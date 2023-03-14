package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.ventas.bm.DevolucionVtasDet;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDevPendIngStock extends Operation {

  public TraerDevPendIngStock() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	Integer oidDevCab = mapaDatos.getInteger("oid_dev_cab");
  	Talonario talonario = null;
  	Sujeto sujeto = null;
  	FacturaCab factura = null;
  	RemitoCab remito = null;
  	PedidoCab pedido = null;
  	Integer nroExt = null;
  	java.util.Date fecDesde = null;
  	java.util.Date fecHasta = null;
  	
  	if (mapaDatos.containsKey("oid_talonario"))
  		talonario = Talonario.findByOidProxy(mapaDatos.getInteger("oid_talonario"), this.getSesion());
  	
  	if (mapaDatos.containsKey("oid_sujeto"))
  		sujeto = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_sujeto"), this.getSesion());
  	
  	if (mapaDatos.containsKey("oid_cco_fact"))
  		factura = FacturaCab.findByOidProxy(mapaDatos.getInteger("oid_cco_fact"), this.getSesion());
  	
  	if (mapaDatos.containsKey("oid_cco_rto"))
  		remito = RemitoCab.findByOidProxy(mapaDatos.getInteger("oid_cco_rto"), this.getSesion());
  	
  	if (mapaDatos.containsKey("oid_cco_ped"))
  		pedido = PedidoCab.findByOidProxy(mapaDatos.getInteger("oid_cco_ped"), this.getSesion());

  	if (mapaDatos.containsKey("NRO_EXT"))
  		nroExt = mapaDatos.getInteger("NRO_EXT");
  	
  	if (mapaDatos.containsKey("FEC_DESDE"))
  		fecDesde = mapaDatos.getDate("FEC_DESDE");
  	
  	if (mapaDatos.containsKey("FEC_HASTA"))
  		fecDesde = mapaDatos.getDate("FEC_HASTA");
  	
  	IDataSet ds = this.getDataSetDevPendIngStock();
  	Iterator iterDevVtasDet =
  		DevolucionVtasDet.getPendIngStock(talonario, sujeto, factura, remito, pedido, nroExt, fecDesde, fecHasta, this.getSesion()).iterator();
  	while (iterDevVtasDet.hasNext()) {
  		DevolucionVtasDet devVtasDet = (DevolucionVtasDet) iterDevVtasDet.next();
  		cargarRegistro(ds, oidDevCab, devVtasDet);
  	}
  	writeCliente(ds);
  	
  	
  	
  }

  private IDataSet getDataSetDevPendIngStock() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDevolucionDet");
    dataset.fieldDef(new Field("oid_devolucion_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_devolucion_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("cant_devuelta", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_mov_stock", Field.INTEGER, 0));
    dataset.fieldDef(new Field("titulo", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_dev_det_ori", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
		  					  Integer oidDevCab,	
                         	  DevolucionVtasDet devolucionVtasDet) throws BaseException {
  	dataset.append();
  	dataset.fieldValue("oid_devolucion_det", devolucionVtasDet.getOIDInteger());
  	dataset.fieldValue("oid_devolucion_cab", oidDevCab);
  	dataset.fieldValue("oid_producto", devolucionVtasDet.getProducto().getOIDInteger());
  	dataset.fieldValue("cod_producto", devolucionVtasDet.getProducto().getCodigo());
  	dataset.fieldValue("desc_producto", devolucionVtasDet.getProducto().getDescripcion());
  	dataset.fieldValue("cant_devuelta", devolucionVtasDet.getCantPendIngStock());
  	dataset.fieldValue("cantidad", devolucionVtasDet.getCantPendIngStock());
  	dataset.fieldValue("oid_um", devolucionVtasDet.getUnidad_medida().getOIDInteger());
  	dataset.fieldValue("oid_mov_stock", "");
  	dataset.fieldValue("titulo", devolucionVtasDet.getTitulo() );
  	dataset.fieldValue("oid_dev_det_ori", devolucionVtasDet.getOIDInteger());
  }
  
}
