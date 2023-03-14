package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.CondicionPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComportamientoCondPago extends Operation {

  public TraerComportamientoCondPago() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    IDataSet ds = getDataSetCompo();
    Integer oidCondPago = mapaDatos.getInteger("oid_cond_pago");
    CondicionPago  condPago = CondicionPago.findByOid(oidCondPago,getSesion());
    cargarCompo(ds,condPago.getOIDInteger(),condPago.getCodigo(),condPago.getDescripcion(),condPago.getComportamiento());
    writeCliente(ds);
  }

  private IDataSet getDataSetCompo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TComportamientoCondPago");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo", Field.STRING, 30));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 100));
    return dataset;
  }

  private void cargarCompo(IDataSet dataset,
                         Integer oid,
                         String codigo,
                         String descripcion,
                         String comportamiento) {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("comportamiento", comportamiento);
  }
}
