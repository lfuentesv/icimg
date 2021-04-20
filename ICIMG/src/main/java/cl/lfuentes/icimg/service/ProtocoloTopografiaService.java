package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import cl.lfuentes.icimg.entityTo.*;
import cl.lfuentes.icimg.validacion.DeleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.ProtocoloTopografiaRepository;
import cl.lfuentes.icimg.requestTO.ProtocoloTopografiaRTO;
import cl.lfuentes.icimg.validacion.protocoloTopografiaNoEncontradoException;

import javax.transaction.Transactional;

@Service
public class ProtocoloTopografiaService {

	@Autowired
	private ProtocoloTopografiaRepository repo;

	
	@Autowired
	private TramoService tramoServicio;
	
	public ProtocoloTopografia crear(ProtocoloTopografiaRTO protocolo) {
		
		Optional<Tramo> tramo = tramoServicio.buscar(protocolo.getIdTramo());
	
		ProtocoloTopografia  protocoloPO = new ProtocoloTopografia ( protocolo.getCodigo(), protocolo.getFechaControl(), protocolo.getNombreTopografo(), protocolo.getObservaciones(), protocolo.getLineasControl());
		tramo.ifPresent(protocoloPO::setIdTramo);
		
		protocoloPO.getLineasControl().forEach( (p) -> {p.setProtocoloTopografia(protocoloPO);});
		ProtocoloTopografia protocoloCreado = repo.saveAndFlush(protocoloPO);
	
		return protocoloCreado;
	}

	public List<ProtocoloTopografia> listar() {

		List<ProtocoloTopografia> protocolos = repo.findAll();
		return protocolos;
	}

	public Optional<ProtocoloTopografia> buscar(String codigo) {
		
		return Optional.ofNullable(repo.findByCodigo(codigo).orElseThrow(() -> new protocoloTopografiaNoEncontradoException(codigo)));
	}

	@Transactional
    public void eliminar(String codigo) {

		Optional<ProtocoloTopografia> existente = repo.findByCodigo(codigo);
		if (!existente.isPresent()) throw new protocoloTopografiaNoEncontradoException(codigo);
		try {
			repo.deleteByCodigo(codigo);
			repo.flush();
		}catch (DataIntegrityViolationException e){
			throw new DeleteException("Error eliminando protocolo de topografía, revise que no este asociado con otro recurso");
		}
    }

	public ProtocoloTopografia actualizar(String codigo, ProtocoloTopografiaRTO protocolo) {

		/**Validamos que exista*/
		Optional<ProtocoloTopografia> existente = repo.findByCodigo(codigo);
		if (!existente.isPresent()) throw new protocoloTopografiaNoEncontradoException(codigo);

		Optional<Tramo> tramo = tramoServicio.buscar(protocolo.getIdTramo());
//TODO acá solo esta dejando null la referencia, deberían eliminarse.
		existente.ifPresent(proto -> proto.getLineasControl().forEach( (p) -> {p.setProtocoloTopografia(null);}));
		ProtocoloTopografia  po = new ProtocoloTopografia ( protocolo.getCodigo(), protocolo.getFechaControl(), protocolo.getNombreTopografo(), protocolo.getObservaciones(), protocolo.getLineasControl());
		po.getLineasControl().forEach( (p) -> p.setProtocoloTopografia(po));
		tramo.ifPresent(po::setIdTramo);

		return repo.saveAndFlush(po);
	}
}
