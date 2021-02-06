package cl.lfuentes.icimg.requestTO;

import java.util.Date;
import java.util.List;

import cl.lfuentes.icimg.entityTo.Muestra;

public class RicRTO {

	private Integer numero;
	private Integer idTramo;
	private Date fecha;
	private String nombreLaboratorista;
	private String comentarioEjecucion;
	private String equiposUtilizados;
	private float ricReferencia;
	private float dmcs;
	private float humedadOptima;

	private List<Muestra> muestras;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}



	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombreLaboratorista() {
		return nombreLaboratorista;
	}

	public void setNombreLaboratorista(String nombreLaboratorista) {
		this.nombreLaboratorista = nombreLaboratorista;
	}

	public String getComentarioEjecucion() {
		return comentarioEjecucion;
	}

	public void setComentarioEjecucion(String comentarioEjecucion) {
		this.comentarioEjecucion = comentarioEjecucion;
	}

	public String getEquiposUtilizados() {
		return equiposUtilizados;
	}

	public void setEquiposUtilizados(String equiposUtilizados) {
		this.equiposUtilizados = equiposUtilizados;
	}

	public float getRicReferencia() {
		return ricReferencia;
	}

	public void setRicReferencia(float ricReferencia) {
		this.ricReferencia = ricReferencia;
	}

	public float getDmcs() {
		return dmcs;
	}

	public void setDmcs(float dmcs) {
		this.dmcs = dmcs;
	}

	public float getHumedadOptima() {
		return humedadOptima;
	}

	public void setHumedadOptima(float humedadOptima) {
		this.humedadOptima = humedadOptima;
	}

	public List<Muestra> getMuestras() {
		return muestras;
	}

	public void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}

	public Integer getIdTramo() {
		return idTramo;
	}

	public void setIdTramo(Integer idTramo) {
		this.idTramo = idTramo;
	}
	
}
