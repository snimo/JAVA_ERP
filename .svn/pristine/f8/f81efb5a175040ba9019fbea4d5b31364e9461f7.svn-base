package com.srn.erp.conciTarjeta.op;

import com.srn.erp.conciTarjeta.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveTipoArchConciTar extends Operation { 

  public SaveTipoArchConciTar() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TTipoArchConciTar"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        TipoArchConciTar tipoarchconcitar = TipoArchConciTar.findByOid(dataset.getInteger("oid_tipo_archivo"),getSesion());
        tipoarchconcitar.setOID(dataset.getInteger("oid_tipo_archivo"));
        tipoarchconcitar.setCodigo(dataset.getString("codigo"));
        tipoarchconcitar.setDescripcion(dataset.getString("descripcion"));
        tipoarchconcitar.setComportamiento(dataset.getString("comportamiento"));
        tipoarchconcitar.setAnt_ult_folder_emp(dataset.getString("ant_ult_folder_emp"));
        tipoarchconcitar.setUlt_folder_tipo(dataset.getString("ult_folder_tipo"));
        tipoarchconcitar.setActivo(dataset.getBoolean("activo"));
        tipoarchconcitar.setCodArchImpTarj(dataset.getString("cod_arch_imp_tarj"));
        addTransaccion(tipoarchconcitar);
        dataset.next();
    }
  }
  
}
