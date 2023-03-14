package com.srn.erp.impuestos.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.impuestos.bm.ListadoIVACab;
import com.srn.erp.impuestos.bm.ListadoIVAConcImpu;
import com.srn.erp.impuestos.bm.SujetoImpositivo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLibroIVACompras extends Operation {

	public TraerLibroIVACompras() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet dsIVACab = getDataSetLibroIVACompras();
		IDataSet dsIVAImpu = getDataSetLibroIVAComprasImpu();
		
		if((!mapaDatos.containsKey("fecha_desde")) || (!mapaDatos.containsKey("fecha_hasta")))
			throw new ExceptionValidation(null,"Debe ingresar la fecha desde y hasta.");
		
		java.util.Date fechaDesde = mapaDatos.getDate("fecha_desde");
		java.util.Date fechaHasta = mapaDatos.getDate("fecha_hasta");
		SujetoImpositivo sujetoImpositivo = null;
		if (mapaDatos.containsKey("oid_suj_imp"))
		   sujetoImpositivo = SujetoImpositivo.findByOidProxy(mapaDatos.getInteger("oid_suj_imp"),getSesion()); 
		
	    List listado = ListadoIVACab.getLibroIVACompras(fechaDesde,fechaHasta,sujetoImpositivo,getSesion());
	    Iterator iterListadoIVA = listado.iterator();
	    while (iterListadoIVA.hasNext()) {
	    	ListadoIVACab listadoIVACab = (ListadoIVACab) iterListadoIVA.next();
	    	
	    	if (!listadoIVACab.getComprobante().isActivo()) continue;
	    	
	    	cargarRegistroLibroIVACompra(dsIVACab,listadoIVACab);
	    	
	    	Iterator iterConcImpu = listadoIVACab.getConceptosImpuestos().iterator();
	    	while (iterConcImpu.hasNext()) {
	    		ListadoIVAConcImpu listadoConcImpu = (ListadoIVAConcImpu) iterConcImpu.next();
	    		cargarRegistroLibroIVACompraImpu(dsIVAImpu,listadoIVACab,listadoConcImpu);
	    	}
	    	
	    	
	    }
	    
	    writeCliente(dsIVACab);
	    writeCliente(dsIVAImpu);		
		
	}

	private IDataSet getDataSetLibroIVACompras() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLibroIVACompras");
		dataset.fieldDef(new Field("oid_listado_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_imputac", Field.DATE, 0));
		dataset.fieldDef(new Field("razon_social", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_cat_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_cat_iva", Field.STRING, 50));
		dataset.fieldDef(new Field("cuit", Field.STRING, 30));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_cco", Field.STRING, 50));
		dataset.fieldDef(new Field("neto_gravado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("neto_no_gravado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("total", Field.CURRENCY, 0));		
		return dataset;
	}
	
	private void cargarRegistroLibroIVACompra(IDataSet dataset,
			ListadoIVACab listadoIVACab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_listado_iva", listadoIVACab.getOIDInteger());
		dataset.fieldValue("fec_emision", listadoIVACab.getComprobante().getEmision());
		dataset.fieldValue("fec_imputac", listadoIVACab.getComprobante().getImputac());
		dataset.fieldValue("razon_social", listadoIVACab.getRazon_social());
		dataset.fieldValue("oid_cat_iva", listadoIVACab.getCategoria_iva().getOIDInteger());
		dataset.fieldValue("desc_cat_iva", listadoIVACab.getCategoria_iva().getDescripcion());
		dataset.fieldValue("cuit", listadoIVACab.getCuit());
		dataset.fieldValue("oid_cco", listadoIVACab.getComprobante().getOIDInteger());
		dataset.fieldValue("codigo_cco", listadoIVACab.getComprobante().getCodigo());
		dataset.fieldValue("neto_gravado", listadoIVACab.getNeto_gravado());
		dataset.fieldValue("neto_no_gravado", listadoIVACab.getNeto_no_gravado());
		dataset.fieldValue("total", listadoIVACab.getTotal());
	}
	

	private IDataSet getDataSetLibroIVAComprasImpu() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLibroIVAComprasImpu");
		dataset.fieldDef(new Field("oid_impu_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_listado_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_col_libro_iva", Field.INTEGER, 0));
		return dataset;
	}
	
	private void cargarRegistroLibroIVACompraImpu(IDataSet dataset,
			ListadoIVACab listadoIVACab,
			ListadoIVAConcImpu listIVAConcImpu) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_impu_iva", listIVAConcImpu.getOIDInteger());
		dataset.fieldValue("oid_listado_iva", listadoIVACab.getOIDInteger());
		dataset.fieldValue("oid_conc_impu", listIVAConcImpu.getConcepto_impuesto().getOIDInteger());
		dataset.fieldValue("importe", listIVAConcImpu.getImporte());
		if (listIVAConcImpu.getConcepto_impuesto().getColumnalibroiva() == null)
			throw new ExceptionValidation(null,"Falta configurar la columna libro de IVA Compras para el concepto de impuesto "+
					listIVAConcImpu.getConcepto_impuesto().getCodigo()+" - "+ listIVAConcImpu.getConcepto_impuesto().getDescripcion());
		dataset.fieldValue("oid_col_libro_iva", listIVAConcImpu.getConcepto_impuesto().getColumnalibroiva().getOIDInteger()); 
	}
	
	
	
	
}
