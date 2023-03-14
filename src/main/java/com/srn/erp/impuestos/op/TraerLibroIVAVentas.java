package com.srn.erp.impuestos.op;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.ctasACobrar.bm.ConsultaCtaCteClie;
import com.srn.erp.impuestos.bm.ListadoIVACab;
import com.srn.erp.impuestos.bm.ListadoIVAConcImpu;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLibroIVAVentas extends Operation {

	public TraerLibroIVAVentas() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsIVACab = getDataSetLibroIVAVentas();
		IDataSet dsIVAImpu = getDataSetLibroIVAVentasImpu();
		Sujeto sujetoConsFinal = Sujeto.getSujetoDefaultConsFinal(this.getSesion());
		
		if (sujetoConsFinal.getSujeto_impositivo() == null)
			throw new ExceptionValidation(null,"Falta Definir el sujeto impositivo para el cliente "+
					sujetoConsFinal.getCodigo()+"-"+sujetoConsFinal.getRazon_social());

		if (!mapaDatos.containsKey("fecha_desde"))
			throw new ExceptionValidation(null, "Debe ingresar la fecha desde");

		if (!mapaDatos.containsKey("fecha_hasta"))
			throw new ExceptionValidation(null, "Debe ingresar la fecha hasta");

		java.util.Date fechaDesde = mapaDatos.getDate("fecha_desde");
		java.util.Date fechaHasta = mapaDatos.getDate("fecha_hasta");
		boolean generarArchivo = mapaDatos.getBoolean("generar_archivo");
		
		SujetoImpositivo sujetoImpositivo = null;
		if (mapaDatos.containsKey("oid_suj_imp"))
			sujetoImpositivo = SujetoImpositivo.findByOidProxy(mapaDatos.getInteger("oid_suj_imp"), getSesion());

		List listado = ListadoIVACab.getLibroIVAVentas(fechaDesde, fechaHasta, sujetoImpositivo, getSesion());
		Iterator iterListadoIVA = listado.iterator();
		while (iterListadoIVA.hasNext()) {
			ListadoIVACab listadoIVACab = (ListadoIVACab) iterListadoIVA.next();
			cargarRegistroLibroIVAVenta(dsIVACab, listadoIVACab,sujetoConsFinal.getSujeto_impositivo());

			Iterator iterConcImpu = listadoIVACab.getConceptosImpuestos().iterator();
			while (iterConcImpu.hasNext()) {
				ListadoIVAConcImpu listadoConcImpu = (ListadoIVAConcImpu) iterConcImpu.next();
				cargarRegistroLibroIVAVentaImpu(dsIVAImpu, listadoIVACab, listadoConcImpu);
			}

		}

		writeCliente(dsIVACab);
		writeCliente(dsIVAImpu);
		
		if (generarArchivo)
			writeClienteGenerarArchivo(listado);

	}
	
	public String getyyyymmdd(Date aFecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if (aFecha == null)
			return "";
		else
			return sdf.format(aFecha).toString();
	}
	
	private String getCerozIzqCantDig(Integer nro, Integer cantDigitos) {
		int i=0;
		String campo = "";
		if (nro.toString().length()<cantDigitos) {
			int repetir = cantDigitos - nro.toString().length();
			for(i=1;i<=repetir;++i) {
				campo = campo + '0';
			}
		}
		return campo + nro.toString();
	}
	
	private String getCerozIzqCantDigS(String nro, Integer cantDigitos) {
		int i=0;
		String campo = "";
		if (nro.length()<cantDigitos) {
			int repetir = cantDigitos - nro.length();
			for(i=1;i<=repetir;++i) {
				campo = campo + '0';
			}
		}
		return campo + nro;
	}
	
	private String getEspaciosADerechaS(String cadena, Integer cantEspacios) {
		int i=0;
		String campo = "";
		if (cadena.length()<cantEspacios) {
			int repetir = cantEspacios - cadena.length();
			for(i=1;i<=repetir;++i) {
				campo = campo + ' ';
			}
		}
		return cadena + campo ;
	}
	
	private String getNroFormateadoCerozIzq(Double importe, Integer cantDecimales, Integer longitud ) {
		String importeString = String.format("%.0"+cantDecimales+"f", importe);
		importeString = importeString.replace(",","");
		importeString = importeString.replace(".","");
		String campo = "";
		int i = 0;
		if (importeString.length()<longitud) {
			int repetir = longitud - importeString.length();
			for(i=1;i<=repetir;++i) {
				campo = campo + '0';
			}
		}
		return campo + importeString;
	}
	
	void writeClienteGenerarArchivo(List listado) throws BaseException {
		
		String contenido = "";
		
		Iterator iterListadoIVA = listado.iterator();
		while (iterListadoIVA.hasNext()) {
			
			String linea = "";
			
			ListadoIVACab listadoIVACab = (ListadoIVACab) iterListadoIVA.next();
			
			if (!(listadoIVACab.getComprobante().isActivo())) continue;
			
			// Obtener codigo de documento del comprador
			FacturaCab facturaCab = FacturaCab.findByOid(listadoIVACab.getComprobante().getOIDInteger(), this.getSesion());
			
			
			// Obtener la fecha de emision
			String fecha = getyyyymmdd(listadoIVACab.getComprobante().getEmision());
			linea = linea + fecha;
			
			//Obtener el tipo de comprobante
			if ((listadoIVACab.getComprobante().getTalonario().getCodigoTCFactEle()==null) || (listadoIVACab.getComprobante().getTalonario().getCodigoTCFactEle()==0))
				throw new ExceptionValidation(null,"Debe ingresar el codigo de T.C. / Letra  AFIP en el talonario "+listadoIVACab.getComprobante().getTalonario().getDescripcion());
			linea = linea + getCerozIzqCantDig(listadoIVACab.getComprobante().getTalonario().getCodigoTCFactEle(),3);;
			
			//Obtener el punto de venta
			linea = linea + getCerozIzqCantDig(listadoIVACab.getComprobante().getLugarEmision().getLugemi(),5);
			
			// Obtener el nro. de comprobante desde
			linea = linea + getCerozIzqCantDig(listadoIVACab.getComprobante().getNroExt(),20);
			
			// Obtener el nro. de comprobante hasta
			linea = linea + getCerozIzqCantDig(listadoIVACab.getComprobante().getNroExt(),20);
			
			
			Sujeto sujeto = facturaCab.getSujeto();
			Integer codAfipTC = sujeto.getTipo_documento().getCodigoFE();
			if ((codAfipTC==null) || (codAfipTC==0)) throw new ExceptionValidation(null,"Falta configurar codigo AFP para tipo comprobante "+facturaCab.getSujeto().getTipo_documento().getDescripcion());
			linea = linea + getCerozIzqCantDig(codAfipTC,2);
			
			// Obtener el nùmero de documento
			linea = linea + getCerozIzqCantDigS(sujeto.getNroDocuParaAfip(),20);
			
			//Obtener la razon social			
			String razonSocial = sujeto.getRazon_social();
			if (razonSocial.length()>30)
				razonSocial = razonSocial.substring(0,30);
			linea = linea + getEspaciosADerechaS(razonSocial,30);
			
			// Importe total de la operacion
			double impTotal = listadoIVACab.getTotal().doubleValue(2);
			CalculadorMoney calcImpTotal = new CalculadorMoney(listadoIVACab.getTotal());
			if (listadoIVACab.getTotal().doubleValue(2)<0) {
				calcImpTotal.multiplicarPor(new Money(-1));
				impTotal = calcImpTotal.getResult(2); 
			}			
			linea = linea + getNroFormateadoCerozIzq(impTotal,2,15);
			
			// Neto no gravado
			double impNetoNoGravado = listadoIVACab.getNeto_no_gravado().doubleValue(2);
			CalculadorMoney calcImpNetoNoGravado = new CalculadorMoney(listadoIVACab.getNeto_no_gravado());
			if (listadoIVACab.getNeto_no_gravado().doubleValue(2)<0) {
				calcImpNetoNoGravado.multiplicarPor(new Money(-1));
				impNetoNoGravado = calcImpNetoNoGravado.getResult(2); 
			}			
			linea = linea + getNroFormateadoCerozIzq(impNetoNoGravado,2,15);
			
			// Percepcion a no categorizados
			linea = linea + getNroFormateadoCerozIzq(new Double(0),2,15);
			
			// Operaciones exentas
			linea = linea + getNroFormateadoCerozIzq(new Double(0),2,15);
						
			//Importe de percepciones o pagos a cuenta de impuestos Nacionales
			linea = linea + getNroFormateadoCerozIzq(new Double(0),2,15);
			
			// Importe de percepcion de ingresos brutos
			linea = linea + getNroFormateadoCerozIzq(new Double(0),2,15);
			
			// Importe de percepcion de impuestos municipales
			linea = linea + getNroFormateadoCerozIzq(new Double(0),2,15);
			
			//Importe impuestos internos
			linea = linea + getNroFormateadoCerozIzq(new Double(0),2,15);
			
			// Moneda
			linea = linea + "PES";
			
			// Tipo de cambio
			linea = linea + "0001000000";

			// Cantidad de alicuotas de IVA
			linea = linea + listadoIVACab.getConceptosImpuestos().size();
			
			//Codigo de operacion
			linea = linea + ' ';
			
			//Otros tributos
			linea = linea + getNroFormateadoCerozIzq(new Double(0),2,15);
			
			// Fecha de vencimiento de pago
			java.util.Date fecVto = null;
			List listaCtaCte = ConsultaCtaCteClie.getVtosCtaCteByComprobante(facturaCab, this.getSesion()); 
			Iterator iterCtaCtae = listaCtaCte.iterator();
			while (iterCtaCtae.hasNext()) {
				ConsultaCtaCteClie consCtaCte = (ConsultaCtaCteClie) iterCtaCtae.next();
				fecVto = consCtaCte.getVto();
			}
			if (fecVto==null) fecVto = facturaCab.getEmision();
			linea = linea + getyyyymmdd(fecVto);
			
			
			if (contenido.length()==0)
				contenido = contenido + linea;
			else
				contenido = contenido + Util.ENTER() + linea;
		}
		
		IDataSet ds = getDataSetArchGeneradoCompro();
		try {
			cargarRegistroArchivoGeneradoCompro(ds,contenido);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeCliente(ds);
		
		
		String contenido2 = "";
		iterListadoIVA = listado.iterator();
		while (iterListadoIVA.hasNext()) {
			
			String linea = "";
			
			ListadoIVACab listadoIVACab = (ListadoIVACab) iterListadoIVA.next();
			
			Iterator iterConceImpu = listadoIVACab.getConceptosImpuestos().iterator();
			while (iterConceImpu.hasNext()) {
				ListadoIVAConcImpu listadoIVAConcImpu = (ListadoIVAConcImpu) iterConceImpu.next();
				
				//Obtener el tipo de comprobante
				if ((listadoIVACab.getComprobante().getTalonario().getCodigoTCFactEle()==null) || (listadoIVACab.getComprobante().getTalonario().getCodigoTCFactEle()==0))
					throw new ExceptionValidation(null,"Debe ingresar el codigo de T.C. / Letra  AFIP en el talonario "+listadoIVACab.getComprobante().getTalonario().getDescripcion());
				linea = linea + getCerozIzqCantDig(listadoIVACab.getComprobante().getTalonario().getCodigoTCFactEle(),3);;
						
				//Obtener el punto de venta
				linea = linea + getCerozIzqCantDig(listadoIVACab.getComprobante().getLugarEmision().getLugemi(),5);
				
				// Obtener el nro. de comprobante desde
				linea = linea + getCerozIzqCantDig(listadoIVACab.getComprobante().getNroExt(),20);
				
				// Neto gravado
				double impNetoGravado = listadoIVACab.getNeto_gravado().doubleValue(2);
				CalculadorMoney calcImpNetoGravado = new CalculadorMoney(listadoIVACab.getNeto_gravado());
				if (listadoIVACab.getNeto_gravado().doubleValue(2)<0) {
								calcImpNetoGravado.multiplicarPor(new Money(-1));
								impNetoGravado = calcImpNetoGravado.getResult(2); 
				}			
				linea = linea + getNroFormateadoCerozIzq(impNetoGravado,2,15);
				
				// Alicuota de IVA
				if ((listadoIVAConcImpu.getConcepto_impuesto().getCodigoAfip()==null) || (listadoIVAConcImpu.getConcepto_impuesto().getCodigoAfip()==0))
					throw new ExceptionValidation(null,"Debe agregar el codigo de AFIP del concepto de impuesto "+listadoIVAConcImpu.getConcepto_impuesto().getDescripcion());
				linea = linea + getCerozIzqCantDig(listadoIVAConcImpu.getConcepto_impuesto().getCodigoAfip(),4);
				
				// Impuesto liquidado
				double impuestoLiquidado = listadoIVAConcImpu.getImporte().doubleValue(2);
				CalculadorMoney calcImpuestoLiquidado = new CalculadorMoney(listadoIVAConcImpu.getImporte());
				if (listadoIVAConcImpu.getImporte().doubleValue(2)<0) {
					calcImpuestoLiquidado.multiplicarPor(new Money(-1));
					impuestoLiquidado = calcImpuestoLiquidado.getResult(2); 
				}			
				linea = linea + getNroFormateadoCerozIzq(impuestoLiquidado,2,15);
				
				if (contenido2.length()==0)
					contenido2 = contenido2 + linea;
				else
					contenido2 = contenido2 + Util.ENTER() + linea;
		
				
				
				
			}
			
			
			
		}		
		
		
		// Genenrar detalle por el IVA
		IDataSet ds1 = getDataSetArchGeneradoComproImpu();
		try {
			cargarRegistroArchivoGeneradoCompro(ds1,contenido2);
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeCliente(ds1);
		
	}
	
	private IDataSet getDataSetArchGeneradoCompro() {
		IDataSet dataset = new TDataSet();
		dataset.create("TArchivoComprobantes");
		dataset.fieldDef(new Field("contenido", Field.MEMO, 0));
		return dataset;
	}
	
	private IDataSet getDataSetArchGeneradoComproImpu() {
		IDataSet dataset = new TDataSet();
		dataset.create("TArchivoComprobantesIVA");
		dataset.fieldDef(new Field("contenido", Field.MEMO, 0));
		return dataset;
	}
	
	private void cargarRegistroArchivoGeneradoCompro(IDataSet dataset, String contenido) throws BaseException {
		dataset.append();
		dataset.fieldValue("contenido", contenido);
	}



	private IDataSet getDataSetLibroIVAVentas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLibroIVAVentas");
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
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("provincia", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistroLibroIVAVenta(IDataSet dataset, ListadoIVACab listadoIVACab, SujetoImpositivo sujetoImpositivo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_listado_iva", listadoIVACab.getOIDInteger());
		dataset.fieldValue("fec_emision", listadoIVACab.getComprobante().getEmision());
		dataset.fieldValue("fec_imputac", listadoIVACab.getComprobante().getImputac());

		if (listadoIVACab.getComprobante().isActivo()) {
			dataset.fieldValue("razon_social", listadoIVACab.getRazon_social());
			dataset.fieldValue("oid_cat_iva", listadoIVACab.getCategoria_iva().getOIDInteger());
			dataset.fieldValue("desc_cat_iva", listadoIVACab.getCategoria_iva().getDescripcion());
			
			if (listadoIVACab.getSujetoImpositivo().getOID() == sujetoImpositivo.getOID())
				dataset.fieldValue("cuit", "");
			else
				dataset.fieldValue("cuit", listadoIVACab.getCuit());
			dataset.fieldValue("oid_cco", listadoIVACab.getComprobante().getOIDInteger());
			dataset.fieldValue("codigo_cco", listadoIVACab.getComprobante().getCodigo());
			dataset.fieldValue("neto_gravado", listadoIVACab.getNeto_gravado());
			dataset.fieldValue("neto_no_gravado", listadoIVACab.getNeto_no_gravado());
			dataset.fieldValue("total", listadoIVACab.getTotal());
			dataset.fieldValue("activo", true);
			
			FacturaCab facturaCab = FacturaCab.findByOid(listadoIVACab.getComprobante().getOIDInteger(), this.getSesion());
			
			if (facturaCab!=null) {
				if (facturaCab.getProvincia()!=null)
					dataset.fieldValue("provincia", facturaCab.getProvincia().getDescripcion());
				else
					dataset.fieldValue("provincia", "");
			}
			else
				dataset.fieldValue("provincia", facturaCab.getProvincia().getDescripcion());
		} else {
			dataset.fieldValue("razon_social", "*** ANULADA ***");
			dataset.fieldValue("oid_cat_iva", "");
			dataset.fieldValue("desc_cat_iva", "");
			dataset.fieldValue("cuit", "");
			dataset.fieldValue("oid_cco", listadoIVACab.getComprobante().getOIDInteger());
			dataset.fieldValue("codigo_cco", listadoIVACab.getComprobante().getCodigo());
			dataset.fieldValue("neto_gravado", "");
			dataset.fieldValue("neto_no_gravado", "");
			dataset.fieldValue("total", "");
			dataset.fieldValue("activo", false);
			dataset.fieldValue("provincia", "");
		}
	}

	private IDataSet getDataSetLibroIVAVentasImpu() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLibroIVAVentasImpu");
		dataset.fieldDef(new Field("oid_impu_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_listado_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_conc_impu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_col_libro_iva", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistroLibroIVAVentaImpu(IDataSet dataset, ListadoIVACab listadoIVACab, ListadoIVAConcImpu listIVAConcImpu)
			throws BaseException {
		
		if (!listadoIVACab.getComprobante().isActivo()) return;
		
		dataset.append();
		dataset.fieldValue("oid_impu_iva", listIVAConcImpu.getOIDInteger());
		dataset.fieldValue("oid_listado_iva", listadoIVACab.getOIDInteger());
		dataset.fieldValue("oid_conc_impu", listIVAConcImpu.getConcepto_impuesto().getOIDInteger());
		dataset.fieldValue("importe", listIVAConcImpu.getImporte());
		if (listIVAConcImpu.getConcepto_impuesto().getColumnalibroiva() == null)
			throw new ExceptionValidation(null, "Falta configurar la columna libro de IVA Ventas para el concepto de impuesto "
					+ listIVAConcImpu.getConcepto_impuesto().getCodigo() + " - " + listIVAConcImpu.getConcepto_impuesto().getDescripcion());
		dataset.fieldValue("oid_col_libro_iva", listIVAConcImpu.getConcepto_impuesto().getColumnalibroiva().getOIDInteger());
	}

}
