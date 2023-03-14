package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveCtaBancoLiqTarj extends Operation { 

  public SaveCtaBancoLiqTarj() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCtaBancoLiqTarj"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        CtaBancoLiqTarj ctabancoliqtarj = CtaBancoLiqTarj.findByOid(dataset.getInteger("oid_cta_banco"),getSesion());
        ctabancoliqtarj.setOID(dataset.getInteger("oid_cta_banco"));
        ctabancoliqtarj.setCodigo(dataset.getString("codigo"));
        ctabancoliqtarj.setDescripcion(dataset.getString("descripcion"));
        ctabancoliqtarj.setCod_interfaz(dataset.getString("cod_interfaz"));
        ctabancoliqtarj.setActivo(dataset.getBoolean("activo"));
        ctabancoliqtarj.setEmpresa(EmpresaConciTar.findByOidProxy(dataset.getInteger("oid_empresa"), this.getSesion()));
        addTransaccion(ctabancoliqtarj);
        dataset.next();
    }
  }
  
}
