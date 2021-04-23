package cl.lfuentes.icimg.validacion;

public class EjeNoEncontradoException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public EjeNoEncontradoException(String codigo) {
        super("El eje código {"+codigo+"} no fue encontrado");
    }
}
