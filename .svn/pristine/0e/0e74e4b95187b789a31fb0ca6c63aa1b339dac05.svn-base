package com.srn.erp.excelReport.op;

import com.srn.erp.excelReport.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerGrupoReporteExcel extends Operation { 

  public TraerGrupoReporteExcel() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoReporteExcel gruporeporteexcel = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       gruporeporteexcel = GrupoReporteExcel.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       gruporeporteexcel = GrupoReporteExcel.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoReporteExcel = getDataSetGrupoReporteExcel();
    if (gruporeporteexcel != null) { 
        cargarRegistroGrupoReporteExcel(datasetGrupoReporteExcel, 
                         gruporeporteexcel);
        
    }
    writeCliente(datasetGrupoReporteExcel);
  }

  private IDataSet getDataSetGrupoReporteExcel() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoReporteExcel");
    dataset.fieldDef(new Field("oid_grupo_reporte", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 30)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroGrupoReporteExcel(IDataSet dataset, 
                          GrupoReporteExcel grupo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_reporte", grupo.getOIDInteger());
    dataset.fieldValue("codigo", grupo.getCodigo());
    dataset.fieldValue("descripcion", grupo.getDescripcion());
    dataset.fieldValue("orden", grupo.getOrden());
    dataset.fieldValue("activo", grupo.isActivo());
  }
}
