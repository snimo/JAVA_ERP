package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerItemCanastaPedido extends Operation {

  public TraerItemCanastaPedido() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	Integer oidPedDet = mapaDatos.getInteger("oid_ped_det");
	PedidoDet pedidoDet = PedidoDet.findByOidProxy(oidPedDet, this.getSesion());

	IDataSet ds = this.getDSAgregarItemPedido();
	cargarRegistro(ds, pedidoDet);
    writeCliente(ds);
  }

  private IDataSet getDSAgregarItemPedido() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAgregarItemCanasta");
    dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("fec_requerida", Field.DATE, 0));
    dataset.fieldDef(new Field("desc_adic_producto", Field.MEMO, 0));
    dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("total", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("asociar_a", Field.STRING, 100));
    dataset.fieldDef(new Field("referencia", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_cco_referencia",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco_referencia_det",Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                              PedidoDet pedidoDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_ped_det", pedidoDet.getOIDInteger());
    dataset.fieldValue("oid_producto", pedidoDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", pedidoDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", pedidoDet.getProducto().getDescripcion());
    if (pedidoDet.getProducto().getUm_cpra()!=null)
    	dataset.fieldValue("oid_um", pedidoDet.getProducto().getUm_cpra().getOIDInteger());
    else if (pedidoDet.getUni_med_ori()!=null)
    	dataset.fieldValue("oid_um", pedidoDet.getUni_med_ori().getOIDInteger());
    else
    	dataset.fieldValue("oid_um", "");
    dataset.fieldValue("cantidad", pedidoDet.getCantSinReserNiSepa());
    dataset.fieldValue("fec_requerida", pedidoDet.getFechaEntrega());
    dataset.fieldValue("desc_adic_producto", pedidoDet.getComentario());
    dataset.fieldValue("precio", new Money(0));
    dataset.fieldValue("total", new Money(0));
    dataset.fieldValue("asociar_a", "ITEM_P");
    dataset.fieldValue("referencia", pedidoDet.getPedido().getCodigo()+"/"+pedidoDet.getNroRenglon());
    dataset.fieldValue("oid_cco_referencia",pedidoDet.getPedido().getOIDInteger());
    dataset.fieldValue("oid_cco_referencia_det",pedidoDet.getOIDInteger());
  }
}
