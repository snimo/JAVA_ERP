package com.srn.erp.presupuesto.op;


import java.util.Iterator;

import com.srn.erp.presupuesto.bm.Metrica;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposMetricas extends Operation { 

  public TraerTiposMetricas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

    IDataSet dsTipoMetrica = getDSMetrica();
    
    int secu = 1;
    Iterator iterTiposMet = Metrica.getTiposMetricas().keySet().iterator();
    while (iterTiposMet.hasNext()) {
    	String codigo = (String) iterTiposMet.next();
    	String descripcion = (String) Metrica.getTiposMetricas().get(codigo);
    	cargarRegistroTipoMetrica(dsTipoMetrica,new Integer(secu),codigo,descripcion);
    	++secu;
    }
    
    writeCliente(dsTipoMetrica);
  }

  private IDataSet getDSMetrica() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoMetrica");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    return dataset;
  }

  private void cargarRegistroTipoMetrica(IDataSet dataset, 
                         Integer secu,
                         String codigo,
                         String descripcion) {
    dataset.append(); 
    dataset.fieldValue("secu", secu);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
