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

import cl.lfuentes.icimg.entityTo.Capa;
import cl.lfuentes.icimg.requestTO.CapaRTO;
import cl.lfuentes.icimg.service.CapaService;

@RestController
@RequestMapping(value = "/parametros/capa")
public class CapasApi {
	
	@Autowired
	private CapaService servicio;
	
	@PostMapping("")
	public ResponseEntity<Capa> registro(@Valid @RequestBody CapaRTO capa ){
				
		Capa respuesta = servicio.crear(capa);
		
		return new ResponseEntity <>(respuesta,HttpStatus.CREATED );
	}
	
	@GetMapping("")
	public ResponseEntity<List<Capa>> buscar(){
		
		List<Capa> capas = servicio.listar();
		
		return ResponseEntity.ok(capas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Capa>> buscarId(@PathVariable(value = "id") String id){
		
		Optional<Capa> capa = servicio.buscar(id);
		
		return ResponseEntity.ok(capa);
	}
	
}
