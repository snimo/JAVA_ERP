package com.srn.erp.ctasACobrar.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpRecibos extends Operation {

  public TraerHelpRecibos() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsRecibo = getDataSetRecibos();
    traerRecibos(dsRecibo,mapaDatos);
    writeCliente(dsRecibo);
  }

  private void traerRecibos(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Sujeto sujeto = null;

    if (mapaDatos.containsKey("nro_ext_desde"))
      nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
    if (mapaDatos.containsKey("nro_ext_hasta"))
      nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
    if (mapaDatos.containsKey("fec_desde"))
      fecDesde = mapaDatos.getDate("fec_desde");
    if (mapaDatos.containsKey("fec_hasta"))
      fecHasta = mapaDatos.getDate("fec_hasta");
    if (mapaDatos.containsKey("oid_cliente"))
      sujeto = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_cliente"),getSesion());

    List listaRecibos =
        Recibo.getHelpRecibos(nroExtDesde,nroExtHasta,sujeto,fecDesde,fecHasta,getSesion());
    Iterator iterRecibos = listaRecibos.iterator();
    while (iterRecibos.hasNext()) {
      Recibo recibo = (Recibo) iterRecibos.next();
      cargarRegistroRecibo(dataSet,recibo);
    }

  }

  private IDataSet getDataSetRecibos() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpRecibos");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_cliente", Field.STRING, 50));
    dataset.fieldDef(new Field("rz_cliente", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 100));
    return dataset;
  }

  private void cargarRegistroRecibo(IDataSet dataset,
                                    Recibo recibo)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", recibo.getOID());
    dataset.fieldValue("oid_cco", recibo.getOID());
    dataset.fieldValue("comprobante", recibo.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(recibo.getEmision()));
    if (recibo.getSujeto()!=null) {
      dataset.fieldValue("oid_cliente", recibo.getSujeto().getOID());
      dataset.fieldValue("cod_cliente", recibo.getSujeto().getCodigo());
      dataset.fieldValue("rz_cliente", recibo.getSujeto().getRazon_social());
    } else {
      dataset.fieldValue("oid_cliente", 0);
      dataset.fieldValue("cod_cliente", "");
      dataset.fieldValue("rz_cliente", "");
    }
    dataset.fieldValue("activo", recibo.isActivo());
  }

}
