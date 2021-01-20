package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.AreaRepository;
import cl.lfuentes.icimg.entityTo.Area;
import cl.lfuentes.icimg.validacion.areaNoEncontradaException;

@Service
public class areaService {

	@Autowired
	private AreaRepository repo;
	
	public Area crear(Area area) {

		Area areaCreada = repo.saveAndFlush(area);
		return areaCreada;
	}

	public List<Area> listar() {

		List<Area> areas = repo.findAll();
		return areas;
	}

	public Optional<Area> buscar(String codigo) {
		
		return Optional.ofNullable(repo.findByCodigo(codigo).orElseThrow(() -> new areaNoEncontradaException(codigo)));
	}

}
