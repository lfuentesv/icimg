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
	
}
