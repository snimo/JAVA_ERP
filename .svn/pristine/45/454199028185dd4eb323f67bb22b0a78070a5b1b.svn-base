package com.srn.erp.presupuesto.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.presupuesto.bm.PeriodoPresupuestario;
import com.srn.erp.presupuesto.bm.TipoPeriodo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPeriodoPresupuestario extends Operation { 

  public TraerPeriodoPresupuestario() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	
  	IDataSet dsPeriodos = this.getDataSetPeriodos(); 
  	IDataSet ds = mapaDatos.getDataSet("TTipoPeriodo");
  	ds.first();
  	while (!ds.EOF()) {
  		
  		TipoPeriodo tipoPeriodo   = TipoPeriodo.findByOid(ds.getInteger("oid_tipo_peri"),this.getSesion());
  		java.util.Date fechaDesde = ds.getDate("fecha_desde");
  		java.util.Date fechaHasta = ds.getDate("fecha_hasta");
  		
  		cargarRegistrosPeriodos(dsPeriodos,tipoPeriodo,fechaDesde,fechaHasta);
  		
  		ds.next();
  	}
  	
  	writeCliente(dsPeriodos);
  	
  	
  }
  
  private void cargarRegistrosPeriodos(IDataSet ds,
  		TipoPeriodo tipoPeriodo,
  		Date fechaDesde,
  		Date fechaHasta) throws BaseException {
  	
  	Iterator iterPeriodos = tipoPeriodo.getPeriodos(fechaDesde,fechaHasta).iterator();
  	while (iterPeriodos.hasNext()) {
  		PeriodoPresupuestario periodoPresupuestario = (PeriodoPresupuestario) iterPeriodos.next();
  		if (periodoPresupuestario.isActivo().booleanValue()==false) continue;
  		cargarRegistroPeriodo(ds,periodoPresupuestario);
  	}
  	
  }

  private IDataSet getDataSetPeriodos() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPeriodos");
    dataset.fieldDef(new Field("oid_peri", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid_tipo_peri", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("fec_desde", Field.DATE, 0)); 
    dataset.fieldDef(new Field("fec_hasta", Field.DATE, 0)); 
    return dataset;
  }

  private void cargarRegistroPeriodo(IDataSet dataset, 
                         PeriodoPresupuestario periodo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_peri", periodo.getOIDInteger());
    dataset.fieldValue("codigo", periodo.getCodigo());
    dataset.fieldValue("descripcion", periodo.getDescripcion());
    dataset.fieldValue("activo", periodo.isActivo());
    dataset.fieldValue("oid_tipo_peri", periodo.getTipo_periodo().getOIDInteger());
    dataset.fieldValue("fec_desde", periodo.getFec_desde());
    dataset.fieldValue("fec_hasta", periodo.getFec_hasta());
  }
}
