package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.GrupoCondPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoCondPago extends Operation {

  public TraerGrupoCondPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    GrupoCondPago grupocondpago = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       grupocondpago = GrupoCondPago.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       grupocondpago = GrupoCondPago.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetGrupoCondPago = getDataSetGrupoCondPago();
    if (grupocondpago != null) {
        cargarRegistroGrupoCondPago(datasetGrupoCondPago,
                         grupocondpago.getOIDInteger(),
                         grupocondpago.getCodigo(),
                         grupocondpago.getDescripcion(),
                         grupocondpago.isActivo());
    }
    writeCliente(datasetGrupoCondPago);
  }

  private IDataSet getDataSetGrupoCondPago() {
    IDataSet dataset = new TDataSet();
    dataset.create("TGrupoCondPago");
    dataset.fieldDef(new Field("oid_grupo_cp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroGrupoCondPago(IDataSet dataset,
                         Integer oid_grupo_cp,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_grupo_cp", oid_grupo_cp);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
