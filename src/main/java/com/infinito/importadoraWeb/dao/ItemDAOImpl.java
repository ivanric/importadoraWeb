package com.infinito.importadoraWeb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infinito.importadoraWeb.model.Item;
import com.infinito.importadoraWeb.service.ICategoriaService;
import com.infinito.importadoraWeb.service.IColorService;
import com.infinito.importadoraWeb.service.ILineaService;
import com.infinito.importadoraWeb.service.IMarcaService;
import com.infinito.importadoraWeb.service.IModeloService;


@Repository
public class ItemDAOImpl implements IItemDAO{



	@Autowired
	ICategoriaService catserv;
	
	@Autowired
	IColorService colorserv;
	
	@Autowired
	ILineaService lineaserv;
	
	@Autowired
	IModeloService modserv;
	
	@Autowired
	IMarcaService marcaserv;
	
	
	@Autowired
	private  JdbcTemplate db;

	String sql;

	
	public class ItRowmapper implements RowMapper<Item>{
		
		@Override
		public Item mapRow(ResultSet rs, int as) throws SQLException {
			Item ac=new Item();
			ac.setDisponible(rs.getInt("disponible"));
			ac.setIdcat(rs.getInt("idcat"));
			ac.setIdcolor(rs.getInt("idcolor"));
			ac.setIdemp(rs.getInt("idemp"));
			ac.setIditem(rs.getInt("iditem"));
			ac.setIdlinea(rs.getInt("idlinea"));
			ac.setIdmod(rs.getInt("idmod"));
			ac.setIdusu(rs.getInt("idusu"));
			try {
				ac.setCategoria(catserv.getcategoria(ac.getIdcat()));
			} catch (Exception e) {
				ac.setCategoria(null);
			}
			
			try {
				ac.setColor(colorserv.getColor(ac.getIdcolor()));
			} catch (Exception e) {
				ac.setColor(null);
			}
			try {
				ac.setLinea(lineaserv.getLinea(ac.getIdlinea()));
			} catch (Exception e) {
				ac.setLinea(null);
			}
			
			try {
				System.out.println(ac.getIdmod());
				ac.setModelo(modserv.getModelo(ac.getIdmod()));
			} catch (Exception e) {
				System.out.println(e);
				ac.setModelo(null);
			}
			
			
			return ac;
		}
		
	}
	
	
	
	@Override
	public Item obtener(int id) {
		try {
			String sql="select * from importadora.item where iditem=?";
			Item it=db.queryForObject(sql,new ItRowmapper() ,id);
			return it;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}


	@Override
	public boolean adicionar(Item it) {
		try {
			String sql;
			int id=generarCodigo();
			sql="insert into importadora.item(iditem,idmod,idcolor,idcat,idusu,disponible,idlinea,idemp) values(?,?,?,?,?,1,?,?);";
			db.update(sql,id,it.getIdmod(),it.getIdcolor(),it.getIdcat(),it.getIdusu(),it.getIdlinea(),it.getIdemp());
			return true;
		} catch (Exception e) {
			System.out.println("error tipo="+e.toString());
			return false;
		}
	}
	public int generarCodigo(){
		String sql="select COALESCE(max(iditem),0)+1 as iditem from importadora.item";
		return db.queryForObject(sql, Integer.class);
	}


	@Override
	public boolean modificar(Item it) {
		try {
			String sql;
			sql="update importadora.item set idmod=?,idcolor=?,idcat=?,idusu=?,idlinea=?,idemp=? where iditem=?;";
			db.update(sql,it.getIdmod(),it.getIdcolor(),it.getIdcat(),it.getIdusu(),it.getIdlinea(),it.getIdemp(),it.getIditem());
			return true;
		} catch (Exception e) {
			System.out.println("error al modificar "+e.toString());
			return false;
		}
	}


	@Override
	public boolean eliminar(int iditem,int estado) {
		try {
			
			db.update("update importadora.item set disponible=? where iditem=?",estado,iditem);
			return true;
		} catch (Exception e) {
			System.out.println("error al dar estado al tipo="+e.toString());
			return false;
		}
	}



	@Override
	public List<Item> Listaitems1() {
		sql="select* from importadora.item";
		return db.query(sql,new ItRowmapper());
	}


	@Override
	public List<Map<String, Object>> ListaItems(int start, int estado, int idemp, int length) {
		sql="select count(*) from importadora.item where disponible=? and idemp=?";
		Integer tot=db.queryForObject(sql, Integer.class,estado,idemp);
		return db.queryForList("select importadora.item.*,row_number() OVER(ORDER BY importadora.item.iditem) as RN,? as Tot from importadora.item where disponible=? and idemp=? LIMIT ? OFFSET ?",tot,estado,idemp,length,start);
	
	}


	@Override
	public Item getItem(int iditem) {
		sql="select* from importadora.item where iditem=?";
		return db.queryForObject(sql,new Object[] { iditem },new ItRowmapper());
	}


	@Override
	public Item obtenerpormodelocolor(Item item) {
		try {
			String sql="select * from importadora.item where idmod=? and idcolor=? limit 1" ;
			Item it=db.queryForObject(sql,new ItRowmapper() ,item.getIdmod(),item.getIdcolor());
			return it;
		} catch (Exception e) {
			System.out.println("error al obtener:"+e.toString());
			return null;
		}
	}
}
