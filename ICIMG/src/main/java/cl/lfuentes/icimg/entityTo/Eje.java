package cl.lfuentes.icimg.entityTo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Eje {
	
	@Id
	private String codigo;
	private String nombre;

	public Eje() {
	}

	public Eje(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
