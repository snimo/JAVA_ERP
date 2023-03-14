package com.srn.erp.mensajero.op;

import com.srn.erp.mensajero.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerImagen extends Operation { 

  public TraerImagen() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    Imagen imagen = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       imagen = Imagen.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       imagen = Imagen.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetImagen = getDataSetImagen();
    if (imagen != null)  
        cargarRegistroImagen(datasetImagen,imagen);
    writeCliente(datasetImagen);
  }

  private IDataSet getDataSetImagen() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TImagen");
    dataset.fieldDef(new Field("oid_imagen", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroImagen(IDataSet dataset, Imagen imagen) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_imagen", imagen.getOIDInteger());
    dataset.fieldValue("codigo", imagen.getCodigo());
    dataset.fieldValue("descripcion", imagen.getDescripcion());
    dataset.fieldValue("activo", imagen.isActivo());
  }
}
