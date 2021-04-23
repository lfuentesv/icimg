package cl.lfuentes.icimg.dao;

import cl.lfuentes.icimg.entityTo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	Optional<Usuario> findByRut(String rut);
	Optional<Usuario> findByRutAndPassword(String rut, String password);
	void deleteByRut(String rut);
}
