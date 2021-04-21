package cl.lfuentes.icimg.api;

import cl.lfuentes.icimg.entityTo.Ric;
import cl.lfuentes.icimg.requestTO.RicRTO;
import cl.lfuentes.icimg.service.RicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ric")
public class RicApi {
	
	@Autowired
	private RicService servicio;
	
	@PostMapping("")
	public ResponseEntity<Ric> registro(@Valid @RequestBody RicRTO ric ){
				
		Ric respuesta = servicio.crear(ric);
		
		return new ResponseEntity <>(respuesta,HttpStatus.CREATED );
	}
	
	@GetMapping("")
	public ResponseEntity<List<Ric>> buscar(){
		
		List<Ric> rics = servicio.listar();
		
		return ResponseEntity.ok(rics);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Ric>> buscarId(@PathVariable(value = "id") Integer id){
		
		Optional<Ric> protocolo = servicio.buscar(id);
		
		return ResponseEntity.ok(protocolo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Ric> update(@Valid @RequestBody RicRTO ric , @PathVariable(value = "id") Integer id){

		Ric respuesta = servicio.actualizar(id, ric);

		return new ResponseEntity <>(respuesta,HttpStatus.CREATED );
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable(value = "id") Integer id){
		servicio.eliminar(id);

		return ResponseEntity.ok("");
	}
	
}
