package com.infinito.importadoraWeb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;





//@RequestMapping("/principal/")
@Controller
public class Controlador {

	
	@RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
	public String init(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/inicio", method = RequestMethod.GET)
	public String inicio(HttpServletRequest request){
		return "inicio";
	}
	
	@RequestMapping({"/desconectar"})
	public String desc(Model m,HttpServletRequest req,HttpServletResponse res){
		return "redirect:index";
	}
	

	
	

	
	
}