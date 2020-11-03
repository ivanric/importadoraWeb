package com.infinito.importadoraWeb.restController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infinito.importadoraWeb.model.Estadoitem;
import com.infinito.importadoraWeb.model.Modelo;
import com.infinito.importadoraWeb.service.IEstadoItemService;

@RestController
@RequestMapping(value={"/RestEitem"})
public class RestEstadoItem {
	
	@Autowired
	IEstadoItemService estitemserv;
	
	@RequestMapping(value="/listar", method = RequestMethod.POST)
	public  Map<?, ?> lista2(HttpServletRequest request)throws IOException{
		
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			List<Estadoitem> lista=estitemserv.listar();
			Data.put("data", lista);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status",false);
		} 
		return Data;

	}

}
