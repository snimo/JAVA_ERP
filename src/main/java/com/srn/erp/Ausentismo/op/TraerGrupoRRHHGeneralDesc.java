package com.srn.erp.Ausentismo.op;

import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneral;
import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneralDesc;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoRRHHGeneralDesc extends Operation { 

  public TraerGrupoRRHHGeneralDesc() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoRRHHGeneralDesc gruporrhhgeneraldesc = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       gruporrhhgeneraldesc = GrupoRRHHGeneralDesc.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       gruporrhhgeneraldesc = GrupoRRHHGeneralDesc.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoRRHHGeneralDesc = getDataSetGrupoRRHHGeneralDesc();
    if (gruporrhhgeneraldesc != null) { 
        cargarRegistroGrupoRRHHGeneralDesc(datasetGrupoRRHHGeneralDesc, 
                         gruporrhhgeneraldesc.getOIDInteger(),
                         gruporrhhgeneraldesc.getGrupogral(),
                         gruporrhhgeneraldesc.getDescripcion(),
                         gruporrhhgeneraldesc.isActivo());
    }
    writeCliente(datasetGrupoRRHHGeneralDesc);
  }

  private IDataSet getDataSetGrupoRRHHGeneralDesc() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoRRHHGeneralDesc");
    dataset.fieldDef(new Field("oid_grupo_gral_desc", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_grupo_gral", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoRRHHGeneralDesc(IDataSet dataset, 
                         Integer oid_grupo_gral_desc,
                         GrupoRRHHGeneral oid_grupo_gral,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_gral_desc", oid_grupo_gral_desc);
    dataset.fieldValue("oid_grupo_gral", oid_grupo_gral);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
