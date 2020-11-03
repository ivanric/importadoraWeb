package com.infinito.importadoraWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"/Prov"})
public class ControladorProvincia {
	
	@RequestMapping(value={"/gestion"}, method = RequestMethod.POST)
	public String init(Model model) {
		return "/provincia/gestion";
	}
	
}