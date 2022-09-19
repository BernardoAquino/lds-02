package labDev.AluguelCarros.controller;

import labDev.AluguelCarros.form.agente.AgenteForm;
import labDev.AluguelCarros.dto.AgenteDto;
import labDev.AluguelCarros.form.agente.AgenteFormAtualizacao;
import labDev.AluguelCarros.model.Agente;
import labDev.AluguelCarros.repository.AgenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/agente")
public class AgenteController {
	

	@Autowired
	private AgenteRepository agenteRepo;

	@GetMapping("/novo")
	@ResponseBody
	public String agenteForm() {
		return "Ainda nao existe view para esse formulario!!";
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
		Optional<Agente> agente = agenteRepo.findById(id);
		if(agente.isPresent()) {
			return new ResponseEntity(agente.get(), HttpStatus.CREATED);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/novo")
	@ResponseBody
	public AgenteDto criarAgente(@RequestBody @Valid AgenteForm form) {

		Agente agente= this.agenteRepo.save(new Agente(form));
		
		return new AgenteDto(agente);
	}

	@DeleteMapping("/remover/{id}")
	@Transactional
	public ResponseEntity removerAgenteById(@PathVariable("id") Long id) {
		try {			
			agenteRepo.deleteById(id);
			return ResponseEntity.ok().build();
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/atualizar/{id}")
	@Transactional
	public ResponseEntity atualizarAgenteById(@PathVariable("id") Long id, @RequestBody @Valid AgenteFormAtualizacao form) {
		Agente agente = form.atualizar(id,agenteRepo);
		if(!agente.equals(null)) {
			return ResponseEntity.ok(new AgenteDto(agente));
		}
		return ResponseEntity.badRequest().build();
		
	}
	
	
}
