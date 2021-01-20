package cl.lfuentes.icimg.requestTO;

public class CapaRTO {

	private String codigo;
	private String nombre;
	private float espesorObjetivo;
	private float elevacionObjetivo;
	private float tolerancia;
	private String codArea;
	private String codSector;
	
	public CapaRTO() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getEspesorObjetivo() {
		return espesorObjetivo;
	}

	public void setEspesorObjetivo(float espesorObjetivo) {
		this.espesorObjetivo = espesorObjetivo;
	}

	public float getElevacionObjetivo() {
		return elevacionObjetivo;
	}

	public void setElevacionObjetivo(float elevacionObjetivo) {
		this.elevacionObjetivo = elevacionObjetivo;
	}

	public float getTolerancia() {
		return tolerancia;
	}

	public void setTolerancia(float tolerancia) {
		this.tolerancia = tolerancia;
	}

	public String getCodArea() {
		return codArea;
	}

	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}

	public String getCodSector() {
		return codSector;
	}

	public void setCodSector(String codSector) {
		this.codSector = codSector;
	}
	
}
