package com.srn.erp.rrhh.op;

import com.srn.erp.cip.bm.Rota;
import com.srn.erp.rrhh.bm.*;

import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveGrabarConsRotasCab extends Operation { 

  public SaveGrabarConsRotasCab() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrabarConsRotasCab"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException {
	GrabarConsRotasCab grabarconsrotascab = null; 
    dataset.first(); 
      while (!dataset.EOF()) { 
        grabarconsrotascab = GrabarConsRotasCab.findByOid(dataset.getInteger("oid_grab_cons_rota"),getSesion());
        grabarconsrotascab.setOID(dataset.getInteger("oid_grab_cons_rota"));
        grabarconsrotascab.setDescripcion(dataset.getString("descripcion"));
        grabarconsrotascab.setFiltro(FiltroLegCab.findByOidProxy(dataset.getInteger("oid_filtro_cab"),this.getSesion()));
        grabarconsrotascab.setFec_desde(dataset.getDate("fec_desde"));
        grabarconsrotascab.setFec_hasta(dataset.getDate("fec_hasta"));
        grabarconsrotascab.setRota(Rota.findByOidProxy(dataset.getInteger("oid_rota"),this.getSesion()));
        grabarconsrotascab.setJuegos_sep_por_comas(dataset.getString("juegos_sep_por_comas"));
        grabarconsrotascab.setNo_most_si_franco(dataset.getBoolean("no_most_si_franco"));
        grabarconsrotascab.setUsuario(Usuario.findByOidProxy(dataset.getInteger("oid_usuario"),this.getSesion()));
        grabarconsrotascab.setFecha_grab(dataset.getDate("fecha_grab"));
        grabarconsrotascab.setHora_grab(dataset.getString("hora_grab"));
        grabarconsrotascab.setActivo(dataset.getBoolean("activo"));
        grabarconsrotascab.save();
        
        dataset.next();
    }
      
  }
  
  
}
