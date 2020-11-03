package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;


import com.infinito.importadoraWeb.model.Categoria;

public interface ICategoriaService {


	public List<Map<String, Object>> ListaCategoria(int start,int estado, String search, int length);
	public Categoria obtener(int id);
	
	
	public boolean adicionar(Categoria cat);
	public boolean modificar(Categoria cat);
	public boolean eliminar(int idcat,int estado);
	public Categoria obtenernombre(int id);
	public List<Categoria> ListaCategoria1();
	public Categoria getcategoria(int idcate);
}
