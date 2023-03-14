package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.tesoreria.bm.FacturasRecibo;
import com.srn.erp.tesoreria.bm.Recibo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBFacturasRecibo extends DBObjetoPersistente {

	public static final String	OID_FACT_EN_RECIBO	= "oid_fact_en_recibo";

	public static final String	OID_RECIBO					= "oid_recibo";

	public static final String	IMPO_MON_ORI				= "impo_mon_ori";

	public static final String	IMPO_MON_LOC				= "impo_mon_loc";

	public static final String	SALDO_MON_ORI				= "saldo_mon_ori";

	public static final String	IMPO_DTO_MON_ORI		= "impo_dto_mon_ori";

	public static final String	SALDO_MON_LOC				= "saldo_mon_loc";

	public static final String	IMPO_DTO_MON_LOC		= "impo_dto_mon_loc";

	public static final String	IMPO_COB_MON_ORI		= "impo_cob_mon_ori";

	public static final String	IMPO_COB_MON_LOC		= "impo_cob_mon_loc";

	public static final String	COTIZACION					= "cotizacion";

	public static final String	IMPO_COB_MON_REC		= "impo_cob_mon_rec";

	public static final String	OID_TRAN_VTO				= "oid_tran_vto";

	public static final int			SELECT_BY_RECIBO		= 100;

	public DBFacturasRecibo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_FACT_EN_RECIBO = 1;
		final int OID_RECIBO = 2;
		final int IMPO_MON_ORI = 3;
		final int IMPO_MON_LOC = 4;
		final int SALDO_MON_ORI = 5;
		final int IMPO_DTO_MON_ORI = 6;
		final int SALDO_MON_LOC = 7;
		final int IMPO_DTO_MON_LOC = 8;
		final int IMPO_COB_MON_ORI = 9;
		final int IMPO_COB_MON_LOC = 10;
		final int COTIZACION = 11;
		final int IMPO_MON_COB_REC = 12;
		final int OID_TRAN_VTO = 13;

		FacturasRecibo pers = (FacturasRecibo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into teFactEnRecibos " + " ( " + "OID_FACT_EN_RECIBO," + "OID_RECIBO," + "IMPO_MON_ORI,"
				+ "IMPO_MON_LOC," + "SALDO_MON_ORI," + "IMPO_DTO_MON_ORI," + "SALDO_MON_LOC," + "IMPO_DTO_MON_LOC,"
				+ "IMPO_COB_MON_ORI," + "IMPO_COB_MON_LOC," + "COTIZACION,IMPO_COB_MON_REC,OID_TRAN_VTO)" + " values " + "("
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_FACT_EN_RECIBO, pers.getOID());
		qInsert.setInt(OID_RECIBO, pers.getRecibo().getOID());
		qInsert.setDouble(IMPO_MON_ORI, pers.getImpo_mon_ori().doubleValue());
		qInsert.setDouble(IMPO_MON_LOC, pers.getImpo_mon_loc().doubleValue());
		qInsert.setDouble(SALDO_MON_ORI, pers.getSaldo_mon_ori().doubleValue());
		qInsert.setDouble(IMPO_DTO_MON_ORI, pers.getImpo_dto_mon_ori().doubleValue());
		qInsert.setDouble(SALDO_MON_LOC, pers.getSaldo_mon_loc().doubleValue());
		qInsert.setDouble(IMPO_DTO_MON_LOC, pers.getImpo_dto_mon_loc().doubleValue());
		qInsert.setDouble(IMPO_COB_MON_ORI, pers.getImpo_cob_mon_ori().doubleValue());
		qInsert.setDouble(IMPO_COB_MON_LOC, pers.getImpo_cob_mon_loc().doubleValue());
		qInsert.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qInsert.setDouble(IMPO_MON_COB_REC, pers.getImpoCobMonRec().doubleValue());
		qInsert.setDouble(OID_TRAN_VTO, pers.getTranClieVto().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_RECIBO = 1;
		final int IMPO_MON_ORI = 2;
		final int IMPO_MON_LOC = 3;
		final int SALDO_MON_ORI = 4;
		final int IMPO_DTO_MON_ORI = 5;
		final int SALDO_MON_LOC = 6;
		final int IMPO_DTO_MON_LOC = 7;
		final int IMPO_COB_MON_ORI = 8;
		final int IMPO_COB_MON_LOC = 9;
		final int COTIZACION = 10;
		final int IMPO_COB_MON_REC = 11;
		final int OID_TRAN_VTO = 12;
		final int OID_FACT_EN_RECIBO = 13;

		FacturasRecibo pers = (FacturasRecibo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update teFactEnRecibos set " + "oid_recibo=?" + ",impo_mon_ori=?" + ",impo_mon_loc=?"
				+ ",saldo_mon_ori=?" + ",impo_dto_mon_ori=?" + ",saldo_mon_loc=?" + ",impo_dto_mon_loc=?"
				+ ",impo_cob_mon_ori=?" + ",impo_cob_mon_loc=?" + ",cotizacion=?,impo_cob_mon_rec=?,oid_tran_vto=?" + " where "
				+ " oid_fact_en_recibo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FACT_EN_RECIBO, pers.getOID());
		qUpdate.setInt(OID_RECIBO, pers.getRecibo().getOID());
		qUpdate.setDouble(IMPO_MON_ORI, pers.getImpo_mon_ori().doubleValue());
		qUpdate.setDouble(IMPO_MON_LOC, pers.getImpo_mon_loc().doubleValue());
		qUpdate.setDouble(SALDO_MON_ORI, pers.getSaldo_mon_ori().doubleValue());
		qUpdate.setDouble(IMPO_DTO_MON_ORI, pers.getImpo_dto_mon_ori().doubleValue());
		qUpdate.setDouble(SALDO_MON_LOC, pers.getSaldo_mon_loc().doubleValue());
		qUpdate.setDouble(IMPO_DTO_MON_LOC, pers.getImpo_dto_mon_loc().doubleValue());
		qUpdate.setDouble(IMPO_COB_MON_ORI, pers.getImpo_cob_mon_ori().doubleValue());
		qUpdate.setDouble(IMPO_COB_MON_LOC, pers.getImpo_cob_mon_loc().doubleValue());
		qUpdate.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qUpdate.setDouble(IMPO_COB_MON_REC, pers.getImpoCobMonRec().doubleValue());
		qUpdate.setDouble(OID_TRAN_VTO, pers.getTranClieVto().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_FACT_EN_RECIBO = 1;
		FacturasRecibo pers = (FacturasRecibo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update teFactEnRecibos " + " set activo=0 " + " where " + " oid_fact_en_recibo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FACT_EN_RECIBO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_FACT_EN_RECIBO = 1;
		FacturasRecibo pers = (FacturasRecibo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update teFactEnRecibos " + " set activo=1 " + " where " + " oid_fact_en_recibo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_FACT_EN_RECIBO, pers.getOID());
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
		case SELECT_BY_RECIBO: {
			ps = this.selectByRecibo(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_FACT_EN_RECIBO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  teFactEnRecibos ");
		textSQL.append(" WHERE oid_fact_en_recibo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_FACT_EN_RECIBO, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  teFactEnRecibos ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectByRecibo(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  teFactEnRecibos ");
		textSQL.append(" WHERE oid_recibo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Recibo recibo = (Recibo) aCondiciones;
		querySelect.setInt(1, recibo.getOID());
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_fact_en_recibo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from teFactEnRecibos");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getFacturasEnRecibo(Recibo recibo, ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(FacturasRecibo.NICKNAME, DBFacturasRecibo.SELECT_BY_RECIBO, recibo,
				new ListObserver(), aSesion);
	}

}
