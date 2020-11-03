package com.infinito.importadoraWeb.model;

public class Item {
	private int iditem, idmod,idcolor,idcat,idusu,idemp,idlinea,disponible;
	
	Modelo modelo;
	Color color;
	Categoria categoria;
	Linea linea;
	public int getIditem() {
		return iditem;
	}
	public void setIditem(int iditem) {
		this.iditem = iditem;
	}
	public int getIdmod() {
		return idmod;
	}
	public void setIdmod(int idmod) {
		this.idmod = idmod;
	}
	public int getIdcolor() {
		return idcolor;
	}
	public void setIdcolor(int idcolor) {
		this.idcolor = idcolor;
	}
	public int getIdcat() {
		return idcat;
	}
	public void setIdcat(int idcat) {
		this.idcat = idcat;
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
	public int getIdlinea() {
		return idlinea;
	}
	public void setIdlinea(int idlinea) {
		this.idlinea = idlinea;
	}
	public int getDisponible() {
		return disponible;
	}
	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Linea getLinea() {
		return linea;
	}
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	public Item(int iditem, int idmod, int idcolor, int idcat, int idusu, int idemp, int idlinea, int disponible,
			Modelo modelo, Color color, Categoria categoria, Linea linea) {
		super();
		this.iditem = iditem;
		this.idmod = idmod;
		this.idcolor = idcolor;
		this.idcat = idcat;
		this.idusu = idusu;
		this.idemp = idemp;
		this.idlinea = idlinea;
		this.disponible = disponible;
		this.modelo = modelo;
		this.color = color;
		this.categoria = categoria;
		this.linea = linea;
	}
	public Item() {
		
	}
	@Override
	public String toString() {
		return "Item [iditem=" + iditem + ", idmod=" + idmod + ", idcolor=" + idcolor + ", idcat=" + idcat + ", idusu="
				+ idusu + ", idemp=" + idemp + ", idlinea=" + idlinea + ", disponible=" + disponible + ", modelo="
				+ modelo + ", color=" + color + ", categoria=" + categoria + ", linea=" + linea + "]";
	}
	
	
	
}
