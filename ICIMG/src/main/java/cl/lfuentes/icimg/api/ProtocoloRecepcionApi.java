package cl.lfuentes.icimg.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.lfuentes.icimg.entityTo.ProtocoloRecepcion;
import cl.lfuentes.icimg.requestTO.ProtocoloRecepcionRTO;
import cl.lfuentes.icimg.service.ProtocoloRecepcionService;

@RestController
@RequestMapping(value = "/protocoloRecepcion")
public class ProtocoloRecepcionApi {
	
	@Autowired
	private ProtocoloRecepcionService servicio;
	
	@PostMapping("")
	public ResponseEntity<ProtocoloRecepcion> registro(@Valid @RequestBody ProtocoloRecepcionRTO protocolo ){
				
		ProtocoloRecepcion respuesta = servicio.crear(protocolo);
		
		return new ResponseEntity <>(respuesta,HttpStatus.CREATED );
	}
	
	@GetMapping("")
	public ResponseEntity<List<ProtocoloRecepcion>> buscar(){
		
		List<ProtocoloRecepcion> protocolos = servicio.listar();
		
		return ResponseEntity.ok(protocolos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProtocoloRecepcion>> buscarId(@PathVariable(value = "id") String id){
		
		Optional<ProtocoloRecepcion> protocolo = servicio.buscar(id);
		
		return ResponseEntity.ok(protocolo);
	}
	
}
