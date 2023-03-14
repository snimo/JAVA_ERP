package com.srn.erp.turnos.op;

import java.util.Iterator;

import com.srn.erp.turnos.bm.CategoriaSujetoTurno;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCategoriasSujetoTurno extends Operation { 

  public TraerCategoriasSujetoTurno() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet ds = this.getDataSetCateg();
    
    Iterator iterCodigos = CategoriaSujetoTurno.getCategorias().keySet().iterator();
    while (iterCodigos.hasNext()) {
    	String codigo = (String) iterCodigos.next();
    	String descripcion = (String) CategoriaSujetoTurno.getCategorias().get(codigo);
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
	dataset.create("TCompoCateg");
	dataset.fieldDef(new Field("codigo", Field.STRING, 20));
	dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
	return dataset;
  }
  
}
