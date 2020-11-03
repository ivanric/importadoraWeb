package com.infinito.importadoraWeb.model;


public class Departamento {

	private int idpais,iddep,estado;
	private String 	nombre, abrevacion;
	Pais pais;
	public int getIdpais() {
		return idpais;
	}
	public void setIdpais(int idpais) {
		this.idpais = idpais;
	}
	public int getIddep() {
		return iddep;
	}
	public void setIddep(int iddep) {
		this.iddep = iddep;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAbrevacion() {
		return abrevacion;
	}
	public void setAbrevacion(String abrevacion) {
		this.abrevacion = abrevacion;
	}
	public Departamento(int idpais, int iddep, int estado, String nombre, String abrevacion) {
		super();
		this.idpais = idpais;
		this.iddep = iddep;
	
		this.estado = estado;
		this.nombre = nombre;
		this.abrevacion = abrevacion;
	}
	public Departamento() {


	}
	@Override
	public String toString() {
		return "Departamento [idpais=" + idpais + ", iddep=" + iddep + ", estado=" + estado
				+ ", nombre=" + nombre + ", abrevacion=" + abrevacion + "]";
	}
	
	
	
}
