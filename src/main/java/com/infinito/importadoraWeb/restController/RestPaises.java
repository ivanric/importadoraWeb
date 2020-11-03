package com.infinito.importadoraWeb.restController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infinito.importadoraWeb.model.Pais;
import com.infinito.importadoraWeb.service.IPaisesService;


@RestController
@RequestMapping(value={"/RestPaises"})
public class RestPaises {
	
	@Autowired
	private IPaisesService paisesService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/lista", method = RequestMethod.POST)
	public  Map<?, ?> lista(HttpServletRequest request, Integer draw,int length, Integer start, int estado)throws IOException{
		System.out.println("llego");
		String total;
		Map<String, Object> Data = new HashMap<String, Object>();
		String search = request.getParameter("search[value]");
		List<?> lista=paisesService.ListaPaises(start, estado, search,length);
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
			List<?> lista=paisesService.ListaPaises();
			System.out.println("ListaPaises:"+lista.toString());
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
			Pais pais=paisesService.obtener(id);
			Data.put("data", pais);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		return Data;
	
	}
	@RequestMapping("/obtenernombre")
	public Map<String, Object> obtenernombre(HttpServletRequest request,int id){
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			Pais pais=paisesService.obtenernombre(id);
			Data.put("data", pais);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		return Data;
	
	}
	
	@RequestMapping("actualizar")
	public Map<String, Object> actualizar(HttpServletRequest request,Model model, Pais pais)throws IOException{
		//Usuario user=(Usuario)request.getSession().getAttribute("user");
		Map<String, Object> Data = new HashMap<String, Object>();
		
			try {
				System.out.println("aqui");
				if(paisesService.modificar(pais)){
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
	public Map<String, Object> guardar(HttpServletRequest request,Pais pais){
		//Pais user=(Pais)request.getSession().getAttribute("user");
		Map<String,Object> Data=new HashMap<>();
		
			try {			
				if(paisesService.adicionar(pais)){
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
	public Map<String, Object> eliminar(HttpServletRequest request,Model model,int idpais)throws IOException{
		Map<String, Object> Data = new HashMap<String, Object>();
			if(paisesService.eliminar(idpais, 0))
				Data.put("status", true);
			else 
				Data.put("status", false);
	
		return Data;
	}
//	@RequestMapping(value="/lista")
//	public ResponseEntity<List<Pais>> lista(HttpServletRequest request){
//		List<Pais> listaPaises=new ArrayList<Pais>();
//		
////		Map<String,Object> pais1=new HashMap<String, Object>();
////		pais1.put("idpais", 1);
////		pais1.put("nombre", "Ecuador");
////		pais1.put("estado", 1);
////		
////		Map<String,Object> pais2=new HashMap<String, Object>();
////		pais2.put("idpais", 2);
////		pais2.put("nombre", "Chile");
////		pais2.put("estado", 1);
//		
//		try {
//			//peticion al servicio de la bd
////			listaPaises.add(pais1);
////			listaPaises.add(pais2);
//			
//			return new ResponseEntity<List<Pais>>(listaPaises,HttpStatus.OK);
//		} catch (Exception e) {
//			// TODO: handle exception
//			listaPaises.add(null);
//			return new ResponseEntity<List<Pais>>(listaPaises,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//	}
	
}
