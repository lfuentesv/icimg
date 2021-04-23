package cl.lfuentes.icimg.validacion;

public class UsuarioNoEncontradoException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public UsuarioNoEncontradoException(String codigo) {
        super("El usuario rut {"+codigo+"} no fue encontrado");
    }
}
