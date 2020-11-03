package com.infinito.importadoraWeb.model;

public class Marca {
	private int idmarc, estado;
	private String nombre;
	public int getIdmarc() {
		return idmarc;
	}
	public void setIdmarc(int idmarc) {
		this.idmarc = idmarc;
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
		return "Marca [idmarc=" + idmarc + ", estado=" + estado + ", nombre=" + nombre + "]";
	}
	public Marca(int idmarc, int estado, String nombre) {
		super();
		this.idmarc = idmarc;
		this.estado = estado;
		this.nombre = nombre;
	}
	public Marca() {
		
	}
	
}
