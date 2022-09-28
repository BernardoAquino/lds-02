package com.rentacar.rentacar_api.form.pedido;

import java.time.LocalDate;
import java.util.Optional;

import com.rentacar.rentacar_api.model.Pedido;
import com.rentacar.rentacar_api.repository.PedidoRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoFormAtualizacao {

	private boolean parecerDoAgente;
	private boolean contratoCredito;

	
	public Pedido atualizar(Long id, PedidoRepository pedidoRepo) {
		Optional<Pedido> p = pedidoRepo.findById(id);
		if(p.isPresent()) {
			Pedido pedido = p.get();

			if (this.contratoCredito) {
				pedido.getAutomovel().setContratoCredito(this.contratoCredito);
			}
			
			pedido.setParecerDoAgente(this.parecerDoAgente);
			pedido.setDataModificacao(LocalDate.now());
			return pedido;
		}
		
		return null;
	}

}
