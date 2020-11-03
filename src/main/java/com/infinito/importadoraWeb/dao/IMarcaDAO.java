package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;


import com.infinito.importadoraWeb.model.Marca;

public interface IMarcaDAO {


	public List<Map<String, Object>> ListaMarca(int start,int estado, String search, int length);
	public Marca obtener(int id);
	
	
	public boolean adicionar(Marca marca);
	public boolean modificar(Marca marca);
	public boolean eliminar(int idmarc,int estado);
	public Marca obtenernombre(int id);
	public List<Marca> ListaMarcas1();
	public Marca obteneridmod(int id);
	public Marca getMarca(int idmarc);
	public List<Marca> listaporitem();
}
