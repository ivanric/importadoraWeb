package com.infinito.importadoraWeb.model;

public class Estadoitem {

	private int idestaitem,idcat,estado;
	private String nombre;
	public int getIdestaitem() {
		return idestaitem;
	}
	public void setIdestaitem(int idestaitem) {
		this.idestaitem = idestaitem;
	}
	public int getIdcat() {
		return idcat;
	}
	public void setIdcat(int idcat) {
		this.idcat = idcat;
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
	@Override
	public String toString() {
		return "Estadoitem [idestaitem=" + idestaitem + ", idcat=" + idcat + ", estado=" + estado + ", nombre=" + nombre
				+ "]";
	}
	public Estadoitem(int idestaitem, int idcat, int estado, String nombre) {
		super();
		this.idestaitem = idestaitem;
		this.idcat = idcat;
		this.estado = estado;
		this.nombre = nombre;
	}
	public Estadoitem() {
		
	}
	
	
}
