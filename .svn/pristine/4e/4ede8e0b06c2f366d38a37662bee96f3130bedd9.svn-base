package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCompeBusqAct;
import com.srn.erp.reclutamiento.bm.RecluCompetencias;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluCompeBusqAct extends Operation { 

  public SaveRecluCompeBusqAct() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluCompeBusqAct"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluCompeBusqAct reclucompebusqact = RecluCompeBusqAct.findByOid(dataset.getInteger("oid_comp_busq_act"),getSesion());
        reclucompebusqact.setOID(dataset.getInteger("oid_comp_busq_act"));
        reclucompebusqact.setCompetencia(RecluCompetencias.findByOidProxy(dataset.getInteger("oid_competencia"),this.getSesion()));
        reclucompebusqact.setBusqueda(RecluBusqueda.findByOidProxy(dataset.getInteger("oid_busqueda_act"),this.getSesion()));
        reclucompebusqact.setActivo(dataset.getBoolean("activo"));
        addTransaccion(reclucompebusqact);
        dataset.next();
    }
  }
  
}
