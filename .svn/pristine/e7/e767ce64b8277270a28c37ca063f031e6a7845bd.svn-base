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

public class TraerTitRepConta extends Operation {

  public TraerTitRepConta() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	IDataSet dsRepConTitCab = this.getDataSetTitCab();
    IDataSet dsRepConTitDet = this.getDataSetTitDet();
    
    Integer oidReporte = mapaDatos.getInteger("oid_reporte");
    ReporteContable reporteContable = ReporteContable.findByOidProxy(oidReporte, this.getSesion());
    
    cargarRegistroCab(dsRepConTitCab, reporteContable);
    Iterator iterTitulos = 
    	reporteContable.getSoloTitulosReporte().iterator();
    while (iterTitulos.hasNext()) {
    	ReporteContableDet reporteContableDet = (ReporteContableDet) iterTitulos.next();
    	cargarRegistroDet(dsRepConTitDet, reporteContableDet);
    }
    
    writeCliente(dsRepConTitCab);
    writeCliente(dsRepConTitDet);

  }


  private IDataSet getDataSetTitCab() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTituloCab");
    dataset.fieldDef(new Field("oid_reporte", Field.INTEGER, 0));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }
  
  private IDataSet getDataSetTitDet() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TTituloDet");
	    dataset.fieldDef(new Field("oid_rep_det", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_reporte", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
	    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_titu", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_titu_padre", Field.INTEGER, 0));
	    return dataset;
  }
  

  private void cargarRegistroCab(IDataSet dataset,
                         		 ReporteContable reporte) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_reporte", reporte.getOIDInteger());
    dataset.fieldValue("descripcion", reporte.getDescripcion());
  }

  private void cargarRegistroDet(IDataSet dataset,
		  						 ReporteContableDet reporteContaDet) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_rep_det", reporteContaDet.getOIDInteger());
	  dataset.fieldValue("oid_reporte", reporteContaDet.getReporteContable().getOIDInteger());
	  dataset.fieldValue("descripcion", reporteContaDet.getDescripcion());
	  dataset.fieldValue("orden", reporteContaDet.getOrden());
	  dataset.fieldValue("oid_titu", reporteContaDet.getOidtitulo());
	  dataset.fieldValue("oid_titu_padre", reporteContaDet.getOidtitulopadre());
	  
  }


}
