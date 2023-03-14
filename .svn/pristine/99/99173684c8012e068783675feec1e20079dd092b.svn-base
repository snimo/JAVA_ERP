package com.srn.erp.pagos.op;

import java.util.Iterator;

import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.pagos.bm.RendicionFFImpuestos;
import com.srn.erp.pagos.bm.RendicionFondoFijo;
import com.srn.erp.pagos.bm.RendicionFondoFijoCompro;
import com.srn.erp.pagos.bm.RendicionFondoFijoComproImpu;
import com.srn.erp.pagos.bm.RendicionFondoFijoImpu;
import com.srn.erp.pagos.bm.RendicionFondoFijoMedioPago;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRendicionFondoFijo extends Operation {
	
	public TraerRendicionFondoFijo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		
		IDataSet dsRendCab = this.getDSRendCab();
		IDataSet dsRendComproProv = this.getDSRendCabComproProv();
		IDataSet dsImputacionesComproProv = this.getDSRendComproProvImputaciones();
		IDataSet dsImputacionesFF = this.getDSRendFFImputaciones();
		IDataSet dsMediosPago = this.getDSMediosPago();
		IDataSet dsImpuestosFactProv = getDSImpuestosFactProv();
		IDataSet dsConcFactProv = getDSConcFactProv();
		
		Iterator iterConcFactProv = 
			ConcFactProv.getAllConceptosFactProv(this.getSesion()).iterator();
		while (iterConcFactProv.hasNext()) {
			ConcFactProv concFactProv = (ConcFactProv) iterConcFactProv.next();
			cargarConcFact(dsConcFactProv, concFactProv);
		}
		
		
		Integer oid = mapaDatos.getInteger("oid");
		RendicionFondoFijo rendFondoFijo = 
			RendicionFondoFijo.findByOid(oid,this.getSesion());
		cargarRendCab(dsRendCab,rendFondoFijo);
		
		Iterator iterRendFondoFijo = rendFondoFijo.getComproProvRendFF().iterator();
		while (iterRendFondoFijo.hasNext()) {
			RendicionFondoFijoCompro rendFFCompro = 
				(RendicionFondoFijoCompro) iterRendFondoFijo.next();
			cargarComproProv(dsRendComproProv,rendFFCompro);
			
			Iterator iterImputacionesComproProv = 
				rendFFCompro.getRendicionFondoFijoImputacionesCompro().iterator();
			while (iterImputacionesComproProv.hasNext()) {
					RendicionFondoFijoComproImpu rendFFComproImpu =
						 (RendicionFondoFijoComproImpu) iterImputacionesComproProv.next();
					cargarImpuComproProv(dsImputacionesComproProv,rendFFComproImpu);
			}
			
			Iterator iterImpuestosComproProv = 
				rendFFCompro.getRendicionFondoFijoImpuestosCompro().iterator();
			while (iterImpuestosComproProv.hasNext()) {
					RendicionFFImpuestos rendFFImpuestos =
						 (RendicionFFImpuestos) iterImpuestosComproProv.next();
					cargarImpuestosComproProv(dsImpuestosFactProv,rendFFImpuestos);
			}
			
			
		}
		
		Iterator iterImputacionesFF = 
			rendFondoFijo.getImputacionesRendFF().iterator();
		while (iterImputacionesFF.hasNext()) {
			RendicionFondoFijoImpu rendFFImpu = 
				(RendicionFondoFijoImpu) iterImputacionesFF.next();
			cargarRendFFImpu(dsImputacionesFF,rendFFImpu);
		}
		
		Iterator iterMediosPago = 
			rendFondoFijo.getDetallesMediosPago().iterator();
		while (iterMediosPago.hasNext()) {
			RendicionFondoFijoMedioPago rendFFMedioPago = 
				(RendicionFondoFijoMedioPago) iterMediosPago.next();
			cargarRendFFValor(dsMediosPago,rendFFMedioPago);
		}
		
		
		
		writeCliente(dsRendCab);
		writeCliente(dsRendComproProv);
		writeCliente(dsImputacionesComproProv);
		writeCliente(dsImputacionesFF);
		writeCliente(dsMediosPago);
		writeCliente(dsImpuestosFactProv);
		writeCliente(dsConcFactProv);

	}
	
	private void cargarComproProv(IDataSet ds,
			RendicionFondoFijoCompro rendFFCompro) throws BaseException {
		ds.append();
		ds.fieldValue("oid_rend_ff_det", rendFFCompro.getOIDInteger());
		ds.fieldValue("oid_rendicion_cab", rendFFCompro.getRendicion_fondo().getOIDInteger());
		ds.fieldValue("oid_cco_prov", rendFFCompro.getComprobante_proveedor().getOIDInteger());
		ds.fieldValue("oid_tc", rendFFCompro.getComprobante_proveedor().getTipoCompro().getOIDInteger());
		ds.fieldValue("cod_tc", rendFFCompro.getComprobante_proveedor().getTipoCompro().getCodigo());
		ds.fieldValue("letra",rendFFCompro.getComprobante_proveedor().getLetra());
		ds.fieldValue("lug_emi", rendFFCompro.getComprobante_proveedor().getNroLugEmision());
		ds.fieldValue("nro_ext", rendFFCompro.getComprobante_proveedor().getNroExt());
		ds.fieldValue("fec_emision", rendFFCompro.getComprobante_proveedor().getEmision());
		ds.fieldValue("oid_prov", rendFFCompro.getComprobante_proveedor().getProveedor().getOIDInteger());
		ds.fieldValue("cod_prov", rendFFCompro.getComprobante_proveedor().getProveedor().getCodigo());
		ds.fieldValue("rz_prov", rendFFCompro.getComprobante_proveedor().getProveedor().getRazonsocial());
		ds.fieldValue("oid_moneda",rendFFCompro.getComprobante_proveedor().getMoneda().getOIDInteger());
		ds.fieldValue("neto_gravado",rendFFCompro.getNetoGravado());
		ds.fieldValue("neto_no_gravado",rendFFCompro.getNetoNoGravado());
		ds.fieldValue("iva",rendFFCompro.getIVA());
		ds.fieldValue("perc_iva",rendFFCompro.getPercIVA());
		ds.fieldValue("perc_ib",rendFFCompro.getPercIB());
		ds.fieldValue("otros_imp",rendFFCompro.getOtrosImp());
		if (rendFFCompro.getMoneda()!=null)
			ds.fieldValue("cod_moneda", rendFFCompro.getMoneda().getCodigo());
		else
			ds.fieldValue("cod_moneda", "");
		ds.fieldValue("cotizacion", rendFFCompro.getRendicion_fondo().getCotizacion());
		ds.fieldValue("oid_conc_fact_prov",rendFFCompro.getConcFactProv().getOIDInteger());
		ds.fieldValue("total",rendFFCompro.getTotal());
		if (rendFFCompro.getConcImpuIVA()!=null)
			ds.fieldValue("oid_conc_impu_iva", rendFFCompro.getConcImpuIVA().getOIDInteger());
		else
			ds.fieldValue("oid_conc_impu_iva", "");
		if (rendFFCompro.getConcImpuPercIVA()!=null)
			ds.fieldValue("oid_conc_impu_perc_iva",rendFFCompro.getConcImpuPercIVA().getOIDInteger());
		else
			ds.fieldValue("oid_conc_impu_perc_iva","");
		if (rendFFCompro.getConcImpuPercIB()!=null)
			ds.fieldValue("oid_conc_impu_perc_ib", rendFFCompro.getConcImpuPercIB().getOIDInteger());
		else
			ds.fieldValue("oid_conc_impu_perc_ib", "");
	}
	
	
	private void cargarImpuestosComproProv(IDataSet ds,RendicionFFImpuestos rendFFImpuesto) throws BaseException {
		ds.append();
		ds.fieldValue("oid_conc_impu_fp", rendFFImpuesto.getOIDInteger());
		ds.fieldValue("oid_rend_ff_det", rendFFImpuesto.getRend_ff_det().getOIDInteger());
		ds.fieldValue("oid_conc_impu", rendFFImpuesto.getConcepto_impuesto().getOIDInteger());
		ds.fieldValue("cod_conc_impu", rendFFImpuesto.getConcepto_impuesto().getCodigo());
		ds.fieldValue("desc_conc_impu",rendFFImpuesto.getConcepto_impuesto().getDescripcion());
		ds.fieldValue("importe",rendFFImpuesto.getImporte());
		ds.fieldValue("comportamiento",rendFFImpuesto.getComportamiento());
	}
	
	private void cargarRendCab(IDataSet ds,RendicionFondoFijo rendFF) throws BaseException {
		ds.append();
		ds.fieldValue("oid_rendicion_cab", rendFF.getOIDInteger());
		ds.fieldValue("oid_talonario",rendFF.getTalonario().getOIDInteger());
		ds.fieldValue("fecha",rendFF.getEmision());
		ds.fieldValue("oid_moneda",rendFF.getMoneda().getOIDInteger());
		ds.fieldValue("cotizacion",rendFF.getCotizacion());
		ds.fieldValue("comentario",rendFF.getComentario());
		ds.fieldValue("activo", rendFF.isActivo());
	}
	
	private void cargarRendFFValor(IDataSet ds,
																 RendicionFondoFijoMedioPago rendFFValor) throws BaseException {
		ds.append();
		ds.fieldValue("oid_rend_med_pago", rendFFValor.getOIDInteger());
		ds.fieldValue("oid_rendicion_cab", rendFFValor.getRendicion_fondo().getOIDInteger());
		ds.fieldValue("oid_caja", rendFFValor.getCaja().getOIDInteger());
		ds.fieldValue("oid_tipo_valor",rendFFValor.getTipo_valor().getOIDInteger());
		ds.fieldValue("cod_tipo_valor",rendFFValor.getTipo_valor().getCodigo());
		ds.fieldValue("desc_tipo_valor",rendFFValor.getTipo_valor().getDescripcion());
		ds.fieldValue("oid_moneda",rendFFValor.getTipo_valor().getMoneda().getOIDInteger());
		ds.fieldValue("impo_mon_valor",rendFFValor.getImporte());
		ds.fieldValue("impo_mon_pago_bd",rendFFValor.getImpo_mon_rend_ff());
		ds.fieldValue("impo_mon_pago",rendFFValor.getImpo_mon_rend_ff());
		ds.fieldValue("cotizacion",rendFFValor.getCotizacion());
		ds.fieldValue("traer_bd", new Boolean(true));

	}
	
	private void cargarConcFact(IDataSet ds,
			 					ConcFactProv concFactProv) throws BaseException {
		ds.append();
		ds.fieldValue("oid", concFactProv.getOIDInteger());
		ds.fieldValue("codigo", concFactProv.getCodigo());
		ds.fieldValue("descripcion", concFactProv.getDescripcion());
	}
	
	
	private void cargarRendFFImpu(IDataSet ds,
																RendicionFondoFijoImpu rendFFImpu) throws BaseException {
		ds.append();
		ds.fieldValue("oid_rend_ff_impu", rendFFImpu.getOIDInteger());
		ds.fieldValue("oid_rendicion_cab", rendFFImpu.getRendicion_fondo().getOIDInteger());
		ds.fieldValue("oid_ai", rendFFImpu.getCuenta_imputable().getOIDInteger());
		ds.fieldValue("codigo_ai", rendFFImpu.getCuenta_imputable().getCodigoCuentaMasCodigosValCompo());
		ds.fieldValue("desc_ai", rendFFImpu.getCuenta_imputable().getDescCuentaMasDescValCompo());
		ds.fieldValue("importe_debe", rendFFImpu.getImporte_debe());
		ds.fieldValue("importe_haber", rendFFImpu.getImporte_haber());
		ds.fieldValue("comentario",rendFFImpu.getComentario());
		
	}
	
	private void cargarImpuComproProv(IDataSet ds,
			                              RendicionFondoFijoComproImpu imputacionComproProv) throws BaseException {
		ds.append();
		ds.fieldValue("oid_cco_compro_impu", imputacionComproProv.getOIDInteger());
		ds.fieldValue("oid_rend_ff_det", imputacionComproProv.getRendicion_det().getOIDInteger());
		ds.fieldValue("oid_ai", imputacionComproProv.getCuenta_imputable().getOID());
		ds.fieldValue("codigo_ai", imputacionComproProv.getCuenta_imputable().getCodigoCuentaMasCodigosValCompo());
		ds.fieldValue("desc_ai", imputacionComproProv.getCuenta_imputable().getDescCuentaMasDescValCompo());
		ds.fieldValue("importe", imputacionComproProv.getImporte());
		ds.fieldValue("comentario", imputacionComproProv.getComentario());
	}
	
	
	private IDataSet getDSRendCab() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TRendicionCab");
    dataset.fieldDef(new Field("oid_rendicion_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_talonario",Field.INTEGER, 0));
    dataset.fieldDef(new Field("fecha",Field.DATE, 0));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cotizacion",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("comentario",Field.MEMO, 0));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
    return dataset;		
	}
	
	private IDataSet getDSConcFactProv() throws BaseException {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TConcFactProv");
	    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("codigo",Field.STRING, 50));
	    dataset.fieldDef(new Field("descripcion",Field.STRING, 100));
	    return dataset;		
	}
	
	
	private IDataSet getDSImpuestosFactProv() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TConcImpuFactProv");
    dataset.fieldDef(new Field("oid_conc_impu_fp", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_rend_ff_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_conc_impu", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_conc_impu", Field.STRING, 100));
    dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("comportamiento", Field.STRING, 100));
    return dataset;		
	}
	
	
	private IDataSet getDSRendCabComproProv() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TRendicionComproProv");
    dataset.fieldDef(new Field("oid_rend_ff_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_rendicion_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tc", Field.STRING, 50));
    dataset.fieldDef(new Field("letra",Field.STRING, 5));
    dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_prov", Field.STRING, 50));
    dataset.fieldDef(new Field("rz_prov", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
    dataset.fieldDef(new Field("neto_gravado",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("neto_no_gravado",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("iva",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("perc_iva",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("perc_ib",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("otros_imp",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cod_moneda",Field.STRING, 50));
    dataset.fieldDef(new Field("cotizacion",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_conc_fact_prov",Field.INTEGER, 0));
    dataset.fieldDef(new Field("total",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_conc_impu_iva",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu_perc_iva",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_impu_perc_ib",Field.INTEGER, 0));
    return dataset;		
	}
	
	private IDataSet getDSRendComproProvImputaciones() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TRendicionComproProvImpu");
    dataset.fieldDef(new Field("oid_cco_compro_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_rend_ff_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_ai", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ai", Field.STRING, 255));
    dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
    return dataset;		
	}
	
	private IDataSet getDSRendFFImputaciones() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TRenfFFImputaciones");
    dataset.fieldDef(new Field("oid_rend_ff_impu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_rendicion_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_ai", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_ai", Field.STRING, 255));
    dataset.fieldDef(new Field("importe_debe", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("importe_haber", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("comentario",Field.MEMO, 0));
    return dataset;		
	}
	
	private IDataSet getDSMediosPago() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TMediosPago");
    dataset.fieldDef(new Field("oid_rend_med_pago", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_rendicion_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tipo_valor",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_tipo_valor",Field.STRING, 50));
    dataset.fieldDef(new Field("desc_tipo_valor",Field.STRING, 100));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
    dataset.fieldDef(new Field("impo_mon_valor",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("impo_mon_pago_bd",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("impo_mon_pago",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cotizacion",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("traer_bd",Field.BOOLEAN, 0));
    return dataset;		
	}	
	
	
	
	
	
	
	

}
