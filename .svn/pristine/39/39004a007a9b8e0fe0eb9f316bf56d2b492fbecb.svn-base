package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.RelacionSujetoTurno;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRelacionesSujetoTurno extends Operation { 

  public TraerRelacionesSujetoTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet ds = this.getDataSetCateg();
    
    Iterator iterCodigos = RelacionSujetoTurno.getRelaciones().keySet().iterator();
    while (iterCodigos.hasNext()) {
    	String codigo = (String) iterCodigos.next();
    	String descripcion = (String) RelacionSujetoTurno.getRelaciones().get(codigo);
    	cargarRegistro(ds, codigo, descripcion);
    }
    
    writeCliente(ds);
  }

  private void cargarRegistro(IDataSet dataset, 
                         String codigo,
                         String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
  
  private IDataSet getDataSetCateg() {
	IDataSet dataset = new TDataSet();
	dataset.create("TCompoRelacion");
	dataset.fieldDef(new Field("codigo", Field.STRING, 20));
	dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
	return dataset;
  }
  
}
