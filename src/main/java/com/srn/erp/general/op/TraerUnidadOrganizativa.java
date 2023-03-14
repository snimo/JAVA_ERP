package com.srn.erp.general.op;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerUnidadOrganizativa extends Operation {

  public TraerUnidadOrganizativa() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    UnidadOrganizativa unidadorganizativa = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       unidadorganizativa = UnidadOrganizativa.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       unidadorganizativa = UnidadOrganizativa.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetUnidadOrganizativa = getDataSetUnidadOrganizativa();
    if (unidadorganizativa != null) {
        cargarRegistroUnidadOrganizativa(datasetUnidadOrganizativa,
                         unidadorganizativa.getOIDInteger(),
                         unidadorganizativa.getCodigo(),
                         unidadorganizativa.getDescripcion(),
                         unidadorganizativa.getTipounidadorganizativa().getOIDInteger(),
                         unidadorganizativa.getTipounidadorganizativa().getCodigo(),
                         unidadorganizativa.getTipounidadorganizativa().getDescripcion(),
                         unidadorganizativa.getSucursal(),
                         unidadorganizativa.isActivo());
    }
    writeCliente(datasetUnidadOrganizativa);
  }

  private IDataSet getDataSetUnidadOrganizativa() {
    IDataSet dataset = new TDataSet();
    dataset.create("TUnidadOrganizativa");
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_tipo_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_tipo_uni_org", Field.STRING, 15));
    dataset.fieldDef(new Field("desc_tipo_uni_org", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sucursal", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_sucursal", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroUnidadOrganizativa(IDataSet dataset,
                         Integer oid_uni_org,
                         String codigo,
                         String descripcion,
                         Integer oid_tipo_uni_org,
                         String codigo_tipo_uni_org,
                         String desc_tipo_uni_org,
                         Sucursal sucursal,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_uni_org", oid_uni_org);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_tipo_uni_org", oid_tipo_uni_org);
    dataset.fieldValue("codigo_tipo_uni_org", codigo_tipo_uni_org);
    dataset.fieldValue("desc_tipo_uni_org", desc_tipo_uni_org);
    dataset.fieldValue("oid_sucursal", sucursal.getOID());
    dataset.fieldValue("cod_sucursal", sucursal.getCodigo());
    dataset.fieldValue("desc_sucursal", sucursal.getDescripcion());
    dataset.fieldValue("activo", activo);

  }
}
