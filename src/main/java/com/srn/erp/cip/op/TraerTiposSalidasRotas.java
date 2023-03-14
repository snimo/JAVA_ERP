package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.TiposSalidasRotas;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposSalidasRotas extends Operation { 

  public TraerTiposSalidasRotas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDataSetTiposSalidas();
	  Iterator iterCodTiposSal = 
		  TiposSalidasRotas.getTiposSalidas().keySet().iterator();
	  while (iterCodTiposSal.hasNext()) {
		  String codigo = (String) iterCodTiposSal.next();
		  String descripcion = (String) TiposSalidasRotas.getTiposSalidas().get(codigo);
		  cargarRegistro(ds, codigo, descripcion);
	  }
	  writeCliente(ds);
	  
  }

  private IDataSet getDataSetTiposSalidas() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTiposSalidas");
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
		  						String codigo,
		  						String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
