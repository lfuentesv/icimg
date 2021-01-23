package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.ProtocoloTopografiaRepository;
import cl.lfuentes.icimg.entityTo.ProtocoloTopografia;
import cl.lfuentes.icimg.entityTo.Tramo;
import cl.lfuentes.icimg.requestTO.ProtocoloTopografiaRTO;
import cl.lfuentes.icimg.validacion.protocoloTopografiaNoEncontradaException;

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
		ProtocoloTopografia protocoloCreado = repo.saveAndFlush(protocoloPO);
	
		return protocoloCreado;
	}

	public List<ProtocoloTopografia> listar() {

		List<ProtocoloTopografia> protocolos = repo.findAll();
		return protocolos;
	}

	public Optional<ProtocoloTopografia> buscar(String codigo) {
		
		return Optional.ofNullable(repo.findByCodigo(codigo).orElseThrow(() -> new protocoloTopografiaNoEncontradaException(codigo)));
	}

}
