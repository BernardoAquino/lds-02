package com.rentacar.rentacar_api.form.pedido;


public class PedidoForm {


	private Long idAutomovel;
	private Long idContratante;

	
	public Long getIdContratante() {
		return idContratante;
	}

	public void setIdContratante(Long idContratante) {
		this.idContratante = idContratante;
	}


	public Long getIdAutomovel() {
		return this.idAutomovel;
	}

	public void setAutomovel(Long idAutomovel) {
		this.idAutomovel = idAutomovel;
	}

	public PedidoForm(Long idAutomovel, Long idContratante) {
		this.idAutomovel = idAutomovel;
		this.idContratante = idContratante;
	}

	public void setIdAutomovel(Long idAutomovel) {
		this.idAutomovel = idAutomovel;
	}
	
	
}
