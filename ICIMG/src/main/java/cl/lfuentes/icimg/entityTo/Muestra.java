package cl.lfuentes.icimg.entityTo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Muestra {
	
	@Id
	@GeneratedValue
	private Integer numeroMuestra;
	
	@ManyToOne /* (optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER) */
	//@JoinColumn(name="numero", nullable=false, insertable=false, updatable=false)
	@JoinColumn(name="numero")
	private Ric ric;
	
	 
	private Integer kilometro;
	private float espesorCapa;
	private float espesorControl;
	private float rebaje;
	private float dclt;
	private float humedad;
	private float dcs;
	private float compactacion;
	private float coordenadaNorte;
	private float coordenadaEste;
	private Integer cota;
	
	public Muestra() {

	}
	
	public Integer getNumeroMuestra() {
		return numeroMuestra;
	}
	public void setNumeroMuestra(Integer numero) {
		this.numeroMuestra = numero;
	}

	public Integer getKilometro() {
		return kilometro;
	}
	public void setKilometro(Integer kilometro) {
		this.kilometro = kilometro;
	}
	public float getEspesorCapa() {
		return espesorCapa;
	}
	public void setEspesorCapa(float espesorCapa) {
		this.espesorCapa = espesorCapa;
	}
	public float getEspesorControl() {
		return espesorControl;
	}
	public void setEspesorControl(float espesorControl) {
		this.espesorControl = espesorControl;
	}
	public float getRebaje() {
		return rebaje;
	}
	public void setRebaje(float rebaje) {
		this.rebaje = rebaje;
	}
	public float getDclt() {
		return dclt;
	}
	public void setDclt(float dclt) {
		this.dclt = dclt;
	}
	public float getHumedad() {
		return humedad;
	}
	public void setHumedad(float humedad) {
		this.humedad = humedad;
	}
	public float getDcs() {
		return dcs;
	}
	public void setDcs(float dcs) {
		this.dcs = dcs;
	}
	public float getCompactacion() {
		return compactacion;
	}
	public void setCompactacion(float compactacion) {
		this.compactacion = compactacion;
	}
	public float getCoordenadaNorte() {
		return coordenadaNorte;
	}
	public void setCoordenadaNorte(float coordenadaNorte) {
		this.coordenadaNorte = coordenadaNorte;
	}
	public float getCoordenadaEste() {
		return coordenadaEste;
	}
	public void setCoordenadaEste(float coordenadaEste) {
		this.coordenadaEste = coordenadaEste;
	}
	public Integer getCota() {
		return cota;
	}
	public void setCota(Integer cota) {
		this.cota = cota;
	}

	public void setRic(Ric ric) {
		this.ric = ric;
	}
	
}
