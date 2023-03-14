package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.Serie;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSerie extends Operation {

  public TraerSerie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Serie serie = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       serie = Serie.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       serie = Serie.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetSerie = getDataSetSerie();
    if (serie != null) {
        cargarRegistroSerie(datasetSerie,
                         serie.getOIDInteger(),
                         serie.getCodigo(),
                         serie.getDescripcion(),
                         serie.getNro(),
                         serie.getFec_inicio(),
                         serie.getFec_vto(),
                         serie.isActivo());
    }
    writeCliente(datasetSerie);
  }

  private IDataSet getDataSetSerie() {
    IDataSet dataset = new TDataSet();
    dataset.create("TSerie");
    dataset.fieldDef(new Field("oid_serie", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("nro", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_inicio", Field.STRING, 10));
    dataset.fieldDef(new Field("fec_vto", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroSerie(IDataSet dataset,
                         Integer oid_serie,
                         String codigo,
                         String descripcion,
                         Integer nro,
                         java.util.Date fec_inicio,
                         java.util.Date fec_vto,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_serie", oid_serie);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("nro", nro);
    dataset.fieldValue("fec_inicio",Fecha.getddmmyyyy(fec_inicio));
    dataset.fieldValue("fec_vto", Fecha.getddmmyyyy(fec_vto));
    dataset.fieldValue("activo", activo);
  }
}
