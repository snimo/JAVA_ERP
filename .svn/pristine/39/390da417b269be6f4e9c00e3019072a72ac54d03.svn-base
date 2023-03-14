package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.legales.bm.DocEnvSeclo;
import com.srn.erp.legales.bm.Seclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBDocEnvSeclo extends DBObjetoPersistente {

	public static final String OID_DOC_ENV_SEC = "oid_doc_env_sec";
	public static final String OID_SECLO = "oid_seclo";
	public static final String FECHA_ENVIO = "fecha_envio";
	public static final String DOCUMENTACION = "documentacion";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_SECLOS = 100;

	public DBDocEnvSeclo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_DOC_ENV_SEC = 1;
		final int OID_SECLO = 2;
		final int FECHA_ENVIO = 3;
		final int DOCUMENTACION = 4;
		final int ACTIVO = 5;

		DocEnvSeclo pers = (DocEnvSeclo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legDocEnvSec " + " ( " + "OID_DOC_ENV_SEC," + "OID_SECLO," + "FECHA_ENVIO," + "DOCUMENTACION," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_DOC_ENV_SEC, pers.getOID());
		qInsert.setInt(OID_SECLO, pers.getSeclo().getOID());
		if (pers.getFecha_envio() != null)
			qInsert.setDate(FECHA_ENVIO, new java.sql.Date(pers.getFecha_envio().getTime()));
		else
			qInsert.setNull(FECHA_ENVIO, Types.DATE);
		qInsert.setString(DOCUMENTACION, pers.getDocumentacion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SECLO = 1;
		final int FECHA_ENVIO = 2;
		final int DOCUMENTACION = 3;
		final int ACTIVO = 4;
		final int OID_DOC_ENV_SEC = 5;

		DocEnvSeclo pers = (DocEnvSeclo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legDocEnvSec set " + "oid_seclo=?" + ",fecha_envio=?" + ",documentacion=?" + ",activo=?" + " where " + " oid_doc_env_sec=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DOC_ENV_SEC, pers.getOID());
		qUpdate.setInt(OID_SECLO, pers.getSeclo().getOID());
		if (pers.getFecha_envio() != null)
			qUpdate.setDate(FECHA_ENVIO, new java.sql.Date(pers.getFecha_envio().getTime()));
		else
			qUpdate.setNull(FECHA_ENVIO, Types.DATE);
		qUpdate.setString(DOCUMENTACION, pers.getDocumentacion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_DOC_ENV_SEC = 1;
		DocEnvSeclo pers = (DocEnvSeclo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legDocEnvSec " + " set activo=0 " + " where " + " oid_doc_env_sec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DOC_ENV_SEC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_DOC_ENV_SEC = 1;
		DocEnvSeclo pers = (DocEnvSeclo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legDocEnvSec " + " set activo=1 " + " where " + " oid_doc_env_sec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DOC_ENV_SEC, pers.getOID());
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
		case SELECT_BY_SECLOS: {
			ps = this.selectBySeclo(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_DOC_ENV_SEC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legDocEnvSec ");
		textSQL.append(" WHERE oid_doc_env_sec = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_DOC_ENV_SEC, oid);
		return querySelect;
	}

	private PreparedStatement selectBySeclo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legDocEnvSec ");
		textSQL.append(" WHERE oid_seclo = ? and activo = 1 order by fecha_envio desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Seclo seclo = (Seclo) aCondiciones;
		querySelect.setInt(1, seclo.getOID());
		return querySelect;

	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legDocEnvSec ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_doc_env_sec oid, codigo,  descripcion ,activo ");
		textSQL.append(" from legDocEnvSec");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDocEnvBySeclos(Seclo aSeclo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(DocEnvSeclo.NICKNAME, DBDocEnvSeclo.SELECT_BY_SECLOS, aSeclo, new ListObserver(), aSesion);
	}

}
