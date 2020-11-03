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

import com.infinito.importadoraWeb.model.Pais;
import com.infinito.importadoraWeb.model.Provincia;
import com.infinito.importadoraWeb.service.IProvService;

@RestController
@RequestMapping(value={"/RestProv"})
public class RestProvincias {
	
	@Autowired
	private IProvService provservice;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/lista", method = RequestMethod.POST)
	public  Map<?, ?> lista(HttpServletRequest request, Integer draw,int length, Integer start, int estado)throws IOException{
		String total;
		System.out.println(" "+draw+" "+length+" "+start+" "+ estado);
		Map<String, Object> Data = new HashMap<String, Object>();
		String search = request.getParameter("search[value]");
		List<?> lista=provservice.ListaProvincia(start, estado, search, length);
		try {
			total=((Map<String, Object>) lista.get(0)).get("Tot").toString();			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			total="0";
		}
		System.out.println("ListaDpto:"+lista);
		Data.put("draw", draw);
		Data.put("recordsTotal", total);
		Data.put("data", lista);
		if(!search.equals(""))
			Data.put("recordsFiltered", lista.size());
		else
			Data.put("recordsFiltered", total);
		return Data;

	}
	
	@RequestMapping("/obtenerpais")
	public Map<String, Object> obtenerpais(HttpServletRequest request,int id){
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			Pais dpto=provservice.obtenerPais(id);
			Data.put("data", dpto);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		return Data;
	
	}
	/*
	@RequestMapping(value="/listar", method = RequestMethod.POST)
	public  Map<?, ?> lista2(HttpServletRequest request)throws IOException{
		
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			List<?> lista=dptoService.ListaDpto();
			System.out.println("ListaDpto:"+lista.toString());
			Data.put("data", lista);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status",false);
		} 
		return Data;

	}
	*/
	@RequestMapping("/obtener")
	public Map<String, Object> obtener(HttpServletRequest request,int id){
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			Provincia dpto=provservice.obtener(id);
			Data.put("data", dpto);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		return Data;
	
	}
	
	
	@RequestMapping("actualizar")
	public Map<String, Object> actualizar(HttpServletRequest request, Provincia prov)throws IOException{
		//Usuario user=(Usuario)request.getSession().getAttribute("user");
		Map<String, Object> Data = new HashMap<String, Object>();
		
			try {
				
				if(provservice.modificar(prov)){
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
	public Map<String, Object> guardar(HttpServletRequest request,int iddep,String nombre){
		//Pais user=(Pais)request.getSession().getAttribute("user");
		Map<String,Object> Data=new HashMap<>();
			try {			
				if(provservice.adicionar(nombre,iddep)){
					Data.put("status", true);
				}else{
					Data.put("status", false);
				}
			} catch (Exception e) {
				System.out.println("error al adicionar rol"+e.toString());
				Data.put("status", false);
			}
		return Data;
	}
	
	@RequestMapping("eliminar")
	public Map<String, Object> eliminar(HttpServletRequest request,int idprov)throws IOException{
		Map<String, Object> Data = new HashMap<String, Object>();
			if(provservice.eliminar(idprov, 0))
				Data.put("status", true);
			else 
				Data.put("status", false);
	
		return Data;
	}

	

}
