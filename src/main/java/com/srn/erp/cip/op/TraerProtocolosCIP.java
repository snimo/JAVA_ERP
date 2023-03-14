package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.ProtocolosCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerProtocolosCIP extends Operation { 

  public TraerProtocolosCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDataSetProtocolosCIP();
	  Iterator iterProtocolos = 
		  ProtocolosCIP.getProtocolos().keySet().iterator();
	  while (iterProtocolos.hasNext()) {
		  String codigo = (String) iterProtocolos.next();
		  String descripcion = (String) ProtocolosCIP.getProtocolos().get(codigo);
		  cargarRegistro(ds, codigo, descripcion);
	  }
	  writeCliente(ds);
	  
  }

  private IDataSet getDataSetProtocolosCIP() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TProtocolosCIP");
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
