package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.TarjetaCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposVisitas extends Operation { 

  public TraerTiposVisitas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  IDataSet dsTipoVisita = this.getDataSetTipoVisita();
	  Iterator iterTiposVis = 
		  TarjetaCIP.getTiposVisitas().keySet().iterator();
	  while (iterTiposVis.hasNext()) {
		  String codigo = (String) iterTiposVis.next();
		  String descripcion = (String) TarjetaCIP.getTiposVisitas().get(codigo);
		  cargarRegistroTipoVisita(dsTipoVisita, codigo, descripcion);
	  }
	  writeCliente(dsTipoVisita);
  }

  private IDataSet getDataSetTipoVisita() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoVisita");
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.BOOLEAN, 100)); 
    return dataset;
  }

  private void cargarRegistroTipoVisita(
		  				 IDataSet dataset, 
                         String codigo,
                         String descripcion) {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
