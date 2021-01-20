package cl.lfuentes.icimg.validacion;

public class ejeNoEncontradoException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public ejeNoEncontradoException(String codigo) {
        super("El eje código {"+codigo+"} no fue encontrado");
    }
}
