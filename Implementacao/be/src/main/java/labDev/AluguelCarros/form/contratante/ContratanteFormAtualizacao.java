package labDev.AluguelCarros.form.contratante;

import labDev.AluguelCarros.form.usuario.UsuarioFormAtualizacao;
import labDev.AluguelCarros.model.Contratante;
import labDev.AluguelCarros.model.Usuario;
import labDev.AluguelCarros.repository.ContratanteRepository;
import labDev.AluguelCarros.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class ContratanteFormAtualizacao extends UsuarioFormAtualizacao {

	
	
	public Contratante atualizar(Long id, ContratanteRepository contratanteRepo) {
		Optional<Contratante> c = contratanteRepo.findById(id);
		if(c.isPresent()) {
			Contratante contratante= c.get();
			contratante.setLogin(this.getLogin());
			contratante.setSenha(this.getSenha());
			contratante.setNome(this.getNome());
			contratante.setDataModificacao(LocalDate.now());
			return contratante;
		}
		
		return null;
	}

}
