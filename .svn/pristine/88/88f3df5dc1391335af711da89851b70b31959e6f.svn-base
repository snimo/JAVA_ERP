package com.srn.erp.tesoreria.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.tesoreria.bm.TransferenciaValores;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpTransferenciasEntreCajas extends Operation {

  public TraerHelpTransferenciasEntreCajas() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet dsHelpTransf = getDataSetTransferencias();
    traerTransferencias(dsHelpTransf,mapaDatos);
    writeCliente(dsHelpTransf);
  }

  private void traerTransferencias(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

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

    List listaTransferencias =
        TransferenciaValores.getHelpTransferencias(nroExtDesde,nroExtHasta,fecDesde,fecHasta,getSesion());
    Iterator iterTransferencias = listaTransferencias.iterator();
    while (iterTransferencias.hasNext()) {
      TransferenciaValores transferencia = (TransferenciaValores) iterTransferencias.next();
      cargarRegistroTransferencia(dataSet,transferencia);
    }

  }

  private IDataSet getDataSetTransferencias() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpTransferencias");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 100));
    dataset.fieldDef(new Field("caja_origen", Field.STRING, 100));
    dataset.fieldDef(new Field("caja_destino", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroTransferencia(IDataSet dataset,
                                           TransferenciaValores transferencia)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", transferencia.getOIDInteger());
    dataset.fieldValue("oid_cco", transferencia.getOIDInteger());
    dataset.fieldValue("comprobante", transferencia.getCodigo());
    dataset.fieldValue("fec_emision", transferencia.getEmision());
    dataset.fieldValue("activo", transferencia.isActivo());
    dataset.fieldValue("caja_origen", transferencia.getCajaOrigen().getDescripcion());
    dataset.fieldValue("caja_destino", transferencia.getCajaDestino().getDescripcion());
  }

}
