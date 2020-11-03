package com.infinito.importadoraWeb.restController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infinito.importadoraWeb.model.Compra;
import com.infinito.importadoraWeb.model.Item;
import com.infinito.importadoraWeb.model.Usuemp;
import com.infinito.importadoraWeb.service.IItemService;

@RestController
@RequestMapping(value={"/RestItem"})
public class RestItem {
	
	@Autowired
	private IItemService itService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/lista", method = RequestMethod.POST)
	public  Map<?, ?> lista(HttpServletRequest request, Integer draw,int length, Integer start, int disponible)throws IOException{
		String total;
		Map<String, Object> Data = new HashMap<String, Object>();
		Usuemp usu=(Usuemp) request.getSession().getAttribute("usu");
		
		int idemp= usu.getIdemp();
		System.out.println(idemp);
		List<?> lista=itService.ListaItems(start, disponible, idemp,length);
		try {
			total=((Map<String, Object>) lista.get(0)).get("Tot").toString();			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			total="0";
		}
		System.out.println("ListaPaises:"+lista.toString());
		Data.put("draw", draw);
		Data.put("recordsTotal", total);
		Data.put("data", lista);
		Data.put("recordsFiltered", lista.size());
		
		return Data;

	}
	
	@RequestMapping(value="/listar", method = RequestMethod.POST)
	public  Map<?, ?> lista2(HttpServletRequest request)throws IOException{
		
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			List<?> lista=itService.Listaitems1();
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
			Item it=itService.obtener(id);
			Data.put("data", it);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		return Data;
	
	}
	
	@RequestMapping("/obtenerdesdeC")
	public Map<String, Object> obtenerdesdeC(HttpServletRequest request,Item item ,Compra com,boolean estad,int idcom){
		Map<String, Object> Data = new HashMap<String, Object>();
		Usuemp usu=(Usuemp) request.getSession().getAttribute("usu");
		System.out.println(item);
		//System.out.println(com);
		System.out.println(estad);
		//Data.put("status", true);
		com.setIdcomp(idcom);
		try {
			Item it=itService.obtenerpormodelocolor(item);
			Data.put("data", it);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		if(com.getIdcomp()==0) {
			com.setIdusu(usu.getIdusu());
			com.setIdemp(usu.getIdemp());
			Date fecha=new Date();
			com.setFecha_compra(new SimpleDateFormat("yyyy-MM-dd").format(fecha));
			System.out.println(com);
			Data.put("data2", com);
		}else {
			Data.put("data2", com);
		}
			
		return Data;
	
	}
	
	
	@RequestMapping("actualizar")
	public Map<String, Object> actualizar(HttpServletRequest request,Model model, Item it)throws IOException{
		//Usuario user=(Usuario)request.getSession().getAttribute("user");
		Usuemp usu=(Usuemp) request.getSession().getAttribute("usu");
		it.setIdcat(1);
		it.setIdusu(usu.getIdusu());
		it.setIdemp(usu.getIdemp());
		Map<String, Object> Data = new HashMap<String, Object>();
		
			try {
				System.out.println(it);
				if(itService.modificar(it)){
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
	public Map<String, Object> guardar(HttpServletRequest request,Item it){
		//Pais user=(Pais)request.getSession().getAttribute("user");
		System.out.println(it);
		Usuemp usu=(Usuemp) request.getSession().getAttribute("usu");
		it.setIdcat(1);
		it.setIdusu(usu.getIdusu());
		it.setIdemp(usu.getIdemp());
		Map<String,Object> Data=new HashMap<>();
			try {
				System.out.println(it);
				if(itService.adicionar(it)){
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
	public Map<String, Object> eliminar(HttpServletRequest request,Model model,int iditem)throws IOException{
		Map<String, Object> Data = new HashMap<String, Object>();
			if(itService.eliminar(iditem, 0))
				Data.put("status", true);
			else 
				Data.put("status", false);
	
		return Data;
	}

	

}
