package com.rentacar.rentacar_api.dto;

import com.rentacar.rentacar_api.model.Agente;
import com.rentacar.rentacar_api.model.TipoAgente;

import java.time.LocalDate;

public class AgenteDto extends UsuarioDto {

    private String login;
    private String nome;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public AgenteDto(Agente agente) {
        super(agente.getLogin(), agente.getNome(), agente.getDataCriacao(), agente.getDataModificacao());
        TipoAgente tipoAgente;
    }
}
