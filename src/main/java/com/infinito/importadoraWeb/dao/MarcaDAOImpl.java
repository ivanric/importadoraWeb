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

import com.infinito.importadoraWeb.dao.ColorDAOImpl.ColorRowmapper;
import com.infinito.importadoraWeb.model.Color;
import com.infinito.importadoraWeb.model.Linea;
import com.infinito.importadoraWeb.model.Marca;


@Repository
public class MarcaDAOImpl implements IMarcaDAO{	

	@Autowired
	private  JdbcTemplate db;

	String sql;

	
	public class MarcaRowmapper implements RowMapper<Marca>{
		
		@Override
		public Marca mapRow(ResultSet rs, int as)throws SQLException{
			Marca me=new Marca();
			me.setEstado(rs.getInt("estado"));
			me.setIdmarc(rs.getInt("idmarc"));
			me.setNombre(rs.getString("nombre"));
			return me;
		}
	}
	
	
	@Override
	public Marca obtener(int id) {
		try {
			String sql="select * from importadora.marca where idmarc=?";
			Marca marc=db.queryForObject(sql, new MarcaRowmapper(),id);
			return marc;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}


	@Override
	public boolean adicionar(Marca marc) {
		try {
			String sql;
			int id=generarCodigo();
			sql="insert into importadora.marca(idmarc,nombre,estado) values(?,?,1);";
			db.update(sql,id,marc.getNombre().toUpperCase());
			return true;
		} catch (Exception e) {
			System.out.println("error tipo="+e.toString());
			return false;
		}
	}
	public int generarCodigo(){
		String sql="select COALESCE(max(idmarc),0)+1 as idmarc from importadora.marca";
		return db.queryForObject(sql, Integer.class);
	}


	@Override
	public boolean modificar(Marca marc) {
		try {
			String sql;
			sql="update importadora.marca set nombre=? where idmarc=?;";
			db.update(sql,marc.getNombre().toUpperCase(),marc.getIdmarc());
			return true;
		} catch (Exception e) {
			System.out.println("error al modificar categoria="+e.toString());
			return false;
		}
	}


	@Override
	public boolean eliminar(int idmarc,int estado) {
		try {
			
			db.update("update importadora.marca set estado=? where idmarc=?",estado,idmarc);
			return true;
		} catch (Exception e) {
			System.out.println("error al dar estado al tipo="+e.toString());
			return false;
		}
	}


	@Override
	public Marca obtenernombre(int id) {
		
		return null;
	}


	@Override
	public List<Marca> ListaMarcas1() {
		sql="select* from importadora.marca";
		return db.query(sql, new MarcaRowmapper());
	}


	@Override
	public List<Map<String, Object>> ListaMarca(int start, int estado, String search, int length) {
		sql="select count(*) from importadora.marca where estado=? and upper(nombre) like concat('%',upper(?),'%')";
		Integer tot=db.queryForObject(sql, Integer.class,estado,search);
		return db.queryForList("select importadora.marca.*,row_number() OVER(ORDER BY importadora.marca.idmarc) as RN,? as Tot from importadora.marca where estado=? and upper(nombre) like concat('%',upper(?),'%') LIMIT ? OFFSET ?",tot,estado,search,length,start);
	
	}


	@Override
	public Marca obteneridmod(int id) {
		try {
			String sql="select * from importadora.marca WHERE idmarc=(SELECT idmarc	from importadora.modelo	where idmod=?)";
			Marca marc=db.queryForObject(sql, new MarcaRowmapper(),id);
			return marc;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}


	@Override
	public Marca getMarca(int idmarc) {
		String sql="select * from importadora.marca where idmarc=?";
		return db.queryForObject(sql, new Object[] {idmarc}, new MarcaRowmapper());
	}


	@Override
	public List<Marca> listaporitem() {
		sql="SELECT * from importadora.marca WHERE idmarc in (SELECT idmarc FROM importadora.modelo WHERE idmod in (SELECT idmod from importadora.item))";
		return db.query(sql, new MarcaRowmapper());
	}



}
