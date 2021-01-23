package cl.lfuentes.icimg.requestTO;

import java.util.Date;
import java.util.List;

import cl.lfuentes.icimg.entityTo.LineaControl;

public class ProtocoloTopografiaRTO {

	private String codigo;
	private Integer idTramo;
	private Date fechaControl;
	private String observaciones;
	private String nombreTopografo;
	private boolean cumpleAlineamientos;
	
	private List<LineaControl> lineasControl; 
	
		
	public ProtocoloTopografiaRTO() {

	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getIdTramo() {
		return idTramo;
	}
	public void setIdTramo(Integer idTramo) {
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
