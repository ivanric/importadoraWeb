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

import com.infinito.importadoraWeb.dao.MarcaDAOImpl.MarcaRowmapper;
import com.infinito.importadoraWeb.model.Compra;
import com.infinito.importadoraWeb.model.Marca;
import com.infinito.importadoraWeb.model.Modelo;

@Repository
public class CompraDAOImpl implements ICompraDAO{

	@Autowired
	private  JdbcTemplate db;

	String sql;
	
	
	public class ComRowmapper implements RowMapper<Compra>{
		
		@Override
		public Compra mapRow(ResultSet rs, int as) throws SQLException {
			Compra ac=new Compra();
			ac.setEstado(rs.getInt("estado"));
			ac.setFecha_compra(rs.getString("fecha_compra"));
			ac.setFecha_importacion(rs.getString("fecha_importacion"));
			ac.setIdcomp(rs.getInt("idcomp"));
			ac.setIdemp(rs.getInt("idemp"));
			ac.setIdpais(rs.getInt("idpais"));
			ac.setIdusu(rs.getInt("idusu"));
			ac.setNum_compra(rs.getString("num_compra"));
			ac.setNum_embarque(rs.getString("num_embarque"));
			ac.setNum_importacion(rs.getString("num_importacion"));
			ac.setTotal(rs.getInt("total"));
			
			
			return ac;
		}
		
	}
	
	
public Compra getcompra(int idcomp) {
	String sql = "SELECT * FROM importadora.compra WHERE idcomp = ? LIMIT 1";
	return db.queryForObject(sql, new ComRowmapper(),idcomp);
}
	
	@Override
	public List<Map<String, Object>> ListaCompras(int start, int estado, String search, int length) {
		sql="select count(*) from importadora.compra where estado=? and upper(num_compra) like concat('%',upper(?),'%')";
		Integer tot=db.queryForObject(sql, Integer.class,estado,search);
		return db.queryForList("select importadora.compra.*,row_number() OVER(ORDER BY importadora.compra.idcomp) as RN,? as Tot from importadora.compra where estado=? and upper(num_compra) like concat('%',upper(?),'%') LIMIT ? OFFSET ?",tot,estado,search,length,start);
	
	}


	@Override
	public Compra obtener(int id) {
		try {
			String sql="select * from importadora.compra where idcomp=?";
			Compra com=db.queryForObject(sql,new ComRowmapper(),id);
			return com;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}


	@Override
	public List<Compra> listaDcompras(int id) {
		return null;
	}


	@Override
	public Marca obtenerMarca(int id) {
		return null;
	}
	
	@Override
	public Modelo obtenerModelo(int id) {
		try {
			String sql="select * from importadora.modelo	WHERE idmod =(SELECT idmod from importadora.item where iditem =(select iditem	from importadora.articulo	WHERE idart=(SELECT idart	from importadora.detallecompra	WHERE iddcomp=?)))";
			Modelo com=db.queryForObject(sql, new BeanPropertyRowMapper<Modelo>(Modelo.class),id,new ComRowmapper());
			return com;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}
	
}
