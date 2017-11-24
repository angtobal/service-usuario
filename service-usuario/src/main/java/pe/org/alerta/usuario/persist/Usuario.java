package pe.org.alerta.usuario.persist;

import org.springframework.data.annotation.Id;

public class Usuario {
	@Id
	private String id;
	private String IMEI;
	private String nombre;
	private String celular;
	private Espacial espacial;
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Espacial getEspacial() {
		return espacial;
	}
	public void setEspacial(Espacial espacial) {
		this.espacial = espacial;
	}
		
}

