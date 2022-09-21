package com.rentacar.rentacar_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.rentacar_api.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
