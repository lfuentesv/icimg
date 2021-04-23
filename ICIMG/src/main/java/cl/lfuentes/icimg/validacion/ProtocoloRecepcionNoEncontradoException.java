package cl.lfuentes.icimg.validacion;

public class ProtocoloRecepcionNoEncontradoException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public ProtocoloRecepcionNoEncontradoException(String codigo) {
        super("La el Protocolo de Recepción código {"+codigo+"} no fue encontrada");
    }
}
