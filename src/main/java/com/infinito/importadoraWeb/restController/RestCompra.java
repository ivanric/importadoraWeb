package com.infinito.importadoraWeb.restController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infinito.importadoraWeb.model.Color;
import com.infinito.importadoraWeb.model.Compra;
import com.infinito.importadoraWeb.model.Detallecompra;
import com.infinito.importadoraWeb.model.Modelo;
import com.infinito.importadoraWeb.model.Usuemp;
import com.infinito.importadoraWeb.service.ICompraService;
import com.infinito.importadoraWeb.service.IDetalleCompraService;
import com.infinito.importadoraWeb.service.IMarcaService;

@RestController
@RequestMapping(value={"/RestComp"})
public class RestCompra {
	
	@Autowired
	ICompraService compraservice;
	
	@Autowired
	IMarcaService marcaservice;
	
	@Autowired
	IDetalleCompraService detacompraserv;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/lista", method = RequestMethod.POST)
	public  Map<?, ?> lista(HttpServletRequest request, Integer draw,int length, Integer start, int estado)throws IOException{
		String total;
		Map<String, Object> Data = new HashMap<String, Object>();
		String search = request.getParameter("search[value]");
		List<?> lista=compraservice.ListaCompras(start, estado, search, length);
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
	@RequestMapping("/obtener")
	public Map<String, Object> obtener(HttpServletRequest request,int id){
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			Compra com=compraservice.obtener(id);
			Data.put("data", com);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		return Data;
	
	}
	
	
	
	@RequestMapping(value="/dcompralista", method = RequestMethod.POST)
	public  Map<?, ?> listaDetalleCompra(HttpServletRequest request,int id)throws IOException{
		
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			List<Detallecompra> lista=detacompraserv.ListaDcompras(id);
			System.out.println(lista);
			Data.put("data", lista);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status",false);
		} 
		return Data;

	}

	
	@RequestMapping("/obtenerModelo")
	public Map<String, Object> obtenerModelo(HttpServletRequest request,int id){
		Map<String, Object> Data = new HashMap<String, Object>();
		try {
			Modelo model=compraservice.obtenerModelo(id);
			Data.put("data", model);
			Data.put("status", true);
		} catch (Exception e) {
			Data.put("status", false);
			System.out.println("error al obtener="+e.toString());
		}
		return Data;
	
	}
	
	
	@RequestMapping("/guardar")
	public Map<String, Object> guardar(HttpServletRequest request,Compra com){
		//Pais user=(Pais)request.getSession().getAttribute("user");
		Map<String,Object> Data=new HashMap<>();
		Usuemp usu=(Usuemp) request.getSession().getAttribute("usu");
		com.setIdusu(usu.getIdusu());
		com.setIdemp(usu.getIdemp());
		Date fecha=new Date();
		com.setFecha_compra(new SimpleDateFormat("yyyy-MM-dd").format(fecha));
		//System.out.println(com);
		
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
