package labDev.AluguelCarros.form.agente;

import labDev.AluguelCarros.form.usuario.UsuarioFormAtualizacao;
import labDev.AluguelCarros.model.Agente;
import labDev.AluguelCarros.model.TipoAgente;
import labDev.AluguelCarros.model.Usuario;
import labDev.AluguelCarros.repository.AgenteRepository;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Setter
@Getter
public class AgenteFormAtualizacao extends UsuarioFormAtualizacao {

    public TipoAgente tipoAgente;
    public Agente atualizar(Long id, AgenteRepository agenteRepo) {
        Optional<Agente> a = agenteRepo.findById(id);
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
