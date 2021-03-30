package cl.lfuentes.icimg.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.lfuentes.icimg.entityTo.Sector;
import cl.lfuentes.icimg.service.SectorService;

@RestController
@RequestMapping(value = "/parametros/sector")
public class SectoresApi {
	
	@Autowired
	private SectorService servicio;
	
	@PostMapping("")
	public ResponseEntity<Sector> registro(@Valid @RequestBody Sector sector ){
		
		Sector sectorRespuesta = servicio.crear(sector);
		
		return new ResponseEntity <>(sectorRespuesta,HttpStatus.CREATED );
	}
	
	@GetMapping("")
	public ResponseEntity<List<Sector>> buscar(){
		
		List<Sector> sectores = servicio.listar();
		
		return ResponseEntity.ok(sectores);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Sector>> buscarId(@PathVariable(value = "id") String id){
		
		Optional<Sector> sector = servicio.buscar(id);
		
		return ResponseEntity.ok(sector);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Sector> update(@Valid @RequestBody Sector sector , @PathVariable(value = "id") String id){

		Sector respuesta = servicio.actualizar(id, sector);

		return new ResponseEntity <>(respuesta,HttpStatus.CREATED );
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable(value = "id") String id){
		servicio.eliminar(id);

		return ResponseEntity.ok("");
	}
}
