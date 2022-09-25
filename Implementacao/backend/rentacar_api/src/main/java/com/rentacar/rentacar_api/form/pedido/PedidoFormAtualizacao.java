package com.rentacar.rentacar_api.form.pedido;

import java.time.LocalDate;
import java.util.Optional;

import com.rentacar.rentacar_api.model.Automovel;
import com.rentacar.rentacar_api.model.Pedido;
import com.rentacar.rentacar_api.repository.PedidoRepository;

public class PedidoFormAtualizacao {

	private boolean parecerDoAgente;
	private Long idAutomovel;

	
	public Pedido atualizar(Long id, PedidoRepository pedidoRepo) {
		Optional<Pedido> p = pedidoRepo.findById(id);
		if(p.isPresent()) {
			Pedido pedido = p.get();
			pedido.setIdAutomovel(this.idAutomovel);
			pedido.setParecerDoAgente(this.parecerDoAgente);
			pedido.setDataModificacao(LocalDate.now());
			return pedido;
		}
		
		return null;
	}

}
