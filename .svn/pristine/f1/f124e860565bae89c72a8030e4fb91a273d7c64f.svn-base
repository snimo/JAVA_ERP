package com.srn.erp.general.op;

import com.srn.erp.general.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveValorEtiquetaIdioma extends Operation { 

  public SaveValorEtiquetaIdioma() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet dataset = mapaDatos.getDataSet("TCabEtiquetaIdioma");
  	dataset.first();
  	while (!dataset.EOF()) {
  		procesarRegistros(dataset.getDataSet("TValorEtiquetaIdioma"));
  		dataset.next();
  	}
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ValorEtiquetaIdioma valoretiquetaidioma = ValorEtiquetaIdioma.findByOid(dataset.getInteger("oid_val_eti_idioma"),getSesion());
        valoretiquetaidioma.setOID(dataset.getInteger("oid_val_eti_idioma"));
        valoretiquetaidioma.setEtiqueta_idioma((EtiquetaIdioma.findByOidProxy(dataset.getInteger("oid_eti_idioma"),this.getSesion())));
        valoretiquetaidioma.setDescripcion(dataset.getString("descripcion"));
        valoretiquetaidioma.setIdioma(Idioma.findByOidProxy(dataset.getInteger("oid_idioma"),this.getSesion()));
        valoretiquetaidioma.setActivo(dataset.getBoolean("activo"));
        addTransaccion(valoretiquetaidioma);
        dataset.next();
    }
  }
  
}
