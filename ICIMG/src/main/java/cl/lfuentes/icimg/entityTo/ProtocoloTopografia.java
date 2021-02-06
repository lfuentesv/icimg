package cl.lfuentes.icimg.entityTo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<LineaControl> lineasControl; 
	
		
	public ProtocoloTopografia() {

	}
	
	public ProtocoloTopografia(String codigo, Date fechaControl, String nombreTopografo, String observaciones, List<LineaControl> lineasControl) {
	
		this.codigo = codigo;
		this.fechaControl = fechaControl;
		this.nombreTopografo = nombreTopografo;
		this.observaciones = observaciones;
		this.lineasControl = lineasControl;
	
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

	public List<LineaControl> getLineasControl() {
		return lineasControl;
	}

	public void setLineasControl(List<LineaControl> lineasControl) {
		this.lineasControl = lineasControl;
	}

	
	
}
