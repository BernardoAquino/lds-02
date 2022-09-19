package labDev.AluguelCarros.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import labDev.AluguelCarros.form.contratante.ContratanteForm;
import labDev.AluguelCarros.form.usuario.UsuarioForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="contratante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contratante extends Usuario{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String cpf;
	private String rg;
	private String endereco;
	private String profissao;
	
	private ArrayList<String> empregadoras;
	
	private String[] rendimentosAuferidos = new String[3];
	
	private LocalDate dataCriacao = LocalDate.now();
	private LocalDate dataModificacao = LocalDate.now();


	public Contratante(ContratanteForm form) {
		super(new UsuarioForm(form.getLogin(),form.getSenha(), form.getNome()));
		this.cpf = form.getCpf();
		this.rg = form.getRg();
		this.endereco = form.getEndereco();
		this.profissao = form.getProfissao();
		this.empregadoras = form.getEmpregadoras();
		this.rendimentosAuferidos = form.getRendimentosAuferidos();
		this.dataCriacao = LocalDate.now();
		this.dataModificacao = LocalDate.now();
	}
}
