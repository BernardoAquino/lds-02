package labDev.AluguelCarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import labDev.AluguelCarros.model.Automovel;

public interface AutomovelRepository extends JpaRepository<Automovel, Long>{

}
