package com.srn.erp.cip.op;



import java.util.Iterator;

import com.srn.erp.cip.bm.AvisoCIPGMaquina;
import com.srn.erp.cip.bm.AvisoCIPGUsuario;
import com.srn.erp.cip.bm.AvisoCIPMaquina;
import com.srn.erp.cip.bm.AvisoCIPUsuario;
import com.srn.erp.cip.bm.Puerta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPuerta extends Operation {

	public TraerPuerta() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		Puerta puerta = null;
		
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			puerta = Puerta.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			puerta = Puerta.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetPuerta = getDataSetPuerta();
		
		IDataSet dsAvisoUsu = this.getDataSetAvisoUsuario();
		IDataSet dsAvisoMaq = this.getDataSetAvisoMaquina();
		IDataSet dsAvisoGUsu = this.getDataSetAvisoGUsuario();
		IDataSet dsAvisoGMaq = this.getDataSetAvisoGMaquina();
		
		IDataSet dsAvisoUsuAD = this.getDataSetAvisoUsuarioAD();
		IDataSet dsAvisoMaqAD = this.getDataSetAvisoMaquinaAD();
		IDataSet dsAvisoGUsuAD = this.getDataSetAvisoGUsuarioAD();
		IDataSet dsAvisoGMaqAD = this.getDataSetAvisoGMaquinaAD();
		
		if (puerta != null) {
			
			cargarRegistroPuerta(datasetPuerta, puerta);
			
			cargarAvisoUsuario(puerta,dsAvisoUsu);
			cargarAvisoGUsuario(puerta,dsAvisoGUsu);
			cargarAvisoMaquina(puerta,dsAvisoMaq);
			cargarAvisoGMaquina(puerta,dsAvisoGMaq);
			
			cargarAvisoUsuarioAD(puerta,dsAvisoUsuAD);
			cargarAvisoGUsuarioAD(puerta,dsAvisoGUsuAD);
			cargarAvisoMaquinaAD(puerta,dsAvisoMaqAD);
			cargarAvisoGMaquinaAD(puerta,dsAvisoGMaqAD);
			
		}

		writeCliente(datasetPuerta);
		
		writeCliente(dsAvisoUsu);
		writeCliente(dsAvisoMaq);
		writeCliente(dsAvisoGUsu);
		writeCliente(dsAvisoGMaq);
		
		writeCliente(dsAvisoUsuAD);
		writeCliente(dsAvisoMaqAD);
		writeCliente(dsAvisoGUsuAD);
		writeCliente(dsAvisoGMaqAD);
		
		
	}

	private IDataSet getDataSetAvisoMaquina() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAvisoMaquina");
		dataset.fieldDef(new Field("oid_avi_maq", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_maquina", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_maquina", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_maquina", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_obj_neg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("circuito", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetAvisoMaquinaAD() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAvisoMaquinaAD");
		dataset.fieldDef(new Field("oid_avi_maq", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_maquina", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_maquina", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_maquina", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_obj_neg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("circuito", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	
	private IDataSet getDataSetAvisoGMaquina() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAvisoGMaquina");
		dataset.fieldDef(new Field("oid_avi_gmaq", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_maquina", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo_maquina", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_maquina", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_obj_neg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("circuito", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetAvisoGMaquinaAD() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAvisoGMaquinaAD");
		dataset.fieldDef(new Field("oid_avi_gmaq", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_maquina", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo_maquina", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_maquina", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_obj_neg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("circuito", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}	
	
	
	private IDataSet getDataSetAvisoUsuario() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAvisoUsuario");
		dataset.fieldDef(new Field("oid_avi_usu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_usuario", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_usuario", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_obj_neg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("circuito", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetAvisoUsuarioAD() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAvisoUsuarioAD");
		dataset.fieldDef(new Field("oid_avi_usu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_usuario", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_usuario", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_obj_neg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("circuito", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}	
	
	
	private IDataSet getDataSetAvisoGUsuario() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAvisoGUsuario");
		dataset.fieldDef(new Field("oid_avi_gusu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_usuario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo_usuario", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_usuario", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_obj_neg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("circuito", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetAvisoGUsuarioAD() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAvisoGUsuarioAD");
		dataset.fieldDef(new Field("oid_avi_gusu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_grupo_usuario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_grupo_usuario", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_grupo_usuario", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_obj_neg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("circuito", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}	
	

	private IDataSet getDataSetPuerta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPuertas");
		dataset.fieldDef(new Field("oid_puerta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("acceso_al_predio", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("egreso_del_predio", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("IP", Field.STRING, 50));
		dataset.fieldDef(new Field("identif_puerta", Field.STRING, 20));
		dataset.fieldDef(new Field("tipo_medio_ent", Field.STRING, 20));
		dataset.fieldDef(new Field("identif_ent", Field.STRING, 20));
		dataset.fieldDef(new Field("identif_leg_ent", Field.STRING, 20));
		dataset.fieldDef(new Field("protocolo_ent", Field.STRING, 20));
		dataset.fieldDef(new Field("modo_func_ent", Field.STRING, 20));
		dataset.fieldDef(new Field("tipo_medio_sal", Field.STRING, 20));
		dataset.fieldDef(new Field("identif_sal", Field.STRING, 20));
		dataset.fieldDef(new Field("identif_leg_sal", Field.STRING, 20));
		dataset.fieldDef(new Field("protocolo_sal", Field.STRING, 20));
		dataset.fieldDef(new Field("modo_func_sal", Field.STRING, 20));

		dataset.fieldDef(new Field("modo_off_line_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("modo_off_line_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("int_status_time", Field.INTEGER, 0));
		dataset.fieldDef(new Field("int_config_time", Field.INTEGER, 0));
		dataset.fieldDef(new Field("int_syncrotime", Field.INTEGER, 0));
		dataset.fieldDef(new Field("hab_punto_acc_1", Field.INTEGER, 0));
		dataset.fieldDef(new Field("hab_punto_acc_2", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ctimeout_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("ctimeout_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("otimeout_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("otimeout_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("alarmtime_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("alarmtime_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("dir_pto_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("dir_pto_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_punto_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_punto_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("benable_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("benable_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("penable_ent", Field.INTEGER, 0));
		dataset.fieldDef(new Field("penable_sal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("mode", Field.INTEGER, 0));
		;
		dataset.fieldDef(new Field("puerto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("puerto_tele", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_alim_lb_ent", Field.STRING, 20));
		dataset.fieldDef(new Field("tipo_alim_lb_sal", Field.STRING, 20));
		dataset.fieldDef(new Field("pedir_config", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("liberar_entrada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("liberar_salida", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("inter_nro_ent", Field.STRING, 20));
		dataset.fieldDef(new Field("inter_nro_sal", Field.STRING, 20));
		dataset.fieldDef(new Field("iniciar_tele", Field.BOOLEAN, 0));
		
		dataset.fieldDef(new Field("ingreso_cacheo", Field.STRING, 20));
		dataset.fieldDef(new Field("egreso_cacheo", Field.STRING, 20));
		
		dataset.fieldDef(new Field("entrada_sale_de", Field.INTEGER, 0));
		dataset.fieldDef(new Field("entrada_entra_a", Field.INTEGER, 0));
		dataset.fieldDef(new Field("salida_sale_de", Field.INTEGER, 0));
		dataset.fieldDef(new Field("salida_entra_a", Field.INTEGER, 0));
		dataset.fieldDef(new Field("antipassback_ent", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("antipassback_sal", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cacheo_ent", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cacheo_sal", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("reg_mov_ult_ent", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("reg_mov_ult_sal", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("act_avi_acc_den", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("restringir_ent", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("restringir_sal", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("restri_ent_vis", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("lib_ent_vis", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("lib_sal_vis", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("traga_tarj_sal", Field.BOOLEAN, 0));
		
		return dataset;
	}

	private void cargarRegistroPuerta(IDataSet dataset, Puerta puerta) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_puerta", puerta.getOIDInteger());
		dataset.fieldValue("codigo", puerta.getCodigo());
		dataset.fieldValue("descripcion", puerta.getDescripcion());
		dataset.fieldValue("activo", puerta.isActivo());
		dataset.fieldValue("acceso_al_predio", puerta.isIngresoAlPredio());
		dataset.fieldValue("egreso_del_predio", puerta.isEgresoDelPredio());
		dataset.fieldValue("IP", puerta.getIP());
		dataset.fieldValue("identif_puerta", puerta.getIdentifPuerta());
		dataset.fieldValue("tipo_medio_ent", puerta.getTipoMedioEntrada());
		dataset.fieldValue("identif_ent", puerta.getIdentifEntrada());
		dataset.fieldValue("identif_leg_ent", puerta.getIdentifLegEntrada());
		dataset.fieldValue("protocolo_ent", puerta.getProtocoloEntrada());
		dataset.fieldValue("modo_func_ent", puerta.getModoFuncEnt());
		dataset.fieldValue("tipo_medio_sal", puerta.getTipoMedioSal());
		dataset.fieldValue("identif_sal", puerta.getIdentifSal());
		dataset.fieldValue("identif_leg_sal", puerta.getIdentifLegSal());
		dataset.fieldValue("protocolo_sal", puerta.getProtocoloSalida());
		dataset.fieldValue("modo_func_sal", puerta.getModoFuncSal());

		dataset.fieldValue("modo_off_line_ent", puerta.getModoOFFLineEnt());
		dataset.fieldValue("modo_off_line_sal", puerta.getModoOFFLineSal());
		dataset.fieldValue("int_status_time", puerta.getIntervaloStatusTime());
		dataset.fieldValue("int_config_time", puerta.getIntervaloConfigTime());
		dataset.fieldValue("int_syncrotime", puerta.getIntervaloSyncroTime());
		dataset.fieldValue("hab_punto_acc_1", puerta.getHabilitarPuntoAcceso1());
		dataset.fieldValue("hab_punto_acc_2", puerta.getHabilitarPuntoAcceso2());
		dataset.fieldValue("ctimeout_ent", puerta.getCTimeOutEnt());
		dataset.fieldValue("ctimeout_sal", puerta.getCTimeOutSal());
		dataset.fieldValue("otimeout_ent", puerta.getOTimeOutEnt());
		dataset.fieldValue("otimeout_sal", puerta.getOTimeOutSal());
		dataset.fieldValue("alarmtime_ent", puerta.getAlarmTimeEnt());
		dataset.fieldValue("alarmtime_sal", puerta.getAlarmTimeSal());
		dataset.fieldValue("dir_pto_ent", puerta.getDirPtoEnt());
		dataset.fieldValue("dir_pto_sal", puerta.getDirPtoSal());
		dataset.fieldValue("tipo_punto_ent", puerta.getTipoPtoEnt());
		dataset.fieldValue("tipo_punto_sal", puerta.getTipoPtoSal());
		dataset.fieldValue("benable_ent", puerta.getBenableEnt());
		dataset.fieldValue("benable_sal", puerta.getBenableSal());
		dataset.fieldValue("penable_ent", puerta.getPenableEnt());
		dataset.fieldValue("penable_sal", puerta.getPenableSal());
		dataset.fieldValue("mode", puerta.getMode());
		dataset.fieldValue("puerto", puerta.getPuerto());
		dataset.fieldValue("puerto_tele", puerta.getTelePuerto());
		dataset.fieldValue("tipo_alim_lb_ent", puerta.getTipoAlimLBEnt());
		dataset.fieldValue("tipo_alim_lb_sal", puerta.getTipoAlimLBSal());
		dataset.fieldValue("pedir_config", puerta.isPideConfiguracion());
		dataset.fieldValue("liberar_entrada", puerta.isLiberarEntrada());
		dataset.fieldValue("liberar_salida", puerta.isLiberarSalida());
		dataset.fieldValue("inter_nro_ent", puerta.getInterpretarNroEnt());
		dataset.fieldValue("inter_nro_sal", puerta.getInterpretarNroSal());
		dataset.fieldValue("iniciar_tele", puerta.isIniciarTelecomando());
		dataset.fieldValue("ingreso_cacheo", puerta.getIngresoCacheo());
		dataset.fieldValue("egreso_cacheo", puerta.getEgresoCacheo());
		if (puerta.getEntradaSaleDe()!=null)
			dataset.fieldValue("entrada_sale_de", puerta.getEntradaSaleDe().getOIDInteger());
		else
			dataset.fieldValue("entrada_sale_de", "");
		if (puerta.getEntradaEntraA()!=null)
			dataset.fieldValue("entrada_entra_a", puerta.getEntradaEntraA().getOIDInteger());
		else
			dataset.fieldValue("entrada_entra_a", "");
		if (puerta.getSalidaSaleDe()!=null)
			dataset.fieldValue("salida_sale_de", puerta.getSalidaSaleDe().getOIDInteger());
		else
			dataset.fieldValue("salida_sale_de", "");
		if (puerta.getSalidaEntraA()!=null)
			dataset.fieldValue("salida_entra_a", puerta.getSalidaEntraA().getOIDInteger());
		else
			dataset.fieldValue("salida_entra_a", "");
		
		dataset.fieldValue("antipassback_ent", puerta.isControlAntiPassBackEnt());
		dataset.fieldValue("antipassback_sal", puerta.isControlAntiPassBackSal());
		
		dataset.fieldValue("cacheo_ent", puerta.isControlCacheoEnt());
		dataset.fieldValue("cacheo_sal", puerta.isControlCacheoSal());
		
		dataset.fieldValue("reg_mov_ult_ent", puerta.isRegMovUltEnt());
		dataset.fieldValue("reg_mov_ult_sal", puerta.isRegMovUltSal());
		dataset.fieldValue("act_avi_acc_den", puerta.isActAviAccDenegado());
		
		dataset.fieldValue("restringir_ent", puerta.isRentringirEnt());
		dataset.fieldValue("restringir_sal", puerta.isRentringirSal());
		
		dataset.fieldValue("restri_ent_vis", puerta.isRestringirEntVisita());
		dataset.fieldValue("lib_ent_vis", puerta.isLibEntradaVisita());
		dataset.fieldValue("lib_sal_vis", puerta.isLibSalidaVisita());
		dataset.fieldValue("traga_tarj_sal" ,   puerta.isTragaTarjAlSalir());
		
		
	}
	
	private void cargarAvisoUsuario(Puerta puerta,IDataSet dsAvisoUsu) throws BaseException {
		Iterator iterAviUsu = 
			puerta.getAvisosCacheoUsu().iterator();
		while (iterAviUsu.hasNext()) {
			AvisoCIPUsuario avisoCIPUsuario = (AvisoCIPUsuario) iterAviUsu.next();
			dsAvisoUsu.append();
			dsAvisoUsu.fieldValue("oid_avi_usu", avisoCIPUsuario.getOIDInteger());
			dsAvisoUsu.fieldValue("oid_usuario", avisoCIPUsuario.getUsuario().getOIDInteger());
			dsAvisoUsu.fieldValue("cod_usuario", avisoCIPUsuario.getUsuario().getLogin());
			dsAvisoUsu.fieldValue("desc_usuario", avisoCIPUsuario.getUsuario().getApellidoyNombre());
			dsAvisoUsu.fieldValue("oid_obj_neg", puerta.getOIDInteger());
			dsAvisoUsu.fieldValue("circuito", puerta.getCACHEO());
			dsAvisoUsu.fieldValue("activo", true);
			
		}
	}
	
	private void cargarAvisoGUsuario(Puerta puerta,IDataSet dsAvisoGUsu) throws BaseException {
		Iterator iterAviGUsu = 
			puerta.getAvisosCacheoGUsu().iterator();
		while (iterAviGUsu.hasNext()) {
			AvisoCIPGUsuario avisoCIPGUsuario = (AvisoCIPGUsuario) iterAviGUsu.next();
			dsAvisoGUsu.append();
			dsAvisoGUsu.fieldValue("oid_avi_gusu", avisoCIPGUsuario.getOIDInteger());
			dsAvisoGUsu.fieldValue("oid_grupo_usuario", avisoCIPGUsuario.getGrupo_usuario().getOIDInteger());
			dsAvisoGUsu.fieldValue("cod_grupo_usuario", avisoCIPGUsuario.getGrupo_usuario().getCodigo());
			dsAvisoGUsu.fieldValue("desc_grupo_usuario", avisoCIPGUsuario.getGrupo_usuario().getDescripcion());
			dsAvisoGUsu.fieldValue("oid_obj_neg", avisoCIPGUsuario.getOid_obj_neg());
			dsAvisoGUsu.fieldValue("circuito", puerta.getCACHEO());
			dsAvisoGUsu.fieldValue("activo", true);
		}		
	}
	
	private void cargarAvisoMaquina(Puerta puerta,IDataSet dsAvisoMaq) throws BaseException {

		Iterator iterAviMaq = 
			puerta.getAvisosCacheoMaq().iterator();
		while (iterAviMaq.hasNext()) {
			AvisoCIPMaquina avisoCIPMaquina = (AvisoCIPMaquina) iterAviMaq.next();
			dsAvisoMaq.append();
			dsAvisoMaq.fieldValue("oid_avi_maq", avisoCIPMaquina.getOIDInteger());
			dsAvisoMaq.fieldValue("oid_maquina", avisoCIPMaquina.getMaquina().getOIDInteger());
			dsAvisoMaq.fieldValue("cod_maquina", avisoCIPMaquina.getMaquina().getCodigo());
			dsAvisoMaq.fieldValue("desc_maquina", avisoCIPMaquina.getMaquina().getDescripcion());
			dsAvisoMaq.fieldValue("oid_obj_neg", avisoCIPMaquina.getOid_obj_neg());
			dsAvisoMaq.fieldValue("circuito", avisoCIPMaquina.getCircuito());
			dsAvisoMaq.fieldValue("activo", true);
			
		}		
		
	}
	
	private void cargarAvisoGMaquina(Puerta puerta,IDataSet dsAvisoGMaq) throws BaseException {

		Iterator iterAviGMaq = 
			puerta.getAvisosCacheoGMaq().iterator();
		while (iterAviGMaq.hasNext()) {
			AvisoCIPGMaquina avisoCIPGMaquina = (AvisoCIPGMaquina) iterAviGMaq.next();
			dsAvisoGMaq.append();
			dsAvisoGMaq.fieldValue("oid_avi_gmaq", avisoCIPGMaquina.getOIDInteger());
			dsAvisoGMaq.fieldValue("oid_grupo_maquina", avisoCIPGMaquina.getGrupo_maquina().getOIDInteger());
			dsAvisoGMaq.fieldValue("cod_grupo_maquina", avisoCIPGMaquina.getGrupo_maquina().getCodigo());
			dsAvisoGMaq.fieldValue("desc_grupo_maquina", avisoCIPGMaquina.getGrupo_maquina().getDescripcion());
			dsAvisoGMaq.fieldValue("oid_obj_neg", avisoCIPGMaquina.getOid_obj_neg());
			dsAvisoGMaq.fieldValue("circuito", avisoCIPGMaquina.getCircuito());
			dsAvisoGMaq.fieldValue("activo", true);
		}		
		
		
	}
	
	private void cargarAvisoUsuarioAD(Puerta puerta,IDataSet dsAvisoUsu) throws BaseException {
		Iterator iterAviUsu = 
			puerta.getAvisosCacheoUsuAD().iterator();
		while (iterAviUsu.hasNext()) {
			AvisoCIPUsuario avisoCIPUsuario = (AvisoCIPUsuario) iterAviUsu.next();
			dsAvisoUsu.append();
			dsAvisoUsu.fieldValue("oid_avi_usu", avisoCIPUsuario.getOIDInteger());
			dsAvisoUsu.fieldValue("oid_usuario", avisoCIPUsuario.getUsuario().getOIDInteger());
			dsAvisoUsu.fieldValue("cod_usuario", avisoCIPUsuario.getUsuario().getLogin());
			dsAvisoUsu.fieldValue("desc_usuario", avisoCIPUsuario.getUsuario().getApellidoyNombre());
			dsAvisoUsu.fieldValue("oid_obj_neg", puerta.getOIDInteger());
			dsAvisoUsu.fieldValue("circuito", puerta.getACCESO_DENEGADO());
			dsAvisoUsu.fieldValue("activo", true);
			
		}
	}
	
	private void cargarAvisoGUsuarioAD(Puerta puerta,IDataSet dsAvisoGUsu) throws BaseException {
		Iterator iterAviGUsu = 
			puerta.getAvisosCacheoGUsuAD().iterator();
		while (iterAviGUsu.hasNext()) {
			AvisoCIPGUsuario avisoCIPGUsuario = (AvisoCIPGUsuario) iterAviGUsu.next();
			dsAvisoGUsu.append();
			dsAvisoGUsu.fieldValue("oid_avi_gusu", avisoCIPGUsuario.getOIDInteger());
			dsAvisoGUsu.fieldValue("oid_grupo_usuario", avisoCIPGUsuario.getGrupo_usuario().getOIDInteger());
			dsAvisoGUsu.fieldValue("cod_grupo_usuario", avisoCIPGUsuario.getGrupo_usuario().getCodigo());
			dsAvisoGUsu.fieldValue("desc_grupo_usuario", avisoCIPGUsuario.getGrupo_usuario().getDescripcion());
			dsAvisoGUsu.fieldValue("oid_obj_neg", avisoCIPGUsuario.getOid_obj_neg());
			dsAvisoGUsu.fieldValue("circuito", puerta.getACCESO_DENEGADO());
			dsAvisoGUsu.fieldValue("activo", true);
		}		
	}
	
	private void cargarAvisoMaquinaAD(Puerta puerta,IDataSet dsAvisoMaq) throws BaseException {

		Iterator iterAviMaq = 
			puerta.getAvisosCacheoMaqAD().iterator();
		while (iterAviMaq.hasNext()) {
			AvisoCIPMaquina avisoCIPMaquina = (AvisoCIPMaquina) iterAviMaq.next();
			dsAvisoMaq.append();
			dsAvisoMaq.fieldValue("oid_avi_maq", avisoCIPMaquina.getOIDInteger());
			dsAvisoMaq.fieldValue("oid_maquina", avisoCIPMaquina.getMaquina().getOIDInteger());
			dsAvisoMaq.fieldValue("cod_maquina", avisoCIPMaquina.getMaquina().getCodigo());
			dsAvisoMaq.fieldValue("desc_maquina", avisoCIPMaquina.getMaquina().getDescripcion());
			dsAvisoMaq.fieldValue("oid_obj_neg", avisoCIPMaquina.getOid_obj_neg());
			dsAvisoMaq.fieldValue("circuito", avisoCIPMaquina.getCircuito());
			dsAvisoMaq.fieldValue("activo", true);
			
		}		
		
	}
	
	private void cargarAvisoGMaquinaAD(Puerta puerta,IDataSet dsAvisoGMaq) throws BaseException {

		Iterator iterAviGMaq = 
			puerta.getAvisosCacheoGMaqAD().iterator();
		while (iterAviGMaq.hasNext()) {
			AvisoCIPGMaquina avisoCIPGMaquina = (AvisoCIPGMaquina) iterAviGMaq.next();
			dsAvisoGMaq.append();
			dsAvisoGMaq.fieldValue("oid_avi_gmaq", avisoCIPGMaquina.getOIDInteger());
			dsAvisoGMaq.fieldValue("oid_grupo_maquina", avisoCIPGMaquina.getGrupo_maquina().getOIDInteger());
			dsAvisoGMaq.fieldValue("cod_grupo_maquina", avisoCIPGMaquina.getGrupo_maquina().getCodigo());
			dsAvisoGMaq.fieldValue("desc_grupo_maquina", avisoCIPGMaquina.getGrupo_maquina().getDescripcion());
			dsAvisoGMaq.fieldValue("oid_obj_neg", avisoCIPGMaquina.getOid_obj_neg());
			dsAvisoGMaq.fieldValue("circuito", avisoCIPGMaquina.getCircuito());
			dsAvisoGMaq.fieldValue("activo", true);
		}		
		
		
	}
	

}
