package cl.lfuentes.icimg.entityTo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProtocoloRecepcion {


	@Id
	private String codigo;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ProtocoloTopografia codProtocolo;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Ric nroInspeccion;
	private String nombreSupervisor;
	private Date fechaEmision;
	private boolean equiposAdecuados;
	private boolean emprestitoAprobado;
	private boolean requiereAello;
	private boolean cumpleGranulometria;
	private boolean cumpleHumedad;
	private boolean cumpleElevacion;
	private boolean capaLibreSobretamaños;
	private boolean sobretamañoPretilesTaludes;			
	private boolean humectacionMaterial;
	private boolean compactacionCapa;
	private float espesorNominal;
	private float largoCapa;
	private float anchoPromedioTeorico;
	private float anchoPromedioReal;
	private boolean terminacionUniforme;
	private boolean veredicto;

	public ProtocoloRecepcion() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ProtocoloTopografia getCodProtocolo() {
		return codProtocolo;
	}

	public void setCodProtocolo(ProtocoloTopografia codProtocolo) {
		this.codProtocolo = codProtocolo;
	}

	public Ric getNroInspeccion() {
		return nroInspeccion;
	}

	public void setNroInspeccion(Ric nroInspeccion) {
		this.nroInspeccion = nroInspeccion;
	}

	public String getNombreSupervisor() {
		return nombreSupervisor;
	}

	public void setNombreSupervisor(String nombreSupervisor) {
		this.nombreSupervisor = nombreSupervisor;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public boolean isEquiposAdecuados() {
		return equiposAdecuados;
	}

	public void setEquiposAdecuados(boolean equiposAdecuados) {
		this.equiposAdecuados = equiposAdecuados;
	}

	public boolean isEmprestitoAprobado() {
		return emprestitoAprobado;
	}

	public void setEmprestitoAprobado(boolean emprestitoAprobado) {
		this.emprestitoAprobado = emprestitoAprobado;
	}

	public boolean isRequiereAello() {
		return requiereAello;
	}

	public void setRequiereAello(boolean requiereAello) {
		this.requiereAello = requiereAello;
	}

	public boolean isCumpleGranulometria() {
		return cumpleGranulometria;
	}

	public void setCumpleGranulometria(boolean cumpleGranulometria) {
		this.cumpleGranulometria = cumpleGranulometria;
	}

	public boolean isCumpleHumedad() {
		return cumpleHumedad;
	}

	public void setCumpleHumedad(boolean cumpleHumedad) {
		this.cumpleHumedad = cumpleHumedad;
	}

	public boolean isCumpleElevacion() {
		return cumpleElevacion;
	}

	public void setCumpleElevacion(boolean cumpleElevacion) {
		this.cumpleElevacion = cumpleElevacion;
	}

	public boolean isCapaLibreSobretamaños() {
		return capaLibreSobretamaños;
	}

	public void setCapaLibreSobretamaños(boolean capaLibreSobretamaños) {
		this.capaLibreSobretamaños = capaLibreSobretamaños;
	}

	public boolean isSobretamañoPretilesTaludes() {
		return sobretamañoPretilesTaludes;
	}

	public void setSobretamañoPretilesTaludes(boolean sobretamañoPretilesTaludes) {
		this.sobretamañoPretilesTaludes = sobretamañoPretilesTaludes;
	}

	public boolean isHumectacionMaterial() {
		return humectacionMaterial;
	}

	public void setHumectacionMaterial(boolean humectacionMaterial) {
		this.humectacionMaterial = humectacionMaterial;
	}

	public boolean isCompactacionCapa() {
		return compactacionCapa;
	}

	public void setCompactacionCapa(boolean compactacionCapa) {
		this.compactacionCapa = compactacionCapa;
	}

	public float getEspesorNominal() {
		return espesorNominal;
	}

	public void setEspesorNominal(float espesorNominal) {
		this.espesorNominal = espesorNominal;
	}

	public float getLargoCapa() {
		return largoCapa;
	}

	public void setLargoCapa(float largoCapa) {
		this.largoCapa = largoCapa;
	}

	public float getAnchoPromedioTeorico() {
		return anchoPromedioTeorico;
	}

	public void setAnchoPromedioTeorico(float anchoPromedioTeorico) {
		this.anchoPromedioTeorico = anchoPromedioTeorico;
	}

	public float getAnchoPromedioReal() {
		return anchoPromedioReal;
	}

	public void setAnchoPromedioReal(float anchoPromedioReal) {
		this.anchoPromedioReal = anchoPromedioReal;
	}

	public boolean isTerminacionUniforme() {
		return terminacionUniforme;
	}

	public void setTerminacionUniforme(boolean terminacionUniforme) {
		this.terminacionUniforme = terminacionUniforme;
	}

	public boolean isVeredicto() {
		return veredicto;
	}

	public void setVeredicto(boolean veredicto) {
		this.veredicto = veredicto;
	}
		
}

