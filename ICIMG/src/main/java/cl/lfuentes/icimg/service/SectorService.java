package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.SectorRepository;
import cl.lfuentes.icimg.entityTo.Sector;
import cl.lfuentes.icimg.validacion.sectorNoEncontradoException;

@Service
public class SectorService {

	@Autowired
	private SectorRepository repo;
	

	public Sector crear(Sector sector) {

		Sector sectorCreado = repo.saveAndFlush(sector);
		return sectorCreado;
	}

	public List<Sector> listar() {

		List<Sector> sectores = repo.findAll();
		return sectores;
	}

	public Optional<Sector> buscar(String codigo) {
		
		return Optional.ofNullable(repo.findByCodigo(codigo).orElseThrow(() -> new sectorNoEncontradoException(codigo)));
	}

}
