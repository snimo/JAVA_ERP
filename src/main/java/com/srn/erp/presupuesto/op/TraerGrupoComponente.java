package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.GrupoComponente;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoComponente extends Operation { 

  public TraerGrupoComponente() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoComponente grupocomponente = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupocomponente = GrupoComponente.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupocomponente = GrupoComponente.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoComponente = getDataSetGrupoComponente();
    if (grupocomponente != null) { 
        cargarRegistroGrupoComponente(datasetGrupoComponente, 
                         grupocomponente.getOIDInteger(),
                         grupocomponente.getCodigo(),
                         grupocomponente.getDescripcion(),
                         grupocomponente.isActivo());
    }
    writeCliente(datasetGrupoComponente);
  }

  private IDataSet getDataSetGrupoComponente() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoComponente");
    dataset.fieldDef(new Field("oid_grupo_compo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 30)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoComponente(IDataSet dataset, 
                         Integer oid_grupo_compo,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_compo", oid_grupo_compo);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
