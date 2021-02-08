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

import cl.lfuentes.icimg.entityTo.ProtocoloTopografia;
import cl.lfuentes.icimg.requestTO.ProtocoloTopografiaRTO;
import cl.lfuentes.icimg.service.ProtocoloTopografiaService;

@RestController
@RequestMapping(value = "/protocoloTopografia")
public class ProtocoloTopografiaApi {
	
	@Autowired
	private ProtocoloTopografiaService servicio;
	
	@PostMapping("")
	public ResponseEntity<ProtocoloTopografia> registro(@Valid @RequestBody ProtocoloTopografiaRTO capa ){
				
		ProtocoloTopografia respuesta = servicio.crear(capa);
		
		return new ResponseEntity <>(respuesta,HttpStatus.CREATED );
	}
	
	@GetMapping("")
	public ResponseEntity<List<ProtocoloTopografia>> buscar(){
		
		List<ProtocoloTopografia> protocolos = servicio.listar();
		
		return ResponseEntity.ok(protocolos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProtocoloTopografia>> buscarId(@PathVariable(value = "id") String id){
		
		Optional<ProtocoloTopografia> protocolo = servicio.buscar(id);
		
		return ResponseEntity.ok(protocolo);
	}
	
}
