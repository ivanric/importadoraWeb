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
@RequestMapping(value={"/Compras"})
public class ControladorCompras {

	
	@RequestMapping(value={"/compras"}, method = RequestMethod.POST)
	public String compras(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		Usuemp usu=(Usuemp) request.getSession().getAttribute("usu");
		if (usu!=null) {
			return "/Compras/compras";	
		}else{
			response.sendRedirect("/index");
			return "index";
		}
		
	}
}
