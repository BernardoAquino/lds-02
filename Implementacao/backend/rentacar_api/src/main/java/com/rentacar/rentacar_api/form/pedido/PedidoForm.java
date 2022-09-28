package com.rentacar.rentacar_api.form.pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoForm {
	private String automovelId;

	public PedidoForm(String automovelId) {
		this.automovelId = automovelId;
	}
}
