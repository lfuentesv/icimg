package cl.lfuentes.icimg.validacion;

public class areaNoEncontradaException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public areaNoEncontradaException(String codigo) {
        super("El área código {"+codigo+"} no fue encontrada");
    }
}
