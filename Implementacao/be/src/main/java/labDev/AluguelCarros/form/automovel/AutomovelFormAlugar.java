package labDev.AluguelCarros.form.automovel;

import labDev.AluguelCarros.model.Automovel;
import labDev.AluguelCarros.repository.AutomovelRepository;

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
            if (!automovel.isAlugado()){
                automovel.setAlugado(true);
                return automovel;
            }
        }
        return null;
    }
}
