package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.cip.bm.FechaPlanifCacheo;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBFechaPlanifCacheo extends DBObjetoPersistente {

	public static final String OID_FEC_PLANIF = "oid_fec_planif";
	public static final String OID_PROC_PLANIF = "oid_proc_planif";
	public static final String FECHA = "fecha";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_FECHA = 100;

	public DBFechaPlanifCacheo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_FEC_PLANIF = 1;
		final int OID_PROC_PLANIF = 2;
		final int FECHA = 3;
		final int ACTIVO = 4;

		FechaPlanifCacheo pers = (FechaPlanifCacheo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipFecPlanifCach " + " ( " + "OID_FEC_PLANIF," + "OID_PROC_PLANIF," + "FECHA," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_FEC_PLANIF, pers.getOID());
		qInsert.setInt(OID_PROC_PLANIF, pers.getProceso().getOID());
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PROC_PLANIF = 1;
		final int FECHA = 2;
		final int ACTIVO = 3;
		final int OID_FEC_PLANIF = 4;

		FechaPlanifCacheo pers = (FechaPlanifCacheo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipFecPlanifCach set " + "oid_proc_planif=?" + ",fecha=?" + ",activo=?" + " where "
				+ " oid_fec_planif=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FEC_PLANIF, pers.getOID());
		qUpdate.setInt(OID_PROC_PLANIF, pers.getProceso().getOID());
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_FEC_PLANIF = 1;
		FechaPlanifCacheo pers = (FechaPlanifCacheo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipFecPlanifCach " + " set activo=0 " + " where " + " oid_fec_planif=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FEC_PLANIF, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_FEC_PLANIF = 1;
		FechaPlanifCacheo pers = (FechaPlanifCacheo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipFecPlanifCach " + " set activo=1 " + " where " + " oid_fec_planif=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FEC_PLANIF, pers.getOID());
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
		case SELECT_BY_FECHA: {
			ps = this.selectByFecha(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_FEC_PLANIF = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipFecPlanifCach ");
		textSQL.append(" WHERE oid_fec_planif = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_FEC_PLANIF, oid);
		return querySelect;
	}

	private PreparedStatement selectByFecha(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipFecPlanifCach ");
		textSQL.append(" WHERE fecha = ? and activo=1  ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		java.util.Date fecha = (java.util.Date) aCondiciones;
		querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
		return querySelect;
	}
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipFecPlanifCach ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_fec_planif oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipFecPlanifCach");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static FechaPlanifCacheo getFechaPlanifCacheo(java.util.Date fecha, ISesion aSesion) throws BaseException {
		return (FechaPlanifCacheo) ObjetoLogico.getObjects(FechaPlanifCacheo.NICKNAME, DBFechaPlanifCacheo.SELECT_BY_FECHA, fecha,
				new ObjetoObservado(), aSesion);
	}
	

}
