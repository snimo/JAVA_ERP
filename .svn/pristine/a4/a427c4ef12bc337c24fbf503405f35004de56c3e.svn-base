package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.IngStockDevVtasDet;
import com.srn.erp.ventas.bm.IngresoDevolucionStockCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerIngDevStock extends Operation {

	public TraerIngDevStock() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IngresoDevolucionStockCab ingresoDevolucion = IngresoDevolucionStockCab.findByOid(mapaDatos.getInteger("oid"), getSesion());
		
		IDataSet dsIngDevolucionCab = this.getDataSetIngDevCab();
		IDataSet dsIngDevolucionDet = this.getDataSetIngDevDet();
		
		if (ingresoDevolucion != null) {
			cargarRegistro(dsIngDevolucionCab, ingresoDevolucion);
			Iterator iterDetDev = 
				ingresoDevolucion.getDetallesDev().iterator();
			while (iterDetDev.hasNext()) {
				IngStockDevVtasDet ingDevDet = (IngStockDevVtasDet) iterDetDev.next();
				cargarRegistroDevDet(dsIngDevolucionDet, ingresoDevolucion, ingDevDet);
			}
			
		}
		
		writeCliente(dsIngDevolucionCab);
		writeCliente(dsIngDevolucionDet);
		
	}

	private IDataSet getDataSetIngDevCab() throws BaseException {
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
		dataset.fieldDef(new Field("oid_talonario_origen", Field.INTEGER, 0));
		return dataset;
	}
	
	private IDataSet getDataSetIngDevDet() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TDevolucionDet");
		dataset.fieldDef(new Field("oid_devolucion_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_devolucion_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto",Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto",Field.STRING, 255));
		dataset.fieldDef(new Field("cantidad",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mov_stock",Field.INTEGER, 0));
		dataset.fieldDef(new Field("titulo", Field.STRING, 255));
		return dataset;
	}
	

	private void cargarRegistro(IDataSet dataset, IngresoDevolucionStockCab devVtasCab) throws BaseException {
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
		dataset.fieldValue("oid_sujeto", "");
		dataset.fieldValue("cod_sujeto", "");
		dataset.fieldValue("rz_sujeto", "");
		dataset.fieldValue("activo", devVtasCab.isActivo());
		dataset.fieldValue("comentario", devVtasCab.getComentario());
		dataset.fieldValue("oid_talonario_origen", devVtasCab.getTalonarioOrigen().getOIDInteger());

	}
	
	private void cargarRegistroDevDet(
			IDataSet dataset, 
			IngresoDevolucionStockCab devVtasCab,
			IngStockDevVtasDet devVtasDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_devolucion_det", devVtasDet.getOIDInteger());
		dataset.fieldValue("oid_devolucion_cab", devVtasCab.getOIDInteger());
		dataset.fieldValue("oid_producto",devVtasDet.getDevolucion_det().getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto",devVtasDet.getDevolucion_det().getProducto().getCodigo());
		dataset.fieldValue("desc_producto",devVtasDet.getDevolucion_det().getProducto().getDescripcion());
		dataset.fieldValue("cantidad",devVtasDet.getCantidad());
		dataset.fieldValue("oid_um",devVtasDet.getUnidad_medida().getOIDInteger());
		dataset.fieldValue("oid_mov_stock",devVtasDet.getMovimiento_stock().getOIDInteger());
		dataset.fieldValue("titulo", devVtasDet.getDevolucion_det().getTitulo());

	}
	

}
