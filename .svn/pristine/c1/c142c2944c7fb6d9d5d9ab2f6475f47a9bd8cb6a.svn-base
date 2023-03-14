package com.srn.erp.cashflow.op;

import com.srn.erp.cashflow.bm.GrupoConceptoCF;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoConceptoCF extends Operation { 

  public TraerGrupoConceptoCF() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoConceptoCF grupoconceptocf = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupoconceptocf = GrupoConceptoCF.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupoconceptocf = GrupoConceptoCF.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoConceptoCF = getDataSetGrupoConceptoCF();
    if (grupoconceptocf != null) { 
        cargarRegistroGrupoConceptoCF(datasetGrupoConceptoCF, grupoconceptocf);
    }
    writeCliente(datasetGrupoConceptoCF);
  }

  private IDataSet getDataSetGrupoConceptoCF() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoConceptoCF");
    dataset.fieldDef(new Field("oid_grupo_concepto", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    dataset.fieldDef(new Field("compor_grupo", Field.STRING, 20));
    return dataset;
  }

  private void cargarRegistroGrupoConceptoCF(IDataSet dataset,
		                 GrupoConceptoCF grupo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_concepto", grupo.getOIDInteger());
    dataset.fieldValue("codigo", grupo.getCodigo());
    dataset.fieldValue("descripcion", grupo.getDescripcion());
    dataset.fieldValue("activo", grupo.isActivo());
    dataset.fieldValue("orden", grupo.getOrden());
    dataset.fieldValue("compor_grupo", grupo.getComporGrupo());
  }
}
