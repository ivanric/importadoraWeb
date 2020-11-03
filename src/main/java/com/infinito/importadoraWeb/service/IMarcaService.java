package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;


import com.infinito.importadoraWeb.model.Marca;

public interface IMarcaService {


	public List<Map<String, Object>> ListaMarcas(int start,int estado, String search, int length);
	public Marca obtener(int id);
	
	
	public boolean adicionar(Marca marc);
	public boolean modificar(Marca marc);
	public boolean eliminar(int idmarc,int estado);
	public Marca obtenernombre(int id);
	public List<Marca> ListaMarcas1();
	public Marca obteneridmod(int id);
	public Marca getMarca(int idmarc);
	public Marca obtenerMarca(int id);
	public List<Marca> listaporitem();
	
}
