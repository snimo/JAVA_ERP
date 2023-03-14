package com.srn.erp.cashflow.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.cashflow.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBVistaCashFlow extends DBObjetoPersistente {

	public static final String OID_VISTA_CF = "oid_vista_cf";
	public static final String OID_PROG_CF = "oid_prog_cf";
	public static final String OID_CONCEPTO = "oid_concepto";
	public static final String FECHA = "fecha";
	public static final String FEC_ORI = "fec_ori";
	public static final String IMPORTE = "importe";
	public static final String OID_MONEDA = "oid_moneda";
	public static final String OID_GRUPO_CONCEPTO = "oid_grupo_concepto";
	public static final String OID_ESCENARIO = "oid_escenario";
	public static final String ACTIVO = "activo";
	public static final String DESCRIPCION = "descripcion";

	public static final int SELECT_BY_ESCENARIO_ACTIVAS = 100;

	public DBVistaCashFlow() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_VISTA_CF = 1;
		final int OID_PROG_CF = 2;
		final int OID_CONCEPTO = 3;
		final int FECHA = 4;
		final int FEC_ORI = 5;
		final int IMPORTE = 6;
		final int OID_MONEDA = 7;
		final int OID_GRUPO_CONCEPTO = 8;
		final int OID_ESCENARIO = 9;
		final int ACTIVO = 10;
		final int DESCRIPCION = 11;

		VistaCashFlow pers = (VistaCashFlow) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cfVistaCF " + " ( " + "OID_VISTA_CF," + "OID_PROG_CF," + "OID_CONCEPTO," + "FECHA," + "FEC_ORI,"
				+ "IMPORTE," + "OID_MONEDA," + "OID_GRUPO_CONCEPTO," + "OID_ESCENARIO," + "ACTIVO , DESCRIPCION)" + " values " + "(" + "?," + "?," + "?,"
				+ "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_VISTA_CF, pers.getOID());
		if (pers.getProg_cf()!=null)
			qInsert.setInt(OID_PROG_CF, pers.getProg_cf().getOID());
		else
			qInsert.setNull(OID_PROG_CF, java.sql.Types.INTEGER);
		if (pers.getConcepto_cf()!=null)
			qInsert.setInt(OID_CONCEPTO, pers.getConcepto_cf().getOID());
		else
			qInsert.setNull(OID_CONCEPTO, java.sql.Types.INTEGER);
		qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qInsert.setDate(FEC_ORI, new java.sql.Date(pers.getFecha_original().getTime()));
		qInsert.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setInt(OID_GRUPO_CONCEPTO, pers.getGrupo_concepto().getOID());
		qInsert.setInt(OID_ESCENARIO, pers.getEscenario_cf().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getDescripcion()!=null)
			qInsert.setString(DESCRIPCION, pers.getDescripcion());
		else
			qInsert.setString(DESCRIPCION, "");
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PROG_CF = 1;
		final int OID_CONCEPTO = 2;
		final int FECHA = 3;
		final int FEC_ORI = 4;
		final int IMPORTE = 5;
		final int OID_MONEDA = 6;
		final int OID_GRUPO_CONCEPTO = 7;
		final int OID_ESCENARIO = 8;
		final int ACTIVO = 9;
		final int DESCRIPCION = 10;
		final int OID_VISTA_CF = 11;

		VistaCashFlow pers = (VistaCashFlow) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cfVistaCF set " + "oid_prog_cf=?" + ",oid_concepto=?" + ",fecha=?" + ",fec_ori=?" + ",importe=?"
				+ ",oid_moneda=?" + ",oid_grupo_concepto=?" + ",oid_escenario=?" + ",activo=? , descripcion = ? " + " where " + " oid_vista_cf=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VISTA_CF, pers.getOID());
		if (pers.getProg_cf()!=null)
			qUpdate.setInt(OID_PROG_CF, pers.getProg_cf().getOID());
		else
			qUpdate.setNull(OID_PROG_CF, java.sql.Types.INTEGER);
		if (pers.getConcepto_cf()!=null)
			qUpdate.setInt(OID_CONCEPTO, pers.getConcepto_cf().getOID());
		else
			qUpdate.setNull(OID_CONCEPTO, java.sql.Types.INTEGER);
		qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		qUpdate.setDate(FEC_ORI, new java.sql.Date(pers.getFecha_original().getTime()));
		qUpdate.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.setInt(OID_GRUPO_CONCEPTO, pers.getGrupo_concepto().getOID());
		qUpdate.setInt(OID_ESCENARIO, pers.getEscenario_cf().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getDescripcion()!=null)
			qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		else
			qUpdate.setString(DESCRIPCION, "");
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VISTA_CF = 1;
		VistaCashFlow pers = (VistaCashFlow) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cfVistaCF " + " set activo=0 " + " where " + " oid_vista_cf=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VISTA_CF, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_VISTA_CF = 1;
		VistaCashFlow pers = (VistaCashFlow) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cfVistaCF " + " set activo=1 " + " where " + " oid_vista_cf=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VISTA_CF, pers.getOID());
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
		case SELECT_BY_ESCENARIO_ACTIVAS: {
			ps = this.selectByEscenarioActivas(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_VISTA_CF = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cfVistaCF ");
		textSQL.append(" WHERE oid_vista_cf = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_VISTA_CF, oid);
		return querySelect;
	}

	private PreparedStatement selectByEscenarioActivas(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cfVistaCF ");
		textSQL.append(" WHERE oid_escenario = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		EscenarioCashFlow escenario = (EscenarioCashFlow) aCondiciones;
		querySelect.setInt(1, escenario.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cfVistaCF ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_vista_cf oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cfVistaCF");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	  public static List getConceptosPlanificados(EscenarioCashFlow escenario, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(VistaCashFlow.NICKNAME, DBVistaCashFlow.SELECT_BY_ESCENARIO_ACTIVAS, escenario,
				new ListObserver(), aSesion);
	}
	

}
