package cl.lfuentes.icimg.validacion;

public class capaNoEncontradaException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public capaNoEncontradaException(String codigo) {
        super("La capa código {"+codigo+"} no fue encontrada");
    }
}
