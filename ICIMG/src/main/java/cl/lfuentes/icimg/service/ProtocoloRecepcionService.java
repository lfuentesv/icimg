package cl.lfuentes.icimg.service;

import cl.lfuentes.icimg.dao.ProtocoloRecepcionRepository;
import cl.lfuentes.icimg.entityTo.ProtocoloRecepcion;
import cl.lfuentes.icimg.entityTo.ProtocoloTopografia;
import cl.lfuentes.icimg.entityTo.Ric;
import cl.lfuentes.icimg.entityTo.Tramo;
import cl.lfuentes.icimg.requestTO.ProtocoloRecepcionRTO;
import cl.lfuentes.icimg.validacion.DeleteException;
import cl.lfuentes.icimg.validacion.protocoloRecepcionNoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProtocoloRecepcionService {

	@Autowired
	private ProtocoloRecepcionRepository repo;
	
	@Autowired
	private TramoService tramoServicio;
	@Autowired
	private ProtocoloTopografiaService topografiaServicio;
	@Autowired
	private RicService ricServicio;
	
	public ProtocoloRecepcion crear(ProtocoloRecepcionRTO protocolo) {
		
		Optional<Tramo> tramo = tramoServicio.buscar(protocolo.getIdTramo());
		Optional<ProtocoloTopografia> topografia = topografiaServicio.buscar(protocolo.getCodProtocolo());
		Optional<Ric> ric = ricServicio.buscar(protocolo.getNroInspeccion());
	
		ProtocoloRecepcion  protocoloPO = new ProtocoloRecepcion ( 
				protocolo.getCodigo(),
				protocolo.getNombreSupervisor(),
				protocolo.getFechaEmision(),
				protocolo.isEquiposAdecuados(),
				protocolo.isEmprestitoAprobado(),
				protocolo.isRequiereAello(),
				protocolo.isCumpleGranulometria(),
				protocolo.isCumpleHumedad(),
				protocolo.isCumpleElevacion(),
				protocolo.isCapaLibreSobretamaños(),
				protocolo.isSobretamañoPretilesTaludes(),			
				protocolo.isHumectacionMaterial(),
				protocolo.isCompactacionCapa(),
				protocolo.getEspesorNominal(),
				protocolo.getLargoCapa(),
				protocolo.getAnchoPromedioTeorico(),
				protocolo.getAnchoPromedioReal(),
				protocolo.isTerminacionUniforme(),
				protocolo.isVeredicto());
		tramo.ifPresent(protocoloPO::setIdTramo);
		topografia.ifPresent(protocoloPO::setCodProtocolo);
		ric.ifPresent(protocoloPO::setNroInspeccion);
		
		ProtocoloRecepcion protocoloCreado = repo.saveAndFlush(protocoloPO);
	
		return protocoloCreado;
	}

	public List<ProtocoloRecepcion> listar() {

		List<ProtocoloRecepcion> protocolos = repo.findAll();
		return protocolos;
	}

	public Optional<ProtocoloRecepcion> buscar(String codigo) {
		
		return Optional.ofNullable(repo.findByCodigo(codigo).orElseThrow(() -> new protocoloRecepcionNoEncontradoException(codigo)));
	}

    public ProtocoloRecepcion actualizar(String codigo, ProtocoloRecepcionRTO protocolo) {
		/**Validamos que exista*/
		Optional<ProtocoloRecepcion> existente = repo.findByCodigo(codigo);
		if (!existente.isPresent()) throw new protocoloRecepcionNoEncontradoException(codigo);

		Optional<Tramo> tramo = tramoServicio.buscar(protocolo.getIdTramo());
		Optional<ProtocoloTopografia> topografia = topografiaServicio.buscar(protocolo.getCodProtocolo());
		Optional<Ric> ric = ricServicio.buscar(protocolo.getNroInspeccion());

		ProtocoloRecepcion  protocoloPO = new ProtocoloRecepcion (
				protocolo.getCodigo(),
				protocolo.getNombreSupervisor(),
				protocolo.getFechaEmision(),
				protocolo.isEquiposAdecuados(),
				protocolo.isEmprestitoAprobado(),
				protocolo.isRequiereAello(),
				protocolo.isCumpleGranulometria(),
				protocolo.isCumpleHumedad(),
				protocolo.isCumpleElevacion(),
				protocolo.isCapaLibreSobretamaños(),
				protocolo.isSobretamañoPretilesTaludes(),
				protocolo.isHumectacionMaterial(),
				protocolo.isCompactacionCapa(),
				protocolo.getEspesorNominal(),
				protocolo.getLargoCapa(),
				protocolo.getAnchoPromedioTeorico(),
				protocolo.getAnchoPromedioReal(),
				protocolo.isTerminacionUniforme(),
				protocolo.isVeredicto());
		tramo.ifPresent(protocoloPO::setIdTramo);
		topografia.ifPresent(protocoloPO::setCodProtocolo);
		ric.ifPresent(protocoloPO::setNroInspeccion);
		return repo.saveAndFlush(protocoloPO);
    }

    @Transactional
	public void eliminar(String codigo) {
		Optional<ProtocoloRecepcion> existente = repo.findByCodigo(codigo);
		if (!existente.isPresent()) throw new protocoloRecepcionNoEncontradoException(codigo);
		try {
			repo.deleteByCodigo(codigo);
			repo.flush();
		}catch (DataIntegrityViolationException e){
			throw new DeleteException("Error eliminando protocolo de recepción, revise que no este asociado con otro recurso");
		}
	}
}
