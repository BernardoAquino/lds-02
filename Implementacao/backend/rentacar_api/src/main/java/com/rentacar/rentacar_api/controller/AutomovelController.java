package com.rentacar.rentacar_api.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.rentacar.rentacar_api.form.automovel.AutomovelFormAlugar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rentacar.rentacar_api.dto.AutomovelDto;
import com.rentacar.rentacar_api.form.automovel.FormCriarAutomovel;
import com.rentacar.rentacar_api.form.automovel.AutomovelFormAtualizacao;
import com.rentacar.rentacar_api.model.Agente;
import com.rentacar.rentacar_api.model.Automovel;
import com.rentacar.rentacar_api.model.Usuario;
import com.rentacar.rentacar_api.repository.AgenteRepository;
import com.rentacar.rentacar_api.repository.AutomovelRepository;
import com.rentacar.rentacar_api.repository.UsuarioRepository;

@Controller
@RequestMapping("/automovel")
public class AutomovelController {

	@Autowired
	private AgenteRepository agenteRepository;

	@Autowired
	private AutomovelRepository automovelRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/all")
	@ResponseBody
	public List<AutomovelDto> getAll(){
		List<Automovel> automoveis = this.automovelRepository.findAll();
		List<AutomovelDto> automoveisDto = automoveis.stream().map(i -> new AutomovelDto(i)).toList();
		
		return automoveisDto;
	}

	@GetMapping("/disponiveis")
	@ResponseBody
	public ResponseEntity getAutomoveisDisponiveis(@RequestHeader(HttpHeaders.AUTHORIZATION) String hash) {
		Optional<Usuario> proprietarioResult = this.usuarioRepository.findByHash(hash);

		if (proprietarioResult.isPresent()) {
			List<Automovel> automoveisDisponiveis = this.automovelRepository.findByIsAlugadoAndProprietarioNot(false, proprietarioResult.get());

			return ResponseEntity.ok(automoveisDisponiveis);
		}

		return ResponseEntity.ok(List.of());
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getAutomovelById(@PathVariable("id") Long id){
		Optional<Automovel> automovel = this.automovelRepository.findById(id);
		if(automovel.isPresent()) {
			return new ResponseEntity(new AutomovelDto(automovel.get()), HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/novo")
	@ResponseBody
	@Transactional
	public ResponseEntity criarAutomovel(@RequestBody FormCriarAutomovel form, @RequestHeader(HttpHeaders.AUTHORIZATION) String hash) {
		Optional<Usuario> proprietarioResult = this.usuarioRepository.findByHash(hash);

		if (proprietarioResult.isPresent()) {
			Usuario proprietario = proprietarioResult.get();

			if (proprietario.getClass().equals(Agente.class)) {
				Agente analista = (Agente) proprietario;

				Automovel automovel = this.automovelRepository.save(new Automovel(form, proprietario, analista));
	
				return ResponseEntity.ok(new AutomovelDto(automovel));
			} else {
				Optional<Agente> analistaResult = this.agenteRepository.findById(form.getAnalistaId());

				if (analistaResult.isPresent()) {
					Agente analista = analistaResult.get();

					Automovel automovel = this.automovelRepository.save(new Automovel(form, proprietario, analista));

					return ResponseEntity.ok(new AutomovelDto(automovel));
				} else {
					return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Analista não encontrado");
				}
			}
		}
		
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/remover/{id}")
	@Transactional
	public ResponseEntity removerAutomovelById(@PathVariable("id") Long id) {
		try {			
			this.automovelRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity atualizarAutomovelById(@PathVariable("id") Long id, @RequestBody @Valid AutomovelFormAtualizacao form) {
		Automovel automovel = form.atualizar(id, this.automovelRepository);
		if(!automovel.equals(null)) {
			return ResponseEntity.ok(new AutomovelDto(automovel));
		}
		return ResponseEntity.badRequest().build();
		
	}

	public ResponseEntity ResponseEntity (Long idAutomovel, @Valid AutomovelFormAlugar form) {
		Automovel automovel = form.alugar(idAutomovel, this.automovelRepository);
		if(!automovel.equals(null)) {
			return ResponseEntity.ok(new AutomovelDto(automovel));
		}

		return ResponseEntity.badRequest().build();
	}
	
}
