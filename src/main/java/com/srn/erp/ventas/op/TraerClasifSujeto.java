package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.ClasifSujeto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerClasifSujeto extends Operation {

  public TraerClasifSujeto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    ClasifSujeto clasifsujeto = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       clasifsujeto = ClasifSujeto.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       clasifsujeto = ClasifSujeto.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetClasifSujeto = getDataSetClasifSujeto();
    if (clasifsujeto != null) {
        cargarRegistroClasifSujeto(datasetClasifSujeto,
                         clasifsujeto.getOIDInteger(),
                         clasifsujeto.getCodigo(),
                         clasifsujeto.getDescripcion(),
                         clasifsujeto.isActivo());
    }
    writeCliente(datasetClasifSujeto);
  }

  private IDataSet getDataSetClasifSujeto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TClasifSujeto");
    dataset.fieldDef(new Field("oid_clasif_suj", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 20));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroClasifSujeto(IDataSet dataset,
                         Integer oid_clasif_suj,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_clasif_suj", oid_clasif_suj);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
