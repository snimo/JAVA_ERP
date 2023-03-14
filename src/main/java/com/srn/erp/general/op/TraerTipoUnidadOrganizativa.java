package com.srn.erp.general.op;

import com.srn.erp.general.bm.TipoUnidadOrganizativa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoUnidadOrganizativa extends Operation {

  public TraerTipoUnidadOrganizativa() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    TipoUnidadOrganizativa tipounidadorganizativa = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       tipounidadorganizativa = TipoUnidadOrganizativa.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       tipounidadorganizativa = TipoUnidadOrganizativa.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetTipoUnidadOrganizativa = getDataSetTipoUnidadOrganizativa();
    if (tipounidadorganizativa != null) {
        cargarRegistroTipoUnidadOrganizativa(datasetTipoUnidadOrganizativa,
                         tipounidadorganizativa.getOIDInteger(),
                         tipounidadorganizativa.getCodigo(),
                         tipounidadorganizativa.getDescripcion(),
                         tipounidadorganizativa.isActivo());
    }
    writeCliente(datasetTipoUnidadOrganizativa);
  }

  private IDataSet getDataSetTipoUnidadOrganizativa() {
    IDataSet dataset = new TDataSet();
    dataset.create("TTipoUnidadOrganizativa");
    dataset.fieldDef(new Field("oid_tipo_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 15));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroTipoUnidadOrganizativa(IDataSet dataset,
                         Integer oid_tipo_uni_org,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid_tipo_uni_org", oid_tipo_uni_org);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
