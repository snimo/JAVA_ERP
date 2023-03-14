package com.srn.erp.crm.op;

import com.srn.erp.crm.bm.EstadoCampania;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadoCampania extends Operation { 

  public TraerEstadoCampania() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    EstadoCampania estadocampania = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       estadocampania = EstadoCampania.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       estadocampania = EstadoCampania.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetEstadoCampania = getDataSetEstadoCampania();
    if (estadocampania != null) { 
        cargarRegistroEstadoCampania(datasetEstadoCampania, 
                         estadocampania.getCodigo(),
                         estadocampania.getDescripcion(),
                         estadocampania.isActivo(),
                         estadocampania.getComportamiento(),
                         estadocampania.getOIDInteger());
    }
    writeCliente(datasetEstadoCampania);
  }

  private IDataSet getDataSetEstadoCampania() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEstadoCampania");
    dataset.fieldDef(new Field("oid_estado_camp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));      
    dataset.fieldDef(new Field("compo_est_camp", Field.STRING, 20));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
     
    return dataset;
  }

  private void cargarRegistroEstadoCampania(IDataSet dataset, 
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         String compo_est_camp,
                         Integer oid_estado_camp) {
    dataset.append();
    dataset.fieldValue("compo_est_camp", compo_est_camp);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_estado_camp", oid_estado_camp);
    dataset.fieldValue("activo", activo);        
  }
}
