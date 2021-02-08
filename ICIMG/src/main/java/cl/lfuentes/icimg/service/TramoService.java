package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.TramoRepository;
import cl.lfuentes.icimg.entityTo.Capa;
import cl.lfuentes.icimg.entityTo.Tramo;
import cl.lfuentes.icimg.requestTO.TramoRTO;
import cl.lfuentes.icimg.validacion.tramoNoEncontradoException;

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
		
		return Optional.ofNullable(repo.findById(id).orElseThrow(() -> new tramoNoEncontradoException(id.toString())));
	}

}
