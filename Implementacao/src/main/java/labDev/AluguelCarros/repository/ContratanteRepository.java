package labDev.AluguelCarros.repository;

import labDev.AluguelCarros.model.Contratante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratanteRepository extends JpaRepository<Contratante, Long> {
}
