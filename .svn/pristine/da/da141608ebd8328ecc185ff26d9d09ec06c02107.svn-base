package com.srn.erp.pagos.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.pagos.bm.ComproOrdenPagoCab;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpOPVariasEfectivo extends Operation {

  public TraerHelpOPVariasEfectivo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = this.getDataSetOPVariasEfectivo();
    traerOP(ds,mapaDatos);
    writeCliente(ds);
  }

  private void traerOP(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;

    if (mapaDatos.containsKey("nro_ext_desde"))
      nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
    if (mapaDatos.containsKey("nro_ext_hasta"))
      nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
    if (mapaDatos.containsKey("fec_desde"))
      fecDesde = mapaDatos.getDate("fec_desde");
    if (mapaDatos.containsKey("fec_hasta"))
      fecHasta = mapaDatos.getDate("fec_hasta");

    List listaOPVariasEfectivo =
        ComproOrdenPagoCab.getHelpComproOrdenPagoVariasEfectivo(
        		nroExtDesde,
        		nroExtHasta,
        		fecDesde,
        		fecHasta,
        		getSesion());
    Iterator iterOPVariasEfe = listaOPVariasEfectivo.iterator();
    while (iterOPVariasEfe.hasNext()) {
      ComproOrdenPagoCab comproOPCab = (ComproOrdenPagoCab) iterOPVariasEfe.next();
      cargarRegistro(dataSet,comproOPCab);
    }

  }

  private IDataSet getDataSetOPVariasEfectivo() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpOPVariasEfectivo");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 100));
    dataset.fieldDef(new Field("total_pago", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("moneda", Field.STRING, 10));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                              ComproOrdenPagoCab comproOP)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", comproOP.getOID());
    dataset.fieldValue("oid_cco", comproOP.getOID());
    dataset.fieldValue("comprobante", comproOP.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(comproOP.getEmision()));
    dataset.fieldValue("activo", comproOP.isActivo());
    dataset.fieldValue("total_pago", comproOP.getTotalPago());
    dataset.fieldValue("moneda", comproOP.getMoneda().getSimbolo());
    
  }

}
