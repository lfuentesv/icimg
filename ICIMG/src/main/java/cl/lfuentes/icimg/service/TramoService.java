package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import cl.lfuentes.icimg.validacion.DeleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.TramoRepository;
import cl.lfuentes.icimg.entityTo.Capa;
import cl.lfuentes.icimg.entityTo.Tramo;
import cl.lfuentes.icimg.requestTO.TramoRTO;
import cl.lfuentes.icimg.validacion.TramoNoEncontradoException;

import javax.transaction.Transactional;

@Service
public class TramoService {

	@Autowired
	private TramoRepository repo;
	
	@Autowired
	private CapaService capaServicio;

	
	public Tramo crear(TramoRTO tramo) {
		Optional<Capa> capa = capaServicio.buscar(tramo.getCodCapa());
	
		Tramo tramoPO = new Tramo ( tramo.getId(), tramo.getKmInicio(), tramo.getKmTermino() );
		capa.ifPresent(tramoPO::setCodCapa);
		Tramo tramoCreado = repo.saveAndFlush(tramoPO);
	
		return tramoCreado;
	}

	public List<Tramo> listar() {

		List<Tramo> tramos = repo.findAll();
		return tramos;
	}

	public Optional<Tramo> buscar(Integer id) {
		
		return Optional.ofNullable(repo.findById(id).orElseThrow(() -> new TramoNoEncontradoException(id.toString())));
	}

    public Tramo actualizar(String id, TramoRTO tramo) {
		/**Validamos que exista*/
		Optional<Tramo> existente = repo.findById(tramo.getId());
		if (!existente.isPresent()) throw new TramoNoEncontradoException(id);

		Optional<Capa> capa = capaServicio.buscar(tramo.getCodCapa());
		Tramo  po = new Tramo ( tramo.getId(), tramo.getKmInicio(), tramo.getKmTermino());
		capa.ifPresent(po::setCodCapa);

		return repo.saveAndFlush(po);
    }

    @Transactional
	public void eliminar(String id) {
		Optional<Tramo> existente = repo.findById(Integer.parseInt(id));
		if (!existente.isPresent()) throw new TramoNoEncontradoException(id);
		try {
			repo.deleteById(Integer.parseInt(id));
			repo.flush();
		}catch (DataIntegrityViolationException e){
			throw new DeleteException("Error eliminando tramo, revise que no este asociado con otro recurso");
		}
	}
}
