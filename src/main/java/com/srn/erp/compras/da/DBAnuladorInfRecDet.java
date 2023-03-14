package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.AnuladorInfRec;
import com.srn.erp.compras.bm.AnuladorInfRecDet;
import com.srn.erp.ventas.bm.PedidoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAnuladorInfRecDet extends DBObjetoPersistente {

	public static final String OID_ANU_DET_REC = "oid_anu_det_rec";

	public static final String OID_ANU_INF_REC = "oid_anu_inf_rec";

	public static final String OID_INF_REC_DET = "oid_inf_rec_det";

	public static final int SELECT_BY_ANULADOR_INF_REC = 100;

	public DBAnuladorInfRecDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ANU_DET_REC = 1;
		final int OID_ANU_INF_REC = 2;
		final int OID_INF_REC_DET = 3;

		AnuladorInfRecDet pers = (AnuladorInfRecDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpInfRecDetAnu  " + " ( "
				+ "OID_ANU_DET_REC," + "OID_ANU_INF_REC," + "OID_INF_REC_DET)"
				+ " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_ANU_DET_REC, pers.getOID());
		qInsert.setInt(OID_ANU_INF_REC, pers.getAnulador_inf_rec().getOID());
		qInsert.setInt(OID_INF_REC_DET, pers.getInf_rec_det().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ANU_INF_REC = 1;
		final int OID_INF_REC_DET = 2;
		final int OID_ANU_DET_REC = 3;

		AnuladorInfRecDet pers = (AnuladorInfRecDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpInfRecDetAnu  set " + "oid_anu_inf_rec=?"
				+ ",oid_inf_rec_det=?" + " where " + " oid_anu_det_rec=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ANU_DET_REC, pers.getOID());
		qUpdate.setInt(OID_ANU_INF_REC, pers.getAnulador_inf_rec().getOID());
		qUpdate.setInt(OID_INF_REC_DET, pers.getInf_rec_det().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ANU_DET_REC = 1;
		AnuladorInfRecDet pers = (AnuladorInfRecDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpInfRecDetAnu  " + " set activo=0 "
				+ " where " + " oid_anu_det_rec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ANU_DET_REC, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_ANU_DET_REC = 1;
		AnuladorInfRecDet pers = (AnuladorInfRecDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpInfRecDetAnu  " + " set activo=1 "
				+ " where " + " oid_anu_det_rec=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_ANU_DET_REC, pers.getOID());
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
		case SELECT_BY_ANULADOR_INF_REC: {
			ps = this.selectByAnuladorInfRec(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_ANU_DET_REC = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpInfRecDetAnu  ");
		textSQL.append(" WHERE oid_anu_det_rec = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_ANU_DET_REC, oid);
		return querySelect;
	}

	private PreparedStatement selectByAnuladorInfRec(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpInfRecDetAnu  ");
		textSQL.append(" WHERE oid_anu_inf_rec = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		AnuladorInfRec anuladorInfRec = (AnuladorInfRec) aCondiciones;
		querySelect.setInt(1, anuladorInfRec.getOID());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpInfRecDetAnu  ");
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
				.append("SELECT oid_anu_det_rec oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpInfRecDetAnu ");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDetAnuInfRec(AnuladorInfRec anuladorInfRec,ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PedidoCab.NICKNAME,
				DBAnuladorInfRecDet.SELECT_BY_ANULADOR_INF_REC, anuladorInfRec,
				new ListObserver(), aSesion);
	}

}
