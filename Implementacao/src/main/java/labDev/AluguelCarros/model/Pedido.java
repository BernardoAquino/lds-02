package labDev.AluguelCarros.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import labDev.AluguelCarros.form.pedido.PedidoForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private boolean parecerDoAgente;
	private LocalDate dataCriacao = LocalDate.now();
	private LocalDate dataModificacao = LocalDate.now();
	private Long idAutomovel;
	private Long idContratante;

	public Pedido(PedidoForm form) {
		this.idAutomovel = form.getIdAutomovel();
		this.parecerDoAgente = false;
		this.dataCriacao = LocalDate.now();
		this.dataModificacao = LocalDate.now();
		this.idContratante = form.getIdContratante();
	}

}
