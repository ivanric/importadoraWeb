package com.infinito.importadoraWeb.model;

public class Itemalmacen {

	private int iditemalm,cantidad_item,idemp,idart,disponible,armadoitem;

	public int getIditemalm() {
		return iditemalm;
	}

	public void setIditemalm(int iditemalm) {
		this.iditemalm = iditemalm;
	}

	public int getCantidad_item() {
		return cantidad_item;
	}

	public void setCantidad_item(int cantidad_item) {
		this.cantidad_item = cantidad_item;
	}

	public int getIdemp() {
		return idemp;
	}

	public void setIdemp(int idemp) {
		this.idemp = idemp;
	}

	public int getIdart() {
		return idart;
	}

	public void setIdart(int idart) {
		this.idart = idart;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}

	public int getArmadoitem() {
		return armadoitem;
	}

	public void setArmadoitem(int armadoitem) {
		this.armadoitem = armadoitem;
	}

	@Override
	public String toString() {
		return "Itemalmacen [iditemalm=" + iditemalm + ", cantidad_item=" + cantidad_item + ", idemp=" + idemp
				+ ", idart=" + idart + ", disponible=" + disponible + ", armadoitem=" + armadoitem + "]";
	}

	public Itemalmacen(int iditemalm, int cantidad_item, int idemp, int idart, int disponible, int armadoitem) {
		super();
		this.iditemalm = iditemalm;
		this.cantidad_item = cantidad_item;
		this.idemp = idemp;
		this.idart = idart;
		this.disponible = disponible;
		this.armadoitem = armadoitem;
	}

	public Itemalmacen() {
	
	}
	
	
}
