package com.srn.erp.tesoreria.op;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.tesoreria.bm.CuentaSistemaBanco;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCuentaSistemaBanco extends Operation { 

  public SaveCuentaSistemaBanco() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCuentaSistemaBanco"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CuentaSistemaBanco cuentasistemabanco = CuentaSistemaBanco.findByOid(dataset.getInteger("oid_cta_hab_bco"),getSesion());
        cuentasistemabanco.setOID(dataset.getInteger("oid_cta_hab_bco"));
        cuentasistemabanco.setCuenta(CuentaImputable.findByOidProxy(dataset.getInteger("oid_ai"),this.getSesion()));
        cuentasistemabanco.setActivo(dataset.getBoolean("activo"));
        addTransaccion(cuentasistemabanco);
        dataset.next();
    }
  }
  
}
