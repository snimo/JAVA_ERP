package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.contabilidad.bm.ReporteContableDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsultaPlanCtas extends Operation {

  public TraerConsultaPlanCtas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet dsPlanCtas = getDataSetDetPlanCtas();
    
    ReporteContable reporte = ReporteContable.findByOid(mapaDatos.getInteger("oid_reporte"), this.getSesion());
    
    Iterator iterItemsRepo = 
    	reporte.getItemsReporte().iterator();
    while (iterItemsRepo.hasNext()) {
    	ReporteContableDet reporteContaDet = (ReporteContableDet) iterItemsRepo.next();
    	cargarRegistroPlanCtas(dsPlanCtas, reporteContaDet);
    }
    
    writeCliente(dsPlanCtas);
  }
  

  private void cargarRegistroPlanCtas(
		  IDataSet ds,
		  ReporteContableDet reporteContaDet) throws BaseException {
  	ds.append();
  	ds.fieldValue("oid_titu", reporteContaDet.getOidtitulo());
  	ds.fieldValue("oid_titu_padre", reporteContaDet.getOidtitulopadre());
  	ds.fieldValue("descripcion", reporteContaDet.getDescripcion());
  	if (reporteContaDet.getCuenta()!=null) {
  		ds.fieldValue("es_patrimonial",reporteContaDet.getCuenta().isEspatrimonial());
  		ds.fieldValue("es_interna",reporteContaDet.getCuenta().isEsctainterna());
  		ds.fieldValue("subsistema",reporteContaDet.getCuenta().getSubsistema());
  		if (reporteContaDet.getCuenta().getEstructura()!=null)
  			ds.fieldValue("estructura",reporteContaDet.getCuenta().getEstructura().getDescripcion());
  		else
  			ds.fieldValue("estructura","");
  		if (reporteContaDet.getCuenta().getTipocambio()!=null)
  			ds.fieldValue("tipo_cambio",reporteContaDet.getCuenta().getTipocambio().getDescripcion());
  		else
  			ds.fieldValue("tipo_cambio","");
  		if (reporteContaDet.getCuenta().getIndice()!=null)
  			ds.fieldValue("indice",reporteContaDet.getCuenta().getIndice().getDescripcion());
  		else
  			ds.fieldValue("indice","");
  		ds.fieldValue("es_impuesto",reporteContaDet.getCuenta().esImpuesto());
  	} else {
  		ds.fieldValue("es_patrimonial","");
  		ds.fieldValue("es_interna","");
  		ds.fieldValue("subsistema","");
  		ds.fieldValue("estructura","");
  		ds.fieldValue("tipo_cambio","");
  		ds.fieldValue("indice","");
  		ds.fieldValue("es_impuesto","");
  	}
  	
  }

  private IDataSet getDataSetDetPlanCtas() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConsultaPlanCtas");
    dataset.fieldDef(new Field("oid_titu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_titu_padre", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("es_patrimonial",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_interna",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("subsistema",Field.STRING, 20));
    dataset.fieldDef(new Field("estructura",Field.STRING, 20));
    dataset.fieldDef(new Field("tipo_cambio",Field.STRING, 20));
    dataset.fieldDef(new Field("indice",Field.STRING, 20));
    dataset.fieldDef(new Field("es_impuesto",Field.STRING, 20));
    return dataset;
  }
  

}
