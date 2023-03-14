package com.srn.erp.stock.op;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.stock.bm.ConfGenMasProd;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConfGenMasProd extends Operation { 

  public SaveConfGenMasProd() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TConfGenMasProd"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ConfGenMasProd confgenmasprod = ConfGenMasProd.findByOid(dataset.getInteger("oid_gen_masiva"),getSesion());
        confgenmasprod.setOID(dataset.getInteger("oid_gen_masiva"));
        confgenmasprod.setClasificador(ClasificadorEntidad.findByOid(dataset.getInteger("oid_clasificador"),this.getSesion()));
        confgenmasprod.setIncluir_codigo(dataset.getBoolean("incluir_codigo"));
        confgenmasprod.setOrden_codigo(dataset.getInteger("orden_codigo"));
        confgenmasprod.setPre_codigo(dataset.getString("pre_codigo"));
        confgenmasprod.setSuf_codigo(dataset.getString("suf_codigo"));
        confgenmasprod.setIncluir_desc(dataset.getBoolean("incluir_desc"));
        confgenmasprod.setOrden_desc(dataset.getInteger("orden_desc"));
        confgenmasprod.setPre_desc(dataset.getString("pre_desc"));
        confgenmasprod.setSuf_desc(dataset.getString("suf_desc"));
        confgenmasprod.setIncluir_sino(dataset.getBoolean("incluir_sino"));
        confgenmasprod.setOrden_sino(dataset.getInteger("orden_sino"));
        confgenmasprod.setPre_sino(dataset.getString("pre_sino"));
        confgenmasprod.setSuf_sino(dataset.getString("suf_sino"));
        confgenmasprod.setIncluir_barra(dataset.getBoolean("incluir_barra"));
        confgenmasprod.setOrden_barra(dataset.getInteger("orden_barra"));
        confgenmasprod.setPre_barra(dataset.getString("pre_barra"));
        confgenmasprod.setSuf_barra(dataset.getString("suf_barra"));
        addTransaccion(confgenmasprod);
        dataset.next();
    }
  }
  
}
