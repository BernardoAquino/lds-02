package com.rentacar.rentacar_api.controller;

import com.rentacar.rentacar_api.dto.ContratanteDto;
import com.rentacar.rentacar_api.form.contratante.ContratanteForm;
import com.rentacar.rentacar_api.form.contratante.ContratanteFormAtualizacao;
import com.rentacar.rentacar_api.model.Contratante;
import com.rentacar.rentacar_api.repository.ContratanteRepository;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/contratante")
public class ContratanteController {
	@Autowired
	private ContratanteRepository contratanteRepo;

	@GetMapping("/novo")
	@ResponseBody
	public String contratanteForm() {
		return "Ainda nao existe view para esse formulario!!";
	}
	
	@GetMapping("/all")
	@ResponseBody
	public List<ContratanteDto> getAll(){
		List<Contratante> contratantes = contratanteRepo.findAll();
		List<ContratanteDto> contratantesDto = contratantes.stream().map(i -> new ContratanteDto(i)).toList();
		return contratantesDto;
		
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getContratanteById(@PathVariable("id") Long id){
		Optional<Contratante> contratante = contratanteRepo.findById(id);
		if(contratante.isPresent()) {
			return new ResponseEntity<Contratante>(contratante.get(), HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/novo")
	@ResponseBody
	public ResponseEntity<Contratante> criarContratante(@RequestBody @Valid ContratanteForm form) {
		Contratante contratante= this.contratanteRepo.save(new Contratante(form));

		return ResponseEntity.status(HttpStatus.CREATED).body(contratante);
	}

	@DeleteMapping("/remover/{id}")
	@Transactional
	public ResponseEntity removerContratanteById(@PathVariable("id") Long id) {
		try {			
			contratanteRepo.deleteById(id);
			return ResponseEntity.ok().build();
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity<ContratanteDto> atualizarContratanteById(@PathVariable("id") Long id, @RequestBody @Valid ContratanteFormAtualizacao form) {
		Contratante contratante = form.atualizar(id,contratanteRepo);
		if(contratante != null) {
			return ResponseEntity.ok(new ContratanteDto(contratante));
		}
		return ResponseEntity.badRequest().build();
		
	}
	
	
}
