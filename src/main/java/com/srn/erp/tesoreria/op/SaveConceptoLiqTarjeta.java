package com.srn.erp.tesoreria.op;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.tesoreria.bm.ConceptoLiqTarjeta;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveConceptoLiqTarjeta extends Operation { 

  public SaveConceptoLiqTarjeta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TConceptoLiqTarjeta"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ConceptoLiqTarjeta conceptoliqtarjeta = ConceptoLiqTarjeta.findByOid(dataset.getInteger("oid_conc_liq_tc"),getSesion());
        conceptoliqtarjeta.setOID(dataset.getInteger("oid_conc_liq_tc"));
        conceptoliqtarjeta.setCodigo(dataset.getString("codigo"));
        conceptoliqtarjeta.setDescripcion(dataset.getString("descripcion"));
        conceptoliqtarjeta.setCuenta(Cuenta.findByOidProxy(dataset.getInteger("oid_ana_con"),this.getSesion()));
        conceptoliqtarjeta.setComportamiento(dataset.getString("comportamiento"));
        conceptoliqtarjeta.setActivo(dataset.getBoolean("activo"));
        conceptoliqtarjeta.setTipoValor(TipoValor.findByOidProxy(dataset.getInteger("oid_tipo_valor"),this.getSesion()));
        addTransaccion(conceptoliqtarjeta);
        dataset.next();
    }
  }
  
}
