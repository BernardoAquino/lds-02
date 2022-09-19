package labDev.AluguelCarros.form.contratante;

import labDev.AluguelCarros.form.usuario.UsuarioForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ContratanteForm extends UsuarioForm {

    public ContratanteForm(String login, String senha, String nome, String cpf) {
        super(login, senha, nome);
        this.cpf = cpf;
    }

    private String cpf;
    private String rg;
    private String endereco;
    private String profissao;

    private ArrayList<String> empregadoras;

    private String[] rendimentosAuferidos = new String[3];

}
