package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;

import com.infinito.importadoraWeb.model.Categoria;


public interface ICategoriaDAO {


	public List<Map<String, Object>> ListaCategorias(int start,int estado, String search, int length);
	public Categoria obtener(int id);
	
	
	public boolean adicionar(Categoria cat);
	public boolean modificar(Categoria cat);
	public boolean eliminar(int idcat,int estado);
	public Categoria obtenernombre(int id);
	public List<Categoria> ListaCategorias1();
	public Categoria getcategoria(int idcate);
}
