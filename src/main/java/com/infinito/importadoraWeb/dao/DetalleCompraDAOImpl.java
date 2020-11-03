package com.infinito.importadoraWeb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



import com.infinito.importadoraWeb.model.Detallecompra;
import com.infinito.importadoraWeb.service.IArticuloService;

@Repository
public class DetalleCompraDAOImpl implements IDetalleCompraDAO{

	@Autowired
	IArticuloService articuloserv;
	
	
	@Autowired
	private  JdbcTemplate db;

	String sql;

	public class DetComRowmapper implements RowMapper<Detallecompra>{
		
	
		
		@Override
		public Detallecompra mapRow(ResultSet rs, int as) throws SQLException {
			Detallecompra ac=new Detallecompra();
			ac.setCantidad(rs.getFloat("cantidad"));
			ac.setIdart(rs.getInt("idart"));
			ac.setIdcomp(rs.getInt("idcomp"));
			ac.setIditemalm(rs.getInt("iditemalm"));
			ac.setPrecio(rs.getFloat("precio"));
			ac.setSub_total(rs.getFloat("sub_total"));
			
			
			try {
				
				ac.setArticulo(articuloserv.obtenerArt(ac.getIdart()));
			} catch (Exception e) {
				System.out.println(e);
				ac.setArticulo(null);
			}
			
			
			
			return ac;
		}
		
	}
	
	
	
	@Override
	public List<Detallecompra> ListaDcompras(int id) {
		sql="select* from importadora.detallecompra where idcomp=?";
		return db.query(sql,new DetComRowmapper(),id);
	}



	@Override
	public Detallecompra getDetallecompra(int iddcomp) {
		String sql = "SELECT * FROM importadora.detallecompra WHERE iddcomp = ? LIMIT 1";
		return db.queryForObject(sql, new DetComRowmapper(),iddcomp);
	}

}
