package labDev.AluguelCarros.dto;

import labDev.AluguelCarros.model.Agente;
import labDev.AluguelCarros.model.Contratante;
import labDev.AluguelCarros.model.TipoAgente;

import java.time.LocalDate;
import java.util.ArrayList;

public class ContratanteDto extends UsuarioDto{


    private String endereco;
    private String profissao;

    private ArrayList<String> empregadoras;
    private String[] rendimentosAuferidos = new String[3];

    private LocalDate dataCriacao = LocalDate.now();
    private LocalDate dataModificacao = LocalDate.now();

    public ContratanteDto(Contratante contratante) {
        super(contratante.getNome(), contratante.getNome(), contratante.getDataCriacao(), contratante.getDataModificacao());



    }

}
