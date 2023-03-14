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

public class DBConfProgConcCF extends DBObjetoPersistente {

	public static final String OID_PROG_CONC = "oid_prog_conc";
	public static final String OID_CONCEPTO = "oid_concepto";
	public static final String NRO_MES = "nro_mes";
	public static final String DIA = "dia";
	public static final String MONTO = "monto";
	public static final String OID_MONEDA = "oid_moneda";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_CONCEPTO = 100;
	public static final int SELECT_BY_MES_DIAS_DESDE_MES_DIA_HASTA = 101;
	public static final int SELECT_BY_MES_DIA = 102;

	public DBConfProgConcCF() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PROG_CONC = 1;
		final int OID_CONCEPTO = 2;
		final int NRO_MES = 3;
		final int DIA = 4;
		final int MONTO = 5;
		final int OID_MONEDA = 6;
		final int ACTIVO = 7;

		ConfProgConcCF pers = (ConfProgConcCF) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cfProgConc " + " ( " + "OID_PROG_CONC," + "OID_CONCEPTO," + "NRO_MES," + "DIA," + "MONTO,"
				+ "OID_MONEDA," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PROG_CONC, pers.getOID());
		qInsert.setInt(OID_CONCEPTO, pers.getConcepto().getOID());
		qInsert.setInt(NRO_MES, pers.getNro_mes().intValue());
		qInsert.setInt(DIA, pers.getDia().intValue());
		qInsert.setDouble(MONTO, pers.getMonto().doubleValue());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CONCEPTO = 1;
		final int NRO_MES = 2;
		final int DIA = 3;
		final int MONTO = 4;
		final int OID_MONEDA = 5;
		final int ACTIVO = 6;
		final int OID_PROG_CONC = 7;

		ConfProgConcCF pers = (ConfProgConcCF) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cfProgConc set " + "oid_concepto=?" + ",nro_mes=?" + ",dia=?" + ",monto=?" + ",oid_moneda=?"
				+ ",activo=?" + " where " + " oid_prog_conc=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PROG_CONC, pers.getOID());
		qUpdate.setInt(OID_CONCEPTO, pers.getConcepto().getOID());
		qUpdate.setInt(NRO_MES, pers.getNro_mes().intValue());
		qUpdate.setInt(DIA, pers.getDia().intValue());
		qUpdate.setDouble(MONTO, pers.getMonto().doubleValue());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PROG_CONC = 1;
		ConfProgConcCF pers = (ConfProgConcCF) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cfProgConc " + " set activo=0 " + " where " + " oid_prog_conc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PROG_CONC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PROG_CONC = 1;
		ConfProgConcCF pers = (ConfProgConcCF) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cfProgConc " + " set activo=1 " + " where " + " oid_prog_conc=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PROG_CONC, pers.getOID());
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
		case SELECT_BY_CONCEPTO: {
			ps = this.selectByConcepto(aCondiciones);
			break;
		}
		case SELECT_BY_MES_DIAS_DESDE_MES_DIA_HASTA: {
			ps = this.selectMesDiaDesdeMesDiaHasta(aCondiciones);
			break;
		}
		case SELECT_BY_MES_DIA: {
			ps = this.selectMesDia(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PROG_CONC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cfProgConc ");
		textSQL.append(" WHERE oid_prog_conc = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PROG_CONC, oid);
		return querySelect;
	}

	private PreparedStatement selectByConcepto(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cfProgConc ");
		textSQL.append(" WHERE oid_concepto = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ConceptoCashFlow concepto = (ConceptoCashFlow) aCondiciones;
		querySelect.setInt(1, concepto.getOID());
		return querySelect;

	}

	private PreparedStatement selectMesDia(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cfProgConc z ");
		textSQL.append(" WHERE z.nro_mes = ? and z.dia = ? and z.activo = 1 ");
		textSQL.append(" and z.oid_concepto in (select oid_concepto from cfConceptos where activo = 1 and oid_concepto = z.oid_concepto) ");
		textSQL.append(" and oid_concepto in (select oid_concepto from cgEsceConc where activo = 1 and oid_escenario = ? and oid_concepto = z.oid_concepto) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		querySelect.setInt(1, (Integer) condiciones.get("NRO_MES"));
		querySelect.setInt(2, (Integer) condiciones.get("NRO_DIA"));
		EscenarioCashFlow escenario = (EscenarioCashFlow) condiciones.get(EscenarioCashFlow.NICKNAME);
		querySelect.setInt(3, escenario.getOID());
		return querySelect;

	}

	private PreparedStatement selectMesDiaDesdeMesDiaHasta(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cfProgConc ");
		textSQL.append(" WHERE nro_mes = ? and dia >= ? and dia <= ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ConceptoCashFlow concepto = (ConceptoCashFlow) aCondiciones;
		querySelect.setInt(1, concepto.getOID());
		return querySelect;

	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cfProgConc ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_prog_conc oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cfProgConc");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getConfProgConcCF(ConceptoCashFlow concepto, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(ConfProgConcCF.NICKNAME, DBConfProgConcCF.SELECT_BY_CONCEPTO, concepto, new ListObserver(),
				aSesion);
	}

	public static List getConfProgConcCF(Integer nroMes, Integer diaDesde, Integer diaHasta, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("NRO_MES", nroMes);
		condiciones.put("DIA_DESDE", diaDesde);
		condiciones.put("DIA_HASTA", diaHasta);

		return (List) ObjetoLogico.getObjects(ConfProgConcCF.NICKNAME, DBConfProgConcCF.SELECT_BY_MES_DIAS_DESDE_MES_DIA_HASTA,
				condiciones, new ListObserver(), aSesion);
	}

	public static List getConfProgConcCF(Integer nroMes, Integer nroDia, EscenarioCashFlow escenario, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("NRO_MES", nroMes);
		condiciones.put("NRO_DIA", nroDia);
		condiciones.put(EscenarioCashFlow.NICKNAME, escenario);

		return (List) ObjetoLogico.getObjects(ConfProgConcCF.NICKNAME, DBConfProgConcCF.SELECT_BY_MES_DIA, condiciones, new ListObserver(),
				aSesion);
	}

}
