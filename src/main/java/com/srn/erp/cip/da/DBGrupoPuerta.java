package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.GrupoPuerta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBGrupoPuerta extends DBObjetoPersistente {

	public static final String OID_GRUPO_PUERTA = "oid_grupo_puerta";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";
	public static final String ES_PARA_CACHEO = "es_para_cacheo";
	public static final String HAB_PARA_ING_VISITA = "hab_para_ing_vis";
	

	public static final int SELECT_BY_HELP_ACTIVOS = 100;
	public static final int SELECT_BY_GRUPOS_DE_CACHEO = 101;
	public static final int SELECT_BY_HELP_GRUPO_PUE_CACH = 102;
	public static final int SELECT_BY_HELP_HAB_ING_VIS = 103;
	public static final int SELECT_BY_PERFIL_USUARIO = 104;

	public DBGrupoPuerta() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_PUERTA = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;
		final int ES_PARA_CACHEO = 5;
		final int HAB_PARA_ING_VISITA = 6;

		GrupoPuerta pers = (GrupoPuerta) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipGrupoPuertas " + " ( " + "OID_GRUPO_PUERTA," + "CODIGO," + "DESCRIPCION,"
				+ "ACTIVO , ES_PARA_CACHEO , hab_para_ing_vis)" + " values " + "(" + "?," + "?,"+ "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GRUPO_PUERTA, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.setBoolean(ES_PARA_CACHEO, pers.isParaCacheo());
		qInsert.setBoolean(HAB_PARA_ING_VISITA, pers.isHabParaIngVisita());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int ES_PARA_CACHEO = 4;
		final int HAB_PARA_ING_VISITA = 5;
		final int OID_GRUPO_PUERTA = 6;

		GrupoPuerta pers = (GrupoPuerta) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipGrupoPuertas set " + "codigo=?" + ",descripcion=?" + ",activo=?" + ",es_para_cacheo=? , hab_para_ing_vis = ?" + " where "
				+ " oid_grupo_puerta=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_PUERTA, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.setBoolean(ES_PARA_CACHEO, pers.isParaCacheo());
		qUpdate.setBoolean(HAB_PARA_ING_VISITA, pers.isHabParaIngVisita());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_PUERTA = 1;
		GrupoPuerta pers = (GrupoPuerta) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipGrupoPuertas " + " set activo=0 " + " where " + " oid_grupo_puerta=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_PUERTA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_PUERTA = 1;
		GrupoPuerta pers = (GrupoPuerta) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipGrupoPuertas " + " set activo=1 " + " where " + " oid_grupo_puerta=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_PUERTA, pers.getOID());
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
		case SELECT_BY_HELP_HAB_ING_VIS: {
			ps = this.selectHabIngVisita(aCondiciones);
			break;
		}
		case SELECT_BY_HELP_GRUPO_PUE_CACH: {
			ps = this.selectByHelpGrupoPueCach(aCondiciones);
			break;
		}
		case SELECT_BY_HELP_ACTIVOS: {
			ps = this.selectAllHelpActivos(aCondiciones);
			break;
		}
		case SELECT_BY_GRUPOS_DE_CACHEO: {
			ps = this.selectByGruposDeCacheo(aCondiciones);
			break;
		}
		case SELECT_BY_PERFIL_USUARIO: {
			ps = this.selectByPerfilUsuario(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_GRUPO_PUERTA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipGrupoPuertas ");
		textSQL.append(" WHERE oid_grupo_puerta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRUPO_PUERTA, oid);
		return querySelect;
	}

	private PreparedStatement selectAllHelpActivos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT oid_grupo_puerta oid,codigo codigo, descripcion descripcion ,activo FROM  cipGrupoPuertas ");
		textSQL.append(" WHERE activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipGrupoPuertas ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByGruposDeCacheo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipGrupoPuertas ");
		textSQL.append(" WHERE activo=1 and es_para_cacheo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByHelpGrupoPueCach(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_puerta oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from cipGrupoPuertas where activo=1 and es_para_cacheo = 1 ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByPerfilUsuario(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String accion = (String) condiciones.get("ACCION");
		String habilitar = (String) condiciones.get("HABILITAR");

		textSQL.append(" select * from cipGrupoPuertas where activo = 1 and oid_grupo_puerta in "); 
		textSQL.append(" ( ");
		textSQL.append(" select "); 
		textSQL.append("  c.oid_grupo_puerta ");
		textSQL.append(" from "); 
		textSQL.append("  sePerfFuncUsu a, ");
		textSQL.append("  sePerfilFunc b , ");
		textSQL.append("  cipPerfilGrupoPue c ");
		textSQL.append(" where ");
		textSQL.append("  a.oid_perfil_func = b.oid_perfil_func and ");
		textSQL.append("  a.activo = 1 and "); 
		textSQL.append("  b.activo = 1 and ");
		textSQL.append("  a.oid_usuario = "+this.getSesion().getLogin().getUsuario().getOID()+" and ");
		
		if (accion.equals("HABILITAR") && habilitar.equals("HAB_ING")) {
			textSQL.append("  c.hab_ing = 1 and ");
		} 
		
		if (accion.equals("HABILITAR") && habilitar.equals("HAB_EGR")) {
			textSQL.append("  c.hab_egr = 1 and ");
		}		
		
		if (accion.equals("HABILITAR") && habilitar.equals("AMBOS")) {
			textSQL.append("  c.hab_ambos = 1 and ");
		}		
		
		if (accion.equals("INHABILITAR") && habilitar.equals("DES_EGR")) {
			textSQL.append("  c.den_egr = 1 and ");
		}		
		
		if (accion.equals("INHABILITAR") && habilitar.equals("DES_ING")) {
			textSQL.append("  c.den_ing = 1 and ");
		}		
		
		if (accion.equals("INHABILITAR") && habilitar.equals("AMBOS")) {
			textSQL.append("  c.den_ambos = 1 and ");
		}		
		
		textSQL.append("  c.activo = 1 and ");
		textSQL.append("  c.oid_perfil_func = b.oid_perfil_func ");
		textSQL.append(" ) ");		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}	
	
	
	private PreparedStatement selectHabIngVisita(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_puerta oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from cipGrupoPuertas where hab_para_ing_vis = 1 and activo = 1 ");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	
	
	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_puerta oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from cipGrupoPuertas");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getGrupoPuertasCacheo(ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(GrupoPuerta.NICKNAME,
                 DBGrupoPuerta.SELECT_BY_GRUPOS_DE_CACHEO,
                 null,
                 new ListObserver(),
                 aSesion);
	}
	
	public static List getGrupoPuertasHabPermisosUsu(
			String accion,
			String habilitar,
			ISesion aSesion) throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put("ACCION", accion);
		  condiciones.put("HABILITAR", habilitar);
		  return (List) ObjetoLogico.getObjects(GrupoPuerta.NICKNAME,
               DBGrupoPuerta.SELECT_BY_PERFIL_USUARIO,
               condiciones,
               new ListObserver(),
               aSesion);
	}	
	

}
