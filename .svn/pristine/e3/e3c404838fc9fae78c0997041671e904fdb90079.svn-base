package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerCompePotencial extends Operation { 

  public TraerCompePotencial() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    CompePotencial compepotencial = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       compepotencial = CompePotencial.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       compepotencial = CompePotencial.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCompePotencial = getDataSetCompePotencial();
    if (compepotencial != null) { 
        cargarRegistroCompePotencial(datasetCompePotencial, 
                         compepotencial.getOIDInteger(),
                         compepotencial.getCosigo(),
                         compepotencial.getDescripcion(),
                         compepotencial.isActivo());
    }
    writeCliente(datasetCompePotencial);
  }

  private IDataSet getDataSetCompePotencial() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCompePotencial");
    dataset.fieldDef(new Field("oid_compe_pot", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroCompePotencial(IDataSet dataset, 
                         Integer oid_compe_pot,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_compe_pot", oid_compe_pot);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
