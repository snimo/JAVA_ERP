package com.srn.erp.general.op;

import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.TipoCambio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCotizaciones extends Operation {

  public SaveCotizaciones() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TCotizacionesFecha");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        Cotizacion cotizacion = Cotizacion.findByOid(dataset.getInteger("oid_cotizacion"),getSesion());
        cotizacion.setCotizacion(dataset.getCotizacion("cotizacion"));
        cotizacion.setFechavig(dataset.getDate("fecha_vig"));
        cotizacion.setTipocambio(TipoCambio.findByOidProxy(dataset.getInteger("oid_tipo_cambio"),getSesion()));
        cotizacion.setMoneda(Moneda.findByOidProxy(dataset.getInteger("oid_moneda"),getSesion()));
        cotizacion.setActivo(new Boolean(true));
        addTransaccion(cotizacion);
        dataset.next();
    }
  }

}
