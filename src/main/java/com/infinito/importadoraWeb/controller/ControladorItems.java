package com.infinito.importadoraWeb.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infinito.importadoraWeb.model.Usuemp;

@Controller
@RequestMapping(value={"/Items"})
public class ControladorItems {

	@RequestMapping(value={"/colores/gestion"}, method = RequestMethod.POST)
	public String init(Model model,HttpServletRequest request) {
		return "/Items/gestioncolores";
	}
	

	@RequestMapping(value={"/categorias/gestion"}, method = RequestMethod.POST)
	public String categorias(Model model,HttpServletRequest request) {
		return "/Items/gestioncategorias";
	}
	
	@RequestMapping(value={"/lineas/gestion"}, method = RequestMethod.POST)
	public String linea(Model model,HttpServletRequest request) {
		return "/Items/gestionlinea";
	}
	
	@RequestMapping(value={"/marcas/gestion"}, method = RequestMethod.POST)
	public String marca(Model model,HttpServletRequest request) {
		return "/Items/gestionmarca";
	}
	
	@RequestMapping(value={"/modelos/gestion"}, method = RequestMethod.POST)
	public String model(Model model,HttpServletRequest request) {
		return "/Items/gestionmodelo";
	}
	@RequestMapping(value={"/gestion"}, method = RequestMethod.POST)
	public String items(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		Usuemp usu=(Usuemp) request.getSession().getAttribute("usu");
		if (usu!=null) {
			return "/Items/gestion";	
		}else{
			response.sendRedirect("/index");
			return "index";
		}
		
	}
}