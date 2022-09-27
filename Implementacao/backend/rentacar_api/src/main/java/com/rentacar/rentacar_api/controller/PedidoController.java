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
import com.rentacar.rentacar_api.model.Automovel;
import com.rentacar.rentacar_api.model.Contratante;
import com.rentacar.rentacar_api.model.Pedido;
import com.rentacar.rentacar_api.repository.AutomovelRepository;
import com.rentacar.rentacar_api.repository.ContratanteRepository;
import com.rentacar.rentacar_api.repository.PedidoRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private AutomovelRepository automovelRepository;

	@Autowired
	private ContratanteRepository contratanteRepository;
	
	@GetMapping("/pendentes")
	@ResponseBody
	public List<PedidoDto> getAll(){
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<PedidoDto> pedidosDto = pedidos.stream().map(i -> new PedidoDto(i)).toList();
		
		return pedidosDto;
		
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getPedidoById(@PathVariable("id") Long id){
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if(pedido.isPresent()) {
			return new ResponseEntity(pedido.get(), HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/novo")
	@ResponseBody
	public ResponseEntity criarPedido(@RequestBody @Valid PedidoForm form, @RequestHeader(HttpHeaders.AUTHORIZATION) String hash) {
		Optional<Contratante> contratante = this.contratanteRepository.findByHash(hash);

		if (contratante.isPresent()) {
			Optional<Automovel> automovel =this.automovelRepository.findById(form.getAutomovelId());

			if (automovel.isPresent()) {
				Pedido pedido= this.pedidoRepository.save(new Pedido(automovel.get(), contratante.get()));

				PedidoDto pedidoCriado = new PedidoDto(pedido);
	
				return ResponseEntity.ok(pedidoCriado);
			} else {
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Automovel não encontrado");
			}
		} else {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Contratante não encontrado");
		}	
	}

	@DeleteMapping("/remover/{id}")
	@Transactional
	public ResponseEntity removerPedidoById(@PathVariable("id") Long id) {
		try {			
			pedidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity atualizarPedidoById(@PathVariable("id") Long id, @RequestBody @Valid PedidoFormAtualizacao form) {
		Pedido pedido = form.atualizar(id,pedidoRepository);
		if(!pedido.equals(null)) {
			return ResponseEntity.ok(new PedidoDto(pedido));
		}
		return ResponseEntity.badRequest().build();
		
	}
	
	@PostMapping("/avaliar/{id}")
	@Transactional
	public ResponseEntity parecerAgente(@PathVariable("id") Long id,boolean parecer) {
		Optional<Pedido> p= this.pedidoRepository.findById(id);
		if(p.isPresent()) {
			Pedido pedido = p.get();
			pedido.setParecerDoAgente(parecer);
			return ResponseEntity.ok(new PedidoDto(pedido));
		}
		
		return ResponseEntity.badRequest().body("Id de pedido invalido!");
	}
	
	
	
}
