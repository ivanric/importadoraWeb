package com.infinito.importadoraWeb.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.infinito.importadoraWeb.model.Departamento;
import com.infinito.importadoraWeb.model.Pais;


@Repository
public class DptoDAOImpl implements IDptoDAO{

	@Autowired
	private  JdbcTemplate db;

	String sql;
	
	@Override
	public List<Map<String, Object>> lista(int start, int estado, String search, int length) {
		sql="select count(*) from departamento where estado=? and upper(nombre) like concat('%',upper(?),'%')";
		Integer tot=db.queryForObject(sql, Integer.class,estado,search);
		return db.queryForList("select departamento.*,row_number() OVER(ORDER BY departamento.iddep) as RN,? as Tot from departamento where estado=? and upper(nombre) like concat('%',upper(?),'%') LIMIT ? OFFSET ?",tot,estado,search,length,start);
	}

	@Override
	public Departamento obtener(int id) {
		try {
			String sql="select * from departamento where iddep=?";
			Departamento dpto=db.queryForObject(sql, new BeanPropertyRowMapper<Departamento>(Departamento.class),id);
			return dpto;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}

	public int generarCodigo(){
		String sql="select COALESCE(max(iddep),0)+1 as iddep from departamento";
		return db.queryForObject(sql, Integer.class);
	}

	@Override
	public boolean adicionar(String nombre,int idpais) {
		int id=generarCodigo();
		try {
			sql="insert into departamento(iddep,nombre,estado,idpais) values(?,?,1,?);";
			db.update(sql,id,nombre.toUpperCase(),idpais);
			return true;
		} catch (Exception e) {
			System.out.println("error tipo="+e.toString());
			return false;
		}
	}

	@Override
	public boolean modificar(Departamento dpto) {
		try {
			String sql;
			sql="update departamento set nombre=?,idpais=? where iddep=?;";
			db.update(sql,dpto.getNombre().toUpperCase(),dpto.getIdpais(),dpto.getIddep());
			return true;
		} catch (Exception e) {
			System.out.println("error al modificar categoria="+e.toString());
			return false;
		}
	}

	@Override
	public boolean eliminar(int iddep, int estado) {
		try {
			db.update("update departamento set estado=? where iddep=?",estado,iddep);
			return true;
		} catch (Exception e) {
			System.out.println("error al dar estado al tipo="+e.toString());
			return false;
		}
	}

	@Override
	public List<Map<String, Object>> ListDpto() {
		sql="select* from departamento";
		return db.queryForList(sql);
	}

	@Override
	public Departamento obtenernombre(int iddep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> ListDptoid(Integer idpais) {
		System.out.println(idpais);
		sql="select* from departamento where idpais=?";
		return db.queryForList(sql,idpais);
	}

}
