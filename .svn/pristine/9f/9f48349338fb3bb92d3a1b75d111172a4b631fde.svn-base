package com.srn.erp.Ausentismo.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneral;
import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralDesc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBGrupoRRHHGeneralDesc extends DBObjetoPersistente {

	public static final String OID_GRUPO_GRAL_DESC = "oid_grupo_gral_desc";
	public static final String OID_GRUPO_GRAL = "oid_grupo_gral";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";

	private static final int SELECT_BY_GRUPO_GENERAL = 100;

	public DBGrupoRRHHGeneralDesc() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_GRAL_DESC = 1;
		final int OID_GRUPO_GRAL = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;

		GrupoRRHHGeneralDesc pers = (GrupoRRHHGeneralDesc) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhoGrupoGralDesc " + " ( " + "OID_GRUPO_GRAL_DESC," + "OID_GRUPO_GRAL," + "DESCRIPCION," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GRUPO_GRAL_DESC, pers.getOID());
		qInsert.setInt(OID_GRUPO_GRAL, pers.getGrupogral().getOID());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_GRAL = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int OID_GRUPO_GRAL_DESC = 4;

		GrupoRRHHGeneralDesc pers = (GrupoRRHHGeneralDesc) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhoGrupoGralDesc set " + "oid_grupo_gral=?" + ",descripcion=?" + ",activo=?" + " where " + " oid_grupo_gral_desc=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_GRAL_DESC, pers.getOID());
		qUpdate.setInt(OID_GRUPO_GRAL, pers.getGrupogral().getOID());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_GRAL_DESC = 1;
		GrupoRRHHGeneralDesc pers = (GrupoRRHHGeneralDesc) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhoGrupoGralDesc " + " set activo=0 " + " where " + " oid_grupo_gral_desc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_GRAL_DESC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_GRAL_DESC = 1;
		GrupoRRHHGeneralDesc pers = (GrupoRRHHGeneralDesc) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhoGrupoGralDesc " + " set activo=1 " + " where " + " oid_grupo_gral_desc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_GRAL_DESC, pers.getOID());
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
			case DBGrupoRRHHGeneralDesc.SELECT_BY_GRUPO_GENERAL: {
				ps = this.selectByGrupoGral(aCondiciones);
				break;
			}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_GRUPO_GRAL_DESC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhoGrupoGralDesc ");
		textSQL.append(" WHERE oid_grupo_gral_desc = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRUPO_GRAL_DESC, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhoGrupoGralDesc ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_gral_desc oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhoGrupoGralDesc");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByGrupoGral(Object aCondiciones) throws BaseException, SQLException {
		GrupoRRHHGeneral grupoGral = (GrupoRRHHGeneral) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhoGrupoGralDesc ");
		textSQL.append(" WHERE oid_grupo_gral = " + grupoGral.getOIDInteger());
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List<GrupoRRHHGeneralDesc> getSelectByOidGrupoGral(ISesion aSesion, GrupoRRHHGeneral grupo) throws BaseException {
		return (List<GrupoRRHHGeneralDesc>) ObjetoLogico.getObjects(GrupoRRHHGeneralDesc.NICKNAME, DBGrupoRRHHGeneralDesc.SELECT_BY_GRUPO_GENERAL, grupo, new ListObserver(), aSesion);
	}
}
