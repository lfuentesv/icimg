package cl.lfuentes.icimg.validacion;

public class RicNoEncontradaException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public RicNoEncontradaException(Integer codigo) {
        super("La capa código {"+codigo+"} no fue encontrada");
    }
}
