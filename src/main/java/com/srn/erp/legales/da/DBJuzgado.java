package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.legales.bm.Juzgado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBJuzgado extends DBObjetoPersistente {

	public static final String OID_JUZGADO = "oid_juzgado";
	public static final String NRO = "nro";
	public static final String JUZGADO = "juzgado";
	public static final String DIRECCION = "direccion";
	public static final String OBSERVACION = "observacion";
	public static final String TELEFONO = "telefono";
	public static final String ACTIVO = "activo";
	
	
	public DBJuzgado() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_JUZGADO = 1;
		final int NRO = 2;
		final int JUZGADO = 3;
		final int DIRECCION = 4;
		final int OBSERVACION = 5;
		final int TELEFONO = 6;
		final int ACTIVO = 7;

		Juzgado pers = (Juzgado) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legJuzgado " + " ( " + "OID_JUZGADO," + "NRO," + "JUZGADO," + "DIRECCION," + "OBSERVACION," + "TELEFONO," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_JUZGADO, pers.getOID());
		qInsert.setString(NRO, pers.getNro());
		qInsert.setString(JUZGADO, pers.getJuzgado());
		qInsert.setString(DIRECCION, pers.getDireccion());
		qInsert.setString(OBSERVACION, pers.getObservacion());
		qInsert.setString(TELEFONO, pers.getTelefono());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int NRO = 1;
		final int JUZGADO = 2;
		final int DIRECCION = 3;
		final int OBSERVACION = 4;
		final int TELEFONO = 5;
		final int ACTIVO = 6;
		final int OID_JUZGADO = 7;

		Juzgado pers = (Juzgado) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legJuzgado set " + "nro=?" + ",juzgado=?" + ",direccion=?" + ",observacion=?" + ",telefono=?" + ",activo=?" + " where " + " oid_juzgado=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_JUZGADO, pers.getOID());
		qUpdate.setString(NRO, pers.getNro());
		qUpdate.setString(JUZGADO, pers.getJuzgado());
		qUpdate.setString(DIRECCION, pers.getDireccion());
		qUpdate.setString(OBSERVACION, pers.getObservacion());
		qUpdate.setString(TELEFONO, pers.getTelefono());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_JUZGADO = 1;
		Juzgado pers = (Juzgado) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legJuzgado " + " set activo=0 " + " where " + " oid_juzgado=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_JUZGADO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_JUZGADO = 1;
		Juzgado pers = (Juzgado) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legJuzgado " + " set activo=1 " + " where " + " oid_juzgado=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_JUZGADO, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_JUZGADO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legJuzgado ");
		textSQL.append(" WHERE oid_juzgado = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_JUZGADO, oid);
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legJuzgado ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legJuzgado ");
		textSQL.append(" WHERE nro = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_juzgado oid,nro codigo, direccion descripcion ,activo ");
		textSQL.append(" from legJuzgado");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAllJuzgados(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Juzgado.NICKNAME, DBJuzgado.SELECT_ALL, null, new ListObserver(), aSesion);
	}

}
