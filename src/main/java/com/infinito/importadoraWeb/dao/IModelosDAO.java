package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;


import com.infinito.importadoraWeb.model.Modelo;

public interface IModelosDAO {


	public List<Map<String, Object>> ListaModelos(int start,int estado, String search, int length);
	public Modelo obtener(int id);
	
	
	public boolean adicionar(Modelo mod);
	public boolean modificar(Modelo mod);
	public boolean eliminar(int idmod,int estado);
	public Modelo obtenernombre(int id);
	public List<Modelo> ListaModelos1();
	public List<Modelo> ListaModelos(int idmarc);
	public Modelo getModelo(int idmod);
	public List<Modelo> listarporItemIdMarca(int idmarc);
}
