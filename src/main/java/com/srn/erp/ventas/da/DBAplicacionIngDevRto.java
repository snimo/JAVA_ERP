package com.srn.erp.ventas.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.ventas.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBAplicacionIngDevRto extends DBObjetoPersistente {

	public static final String OID_APLIC_ING_RTO = "oid_aplic_ing_rto";
	public static final String OID_REMITO_DET = "oid_remito_det";
	public static final String OID_DEV_DET = "oid_dev_det";
	public static final String CANTIDAD = "cantidad";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_DEV_DET_ACTIVOS = 100;

	public DBAplicacionIngDevRto() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_APLIC_ING_RTO = 1;
		final int OID_REMITO_DET = 2;
		final int OID_DEV_DET = 3;
		final int CANTIDAD = 4;
		final int ACTIVO = 5;

		AplicacionIngDevRto pers = (AplicacionIngDevRto) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veAplicIngDevRto " + " ( " + "OID_APLIC_ING_RTO," + "OID_REMITO_DET," + "OID_DEV_DET," + "CANTIDAD,"
				+ "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_APLIC_ING_RTO, pers.getOID());
		qInsert.setInt(OID_REMITO_DET, pers.getRemito_det().getOID());
		qInsert.setInt(OID_DEV_DET, pers.getDevolucion_det().getOID());
		qInsert.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_REMITO_DET = 1;
		final int OID_DEV_DET = 2;
		final int CANTIDAD = 3;
		final int ACTIVO = 4;
		final int OID_APLIC_ING_RTO = 5;

		AplicacionIngDevRto pers = (AplicacionIngDevRto) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veAplicIngDevRto set " + "oid_remito_det=?" + ",oid_dev_det=?" + ",cantidad=?" + ",activo=?" + " where "
				+ " oid_aplic_ing_rto=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_APLIC_ING_RTO, pers.getOID());
		qUpdate.setInt(OID_REMITO_DET, pers.getRemito_det().getOID());
		qUpdate.setInt(OID_DEV_DET, pers.getDevolucion_det().getOID());
		qUpdate.setDouble(CANTIDAD, pers.getCantidad().doubleValue());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_APLIC_ING_RTO = 1;
		AplicacionIngDevRto pers = (AplicacionIngDevRto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veAplicIngDevRto " + " set activo=0 " + " where " + " oid_aplic_ing_rto=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_APLIC_ING_RTO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_APLIC_ING_RTO = 1;
		AplicacionIngDevRto pers = (AplicacionIngDevRto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veAplicIngDevRto " + " set activo=1 " + " where " + " oid_aplic_ing_rto=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_APLIC_ING_RTO, pers.getOID());
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
		case SELECT_BY_DEV_DET_ACTIVOS: {
			ps = this.selectByDevDetActivos(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_APLIC_ING_RTO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veAplicIngDevRto ");
		textSQL.append(" WHERE oid_aplic_ing_rto = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_APLIC_ING_RTO, oid);
		return querySelect;
	}

	private PreparedStatement selectByDevDetActivos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veAplicIngDevRto ");
		textSQL.append(" WHERE oid_dev_det = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		DevolucionVtasDet devVtasDet = (DevolucionVtasDet) aCondiciones;
		querySelect.setInt(1, devVtasDet.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veAplicIngDevRto ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_aplic_ing_rto oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veAplicIngDevRto");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAplicacionesActivasIngDevDet(DevolucionVtasDet devolucionVtasDet, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AplicacionIngDevRto.NICKNAME, DBAplicacionIngDevRto.SELECT_BY_DEV_DET_ACTIVOS,
				devolucionVtasDet, new ListObserver(), aSesion);
	}

}
