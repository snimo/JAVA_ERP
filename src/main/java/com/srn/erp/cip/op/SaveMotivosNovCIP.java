package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveMotivosNovCIP extends Operation { 

  public SaveMotivosNovCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TMotivosNovCIP"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        MotivosNovCIP motivosnovcip = MotivosNovCIP.findByOid(dataset.getInteger("oid_motivo"),getSesion());

        motivosnovcip.setOID(dataset.getInteger("oid_motivo"));
        motivosnovcip.setCodigo(dataset.getString("codigo"));
        motivosnovcip.setDescripcion(dataset.getString("descripcion"));
        motivosnovcip.setActivo(dataset.getBoolean("activo"));
        motivosnovcip.setHabParaIngresos(dataset.getBoolean("hab_para_ingreso"));
        motivosnovcip.setHabParaEgresos(dataset.getBoolean("hab_para_egreso"));
        motivosnovcip.setCompoExtIngreso(dataset.getString("compo_ext_ing"));
        motivosnovcip.setCompoExtEgreso(dataset.getString("compo_ext_egr"));
        motivosnovcip.setMinEntAnt(dataset.getInteger("min_ent_ant"));
        motivosnovcip.setMinEntDes(dataset.getInteger("min_ent_des"));
        motivosnovcip.setAnulaRotaDelDia(dataset.getBoolean("anula_rota_del_dia"));
        motivosnovcip.setHoraDesdeIng(dataset.getString("hora_desde_ing")); 
        motivosnovcip.setHoraHastaIng(dataset.getString("hora_hasta_ing"));
        motivosnovcip.setHoraDesdeEgr(dataset.getString("hora_desde_egr")); 
        motivosnovcip.setHoraHastaEgr(dataset.getString("hora_hasta_egr"));
        
        IDataSet dsEquiv = dataset.getDataSet("TMotivosEquivCIP");
        dsEquiv.first();
        while (!dsEquiv.EOF()) {
        	MotivosEquivCIP motivosEquiv =
        		MotivosEquivCIP.findByOid(dsEquiv.getInteger("oid_mot_equiv"), this.getSesion());
        	motivosEquiv.setMotivo(motivosnovcip);
        	motivosEquiv.setCodigo_externo(dsEquiv.getString("codigo_externo"));
        	motivosEquiv.setActivo(dsEquiv.getBoolean("activo"));
        	motivosnovcip.addEquivalenciaMotivo(motivosEquiv);
        	if (!motivosnovcip.isActivo())
        		motivosnovcip.delete();
        	dsEquiv.next();
        }
        
        addTransaccion(motivosnovcip);
        dataset.next();
    }
  }
  
}
