package com.infinito.importadoraWeb.model;

public class Persona {

		private int idper, ci,estado;
		private String nombres, apellidos,telefono, tipo;
		public int getIdper() {
			return idper;
		}
		public void setIdper(int idper) {
			this.idper = idper;
		}
		public int getCi() {
			return ci;
		}
		public void setCi(int ci) {
			this.ci = ci;
		}
		public int getEstado() {
			return estado;
		}
		public void setEstado(int estado) {
			this.estado = estado;
		}
		public String getNombres() {
			return nombres;
		}
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}
		public String getApellidos() {
			return apellidos;
		}
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public Persona(int idper, int ci, int estado, String nombres, String apellidos, String telefono, String tipo) {
			super();
			this.idper = idper;
			this.ci = ci;
			this.estado = estado;
			this.nombres = nombres;
			this.apellidos = apellidos;
			this.telefono = telefono;
			this.tipo = tipo;
		}
		public Persona() {
			
		}
		@Override
		public String toString() {
			return "Persona [idper=" + idper + ", ci=" + ci + ", estado=" + estado + ", nombres=" + nombres
					+ ", apellidos=" + apellidos + ", telefono=" + telefono + ", tipo=" + tipo + "]";
		}
		
		
		
}
