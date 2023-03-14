package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.ventas.bm.FechaFacturacionSucursal;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveFechaFacturacionSucursal extends Operation {

  public SaveFechaFacturacionSucursal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dataset = mapaDatos.getDataSet("TFechaFacturacionSucursal");
    procesarRegistros(dataset);
  }

  private void procesarRegistros(IDataSet dataset) throws BaseException {
    dataset.first();
      while (!dataset.EOF()) {
        FechaFacturacionSucursal fechafacturacionsucursal = FechaFacturacionSucursal.findByOid(dataset.getInteger("oid_fec_fact_suc"),getSesion());
        fechafacturacionsucursal.setOID(dataset.getInteger("oid_fec_fact_suc"));
        fechafacturacionsucursal.setSucursal(Sucursal.findByOidProxy(dataset.getInteger("oid_sucursal"),getSesion()));
        fechafacturacionsucursal.setFecha_anterior(dataset.getDate("nue_fec"));
        if (dataset.getDate("nueva_fecha")==null)
          throw new ExceptionValidation(null,"Debe ingresar la nueva fecha de Facturación");
        fechafacturacionsucursal.setFecha_actual(dataset.getDate("nueva_fecha"));
        fechafacturacionsucursal.setActivo(dataset.getBoolean("activo"));
        addTransaccion(fechafacturacionsucursal);
        dataset.next();
        if (dataset.getInteger("oid_sucursal")!=null)
            setRefreshObjNeg(dataset.getInteger("oid_sucursal"));
    }
  }

}
