package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.TipoHabilitadoUPC;
import com.srn.erp.presupuesto.bm.TipoUPC;
import com.srn.erp.presupuesto.bm.UPC;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveUPC extends Operation { 

  public SaveUPC() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TUPC"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        UPC upc = UPC.findByOid(dataset.getInteger("oid_upc"),getSesion());
        upc.setOID(dataset.getInteger("oid_upc"));
        upc.setCodigo(dataset.getString("codigo"));
        upc.setDescripcion(dataset.getString("descripcion"));
        upc.setActivo(dataset.getBoolean("activo"));
        
        // Tipos Habilitados
        IDataSet dsTiposHabUPC = dataset.getDataSet("TTiposHabUPC");
        dsTiposHabUPC.first();
        while (!dsTiposHabUPC.EOF()) {
        	TipoUPC tipoUPC = 
        		TipoUPC.findByOid(dsTiposHabUPC.getInteger("oid_tipo_upc"),this.getSesion());
        	TipoHabilitadoUPC tipoHabUPC = 
        		TipoHabilitadoUPC.getTipoHabilitadoUPC(upc,tipoUPC,this.getSesion());
        	if (tipoHabUPC!=null) 
        		tipoHabUPC.setHabilitado(dsTiposHabUPC.getBoolean("habilitado"));
          else {
          	tipoHabUPC = (TipoHabilitadoUPC)TipoHabilitadoUPC.getNew(TipoHabilitadoUPC.NICKNAME,this.getSesion());
          	tipoHabUPC.setUpc(upc);
          	tipoHabUPC.setTipoupc(tipoUPC);
          	tipoHabUPC.setHabilitado(dsTiposHabUPC.getBoolean("habilitado"));
        	}
        	upc.addTipoUPCHabilitado(tipoHabUPC);
        	dsTiposHabUPC.next();
        }
        
        addTransaccion(upc);
        dataset.next();
    }
  }
  
}
