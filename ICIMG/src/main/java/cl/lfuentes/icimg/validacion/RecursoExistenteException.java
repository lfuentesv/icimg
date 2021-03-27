package cl.lfuentes.icimg.validacion;

public class RecursoExistenteException extends NoEncontradoException{

	public RecursoExistenteException(String recurso, String valor) {

		super (recurso+" código <"+valor+"> ya existe.");
	}

	private static final long serialVersionUID = 1L;

}
