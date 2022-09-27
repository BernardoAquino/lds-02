package com.rentacar.rentacar_api.repository;

import com.rentacar.rentacar_api.model.Contratante;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratanteRepository extends JpaRepository<Contratante, Long> {
  Optional<Contratante> findByLoginAndSenha(String login, String senha);

  Optional<Contratante> findByHash(String hash);
}
