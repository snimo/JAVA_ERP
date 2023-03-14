package com.srn.erp.contabilidad.op;

import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.contabilidad.bm.CriterioSelCuenta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposCritSelCta extends Operation {

  public TraerTiposCritSelCta() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	int oid = 0;
    IDataSet dataset = getDataSetTiposCriterios();
    Hashtable criterios = CriterioSelCuenta.getTiposCriterios();
    Iterator iterCodigosCriterios = criterios.keySet().iterator();
    while (iterCodigosCriterios.hasNext()) {
    	++oid;
    	String codigo = (String) iterCodigosCriterios.next();
    	String descripcion = (String) criterios.get(codigo);
    	cargarRegistroEjercicio(dataset,new Integer(oid),codigo,descripcion);
    }
    writeCliente(dataset);
  }

  private IDataSet getDataSetTiposCriterios() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTiposCriterios");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroEjercicio(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }



}
