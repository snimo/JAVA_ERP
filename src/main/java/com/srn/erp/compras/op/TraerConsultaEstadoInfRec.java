package com.srn.erp.compras.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsultaEstadoInfRec extends Operation {

	private HashTableDatos condiciones = new HashTableDatos();
	private String estado = "";
	
	public TraerConsultaEstadoInfRec() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		cargarParametros(mapaDatos);
		traerConsultaInfRec();
	}

	public void traerConsultaInfRec() throws BaseException {

		IDataSet dataSetConsulta = getDataSetConsultaInfRec();
		List detallesInfRec = null;
		detallesInfRec = InformeRecepcionDet.getDetallesInfRec(condiciones,getSesion());
			
		Iterator iterDetInfRec = detallesInfRec.iterator();
		while (iterDetInfRec.hasNext()) {
			InformeRecepcionDet infRecDet = (InformeRecepcionDet) iterDetInfRec.next();
			cargarRegistroEstadoInfRec(dataSetConsulta,infRecDet);
		} 
		writeCliente(dataSetConsulta);
	}
	
	private void cargarParametros(MapDatos mapaDatos) throws BaseException {
		
		// Obtener el Proveedor
		if (mapaDatos.containsKey("oid_proveedor")) {
			Integer oidProveedor = mapaDatos.getInteger("oid_proveedor");
			Proveedor proveedor = Proveedor.findByOidProxy(oidProveedor,getSesion());
			condiciones.put(Proveedor.NICKNAME,proveedor);
		}
		
		// Obtener el Producto
		if (mapaDatos.containsKey("oid_producto")) {
			Integer oidProducto = mapaDatos.getInteger("oid_producto");
			Producto producto = Producto.findByOidProxy(oidProducto,getSesion());
			condiciones.put(Producto.NICKNAME,producto);
		}				
		
		// Obtener la fecha de emision desde
		if (mapaDatos.containsKey("fec_emi_desde")) {
			java.util.Date fecEmiDesde = mapaDatos.getDate("fec_emi_desde");
			condiciones.put("FEC_EMI_DESDE",fecEmiDesde);
		}		
		
		// Obtener la fecha de emision hasta
		if (mapaDatos.containsKey("fec_emi_hasta")) {
			java.util.Date fecEmiHasta = mapaDatos.getDate("fec_emi_hasta");
			condiciones.put("FEC_EMI_HASTA",fecEmiHasta);
		}		
		
		// Obtener el estado
		if (mapaDatos.containsKey("estado")) 
			condiciones.put("estado",mapaDatos.getString("estado"));
		
		// Obtener el Talonario
		if (mapaDatos.containsKey("oid_talonario")) {
			Integer oidTalonario = mapaDatos.getInteger("oid_talonario");
			Talonario talonario = Talonario.findByOidProxy(oidTalonario,getSesion());
			condiciones.put(Talonario.NICKNAME,talonario);
		}		
		
		// Obtener el Nro. Desde
		if (mapaDatos.containsKey("nro_desde")) {
			Integer nroDesde = mapaDatos.getInteger("nro_desde");
			condiciones.put("NRO_DESDE",nroDesde);
		}		
		
		// Obtener el Nro. Hasta
		if (mapaDatos.containsKey("nro_hasta")) {
			Integer nroHasta = mapaDatos.getInteger("nro_hasta");
			condiciones.put("NRO_HASTA",nroHasta);
		}		
	}

	
	private IDataSet getDataSetConsultaInfRec() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsEstadoInfRec");
		dataset.fieldDef(new Field("oid_co", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("fec_imputacion", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_prov",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prov",Field.STRING, 50));
		dataset.fieldDef(new Field("rs_prov",Field.STRING, 100));
		dataset.fieldDef(new Field("remito",Field.STRING, 50));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_producto",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto",Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto",Field.STRING, 100));
		dataset.fieldDef(new Field("oid_um_stock",Field.INTEGER, 0));
		dataset.fieldDef(new Field("recep_um_stock",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um_cpra",Field.INTEGER, 0));
		dataset.fieldDef(new Field("recep_um_cpra",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario_item",Field.STRING, 255));
		dataset.fieldDef(new Field("cant_a_cc_us",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_a_cc_uc",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("anulado",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("pend_cc",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("cant_ok_uc",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_ok_us",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_mal_uc",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_mal_us",Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarRegistroEstadoInfRec(IDataSet dataset,
										    InformeRecepcionDet informeRecepcionDet) throws BaseException {
		
		dataset.append();
		dataset.fieldValue("oid_co", informeRecepcionDet.getInforme_recepcion().getOIDInteger());
		dataset.fieldValue("comprobante", informeRecepcionDet.getInforme_recepcion().getCodigo());
		dataset.fieldValue("fec_imputacion", informeRecepcionDet.getInforme_recepcion().getImputac());
		dataset.fieldValue("oid_prov",informeRecepcionDet.getInforme_recepcion().getProveedor().getOIDInteger());
		dataset.fieldValue("cod_prov",informeRecepcionDet.getInforme_recepcion().getProveedor().getCodigo());
		dataset.fieldValue("rs_prov",informeRecepcionDet.getInforme_recepcion().getProveedor().getRazonsocial());
		dataset.fieldValue("remito",informeRecepcionDet.getInforme_recepcion().getRemito_prov());
		dataset.fieldValue("comentario", informeRecepcionDet.getInforme_recepcion().getComentario());
		dataset.fieldValue("oid_producto",informeRecepcionDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto",informeRecepcionDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto",informeRecepcionDet.getProducto().getDescripcion());
		dataset.fieldValue("oid_um_stock",informeRecepcionDet.getUnidadMedidaStock().getOIDInteger());
		dataset.fieldValue("recep_um_stock",informeRecepcionDet.getCant_rec_en_us());
		dataset.fieldValue("oid_um_cpra",informeRecepcionDet.getUnidadMedidaCompra().getOIDInteger());
		dataset.fieldValue("recep_um_cpra",informeRecepcionDet.getCant_rec_en_uc());
		dataset.fieldValue("comentario_item",informeRecepcionDet.getComentario());
		dataset.fieldValue("cant_a_cc_us",informeRecepcionDet.getCantPendCCEnUS());
		dataset.fieldValue("cant_a_cc_uc",informeRecepcionDet.getCantPendCCEnUC());
		dataset.fieldValue("anulado",informeRecepcionDet.isAnulado());
		dataset.fieldValue("pend_cc",informeRecepcionDet.isPendiente_cc());
		dataset.fieldValue("cant_ok_uc",informeRecepcionDet.getCant_ok_uc());
		dataset.fieldValue("cant_ok_us",informeRecepcionDet.getCant_ok_us());
		dataset.fieldValue("cant_mal_uc",informeRecepcionDet.getCant_mal_uc());
		dataset.fieldValue("cant_mal_us",informeRecepcionDet.getCant_mal_us());
	}
}
