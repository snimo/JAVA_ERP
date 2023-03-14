package com.srn.erp.legales.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.legales.bm.NegociacionLegales;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBNegociacionLegales extends DBObjetoPersistente {

	public static final String OID_NEGOCIACION = "oid_negociacion";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String FECHA = "fecha";
	public static final String OBSERVACION = "observacion";
	public static final String MONTO = "monto";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_LEGAJO = 100;
	public static final int SELECT_BY_NEG_EN_SEGUI = 101;

	public DBNegociacionLegales() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_NEGOCIACION = 1;
		final int OID_LEGAJO = 2;
		final int FECHA = 3;
		final int OBSERVACION = 4;
		final int MONTO = 5;
		final int ACTIVO = 6;

		NegociacionLegales pers = (NegociacionLegales) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into legNegociacion " + " ( " + "OID_NEGOCIACION," + "OID_LEGAJO," + "FECHA," + "OBSERVACION," + "MONTO," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?,"
				+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_NEGOCIACION, pers.getOID());
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		if (pers.getObservacion() != null)
			qInsert.setString(OBSERVACION, pers.getObservacion());
		else
			qInsert.setNull(OBSERVACION, Types.VARCHAR);
		if (pers.getMonto() != null)
			qInsert.setDouble(MONTO, pers.getMonto().doubleValue());
		else
			qInsert.setNull(MONTO, java.sql.Types.DOUBLE);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LEGAJO = 1;
		final int FECHA = 2;
		final int OBSERVACION = 3;
		final int MONTO = 4;
		final int ACTIVO = 5;
		final int OID_NEGOCIACION = 6;

		NegociacionLegales pers = (NegociacionLegales) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update legNegociacion set " + "oid_legajo=?" + ",fecha=?" + ",observacion=?" + ",monto=?" + ",activo=?" + " where " + " oid_negociacion=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_NEGOCIACION, pers.getOID());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		if (pers.getObservacion() != null)
			qUpdate.setString(OBSERVACION, pers.getObservacion());
		else
			qUpdate.setNull(OBSERVACION, Types.VARCHAR);
		if (pers.getMonto() != null)
			qUpdate.setDouble(MONTO, pers.getMonto().doubleValue());
		else
			qUpdate.setNull(MONTO, java.sql.Types.DOUBLE);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_NEGOCIACION = 1;
		NegociacionLegales pers = (NegociacionLegales) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legNegociacion " + " set activo=0 " + " where " + " oid_negociacion=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_NEGOCIACION, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_NEGOCIACION = 1;
		NegociacionLegales pers = (NegociacionLegales) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update legNegociacion " + " set activo=1 " + " where " + " oid_negociacion=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_NEGOCIACION, pers.getOID());
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
		case SELECT_BY_NEG_EN_SEGUI: {
			ps = this.selectByNegEnSegui(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_NEGOCIACION = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legNegociacion ");
		textSQL.append(" WHERE oid_negociacion = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_NEGOCIACION, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legNegociacion ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	private PreparedStatement selectByNegEnSegui(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legNegociacion ");
		textSQL.append(" WHERE activo = 1 and oid_legajo in (select oid_legajo from suLegajo where (segui_legales = 1 OR segui_cartas_docu = 1) and activo = 1 ) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}	
	
	
	

	private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  legNegociacion ");
		textSQL.append(" WHERE oid_legajo = ? and activo = 1 order by fecha desc ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_negociacion oid, codigo,  descripcion ,activo ");
		textSQL.append(" from legNegociacion");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getNegociaciones(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(NegociacionLegales.NICKNAME, DBNegociacionLegales.SELECT_BY_LEGAJO, aLegajo, new ListObserver(), aSesion);
	}
	
	public static List getNegociacionesEnSeguimiento(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(NegociacionLegales.NICKNAME, DBNegociacionLegales.SELECT_BY_NEG_EN_SEGUI, null, new ListObserver(), aSesion);
	}	

}
