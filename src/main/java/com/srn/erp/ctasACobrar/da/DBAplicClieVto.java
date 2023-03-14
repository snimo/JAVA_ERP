package com.srn.erp.ctasACobrar.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.ctasACobrar.bm.AplicClieVto;
import com.srn.erp.ctasACobrar.bm.AplicacionComproClie;
import com.srn.erp.ctasAPagar.bm.AplProv;
import com.srn.erp.ctasAPagar.da.DBAplProv;
import com.srn.erp.general.bm.ComproCab;
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

public class DBAplicClieVto extends DBObjetoPersistente {

	public static final String OID_APL_CLIE = "oid_apl_clie";
	public static final String OID_CCO = "oid_cco";
	public static final String OID_SUJETO = "oid_sujeto";
	public static final String OID_MONEDA = "oid_moneda";
	public static final String IMPORTE = "importe";
	public static final String IMPUTAC = "imputac";
	public static final String EMISION = "emision";
	public static final String DIAS_BASE = "dias_base";
	public static final String DIAS_VTO = "dias_vto";
	public static final String OID_TRAN_VTO = "oid_tran_vto";
	public static final String OID_CCO_ORI = "oid_cco_ori";
	public static final String OID_TRAN_VTO_ORI = "oid_tran_vto_ori";
	public static final String COTIZ_MON_ORI = "cotiz_mon_ori";
	public static final String COTIZ_MON_EXT1 = "cotiz_mon_ext1";
	public static final String COTIZ_MON_EXT2 = "cotiz_mon_ext2";
	public static final String OID_TIPO_CTA_CTE = "oid_tipo_cta_clie";

	public static final int SELECT_BY_COMPRO_APLICACION = 100;
	public static final int SELECT_APLIC_ACTIVAS_COMPRO = 101;
	public static final int SELECT_APLIC_ACTIVAS_COMPRO_ORI = 102;

	public DBAplicClieVto() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_APL_CLIE = 1;
		final int OID_CCO = 2;
		final int OID_SUJETO = 3;
		final int OID_MONEDA = 4;
		final int IMPORTE = 5;
		final int IMPUTAC = 6;
		final int EMISION = 7;
		final int DIAS_BASE = 8;
		final int DIAS_VTO = 9;
		final int OID_TRAN_VTO = 10;
		final int OID_CCO_ORI = 11;
		final int OID_TRAN_VTO_ORI = 12;
		final int COTIZ_MON_ORI = 13;
		final int COTIZ_MON_EXT1 = 14;
		final int COTIZ_MON_EXT2 = 15;
		final int OID_TIPO_CTA_CTE = 16;

		AplicClieVto pers = (AplicClieVto) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into veAplClie " + " ( " + "OID_APL_CLIE," + "OID_CCO," + "OID_SUJETO," + "OID_MONEDA," + "IMPORTE,"
				+ "IMPUTAC," + "EMISION," + "DIAS_BASE," + "DIAS_VTO," + "OID_TRAN_VTO," + "OID_CCO_ORI," + "OID_TRAN_VTO_ORI,"
				+ "COTIZ_MON_ORI," + "COTIZ_MON_EXT1," + "COTIZ_MON_EXT2," + "OID_TIPO_CTA_CLIE)" + " values " + "(" + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_APL_CLIE, pers.getOID());
		qInsert.setInt(OID_CCO, pers.getComprobante().getOID());
		qInsert.setInt(OID_SUJETO, pers.getSujeto().getOID());
		qInsert.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qInsert.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qInsert.setDate(IMPUTAC, new java.sql.Date(pers.getImputac().getTime()));
		qInsert.setDate(EMISION, new java.sql.Date(pers.getEmision().getTime()));
		qInsert.setInt(DIAS_BASE, pers.getDias_base().intValue());
		qInsert.setInt(DIAS_VTO, pers.getDias_vto().intValue());
		qInsert.setInt(OID_TRAN_VTO, pers.getTran_vto().getOID());
		if (pers.getCompro_ori() != null)
			qInsert.setInt(OID_CCO_ORI, pers.getCompro_ori().getOID());
		else
			qInsert.setNull(OID_CCO_ORI, Types.INTEGER);
		if (pers.getTran_vto_ori() != null)
			qInsert.setInt(OID_TRAN_VTO_ORI, pers.getTran_vto_ori().getOID());
		else
			qInsert.setNull(OID_TRAN_VTO_ORI, Types.INTEGER);
		qInsert.setDouble(COTIZ_MON_ORI, pers.getCotiz_mon_ori().doubleValue());
		qInsert.setDouble(COTIZ_MON_EXT1, pers.getCotiz_mon_ext1().doubleValue());
		qInsert.setDouble(COTIZ_MON_EXT2, pers.getCotiz_mon_ext2().doubleValue());
		qInsert.setInt(OID_TIPO_CTA_CTE, pers.getTipo_cta_cte().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_CCO = 1;
		final int OID_SUJETO = 2;
		final int OID_MONEDA = 3;
		final int IMPORTE = 4;
		final int IMPUTAC = 5;
		final int EMISION = 6;
		final int DIAS_BASE = 7;
		final int DIAS_VTO = 8;
		final int OID_TRAN_VTO = 9;
		final int OID_CCO_ORI = 10;
		final int OID_TRAN_VTO_ORI = 11;
		final int COTIZ_MON_ORI = 12;
		final int COTIZ_MON_EXT1 = 13;
		final int COTIZ_MON_EXT2 = 14;
		final int OID_TIPO_CTA_CTE = 15;
		final int OID_APL_CLIE = 16;

		AplicClieVto pers = (AplicClieVto) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update veAplClie set " + "oid_cco=?" + ",oid_sujeto=?" + ",oid_moneda=?" + ",importe=?" + ",imputac=?"
				+ ",emision=?" + ",dias_base=?" + ",dias_vto=?" + ",oid_tran_vto=?" + ",oid_cco_ori=?" + ",oid_tran_vto_ori=?"
				+ ",cotiz_mon_ori=?" + ",cotiz_mon_ext1=?" + ",cotiz_mon_ext2=?" + ",oid_tipo_cta_clie=?" + " where " + " oid_apl_clie=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_APL_CLIE, pers.getOID());
		qUpdate.setInt(OID_CCO, pers.getComprobante().getOID());
		qUpdate.setInt(OID_SUJETO, pers.getSujeto().getOID());
		qUpdate.setInt(OID_MONEDA, pers.getMoneda().getOID());
		qUpdate.setDouble(IMPORTE, pers.getImporte().doubleValue());
		qUpdate.setDate(IMPUTAC, new Date(pers.getImputac().getTime()));
		qUpdate.setDate(EMISION, new Date(pers.getEmision().getTime()));
		qUpdate.setInt(DIAS_BASE, pers.getDias_base().intValue());
		qUpdate.setInt(DIAS_VTO, pers.getDias_vto().intValue());
		qUpdate.setInt(OID_TRAN_VTO, pers.getTran_vto().getOID());
		qUpdate.setInt(OID_CCO_ORI, pers.getCompro_ori().getOID());
		qUpdate.setInt(OID_TRAN_VTO_ORI, pers.getTran_vto_ori().getOID());
		qUpdate.setDouble(COTIZ_MON_ORI, pers.getCotiz_mon_ori().doubleValue());
		qUpdate.setDouble(COTIZ_MON_EXT1, pers.getCotiz_mon_ext1().doubleValue());
		qUpdate.setDouble(COTIZ_MON_EXT2, pers.getCotiz_mon_ext2().doubleValue());
		qUpdate.setInt(OID_TIPO_CTA_CTE, pers.getTipo_cta_cte().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_APL_CLIE = 1;
		AplicClieVto pers = (AplicClieVto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from veAplClie " + " where " + " oid_apl_clie=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_APL_CLIE, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_APL_CLIE = 1;
		AplicClieVto pers = (AplicClieVto) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update veAplClie " + " set activo=1 " + " where " + " oid_apl_clie=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_APL_CLIE, pers.getOID());
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
		case SELECT_BY_COMPRO_APLICACION: {
			ps = this.selectByComproAplicacion(aCondiciones);
			break;
		}
		case SELECT_APLIC_ACTIVAS_COMPRO_ORI: {
			ps = this.selectByComproAplicOri(aCondiciones);
			break;
		}
		case SELECT_APLIC_ACTIVAS_COMPRO: {
			ps = this.selectAplicActivasCompro(aCondiciones);
			break;
		}

		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_APL_CLIE = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veAplClie ");
		textSQL.append(" WHERE oid_apl_clie = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_APL_CLIE, oid);
		return querySelect;
	}

	private PreparedStatement selectByComproAplicacion(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veAplClie ");
		textSQL.append(" WHERE oid_cco = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		AplicacionComproClie aplicacionComproClie = (AplicacionComproClie) aCondiciones;
		querySelect.setInt(1, aplicacionComproClie.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veAplClie ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByComproAplicOri(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  veAplClie a , geComproCab b ");
		textSQL.append(" WHERE a.oid_cco = b.oid_cco and a.oid_cco_ori = ? and b.activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ComproCab compro = (ComproCab) aCondiciones;
		querySelect.setInt(1, compro.getOID());
		return querySelect;
	}

	private PreparedStatement selectAplicActivasCompro(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT a.* FROM  veAplClie a, geComproCab b  ");
		textSQL
				.append(" WHERE a.oid_cco = b.oid_cco and b.activo = 1 and a.oid_tran_vto in (select OID_TRAN_VTO from veTranClie f , veTranClieVto g where f.oid_tran_clie = g.oid_tran_clie and f.OID_CCO = ? ) ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		ComproCab comproCab = (ComproCab) aCondiciones;
		querySelect.setInt(1, comproCab.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_apl_clie oid, codigo,  descripcion ,activo ");
		textSQL.append(" from veAplClie");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getAplicacionesClienteVto(AplicacionComproClie aplicacionComproClie, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AplicClieVto.NICKNAME, DBAplicClieVto.SELECT_BY_COMPRO_APLICACION, aplicacionComproClie,
				new ListObserver(), aSesion);
	}

	public static List getAplicacionesActivasCompro(ComproCab aComproCab, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AplicClieVto.NICKNAME, DBAplicClieVto.SELECT_APLIC_ACTIVAS_COMPRO, aComproCab,
				new ListObserver(), aSesion);
	}

	public static List getAplicacionesActivasDelCompro(ComproCab aComproCab, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(AplicClieVto.NICKNAME, DBAplicClieVto.SELECT_APLIC_ACTIVAS_COMPRO_ORI, aComproCab,
				new ListObserver(), aSesion);
	}

}
