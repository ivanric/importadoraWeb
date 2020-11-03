package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.infinito.importadoraWeb.model.Pais;
import com.infinito.importadoraWeb.model.Provincia;

@Repository
public class ProvDAOImpl implements IProvDAO{

	@Autowired
	private  JdbcTemplate db;

	String sql;
	
	@Override
	public List<Map<String, Object>> ListaProvincia(int start, int estado, String search, int length) {
		sql="select count(*) from provincia where estado=? and upper(nombre) like concat('%',upper(?),'%')";
		Integer tot=db.queryForObject(sql, Integer.class,estado,search);
		return db.queryForList("select provincia.*,row_number() OVER(ORDER BY provincia.idprov) as RN,? as Tot from provincia where estado=? and upper(nombre) like concat('%',upper(?),'%') LIMIT ? OFFSET ?",tot,estado,search,length,start);
	
	}

	@Override
	public Provincia obtener(int id) {
		try {
			String sql="select * from provincia where idprov=?";
			Provincia prov=db.queryForObject(sql, new BeanPropertyRowMapper<Provincia>(Provincia.class),id);
			return prov;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}
	
	public int generarCodigo(){
		String sql="select COALESCE(max(idprov),0)+1 as idprov from provincia";
		return db.queryForObject(sql, Integer.class);
	}

	@Override
	public boolean adicionar(String nombre, int iddep) {
		int id=generarCodigo();
		try {
			sql="insert into provincia(idprov,nombre,estado,iddep) values(?,?,1,?);";
			db.update(sql,id,nombre.toUpperCase(),iddep);
			return true;
		} catch (Exception e) {
			System.out.println("error tipo="+e.toString());
			return false;
		}
	}

	@Override
	public boolean modificar(Provincia prov) {
		try {
			String sql;
			sql="update Provincia set nombre=?,iddep=? where idprov=?;";
			db.update(sql,prov.getNombre().toUpperCase(),prov.getIddep(),prov.getIdprov());
			return true;
		} catch (Exception e) {
			System.out.println("error al modificar categoria="+e.toString());
			return false;
		}
	}

	@Override
	public boolean eliminar(int idprov, int estado) {
		try {
			db.update("update provincia set estado=? where idprov=?",estado,idprov);
			return true;
		} catch (Exception e) {
			System.out.println("error al dar estado al tipo="+e.toString());
			return false;
		}
	}

	@Override
	public Pais obtenerPais(int iddep) {
		try {
			Integer idpais=db.queryForObject("select idpais from departamento where iddep=?",Integer.class ,iddep);
			sql="select * from pais where idpais=?";
			Pais prov=db.queryForObject(sql, new BeanPropertyRowMapper<Pais>(Pais.class),idpais);
			return prov;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}
}
