package labDev.AluguelCarros.form.usuario;

import java.time.LocalDate;
import java.util.Optional;

import labDev.AluguelCarros.model.Usuario;
import labDev.AluguelCarros.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioFormAtualizacao {

	private String login;
	private String senha;
	private String nome;
	
	
	public Usuario atualizar(Long id, UsuarioRepository usuarioRepo) {
		Optional<Usuario> u = usuarioRepo.findById(id);
		if(u.isPresent()) {
			Usuario usuario= u.get();
			usuario.setLogin(this.login);
			usuario.setSenha(this.senha);
			usuario.setNome(this.nome);
			usuario.setDataModificacao(LocalDate.now());
			return usuario;
		}
		
		return null;
	}

}
