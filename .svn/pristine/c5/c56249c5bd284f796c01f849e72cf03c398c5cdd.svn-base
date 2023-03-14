package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CotizacionProveedorCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveAdjudicarCotizProv extends Operation { 

  public SaveAdjudicarCotizProv() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCotizacionesProveedores"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CotizacionProveedorCab cotizProvCab =CotizacionProveedorCab.findByOid(dataset.getInteger("oid_cotiz_prov"),getSesion());
        cotizProvCab.adjudicar();
        addTransaccion(cotizProvCab);
        dataset.next();
    }
  }
  
}
