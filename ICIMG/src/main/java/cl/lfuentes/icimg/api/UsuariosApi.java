package cl.lfuentes.icimg.api;

import cl.lfuentes.icimg.entityTo.Area;
import cl.lfuentes.icimg.entityTo.Usuario;
import cl.lfuentes.icimg.requestTO.AreaRTO;
import cl.lfuentes.icimg.requestTO.UsuarioRTO;
import cl.lfuentes.icimg.resposeTO.UsuarioResponseTO;
import cl.lfuentes.icimg.service.UsuarioService;
import cl.lfuentes.icimg.service.areaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class UsuariosApi {
	
	@Autowired
	private UsuarioService servicio;


	@Autowired
	private Mapper mapper;
	
	@PostMapping("")
	public ResponseEntity<UsuarioResponseTO> registro(@Valid @RequestBody UsuarioRTO usuario ){
				
		Usuario respuesta = servicio.crear(usuario);
		UsuarioResponseTO usuarioResponseTO = mapper.map(respuesta, UsuarioResponseTO.class);


		return new ResponseEntity <>(usuarioResponseTO,HttpStatus.CREATED );
	}
	
	@GetMapping("")
	public ResponseEntity<List<Usuario>> buscar(){
		
		List<Usuario> lista = servicio.listar();
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseTO> buscarId(@PathVariable(value = "id") String id){
		
		Optional<Usuario> usuario = servicio.buscar(id);
		UsuarioResponseTO usuarioResponseTO = mapper.map(usuario.get(), UsuarioResponseTO.class);
		
		return ResponseEntity.ok(usuarioResponseTO);
	}
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioResponseTO> update(@Valid @RequestBody UsuarioRTO usuario ,@PathVariable(value = "id") String rut){
				
		Usuario usuarioRespuesta = servicio.actualizar(rut, usuario);
		UsuarioResponseTO usuarioResponseTO = mapper.map(usuarioRespuesta,UsuarioResponseTO.class );
		return new ResponseEntity <>(usuarioResponseTO,HttpStatus.CREATED );
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminar(@PathVariable(value = "id") String id){
		servicio.eliminar(id);

		return ResponseEntity.ok("");
	}
	
}
