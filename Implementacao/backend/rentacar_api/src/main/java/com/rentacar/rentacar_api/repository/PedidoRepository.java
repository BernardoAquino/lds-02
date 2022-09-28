package com.rentacar.rentacar_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.rentacar_api.model.Contratante;
import com.rentacar.rentacar_api.model.Pedido;
import com.rentacar.rentacar_api.model.Usuario;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
  List<Pedido> findByAnalistaAndAvaliado(Usuario analista, Boolean avaliado);
  List<Pedido> findByContratanteAndAvaliado(Contratante contratante, Boolean avaliado);
}
