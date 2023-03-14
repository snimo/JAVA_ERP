package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.ObsGeneralesOC;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveObsGeneralesOC extends Operation { 

  public SaveObsGeneralesOC() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TObsGeneralesOC"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ObsGeneralesOC obsgeneralesoc = ObsGeneralesOC.findByOid(dataset.getInteger("oid_obs_gen_oc"),getSesion());
        obsgeneralesoc.setOID(dataset.getInteger("oid_obs_gen_oc"));
        obsgeneralesoc.setCodigo(dataset.getString("codigo"));
        obsgeneralesoc.setDescripcion(dataset.getString("descripcion"));
        obsgeneralesoc.setIncluir_en_oc(dataset.getBoolean("inc_en_oc"));
        obsgeneralesoc.setOrden(dataset.getInteger("orden"));
        obsgeneralesoc.setActivo(dataset.getBoolean("activo"));
        addTransaccion(obsgeneralesoc);
        dataset.next();
    }
  }
  
}
