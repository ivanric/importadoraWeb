package com.infinito.importadoraWeb.dao;

import com.infinito.importadoraWeb.model.Articulo;

public interface IArticuloDAO {

	public Articulo getArticulo(int idart);

	public Articulo obtenerArt(int idart);

	public boolean validarexistenciachasis(String validar);

	public boolean validarexistenciamotor(String validar);
}
