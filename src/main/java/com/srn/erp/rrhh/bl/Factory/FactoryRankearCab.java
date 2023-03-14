package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.RankearCab;
import com.srn.erp.rrhh.da.DBRankearCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRankearCab extends FactoryObjetoLogico {

	public FactoryRankearCab() {
	}

	public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
		RankearCab rankearcab = (RankearCab) objLog;
		rankearcab.setOID(db.getInteger(DBRankearCab.OID_RANKEAR));
		rankearcab.setCodigo(db.getString(DBRankearCab.CODIGO));
		rankearcab.setDescripcion(db.getString(DBRankearCab.DESCRIPCION));
		rankearcab.setActivo(db.getBoolean(DBRankearCab.ACTIVO));
		rankearcab.setRank_por_ant_emp(db.getBoolean(DBRankearCab.RANK_POR_ANT_EMP));
		rankearcab.setPtos_ant_emp(db.getMoney(DBRankearCab.PTOS_ANT_EMP));
		rankearcab.setUnitiempoantemp(db.getString(DBRankearCab.UT_ANT_EMP));
		rankearcab.setPond_ant_emp(db.getMoney(DBRankearCab.POND_ANT_EMP));
		rankearcab.setRank_por_ant_pue(db.getBoolean(DBRankearCab.RANK_POR_ANT_PUE));
		rankearcab.setPtos_ant_pue(db.getMoney(DBRankearCab.PTOS_ANT_PUE));
		rankearcab.setUt_ant_pue(db.getString(DBRankearCab.UT_ANT_PUE));
		rankearcab.setPond_ant_pue(db.getMoney(DBRankearCab.POND_ANT_PUE));
		rankearcab.setRank_por_novedad(db.getBoolean(DBRankearCab.RANK_POR_NOVEDAD));
		rankearcab.setRank_por_eval(db.getBoolean(DBRankearCab.RANK_POR_EVAL));
		rankearcab.setEval_ult_meses(db.getInteger(DBRankearCab.EVAL_ULT_MESES));
		rankearcab.setEval_calif_punto(db.getMoney(DBRankearCab.EVAL_CALIF_PUNTO));
		rankearcab.setEval_ponderacion(db.getMoney(DBRankearCab.EVAL_PONDERACION));
		rankearcab.setCm_ant_req_emp(db.getBoolean(DBRankearCab.CM_ANT_REQ_EMP));
		rankearcab.setCm_cant_req_emp(db.getInteger(DBRankearCab.CM_CANT_REQ_EMP));
		rankearcab.setCm_ut_req_emp(db.getString(DBRankearCab.CM_UT_REQ_EMP));
		rankearcab.setCm_ant_req_pue(db.getBoolean(DBRankearCab.CM_ANT_REQ_PUE));
		rankearcab.setCm_cant_req_pue(db.getInteger(DBRankearCab.CM_CANT_REQ_PUE));
		rankearcab.setCm_ut_req_pue(db.getString(DBRankearCab.CM_UT_REQ_PUE));
		rankearcab.setCm_aplicar_eval(db.getBoolean(DBRankearCab.CM_APLICAR_EVAL));
		rankearcab.setCm_puntaje_eval(db.getMoney(DBRankearCab.CM_PUNTAJE_EVAL));
		rankearcab.setCm_aplic_nov_1(db.getBoolean(DBRankearCab.CM_APLIC_NOV_1));
		rankearcab.setCm_dias_nov_1(db.getInteger(DBRankearCab.CM_DIAS_NOV_1));
		rankearcab.setCm_ult_mes_nov_1(db.getInteger(DBRankearCab.CM_ULT_MES_NOV_1));
		rankearcab.setCm_motivos_1(db.getString(DBRankearCab.CM_MOTIVOS_1));
		rankearcab.setCm_aplic_nov_2(db.getBoolean(DBRankearCab.CM_APLIC_NOV_2));
		rankearcab.setCm_dias_nov_2(db.getInteger(DBRankearCab.CM_DIAS_NOV_2));
		rankearcab.setCm_ult_mes_nov_2(db.getInteger(DBRankearCab.CM_ULT_MES_NOV_2));
		rankearcab.setCm_motivos_2(db.getString(DBRankearCab.CM_MOTIVOS_2));
		rankearcab.setCm_aplic_nov_3(db.getBoolean(DBRankearCab.CM_APLIC_NOV_3));
		rankearcab.setCm_dias_nov_3(db.getInteger(DBRankearCab.CM_DIAS_NOV_3));
		rankearcab.setCm_ult_mes_nov_3(db.getInteger(DBRankearCab.CM_ULT_MES_NOV_3));
		rankearcab.setCm_motivos_3(db.getString(DBRankearCab.CM_MOTIVOS_3));
		rankearcab.setCm_aplic_nov_4(db.getBoolean(DBRankearCab.CM_APLIC_NOV_4));
		rankearcab.setCm_dias_nov_4(db.getInteger(DBRankearCab.CM_DIAS_NOV_4));
		rankearcab.setCm_ult_mes_nov_4(db.getInteger(DBRankearCab.CM_ULT_MES_NOV_4));
		rankearcab.setCm_motivos_4(db.getString(DBRankearCab.CM_MOTIVOS_4));
		rankearcab.setCm_aplic_nov_5(db.getBoolean(DBRankearCab.CM_APLIC_NOV_5));
		rankearcab.setCm_dias_nov_5(db.getInteger(DBRankearCab.CM_DIAS_NOV_5));
		rankearcab.setCm_ult_mes_nov_5(db.getInteger(DBRankearCab.CM_ULT_MES_NOV_5));
		rankearcab.setCm_motivos_5(db.getString(DBRankearCab.CM_MOTIVOS_5));
		rankearcab.setRankearPorSancion(db.getBoolean(DBRankearCab.RANK_POR_SANCION));
		rankearcab.setControlarEstadoDesa(db.getBoolean(DBRankearCab.CONTROL_ESTA_DESA));
		
		rankearcab.setCm_aplic_nov_6(db.getBoolean(DBRankearCab.CM_APLIC_NOV_6));
		rankearcab.setCm_dias_nov_6(db.getInteger(DBRankearCab.CM_DIAS_NOV_6));
		rankearcab.setCm_ult_mes_nov_6(db.getInteger(DBRankearCab.CM_ULT_MES_NOV_6));
		rankearcab.setCm_motivos_6(db.getString(DBRankearCab.CM_MOTIVOS_6));
		
		rankearcab.setCm_aplic_nov_7(db.getBoolean(DBRankearCab.CM_APLIC_NOV_7));
		rankearcab.setCm_dias_nov_7(db.getInteger(DBRankearCab.CM_DIAS_NOV_7));
		rankearcab.setCm_ult_mes_nov_7(db.getInteger(DBRankearCab.CM_ULT_MES_NOV_7));
		rankearcab.setCm_motivos_7(db.getString(DBRankearCab.CM_MOTIVOS_7));

		rankearcab.setCm_aplic_nov_8(db.getBoolean(DBRankearCab.CM_APLIC_NOV_8));
		rankearcab.setCm_dias_nov_8(db.getInteger(DBRankearCab.CM_DIAS_NOV_8));
		rankearcab.setCm_ult_mes_nov_8(db.getInteger(DBRankearCab.CM_ULT_MES_NOV_8));
		rankearcab.setCm_motivos_8(db.getString(DBRankearCab.CM_MOTIVOS_8));
		
		rankearcab.setCm_aplic_nov_9(db.getBoolean(DBRankearCab.CM_APLIC_NOV_9));
		rankearcab.setCm_dias_nov_9(db.getInteger(DBRankearCab.CM_DIAS_NOV_9));
		rankearcab.setCm_ult_mes_nov_9(db.getInteger(DBRankearCab.CM_ULT_MES_NOV_9));
		rankearcab.setCm_motivos_9(db.getString(DBRankearCab.CM_MOTIVOS_9));
		
		rankearcab.setCm_aplic_nov_10(db.getBoolean(DBRankearCab.CM_APLIC_NOV_10));
		rankearcab.setCm_dias_nov_10(db.getInteger(DBRankearCab.CM_DIAS_NOV_10));
		rankearcab.setCm_ult_mes_nov_10(db.getInteger(DBRankearCab.CM_ULT_MES_NOV_10));
		rankearcab.setCm_motivos_10(db.getString(DBRankearCab.CM_MOTIVOS_10));
		
		rankearcab.setAplicCaligGral(db.getBoolean(DBRankearCab.CM_CALIF_GRAL));
		rankearcab.setPtosMinCalifGral(db.getMoney(DBRankearCab.CM_PTOS_MIN_CALIF));
		rankearcab.setAplicCMJuegosA(db.getBoolean(DBRankearCab.CM_APLIC_JUEGOS_A));
		rankearcab.setAplicHoriCarrera(db.getBoolean(DBRankearCab.CM_APLIC_HOR_CAR));
		
		rankearcab.setDesapruebaSiNoveRestanMas(db.getBoolean(DBRankearCab.DES_NOV_REST_MAS));
		rankearcab.setDesapruebaSiSancRestanMas(db.getBoolean(DBRankearCab.DES_SANC_REST_MAS));
		rankearcab.setPtosMaxDesapruebaNov(db.getMoney(DBRankearCab.PTOS_MAX_REST_NOV));
		rankearcab.setPtosMaxDesapruebaSanc(db.getMoney(DBRankearCab.PTOS_MAX_REST_SANC));
		
		
	}
}
