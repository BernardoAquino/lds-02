package com.rentacar.rentacar_api.form.agente;

import com.rentacar.rentacar_api.form.usuario.UsuarioForm;
import com.rentacar.rentacar_api.model.TipoAgente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgenteForm extends UsuarioForm {

    private TipoAgente tipoAgente;
    private String cnpj;


    public AgenteForm(String login, String senha, String nome, TipoAgente tipoAgente, String cnpj) {
        super(login, senha, nome);
        this.tipoAgente = tipoAgente;
        this.cnpj = cnpj;
    }
}
