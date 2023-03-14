package com.srn.erp.general.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCotizaciones extends Operation {

  public TraerCotizaciones() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    int oid = 0;

    Date fechaVig = mapaDatos.getDate("fecha_vig");
    IDataSet dataSetCotizaciones = getDataSetCotizacion();

    Iterator iterTipoCambio = TipoCambio.getAllActivos(getSesion()).iterator();
    while (iterTipoCambio.hasNext()) {
      TipoCambio tipoCambio = (TipoCambio) iterTipoCambio.next();

      Iterator iterMonedas = Moneda.getAllActivos(getSesion()).iterator();
      while (iterMonedas.hasNext()) {
        Moneda moneda = (Moneda) iterMonedas.next();

        Cotizacion cotizacion =
            Cotizacion.getCotizacionByFechaTipoMoneda(
                           fechaVig,
                           tipoCambio,
                           moneda,
                           getSesion());

        double cotizacionDia = 0.0;
        int oid_cotizacion = -1;
        if (cotizacion!=null) {
          cotizacionDia = cotizacion.getCotizacion().doubleValue();
          oid_cotizacion = cotizacion.getOID();
        }

        ++oid;
        cargarRegistroCotizacion(
           dataSetCotizaciones,
           new Integer(oid),
           new Integer(oid_cotizacion),
           fechaVig,
           tipoCambio.getOIDInteger(),
           tipoCambio.getDescripcion(),
           new Double(cotizacionDia),
           moneda.getOIDInteger(),
           moneda.getDescripcion(),
           new Boolean(true));
      }
    }
    writeCliente(dataSetCotizaciones);
  }

  private IDataSet getDataSetCotizacion() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCotizacionesFecha");
    dataset.fieldDef(new Field("oid",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cotizacion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fecha_vig", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_tipo_cambio", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_tipo_cambio", Field.STRING, 50));
    dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_moneda", Field.STRING, 50));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroCotizacion(IDataSet dataset,
                         Integer oid,
                         Integer oid_cotizacion,
                         Date fecha_vig,
                         Integer oid_tipo_cambio,
                         String desc_tipo_cambio,
                         Double cotizacion,
                         Integer oid_moneda,
                         String descMoneda,
                         Boolean activo) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("oid_cotizacion", oid_cotizacion);
    dataset.fieldValue("fecha_vig", Fecha.getddmmyyyy(fecha_vig));
    dataset.fieldValue("oid_tipo_cambio", oid_tipo_cambio);
    dataset.fieldValue("desc_tipo_cambio",desc_tipo_cambio);
    dataset.fieldValue("cotizacion", cotizacion);
    dataset.fieldValue("oid_moneda", oid_moneda);
    dataset.fieldValue("desc_moneda",descMoneda);
    dataset.fieldValue("activo", activo);
  }
}
