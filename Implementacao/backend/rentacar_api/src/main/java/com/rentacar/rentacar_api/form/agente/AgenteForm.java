package com.rentacar.rentacar_api.form.agente;

import com.rentacar.rentacar_api.form.usuario.UsuarioForm;
import com.rentacar.rentacar_api.model.TipoAgente;

public class AgenteForm extends UsuarioForm {

    private TipoAgente tipoAgente;


    public AgenteForm(String login, String senha, String nome, TipoAgente tipoAgente) {
        super(login, senha, nome);
        this.tipoAgente = tipoAgente;
    }
}
