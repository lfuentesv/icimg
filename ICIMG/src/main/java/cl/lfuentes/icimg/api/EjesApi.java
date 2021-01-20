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

import cl.lfuentes.icimg.entityTo.Area;
import cl.lfuentes.icimg.entityTo.Eje;
import cl.lfuentes.icimg.service.EjeService;

@RestController
@RequestMapping(value = "/parametros/eje")
public class EjesApi {
	
	@Autowired
	private EjeService servicio;
	
	/****Ejes**/
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
	/**********/
	
	/****Areas**/
	@PostMapping("/area")
	public ResponseEntity<Area> registro(@Valid @RequestBody Area area ){
		
		Area areaRespuesta = servicio.crear(area);
		
		return new ResponseEntity <>(areaRespuesta,HttpStatus.CREATED );
	}
	
	@GetMapping("/area")
	public ResponseEntity<List<Area>> buscar(){
		
		List<Area> areas = servicio.listar();
		
		return ResponseEntity.ok(areas);
	}
	
	@GetMapping("/area/{id}")
	public ResponseEntity<Optional<Area>> buscarId(@PathVariable(value = "id") String id){
		
		Optional<Area> area = servicio.buscar(area);
		
		return ResponseEntity.ok(area);
	}
	
	/**********/
	
	/****Sector**/
	/**********/
	
	/****Capas**/
	/**********/
	
	/****Tramos**/
	/**********/
}
