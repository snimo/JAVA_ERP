package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveAgrupadorDeposito extends Operation { 

  public SaveAgrupadorDeposito() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TAgrupadorDeposito"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        AgrupadorDeposito agrupadordeposito = AgrupadorDeposito.findByOid(dataset.getInteger("oid_agrupador_depo"),getSesion());
        agrupadordeposito.setOID(dataset.getInteger("oid_agrupador_depo"));
        agrupadordeposito.setCodigo(dataset.getString("codigo"));
        agrupadordeposito.setDescripcion(dataset.getString("descripcion"));
        agrupadordeposito.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsAgrupadorDet = dataset.getDataSet("TAgrupadorDepositoDet");
        dsAgrupadorDet.first();
        while (!dsAgrupadorDet.EOF() ) {
          AgrupadorDepositoDet agrupadordepositodet = AgrupadorDepositoDet.findByOid(dsAgrupadorDet.getInteger("oid_agrupador_det"),getSesion());
          agrupadordepositodet.setOID(dsAgrupadorDet.getInteger("oid_agrupador_det"));
          agrupadordepositodet.setAgrupador_deposito(AgrupadorDeposito.findByOidProxy(dsAgrupadorDet.getInteger("oid_agrupador_depo"),this.getSesion()));
          agrupadordepositodet.setDeposito(Deposito.findByOidProxy(dsAgrupadorDet.getInteger("oid_deposito"),this.getSesion()));
          agrupadordepositodet.setActivo(dsAgrupadorDet.getBoolean("activo"));
          if (dsAgrupadorDet.getBoolean("activo").booleanValue()==false)
          	agrupadordepositodet.delete();	
          	
          
          agrupadordeposito.addAgrupadorDepositoDet(agrupadordepositodet);
          
        	dsAgrupadorDet.next();
        }
                
        
        addTransaccion(agrupadordeposito);
        dataset.next();
    }
  }
  
}
