package com.srn.erp.tesoreria.op;

import com.srn.erp.tesoreria.bm.TipoValor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMonedaTipoValor extends Operation {

  public TraerMonedaTipoValor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    TipoValor tipovalor = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       tipovalor = TipoValor.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       tipovalor = TipoValor.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTipoValor = getDataSetMonedaTipoValor();
    if (tipovalor != null) 
    	cargarRegistroMonedaTipoValor(datasetTipoValor,tipovalor);
    writeCliente(datasetTipoValor);
  }

  private IDataSet getDataSetMonedaTipoValor() {
    IDataSet dataset = new TDataSet();
    dataset.create("TMonedaTipoValor");
    dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 10));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_moneda", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_moneda", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroMonedaTipoValor(IDataSet dataset,
                         TipoValor tipoValor) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_tipo_valor", tipoValor.getOIDInteger());
    dataset.fieldValue("codigo", tipoValor.getCodigo());
    dataset.fieldValue("descripcion", tipoValor.getDescripcion());
    dataset.fieldValue("oid_moneda", tipoValor.getMoneda().getOIDInteger());
    dataset.fieldValue("cod_moneda", tipoValor.getMoneda().getCodigo());
    dataset.fieldValue("desc_moneda", tipoValor.getMoneda().getDescripcion());
  }
}
