package com.rentacar.rentacar_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.rentacar_api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
  Optional<Usuario> findByHash(String hash);
}
