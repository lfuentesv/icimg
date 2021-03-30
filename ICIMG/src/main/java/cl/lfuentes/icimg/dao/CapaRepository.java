package cl.lfuentes.icimg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.lfuentes.icimg.entityTo.Capa;

public interface CapaRepository extends JpaRepository<Capa, String>{

	Optional<Capa> findByCodigo(String codigo);

    void deleteByCodigo(String codigo);
}
