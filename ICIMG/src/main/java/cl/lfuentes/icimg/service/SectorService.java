package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import cl.lfuentes.icimg.validacion.RecursoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.SectorRepository;
import cl.lfuentes.icimg.entityTo.Sector;
import cl.lfuentes.icimg.validacion.sectorNoEncontradoException;

import javax.transaction.Transactional;

@Service
public class SectorService {

	@Autowired
	private SectorRepository repo;
	

	public Sector crear(Sector sector) {
		/**Validamos que el área no exista*/
		Optional<Sector> existente = repo.findByCodigo(sector.getCodigo());
		if (existente.isPresent()) throw new RecursoExistenteException("Sector",sector.getCodigo());

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
	@Transactional
    public void eliminar(String codigo) {
		Optional<Sector> existente = repo.findByCodigo(codigo);
		if (!existente.isPresent()) throw new sectorNoEncontradoException(codigo);

		repo.deleteByCodigo(codigo);
	}

	public Sector actualizar(String codigo, Sector sector) {
		/**Validamos que el sector exista*/
		Optional<Sector> existente = repo.findByCodigo(sector.getCodigo());
		if (!existente.isPresent()) throw new sectorNoEncontradoException(codigo);

		Sector  po = new Sector ( codigo, sector.getNombre());

		return repo.saveAndFlush(po);
	}
}
