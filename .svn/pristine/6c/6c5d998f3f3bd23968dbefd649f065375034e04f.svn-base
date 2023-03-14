package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.AnuladorInfCC;
import com.srn.erp.compras.bm.AnuladorInfCCDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAnuladorInfCCDet extends DBObjetoPersistente {

	public static final String OID_DET_CC_ANU = "oid_det_cc_anu";

	public static final String OID_ANU_CC = "oid_anu_cc";

	public static final String OID_CC_DET = "oid_cc_det";

	public static final int SELECT_BY_COMPRO_ANULADOR_INF_CC = 100;

	public DBAnuladorInfCCDet() {
	}

	protected void insert(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_DET_CC_ANU = 1;
		final int OID_ANU_CC = 2;
		final int OID_CC_DET = 3;

		AnuladorInfCCDet pers = (AnuladorInfCCDet) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cpDetCCAnu " + " ( "
				+ "OID_DET_CC_ANU," + "OID_ANU_CC," + "OID_CC_DET)"
				+ " values " + "(" + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD()
				.prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_DET_CC_ANU, pers.getOID());
		qInsert.setInt(OID_ANU_CC, pers.getAnulador_inf_cc().getOID());
		qInsert.setInt(OID_CC_DET, pers.getDetalle_inf_cc().getOID());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {

		final int OID_ANU_CC = 1;
		final int OID_CC_DET = 2;
		final int OID_DET_CC_ANU = 3;

		AnuladorInfCCDet pers = (AnuladorInfCCDet) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cpDetCCAnu set " + "oid_anu_cc=?"
				+ ",oid_cc_det=?" + " where " + " oid_det_cc_anu=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DET_CC_ANU, pers.getOID());
		qUpdate.setInt(OID_ANU_CC, pers.getAnulador_inf_cc().getOID());
		qUpdate.setInt(OID_CC_DET, pers.getDetalle_inf_cc().getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_DET_CC_ANU = 1;
		AnuladorInfCCDet pers = (AnuladorInfCCDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpDetCCAnu " + " set activo=0 " + " where "
				+ " oid_det_cc_anu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DET_CC_ANU, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente)
			throws BaseException, SQLException {
		final int OID_DET_CC_ANU = 1;
		AnuladorInfCCDet pers = (AnuladorInfCCDet) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cpDetCCAnu " + " set activo=1 " + " where "
				+ " oid_det_cc_anu=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD()
				.prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_DET_CC_ANU, pers.getOID());
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
		case SELECT_BY_COMPRO_ANULADOR_INF_CC: {
			ps = this.selectByComproAnulador(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByComproAnulador(Object aCondiciones)
			throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpDetCCAnu ");
		textSQL.append(" WHERE OID_ANU_CC = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		AnuladorInfCC anulador = (AnuladorInfCC) aCondiciones;
		querySelect.setInt(1, anulador.getOID());
		return querySelect;
	}

	private PreparedStatement selectByOID(Object aCondiciones)
			throws BaseException, SQLException {

		final int OID_DET_CC_ANU = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpDetCCAnu ");
		textSQL.append(" WHERE oid_det_cc_anu = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_DET_CC_ANU, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones)
			throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cpDetCCAnu ");
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
				.append("SELECT oid_det_cc_anu oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cpDetCCAnu");

		PreparedStatement querySelect = getSesion().getConexionBD()
				.prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getDetalles(AnuladorInfCC anulador, ISesion aSesion)
			throws BaseException {
		return (List) ObjetoLogico.getObjects(AnuladorInfCCDet.NICKNAME,
				DBAnuladorInfCCDet.SELECT_BY_COMPRO_ANULADOR_INF_CC, anulador,
				new ListObserver(), aSesion);
	}

}
