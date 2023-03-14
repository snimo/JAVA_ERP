package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.rrhh.bm.FiltroLegCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class DBFiltroLegCab extends DBObjetoPersistente {

	public static final String OID_FILTRO_CAB = "oid_filtro_cab";
	public static final String DESCRIPCION = "descripcion";
	public static final String APLIC_CONS_ROTAS = "aplic_cons_rotas";
	public static final String APLIC_BUSQ_LEG = "aplic_busq_leg";
	public static final String ACTIVO = "activo";
	
	
	public static final int SELECT_BY_ACTIVOS_CONS_ROTAS = 100;
	private static final int SELECT_BY_FILTROS_POR_USU = 101;
	
	

	public DBFiltroLegCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_FILTRO_CAB = 1;
		final int DESCRIPCION = 2;
		final int APLIC_CONS_ROTAS = 3;
		final int ACTIVO = 4;
		final int APLIC_BUSQ_LEG = 5;

		FiltroLegCab pers = (FiltroLegCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhFiltroLegCab " + " ( " + "OID_FILTRO_CAB," + "DESCRIPCION," + "APLIC_CONS_ROTAS," + "ACTIVO , aplic_busq_leg)" + " values " + "(" + "?," + "?," + "?," + "? , ?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_FILTRO_CAB, pers.getOID());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(APLIC_CONS_ROTAS, pers.isAplic_cons_rotas().booleanValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.isAplic_busq_leg()!=null)
			qInsert.setBoolean(APLIC_BUSQ_LEG, pers.isAplic_busq_leg());
		else
			qInsert.setBoolean(APLIC_BUSQ_LEG, false);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int DESCRIPCION = 1;
		final int APLIC_CONS_ROTAS = 2;
		final int ACTIVO = 3;
		final int APLIC_BUSQ_LEG = 4;
		final int OID_FILTRO_CAB = 5;

		FiltroLegCab pers = (FiltroLegCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhFiltroLegCab set " + "descripcion=?" + ",aplic_cons_rotas=?" + ",activo=? , aplic_busq_leg = ? " + " where " + " oid_filtro_cab=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FILTRO_CAB, pers.getOID());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(APLIC_CONS_ROTAS, pers.isAplic_cons_rotas().booleanValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.isAplic_busq_leg()!=null)
			qUpdate.setBoolean(APLIC_BUSQ_LEG, pers.isAplic_busq_leg());
		else
			qUpdate.setBoolean(APLIC_BUSQ_LEG, false);		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_FILTRO_CAB = 1;
		FiltroLegCab pers = (FiltroLegCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhFiltroLegCab " + " set activo=0 " + " where " + " oid_filtro_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FILTRO_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_FILTRO_CAB = 1;
		FiltroLegCab pers = (FiltroLegCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhFiltroLegCab " + " set activo=1 " + " where " + " oid_filtro_cab=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FILTRO_CAB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
		PreparedStatement ps = null;
		switch (aSelect) {
		case IDBObjetoPersistente.SELECT_BY_OID: {
			ps = this.selectByOID(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_BY_CODIGO: {
			ps = this.selectByCodigo(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_ALL_HELP: {
			ps = this.selectAllHelp(aCondiciones);
			break;
		}
		case DBFiltroLegCab.SELECT_BY_ACTIVOS_CONS_ROTAS: {
			ps = this.selectAllActivosConsRotas(aCondiciones);
			break;
		}	
		case SELECT_BY_FILTROS_POR_USU: {
			ps = this.selectByFiltrosPorUsu(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_FILTRO_CAB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhFiltroLegCab ");
		textSQL.append(" WHERE oid_filtro_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_FILTRO_CAB, oid);
		return querySelect;
	}

	
	private PreparedStatement selectAllActivosConsRotas(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhFiltroLegCab ");
		textSQL.append(" WHERE activo = 1 and aplic_cons_rotas = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}	
	
	private PreparedStatement selectByFiltrosPorUsu(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("select a.* from rhFiltroLegCab a , rhPerfilFilLegCab b , sePerfFuncUsu c , seUsuarios d ");
		textSQL.append(" where "); 
		textSQL.append("a.oid_filtro_cab=b.oid_filtro_cab "); 
		textSQL.append(" and a.activo=1 and b.activo=1 and ");
		textSQL.append(" c.oid_perfil_func = b.oid_perfil and c.activo=1 and ");
		textSQL.append("c.oid_usuario = d.oid_usuario and d.activo=1 and d.oid_usuario=? "); 
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Usuario usuario = (Usuario) aCondiciones;
		querySelect.setInt(1, usuario.getOID());
		return querySelect;
	}	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhFiltroLegCab ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_filtro_cab oid, descripcion codigo, descripcion descripcion ,activo ");
		textSQL.append(" from rhFiltroLegCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getFiltrosLegajosCabConsRotasPlanif(ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(FiltroLegCab.NICKNAME,
	             DBFiltroLegCab.SELECT_BY_ACTIVOS_CONS_ROTAS,
	             null,
	             new ListObserver(),
	             aSesion);
	  }  
	
	
	public static List getFiltrosLegajosCabByUSuario(ISesion aSesion,Usuario usuario) throws BaseException {
		  return (List) ObjetoLogico.getObjects(FiltroLegCab.NICKNAME,
	             DBFiltroLegCab.SELECT_BY_FILTROS_POR_USU,
	             usuario,
	             new ListObserver(),
	             aSesion);
	  }	
	  	
	
	

}
