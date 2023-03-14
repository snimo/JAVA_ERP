package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.DevolucionVtasCab;
import com.srn.erp.ventas.bm.DevolucionVtasDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDevolucionesVtas extends Operation {

	public TraerDevolucionesVtas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		DevolucionVtasCab devolucion = DevolucionVtasCab.findByOid(mapaDatos.getInteger("oid"), getSesion());
		
		IDataSet dsDevolucionCab = this.getDataSetDevVtasCab();
		IDataSet dsDevolucionDet = this.getDataSetDevVtasDet();
		
		if (devolucion != null) {
			cargarRegistro(dsDevolucionCab, devolucion);
			Iterator iterDetDev = 
				devolucion.getDetallesDev().iterator();
			while (iterDetDev.hasNext()) {
				DevolucionVtasDet devDet = (DevolucionVtasDet) iterDetDev.next();
				cargarRegistroDevDet(dsDevolucionDet, devolucion, devDet);
			}
			
		}
		
		writeCliente(dsDevolucionCab);
		writeCliente(dsDevolucionDet);
		
	}

	private IDataSet getDataSetDevVtasCab() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TDevolucionCab");
		dataset.fieldDef(new Field("oid_devolucion_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc", Field.STRING, 50));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_sujeto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_sujeto", Field.STRING, 50));
		dataset.fieldDef(new Field("rz_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		dataset.fieldDef(new Field("tipo_devolucion", Field.STRING, 50));
		dataset.fieldDef(new Field("tipo_oper", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_pedido", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_cco_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_factura", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_cco_rto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_remito", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetDevVtasDet() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TDevolucionDet");
		dataset.fieldDef(new Field("oid_devolucion_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_devolucion_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto",Field.INTEGER, 0));
		dataset.fieldDef(new Field("label_emitir_nc",Field.STRING, 50));
		dataset.fieldDef(new Field("oid_um_dev_1",Field.INTEGER, 50));
		dataset.fieldDef(new Field("cod_producto",Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto",Field.STRING, 255));
		dataset.fieldDef(new Field("observaciones",Field.MEMO, 0));
		dataset.fieldDef(new Field("oid_motivo_devolucion",Field.INTEGER, 50));
		dataset.fieldDef(new Field("label_motivo_devolucion",Field.STRING, 50));
		dataset.fieldDef(new Field("modif_precio",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("pend_emitir_nc",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("label_cant_dev_1",Field.STRING, 50));
		dataset.fieldDef(new Field("cant_dev_1",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("label_modif_precio",Field.STRING, 50));
		dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_ped_det",Field.INTEGER, 50));
		dataset.fieldDef(new Field("ref_ped_det",Field.STRING, 50));
		dataset.fieldDef(new Field("oid_rto_det",Field.INTEGER, 50));
		dataset.fieldDef(new Field("ref_rto_det",Field.STRING, 50));
		dataset.fieldDef(new Field("oid_fact_det",Field.INTEGER, 50));
		dataset.fieldDef(new Field("ref_fact_det",Field.STRING, 50));
		dataset.fieldDef(new Field("label_ref_pedido",Field.STRING, 50));
		dataset.fieldDef(new Field("label_ref_remito",Field.STRING, 50));
		dataset.fieldDef(new Field("label_ref_factura",Field.STRING, 50));
		dataset.fieldDef(new Field("label_obs",Field.STRING, 50));
		return dataset;
	}
	

	private void cargarRegistro(IDataSet dataset, DevolucionVtasCab devVtasCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_devolucion_cab", devVtasCab.getOIDInteger());
		dataset.fieldValue("oid_talonario", devVtasCab.getTalonario().getOIDInteger());
		dataset.fieldValue("oid_tc", devVtasCab.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_tc", devVtasCab.getTipoCompro().getCodigo());
		dataset.fieldValue("letra", devVtasCab.getLetra());
		dataset.fieldValue("oid_lug_emi", devVtasCab.getLugarEmision().getOIDInteger());
		dataset.fieldValue("nro_lug_emi", devVtasCab.getLugarEmision().getLugemi());
		dataset.fieldValue("nro_ext", devVtasCab.getNroExt());
		dataset.fieldValue("fecha", devVtasCab.getEmision());
		dataset.fieldValue("oid_sujeto", devVtasCab.getSujeto().getOIDInteger());
		dataset.fieldValue("cod_sujeto", devVtasCab.getSujeto().getCodigo());
		dataset.fieldValue("rz_sujeto", devVtasCab.getSujeto().getRazon_social());
		dataset.fieldValue("activo", devVtasCab.isActivo());
		dataset.fieldValue("comentario", devVtasCab.getComentario());
		dataset.fieldValue("tipo_devolucion", devVtasCab.getTipoDevolucion());
		dataset.fieldValue("tipo_oper", devVtasCab.getTipoOperacion());
		if (devVtasCab.getPedidoCab() != null) {
			dataset.fieldValue("oid_cco_ped", devVtasCab.getPedidoCab().getOIDInteger());
			dataset.fieldValue("codigo_pedido", devVtasCab.getPedidoCab().getCodigo());
		} else {
			dataset.fieldValue("oid_cco_ped", "");
			dataset.fieldValue("codigo_pedido", "");
		}
		if (devVtasCab.getFacturaCab() != null) {
			dataset.fieldValue("oid_cco_fact", devVtasCab.getFacturaCab().getOIDInteger());
			dataset.fieldValue("codigo_factura", devVtasCab.getFacturaCab().getCodigo());
		} else {
			dataset.fieldValue("oid_cco_fact", "");
			dataset.fieldValue("codigo_factura", "");
		}
		if (devVtasCab.getRemitoCab() != null) {
			dataset.fieldValue("oid_cco_rto", devVtasCab.getRemitoCab().getOIDInteger());
			dataset.fieldValue("codigo_remito", devVtasCab.getRemitoCab().getCodigo());
		} else {
			dataset.fieldValue("oid_cco_rto", "");
			dataset.fieldValue("codigo_remito", "");
		}

	}
	
	private void cargarRegistroDevDet(
			IDataSet dataset, 
			DevolucionVtasCab devVtasCab,
			DevolucionVtasDet devVtasDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_devolucion_det", devVtasDet.getOIDInteger());
		dataset.fieldValue("oid_devolucion_cab", devVtasCab.getOIDInteger());
		dataset.fieldValue("oid_producto",devVtasDet.getProducto().getOIDInteger());
		dataset.fieldValue("label_emitir_nc","Emitir N.C.");
		dataset.fieldValue("oid_um_dev_1",devVtasDet.getUnidad_medida().getOIDInteger());
		dataset.fieldValue("cod_producto",devVtasDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto",devVtasDet.getProducto().getDescripcion());
		dataset.fieldValue("observaciones",devVtasDet.getObservaciones());
		dataset.fieldValue("oid_motivo_devolucion",devVtasDet.getMotivo_devolucion().getOIDInteger());
		dataset.fieldValue("label_motivo_devolucion","Motivo Devolución");
		dataset.fieldValue("modif_precio",devVtasDet.isModif_precio());
		dataset.fieldValue("pend_emitir_nc",devVtasDet.isPend_emitir_nc());
		dataset.fieldValue("label_cant_dev_1","Cantidad");
		dataset.fieldValue("cant_dev_1",devVtasDet.getCantidad_devuelta());
		dataset.fieldValue("label_modif_precio","Modif. Precio");
		dataset.fieldValue("activo",devVtasDet.isActivo());
		if (devVtasDet.getPedido_det()!=null)
			dataset.fieldValue("oid_ped_det",devVtasDet.getPedido_det().getOIDInteger());
		else
			dataset.fieldValue("oid_ped_det","");
		if (devVtasDet.getPedido_det()!=null)
			dataset.fieldValue("ref_ped_det",devVtasDet.getPedido_det().getReferencia());
		else
			dataset.fieldValue("ref_ped_det","");
		if (devVtasDet.getRemito_det()!=null)
			dataset.fieldValue("oid_rto_det",devVtasDet.getRemito_det().getOIDInteger());
		else
			dataset.fieldValue("oid_rto_det","");
		if (devVtasDet.getRemito_det()!=null)
			dataset.fieldValue("ref_rto_det",devVtasDet.getRemito_det().getRemito_cab().getCodigo());
		else
			dataset.fieldValue("ref_rto_det","");
		if (devVtasDet.getFactura_det()!=null)
			dataset.fieldValue("oid_fact_det",devVtasDet.getFactura_det().getOIDInteger());
		else
			dataset.fieldValue("oid_fact_det","");
		if (devVtasDet.getFactura_det()!=null)
			dataset.fieldValue("ref_fact_det",devVtasDet.getFactura_det().getComprocab().getCodigo());
		else
			dataset.fieldValue("ref_fact_det","");
		dataset.fieldValue("label_ref_pedido","Ref. Pedido");
		dataset.fieldValue("label_ref_remito","Ref. Remito");
		dataset.fieldValue("label_ref_factura","Ref. Factura");
		dataset.fieldValue("label_obs","Obs.");
		

	}
	

}
