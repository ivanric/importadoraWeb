package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.IItemDAO;
import com.infinito.importadoraWeb.model.Item;

@Service
public class ItemServiceImpl implements IItemService{

	@Autowired
	IItemDAO itemdao;
	
	@Override
	public List<Map<String, Object>> ListaItems(int start, int estado, int idemp, int length) {
		// TODO Auto-generated method stub
		return itemdao.ListaItems(start, estado, idemp, length);
	}

	@Override
	public Item obtener(int id) {
		// TODO Auto-generated method stub
		return itemdao.obtener(id);
	}

	@Override
	public boolean adicionar(Item item) {
		// TODO Auto-generated method stub
		return itemdao.adicionar(item);
	}

	@Override
	public boolean modificar(Item item) {
		// TODO Auto-generated method stub
		return itemdao.modificar(item);
	}

	@Override
	public boolean eliminar(int iditem, int estado) {
		// TODO Auto-generated method stub
		return itemdao.eliminar(iditem, estado);
	}

	@Override
	public List<Item> Listaitems1() {
		// TODO Auto-generated method stub
		return itemdao.Listaitems1();
	}

	@Override
	public Item getItem(int iditem) {
		// TODO Auto-generated method stub
		return itemdao.getItem(iditem);
	}

	@Override
	public Item obtenerpormodelocolor(Item item) {
		// TODO Auto-generated method stub
		return itemdao.obtenerpormodelocolor(item);
	}

}
