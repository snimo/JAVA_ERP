package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.TipoUPC;
import com.srn.erp.presupuesto.bm.UPC;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerUPC extends Operation { 

  public TraerUPC() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	
  	if (mapaDatos.containsKey("NUEVO")) {
  		inicializarDatos(mapaDatos.getInteger("oid_upc"));
  		return; 
  	}
  	
  	int secu = 1;
    UPC upc = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       upc = UPC.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       upc = UPC.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetUPC = getDataSetUPC();
    IDataSet datasetTiposHabUPC = getDataSetTiposHabUPC();
    
    if (upc != null) {  
        cargarRegistroUPC(datasetUPC, 
                          upc);
        
        Iterator iterTipoUPC = TipoUPC.getAllActivos(this.getSesion()).iterator();
        while (iterTipoUPC.hasNext()) {
        	TipoUPC tipoUPC = (TipoUPC)iterTipoUPC.next();
        	boolean habilitado = tipoUPC.isActivadaForUPC(upc);
        	cargarRegistroTipoHabUPC(datasetTiposHabUPC,new Integer(++secu),upc,tipoUPC,habilitado);
        }
        
        
    }
    
    
    writeCliente(datasetUPC);
    writeCliente(datasetTiposHabUPC);
    
  }
  
  private void inicializarDatos(Integer oidUPC) throws BaseException {
  	
  	IDataSet ds = getDataSetTiposHabUPC();
  	int secu = 1;
  	
  	Iterator iterTipoUPC = TipoUPC.getAllActivos(this.getSesion()).iterator();
  	UPC upc = (UPC) UPC.getNew(UPC.NICKNAME,this.getSesion());
  	upc.setOID(oidUPC);
  	while (iterTipoUPC.hasNext()) {
  		TipoUPC  tipoUPC = (TipoUPC) iterTipoUPC.next();
  		cargarRegistroTipoHabUPC(ds,new Integer(secu),upc,tipoUPC,false);
  		++secu;
  	}
  	
  	writeCliente(ds);
  	
  }

  private IDataSet getDataSetUPC() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TUPC");
    dataset.fieldDef(new Field("oid_upc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  private IDataSet getDataSetTiposHabUPC() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTiposHabUPC");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_upc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_upc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_tipo_upc", Field.STRING, 255));
    dataset.fieldDef(new Field("habilitado",Field.BOOLEAN, 0));
    return dataset;
  }  

  private void cargarRegistroUPC(IDataSet dataset, 
                         UPC upc) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_upc", upc.getOIDInteger());
    dataset.fieldValue("codigo", upc.getCodigo());
    dataset.fieldValue("descripcion", upc.getDescripcion());
    dataset.fieldValue("activo", upc.isActivo());
  }
  
  private void cargarRegistroTipoHabUPC(IDataSet dataset, 
      Integer secu,
      UPC upc,
      TipoUPC tipoUPC,
      boolean habilitado) throws BaseException {
  	dataset.append(); 
  	dataset.fieldValue("secu", secu);
  	dataset.fieldValue("oid_upc", upc.getOIDInteger());
  	dataset.fieldValue("oid_tipo_upc", tipoUPC.getOIDInteger());
  	dataset.fieldValue("desc_tipo_upc", tipoUPC.getDescripcion());
  	dataset.fieldValue("habilitado", new Boolean(habilitado));
  }
  
  
}
