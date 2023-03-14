package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveBiometrico extends Operation { 

  public SaveBiometrico() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TBiometrico"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        Biometrico biometrico = Biometrico.findByOid(dataset.getInteger("oid_biometrico"),getSesion());
        biometrico.setCodigo(dataset.getString("codigo"));
        biometrico.setDescripcion(dataset.getString("descripcion"));
        biometrico.setIp(dataset.getString("ip"));
        biometrico.setPuerto(dataset.getInteger("puerto"));
        biometrico.setTipo_biometrico(dataset.getString("tipo_biometrico"));
        biometrico.setNro_biometrico(dataset.getInteger("nro_biometrico"));
        biometrico.setActivo(dataset.getBoolean("activo"));
        addTransaccion(biometrico);
        dataset.next();
    }
  }
  
}
