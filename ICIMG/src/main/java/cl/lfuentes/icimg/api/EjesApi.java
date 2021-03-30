package cl.lfuentes.icimg.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.lfuentes.icimg.entityTo.Eje;
import cl.lfuentes.icimg.service.EjeService;

@RestController
@RequestMapping(value = "/parametros/eje")
public class EjesApi {
	
	@Autowired
	private EjeService servicio;
	
	@PostMapping("")
	public ResponseEntity<Eje> registro(@Valid @RequestBody Eje eje ){
		
		Eje ejeRespuesta = servicio.crear(eje);
		
		return new ResponseEntity <>(ejeRespuesta,HttpStatus.CREATED );
	}
	
	@GetMapping("")
	public ResponseEntity<List<Eje>> buscar(){
		
		List<Eje> ejes = servicio.listar();
		
		return ResponseEntity.ok(ejes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Eje>> buscarId(@PathVariable(value = "id") String id){
		
		Optional<Eje> eje = servicio.buscar(id);
		
		return ResponseEntity.ok(eje);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Eje> update(@Valid @RequestBody Eje eje , @PathVariable(value = "id") String id){

		Eje ejeRespuesta = servicio.actualizar(id, eje);

		return new ResponseEntity <>(ejeRespuesta,HttpStatus.CREATED );
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable(value = "id") String id){
		servicio.eliminar(id);

		return ResponseEntity.ok("");
	}
}
