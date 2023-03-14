package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.ctasAPagar.bm.EsquemaAutorizFactProv;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBEsquemaAutorizFactProv extends DBObjetoPersistente {

	public static final String	OID_ESQ_AUT_FACT	= "oid_esq_aut_fact";

	public static final String	CODIGO						= "codigo";

	public static final String	DESCRIPCION				= "descripcion";

	public static final String	OID_MONEDA				= "oid_moneda";

	public static final String	ACTIVO						= "activo";

	public DBEsquemaAutorizFactProv() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ESQ_AUT_FACT = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int OID_MONEDA = 4;
		final int ACTIVO = 5;

		EsquemaAutorizFactProv pers = (EsquemaAutorizFactProv) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpEsqAutFactProv " + " ( " + "OID_ESQ_AUT_FACT," + "CODIGO," + "DESCRIPCION,"
				+ "OID_MONEDA," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ESQ_AUT_FACT, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int OID_MONEDA = 3;
		final int ACTIVO = 4;
		final int OID_ESQ_AUT_FACT = 5;

		EsquemaAutorizFactProv pers = (EsquemaAutorizFactProv) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpEsqAutFactProv set " + "codigo=?" + ",descripcion=?" + ",oid_moneda=?" + ",activo=?"
				+ " where " + " oid_esq_aut_fact=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_AUT_FACT, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESQ_AUT_FACT = 1;
		EsquemaAutorizFactProv pers = (EsquemaAutorizFactProv) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpEsqAutFactProv " + " set activo=0 " + " where " + " oid_esq_aut_fact=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_AUT_FACT, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ESQ_AUT_FACT = 1;
		EsquemaAutorizFactProv pers = (EsquemaAutorizFactProv) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpEsqAutFactProv " + " set activo=1 " + " where " + " oid_esq_aut_fact=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ESQ_AUT_FACT, pers.getOID());
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

		final int OID_ESQ_AUT_FACT = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqAutFactProv ");
		textSQL.append(" WHERE oid_esq_aut_fact = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ESQ_AUT_FACT, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpEsqAutFactProv ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_esq_aut_fact oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from cpEsqAutFactProv");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
