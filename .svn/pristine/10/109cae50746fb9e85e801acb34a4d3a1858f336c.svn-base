package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CotizacionProveedorDet;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerItemCanastaCotProv extends Operation {

  public TraerItemCanastaCotProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	Integer oidCotProvDet = mapaDatos.getInteger("oid_cod_prov_det");
	CotizacionProveedorDet cotProvDet = CotizacionProveedorDet.findByOidProxy(oidCotProvDet, this.getSesion());

	IDataSet ds = this.getDSAgregarItemCotProv();
	cargarRegistro(ds, cotProvDet);
    writeCliente(ds);
  }

  private IDataSet getDSAgregarItemCotProv() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAgregarItemCanasta");
    dataset.fieldDef(new Field("oid_cot_prov_det", Field.INTEGER, 0));
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
    dataset.fieldDef(new Field("oid_proveedor",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_proveedor",Field.STRING, 50));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cond_pago",Field.INTEGER, 0));
    
    
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
		  					  CotizacionProveedorDet cotProvDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cot_prov_det", cotProvDet.getOIDInteger());
    dataset.fieldValue("oid_producto", cotProvDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", cotProvDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", cotProvDet.getProducto().getDescripcion());
    if (cotProvDet.getUnidad_medida()!=null)
    	dataset.fieldValue("oid_um", cotProvDet.getUnidad_medida().getOIDInteger());
    else
        if (cotProvDet.getProducto().getUm_cpra()!=null)
        	dataset.fieldValue("oid_um", cotProvDet.getProducto().getUm_cpra().getOIDInteger());
        else
        	dataset.fieldValue("oid_um", "");
    dataset.fieldValue("cantidad", cotProvDet.getCant_presu());
    dataset.fieldValue("fec_requerida", cotProvDet.getFec_ent());
    dataset.fieldValue("desc_adic_producto", cotProvDet.getComentario());
    dataset.fieldValue("precio", cotProvDet.getPrecio());
    
    CalculadorMoney calcTotal = new CalculadorMoney(new Money(cotProvDet.getCant_presu()));
    calcTotal.multiplicarPor(cotProvDet.getPrecio());
    
    dataset.fieldValue("total", calcTotal.getResultDecimal());
    dataset.fieldValue("asociar_a", "ITEM_CP");
    dataset.fieldValue("referencia", cotProvDet.getCotizacion_proveedor().getCodigo()+"/"+cotProvDet.getNroItem());
    dataset.fieldValue("oid_cco_referencia",cotProvDet.getCotizacion_proveedor().getOIDInteger());
    dataset.fieldValue("oid_cco_referencia_det",cotProvDet.getOIDInteger());
    dataset.fieldValue("oid_proveedor",cotProvDet.getCotizacion_proveedor().getProveedor().getOIDInteger());
    dataset.fieldValue("cod_proveedor",cotProvDet.getCotizacion_proveedor().getProveedor().getCodigo());
    dataset.fieldValue("oid_moneda",cotProvDet.getMoneda().getOIDInteger());
    
    if (cotProvDet.getCotizacion_proveedor().getCond_pago_1()!=null)
    	dataset.fieldValue("oid_cond_pago",cotProvDet.getCotizacion_proveedor().getCond_pago_1().getOIDInteger());
    else
    	dataset.fieldValue("oid_cond_pago","");
        
    
  }
}
