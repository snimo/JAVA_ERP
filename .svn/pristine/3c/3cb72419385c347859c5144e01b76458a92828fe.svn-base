package com.srn.erp.general.op;

import com.srn.erp.general.bm.Entidad;
import com.srn.erp.general.bm.Idioma;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerInicioValorEtiquetaIdioma extends Operation { 

  public TraerInicioValorEtiquetaIdioma() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	
  	Integer oidEntidad = mapaDatos.getInteger("oid");
  	Entidad entidad = Entidad.findByOid(oidEntidad,this.getSesion());
  	
  	
  	IDataSet ds = getDataSetCabEtiquetaIdioma();
  	cargarRegistro(ds,
  									entidad.getOIDInteger(),
  									entidad.getDescripcion(),
  									entidad.getNombre_nickname(),
  									null,
  									new Boolean(true)); 
  	writeCliente(ds);
  	
  	
  }

  private IDataSet getDataSetCabEtiquetaIdioma() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCabEtiquetaIdioma");
    dataset.fieldDef(new Field("oid_entidad", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("nickname", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_idioma", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         Integer oidEntidad,
                         String descripcion,
                         String nickName,
                         Idioma idioma,
                         Boolean activo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_entidad", oidEntidad);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("nickname", nickName);
    if (idioma!=null)
    	dataset.fieldValue("oid_idioma", idioma.getOIDInteger());
    else
    	dataset.fieldValue("oid_idioma", 0);
    dataset.fieldValue("activo", activo);
  }
  
}
