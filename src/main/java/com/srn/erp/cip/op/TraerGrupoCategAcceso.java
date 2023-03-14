package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerGrupoCategAcceso extends Operation { 

  public TraerGrupoCategAcceso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoCategAcceso grupocategacceso = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupocategacceso = GrupoCategAcceso.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupocategacceso = GrupoCategAcceso.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoCategAcceso = getDataSetGrupoCategAcceso();
    if (grupocategacceso != null) { 
        cargarRegistroGrupoCategAcceso(datasetGrupoCategAcceso, 
                         grupocategacceso.getOIDInteger(),
                         grupocategacceso.getCodigo(),
                         grupocategacceso.getDescripcion(),
                         grupocategacceso.isActivo(),
                         grupocategacceso.getOrden());
    }
    writeCliente(datasetGrupoCategAcceso);
  }

  private IDataSet getDataSetGrupoCategAcceso() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoCategAcceso");
    dataset.fieldDef(new Field("oid_grupo_categ", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoCategAcceso(IDataSet dataset, 
                         Integer oid_grupo_categ,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         Integer orden) {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_categ", oid_grupo_categ);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("orden", orden);
  }
}
