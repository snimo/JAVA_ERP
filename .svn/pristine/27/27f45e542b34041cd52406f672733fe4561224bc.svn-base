package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.DocuRequeridaCIP;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.TarjetaRotaVisita;
import com.srn.erp.cip.bm.UtilCIP;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTarjetaCIP extends Operation {

	public TraerTarjetaCIP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		TarjetaCIP tarjetacip = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			tarjetacip = TarjetaCIP.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			tarjetacip = TarjetaCIP.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetTarjetaCIP = getDataSetTarjetaCIP();
		IDataSet dsDocuReque = this.getDataSetDocuReq();
		IDataSet dsRotaFecha = getDataSetRotaFecha();
		
		if (tarjetacip != null) {
			
			cargarRegistroTarjetaCIP(datasetTarjetaCIP, tarjetacip);
			Iterator iterDocuReque = 
				tarjetacip.getDocumentacionRequerida().iterator();
			while (iterDocuReque.hasNext()) {
				DocuRequeridaCIP docuReque = (DocuRequeridaCIP) iterDocuReque.next();
				cargarRegistroDocuRequ(dsDocuReque, docuReque);
			}
			
			Iterator iterTarjRotaVisita = 
				tarjetacip.getTarjetasRotaVisita(Fecha.getFechaDiaAnterior(UtilCIP.getFechaHoraActual(this.getSesion()))).iterator();
			while (iterTarjRotaVisita.hasNext()) {
				TarjetaRotaVisita tarjRotaVisita = (TarjetaRotaVisita) iterTarjRotaVisita.next();
				cargarRotaFecha(dsRotaFecha, tarjRotaVisita);
			}
			
			
		}
		
		writeCliente(datasetTarjetaCIP);
		writeCliente(dsDocuReque);
		writeCliente(dsRotaFecha);
		
	}

	private IDataSet getDataSetDocuReq() {
		IDataSet dataset = new TDataSet();
		dataset.create("TDocuReq");
		dataset.fieldDef(new Field("oid_tipo_docu_req", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tarjeta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_docu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private IDataSet getDataSetRotaFecha() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRotasFecha");
		dataset.fieldDef(new Field("oid_tarj_rot", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tarjeta",Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_rota", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_rota", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_rota", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}
	
	private void cargarRotaFecha(IDataSet dsFechaRota,TarjetaRotaVisita aTarjetaRotaFisica) throws BaseException {
		dsFechaRota.append();
		dsFechaRota.fieldValue("oid_tarj_rot", aTarjetaRotaFisica.getOIDInteger());
		dsFechaRota.fieldValue("oid_tarjeta",aTarjetaRotaFisica.getTarjeta().getOIDInteger());
		dsFechaRota.fieldValue("fecha", aTarjetaRotaFisica.getFecha());
		dsFechaRota.fieldValue("oid_rota", aTarjetaRotaFisica.getRota().getOIDInteger());
		dsFechaRota.fieldValue("cod_rota", aTarjetaRotaFisica.getRota().getCodigo());
		dsFechaRota.fieldValue("desc_rota", aTarjetaRotaFisica.getRota().getDescripcion());
		dsFechaRota.fieldValue("activo", aTarjetaRotaFisica.isActivo());
	}

	private IDataSet getDataSetTarjetaCIP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTarjetaCIP");
		dataset.fieldDef(new Field("oid_tarjeta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_tarjeta", Field.STRING, 10));
		dataset.fieldDef(new Field("nro_tarjeta", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_grupo_tar", Field.STRING, 0));
		dataset.fieldDef(new Field("tiene_vig", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("vig_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("vig_hasta", Field.DATE, 0));
		dataset.fieldDef(new Field("hora_desde", Field.STRING, 5));
		dataset.fieldDef(new Field("hora_hasta", Field.STRING, 5));
		dataset.fieldDef(new Field("asignada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("estado_tarjeta", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_mot_baj_tar", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_asig", Field.DATE, 0));
		dataset.fieldDef(new Field("hora_asig", Field.STRING, 5));
		dataset.fieldDef(new Field("visita", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_gru_p_ing_vi", Field.INTEGER, 0)); 
		dataset.fieldDef(new Field("cod_gru_p_ing_vi", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_gru_p_ing_vi", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_gru_p_egr_vi", Field.INTEGER, 0)); 
		dataset.fieldDef(new Field("cod_gru_p_egr_vi", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_gru_p_egr_vi", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_categ_acc_vis", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_categ_acc_vis", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_categ_acc_vis", Field.STRING, 100));
		dataset.fieldDef(new Field("tole_ing_vis_min", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_visita", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_planif_sem_vis", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_planif_sem_vis", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_planif_sem_vis", Field.STRING, 100));
		dataset.fieldDef(new Field("anti_passback", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("tar_asig_a", Field.STRING, 100));
		return dataset;
	}
	
	private void cargarRegistroDocuRequ(IDataSet dataset, DocuRequeridaCIP docuReque) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_tipo_docu_req", docuReque.getOIDInteger());
		dataset.fieldValue("oid_tarjeta", docuReque.getTarjeta().getOIDInteger());
		dataset.fieldValue("oid_tipo_docu", docuReque.getTipo_docu().getOIDInteger());
		dataset.fieldValue("activo", docuReque.isActivo());
	}
	

	private void cargarRegistroTarjetaCIP(IDataSet dataset, TarjetaCIP tarjeta) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_tarjeta", tarjeta.getOIDInteger());
		dataset.fieldValue("tipo_tarjeta", tarjeta.getTipo_tarjeta());
		dataset.fieldValue("nro_tarjeta", tarjeta.getNro_tarjeta());
		dataset.fieldValue("oid_grupo_tar", tarjeta.getGrupo_tarjeta().getOIDInteger());
		dataset.fieldValue("tiene_vig", tarjeta.isTiene_vig());
		dataset.fieldValue("vig_desde", tarjeta.getVig_desde());
		dataset.fieldValue("vig_hasta", tarjeta.getVig_hasta());
		dataset.fieldValue("hora_desde", tarjeta.getHora_desde());
		dataset.fieldValue("hora_hasta", tarjeta.getHora_hasta());
		dataset.fieldValue("asignada", tarjeta.isTarjetaAsignada());
		dataset.fieldValue("estado_tarjeta", tarjeta.getEstado_tarjeta());
		dataset.fieldValue("activo", tarjeta.isActivo());
		if (tarjeta.getMotivo_baja_tarjeta()!=null)
			dataset.fieldValue("oid_mot_baj_tar", tarjeta.getMotivo_baja_tarjeta().getOIDInteger());
		else
			dataset.fieldValue("oid_mot_baj_tar", "");
		if (tarjeta.getLegajo()!=null)
			dataset.fieldValue("oid_legajo", tarjeta.getLegajo().getOIDInteger());
		else
			dataset.fieldValue("oid_legajo", "");
		if (tarjeta.getVisita()!=null)
			dataset.fieldValue("oid_visita", tarjeta.getVisita().getOIDInteger());
		else
			dataset.fieldValue("oid_visita", "");
		if (tarjeta.getCliente()!=null)
			dataset.fieldValue("oid_cliente", tarjeta.getCliente().getOIDInteger());
		else
			dataset.fieldValue("oid_cliente", "");
		dataset.fieldValue("fec_asig", tarjeta.getFec_asig());
		dataset.fieldValue("hora_asig", tarjeta.getHora_asig());
		dataset.fieldValue("visita", tarjeta.isParaVisita());
		
		if (tarjeta.getGrupoPueAccVisita()!=null) {
			dataset.fieldValue("oid_gru_p_ing_vi", tarjeta.getGrupoPueAccVisita().getOIDInteger()); 
			dataset.fieldValue("cod_gru_p_ing_vi", tarjeta.getGrupoPueAccVisita().getCodigo());
			dataset.fieldValue("desc_gru_p_ing_vi", tarjeta.getGrupoPueAccVisita().getDescripcion());
		} else {
			dataset.fieldValue("oid_gru_p_ing_vi", ""); 
			dataset.fieldValue("cod_gru_p_ing_vi", "");
			dataset.fieldValue("desc_gru_p_ing_vi", "");
		}
		
		if (tarjeta.getGrupoPueEgrVisita()!=null) {
			dataset.fieldValue("oid_gru_p_egr_vi", tarjeta.getGrupoPueEgrVisita().getOIDInteger()); 
			dataset.fieldValue("cod_gru_p_egr_vi", tarjeta.getGrupoPueEgrVisita().getCodigo());
			dataset.fieldValue("desc_gru_p_egr_vi", tarjeta.getGrupoPueEgrVisita().getDescripcion());
		} else {
			dataset.fieldValue("oid_gru_p_egr_vi", ""); 
			dataset.fieldValue("cod_gru_p_egr_vi", "");
			dataset.fieldValue("desc_gru_p_egr_vi", "");
		}
		
		if (tarjeta.getCategAccesoVisita()!=null) {
			dataset.fieldValue("oid_categ_acc_vis", tarjeta.getCategAccesoVisita().getOIDInteger());
			dataset.fieldValue("cod_categ_acc_vis", tarjeta.getCategAccesoVisita().getCodigo());
			dataset.fieldValue("desc_categ_acc_vis", tarjeta.getCategAccesoVisita().getDescripcion());
		} else {
			dataset.fieldValue("oid_categ_acc_vis", "");
			dataset.fieldValue("cod_categ_acc_vis", "");
			dataset.fieldValue("desc_categ_acc_vis", "");
		}
		
		dataset.fieldValue("tole_ing_vis_min" , tarjeta.getToleranciaIngVisMin());
		dataset.fieldValue("tipo_visita", tarjeta.getTipoVisita());
		
		if (tarjeta.getPermisoSemanal()!=null) {
			dataset.fieldValue("oid_planif_sem_vis", tarjeta.getPermisoSemanal().getOIDInteger());
			dataset.fieldValue("cod_planif_sem_vis", tarjeta.getPermisoSemanal().getCodigo());
			dataset.fieldValue("desc_planif_sem_vis", tarjeta.getPermisoSemanal().getDescripcion());
		} else {
			dataset.fieldValue("oid_planif_sem_vis", "");
			dataset.fieldValue("cod_planif_sem_vis", "");
			dataset.fieldValue("desc_planif_sem_vis", "");
		}
		
		dataset.fieldValue("anti_passback" , tarjeta.isControlarAntiPassBack());
		dataset.fieldValue("tar_asig_a" ,  tarjeta.getNomyApeTarjAsig());
		
		
	}
}
