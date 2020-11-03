package com.infinito.importadoraWeb.model;

public class Compra {

	private int idcomp,idusu,idemp,idpais,total,estado;
	private String num_compra,num_embarque,num_importacion,fecha_compra,fecha_importacion;
	
	Pais pais;
	public int getIdcomp() {
		return idcomp;
	}
	public void setIdcomp(int idcomp) {
		this.idcomp = idcomp;
	}
	
	public String getFecha_importacion() {
		return fecha_importacion;
	}
	public void setFecha_importacion(String fecha_importacion) {
		this.fecha_importacion = fecha_importacion;
	}
	public int getIdusu() {
		return idusu;
	}
	public void setIdusu(int idusu) {
		this.idusu = idusu;
	}
	public int getIdemp() {
		return idemp;
	}
	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}
	public int getIdpais() {
		return idpais;
	}
	public void setIdpais(int idpais) {
		this.idpais = idpais;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getNum_compra() {
		return num_compra;
	}
	public void setNum_compra(String num_compra) {
		this.num_compra = num_compra;
	}
	public String getNum_embarque() {
		return num_embarque;
	}
	public void setNum_embarque(String num_embarque) {
		this.num_embarque = num_embarque;
	}
	public String getNum_importacion() {
		return num_importacion;
	}
	public void setNum_importacion(String num_importacion) {
		this.num_importacion = num_importacion;
	}
	public String getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(String fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	@Override
	public String toString() {
		return "Compra [idcomp=" + idcomp + ", idusu=" + idusu + ", idemp=" + idemp + ", idpais=" + idpais + ", total="
				+ total + ", estado=" + estado + ", num_compra=" + num_compra + ", num_embarque=" + num_embarque
				+ ", num_importacion=" + num_importacion + ", fecha_compra=" + fecha_compra + ", fecha_importacion="
				+ fecha_importacion + "]";
	}
	public Compra(int idcomp, int idusu, int idemp, int idpais, int total, int estado, String num_compra,
			String num_embarque, String num_importacion, String fecha_compra, String fecha_importacion) {
		super();
		this.idcomp = idcomp;
		this.idusu = idusu;
		this.idemp = idemp;
		this.idpais = idpais;
		this.total = total;
		this.estado = estado;
		this.num_compra = num_compra;
		this.num_embarque = num_embarque;
		this.num_importacion = num_importacion;
		this.fecha_compra = fecha_compra;
		this.fecha_importacion = fecha_importacion;
	}
	public Compra() {

	}

	
	
}
