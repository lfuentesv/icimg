package cl.lfuentes.icimg.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.lfuentes.icimg.entityTo.Tramo;
import cl.lfuentes.icimg.requestTO.TramoRTO;
import cl.lfuentes.icimg.service.TramoService;

@RestController
@RequestMapping(value = "/parametros/tramo")
public class TramosApi {
	
	@Autowired
	private TramoService servicio;
	
	@PostMapping("")
	public ResponseEntity<Tramo> registro(@Valid @RequestBody TramoRTO tramo ){
				
		Tramo respuesta = servicio.crear(tramo);
		
		return new ResponseEntity <>(respuesta,HttpStatus.CREATED );
	}
	
	@GetMapping("")
	public ResponseEntity<List<Tramo>> buscar(){
		
		List<Tramo> tramos = servicio.listar();
		
		return ResponseEntity.ok(tramos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Tramo>> buscarId(@PathVariable(value = "id") Integer id){
		
		Optional<Tramo> tramo = servicio.buscar(id);
		
		return ResponseEntity.ok(tramo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tramo> update(@Valid @RequestBody TramoRTO tramo , @PathVariable(value = "id") String id){

		Tramo respuesta = servicio.actualizar(id, tramo);

		return new ResponseEntity <>(respuesta,HttpStatus.CREATED );
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable(value = "id") String id){
		servicio.eliminar(id);

		return ResponseEntity.ok("");
	}
	
}
