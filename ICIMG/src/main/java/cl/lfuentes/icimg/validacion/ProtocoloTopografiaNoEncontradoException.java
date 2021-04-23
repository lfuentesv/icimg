package cl.lfuentes.icimg.validacion;

public class ProtocoloTopografiaNoEncontradoException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public ProtocoloTopografiaNoEncontradoException(String codigo) {
        super("El Protocolo de Topografía código {"+codigo+"} no fue encontrado");
    }
}
