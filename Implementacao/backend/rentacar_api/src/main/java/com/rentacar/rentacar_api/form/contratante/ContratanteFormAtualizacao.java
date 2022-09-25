package com.rentacar.rentacar_api.form.contratante;

import com.rentacar.rentacar_api.form.usuario.UsuarioFormAtualizacao;
import com.rentacar.rentacar_api.model.Contratante;
import com.rentacar.rentacar_api.model.Usuario;
import com.rentacar.rentacar_api.repository.ContratanteRepository;
import com.rentacar.rentacar_api.repository.UsuarioRepository;
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
