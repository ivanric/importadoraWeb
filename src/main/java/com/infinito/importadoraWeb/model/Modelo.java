package com.infinito.importadoraWeb.model;

public class Modelo {
	private int idmod, estado, idmarc, anho;
	private String nombre;
	
	Marca marca;

	public Modelo(int idmod, int estado, int idmarc, int anho, String nombre, Marca marca) {
		super();
		this.idmod = idmod;
		this.estado = estado;
		this.idmarc = idmarc;
		this.anho = anho;
		this.nombre = nombre;
		this.marca = marca;
	}

	public int getIdmod() {
		return idmod;
	}

	public void setIdmod(int idmod) {
		this.idmod = idmod;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getIdmarc() {
		return idmarc;
	}

	public void setIdmarc(int idmarc) {
		this.idmarc = idmarc;
	}

	public int getAnho() {
		return anho;
	}

	public void setAnho(int anho) {
		this.anho = anho;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo() {
		
	}

	@Override
	public String toString() {
		return "Modelo [idmod=" + idmod + ", estado=" + estado + ", idmarc=" + idmarc + ", anho=" + anho + ", nombre="
				+ nombre + ", marca=" + marca + "]";
	}
	
	
	
}
