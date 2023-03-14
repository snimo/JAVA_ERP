package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerProdParaPedDepo extends Operation {

  public TraerProdParaPedDepo() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet ds = getDSProdParaPedDepo();
    PedidoCab pedido = PedidoCab.findByOidProxy(mapaDatos.getInteger("oid_cco_ped"), this.getSesion());
    
    Iterator iterDetPendEnt = 
    	pedido.getDetallesPendEnt().iterator();
    while (iterDetPendEnt.hasNext()) {
    	PedidoDet pedidoDet = (PedidoDet) iterDetPendEnt.next();
    	cargarRegistro(ds, pedidoDet);
    }
    writeCliente(ds);
    
  }

  private IDataSet getDSProdParaPedDepo() {
    IDataSet dataset = new TDataSet();
    dataset.create("TProdParaPedidoDepo");
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_um", Field.STRING, 50));
    dataset.fieldDef(new Field("cant_sugerida", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("fec_requerida", Field.DATE, 0));
    dataset.fieldDef(new Field("observaciones", Field.MEMO, 0));
    dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("referencia", Field.STRING, 100));
    return dataset;
  }


  private void cargarRegistro(IDataSet dataset,
                         	  PedidoDet pedidoDet) throws BaseException {
	  
	  dataset.append();
	  dataset.fieldValue("oid_producto", pedidoDet.getProducto().getOIDInteger());
	  dataset.fieldValue("cod_producto", pedidoDet.getProducto().getCodigo());
	  dataset.fieldValue("desc_producto", pedidoDet.getProducto().getDescripcion());
	  dataset.fieldValue("oid_um", pedidoDet.getUni_med_ori().getOIDInteger());
	  dataset.fieldValue("cod_um", pedidoDet.getUni_med_ori().getCodigo());
	  dataset.fieldValue("cant_sugerida", pedidoDet.getCantPendDespUniOri());
	  dataset.fieldValue("fec_requerida", pedidoDet.getFechaEntrega());
	  dataset.fieldValue("observaciones", pedidoDet.getComentario());
	  dataset.fieldValue("oid_ped_det", pedidoDet.getOIDInteger());
	  dataset.fieldValue("referencia", pedidoDet.getReferencia());

  }

}
