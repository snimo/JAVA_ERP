package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.ConceptoLiqTarjeta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCompoConcLiqTar extends Operation {

  public TraerCompoConcLiqTar() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet ds = this.getDataComportamientos();
    
    Iterator iterConc = 
    	ConceptoLiqTarjeta.getComportamientos().keySet().iterator();
    while (iterConc.hasNext()) {
    	String codigo = (String) iterConc.next();
    	String descripcion = (String)ConceptoLiqTarjeta.getComportamientos().get(codigo);
    	cargarRegistro(ds, codigo , descripcion);
    }
    
    writeCliente(ds);
  }

  private IDataSet getDataComportamientos() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComporConcLiqTar");
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistro(IDataSet ds,
                         String codigo,
                         String descripcion) throws BaseException {
    ds.append();
    ds.fieldValue("codigo", codigo);
    ds.fieldValue("descripcion", descripcion);
  }
}
