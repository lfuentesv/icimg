package cl.lfuentes.icimg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.lfuentes.icimg.entityTo.Ric;

public interface RicRepository extends JpaRepository<Ric, String>{

	Optional<Ric> findByNumero(String numero);

}
