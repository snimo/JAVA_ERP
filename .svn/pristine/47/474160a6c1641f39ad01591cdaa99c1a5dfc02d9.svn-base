package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluEstadoPostulante extends Operation { 

  public TraerRecluEstadoPostulante() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluEstadoPostulante recluestadopostulante = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       recluestadopostulante = RecluEstadoPostulante.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       recluestadopostulante = RecluEstadoPostulante.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluEstadoPostulante = getDataSetRecluEstadoPostulante();
    if (recluestadopostulante != null) { 
        cargarRegistroRecluEstadoPostulante(datasetRecluEstadoPostulante, 
                         recluestadopostulante.getOIDInteger(),
                         recluestadopostulante.getCodigo(),
                         recluestadopostulante.getDescripcion(),
                         recluestadopostulante.isActivo(),
                         recluestadopostulante.getColor(),
                         recluestadopostulante.isSeleccionado()
                         );
    }
    writeCliente(datasetRecluEstadoPostulante);
  }

  private IDataSet getDataSetRecluEstadoPostulante() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluEstadoPostulante");
    dataset.fieldDef(new Field("oid_estado_postu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("color", Field.INTEGER, 0));
    dataset.fieldDef(new Field("seleccionado", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroRecluEstadoPostulante(IDataSet dataset, 
                         Integer oid_estado_postu,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         Integer color,
                         Boolean seleccionado) {
    dataset.append(); 
    dataset.fieldValue("oid_estado_postu", oid_estado_postu);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("color", color);
    dataset.fieldValue("seleccionado", seleccionado);
  }
}
