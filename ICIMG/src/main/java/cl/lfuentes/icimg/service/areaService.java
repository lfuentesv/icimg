package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import cl.lfuentes.icimg.validacion.RecursoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.AreaRepository;
import cl.lfuentes.icimg.entityTo.Area;
import cl.lfuentes.icimg.entityTo.Eje;
import cl.lfuentes.icimg.requestTO.AreaRTO;
import cl.lfuentes.icimg.validacion.areaNoEncontradaException;

@Service
public class areaService {

	@Autowired
	private AreaRepository repo;
	
	@Autowired
	private EjeService ejeServicio;
	
	public Area crear(AreaRTO area) {
		/**Validamos que el área no exista*/
		
		Optional<Area> areaExistente = repo.findByCodigo(area.getCodigo());

		if (areaExistente.isPresent()) throw new RecursoExistenteException("Área",area.getCodigo());
		
		/**Validamos si el Eje enviado Existe*/
		
		Optional<Eje> eje = ejeServicio.buscar(area.getEje());		
	
		Area  areaPO = new Area ( area.getCodigo(), area.getNombre());
		eje.ifPresent(areaPO::setEje);
		Area areaCreada = repo.saveAndFlush(areaPO);
	
		return areaCreada;
	}

	public Area actualizar(String codigo,AreaRTO area) {
		/**Validamos que el área exista*/
		Optional<Area> areaExistente = repo.findByCodigo(area.getCodigo());
		if (!areaExistente.isPresent()) throw new areaNoEncontradaException(codigo);

		/**Validamos si el Eje enviado Existe*/
		Optional<Eje> eje = ejeServicio.buscar(area.getEje());

		Area  areaPO = new Area ( codigo, area.getNombre());
		eje.ifPresent(areaPO::setEje);
		Area areaCreada = repo.saveAndFlush(areaPO);

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
