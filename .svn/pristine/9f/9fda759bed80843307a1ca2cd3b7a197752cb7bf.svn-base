package com.srn.erp.cip.da;

import java.sql.*;
import com.srn.erp.cip.bm.*;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.*;

public class DBPrepararLB extends DBObjetoPersistente {

	public static final String OID_PREP_LB = "oid_prep_lb";
	public static final String OID_PUERTA = "oid_puerta";
	public static final String FECHA_PREP = "fecha_prep";
	public static final String HORA_PREP = "hora_prep";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_PUERTA = 100;

	public DBPrepararLB() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PREP_LB = 1;
		final int OID_PUERTA = 2;
		final int FECHA_PREP = 3;
		final int HORA_PREP = 4;
		final int ACTIVO = 5;

		PrepararLB pers = (PrepararLB) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipPrepararLB " + " ( " + "OID_PREP_LB," + "OID_PUERTA," + "FECHA_PREP," + "HORA_PREP," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PREP_LB, pers.getOID());
		qInsert.setInt(OID_PUERTA, pers.getPuerta().getOID());
		if (pers.getFecha_preparacion() != null)
			qInsert.setDate(FECHA_PREP, new java.sql.Date(pers.getFecha_preparacion().getTime()));
		else
			qInsert.setNull(FECHA_PREP, java.sql.Types.DATE);
		qInsert.setString(HORA_PREP, pers.getHora_prep());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PUERTA = 1;
		final int FECHA_PREP = 2;
		final int HORA_PREP = 3;
		final int ACTIVO = 4;
		final int OID_PREP_LB = 5;

		PrepararLB pers = (PrepararLB) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipPrepararLB set " + "oid_puerta=?" + ",fecha_prep=?" + ",hora_prep=?" + ",activo=?" + " where "
				+ " oid_prep_lb=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PREP_LB, pers.getOID());
		qUpdate.setInt(OID_PUERTA, pers.getPuerta().getOID());
		if (pers.getFecha_preparacion() != null)
			qUpdate.setDate(FECHA_PREP, new java.sql.Date(pers.getFecha_preparacion().getTime()));
		else
			qUpdate.setNull(FECHA_PREP, java.sql.Types.DATE);
		qUpdate.setString(HORA_PREP, pers.getHora_prep());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PREP_LB = 1;
		PrepararLB pers = (PrepararLB) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPrepararLB " + " set activo=0 " + " where " + " oid_prep_lb=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PREP_LB, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PREP_LB = 1;
		PrepararLB pers = (PrepararLB) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPrepararLB " + " set activo=1 " + " where " + " oid_prep_lb=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PREP_LB, pers.getOID());
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
		case SELECT_BY_PUERTA: {
			ps = this.selectByPuerta(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PREP_LB = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPrepararLB ");
		textSQL.append(" WHERE oid_prep_lb = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PREP_LB, oid);
		return querySelect;
	}

	private PreparedStatement selectByPuerta(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPrepararLB ");
		textSQL.append(" WHERE oid_puerta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Puerta puerta = (Puerta) aCondiciones;
		querySelect.setInt(1, puerta.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPrepararLB ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_prep_lb oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipPrepararLB");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static PrepararLB getPrepararLB(Puerta puerta, ISesion aSesion) throws BaseException {
		return (PrepararLB) ObjetoLogico
				.getObjects(PrepararLB.NICKNAME, DBPrepararLB.SELECT_BY_PUERTA, puerta, new ObjetoObservado(), aSesion);
	}
	

}
