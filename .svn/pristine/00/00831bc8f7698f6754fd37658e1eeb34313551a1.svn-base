package com.srn.erp.impuestos.op;

import com.srn.erp.impuestos.bm.SujetoImpositivo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSujetoImpositivoCliente extends Operation {

  public TraerSujetoImpositivoCliente() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    SujetoImpositivo sujetoImpositivo = null;
    Integer oidSujeto = mapaDatos.getInteger("oid_sujeto");

    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       sujetoImpositivo = SujetoImpositivo.findByOid(oid, getSesion());
    }
    else {
       String cuit = mapaDatos.getString("cuit");
       if (cuit.trim().length()!=0)
      	 sujetoImpositivo = SujetoImpositivo.findByCodigo(cuit.trim(), getSesion());
    }

    IDataSet datasetSujetoImpositivo = getDataSetSujetoImpositivo();
    if (sujetoImpositivo!=null)
       cargarRegistroSujetoImpositivo(datasetSujetoImpositivo,
                                      oidSujeto,
                                      sujetoImpositivo);
    writeCliente(datasetSujetoImpositivo);
  }

  private void cargarRegistroSujetoImpositivo(IDataSet dataset,
                                              Integer oidSujeto,
                                              SujetoImpositivo sujetoImpositivo) throws BaseException {
      dataset.append();
      dataset.fieldValue("oid_suj_imp", sujetoImpositivo.getOID());
      dataset.fieldValue("razon_social", sujetoImpositivo.getRazon());
      dataset.fieldValue("cuit", sujetoImpositivo.getCuit());
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

      dataset.fieldValue("oid_sujeto",oidSujeto);
      dataset.fieldValue("activo", sujetoImpositivo.isActivo());
  }


  private IDataSet getDataSetSujetoImpositivo()  {
    IDataSet dataset = new TDataSet();
    dataset.create("TSujetoImpositivo");
    dataset.fieldDef(new Field("oid_suj_imp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("razon_social",Field.STRING, 100));
    dataset.fieldDef(new Field("cuit",Field.STRING, 20));
    dataset.fieldDef(new Field("ing_brutos",Field.STRING, 20));
    dataset.fieldDef(new Field("dnrp",Field.STRING, 20));
    dataset.fieldDef(new Field("oid_cat_iva", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_gan", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cat_ib", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sujeto",Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }



}
