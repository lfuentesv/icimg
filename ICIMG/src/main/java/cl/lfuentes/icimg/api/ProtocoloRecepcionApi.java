package cl.lfuentes.icimg.api;

import cl.lfuentes.icimg.entityTo.ProtocoloRecepcion;
import cl.lfuentes.icimg.requestTO.ProtocoloRecepcionRTO;
import cl.lfuentes.icimg.service.ProtocoloRecepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

	@PutMapping("/{id}")
	public ResponseEntity<ProtocoloRecepcion> update(@Valid @RequestBody ProtocoloRecepcionRTO proto , @PathVariable(value = "id") String id){

		ProtocoloRecepcion respuesta = servicio.actualizar(id, proto);

		return new ResponseEntity <>(respuesta,HttpStatus.CREATED );
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable(value = "id") String id){
		servicio.eliminar(id);

		return ResponseEntity.ok("");
	}
	
}
