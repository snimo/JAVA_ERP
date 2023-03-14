package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBComproProveedorBase extends DBObjetoPersistente {

	public static final String OID_CCO = "oid_cco";
	public static final String PROVEEDOR = "oid_proveedor";
	public static final String TOT_MON_ORI = "tot_mon_ori";
	public static final String TOT_MON_LOC = "tot_mon_loc";
	public static final String OID_MONEDA = "oid_moneda";
	public static final String FEC_BASE = "fec_base";
	public static final String MAX_MONTO_AUT_ORI = "max_monto_aut_ori";
	public static final String AUTORIZADA = "autorizada";
	public static final String OID_COND_PAGO_CC = "oid_cond_pago_cc";
	public static final String OID_COND_PAGO_AL1 = "oid_cond_pago_al1";
	public static final String OID_CONC_PAGO_AL2 = "oid_cond_pago_al2";
	public static final String DESC_CP_CC = "desc_cp_cc";
	public static final String DESC_CP_AL1 = "desc_cp_al1";
	public static final String DESC_CP_AL2 = "desc_cp_al2";
	public static final String NETO_GRAVADO_MON_ORI = "ng_mon_ori";
	public static final String NETO_NO_GRAVADO_MON_ORI = "nng_mon_ori";
	public static final String NETO_GRAVADO_MON_LOC = "ng_mon_loc";
	public static final String NETO_NO_GRAVADO_MON_LOC = "nng_mon_loc";
	public static final String OID_SECTOR_COMPRA = "oid_sector_compra";
	public static final String COTIZACION = "cotizacion";
	public static final String ANTICIPO_PAGADO = "anticipo_pagado";
	public static final String SALDO_ANT_PROV = "saldo_ant_prov";
	public static final String OID_TIPO_CTA_PROV = "oid_tipo_cta_prov";
	public static final String COTIZ_MON_EXT_1 = "cotiz_mon_ext_1";
	public static final String COTIZ_MON_EXT_2 = "cotiz_mon_ext_2";
	public static final String ES_ESTADISTICA = "es_estadistica";

	public static final int SELECT_ANTICIPOS_AUTORIZ = 100;
	public static final int SELECT_BY_TC_LETRA_LE_NRO_ACTIVO = 101;

	public DBComproProveedorBase() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_CCO = 1;
		final int PROVEEDOR = 2;
		final int TOT_MON_ORI = 3;
		final int TOT_MON_LOC = 4;
		final int OID_MONEDA = 5;
		final int FEC_BASE = 6;
		final int MAX_MONTO_AUT_ORI = 7;
		final int AUTORIZADA = 8;
		final int OID_COND_PAGO_CC = 9;
		final int OID_COND_PAGO_AL1 = 10;
		final int OID_CONC_PAGO_AL2 = 11;
		final int DESC_CP_CC = 12;
		final int DESC_CP_AL1 = 13;
		final int DESC_CP_AL2 = 14;
		final int NETO_GRAVADO_MON_ORI = 15;
		final int NETO_NO_GRAVADO_MON_ORI = 16;
		final int NETO_GRAVADO_MON_LOC = 17;
		final int NETO_NO_GRAVADO_MON_LOC = 18;
		final int OID_SECTOR_COMPRA = 19;
		final int COTIZACION = 20;
		final int ANTICIPO_PAGADO = 21;
		final int SALDO_ANT_PROV = 22;
		final int OID_TIPO_CTA_PROV = 23;
		final int COTIZ_MON_EXT_1 = 24;
		final int COTIZ_MON_EXT_2 = 25;
		final int ES_ESTADISTICA = 26;

		ComproProveedorBase pers = (ComproProveedorBase) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert
				.append(" insert into cpComproProv "
						+ " ( "
						+ "OID_CCO,"
						+ "OID_PROVEEDOR,"
						+ "TOT_MON_ORI,"
						+ "TOT_MON_LOC,"
						+ "OID_MONEDA,"
						+ "FEC_BASE,"
						+ "MAX_MONTO_AUT_ORI,"
						+ "AUTORIZADA,"
						+ "OID_COND_PAGO_CC,"
						+ "OID_COND_PAGO_AL1,"
						+ "OID_COND_PAGO_AL2,"
						+ "DESC_CP_CC,"
						+ "DESC_CP_AL1,"
						+ "DESC_CP_AL2,"
						+ "NG_MON_ORI,"
						+ "NNG_MON_ORI,"
						+ "NG_MON_LOC,"
						+ "NNG_MON_LOC,"
						+ "OID_SECTOR_COMPRA,COTIZACION,ANTICIPO_PAGADO,SALDO_ANT_PROV,OID_TIPO_CTA_PROV,COTIZ_MON_EXT_1,COTIZ_MON_EXT_2,ES_ESTADISTICA"
						+ ")" + " values " + "(" + "?," + "?," + "?," + "?,"
						+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"
						+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
						+ "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_CCO, pers.getOID());
		qInsert.setInt(PROVEEDOR, pers.getProveedor().getOID());
		qInsert.setDouble(TOT_MON_ORI, pers.getTotMonedaOri().doubleValue());
		qInsert.setDouble(TOT_MON_LOC, pers.getTotMonedaLoc().doubleValue());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setDate(FEC_BASE,
				new java.sql.Date(pers.getFecbase().getTime()));
		qInsert.setDouble(MAX_MONTO_AUT_ORI, pers.getMaxMontoAutori()
				.doubleValue());
		qInsert.setBoolean(AUTORIZADA, pers.isAutorizada().booleanValue());
		qInsert.setInt(OID_COND_PAGO_CC, pers.getCondPagoCC().getOID());
		if (pers.getCondPagoalt1() != null)
			qInsert.setInt(OID_COND_PAGO_AL1, pers.getCondPagoalt1().getOID());
		else
			qInsert.setNull(OID_COND_PAGO_AL1, java.sql.Types.INTEGER);
		if (pers.getCondPagoAlt2() != null)
			qInsert.setInt(OID_CONC_PAGO_AL2, pers.getCondPagoAlt2().getOID());
		else
			qInsert.setNull(OID_CONC_PAGO_AL2, java.sql.Types.INTEGER);
		if (pers.getDescCondPagoCC() != null)
			qInsert.setDouble(DESC_CP_CC, pers.getDescCondPagoCC()
					.doubleValue());
		else
			qInsert.setDouble(DESC_CP_CC, 0);
		if (pers.getDescCondPagoAlt1() != null)
			qInsert.setDouble(DESC_CP_AL1, pers.getDescCondPagoAlt1()
					.doubleValue());
		else
			qInsert.setDouble(DESC_CP_AL1, 0);
		if (pers.getDescCondPagoAlt2() != null)
			qInsert.setDouble(DESC_CP_AL2, pers.getDescCondPagoAlt2()
					.doubleValue());
		else
			qInsert.setDouble(DESC_CP_AL2, 0);

		if (pers.getNetoGravadoMonOri() != null)
			qInsert.setDouble(NETO_GRAVADO_MON_ORI, pers.getNetoGravadoMonOri()
					.doubleValue());
		else
			qInsert.setDouble(NETO_GRAVADO_MON_ORI, 0);
		if (pers.getNetoNoGravadoMonOri() != null)
			qInsert.setDouble(NETO_NO_GRAVADO_MON_ORI, pers
					.getNetoNoGravadoMonOri().doubleValue());
		else
			qInsert.setDouble(NETO_NO_GRAVADO_MON_ORI, 0);
		if (pers.getNetoGravadoMonLoc() != null)
			qInsert.setDouble(NETO_GRAVADO_MON_LOC, pers.getNetoGravadoMonLoc()
					.doubleValue());
		else
			qInsert.setDouble(NETO_GRAVADO_MON_LOC, 0);
		if (pers.getNetoNoGravadoMonLoc() != null)
			qInsert.setDouble(NETO_NO_GRAVADO_MON_LOC, pers
					.getNetoNoGravadoMonLoc().doubleValue());
		else
			qInsert.setDouble(NETO_NO_GRAVADO_MON_LOC, 0);
		if (pers.getSectorCompra() != null)
			qInsert.setInt(OID_SECTOR_COMPRA, pers.getSectorCompra().getOID());
		else
			qInsert.setNull(OID_SECTOR_COMPRA, Types.INTEGER);
		if (pers.getCotizacion() != null)
			qInsert.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		else
			qInsert.setNull(COTIZACION, Types.DOUBLE);
		if (pers.isAnticipoPagado() != null)
			qInsert.setBoolean(ANTICIPO_PAGADO, pers.isAnticipoPagado()
					.booleanValue());
		else
			qInsert.setNull(COTIZACION, Types.BOOLEAN);
		if (pers.getSaldoAnticipoProveedor() != null)
			qInsert.setDouble(SALDO_ANT_PROV, pers.getSaldoAnticipoProveedor()
					.doubleValue());
		else
			qInsert.setNull(SALDO_ANT_PROV, Types.DOUBLE);
		if (pers.getTipoCtaCteProv() != null)
			qInsert
					.setInt(OID_TIPO_CTA_PROV, pers.getTipoCtaCteProv()
							.getOID());
		else
			qInsert.setNull(OID_TIPO_CTA_PROV, Types.INTEGER);

		if (pers.getValorCotizExt1() != null)
			qInsert.setDouble(COTIZ_MON_EXT_1, pers.getValorCotizExt1()
					.doubleValue());
		else
			qInsert.setNull(COTIZ_MON_EXT_1, Types.DOUBLE);

		if (pers.getValorCotizExt2() != null)
			qInsert.setDouble(COTIZ_MON_EXT_2, pers.getValorCotizExt2()
					.doubleValue());
		else
			qInsert.setNull(COTIZ_MON_EXT_2, Types.DOUBLE);
		qInsert.setBoolean(ES_ESTADISTICA, pers.isEstadistica().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int PROVEEDOR = 1;
		final int TOT_MON_ORI = 2;
		final int TOT_MON_LOC = 3;
		final int OID_MONEDA = 4;
		final int FEC_BASE = 5;
		final int MAX_MONTO_AUT_ORI = 6;
		final int AUTORIZADA = 7;
		final int OID_COND_PAGO_CC = 8;
		final int OID_COND_PAGO_AL1 = 9;
		final int OID_CONC_PAGO_AL2 = 10;
		final int DESC_CP_CC = 11;
		final int DESC_CP_AL1 = 12;
		final int DESC_CP_AL2 = 13;
		final int NETO_GRAVADO_MON_ORI = 14;
		final int NETO_NO_GRAVADO_MON_ORI = 15;
		final int NETO_GRAVADO_MON_LOC = 16;
		final int NETO_NO_GRAVADO_MON_LOC = 17;
		final int OID_SECTOR_COMPRA = 18;
		final int COTIZACION = 19;
		final int ANTICIPO_PAGADO = 20;
		final int SALDO_ANT_PROV = 21;
		final int OID_TIPO_CTA_PROV = 22;
		final int ES_ESTADISTICA = 23;
		final int OID_CCO = 24;

		ComproProveedorBase pers = (ComproProveedorBase) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpComproProv set " + "oid_proveedor=?"
				+ ",tot_mon_ori=?" + ",tot_mon_loc=?" + ",oid_moneda=?"
				+ ",fec_base=?" + ",max_monto_aut_ori=?" + ",autorizada=?"
				+ ",oid_cond_pago_cc=?" + ",oid_cond_pago_al1=?"
				+ ",oid_cond_pago_al2=?" + ",desc_cp_cc=?" + ",desc_cp_al1=?"
				+ ",desc_cp_al2=?" + ",ng_mon_ori=?" + ",nng_mon_ori=?"
				+ ",ng_mon_loc=?" + ",nng_mon_loc=? " + ",oid_sector_compra=?"
				+ ",cotizacion=?" + ",anticipo_pagado=?" + ",saldo_ant_prov=?"
				+ ",oid_tipo_cta_prov=? , es_estadistica=? " + " where " + " oid_cco=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO, pers.getOID());
		qUpdate.setInt(PROVEEDOR, pers.getProveedor().getOID());
		qUpdate.setDouble(TOT_MON_ORI, pers.getTotMonedaOri().doubleValue());
		qUpdate.setDouble(TOT_MON_LOC, pers.getTotMonedaLoc().doubleValue());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.setDate(FEC_BASE,
				new java.sql.Date(pers.getFecbase().getTime()));
		qUpdate.setDouble(MAX_MONTO_AUT_ORI, pers.getMaxMontoAutori()
				.doubleValue());
		qUpdate.setBoolean(AUTORIZADA, pers.isAutorizada().booleanValue());
		qUpdate.setInt(OID_COND_PAGO_CC, pers.getCondPagoCC().getOID());
		if (pers.getCondPagoalt1() != null)
			qUpdate.setInt(OID_COND_PAGO_AL1, pers.getCondPagoalt1().getOID());
		else
			qUpdate.setNull(OID_COND_PAGO_AL1, java.sql.Types.INTEGER);
		if (pers.getCondPagoAlt2() != null)
			qUpdate.setInt(OID_CONC_PAGO_AL2, pers.getCondPagoAlt2().getOID());
		else
			qUpdate.setNull(OID_CONC_PAGO_AL2, java.sql.Types.INTEGER);
		if (pers.getDescCondPagoCC() != null)
			qUpdate.setDouble(DESC_CP_CC, pers.getDescCondPagoCC()
					.doubleValue());
		else
			qUpdate.setDouble(DESC_CP_CC, 0);
		if (pers.getDescCondPagoAlt1() != null)
			qUpdate.setDouble(DESC_CP_AL1, pers.getDescCondPagoAlt1()
					.doubleValue());
		else
			qUpdate.setDouble(DESC_CP_AL1, 0);
		if (pers.getDescCondPagoAlt2() != null)
			qUpdate.setDouble(DESC_CP_AL2, pers.getDescCondPagoAlt2()
					.doubleValue());
		else
			qUpdate.setDouble(DESC_CP_AL2, 0);
		qUpdate.setDouble(NETO_GRAVADO_MON_ORI, pers.getNetoGravadoMonOri()
				.doubleValue());
		qUpdate.setDouble(NETO_NO_GRAVADO_MON_ORI, pers
				.getNetoNoGravadoMonOri().doubleValue());
		qUpdate.setDouble(NETO_GRAVADO_MON_LOC, pers.getNetoGravadoMonLoc()
				.doubleValue());
		qUpdate.setDouble(NETO_NO_GRAVADO_MON_LOC, pers
				.getNetoNoGravadoMonLoc().doubleValue());
		if (pers.getSectorCompra() != null)
			qUpdate.setInt(OID_SECTOR_COMPRA, pers.getSectorCompra().getOID());
		else
			qUpdate.setNull(OID_SECTOR_COMPRA, Types.INTEGER);
		if (pers.getCotizacion() != null)
			qUpdate.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		else
			qUpdate.setNull(COTIZACION, Types.DOUBLE);
		if (pers.isAnticipoPagado() != null)
			qUpdate.setBoolean(ANTICIPO_PAGADO, pers.isAnticipoPagado()
					.booleanValue());
		else
			qUpdate.setNull(COTIZACION, Types.BOOLEAN);
		if (pers.getSaldoAnticipoProveedor() != null)
			qUpdate.setDouble(SALDO_ANT_PROV, pers.getSaldoAnticipoProveedor()
					.doubleValue());
		else
			qUpdate.setNull(SALDO_ANT_PROV, Types.DOUBLE);
		if (pers.getTipoCtaCteProv() != null)
			qUpdate.setInt(OID_TIPO_CTA_PROV, pers.getTipoCtaCteProv().getOID());
		else
			qUpdate.setNull(OID_TIPO_CTA_PROV, Types.INTEGER);
		qUpdate.setBoolean(ES_ESTADISTICA, pers.isEstadistica().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CCO = 1;
		ComproProveedorBase pers = (ComproProveedorBase) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
	    sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");		
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_CCO = 1;
		ComproProveedorBase pers = (ComproProveedorBase) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpComproProv " + " set activo=1 " + " where "
				+ " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO, pers.getOID());
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
		case SELECT_ANTICIPOS_AUTORIZ: {
			ps = this.selectByAnticiposAutorizados(aCondiciones);
			break;
		}
		case SELECT_BY_TC_LETRA_LE_NRO_ACTIVO: {
			ps = this.selectByTC_Letra_LE_NroActivo(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_CCO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  cpComproProv a, geComproCab b  ");
		textSQL.append(" WHERE a.oid_cco = b.oid_cco and a.oid_cco = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_CCO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpComproProv ");
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

		textSQL.append("SELECT oid_cco oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpComproProv");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByAnticiposAutorizados(Object aCondiciones)
			throws BaseException, SQLException {

		Proveedor proveedor = null;
		Moneda moneda = null;

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);
		moneda = (Moneda) condiciones.get(Moneda.NICKNAME);

		StringBuffer textSQL = new StringBuffer();
		textSQL.append(" select ");
		textSQL.append("   b.*,a.* ");
		textSQL.append(" from ");
		textSQL.append("  cpComproProv a , ");
		textSQL.append("  geComproCab b, ");
		textSQL.append("  geTipoCompro c , ");
		textSQL.append("  cpAutorizFactProv d ");
		textSQL.append(" where ");
		textSQL.append("  a.oid_cco = b.oid_cco and b.activo = 1 and ");
		textSQL
				.append("  b.oid_tc = c.oid_tc and c.identificacion = 'ANTPR' and a.anticipo_pagado = 0 and ");
		textSQL.append("  d.oid_cco = b.oid_cco ");
		if (proveedor != null)
			textSQL.append("  and a.oid_proveedor="
					+ proveedor.getOIDInteger().toString());
		if (moneda != null)
			textSQL.append("  and a.oid_moneda="
					+ moneda.getOIDInteger().toString());

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAnticiposProvAutori(HashTableDatos condiciones,
			ISesion aSesion) throws BaseException {

		return (List) ObjetoLogico.getObjects(ComproProveedorBase.NICKNAME,
				DBComproProveedorBase.SELECT_ANTICIPOS_AUTORIZ, condiciones,
				new ListObserver(), aSesion);
	}

	private PreparedStatement selectByTC_Letra_LE_NroActivo(Object aCondiciones)
			throws BaseException, SQLException {

		HashTableDatos condiciones = (HashTableDatos) aCondiciones;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.*,b.* FROM  cpComproProv a, geComproCab b  ");
		textSQL.append(" WHERE  a.oid_cco = b.oid_cco  ");

		TipoComprobante tc = (TipoComprobante) condiciones
				.get(TipoComprobante.NICKNAME);
		String letra = (String) condiciones.get("letra");
		Integer lugEmi = (Integer) condiciones.get("nro_lug_emi");
		Integer nroExt = (Integer) condiciones.get("nro_ext");
		Proveedor proveedor = (Proveedor) condiciones.get(Proveedor.NICKNAME);

		textSQL.append(" and b.oid_tc = " + tc.getOIDInteger());

		textSQL.append(" and b.letra = '" + letra+"' ");

		textSQL.append(" and b.lug_emi = " + lugEmi);

		textSQL.append(" and b.nro_ext = " + nroExt);

		textSQL.append(" and b.activo = 1 ");

		textSQL.append(" and a.oid_proveedor = " + proveedor.getOIDInteger());

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());

		return querySelect;
	}

}
