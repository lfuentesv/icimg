package cl.lfuentes.icimg.validacion;

public class tramoNoEncontradoException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public tramoNoEncontradoException(String codigo) {
        super("El tramo código {"+codigo+"} no fue encontrado");
    }
}
