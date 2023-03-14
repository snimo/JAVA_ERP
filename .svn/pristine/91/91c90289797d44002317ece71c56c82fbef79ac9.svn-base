package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ComproProvTotImpu;
import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.da.DBRendicionFondoFijo;
import com.srn.erp.tesoreria.bm.MedioPago;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class RendicionFondoFijo extends ComproCab implements IContabilizable {

	private boolean					readComprobantesProv			= true;

	private List						detallesComprobantesProv	= new ArrayList();

	private boolean					readImputaciones					= true;

	private List						detallesImputaciones			= new ArrayList();

	private boolean					readMediosPago						= true;

	private List						mediosPago								= new ArrayList();

	private List						mediosPagoFF							= new ArrayList();

	private AnuladorRendFF	anuladorRendFF						= null;

	public ComproCab getComprobante() throws BaseException {
		return this;
	}

	public Date getImputacion() throws BaseException {
		return getImputac();
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

	public RendicionFondoFijo() {
	}

	public static String		NICKNAME	= "pag.RendicionFondoFijo";

	private Moneda					moneda;

	private ComproCab				comprobante;

	private ValorCotizacion	cotizacion;

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public ValorCotizacion getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizacion(ValorCotizacion aValorCotizacion) {
		this.cotizacion = aValorCotizacion;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static RendicionFondoFijo findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (RendicionFondoFijo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static RendicionFondoFijo findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (RendicionFondoFijo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {
		Validar.noNulo(moneda, "Debe ingresar la Moneda");

		beforeSaveComprobante(this);
		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
		}

		grabarComproProv();

	}

	public void afterSave() throws BaseException {
		afterSaveComprobante(this);
		grabarImputacionesComproProv();
		grabarMediosPago();
	}

	private void grabarImputacionesComproProv() throws BaseException {
		Iterator iterImputaciones = detallesImputaciones.iterator();
		while (iterImputaciones.hasNext()) {
			RendicionFondoFijoImpu rendFondoFijoImpu = (RendicionFondoFijoImpu) iterImputaciones.next();
			rendFondoFijoImpu.save();
			rendFondoFijoImpu = null;
		}
		iterImputaciones = null;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public static FormaPago getFormaPagoDefault(ISesion aSesion) throws BaseException {
		ValorParametro valorParamFormaPagoDefault = ValorParametro.findByCodigoParametro("FORMA_PAGO_DEF_FONDO_FIJO",
				aSesion);
		FormaPago formaPago = FormaPago.findByOid(valorParamFormaPagoDefault.getOidObjNeg(), aSesion);
		return formaPago;
	}

	public static CondicionCompra getCondPagoDefaultFF(ISesion aSesion) throws BaseException {
		ValorParametro valorParamCondPagoDefault = ValorParametro.findByCodigoParametro("COND_PAGO_FONDO_FIJO", aSesion);
		CondicionCompra condPago = CondicionCompra.findByOid(valorParamCondPagoDefault.getOidObjNeg(), aSesion);
		return condPago;
	}

	public static boolean contabilizarComprobante(ISesion aSesion) throws BaseException {
		ValorParametro valorParamContabilizaComproProv = ValorParametro.findByCodigoParametro("CONTA_REND_FONDO_FIJO",
				aSesion);
		return valorParamContabilizaComproProv.getBoolean();
	}

	public static TipoCtaCteProv getTipoCtaCteProv(ISesion aSesion) throws BaseException {
		ValorParametro valorParamTipoCtaCteProv = ValorParametro.findByCodigoParametro("TIPO_CTA_FF", aSesion);
		TipoCtaCteProv tipoCtaCteProv = TipoCtaCteProv.findByOid(valorParamTipoCtaCteProv.getOidObjNeg(), aSesion);
		return tipoCtaCteProv;
	}

	public RendicionFondoFijoCompro addDetComproProvFF() throws BaseException {
		RendicionFondoFijoCompro comproProv = (RendicionFondoFijoCompro) ComproProveedor.getNew(
				RendicionFondoFijoCompro.NICKNAME, getSesion());
		comproProv.setRendicion_fondo(this);
		detallesComprobantesProv.add(comproProv);
		return comproProv;
	}

	public RendicionFondoFijoImpu addRendFFImputacion() throws BaseException {
		RendicionFondoFijoImpu rendFFImpu = (RendicionFondoFijoImpu) RendicionFondoFijoImpu.getNew(
				RendicionFondoFijoImpu.NICKNAME, getSesion());
		rendFFImpu.setRendicion_fondo(this);
		detallesImputaciones.add(rendFFImpu);
		return rendFFImpu;
	}

	public List getComproProvRendFF() throws BaseException {
		if (readComprobantesProv) {
			cargarListaFromBD(detallesComprobantesProv, RendicionFondoFijoCompro.getComprobantesFF(this, getSesion()));
			readComprobantesProv = false;
		}
		return detallesComprobantesProv;
	}

	public List getDetallesMediosPago() throws BaseException {
		if (this.readMediosPago) {
			cargarListaFromBD(this.mediosPagoFF, RendicionFondoFijoMedioPago.getValores(this, getSesion()));
			this.readMediosPago = false;
		}
		return this.mediosPagoFF;
	}

	public List getImputacionesRendFF() throws BaseException {
		if (readImputaciones) {
			cargarListaFromBD(detallesImputaciones, RendicionFondoFijoImpu.getImputacionesRendFF(this, getSesion()));
			readImputaciones = false;
		}
		return detallesImputaciones;
	}

	private void grabarComproProv() throws BaseException {
		Iterator iterDetalles = detallesComprobantesProv.iterator();
		while (iterDetalles.hasNext()) {
			RendicionFondoFijoCompro comproProveedor = (RendicionFondoFijoCompro) iterDetalles.next();
			comproProveedor.save();
			comproProveedor = null;
		}
		iterDetalles = null;
	}

	private void grabarMediosPago() throws BaseException {
		Iterator iterMediosPagos = mediosPago.iterator();
		while (iterMediosPagos.hasNext()) {
			MedioPago medioPago = (MedioPago) iterMediosPagos.next();
			medioPago.save();
		}
	}

	public MedioPago addMedioPago() throws BaseException {
		MedioPago medioPago = new MedioPago();
		medioPago.setSesion(getSesion());
		medioPago.setComprobante(this);
		mediosPago.add(medioPago);
		return medioPago;
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {

		RenglonesAsiento renglones = new RenglonesAsiento();

		// Debitar las imputaciones correspondientes a los comprobantes del Proveedor
		Iterator iterDetalles = getComproProvRendFF().iterator();
		while (iterDetalles.hasNext()) {
			RendicionFondoFijoCompro comproProvRendFF = (RendicionFondoFijoCompro) iterDetalles.next();
			Iterator iterImputacionesComproProv = comproProvRendFF.getRendicionFondoFijoImputacionesCompro().iterator();
			while (iterImputacionesComproProv.hasNext()) {
				RendicionFondoFijoComproImpu rendFFComproImpu = (RendicionFondoFijoComproImpu) iterImputacionesComproProv
						.next();
				armarRenglonImputacionComproProv(renglones, rendFFComproImpu);
			}

			armarRenglonesImpuestosComproProv(renglones, comproProvRendFF);
		}

		// Debitar o Acreditar las imputaciones del Asiento
		Iterator iterImputacionesRendFF = detallesImputaciones.iterator();
		while (iterImputacionesRendFF.hasNext()) {
			RendicionFondoFijoImpu rendFFImpu = (RendicionFondoFijoImpu) iterImputacionesRendFF.next();
			armarRenglonImputacionRendFF(renglones, rendFFImpu);
		}

		// Grabar las Imputaciones correspondientes a los Valores
		Iterator iterMediosPago = mediosPago.iterator();
		while (iterMediosPago.hasNext()) {
			MedioPago medioPago = (MedioPago) iterMediosPago.next();
			armarRenglonMedioPago(renglones, medioPago);
		}

		return renglones;

	}

	private void armarRenglonesImpuestosComproProv(RenglonesAsiento renglones, RendicionFondoFijoCompro rendFFCompro)
			throws BaseException {
		Iterator iterImpuestosComproProv = rendFFCompro.getComprobante_proveedor().getDetallesTotImpuestos().iterator();
		while (iterImpuestosComproProv.hasNext()) {
			ComproProvTotImpu comproProvImpuesto = (ComproProvTotImpu) iterImpuestosComproProv.next();

			RenglonAsiento renglonImpuesto = renglones.addRenglonAsiento();
			renglonImpuesto.setComentario("");
			if (comproProvImpuesto.getConceptoImpuesto().getCuentaImputable() == null)
				throw new ExceptionValidation(null, "Debe configurar la cuenta contable para el concepto de impuesto "
						+ comproProvImpuesto.getConceptoImpuesto().getDescripcion());
			renglonImpuesto.setCuentaImputable(comproProvImpuesto.getConceptoImpuesto().getCuentaImputable());
			renglonImpuesto.setD_H(RenglonAsiento.DEBE);
			renglonImpuesto.setMonedaOri(rendFFCompro.getComprobante_proveedor().getMoneda());
			renglonImpuesto.setImporteOri(comproProvImpuesto.getImporteMonedaOri());
			renglonImpuesto.setCotizOri(this.getCotizacionMoneda(rendFFCompro.getComprobante_proveedor().getMoneda()));

			ImportesContables importesImpuesto = this.getImportesContables(comproProvImpuesto.getImporteMonedaOri(),
					rendFFCompro.getComprobante_proveedor().getMoneda(), this.getImputac());

			renglonImpuesto.setCotizMonExt1(importesImpuesto.getValorCotizMonExt1());
			renglonImpuesto.setCotizMonExt2(importesImpuesto.getValorCotizMonExt2());
			renglonImpuesto.setImpoLocHist(importesImpuesto.getImpoMonLoc());
			renglonImpuesto.setImpoLocAju(importesImpuesto.getImpoMonLocAju());
			renglonImpuesto.setImpoMonExt1(importesImpuesto.getImpoMonExt1());
			renglonImpuesto.setImpoMonExt2(importesImpuesto.getImpoMonExt2());

		}
	}

	private RenglonAsiento armarRenglonMedioPago(RenglonesAsiento renglones, MedioPago medioPago) throws BaseException {

		RenglonAsiento renglonValor = renglones.addRenglonAsiento();
		renglonValor.setComentario("");
		renglonValor.setCuentaImputable(medioPago.getCuentaImputable());
		renglonValor.setD_H(RenglonAsiento.HABER);
		renglonValor.setMonedaOri(getMoneda());
		renglonValor.setImporteOri(medioPago.getImporteMonedaValor());
		renglonValor.setCotizOri(medioPago.getCotizMonedaValor());
		renglonValor.setCotizMonExt1(medioPago.getImportesContables().getValorCotizMonExt1());
		renglonValor.setCotizMonExt2(medioPago.getImportesContables().getValorCotizMonExt2());
		renglonValor.setImpoLocHist(medioPago.getImportesContables().getImpoMonLoc());
		renglonValor.setImpoLocAju(medioPago.getImportesContables().getImpoMonLocAju());
		renglonValor.setImpoMonExt1(medioPago.getImportesContables().getImpoMonExt1());
		renglonValor.setImpoMonExt2(medioPago.getImportesContables().getImpoMonExt2());

		return renglonValor;
	}

	private RenglonAsiento armarRenglonImputacionRendFF(RenglonesAsiento renglones, RendicionFondoFijoImpu rendFFImpu)
			throws BaseException {

		int DEBE_O_HABER = 0;
		Money importe = new Money("0");
		if ((rendFFImpu.getImporte_debe() != null) && (rendFFImpu.getImporte_debe().doubleValue() > 0)) {
			importe = new Money(rendFFImpu.getImporte_debe().doubleValue());
			DEBE_O_HABER = RenglonAsiento.DEBE;
		}
		else {
			if (rendFFImpu.getImporte_haber() == null)
				return null;
			importe = new Money(rendFFImpu.getImporte_haber().doubleValue());
			DEBE_O_HABER = RenglonAsiento.HABER;
		}

		ImportesContables importesContablesImputacion = this.getImportesContables(importe, this.getMoneda(), this
				.getImputac());

		RenglonAsiento renglonImputacionRendFF = renglones.addRenglonAsiento();
		renglonImputacionRendFF.setCuentaImputable(rendFFImpu.getCuenta_imputable());
		renglonImputacionRendFF.setD_H(DEBE_O_HABER);
		renglonImputacionRendFF.setMonedaOri(this.getMoneda());
		renglonImputacionRendFF.setImporteOri(importe);
		renglonImputacionRendFF.setCotizOri(this.getCotizacion());
		renglonImputacionRendFF.setCotizMonExt1(importesContablesImputacion.getValorCotizMonExt1());
		renglonImputacionRendFF.setCotizMonExt2(importesContablesImputacion.getValorCotizMonExt2());

		renglonImputacionRendFF.setComentario("");
		renglonImputacionRendFF.setImpoLocHist(importesContablesImputacion.getImpoMonLoc());
		renglonImputacionRendFF.setImpoLocAju(importesContablesImputacion.getImpoMonLocAju());
		renglonImputacionRendFF.setImpoMonExt1(importesContablesImputacion.getImpoMonExt1());
		renglonImputacionRendFF.setImpoMonExt2(importesContablesImputacion.getImpoMonExt2());

		return renglonImputacionRendFF;
	}

	private RenglonAsiento armarRenglonImputacionComproProv(RenglonesAsiento renglones,
			RendicionFondoFijoComproImpu imputacionComproProv) throws BaseException {

		ImportesContables importesContablesImpuComproProv = this.getImportesContables(new Money(imputacionComproProv
				.getImporte().doubleValue()), imputacionComproProv.getRendicion_det().getComprobante_proveedor().getMoneda(),
				this.getImputac());

		RenglonAsiento renglonImputacionComproProv = renglones.addRenglonAsiento();
		renglonImputacionComproProv.setCuentaImputable(imputacionComproProv.getCuenta_imputable());
		renglonImputacionComproProv.setD_H(RenglonAsiento.DEBE);
		renglonImputacionComproProv.setMonedaOri(imputacionComproProv.getRendicion_det().getComprobante_proveedor()
				.getMoneda());
		renglonImputacionComproProv.setImporteOri(new Money(imputacionComproProv.getImporte().doubleValue()));
		renglonImputacionComproProv.setCotizOri(this.getCotizacionMoneda(imputacionComproProv.getRendicion_det()
				.getComprobante_proveedor().getMoneda()));
		renglonImputacionComproProv.setCotizMonExt1(importesContablesImpuComproProv.getValorCotizMonExt1());
		renglonImputacionComproProv.setCotizMonExt2(importesContablesImpuComproProv.getValorCotizMonExt2());

		renglonImputacionComproProv.setComentario("");
		renglonImputacionComproProv.setImpoLocHist(importesContablesImpuComproProv.getImpoMonLoc());
		renglonImputacionComproProv.setImpoLocAju(importesContablesImpuComproProv.getImpoMonLocAju());
		renglonImputacionComproProv.setImpoMonExt1(importesContablesImpuComproProv.getImpoMonExt1());
		renglonImputacionComproProv.setImpoMonExt2(importesContablesImpuComproProv.getImpoMonExt2());

		return renglonImputacionComproProv;
	}

	public static ConceptoImpuesto getConcImpuestoIVA(ISesion aSesion) throws BaseException {
		ValorParametro valorParamConcImpu = ValorParametro.findByCodigoParametro("CONC_IMPU_IVA_REND_FF", aSesion);
		ConceptoImpuesto conceptoImpuesto = ConceptoImpuesto.findByOid(valorParamConcImpu.getOidObjNeg(), aSesion);
		return conceptoImpuesto;
	}

	public static ConceptoImpuesto getConcImpuestoPercIVA(ISesion aSesion) throws BaseException {
		ValorParametro valorParamConcImpu = ValorParametro.findByCodigoParametro("CONC_IMPU_PERC_IVA_REND_FF", aSesion);
		ConceptoImpuesto conceptoImpuesto = ConceptoImpuesto.findByOid(valorParamConcImpu.getOidObjNeg(), aSesion);
		return conceptoImpuesto;
	}

	public static ConceptoImpuesto getConcImpuestoPercIB(ISesion aSesion) throws BaseException {
		ValorParametro valorParamConcImpu = ValorParametro.findByCodigoParametro("CONC_IMPU_PERC_IB_REND_FF", aSesion);
		ConceptoImpuesto conceptoImpuesto = ConceptoImpuesto.findByOid(valorParamConcImpu.getOidObjNeg(), aSesion);
		return conceptoImpuesto;
	}

	public static List getHelpRendicionFF(Integer nroExtDesde, Integer nroExtHasta, Proveedor proveedor, Date fechaDesde,
			Date fechaHasta, ISesion aSesion) throws BaseException {

		return DBRendicionFondoFijo
				.getHelpRendicionFF(nroExtDesde, nroExtHasta, proveedor, fechaDesde, fechaHasta, aSesion);
	}

	public void anular() throws BaseException {

		anuladorRendFF = (AnuladorRendFF) AnuladorRendFF.getNew(AnuladorRendFF.NICKNAME, getSesion());
		anuladorRendFF.setRendicion_ff(this);
		anuladorRendFF.generarComproAnulacion();
		anuladorRendFF.save();

	}

	protected void beforeSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.beforeSaveNew();
		
		Iterator iterComproProv = this.detallesComprobantesProv.iterator();		
		while (iterComproProv.hasNext()) {
			RendicionFondoFijoCompro rendFFCompro = 
				(RendicionFondoFijoCompro) iterComproProv.next();
			
			if (rendFFCompro.getIVA().doubleValue()!=rendFFCompro.getTotalImpuestosIVA().doubleValue())
				throw new ExceptionValidation(null,"El IVA ingresado a nivel comprobante no coincide con el total del IVA ingresado en los impuestos para el comprobante "+
						rendFFCompro.getComprobante_proveedor().getCodigo());
				
			if (rendFFCompro.getPercIVA().doubleValue()!=rendFFCompro.getTotalImpuestosPercIVA().doubleValue())
				throw new ExceptionValidation(null,"La Perc. de IVA ingresado a nivel comprobante no coincide con el total de Perc. de IVA ingresado en los impuestos para el comprobante "+
						rendFFCompro.getComprobante_proveedor().getCodigo());
			
			if (rendFFCompro.getPercIB().doubleValue()!=rendFFCompro.getTotalImpuestosPercIB().doubleValue())
				throw new ExceptionValidation(null,"La Perc. de IB ingresada a nivel comprobante no coincide con el total de la Perc. de I.B. ingresada en los impuestos para el comprobante "+
						rendFFCompro.getComprobante_proveedor().getCodigo());

			if (rendFFCompro.getOtrosImp().doubleValue()!=rendFFCompro.getTotalImpuestosOtrosImpuestos().doubleValue())
				throw new ExceptionValidation(null,"Los impuestos internos ingresados a nivel comprobante no coincide con el total de Impuestos Internos ingresados en los impuestos para el comprobante "+
						rendFFCompro.getComprobante_proveedor().getCodigo());
			
		}
		
		
		
		// Controlar el total de impuesto
		
		
	}

}