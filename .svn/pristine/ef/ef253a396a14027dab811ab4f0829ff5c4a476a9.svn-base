package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluGrupoCompe;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluGrupoCompe extends Operation { 

  public TraerRecluGrupoCompe() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluGrupoCompe reclugrupocompe = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reclugrupocompe = RecluGrupoCompe.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reclugrupocompe = RecluGrupoCompe.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluGrupoCompe = getDataSetRecluGrupoCompe();
    if (reclugrupocompe != null) { 
        cargarRegistroRecluGrupoCompe(datasetRecluGrupoCompe, 
                         reclugrupocompe.getOIDInteger(),
                         reclugrupocompe.getCodigo(),
                         reclugrupocompe.getDescripcion(),
                         reclugrupocompe.isActivo());
    }
    writeCliente(datasetRecluGrupoCompe);
  }

  private IDataSet getDataSetRecluGrupoCompe() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluGrupoCompe");
    dataset.fieldDef(new Field("oid_grupo_compe", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluGrupoCompe(IDataSet dataset, 
                         Integer oid_grupo_compe,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_compe", oid_grupo_compe);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
