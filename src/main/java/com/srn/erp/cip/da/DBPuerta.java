package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.Puerta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPuerta extends DBObjetoPersistente {

	public static final String OID_PUERTA = "oid_puerta";
	public static final String CODIGO = "codigo";
	public static final String DESCRIPCION = "descripcion";
	public static final String ACCESO_AL_PREDIO = "acceso_al_predio";
	public static final String EGRESO_DEL_PREDIO = "egreso_del_predio";
	public static final String ACTIVO = "activo";
	public static final String IP = "IP";
	public static final String IDENTIF_PUERTA = "identif_puerta";
	public static final String TIPO_MEDIO_ENT = "tipo_medio_ent";
	public static final String IDENTIF_ENT = "identif_ent";
	public static final String IDENTIF_LEG_ENT = "identif_leg_ent";
	public static final String PROTOLOCO_ENT = "protocolo_ent";
	public static final String MODO_FUNC_ENT = "modo_func_ent";
	public static final String TIPO_MEDIO_SAL = "tipo_medio_sal";
	public static final String IDENTIF_SAL = "identif_sal";
	public static final String IDENTIF_LEG_SAL = "identif_leg_sal";
	public static final String PROTOCOLO_SAL = "protocolo_sal";
	public static final String MODO_FUNC_SAL = "modo_func_sal";

	public static final String MODO_OFF_LINE_ENT = "modo_off_line_ent";
	public static final String MODO_OFF_LINE_SAL = "modo_off_line_sal";
	public static final String INT_STATUS_TIME = "int_status_time";
	public static final String INT_CONFIG_TIME = "int_config_time";
	public static final String INT_SYNCROTIME = "int_syncrotime";
	public static final String HAB_PUNTO_ACC_1 = "hab_punto_acc_1";
	public static final String HAB_PUNTO_ACC_2 = "hab_punto_acc_2";
	public static final String CTIMEOUT_ENT = "ctimeout_ent";
	public static final String CTIMEOUT_SAL = "ctimeout_sal";
	public static final String OTIMEOUT_ENT = "otimeout_ent";
	public static final String OTIMEOUT_SAL = "otimeout_sal";
	public static final String ALARMTIME_ENT = "alarmtime_ent";
	public static final String ALARMTIME_SAL = "alarmtime_sal";
	public static final String DIR_PTO_ENT = "dir_pto_ent";
	public static final String DIR_PTO_SAL = "dir_pto_sal";
	public static final String TIPO_PUNTO_ENT = "tipo_punto_ent";
	public static final String TIPO_PUNTO_SAL = "tipo_punto_sal";
	public static final String BENABLE_ENT = "benable_ent";
	public static final String BENABLE_SAL = "benable_sal";
	public static final String PENABLE_ENT = "penable_ent";
	public static final String PENABLE_SAL = "penable_sal";
	public static final String MODE = "modo";
	public static final String PUERTO = "puerto";
	public static final String PUERTO_TELE = "puerto_tele";
	public static final String FEC_ULT_ACT_LB = "fec_ult_act_lb";
	public static final String HORA_ULT_ACT_LB = "hora_ult_act_lb";
	public static final String FEC_CARGA_PLACA_LB = "fec_carga_placa_lb";
	public static final String HOR_CARGA_PLACA_LB = "hor_carga_placa_lb";
	public static final String CANT_REG_LB = "cant_reg_lb";
	public static final String TIPO_ALIM_LB_ENT = "tipo_alim_lb_ent";
	public static final String TIPO_ALIM_LB_SAL = "tipo_alim_lb_sal";
	public static final String PEDIR_CONFIG = "pedir_config";
	
	public static final String FEC_INICIO_OL = "fec_inicio_ol";
	public static final String HOR_INICIO_OL = "hora_inicio_ol";
	public static final String FEC_ULT_STATUS = "fec_ult_status";
	public static final String HOR_ULT_STATUS = "hora_ult_status";
	
	public static final String LIBERAR_ENTRADA = "liberar_entrada";
	public static final String LIBERAR_SALIDA = "liberar_salida";
	
	public static final String INTER_NRO_ENT = "inter_nro_ent";
	public static final String INTER_NRO_SAL = "inter_nro_sal";
	
	public static final String INI_TELE = "iniciar_tele";
	
	public static final String INGRESO_CACHEO = "ingreso_cacheo";
	public static final String EGRESO_CACHEO = "egreso_cacheo";
	
	public static final String ENTRADA_SALE_DE = "entrada_sale_de";
	public static final String ENTRADA_ENTRA_A = "entrada_entra_a";
	public static final String SALIDA_SALE_DE = "salida_sale_de";
	public static final String SALIDA_ENTRA_A = "salida_entra_a";
	
	public static final String REG_MOV_ULT_ACCLEG = "reg_mov_ult_accleg";
	public static final String ANTIPASSBACK_ENT = "antipassback_ent";
	public static final String ANTIPASSBACK_SAL = "antipassback_sal";
	public static final String CACHEO_ENT = "cacheo_ent";
	public static final String CACHEO_SAL = "cacheo_sal";
	
	public static final String REG_MOV_ULT_ENT = "reg_mov_ult_ent";
	public static final String REG_MOV_ULT_SAL = "reg_mov_ult_sal";
	public static final String ACT_AVI_ACC_DEN = "act_avi_acc_den";
	
	public static final String RESTRINGIR_ENT = "restringir_ent";
	public static final String RESTRINGIR_SAL = "restringir_sal";
	public static final String RESTRI_ENT_VIS = "restri_ent_vis";
	
	public static final String LIB_ENT_VIS = "lib_ent_vis";
	public static final String LIB_SAL_VIS = "lib_sal_vis";
	
	public static final String DESCONECTADA = "desconectada";

	
	
	public static final String TRAGA_TARJ_SAL = "traga_tarj_sal";
	
	
	public static final int SELECT_BY_IDENTIF_PUERTA = 100;

	public DBPuerta() {
	}

	protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int OID_PUERTA = 1;
		final int CODIGO = 2;
		final int DESCRIPCION = 3;
		final int ACTIVO = 4;
		final int ACCESO_AL_PREDIO = 5;
		final int EGRESO_DEL_PREDIO = 6;
		final int IDENTIF_PUERTA = 7;
		final int TIPO_MEDIO_ENT = 8;
		final int IDENTIF_ENT = 9;
		final int IDENTIF_LEG_ENT = 10;
		final int PROTOCOLO_ENT = 11;
		final int MODO_FUNC_ENT = 12;
		final int TIPO_MEDIO_SAL = 13;
		final int IDENTIF_SAL = 14;
		final int IDENTIF_LEG_SAL = 15;
		final int PROTOCOLO_SAL = 16;
		final int MODO_FUNC_SAL = 17;
		final int IP = 18;
		final int MODO_OFF_LINE_ENT = 19;
		final int MODO_OFF_LINE_SAL = 20;
		final int INT_STATUS_TIME = 21;
		final int INT_CONFIG_TIME = 22;
		final int INT_SYNCROTIME = 23;
		final int HAB_PUNTO_ACC_1 = 24;
		final int HAB_PUNTO_ACC_2 = 25;
		final int CTIMEOUT_ENT = 26;
		final int CTIMEOUT_SAL = 27;
		final int OTIMEOUT_ENT = 28;
		final int OTIMEOUT_SAL = 29;
		final int ALARMTIME_ENT = 30;
		final int ALARMTIME_SAL = 31;
		final int DIR_PTO_ENT = 32;
		final int DIR_PTO_SAL = 33;
		final int TIPO_PUNTO_ENT = 34;
		final int TIPO_PUNTO_SAL = 35;
		final int BENABLE_ENT = 36;
		final int BENABLE_SAL = 37;
		final int PENABLE_ENT = 38;
		final int PENABLE_SAL = 39;
		final int MODE = 40;
		final int PUERTO = 41;
		final int PUERTO_TELE = 42;
		final int FEC_ULT_ACT_LB = 43;
		final int HORA_ULT_ACT_LB = 44;
		final int FEC_CARGA_PLACA_LB = 45;
		final int HOR_CARGA_PLACA_LB = 46;
		final int CANT_REG_LB = 47;
		final int TIPO_ALIM_LB_ENT = 48;
		final int TIPO_ALIM_LB_SAL = 49;
		final int PEDIR_CONFIG = 50;
		final int FEC_INICIO_OL = 51;
		final int HOR_INICIO_OL = 52;
		final int FEC_ULT_STATUS = 53;
		final int HOR_ULT_STATUS = 54;
		final int LIBERAR_ENTRADA = 55;
		final int LIBERAR_SALIDA = 56;
		final int INTER_NRO_ENT = 57;
		final int INTER_NRO_SAL = 58;
		final int INI_TEL = 59;
		final int INGRESO_CACHEO = 60;
		final int EGRESO_CACHEO = 61;
		final int ENTRADA_SALE_DE = 62;
		final int ENTRADA_ENTRA_A = 63;
		final int SALIDA_SALE_DE = 64;
		final int SALIDA_ENTRA_A = 65;
		final int ANTIPASSBACK_ENT = 66;
		final int ANTIPASSBACK_SAL = 67;
		final int CACHEO_ENT = 68;
		final int CACHEO_SAL = 69;
		final int REG_MOV_ULT_ENT = 70;
		final int REG_MOV_ULT_SAL = 71;
		final int ACT_AVI_ACC_DEN = 72;
		final int RESTRINGIR_ENT = 73;
		final int RESTRINGIR_SAL = 74;
		final int RESTRI_ENT_VIS = 75;
		final int LIB_ENT_VIS = 76;
		final int LIB_SAL_VIS = 77;
		final int TRAGA_TARJ_SAL = 78;
		final int DESCONECTADA = 79;
		
		Puerta pers = (Puerta) objetoPersistente;

		StringBuffer sqlInsert = new StringBuffer();
		sqlInsert.append(" insert into cipPuerta " + " ( " + "OID_PUERTA," + "CODIGO," + "DESCRIPCION,"
				+ "ACTIVO,ACCESO_AL_PREDIO,EGRESO_DEL_PREDIO" + ",IDENTIF_PUERTA,TIPO_MEDIO_ENT,IDENTIF_ENT,"
				+ "IDENTIF_LEG_ENT,PROTOCOLO_ENT,MODO_FUNC_ENT," + "TIPO_MEDIO_SAL,IDENTIF_SAL,IDENTIF_LEG_SAL,"
				+ "PROTOCOLO_SAL,MODO_FUNC_SAL,IP," + "modo_off_line_ent," + "modo_off_line_sal," + "int_status_time," + "int_config_time,"
				+ "int_syncrotime," + "hab_punto_acc_1," + "hab_punto_acc_2," + "ctimeout_ent," + "ctimeout_sal," + "otimeout_ent,"
				+ "otimeout_sal," + "alarmtime_ent," + "alarmtime_sal," + "dir_pto_ent," + "dir_pto_sal," + "tipo_punto_ent,"
				+ "tipo_punto_sal," + "benable_ent," + "benable_sal," + "penable_ent," + "penable_sal," + "modo," + "puerto,"
				+ "puerto_tele,fec_ult_act_lb,hora_ult_act_lb,fec_carga_placa_lb,hor_carga_placa_lb,cant_reg_lb,tipo_alim_lb_ent,tipo_alim_lb_sal, pedir_config"+
				",fec_inicio_ol,hora_inicio_ol,fec_ult_status,hora_ult_status,liberar_entrada,liberar_salida,inter_nro_ent,inter_nro_sal,iniciar_tele,ingreso_cacheo,egreso_cacheo,"+
				"entrada_sale_de,entrada_entra_a,salida_sale_de,salida_entra_a,antipassback_ent,antipassback_sal,cacheo_ent,cacheo_sal,reg_mov_ult_ent,reg_mov_ult_sal,act_avi_acc_den,restringir_ent,restringir_sal,restri_ent_vis,lib_ent_vis,lib_sal_vis,traga_tarj_sal, desconectada) " + " values " + "(" + "?," + "?,"+ "?,"+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?," + "?,"+ "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?,"  + "?," + "?," +"?," + "?," + "?," + "?," + "?," + "?,"+ "?,"+ "?," + "?,"+ "?,"+ "?,"
				+ "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," + "?," +"?," +"?," +"?," +"?," + "?," + "?," + "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?,"+ "?," +"?,"+"?,"+"?,"+"?,"+"?,"+"?,"+"?,"+"?,"+"?,"+"?,"+"?,"+"?," +"?,"+"?) ");

		PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
		qInsert.setInt(OID_PUERTA, pers.getOID());
		qInsert.setString(CODIGO, pers.getCodigo());
		qInsert.setString(DESCRIPCION, pers.getDescripcion());
		qInsert.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.isIngresoAlPredio() != null)
			qInsert.setBoolean(ACCESO_AL_PREDIO, pers.isIngresoAlPredio().booleanValue());
		else
			qInsert.setBoolean(ACCESO_AL_PREDIO, false);
		if (pers.isEgresoDelPredio() != null)
			qInsert.setBoolean(EGRESO_DEL_PREDIO, pers.isEgresoDelPredio().booleanValue());
		else
			qInsert.setBoolean(EGRESO_DEL_PREDIO, false);

		if (pers.getIdentifPuerta() != null)
			qInsert.setString(IDENTIF_PUERTA, pers.getIdentifPuerta());
		else
			qInsert.setString(IDENTIF_PUERTA, "");
		if (pers.getTipoMedioEntrada() != null)
			qInsert.setString(TIPO_MEDIO_ENT, pers.getTipoMedioEntrada());
		else
			qInsert.setString(TIPO_MEDIO_ENT, "");
		if (pers.getIdentifEntrada() != null)
			qInsert.setString(IDENTIF_ENT, pers.getIdentifEntrada());
		else
			qInsert.setString(IDENTIF_ENT, "");
		if (pers.getIdentifLegEntrada() != null)
			qInsert.setString(IDENTIF_LEG_ENT, pers.getIdentifLegEntrada());
		else
			qInsert.setString(IDENTIF_LEG_ENT, "");
		if (pers.getProtocoloEntrada() != null)
			qInsert.setString(PROTOCOLO_ENT, pers.getProtocoloEntrada());
		else
			qInsert.setString(PROTOCOLO_ENT, "");
		if (pers.getModoFuncEnt() != null)
			qInsert.setString(MODO_FUNC_ENT, pers.getModoFuncEnt());
		else
			qInsert.setString(MODO_FUNC_ENT, "");
		if (pers.getTipoMedioSal() != null)
			qInsert.setString(TIPO_MEDIO_SAL, pers.getTipoMedioSal());
		else
			qInsert.setString(TIPO_MEDIO_SAL, "");
		if (pers.getIdentifSal() != null)
			qInsert.setString(IDENTIF_SAL, pers.getIdentifSal());
		else
			qInsert.setString(IDENTIF_SAL, "");
		if (pers.getIdentifLegSal() != null)
			qInsert.setString(IDENTIF_LEG_SAL, pers.getIdentifLegSal());
		else
			qInsert.setString(IDENTIF_LEG_SAL, "");
		if (pers.getProtocoloSalida() != null)
			qInsert.setString(PROTOCOLO_SAL, pers.getProtocoloSalida());
		else
			qInsert.setString(PROTOCOLO_SAL, "");
		if (pers.getModoFuncSal() != null)
			qInsert.setString(MODO_FUNC_SAL, pers.getModoFuncSal());
		else
			qInsert.setString(MODO_FUNC_SAL, "");
		if (pers.getIP() != null)
			qInsert.setString(IP, pers.getIP());
		else
			qInsert.setString(IP, "");

		if (pers.getModoOFFLineEnt() != null)
			qInsert.setInt(MODO_OFF_LINE_ENT, pers.getModoOFFLineEnt().intValue());
		else
			qInsert.setNull(MODO_OFF_LINE_ENT, java.sql.Types.INTEGER);
		if (pers.getModoOFFLineSal() != null)
			qInsert.setInt(MODO_OFF_LINE_SAL, pers.getModoOFFLineSal().intValue());
		else
			qInsert.setNull(MODO_OFF_LINE_SAL, java.sql.Types.INTEGER);
		if (pers.getIntervaloStatusTime() != null)
			qInsert.setInt(INT_STATUS_TIME, pers.getIntervaloStatusTime().intValue());
		else
			qInsert.setNull(INT_STATUS_TIME, java.sql.Types.INTEGER);
		if (pers.getIntervaloConfigTime() != null)
			qInsert.setInt(INT_CONFIG_TIME, pers.getIntervaloConfigTime().intValue());
		else
			qInsert.setNull(INT_CONFIG_TIME, java.sql.Types.INTEGER);
		if (pers.getIntervaloSyncroTime() != null)
			qInsert.setInt(INT_SYNCROTIME, pers.getIntervaloSyncroTime().intValue());
		else
			qInsert.setNull(INT_SYNCROTIME, java.sql.Types.INTEGER);
		if (pers.getHabilitarPuntoAcceso1() != null)
			qInsert.setInt(HAB_PUNTO_ACC_1, pers.getHabilitarPuntoAcceso1().intValue());
		else
			qInsert.setNull(HAB_PUNTO_ACC_1, java.sql.Types.INTEGER);
		if (pers.getHabilitarPuntoAcceso2() != null)
			qInsert.setInt(HAB_PUNTO_ACC_2, pers.getHabilitarPuntoAcceso2().intValue());
		else
			qInsert.setNull(HAB_PUNTO_ACC_2, java.sql.Types.INTEGER);
		if (pers.getCTimeOutEnt() != null)
			qInsert.setInt(CTIMEOUT_ENT, pers.getCTimeOutEnt().intValue());
		else
			qInsert.setNull(CTIMEOUT_ENT, java.sql.Types.INTEGER);
		if (pers.getCTimeOutSal() != null)
			qInsert.setInt(CTIMEOUT_SAL, pers.getCTimeOutSal().intValue());
		else
			qInsert.setNull(CTIMEOUT_SAL, java.sql.Types.INTEGER);
		if (pers.getOTimeOutEnt() != null)
			qInsert.setInt(OTIMEOUT_ENT, pers.getOTimeOutEnt().intValue());
		else
			qInsert.setNull(OTIMEOUT_ENT, java.sql.Types.INTEGER);
		if (pers.getOTimeOutSal() != null)
			qInsert.setInt(OTIMEOUT_SAL, pers.getOTimeOutSal().intValue());
		else
			qInsert.setNull(OTIMEOUT_SAL, java.sql.Types.INTEGER);
		if (pers.getAlarmTimeEnt() != null)
			qInsert.setInt(ALARMTIME_ENT, pers.getAlarmTimeEnt().intValue());
		else
			qInsert.setNull(ALARMTIME_ENT, java.sql.Types.INTEGER);
		if (pers.getAlarmTimeSal() != null)
			qInsert.setInt(ALARMTIME_SAL, pers.getAlarmTimeSal().intValue());
		else
			qInsert.setNull(ALARMTIME_SAL, java.sql.Types.INTEGER);
		if (pers.getDirPtoEnt() != null)
			qInsert.setInt(DIR_PTO_ENT, pers.getDirPtoEnt().intValue());
		else
			qInsert.setNull(DIR_PTO_ENT, java.sql.Types.INTEGER);
		if (pers.getDirPtoSal() != null)
			qInsert.setInt(DIR_PTO_SAL, pers.getDirPtoSal().intValue());
		else
			qInsert.setNull(DIR_PTO_SAL, java.sql.Types.INTEGER);
		if (pers.getTipoPtoEnt() != null)
			qInsert.setInt(TIPO_PUNTO_ENT, pers.getTipoPtoEnt().intValue());
		else
			qInsert.setNull(TIPO_PUNTO_ENT, java.sql.Types.INTEGER);
		if (pers.getTipoPtoSal() != null)
			qInsert.setInt(TIPO_PUNTO_SAL, pers.getTipoPtoSal().intValue());
		else
			qInsert.setNull(TIPO_PUNTO_SAL, java.sql.Types.INTEGER);
		if (pers.getBenableEnt() != null)
			qInsert.setInt(BENABLE_ENT, pers.getBenableEnt().intValue());
		else
			qInsert.setNull(BENABLE_ENT, java.sql.Types.INTEGER);
		if (pers.getBenableSal() != null)
			qInsert.setInt(BENABLE_SAL, pers.getBenableSal().intValue());
		else
			qInsert.setNull(BENABLE_SAL, java.sql.Types.INTEGER);
		if (pers.getPenableEnt() != null)
			qInsert.setInt(PENABLE_ENT, pers.getPenableEnt().intValue());
		else
			qInsert.setNull(PENABLE_ENT, java.sql.Types.INTEGER);
		if (pers.getPenableSal() != null)
			qInsert.setInt(PENABLE_SAL, pers.getPenableSal().intValue());
		else
			qInsert.setNull(PENABLE_SAL, java.sql.Types.INTEGER);
		if (pers.getMode() != null)
			qInsert.setInt(MODE, pers.getMode().intValue());
		else
			qInsert.setNull(MODE, java.sql.Types.INTEGER);
		if (pers.getPuerto() != null)
			qInsert.setInt(PUERTO, pers.getPuerto().intValue());
		else
			qInsert.setNull(PUERTO, java.sql.Types.INTEGER);
		if (pers.getTelePuerto() != null)
			qInsert.setInt(PUERTO_TELE, pers.getTelePuerto().intValue());
		else
			qInsert.setNull(PUERTO_TELE, java.sql.Types.INTEGER);
		
		if (pers.getFecUltActLB()!=null)
			qInsert.setDate(FEC_ULT_ACT_LB, new java.sql.Date(pers.getFecUltActLB().getTime()));
		else
			qInsert.setNull(FEC_ULT_ACT_LB, java.sql.Types.DATE);

		if (pers.getHoraUltActLB()!=null)
			qInsert.setString(HORA_ULT_ACT_LB, pers.getHoraUltActLB());
		else
			qInsert.setNull(HORA_ULT_ACT_LB, java.sql.Types.VARCHAR);
		
		if (pers.getFecUltCargaLB()!=null)
			qInsert.setDate(FEC_CARGA_PLACA_LB, new java.sql.Date(pers.getFecUltCargaLB().getTime()));
		else
			qInsert.setNull(FEC_CARGA_PLACA_LB, java.sql.Types.DATE);
		
		if (pers.getHorUltCargaLB()!=null)
			qInsert.setString(HOR_CARGA_PLACA_LB, pers.getHorUltCargaLB());
		else
			qInsert.setNull(HOR_CARGA_PLACA_LB, java.sql.Types.VARCHAR);
		
		if (pers.getCantRegLB()!=null)
			qInsert.setInt(CANT_REG_LB, pers.getCantRegLB().intValue());
		else
			qInsert.setNull(CANT_REG_LB, java.sql.Types.INTEGER);
		
		if (pers.getTipoAlimLBEnt()!=null)
			qInsert.setString(TIPO_ALIM_LB_ENT, pers.getTipoAlimLBEnt());
		else
			qInsert.setNull(TIPO_ALIM_LB_ENT, java.sql.Types.VARCHAR);		
		
		if (pers.getTipoAlimLBSal()!=null)
			qInsert.setString(TIPO_ALIM_LB_SAL, pers.getTipoAlimLBSal());
		else
			qInsert.setNull(TIPO_ALIM_LB_SAL, java.sql.Types.VARCHAR);
		
		if (pers.isPideConfiguracion()!=null)
			qInsert.setBoolean(PEDIR_CONFIG, pers.isPideConfiguracion().booleanValue());
		else
			qInsert.setNull(PEDIR_CONFIG, java.sql.Types.BOOLEAN);
		
		if (pers.getFecInicioOL()!=null)
			qInsert.setDate(FEC_INICIO_OL, new java.sql.Date(pers.getFecInicioOL().getTime()));
		else
			qInsert.setNull(FEC_INICIO_OL, java.sql.Types.DATE);
		
		if (pers.getHoraInicioOL()!=null)
			qInsert.setString(HOR_INICIO_OL, pers.getHoraInicioOL());
		else
			qInsert.setNull(HOR_INICIO_OL, java.sql.Types.VARCHAR);
		
		if (pers.getFecUltStatus()!=null)
			qInsert.setDate(FEC_ULT_STATUS, new java.sql.Date(pers.getFecUltStatus().getTime()));
		else
			qInsert.setNull(FEC_ULT_STATUS, java.sql.Types.DATE);
		
		if (pers.getHoraUltStatus()!=null)
			qInsert.setString(HOR_ULT_STATUS, pers.getHoraUltStatus());
		else
			qInsert.setNull(HOR_ULT_STATUS, java.sql.Types.VARCHAR);
		
		if (pers.isLiberarEntrada()!=null)
			qInsert.setBoolean(LIBERAR_ENTRADA, pers.isLiberarEntrada().booleanValue());
		else
			qInsert.setNull(LIBERAR_ENTRADA, java.sql.Types.BOOLEAN);
		if (pers.isLiberarSalida()!=null)
			qInsert.setBoolean(LIBERAR_SALIDA, pers.isLiberarSalida().booleanValue());
		else
			qInsert.setNull(LIBERAR_SALIDA, java.sql.Types.BOOLEAN);
		if (pers.getInterpretarNroEnt()!=null)
			qInsert.setString(INTER_NRO_ENT, pers.getInterpretarNroEnt());
		else
			qInsert.setNull(INTER_NRO_ENT, java.sql.Types.VARCHAR);
		if (pers.getInterpretarNroSal()!=null)
			qInsert.setString(INTER_NRO_SAL, pers.getInterpretarNroSal());
		else
			qInsert.setNull(INTER_NRO_SAL, java.sql.Types.VARCHAR);
		
		if (pers.isIniciarTelecomando()!=null)
			qInsert.setBoolean(INI_TEL, pers.isIniciarTelecomando());
		else
			qInsert.setNull(INI_TEL, java.sql.Types.BOOLEAN);		
		
		if (pers.getIngresoCacheo()!=null)
			qInsert.setString(INGRESO_CACHEO, pers.getIngresoCacheo());
		else
			qInsert.setNull(INGRESO_CACHEO, java.sql.Types.VARCHAR);		
		
		if (pers.getEgresoCacheo()!=null)
			qInsert.setString(EGRESO_CACHEO, pers.getEgresoCacheo());
		else
			qInsert.setNull(EGRESO_CACHEO, java.sql.Types.VARCHAR);
		
		if (pers.getEntradaSaleDe()!=null)
			qInsert.setInt(ENTRADA_SALE_DE, pers.getEntradaSaleDe().getOID());
		else
			qInsert.setNull(ENTRADA_SALE_DE, java.sql.Types.INTEGER);		
		
		if (pers.getEntradaEntraA()!=null)
			qInsert.setInt(ENTRADA_ENTRA_A, pers.getEntradaEntraA().getOID());
		else
			qInsert.setNull(ENTRADA_ENTRA_A, java.sql.Types.INTEGER);		
		
		if (pers.getSalidaSaleDe()!=null)
			qInsert.setInt(SALIDA_SALE_DE, pers.getSalidaSaleDe().getOID());
		else
			qInsert.setNull(SALIDA_SALE_DE, java.sql.Types.INTEGER);		
		
		if (pers.getSalidaEntraA()!=null)
			qInsert.setInt(SALIDA_ENTRA_A, pers.getSalidaEntraA().getOID());
		else
			qInsert.setNull(SALIDA_ENTRA_A, java.sql.Types.INTEGER);		
		
		qInsert.setBoolean(ANTIPASSBACK_ENT, pers.isControlAntiPassBackEnt());
		qInsert.setBoolean(ANTIPASSBACK_SAL, pers.isControlAntiPassBackSal());

		qInsert.setBoolean(CACHEO_ENT, pers.isControlCacheoEnt());
		qInsert.setBoolean(CACHEO_SAL, pers.isControlCacheoSal());
		
		qInsert.setBoolean(REG_MOV_ULT_ENT , pers.isRegMovUltEnt());
		qInsert.setBoolean(REG_MOV_ULT_SAL , pers.isRegMovUltSal());
		qInsert.setBoolean(ACT_AVI_ACC_DEN , pers.isActAviAccDenegado());
		qInsert.setBoolean(RESTRINGIR_ENT , pers.isRentringirEnt());
		qInsert.setBoolean(RESTRINGIR_SAL, pers.isRentringirSal());
		
		qInsert.setBoolean(RESTRI_ENT_VIS, pers.isRestringirEntVisita());
		qInsert.setBoolean(LIB_ENT_VIS , pers.isLibEntradaVisita());
		qInsert.setBoolean(LIB_SAL_VIS , pers.isLibSalidaVisita());
		qInsert.setBoolean(TRAGA_TARJ_SAL , pers.isTragaTarjAlSalir()); 
		
		qInsert.setBoolean(DESCONECTADA, pers.isDesconectada());
		
		qInsert.executeUpdate();
		qInsert.close();
	}

	protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

		final int CODIGO = 1;
		final int DESCRIPCION = 2;
		final int ACTIVO = 3;
		final int ACCESO_AL_PREDIO = 4;
		final int EGRESO_DEL_PREDIO = 5;
		final int IDENTIF_PUERTA = 6;
		final int TIPO_MEDIO_ENT = 7;
		final int IDENTIF_ENT = 8;
		final int IDENTIF_LEG_ENT = 9;
		final int PROTOCOLO_ENT = 10;
		final int MODO_FUNC_ENT = 11;
		final int TIPO_MEDIO_SAL = 12;
		final int IDENTIF_SAL = 13;
		final int IDENTIF_LEG_SAL = 14;
		final int PROTOCOLO_SAL = 15;
		final int MODO_FUNC_SAL = 16;
		final int IP = 17;

		final int MODO_OFF_LINE_ENT = 18;
		final int MODO_OFF_LINE_SAL = 19;
		final int INT_STATUS_TIME = 20;
		final int INT_CONFIG_TIME = 21;
		final int INT_SYNCROTIME = 22;
		final int HAB_PUNTO_ACC_1 = 23;
		final int HAB_PUNTO_ACC_2 = 24;
		final int CTIMEOUT_ENT = 25;
		final int CTIMEOUT_SAL = 26;
		final int OTIMEOUT_ENT = 27;
		final int OTIMEOUT_SAL = 28;
		final int ALARMTIME_ENT = 29;
		final int ALARMTIME_SAL = 30;
		final int DIR_PTO_ENT = 31;
		final int DIR_PTO_SAL = 32;
		final int TIPO_PUNTO_ENT = 33;
		final int TIPO_PUNTO_SAL = 34;
		final int BENABLE_ENT = 35;
		final int BENABLE_SAL = 36;
		final int PENABLE_ENT = 37;
		final int PENABLE_SAL = 38;
		final int MODE = 39;
		final int PUERTO = 40;
		final int PUERTO_TELE = 41;
		final int FEC_ULT_ACT_LB = 42;
		final int HORA_ULT_ACT_LB = 43;
		final int FEC_CARGA_PLACA_LB = 44;
		final int HOR_CARGA_PLACA_LB = 45;
		final int CANT_REG_LB = 46;
		final int TIPO_ALIM_LB_ENT = 47;
		final int TIPO_ALIM_LB_SAL = 48;
		final int PEDIR_CONFIG = 49;
		final int FEC_INICIO_OL = 50;
		final int HOR_INICIO_OL = 51;
		final int FEC_ULT_STATUS = 52;
		final int HOR_ULT_STATUS = 53;
		final int LIBERAR_ENTRADA = 54;
		final int LIBERAR_SALIDA = 55;
		final int INTER_NRO_ENT = 56;
		final int INTER_NRO_SAL = 57;
		final int INI_TEL = 58;
		final int INGRESO_CACHEO = 59;
		final int EGRESO_CACHEO = 60;
		final int ENTRADA_SALE_DE = 61;
		final int ENTRADA_ENTRA_A = 62;
		final int SALIDA_SALE_DE = 63;
		final int SALIDA_ENTRA_A = 64;
		final int ANTIPASSBACK_ENT = 65;
		final int ANTIPASSBACK_SAL = 66;
		final int CACHEO_ENT = 67;
		final int CACHEO_SAL = 68;
		final int REG_MOV_ULT_ENT = 69;
		final int REG_MOV_ULT_SAL = 70;
		final int ACT_AVI_ACC_DEN = 71;
		final int RESTRINGIR_ENT = 72;
		final int RESTRINGIR_SAL = 73;
		final int RESTRI_ENT_VIS = 74;
		final int LIB_ENT_VIS = 75;
		final int LIB_SAL_VIS = 76;
		final int TRAGA_TARJ_SAL = 77;
		final int DESCONECTADA = 78;
		final int OID_PUERTA = 79;

		Puerta pers = (Puerta) objetoPersistente;

		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append(" update cipPuerta set " + "codigo=?" + ",descripcion=?" + ",activo=?" + ",acceso_al_predio=?"
				+ ",egreso_del_predio=?" + ",IDENTIF_PUERTA=?,TIPO_MEDIO_ENT=?,IDENTIF_ENT=?,"
				+ "IDENTIF_LEG_ENT=?,PROTOCOLO_ENT=?,MODO_FUNC_ENT=?," + "TIPO_MEDIO_SAL=?,IDENTIF_SAL=?,IDENTIF_LEG_SAL=?,"
				+ "PROTOCOLO_SAL=?,MODO_FUNC_SAL=?,IP=?, " + "modo_off_line_ent=?," + "modo_off_line_sal=?," + "int_status_time=?,"
				+ "int_config_time=?," + "int_syncrotime=?," + "hab_punto_acc_1=?," + "hab_punto_acc_2=?," + "ctimeout_ent=?,"
				+ "ctimeout_sal=?," + "otimeout_ent=?," + "otimeout_sal=?," + "alarmtime_ent=?," + "alarmtime_sal=?," + "dir_pto_ent=?,"
				+ "dir_pto_sal=?," + "tipo_punto_ent=?," + "tipo_punto_sal=?," + "benable_ent=?," + "benable_sal=?," + "penable_ent=?,"
				+ "penable_sal=?," + "modo=?," + "puerto=?," + "puerto_tele=?, " +
				" fec_ult_act_lb=?,hora_ult_act_lb=?,fec_carga_placa_lb=?,hor_carga_placa_lb=?,cant_reg_lb=?,tipo_alim_lb_ent=?,tipo_alim_lb_sal=? , pedir_config=?, "+
				" fec_inicio_ol=?,hora_inicio_ol=?,fec_ult_status=?,hora_ult_status=?,liberar_entrada=?,liberar_salida=?,inter_nro_ent=?,inter_nro_sal=?,iniciar_tele=? , ingreso_cacheo=? , egreso_cacheo=? , "+
				" entrada_sale_de=?, entrada_entra_a=?, salida_sale_de=?, salida_entra_a=? , antipassback_ent = ? , antipassback_sal = ? , cacheo_ent = ? , cacheo_sal = ? , reg_mov_ult_ent = ?,reg_mov_ult_sal = ? , act_avi_acc_den = ? , restringir_ent = ? , restringir_sal = ? , restri_ent_vis = ? , lib_ent_vis = ? ,lib_sal_vis = ? , traga_tarj_sal = ? ,desconectada = ?"+
				" where " + " oid_puerta=? ");
		
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PUERTA, pers.getOID());
		qUpdate.setString(CODIGO, pers.getCodigo());
		qUpdate.setString(DESCRIPCION, pers.getDescripcion());
		qUpdate.setBoolean(ACTIVO, pers.isActivo().booleanValue());
		if (pers.isIngresoAlPredio() != null)
			qUpdate.setBoolean(ACCESO_AL_PREDIO, pers.isIngresoAlPredio().booleanValue());
		else
			qUpdate.setBoolean(ACCESO_AL_PREDIO, false);
		if (pers.isEgresoDelPredio() != null)
			qUpdate.setBoolean(EGRESO_DEL_PREDIO, pers.isEgresoDelPredio().booleanValue());
		else
			qUpdate.setBoolean(EGRESO_DEL_PREDIO, false);

		if (pers.getIdentifPuerta() != null)
			qUpdate.setString(IDENTIF_PUERTA, pers.getIdentifPuerta());
		else
			qUpdate.setString(IDENTIF_PUERTA, "");
		if (pers.getTipoMedioEntrada() != null)
			qUpdate.setString(TIPO_MEDIO_ENT, pers.getTipoMedioEntrada());
		else
			qUpdate.setString(TIPO_MEDIO_ENT, "");
		if (pers.getIdentifEntrada() != null)
			qUpdate.setString(IDENTIF_ENT, pers.getIdentifEntrada());
		else
			qUpdate.setString(IDENTIF_ENT, "");
		if (pers.getIdentifLegEntrada() != null)
			qUpdate.setString(IDENTIF_LEG_ENT, pers.getIdentifLegEntrada());
		else
			qUpdate.setString(IDENTIF_LEG_ENT, "");
		if (pers.getProtocoloEntrada() != null)
			qUpdate.setString(PROTOCOLO_ENT, pers.getProtocoloEntrada());
		else
			qUpdate.setString(PROTOCOLO_ENT, "");
		if (pers.getModoFuncEnt() != null)
			qUpdate.setString(MODO_FUNC_ENT, pers.getModoFuncEnt());
		else
			qUpdate.setString(MODO_FUNC_ENT, "");
		if (pers.getTipoMedioSal() != null)
			qUpdate.setString(TIPO_MEDIO_SAL, pers.getTipoMedioSal());
		else
			qUpdate.setString(TIPO_MEDIO_SAL, "");
		if (pers.getIdentifSal() != null)
			qUpdate.setString(IDENTIF_SAL, pers.getIdentifSal());
		else
			qUpdate.setString(IDENTIF_SAL, "");
		if (pers.getIdentifLegSal() != null)
			qUpdate.setString(IDENTIF_LEG_SAL, pers.getIdentifLegSal());
		else
			qUpdate.setString(IDENTIF_LEG_SAL, "");
		if (pers.getProtocoloSalida() != null)
			qUpdate.setString(PROTOCOLO_SAL, pers.getProtocoloSalida());
		else
			qUpdate.setString(PROTOCOLO_SAL, "");
		if (pers.getModoFuncSal() != null)
			qUpdate.setString(MODO_FUNC_SAL, pers.getModoFuncSal());
		else
			qUpdate.setString(MODO_FUNC_SAL, "");
		if (pers.getIP() != null)
			qUpdate.setString(IP, pers.getIP());
		else
			qUpdate.setString(IP, "");

		if (pers.getModoOFFLineEnt() != null)
			qUpdate.setInt(MODO_OFF_LINE_ENT, pers.getModoOFFLineEnt().intValue());
		else
			qUpdate.setNull(MODO_OFF_LINE_ENT, java.sql.Types.INTEGER);
		if (pers.getModoOFFLineSal() != null)
			qUpdate.setInt(MODO_OFF_LINE_SAL, pers.getModoOFFLineSal().intValue());
		else
			qUpdate.setNull(MODO_OFF_LINE_SAL, java.sql.Types.INTEGER);
		if (pers.getIntervaloStatusTime() != null)
			qUpdate.setInt(INT_STATUS_TIME, pers.getIntervaloStatusTime().intValue());
		else
			qUpdate.setNull(INT_STATUS_TIME, java.sql.Types.INTEGER);
		if (pers.getIntervaloConfigTime() != null)
			qUpdate.setInt(INT_CONFIG_TIME, pers.getIntervaloConfigTime().intValue());
		else
			qUpdate.setNull(INT_CONFIG_TIME, java.sql.Types.INTEGER);
		if (pers.getIntervaloSyncroTime() != null)
			qUpdate.setInt(INT_SYNCROTIME, pers.getIntervaloSyncroTime().intValue());
		else
			qUpdate.setNull(INT_SYNCROTIME, java.sql.Types.INTEGER);
		if (pers.getHabilitarPuntoAcceso1() != null)
			qUpdate.setInt(HAB_PUNTO_ACC_1, pers.getHabilitarPuntoAcceso1().intValue());
		else
			qUpdate.setNull(HAB_PUNTO_ACC_1, java.sql.Types.INTEGER);
		if (pers.getHabilitarPuntoAcceso2() != null)
			qUpdate.setInt(HAB_PUNTO_ACC_2, pers.getHabilitarPuntoAcceso2().intValue());
		else
			qUpdate.setNull(HAB_PUNTO_ACC_2, java.sql.Types.INTEGER);
		if (pers.getCTimeOutEnt() != null)
			qUpdate.setInt(CTIMEOUT_ENT, pers.getCTimeOutEnt().intValue());
		else
			qUpdate.setNull(CTIMEOUT_ENT, java.sql.Types.INTEGER);
		if (pers.getCTimeOutSal() != null)
			qUpdate.setInt(CTIMEOUT_SAL, pers.getCTimeOutSal().intValue());
		else
			qUpdate.setNull(CTIMEOUT_SAL, java.sql.Types.INTEGER);
		if (pers.getOTimeOutEnt() != null)
			qUpdate.setInt(OTIMEOUT_ENT, pers.getOTimeOutEnt().intValue());
		else
			qUpdate.setNull(OTIMEOUT_ENT, java.sql.Types.INTEGER);
		if (pers.getOTimeOutSal() != null)
			qUpdate.setInt(OTIMEOUT_SAL, pers.getOTimeOutSal().intValue());
		else
			qUpdate.setNull(OTIMEOUT_SAL, java.sql.Types.INTEGER);
		if (pers.getAlarmTimeEnt() != null)
			qUpdate.setInt(ALARMTIME_ENT, pers.getAlarmTimeEnt().intValue());
		else
			qUpdate.setNull(ALARMTIME_ENT, java.sql.Types.INTEGER);
		if (pers.getAlarmTimeSal() != null)
			qUpdate.setInt(ALARMTIME_SAL, pers.getAlarmTimeSal().intValue());
		else
			qUpdate.setNull(ALARMTIME_SAL, java.sql.Types.INTEGER);
		if (pers.getDirPtoEnt() != null)
			qUpdate.setInt(DIR_PTO_ENT, pers.getDirPtoEnt().intValue());
		else
			qUpdate.setNull(DIR_PTO_ENT, java.sql.Types.INTEGER);
		if (pers.getDirPtoSal() != null)
			qUpdate.setInt(DIR_PTO_SAL, pers.getDirPtoSal().intValue());
		else
			qUpdate.setNull(DIR_PTO_SAL, java.sql.Types.INTEGER);
		if (pers.getTipoPtoEnt() != null)
			qUpdate.setInt(TIPO_PUNTO_ENT, pers.getTipoPtoEnt().intValue());
		else
			qUpdate.setNull(TIPO_PUNTO_ENT, java.sql.Types.INTEGER);
		if (pers.getTipoPtoSal() != null)
			qUpdate.setInt(TIPO_PUNTO_SAL, pers.getTipoPtoSal().intValue());
		else
			qUpdate.setNull(TIPO_PUNTO_SAL, java.sql.Types.INTEGER);
		if (pers.getBenableEnt() != null)
			qUpdate.setInt(BENABLE_ENT, pers.getBenableEnt().intValue());
		else
			qUpdate.setNull(BENABLE_ENT, java.sql.Types.INTEGER);
		if (pers.getBenableSal() != null)
			qUpdate.setInt(BENABLE_SAL, pers.getBenableSal().intValue());
		else
			qUpdate.setNull(BENABLE_SAL, java.sql.Types.INTEGER);
		if (pers.getPenableEnt() != null)
			qUpdate.setInt(PENABLE_ENT, pers.getPenableEnt().intValue());
		else
			qUpdate.setNull(PENABLE_ENT, java.sql.Types.INTEGER);
		if (pers.getPenableSal() != null)
			qUpdate.setInt(PENABLE_SAL, pers.getPenableSal().intValue());
		else
			qUpdate.setNull(PENABLE_SAL, java.sql.Types.INTEGER);
		if (pers.getMode() != null)
			qUpdate.setInt(MODE, pers.getMode().intValue());
		else
			qUpdate.setNull(MODE, java.sql.Types.INTEGER);
		if (pers.getPuerto() != null)
			qUpdate.setInt(PUERTO, pers.getPuerto().intValue());
		else
			qUpdate.setNull(PUERTO, java.sql.Types.INTEGER);
		if (pers.getTelePuerto() != null)
			qUpdate.setInt(PUERTO_TELE, pers.getTelePuerto().intValue());
		else
			qUpdate.setNull(PUERTO_TELE, java.sql.Types.INTEGER);
		
		if (pers.getFecUltActLB()!=null)
			qUpdate.setDate(FEC_ULT_ACT_LB, new java.sql.Date(pers.getFecUltActLB().getTime()));
		else
			qUpdate.setNull(FEC_ULT_ACT_LB, java.sql.Types.DATE);

		if (pers.getHoraUltActLB()!=null)
			qUpdate.setString(HORA_ULT_ACT_LB, pers.getHoraUltActLB());
		else
			qUpdate.setNull(HORA_ULT_ACT_LB, java.sql.Types.VARCHAR);
		
		if (pers.getFecUltCargaLB()!=null)
			qUpdate.setDate(FEC_CARGA_PLACA_LB, new java.sql.Date(pers.getFecUltCargaLB().getTime()));
		else
			qUpdate.setNull(FEC_CARGA_PLACA_LB, java.sql.Types.DATE);
		
		if (pers.getHorUltCargaLB()!=null)
			qUpdate.setString(HOR_CARGA_PLACA_LB, pers.getHorUltCargaLB());
		else
			qUpdate.setNull(HOR_CARGA_PLACA_LB, java.sql.Types.VARCHAR);
		
		if (pers.getCantRegLB()!=null)
			qUpdate.setInt(CANT_REG_LB, pers.getCantRegLB().intValue());
		else
			qUpdate.setNull(CANT_REG_LB, java.sql.Types.INTEGER);
		
		if (pers.getTipoAlimLBEnt()!=null)
			qUpdate.setString(TIPO_ALIM_LB_ENT, pers.getTipoAlimLBEnt());
		else
			qUpdate.setNull(TIPO_ALIM_LB_ENT, java.sql.Types.VARCHAR);		
		
		if (pers.getTipoAlimLBSal()!=null)
			qUpdate.setString(TIPO_ALIM_LB_SAL, pers.getTipoAlimLBSal());
		else
			qUpdate.setNull(TIPO_ALIM_LB_SAL, java.sql.Types.VARCHAR);
		
		if (pers.isPideConfiguracion()!=null)
			qUpdate.setBoolean(PEDIR_CONFIG, pers.isPideConfiguracion().booleanValue());
		else
			qUpdate.setNull(PEDIR_CONFIG, java.sql.Types.BOOLEAN);		
		
		if (pers.getFecInicioOL()!=null)
			qUpdate.setDate(FEC_INICIO_OL, new java.sql.Date(pers.getFecInicioOL().getTime()));
		else
			qUpdate.setNull(FEC_INICIO_OL, java.sql.Types.DATE);
		
		if (pers.getHoraInicioOL()!=null)
			qUpdate.setString(HOR_INICIO_OL, pers.getHoraInicioOL());
		else
			qUpdate.setNull(HOR_INICIO_OL, java.sql.Types.VARCHAR);
		
		if (pers.getFecUltStatus()!=null)
			qUpdate.setDate(FEC_ULT_STATUS, new java.sql.Date(pers.getFecUltStatus().getTime()));
		else
			qUpdate.setNull(FEC_ULT_STATUS, java.sql.Types.DATE);
		
		if (pers.getHoraUltStatus()!=null)
			qUpdate.setString(HOR_ULT_STATUS, pers.getHoraUltStatus());
		else
			qUpdate.setNull(HOR_ULT_STATUS, java.sql.Types.VARCHAR);
		
		if (pers.isLiberarEntrada()!=null)
			qUpdate.setBoolean(LIBERAR_ENTRADA, pers.isLiberarEntrada().booleanValue());
		else
			qUpdate.setNull(LIBERAR_ENTRADA, java.sql.Types.BOOLEAN);
		if (pers.isLiberarSalida()!=null)
			qUpdate.setBoolean(LIBERAR_SALIDA, pers.isLiberarSalida().booleanValue());
		else
			qUpdate.setNull(LIBERAR_SALIDA, java.sql.Types.BOOLEAN);
		
		if (pers.getInterpretarNroEnt()!=null)
			qUpdate.setString(INTER_NRO_ENT, pers.getInterpretarNroEnt());
		else
			qUpdate.setNull(INTER_NRO_ENT, java.sql.Types.VARCHAR);
		if (pers.getInterpretarNroSal()!=null)
			qUpdate.setString(INTER_NRO_SAL, pers.getInterpretarNroSal());
		else
			qUpdate.setNull(INTER_NRO_SAL, java.sql.Types.VARCHAR);
		
		if (pers.isIniciarTelecomando()!=null)
			qUpdate.setBoolean(INI_TEL, pers.isIniciarTelecomando().booleanValue());
		else
			qUpdate.setNull(INI_TEL, java.sql.Types.BOOLEAN);
		
		if (pers.getIngresoCacheo()!=null)
			qUpdate.setString(INGRESO_CACHEO, pers.getIngresoCacheo());
		else
			qUpdate.setNull(INGRESO_CACHEO, java.sql.Types.VARCHAR);		
		
		if (pers.getEgresoCacheo()!=null)
			qUpdate.setString(EGRESO_CACHEO, pers.getEgresoCacheo());
		else
			qUpdate.setNull(EGRESO_CACHEO, java.sql.Types.VARCHAR);
		
		if (pers.getEntradaSaleDe()!=null)
			qUpdate.setInt(ENTRADA_SALE_DE, pers.getEntradaSaleDe().getOID());
		else
			qUpdate.setNull(ENTRADA_SALE_DE, java.sql.Types.INTEGER);		
		
		if (pers.getEntradaEntraA()!=null)
			qUpdate.setInt(ENTRADA_ENTRA_A, pers.getEntradaEntraA().getOID());
		else
			qUpdate.setNull(ENTRADA_ENTRA_A, java.sql.Types.INTEGER);		
		
		if (pers.getSalidaSaleDe()!=null)
			qUpdate.setInt(SALIDA_SALE_DE, pers.getSalidaSaleDe().getOID());
		else
			qUpdate.setNull(SALIDA_SALE_DE, java.sql.Types.INTEGER);		
		
		if (pers.getSalidaEntraA()!=null)
			qUpdate.setInt(SALIDA_ENTRA_A, pers.getSalidaEntraA().getOID());
		else
			qUpdate.setNull(SALIDA_ENTRA_A, java.sql.Types.INTEGER);	
		
		qUpdate.setBoolean(ANTIPASSBACK_ENT, pers.isControlAntiPassBackEnt());
		qUpdate.setBoolean(ANTIPASSBACK_SAL, pers.isControlAntiPassBackSal());
		
		qUpdate.setBoolean(CACHEO_ENT, pers.isControlCacheoEnt());
		qUpdate.setBoolean(CACHEO_SAL, pers.isControlCacheoSal());

		qUpdate.setBoolean(REG_MOV_ULT_ENT , pers.isRegMovUltEnt());
		qUpdate.setBoolean(REG_MOV_ULT_SAL , pers.isRegMovUltSal());
		qUpdate.setBoolean(ACT_AVI_ACC_DEN , pers.isActAviAccDenegado());
		qUpdate.setBoolean(RESTRINGIR_ENT , pers.isRentringirEnt());
		qUpdate.setBoolean(RESTRINGIR_SAL, pers.isRentringirSal());
		
		qUpdate.setBoolean(RESTRI_ENT_VIS, pers.isRestringirEntVisita());
		qUpdate.setBoolean(LIB_ENT_VIS , pers.isLibEntradaVisita());
		qUpdate.setBoolean(LIB_SAL_VIS , pers.isLibSalidaVisita());
		qUpdate.setBoolean(TRAGA_TARJ_SAL , pers.isTragaTarjAlSalir());
		
		qUpdate.setBoolean(DESCONECTADA, pers.isDesconectada());
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PUERTA = 1;
		Puerta pers = (Puerta) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPuerta " + " set activo=0 " + " where " + " oid_puerta=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PUERTA, pers.getOID());
		
		qUpdate.executeUpdate();
		qUpdate.close();
	}

	protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
		final int OID_PUERTA = 1;
		Puerta pers = (Puerta) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update cipPuerta " + " set activo=1 " + " where " + " oid_puerta=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_PUERTA, pers.getOID());
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
		case IDBObjetoPersistente.SELECT_ALL_ACTIVOS_HELP: {
			ps = this.selectAllHelpActivos(aCondiciones);
			break;
		}
		case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: {
			ps = this.selectAllActivos(aCondiciones);
			break;
		}		
		case SELECT_BY_IDENTIF_PUERTA: {
			ps = this.selectByIdentifPuerta(aCondiciones);
			break;
		}
		}
		return ps;
	}

	private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

		final int OID_PUERTA = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPuerta ");
		textSQL.append(" WHERE oid_puerta = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		int oid = ((Integer) aCondiciones).intValue();
		querySelect.setInt(OID_PUERTA, oid);
		return querySelect;
	}

	private PreparedStatement selectByIdentifPuerta(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPuerta ");
		textSQL.append(" WHERE identif_puerta = ? and activo=1 ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		Integer identifPuerta = (Integer) aCondiciones;
		querySelect.setInt(1, identifPuerta.intValue());
		return querySelect;
	}
	
	private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException {
		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPuerta ");
		textSQL.append(" WHERE activo = 1");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

		final int CODIGO = 1;

		StringBuffer textSQL = new StringBuffer();
		textSQL.append("SELECT * FROM  cipPuerta ");
		textSQL.append(" WHERE codigo = ? ");
		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		String codigo = (String) aCondiciones;
		querySelect.setString(CODIGO, codigo);
		return querySelect;
	}
	
	
	private PreparedStatement selectAllHelpActivos(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_puerta oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from cipPuerta where activo=1");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}
	

	private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

		StringBuffer textSQL = new StringBuffer();

		textSQL.append("SELECT oid_puerta oid,codigo codigo, descripcion descripcion ,activo ");
		textSQL.append(" from cipPuerta");

		PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
		return querySelect;
	}

	public static Puerta getPuertaByIdentif(Integer aIdentif, ISesion aSesion) throws BaseException {
		return (Puerta) ObjetoLogico.getObjects(Puerta.NICKNAME, DBPuerta.SELECT_BY_IDENTIF_PUERTA, aIdentif, new ObjetoObservado(),
				aSesion);
	}
	
	public static List getPuertasActivas(ISesion aSesion) throws BaseException {
		return (List) ObjetoLogico.getObjects(Puerta.NICKNAME, DBPuerta.SELECT_ALL_ACTIVOS, null, new ListObserver(), aSesion);
	}

		
	
}
	

