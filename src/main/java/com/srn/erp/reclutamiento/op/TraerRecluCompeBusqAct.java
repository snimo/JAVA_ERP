package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCompeBusqAct;
import com.srn.erp.reclutamiento.bm.RecluCompetencias;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluCompeBusqAct extends Operation { 

  public TraerRecluCompeBusqAct() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluCompeBusqAct reclucompebusqact = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reclucompebusqact = RecluCompeBusqAct.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reclucompebusqact = RecluCompeBusqAct.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluCompeBusqAct = getDataSetRecluCompeBusqAct();
    if (reclucompebusqact != null) { 
        cargarRegistroRecluCompeBusqAct(datasetRecluCompeBusqAct, 
                         reclucompebusqact.getOIDInteger(),
                         reclucompebusqact.getCompetencia(),
                         reclucompebusqact.getBusqueda(),
                         reclucompebusqact.isActivo());
    }
    writeCliente(datasetRecluCompeBusqAct);
  }

  private IDataSet getDataSetRecluCompeBusqAct() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluCompeBusqAct");
    dataset.fieldDef(new Field("oid_comp_busq_act", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_competencia", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluCompeBusqAct(IDataSet dataset, 
                         Integer oid_comp_busq_act,
                         RecluCompetencias oid_competencia,
                         RecluBusqueda oid_busqueda_act,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_comp_busq_act", oid_comp_busq_act);
    dataset.fieldValue("oid_competencia", oid_competencia);
    dataset.fieldValue("oid_busqueda_act", oid_busqueda_act);
    dataset.fieldValue("activo", activo);
  }
}
