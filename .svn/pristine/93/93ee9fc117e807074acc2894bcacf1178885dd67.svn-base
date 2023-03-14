package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveSubReparto extends Operation { 

  public SaveSubReparto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TSubReparto"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        SubReparto subreparto = SubReparto.findByOid(dataset.getInteger("oid_subreparto"),getSesion());
        subreparto.setOID(dataset.getInteger("oid_subreparto"));
        subreparto.setCodigo(dataset.getString("codigo"));
        subreparto.setDescripcion(dataset.getString("descripcion"));
        subreparto.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsSubRepDet = dataset.getDataSet("TSubRepartoDet");
        dsSubRepDet.first();
        while (!dsSubRepDet.EOF()) {
        	SubRepartoDet subRepartoDet = SubRepartoDet.findByOid(dsSubRepDet.getInteger("oid_sub_det"), this.getSesion());
        	subRepartoDet.setSecu(dsSubRepDet.getInteger("secu"));
        	subRepartoDet.setSubreparto(subreparto);
        	subRepartoDet.setFase(FaseSubReparto.findByOid(dsSubRepDet.getInteger("oid_fase"), this.getSesion()));
        	subRepartoDet.setActivo(dsSubRepDet.getBoolean("activo"));
        	if (!subRepartoDet.isActivo())
        		subRepartoDet.delete();
        	subreparto.addSubRepartoDet(subRepartoDet);
        	dsSubRepDet.next();
        }
        
        addTransaccion(subreparto);
        dataset.next();
    }
  }
  
}
