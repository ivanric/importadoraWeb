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

import com.infinito.importadoraWeb.model.Color;

@Repository
public class ColorDAOImpl implements IColorDAO{

	@Autowired
	private  JdbcTemplate db;

	String sql;
	
	
	public class ColorRowmapper implements RowMapper<Color>{
		
		@Override
		public Color mapRow(ResultSet rs, int as)throws SQLException{
			Color me=new Color();
			me.setEstado(rs.getInt("estado"));
			me.setIdcolor(rs.getInt("idcolor"));
			me.setNombre(rs.getString("nombre"));
			return me;
		}
	}
	
	
	@Override
	public Color obtener(int id) {
		try {
			String sql="select * from importadora.color where idcolor=?";
			Color color=db.queryForObject(sql, new ColorRowmapper(),id);
			return color;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}


	@Override
	public boolean adicionar(Color color) {
		try {
			String sql;
			int id=generarCodigo();
			sql="insert into importadora.color(idcolor,nombre,estado) values(?,?,1);";
			db.update(sql,id,color.getNombre().toUpperCase());
			return true;
		} catch (Exception e) {
			System.out.println("error tipo="+e.toString());
			return false;
		}
	}
	public int generarCodigo(){
		String sql="select COALESCE(max(idcolor),0)+1 as idcolor from importadora.color";
		return db.queryForObject(sql, Integer.class);
	}


	@Override
	public boolean modificar(Color color) {
		try {
			String sql;
			sql="update importadora.color set nombre=? where idcolor=?;";
			db.update(sql,color.getNombre().toUpperCase(),color.getIdcolor());
			return true;
		} catch (Exception e) {
			System.out.println("error al modificar categoria="+e.toString());
			return false;
		}
	}


	@Override
	public boolean eliminar(int idcolor,int estado) {
		try {
			
			db.update("update importadora.color set estado=? where idcolor=?",estado,idcolor);
			return true;
		} catch (Exception e) {
			System.out.println("error al dar estado al tipo="+e.toString());
			return false;
		}
	}


	@Override
	public Color obtenernombre(int id) {
		
		return null;
	}


	@Override
	public List<Color> ListaColores1() {
		sql="select* from importadora.color";
		return db.query(sql,new ColorRowmapper());
	}


	@Override
	public List<Map<String, Object>> ListaColores(int start, int estado, String search, int length) {
		sql="select count(*) from importadora.color where estado=? and upper(nombre) like concat('%',upper(?),'%')";
		Integer tot=db.queryForObject(sql, Integer.class,estado,search);
		return db.queryForList("select importadora.color.*,row_number() OVER(ORDER BY importadora.color.idcolor) as RN,? as Tot from importadora.color where estado=? and upper(nombre) like concat('%',upper(?),'%') LIMIT ? OFFSET ?",tot,estado,search,length,start);
	
	}


	@Override
	public Color getcolor(int idcolor) {
		String sql="select * from importadora.color where idcolor=?";
		return db.queryForObject(sql, new Object[] {idcolor}, new ColorRowmapper());
	}


	@Override
	public List<Color> listarporItemIdColor(int idmod) {
		sql="select* from importadora.color WHERE idcolor in(SELECT idcolor from importadora.item WHERE idmod=?) ";
		return db.query(sql,new ColorRowmapper(),idmod);
	}
	





}
