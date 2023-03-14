package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveCabModeloLiq extends Operation { 

  public SaveCabModeloLiq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCabModeloLiq"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CabModeloLiq cabmodeloliq = CabModeloLiq.findByOid(dataset.getInteger("oid_modelo_liq"),getSesion());
        cabmodeloliq.setOID(dataset.getInteger("oid_modelo_liq"));
        cabmodeloliq.setCodigo(dataset.getString("codigo"));
        cabmodeloliq.setDescripcion(dataset.getString("descripcion"));
        cabmodeloliq.setActivo(dataset.getBoolean("activo"));
        cabmodeloliq.setComenAsiento(dataset.getString("comen_asiento"));
        
        IDataSet dsDet = dataset.getDataSet("TDetModeloLiq");
        dsDet.first();
        while (!dsDet.EOF()) {
        	DetModeloLiq detModeloLiq =
        		DetModeloLiq.findByOid(dsDet.getInteger("oid_modelo_det"), this.getSesion());
        	detModeloLiq.setModelo(cabmodeloliq);
        	detModeloLiq.setOrden(dsDet.getInteger("orden"));
        	detModeloLiq.setCuenta(dsDet.getString("cuenta"));
        	detModeloLiq.setDesc_cuenta(dsDet.getString("desc_cuenta"));
        	detModeloLiq.setCompo1(dsDet.getString("compo1"));
        	detModeloLiq.setCompo2(dsDet.getString("compo2"));
        	detModeloLiq.setDebe(dsDet.getDouble("debe"));
        	detModeloLiq.setHaber(dsDet.getDouble("haber"));
        	detModeloLiq.setActivo(dsDet.getBoolean("activo"));
        	detModeloLiq.setCodImpuesto(dsDet.getString("cod_impuesto"));
        	detModeloLiq.setPorcImp(dsDet.getMoney("porc_imp"));
        	
        	detModeloLiq.setModelo(CabModeloLiq.findByOidProxy(dsDet.getInteger("oid_modelo_liq"), this.getSesion()));
        	
        	if (!detModeloLiq.isActivo())
        		detModeloLiq.delete();
        	
        	cabmodeloliq.addRenglonCuenta(detModeloLiq);
        	
        	dsDet.next();	
        }
        
        
        addTransaccion(cabmodeloliq);
        dataset.next();
    }
  }
  
}
