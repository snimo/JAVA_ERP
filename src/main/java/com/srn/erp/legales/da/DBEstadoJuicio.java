package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.legales.bm.EstadoJuicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEstadoJuicio extends DBObjetoPersistente {

	public static final String OID_EST_JUICIO = "oid_est_juicio";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_DESCRIPCION = 100;

	public DBEstadoJuicio() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_EST_JUICIO = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;

		EstadoJuicio pers = (EstadoJuicio) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legEstadoJuicio " + " ( " + "OID_EST_JUICIO," + "CODIGO," + "DESCRIPCION," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_EST_JUICIO, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int OID_EST_JUICIO = 4;

		EstadoJuicio pers = (EstadoJuicio) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legEstadoJuicio set " + "codigo=?" + ",descripcion=?" + ",activo=?" + " where " + " oid_est_juicio=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EST_JUICIO, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_EST_JUICIO = 1;
		EstadoJuicio pers = (EstadoJuicio) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legEstadoJuicio " + " set activo=0 " + " where " + " oid_est_juicio=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EST_JUICIO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_EST_JUICIO = 1;
		EstadoJuicio pers = (EstadoJuicio) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legEstadoJuicio " + " set activo=1 " + " where " + " oid_est_juicio=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_EST_JUICIO, pers.getOID());
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
		case DBEstadoJuicio.SELECT_BY_DESCRIPCION: {
			ps = this.selectByDescripcion(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_ALL_HELP: {
			ps = this.selectAllHelp(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectEstadoJuicio(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_EST_JUICIO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legEstadoJuicio ");
		textSQL.append(" WHERE oid_est_juicio = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_EST_JUICIO, oid);
		return querySelect;
	}

	private PreparedStatement selectEstadoJuicio(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legEstadoJuicio ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByDescripcion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legEstadoJuicio ");
		textSQL.append(" WHERE descripcion = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String descripcion = (String) aCondiciones;
		querySelect.setString(1, descripcion);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legEstadoJuicio ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_est_juicio oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from legEstadoJuicio");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAllEstados(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(EstadoJuicio.NICKNAME, DBEstadoJuicio.SELECT_ALL, null, new ListObserver(), aSesion);
	}

	public static EstadoJuicio getEstadoJuicio(String descripcion, ISesion aSesion) throws BaseException {
		return (EstadoJuicio) ObjetoLogico.getObjects(EstadoJuicio.NICKNAME, DBEstadoJuicio.SELECT_BY_DESCRIPCION, descripcion, new ObjetoObservado(), aSesion);
	}

}
