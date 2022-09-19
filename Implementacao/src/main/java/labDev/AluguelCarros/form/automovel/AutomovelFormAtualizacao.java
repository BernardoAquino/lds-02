package labDev.AluguelCarros.form.automovel;

import java.time.LocalDate;
import java.util.Optional;

import labDev.AluguelCarros.model.Automovel;
import labDev.AluguelCarros.repository.AutomovelRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomovelFormAtualizacao {
	
	public String ano;
	public String marca;
	public String modelo;
	public String placa;
	public String contratoCredito;
	public String proprietario;
	public boolean isEmprestado;

	public Automovel atualizar(Long id, AutomovelRepository automovelRepo) {
		Optional<Automovel> automovelOptional= automovelRepo.findById(id);
		if(automovelOptional.isPresent()) {
			Automovel automovel = automovelOptional.get();
			automovel.setAno(this.ano);
			automovel.setMarca(this.marca);
			automovel.setModelo(this.modelo);
			automovel.setPlaca(this.placa);
			automovel.setContratoCredito(this.contratoCredito);
			automovel.setProprietario(this.proprietario);
			automovel.setAlugado(this.isEmprestado);
			automovel.setDataModificacao(LocalDate.now());
			return automovel;
		}
		return null;
	}
	
	
}
