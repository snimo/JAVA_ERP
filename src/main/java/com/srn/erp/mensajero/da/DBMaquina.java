package com.srn.erp.mensajero.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.mensajero.bm.Maquina;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBMaquina extends DBObjetoPersistente {

	public static final String OID_MAQUINA = "oid_maquina";
	public static final String NOMBRE = "nombre";
	public static final String DESCRIPCION = "descripcion";
	public static final String ES_IP_DINAMICA = "es_ip_dinamica";
	public static final String IP = "ip";
	public static final String ACTIVA = "activa";

	public DBMaquina() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_MAQUINA = 1;
		final int NOMBRE = 2;
		final int DESCRIPCION = 3;
		final int ES_IP_DINAMICA = 4;
		final int IP = 5;
		final int ACTIVA = 6;

		Maquina pers = (Maquina) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into geMaquinas " + " ( " + "OID_MAQUINA," + "NOMBRE," + "DESCRIPCION," + "ES_IP_DINAMICA," + "IP,"
				+ "ACTIVA)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_MAQUINA, pers.getOID());
		qInsert.setString(NOMBRE, pers.getNombre());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ES_IP_DINAMICA, pers.isEs_ip_dinamica().booleanValue());
		qInsert.setString(IP, pers.getIp());
		qInsert.setBoolean(ACTIVA, pers.isActiva().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int NOMBRE = 1;
		final int DESCRIPCION = 2;
		final int ES_IP_DINAMICA = 3;
		final int IP = 4;
		final int ACTIVA = 5;
		final int OID_MAQUINA = 6;

		Maquina pers = (Maquina) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update geMaquinas set " + "nombre=?" + ",descripcion=?" + ",es_ip_dinamica=?" + ",ip=?" + ",activa=?"
				+ " where " + " oid_maquina=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MAQUINA, pers.getOID());
		qUpdate.setString(NOMBRE, pers.getNombre());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ES_IP_DINAMICA, pers.isEs_ip_dinamica().booleanValue());
		qUpdate.setString(IP, pers.getIp());
		qUpdate.setBoolean(ACTIVA, pers.isActiva().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MAQUINA = 1;
		Maquina pers = (Maquina) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geMaquinas " + " set activa=0 " + " where " + " oid_maquina=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MAQUINA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_MAQUINA = 1;
		Maquina pers = (Maquina) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geMaquinas " + " set activa=1 " + " where " + " oid_maquina=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_MAQUINA, pers.getOID());
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

		final int OID_MAQUINA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geMaquinas ");
		textSQL.append(" WHERE oid_maquina = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_MAQUINA, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  geMaquinas ");
		textSQL.append(" WHERE nombre  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_maquina oid, nombre codigo,  descripcion ,activa activo ");
		textSQL.append(" from geMaquinas");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
