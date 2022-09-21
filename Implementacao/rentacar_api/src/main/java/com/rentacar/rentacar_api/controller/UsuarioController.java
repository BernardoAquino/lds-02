package com.rentacar.rentacar_api.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rentacar.rentacar_api.dto.UsuarioDto;
import com.rentacar.rentacar_api.form.usuario.UsuarioForm;
import com.rentacar.rentacar_api.form.usuario.UsuarioFormAtualizacao;
import com.rentacar.rentacar_api.model.Usuario;
import com.rentacar.rentacar_api.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	

	@Autowired
	private UsuarioRepository usuarioRepo;

	@GetMapping("/novo")
	@ResponseBody
	public String usuarioForm() {
		return "Ainda nao existe view para esse formulario!!";
	}
	
	@GetMapping("/all")
	@ResponseBody
	public List<UsuarioDto> getAll(){
		List<Usuario> usuarios = usuarioRepo.findAll();
		List<UsuarioDto> usuariosDto = usuarios.stream().map(i -> new UsuarioDto(i)).toList();
		return usuariosDto;
		
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getUsuarioById(@PathVariable("id") Long id){
		Optional<Usuario> usuario = usuarioRepo.findById(id);
		if(usuario.isPresent()) {
			return new ResponseEntity(usuario.get(), HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/novo")
	@ResponseBody
	public UsuarioDto criarUsuario(@RequestBody @Valid UsuarioForm form) {

		Usuario usuario= this.usuarioRepo.save(new Usuario(form));
		
		return new UsuarioDto(usuario);
	}

	@DeleteMapping("/remover/{id}")
	@Transactional
	public ResponseEntity removerUsuarioById(@PathVariable("id") Long id) {
		try {			
			usuarioRepo.deleteById(id);
			return ResponseEntity.ok().build();
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity atualizarUsuarioById(@PathVariable("id") Long id, @RequestBody @Valid UsuarioFormAtualizacao form) {
		Usuario usuario = form.atualizar(id,usuarioRepo);
		if(!usuario.equals(null)) {
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		return ResponseEntity.badRequest().build();
		
	}
	
	
}
