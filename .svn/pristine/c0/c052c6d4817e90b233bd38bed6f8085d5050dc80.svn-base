package com.srn.erp.tesoreria.op;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCuentaBancaria extends Operation {

  public TraerCuentaBancaria() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    CuentaBancaria cuentabancaria = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       cuentabancaria = CuentaBancaria.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       cuentabancaria = CuentaBancaria.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCuentaBancaria = getDataSetCuentaBancaria();
    if (cuentabancaria != null) {
        cargarRegistroCuentaBancaria(datasetCuentaBancaria,
                         cuentabancaria.getCodigo(),
                         cuentabancaria.getOIDInteger(),
                         cuentabancaria.getBanco(),
                         cuentabancaria.getNrocuenta(),
                         cuentabancaria.getDescripcion(),
                         cuentabancaria.isActivo(),
                         cuentabancaria.getCompo(),
                         cuentabancaria.getCuentaimputableAConciliar(),
                         cuentabancaria.getCuentaMovRealesBco(),
                         cuentabancaria.getMoneda(),
                         cuentabancaria.getClearingEnDias()
                         );
    }
    writeCliente(datasetCuentaBancaria);
  }

  private IDataSet getDataSetCuentaBancaria() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCuentaBancaria");
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("oid_cta_bancaria", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_banco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_banco", Field.STRING,30));
    dataset.fieldDef(new Field("desc_banco", Field.STRING,50));
    dataset.fieldDef(new Field("nro_cuenta", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("compo", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ai", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ai", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_ai_real", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ai_real", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ai_real", Field.STRING, 255));    
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("clearing_en_dias", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroCuentaBancaria(IDataSet dataset,
                         String codigo,
                         Integer oid_cta_bancaria,
                         Banco banco,
                         String nro_cuenta,
                         String descripcion,
                         Boolean activo,
                         String compo,
                         CuentaImputable cuentaImputable,
                         CuentaImputable cuentaImputableReal,
                         Moneda moneda,
                         Integer clearing) throws BaseException {
    dataset.append();
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("oid_cta_bancaria", oid_cta_bancaria);
    dataset.fieldValue("oid_banco", banco.getOIDInteger());
    dataset.fieldValue("cod_banco", banco.getCodigo());
    dataset.fieldValue("desc_banco", banco.getDescripcion());
    dataset.fieldValue("nro_cuenta", nro_cuenta);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("compo", compo);
    dataset.fieldValue("oid_ai", cuentaImputable.getOID());
    dataset.fieldValue("cod_ai", cuentaImputable.getCodigoCuentaMasCodigosValCompo());
    dataset.fieldValue("desc_ai", cuentaImputable.getDescCuentaMasDescValCompo());
    
    if (cuentaImputableReal!=null) {
    	dataset.fieldValue("oid_ai_real", cuentaImputableReal.getOID());
    	dataset.fieldValue("cod_ai_real", cuentaImputableReal.getCodigoCuentaMasCodigosValCompo());
    	dataset.fieldValue("desc_ai_real", cuentaImputableReal.getDescCuentaMasDescValCompo());
    } else {
    	dataset.fieldValue("oid_ai_real", "");
    	dataset.fieldValue("cod_ai_real", "");
    	dataset.fieldValue("desc_ai_real", "");    	
    }
    
    dataset.fieldValue("oid_moneda", moneda.getOIDInteger()); 
    dataset.fieldValue("clearing_en_dias", clearing);
  }
}
