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

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.infinito.importadoraWeb.model.Marca;
import com.infinito.importadoraWeb.model.Modelo;
import com.infinito.importadoraWeb.service.IMarcaService;
import com.infinito.importadoraWeb.service.IModeloService;

@RestController
@RequestMapping(value={"/RestMod"})
public class RestModelo {
	
	@Autowired
	private IModeloService modservice;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/lista", method = RequestMethod.POST)
	public  Map<?, ?> lista(HttpServletRequest request, Integer draw,int length, Integer start, int estado)throws IOException{	
		String total;
		Map<String, Object> Data = new HashMap<String, Object>();
		String search = request.getParameter("search[value]");
		List<?> lista=modservice.ListaModelos(start, estado, search, length);
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
			List<Modelo> lista=modservice.ListaModelos1();
			System.out.println("Listamodleos:"+lista.toString());
			Data.put("data", lista);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status",false);
		} 
		return Data;

	}
	@RequestMapping(value="/listarporItemIdMarca", method = RequestMethod.POST)
	public  Map<?, ?> listarporItemIdMarca(HttpServletRequest request,Integer idmarc)throws IOException{
		
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			List<Modelo> lista=modservice.listarporItemIdMarca(idmarc);
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
			Modelo mod=modservice.obtener(id);
			Data.put("data", mod);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		return Data;
	
	}
	
	
	@RequestMapping("actualizar")
	public Map<String, Object> actualizar(HttpServletRequest request, Modelo mod)throws IOException{
		//Usuario user=(Usuario)request.getSession().getAttribute("user");
		Map<String, Object> Data = new HashMap<String, Object>();
		
			try {
				
				if(modservice.modificar(mod)){
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
	public Map<String, Object> guardar(HttpServletRequest request,Modelo mod){
		//Pais user=(Pais)request.getSession().getAttribute("user");
		Map<String,Object> Data=new HashMap<>();
		
			try {			
				if(modservice.adicionar(mod)){
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
	public Map<String, Object> eliminar(HttpServletRequest request,int idmod)throws IOException{
		Map<String, Object> Data = new HashMap<String, Object>();
			if(modservice.eliminar(idmod, 0))
				Data.put("status", true);
			else 
				Data.put("status", false);
	
		return Data;
	}
	
	@RequestMapping(value="/listaridmarc", method = RequestMethod.POST)
	public  Map<?, ?> lista3(HttpServletRequest request,Integer idmarc)throws IOException{
		
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			List<Modelo> lista=modservice.ListaModelos(idmarc);
			System.out.println("ListaDpto:"+lista.toString());
			Data.put("data", lista);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status",false);
		} 
		return Data;

	}
}