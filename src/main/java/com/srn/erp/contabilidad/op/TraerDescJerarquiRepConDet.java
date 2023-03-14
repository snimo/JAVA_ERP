package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.ReporteContableDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDescJerarquiRepConDet extends Operation {
	
  public TraerDescJerarquiRepConDet() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  ReporteContableDet reporteContableDet = ReporteContableDet.findByOid(mapaDatos.getInteger("oid_rep_det"), this.getSesion());
	  
	  IDataSet ds = this.getDataSetDescRepDet();
	  cargarRegistro(ds,reporteContableDet);
	  writeCliente(ds);
    
  }
  
  private IDataSet getDataSetDescRepDet() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TDescRepDet");
	    dataset.fieldDef(new Field("oid_rep_det", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
	    dataset.fieldDef(new Field("descripcion_jerarquia",Field.STRING, 1000));
	    return dataset;
  }
  
  private void cargarRegistro(IDataSet dataset,
                              ReporteContableDet reporteContableDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_rep_det", reporteContableDet.getOIDInteger());
    dataset.fieldValue("descripcion", reporteContableDet.getDescripcion());
    dataset.fieldValue("descripcion_jerarquia", reporteContableDet.getDescripcionJerarquia());
    
  }


}
