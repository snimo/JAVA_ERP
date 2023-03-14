package com.srn.erp.excelReport.op;

import com.srn.erp.excelReport.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoReporteExcel extends Operation { 

  public SaveGrupoReporteExcel() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoReporteExcel"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoReporteExcel gruporeporteexcel = GrupoReporteExcel.findByOid(dataset.getInteger("oid_grupo_reporte"),getSesion());
        gruporeporteexcel.setOID(dataset.getInteger("oid_grupo_reporte"));
        gruporeporteexcel.setCodigo(dataset.getString("codigo"));
        gruporeporteexcel.setDescripcion(dataset.getString("descripcion"));
        gruporeporteexcel.setOrden(dataset.getInteger("orden"));
        gruporeporteexcel.setActivo(dataset.getBoolean("activo"));
        addTransaccion(gruporeporteexcel);
        dataset.next();
    }
  }
  
}
