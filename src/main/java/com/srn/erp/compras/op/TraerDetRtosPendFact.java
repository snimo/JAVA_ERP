package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.InformeRecepcionDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDetRtosPendFact extends Operation {

  public TraerDetRtosPendFact() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet ds =  getDataSetInfRecPendFact(); 
	  
	IDataSet dataset = mapaDatos.getDataSet("TListaInfRec");
	dataset.first();
	while (!dataset.EOF()) {
		Integer oidInfRec = dataset.getInteger("oid_inf_rec");
		InformeRecepcion informeRecepcion = InformeRecepcion.findByOid(oidInfRec,getSesion());
		Iterator iterDetInfRecPendFact = informeRecepcion.getDetallesInfRecPendFact().iterator();
		while (iterDetInfRecPendFact.hasNext()) {
			InformeRecepcionDet infRecDet = (InformeRecepcionDet) iterDetInfRecPendFact.next();
			cargarRegistroInfRec(ds,informeRecepcion,infRecDet);
		}
		dataset.next();
	}
    writeCliente(ds);
  
  }

  private IDataSet getDataSetInfRecPendFact() {
    IDataSet dataset = new TDataSet();
    dataset.create("TDetRtosPendFact");
    dataset.fieldDef(new Field("oid_inf_rec_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_inf_rec",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_oc",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_oc_det",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_oc_det_ent",Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_oc",Field.STRING, 50));
    dataset.fieldDef(new Field("codigo_inf_rec",Field.STRING, 50));
    dataset.fieldDef(new Field("oid_producto",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto",Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto",Field.STRING, 100));
    dataset.fieldDef(new Field("recibido_uc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("facturado_uc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("pend_fact_uc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("precio_oc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER,0));
    dataset.fieldDef(new Field("cod_moneda",Field.STRING,20));
    dataset.fieldDef(new Field("oid_conc_fact", Field.INTEGER,0));
    return dataset;
  }

  private void cargarRegistroInfRec(IDataSet dataset,
		  							InformeRecepcion infRec,
		  							InformeRecepcionDet infRecDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_inf_rec_det", infRecDet.getOIDInteger());
    dataset.fieldValue("oid_inf_rec", infRec.getOIDInteger());
    dataset.fieldValue("oid_oc", infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getOIDInteger());
    dataset.fieldValue("oid_oc_det",infRecDet.getOrdenDeCompraDet().getOIDInteger());
    dataset.fieldValue("oid_oc_det_ent",infRecDet.getOrdenDeCompraDet().getOIDInteger());
    dataset.fieldValue("codigo_oc",infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getCodigo());
    dataset.fieldValue("codigo_inf_rec",infRecDet.getInforme_recepcion().getCodigo());
    dataset.fieldValue("oid_producto",infRecDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto",infRecDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto",infRecDet.getProducto().getDescripcion());
    dataset.fieldValue("recibido_uc",infRecDet.getCant_rec_en_uc());
    dataset.fieldValue("facturado_uc",infRecDet.getCantFactUC());
    dataset.fieldValue("pend_fact_uc",infRecDet.getCantPendFactUC());
    dataset.fieldValue("precio_oc",infRecDet.getOrdenDeCompraDet().getPrecio());
    dataset.fieldValue("oid_moneda",infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getMoneda().getOIDInteger());
    dataset.fieldValue("cod_moneda",infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getMoneda().getCodigo());
    if (infRecDet.getProducto().getConcFactProv()==null)
    	throw new ExceptionValidation(null,"Falta configurar un concepto de factura proveedor para el producto "+
    			infRecDet.getProducto().getCodigo()+" - "+ infRecDet.getProducto().getDescripcion());
    dataset.fieldValue("oid_conc_fact",infRecDet.getProducto().getConcFactProv().getOIDInteger());
  }
}
