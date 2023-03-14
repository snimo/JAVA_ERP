package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.DocuRequeridaCIP;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.GrupoTarjeta;
import com.srn.erp.cip.bm.MotivoBajaTarjeta;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.TarjetaRotaVisita;
import com.srn.erp.cip.bm.TipoDocumentacionCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveTarjetaCIP extends Operation { 

  public SaveTarjetaCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTarjetaCIP"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TarjetaCIP tarjetacip = TarjetaCIP.findByOid(dataset.getInteger("oid_tarjeta"),getSesion());
        tarjetacip.setOID(dataset.getInteger("oid_tarjeta"));
        tarjetacip.setTipo_tarjeta(dataset.getString("tipo_tarjeta"));
        tarjetacip.setNro_tarjeta(dataset.getString("nro_tarjeta"));
        tarjetacip.setGrupo_tarjeta(GrupoTarjeta.findByOidProxy(dataset.getInteger("oid_grupo_tar"),this.getSesion()));
        tarjetacip.setTiene_vig(dataset.getBoolean("tiene_vig"));
        tarjetacip.setVig_desde(dataset.getDate("vig_desde"));
        tarjetacip.setVig_hasta(dataset.getDate("vig_hasta"));
        tarjetacip.setHora_desde(dataset.getString("hora_desde"));
        tarjetacip.setHora_hasta(dataset.getString("hora_hasta"));
        tarjetacip.setEstado_tarjeta(dataset.getString("estado_tarjeta"));
        tarjetacip.setActivo(dataset.getBoolean("activo"));
        tarjetacip.setMotivo_baja_tarjeta(MotivoBajaTarjeta.findByOidProxy(dataset.getInteger("oid_mot_baj_tar"),this.getSesion()));
        tarjetacip.setIsParaVisita(dataset.getBoolean("visita"));
        tarjetacip.setGrupoPueAccVisita(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_gru_p_ing_vi"),this.getSesion()));
        tarjetacip.setGrupoPueEgrVisita(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_gru_p_egr_vi"),this.getSesion()));
        tarjetacip.setCategAccesoVisita(CategAccesoCIP.findByOidProxy(dataset.getInteger("oid_categ_acc_vis"), this.getSesion()));
        tarjetacip.setToleranciaIngVisMin(dataset.getInteger("tole_ing_vis_min"));
        tarjetacip.setTipoVisita(dataset.getString("tipo_visita"));
        tarjetacip.setPermisoSemanal(PermisoSemanalCIP.findByOidProxy(dataset.getInteger("oid_planif_sem_vis"), this.getSesion()));
        tarjetacip.setControlarAntiPassBack(dataset.getBoolean("anti_passback"));
        
        
        IDataSet dsDocuRequ = dataset.getDataSet("TDocuReq");
        dsDocuRequ.first();
        while (!dsDocuRequ.EOF()) {
        	DocuRequeridaCIP docuRequeridaCIP = DocuRequeridaCIP.findByOid(dsDocuRequ.getInteger("oid_tipo_docu_req"), this.getSesion());
        	docuRequeridaCIP.setTarjeta(tarjetacip);
        	docuRequeridaCIP.setTipo_docu(TipoDocumentacionCIP.findByOidProxy(dsDocuRequ.getInteger("oid_tipo_docu"), this.getSesion()));
        	docuRequeridaCIP.setActivo(dsDocuRequ.getBoolean("activo"));
        	if (!docuRequeridaCIP.isActivo())
        		docuRequeridaCIP.delete();
        	tarjetacip.addDocuReque(docuRequeridaCIP);
        	dsDocuRequ.next();
        }
        
        IDataSet dsRotaFecha = dataset.getDataSet("TRotasFecha");
        dsRotaFecha.first();
        while (!dsRotaFecha.EOF()) {
        	TarjetaRotaVisita tarjetaRotaVisita = TarjetaRotaVisita.findByOid(dsRotaFecha.getInteger("oid_tarj_rot"), this.getSesion()); 
        	tarjetaRotaVisita.setTarjeta(TarjetaCIP.findByOidProxy(dsRotaFecha.getInteger("oid_tarjeta"), this.getSesion()));
        	tarjetaRotaVisita.setFecha(dsRotaFecha.getDate("fecha"));
        	tarjetaRotaVisita.setRota(Rota.findByOidProxy(dsRotaFecha.getInteger("oid_rota"), this.getSesion()));
        	tarjetaRotaVisita.setActivo(dsRotaFecha.getBoolean("activo"));
        	if (!tarjetaRotaVisita.isActivo())
        		tarjetaRotaVisita.delete();
        	tarjetacip.addRotaVisita(tarjetaRotaVisita);
        	dsRotaFecha.next();
        }
        
        
        addTransaccion(tarjetacip);
        dataset.next();
    }
  }
  
}
