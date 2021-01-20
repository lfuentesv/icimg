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
import cl.lfuentes.icimg.requestTO.AreaRTO;
import cl.lfuentes.icimg.service.areaService;

@RestController
@RequestMapping(value = "/parametros/area")
public class AreasApi {
	
	@Autowired
	private areaService servicio;
	
	@PostMapping("")
	public ResponseEntity<Area> registro(@Valid @RequestBody AreaRTO area ){
				
		Area areaRespuesta = servicio.crear(area);
		
		return new ResponseEntity <>(areaRespuesta,HttpStatus.CREATED );
	}
	
	@GetMapping("")
	public ResponseEntity<List<Area>> buscar(){
		
		List<Area> areas = servicio.listar();
		
		return ResponseEntity.ok(areas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Area>> buscarId(@PathVariable(value = "id") String id){
		
		Optional<Area> area = servicio.buscar(id);
		
		return ResponseEntity.ok(area);
	}
	
}
