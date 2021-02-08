package cl.lfuentes.icimg.entityTo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LineaControl {

	@Id
	@GeneratedValue
	private Integer idLinea;
	private Integer nroLinea;
	
	@ManyToOne 
	@JoinColumn(name="codProtocolo")
	private ProtocoloTopografia protocoloTopografia;
	
	private Integer kilometro;
	private float elevacionBordeNorte;
	private float elevacionCentroNorte;
	private float elevacionCentroSur;
	private float elevacionBordeSur;
	private float ancho;
	private boolean cumplimiento;
	private String observacion;
	
	public LineaControl() {

	}

	public Integer getNro_linea() {
		return nroLinea;
	}

	public void setNro_linea(Integer nroLinea) {
		this.nroLinea = nroLinea;
	}



	public void setProtocoloTopografia(ProtocoloTopografia protocoloTopografia) {
		this.protocoloTopografia = protocoloTopografia;
	}

	public Integer getKilometro() {
		return kilometro;
	}

	public void setKilometro(Integer kilometro) {
		this.kilometro = kilometro;
	}

	public float getElevacionBordeNorte() {
		return elevacionBordeNorte;
	}

	public void setElevacionBordeNorte(float elevacionBordeNorte) {
		this.elevacionBordeNorte = elevacionBordeNorte;
	}

	public float getElevacionCentroNorte() {
		return elevacionCentroNorte;
	}

	public void setElevacionCentroNorte(float elevacionCentroNorte) {
		this.elevacionCentroNorte = elevacionCentroNorte;
	}

	public float getElevacionCentroSur() {
		return elevacionCentroSur;
	}

	public void setElevacionCentroSur(float elevacionCentroSur) {
		this.elevacionCentroSur = elevacionCentroSur;
	}

	public float getElevacionBordeSur() {
		return elevacionBordeSur;
	}

	public void setElevacionBordeSur(float elevacionBordeSur) {
		this.elevacionBordeSur = elevacionBordeSur;
	}

	public float getAncho() {
		return ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public boolean isCumplimiento() {
		return cumplimiento;
	}

	public void setCumplimiento(boolean cumplimiento) {
		this.cumplimiento = cumplimiento;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Integer idLinea) {
		this.idLinea = idLinea;
	}

	public Integer getNroLinea() {
		return nroLinea;
	}

	public void setNroLinea(Integer nroLinea) {
		this.nroLinea = nroLinea;
	}
	
		

}
