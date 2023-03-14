package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.legales.bm.AudienciaJuicio;
import com.srn.erp.legales.bm.Juicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAudienciaJuicio extends DBObjetoPersistente {

	public static final String OID_AUD_JUICIO = "oid_aud_juicio";
	public static final String OID_JUICIO = "oid_juicio";
	public static final String FECHA = "fecha";
	public static final String HORA = "hora";
	public static final String PERSONA = "persona";
	public static final String OID_TIPO_AUD = "oid_tipo_aud";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_JUICIO = 100;

	public DBAudienciaJuicio() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_AUD_JUICIO = 1;
		final int OID_JUICIO = 2;
		final int FECHA = 3;
		final int HORA = 4;
		final int PERSONA = 5;
		final int OID_TIPO_AUD = 6;
		final int ACTIVO = 7;

		AudienciaJuicio pers = (AudienciaJuicio) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legAudJuicio " + " ( " + "OID_AUD_JUICIO," + "OID_JUICIO," + "FECHA," + "HORA," + "PERSONA," + "OID_TIPO_AUD," + "ACTIVO)" + " values " + "(" + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_AUD_JUICIO, pers.getOID());
		qInsert.setInt(OID_JUICIO, pers.getJuicio().getOID());
		if (pers.getFecha() != null)
			qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qInsert.setNull(FECHA, java.sql.Types.DATE);
		qInsert.setString(HORA, pers.getHora());
		qInsert.setString(PERSONA, pers.getPersona());
		if (pers.getTipo_audiencia() != null)
			qInsert.setInt(OID_TIPO_AUD, pers.getTipo_audiencia().getOID());
		else
			qInsert.setNull(OID_TIPO_AUD, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_JUICIO = 1;
		final int FECHA = 2;
		final int HORA = 3;
		final int PERSONA = 4;
		final int OID_TIPO_AUD = 5;
		final int ACTIVO = 6;
		final int OID_AUD_JUICIO = 7;

		AudienciaJuicio pers = (AudienciaJuicio) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legAudJuicio set " + "oid_juicio=?" + ",fecha=?" + ",hora=?" + ",persona=?" + ",oid_tipo_aud=?" + ",activo=?" + " where " + " oid_aud_juicio=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUD_JUICIO, pers.getOID());
		qUpdate.setInt(OID_JUICIO, pers.getJuicio().getOID());
		if (pers.getFecha() != null)
			qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qUpdate.setNull(FECHA, java.sql.Types.DATE);
		qUpdate.setString(HORA, pers.getHora());
		qUpdate.setString(PERSONA, pers.getPersona());
		if (pers.getTipo_audiencia() != null)
			qUpdate.setInt(OID_TIPO_AUD, pers.getTipo_audiencia().getOID());
		else
			qUpdate.setNull(OID_TIPO_AUD, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AUD_JUICIO = 1;
		AudienciaJuicio pers = (AudienciaJuicio) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legAudJuicio " + " set activo=0 " + " where " + " oid_aud_juicio=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUD_JUICIO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_AUD_JUICIO = 1;
		AudienciaJuicio pers = (AudienciaJuicio) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legAudJuicio " + " set activo=1 " + " where " + " oid_aud_juicio=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_AUD_JUICIO, pers.getOID());
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

		final int OID_AUD_JUICIO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legAudJuicio ");
		textSQL.append(" WHERE oid_aud_juicio = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_AUD_JUICIO, oid);
		return querySelect;
	}

	private PreparedStatement selectByJuicio(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legAudJuicio ");
		textSQL.append(" WHERE oid_juicio = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Juicio juicio = (Juicio) aCondiciones;
		querySelect.setInt(1, juicio.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legAudJuicio ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_aud_juicio oid, codigo,  descripcion ,activo ");
		textSQL.append(" from legAudJuicio");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAudienciasJuicio(Juicio aJuicio, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AudienciaJuicio.NICKNAME, DBAudienciaJuicio.SELECT_BY_JUICIO, aJuicio, new ListObserver(), aSesion);
	}

}
