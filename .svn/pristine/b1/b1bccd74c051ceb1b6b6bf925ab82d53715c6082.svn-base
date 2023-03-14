package com.srn.erp.compras.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.InformeControlCalidad;
import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsultaEstadoInfCC extends Operation {

	private HashTableDatos condiciones = new HashTableDatos();
	
	public TraerConsultaEstadoInfCC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		cargarParametros(mapaDatos);
		traerConsultaInfCC();
	}

	public void traerConsultaInfCC() throws BaseException {

		IDataSet dataSetConsulta = getDataSetConsultaInfCC();
		List detallesInfCC = null;
		detallesInfCC = InformeControlCalidadDet.getDetallesInfCCByCondiciones(condiciones,getSesion());
			
		Iterator iterDetInfCC = detallesInfCC.iterator();
		while (iterDetInfCC.hasNext()) {
			InformeControlCalidadDet infCCDet = (InformeControlCalidadDet) iterDetInfCC.next();
			cargarRegistroEstadoInfCC(dataSetConsulta,infCCDet);
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
		
		// Obtenerl el Informe de Control de calidad
		if (mapaDatos.containsKey("oid_cco_inf_cc")) {
			Integer oidInfCC = mapaDatos.getInteger("oid_cco_inf_cc");
			ComproCab comproCab = (ComproCab)ComproCab.findByOidCompro(oidInfCC,getSesion());
			condiciones.put(InformeControlCalidad.NICKNAME,comproCab);
		}
		
		// Obtenerl el Informe de Control de calidad
		if (mapaDatos.containsKey("oid_cco_inf_rec")) {
			Integer oidInfRec = mapaDatos.getInteger("oid_cco_inf_rec");
			ComproCab comproCab = (ComproCab)ComproCab.findByOidCompro(oidInfRec,getSesion());
			condiciones.put(InformeRecepcion.NICKNAME,comproCab);
		}
		
		
	}

	
	private IDataSet getDataSetConsultaInfCC() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsEstadoInfCC");
		dataset.fieldDef(new Field("oid_inf_cc_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_inf_cc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("inf_cc",Field.STRING, 50));
		dataset.fieldDef(new Field("inf_rec",Field.STRING, 50));
		dataset.fieldDef(new Field("remito",Field.STRING, 50));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("cant_recep", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("aceptado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("rechazado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("devuelto",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fecha_cc", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.DATE, 0));
		dataset.fieldDef(new Field("cod_proveedor",Field.STRING, 50));
		dataset.fieldDef(new Field("rs_proveedor",Field.STRING, 255));
		dataset.fieldDef(new Field("comentario_inf_cc",Field.STRING, 255));
		dataset.fieldDef(new Field("comentario_item",Field.STRING, 255));
		dataset.fieldDef(new Field("oid_um",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oc",Field.STRING, 500));
		dataset.fieldDef(new Field("pend_ret_prov", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEstadoInfCC(IDataSet dataset,
										    InformeControlCalidadDet infCCDet) throws BaseException {
		
		dataset.append();
		dataset.fieldValue("oid_inf_cc_det", infCCDet.getOIDInteger());
		dataset.fieldValue("oid_cco_inf_cc", infCCDet.getInforme_cc().getOIDInteger());
		dataset.fieldValue("inf_cc", infCCDet.getInforme_cc().getCodigo());
		dataset.fieldValue("inf_rec", infCCDet.getInforme_recepcion_det().getInforme_recepcion().getCodigo());
		dataset.fieldValue("remito", infCCDet.getInforme_recepcion_det().getInforme_recepcion().getRemito_prov());
		dataset.fieldValue("oid_producto", infCCDet.getInforme_recepcion_det().getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", infCCDet.getInforme_recepcion_det().getProducto().getCodigo());
		dataset.fieldValue("desc_producto", infCCDet.getInforme_recepcion_det().getProducto().getDescripcion());
		dataset.fieldValue("cant_recep", infCCDet.getInforme_recepcion_det().getCant_rec_en_us());
		dataset.fieldValue("aceptado", infCCDet.getCant_ok_us());
		dataset.fieldValue("rechazado", infCCDet.getCant_mal_us());
		dataset.fieldValue("devuelto", infCCDet.getCant_ret_prov_us());
		dataset.fieldValue("fecha_cc", infCCDet.getInforme_cc().getEmision());
		dataset.fieldValue("oid_proveedor", infCCDet.getInforme_recepcion_det().getInforme_recepcion().getProveedor().getOIDInteger());
		dataset.fieldValue("cod_proveedor",infCCDet.getInforme_recepcion_det().getInforme_recepcion().getProveedor().getCodigo());
		dataset.fieldValue("rs_proveedor",infCCDet.getInforme_recepcion_det().getInforme_recepcion().getProveedor().getRazonsocial());
		dataset.fieldValue("comentario_inf_cc",infCCDet.getInforme_cc().getComentario());
		dataset.fieldValue("comentario_item",infCCDet.getObservaciones());
		dataset.fieldValue("oid_um",infCCDet.getInforme_recepcion_det().getUnidadMedidaStock().getOIDInteger());
		dataset.fieldValue("oc",infCCDet.getInforme_recepcion_det().getOrdenDeCompraDet().getOrden_de_compra().getCodigo());
		dataset.fieldValue("pend_ret_prov", infCCDet.isPend_ret_prov());
	}
}
