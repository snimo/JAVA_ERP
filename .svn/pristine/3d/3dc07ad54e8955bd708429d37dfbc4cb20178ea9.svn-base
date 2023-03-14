package com.srn.erp.contabilidad.op;

import com.srn.erp.contabilidad.bm.ComproSubReparto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComproSubReparto extends Operation {

  public TraerComproSubReparto() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    ComproSubReparto comproSubReparto = null;
    Integer oid = mapaDatos.getInteger("oid");
    comproSubReparto = ComproSubReparto.findByOid(oid, getSesion());
    
    

    IDataSet dsSubReparto = this.getDataSetEjecucionSubReparto();
    cargarRegistroComponente(dsSubReparto, comproSubReparto);
    writeCliente(dsSubReparto);
    
  }

  private IDataSet getDataSetEjecucionSubReparto() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEjecucionSubReparto");
    dataset.fieldDef(new Field("oid_cco_subreparto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_desde", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_hasta", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_imputacion", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_subreparto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_subreparto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_subreparto", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  

  private void cargarRegistroComponente(IDataSet dataset,
                         ComproSubReparto comproSubReparto) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cco_subreparto", comproSubReparto.getOIDInteger());
    dataset.fieldValue("comprobante", comproSubReparto.getCodigo());
    dataset.fieldValue("fec_desde", comproSubReparto.getFec_desde());
    dataset.fieldValue("fec_hasta", comproSubReparto.getFec_hasta());
    dataset.fieldValue("fec_imputacion", comproSubReparto.getImputac());
    dataset.fieldValue("oid_subreparto", comproSubReparto.getSubReparto().getOIDInteger());
    dataset.fieldValue("cod_subreparto", comproSubReparto.getSubReparto().getCodigo());
    dataset.fieldValue("desc_subreparto", comproSubReparto.getSubReparto().getDescripcion());
    dataset.fieldValue("activo", comproSubReparto.isActivo());
  }

}
