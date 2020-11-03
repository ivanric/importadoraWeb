package com.infinito.importadoraWeb.model;

public class Provincia {
	
	private int idprov,estado,iddep;
	private String nombre;
	Departamento departamento;
	public int getIdprov() {
		return idprov;
	}
	public void setIdprov(int idprov) {
		this.idprov = idprov;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getIddep() {
		return iddep;
	}
	public void setIddep(int iddep) {
		this.iddep = iddep;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Provincia(int idprov, int estado, int iddep, String nombre) {
		super();
		this.idprov = idprov;
		this.estado = estado;
		this.iddep = iddep;
		this.nombre = nombre;
	}
	public Provincia() {
		
	}
	@Override
	public String toString() {
		return "Provincia [idprov=" + idprov + ", estado=" + estado + ", iddep=" + iddep + ", nombre=" + nombre + "]";
	}
	
	

}
