package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.CategEvenAccesoLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBCategEvenAccesoLeg extends DBObjetoPersistente {

	public static final String OID_CATEG_EVE_LEG = "oid_categ_eve_leg";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String FEC_DESDE = "fec_desde";
	public static final String FEC_HASTA = "fec_hasta";
	public static final String TIPO_ACCESO = "tipo_acceso";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_LEGAJO_FECDESHAS = 100;

	public DBCategEvenAccesoLeg() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CATEG_EVE_LEG = 1;
		final int OID_LEGAJO = 2;
		final int FEC_DESDE = 3;
		final int FEC_HASTA = 4;
		final int TIPO_ACCESO = 5;
		final int ACTIVO = 6;

		CategEvenAccesoLeg pers = (CategEvenAccesoLeg) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipCategEveAccLeg " + " ( "
				+ "OID_CATEG_EVE_LEG," + "OID_LEGAJO," + "FEC_DESDE,"
				+ "FEC_HASTA," + "TIPO_ACCESO," + "ACTIVO)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CATEG_EVE_LEG, pers.getOID());
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setTimestamp(FEC_DESDE, new java.sql.Timestamp(pers.getFecha_desde().getTime()));
		qInsert.setTimestamp(FEC_HASTA, new java.sql.Timestamp(pers.getFecha_hasta().getTime()));
		qInsert.setString(TIPO_ACCESO, pers.getTipo_acceso());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_LEGAJO = 1;
		final int FEC_DESDE = 2;
		final int FEC_HASTA = 3;
		final int TIPO_ACCESO = 4;
		final int ACTIVO = 5;
		final int OID_CATEG_EVE_LEG = 6;

		CategEvenAccesoLeg pers = (CategEvenAccesoLeg) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipCategEveAccLeg set " + "oid_legajo=?"
				+ ",fec_desde=?" + ",fec_hasta=?" + ",tipo_acceso=?"
				+ ",activo=?" + " where " + " oid_categ_eve_leg=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CATEG_EVE_LEG, pers.getOID());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setTimestamp(FEC_DESDE, new java.sql.Timestamp(pers.getFecha_desde().getTime()));
		qUpdate.setTimestamp(FEC_HASTA, new java.sql.Timestamp(pers.getFecha_hasta().getTime()));
		qUpdate.setString(TIPO_ACCESO, pers.getTipo_acceso());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CATEG_EVE_LEG = 1;
		CategEvenAccesoLeg pers = (CategEvenAccesoLeg) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipCategEveAccLeg " + " set activo=0 "
				+ " where " + " oid_categ_eve_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CATEG_EVE_LEG, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CATEG_EVE_LEG = 1;
		CategEvenAccesoLeg pers = (CategEvenAccesoLeg) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipCategEveAccLeg " + " set activo=1 "
				+ " where " + " oid_categ_eve_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CATEG_EVE_LEG, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	public PreparedStatement prepararSelect(int aSelect, Object aCondiciones)
			throws BaseException, SQLException {
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
		case SELECT_BY_LEGAJO_FECDESHAS: {
			ps = this.selectByLegajoFecDesHas(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_CATEG_EVE_LEG = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCategEveAccLeg ");
		textSQL.append(" WHERE oid_categ_eve_leg = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CATEG_EVE_LEG, oid);
		return querySelect;
	}

	private PreparedStatement selectByLegajoFecDesde(Object aCondiciones)
	throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCategEveAccLeg ");
		textSQL.append(" WHERE oid_legajo = ? and fec_desde >= ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecHasta.getTime()));
		return querySelect;
	}	
		
	
	private PreparedStatement selectByLegajoFecDesHas(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCategEveAccLeg ");
		textSQL.append(" WHERE oid_legajo = ? and ? >=fec_desde and ? <=fec_hasta and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		querySelect.setInt(1, legajo.getOID());
		querySelect.setTimestamp(2, new java.sql.Timestamp(fecha.getTime()));
		querySelect.setTimestamp(3, new java.sql.Timestamp(fecha.getTime()));
		
		
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipCategEveAccLeg ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL
				.append("SELECT oid_categ_eve_leg oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipCategEveAccLeg");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getCategAccEventuales(Legajo legajo,
			java.util.Date fecha,
			ISesion aSesion)
			throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, legajo);
		condiciones.put("FECHA", fecha);
		return (List) ObjetoLogico.getObjects(CategEvenAccesoLeg.NICKNAME,
				DBCategEvenAccesoLeg.SELECT_BY_LEGAJO_FECDESHAS, condiciones,
				new ListObserver(), aSesion);
	}

}
