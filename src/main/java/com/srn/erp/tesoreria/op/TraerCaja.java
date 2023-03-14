package com.srn.erp.tesoreria.op;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.Caja;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCaja extends Operation {

  public TraerCaja() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Caja caja = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       caja = Caja.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       caja = Caja.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCaja = getDataSetCaja();
    if (caja != null) {
        cargarRegistroCaja(datasetCaja,
                         caja.getOIDInteger(),
                         caja.getCodigo(),
                         caja.getDescripcion(),
                         caja.getUnidadorganizativa(),
                         caja.getCompo(),
                         caja.isActivo(),
                         caja.getTipoCierreApertura());
    }
    writeCliente(datasetCaja);
  }

  private IDataSet getDataSetCaja() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCaja");
    dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_uni_org", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_uni_org", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_uni_org" , Field.STRING, 50));
    dataset.fieldDef(new Field("compo", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("tipo_cie_aper", Field.STRING, 10));

    return dataset;
  }

  private void cargarRegistroCaja(IDataSet dataset,
                         Integer oid_caja,
                         String codigo,
                         String descripcion,
                         UnidadOrganizativa unidadOrganizativa,
                         String compo,
                         Boolean activo,
                         String tipo_cie_aper) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_caja", oid_caja);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_uni_org", unidadOrganizativa.getOID());
    dataset.fieldValue("cod_uni_org", unidadOrganizativa.getCodigo());
    dataset.fieldValue("desc_uni_org" , unidadOrganizativa.getDescripcion());
    dataset.fieldValue("compo", compo);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("tipo_cie_aper",tipo_cie_aper);
  }
}
