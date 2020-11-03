package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;

import com.infinito.importadoraWeb.model.Item;

public interface IItemDAO {
	
	public List<Map<String, Object>> ListaItems(int start,int estado, int idemp, int length);
	public Item obtener(int id);
	public boolean adicionar(Item item);
	public boolean modificar(Item item);
	public boolean eliminar(int iditem,int estado);
	public List<Item> Listaitems1();
	public Item getItem(int iditem);
	public Item obtenerpormodelocolor(Item item);
}
