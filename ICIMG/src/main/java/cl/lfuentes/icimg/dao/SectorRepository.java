package cl.lfuentes.icimg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.lfuentes.icimg.entityTo.Sector;

public interface SectorRepository extends JpaRepository<Sector, String>{

	Optional<Sector> findByCodigo(String codigo);

}
