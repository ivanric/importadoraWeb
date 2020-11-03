package com.infinito.importadoraWeb.service;

import com.infinito.importadoraWeb.model.Articulo;

public interface IArticuloService {

	public Articulo getArticulo(int idart);
	public Articulo obtenerArt(int idart);
	public boolean validarexistenciachasis(String validar);
	public boolean validarexistenciamotor(String validar);
}
