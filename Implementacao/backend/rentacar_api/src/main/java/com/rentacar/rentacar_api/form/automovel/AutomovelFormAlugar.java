package com.rentacar.rentacar_api.form.automovel;

import com.rentacar.rentacar_api.model.Automovel;
import com.rentacar.rentacar_api.repository.AutomovelRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class AutomovelFormAlugar {

    @NotEmpty
    @NotNull
    private Long idAutomovel;

    @NotEmpty
    @NotNull
    private Long idContratante;


    public Automovel alugar(Long idAutomovel, AutomovelRepository automovelRepo) {
        Optional<Automovel> a = automovelRepo.findById(idAutomovel);
        if (a.isPresent()){
            Automovel automovel = a.get();
            if (!automovel.getIsAlugado()){
                automovel.setIsAlugado(true);
                return automovel;
            }
        }
        return null;
    }
}
