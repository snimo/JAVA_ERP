package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.tesoreria.bm.AnuladorRecibo;
import com.srn.erp.tesoreria.bm.ValoresReciboAnulado;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBValoresReciboAnulado extends DBObjetoPersistente {

	public static final String	OID_ANU_REC_VAL				= "oid_anu_rec_val";

	public static final String	OID_ANU_REC_CAB				= "oid_anu_rec_cab";

	public static final String	OID_VAL_EN_RECIBO			= "oid_val_en_recibo";

	public static final int			SELECT_BY_ANU_REC_CAB	= 100;

	public DBValoresReciboAnulado() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ANU_REC_VAL = 1;
		final int OID_ANU_REC_CAB = 2;
		final int OID_VAL_EN_RECIBO = 3;

		ValoresReciboAnulado pers = (ValoresReciboAnulado) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into teAnuRecVal " + " ( " + "OID_ANU_REC_VAL," + "OID_ANU_REC_CAB,"
				+ "OID_VAL_EN_RECIBO)" + " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ANU_REC_VAL, pers.getOID());
		qInsert.setInt(OID_ANU_REC_CAB, pers.getAnulador_recibo().getOID());
		qInsert.setInt(OID_VAL_EN_RECIBO, pers.getValor_recibo().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_ANU_REC_CAB = 1;
		final int OID_VAL_EN_RECIBO = 2;
		final int OID_ANU_REC_VAL = 3;

		ValoresReciboAnulado pers = (ValoresReciboAnulado) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update teAnuRecVal set " + "oid_anu_rec_cab=?" + ",oid_val_en_recibo=?" + " where "
				+ " oid_anu_rec_val=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ANU_REC_VAL, pers.getOID());
		qUpdate.setInt(OID_ANU_REC_CAB, pers.getAnulador_recibo().getOID());
		qUpdate.setInt(OID_VAL_EN_RECIBO, pers.getValor_recibo().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ANU_REC_VAL = 1;
		ValoresReciboAnulado pers = (ValoresReciboAnulado) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update teAnuRecVal " + " set activo=0 " + " where " + " oid_anu_rec_val=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ANU_REC_VAL, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_ANU_REC_VAL = 1;
		ValoresReciboAnulado pers = (ValoresReciboAnulado) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update teAnuRecVal " + " set activo=1 " + " where " + " oid_anu_rec_val=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ANU_REC_VAL, pers.getOID());
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
		case SELECT_BY_ANU_REC_CAB: {
			ps = this.selectByAnuRecCab(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_ANU_REC_VAL = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  teAnuRecVal ");
		textSQL.append(" WHERE oid_anu_rec_val = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ANU_REC_VAL, oid);
		return querySelect;
	}

	private PreparedStatement selectByAnuRecCab(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  teAnuRecVal ");
		textSQL.append(" WHERE oid_anu_rec_cab = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		AnuladorRecibo anuladorRecibo = (AnuladorRecibo) aCondiciones;
		querySelect.setInt(1, anuladorRecibo.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  teAnuRecVal ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_anu_rec_val oid, codigo,  descripcion ,activo ");
		textSQL.append(" from teAnuRecVal");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getValoresReciboAnulados(AnuladorRecibo anuladorRecibo, 
																							ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(
				ValoresReciboAnulado.NICKNAME, 
				DBValoresReciboAnulado.SELECT_BY_ANU_REC_CAB,
				anuladorRecibo, 
				new ListObserver(), 
				aSesion);
	}

}
