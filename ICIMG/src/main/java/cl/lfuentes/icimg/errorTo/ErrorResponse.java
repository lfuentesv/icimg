package cl.lfuentes.icimg.errorTo;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
	
	private List<Error> errores = new ArrayList<>();

	public List<Error> getErrores() {
		return errores;
	}

	public void setErrores(List<Error> errores) {
		this.errores = errores;
	}
	
}
