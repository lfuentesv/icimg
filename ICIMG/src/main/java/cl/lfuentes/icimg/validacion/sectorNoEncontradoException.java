package cl.lfuentes.icimg.validacion;

public class sectorNoEncontradoException extends NoEncontradoException{

	private static final long serialVersionUID = -3014896195971684306L;

	public sectorNoEncontradoException(String codigo) {
        super("El sector código {"+codigo+"} no fue encontrado");
    }
}
