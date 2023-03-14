package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.rrhh.bm.CategPosibleLeg;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCategPosibleLeg extends DBObjetoPersistente {

	public static final String OID_CATEG_POS_LEG = "oid_categ_pos_leg";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String OID_CATEG_POSIBLE = "oid_categ_posible";
	public static final String FEC_DESDE = "fec_desde";
	public static final String FEC_HASTA = "fec_hasta";
	public static final String ACTIVO = "activo";
	public static final String OID_RANKEAR = "oid_rankear";

	public static final int SELECT_BY_LEGAJO = 100;
	public static final int SELECT_BY_LEGAJO_FECHA = 101;

	public DBCategPosibleLeg() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CATEG_POS_LEG = 1;
		final int OID_LEGAJO = 2;
		final int OID_CATEG_POSIBLE = 3;
		final int FEC_DESDE = 4;
		final int FEC_HASTA = 5;
		final int ACTIVO = 6;
		final int OID_RANKEAR = 7;

		CategPosibleLeg pers = (CategPosibleLeg) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhCategPosiLeg " + " ( " + "OID_CATEG_POS_LEG," + "OID_LEGAJO," + "OID_CATEG_POSIBLE," + "FEC_DESDE," + "FEC_HASTA," + "ACTIVO , OID_RANKEAR)" + " values " + "(" + "?,"
				+ "?," + "?," + "?," + "?," + "? , ?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CATEG_POS_LEG, pers.getOID());
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setInt(OID_CATEG_POSIBLE, pers.getCateg_posible().getOID());
		qInsert.setDate(FEC_DESDE, new java.sql.Date(pers.getFec_desde().getTime()));
		qInsert.setDate(FEC_HASTA, new java.sql.Date(pers.getFec_hasta().getTime()));
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getRankearCab()!=null)
			qInsert.setInt(OID_RANKEAR, pers.getRankearCab().getOID());
		else
			qInsert.setNull(OID_RANKEAR, Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LEGAJO = 1;
		final int OID_CATEG_POSIBLE = 2;
		final int FEC_DESDE = 3;
		final int FEC_HASTA = 4;
		final int ACTIVO = 5;
		final int OID_RANKEAR = 6;
		final int OID_CATEG_POS_LEG = 7;

		CategPosibleLeg pers = (CategPosibleLeg) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhCategPosiLeg set " + "oid_legajo=?" + ",oid_categ_posible=?" + ",fec_desde=?" + ",fec_hasta=?" + ",activo=? , oid_rankear = ? " + " where " + " oid_categ_pos_leg=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CATEG_POS_LEG, pers.getOID());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setInt(OID_CATEG_POSIBLE, pers.getCateg_posible().getOID());
		qUpdate.setDate(FEC_DESDE, new java.sql.Date(pers.getFec_desde().getTime()));
		qUpdate.setDate(FEC_HASTA, new java.sql.Date(pers.getFec_hasta().getTime()));
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getRankearCab()!=null)
			qUpdate.setInt(OID_RANKEAR, pers.getRankearCab().getOID());
		else
			qUpdate.setNull(OID_RANKEAR, Types.INTEGER);
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CATEG_POS_LEG = 1;
		CategPosibleLeg pers = (CategPosibleLeg) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhCategPosiLeg " + " set activo=0 " + " where " + " oid_categ_pos_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CATEG_POS_LEG, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_CATEG_POS_LEG = 1;
		CategPosibleLeg pers = (CategPosibleLeg) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhCategPosiLeg " + " set activo=1 " + " where " + " oid_categ_pos_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CATEG_POS_LEG, pers.getOID());
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
		case SELECT_BY_LEGAJO: {
			ps = this.selectByLegajo(aCondiciones);
			break;
		}
		case SELECT_BY_LEGAJO_FECHA: {
			ps = this.selectByLegajoFecha(aCondiciones);
			break;

		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_CATEG_POS_LEG = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhCategPosiLeg ");
		textSQL.append(" WHERE oid_categ_pos_leg = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CATEG_POS_LEG, oid);
		return querySelect;
	}

	private PreparedStatement selectByLegajoFecha(Object aCondiciones) throws BaseException, SQLException {
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhCategPosiLeg ");
		textSQL.append(" WHERE oid_legajo = ? and ? >= fec_desde and ? <= fec_hasta and activo=1 order by fec_desde desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhCategPosiLeg ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhCategPosiLeg ");
		textSQL.append(" WHERE oid_legajo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_categ_pos_leg oid,oid_legajo codigo, oid_categ_posible descripcion ,activo ");
		textSQL.append(" from rhCategPosiLeg");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getCategPosibleLeg(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(CategPosibleLeg.NICKNAME, DBCategPosibleLeg.SELECT_BY_LEGAJO, aLegajo, new ListObserver(), aSesion);
	}

	public static CategPosibleLeg getCategPosibleLeg(Legajo aLegajo, java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, aLegajo);
		condiciones.put("FECHA", fecha);
		return (CategPosibleLeg) ObjetoLogico.getObjects(CategPosibleLeg.NICKNAME, DBCategPosibleLeg.SELECT_BY_LEGAJO_FECHA, condiciones, new ObjetoObservado(), aSesion);
	}

}
