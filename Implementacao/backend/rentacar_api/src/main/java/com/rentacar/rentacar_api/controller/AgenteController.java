package com.rentacar.rentacar_api.controller;

import com.rentacar.rentacar_api.form.agente.AgenteForm;
import com.rentacar.rentacar_api.dto.AgenteDto;
import com.rentacar.rentacar_api.form.agente.AgenteFormAtualizacao;
import com.rentacar.rentacar_api.model.Agente;
import com.rentacar.rentacar_api.repository.AgenteRepository;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/agente")
public class AgenteController {
	

	@Autowired
	private AgenteRepository agenteRepo;

	@PostMapping("/entrar")
	@ResponseBody
	public ResponseEntity logarUsuario(@RequestBody @Valid AgenteForm form) {
		Optional<Agente> usuario = this.agenteRepo.findByLoginAndSenha(form.getLogin(), form.getSenha());

		if(usuario.isPresent()) {
			String hash = DigestUtils.sha256Hex(usuario.get().getSenha() + usuario.get().getLogin());

			usuario.get().setHash(hash);

			this.agenteRepo.save(usuario.get());

			return new ResponseEntity(usuario.get(), HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/all")
	@ResponseBody
	public List<AgenteDto> getAll(){
		List<Agente> agentes = agenteRepo.findAll();
		List<AgenteDto> agentesDto = agentes.stream().map(i -> new AgenteDto(i)).toList();
		return agentesDto;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getAgenteById(@PathVariable("id") Long id){
		Optional<Agente> agente = this.agenteRepo.findById(id);
		if(agente.isPresent()) {
			return new ResponseEntity(agente.get(), HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/novo")
	@ResponseBody
	public AgenteDto criarAgente(@RequestBody @Valid AgenteForm form) {

		Agente agente= this.agenteRepo.save(new Agente(form));
		
		return new AgenteDto(agente);
	}

	@DeleteMapping("/remover")
	@Transactional
	public ResponseEntity removerAgenteById(@RequestHeader(HttpHeaders.AUTHORIZATION) String hash) {
		Optional<Agente> agente = agenteRepo.findByHash(hash);

		if (agente.isPresent()) {
			agenteRepo.delete(agente.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();		
	}
	
	@PutMapping("/atualizar")
	@Transactional
	public ResponseEntity atualizarAgenteById(@RequestHeader(HttpHeaders.AUTHORIZATION) String hash, @RequestBody @Valid AgenteFormAtualizacao form) {
		Agente agente = form.atualizar(hash,agenteRepo);
		if(!agente.equals(null)) {
			return ResponseEntity.ok(new AgenteDto(agente));
		}
		return ResponseEntity.badRequest().build();
		
	}
	
	
}
