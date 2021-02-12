package cl.lfuentes.icimg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.lfuentes.icimg.entityTo.ProtocoloRecepcion;

public interface ProtocoloRecepcionRepository extends JpaRepository<ProtocoloRecepcion, String>{

	Optional<ProtocoloRecepcion> findByCodigo(String codigo);

}
