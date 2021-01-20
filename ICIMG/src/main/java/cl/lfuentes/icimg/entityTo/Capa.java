package cl.lfuentes.icimg.entityTo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Capa {

	@Id
	private String codigo;
	private String nombre;
	private float espesorObjetivo;
	private float elevacionObjetivo;
	private float tolerancia;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Area codArea;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Sector codSector;
	
	public Capa() {
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

	public Area getCodArea() {
		return codArea;
	}

	public void setCodArea(Area codArea) {
		this.codArea = codArea;
	}

	public Sector getCodSector() {
		return codSector;
	}

	public void setCodSector(Sector codSector) {
		this.codSector = codSector;
	}

	
	
}
