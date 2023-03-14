package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.CategoriaIB;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCategoriaIB extends Operation {

  public TraerCategoriaIB() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    CategoriaIB categoriaib = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       categoriaib = CategoriaIB.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       categoriaib = CategoriaIB.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetCategoriaIB = getDataSetCategoriaIB();
    if (categoriaib != null) {
        cargarRegistroCategoriaIB(datasetCategoriaIB,
                         categoriaib.getOIDInteger(),
                         categoriaib.getCodigo(),
                         categoriaib.getDescripcion(),
                         categoriaib.getComportamiento(),
                         categoriaib.isActivo(),
                         categoriaib.isCalcPercIBBsAs(),
                         categoriaib.isCalcPercIBCapFed());
    }
    writeCliente(datasetCategoriaIB);
  }

  private IDataSet getDataSetCategoriaIB() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCategoriaIB");
    dataset.fieldDef(new Field("oid_cat_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
    dataset.fieldDef(new Field("compo_cat_ib", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("calc_perc_ib_ba", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("calc_perc_ib_cf", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCategoriaIB(IDataSet dataset,
                         Integer oid_cat_ib,
                         String codigo,
                         String descripcion,
                         String compo_cat_ib,
                         Boolean activo,
                         boolean calcPercIBBsAs,
                         boolean calcPercIBCapFed) {
    dataset.append();
    dataset.fieldValue("oid_cat_ib", oid_cat_ib);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("compo_cat_ib", compo_cat_ib);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("calc_perc_ib_ba", new Boolean(calcPercIBBsAs));
    dataset.fieldValue("calc_perc_ib_cf", new Boolean(calcPercIBCapFed));
    
  }
}
