package cl.lfuentes.icimg.service;

import cl.lfuentes.icimg.dao.RicRepository;
import cl.lfuentes.icimg.entityTo.Ric;
import cl.lfuentes.icimg.entityTo.Tramo;
import cl.lfuentes.icimg.requestTO.RicRTO;
import cl.lfuentes.icimg.validacion.DeleteException;
import cl.lfuentes.icimg.validacion.RicNoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public Ric actualizar(Integer numero, RicRTO ric) {
		/**Validamos que exista*/
		Optional<Ric> existente = repo.findByNumero(numero);
		if (!existente.isPresent()) throw new RicNoEncontradaException(numero);

		Optional<Tramo> tramo = tramoServicio.buscar(ric.getIdTramo());
//TODO acá solo esta dejando null la referencia, deberían eliminarse.
		existente.ifPresent(proto -> proto.getMuestras().forEach( (p) -> {p.setRic(null);}));
		Ric  ricPO = new Ric ( ric.getNumero(), ric.getFecha(), ric.getNombreLaboratorista(), ric.getComentarioEjecucion(), ric.getEquiposUtilizados(), ric.getRicReferencia(), ric.getDmcs(), ric.getHumedadOptima(), ric.getMuestras() );
		tramo.ifPresent(ricPO::setIdTramo);
		ricPO.getMuestras().forEach( (p) -> {p.setRic(ricPO);});

		return repo.saveAndFlush(ricPO);
	}

    @Transactional
	public void eliminar(Integer numero) {
		Optional<Ric> existente = repo.findByNumero(numero);
		if (!existente.isPresent()) throw new RicNoEncontradaException(numero);
		try {
			repo.deleteByNumero(numero);
			repo.flush();
		}catch (DataIntegrityViolationException e){
			throw new DeleteException("Error Ric, revise que no este asociado con otro recurso");
		}
	}
}
