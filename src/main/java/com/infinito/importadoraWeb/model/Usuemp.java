package com.infinito.importadoraWeb.model;

public class Usuemp {

	private int idusu,idemp,habilitado,idusuemp;
	
	//Usuario user;
	//Empresa empresa; 

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

	public int getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(int habilitado) {
		this.habilitado = habilitado;
	}

	public int getIdusuemp() {
		return idusuemp;
	}

	public void setIdusuemp(int idusuemp) {
		this.idusuemp = idusuemp;
	}

	public Usuemp(int idusu, int idemp, int habilitado, int idusuemp) {
		super();
		this.idusu = idusu;
		this.idemp = idemp;
		this.habilitado = habilitado;
		this.idusuemp = idusuemp;
	}

	public Usuemp() {
	
	}

	@Override
	public String toString() {
		return "Usuemp [idusu=" + idusu + ", idemp=" + idemp + ", habilitado=" + habilitado + ", idusuemp=" + idusuemp
				+ "]";
	}
	
	
}
