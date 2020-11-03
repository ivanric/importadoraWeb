package com.infinito.importadoraWeb.model;

public class Categoria {
	private int idcat, estado;
	private String nombre;
	
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
		return "Linea [idcategoria=" + idcat + ", estado=" + estado + ", nombre=" + nombre + "]";
	}
	public Categoria(int idcat, int estado, String nombre) {
		super();
		this.idcat = idcat;
		this.estado = estado;
		this.nombre = nombre;
	}
	public Categoria() {
	}
	
	
}
