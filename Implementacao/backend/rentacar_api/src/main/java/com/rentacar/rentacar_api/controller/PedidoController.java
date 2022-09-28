package com.rentacar.rentacar_api.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

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

import com.rentacar.rentacar_api.dto.PedidoDto;
import com.rentacar.rentacar_api.form.pedido.PedidoForm;
import com.rentacar.rentacar_api.form.pedido.PedidoFormAtualizacao;
import com.rentacar.rentacar_api.model.Agente;
import com.rentacar.rentacar_api.model.Automovel;
import com.rentacar.rentacar_api.model.Contratante;
import com.rentacar.rentacar_api.model.Pedido;
import com.rentacar.rentacar_api.model.Usuario;
import com.rentacar.rentacar_api.repository.UsuarioRepository;
import com.rentacar.rentacar_api.repository.AutomovelRepository;
import com.rentacar.rentacar_api.repository.ContratanteRepository;
import com.rentacar.rentacar_api.repository.PedidoRepository;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AutomovelRepository automovelRepository;

	@Autowired
	private ContratanteRepository contratanteRepository;
	
	@GetMapping("/pendentes")
	@ResponseBody
	public ResponseEntity getAll(@RequestHeader(HttpHeaders.AUTHORIZATION) String hash) {
		Optional<Usuario> usuarioResult = this.usuarioRepository.findByHash(hash);

		if (usuarioResult.isPresent()) {
			Usuario usuario = usuarioResult.get();
			boolean isAgente = usuario.getClass().equals(Agente.class);
			List<Pedido> pedidos;

			if (isAgente) {
				pedidos = this.pedidoRepository.findByAnalistaAndAvaliado(usuario, false);
			} else {
				Contratante contratante = this.contratanteRepository.findByHash(hash).get();

				pedidos = this.pedidoRepository.findByContratanteAndAvaliado(contratante, false);
			}

			return ResponseEntity.status(HttpStatus.OK).body(pedidos);
		} else {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Agente não encontrado");
		}
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getPedidoById(@PathVariable("id") Long id){
		Optional<Pedido> pedido = this.pedidoRepository.findById(id);
		if(pedido.isPresent()) {
			return new ResponseEntity(pedido.get(), HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/criar/{id}")
	@ResponseBody
	public ResponseEntity criarPedido(@PathVariable("id") Long automovelId, @RequestHeader(HttpHeaders.AUTHORIZATION) String hash) {
		Optional<Contratante> contratante = this.contratanteRepository.findByHash(hash);

		if (contratante.isPresent()) {
			Optional<Automovel> automovel =this.automovelRepository.findById(automovelId);

			if (automovel.isPresent()) {
				Pedido pedido = this.pedidoRepository.save(new Pedido(automovel.get(), contratante.get()));
	
				return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
			} else {
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Automovel não encontrado");
			}
		} else {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Contratante não encontrado");
		}	
	}

	@DeleteMapping("/cancelar/{id}")
	@Transactional
	public ResponseEntity removerPedidoById(@PathVariable("id") Long id) {
		Optional<Pedido> pedidoResult = this.pedidoRepository.findById(id);

		if (pedidoResult.isPresent()) {
			pedidoResult.get().getAutomovel().setContratoCredito(false);
			pedidoResult.get().getAutomovel().setIsAlugado(false);

			this.automovelRepository.save(pedidoResult.get().getAutomovel());
			this.pedidoRepository.delete(pedidoResult.get());

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.badRequest().build();		
	}
	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity atualizarPedidoById(@PathVariable("id") Long id, @RequestBody @Valid PedidoFormAtualizacao form) {
		Pedido pedido = form.atualizar(id, this.pedidoRepository);
		if(!pedido.equals(null)) {
			return ResponseEntity.ok(pedido);
		}
		return ResponseEntity.badRequest().build();
		
	}
	
	@PutMapping("/avaliar/{id}")
	@Transactional
	public ResponseEntity parecerAgente(@PathVariable("id") Long id, @RequestBody @Valid PedidoFormAtualizacao form) {
		Optional<Pedido> p= this.pedidoRepository.findById(id);
		if(p.isPresent()) {
			Pedido pedido = p.get();
			pedido.setParecerDoAgente(form.isParecerDoAgente());
			pedido.setAvaliado(true);
			return ResponseEntity.ok(new PedidoDto(pedido));
		}
		
		return ResponseEntity.badRequest().body("Id de pedido invalido!");
	}	
}
