package com.infinito.importadoraWeb.restController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestLogin {
	@RequestMapping(value="/validar", method = RequestMethod.GET)
	public Map<String,Object> inicio(HttpServletRequest request){
		Map<String,Object> respuesta=new HashMap<String, Object>();
		respuesta.put("status", true);
		return respuesta;
	}
	
	
	@RequestMapping(value="/mostrarVista", method = RequestMethod.GET)
	public String mostrarV(HttpServletRequest request){
		return "index";
	}
	
	
	@RequestMapping(value="/dataC", method = RequestMethod.POST)
	public String data(HttpServletRequest request){
		System.out.println("llego");
		return "index";
	}
	
}
