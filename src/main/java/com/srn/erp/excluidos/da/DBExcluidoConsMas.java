package com.srn.erp.excluidos.da;

import java.sql.*;

import com.srn.erp.excluidos.bm.*;
import com.srn.erp.ventas.bm.PedidoCab;

import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.*;

public class DBExcluidoConsMas extends DBObjetoPersistente {

	public static final String OID_CONS_MAS = "oid_cons_mas";
	public static final String OID_INDIVIDUO = "oid_individuo";
	public static final String NRO_LOTE = "nro_lote";
	public static final String NRO_ORDEN = "nro_orden";
	public static final String FECHA = "fecha";
	public static final String ACTIVO = "activo";

	public static final int DELETE_FROM_FECHA = 100;

	public DBExcluidoConsMas() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CONS_MAS = 1;
		final int OID_INDIVIDUO = 2;
		final int NRO_LOTE = 3;
		final int NRO_ORDEN = 4;
		final int FECHA = 5;
		final int ACTIVO = 6;

		ExcluidoConsMas pers = (ExcluidoConsMas) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into excConsMasInd " + " ( " + "OID_CONS_MAS," + "OID_INDIVIDUO," + "NRO_LOTE," + "NRO_ORDEN," + "FECHA,"
				+ "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CONS_MAS, pers.getOID());
		qInsert.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		qInsert.setInt(NRO_LOTE, pers.getNro_lote().intValue());
		qInsert.setInt(NRO_ORDEN, pers.getNro_orden().intValue());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_INDIVIDUO = 1;
		final int NRO_LOTE = 2;
		final int NRO_ORDEN = 3;
		final int FECHA = 4;
		final int ACTIVO = 5;
		final int OID_CONS_MAS = 6;

		ExcluidoConsMas pers = (ExcluidoConsMas) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update excConsMasInd set " + "oid_individuo=?" + ",nro_lote=?" + ",nro_orden=?" + ",fecha=?" + ",activo=?"
				+ " where " + " oid_cons_mas=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONS_MAS, pers.getOID());
		qUpdate.setInt(OID_INDIVIDUO, pers.getIndividuo().getOID());
		qUpdate.setInt(NRO_LOTE, pers.getNro_lote().intValue());
		qUpdate.setInt(NRO_ORDEN, pers.getNro_orden().intValue());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CONS_MAS = 1;
		ExcluidoConsMas pers = (ExcluidoConsMas) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excConsMasInd " + " set activo=0 " + " where " + " oid_cons_mas=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONS_MAS, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CONS_MAS = 1;
		ExcluidoConsMas pers = (ExcluidoConsMas) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update excConsMasInd " + " set activo=1 " + " where " + " oid_cons_mas=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CONS_MAS, pers.getOID());
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
		case DELETE_FROM_FECHA: {
			ps = this.deleteFromFecha(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CONS_MAS = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excConsMasInd ");
		textSQL.append(" WHERE oid_cons_mas = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CONS_MAS, oid);
		return querySelect;
	}

	private PreparedStatement deleteFromFecha(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("delete FROM  excConsMasInd ");
		textSQL.append(" WHERE fecha <= ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		java.util.Date fecha = (java.util.Date) aCondiciones;
		querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  excConsMasInd ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_cons_mas oid, codigo,  descripcion ,activo ");
		textSQL.append(" from excConsMasInd");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static void borrarConsultasViejas(java.util.Date fecha, ISesion aSesion) throws BaseException {

		try {
			StringBuffer textSQL = new StringBuffer();

			textSQL.append("delete from excConsMasInd where fecha<=? ");

			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());

			querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
			querySelect.executeUpdate();
			querySelect.close();
		} catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}

}
