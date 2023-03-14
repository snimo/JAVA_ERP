package com.srn.erp.cashflow.op;


import com.srn.erp.cashflow.bm.CtaBcoSaldoIniCF;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCtaBcoSaldoIniCF extends Operation { 

  public TraerCtaBcoSaldoIniCF() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    CtaBcoSaldoIniCF ctabcosaldoinicf = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       ctabcosaldoinicf = CtaBcoSaldoIniCF.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       ctabcosaldoinicf = CtaBcoSaldoIniCF.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetCtaBcoSaldoIniCF = getDataSetCtaBcoSaldoIniCF();
    if (ctabcosaldoinicf != null) { 
        cargarRegistroCtaBcoSaldoIniCF(datasetCtaBcoSaldoIniCF, 
                         ctabcosaldoinicf.getOIDInteger(),
                         ctabcosaldoinicf.getEscenariocf(),
                         ctabcosaldoinicf.getCuenta_bancaria(),
                         ctabcosaldoinicf.isActivo());
    }
    writeCliente(datasetCtaBcoSaldoIniCF);
  }

  private IDataSet getDataSetCtaBcoSaldoIniCF() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCtaBcoSaldoIniCF");
    dataset.fieldDef(new Field("oid_sal_ini_cta", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_escenario", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_cta_bancaria", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroCtaBcoSaldoIniCF(IDataSet dataset, 
                         Integer oid_sal_ini_cta,
                         EscenarioCashFlow oid_escenario,
                         CuentaBancaria oid_cta_bancaria,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_sal_ini_cta", oid_sal_ini_cta);
    dataset.fieldValue("oid_escenario", oid_escenario);
    dataset.fieldValue("oid_cta_bancaria", oid_cta_bancaria);
    dataset.fieldValue("activo", activo);
  }
}
