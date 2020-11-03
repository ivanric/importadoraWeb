package com.infinito.importadoraWeb.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinito.importadoraWeb.dao.IPaisDAO;
import com.infinito.importadoraWeb.dao.PaisDAOImpl;
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

	@Override
	public boolean adicionar(Pais pais) {
		return paisDAO.adicionar(pais);
	}

	@Override
	public boolean modificar(Pais pais) {
		
		return paisDAO.modificar(pais);
	}

	@Override
	public boolean eliminar(int idpais,int estado) {
		
		return paisDAO.eliminar(idpais, estado);
	}

	@Override
	public Pais obtenernombre(int id) {
		// TODO Auto-generated method stub
		return paisDAO.obtenernombre(id);
	}

	@Override
	public List<Map<String, Object>> ListaPaises() {
		// TODO Auto-generated method stub
		return paisDAO.lista();
	}

}
