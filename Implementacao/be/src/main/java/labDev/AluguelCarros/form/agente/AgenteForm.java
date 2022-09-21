package labDev.AluguelCarros.form.agente;

import labDev.AluguelCarros.form.usuario.UsuarioForm;
import labDev.AluguelCarros.model.TipoAgente;

public class AgenteForm extends UsuarioForm {

    private TipoAgente tipoAgente;


    public AgenteForm(String login, String senha, String nome, TipoAgente tipoAgente) {
        super(login, senha, nome);
        this.tipoAgente = tipoAgente;
    }
}
