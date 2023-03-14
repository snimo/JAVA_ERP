package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerTipoNariz extends Operation { 

  public TraerTipoNariz() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoNariz tiponariz = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tiponariz = TipoNariz.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tiponariz = TipoNariz.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoNariz = getDataSetTipoNariz();
    if (tiponariz != null)  
        cargarRegistroTipoNariz(datasetTipoNariz, tiponariz);
    
    writeCliente(datasetTipoNariz);
  }

  private IDataSet getDataSetTipoNariz() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoNariz");
    dataset.fieldDef(new Field("oid_tipo_nariz", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoNariz(IDataSet dataset, 
                         TipoNariz  tipoNariz) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_nariz", tipoNariz.getOIDInteger());
    dataset.fieldValue("codigo", tipoNariz.getCodigo());
    dataset.fieldValue("descripcion", tipoNariz.getDescripcion());
    dataset.fieldValue("activo", tipoNariz.isActivo());
  }
}
