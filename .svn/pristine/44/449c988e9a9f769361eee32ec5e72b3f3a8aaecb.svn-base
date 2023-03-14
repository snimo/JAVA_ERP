package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.AvisoCIPGMaquina;
import com.srn.erp.cip.bm.AvisoCIPGUsuario;
import com.srn.erp.cip.bm.AvisoCIPMaquina;
import com.srn.erp.cip.bm.AvisoCIPUsuario;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.ZonaCIP;
import com.srn.erp.mensajero.bm.GrupoMaquina;
import com.srn.erp.mensajero.bm.GrupoUsuMens;
import com.srn.erp.mensajero.bm.Maquina;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SavePuerta extends Operation { 

  public SavePuerta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TPuertas"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Puerta puerta = Puerta.findByOid(dataset.getInteger("oid_puerta"),getSesion());
        puerta.setOID(dataset.getInteger("oid_puerta"));
        puerta.setCodigo(dataset.getString("codigo"));
        puerta.setDescripcion(dataset.getString("descripcion"));
        puerta.setActivo(dataset.getBoolean("activo"));
        puerta.setIngresoAlPredio(dataset.getBoolean("acceso_al_predio"));
        puerta.setEgresoDelPredio(dataset.getBoolean("egreso_del_predio"));
        
        puerta.setIP(dataset.getString("IP"));
        puerta.setIdentifPuerta(dataset.getString("identif_puerta"));
        puerta.setTipoMedioEntrada(dataset.getString("tipo_medio_ent"));
        puerta.setIdentifEntrada(dataset.getString("identif_ent"));
        puerta.setIdentifLegEntrada(dataset.getString("identif_leg_ent"));
        puerta.setProtolocoEntrada(dataset.getString("protocolo_ent"));
        puerta.setModoFuncEnt(dataset.getString("modo_func_ent"));
        puerta.setTipoMedioSal(dataset.getString("tipo_medio_sal"));
        puerta.setIdentifSal(dataset.getString("identif_sal"));
        puerta.setIdentifLegSal(dataset.getString("identif_leg_sal"));
        puerta.setProtocoloSalida(dataset.getString("protocolo_sal"));
        puerta.setModoFuncSal(dataset.getString("modo_func_sal"));
        
        puerta.setModoOFFLineEnt(dataset.getInteger("modo_off_line_ent"));
        puerta.setModoOFFLineSal(dataset.getInteger("modo_off_line_sal"));
        puerta.setIntervalorStatusTime(dataset.getInteger("int_status_time"));
        puerta.setIntervalorConfigTime(dataset.getInteger("int_config_time"));
        puerta.setIntervalorSyncroTime(dataset.getInteger("int_syncrotime"));
        puerta.setHabilitarPuntoAcceso1(dataset.getInteger("hab_punto_acc_1"));
        puerta.setHabilitarPuntoAcceso2(dataset.getInteger("hab_punto_acc_2"));
        puerta.setCTimeOutEnt(dataset.getInteger("ctimeout_ent"));
        puerta.setCTimeOutSal(dataset.getInteger("ctimeout_sal"));
        puerta.setOTimeOutEnt(dataset.getInteger("otimeout_ent"));
        puerta.setOTimeOutSal(dataset.getInteger("otimeout_sal"));
        puerta.setAlarmTimeEnt(dataset.getInteger("alarmtime_ent"));
        puerta.setAlarmTimeSal(dataset.getInteger("alarmtime_sal"));
        puerta.setDirPtoEnt(dataset.getInteger("dir_pto_ent"));
        puerta.setDirPtoSal(dataset.getInteger("dir_pto_sal"));
        puerta.setTipoPtoEnt(dataset.getInteger("tipo_punto_ent"));
        puerta.setTipoPtoSal(dataset.getInteger("tipo_punto_sal"));
        puerta.setBenableEnt(dataset.getInteger("benable_ent"));
        puerta.setBenableSal(dataset.getInteger("benable_sal"));
        puerta.setPenableEnt(dataset.getInteger("penable_ent"));
        puerta.setPenableSal(dataset.getInteger("penable_sal"));
        puerta.setMode(dataset.getInteger("mode"));
        puerta.setPuerto(dataset.getInteger("puerto"));
        puerta.setTelePuerto(dataset.getInteger("puerto_tele"));
        puerta.setTipoAlimLBEnt(dataset.getString("tipo_alim_lb_ent"));
        puerta.setTipoAlimLBSal(dataset.getString("tipo_alim_lb_sal"));
        puerta.setPideConfiguracion(dataset.getBoolean("pedir_config"));
        puerta.setLiberarEntrada(dataset.getBoolean("liberar_entrada"));
        puerta.setLiberarSalida(dataset.getBoolean("liberar_salida"));
        puerta.setInterpretarNroEnt(dataset.getString("inter_nro_ent"));
        puerta.setInterpretarNroSal(dataset.getString("inter_nro_sal"));
        puerta.setIniciarTelecomando(dataset.getBoolean("iniciar_tele"));
        puerta.setIngresoCacheo(dataset.getString("ingreso_cacheo"));
        puerta.setEgresoCacheo(dataset.getString("egreso_cacheo"));
        puerta.setEntradaEntraA(ZonaCIP.findByOidProxy(dataset.getInteger("entrada_entra_a"),this.getSesion()));
        puerta.setEntradaSaleDe(ZonaCIP.findByOidProxy(dataset.getInteger("entrada_sale_de"),this.getSesion()));
        puerta.setSalidaEntraA(ZonaCIP.findByOidProxy(dataset.getInteger("salida_entra_a"),this.getSesion()));
        puerta.setSalidaSaleDe(ZonaCIP.findByOidProxy(dataset.getInteger("salida_sale_de"),this.getSesion()));
        puerta.setControlCacheoEnt(dataset.getBoolean("cacheo_ent"));
        puerta.setControlCacheoSal(dataset.getBoolean("cacheo_sal"));
        puerta.setRegMovUltEnt(dataset.getBoolean("reg_mov_ult_ent"));
        puerta.setRegMovUltSal(dataset.getBoolean("reg_mov_ult_sal"));
        puerta.setActAviAccDenegado(dataset.getBoolean("act_avi_acc_den"));
        puerta.setRestringirEnt(dataset.getBoolean("restringir_ent"));
        puerta.setRestringirSal(dataset.getBoolean("restringir_sal"));
        puerta.setControlAntiPassBackEnt(dataset.getBoolean("antipassback_ent"));
        puerta.setControlAntiPassBackSal(dataset.getBoolean("antipassback_sal"));
        puerta.setRestringirEntVisita(dataset.getBoolean("restri_ent_vis"));
        puerta.setLibEntradaVisita(dataset.getBoolean("lib_ent_vis"));
        puerta.setLibSalidaVisita(dataset.getBoolean("lib_sal_vis"));
        puerta.setTragaTarjAlSalir(dataset.getBoolean("traga_tarj_sal"));
        
        IDataSet dsAvisoUsuario = dataset.getDataSet("TAvisoUsuario");
        dsAvisoUsuario.first();
        while (!dsAvisoUsuario.EOF()) {
        	AvisoCIPUsuario avisoCIPUsuario =
        		AvisoCIPUsuario.findByOid(dsAvisoUsuario.getInteger("oid_avi_usu"), this.getSesion());
        	avisoCIPUsuario.setUsuario(Usuario.findByOidProxy(dsAvisoUsuario.getInteger("oid_usuario"), this.getSesion()));
        	avisoCIPUsuario.setOid_obj_neg(puerta.getOIDInteger());
        	avisoCIPUsuario.setCircuito(Puerta.getCACHEO());
        	if (!dsAvisoUsuario.getBoolean("activo"))
        		avisoCIPUsuario.delete();
        	dsAvisoUsuario.next();
        	puerta.addAvisoCacheoUsuario(avisoCIPUsuario);
        }
        
        IDataSet dsAvisoUsuarioAD = dataset.getDataSet("TAvisoUsuarioAD");
        dsAvisoUsuarioAD.first();
        while (!dsAvisoUsuarioAD.EOF()) {
        	AvisoCIPUsuario avisoCIPUsuario =
        		AvisoCIPUsuario.findByOid(dsAvisoUsuarioAD.getInteger("oid_avi_usu"), this.getSesion());
        	avisoCIPUsuario.setUsuario(Usuario.findByOidProxy(dsAvisoUsuarioAD.getInteger("oid_usuario"), this.getSesion()));
        	avisoCIPUsuario.setOid_obj_neg(puerta.getOIDInteger());
        	avisoCIPUsuario.setCircuito(Puerta.getACCESO_DENEGADO());
        	if (!dsAvisoUsuarioAD.getBoolean("activo"))
        		avisoCIPUsuario.delete();
        	dsAvisoUsuarioAD.next();
        	puerta.addAvisoUsuarioAD(avisoCIPUsuario);
        }
        
        
        IDataSet dsAvisoMaquina = dataset.getDataSet("TAvisoMaquina");
        dsAvisoMaquina.first();
        while (!dsAvisoMaquina.EOF()) {
        	AvisoCIPMaquina avisoCIPMaquina =
        		AvisoCIPMaquina.findByOid(dsAvisoMaquina.getInteger("oid_avi_maq"), this.getSesion());
        	avisoCIPMaquina.setMaquina(Maquina.findByOidProxy(dsAvisoMaquina.getInteger("oid_maquina"), this.getSesion()));
        	avisoCIPMaquina.setOid_obj_neg(puerta.getOIDInteger());
        	avisoCIPMaquina.setCircuito(Puerta.getCACHEO());
        	if (!dsAvisoMaquina.getBoolean("activo"))
        		avisoCIPMaquina.delete();
        	dsAvisoMaquina.next();
        	puerta.addAvisoCacheoMaquina(avisoCIPMaquina);
        }
        
        IDataSet dsAvisoMaquinaAD = dataset.getDataSet("TAvisoMaquinaAD");
        dsAvisoMaquinaAD.first();
        while (!dsAvisoMaquinaAD.EOF()) {
        	AvisoCIPMaquina avisoCIPMaquina =
        		AvisoCIPMaquina.findByOid(dsAvisoMaquinaAD.getInteger("oid_avi_maq"), this.getSesion());
        	avisoCIPMaquina.setMaquina(Maquina.findByOidProxy(dsAvisoMaquinaAD.getInteger("oid_maquina"), this.getSesion()));
        	avisoCIPMaquina.setOid_obj_neg(puerta.getOIDInteger());
        	avisoCIPMaquina.setCircuito(Puerta.getACCESO_DENEGADO());
        	if (!dsAvisoMaquinaAD.getBoolean("activo"))
        		avisoCIPMaquina.delete();
        	dsAvisoMaquinaAD.next();
        	puerta.addAvisoMaquinaAD(avisoCIPMaquina);
        }
        
        IDataSet dsAvisoGUsuario = dataset.getDataSet("TAvisoGUsuario");
        dsAvisoGUsuario.first();
        while (!dsAvisoGUsuario.EOF()) {
        	AvisoCIPGUsuario avisoCIPGUsuario =
        		AvisoCIPGUsuario.findByOid(dsAvisoGUsuario.getInteger("oid_avi_gusu"), this.getSesion());
        	avisoCIPGUsuario.setGrupo_usuario(GrupoUsuMens.findByOidProxy(dsAvisoGUsuario.getInteger("oid_grupo_usuario"), this.getSesion()));
        	avisoCIPGUsuario.setOid_obj_neg(puerta.getOIDInteger());
        	avisoCIPGUsuario.setCircuito(Puerta.getCACHEO());
        	if (!dsAvisoGUsuario.getBoolean("activo"))
        		avisoCIPGUsuario.delete();
        	dsAvisoGUsuario.next();
        	puerta.addAvisoCacheoGUsuario(avisoCIPGUsuario);
        }
        
        IDataSet dsAvisoGUsuarioAD = dataset.getDataSet("TAvisoGUsuarioAD");
        dsAvisoGUsuarioAD.first();
        while (!dsAvisoGUsuarioAD.EOF()) {
        	AvisoCIPGUsuario avisoCIPGUsuario =
        		AvisoCIPGUsuario.findByOid(dsAvisoGUsuarioAD.getInteger("oid_avi_gusu"), this.getSesion());
        	avisoCIPGUsuario.setGrupo_usuario(GrupoUsuMens.findByOidProxy(dsAvisoGUsuarioAD.getInteger("oid_grupo_usuario"), this.getSesion()));
        	avisoCIPGUsuario.setOid_obj_neg(puerta.getOIDInteger());
        	avisoCIPGUsuario.setCircuito(Puerta.getACCESO_DENEGADO());
        	if (!dsAvisoGUsuarioAD.getBoolean("activo"))
        		avisoCIPGUsuario.delete();
        	dsAvisoGUsuarioAD.next();
        	puerta.addAvisoGUsuarioAD(avisoCIPGUsuario);
        }
        
        
        IDataSet dsAvisoGMaquina = dataset.getDataSet("TAvisoGMaquina");
        dsAvisoGMaquina.first();
        while (!dsAvisoGMaquina.EOF()) {
        	AvisoCIPGMaquina avisoCIPGMaquina =
        		AvisoCIPGMaquina.findByOid(dsAvisoGMaquina.getInteger("oid_avi_gmaq"), this.getSesion());
        	avisoCIPGMaquina.setGrupo_maquina(GrupoMaquina.findByOidProxy(dsAvisoGMaquina.getInteger("oid_grupo_maquina"), this.getSesion()));
        	avisoCIPGMaquina.setOid_obj_neg(puerta.getOIDInteger());
        	avisoCIPGMaquina.setCircuito(Puerta.getCACHEO());
        	if (!dsAvisoGMaquina.getBoolean("activo"))
        		avisoCIPGMaquina.delete();
        	dsAvisoGMaquina.next();
        	puerta.addAvisoCacheoGMaquina(avisoCIPGMaquina);
        }
        
        IDataSet dsAvisoGMaquinaAD = dataset.getDataSet("TAvisoGMaquinaAD");
        dsAvisoGMaquinaAD.first();
        while (!dsAvisoGMaquinaAD.EOF()) {
        	AvisoCIPGMaquina avisoCIPGMaquina =
        		AvisoCIPGMaquina.findByOid(dsAvisoGMaquinaAD.getInteger("oid_avi_gmaq"), this.getSesion());
        	avisoCIPGMaquina.setGrupo_maquina(GrupoMaquina.findByOidProxy(dsAvisoGMaquinaAD.getInteger("oid_grupo_maquina"), this.getSesion()));
        	avisoCIPGMaquina.setOid_obj_neg(puerta.getOIDInteger());
        	avisoCIPGMaquina.setCircuito(Puerta.getACCESO_DENEGADO());
        	if (!dsAvisoGMaquinaAD.getBoolean("activo"))
        		avisoCIPGMaquina.delete();
        	dsAvisoGMaquinaAD.next();
        	puerta.addAvisoGMaquinaAD(avisoCIPGMaquina);
        }
        
        
        addTransaccion(puerta);
        dataset.next();
    }
  }
  
}
