package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Entidad;
import com.srn.erp.general.bm.EtiquetaIdioma;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEtiquetaIdioma extends Operation { 

  public TraerEtiquetaIdioma() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	Entidad entidad = Entidad.findByOid(mapaDatos.getInteger("oid"),this.getSesion());  	
  	String buscarPorNickName = entidad.getNombre_nickname();
  	
    IDataSet datasetCabEtiquetaIdioma = getDataSetCabEtiquetaIdioma();
    IDataSet datasetEtiquetaIdioma = getDataSetEtiquetaIdioma();
    
    cargarRegistroCabEtiquetaIdioma(datasetCabEtiquetaIdioma,
    		                            entidad.getOIDInteger(),
    		                            entidad.getDescripcion(),
    		                            buscarPorNickName,
    		                            entidad.isActivo());
    
    
  	Iterator iterEtiquetas = 
  		EtiquetaIdioma.getEtiquetasComprobante(buscarPorNickName,this.getSesion()).iterator();
  	while (iterEtiquetas.hasNext()) {
  		EtiquetaIdioma etiquetaIdioma = (EtiquetaIdioma) iterEtiquetas.next();

      cargarRegistroEtiquetaIdioma(datasetEtiquetaIdioma, 
      		etiquetaIdioma.getOIDInteger(),
      		etiquetaIdioma.getNickname(),
      		etiquetaIdioma.getEtiqueta(),
      		etiquetaIdioma.getDescripcion(),
      		etiquetaIdioma.isActivo());

  	}

    writeCliente(datasetCabEtiquetaIdioma);
    writeCliente(datasetEtiquetaIdioma);
  }

  
  private IDataSet getDataSetCabEtiquetaIdioma() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCabEtiquetaIdioma");
    dataset.fieldDef(new Field("oid_entidad", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("nickname", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }
  
  private void cargarRegistroCabEtiquetaIdioma(IDataSet dataset, 
      Integer oidEntidad,
      String descripcion,
      String nickname,
      Boolean activo) {
  	dataset.append(); 
  	dataset.fieldValue("oid_entidad", oidEntidad);
  	dataset.fieldValue("descripcion", descripcion);
  	dataset.fieldValue("nickname", nickname);
  	dataset.fieldValue("activo", activo);
  }
  
  
  
  private IDataSet getDataSetEtiquetaIdioma() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TEtiquetaIdioma");
    dataset.fieldDef(new Field("oid_eti_idioma", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nickname", Field.STRING, 50)); 
    dataset.fieldDef(new Field("etiqueta", Field.STRING, 100));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroEtiquetaIdioma(IDataSet dataset, 
                         Integer oid_eti_idioma,
                         String nickname,
                         String etiqueta,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_eti_idioma", oid_eti_idioma);
    dataset.fieldValue("nickname", nickname);
    dataset.fieldValue("etiqueta", etiqueta);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
  
}
