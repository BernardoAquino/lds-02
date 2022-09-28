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
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/automovel")
public class AutomovelController {

	@Autowired
	private AgenteRepository agenteRepository;

	@Autowired
	private AutomovelRepository automovelRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/meus")
	@ResponseBody
	public ResponseEntity getMeusAutomoveis(@RequestHeader(HttpHeaders.AUTHORIZATION) String hash) {
		Optional<Usuario> proprietarioResult = this.usuarioRepository.findByHash(hash);

		if (proprietarioResult.isPresent()) {
			List<Automovel> meusAutomoveis = this.automovelRepository.findByProprietario(proprietarioResult.get());

			return ResponseEntity.ok(meusAutomoveis);
		} else {
			return ResponseEntity.badRequest().build();
		}
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
			return new ResponseEntity(automovel.get(), HttpStatus.OK);
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
	
				return ResponseEntity.status(HttpStatus.CREATED).body(new AutomovelDto(automovel));
			} else {
				Optional<Agente> analistaResult = this.agenteRepository.findById(form.getAnalistaId());

				if (analistaResult.isPresent()) {
					Agente analista = analistaResult.get();

					Automovel automovel = this.automovelRepository.save(new Automovel(form, proprietario, analista));

					return ResponseEntity.status(HttpStatus.CREATED).body(new AutomovelDto(automovel));
				} else {
					return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Analista não encontrado");
				}
			}
		}
		
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity removerAutomovelById(@PathVariable("id") Long id) {
		try {			
			this.automovelRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity atualizarAutomovelById(@PathVariable("id") Long id, @RequestBody @Valid AutomovelFormAtualizacao form) {
		Automovel automovel = form.atualizar(id,this.automovelRepository);
		if(!automovel.equals(null)) {
			return ResponseEntity.ok(new AutomovelDto(automovel));
		}
		return ResponseEntity.badRequest().build();
		
	}

	public ResponseEntity ResponseEntity (Long idAutomovel, @Valid AutomovelFormAlugar form) {
		Automovel automovel = form.alugar(idAutomovel,this.automovelRepository);
		if(!automovel.equals(null)) {
			return ResponseEntity.ok(new AutomovelDto(automovel));
		}

		return ResponseEntity.badRequest().build();
	}
	
}
