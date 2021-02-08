package cl.lfuentes.icimg.requestTO;

public class TramoRTO {
	
	private Integer id;
	private String codCapa;
	private Integer kmInicio;
	private Integer kmTermino;

	public TramoRTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodCapa() {
		return codCapa;
	}

	public void setCodCapa(String codCapa) {
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
