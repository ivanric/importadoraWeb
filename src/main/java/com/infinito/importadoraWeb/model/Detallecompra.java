package com.infinito.importadoraWeb.model;

import com.infinito.importadoraWeb.model.Articulo;
import com.infinito.importadoraWeb.model.Itemalmacen;;

public class Detallecompra {
	
	private int iddcomp,idart,idcomp,iditemalm;
	private float precio,cantidad,sub_total;
	Articulo articulo;
	Itemalmacen itemalmacen;

	public int getIddcomp() {
		return iddcomp;
	}

	public void setIddcomp(int iddcomp) {
		this.iddcomp = iddcomp;
	}

	public int getIdart() {
		return idart;
	}

	public void setIdart(int idart) {
		this.idart = idart;
	}

	public int getIdcomp() {
		return idcomp;
	}

	public void setIdcomp(int idcomp) {
		this.idcomp = idcomp;
	}

	public int getIditemalm() {
		return iditemalm;
	}

	public void setIditemalm(int iditemalm) {
		this.iditemalm = iditemalm;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public float getSub_total() {
		return sub_total;
	}

	public void setSub_total(float sub_total) {
		this.sub_total = sub_total;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Itemalmacen getItemalmacen() {
		return itemalmacen;
	}

	public void setItemalmacen(Itemalmacen itemalmacen) {
		this.itemalmacen = itemalmacen;
	}

	@Override
	public String toString() {
		return "Detallecompra [iddcompra=" + iddcomp + ", idart=" + idart + ", idcomp=" + idcomp + ", iditemalm="
				+ iditemalm + ", precio=" + precio + ", cantidad=" + cantidad + ", sub_total=" + sub_total
				+ ", articulo=" + articulo + ", itemalmacen=" + itemalmacen + "]";
	}

	public Detallecompra(int iddcomp, int idart, int idcomp, int iditemalm, float precio, float cantidad,
			float sub_total, Articulo articulo, Itemalmacen itemalmacen) {
		super();
		this.iddcomp = iddcomp;
		this.idart = idart;
		this.idcomp = idcomp;
		this.iditemalm = iditemalm;
		this.precio = precio;
		this.cantidad = cantidad;
		this.sub_total = sub_total;
		this.articulo = articulo;
		this.itemalmacen = itemalmacen;
	}

	public Detallecompra() {
		
	}

	
	
}
