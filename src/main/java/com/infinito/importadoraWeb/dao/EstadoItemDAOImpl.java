package com.infinito.importadoraWeb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infinito.importadoraWeb.dao.ColorDAOImpl.ColorRowmapper;
import com.infinito.importadoraWeb.model.Estadoitem;


@Repository
public class EstadoItemDAOImpl implements IEstadoItemDAO{

	@Autowired
	private  JdbcTemplate db;

	String sql;

	
	public class EstaItemRowmapper implements RowMapper<Estadoitem>{
		
		
		@Override
		public Estadoitem mapRow(ResultSet rs, int as) throws SQLException {
			Estadoitem ac=new Estadoitem();
			ac.setEstado(rs.getInt("estado"));
			ac.setIdcat(rs.getInt("idcat"));
			ac.setIdestaitem(rs.getInt("idestaitem"));
			ac.setNombre(rs.getString("nombre"));
						
			
			return ac;
		}
		
	}
	
	@Override
	public Estadoitem getEstadoItem(int idestaitem) {
		sql="select* from importadora.estadoitem where idestaitem=?";
		return db.queryForObject(sql,new Object[] { idestaitem },new EstaItemRowmapper());
	}

	@Override
	public List<Estadoitem> listar() {
		sql="select* from importadora.estadoitem";
		return db.query(sql,new EstaItemRowmapper());
	}

}
