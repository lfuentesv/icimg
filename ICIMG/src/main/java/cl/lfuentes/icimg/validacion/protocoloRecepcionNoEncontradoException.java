package cl.lfuentes.icimg.validacion;

public class protocoloRecepcionNoEncontradoException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public protocoloRecepcionNoEncontradoException(String codigo) {
        super("La el Protocolo de Recepción código {"+codigo+"} no fue encontrada");
    }
}
