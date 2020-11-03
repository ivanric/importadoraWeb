package com.infinito.importadoraWeb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.infinito.importadoraWeb.model.Articulo;
import com.infinito.importadoraWeb.service.IEstadoItemService;
import com.infinito.importadoraWeb.service.IItemService;


@Repository
public class ArticuloDAOImpl implements IArticuloDAO{

	@Autowired
	private  JdbcTemplate db;

	String sql;
	
	@Autowired
	IItemService itserv;
	
	@Autowired
	IEstadoItemService estaitemserv;
	
	public class ArtRowmapper implements RowMapper<Articulo>{
		
		
		
		@Override
		public Articulo mapRow(ResultSet rs, int as) throws SQLException {
			Articulo ac=new Articulo();
			ac.setEstado(rs.getInt("estado"));
			ac.setIdart(rs.getInt("idart"));
			ac.setIdestaitem(rs.getInt("idestaitem"));
			ac.setIditem(rs.getInt("iditem"));
			ac.setNum_chasis(rs.getString("num_chasis"));
			ac.setNum_motor(rs.getString("num_motor"));
			ac.setNum_serie(rs.getString("num_serie"));
			ac.setTamanio(rs.getString("tamanio"));
			
			
			try {
				ac.setItem(itserv.getItem(ac.getIditem()));
			} catch (Exception e) {
				ac.setItem(null);
			}
			
			try {
				ac.setEstadoitem(estaitemserv.getEstaItem(ac.getIdestaitem()));
			} catch (Exception e) {
				ac.setEstadoitem(null);
			}
			return ac;
		}
		
	}
	
	
	@Override
	public Articulo getArticulo(int idart) {
		System.out.println("llego "+idart);
		sql="select* from importadora.articulo where idart=? LIMIT 1";
		return db.queryForObject(sql,new Object[] { idart },new ArtRowmapper());
	}


	@Override
	public Articulo obtenerArt(int idart) {
		System.out.println("llego "+idart);
		sql="select* from importadora.articulo where idart=? LIMIT 1";
		return db.queryForObject(sql,new ArtRowmapper(),idart);
	}


	@Override
	public boolean validarexistenciachasis(String validar) {
		try {
			sql="select * from importadora.articulo where upper(num_chasis)=upper(?) limit 1 ";
			db.queryForObject(sql,new ArtRowmapper(), validar);
			return true;
		} catch (Exception e) {
			System.out.println("error tipo="+e.toString());
			return false;
		}
	}


	@Override
	public boolean validarexistenciamotor(String validar) {
		try {
			sql="select * from importadora.articulo where upper(num_motor)=upper(?) limit 1 ";
			db.queryForObject(sql,new ArtRowmapper(), validar);
			return true;
		} catch (Exception e) {
			System.out.println("error tipo="+e.toString());
			return false;
		}
	}

}
