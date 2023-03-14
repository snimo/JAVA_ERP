package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.rrhh.bm.EvalObsGen;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEvalObsGen extends DBObjetoPersistente {

	public static final String OID_OBS_GEN = "oid_obs_gen";
	public static final String OID_EVAL_CAB = "oid_eval_cab";
	public static final String OBSERVACION = "observacion";
	public static final String FEC_ALTA = "fec_alta";
	public static final String OID_USU_ALTA = "oid_usu_alta";
	public static final String FEC_UTL_MODIF = "fec_utl_modif";
	public static final String OID_USU_MODIF = "oid_usu_modif";
	public static final String ACTIVO = "activo";
	
	public static final int SELECT_BY_EVALUACION = 100;

	public DBEvalObsGen() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_OBS_GEN = 1;
		final int OID_EVAL_CAB = 2;
		final int OBSERVACION = 3;
		final int FEC_ALTA = 4;
		final int OID_USU_ALTA = 5;
		final int FEC_UTL_MODIF = 6;
		final int OID_USU_MODIF = 7;
		final int ACTIVO = 8;

		EvalObsGen pers = (EvalObsGen) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhEvalObsGen " + " ( " + "OID_OBS_GEN," + "OID_EVAL_CAB," + "OBSERVACION," + "FEC_ALTA," + "OID_USU_ALTA," + "FEC_UTL_MODIF," + "OID_USU_MODIF," + "ACTIVO)"
				+ " values " + "(" + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_OBS_GEN, pers.getOID());
		qInsert.setInt(OID_EVAL_CAB, pers.getEvaluacion().getOID());
		qInsert.setString(OBSERVACION, pers.getObservacion());
		qInsert.setDate(FEC_ALTA, new java.sql.Date(pers.getFec_alta().getTime()));
		qInsert.setInt(OID_USU_ALTA, pers.getUsuario_alta().getOID());
		if (pers.getFec_utl_modif() != null)
			qInsert.setDate(FEC_UTL_MODIF, new java.sql.Date(pers.getFec_utl_modif().getTime()));
		else
			qInsert.setNull(FEC_UTL_MODIF, java.sql.Types.DATE);
		if (pers.getUsuario_modif() != null)
			qInsert.setInt(OID_USU_MODIF, pers.getUsuario_modif().getOID());
		else
			qInsert.setNull(OID_USU_MODIF, java.sql.Types.INTEGER);
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_EVAL_CAB = 1;
		final int OBSERVACION = 2;
		final int FEC_ALTA = 3;
		final int OID_USU_ALTA = 4;
		final int FEC_UTL_MODIF = 5;
		final int OID_USU_MODIF = 6;
		final int ACTIVO = 7;
		final int OID_OBS_GEN = 8;

		EvalObsGen pers = (EvalObsGen) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhEvalObsGen set " + "oid_eval_cab=?" + ",observacion=?" + ",fec_alta=?" + ",oid_usu_alta=?" + ",fec_utl_modif=?" + ",oid_usu_modif=?" + ",activo=?" + " where "
				+ " oid_obs_gen=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_GEN, pers.getOID());
		qUpdate.setInt(OID_EVAL_CAB, pers.getEvaluacion().getOID());
		qUpdate.setString(OBSERVACION, pers.getObservacion());
		qUpdate.setDate(FEC_ALTA, new java.sql.Date(pers.getFec_alta().getTime()));
		qUpdate.setInt(OID_USU_ALTA, pers.getUsuario_alta().getOID());
		if (pers.getFec_utl_modif() != null)
			qUpdate.setDate(FEC_UTL_MODIF,new java.sql.Date(pers.getFec_utl_modif().getTime()));
		else
			qUpdate.setNull(FEC_UTL_MODIF, java.sql.Types.DATE);
		if (pers.getUsuario_modif() != null)
			qUpdate.setInt(OID_USU_MODIF, pers.getUsuario_modif().getOID());
		else
			qUpdate.setNull(OID_USU_MODIF, java.sql.Types.INTEGER);
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OBS_GEN = 1;
		EvalObsGen pers = (EvalObsGen) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhEvalObsGen " + " set activo=0 " + " where " + " oid_obs_gen=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_GEN, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_OBS_GEN = 1;
		EvalObsGen pers = (EvalObsGen) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhEvalObsGen " + " set activo=1 " + " where " + " oid_obs_gen=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_OBS_GEN, pers.getOID());
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
		case SELECT_BY_EVALUACION: {
			ps = this.selectByEvaluacion(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_OBS_GEN = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEvalObsGen ");
		textSQL.append(" WHERE oid_obs_gen = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_OBS_GEN, oid);
		return querySelect;
	}

	private PreparedStatement selectByEvaluacion(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEvalObsGen ");
		textSQL.append(" WHERE oid_eval_cab = ? and activo = 1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		EvaluacionLegajoCab evaluacion = (EvaluacionLegajoCab) aCondiciones;
		querySelect.setInt(1, evaluacion.getOID());
		return querySelect;
	}
	
	
	
	
	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhEvalObsGen ");
		textSQL.append(" WHERE  = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_obs_gen oid, codigo,  descripcion ,activo ");
		textSQL.append(" from rhEvalObsGen");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	
	public static List getEvalObsGen(EvaluacionLegajoCab aEvaluacion,
              ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(EvalObsGen.NICKNAME,
                 DBEvalObsGen.SELECT_BY_EVALUACION,
                 aEvaluacion,
                 new ListObserver(),
                 aSesion);
	}
	

}
