package com.infinito.importadoraWeb.model;

public class Color {
	
	private int idcolor,estado;
	private String nombre;
	public int getIdcolor() {
		return idcolor;
	}
	public void setIdcolor(int idcolor) {
		this.idcolor = idcolor;
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
		return "Color [idcolor=" + idcolor + ", estado=" + estado + ", nombre=" + nombre + "]";
	}
	public Color(int idcolor, int estado, String nombre) {
		super();
		this.idcolor = idcolor;
		this.estado = estado;
		this.nombre = nombre;
	}
	public Color() {
	
	}
	
	
}
