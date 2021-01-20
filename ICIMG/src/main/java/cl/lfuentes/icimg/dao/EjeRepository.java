package cl.lfuentes.icimg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.lfuentes.icimg.entityTo.Eje;

public interface EjeRepository extends JpaRepository<Eje, String>{

	Optional<Eje> findByCodigo(String codigo);

}
