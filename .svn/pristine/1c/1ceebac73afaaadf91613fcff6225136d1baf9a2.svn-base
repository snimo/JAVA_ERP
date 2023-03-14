package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerRecluConvenio extends Operation { 

  public TraerRecluConvenio() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluConvenio recluconvenio = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       recluconvenio = RecluConvenio.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       recluconvenio = RecluConvenio.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluConvenio = getDataSetRecluConvenio();
    if (recluconvenio != null) { 
        cargarRegistroRecluConvenio(datasetRecluConvenio, 
                         recluconvenio.getOIDInteger(),
                         recluconvenio.getCodigo(),
                         recluconvenio.getDescripcion(),
                         recluconvenio.isActivo());
    }
    writeCliente(datasetRecluConvenio);
  }

  private IDataSet getDataSetRecluConvenio() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluConvenio");
    dataset.fieldDef(new Field("oid_convenio", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluConvenio(IDataSet dataset, 
                         Integer oid_convenio,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_convenio", oid_convenio);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
