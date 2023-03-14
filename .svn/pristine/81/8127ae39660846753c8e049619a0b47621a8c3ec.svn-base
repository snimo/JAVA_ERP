package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.legales.bm.DocuEnvJuicio;
import com.srn.erp.legales.bm.Juicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBDocuEnvJuicio extends DBObjetoPersistente {

	public static final String OID_DOC_ENV_JUICIO = "oid_doc_env_juicio";
	public static final String OID_JUICIO = "oid_juicio";
	public static final String FECHA_ENVIO = "fecha_envio";
	public static final String DOCUMENTACION = "documentacion";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_JUICIO = 100;

	public DBDocuEnvJuicio() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_DOC_ENV_JUICIO = 1;
		final int OID_JUICIO = 2;
		final int FECHA_ENVIO = 3;
		final int DOCUMENTACION = 4;
		final int ACTIVO = 5;

		DocuEnvJuicio pers = (DocuEnvJuicio) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legDocEnvJuicio " + " ( " + "OID_DOC_ENV_JUICIO," + "OID_JUICIO," + "FECHA_ENVIO," + "DOCUMENTACION," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?,"
				+ "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_DOC_ENV_JUICIO, pers.getOID());
		qInsert.setInt(OID_JUICIO, pers.getJuicio().getOID());
		qInsert.setDate(FECHA_ENVIO, new java.sql.Date(pers.getFecha_envio().getTime()));
		qInsert.setString(DOCUMENTACION, pers.getDocumentacion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_JUICIO = 1;
		final int FECHA_ENVIO = 2;
		final int DOCUMENTACION = 3;
		final int ACTIVO = 4;
		final int OID_DOC_ENV_JUICIO = 5;

		DocuEnvJuicio pers = (DocuEnvJuicio) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legDocEnvJuicio set " + "oid_juicio=?" + ",fecha_envio=?" + ",documentacion=?" + ",activo=?" + " where " + " oid_doc_env_juicio=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DOC_ENV_JUICIO, pers.getOID());
		qUpdate.setInt(OID_JUICIO, pers.getJuicio().getOID());
		qUpdate.setDate(FECHA_ENVIO, new java.sql.Date(pers.getFecha_envio().getTime()));
		qUpdate.setString(DOCUMENTACION, pers.getDocumentacion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_DOC_ENV_JUICIO = 1;
		DocuEnvJuicio pers = (DocuEnvJuicio) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legDocEnvJuicio " + " set activo=0 " + " where " + " oid_doc_env_juicio=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DOC_ENV_JUICIO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_DOC_ENV_JUICIO = 1;
		DocuEnvJuicio pers = (DocuEnvJuicio) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legDocEnvJuicio " + " set activo=1 " + " where " + " oid_doc_env_juicio=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DOC_ENV_JUICIO, pers.getOID());
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
		case SELECT_BY_JUICIO: {
			ps = this.selectByJuicio(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_DOC_ENV_JUICIO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legDocEnvJuicio ");
		textSQL.append(" WHERE oid_doc_env_juicio = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_DOC_ENV_JUICIO, oid);
		return querySelect;
	}

	private PreparedStatement selectByJuicio(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legDocEnvJuicio ");
		textSQL.append(" WHERE oid_juicio = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Juicio juicio = (Juicio) aCondiciones;
		querySelect.setInt(1, juicio.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legDocEnvJuicio ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_doc_env_juicio oid, codigo,  descripcion ,activo ");
		textSQL.append(" from legDocEnvJuicio");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getDocuEnvJuicio(Juicio juicio,
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(DocuEnvJuicio.NICKNAME,
                 DBDocuEnvJuicio.SELECT_BY_JUICIO,
                 juicio,
                 new ListObserver(),
                 aSesion);
	}
	

}
