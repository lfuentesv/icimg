package cl.lfuentes.icimg.entityTo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tramo {
	
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Capa codCapa;
	private Integer kmInicio;
	private Integer kmTermino;

	public Tramo() {
	}

	public Tramo(Integer id2, Integer kmInicio2, Integer kmTermino2 ) {
		this.id =id2;
		this.kmInicio = kmInicio2;
		this.kmTermino = kmTermino2;
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
