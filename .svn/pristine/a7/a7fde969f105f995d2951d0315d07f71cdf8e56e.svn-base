package com.srn.erp.general.op;

import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValorClasif extends Operation {

	private String tableName;
	
  public TraerValorClasif() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	
  	ValorClasificadorEntidad valClasifEnt = 
  		ValorClasificadorEntidad.findByOidProxy(mapaDatos.getInteger("oid_val_clasif"),this.getSesion());

  	tableName = mapaDatos.getString("tableName");
    IDataSet ds = getDataSet();
    cargarRegistro(ds,valClasifEnt);
    writeCliente(ds);
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create(tableName);
    dataset.fieldDef(new Field("oid_val_clasif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_clasif", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         ValorClasificadorEntidad valor) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_val_clasif", valor.getOIDInteger());
    dataset.fieldValue("codigo", valor.getCodigo());
    dataset.fieldValue("descripcion", valor.getDescripcion());
    dataset.fieldValue("oid_clasif", valor.getClasificador_entidad().getOIDInteger());
  }

}
