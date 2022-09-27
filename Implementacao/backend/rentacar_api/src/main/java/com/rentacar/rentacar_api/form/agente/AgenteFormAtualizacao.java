package com.rentacar.rentacar_api.form.agente;

import com.rentacar.rentacar_api.form.usuario.UsuarioFormAtualizacao;
import com.rentacar.rentacar_api.model.Agente;
import com.rentacar.rentacar_api.model.TipoAgente;
import com.rentacar.rentacar_api.repository.AgenteRepository;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Setter
@Getter
public class AgenteFormAtualizacao extends UsuarioFormAtualizacao {

    public TipoAgente tipoAgente;
    public Agente atualizar(String hash, AgenteRepository agenteRepo) {
        Optional<Agente> a = agenteRepo.findByHash(hash);
        if(a.isPresent()) {
            Agente agente= a.get();
            agente.setLogin(this.getLogin());
            agente.setSenha(this.getSenha());
            agente.setNome(this.getNome());
            agente.setTipoAgente(this.getTipoAgente());
            agente.setDataModificacao(LocalDate.now());
            return agente;
        }

        return null;
    }
}
