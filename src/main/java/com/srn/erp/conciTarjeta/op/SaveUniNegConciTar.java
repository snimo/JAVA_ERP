package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.EmpresaConciTar;
import com.srn.erp.conciTarjeta.bm.UniNegConciTar;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveUniNegConciTar extends Operation { 

  public SaveUniNegConciTar() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TUniNegConciTar"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        UniNegConciTar uninegconcitar = UniNegConciTar.findByOid(dataset.getInteger("oid_uni_neg"),getSesion());
        uninegconcitar.setOID(dataset.getInteger("oid_uni_neg"));
        uninegconcitar.setDescripcion(dataset.getString("descripcion"));
        uninegconcitar.setEmpresa(EmpresaConciTar.findByOidProxy(dataset.getInteger("oid_empresa"),this.getSesion()));
        uninegconcitar.setActivo(dataset.getBoolean("activo"));
        uninegconcitar.setCtaTarjetaACobrar(dataset.getString("acob_cta_tarj"));
        uninegconcitar.setCtaTarjetaACobrarC1(dataset.getString("acob_cta_tarj_c1"));
        uninegconcitar.setCtaTarjetaACobrarC2(dataset.getString("acob_cta_tarj_c2"));
        addTransaccion(uninegconcitar);
        dataset.next();
    }
  }
  
}
