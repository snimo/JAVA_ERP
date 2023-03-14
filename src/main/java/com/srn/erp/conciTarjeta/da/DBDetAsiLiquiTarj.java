package com.srn.erp.conciTarjeta.da;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.conciTarjeta.bm.CabAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.DetAsiLiquiTarj;
import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBDetAsiLiquiTarj extends DBObjetoPersistente {

	public static final String OID_DET_ASI_LIQ = "oid_det_asi_liq";
	public static final String OID_CAB_ASI_LIQ = "oid_cab_asi_liq";
	public static final String ORDEN = "orden";
	public static final String CUENTA = "cuenta";
	public static final String DESC_CUENTA = "desc_cuenta";
	public static final String COMPO1 = "compo1";
	public static final String COMPO2 = "compo2";
	public static final String DEBE = "debe";
	public static final String HABER = "haber";
	public static final String ACTIVO = "activo";
	public static final String COMENTARIO = "comentario";

	public static final String COD_IMPUESTO = "cod_impu";
	public static final String PORC_IMPUESTO = "porc_impu";
	public static final String BASE = "base";

	public static final int SELECT_BY_CAB_ASI_LIQ = 100;
	public static final int SELECT_BY_CTA_FEC_DES_HAS = 101;

	public DBDetAsiLiquiTarj() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_DET_ASI_LIQ = 1;
		final int OID_CAB_ASI_LIQ = 2;
		final int ORDEN = 3;
		final int CUENTA = 4;
		final int DESC_CUENTA = 5;
		final int COMPO1 = 6;
		final int COMPO2 = 7;
		final int DEBE = 8;
		final int HABER = 9;
		final int ACTIVO = 10;
		final int COMENTARIO = 11;
		final int COD_IMPU = 12;
		final int PORC_IMPU = 13;
		final int BASE = 14;

		DetAsiLiquiTarj pers = (DetAsiLiquiTarj) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cTarDetAsiLiq " + " ( " + "OID_DET_ASI_LIQ," + "OID_CAB_ASI_LIQ," + "ORDEN," + "CUENTA,"
				+ "DESC_CUENTA," + "COMPO1," + "COMPO2," + "DEBE," + "HABER," + "ACTIVO,COMENTARIO,COD_IMPU,PORC_IMPU,BASE)" + " values "
				+ "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_DET_ASI_LIQ, pers.getOID());
		qInsert.setInt(OID_CAB_ASI_LIQ, pers.getCabasiliqtarj().getOID());
		qInsert.setInt(ORDEN, pers.getOrden().intValue());
		qInsert.setString(CUENTA, pers.getCuenta());
		qInsert.setString(DESC_CUENTA, pers.getDesc_cuenta());
		qInsert.setString(COMPO1, pers.getCompo1());
		qInsert.setString(COMPO2, pers.getCompo2());
		if (pers.getDebe() != null)
			qInsert.setDouble(DEBE, pers.getDebe().doubleValue());
		else
			qInsert.setDouble(DEBE, 0);
		if (pers.getHaber() != null)
			qInsert.setDouble(HABER, pers.getHaber().doubleValue());
		else
			qInsert.setDouble(HABER, 0);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getComentario() != null)
			qInsert.setString(COMENTARIO, pers.getComentario());
		else
			qInsert.setNull(COMENTARIO, Types.VARCHAR);
		if (pers.getCodImpuesto() != null)
			qInsert.setString(COD_IMPU, pers.getCodImpuesto());
		else
			qInsert.setNull(COD_IMPU, Types.VARCHAR);
		if (pers.getPorcImpuesto() != null)
			qInsert.setDouble(PORC_IMPU, pers.getPorcImpuesto().doubleValue());
		else
			qInsert.setNull(PORC_IMPU, Types.DOUBLE);
		if (pers.getBaseImpuesto() != null)
			qInsert.setDouble(BASE, pers.getBaseImpuesto().doubleValue());
		else
			qInsert.setNull(BASE, Types.DOUBLE);

		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CAB_ASI_LIQ = 1;
		final int ORDEN = 2;
		final int CUENTA = 3;
		final int DESC_CUENTA = 4;
		final int COMPO1 = 5;
		final int COMPO2 = 6;
		final int DEBE = 7;
		final int HABER = 8;
		final int ACTIVO = 9;
		final int COMENTARIO = 10;
		final int COD_IMPU = 11;
		final int PORC_IMPU = 12;
		final int BASE = 13;
		final int OID_DET_ASI_LIQ = 14;

		DetAsiLiquiTarj pers = (DetAsiLiquiTarj) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cTarDetAsiLiq set " + "oid_cab_asi_liq=?" + ",orden=?" + ",cuenta=?" + ",desc_cuenta=?" + ",compo1=?"
				+ ",compo2=?" + ",debe=?" + ",haber=?" + ",activo=?" + ",comentario=?" + ",cod_impu=?" + ",porc_impu=?" + ",base=?"
				+ " where " + " oid_det_asi_liq=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DET_ASI_LIQ, pers.getOID());
		qUpdate.setInt(OID_CAB_ASI_LIQ, pers.getCabasiliqtarj().getOID());
		qUpdate.setInt(ORDEN, pers.getOrden().intValue());
		qUpdate.setString(CUENTA, pers.getCuenta());
		qUpdate.setString(DESC_CUENTA, pers.getDesc_cuenta());
		qUpdate.setString(COMPO1, pers.getCompo1());
		qUpdate.setString(COMPO2, pers.getCompo2());
		if (pers.getDebe() != null)
			qUpdate.setDouble(DEBE, pers.getDebe().doubleValue());
		else
			qUpdate.setDouble(DEBE, 0);
		if (pers.getHaber() != null)
			qUpdate.setDouble(HABER, pers.getHaber().doubleValue());
		else
			qUpdate.setDouble(HABER, 0);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.getComentario() != null)
			qUpdate.setString(COMENTARIO, pers.getComentario());
		else
			qUpdate.setNull(COMENTARIO, Types.VARCHAR);
		if (pers.getCodImpuesto() != null)
			qUpdate.setString(COD_IMPU, pers.getCodImpuesto());
		else
			qUpdate.setNull(COD_IMPU, Types.VARCHAR);
		if (pers.getPorcImpuesto() != null)
			qUpdate.setDouble(PORC_IMPU, pers.getPorcImpuesto().doubleValue());
		else
			qUpdate.setNull(PORC_IMPU, Types.DOUBLE);
		if (pers.getBaseImpuesto() != null)
			qUpdate.setDouble(BASE, pers.getBaseImpuesto().doubleValue());
		else
			qUpdate.setNull(BASE, Types.DOUBLE);

		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_DET_ASI_LIQ = 1;
		DetAsiLiquiTarj pers = (DetAsiLiquiTarj) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarDetAsiLiq " + " set activo=0 " + " where " + " oid_det_asi_liq=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DET_ASI_LIQ, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_DET_ASI_LIQ = 1;
		DetAsiLiquiTarj pers = (DetAsiLiquiTarj) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cTarDetAsiLiq " + " set activo=1 " + " where " + " oid_det_asi_liq=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DET_ASI_LIQ, pers.getOID());
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
		case SELECT_BY_CAB_ASI_LIQ: {
			ps = this.selectByCabAsiLiq(aCondiciones);
			break;
		}
		case SELECT_BY_CTA_FEC_DES_HAS: {
			ps = this.selectByCtaFecDesdeHasta(aCondiciones);
			break;			
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_DET_ASI_LIQ = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarDetAsiLiq ");
		textSQL.append(" WHERE oid_det_asi_liq = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_DET_ASI_LIQ, oid);
		return querySelect;
	}

	private PreparedStatement selectByCtaFecDesdeHasta(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarDetAsiLiq a , cTarCabAsiLiq b  ");
		textSQL.append(" WHERE a.oid_cab_asi_liq = b.oid_cab_asi_liq and ");
		textSQL.append(" a.activo = 1 and b.activo = 1 and a.cuenta = ? and b.fec_asiento>=? and b.fec_asiento<=? and b.oid_empresa = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		HashTableDatos condiciones = (HashTableDatos) aCondiciones;
		String cuenta = (String) condiciones.get("CUENTA");
		java.util.Date fecDesde = (java.util.Date) condiciones.get("FEC_DESDE");
		java.util.Date fecHasta = (java.util.Date) condiciones.get("FEC_HASTA");
		EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
		querySelect.setString(1, cuenta);
		querySelect.setDate(2, new java.sql.Date(fecDesde.getTime()));
		querySelect.setDate(3, new java.sql.Date(fecHasta.getTime()));
		querySelect.setInt(4, empresa.getOID());
		return querySelect;
	}	
	
	
	private PreparedStatement selectByCabAsiLiq(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarDetAsiLiq ");
		textSQL.append(" WHERE oid_cab_asi_liq = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		CabAsiLiquiTarj cabAsiLiquiTarj = (CabAsiLiquiTarj) aCondiciones;
		querySelect.setInt(1, cabAsiLiquiTarj.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cTarDetAsiLiq ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_det_asi_liq oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cTarDetAsiLiq");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDetAsiLiquiTarj(CabAsiLiquiTarj aCabAsiLiquiTarj, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(DetAsiLiquiTarj.NICKNAME, DBDetAsiLiquiTarj.SELECT_BY_CAB_ASI_LIQ, aCabAsiLiquiTarj,
				new ListObserver(), aSesion);
	}

	public static double getSaldoAUnaFecha(Object aCondiciones, ISesion aSesion) throws BaseException {

		try {
			HashTableDatos condiciones = (HashTableDatos) aCondiciones;
			String cuenta = (String) condiciones.get("CUENTA");
			java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
			EmpresaConciTar empresa = (EmpresaConciTar) condiciones.get(EmpresaConciTar.NICKNAME);
			StringBuffer textSQL = new StringBuffer();
			textSQL.append(" select ");
			textSQL.append("   sum(nvl(debe,0))-sum(nvl(haber,0))  saldo ");
			textSQL.append(" from ");
			textSQL.append("   cTarDetAsiLiq a , ctarcabasiliq b ");
			textSQL.append(" where ");
			textSQL.append("  a.oid_cab_asi_liq = b.oid_cab_asi_liq and ");
			textSQL.append("    a.activo=1 and ");
			textSQL.append("    b.activo=1 and ");
			textSQL.append("    a.cuenta=? and ");
			textSQL.append("    b.fec_asiento < ? and ");
			textSQL.append("    b.oid_empresa = ?  ");

			PreparedStatement querySelect = aSesion.getConexionBD().prepareStatement(textSQL.toString());

			querySelect.setString(1, cuenta);
			querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
			querySelect.setInt(3, empresa.getOID());

			ResultSet rs = querySelect.executeQuery();
			double saldo = 0;
			if (rs.next())
				saldo = rs.getDouble(1);
			rs.close();
			querySelect.close();

			return saldo;
		} catch (Exception e) {
			throw new BaseException(null, e.getMessage());
		}
	}
	
	public static List getDetAsiLiqTarj(
				EmpresaConciTar empresa,
				String cuenta,
				java.util.Date fecDesde,
				java.util.Date fecHasta,
				ISesion aSesion) throws BaseException {
		  HashTableDatos condiciones = new HashTableDatos();
		  condiciones.put("CUENTA", cuenta);
		  condiciones.put("FEC_DESDE", fecDesde);
		  condiciones.put("FEC_HASTA", fecHasta);
		  condiciones.put(EmpresaConciTar.NICKNAME, empresa);
		  
		  return (List) ObjetoLogico.getObjects(DetAsiLiquiTarj.NICKNAME,
                 DBDetAsiLiquiTarj.SELECT_BY_CTA_FEC_DES_HAS,
                 condiciones,
                 new ListObserver(),
                 aSesion);
	}	

}
