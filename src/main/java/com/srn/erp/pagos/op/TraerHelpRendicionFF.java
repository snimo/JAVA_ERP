package com.srn.erp.pagos.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.pagos.bm.RendicionFondoFijo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpRendicionFF extends Operation {

  public TraerHelpRendicionFF() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = this.getDataSetRendFF();
    traerRendFF(ds,mapaDatos);
    writeCliente(ds);
  }

  private void traerRendFF(IDataSet dataSet ,MapDatos mapaDatos) throws BaseException {

    Integer nroExtDesde = null;
    Integer nroExtHasta = null;
    java.util.Date fecDesde = null;
    java.util.Date fecHasta = null;
    Proveedor proveedor = null;

    if (mapaDatos.containsKey("nro_ext_desde"))
      nroExtDesde = mapaDatos.getInteger("nro_ext_desde");
    if (mapaDatos.containsKey("nro_ext_hasta"))
      nroExtHasta = mapaDatos.getInteger("nro_ext_hasta");
    if (mapaDatos.containsKey("fec_desde"))
      fecDesde = mapaDatos.getDate("fec_desde");
    if (mapaDatos.containsKey("fec_hasta"))
      fecHasta = mapaDatos.getDate("fec_hasta");
    if (mapaDatos.containsKey("oid_proveedor"))
      proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"),getSesion());

    List listaRendFF =
        RendicionFondoFijo.getHelpRendicionFF(
        		nroExtDesde,
        		nroExtHasta,
        		proveedor,fecDesde,fecHasta,getSesion());
    Iterator iterRendFF = listaRendFF.iterator();
    while (iterRendFF.hasNext()) {
      RendicionFondoFijo rendicionFondoFijo = (RendicionFondoFijo) iterRendFF.next();
      cargarRegistroRendFF(dataSet,rendicionFondoFijo);
    }

  }

  private IDataSet getDataSetRendFF() {
    IDataSet dataset = new TDataSet();
    dataset.create("THelpRendicionFF");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 100));
    return dataset;
  }

  private void cargarRegistroRendFF(IDataSet dataset,
                                    RendicionFondoFijo rendFF)
    throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid", rendFF.getOIDInteger());
    dataset.fieldValue("oid_cco", rendFF.getOIDInteger());
    dataset.fieldValue("comprobante", rendFF.getCodigo());
    dataset.fieldValue("fec_emision", rendFF.getEmision());
    dataset.fieldValue("activo", rendFF.isActivo());
  }

}
