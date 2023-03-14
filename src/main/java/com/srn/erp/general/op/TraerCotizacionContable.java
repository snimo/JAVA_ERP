package com.srn.erp.general.op;

import java.util.Date;

import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCotizacionContable extends Operation {

  public TraerCotizacionContable() {
  }

  private TipoCambio getTipoCambioContable() throws BaseException {
    ValorParametro valorParamTipoCambio =
        ValorParametro.findByCodigoParametro("TIPO_CAMBIO_CONTABILIDAD",getSesion());
    Integer oidTipoCambio = valorParamTipoCambio.getOidObjNeg();
    TipoCambio tipoCambio = (TipoCambio) TipoCambio.findByOid(oidTipoCambio,getSesion());
    return tipoCambio;
  }

  private Date getFecha(MapDatos mapaDatos) throws BaseException {
    Date fecha = null;
    if (mapaDatos.containsKey("fecha"))
      fecha = mapaDatos.getDate("fecha");
    else
      fecha = Fecha.getFechaActual();
    return fecha;
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    Date fecha           = getFecha(mapaDatos);
    Moneda moneda        = null;

    if (mapaDatos.containsKey("oid_moneda_ext1"))
       moneda = Moneda.getMonedaExt1(getSesion());
    else
       if (mapaDatos.containsKey("oid_moneda_ext2"))
           moneda = Moneda.getMonedaExt2(getSesion());
       else
           moneda  = Moneda.findByOid(mapaDatos.getInteger("oid_moneda"),getSesion());

    ValorCotizacion cotizacion = Cotizacion.getCotizacion(fecha,
                                                          getTipoCambioContable(),
                                                          moneda,
                                                          getSesion());
    IDataSet dataSetCotizacion = getDataSetCotizacion();
    cargarRegistroCotizacion(dataSetCotizacion,
                             new Integer(1),
                             new Double(cotizacion.doubleValue()));

    writeCliente(dataSetCotizacion);
  }

  private IDataSet getDataSetCotizacion() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCotizacionFecha");
    dataset.fieldDef(new Field("oid",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
    return dataset;
  }

  private void cargarRegistroCotizacion(IDataSet dataset,
                         Integer oid,
                         Double cotizacion) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("cotizacion", cotizacion);
  }
}
