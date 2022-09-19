package labDev.AluguelCarros.controller;

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

import labDev.AluguelCarros.dto.PedidoDto;
import labDev.AluguelCarros.form.pedido.PedidoForm;
import labDev.AluguelCarros.form.pedido.PedidoFormAtualizacao;
import labDev.AluguelCarros.model.Pedido;
import labDev.AluguelCarros.repository.PedidoRepository;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepo;

	@GetMapping("/novo")
	@ResponseBody
	public String pedidoForm() {
		return "Ainda nao existe view para esse formulario!!";
	}
	
	@GetMapping("/all")
	@ResponseBody
	public List<PedidoDto> getAll(){
		List<Pedido> pedidos = pedidoRepo.findAll();
		List<PedidoDto> pedidosDto = pedidos.stream().map(i -> new PedidoDto(i)).toList();
		
		return pedidosDto;
		
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getPedidoById(@PathVariable("id") Long id){
		Optional<Pedido> pedido = pedidoRepo.findById(id);
		if(pedido.isPresent()) {
			return new ResponseEntity(pedido.get(), HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/novo")
	@ResponseBody
	public PedidoDto criarPedido(@RequestBody @Valid PedidoForm form) {

		Pedido pedido= this.pedidoRepo.save(new Pedido(form));
		
		return new PedidoDto(pedido);
	}

	@DeleteMapping("/remover/{id}")
	@Transactional
	public ResponseEntity removerPedidoById(@PathVariable("id") Long id) {
		try {			
			pedidoRepo.deleteById(id);
			return ResponseEntity.ok().build();
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity atualizarPedidoById(@PathVariable("id") Long id, @RequestBody @Valid PedidoFormAtualizacao form) {
		Pedido pedido = form.atualizar(id,pedidoRepo);
		if(!pedido.equals(null)) {
			return ResponseEntity.ok(new PedidoDto(pedido));
		}
		return ResponseEntity.badRequest().build();
		
	}
	
	@PostMapping("/avaliar/{id}")
	@Transactional
	public ResponseEntity parecerAgente(@PathVariable("id") Long id,boolean parecer) {
		Optional<Pedido> p= this.pedidoRepo.findById(id);
		if(p.isPresent()) {
			Pedido pedido = p.get();
			pedido.setParecerDoAgente(parecer);
			return ResponseEntity.ok(new PedidoDto(pedido));
		}
		
		return ResponseEntity.badRequest().body("Id de pedido invalido!");
	}
	
	
	
}
