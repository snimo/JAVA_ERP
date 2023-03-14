package com.srn.erp.ctasAPagar.bm;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.CalcImportesContables;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.CuentasParametrizadas;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.ctasAPagar.da.DBComproProveedor;
import com.srn.erp.general.bm.IdentificacionTipoComprobante;
import com.srn.erp.impuestos.bm.ILibroIVA;
import com.srn.erp.impuestos.bm.ListadoIVA;
import com.srn.erp.impuestos.bm.ListadoIVACab;
import com.srn.erp.impuestos.bm.ListadoIVAConcImpu;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ComproProveedor extends ComproProveedorBase implements
		IContabilizable, ILibroIVA, ICtaCteProv {


	private ComproProveedorAnulador comproProvAnulador = null;

	public ComproProveedor() {
	}

	public static String NICKNAME = "cap.ComproProveedor";

	public String getNickName() {
		return NICKNAME;
	}

	// Agregar el After Save

	protected boolean isGrabaCtaCte() throws BaseException {
		if (this.isPagoContado())
			return false;
		else
			return true;
	}

	protected void grabarCtaCte(GrabarCtaCteProv ctaCteProv)
			throws BaseException {

		// Grabar la Cuenta Corriente del Proveedor
		getCotizacionesConta().init();
		getCotizacionesConta().addCotizaciones(listaCotizaciones);
		getCotizacionesConta().addCotizacion(getMoneda(), getCotizacion());
		getCotizacionesConta().setFecha(getEmision());

		if ((IdentificacionTipoComprobante.esFactProv(getTipoCompro().getIdentificacion()))
				|| (IdentificacionTipoComprobante.esNDProv(getTipoCompro()
						.getIdentificacion()))) {
			ctaCteProv.setSigno(new Integer(-1));
			ctaCteProv.setGrabarAutorizacion(true);
		} else {
			ctaCteProv.setSigno(new Integer(1));
			ctaCteProv.setGrabarAutorizacion(false);
		}

		ctaCteProv.setComprobante(this);
		ctaCteProv.setTipoCtaCteProv(getTipoCtaCteProv());
		ctaCteProv.setProveedor(getProveedor());
		ctaCteProv.setMoneda(getMoneda());
		ctaCteProv.setImporte(getTotMonedaOri());
		ctaCteProv.setImputac(getFecImputacion());
		
		ctaCteProv.setEmision(getEmision());
		ctaCteProv.setBase(getFecbase());
		ctaCteProv.setCotizMonOri(getCotizacion());
		ctaCteProv.setCotizMonExt1(getCotizacionesConta().getCotizMonedaExt1());
		ctaCteProv.setCotizMonExt2(getCotizacionesConta().getCotizMonedaExt2());
		ctaCteProv.setCotizMonOriCon(getCotizacion());
		ctaCteProv.setCotizMonExt1Con(getCotizacionesConta()
				.getCotizMonedaExt1());
		ctaCteProv.setCotizMonExt2Con(getCotizacionesConta()
				.getCotizMonedaExt2());
		// Condiciones de Pago
		ctaCteProv.setCondPago(getCondPagoCC());
		Iterator iteVtosFijos = this.getVtosFijos().iterator();
		while (iteVtosFijos.hasNext()) {
			ComproProvVtoFijo comproProvVtoFijo = (ComproProvVtoFijo) iteVtosFijos
					.next();
			CalculadorMoney calcCuota = new CalculadorMoney(getTotMonedaOri());
			calcCuota.multiplicarPor(new Money(comproProvVtoFijo
					.getPorcentaje().doubleValue()));
			calcCuota.dividirPor(new Money(100));
			ctaCteProv.addVtoFechaFija(comproProvVtoFijo.getFecha(), calcCuota
					.getResultMoney());
		}

	}

	/**
	 * getDescripcion
	 * 
	 * @return String
	 */
	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		RenglonesAsiento renglones = new RenglonesAsiento();

		ValorCotizacion valCotizMonExt1 = null;
		ValorCotizacion valCotizMonExt2 = null;

		CalculadorMoney totProveedorMonLoc = new CalculadorMoney(
				new NumeroBase(0));
		CalculadorMoney totProveedorMonAju = new CalculadorMoney(
				new NumeroBase(0));
		CalculadorMoney totProveedorMonExt1 = new CalculadorMoney(
				new NumeroBase(0));
		CalculadorMoney totProveedorMonExt2 = new CalculadorMoney(
				new NumeroBase(0));

		// Contabilizar los conceptos

		Iterator iterDetalles = this.getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			ComproProveedorDet comproProveedorDet = (ComproProveedorDet) iterDetalles
					.next();
			Iterator iterImputacionesConcepto = comproProveedorDet
					.getDetalleImputacionesConc().iterator();
			while (iterImputacionesConcepto.hasNext()) {
				ComproProvDetCtaImpu detImputacion = (ComproProvDetCtaImpu) iterImputacionesConcepto
						.next();
				RenglonAsiento renglon = renglones.addRenglonAsiento();
				renglon.setCuentaImputable(detImputacion.getCuentaimputable());
				if (IdentificacionTipoComprobante.esFactProv(getTipoCompro().getIdentificacion())
						|| IdentificacionTipoComprobante.esNDProv(getTipoCompro().getIdentificacion()) 
						|| IdentificacionTipoComprobante.esNotaDebitoInternoProveedor(getTipoCompro().getIdentificacion()))
					renglon.setD_H(RenglonAsiento.DEBE);
				else
					renglon.setD_H(RenglonAsiento.HABER);

				renglon.setMonedaOri(getMoneda());
				Money importeConcepto = new Money(detImputacion.getImporte()
						.doubleValue());
				renglon.setImporteOri(importeConcepto);
				renglon.setCotizOri(getCotizacion());
				renglon.setComentario("");

				CalcImportesContables calcImpoConta = new CalcImportesContables(
						getSesion(), getEmision());
				calcImpoConta.addCotizaciones(getCotizaciones());
				calcImpoConta.addCotizacion(getCotizacion(), getMoneda());
				ImportesContables importesContables = calcImpoConta
						.getImportesContables(importeConcepto, getMoneda());
				renglon.setCotizMonExt1(importesContables
						.getValorCotizMonExt1());
				renglon.setCotizMonExt2(importesContables
						.getValorCotizMonExt2());

				valCotizMonExt1 = importesContables.getValorCotizMonExt1();
				valCotizMonExt2 = importesContables.getValorCotizMonExt2();

				renglon.setImpoLocHist(importesContables.getImpoMonLoc());
				renglon.setImpoLocAju(importesContables.getImpoMonLocAju());
				renglon.setImpoMonExt1(importesContables.getImpoMonExt1());
				renglon.setImpoMonExt2(importesContables.getImpoMonExt2());

				totProveedorMonLoc.sumar(importesContables.getImpoMonLoc());
				totProveedorMonAju.sumar(importesContables.getImpoMonLocAju());
				totProveedorMonExt1.sumar(importesContables.getImpoMonExt1());
				totProveedorMonExt2.sumar(importesContables.getImpoMonExt2());

			}
		}

		// Contabilizar los Impuestos

		Iterator iterTotImpuestos = this.getDetallesTotImpuestos().iterator();
		while (iterTotImpuestos.hasNext()) {
			ComproProvTotImpu comproProvTotImpu = (ComproProvTotImpu) iterTotImpuestos
					.next();
			CuentaImputable ctaImputable = comproProvTotImpu
					.getConceptoImpuesto().getCuentaImputable();

			if (ctaImputable == null)
				throw new ExceptionValidation(null,
						"No se puede encontrar la cuenta contable para el concepto "
								+ comproProvTotImpu.getConceptoImpuesto()
										.getDescripcion());

			RenglonAsiento renglon = renglones.addRenglonAsiento();
			renglon.setCuentaImputable(ctaImputable);

			if (IdentificacionTipoComprobante.esFactProv(getTipoCompro()
					.getIdentificacion())
					|| IdentificacionTipoComprobante.esNDProv(getTipoCompro()
							.getIdentificacion())
							|| IdentificacionTipoComprobante.esNotaDebitoInternoProveedor(getTipoCompro().getIdentificacion()))
				renglon.setD_H(RenglonAsiento.DEBE);
			else
				renglon.setD_H(RenglonAsiento.HABER);

			renglon.setMonedaOri(getMoneda());
			Money importeImpuesto = comproProvTotImpu.getImporteMonedaOri();
			renglon.setImporteOri(importeImpuesto);
			renglon.setCotizOri(getCotizacion());
			renglon.setComentario("");

			CalcImportesContables calcImpoConta = new CalcImportesContables(
					getSesion(), getEmision());
			calcImpoConta.addCotizaciones(getCotizaciones());
			calcImpoConta.addCotizacion(getCotizacion(), getMoneda());
			ImportesContables importesContables = calcImpoConta
					.getImportesContables(importeImpuesto, getMoneda());
			renglon.setImpoLocHist(importesContables.getImpoMonLoc());
			renglon.setImpoLocAju(importesContables.getImpoMonLocAju());
			renglon.setImpoMonExt1(importesContables.getImpoMonExt1());
			renglon.setImpoMonExt2(importesContables.getImpoMonExt2());
			renglon.setCotizMonExt1(importesContables.getValorCotizMonExt1());
			renglon.setCotizMonExt2(importesContables.getValorCotizMonExt2());
			totProveedorMonLoc.sumar(importesContables.getImpoMonLoc());
			totProveedorMonAju.sumar(importesContables.getImpoMonLocAju());
			totProveedorMonExt1.sumar(importesContables.getImpoMonExt1());
			totProveedorMonExt2.sumar(importesContables.getImpoMonExt2());

			comproProvTotImpu = null;
		}
		iterTotImpuestos = null;

		// Agregar el Concepto Proveedor
		RenglonAsiento renglon = renglones.addRenglonAsiento();
		renglon.setCuentaImputable(CuentasParametrizadas.getProveedores(this,
				getSesion()));

		if (IdentificacionTipoComprobante.esFactProv(getTipoCompro()
				.getIdentificacion())
				|| IdentificacionTipoComprobante.esNDProv(getTipoCompro()
						.getIdentificacion())
						|| IdentificacionTipoComprobante.esNotaDebitoInternoProveedor(getTipoCompro().getIdentificacion()))
			
			renglon.setD_H(RenglonAsiento.HABER);
		else
			renglon.setD_H(RenglonAsiento.DEBE);

		renglon.setMonedaOri(getMoneda());
		renglon.setImporteOri(getTotMonedaOri());
		renglon.setCotizOri(getCotizacion());
		renglon.setComentario("");
		renglon.setCotizMonExt1(valCotizMonExt1);
		renglon.setCotizMonExt2(valCotizMonExt2);

		renglon.setImpoLocHist(totProveedorMonLoc.getResultMoney());
		renglon.setImpoLocAju(totProveedorMonAju.getResultMoney());
		renglon.setImpoMonExt1(totProveedorMonExt1.getResultMoney());
		renglon.setImpoMonExt2(totProveedorMonExt2.getResultMoney());

		return renglones;

	}

	public ListadoIVACab getLibroIVACab() throws BaseException {
		// Grabar los Impuestos correspondientes al comprobantes Proveedor

		ListadoIVACab libroIVA = (ListadoIVACab) ListadoIVACab.getNew(
				ListadoIVACab.NICKNAME, getSesion());
		libroIVA.setComprobante(this);
		if (getProveedor().getSujetoimpositivo() == null)
			throw new ExceptionValidation(null,
					"No se encuentra configurado un sujeto impositivo para proveedor "
							+ getProveedor().getCodigo() + " - "
							+ getProveedor().getRazonsocial());
		libroIVA.setRazon_social(getProveedor().getSujetoimpositivo()
				.getRazon());
		libroIVA.setCategoria_iva(getProveedor().getSujetoimpositivo()
				.getCategiva());
		libroIVA.setSujetoImpositivo(getProveedor().getSujetoimpositivo());
		libroIVA.setCuit(getProveedor().getSujetoimpositivo().getCuit());
		libroIVA.setTipo_listado(ListadoIVA.LIBRO_IVA_COMPRAS);
		libroIVA.setNeto_gravado(new Money(getNetoGravadoMonLoc().doubleValue()
				* getSignoLibroIVA()));
		libroIVA.setNeto_no_gravado(new Money(getNetoNoGravadoMonLoc()
				.doubleValue()
				* getSignoLibroIVA()));
		libroIVA.setTotal(new Money(getTotMonedaLoc().doubleValue()
				* getSignoLibroIVA()));

		// Agregar los conceptos de Impuestos
		Iterator iterComproProvImpu = this.getDetallesTotImpuestos().iterator();
		while (iterComproProvImpu.hasNext()) {
			ComproProvTotImpu comproProvImpu = (ComproProvTotImpu) iterComproProvImpu
					.next();
			ListadoIVAConcImpu listadoIVAConcImpu = (ListadoIVAConcImpu) ListadoIVAConcImpu
					.getNew(ListadoIVAConcImpu.NICKNAME, getSesion());
			listadoIVAConcImpu.setConcepto_impuesto(comproProvImpu
					.getConceptoImpuesto());
			listadoIVAConcImpu.setImporte(new Money(comproProvImpu
					.getImporteMonedaLocal().doubleValue()
					* getSignoLibroIVA()));
			libroIVA.addLibroIVAConcImpu(listadoIVAConcImpu);
		}
		return libroIVA;
	}


	public static ComproProveedorBase findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (ComproProveedorBase) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproProveedorBase findByOidProxy(Integer oid,
			ISesion aSesion) throws BaseException {
		return (ComproProveedorBase) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static List getHelpComproProv(Integer nroExtDesde,
			Integer nroExtHasta, Proveedor proveedor, Date fechaDesde,
			Date fechaHasta, ISesion aSesion) throws BaseException {

		return DBComproProveedor.getHelpComproProveedor(nroExtDesde,
				nroExtHasta, proveedor, fechaDesde, fechaHasta, aSesion);
	}

	public void anular() throws BaseException {

		comproProvAnulador = (ComproProveedorAnulador) ComproProveedorAnulador
				.getNew(ComproProveedorAnulador.NICKNAME, getSesion());
		comproProvAnulador.setComprobanteBase(this);
		comproProvAnulador.generarComproAnulacion();
		comproProvAnulador.save();

	}

}
