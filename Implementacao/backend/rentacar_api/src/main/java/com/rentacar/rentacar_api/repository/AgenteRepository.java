package com.rentacar.rentacar_api.repository;

import com.rentacar.rentacar_api.model.Agente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenteRepository extends JpaRepository<Agente, Long> {
}
