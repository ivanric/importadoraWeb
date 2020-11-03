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


import com.infinito.importadoraWeb.model.Marca;

import com.infinito.importadoraWeb.service.IMarcaService;

@RestController
@RequestMapping(value={"/RestMarc"})
public class RestMarca {
	
	@Autowired
	private IMarcaService marcservice;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/lista", method = RequestMethod.POST)
	public  Map<?, ?> lista(HttpServletRequest request, Integer draw,int length, Integer start, int estado)throws IOException{
		System.out.println("aqui1"+draw+" "+length+" "+length+" "+start+" "+ estado);
		String total;
		System.out.println(" "+draw+" "+length+" "+start+" "+ estado);
		Map<String, Object> Data = new HashMap<String, Object>();
		String search = request.getParameter("search[value]");
		List<?> lista=marcservice.ListaMarcas(start, estado, search, length);
		try {
			total=((Map<String, Object>) lista.get(0)).get("Tot").toString();			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			total="0";
		}
		Data.put("draw", draw);
		Data.put("recordsTotal", total);
		Data.put("data", lista);
		if(!search.equals(""))
			Data.put("recordsFiltered", lista.size());
		else
			Data.put("recordsFiltered", total);
		return Data;

	}
	@RequestMapping(value="/listar", method = RequestMethod.POST)
	public  Map<?, ?> lista2(HttpServletRequest request)throws IOException{
		
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			List<?> lista=marcservice.ListaMarcas1();
			Data.put("data", lista);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status",false);
		} 
		return Data;

	}

	@RequestMapping("/obtener")
	public Map<String, Object> obtener(HttpServletRequest request,int id){
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			Marca marc=marcservice.obtener(id);
			Data.put("data", marc);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		return Data;
	
	}

	@RequestMapping("/obtenerporidmodelo")
	public Map<String, Object> obteneridmod(HttpServletRequest request,int id){
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			Marca marc=marcservice.obteneridmod(id);
			Data.put("data", marc);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		return Data;
	
	}
	
	@RequestMapping("actualizar")
	public Map<String, Object> actualizar(HttpServletRequest request, Marca marc)throws IOException{
		//Usuario user=(Usuario)request.getSession().getAttribute("user");
		Map<String, Object> Data = new HashMap<String, Object>();
		
			try {
				
				if(marcservice.modificar(marc)){
					Data.put("status", true);
				}else{
					Data.put("status", false);
				}
			}catch(Exception e){
				System.out.println("error al modificar"+e.toString());
				Data.put("status", false);
			}
		return Data;		
	}
	
	@RequestMapping("/guardar")
	public Map<String, Object> guardar(HttpServletRequest request,Marca marc){
		//Pais user=(Pais)request.getSession().getAttribute("user");
		Map<String,Object> Data=new HashMap<>();
			try {			
				if(marcservice.adicionar(marc)){
					Data.put("status", true);
				}else{
					Data.put("status", false);
				}
			} catch (Exception e) {
				System.out.println("error al adicionar "+e.toString());
				Data.put("status", false);
			}
		return Data;
	}
	
	@RequestMapping("eliminar")
	public Map<String, Object> eliminar(HttpServletRequest request,int idmarc)throws IOException{
		Map<String, Object> Data = new HashMap<String, Object>();
			if(marcservice.eliminar(idmarc, 0))
				Data.put("status", true);
			else 
				Data.put("status", false);
	
		return Data;
	}
	
	@RequestMapping(value="/listarporitem", method = RequestMethod.POST)
	public  Map<?, ?> listarporitem(HttpServletRequest request)throws IOException{
		
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			List<?> lista=marcservice.listaporitem();
			Data.put("data", lista);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status",false);
		} 
		return Data;

	}
}