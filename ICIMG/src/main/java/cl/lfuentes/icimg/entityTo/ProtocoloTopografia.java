package cl.lfuentes.icimg.entityTo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProtocoloTopografia {

	@Id
	private String codigo;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Tramo idTramo;
	private Date fechaControl;
	private String observaciones;
	private String nombreTopografo;
	private boolean cumpleAlineamientos;
	
		
	public ProtocoloTopografia() {

	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Tramo getIdTramo() {
		return idTramo;
	}
	public void setIdTramo(Tramo idTramo) {
		this.idTramo = idTramo;
	}
	public Date getFechaControl() {
		return fechaControl;
	}
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getNombreTopografo() {
		return nombreTopografo;
	}
	public void setNombreTopografo(String nombreTopografo) {
		this.nombreTopografo = nombreTopografo;
	}
	public boolean isCumpleAlineamientos() {
		return cumpleAlineamientos;
	}
	public void setCumpleAlineamientos(boolean cumpleAlineamientos) {
		this.cumpleAlineamientos = cumpleAlineamientos;
	}

	
}
