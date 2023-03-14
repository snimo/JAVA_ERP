package com.srn.erp.ctasAPagar.bm;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.CalcImportesContables;
import com.srn.erp.contabilidad.bm.CuentasParametrizadas;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.IdentificacionTipoComprobante;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;

public class ComproProveedorInterno extends ComproProveedorBase implements IContabilizable,  ICtaCteProv {

	public ComproProveedorInterno() {
	}

	public static String			NICKNAME	= "cap.ComproProveedorInterno";

	public String getNickName() {
		return NICKNAME;
	}


	// Agregar el After Save
	
	protected boolean isGrabaCtaCte() throws BaseException {
		return true;
	}
		
	protected void grabarCtaCte(GrabarCtaCteProv ctaCteProv) throws BaseException {
		
		// Grabar la Cuenta Corriente del Proveedor
		getCotizacionesConta().init();
		getCotizacionesConta().addCotizaciones(listaCotizaciones);
		getCotizacionesConta().addCotizacion(getMoneda(), getCotizacion());
		getCotizacionesConta().setFecha(getEmision());
		
		if (IdentificacionTipoComprobante.esNotaDebitoInternoProveedor(getTipoCompro().getIdentificacion())) {
			ctaCteProv.setSigno(new Integer(-1));
			ctaCteProv.setGrabarAutorizacion(true);
		}
		else {
			// Si es una nota de credito
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
		ctaCteProv.setCotizMonExt1Con(getCotizacionesConta().getCotizMonedaExt1());
		ctaCteProv.setCotizMonExt2Con(getCotizacionesConta().getCotizMonedaExt2());
		// Condiciones de Pago
		ctaCteProv.setCondPago(getCondPagoCC());
		Iterator iteVtosFijos = this.getVtosFijos().iterator();
		while (iteVtosFijos.hasNext()) {
			ComproProvVtoFijo comproProvVtoFijo = (ComproProvVtoFijo) iteVtosFijos.next();
			CalculadorMoney calcCuota = new CalculadorMoney(getTotMonedaOri());
			calcCuota.multiplicarPor(new Money(comproProvVtoFijo.getPorcentaje().doubleValue()));
			calcCuota.dividirPor(new Money(100));
			ctaCteProv.addVtoFechaFija(comproProvVtoFijo.getFecha(), calcCuota.getResultMoney());
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

		CalculadorMoney totProveedorMonLoc = new CalculadorMoney(new NumeroBase(0));
		CalculadorMoney totProveedorMonAju = new CalculadorMoney(new NumeroBase(0));
		CalculadorMoney totProveedorMonExt1 = new CalculadorMoney(new NumeroBase(0));
		CalculadorMoney totProveedorMonExt2 = new CalculadorMoney(new NumeroBase(0));

		// Contabilizar los conceptos
		
		Iterator iterDetalles = this.getDetalles().iterator();
		while (iterDetalles.hasNext()) {
			ComproProveedorDet comproProveedorDet = (ComproProveedorDet) iterDetalles.next();
			Iterator iterImputacionesConcepto = comproProveedorDet.getDetalleImputacionesConc().iterator();
			while (iterImputacionesConcepto.hasNext()) {
				ComproProvDetCtaImpu detImputacion = (ComproProvDetCtaImpu) iterImputacionesConcepto.next();
				RenglonAsiento renglon = renglones.addRenglonAsiento();
				renglon.setCuentaImputable(detImputacion.getCuentaimputable());
				if (IdentificacionTipoComprobante.esFactProv(getTipoCompro().getIdentificacion())
						|| IdentificacionTipoComprobante.esNDProv(getTipoCompro().getIdentificacion())
						|| IdentificacionTipoComprobante.esNotaDebitoInternoProveedor(getTipoCompro().getIdentificacion()))
					renglon.setD_H(RenglonAsiento.DEBE);
				else
					renglon.setD_H(RenglonAsiento.HABER);

				renglon.setMonedaOri(getMoneda());
				Money importeConcepto = new Money(detImputacion.getImporte().doubleValue());
				renglon.setImporteOri(importeConcepto);
				renglon.setCotizOri(getCotizacion());
				renglon.setComentario("");

				CalcImportesContables calcImpoConta = new CalcImportesContables(getSesion(), getEmision());
				calcImpoConta.addCotizaciones(getCotizaciones());
				calcImpoConta.addCotizacion(getCotizacion(), getMoneda());
				ImportesContables importesContables = calcImpoConta.getImportesContables(importeConcepto, getMoneda());
				renglon.setCotizMonExt1(importesContables.getValorCotizMonExt1());
				renglon.setCotizMonExt2(importesContables.getValorCotizMonExt2());

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


		// Agregar el Concepto Proveedor
		RenglonAsiento renglon = renglones.addRenglonAsiento();
		renglon.setCuentaImputable(CuentasParametrizadas.getProveedores(this, getSesion()));

		if (IdentificacionTipoComprobante.esFactProv(getTipoCompro().getIdentificacion())
				|| IdentificacionTipoComprobante.esNDProv(getTipoCompro().getIdentificacion())
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


	public int getSignoLibroIVA() throws BaseException {
		if (this.getTipoCompro().esNotaDebitoInternoProveedor())
			return 1;
		if (this.getTipoCompro().esNotaCreditoInternoProveedor())
			return -1;
		throw new ExceptionValidation(null,"El tipo de comprobante ingresado no corresponde a una Nota de Debito/Credito proveedor"); 
	}
	
	public static ComproProveedorBase findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproProveedorInterno) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static ComproProveedorBase findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (ComproProveedorInterno) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	



}
