package cl.lfuentes.icimg.validacion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import cl.lfuentes.icimg.errorTo.ErrorResponse;
import cl.lfuentes.icimg.errorTo.Error;

@ControllerAdvice
public class ParametrosAdvisor {
	@ExceptionHandler(NoEncontradoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse onNoEncontradoException(NoEncontradoException e) {
		ErrorResponse respuestaError = new ErrorResponse();
		respuestaError.getErrores().add(new Error(e.getMessage()));
	  return respuestaError;
	}

	@ExceptionHandler(DeleteException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResponse onDeleteException(DeleteException e) {
		ErrorResponse respuestaError = new ErrorResponse();
		respuestaError.getErrores().add(new Error(e.getMessage()));
		return respuestaError;
	}

}
