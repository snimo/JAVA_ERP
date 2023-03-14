package com.srn.erp.general.op;

import com.srn.erp.general.bm.Moneda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMonedasContabilidad extends Operation {

  public TraerMonedasContabilidad() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {    
    IDataSet datasetMoneda = getDataSetMonedasContables();
    cargarRegistroMonedaContable(datasetMoneda,new Integer(1),Moneda.getMonedaCursoLegal(getSesion()));
    cargarRegistroMonedaContable(datasetMoneda,new Integer(2),Moneda.getMonedaExt1(getSesion()));
    cargarRegistroMonedaContable(datasetMoneda,new Integer(3),Moneda.getMonedaExt2(getSesion()));    
    writeCliente(datasetMoneda);
  }

  private IDataSet getDataSetMonedasContables() {
    IDataSet dataset = new TDataSet();
    dataset.create("TMonedasContables");
    dataset.fieldDef(new Field("nro",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    
    return dataset;
  }

  private void cargarRegistroMonedaContable(IDataSet dataset,
		  				 Integer nro,
                         Moneda moneda) throws BaseException {
    dataset.append();
    dataset.fieldValue("nro",nro);
    dataset.fieldValue("oid_moneda", moneda.getOIDInteger());
    dataset.fieldValue("codigo", moneda.getCodigo());
    dataset.fieldValue("descripcion", moneda.getDescripcion());
  }
}
