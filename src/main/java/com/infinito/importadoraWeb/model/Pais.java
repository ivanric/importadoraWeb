package com.infinito.importadoraWeb.model;

public class Pais {
	private int idpais;
	private String codigo;
	private String nombre;
	private int estado;
	public Pais() {
		
	}
	public Pais(int idpais, String codigo, String nombre, int estado) {
		super();
		this.idpais = idpais;
		this.codigo = codigo;
		this.nombre = nombre;
		this.estado = estado;
	}
	public int getIdpais() {
		return idpais;
	}
	public void setIdpais(int idpais) {
		this.idpais = idpais;
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
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Pais [idpais=" + idpais + ", codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
	
	
}
