package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.ReporteContaCompo;
import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.contabilidad.bm.ReporteContableDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveReporteContable extends Operation {

  public SaveReporteContable() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TReporteContable");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    IDataSet datasetItemsReporte;
    dataset.first();
      while (!dataset.EOF()) {
        ReporteContable reportecontable = ReporteContable.findByOid(dataset.getInteger("oid_rep_conta"),getSesion());
        reportecontable.setOID(dataset.getInteger("oid_rep_conta"));
        reportecontable.setCodigo(dataset.getString("codigo"));
        reportecontable.setDescripcion(dataset.getString("descripcion"));
        reportecontable.setActivo(dataset.getBoolean("activo"));
        reportecontable.setShowEnABMCtas(dataset.getBoolean("show_abm_cta"));

        datasetItemsReporte = dataset.getDataSet("TReporteContableDet");
        datasetItemsReporte.first();
        while (!datasetItemsReporte.EOF()) {
          ReporteContableDet reportecontableDet = ReporteContableDet.findByOid(datasetItemsReporte.getInteger("oid_rep_conta_det"),getSesion());
          reportecontableDet.setReporteContable(reportecontable);
          reportecontableDet.setOidtitulo(datasetItemsReporte.getInteger("oid_titu"));
          reportecontableDet.setOidtitulopadre(datasetItemsReporte.getInteger("oid_titu_padre"));
          reportecontableDet.setDesctitulo(datasetItemsReporte.getString("desc_titulo"));
          reportecontableDet.setCuenta(Cuenta.findByOidProxy(datasetItemsReporte.getInteger("oid_ana_con"),getSesion()));
          reportecontableDet.setCodigodesde(datasetItemsReporte.getString("codigo_desde"));
          reportecontableDet.setCodigohasta(datasetItemsReporte.getString("codigo_hasta"));
          reportecontableDet.setTipo(datasetItemsReporte.getString("tipo"));
          reportecontableDet.setOrden(datasetItemsReporte.getInteger("orden"));
          reportecontableDet.setActivo(datasetItemsReporte.getBoolean("activo"));
          if (datasetItemsReporte.getBoolean("activo").booleanValue()==false)
             reportecontableDet.delete();

          if (reportecontableDet.isCuentaConComponentes() || reportecontableDet.isCuentaSinComponentes()) {
            IDataSet datasetItemsReporteCompo = datasetItemsReporte.getDataSet("TRepContaCompo");
            datasetItemsReporteCompo.first();
            while (!datasetItemsReporteCompo.EOF()) {
              ReporteContaCompo reporteContaCompo =
                  ReporteContaCompo.findByOid(datasetItemsReporteCompo.getInteger("oid_rep_con_compo"),getSesion());
              if (datasetItemsReporteCompo.getInteger("oid_valor_compo")== null)
                reporteContaCompo.delete();
              else {
                reporteContaCompo.setReportecontadet(reportecontableDet);
                Componente componente = Componente.findByOid(
                    datasetItemsReporteCompo.getInteger("oid_cco"), getSesion());
                reporteContaCompo.setComponente(componente);
                reporteContaCompo.setValorcomponente(componente.getValorCompo(datasetItemsReporteCompo.getInteger("oid_valor_compo")));
              }
              reportecontableDet.addItemReporte(reporteContaCompo);
              datasetItemsReporteCompo.next();
            }
          }

          datasetItemsReporte.next();
          reportecontable.addItemReporte(reportecontableDet);
        }

        addTransaccion(reportecontable);
        dataset.next();
    }
  }

}
