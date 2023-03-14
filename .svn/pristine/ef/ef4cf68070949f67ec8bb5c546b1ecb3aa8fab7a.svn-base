package com.srn.erp.conciTarjeta.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.conciTarjeta.bm.CabConciAutomatica;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBCabConciAutomatica extends DBObjetoPersistente {

	public static final String OID_CAB_CONCI_AUT = "oid_cab_conci_aut";
	public static final String OID_USUARIO = "oid_usuario";
	public static final String FECHA = "fecha";
	public static final String HORA = "hora";
	public static final String ACTIVO = "activo";

	public DBCabConciAutomatica() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CAB_CONCI_AUT = 1;
		final int OID_USUARIO = 2;
		final int FECHA = 3;
		final int HORA = 4;
		final int ACTIVO = 5;

		CabConciAutomatica pers = (CabConciAutomatica) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cTarCabConciAut " + " ( " + "OID_CAB_CONCI_AUT," + "OID_USUARIO," + "FECHA," + "HORA," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CAB_CONCI_AUT, pers.getOID());
		qInsert.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setString(HORA, pers.getHora());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_USUARIO = 1;
		final int FECHA = 2;
		final int HORA = 3;
		final int ACTIVO = 4;
		final int OID_CAB_CONCI_AUT = 5;

		CabConciAutomatica pers = (CabConciAutomatica) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cTarCabConciAut set " + "oid_usuario=?" + ",fecha=?" + ",hora=?" + ",activo=?" + " where "
				+ " oid_cab_conci_aut=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CAB_CONCI_AUT, pers.getOID());
		qUpdate.setInt(OID_USUARIO, pers.getUsuario().getOID());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setString(HORA, pers.getHora());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CAB_CONCI_AUT = 1;
		CabConciAutomatica pers = (CabConciAutomatica) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarCabConciAut " + " set activo=0 " + " where " + " oid_cab_conci_aut=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CAB_CONCI_AUT, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CAB_CONCI_AUT = 1;
		CabConciAutomatica pers = (CabConciAutomatica) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarCabConciAut " + " set activo=1 " + " where " + " oid_cab_conci_aut=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CAB_CONCI_AUT, pers.getOID());
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

		final int OID_CAB_CONCI_AUT = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarCabConciAut ");
		textSQL.append(" WHERE oid_cab_conci_aut = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CAB_CONCI_AUT, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarCabConciAut ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cab_conci_aut oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cTarCabConciAut");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
