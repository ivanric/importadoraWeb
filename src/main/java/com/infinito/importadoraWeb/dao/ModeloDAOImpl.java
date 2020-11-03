package com.infinito.importadoraWeb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.infinito.importadoraWeb.model.Modelo;
import com.infinito.importadoraWeb.service.IMarcaService;

@Repository
public class ModeloDAOImpl implements IModelosDAO{
	
	@Autowired
	IMarcaService marcaser;

	@Autowired
	private  JdbcTemplate db;

	String sql;
	
	public class ModeloRowmapper implements RowMapper<Modelo>{
		
		@Override
		public Modelo mapRow(ResultSet rs, int as)throws SQLException{
			Modelo me=new Modelo();
			me.setEstado(rs.getInt("estado"));
			me.setIdmod(rs.getInt("idmod"));
			me.setNombre(rs.getString("nombre"));
			me.setIdmarc(rs.getInt("idmarc"));
			me.setAnho(rs.getInt("anho"));
			
			try {
				me.setMarca(marcaser.getMarca(me.getIdmarc()));
			} catch (Exception e) {
				me.setMarca(null);
			}
			return me;
		}
		
	}
	
	
	@Override
	public Modelo obtener(int id) {
		try {
			String sql="select * from importadora.modelo where idmod=?";
			Modelo mod=db.queryForObject(sql, new ModeloRowmapper(),id);
			return mod;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}


	@Override
	public boolean adicionar(Modelo mod) {
		try {
			String sql;
			int id=generarCodigo();
			int anho=mod.getAnho();
			sql="insert into importadora.modelo(idmod,idmarc,nombre,anho,estado) values(?,?,?,?,1);";
			db.update(sql,id,mod.getIdmarc(),mod.getNombre().toUpperCase(),anho);
			return true;
		} catch (Exception e) {
			System.out.println("error tipo="+e.toString());
			return false;
		}
	}
	public int generarCodigo(){
		String sql="select COALESCE(max(idmod),0)+1 as idmod from importadora.modelo";
		return db.queryForObject(sql, Integer.class);
	}


	@Override
	public boolean modificar(Modelo mod) {
		try {
			String sql;
			sql="update importadora.modelo set nombre=?,idmarc=? where idmod=?;";
			db.update(sql,mod.getNombre().toUpperCase(),mod.getIdmarc(),mod.getIdmod());
			return true;
		} catch (Exception e) {
			System.out.println("error al modificar categoria="+e.toString());
			return false;
		}
	}


	@Override
	public boolean eliminar(int idmod,int estado) {
		try {
			
			db.update("update importadora.modelo set estado=? where idmod=?",estado,idmod);
			return true;
		} catch (Exception e) {
			System.out.println("error al dar estado al tipo="+e.toString());
			return false;
		}
	}


	@Override
	public Modelo obtenernombre(int id) {
		
		return null;
	}


	@Override
	public List<Modelo> ListaModelos1() {
		sql="select* from importadora.modelo";
		return db.query(sql, new ModeloRowmapper());
	}


	@Override
	public List<Map<String, Object>> ListaModelos(int start, int estado, String search, int length) {
		sql="select count(*) from importadora.modelo where estado=? and upper(nombre) like concat('%',upper(?),'%')";
		Integer tot=db.queryForObject(sql, Integer.class,estado,search);
		return db.queryForList("select importadora.modelo.*,row_number() OVER(ORDER BY importadora.modelo.idmod) as RN,? as Tot from importadora.modelo where estado=? and upper(nombre) like concat('%',upper(?),'%') LIMIT ? OFFSET ?",tot,estado,search,length,start);
	
	}


	@Override
	public List<Modelo> ListaModelos(int idmod) {
		sql="select * from importadora.modelo WHERE idmarc=? ";
		return db.query(sql, new ModeloRowmapper(),idmod);
	}


	@Override
	public Modelo getModelo(int idmod) {
		String sql="select * from importadora.modelo where idmod=?";
		return db.queryForObject(sql, new Object[] {idmod}, new ModeloRowmapper());
	}


	@Override
	public List<Modelo> listarporItemIdMarca(int idmarc) {
		sql="SELECT * from importadora.modelo WHERE (idmarc=?)and idmod in (SELECT idmod from importadora.item )";
		return db.query(sql, new ModeloRowmapper(),idmarc);
	}


}
