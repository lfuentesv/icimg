package cl.lfuentes.icimg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.lfuentes.icimg.entityTo.Area;

public interface AreaRepository extends JpaRepository<Area, String>{

	Optional<Area> findByCodigo(String codigo);

}
