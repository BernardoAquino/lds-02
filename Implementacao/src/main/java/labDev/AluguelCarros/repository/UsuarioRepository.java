package labDev.AluguelCarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import labDev.AluguelCarros.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
