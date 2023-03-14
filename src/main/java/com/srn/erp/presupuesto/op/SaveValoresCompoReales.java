package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveValoresCompoReales extends Operation { 

  public SaveValoresCompoReales() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TValorCompoReal"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ValorCompoReal valorcomporeal = ValorCompoReal.findByOid(dataset.getInteger("oid_valor_real"),getSesion());
        valorcomporeal.setOID(dataset.getInteger("oid_valor_real"));
        valorcomporeal.setCodigo(dataset.getString("codigo"));
        valorcomporeal.setDescripcion(dataset.getString("descripcion"));
        valorcomporeal.setCompo_presu(CompoPresupuestario.findByOidProxy(dataset.getInteger("oid_compo_presu"),this.getSesion()));
        valorcomporeal.setActivo(dataset.getBoolean("activo"));
        valorcomporeal.setValorCompoPresu(ValorCompoPresu.findByOidProxy(dataset.getInteger("oid_valor_compo_presu"),this.getSesion()));
        if (valorcomporeal.isActivo().booleanValue()==false) valorcomporeal.delete();
        addTransaccion(valorcomporeal);
        dataset.next();
    }
  }
  
}
