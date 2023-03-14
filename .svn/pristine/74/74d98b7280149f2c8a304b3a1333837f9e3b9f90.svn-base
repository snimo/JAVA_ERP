package com.srn.erp.ctasAPagar.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ConsultaCtaCteProv;
import com.srn.erp.ctasAPagar.bm.TranProv;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerVistaCtaCteProv extends Operation {

	List primerasCuotas = new ArrayList();

	public TraerVistaCtaCteProv() {
	}

	private String getClaveCuota(ComproCab compro, TranProv tranProv)
			throws BaseException {
		return compro.getOIDInteger().toString() + "_"
				+ tranProv.getOIDInteger();
	}

	private boolean existeClave(String clave) throws BaseException {
		return primerasCuotas.contains(clave);
	}

	public void agregarClave(String clave) throws BaseException {
		primerasCuotas.add(clave);
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		TipoCtaCteProv tipoCuenta = null;
		Proveedor proveedor = null;
		java.util.Date fecha = null;
		boolean incluirDeudaFinan     = false;

		if (mapaDatos.containsKey("oid_tipo_cta_prov")) {
			Integer oidTipoCtaProv = mapaDatos.getInteger("oid_tipo_cta_prov");
			tipoCuenta = TipoCtaCteProv.findByOidProxy(oidTipoCtaProv,
					getSesion());
		}

		if (mapaDatos.containsKey("oid_proveedor"))
			proveedor = (Proveedor) Proveedor.findByOid(mapaDatos
					.getInteger("oid_proveedor"), getSesion());

		if (!mapaDatos.containsKey("fecha")) {
			fecha = Fecha.getFechaActual();
		} else {
			fecha = mapaDatos.getDate("fecha");
			if (fecha == null)
				throw new ExceptionValidation(null, "Debe ingresar una Fecha");
		}
		
	    if (mapaDatos.containsKey("incluir_deuda_finan"))
	    	incluirDeudaFinan = mapaDatos.getBoolean("incluir_deuda_finan");
		

	    java.util.Date fecEmiHastaDeudaFinan = null;
	    java.util.Date fecVto = Valor.getFechaDeudaFinanProv(this.getSesion());
	    
		if (!fecha.equals(Fecha.getFechaActual()))
			fecEmiHastaDeudaFinan = fecha;
		    fecVto = fecha;
		//	throw new ExceptionValidation(null,
		//			"Solamente se debe permitir el ingreso de la fecha actual");

		IDataSet datasetCtaCteProv = getDataSetCtaCteProv();
		
		
		
	    // Devolver al Deuda Financiera
	    if (incluirDeudaFinan) {
	    	
	    	Iterator iterValDeudaFinan = 
	    		Valor.getValoresDeudaFinanProv(fecVto, proveedor, fecEmiHastaDeudaFinan,this.getSesion()).iterator();
	    	while (iterValDeudaFinan.hasNext()) {
	    		Valor valor = (Valor) iterValDeudaFinan.next();
	    		
	    		String rsProveedor = "";
	    		if (valor.getProveedor()!=null)
	    			rsProveedor = valor.getProveedor().getRazonsocial();
	    		
	    		
				cargarRegistroDataSetCtaCteProv(
						datasetCtaCteProv,
						1, 
						valor.getOIDInteger(), 
						"",
						"", 
						new Integer(0), 
						new Integer(0),
						valor.getFechaemision(), 
						valor.getFechaemision(), 
						null,
						null, 
						valor.getFechavto(), 
						valor.getImporte(),
						valor.getImporte(), 
						null, 
						valor.getTipovalor().getDescripcion(), 
						valor.getProveedor(), 
						rsProveedor,
						valor.getImporte(), 
						valor.getImporte(), 
						valor.getTipovalor().getMoneda(),
						valor.getTipovalor().getMoneda().getDescripcion(), 
						null, 
						valor.getDescripcion(), 
						valor.getCotizacion(), 
						null, 
						null, 
						null, 
						null, 
						null, 
						1);
	    		
	    				
	    	}
	    	
	    }
		
		
		
	    List listVtosCtaCte = ConsultaCtaCteProv.getVtosCtaCteByProveedor(proveedor,
                fecha,
                tipoCuenta,
                null,
                getSesion());
		
		Iterator iterVtosCtaCte = listVtosCtaCte.iterator();
		while (iterVtosCtaCte.hasNext()) {

			// Hacer un corte de control por Comprobante y Fecha de Vencimiento
			ConsultaCtaCteProv consultaCtaCteProv = (ConsultaCtaCteProv) iterVtosCtaCte
					.next();

			String clave = getClaveCuota(consultaCtaCteProv.getComprobante(),
					consultaCtaCteProv.getTranProv());

			String comprobante = consultaCtaCteProv.getComprobante()
					.getCodigo();
			java.util.Date fechaEmisionCompro = consultaCtaCteProv
					.getComprobante().getEmision();
			java.util.Date fechaImputacCompro = consultaCtaCteProv
					.getComprobante().getImputac();
			Money importe = consultaCtaCteProv.getTotMonOri();
			Money saldo = consultaCtaCteProv.getSaldoMonOri();
			int primeraCuota = 0;

			if (this.existeClave(clave)) {
				//comprobante = "";
				// fechaEmisionCompro = null;
				// fechaImputacCompro = null;
				importe = null;
				saldo = null;
				primeraCuota = 1;
			} else
				agregarClave(clave);

			cargarRegistroDataSetCtaCteProv(
					datasetCtaCteProv,
					consultaCtaCteProv.getOrden(), 
					consultaCtaCteProv.getOIDInteger(), 
					consultaCtaCteProv.getTc_ext(),
					consultaCtaCteProv.getLetra(), 
					consultaCtaCteProv.getLugEmi(), 
					consultaCtaCteProv.getNroExt(),
					fechaEmisionCompro, fechaImputacCompro, 
					consultaCtaCteProv.getTranProv(),
					consultaCtaCteProv.getTranProvVto(), 
					consultaCtaCteProv.getVto(), 
					consultaCtaCteProv.getImpoCuota(),
					consultaCtaCteProv.getSaldoCuota(), 
					consultaCtaCteProv.getTipoCtaCteProv(), 
					consultaCtaCteProv.getDescTipoCtaCteProv(), 
					consultaCtaCteProv.getProveedor(), 
					consultaCtaCteProv.getRsProveedor(),
					importe, saldo, 
					consultaCtaCteProv.getMoneda(),
					consultaCtaCteProv.getDescMoneda(), 
					consultaCtaCteProv.getComprobante(), 
					comprobante, 
					consultaCtaCteProv.getCotizMonOri(), 
					consultaCtaCteProv.getCotizMonExt1(), 
					consultaCtaCteProv.getCotizMonExt2(), 
					consultaCtaCteProv.getCotizMonOriCon(), 
					consultaCtaCteProv.getCotizMonExt1Con(), 
					consultaCtaCteProv.getCotizMonExt2Con(), 
					primeraCuota);
		}

		IDataSet dsTipoCons = getDataSetTipoConsulta();
		cargarRegistroTipoConsulta(dsTipoCons, fecha);

		writeCliente(datasetCtaCteProv);
		writeCliente(dsTipoCons);
	}

	private IDataSet getDataSetCtaCteProv() {
		IDataSet dataset = new TDataSet();
		dataset.create("TVistaCtaCteProv");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tran_vto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tran_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("saldo_cuota", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_cuota", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("moneda", Field.STRING, 30));
		dataset.fieldDef(new Field("oid_tipo_cta_prov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_cta_prov", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 30));
		dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("tot_mon_ori", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("saldo_mon_ori", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("monto_autorizado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe_aplicado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("saldo_con_aplic", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_ori", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_ext1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_ext2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_ori_co", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_ext1_co", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_ext2_co", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("vto", Field.STRING, 10));
		dataset.fieldDef(new Field("primer_cuota", Field.INTEGER, 0));
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		return dataset;
	}

	private IDataSet getDataSetTipoConsulta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoConsCtaCteClie");
		dataset.fieldDef(new Field("trae_aplicaciones", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroTipoConsulta(IDataSet dataSet,
			java.util.Date fecha) throws BaseException {
		dataSet.append();
		if (fecha.equals(Fecha.getFechaActual()))
			dataSet.fieldValue("trae_aplicaciones", new Boolean(false));
		else
			dataSet.fieldValue("trae_aplicaciones", new Boolean(true));
	}

	private void cargarRegistroDataSetCtaCteProv(
			IDataSet dataset,
			Integer orden, Integer oid, String tcExt, String letra,
			Integer lugEmi, Integer nroExt, java.util.Date fecEmision,
			java.util.Date fecImputacion, TranProv tranProv,
			TranProvVto tranProvVto,
			java.util.Date vtoCuota, Money impoCuota,
			Money saldoCuota, TipoCtaCteProv tipoCtaCteProv,
			String descTipoCtaCteProv, Proveedor sujeto, String rsSujeto,
			Money totMonedaOri, Money saldoMonedaOri, Moneda moneda,
			String descMoneda, ComproCab comproCab, String comprobante,
			ValorCotizacion cotizMonOri, ValorCotizacion cotizMonExt1,
			ValorCotizacion cotizMonExt2, ValorCotizacion cotizMonOriCon,
			ValorCotizacion cotizMonExt1Con, ValorCotizacion cotizMonExt2Con,
			Integer nroCuota) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("orden", orden);
		if (tranProvVto!=null)
			dataset.fieldValue("oid_tran_vto", tranProvVto.getOIDInteger());
		else
			dataset.fieldValue("oid_tran_vto", "");
		if (comproCab!=null)
			dataset.fieldValue("oid_cco", comproCab.getOIDInteger());
		else
			dataset.fieldValue("oid_cco", "");
		if (tranProv!=null)
			dataset.fieldValue("oid_tran_prov", tranProv.getOIDInteger());
		else
			dataset.fieldValue("oid_tran_prov", "");
		dataset.fieldValue("saldo_cuota", saldoCuota);
		dataset.fieldValue("impo_cuota", impoCuota);
		if (moneda!=null)
			dataset.fieldValue("oid_moneda", moneda.getOIDInteger());
		else
			dataset.fieldValue("oid_moneda", "");
		if (moneda!=null)
			dataset.fieldValue("moneda", moneda.getDescripcion());
		else
			dataset.fieldValue("moneda", "");
		if (tipoCtaCteProv!=null) 
			dataset.fieldValue("oid_tipo_cta_prov", tipoCtaCteProv.getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_cta_prov", "");
		dataset.fieldValue("tipo_cta_prov",descTipoCtaCteProv);
		if (sujeto!=null) {
		dataset.fieldValue("oid_proveedor", sujeto.getOIDInteger()); 
		dataset.fieldValue("rs_proveedor", sujeto.getRazonsocial());
		} else {
			dataset.fieldValue("oid_proveedor", ""); 
			dataset.fieldValue("rs_proveedor", "");
			
		}
		dataset.fieldValue("comprobante", comprobante);
		if (fecEmision == null)
			dataset.fieldValue("fec_emision", "");
		else
			dataset.fieldValue("fec_emision", Fecha.getddmmyyyy(fecEmision));
		dataset.fieldValue("tot_mon_ori", totMonedaOri);
		dataset.fieldValue("saldo_mon_ori", saldoMonedaOri);
		dataset.fieldValue("monto_autorizado", new Money(0));
		dataset.fieldValue("importe_aplicado", new Money(0));
		dataset.fieldValue("saldo_con_aplic", new Money(0));
		dataset.fieldValue("cotiz_mon_ori", cotizMonOri);
		dataset.fieldValue("cotiz_mon_ext1", cotizMonExt1);
		dataset.fieldValue("cotiz_mon_ext2", cotizMonExt2);
		dataset.fieldValue("cotiz_mon_ori_co", cotizMonOriCon);
		dataset.fieldValue("cotiz_mon_ext1_co", cotizMonExt1Con);
		dataset.fieldValue("cotiz_mon_ext2_co", cotizMonExt2Con);
		dataset.fieldValue("vto", Fecha.getddmmyyyy(vtoCuota));
		dataset.fieldValue("primer_cuota", nroCuota);
		dataset.fieldValue("sel", new Boolean(false));
	}

}
