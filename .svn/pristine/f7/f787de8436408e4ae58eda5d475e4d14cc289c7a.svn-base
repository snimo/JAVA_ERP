package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.ZonaCIP;
import com.srn.erp.cip.da.DBPuerta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPuerta extends FactoryObjetoLogico { 

  public FactoryPuerta() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
   
	Puerta puerta = (Puerta) objLog;
    puerta.setOID(db.getInteger(DBPuerta.OID_PUERTA));
    puerta.setCodigo(db.getString(DBPuerta.CODIGO));
    puerta.setDescripcion(db.getString(DBPuerta.DESCRIPCION));
    puerta.setActivo(db.getBoolean(DBPuerta.ACTIVO));
    puerta.setIngresoAlPredio(db.getBoolean(DBPuerta.ACCESO_AL_PREDIO));
    puerta.setEgresoDelPredio(db.getBoolean(DBPuerta.EGRESO_DEL_PREDIO));
    
    puerta.setIP(db.getString(DBPuerta.IP));
    puerta.setIdentifPuerta(db.getString(DBPuerta.IDENTIF_PUERTA));
    puerta.setTipoMedioEntrada(db.getString(DBPuerta.TIPO_MEDIO_ENT));
    puerta.setIdentifEntrada(db.getString(DBPuerta.IDENTIF_ENT));
    puerta.setIdentifLegEntrada(db.getString(DBPuerta.IDENTIF_LEG_ENT));
    puerta.setProtolocoEntrada(db.getString(DBPuerta.PROTOLOCO_ENT));
    puerta.setModoFuncEnt(db.getString(DBPuerta.MODO_FUNC_ENT));
    puerta.setTipoMedioSal(db.getString(DBPuerta.TIPO_MEDIO_SAL));
    puerta.setIdentifSal(db.getString(DBPuerta.IDENTIF_SAL));
    puerta.setIdentifLegSal(db.getString(DBPuerta.IDENTIF_LEG_SAL));
    puerta.setProtocoloSalida(db.getString(DBPuerta.PROTOCOLO_SAL));
    puerta.setModoFuncSal(db.getString(DBPuerta.MODO_FUNC_SAL));
    
    puerta.setModoOFFLineEnt(db.getInteger("modo_off_line_ent"));
    puerta.setModoOFFLineSal(db.getInteger("modo_off_line_sal"));
    puerta.setIntervalorStatusTime(db.getInteger("int_status_time"));
    puerta.setIntervalorConfigTime(db.getInteger("int_config_time"));
    puerta.setIntervalorSyncroTime(db.getInteger("int_syncrotime"));
    puerta.setHabilitarPuntoAcceso1(db.getInteger("hab_punto_acc_1"));
    puerta.setHabilitarPuntoAcceso2(db.getInteger("hab_punto_acc_2"));
    puerta.setCTimeOutEnt(db.getInteger("ctimeout_ent"));
    puerta.setCTimeOutSal(db.getInteger("ctimeout_sal"));
    puerta.setOTimeOutEnt(db.getInteger("otimeout_ent"));
    puerta.setOTimeOutSal(db.getInteger("otimeout_sal"));
    puerta.setAlarmTimeEnt(db.getInteger("alarmtime_ent"));
    puerta.setAlarmTimeSal(db.getInteger("alarmtime_sal"));
    puerta.setDirPtoEnt(db.getInteger("dir_pto_ent"));
    puerta.setDirPtoSal(db.getInteger("dir_pto_sal"));
    puerta.setTipoPtoEnt(db.getInteger("tipo_punto_ent"));
    puerta.setTipoPtoSal(db.getInteger("tipo_punto_sal"));
    puerta.setBenableEnt(db.getInteger("benable_ent"));
    puerta.setBenableSal(db.getInteger("benable_sal"));
    puerta.setPenableEnt(db.getInteger("penable_ent"));
    puerta.setPenableSal(db.getInteger("penable_sal"));
    puerta.setMode(db.getInteger("modo"));
    puerta.setPuerto(db.getInteger("puerto"));
    puerta.setTelePuerto(db.getInteger("puerto_tele"));
    puerta.setPideConfiguracion(db.getBoolean(DBPuerta.PEDIR_CONFIG));
    
    puerta.setFecUltActLB(db.getDate(DBPuerta.FEC_ULT_ACT_LB));
    puerta.setHoraUltActLB(db.getString(DBPuerta.HORA_ULT_ACT_LB));
    puerta.setFecUltCargaLB(db.getDate(DBPuerta.FEC_CARGA_PLACA_LB));
    puerta.setHoraUltCargaLP(db.getString(DBPuerta.HOR_CARGA_PLACA_LB));
    puerta.setCantRegLP(db.getInteger(DBPuerta.CANT_REG_LB));
    puerta.setTipoAlimLBEnt(db.getString(DBPuerta.TIPO_ALIM_LB_ENT));
    puerta.setTipoAlimLBSal(db.getString(DBPuerta.TIPO_ALIM_LB_SAL));
    
    puerta.setFecInicioOL(db.getDate(DBPuerta.FEC_INICIO_OL));
    puerta.setHoraInicioOL(db.getString(DBPuerta.HOR_INICIO_OL));
    puerta.setFecUltStatus(db.getDate(DBPuerta.FEC_ULT_STATUS));
    puerta.setHoraUltStatus(db.getString(DBPuerta.HOR_ULT_STATUS));
    puerta.setLiberarEntrada(db.getBoolean(DBPuerta.LIBERAR_ENTRADA));
    puerta.setLiberarSalida(db.getBoolean(DBPuerta.LIBERAR_SALIDA));
    
    puerta.setInterpretarNroEnt(db.getString(DBPuerta.INTER_NRO_ENT));
    puerta.setInterpretarNroSal(db.getString(DBPuerta.INTER_NRO_SAL));
    puerta.setIniciarTelecomando(db.getBoolean(DBPuerta.INI_TELE));
    
    puerta.setIngresoCacheo(db.getString(DBPuerta.INGRESO_CACHEO));
    puerta.setEgresoCacheo(db.getString(DBPuerta.EGRESO_CACHEO));
    
    puerta.setEntradaEntraA(ZonaCIP.findByOidProxy(db.getInteger(DBPuerta.ENTRADA_ENTRA_A),this.getSesion()));
    puerta.setEntradaSaleDe(ZonaCIP.findByOidProxy(db.getInteger(DBPuerta.ENTRADA_SALE_DE),this.getSesion()));
    puerta.setSalidaEntraA(ZonaCIP.findByOidProxy(db.getInteger(DBPuerta.SALIDA_ENTRA_A),this.getSesion()));
    puerta.setSalidaSaleDe(ZonaCIP.findByOidProxy(db.getInteger(DBPuerta.SALIDA_SALE_DE),this.getSesion()));
    
    puerta.setControlAntiPassBackEnt(db.getBoolean(DBPuerta.ANTIPASSBACK_ENT));
    puerta.setControlAntiPassBackSal(db.getBoolean(DBPuerta.ANTIPASSBACK_SAL));
    
    puerta.setControlCacheoEnt(db.getBoolean(DBPuerta.CACHEO_ENT));
    puerta.setControlCacheoSal(db.getBoolean(DBPuerta.CACHEO_SAL));
    
    puerta.setRegMovUltEnt(db.getBoolean(DBPuerta.REG_MOV_ULT_ENT));
    puerta.setRegMovUltSal(db.getBoolean(DBPuerta.REG_MOV_ULT_SAL));
    puerta.setActAviAccDenegado(db.getBoolean(DBPuerta.ACT_AVI_ACC_DEN));
    puerta.setRestringirEnt(db.getBoolean(DBPuerta.RESTRINGIR_ENT));
    puerta.setRestringirSal(db.getBoolean(DBPuerta.RESTRINGIR_SAL));
    puerta.setRestringirEntVisita(db.getBoolean(DBPuerta.RESTRI_ENT_VIS));
    puerta.setLibEntradaVisita(db.getBoolean(DBPuerta.LIB_ENT_VIS));
    puerta.setLibSalidaVisita(db.getBoolean(DBPuerta.LIB_SAL_VIS));
    puerta.setTragaTarjAlSalir(db.getBoolean(DBPuerta.TRAGA_TARJ_SAL));
    puerta.setDesconectada(db.getBoolean(DBPuerta.DESCONECTADA));
    
  }
}
