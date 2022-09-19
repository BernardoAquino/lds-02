package labDev.AluguelCarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import labDev.AluguelCarros.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
