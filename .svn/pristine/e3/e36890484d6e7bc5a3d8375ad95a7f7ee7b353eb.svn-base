package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.TipoOrientacionPapel;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposOrientacionPapel extends Operation {

  public TraerTiposOrientacionPapel() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    int secu = 0;
    IDataSet dsOrientacion = getDataSetTiposOrientacion();
  	Iterator iterTipos = TipoOrientacionPapel.getTipos().keySet().iterator();
  	while (iterTipos.hasNext()) {
  		String codigo      = (String) iterTipos.next();
  		String descripcion = (String) TipoOrientacionPapel.getTipos().get(codigo);
  		Integer oid        = new Integer(++secu);
  		cargarRegistroTipoOrientacion(dsOrientacion,oid,codigo,descripcion);
  	}
    writeCliente(dsOrientacion);
  }

  private IDataSet getDataSetTiposOrientacion() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposOrientacionPapel");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroTipoOrientacion(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    
  }
}
