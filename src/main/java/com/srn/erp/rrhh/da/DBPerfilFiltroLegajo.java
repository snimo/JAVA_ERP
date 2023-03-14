package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.rrhh.bm.FiltroLegCab;
import com.srn.erp.rrhh.bm.PerfilFiltroLegajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class DBPerfilFiltroLegajo extends DBObjetoPersistente {

	public static final String OID_PERFIL_LEG_FILTRO = "oid_perfil_leg_filtro";
	public static final String OID_FILTRO_CAB = "oid_filtro_cab";
	public static final String OID_PERFIL = "oid_perfil";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_PERFIL = 100;
	private static final int SELECT_BY_USUARIO = 101;

	public DBPerfilFiltroLegajo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PERFIL_LEG_FILTRO = 1;
		final int OID_FILTRO_CAB = 2;
		final int OID_PERFIL = 3;
		final int ACTIVO = 4;

		PerfilFiltroLegajo pers = (PerfilFiltroLegajo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhPerfilFilLegCab " + " ( " + "OID_PERFIL_LEG_FILTRO," + "OID_FILTRO_CAB," + "OID_PERFIL," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PERFIL_LEG_FILTRO, pers.getOID());
		qInsert.setInt(OID_FILTRO_CAB, pers.getFiltro_legajo_cab().getOID());
		qInsert.setInt(OID_PERFIL, pers.getPerfil().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_FILTRO_CAB = 1;
		final int OID_PERFIL = 2;
		final int ACTIVO = 3;
		final int OID_PERFIL_LEG_FILTRO = 4;

		PerfilFiltroLegajo pers = (PerfilFiltroLegajo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhPerfilFilLegCab set " + "oid_filtro_cab=?" + ",oid_perfil=?" + ",activo=?" + " where " + " oid_perfil_leg_filtro=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERFIL_LEG_FILTRO, pers.getOID());
		qUpdate.setInt(OID_FILTRO_CAB, pers.getFiltro_legajo_cab().getOID());
		qUpdate.setInt(OID_PERFIL, pers.getPerfil().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PERFIL_LEG_FILTRO = 1;
		PerfilFiltroLegajo pers = (PerfilFiltroLegajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhPerfilFilLegCab " + " set activo=0 " + " where " + " oid_perfil_leg_filtro=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERFIL_LEG_FILTRO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PERFIL_LEG_FILTRO = 1;
		PerfilFiltroLegajo pers = (PerfilFiltroLegajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhPerfilFilLegCab " + " set activo=1 " + " where " + " oid_perfil_leg_filtro=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PERFIL_LEG_FILTRO, pers.getOID());
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
		case SELECT_BY_PERFIL: {
			ps = this.selectByPerfil(aCondiciones);
			break;			
		}
		case SELECT_BY_USUARIO: {
			ps = this.selectByUsuario(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PERFIL_LEG_FILTRO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhPerfilFilLegCab ");
		textSQL.append(" WHERE oid_perfil_leg_filtro = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PERFIL_LEG_FILTRO, oid);
		return querySelect;
	}

	
	private PreparedStatement selectByPerfil(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhPerfilFilLegCab ");
		textSQL.append(" WHERE oid_filtro_cab = ? and activo = 1");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		FiltroLegCab filtro = (FiltroLegCab) aCondiciones;
		querySelect.setInt(1, filtro.getOID());
		return querySelect;
	}	
	
	private PreparedStatement selectByUsuario(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		
		textSQL.append(" select a.* from rhFiltroLegCab a , rhPerfilFilLegCab b , sePerfFuncUsu c , seUsuarios d ");
		textSQL.append("  where "); 
		textSQL.append("  a.oid_filtro_cab=b.oid_filtro_cab "); 
		textSQL.append("  and a.activo=1 and b.activo=1 and ");
		textSQL.append("   c.oid_perfil_func = b.oid_perfil and c.activo=1 and ");
		textSQL.append("  c.oid_usuario = d.oid_usuario and d.activo=1 and d.oid_usuario=? ");
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Usuario usuario = (Usuario) aCondiciones;
		querySelect.setInt(1, usuario.getOID());
		return querySelect;
	}	
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhPerfilFilLegCab ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_perfil_leg_filtro oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhPerfilFilLegCab");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getPerfilesFiltroLegajo(
			  FiltroLegCab filtro,
              ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PerfilFiltroLegajo.NICKNAME,
                 DBPerfilFiltroLegajo.SELECT_BY_PERFIL,
                 filtro,
                 new ListObserver(),
                 aSesion);
	}	
	
	public static List getPerfilesFiltroLegajoByUsu(
			  Usuario aUsuario,
            ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PerfilFiltroLegajo.NICKNAME,
               DBPerfilFiltroLegajo.SELECT_BY_USUARIO,
               aUsuario,
               new ListObserver(),
               aSesion);
	}	

}
