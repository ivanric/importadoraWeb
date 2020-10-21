package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.IPaisDAO;
import com.infinito.importadoraWeb.model.Pais;
@Service
public class PaisesServiceImpl implements IPaisesService{

	
	@Autowired 
	private IPaisDAO paisDAO;
	
	@Override
	public List<Map<String, Object>> ListaPaises(int start,int estado, String search, int length) {
		return paisDAO.lista(start,estado,search,length);
	}

	@Override
	public Pais obtener(int id) {
		return paisDAO.obtener(id);
	}

}
