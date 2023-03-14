package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.tesoreria.bm.ValoresRecibo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBValoresRecibo extends DBObjetoPersistente {

	public static final String OID_VAL_EN_RECIBO = "oid_val_en_recibo";

	public static final String OID_RECIBO = "oid_recibo";

	public static final String OID_TIPO_VALOR = "oid_tipo_valor";

	public static final String OID_VALOR = "oid_valor";

	public static final String IMPO_MON_ORI = "impo_mon_ori";

	public static final String IMPO_MON_LOC = "impo_mon_loc";
	
	public static final String COTIZACION = "cotizacion";
	
	public static final String IMPO_MON_REC = "impo_mon_rec";

	public static final int SELECT_BY_RECIBO = 100;

	public DBValoresRecibo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_VAL_EN_RECIBO = 1;
		final int OID_RECIBO = 2;
		final int OID_TIPO_VALOR = 3;
		final int OID_VALOR = 4;
		final int IMPO_MON_ORI = 5;
		final int IMPO_MON_LOC = 6;
		final int COTIZACION = 7;
		final int IMPO_MON_REC = 8;

		ValoresRecibo pers = (ValoresRecibo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into teValEnRecibos " + " ( "
				+ "OID_VAL_EN_RECIBO," + "OID_RECIBO," + "OID_TIPO_VALOR,"
				+ "OID_VALOR," + "IMPO_MON_ORI," + "IMPO_MON_LOC,COTIZACION,IMPO_MON_REC)" + " values "
				+ "(" + "?," + "?," + "?," + "?," + "?," +"?," +"?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_VAL_EN_RECIBO, pers.getOID());
		qInsert.setInt(OID_RECIBO, pers.getRecibo().getOID());
		qInsert.setInt(OID_TIPO_VALOR, pers.getTipo_valor().getOID());
		if (pers.getValor()!=null)
			qInsert.setInt(OID_VALOR, pers.getValor().getOID());
		else
			qInsert.setNull(OID_VALOR, Types.INTEGER);
		qInsert.setDouble(IMPO_MON_ORI, pers.getImpo_mon_ori().doubleValue());
		qInsert.setDouble(IMPO_MON_LOC, pers.getImpo_mon_loc().doubleValue());
		qInsert.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qInsert.setDouble(IMPO_MON_REC,pers.getImpoMonRec().doubleValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_RECIBO = 1;
		final int OID_TIPO_VALOR = 2;
		final int OID_VALOR = 3;
		final int IMPO_MON_ORI = 4;
		final int IMPO_MON_LOC = 5;
		final int COTIZACION = 6;
		final int IMPO_MON_REC = 7;
		final int OID_VAL_EN_RECIBO = 8;

		ValoresRecibo pers = (ValoresRecibo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update teValEnRecibos set " + "oid_recibo=?"
				+ ",oid_tipo_valor=?" + ",oid_valor=?" + ",impo_mon_ori=?"
				+ ",impo_mon_loc=?" + ",cotizacion=?" +",impo_mon_rec=?" +" where " + " oid_val_en_recibo=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VAL_EN_RECIBO, pers.getOID());
		qUpdate.setInt(OID_RECIBO, pers.getRecibo().getOID());
		qUpdate.setInt(OID_TIPO_VALOR, pers.getTipo_valor().getOID());
		qUpdate.setInt(OID_VALOR, pers.getValor().getOID());
		qUpdate.setDouble(IMPO_MON_ORI, pers.getImpo_mon_ori().doubleValue());
		qUpdate.setDouble(IMPO_MON_LOC, pers.getImpo_mon_loc().doubleValue());
		qUpdate.setDouble(COTIZACION, pers.getCotizacion().doubleValue());
		qUpdate.setDouble(IMPO_MON_REC,pers.getImpoMonRec().doubleValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_VAL_EN_RECIBO = 1;
		ValoresRecibo pers = (ValoresRecibo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update teValEnRecibos " + " set activo=0 "
				+ " where " + " oid_val_en_recibo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VAL_EN_RECIBO, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_VAL_EN_RECIBO = 1;
		ValoresRecibo pers = (ValoresRecibo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update teValEnRecibos " + " set activo=1 "
				+ " where " + " oid_val_en_recibo=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_VAL_EN_RECIBO, pers.getOID());
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
		case SELECT_BY_RECIBO: {
			ps = this.selectByRecibo(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_VAL_EN_RECIBO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  teValEnRecibos ");
		textSQL.append(" WHERE oid_val_en_recibo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_VAL_EN_RECIBO, oid);
		return querySelect;
	}

	private PreparedStatement selectByRecibo(Object aCondiciones)
			throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  teValEnRecibos ");
		textSQL.append(" WHERE oid_recibo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		Recibo recibo = (Recibo) aCondiciones;
		querySelect.setInt(1, recibo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  teValEnRecibos ");
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

		textSQL
				.append("SELECT oid_val_en_recibo oid, codigo,  descripcion ,activo ");
		textSQL.append(" from teValEnRecibos");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getValoresEnRecibo(Recibo recibo, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(ValoresRecibo.NICKNAME,
				DBValoresRecibo.SELECT_BY_RECIBO, recibo, new ListObserver(),
				aSesion);
	}

}
