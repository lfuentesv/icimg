package cl.lfuentes.icimg.validacion;

public class protocoloTopografiaNoEncontradaException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public protocoloTopografiaNoEncontradaException(String codigo) {
        super("La capa código {"+codigo+"} no fue encontrada");
    }
}
