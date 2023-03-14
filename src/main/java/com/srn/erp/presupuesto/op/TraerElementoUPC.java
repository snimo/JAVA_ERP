package com.srn.erp.presupuesto.op;


import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerElementoUPC extends Operation { 

  public TraerElementoUPC() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    ElementoUPC elementoupc = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       elementoupc = ElementoUPC.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       elementoupc = ElementoUPC.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetElementoUPC = getDataSetElementoUPC();
    if (elementoupc != null)  
        cargarRegistroElementoUPC(datasetElementoUPC,elementoupc);
    
    writeCliente(datasetElementoUPC);
  }

  private IDataSet getDataSetElementoUPC() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TElementoUPC");
    dataset.fieldDef(new Field("oid_elemento_upc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("tipo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("nro_interno", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroElementoUPC(IDataSet dataset, 
                         								 ElementoUPC elementoUPC) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_elemento_upc", elementoUPC.getOIDInteger());
    dataset.fieldValue("codigo", elementoUPC.getCodigo());
    dataset.fieldValue("descripcion", elementoUPC.getDescripcion());
    dataset.fieldValue("tipo", elementoUPC.getTipo());
    dataset.fieldValue("nro_interno", elementoUPC.getNro_interno());
    dataset.fieldValue("activo", elementoUPC.isActivo());
    
  }
  
}
