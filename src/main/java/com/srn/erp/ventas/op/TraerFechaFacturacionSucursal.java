package com.srn.erp.ventas.op;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.ventas.bm.FechaFacturacionSucursal;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFechaFacturacionSucursal extends Operation {

  public TraerFechaFacturacionSucursal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    FechaFacturacionSucursal fechafacturacionsucursal = null;
    Sucursal sucursal = null;
    Integer oidSucursal = mapaDatos.getInteger("oid");
    sucursal = Sucursal.findByOid(oidSucursal, getSesion());
    fechafacturacionsucursal = FechaFacturacionSucursal.getFechaFacturacion(sucursal,getSesion());
    IDataSet datasetFechaFacturacionSucursal = getDataSetFechaFacturacionSucursal();
    if (fechafacturacionsucursal!=null)
        cargarRegistroFechaFacturacionSucursal(datasetFechaFacturacionSucursal,
                         fechafacturacionsucursal.getOIDInteger(),
                         fechafacturacionsucursal.getSucursal(),
                         Fecha.getddmmyyyy(fechafacturacionsucursal.getFecha_actual()),
                         Fecha.getddmmyyyy(fechafacturacionsucursal.getFecha_actual()),
                         fechafacturacionsucursal.isActivo());
    else
      cargarRegistroFechaFacturacionSucursal(datasetFechaFacturacionSucursal,
                       new Integer(-1),
                       sucursal,
                       Fecha.FECHA_NULA(),
                       Fecha.FECHA_NULA(),
                       new Boolean(true));

    writeCliente(datasetFechaFacturacionSucursal);
  }

  private IDataSet getDataSetFechaFacturacionSucursal() {
    IDataSet dataset = new TDataSet();
    dataset.create("TFechaFacturacionSucursal");
    dataset.fieldDef(new Field("oid_fec_fact_suc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_sucursal", Field.STRING, 30));
    dataset.fieldDef(new Field("desc_sucursal", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_ant", Field.STRING,10));
    dataset.fieldDef(new Field("nue_fec", Field.STRING,10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }

  private void cargarRegistroFechaFacturacionSucursal(IDataSet dataset,
                         Integer oid_fec_fact_suc,
                         Sucursal sucursal,
                         String fec_ant,
                         String nue_fec,
                         Boolean activo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_fec_fact_suc", oid_fec_fact_suc);
    dataset.fieldValue("oid_sucursal", sucursal.getOID());
    dataset.fieldValue("cod_sucursal", sucursal.getCodigo());
    dataset.fieldValue("desc_sucursal", sucursal.getDescripcion());
    dataset.fieldValue("fec_ant", fec_ant);
    dataset.fieldValue("nue_fec", nue_fec);
    dataset.fieldValue("activo", activo);
  }
}
