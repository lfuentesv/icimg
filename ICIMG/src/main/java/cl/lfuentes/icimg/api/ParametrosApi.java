package cl.lfuentes.icimg.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cl.lfuentes.icimg.entityTo.Eje;
import cl.lfuentes.icimg.service.ParametrosService;

@RestController
@RequestMapping(value = "/parametros")
public class ParametrosApi {
	
	@Autowired
	private ParametrosService servicio;
	
	/****Ejes**/
	@PostMapping("/eje")
	public ResponseEntity<Eje> registro(@Valid @RequestBody Eje eje ){
		
		Eje ejeRespuesta = servicio.crear(eje);
		
		return new ResponseEntity <>(ejeRespuesta,HttpStatus.CREATED );
	}
	/**********/
	
	/****Areas**/
	/**********/
	
	/****Sector**/
	/**********/
	
	/****Capas**/
	/**********/
	
	/****Tramos**/
	/**********/
}
