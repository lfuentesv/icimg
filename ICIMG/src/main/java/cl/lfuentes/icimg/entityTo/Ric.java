package cl.lfuentes.icimg.entityTo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ric {
	
	@Id
	@GeneratedValue
	private Integer numero;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Tramo idTramo;
	private Date fecha;
	private String nombreLaboratorista;
	private String comentarioEjecucion;
	private String equiposUtilizados;
	private float ricReferencia;
	private float dmcs;
	private float humedadOptima;
	
	public Ric() {
	
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Tramo getIdTramo() {
		return idTramo;
	}

	public void setIdTramo(Tramo idTramo) {
		this.idTramo = idTramo;
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
	

}
