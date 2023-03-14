package com.srn.erp.contabilidad.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.contabilidad.bm.ReporteContableDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpCuentas extends Operation {

  public TraerHelpCuentas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet datasetCuentas = getDataSetCuenta();
    if(!mapaDatos.containsKey("oid_clasificador"))
      traerCuentas(datasetCuentas,mapaDatos);
    else
      traerCuentasReporte(datasetCuentas,mapaDatos);
    writeCliente(datasetCuentas);
  }

  private void traerCuentasReporte(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer oidTitu;
    String  codigo;
    String  descripcion;
    Integer oidTituPadre;

    ReporteContable reporteContable =
        ReporteContable.findByOid(mapaDatos.getInteger("oid_clasificador"),
                                  getSesion());
    Iterator iterItemsReporte = reporteContable.getItemsReporte().iterator();
    while (iterItemsReporte.hasNext()) {
      ReporteContableDet reporteContableDet =
          (ReporteContableDet) iterItemsReporte.next();

      if (reporteContableDet.isTitulo()) {
        oidTitu      = new Integer(reporteContableDet.getOidtitulo().intValue()*-1);
        codigo       = "";
        descripcion  = reporteContableDet.getDesctitulo();
        oidTituPadre = new Integer(reporteContableDet.getOidtitulopadre().intValue()*-1);
        cargarRegistroCuenta(dataSet,oidTitu,codigo,descripcion,oidTituPadre);
      }
      else
      if (reporteContableDet.isCuenta()) {
        oidTitu      = reporteContableDet.getCuenta().getOIDInteger();
        codigo       = reporteContableDet.getCuenta().getCodigo();
        descripcion  = reporteContableDet.getCuenta().getDescripcion();
        oidTituPadre = new Integer(reporteContableDet.getOidtitulopadre().intValue()*-1);
        cargarRegistroCuenta(dataSet,oidTitu,codigo,descripcion,oidTituPadre);
      }
      else
      if (reporteContableDet.isRangoCuentas()) {

        List listaCuentas =
            reporteContableDet.getRangoCuentas(reporteContableDet.getCodigodesde(),
                                           reporteContableDet.getCodigohasta());
        if (listaCuentas == null) continue;
        Iterator iterListaCuentas = listaCuentas.iterator();
        while (iterListaCuentas.hasNext()) {
          Cuenta cuenta = (Cuenta) iterListaCuentas.next();
          oidTitu      = cuenta.getOIDInteger();
          codigo       = cuenta.getCodigo();
          descripcion  = cuenta.getDescripcion();
          oidTituPadre = new Integer(reporteContableDet.getOidtitulopadre().intValue()*-1);
          cargarRegistroCuenta(dataSet,oidTitu,codigo,descripcion,oidTituPadre);
        }
      }
    }
  }

  private void traerCuentas(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {
    List listaCuentas = Cuenta.getHelpCuentas(mapaDatos,getSesion());
    Iterator iterCuentas = listaCuentas.iterator();
    while (iterCuentas.hasNext()) {
      Cuenta cuenta = (Cuenta) iterCuentas.next();
      cargarRegistroCuenta(dataSet,
                           cuenta.getOIDInteger(),
                           cuenta.getCodigo(),
                           cuenta.getDescripcion(),
                           new Integer(0));
    }
  }

  private IDataSet getDataSetCuenta() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpCuentas");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 15));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_padre", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistroCuenta(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion,
                         Integer oidPadre) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("oid_padre",oidPadre);

  }

}
