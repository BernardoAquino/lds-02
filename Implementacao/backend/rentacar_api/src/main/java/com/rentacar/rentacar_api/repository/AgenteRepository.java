package com.rentacar.rentacar_api.repository;

import com.rentacar.rentacar_api.model.Agente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenteRepository extends JpaRepository<Agente, Long> {
  Optional<Agente> findByLoginAndSenha(String login, String senha);
}
