package com.srn.erp.cip.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.cip.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBPlanifDiaCacheo extends DBObjetoPersistente {

	public static final String OID_PLANIF_DIA = "oid_planif_dia";
	public static final String OID_LUN_ENT = "oid_lun_ent";
	public static final String OID_LUN_SAL = "oid_lun_sal";
	public static final String OID_MAR_ENT = "oid_mar_ent";
	public static final String OID_MAR_SAL = "oid_mar_sal";
	public static final String OID_MIE_ENT = "oid_mie_ent";
	public static final String OID_MIE_SAL = "oid_mie_sal";
	public static final String OID_JUE_ENT = "oid_jue_ent";
	public static final String OID_JUE_SAL = "oid_jue_sal";
	public static final String OID_VIE_ENT = "oid_vie_ent";
	public static final String OID_VIE_SAL = "oid_vie_sal";
	public static final String OID_SAB_ENT = "oid_sab_ent";
	public static final String OID_SAB_SAL = "oid_sab_sal";
	public static final String OID_DOM_ENT = "oid_dom_ent";
	public static final String OID_DOM_SAL = "oid_dom_sal";

	public DBPlanifDiaCacheo() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PLANIF_DIA = 1;
		final int OID_LUN_ENT = 2;
		final int OID_LUN_SAL = 3;
		final int OID_MAR_ENT = 4;
		final int OID_MAR_SAL = 5;
		final int OID_MIE_ENT = 6;
		final int OID_MIE_SAL = 7;
		final int OID_JUE_ENT = 8;
		final int OID_JUE_SAL = 9;
		final int OID_VIE_ENT = 10;
		final int OID_VIE_SAL = 11;
		final int OID_SAB_ENT = 12;
		final int OID_SAB_SAL = 13;
		final int OID_DOM_ENT = 14;
		final int OID_DOM_SAL = 15;

		PlanifDiaCacheo pers = (PlanifDiaCacheo) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipPlanifDiaCacheo " + " ( " + "OID_PLANIF_DIA," + "OID_LUN_ENT," + "OID_LUN_SAL," + "OID_MAR_ENT,"
				+ "OID_MAR_SAL," + "OID_MIE_ENT," + "OID_MIE_SAL," + "OID_JUE_ENT," + "OID_JUE_SAL," + "OID_VIE_ENT," + "OID_VIE_SAL,"
				+ "OID_SAB_ENT," + "OID_SAB_SAL," + "OID_DOM_ENT," + "OID_DOM_SAL)" + " values " + "(" + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PLANIF_DIA, pers.getOID());
		if (pers.getLunes_entrada() != null)
			qInsert.setInt(OID_LUN_ENT, pers.getLunes_entrada().getOID());
		else
			qInsert.setNull(OID_LUN_ENT, java.sql.Types.INTEGER);
		if (pers.getLunes_salida() != null)
			qInsert.setInt(OID_LUN_SAL, pers.getLunes_salida().getOID());
		else
			qInsert.setNull(OID_LUN_SAL, java.sql.Types.INTEGER);
		if (pers.getMartes_entrada() != null)
			qInsert.setInt(OID_MAR_ENT, pers.getMartes_entrada().getOID());
		else
			qInsert.setNull(OID_MAR_ENT, java.sql.Types.INTEGER);
		if (pers.getMartes_salida() != null)
			qInsert.setInt(OID_MAR_SAL, pers.getMartes_salida().getOID());
		else
			qInsert.setNull(OID_MAR_SAL, java.sql.Types.INTEGER);
		if (pers.getMiercoles_entrada() != null)
			qInsert.setInt(OID_MIE_ENT, pers.getMiercoles_entrada().getOID());
		else
			qInsert.setNull(OID_MIE_ENT, java.sql.Types.INTEGER);
		if (pers.getMiercoles_salida() != null)
			qInsert.setInt(OID_MIE_SAL, pers.getMiercoles_salida().getOID());
		else
			qInsert.setNull(OID_MIE_SAL, java.sql.Types.INTEGER);
		if (pers.getJueves_entrada() != null)
			qInsert.setInt(OID_JUE_ENT, pers.getJueves_entrada().getOID());
		else
			qInsert.setNull(OID_JUE_ENT, java.sql.Types.INTEGER);
		if (pers.getJueves_salida() != null)
			qInsert.setInt(OID_JUE_SAL, pers.getJueves_salida().getOID());
		else
			qInsert.setNull(OID_JUE_SAL, java.sql.Types.INTEGER);
		if (pers.getViernes_entrada() != null)
			qInsert.setInt(OID_VIE_ENT, pers.getViernes_entrada().getOID());
		else
			qInsert.setNull(OID_VIE_ENT, java.sql.Types.INTEGER);
		if (pers.getViermes_salida() != null)
			qInsert.setInt(OID_VIE_SAL, pers.getViermes_salida().getOID());
		else
			qInsert.setNull(OID_VIE_SAL, java.sql.Types.INTEGER);
		if (pers.getSabado_entrada() != null)
			qInsert.setInt(OID_SAB_ENT, pers.getSabado_entrada().getOID());
		else
			qInsert.setNull(OID_SAB_ENT, java.sql.Types.INTEGER);
		if (pers.getSabado_salida() != null)
			qInsert.setInt(OID_SAB_SAL, pers.getSabado_salida().getOID());
		else
			qInsert.setNull(OID_SAB_SAL, java.sql.Types.INTEGER);
		if (pers.getDomingo_entrada() != null)
			qInsert.setInt(OID_DOM_ENT, pers.getDomingo_entrada().getOID());
		else
			qInsert.setNull(OID_DOM_ENT, java.sql.Types.INTEGER);
		if (pers.getDomingo_salida() != null)
			qInsert.setInt(OID_DOM_SAL, pers.getDomingo_salida().getOID());
		else
			qInsert.setNull(OID_DOM_SAL, java.sql.Types.INTEGER);
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_LUN_ENT = 1;
		final int OID_LUN_SAL = 2;
		final int OID_MAR_ENT = 3;
		final int OID_MAR_SAL = 4;
		final int OID_MIE_ENT = 5;
		final int OID_MIE_SAL = 6;
		final int OID_JUE_ENT = 7;
		final int OID_JUE_SAL = 8;
		final int OID_VIE_ENT = 9;
		final int OID_VIE_SAL = 10;
		final int OID_SAB_ENT = 11;
		final int OID_SAB_SAL = 12;
		final int OID_DOM_ENT = 13;
		final int OID_DOM_SAL = 14;
		final int OID_PLANIF_DIA = 15;

		PlanifDiaCacheo pers = (PlanifDiaCacheo) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipPlanifDiaCacheo set " + "oid_lun_ent=?" + ",oid_lun_sal=?" + ",oid_mar_ent=?" + ",oid_mar_sal=?"
				+ ",oid_mie_ent=?" + ",oid_mie_sal=?" + ",oid_jue_ent=?" + ",oid_jue_sal=?" + ",oid_vie_ent=?" + ",oid_vie_sal=?"
				+ ",oid_sab_ent=?" + ",oid_sab_sal=?" + ",oid_dom_ent=?" + ",oid_dom_sal=?" + " where " + " oid_planif_dia=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PLANIF_DIA, pers.getOID());
		if (pers.getLunes_entrada() != null)
			qUpdate.setInt(OID_LUN_ENT, pers.getLunes_entrada().getOID());
		else
			qUpdate.setNull(OID_LUN_ENT, java.sql.Types.INTEGER);
		if (pers.getLunes_salida() != null)
			qUpdate.setInt(OID_LUN_SAL, pers.getLunes_salida().getOID());
		else
			qUpdate.setNull(OID_LUN_SAL, java.sql.Types.INTEGER);
		if (pers.getMartes_entrada() != null)
			qUpdate.setInt(OID_MAR_ENT, pers.getMartes_entrada().getOID());
		else
			qUpdate.setNull(OID_MAR_ENT, java.sql.Types.INTEGER);
		if (pers.getMartes_salida() != null)
			qUpdate.setInt(OID_MAR_SAL, pers.getMartes_salida().getOID());
		else
			qUpdate.setNull(OID_MAR_SAL, java.sql.Types.INTEGER);
		if (pers.getMiercoles_entrada() != null)
			qUpdate.setInt(OID_MIE_ENT, pers.getMiercoles_entrada().getOID());
		else
			qUpdate.setNull(OID_MIE_ENT, java.sql.Types.INTEGER);
		if (pers.getMiercoles_salida() != null)
			qUpdate.setInt(OID_MIE_SAL, pers.getMiercoles_salida().getOID());
		else
			qUpdate.setNull(OID_MIE_SAL, java.sql.Types.INTEGER);
		if (pers.getJueves_entrada() != null)
			qUpdate.setInt(OID_JUE_ENT, pers.getJueves_entrada().getOID());
		else
			qUpdate.setNull(OID_JUE_ENT, java.sql.Types.INTEGER);
		if (pers.getJueves_salida() != null)
			qUpdate.setInt(OID_JUE_SAL, pers.getJueves_salida().getOID());
		else
			qUpdate.setNull(OID_JUE_SAL, java.sql.Types.INTEGER);
		if (pers.getViernes_entrada() != null)
			qUpdate.setInt(OID_VIE_ENT, pers.getViernes_entrada().getOID());
		else
			qUpdate.setNull(OID_VIE_ENT, java.sql.Types.INTEGER);
		if (pers.getViermes_salida() != null)
			qUpdate.setInt(OID_VIE_SAL, pers.getViermes_salida().getOID());
		else
			qUpdate.setNull(OID_VIE_SAL, java.sql.Types.INTEGER);
		if (pers.getSabado_entrada() != null)
			qUpdate.setInt(OID_SAB_ENT, pers.getSabado_entrada().getOID());
		else
			qUpdate.setNull(OID_SAB_ENT, java.sql.Types.INTEGER);
		if (pers.getSabado_salida() != null)
			qUpdate.setInt(OID_SAB_SAL, pers.getSabado_salida().getOID());
		else
			qUpdate.setNull(OID_SAB_SAL, java.sql.Types.INTEGER);
		if (pers.getDomingo_entrada() != null)
			qUpdate.setInt(OID_DOM_ENT, pers.getDomingo_entrada().getOID());
		else
			qUpdate.setNull(OID_DOM_ENT, java.sql.Types.INTEGER);
		if (pers.getDomingo_salida() != null)
			qUpdate.setInt(OID_DOM_SAL, pers.getDomingo_salida().getOID());
		else
			qUpdate.setNull(OID_DOM_SAL, java.sql.Types.INTEGER);
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PLANIF_DIA = 1;
		PlanifDiaCacheo pers = (PlanifDiaCacheo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPlanifDiaCacheo " + " set activo=0 " + " where " + " oid_planif_dia=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PLANIF_DIA, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PLANIF_DIA = 1;
		PlanifDiaCacheo pers = (PlanifDiaCacheo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPlanifDiaCacheo " + " set activo=1 " + " where " + " oid_planif_dia=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PLANIF_DIA, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL: {
			ps = this.selectAll(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PLANIF_DIA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPlanifDiaCacheo ");
		textSQL.append(" WHERE oid_planif_dia = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PLANIF_DIA, oid);
		return querySelect;
	}

	private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPlanifDiaCacheo ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;

	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPlanifDiaCacheo ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_planif_dia oid, codigo,  descripcion ,activo ");
		textSQL.append(" from cipPlanifDiaCacheo");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static List getPlanifDiaCacheo(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(PlanifDiaCacheo.NICKNAME, DBPlanifDiaCacheo.SELECT_ALL, null, new ListObserver(), aSesion);
	}

}
