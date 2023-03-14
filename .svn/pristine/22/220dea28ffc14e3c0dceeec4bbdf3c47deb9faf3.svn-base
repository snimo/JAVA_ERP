package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.bm.SancionesLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBSancionesLegajo extends DBObjetoPersistente {

	public static final String OID_SANC_LEG = "oid_sanc_leg";
	public static final String OID_LEGAJO = "oid_legajo";
	public static final String OID_MOT_FALTA = "oid_mot_falta";
	public static final String OID_MOT_SANCION = "oid_mot_sancion";
	public static final String NRO_SANCION = "nro_sancion";
	public static final String FECHA = "fecha";
	public static final String FEC_SUSP_DESDE = "fec_susp_desde";
	public static final String FEC_REINTEGRO = "fec_reintegro";
	public static final String ACTIVO = "activo";

	public static final int SELECT_BY_LEGAJO = 100;
	public static final int SELECT_BY_LEGAJO_FEC_DES_HAS = 101;
	public static final int SELECT_BY_LEGAJO_FECDESHAS_RANK_NOV = 102;
	public static final int SELECT_BY_SUSP_DES_Y_REINT = 103;

	public DBSancionesLegajo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_SANC_LEG = 1;
		final int OID_LEGAJO = 2;
		final int OID_MOT_FALTA = 3;
		final int OID_MOT_SANCION = 4;
		final int NRO_SANCION = 5;
		final int FECHA = 6;
		final int FEC_SUSP_DESDE = 7;
		final int FEC_REINTEGRO = 8;
		final int ACTIVO = 9;

		SancionesLegajo pers = (SancionesLegajo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhSancionesLeg " + " ( " + "OID_SANC_LEG," + "OID_LEGAJO," + "OID_MOT_FALTA," + "OID_MOT_SANCION," + "NRO_SANCION," + "FECHA," + "FEC_SUSP_DESDE,"
				+ "FEC_REINTEGRO," + "ACTIVO)" + " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_SANC_LEG, pers.getOID());
		qInsert.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		if (pers.getMotivo_falta() != null)
			qInsert.setInt(OID_MOT_FALTA, pers.getMotivo_falta().getOID());
		else
			qInsert.setNull(OID_MOT_FALTA, java.sql.Types.INTEGER);
		if (pers.getMotivo_sancion() != null)
			qInsert.setInt(OID_MOT_SANCION, pers.getMotivo_sancion().getOID());
		else
			qInsert.setNull(OID_MOT_SANCION, java.sql.Types.INTEGER);
		if (pers.getNro_sancion() != null)
			qInsert.setInt(NRO_SANCION, pers.getNro_sancion().intValue());
		else
			qInsert.setNull(NRO_SANCION, Types.INTEGER);
		if (pers.getFecha() != null)
			qInsert.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qInsert.setNull(FECHA, Types.DATE);
		if (pers.getFec_susp_desde() != null)
			qInsert.setDate(FEC_SUSP_DESDE, new java.sql.Date(pers.getFec_susp_desde().getTime()));
		else
			qInsert.setNull(FEC_SUSP_DESDE, Types.DATE);
		if (pers.getFec_reintegro() != null)
			qInsert.setDate(FEC_REINTEGRO, new java.sql.Date(pers.getFec_reintegro().getTime()));
		else
			qInsert.setNull(FEC_REINTEGRO, Types.DATE);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LEGAJO = 1;
		final int OID_MOT_FALTA = 2;
		final int OID_MOT_SANCION = 3;
		final int NRO_SANCION = 4;
		final int FECHA = 5;
		final int FEC_SUSP_DESDE = 6;
		final int FEC_REINTEGRO = 7;
		final int ACTIVO = 8;
		final int OID_SANC_LEG = 9;

		SancionesLegajo pers = (SancionesLegajo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhSancionesLeg set " + "oid_legajo=?" + ",oid_mot_falta=?" + ",oid_mot_sancion=?" + ",nro_sancion=?" + ",fecha=?" + ",fec_susp_desde=?" + ",fec_reintegro=?"
				+ ",activo=?" + " where " + " oid_sanc_leg=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SANC_LEG, pers.getOID());
		qUpdate.setInt(OID_LEGAJO, pers.getLegajo().getOID());
		if (pers.getMotivo_falta() != null)
			qUpdate.setInt(OID_MOT_FALTA, pers.getMotivo_falta().getOID());
		else
			qUpdate.setNull(OID_MOT_FALTA, java.sql.Types.INTEGER);
		if (pers.getMotivo_sancion() != null)
			qUpdate.setInt(OID_MOT_SANCION, pers.getMotivo_sancion().getOID());
		else
			qUpdate.setNull(OID_MOT_SANCION, java.sql.Types.INTEGER);
		if (pers.getNro_sancion() != null)
			qUpdate.setInt(NRO_SANCION, pers.getNro_sancion().intValue());
		else
			qUpdate.setNull(NRO_SANCION, Types.INTEGER);
		if (pers.getFecha() != null)
			qUpdate.setDate(FECHA, new java.sql.Date(pers.getFecha().getTime()));
		else
			qUpdate.setNull(FECHA, Types.DATE);
		if (pers.getFec_susp_desde() != null)
			qUpdate.setDate(FEC_SUSP_DESDE, new java.sql.Date(pers.getFec_susp_desde().getTime()));
		else
			qUpdate.setNull(FEC_SUSP_DESDE, Types.DATE);
		if (pers.getFec_reintegro() != null)
			qUpdate.setDate(FEC_REINTEGRO, new java.sql.Date(pers.getFec_reintegro().getTime()));
		else
			qUpdate.setNull(FEC_REINTEGRO, Types.DATE);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_SANC_LEG = 1;
		SancionesLegajo pers = (SancionesLegajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhSancionesLeg " + " set activo=0 " + " where " + " oid_sanc_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SANC_LEG, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_SANC_LEG = 1;
		SancionesLegajo pers = (SancionesLegajo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhSancionesLeg " + " set activo=1 " + " where " + " oid_sanc_leg=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_SANC_LEG, pers.getOID());
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
		case SELECT_BY_LEGAJO_FEC_DES_HAS: {
			ps = this.selectByLegajoFecDesHas(aCondiciones);
			break;
		}
		case SELECT_BY_LEGAJO_FECDESHAS_RANK_NOV: {
			ps = this.selectByLegajoFecDesHasRankNov(aCondiciones);
			break;
		}
		case SELECT_BY_SUSP_DES_Y_REINT: {
			ps = this.selectBySuspDesdeYReint(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_SANC_LEG = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhSancionesLeg ");
		textSQL.append(" WHERE oid_sanc_leg = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_SANC_LEG, oid);
		return querySelect;
	}

	private PreparedStatement selectByLegajoFecDesHasRankNov(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		
		textSQL.append(" select "); 
		textSQL.append("  a.* "); 
		textSQL.append(" from "); 
		textSQL.append("  rhSancionesLeg a, ");
		textSQL.append("  rhCondMinSanc b "); 
		textSQL.append(" where ");  
		textSQL.append("  b.oid_rankear = ? and ");
		textSQL.append("  b.nro_novedad = ? and ");
		textSQL.append("  a.activo = 1 and "); 
		textSQL.append("  b.activo = 1 and ");
		textSQL.append("  a.oid_legajo = ? and ");
		textSQL.append("  a.oid_mot_sancion = b.oid_mot_sancion and ");
		textSQL.append("  a.fecha>=? and a.fecha<=? ");		
		
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		RankearCab rankear = (RankearCab) condiciones.get(RankearCab.NICKNAME);
		Integer nroNovedad = (Integer) condiciones.get("NRO_NOVEDAD");
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fechaDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		
		querySelect.setInt(1, rankear.getOID());
		querySelect.setInt(2, nroNovedad.intValue());
		querySelect.setInt(3, legajo.getOID());
		querySelect.setDate(4, new java.sql.Date(fechaDesde.getTime()));
		querySelect.setDate(5, new java.sql.Date(fechaHasta.getTime()));
		return querySelect;
	}
	
	private PreparedStatement selectBySuspDesdeYReint(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhSancionesLeg ");
		textSQL.append(" WHERE oid_legajo = ? and activo=1 and ?>=fec_susp_desde and ?<fec_reintegro ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fecha1 = (java.util.Date) condiciones.get("FECHA1");
		java.util.Date fecha2 = (java.util.Date) condiciones.get("FECHA2");
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fecha1.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecha2.getTime()));
		return querySelect;
	}
	
	private PreparedStatement selectByLegajoFecDesHas(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhSancionesLeg ");
		textSQL.append(" WHERE oid_legajo = ? and activo=1 and fecha>=? and fecha<=? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
		java.util.Date fechaDesde = (java.util.Date) condiciones.get("FECHA_DESDE");
		java.util.Date fechaHasta = (java.util.Date) condiciones.get("FECHA_HASTA");
		querySelect.setInt(1, legajo.getOID());
		querySelect.setDate(2, new java.sql.Date(fechaDesde.getTime()));
		querySelect.setDate(3, new java.sql.Date(fechaHasta.getTime()));
		return querySelect;
	}

	private PreparedStatement selectByLegajo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhSancionesLeg ");
		textSQL.append(" WHERE oid_legajo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Legajo legajo = (Legajo) aCondiciones;
		querySelect.setInt(1, legajo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhSancionesLeg ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_sanc_leg oid, codigo, oid_mot_falta descripcion ,activo ");
		textSQL.append(" from rhSancionesLeg");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getSancionesLegajos(Legajo aLegajo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(SancionesLegajo.NICKNAME, DBSancionesLegajo.SELECT_BY_LEGAJO, aLegajo, new ListObserver(), aSesion);
	}
	
	public static List getSancionesLegajos(
			Legajo aLegajo,
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, aLegajo);
		condiciones.put("FECHA_DESDE", fechaDesde);
		condiciones.put("FECHA_HASTA", fechaHasta);
		return 
		(List) ObjetoLogico.getObjects(
				SancionesLegajo.NICKNAME, 
				DBSancionesLegajo.SELECT_BY_LEGAJO_FEC_DES_HAS, 
				condiciones, new ListObserver(), 
				aSesion);
	}
	
	
	public static List getSancionesLegajosFecSuspDesdeYReintegro(
			Legajo aLegajo,
			java.util.Date fecha,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(Legajo.NICKNAME, aLegajo);
		condiciones.put("FECHA1", fecha);
		condiciones.put("FECHA2", fecha);
		return (List) ObjetoLogico.getObjects(
				SancionesLegajo.NICKNAME, 
				DBSancionesLegajo.SELECT_BY_SUSP_DES_Y_REINT, 
				condiciones, new ListObserver(), 
				aSesion);
	}	
		
	public static List getSancionesLegajos(
			Integer nroNovedad,
			RankearCab ranquear,
			Legajo aLegajo,
			java.util.Date fechaDesde,
			java.util.Date fechaHasta,
			ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(RankearCab.NICKNAME, ranquear);
		condiciones.put("NRO_NOVEDAD", nroNovedad);
		condiciones.put(Legajo.NICKNAME, aLegajo);
		condiciones.put("FECHA_DESDE", fechaDesde);
		condiciones.put("FECHA_HASTA", fechaHasta);
		return 
		(List) ObjetoLogico.getObjects(
				SancionesLegajo.NICKNAME, 
				DBSancionesLegajo.SELECT_BY_LEGAJO_FECDESHAS_RANK_NOV, 
				condiciones, new ListObserver(), 
				aSesion);
	}
	
	

}
