package com.infinito.importadoraWeb.model;

public class Usuario {
	private int udusu,estado,idper;
	private String iduserfire,tipo,password,mail;
	public int getUdusu() {
		return udusu;
	}
	public void setUdusu(int udusu) {
		this.udusu = udusu;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getIdper() {
		return idper;
	}
	public void setIdper(int idper) {
		this.idper = idper;
	}
	public String getIduserfire() {
		return iduserfire;
	}
	public void setIduserfire(String iduserfire) {
		this.iduserfire = iduserfire;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Usuario(int udusu, int estado, int idper, String iduserfire, String tipo, String password, String mail) {
		super();
		this.udusu = udusu;
		this.estado = estado;
		this.idper = idper;
		this.iduserfire = iduserfire;
		this.tipo = tipo;
		this.password = password;
		this.mail = mail;
	}
	public Usuario() {
		
	}
	@Override
	public String toString() {
		return "Usuario [udusu=" + udusu + ", estado=" + estado + ", idper=" + idper + ", iduserfire=" + iduserfire
				+ ", tipo=" + tipo + ", password=" + password + ", mail=" + mail + "]";
	}
	
	
}
