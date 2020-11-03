package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.infinito.importadoraWeb.model.Pais;


@Repository
public class PaisDAOImpl implements IPaisDAO{
	@Autowired
	private  JdbcTemplate db;

	String sql;
	
	
	public List<Map<String, Object>> lista(int start,int estado,String search,int length){
		sql="select count(*) from pais where estado=? and upper(nombre) like concat('%',upper(?),'%')";
		Integer tot=db.queryForObject(sql, Integer.class,estado,search);
		return db.queryForList("select pais.*,row_number() OVER(ORDER BY pais.idpais) as RN,? as Tot from pais where estado=? and upper(nombre) like concat('%',upper(?),'%') LIMIT ? OFFSET ?",tot,estado,search,length,start);
	
	}


	@Override
	public Pais obtener(int id) {
		try {
			String sql="select * from pais where idpais=?";
			Pais pais=db.queryForObject(sql, new BeanPropertyRowMapper<Pais>(Pais.class),id);
			return pais;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}


	@Override
	public boolean adicionar(Pais pais) {
		try {
			String sql;
			int id=generarCodigo();
			sql="insert into pais(idpais,nombre,estado) values(?,?,1);";
			db.update(sql,id,pais.getNombre().toUpperCase());
			return true;
		} catch (Exception e) {
			System.out.println("error tipo="+e.toString());
			return false;
		}
	}
	public int generarCodigo(){
		String sql="select COALESCE(max(idpais),0)+1 as idpais from pais";
		return db.queryForObject(sql, Integer.class);
	}


	@Override
	public boolean modificar(Pais pais) {
		try {
			String sql;
			sql="update pais set nombre=? where idpais=?;";
			db.update(sql,pais.getNombre(),pais.getIdpais());
			return true;
		} catch (Exception e) {
			System.out.println("error al modificar categoria="+e.toString());
			return false;
		}
	}


	@Override
	public boolean eliminar(int idpais,int estado) {
		try {
			System.out.println("qui");
			db.update("update pais set estado=? where idpais=?",estado,idpais);
			return true;
		} catch (Exception e) {
			System.out.println("error al dar estado al tipo="+e.toString());
			return false;
		}
	}


	@Override
	public Pais obtenernombre(int id) {
		
		return null;
	}


	@Override
	public List<Map<String, Object>> lista() {
		sql="select* from pais";
		return db.queryForList(sql);
	}


	
}
