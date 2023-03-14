package com.srn.erp.ventas.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.ventas.bm.CondicionPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCondPagoSucursal extends Operation {

  public TraerCondPagoSucursal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet ds = getDataSetCondicionPago();
    List listaCondPago = CondicionPago.getCondPagoHabSuc(getSesion());
    Iterator iterCondPago = listaCondPago.iterator();
    while (iterCondPago.hasNext()) {
      CondicionPago condPago = (CondicionPago)  iterCondPago.next();
      cargarRegistroCondicionPago(ds,condPago);
    }
    writeCliente(ds);
  }

  private IDataSet getDataSetCondicionPago() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCondicionPago");
    dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 20));
    dataset.fieldDef(new Field("oid_cond_vta", Field.INTEGER, 0));
    dataset.fieldDef(new Field("porc_dto", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("porc_reca", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_tar_credito", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_grupo_cp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }


  private void cargarRegistroCondicionPago(IDataSet dataset,
                         CondicionPago condPago) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cond_pago", condPago.getOIDInteger());
    dataset.fieldValue("codigo", condPago.getCodigo());
    dataset.fieldValue("descripcion", condPago.getDescripcion());
    dataset.fieldValue("comportamiento", condPago.getComportamiento());
    if (condPago.getCondicion_vta()!=null)
      dataset.fieldValue("oid_cond_vta", condPago.getCondicion_vta().getOIDInteger());
    else
      dataset.fieldValue("oid_cond_vta", 0);
    dataset.fieldValue("porc_dto", condPago.getPorc_desc());
    dataset.fieldValue("porc_reca", condPago.getPorc_reca());
    if (condPago.getTarjeta_credito()!=null)
      dataset.fieldValue("oid_tar_credito", condPago.getTarjeta_credito().getOIDInteger());
    else
      dataset.fieldValue("oid_tar_credito", 0);
    dataset.fieldValue("oid_grupo_cp", condPago.getGrupo_cond_pago().getOIDInteger());
    dataset.fieldValue("activo", condPago.isActivo());
  }

}
