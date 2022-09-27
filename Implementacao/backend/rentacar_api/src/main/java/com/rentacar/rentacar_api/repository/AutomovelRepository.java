package com.rentacar.rentacar_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.rentacar_api.model.Automovel;

public interface AutomovelRepository extends JpaRepository<Automovel, Long>{
  List<Automovel> findByIsAlugado(boolean isAlugado);
}
