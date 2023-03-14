package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.rrhh.bm.RankearCab;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBRankearCab extends DBObjetoPersistente {

	public static final String OID_RANKEAR = "oid_rankear";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACTIVO = "activo";
	public static final String RANK_POR_ANT_EMP = "rank_por_ant_emp";
	public static final String PTOS_ANT_EMP = "ptos_ant_emp";
	public static final String UT_ANT_EMP = "ut_ant_emp";
	public static final String POND_ANT_EMP = "pond_ant_emp";
	public static final String RANK_POR_ANT_PUE = "rank_por_ant_pue";
	public static final String PTOS_ANT_PUE = "ptos_ant_pue";
	public static final String UT_ANT_PUE = "ut_ant_pue";
	public static final String POND_ANT_PUE = "pond_ant_pue";
	public static final String RANK_POR_NOVEDAD = "rank_por_novedad";
	public static final String RANK_POR_EVAL = "rank_por_eval";
	public static final String EVAL_ULT_MESES = "eval_ult_meses";
	public static final String EVAL_CALIF_PUNTO = "eval_calif_punto";
	public static final String EVAL_PONDERACION = "eval_ponderacion";
	public static final String CM_ANT_REQ_EMP = "cm_ant_req_emp";
	public static final String CM_CANT_REQ_EMP = "cm_cant_req_emp";
	public static final String CM_UT_REQ_EMP = "cm_ut_req_emp";
	public static final String CM_ANT_REQ_PUE = "cm_ant_req_pue";
	public static final String CM_CANT_REQ_PUE = "cm_cant_req_pue";
	public static final String CM_UT_REQ_PUE = "cm_ut_req_pue";
	public static final String CM_APLICAR_EVAL = "cm_aplicar_eval";
	public static final String CM_PUNTAJE_EVAL = "cm_puntaje_eval";
	public static final String CM_APLIC_NOV_1 = "cm_aplic_nov_1";
	public static final String CM_DIAS_NOV_1 = "cm_dias_nov_1";
	public static final String CM_ULT_MES_NOV_1 = "cm_ult_mes_nov_1";
	public static final String CM_MOTIVOS_1 = "cm_motivos_1";
	public static final String CM_APLIC_NOV_2 = "cm_aplic_nov_2";
	public static final String CM_DIAS_NOV_2 = "cm_dias_nov_2";
	public static final String CM_ULT_MES_NOV_2 = "cm_ult_mes_nov_2";
	public static final String CM_MOTIVOS_2 = "cm_motivos_2";
	public static final String CM_APLIC_NOV_3 = "cm_aplic_nov_3";
	public static final String CM_DIAS_NOV_3 = "cm_dias_nov_3";
	public static final String CM_ULT_MES_NOV_3 = "cm_ult_mes_nov_3";
	public static final String CM_MOTIVOS_3 = "cm_motivos_3";
	public static final String CM_APLIC_NOV_4 = "cm_aplic_nov_4";
	public static final String CM_DIAS_NOV_4 = "cm_dias_nov_4";
	public static final String CM_ULT_MES_NOV_4 = "cm_ult_mes_nov_4";
	public static final String CM_MOTIVOS_4 = "cm_motivos_4";
	public static final String CM_APLIC_NOV_5 = "cm_aplic_nov_5";
	public static final String CM_DIAS_NOV_5 = "cm_dias_nov_5";
	public static final String CM_ULT_MES_NOV_5 = "cm_ult_mes_nov_5";
	public static final String CM_MOTIVOS_5 = "cm_motivos_5";
	public static final String RANK_POR_SANCION = "rank_por_sancion";
	public static final String CONTROL_ESTA_DESA = "control_esta_desa";
	
	public static final String CM_APLIC_NOV_6 = "cm_aplic_nov_6";
	public static final String CM_DIAS_NOV_6 = "cm_dias_nov_6";
	public static final String CM_ULT_MES_NOV_6 =  "cm_ult_mes_nov_6";
	public static final String CM_MOTIVOS_6 = "cm_motivos_6";
	
	public static final String CM_APLIC_NOV_7 = "cm_aplic_nov_7";
	public static final String CM_DIAS_NOV_7 = "cm_dias_nov_7";
	public static final String CM_ULT_MES_NOV_7 =  "cm_ult_mes_nov_7";
	public static final String CM_MOTIVOS_7 = "cm_motivos_7";
	
	public static final String CM_APLIC_NOV_8 = "cm_aplic_nov_8";
	public static final String CM_DIAS_NOV_8 = "cm_dias_nov_8";
	public static final String CM_ULT_MES_NOV_8 =  "cm_ult_mes_nov_8";
	public static final String CM_MOTIVOS_8 = "cm_motivos_8";
	
	public static final String CM_APLIC_NOV_9 = "cm_aplic_nov_9";
	public static final String CM_DIAS_NOV_9 = "cm_dias_nov_9";
	public static final String CM_ULT_MES_NOV_9 =  "cm_ult_mes_nov_9";
	public static final String CM_MOTIVOS_9 = "cm_motivos_9";
	
	public static final String CM_APLIC_NOV_10 = "cm_aplic_nov_10";
	public static final String CM_DIAS_NOV_10 = "cm_dias_nov_10";
	public static final String CM_ULT_MES_NOV_10 =  "cm_ult_mes_nov_10";
	public static final String CM_MOTIVOS_10 = "cm_motivos_10";
	
	public static final String CM_CALIF_GRAL = "cm_calif_gral";
	public static final String CM_PTOS_MIN_CALIF  ="cm_ptos_min_calif";
	public static final String CM_APLIC_JUEGOS_A = "cm_aplic_juegos_a";
	
	public static final String CM_APLIC_HOR_CAR = "cm_aplic_hor_car";
	
	public static final String DES_SANC_REST_MAS = "des_sanc_rest_mas";
	public static final String DES_NOV_REST_MAS = "des_nov_rest_mas";
	public static final String PTOS_MAX_REST_SANC = "ptos_max_rest_sanc";
	public static final String PTOS_MAX_REST_NOV = "ptos_max_rest_nov";

	public DBRankearCab() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_RANKEAR = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;
		final int RANK_POR_ANT_EMP = 5;
		final int PTOS_ANT_EMP = 6;
		final int UT_ANT_EMP = 7;
		final int POND_ANT_EMP = 8;
		final int RANK_POR_ANT_PUE = 9;
		final int PTOS_ANT_PUE = 10;
		final int UT_ANT_PUE = 11;
		final int POND_ANT_PUE = 12;
		final int RANK_POR_NOVEDAD = 13;
		final int RANK_POR_EVAL = 14;
		final int EVAL_ULT_MESES = 15;
		final int EVAL_CALIF_PUNTO = 16;
		final int EVAL_PONDERACION = 17;
		final int CM_ANT_REQ_EMP = 18;
		final int CM_CANT_REQ_EMP = 19;
		final int CM_UT_REQ_EMP = 20;
		final int CM_ANT_REQ_PUE = 21;
		final int CM_CANT_REQ_PUE = 22;
		final int CM_UT_REQ_PUE = 23;
		final int CM_APLICAR_EVAL = 24;
		final int CM_PUNTAJE_EVAL = 25;
		final int CM_APLIC_NOV_1 = 26;
		final int CM_DIAS_NOV_1 = 27;
		final int CM_ULT_MES_NOV_1 = 28;
		final int CM_MOTIVOS_1 = 29;
		final int CM_APLIC_NOV_2 = 30;
		final int CM_DIAS_NOV_2 = 31;
		final int CM_ULT_MES_NOV_2 = 32;
		final int CM_MOTIVOS_2 = 33;
		final int CM_APLIC_NOV_3 = 34;
		final int CM_DIAS_NOV_3 = 35;
		final int CM_ULT_MES_NOV_3 = 36;
		final int CM_MOTIVOS_3 = 37;
		final int CM_APLIC_NOV_4 = 38;
		final int CM_DIAS_NOV_4 = 39;
		final int CM_ULT_MES_NOV_4 = 40;
		final int CM_MOTIVOS_4 = 41;
		final int CM_APLIC_NOV_5 = 42;
		final int CM_DIAS_NOV_5 = 43;
		final int CM_ULT_MES_NOV_5 = 44;
		final int CM_MOTIVOS_5 = 45;
		final int RANK_POR_SANCION = 46;
		final int CONTROL_ESTA_DESA = 47;
		
		final int CM_APLIC_NOV_6 = 48;
		final int CM_DIAS_NOV_6 = 49;
		final int CM_ULT_MES_NOV_6 =  50;
		final int CM_MOTIVOS_6 = 51;
		
		final int CM_APLIC_NOV_7 = 52;
		final int CM_DIAS_NOV_7 = 53;
		final int CM_ULT_MES_NOV_7 =  54;
		final int CM_MOTIVOS_7 = 55;
		
		final int CM_APLIC_NOV_8 = 56;
		final int CM_DIAS_NOV_8 = 57;
		final int CM_ULT_MES_NOV_8 =  58;
		final int CM_MOTIVOS_8 = 59;
		
		final int CM_APLIC_NOV_9 = 60;
		final int CM_DIAS_NOV_9 = 61;
		final int CM_ULT_MES_NOV_9 =  62;
		final int CM_MOTIVOS_9 = 63;
		
		final int CM_APLIC_NOV_10 = 64;
		final int CM_DIAS_NOV_10 = 65;
		final int CM_ULT_MES_NOV_10 =  66;
		final int CM_MOTIVOS_10 = 67;
		
		final int CM_CALIF_GRAL = 68;
		final int CM_PTOS_MIN_CALIF  = 69;
		final int CM_APLIC_JUEGOS_A = 70;
		final int CM_APLIC_HOR_CAR = 71;
		final int DES_SANC_REST_MAS = 72;
		final int DES_NOV_REST_MAS = 73;
		final int PTOS_MAX_REST_SANC = 74;
		final int PTOS_MAX_REST_NOV = 75;
		


		RankearCab pers = (RankearCab) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into rhRankear " + " ( " + "OID_RANKEAR," + "CODIGO," + "DESCRIPCION," + "ACTIVO," + "RANK_POR_ANT_EMP," + "PTOS_ANT_EMP," + "UT_ANT_EMP," + "POND_ANT_EMP,"
				+ "RANK_POR_ANT_PUE," + "PTOS_ANT_PUE," + "UT_ANT_PUE," + "POND_ANT_PUE," + "RANK_POR_NOVEDAD," + "RANK_POR_EVAL," + "EVAL_ULT_MESES," + "EVAL_CALIF_PUNTO," + "EVAL_PONDERACION,"
				+ "CM_ANT_REQ_EMP," + "CM_CANT_REQ_EMP," + "CM_UT_REQ_EMP," + "CM_ANT_REQ_PUE," + "CM_CANT_REQ_PUE," + "CM_UT_REQ_PUE," + "CM_APLICAR_EVAL," + "CM_PUNTAJE_EVAL," + "CM_APLIC_NOV_1,"
				+ "CM_DIAS_NOV_1," + "CM_ULT_MES_NOV_1," + "CM_MOTIVOS_1," + "CM_APLIC_NOV_2," + "CM_DIAS_NOV_2," + "CM_ULT_MES_NOV_2," + "CM_MOTIVOS_2," + "CM_APLIC_NOV_3," + "CM_DIAS_NOV_3,"
				+ "CM_ULT_MES_NOV_3," + "CM_MOTIVOS_3," + "CM_APLIC_NOV_4," + "CM_DIAS_NOV_4," + "CM_ULT_MES_NOV_4," + "CM_MOTIVOS_4," + "CM_APLIC_NOV_5," + "CM_DIAS_NOV_5," + "CM_ULT_MES_NOV_5,"
				+ "CM_MOTIVOS_5 , RANK_POR_SANCION,CONTROL_ESTA_DESA,"+
				"cm_aplic_nov_6,cm_dias_nov_6,cm_ult_mes_nov_6,cm_motivos_6,"+
				"cm_aplic_nov_7,cm_dias_nov_7,cm_ult_mes_nov_7,cm_motivos_7,"+
				"cm_aplic_nov_8,cm_dias_nov_8,cm_ult_mes_nov_8,cm_motivos_8,"+
				"cm_aplic_nov_9,cm_dias_nov_9,cm_ult_mes_nov_9,cm_motivos_9,"+
				"cm_aplic_nov_10,cm_dias_nov_10,cm_ult_mes_nov_10,cm_motivos_10,cm_calif_gral,cm_ptos_min_calif,cm_aplic_juegos_a,cm_aplic_hor_car,DES_SANC_REST_MAS,DES_NOV_REST_MAS,PTOS_MAX_REST_SANC,PTOS_MAX_REST_NOV"
				+")"
				+ " values " + "(" + "?," + "?,"+ "?," + "?," + "?,"+ "?,"+ "?," + "?," + "?," + "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?," + "?," + "?,"+ "?," + "?," + "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?," + "?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_RANKEAR, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.isRank_por_ant_emp()!=null)
			qInsert.setBoolean(RANK_POR_ANT_EMP, pers.isRank_por_ant_emp().booleanValue());
		else
			qInsert.setNull(RANK_POR_ANT_EMP, Types.BOOLEAN);
		if (pers.getPtos_ant_emp() != null)
			qInsert.setDouble(PTOS_ANT_EMP, pers.getPtos_ant_emp().doubleValue());
		else
			qInsert.setNull(PTOS_ANT_EMP, java.sql.Types.DOUBLE);
		if (pers.getUnitiempoantemp()!=null)
			qInsert.setString(UT_ANT_EMP, pers.getUnitiempoantemp());
		else
			qInsert.setNull(UT_ANT_EMP, Types.VARCHAR);
		if (pers.getPond_ant_emp() != null)
			qInsert.setDouble(POND_ANT_EMP, pers.getPond_ant_emp().doubleValue());
		else
			qInsert.setNull(POND_ANT_EMP, java.sql.Types.DOUBLE);
		if (pers.isRank_por_ant_pue()!=null)
			qInsert.setBoolean(RANK_POR_ANT_PUE, pers.isRank_por_ant_pue().booleanValue());
		else
			qInsert.setNull(RANK_POR_ANT_PUE, Types.BOOLEAN);
		if (pers.getPtos_ant_pue() != null)
			qInsert.setDouble(PTOS_ANT_PUE, pers.getPtos_ant_pue().doubleValue());
		else
			qInsert.setNull(PTOS_ANT_PUE, java.sql.Types.DOUBLE);
		if (pers.getUt_ant_pue()!=null)
			qInsert.setString(UT_ANT_PUE, pers.getUt_ant_pue());
		else
			qInsert.setNull(UT_ANT_PUE, Types.VARCHAR);
		if (pers.getPond_ant_pue() != null)
			qInsert.setDouble(POND_ANT_PUE, pers.getPond_ant_pue().doubleValue());
		else
			qInsert.setNull(POND_ANT_PUE, java.sql.Types.DOUBLE);
		if (pers.isRank_por_novedad()!=null)
			qInsert.setBoolean(RANK_POR_NOVEDAD, pers.isRank_por_novedad().booleanValue());
		else
			qInsert.setNull(RANK_POR_NOVEDAD, Types.BOOLEAN);
		if (pers.isRank_por_eval()!=null)
			qInsert.setBoolean(RANK_POR_EVAL, pers.isRank_por_eval().booleanValue());
		else
			qInsert.setNull(RANK_POR_EVAL, Types.BOOLEAN);
		if (pers.getEval_ult_meses()!=null)
			qInsert.setInt(EVAL_ULT_MESES, pers.getEval_ult_meses().intValue());
		else
			qInsert.setNull(EVAL_ULT_MESES, Types.INTEGER);
		if (pers.getEval_calif_punto()!=null)
			qInsert.setDouble(EVAL_CALIF_PUNTO, pers.getEval_calif_punto().doubleValue());
		else
			qInsert.setNull(EVAL_CALIF_PUNTO, Types.INTEGER);
		if (pers.getEval_ponderacion() != null)
			qInsert.setDouble(EVAL_PONDERACION, pers.getEval_ponderacion().doubleValue());
		else
			qInsert.setNull(EVAL_PONDERACION, java.sql.Types.DOUBLE);
		if (pers.isCm_ant_req_emp()!=null)
			qInsert.setBoolean(CM_ANT_REQ_EMP, pers.isCm_ant_req_emp().booleanValue());
		else
			qInsert.setNull(CM_ANT_REQ_EMP, Types.BOOLEAN);
		if (pers.getCm_cant_req_emp()!=null)
			qInsert.setInt(CM_CANT_REQ_EMP, pers.getCm_cant_req_emp().intValue());
		else
			qInsert.setNull(CM_CANT_REQ_EMP, Types.INTEGER);
		if (pers.getCm_ut_req_emp()!=null)
			qInsert.setString(CM_UT_REQ_EMP, pers.getCm_ut_req_emp());
		else
			qInsert.setNull(CM_UT_REQ_EMP, Types.VARCHAR);
		if (pers.isCm_ant_req_pue()!=null)
			qInsert.setBoolean(CM_ANT_REQ_PUE, pers.isCm_ant_req_pue().booleanValue());
		else
			qInsert.setNull(CM_ANT_REQ_PUE, Types.BOOLEAN);
		if (pers.getCm_cant_req_pue()!=null)
			qInsert.setInt(CM_CANT_REQ_PUE, pers.getCm_cant_req_pue().intValue());
		else
			qInsert.setNull(CM_CANT_REQ_PUE, Types.INTEGER);
		if (pers.getCm_ut_req_pue()!=null)
			qInsert.setString(CM_UT_REQ_PUE, pers.getCm_ut_req_pue());
		else
			qInsert.setNull(CM_UT_REQ_PUE, Types.VARCHAR);
		if (pers.isCm_aplicar_eval()!=null)
			qInsert.setBoolean(CM_APLICAR_EVAL, pers.isCm_aplicar_eval().booleanValue());
		else
			qInsert.setNull(CM_APLICAR_EVAL, Types.BOOLEAN);
		if (pers.getCm_puntaje_eval() != null)
			qInsert.setDouble(CM_PUNTAJE_EVAL, pers.getCm_puntaje_eval().doubleValue());
		else
			qInsert.setNull(CM_PUNTAJE_EVAL, java.sql.Types.DOUBLE);
		if (pers.isCm_aplic_nov_1()!=null)
			qInsert.setBoolean(CM_APLIC_NOV_1, pers.isCm_aplic_nov_1().booleanValue());
		else
			qInsert.setNull(CM_APLIC_NOV_1, Types.BOOLEAN);
		if (pers.getCm_dias_nov_1()!=null)
			qInsert.setInt(CM_DIAS_NOV_1, pers.getCm_dias_nov_1().intValue());
		else
			qInsert.setNull(CM_DIAS_NOV_1, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_1()!=null)
			qInsert.setInt(CM_ULT_MES_NOV_1, pers.getCm_ult_mes_nov_1().intValue());
		else
			qInsert.setNull(CM_ULT_MES_NOV_1, Types.INTEGER);
		if (pers.getCm_motivos_1()!=null)
			qInsert.setString(CM_MOTIVOS_1, pers.getCm_motivos_1());
		else
			qInsert.setNull(CM_MOTIVOS_1, Types.VARCHAR);
		if (pers.isCm_aplic_nov_2()!=null)
			qInsert.setBoolean(CM_APLIC_NOV_2, pers.isCm_aplic_nov_2().booleanValue());
		else
			qInsert.setNull(CM_APLIC_NOV_2, Types.BOOLEAN);
		if (pers.getCm_dias_nov_2()!=null)
			qInsert.setInt(CM_DIAS_NOV_2, pers.getCm_dias_nov_2().intValue());
		else
			qInsert.setNull(CM_DIAS_NOV_2, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_2()!=null)
			qInsert.setInt(CM_ULT_MES_NOV_2, pers.getCm_ult_mes_nov_2().intValue());
		else
			qInsert.setNull(CM_ULT_MES_NOV_2, Types.INTEGER);
		if (pers.getCm_motivos_2()!=null)
			qInsert.setString(CM_MOTIVOS_2, pers.getCm_motivos_2());
		else
			qInsert.setNull(CM_MOTIVOS_2, Types.VARCHAR);
		if (pers.isCm_aplic_nov_3()!=null)
			qInsert.setBoolean(CM_APLIC_NOV_3, pers.isCm_aplic_nov_3().booleanValue());
		else
			qInsert.setNull(CM_APLIC_NOV_3, Types.BOOLEAN);
		if (pers.getCm_dias_nov_3()!=null)
			qInsert.setInt(CM_DIAS_NOV_3, pers.getCm_dias_nov_3().intValue());
		else
			qInsert.setNull(CM_DIAS_NOV_3, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_3()!=null)
			qInsert.setInt(CM_ULT_MES_NOV_3, pers.getCm_ult_mes_nov_3().intValue());
		else
			qInsert.setNull(CM_ULT_MES_NOV_3, Types.INTEGER);
		if (pers.getCm_motivos_3()!=null)
			qInsert.setString(CM_MOTIVOS_3, pers.getCm_motivos_3());
		else
			qInsert.setNull(CM_MOTIVOS_3, Types.VARCHAR);
		if (pers.isCm_aplic_nov_4()!=null)
			qInsert.setBoolean(CM_APLIC_NOV_4, pers.isCm_aplic_nov_4().booleanValue());
		else
			qInsert.setNull(CM_APLIC_NOV_4, Types.BOOLEAN);
		if (pers.getCm_dias_nov_4()!=null)	
			qInsert.setInt(CM_DIAS_NOV_4, pers.getCm_dias_nov_4().intValue());
		else
			qInsert.setNull(CM_DIAS_NOV_4, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_4()!=null)
			qInsert.setInt(CM_ULT_MES_NOV_4, pers.getCm_ult_mes_nov_4().intValue());
		else
			qInsert.setNull(CM_ULT_MES_NOV_4, Types.INTEGER);
		if (pers.getCm_motivos_4()!=null)
			qInsert.setString(CM_MOTIVOS_4, pers.getCm_motivos_4());
		else
			qInsert.setNull(CM_MOTIVOS_4, Types.VARCHAR);
		if (pers.isCm_aplic_nov_5()!=null)
			qInsert.setBoolean(CM_APLIC_NOV_5, pers.isCm_aplic_nov_5().booleanValue());
		else
			qInsert.setNull(CM_APLIC_NOV_5, Types.BOOLEAN);
		if (pers.getCm_dias_nov_5()!=null)
			qInsert.setInt(CM_DIAS_NOV_5, pers.getCm_dias_nov_5().intValue());
		else
			qInsert.setNull(CM_DIAS_NOV_5, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_5()!=null)
			qInsert.setInt(CM_ULT_MES_NOV_5, pers.getCm_ult_mes_nov_5().intValue());
		else
			qInsert.setNull(CM_ULT_MES_NOV_5, Types.INTEGER);
		if (pers.getCm_motivos_5()!=null)
			qInsert.setString(CM_MOTIVOS_5, pers.getCm_motivos_5());
		else
			qInsert.setNull(CM_MOTIVOS_5, Types.VARCHAR);
		if (pers.isRankearPorSancion()!=null)
			qInsert.setBoolean(RANK_POR_SANCION, pers.isRankearPorSancion());
		else
			qInsert.setNull(RANK_POR_SANCION, Types.BOOLEAN);
		if (pers.isControlarEstadoDesa()!=null)
			qInsert.setBoolean(CONTROL_ESTA_DESA, pers.isControlarEstadoDesa());
		else
			qInsert.setNull(CONTROL_ESTA_DESA, Types.BOOLEAN);
		
		if (pers.isCm_aplic_nov_6()!=null)
			qInsert.setBoolean(CM_APLIC_NOV_6, pers.isCm_aplic_nov_6());
		else
			qInsert.setNull(CM_APLIC_NOV_6, Types.BOOLEAN);
		if (pers.getCm_dias_nov_6()!=null)
			qInsert.setInt(CM_DIAS_NOV_6, pers.getCm_dias_nov_6().intValue());
		else
			qInsert.setNull(CM_DIAS_NOV_6, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_6()!=null)
			qInsert.setInt(CM_ULT_MES_NOV_6, pers.getCm_ult_mes_nov_6().intValue());
		else
			qInsert.setNull(CM_ULT_MES_NOV_6, Types.INTEGER);
		if (pers.getCm_motivos_6()!=null)
			qInsert.setString(CM_MOTIVOS_6, pers.getCm_motivos_6());
		else
			qInsert.setNull(CM_MOTIVOS_6, Types.VARCHAR);
		
		//
		if (pers.isCm_aplic_nov_7()!=null)
			qInsert.setBoolean(CM_APLIC_NOV_7, pers.isCm_aplic_nov_7());
		else
			qInsert.setNull(CM_APLIC_NOV_7, Types.BOOLEAN);
		if (pers.getCm_dias_nov_7()!=null)
			qInsert.setInt(CM_DIAS_NOV_7, pers.getCm_dias_nov_7().intValue());
		else
			qInsert.setNull(CM_DIAS_NOV_7, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_7()!=null)
			qInsert.setInt(CM_ULT_MES_NOV_7, pers.getCm_ult_mes_nov_7().intValue());
		else
			qInsert.setNull(CM_ULT_MES_NOV_7, Types.INTEGER);
		if (pers.getCm_motivos_7()!=null)
			qInsert.setString(CM_MOTIVOS_7, pers.getCm_motivos_7());
		else
			qInsert.setNull(CM_MOTIVOS_7, Types.VARCHAR);
		//
		if (pers.isCm_aplic_nov_8()!=null)
			qInsert.setBoolean(CM_APLIC_NOV_8, pers.isCm_aplic_nov_8());
		else
			qInsert.setNull(CM_APLIC_NOV_8, Types.BOOLEAN);
		if (pers.getCm_dias_nov_8()!=null)
			qInsert.setInt(CM_DIAS_NOV_8, pers.getCm_dias_nov_8().intValue());
		else
			qInsert.setNull(CM_DIAS_NOV_8, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_8()!=null)
			qInsert.setInt(CM_ULT_MES_NOV_8, pers.getCm_ult_mes_nov_8().intValue());
		else
			qInsert.setNull(CM_ULT_MES_NOV_8, Types.INTEGER);
		if (pers.getCm_motivos_8()!=null)
			qInsert.setString(CM_MOTIVOS_8, pers.getCm_motivos_8());
		else
			qInsert.setNull(CM_MOTIVOS_8, Types.VARCHAR);
		//
		if (pers.isCm_aplic_nov_9()!=null)
			qInsert.setBoolean(CM_APLIC_NOV_9, pers.isCm_aplic_nov_9());
		else
			qInsert.setNull(CM_APLIC_NOV_9, Types.BOOLEAN);
		if (pers.getCm_dias_nov_9()!=null)
			qInsert.setInt(CM_DIAS_NOV_9, pers.getCm_dias_nov_9().intValue());
		else
			qInsert.setNull(CM_DIAS_NOV_9, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_9()!=null)
			qInsert.setInt(CM_ULT_MES_NOV_9, pers.getCm_ult_mes_nov_9().intValue());
		else
			qInsert.setNull(CM_ULT_MES_NOV_9, Types.INTEGER);
		if (pers.getCm_motivos_9()!=null)
			qInsert.setString(CM_MOTIVOS_9, pers.getCm_motivos_9());
		else
			qInsert.setNull(CM_MOTIVOS_9, Types.VARCHAR);
		//
		if (pers.isCm_aplic_nov_10()!=null)
			qInsert.setBoolean(CM_APLIC_NOV_10, pers.isCm_aplic_nov_10());
		else
			qInsert.setNull(CM_APLIC_NOV_10, Types.BOOLEAN);
		if (pers.getCm_dias_nov_10()!=null)
			qInsert.setInt(CM_DIAS_NOV_10, pers.getCm_dias_nov_10().intValue());
		else
			qInsert.setNull(CM_DIAS_NOV_10, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_10()!=null)
			qInsert.setInt(CM_ULT_MES_NOV_10, pers.getCm_ult_mes_nov_10().intValue());
		else
			qInsert.setNull(CM_ULT_MES_NOV_10, Types.INTEGER);
		if (pers.getCm_motivos_10()!=null)
			qInsert.setString(CM_MOTIVOS_10, pers.getCm_motivos_10());
		else
			qInsert.setNull(CM_MOTIVOS_10, Types.VARCHAR);
		if (pers.isAplicClasifGral()!=null)
			qInsert.setBoolean(CM_CALIF_GRAL, pers.isAplicClasifGral().booleanValue());
		else
			qInsert.setNull(CM_CALIF_GRAL, Types.BOOLEAN);
		
		if (pers.getPtosMinCalifGral()!=null)
			qInsert.setDouble(CM_PTOS_MIN_CALIF, pers.getPtosMinCalifGral().doubleValue());
		else
			qInsert.setNull(CM_PTOS_MIN_CALIF, Types.DOUBLE);
		
		if (pers.isAplicCMJuegosA()!=null)
			qInsert.setBoolean(CM_APLIC_JUEGOS_A, pers.isAplicCMJuegosA().booleanValue());
		else
			qInsert.setNull(CM_APLIC_JUEGOS_A, Types.BOOLEAN);
		
		if (pers.isAplicHoriCarrera()!=null)
			qInsert.setBoolean(CM_APLIC_HOR_CAR, pers.isAplicHoriCarrera().booleanValue());
		else
			qInsert.setBoolean(CM_APLIC_HOR_CAR, false);
		
		
		qInsert.setBoolean(DES_SANC_REST_MAS, pers.IsDesapruebaSiSancRestanMas());
		qInsert.setBoolean(DES_NOV_REST_MAS, pers.IsDesapruebaSiNoveRestanMas());
		if (pers.getPtosMaxDesapruebaSanc()!=null)
			qInsert.setDouble(PTOS_MAX_REST_SANC , pers.getPtosMaxDesapruebaSanc().doubleValue());
		else
			qInsert.setNull(PTOS_MAX_REST_SANC , Types.DOUBLE);
		if (pers.getPtosMaxDesapruebaNov()!=null)
			qInsert.setDouble(PTOS_MAX_REST_NOV, pers.getPtosMaxDesapruebaNov().doubleValue());
		else
			qInsert.setNull(PTOS_MAX_REST_NOV , Types.DOUBLE);		
			
		

		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int RANK_POR_ANT_EMP = 4;
		final int PTOS_ANT_EMP = 5;
		final int UT_ANT_EMP = 6;
		final int POND_ANT_EMP = 7;
		final int RANK_POR_ANT_PUE = 8;
		final int PTOS_ANT_PUE = 9;
		final int UT_ANT_PUE = 10;
		final int POND_ANT_PUE = 11;
		final int RANK_POR_NOVEDAD = 12;
		final int RANK_POR_EVAL = 13;
		final int EVAL_ULT_MESES = 14;
		final int EVAL_CALIF_PUNTO = 15;
		final int EVAL_PONDERACION = 16;
		final int CM_ANT_REQ_EMP = 17;
		final int CM_CANT_REQ_EMP = 18;
		final int CM_UT_REQ_EMP = 19;
		final int CM_ANT_REQ_PUE = 20;
		final int CM_CANT_REQ_PUE = 21;
		final int CM_UT_REQ_PUE = 22;
		final int CM_APLICAR_EVAL = 23;
		final int CM_PUNTAJE_EVAL = 24;
		final int CM_APLIC_NOV_1 = 25;
		final int CM_DIAS_NOV_1 = 26;
		final int CM_ULT_MES_NOV_1 = 27;
		final int CM_MOTIVOS_1 = 28;
		final int CM_APLIC_NOV_2 = 29;
		final int CM_DIAS_NOV_2 = 30;
		final int CM_ULT_MES_NOV_2 = 31;
		final int CM_MOTIVOS_2 = 32;
		final int CM_APLIC_NOV_3 = 33;
		final int CM_DIAS_NOV_3 = 34;
		final int CM_ULT_MES_NOV_3 = 35;
		final int CM_MOTIVOS_3 = 36;
		final int CM_APLIC_NOV_4 = 37;
		final int CM_DIAS_NOV_4 = 38;
		final int CM_ULT_MES_NOV_4 = 39;
		final int CM_MOTIVOS_4 = 40;
		final int CM_APLIC_NOV_5 = 41;
		final int CM_DIAS_NOV_5 = 42;
		final int CM_ULT_MES_NOV_5 = 43;
		final int CM_MOTIVOS_5 = 44;
		final int RANK_POR_SANCION = 45;
		final int CONTROL_ESTA_DESA = 46;
		
		final int CM_APLIC_NOV_6 = 47;
		final int CM_DIAS_NOV_6 = 48;
		final int CM_ULT_MES_NOV_6 =  49;
		final int CM_MOTIVOS_6 = 50;
		
		final int CM_APLIC_NOV_7 = 51;
		final int CM_DIAS_NOV_7 = 52;
		final int CM_ULT_MES_NOV_7 =  53;
		final int CM_MOTIVOS_7 = 54;
		
		final int CM_APLIC_NOV_8 = 55;
		final int CM_DIAS_NOV_8 = 56;
		final int CM_ULT_MES_NOV_8 =  57;
		final int CM_MOTIVOS_8 = 58;
		
		final int CM_APLIC_NOV_9 = 59;
		final int CM_DIAS_NOV_9 = 60;
		final int CM_ULT_MES_NOV_9 =  61;
		final int CM_MOTIVOS_9 = 62;
		
		final int CM_APLIC_NOV_10 = 63;
		final int CM_DIAS_NOV_10 = 64;
		final int CM_ULT_MES_NOV_10 =  65;
		final int CM_MOTIVOS_10 = 66;
		
		final int CM_CALIF_GRAL = 67;
		final int CM_PTOS_MIN_CALIF  = 68;
		final int CM_APLIC_JUEGOS_A = 69;
		final int CM_APLIC_HOR_CAR = 70;
		
		final int DES_SANC_REST_MAS = 71;
		final int DES_NOV_REST_MAS = 72;
		final int PTOS_MAX_REST_SANC = 73;
		final int PTOS_MAX_REST_NOV = 74;
		
		final int OID_RANKEAR = 75;

		RankearCab pers = (RankearCab) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update rhRankear set " + "codigo=?" + ",descripcion=?" + ",activo=?" + ",rank_por_ant_emp=?" + ",ptos_ant_emp=?" + ",ut_ant_emp=?" + ",pond_ant_emp=?"
				+ ",rank_por_ant_pue=?" + ",ptos_ant_pue=?" + ",ut_ant_pue=?" + ",pond_ant_pue=?" + ",rank_por_novedad=?" + ",rank_por_eval=?" + ",eval_ult_meses=?" + ",eval_calif_punto=?"
				+ ",eval_ponderacion=?" + ",cm_ant_req_emp=?" + ",cm_cant_req_emp=?" + ",cm_ut_req_emp=?" + ",cm_ant_req_pue=?" + ",cm_cant_req_pue=?" + ",cm_ut_req_pue=?" + ",cm_aplicar_eval=?"
				+ ",cm_puntaje_eval=?" + ",cm_aplic_nov_1=?" + ",cm_dias_nov_1=?" + ",cm_ult_mes_nov_1=?" + ",cm_motivos_1=?" + ",cm_aplic_nov_2=?" + ",cm_dias_nov_2=?" + ",cm_ult_mes_nov_2=?"
				+ ",cm_motivos_2=?" + ",cm_aplic_nov_3=?" + ",cm_dias_nov_3=?" + ",cm_ult_mes_nov_3=?" + ",cm_motivos_3=?" + ",cm_aplic_nov_4=?" + ",cm_dias_nov_4=?" + ",cm_ult_mes_nov_4=?"
				+ ",cm_motivos_4=?" + ",cm_aplic_nov_5=?" + ",cm_dias_nov_5=?" + ",cm_ult_mes_nov_5=?" + ",cm_motivos_5=? , rank_por_sancion = ? , control_esta_desa = ?, " +
				"cm_aplic_nov_6=?,cm_dias_nov_6=?,cm_ult_mes_nov_6=?,cm_motivos_6=?,"+
				"cm_aplic_nov_7=?,cm_dias_nov_7=?,cm_ult_mes_nov_7=?,cm_motivos_7=?,"+
				"cm_aplic_nov_8=?,cm_dias_nov_8=?,cm_ult_mes_nov_8=?,cm_motivos_8=?,"+
				"cm_aplic_nov_9=?,cm_dias_nov_9=?,cm_ult_mes_nov_9=?,cm_motivos_9=?,"+
				"cm_aplic_nov_10=?,cm_dias_nov_10=?,cm_ult_mes_nov_10=?,cm_motivos_10=? , cm_calif_gral = ? , cm_ptos_min_calif = ? , cm_aplic_juegos_a=? , cm_aplic_hor_car = ? ,des_sanc_rest_mas = ? , des_nov_rest_mas = ? , ptos_max_rest_sanc = ? , ptos_max_rest_nov = ? "+
				" where " + " oid_rankear=? ");

		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RANKEAR, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.isRank_por_ant_emp()!=null)
			qUpdate.setBoolean(RANK_POR_ANT_EMP, pers.isRank_por_ant_emp().booleanValue());
		else
			qUpdate.setNull(RANK_POR_ANT_EMP, Types.BOOLEAN);
		if (pers.getPtos_ant_emp() != null)
			qUpdate.setDouble(PTOS_ANT_EMP, pers.getPtos_ant_emp().doubleValue());
		else
			qUpdate.setNull(PTOS_ANT_EMP, java.sql.Types.DOUBLE);
		if (pers.getUnitiempoantemp()!=null)
			qUpdate.setString(UT_ANT_EMP, pers.getUnitiempoantemp());
		else
			qUpdate.setNull(UT_ANT_EMP, Types.VARCHAR);
		if (pers.getPond_ant_emp() != null)
			qUpdate.setDouble(POND_ANT_EMP, pers.getPond_ant_emp().doubleValue());
		else
			qUpdate.setNull(POND_ANT_EMP, java.sql.Types.DOUBLE);
		if (pers.isRank_por_ant_pue()!=null)
			qUpdate.setBoolean(RANK_POR_ANT_PUE, pers.isRank_por_ant_pue().booleanValue());
		else
			qUpdate.setNull(RANK_POR_ANT_PUE, Types.BOOLEAN);
		if (pers.getPtos_ant_pue() != null)
			qUpdate.setDouble(PTOS_ANT_PUE, pers.getPtos_ant_pue().doubleValue());
		else
			qUpdate.setNull(PTOS_ANT_PUE, java.sql.Types.DOUBLE);
		if (pers.getUt_ant_pue()!=null)
			qUpdate.setString(UT_ANT_PUE, pers.getUt_ant_pue());
		else
			qUpdate.setNull(UT_ANT_PUE, Types.VARCHAR);
		if (pers.getPond_ant_pue() != null)
			qUpdate.setDouble(POND_ANT_PUE, pers.getPond_ant_pue().doubleValue());
		else
			qUpdate.setNull(POND_ANT_PUE, java.sql.Types.DOUBLE);
		if (pers.isRank_por_novedad()!=null)
			qUpdate.setBoolean(RANK_POR_NOVEDAD, pers.isRank_por_novedad().booleanValue());
		else
			qUpdate.setNull(RANK_POR_NOVEDAD, Types.BOOLEAN);
		if (pers.isRank_por_eval()!=null)
			qUpdate.setBoolean(RANK_POR_EVAL, pers.isRank_por_eval().booleanValue());
		else
			qUpdate.setNull(RANK_POR_EVAL, Types.BOOLEAN);
		if (pers.getEval_ult_meses()!=null)
			qUpdate.setInt(EVAL_ULT_MESES, pers.getEval_ult_meses().intValue());
		else
			qUpdate.setNull(EVAL_ULT_MESES, Types.INTEGER);
		if (pers.getEval_calif_punto()!=null)
			qUpdate.setDouble(EVAL_CALIF_PUNTO, pers.getEval_calif_punto().doubleValue());
		else
			qUpdate.setNull(EVAL_CALIF_PUNTO, Types.DOUBLE);
		if (pers.getEval_ponderacion() != null)
			qUpdate.setDouble(EVAL_PONDERACION, pers.getEval_ponderacion().doubleValue());
		else
			qUpdate.setNull(EVAL_PONDERACION, java.sql.Types.DOUBLE);
		if (pers.isCm_ant_req_emp()!=null)
			qUpdate.setBoolean(CM_ANT_REQ_EMP, pers.isCm_ant_req_emp().booleanValue());
		else
			qUpdate.setNull(CM_ANT_REQ_EMP, Types.BOOLEAN);
		if (pers.getCm_cant_req_emp()!=null)
			qUpdate.setInt(CM_CANT_REQ_EMP, pers.getCm_cant_req_emp().intValue());
		else
			qUpdate.setNull(CM_CANT_REQ_EMP, Types.INTEGER);
		if (pers.getCm_ut_req_emp()!=null)
			qUpdate.setString(CM_UT_REQ_EMP, pers.getCm_ut_req_emp());
		else
			qUpdate.setNull(CM_UT_REQ_EMP, Types.VARCHAR);
		if (pers.isCm_ant_req_pue()!=null)
			qUpdate.setBoolean(CM_ANT_REQ_PUE, pers.isCm_ant_req_pue().booleanValue());
		else
			qUpdate.setNull(CM_ANT_REQ_PUE, Types.BOOLEAN);
		if (pers.getCm_cant_req_pue()!=null)
			qUpdate.setInt(CM_CANT_REQ_PUE, pers.getCm_cant_req_pue().intValue());
		else
			qUpdate.setNull(CM_CANT_REQ_PUE, Types.INTEGER);
		if (pers.getCm_ut_req_pue()!=null)
			qUpdate.setString(CM_UT_REQ_PUE, pers.getCm_ut_req_pue());
		else
			qUpdate.setNull(CM_UT_REQ_PUE, Types.VARCHAR);
		if (pers.isCm_aplicar_eval()!=null)
			qUpdate.setBoolean(CM_APLICAR_EVAL, pers.isCm_aplicar_eval().booleanValue());
		else
			qUpdate.setNull(CM_APLICAR_EVAL, Types.BOOLEAN);
		if (pers.getCm_puntaje_eval() != null)
			qUpdate.setDouble(CM_PUNTAJE_EVAL, pers.getCm_puntaje_eval().doubleValue());
		else
			qUpdate.setNull(CM_PUNTAJE_EVAL, java.sql.Types.DOUBLE);
		if (pers.isCm_aplic_nov_1()!=null)
			qUpdate.setBoolean(CM_APLIC_NOV_1, pers.isCm_aplic_nov_1().booleanValue());
		else
			qUpdate.setNull(CM_APLIC_NOV_1, Types.BOOLEAN);
		if (pers.getCm_dias_nov_1()!=null)
			qUpdate.setInt(CM_DIAS_NOV_1, pers.getCm_dias_nov_1().intValue());
		else
			qUpdate.setNull(CM_DIAS_NOV_1, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_1()!=null)
			qUpdate.setInt(CM_ULT_MES_NOV_1, pers.getCm_ult_mes_nov_1().intValue());
		else
			qUpdate.setNull(CM_ULT_MES_NOV_1, Types.INTEGER);
		if (pers.getCm_motivos_1()!=null)
			qUpdate.setString(CM_MOTIVOS_1, pers.getCm_motivos_1());
		else
			qUpdate.setNull(CM_MOTIVOS_1, Types.VARCHAR);
		if (pers.isCm_aplic_nov_2()!=null)
			qUpdate.setBoolean(CM_APLIC_NOV_2, pers.isCm_aplic_nov_2().booleanValue());
		else
			qUpdate.setNull(CM_APLIC_NOV_2, Types.BOOLEAN);
		if (pers.getCm_dias_nov_2()!=null)
			qUpdate.setInt(CM_DIAS_NOV_2, pers.getCm_dias_nov_2().intValue());
		else
			qUpdate.setInt(CM_DIAS_NOV_2, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_2()!=null)
			qUpdate.setInt(CM_ULT_MES_NOV_2, pers.getCm_ult_mes_nov_2().intValue());
		else
			qUpdate.setNull(CM_ULT_MES_NOV_2, Types.INTEGER);
		if (pers.getCm_motivos_2()!=null)
			qUpdate.setString(CM_MOTIVOS_2, pers.getCm_motivos_2());
		else
			qUpdate.setNull(CM_MOTIVOS_2, Types.VARCHAR);
		if (pers.isCm_aplic_nov_3()!=null)
			qUpdate.setBoolean(CM_APLIC_NOV_3, pers.isCm_aplic_nov_3().booleanValue());
		else
			qUpdate.setNull(CM_APLIC_NOV_3, Types.BOOLEAN);
		if (pers.getCm_dias_nov_3()!=null)
			qUpdate.setInt(CM_DIAS_NOV_3, pers.getCm_dias_nov_3().intValue());
		else
			qUpdate.setNull(CM_DIAS_NOV_3, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_3()!=null)
			qUpdate.setInt(CM_ULT_MES_NOV_3, pers.getCm_ult_mes_nov_3().intValue());
		else
			qUpdate.setNull(CM_ULT_MES_NOV_3, Types.INTEGER);
		if (pers.getCm_motivos_3()!=null)
			qUpdate.setString(CM_MOTIVOS_3, pers.getCm_motivos_3());
		else
			qUpdate.setNull(CM_MOTIVOS_3, Types.VARCHAR);
		if (pers.isCm_aplic_nov_4()!=null)
			qUpdate.setBoolean(CM_APLIC_NOV_4, pers.isCm_aplic_nov_4().booleanValue());
		else
			qUpdate.setNull(CM_APLIC_NOV_4, Types.BOOLEAN);
		if (pers.getCm_dias_nov_4()!=null)
			qUpdate.setInt(CM_DIAS_NOV_4, pers.getCm_dias_nov_4().intValue());
		else
			qUpdate.setNull(CM_DIAS_NOV_4, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_4()!=null)
			qUpdate.setInt(CM_ULT_MES_NOV_4, pers.getCm_ult_mes_nov_4().intValue());
		else
			qUpdate.setNull(CM_ULT_MES_NOV_4, Types.INTEGER);
		if (pers.getCm_motivos_4()!=null)
			qUpdate.setString(CM_MOTIVOS_4, pers.getCm_motivos_4());
		else
			qUpdate.setNull(CM_MOTIVOS_4, Types.VARCHAR);
		if (pers.isCm_aplic_nov_5()!=null)
			qUpdate.setBoolean(CM_APLIC_NOV_5, pers.isCm_aplic_nov_5().booleanValue());
		else
			qUpdate.setNull(CM_APLIC_NOV_5, Types.INTEGER);
		if (pers.getCm_dias_nov_5()!=null)
			qUpdate.setInt(CM_DIAS_NOV_5, pers.getCm_dias_nov_5().intValue());
		else
			qUpdate.setNull(CM_DIAS_NOV_5, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_5()!=null)
			qUpdate.setInt(CM_ULT_MES_NOV_5, pers.getCm_ult_mes_nov_5().intValue());
		else
			qUpdate.setNull(CM_ULT_MES_NOV_5, Types.INTEGER);
		if (pers.getCm_motivos_5()!=null)
			qUpdate.setString(CM_MOTIVOS_5, pers.getCm_motivos_5());
		else
			qUpdate.setNull(CM_MOTIVOS_5, Types.VARCHAR);
		if (pers.isRankearPorSancion()!=null)
			qUpdate.setBoolean(RANK_POR_SANCION, pers.isRankearPorSancion());
		else
			qUpdate.setNull(RANK_POR_SANCION, Types.BOOLEAN);
		
		if (pers.isControlarEstadoDesa()!=null)
			qUpdate.setBoolean(CONTROL_ESTA_DESA, pers.isControlarEstadoDesa());
		else
			qUpdate.setNull(CONTROL_ESTA_DESA, Types.BOOLEAN);
		
		if (pers.isCm_aplic_nov_6()!=null)
			qUpdate.setBoolean(CM_APLIC_NOV_6, pers.isCm_aplic_nov_6());
		else
			qUpdate.setNull(CM_APLIC_NOV_6, Types.BOOLEAN);
		if (pers.getCm_dias_nov_6()!=null)
			qUpdate.setInt(CM_DIAS_NOV_6, pers.getCm_dias_nov_6().intValue());
		else
			qUpdate.setNull(CM_DIAS_NOV_6, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_6()!=null)
			qUpdate.setInt(CM_ULT_MES_NOV_6, pers.getCm_ult_mes_nov_6().intValue());
		else
			qUpdate.setNull(CM_ULT_MES_NOV_6, Types.INTEGER);
		if (pers.getCm_motivos_6()!=null)
			qUpdate.setString(CM_MOTIVOS_6, pers.getCm_motivos_6());
		else
			qUpdate.setNull(CM_MOTIVOS_6, Types.VARCHAR);
		
		//
		if (pers.isCm_aplic_nov_7()!=null)
			qUpdate.setBoolean(CM_APLIC_NOV_7, pers.isCm_aplic_nov_7());
		else
			qUpdate.setNull(CM_APLIC_NOV_7, Types.BOOLEAN);
		if (pers.getCm_dias_nov_7()!=null)
			qUpdate.setInt(CM_DIAS_NOV_7, pers.getCm_dias_nov_7().intValue());
		else
			qUpdate.setNull(CM_DIAS_NOV_7, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_7()!=null)
			qUpdate.setInt(CM_ULT_MES_NOV_7, pers.getCm_ult_mes_nov_7().intValue());
		else
			qUpdate.setNull(CM_ULT_MES_NOV_7, Types.INTEGER);
		if (pers.getCm_motivos_7()!=null)
			qUpdate.setString(CM_MOTIVOS_7, pers.getCm_motivos_7());
		else
			qUpdate.setNull(CM_MOTIVOS_7, Types.VARCHAR);
		//
		if (pers.isCm_aplic_nov_8()!=null)
			qUpdate.setBoolean(CM_APLIC_NOV_8, pers.isCm_aplic_nov_8());
		else
			qUpdate.setNull(CM_APLIC_NOV_8, Types.BOOLEAN);
		if (pers.getCm_dias_nov_8()!=null)
			qUpdate.setInt(CM_DIAS_NOV_8, pers.getCm_dias_nov_8().intValue());
		else
			qUpdate.setNull(CM_DIAS_NOV_8, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_8()!=null)
			qUpdate.setInt(CM_ULT_MES_NOV_8, pers.getCm_ult_mes_nov_8().intValue());
		else
			qUpdate.setNull(CM_ULT_MES_NOV_8, Types.INTEGER);
		if (pers.getCm_motivos_8()!=null)
			qUpdate.setString(CM_MOTIVOS_8, pers.getCm_motivos_8());
		else
			qUpdate.setNull(CM_MOTIVOS_8, Types.VARCHAR);
		//
		if (pers.isCm_aplic_nov_9()!=null)
			qUpdate.setBoolean(CM_APLIC_NOV_9, pers.isCm_aplic_nov_9());
		else
			qUpdate.setNull(CM_APLIC_NOV_9, Types.BOOLEAN);
		if (pers.getCm_dias_nov_9()!=null)
			qUpdate.setInt(CM_DIAS_NOV_9, pers.getCm_dias_nov_9().intValue());
		else
			qUpdate.setNull(CM_DIAS_NOV_9, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_9()!=null)
			qUpdate.setInt(CM_ULT_MES_NOV_9, pers.getCm_ult_mes_nov_9().intValue());
		else
			qUpdate.setNull(CM_ULT_MES_NOV_9, Types.INTEGER);
		if (pers.getCm_motivos_9()!=null)
			qUpdate.setString(CM_MOTIVOS_9, pers.getCm_motivos_9());
		else
			qUpdate.setNull(CM_MOTIVOS_9, Types.VARCHAR);
		//
		if (pers.isCm_aplic_nov_10()!=null)
			qUpdate.setBoolean(CM_APLIC_NOV_10, pers.isCm_aplic_nov_10());
		else
			qUpdate.setNull(CM_APLIC_NOV_10, Types.BOOLEAN);
		if (pers.getCm_dias_nov_10()!=null)
			qUpdate.setInt(CM_DIAS_NOV_10, pers.getCm_dias_nov_10().intValue());
		else
			qUpdate.setNull(CM_DIAS_NOV_10, Types.INTEGER);
		if (pers.getCm_ult_mes_nov_10()!=null)
			qUpdate.setInt(CM_ULT_MES_NOV_10, pers.getCm_ult_mes_nov_10().intValue());
		else
			qUpdate.setNull(CM_ULT_MES_NOV_10, Types.INTEGER);
		if (pers.getCm_motivos_10()!=null)
			qUpdate.setString(CM_MOTIVOS_10, pers.getCm_motivos_10());
		else
			qUpdate.setNull(CM_MOTIVOS_10, Types.VARCHAR);
		
		if (pers.isAplicClasifGral()!=null)
			qUpdate.setBoolean(CM_CALIF_GRAL, pers.isAplicClasifGral().booleanValue());
		else
			qUpdate.setNull(CM_CALIF_GRAL, Types.BOOLEAN);
		
		if (pers.getPtosMinCalifGral()!=null)
			qUpdate.setDouble(CM_PTOS_MIN_CALIF, pers.getPtosMinCalifGral().doubleValue());
		else
			qUpdate.setNull(CM_CALIF_GRAL, Types.DOUBLE);
		
		if (pers.isAplicCMJuegosA()!=null)
			qUpdate.setBoolean(CM_APLIC_JUEGOS_A, pers.isAplicCMJuegosA().booleanValue());
		else
			qUpdate.setNull(CM_APLIC_JUEGOS_A, Types.BOOLEAN);

		if (pers.isAplicHoriCarrera()!=null)
			qUpdate.setBoolean(CM_APLIC_HOR_CAR, pers.isAplicHoriCarrera().booleanValue());
		else
			qUpdate.setBoolean(CM_APLIC_HOR_CAR, false);		
		
		qUpdate.setBoolean(DES_SANC_REST_MAS, pers.IsDesapruebaSiSancRestanMas());
		qUpdate.setBoolean(DES_NOV_REST_MAS, pers.IsDesapruebaSiNoveRestanMas());
		if (pers.getPtosMaxDesapruebaSanc()!=null)
			qUpdate.setDouble(PTOS_MAX_REST_SANC , pers.getPtosMaxDesapruebaSanc().doubleValue());
		else
			qUpdate.setNull(PTOS_MAX_REST_SANC , Types.DOUBLE);
		if (pers.getPtosMaxDesapruebaNov()!=null)
			qUpdate.setDouble(PTOS_MAX_REST_NOV, pers.getPtosMaxDesapruebaNov().doubleValue());
		else
			qUpdate.setNull(PTOS_MAX_REST_NOV , Types.DOUBLE);		
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_RANKEAR = 1;
		RankearCab pers = (RankearCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhRankear " + " set activo=0 " + " where " + " oid_rankear=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RANKEAR, pers.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_RANKEAR = 1;
		RankearCab pers = (RankearCab) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update rhRankear " + " set activo=1 " + " where " + " oid_rankear=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_RANKEAR, pers.getOID());
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
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_RANKEAR = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRankear ");
		textSQL.append(" WHERE oid_rankear = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_RANKEAR, oid);
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  rhRankear ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_rankear oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from rhRankear");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

}
