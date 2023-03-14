package com.srn.erp.mensajero.da;

import java.sql.*;
import com.srn.erp.mensajero.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBInboxMensUsu extends DBObjetoPersistente {

	public static final String OID_INBOX_USU = "oid_inbox_usu";
	public static final String OID_USUARIO = "oid_usuario";
	public static final String OID_MENS_CAB = "oid_mens_cab";
	public static final String LEIDO = "leido";
	public static final String ELIMINADO = "eliminado";
	public static final String DEPURADO = "depurado";
	public static final String FEC_RECIBIDO = "fec_recibido";
	public static final String HORA_RECIBIDO = "hora_recibido";
	public static final String ACTIVO = "activo";

	public DBInboxMensUsu() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_INBOX_USU = 1;
		final int OID_USUARIO = 2;
		final int OID_MENS_CAB = 3;
		final int LEIDO = 4;
		final int ELIMINADO = 5;
		final int DEPURADO = 6;
		final int FEC_RECIBIDO = 7;
		final int HORA_RECIBIDO = 8;
		final int ACTIVO = 9;

		InboxMensUsu pers = (InboxMensUsu) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into meInboxUsu " + " ( " + "OID_INBOX_USU," + "OID_USUARIO," + "OID_MENS_CAB," + "LEIDO," + "ELIMINADO,"
				+ "DEPURADO," + "FEC_RECIBIDO," + "HORA_RECIBIDO," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_INBOX_USU, pers.getOID());
		qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qInsert.setInt(OID_MENS_CAB, pers.getMensaje().getOID());
		qInsert.setBoolean(LEIDO, pers.isLeido().booleanValue());
		qInsert.setBoolean(ELIMINADO, pers.isEliminado().booleanValue());
		qInsert.setBoolean(DEPURADO, pers.isDepurado().booleanValue());
		if (pers.getFec_recibido() != null)
			qInsert.setDate(FEC_RECIBIDO, new java.sql.Date(pers.getFec_recibido().getTime()));
		else
			qInsert.setNull(FEC_RECIBIDO, java.sql.Types.DATE);
		qInsert.setString(HORA_RECIBIDO, pers.getHora_recibido());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_USUARIO = 1;
		final int OID_MENS_CAB = 2;
		final int LEIDO = 3;
		final int ELIMINADO = 4;
		final int DEPURADO = 5;
		final int FEC_RECIBIDO = 6;
		final int HORA_RECIBIDO = 7;
		final int ACTIVO = 8;
		final int OID_INBOX_USU = 9;

		InboxMensUsu pers = (InboxMensUsu) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update meInboxUsu set " + "oid_usuario=?" + ",oid_mens_cab=?" + ",leido=?" + ",eliminado=?" + ",depurado=?"
				+ ",fec_recibido=?" + ",hora_recibido=?" + ",activo=?" + " where " + " oid_inbox_usu=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_INBOX_USU, pers.getOID());
		qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qUpdate.setInt(OID_MENS_CAB, pers.getMensaje().getOID());
		qUpdate.setBoolean(LEIDO, pers.isLeido().booleanValue());
		qUpdate.setBoolean(ELIMINADO, pers.isEliminado().booleanValue());
		qUpdate.setBoolean(DEPURADO, pers.isDepurado().booleanValue());
		if (pers.getFec_recibido() != null)
			qUpdate.setDate(FEC_RECIBIDO,new java.sql.Date(pers.getFec_recibido().getTime()));
		else
			qUpdate.setNull(FEC_RECIBIDO, java.sql.Types.DATE);
		qUpdate.setString(HORA_RECIBIDO, pers.getHora_recibido());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_INBOX_USU = 1;
		InboxMensUsu pers = (InboxMensUsu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update meInboxUsu " + " set activo=0 " + " where " + " oid_inbox_usu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_INBOX_USU, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_INBOX_USU = 1;
		InboxMensUsu pers = (InboxMensUsu) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update meInboxUsu " + " set activo=1 " + " where " + " oid_inbox_usu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_INBOX_USU, pers.getOID());
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
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_INBOX_USU = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  meInboxUsu ");
		textSQL.append(" WHERE oid_inbox_usu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_INBOX_USU, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  meInboxUsu ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_inbox_usu oid, codigo,  descripcion ,activo ");
		textSQL.append(" from meInboxUsu");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
