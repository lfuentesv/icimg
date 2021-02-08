package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.RicRepository;
import cl.lfuentes.icimg.entityTo.Ric;
import cl.lfuentes.icimg.entityTo.Tramo;
import cl.lfuentes.icimg.requestTO.RicRTO;
import cl.lfuentes.icimg.validacion.RicNoEncontradaException;

@Service
public class RicService {

	@Autowired
	private RicRepository repo;
	
	@Autowired
	private TramoService tramoServicio;
	
	public Ric crear(RicRTO ric) {
		
		Optional<Tramo> tramo = tramoServicio.buscar(ric.getIdTramo());
	
		Ric  ricPO = new Ric ( ric.getNumero(), ric.getFecha(), ric.getNombreLaboratorista(), ric.getComentarioEjecucion(), ric.getEquiposUtilizados(), ric.getRicReferencia(), ric.getDmcs(), ric.getHumedadOptima(), ric.getMuestras() );
		tramo.ifPresent(ricPO::setIdTramo);
		ricPO.getMuestras().forEach( (p) -> {p.setRic(ricPO);});
		Ric ricCreado = repo.saveAndFlush(ricPO);
	
		return ricCreado;
	}

	public List<Ric> listar() {

		List<Ric> rics = repo.findAll();
		return rics;
	}

	public Optional<Ric> buscar(Integer numero) {
		
		return Optional.ofNullable(repo.findByNumero(numero).orElseThrow(() -> new RicNoEncontradaException(numero)));
	}

}
