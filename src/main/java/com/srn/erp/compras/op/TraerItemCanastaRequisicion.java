package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.RequisicionDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerItemCanastaRequisicion extends Operation {

  public TraerItemCanastaRequisicion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	Integer oidReqDet = mapaDatos.getInteger("oid_req_det");
	RequisicionDet requisicionDet = RequisicionDet.findByOidProxy(oidReqDet, this.getSesion());

	IDataSet ds = this.getDSAgregarItemPedido();
	cargarRegistro(ds, requisicionDet);
    writeCliente(ds);
  }

  private IDataSet getDSAgregarItemPedido() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAgregarItemCanasta");
    dataset.fieldDef(new Field("oid_req_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("fec_requerida", Field.DATE, 0));
    dataset.fieldDef(new Field("desc_adic_producto", Field.MEMO, 0));
    dataset.fieldDef(new Field("asociar_a", Field.STRING, 100));
    dataset.fieldDef(new Field("referencia", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_cco_referencia",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco_referencia_det",Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                              RequisicionDet requisicionDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_req_det", requisicionDet.getOIDInteger());
    dataset.fieldValue("oid_producto", requisicionDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", requisicionDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", requisicionDet.getProducto().getDescripcion());
    if (requisicionDet.getProducto().getUm_cpra()!=null)
    	dataset.fieldValue("oid_um", requisicionDet.getProducto().getUm_cpra().getOIDInteger());
    else if (requisicionDet.getUnidad_medida_req()!=null)
    	dataset.fieldValue("oid_um", requisicionDet.getUnidad_medida_req().getOIDInteger());
    else
    	dataset.fieldValue("oid_um", "");
    dataset.fieldValue("cantidad", requisicionDet.getcantPendCompra());
    dataset.fieldValue("fec_requerida", requisicionDet.getFec_requerida());
    dataset.fieldValue("desc_adic_producto", requisicionDet.getComentario());
    dataset.fieldValue("asociar_a", "ITEM_R");
    dataset.fieldValue("referencia", requisicionDet.getRequisicion().getCodigo()+"/"+requisicionDet.getRenglon());
    dataset.fieldValue("oid_cco_referencia",requisicionDet.getRequisicion().getOIDInteger());
    dataset.fieldValue("oid_cco_referencia_det",requisicionDet.getOIDInteger());
  }
}
