package com.rentacar.rentacar_api.repository;

import com.rentacar.rentacar_api.model.Contratante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratanteRepository extends JpaRepository<Contratante, Long> {
}
