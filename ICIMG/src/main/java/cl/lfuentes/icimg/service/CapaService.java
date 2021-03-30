package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import cl.lfuentes.icimg.validacion.DeleteException;
import cl.lfuentes.icimg.validacion.RecursoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.CapaRepository;
import cl.lfuentes.icimg.entityTo.Area;
import cl.lfuentes.icimg.entityTo.Capa;
import cl.lfuentes.icimg.entityTo.Sector;
import cl.lfuentes.icimg.requestTO.CapaRTO;
import cl.lfuentes.icimg.validacion.capaNoEncontradaException;

import javax.transaction.Transactional;

@Service
public class CapaService {

	@Autowired
	private CapaRepository repo;
	
	@Autowired
	private areaService areaServicio;
	@Autowired
	private SectorService sectorServicio;
	
	public Capa crear(CapaRTO capa) {
		/**Validamos que no exista*/
		Optional<Capa> existente = repo.findByCodigo(capa.getCodigo());
		if (existente.isPresent()) throw new RecursoExistenteException("Capa",capa.getCodigo());

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

    public Capa actualizar(String codigo, CapaRTO capa) {
		/**Validamos que exista*/
		Optional<Capa> existente = repo.findByCodigo(capa.getCodigo());
		if (!existente.isPresent()) throw new capaNoEncontradaException(codigo);

		Optional<Area> area = areaServicio.buscar(capa.getCodArea());
		Optional<Sector> sector = sectorServicio.buscar(capa.getCodSector());

		Capa  po = new Capa ( capa.getCodigo(), capa.getNombre(),capa.getElevacionObjetivo(), capa.getEspesorObjetivo(), capa.getTolerancia());
		area.ifPresent(po::setCodArea);
		sector.ifPresent(po::setCodSector);

		return repo.saveAndFlush(po);

    }
	@Transactional
	public void eliminar(String codigo) {
		Optional<Capa> existente = repo.findByCodigo(codigo);
		if (!existente.isPresent()) throw new capaNoEncontradaException(codigo);
		try {
			repo.deleteByCodigo(codigo);
			repo.flush();
		}catch (DataIntegrityViolationException e){
			throw new DeleteException("Error eliminando capa, revise que no este asociada con otro recurso");
		}
	}
}
