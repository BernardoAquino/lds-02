package labDev.AluguelCarros.repository;

import labDev.AluguelCarros.model.Agente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenteRepository extends JpaRepository<Agente, Long> {
}
