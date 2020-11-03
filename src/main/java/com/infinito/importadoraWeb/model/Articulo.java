package com.infinito.importadoraWeb.model;

import com.infinito.importadoraWeb.model.Item;;

public class Articulo {

	private int idart,iditem,estado,idestaitem;
	private String num_chasis,num_motor,num_serie,tamanio;
	
	Estadoitem estadoitem;
	Item item;
	public int getIdart() {
		return idart;
	}
	public void setIdart(int idart) {
		this.idart = idart;
	}
	public int getIditem() {
		return iditem;
	}
	public void setIditem(int iditem) {
		this.iditem = iditem;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getIdestaitem() {
		return idestaitem;
	}
	public void setIdestaitem(int idestaitem) {
		this.idestaitem = idestaitem;
	}
	public String getNum_chasis() {
		return num_chasis;
	}
	public void setNum_chasis(String num_chasis) {
		this.num_chasis = num_chasis;
	}
	public String getNum_motor() {
		return num_motor;
	}
	public void setNum_motor(String num_motor) {
		this.num_motor = num_motor;
	}
	public String getNum_serie() {
		return num_serie;
	}
	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}
	public String getTamanio() {
		return tamanio;
	}
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}
	public Estadoitem getEstadoitem() {
		return estadoitem;
	}
	public void setEstadoitem(Estadoitem estadoitem) {
		this.estadoitem = estadoitem;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Articulo(int idart, int iditem, int estado, int idestaitem, String num_chasis, String num_motor,
			String num_serie, String tamanio, Estadoitem estadoitem, Item item) {
		super();
		this.idart = idart;
		this.iditem = iditem;
		this.estado = estado;
		this.idestaitem = idestaitem;
		this.num_chasis = num_chasis;
		this.num_motor = num_motor;
		this.num_serie = num_serie;
		this.tamanio = tamanio;
		this.estadoitem = estadoitem;
		this.item = item;
	}
	public Articulo() {
		
	}
	@Override
	public String toString() {
		return "Articulo [idart=" + idart + ", iditem=" + iditem + ", estado=" + estado + ", idestaitem=" + idestaitem
				+ ", num_chasis=" + num_chasis + ", num_motor=" + num_motor + ", num_serie=" + num_serie + ", tamanio="
				+ tamanio + ", estadoitem=" + estadoitem + ", item=" + item + "]";
	}
	
}
