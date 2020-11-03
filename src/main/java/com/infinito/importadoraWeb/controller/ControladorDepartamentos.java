package com.infinito.importadoraWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"/Dpto"})
public class ControladorDepartamentos {

	@RequestMapping(value={"/gestion"}, method = RequestMethod.POST)
	public String init(Model model) {
		System.out.println("aqui");
		return "/dpto/gestion";
	}
	

}
