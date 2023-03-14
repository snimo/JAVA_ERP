package com.srn.erp.cashflow.op;

import com.srn.erp.cashflow.bm.CtaBcoSaldoIniCF;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCtaBcoSaldoIniCF extends Operation { 

  public SaveCtaBcoSaldoIniCF() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCtaBcoSaldoIniCF"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CtaBcoSaldoIniCF ctabcosaldoinicf = CtaBcoSaldoIniCF.findByOid(dataset.getInteger("oid_sal_ini_cta"),getSesion());
        ctabcosaldoinicf.setOID(dataset.getInteger("oid_sal_ini_cta"));
        ctabcosaldoinicf.setEscenariocf(EscenarioCashFlow.findByOidProxy(dataset.getInteger("oid_escenario"),this.getSesion()));
        ctabcosaldoinicf.setCuenta_bancaria(CuentaBancaria.findByOidProxy(dataset.getInteger("oid_cta_bancaria"),this.getSesion()));
        ctabcosaldoinicf.setActivo(dataset.getBoolean("activo"));
        addTransaccion(ctabcosaldoinicf);
        dataset.next();
    }
  }
  
}
