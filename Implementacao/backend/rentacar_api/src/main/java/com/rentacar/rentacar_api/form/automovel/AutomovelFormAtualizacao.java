package com.rentacar.rentacar_api.form.automovel;

import java.time.LocalDate;
import java.util.Optional;

import com.rentacar.rentacar_api.model.Automovel;
import com.rentacar.rentacar_api.repository.AutomovelRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomovelFormAtualizacao {
	public String ano;
	public String marca;
	public String modelo;
	public String placa;
	public Boolean contratoCredito;
	public Long analistaId;

	public Automovel atualizar(Long id, AutomovelRepository automovelRepo) {
		Optional<Automovel> automovelOptional= automovelRepo.findById(id);
		if(automovelOptional.isPresent()) {
			Automovel automovel = automovelOptional.get();
			automovel.setAno(this.ano);
			automovel.setMarca(this.marca);
			automovel.setModelo(this.modelo);
			automovel.setPlaca(this.placa);
			automovel.setContratoCredito(this.contratoCredito);
			automovel.setDataModificacao(LocalDate.now());
			return automovel;
		}
		return null;
	}
	
	
}
