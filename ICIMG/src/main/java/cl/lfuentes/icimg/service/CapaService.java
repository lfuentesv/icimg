package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.CapaRepository;
import cl.lfuentes.icimg.entityTo.Area;
import cl.lfuentes.icimg.entityTo.Capa;
import cl.lfuentes.icimg.entityTo.Sector;
import cl.lfuentes.icimg.requestTO.CapaRTO;
import cl.lfuentes.icimg.validacion.capaNoEncontradaException;

@Service
public class CapaService {

	@Autowired
	private CapaRepository repo;
	
	@Autowired
	private areaService areaServicio;
	@Autowired
	private SectorService sectorServicio;
	
	public Capa crear(CapaRTO capa) {
		
		Optional<Area> area = areaServicio.buscar(capa.getCodArea());
		Optional<Sector> sector = sectorServicio.buscar(capa.getCodSector());	
	
		Capa  capaPO = new Capa ( capa.getCodigo(), capa.getNombre(),capa.getElevacionObjetivo(), capa.getEspesorObjetivo(), capa.getTolerancia());
		area.ifPresent(capaPO::setCodArea);
		sector.ifPresent(capaPO::setCodSector);
		Capa capaCreada = repo.saveAndFlush(capaPO);
	
		return capaCreada;
	}

	public List<Capa> listar() {

		List<Capa> capas = repo.findAll();
		return capas;
	}

	public Optional<Capa> buscar(String codigo) {
		
		return Optional.ofNullable(repo.findByCodigo(codigo).orElseThrow(() -> new capaNoEncontradaException(codigo)));
	}

}
