package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerSubGrupoCategAcceso extends Operation { 

  public TraerSubGrupoCategAcceso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    SubGrupoCategAcceso subgrupocategacceso = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       subgrupocategacceso = SubGrupoCategAcceso.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       subgrupocategacceso = SubGrupoCategAcceso.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetSubGrupoCategAcceso = getDataSetSubGrupoCategAcceso();
    if (subgrupocategacceso != null) { 
        cargarRegistroSubGrupoCategAcceso(datasetSubGrupoCategAcceso, 
                         subgrupocategacceso.getOIDInteger(),
                         subgrupocategacceso.getCodigo(),
                         subgrupocategacceso.getDescripcion(),
                         subgrupocategacceso.isActivo(),
                         subgrupocategacceso.getOrden(),
                         subgrupocategacceso.getGrupo_categoria());
    }
    writeCliente(datasetSubGrupoCategAcceso);
  }

  private IDataSet getDataSetSubGrupoCategAcceso() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TSubGrupoCategAcceso");
    dataset.fieldDef(new Field("oid_sub_grupo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_grupo_categ", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cod_grupo_categ", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_grupo_categ", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroSubGrupoCategAcceso(IDataSet dataset, 
                         Integer oid_sub_grupo,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         Integer orden,
                         GrupoCategAcceso grupo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_sub_grupo", oid_sub_grupo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("orden", orden);
    dataset.fieldValue("oid_grupo_categ", grupo.getOIDInteger());
    dataset.fieldValue("cod_grupo_categ", grupo.getCodigo());
    dataset.fieldValue("desc_grupo_categ", grupo.getDescripcion());
     
  }
}
