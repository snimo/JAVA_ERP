package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.TipoUPC;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoUPC extends Operation { 

  public TraerTipoUPC() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    TipoUPC tipoupc = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       tipoupc = TipoUPC.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       tipoupc = TipoUPC.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetTipoUPC = getDataSetTipoUPC();
    if (tipoupc != null) 
        cargarRegistroTipoUPC(datasetTipoUPC,tipoupc);
    
    writeCliente(datasetTipoUPC);
  }

  private IDataSet getDataSetTipoUPC() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoUPC");
    dataset.fieldDef(new Field("oid_tipo_upc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoUPC(IDataSet dataset, 
                         TipoUPC tipoUPC) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_upc", tipoUPC.getOIDInteger());
    dataset.fieldValue("codigo", tipoUPC.getCodigo());
    dataset.fieldValue("descripcion", tipoUPC.getDescripcion());
    dataset.fieldValue("activo", tipoUPC.isActivo());
  }
}

