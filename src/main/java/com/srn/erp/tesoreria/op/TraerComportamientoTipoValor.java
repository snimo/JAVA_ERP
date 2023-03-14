package com.srn.erp.tesoreria.op;

import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComportamientoTipoValor extends Operation {

  public TraerComportamientoTipoValor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    TipoValor tipoValor = null;
    if (mapaDatos.containsKey("oid_tipo_valor")) {
       Integer oid = mapaDatos.getInteger("oid_tipo_valor");
       tipoValor = TipoValor.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       tipoValor = TipoValor.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetComportammiento = getDataSetComportamiento();
    if (tipoValor != null) {
        cargarRegistroComportamiento(datasetComportammiento,tipoValor);
    }
    writeCliente(datasetComportammiento);
  }

  private IDataSet getDataSetComportamiento() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComportamientoTV");
    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroComportamiento(IDataSet dataset,
                         TipoValor tipoValor) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tipo_valor", tipoValor.getOIDInteger());
    dataset.fieldValue("codigo", tipoValor.getCodigo());
    dataset.fieldValue("descripcion", tipoValor.getDescripcion());
    dataset.fieldValue("comportamiento", tipoValor.getCompo());
  }
}
