package cl.lfuentes.icimg.validacion;

public class protocoloTopografiaNoEncontradoException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public protocoloTopografiaNoEncontradoException(String codigo) {
        super("El Protocolo de Topografía código {"+codigo+"} no fue encontrado");
    }
}
