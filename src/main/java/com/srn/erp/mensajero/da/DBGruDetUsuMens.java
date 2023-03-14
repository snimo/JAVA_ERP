package com.srn.erp.mensajero.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.mensajero.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBGruDetUsuMens extends DBObjetoPersistente {

	public static final String OID_GRUPO_DEST_DET = "oid_grupo_dest_det";
	public static final String OID_GRUPO_DEST_CAB = "oid_grupo_dest_cab";
	public static final String OID_USUARIO = "oid_usuario";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_GRUPO_DEST_CAB = 100;

	public DBGruDetUsuMens() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_DEST_DET = 1;
		final int OID_GRUPO_DEST_CAB = 2;
		final int OID_USUARIO = 3;
		final int ACTIVO = 4;

		GruDetUsuMens pers = (GruDetUsuMens) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into meGrupoDestDet " + " ( " + "OID_GRUPO_DEST_DET," + "OID_GRUPO_DEST_CAB," + "OID_USUARIO,"
				+ "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_GRUPO_DEST_DET, pers.getOID());
		qInsert.setInt(OID_GRUPO_DEST_CAB, pers.getGrupo_dest_cab().getOID());
		qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_GRUPO_DEST_CAB = 1;
		final int OID_USUARIO = 2;
		final int ACTIVO = 3;
		final int OID_GRUPO_DEST_DET = 4;

		GruDetUsuMens pers = (GruDetUsuMens) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update meGrupoDestDet set " + "oid_grupo_dest_cab=?" + ",oid_usuario=?" + ",activo=?" + " where "
				+ " oid_grupo_dest_det=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_DEST_DET, pers.getOID());
		qUpdate.setInt(OID_GRUPO_DEST_CAB, pers.getGrupo_dest_cab().getOID());
		qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_DEST_DET = 1;
		GruDetUsuMens pers = (GruDetUsuMens) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update meGrupoDestDet " + " set activo=0 " + " where " + " oid_grupo_dest_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_DEST_DET, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_GRUPO_DEST_DET = 1;
		GruDetUsuMens pers = (GruDetUsuMens) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update meGrupoDestDet " + " set activo=1 " + " where " + " oid_grupo_dest_det=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_GRUPO_DEST_DET, pers.getOID());
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
		case SELECT_BY_GRUPO_DEST_CAB: {
			ps = this.selectByGrupoDestCab(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_GRUPO_DEST_DET = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  meGrupoDestDet ");
		textSQL.append(" WHERE oid_grupo_dest_det = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_GRUPO_DEST_DET, oid);
		return querySelect;
	}

	private PreparedStatement selectByGrupoDestCab(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  meGrupoDestDet ");
		textSQL.append(" WHERE oid_grupo_dest_cab = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		GrupoUsuMens grupoUsuMens = (GrupoUsuMens) aCondiciones;
		querySelect.setInt(1, grupoUsuMens.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  meGrupoDestDet ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_grupo_dest_det oid, codigo,  descripcion ,activo ");
		textSQL.append(" from meGrupoDestDet");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getGrupoDetUsuarios(GrupoUsuMens grupoUsuMens, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(GruDetUsuMens.NICKNAME, DBGruDetUsuMens.SELECT_BY_GRUPO_DEST_CAB, grupoUsuMens,
				new ListObserver(), aSesion);
	}

}
