package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.SujetoImpositivo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSujetoImpositivo extends Operation {

  public TraerSujetoImpositivo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    SujetoImpositivo sujetoImpositivo = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       sujetoImpositivo = SujetoImpositivo.findByOid(oid, getSesion());
    }
    else {
       String cuit = mapaDatos.getString("cuit");
       sujetoImpositivo = SujetoImpositivo.findByCodigo(cuit, getSesion());
    }

    Integer oidProveedor = mapaDatos.getInteger("oid_proveedor");

    IDataSet datasetSujetoImpositivo = getDataSetSujetoImpositivo();
    if (sujetoImpositivo!=null)
       cargarRegistroSujetoImpositivo(datasetSujetoImpositivo,
                                      oidProveedor,
                                      sujetoImpositivo);
    writeCliente(datasetSujetoImpositivo);
  }

  private void cargarRegistroSujetoImpositivo(IDataSet dataset,
                                              Integer oidProveedor,
                                              SujetoImpositivo sujetoImpositivo) throws BaseException {
      dataset.append();
      dataset.fieldValue("oid_suj_imp", sujetoImpositivo.getOID());
      dataset.fieldValue("razon_social", sujetoImpositivo.getRazon());
      dataset.fieldValue("cuit", sujetoImpositivo.getCuit());
      dataset.fieldValue("exento_ret_iva", sujetoImpositivo.isExentoretiva());
      dataset.fieldValue("exento_ret_gan", sujetoImpositivo.isExentoretgan());
      dataset.fieldValue("exento_ret_ib", sujetoImpositivo.isExentoretib());
      dataset.fieldValue("ing_brutos", sujetoImpositivo.getIngbrutos());
      dataset.fieldValue("dnrp", sujetoImpositivo.getDnrp());
      if (sujetoImpositivo.getCategiva()==null)
         dataset.fieldValue("oid_cat_iva", 0);
      else
         dataset.fieldValue("oid_cat_iva", sujetoImpositivo.getCategiva().getOID());
      if (sujetoImpositivo.getCateggan()==null)
         dataset.fieldValue("oid_cat_gan", 0);
      else
         dataset.fieldValue("oid_cat_gan", sujetoImpositivo.getCateggan().getOID());
      if (sujetoImpositivo.getCategib()==null)
         dataset.fieldValue("oid_cat_ib", 0);
      else
         dataset.fieldValue("oid_cat_ib", sujetoImpositivo.getCategib().getOID());

       if (sujetoImpositivo.getCatRetIVA()==null)
         dataset.fieldValue("oid_cat_ret_iva", 0);
       else
         dataset.fieldValue("oid_cat_ret_iva", sujetoImpositivo.getCatRetIVA().getOID());

       if (sujetoImpositivo.getCatRetGan()==null)
         dataset.fieldValue("oid_cat_ret_gan", 0);
       else
         dataset.fieldValue("oid_cat_ret_gan", sujetoImpositivo.getCatRetGan().getOID());

       if (sujetoImpositivo.getCatRetIB()==null)
         dataset.fieldValue("oid_cat_ret_ib", 0);
       else
         dataset.fieldValue("oid_cat_ret_ib", sujetoImpositivo.getCatRetIB().getOID());


      dataset.fieldValue("activo", sujetoImpositivo.isActivo());
      dataset.fieldValue("oid_proveedor", oidProveedor);
  }


  private IDataSet getDataSetSujetoImpositivo()  {
    IDataSet dataset = new TDataSet();
    dataset.create("TSujetoImpositivo");
    dataset.fieldDef(new Field("oid_suj_imp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("razon_social",Field.STRING, 100));
    dataset.fieldDef(new Field("cuit",Field.STRING, 20));
    dataset.fieldDef(new Field("exento_ret_iva",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("exento_ret_gan",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("exento_ret_ib",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("ing_brutos",Field.STRING, 20));
    dataset.fieldDef(new Field("dnrp",Field.STRING, 20));
    dataset.fieldDef(new Field("oid_cat_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ret_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ret_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ret_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_proveedor",Field.INTEGER, 0));
    return dataset;
  }

}
