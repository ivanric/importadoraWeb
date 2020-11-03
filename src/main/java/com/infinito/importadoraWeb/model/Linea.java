package com.infinito.importadoraWeb.model;

public class Linea {
	private int idlinea, estado;
	private String nombre;
	public int getIdlinea() {
		return idlinea;
	}
	public void setIdlinea(int idlinea) {
		this.idlinea = idlinea;
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
		return "Linea [idlinea=" + idlinea + ", estado=" + estado + ", nombre=" + nombre + "]";
	}
	public Linea(int idlinea, int estado, String nombre) {
		super();
		this.idlinea = idlinea;
		this.estado = estado;
		this.nombre = nombre;
	}
	public Linea() {
	}
	
	
}
