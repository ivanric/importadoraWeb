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


import com.infinito.importadoraWeb.model.Linea;

@Repository
public class LineaDAOImpl implements ILineaDAO{

	@Autowired
	private  JdbcTemplate db;

	String sql;

	public class LineaRowmapper implements RowMapper<Linea>{
		
		@Override
		public Linea mapRow(ResultSet rs, int as)throws SQLException{
			Linea me=new Linea();
			me.setEstado(rs.getInt("estado"));
			me.setIdlinea(rs.getInt("idlinea"));
			me.setNombre(rs.getString("nombre"));
			return me;
		}
	}
	
	
	@Override
	public Linea obtener(int id) {
		try {
			String sql="select * from importadora.linea where idlinea=?";
			Linea Lin=db.queryForObject(sql, new LineaRowmapper(),id);
			return Lin;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}


	@Override
	public boolean adicionar(Linea lin) {
		try {
			String sql;
			int id=generarCodigo();
			sql="insert into importadora.linea(idlinea,nombre,estado) values(?,?,1);";
			db.update(sql,id,lin.getNombre().toUpperCase());
			return true;
		} catch (Exception e) {
			System.out.println("error tipo="+e.toString());
			return false;
		}
	}
	public int generarCodigo(){
		String sql="select COALESCE(max(idlinea),0)+1 as idlinea from importadora.linea";
		return db.queryForObject(sql, Integer.class);
	}


	@Override
	public boolean modificar(Linea lin) {
		try {
			String sql;
			sql="update importadora.linea set nombre=? where idlinea=?;";
			db.update(sql,lin.getNombre().toUpperCase(),lin.getIdlinea());
			return true;
		} catch (Exception e) {
			System.out.println("error al modificar categoria="+e.toString());
			return false;
		}
	}


	@Override
	public boolean eliminar(int idlinea,int estado) {
		try {
			
			db.update("update importadora.linea set estado=? where idlinea=?",estado,idlinea);
			return true;
		} catch (Exception e) {
			System.out.println("error al dar estado al tipo="+e.toString());
			return false;
		}
	}


	@Override
	public Linea obtenernombre(int id) {
		
		return null;
	}


	@Override
	public List<Linea> ListaLineas1() {
		sql="select* from importadora.linea";
		return db.query(sql,new LineaRowmapper());
	}


	@Override
	public List<Map<String, Object>> ListaLineas(int start, int estado, String search, int length) {
		sql="select count(*) from importadora.linea where estado=? and upper(nombre) like concat('%',upper(?),'%')";
		Integer tot=db.queryForObject(sql, Integer.class,estado,search);
		return db.queryForList("select importadora.linea.*,row_number() OVER(ORDER BY importadora.linea.idlinea) as RN,? as Tot from importadora.linea where estado=? and upper(nombre) like concat('%',upper(?),'%') LIMIT ? OFFSET ?",tot,estado,search,length,start);
	
	}


	@Override
	public Linea getLinea(int idlinea) {
		String sql="select * from importadora.linea where idlinea=?";
		return db.queryForObject(sql, new Object[] {idlinea}, new LineaRowmapper());
	}

}
