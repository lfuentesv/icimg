package cl.lfuentes.icimg.api;

import cl.lfuentes.icimg.requestTO.LoginRTO;
import cl.lfuentes.icimg.requestTO.ProtocoloRecepcionRTO;
import cl.lfuentes.icimg.resposeTO.LoginResponseTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class LoginApi {

    @PostMapping("")
    public ResponseEntity<LoginResponseTO> login(@RequestBody LoginRTO login){

        return new ResponseEntity<>(new LoginResponseTO("test123"), HttpStatus.OK);
    }
}
