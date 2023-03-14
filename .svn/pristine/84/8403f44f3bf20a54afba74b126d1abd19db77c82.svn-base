package com.srn.erp.contabilidad.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.ReporteContaCompo;
import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.contabilidad.bm.ReporteContableDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerReporteContable extends Operation {

  public TraerReporteContable() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    ReporteContable reportecontable = null;
    if (mapaDatos.containsKey("oid")) {
       Integer oid = mapaDatos.getInteger("oid");
       reportecontable = ReporteContable.findByOid(oid, getSesion());
    }
    else {
       String codigo = mapaDatos.getString("codigo");
       reportecontable = ReporteContable.findByCodigo(codigo, getSesion());
    }

    IDataSet datasetReporteContable = getDataSetReporteContable();
    IDataSet datasetReporteContableDet = getDataSetReporteContableDet();
    IDataSet datasetReporteContableCompo = getDataSetReporteContableCompo();

    if (reportecontable != null) {
        cargarRegistroReporteContable(datasetReporteContable,
                         reportecontable.getOIDInteger(),
                         reportecontable.getCodigo(),
                         reportecontable.getDescripcion(),
                         reportecontable.isActivo(),
                         reportecontable.isShowEnABMCtas()
                         );
        Iterator iterIetmsReporte = reportecontable.getItemsReporte().iterator();
        while (iterIetmsReporte.hasNext()) {
          ReporteContableDet reporteContableDet = (ReporteContableDet) iterIetmsReporte.next();

          Integer oidAnaCon    = new Integer(0);
          String  codigoAnaCon = "";
          String  descAnaCon   = "";

          if (reporteContableDet.isCuenta() ||
              reporteContableDet.isCuentaConComponentes() ||
              reporteContableDet.isCuentaSinComponentes()) {
            oidAnaCon = reporteContableDet.getCuenta().getOIDInteger();
            codigoAnaCon = reporteContableDet.getCuenta().getCodigo();
            descAnaCon = reporteContableDet.getCuenta().getDescripcion();
          }
          
          cargarRegistroReporteContableDet(datasetReporteContableDet,reporteContableDet.getOIDInteger(),
                                           reportecontable.getOIDInteger(),reporteContableDet.getOidtitulo(),
                                           reporteContableDet.getOidtitulopadre(),
                                           reporteContableDet.getDesctitulo(),
                                           oidAnaCon,codigoAnaCon,descAnaCon,
                                           reporteContableDet.getCodigodesde(),
                                           reporteContableDet.getCodigohasta(),
                                           reporteContableDet.getOrden(),
                                           reporteContableDet.isActivo(),
                                           reporteContableDet.getTipo(),
                                           reporteContableDet.getDescripcion()
                                           );

          if (reporteContableDet.isCuenta() ||
              reporteContableDet.isCuentaConComponentes() ||
              reporteContableDet.isCuentaSinComponentes()
              ) {
            List listaReporteCompoConta = ReporteContaCompo.getReportesContaCompoByReporteDet(reporteContableDet,getSesion());
            Iterator iterReportesCompoConta = listaReporteCompoConta.iterator();
            while (iterReportesCompoConta.hasNext()) {
              ReporteContaCompo reporteContaCompo = (ReporteContaCompo) iterReportesCompoConta.next();
              cargarRegistroReporteContableCompo(datasetReporteContableCompo,
                                                 reporteContaCompo.getOIDInteger(),
                                                 reporteContableDet.getOIDInteger(),
                                                 reporteContaCompo.getComponente().getOIDInteger(),
                                                 reporteContaCompo.getComponente().getDescripcion(),
                                                 reporteContaCompo.getValorcomponente().getOIDInteger(),
                                                 reporteContaCompo.getValorcomponente().getCodigo(),
                                                 reporteContaCompo.getValorcomponente().getDescripcion());
            }
          }
        }
    }
    writeCliente(datasetReporteContable);
    writeCliente(datasetReporteContableDet);
    writeCliente(datasetReporteContableCompo);
  }

  private IDataSet getDataSetReporteContable() {
    IDataSet dataset = new TDataSet();
    dataset.create("TReporteContable");
    dataset.fieldDef(new Field("oid_rep_conta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("show_abm_cta", Field.BOOLEAN, 0));
    return dataset;
  }

  private IDataSet getDataSetReporteContableDet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TReporteContableDet");
    dataset.fieldDef(new Field("oid_rep_conta_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_rep_conta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_titu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_titu_padre", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_titulo",Field.STRING, 50));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_ana_con",Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_ana_con",Field.STRING, 15));
    dataset.fieldDef(new Field("desc_ana_con",Field.STRING, 50));
    dataset.fieldDef(new Field("codigo_desde",Field.STRING, 15));
    dataset.fieldDef(new Field("codigo_hasta",Field.STRING, 15));
    dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo",Field.STRING, 5));
    dataset.fieldDef(new Field("descripcion",Field.STRING, 255));

    return dataset;
  }

  private void cargarRegistroReporteContableDet(IDataSet dataset,
                         Integer oid_rep_conta_det,
                         Integer oid_rep_conta,
                         Integer oid_titu,
                         Integer oid_titu_padre,
                         String descTitulo,
                         Integer oid_ana_con,
                         String codigo_ana_con,
                         String desc_ana_con,
                         String codigo_desde,
                         String codigo_hasta,
                         Integer orden,
                         Boolean activo,
                         String tipo,
                         String descripcion) {
    dataset.append();
    dataset.fieldValue("oid_rep_conta_det", oid_rep_conta_det);
    dataset.fieldValue("oid_rep_conta", oid_rep_conta);
    dataset.fieldValue("oid_titu", oid_titu);
    dataset.fieldValue("oid_titu_padre", oid_titu_padre);
    dataset.fieldValue("desc_titulo",descTitulo);
    dataset.fieldValue("activo",activo);
    dataset.fieldValue("oid_ana_con",oid_ana_con);
    dataset.fieldValue("codigo_ana_con",codigo_ana_con);
    dataset.fieldValue("desc_ana_con",desc_ana_con);
    dataset.fieldValue("codigo_desde",codigo_desde);
    dataset.fieldValue("codigo_hasta",codigo_hasta);
    dataset.fieldValue("orden",orden);
    dataset.fieldValue("tipo",tipo);
    dataset.fieldValue("descripcion",descripcion);
  }



  private void cargarRegistroReporteContable(IDataSet dataset,
                         Integer oid_rep_conta,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         Boolean showABMCta) {
    dataset.append();
    dataset.fieldValue("oid_rep_conta", oid_rep_conta);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("show_abm_cta", showABMCta);
  }

  private IDataSet getDataSetReporteContableCompo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TRepContaCompo");
    dataset.fieldDef(new Field("oid_rep_con_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_rep_conta_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_compo", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_valor_compo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_val_compo", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_valor_compo", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistroReporteContableCompo(IDataSet dataset,
                         Integer oidRepConCompo,
                         Integer oidRepContaDet,
                         Integer oidCCO,
                         String descCompo,
                         Integer oidValorCompo,
                         String codigoValCompo,
                         String descValorCompo) {
    dataset.append();
    dataset.fieldValue("oid_rep_con_compo", oidRepConCompo);
    dataset.fieldValue("oid_rep_conta_det", oidRepContaDet);
    dataset.fieldValue("oid_cco", oidCCO);
    dataset.fieldValue("desc_compo", descCompo);
    dataset.fieldValue("oid_valor_compo",oidValorCompo);
    dataset.fieldValue("codigo_val_compo",codigoValCompo);
    dataset.fieldValue("desc_valor_compo",descValorCompo);
  }




}
