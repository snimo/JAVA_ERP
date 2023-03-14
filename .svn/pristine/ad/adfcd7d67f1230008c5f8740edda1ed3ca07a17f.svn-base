package com.srn.erp.presupuesto.op;


import com.srn.erp.presupuesto.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerGrupoRepositorioReal extends Operation { 

  public TraerGrupoRepositorioReal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoRepositorioReal gruporepositorioreal = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       gruporepositorioreal = GrupoRepositorioReal.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       gruporepositorioreal = GrupoRepositorioReal.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoRepositorioReal = getDataSetGrupoRepositorioReal();
    if (gruporepositorioreal != null) { 
        cargarRegistroGrupoRepositorioReal(datasetGrupoRepositorioReal, 
                         gruporepositorioreal.getOIDInteger(),
                         gruporepositorioreal.getCodigo(),
                         gruporepositorioreal.getDescripcion(),
                         gruporepositorioreal.isActivo());
    }
    writeCliente(datasetGrupoRepositorioReal);
  }

  private IDataSet getDataSetGrupoRepositorioReal() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoRepositorioReal");
    dataset.fieldDef(new Field("oid_grupo_repo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoRepositorioReal(IDataSet dataset, 
                         Integer oid_grupo_repo,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_repo", oid_grupo_repo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
