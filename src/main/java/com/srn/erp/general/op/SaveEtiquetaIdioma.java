package com.srn.erp.general.op;

import com.srn.erp.general.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveEtiquetaIdioma extends Operation { 

  public SaveEtiquetaIdioma() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TCabEtiquetaIdioma");
    dataset.first();
    while (!dataset.EOF()) {
    	procesarEtiquetas(dataset.getDataSet("TEtiquetaIdioma"));
    	dataset.next();
    }
  } 

  private void procesarEtiquetas(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        EtiquetaIdioma etiquetaidioma = EtiquetaIdioma.findByOid(dataset.getInteger("oid_eti_idioma"),getSesion());
        etiquetaidioma.setOID(dataset.getInteger("oid_eti_idioma"));
        etiquetaidioma.setNickname(dataset.getString("nickname"));
        etiquetaidioma.setEtiqueta(dataset.getString("etiqueta"));
        etiquetaidioma.setActivo(dataset.getBoolean("activo"));
        etiquetaidioma.setDescripcion(dataset.getString("descripcion"));
        addTransaccion(etiquetaidioma);
        dataset.next();
    }
  }
  
}
