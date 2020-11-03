package com.infinito.importadoraWeb.restController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinito.importadoraWeb.model.Articulo;
import com.infinito.importadoraWeb.model.Color;
import com.infinito.importadoraWeb.service.IArticuloService;

@RestController
@RequestMapping(value={"/RestArt"})
public class RestArticulo {

	
	@Autowired
	IArticuloService artiserv;
	
	@RequestMapping("/obtener")
	public Map<String, Object> obtener(HttpServletRequest request,int idart){
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			System.out.println("entra articulos");
			Articulo com=artiserv.obtenerArt(idart);
			Data.put("data", com);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		return Data;
	
	}
	
	@RequestMapping("validarexistenciachasis")
	public Map<String, Object> existenciaChasis(HttpServletRequest request, String validar)throws IOException{
		//Usuario user=(Usuario)request.getSession().getAttribute("user");
		Map<String, Object> Data = new HashMap<String, Object>();
		
			try {
				
				if(artiserv.validarexistenciachasis(validar)){
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
	@RequestMapping("validarexistenciamotor")
	public Map<String, Object> existenciaMotor(HttpServletRequest request, String validar)throws IOException{
		//Usuario user=(Usuario)request.getSession().getAttribute("user");
		Map<String, Object> Data = new HashMap<String, Object>();
		
			try {
				
				if(artiserv.validarexistenciamotor(validar)){
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
	public Map<String, Object> guardar(HttpServletRequest request,Articulo art){
		//Pais user=(Pais)request.getSession().getAttribute("user");
		Map<String,Object> Data=new HashMap<>();
		System.out.println(art);
		Data.put("status", true);
			/*try {			
				if(colservice.adicionar(color)){
					Data.put("status", true);
				}else{
					Data.put("status", false);
				}
			} catch (Exception e) {
				System.out.println("error al adicionar rol"+e.toString());
				Data.put("status", false);
			}*/
			
		return Data;
	}
	
	
}
