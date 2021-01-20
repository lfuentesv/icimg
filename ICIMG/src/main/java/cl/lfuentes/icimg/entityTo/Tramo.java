package cl.lfuentes.icimg.entityTo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tramo {
	
	@Id
	private Integer id;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Capa codCapa;
	private Integer kmInicio;
	private Integer kmTermino;

	public Tramo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Capa getCodCapa() {
		return codCapa;
	}

	public void setCodCapa(Capa codCapa) {
		this.codCapa = codCapa;
	}

	public Integer getKmInicio() {
		return kmInicio;
	}

	public void setKmInicio(Integer kmInicio) {
		this.kmInicio = kmInicio;
	}

	public Integer getKmTermino() {
		return kmTermino;
	}

	public void setKmTermino(Integer kmTermino) {
		this.kmTermino = kmTermino;
	}

}
