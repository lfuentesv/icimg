package cl.lfuentes.icimg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.lfuentes.icimg.entityTo.Tramo;

public interface TramoRepository extends JpaRepository<Tramo, String>{

	Optional<Tramo> findById(int parseInt);

    void deleteById(int parseInt);
}
