package cl.lfuentes.icimg.validacion;

public class TramoNoEncontradoException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public TramoNoEncontradoException(String codigo) {
        super("El tramo código {"+codigo+"} no fue encontrado");
    }
}
