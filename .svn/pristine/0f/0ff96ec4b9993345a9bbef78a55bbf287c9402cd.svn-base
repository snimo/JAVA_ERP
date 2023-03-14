package com.srn.erp.contabilidad.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.AsientoManual;
import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpIngresoAsientos extends Operation {

  public TraerHelpIngresoAsientos() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = this.getDataSet();
    traerIngresoAsientos(ds,mapaDatos);
    writeCliente(ds);
  }

  private void traerIngresoAsientos(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    java.util.Date fecImputacDesde = null;
    java.util.Date fecImputacHasta = null;    
    CuentaImputable cuenta = null;

    if (mapaDatos.containsKey("nro_ext_desde"))
      nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
    if (mapaDatos.containsKey("nro_ext_hasta"))
      nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
    if (mapaDatos.containsKey("fec_desde"))
      fecDesde = mapaDatos.getDate("fec_desde");
    if (mapaDatos.containsKey("fec_hasta"))
      fecHasta = mapaDatos.getDate("fec_hasta");
    
    if (mapaDatos.containsKey("fec_imputac_desde"))
        fecImputacDesde = mapaDatos.getDate("fec_imputac_desde");
    if (mapaDatos.containsKey("fec_imputac_hasta"))
        fecImputacHasta = mapaDatos.getDate("fec_imputac_hasta");    
    
    if (mapaDatos.containsKey("oid_ai"))
      cuenta = CuentaImputable.findByOidProxy(mapaDatos.getInteger("oid_ai"),this.getSesion());

    List listaAsientos =
        AsientoManual.getAsientosByHelp(
        		nroExtDesde,
        		nroExtHasta,
        		fecDesde,
        		fecHasta,
        		fecImputacDesde,
        		fecImputacHasta,
        		cuenta,
        		getSesion());
    Iterator iterAsientos = listaAsientos.iterator();
    while (iterAsientos.hasNext()) {
      AsientoManual asientoManual = (AsientoManual) iterAsientos.next();
      cargarRegistro(dataSet,asientoManual);
    }

  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpIngresoAsientos");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_imputacion", Field.DATE, 0));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 100));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                              AsientoManual asiento)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", asiento.getOID());
    dataset.fieldValue("oid_cco", asiento.getOID());
    dataset.fieldValue("comprobante", asiento.getCodigo());
    dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(asiento.getEmision()));
    dataset.fieldValue("fec_imputacion", Fecha.getddmmyyyy(asiento.getImputac()));
    dataset.fieldValue("comentario", asiento.getComentario());
    dataset.fieldValue("activo", asiento.isActivo());
     
  }

}
