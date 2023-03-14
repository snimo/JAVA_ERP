package com.srn.erp.general.op;

import com.srn.erp.general.bm.Provincia;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerProvincia extends Operation {

  public TraerProvincia() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    Provincia provincia = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       provincia = Provincia.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       provincia = Provincia.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetProvincia = getDataSetProvincia();
    if (provincia != null) {
        cargarRegistroProvincia(datasetProvincia,
                         provincia.getOIDInteger(),
                         provincia.getCodigo(),
                         provincia.getDescripcion(),
                         provincia.isActivo(),
                         new Boolean(provincia.esBuenosAires()),
                         new Boolean(provincia.esCapitalFederal()),
                         new Boolean(provincia.isCalcPercIBBA()));
    }
    writeCliente(datasetProvincia);
  }

  private IDataSet getDataSetProvincia() {
    IDataSet dataset = new TDataSet();
    dataset.create("TProvincia");
    dataset.fieldDef(new Field("oid_provincia", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_bs_as", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_cap_fed", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("calc_perc_ib_ba", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroProvincia(IDataSet dataset,
                         Integer oid_provincia,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         Boolean esBsAs,
                         Boolean esCapFed,
                         Boolean calcPercIBBA) {
    dataset.append();
    dataset.fieldValue("oid_provincia", oid_provincia);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("es_bs_as", esBsAs);
    dataset.fieldValue("es_cap_fed", esCapFed);
    dataset.fieldValue("calc_perc_ib_ba", calcPercIBBA);
    
    
  }
}
