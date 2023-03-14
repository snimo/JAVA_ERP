package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.EtiquetaIdioma;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.ValorEtiquetaIdioma;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValorEtiquetaIdioma extends Operation { 

  public TraerValorEtiquetaIdioma() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	int oidNuevo = 0;
  	int secu = 0;
  	
  	String nickName = mapaDatos.getString("nickname");
  	Idioma idioma = Idioma.findByOid(mapaDatos.getInteger("oid_idioma"),this.getSesion());
  	
  	IDataSet datasetValorEtiquetaIdioma = getDataSetValorEtiquetaIdioma();
  	
  	Iterator iterEtiquetas = 
  		EtiquetaIdioma.getEtiquetasComprobante(nickName,this.getSesion()).iterator();
  	while (iterEtiquetas.hasNext()) {
  		EtiquetaIdioma etiquetaIdioma = (EtiquetaIdioma) iterEtiquetas.next();
  		ValorEtiquetaIdioma valorEtiquetaIdioma = 
  			ValorEtiquetaIdioma.getValorEtiquetaIdioma(etiquetaIdioma,idioma,this.getSesion());
  		
  		String descValor = null;
  		
  		if (valorEtiquetaIdioma== null) {
  			--oidNuevo;
  			secu = oidNuevo;
  			descValor = "";
  			
  		} else {
  			secu = valorEtiquetaIdioma.getOID();
  			descValor = valorEtiquetaIdioma.getDescripcion();
  		}
  		
      cargarRegistroValorEtiquetaIdioma(datasetValorEtiquetaIdioma, 
          new Integer(secu),
          etiquetaIdioma,
          descValor,
          idioma,
          new Boolean(true));
  		
  		
  	}
  	
    
    writeCliente(datasetValorEtiquetaIdioma);
  }

  private IDataSet getDataSetValorEtiquetaIdioma() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValorEtiquetaIdioma");
    dataset.fieldDef(new Field("oid_val_eti_idioma", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_eti_idioma", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_eti_idioma", Field.STRING, 100));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255)); 
    dataset.fieldDef(new Field("oid_idioma", Field.STRING, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroValorEtiquetaIdioma(IDataSet dataset, 
                         Integer oid_val_eti_idioma,
                         EtiquetaIdioma etiquetaIdioma,
                         String descripcion,
                         Idioma idioma,
                         Boolean activo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_val_eti_idioma", oid_val_eti_idioma);
    dataset.fieldValue("oid_eti_idioma", etiquetaIdioma.getOIDInteger());
    dataset.fieldValue("desc_eti_idioma", etiquetaIdioma.getDescripcion());
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_idioma", idioma.getOIDInteger());
    dataset.fieldValue("activo", activo);
  }
}
