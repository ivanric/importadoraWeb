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

import com.infinito.importadoraWeb.model.Categoria;
import com.infinito.importadoraWeb.model.Compra;


@Repository
public class CategoriaDAOImpl implements ICategoriaDAO{

	@Autowired
	private  JdbcTemplate db;

	String sql;

public class CateRowmapper implements RowMapper<Categoria>{
		
		@Override
		public Categoria mapRow(ResultSet rs, int as) throws SQLException {
			Categoria ac=new Categoria();
			ac.setEstado(rs.getInt("estado"));
			ac.setIdcat(rs.getInt("idcat"));
			ac.setNombre(rs.getString("nombre"));
			return ac;
		}
		
	}
	
	
	
	public Categoria getcategoria(int idcate) {
		String sql="select * from importadora.categoria where idcat=?";
		return db.queryForObject(sql, new Object[] {idcate}, new CateRowmapper());
	}
	

	@Override
	public Categoria obtener(int id) {
		try {
			String sql="select * from importadora.categoria where idcat=?";
			Categoria categoria=db.queryForObject(sql,new CateRowmapper(),id);
			return categoria;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}


	@Override
	public boolean adicionar(Categoria cat) {
		try {
			String sql;
			int id=generarCodigo();
			sql="insert into importadora.categoria(idcat,nombre,estado) values(?,?,1);";
			db.update(sql,id,cat.getNombre().toUpperCase());
			return true;
		} catch (Exception e) {
			System.out.println("error tipo="+e.toString());
			return false;
		}
	}
	public int generarCodigo(){
		String sql="select COALESCE(max(idcat),0)+1 as idcat from importadora.categoria";
		return db.queryForObject(sql, Integer.class);
	}


	@Override
	public boolean modificar(Categoria cat) {
		try {
			String sql;
			sql="update importadora.categoria set nombre=? where idcat=?;";
			db.update(sql,cat.getNombre().toUpperCase(),cat.getIdcat());
			return true;
		} catch (Exception e) {
			System.out.println("error al modificar categoria="+e.toString());
			return false;
		}
	}


	@Override
	public boolean eliminar(int idcat,int estado) {
		try {
			
			db.update("update importadora.categoria set estado=? where idcat=?",estado,idcat);
			return true;
		} catch (Exception e) {
			System.out.println("error al dar estado al tipo="+e.toString());
			return false;
		}
	}


	@Override
	public Categoria obtenernombre(int id) {
		
		return null;
	}


	@Override
	public List<Categoria> ListaCategorias1() {
		sql="select* from importadora.categoria";
		return db.query(sql,new CateRowmapper());
	}


	@Override
	public List<Map<String, Object>> ListaCategorias(int start, int estado, String search, int length) {
		sql="select count(*) from importadora.categoria where estado=? and upper(nombre) like concat('%',upper(?),'%')";
		Integer tot=db.queryForObject(sql, Integer.class,estado,search);
		return db.queryForList("select importadora.categoria.*,row_number() OVER(ORDER BY importadora.categoria.idcat) as RN,? as Tot from importadora.categoria where estado=? and upper(nombre) like concat('%',upper(?),'%') LIMIT ? OFFSET ?",tot,estado,search,length,start);
	}

}
