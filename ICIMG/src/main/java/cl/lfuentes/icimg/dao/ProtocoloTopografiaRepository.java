package cl.lfuentes.icimg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.lfuentes.icimg.entityTo.ProtocoloTopografia;

public interface ProtocoloTopografiaRepository extends JpaRepository<ProtocoloTopografia, String>{

	Optional<ProtocoloTopografia> findByCodigo(String codigo);

}
