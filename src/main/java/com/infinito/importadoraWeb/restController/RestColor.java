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

import com.infinito.importadoraWeb.model.Color;

import com.infinito.importadoraWeb.service.IColorService;


@RestController
@RequestMapping(value={"/Restcol"})
public class RestColor {
	
	@Autowired
	private IColorService colservice;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/lista", method = RequestMethod.POST)
	public  Map<?, ?> lista(HttpServletRequest request, Integer draw,int length, Integer start, int estado)throws IOException{
		System.out.println("aqui1"+draw+" "+length+" "+length+" "+start+" "+ estado);
		String total;
		System.out.println(" "+draw+" "+length+" "+start+" "+ estado);
		Map<String, Object> Data = new HashMap<String, Object>();
		String search = request.getParameter("search[value]");
		List<?> lista=colservice.ListaColores(start, estado, search, length);
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
			List<?> lista=colservice.ListaColores();
			System.out.println("Listacolores:"+lista.toString());
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
			Color col=colservice.obtener(id);
			Data.put("data", col);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		return Data;
	
	}
	
	
	@RequestMapping("actualizar")
	public Map<String, Object> actualizar(HttpServletRequest request, Color color)throws IOException{
		//Usuario user=(Usuario)request.getSession().getAttribute("user");
		Map<String, Object> Data = new HashMap<String, Object>();
		
			try {
				
				if(colservice.modificar(color)){
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
	public Map<String, Object> guardar(HttpServletRequest request,Color color){
		//Pais user=(Pais)request.getSession().getAttribute("user");
		Map<String,Object> Data=new HashMap<>();
			try {			
				if(colservice.adicionar(color)){
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
	public Map<String, Object> eliminar(HttpServletRequest request,int idcolor)throws IOException{
		Map<String, Object> Data = new HashMap<String, Object>();
			if(colservice.eliminar(idcolor, 0))
				Data.put("status", true);
			else 
				Data.put("status", false);
	
		return Data;
	}

	
	@RequestMapping(value="/listarporItemIdMod", method = RequestMethod.POST)
	public  Map<?, ?> listarporItemIdColor(HttpServletRequest request,int idmod)throws IOException{
		
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			List<?> lista=colservice.listarporItemIdColor(idmod);
			Data.put("data", lista);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status",false);
		} 
		return Data;

	}
	
	
}
