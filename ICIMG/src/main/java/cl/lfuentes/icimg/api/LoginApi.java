package cl.lfuentes.icimg.api;

import cl.lfuentes.icimg.entityTo.Usuario;
import cl.lfuentes.icimg.requestTO.LoginRTO;
import cl.lfuentes.icimg.requestTO.ProtocoloRecepcionRTO;
import cl.lfuentes.icimg.resposeTO.LoginResponseTO;
import cl.lfuentes.icimg.service.UsuarioService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/login")
public class LoginApi {

    @Autowired
    private UsuarioService service;

    @Autowired
    private Mapper mapper;

    @PostMapping("")
    public ResponseEntity<LoginResponseTO> login(@RequestBody LoginRTO login){

        Usuario usuario = service.login(login);

        LoginResponseTO loginResponseTO = mapper.map(usuario,LoginResponseTO.class);
        loginResponseTO.setToken( "test123");

        return new ResponseEntity<>(loginResponseTO, HttpStatus.OK);
    }
}
