package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.TipoPeriodo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposPeriodos extends Operation { 

  public TraerTiposPeriodos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    
  	IDataSet dsTipoPeriodo = this.getDataSetTipoPeriodo();
  	
  	Iterator iterTipoPeriodos = TipoPeriodo.getAllTiposPediodos(this.getSesion()).iterator();
  	while (iterTipoPeriodos.hasNext()) {
  		TipoPeriodo tipoPeriodo = (TipoPeriodo) iterTipoPeriodos.next();
  		cargarRegistroTipoPeriodo(dsTipoPeriodo,tipoPeriodo);
  	}

    writeCliente(dsTipoPeriodo);
  }

  private IDataSet getDataSetTipoPeriodo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoPeriodo");
    dataset.fieldDef(new Field("oid_tipo_peri", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTipoPeriodo(IDataSet dataset, 
                         								 TipoPeriodo tipoPeriodo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_tipo_peri", tipoPeriodo.getOIDInteger());
    dataset.fieldValue("codigo", tipoPeriodo.getCodigo());
    dataset.fieldValue("descripcion", tipoPeriodo.getDescripcion());
    dataset.fieldValue("activo", tipoPeriodo.isActivo());
  }
}
