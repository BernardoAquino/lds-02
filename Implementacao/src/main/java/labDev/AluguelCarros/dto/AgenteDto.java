package labDev.AluguelCarros.dto;

import labDev.AluguelCarros.model.Agente;
import labDev.AluguelCarros.model.TipoAgente;

import java.time.LocalDate;

public class AgenteDto extends UsuarioDto{

    private String login;
    private String nome;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public AgenteDto(Agente agente) {
        super(agente.getNome(), agente.getNome(), agente.getDataCriacao(), agente.getDataModificacao());
        TipoAgente tipoAgente;

    }
}
