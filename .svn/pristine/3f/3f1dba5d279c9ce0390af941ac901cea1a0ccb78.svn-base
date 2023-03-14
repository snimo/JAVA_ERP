package com.srn.erp.contabilidad.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Atributo;
import com.srn.erp.contabilidad.bm.CompoAtributo;
import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.ValorCompo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerValorComponente extends Operation {

  public TraerValorComponente() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Componente componente = null;
    if (mapaDatos.containsKey("oid_compo")) {
       Integer oid = mapaDatos.getInteger("oid_compo");
       componente = Componente.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       componente = Componente.findByCodigo(codigo, getSesion());
    }

    ValorCompo valorCompo = ValorCompo.findByOid(componente,
                                                 mapaDatos.getInteger("oid"),
                                                 getSesion());
    IDataSet datasetValorComponente = getDataSetValorCompo(componente);

    datasetValorComponente.append();
    datasetValorComponente.fieldValue("oid_compo", valorCompo.getOID());
    datasetValorComponente.fieldValue("codigo", valorCompo.getCodigo());
    datasetValorComponente.fieldValue("descripcion", valorCompo.getDescripcion());

    Iterator iterCompoAtri = componente.getCompoAtributos().iterator();
    while (iterCompoAtri.hasNext()) {

      CompoAtributo compoAtributo = (CompoAtributo) iterCompoAtri.next();

      if (compoAtributo.getAtributo().getCompo()!=null) {
        ValorCompo valorCompoAtri =
            (ValorCompo) valorCompo.getAtributoCompo(compoAtributo.getAtributo().getCampoFisico());
        if (valorCompoAtri.getOIDInteger()!=null) {
          datasetValorComponente.fieldValue(compoAtributo.getAtributo().
                                            getCampoFisico(),
                                            valorCompoAtri.getOID());
          datasetValorComponente.fieldValue("cod_" +
                                            compoAtributo.getAtributo().getCampoFisico(),
                                            valorCompoAtri.getCodigo());
          datasetValorComponente.fieldValue("desc_" +
                                            compoAtributo.getAtributo().getCampoFisico(),
                                            valorCompoAtri.getDescripcion());
        }
        else {
          datasetValorComponente.fieldValue(compoAtributo.getAtributo().
                                            getCampoFisico(),
                                            0);
          datasetValorComponente.fieldValue("cod_" +
                                            compoAtributo.getAtributo().getCampoFisico(),
                                            "");
          datasetValorComponente.fieldValue("desc_" +
                                            compoAtributo.getAtributo().getCampoFisico(),
                                            "");

        }
      }
      else
        if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_ENTERO))
           datasetValorComponente.fieldValue(compoAtributo.getAtributo().getCampoFisico(),
                                        valorCompo.getAtributoInteger(compoAtributo.getAtributo().getCampoFisico()));
      else
        if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_DECIMAL))
           datasetValorComponente.fieldValue(compoAtributo.getAtributo().getCampoFisico(),
                                          valorCompo.getAtributoDouble(compoAtributo.getAtributo().getCampoFisico()));

      else
      if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_FECHA)) {

        Date fecha = valorCompo.getAtributoDate(compoAtributo.getAtributo().getCampoFisico());
        if (fecha == null)
            datasetValorComponente.fieldValue(compoAtributo.getAtributo().getCampoFisico(),
                                            "");
           else
             datasetValorComponente.fieldValue(compoAtributo.getAtributo().getCampoFisico(),Fecha.getddmmyyyy(fecha));
      }

      else
      if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_STRING))
         datasetValorComponente.fieldValue(compoAtributo.getAtributo().getCampoFisico(),
                                      valorCompo.getAtributoString(compoAtributo.getAtributo().getCampoFisico()));

    }

    datasetValorComponente.fieldValue("activo",valorCompo.isActivo());

    writeCliente(datasetValorComponente);
  }

  private IDataSet getDataSetValorCompo(Componente componente) throws BaseException {

    IDataSet dataset = new TDataSet();
    dataset.create("TValorComponente");
    dataset.fieldDef(new Field("oid_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));

    Iterator iterCompoAtri = componente.getCompoAtributos().iterator();
    while (iterCompoAtri.hasNext()) {

      CompoAtributo compoAtributo = (CompoAtributo) iterCompoAtri.next();

      if (compoAtributo.getAtributo().getCompo()!=null) {
        dataset.fieldDef(new Field(compoAtributo.getAtributo().getCampoFisico(), Field.INTEGER, 0));
        dataset.fieldDef(new Field("cod_"+compoAtributo.getAtributo().getCampoFisico(), Field.STRING, 15));
        dataset.fieldDef(new Field("desc_"+compoAtributo.getAtributo().getCampoFisico(), Field.STRING, 50));
      }
      else
        if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_ENTERO))
           dataset.fieldDef(new Field(compoAtributo.getAtributo().getCampoFisico(), Field.INTEGER, 0));
      else
        if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_DECIMAL))
           dataset.fieldDef(new Field(compoAtributo.getAtributo().getCampoFisico(), Field.CURRENCY, 0));
      else
      if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_FECHA))
           dataset.fieldDef(new Field(compoAtributo.getAtributo().getCampoFisico(), Field.STRING, 10));
      else
      if (compoAtributo.getAtributo().getTipo().equals(Atributo.TIPO_STRING))
           dataset.fieldDef(new Field(compoAtributo.getAtributo().getCampoFisico(), Field.STRING, 50));
    }

    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }



}
