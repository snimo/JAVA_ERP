package com.srn.erp.tesoreria.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.da.DBLiquidacionTarCab;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class LiquidacionTarCab extends ComproCab implements IContabilizable {

	private List mediosPago = new ArrayList();
	
	private List valoresLiquidacion = new ArrayList();
	private boolean readValoresLiquidacion = true;
	
	
	public LiquidacionTarCab() {
	}

	public static String NICKNAME = "va.LiquidacionTarCab";

	private TipoValor tipo_valor;
	private String compo_tipo_valor;
	private TarjetaCredito tarjeta_credito;
	private Banco banco;
	private java.util.Date fec_desde;
	private java.util.Date fec_hasta;
	private java.util.Date fec_vto;
	private Moneda moneda;
	private ValorCotizacion cotizacion;
	private Money importe;
	private ConceptoLiqTarjeta concepto_liq_tar;
	private ComproCab comprobante;
	private Caja caja;
	private Valor valor;

	private List detallesLiquidacion = new ArrayList();
	private boolean readDetallesLiquidacion = true;

	public TipoValor getTipo_valor() throws BaseException {
		supportRefresh();
		return tipo_valor;
	}

	public void setTipo_valor(TipoValor aTipo_valor) {
		this.tipo_valor = aTipo_valor;
	}
	
	public Valor getValor() throws BaseException {
		supportRefresh();
		return this.valor;
	}

	public void setValor(Valor aValor) {
		this.valor = aValor;
	}
	
	
	public Caja getCaja() throws BaseException {
		supportRefresh();
		return caja;
	}

	public void setCaja(Caja aCaja) {
		this.caja = aCaja;
	}
	

	public String getCompo_tipo_valor() throws BaseException {
		supportRefresh();
		return compo_tipo_valor;
	}

	public void setCompo_tipo_valor(String aCompo_tipo_valor) {
		this.compo_tipo_valor = aCompo_tipo_valor;
	}

	public TarjetaCredito getTarjeta_credito() throws BaseException {
		supportRefresh();
		return tarjeta_credito;
	}

	public void setTarjeta_credito(TarjetaCredito aTarjeta_credito) {
		this.tarjeta_credito = aTarjeta_credito;
	}

	public Banco getBanco() throws BaseException {
		supportRefresh();
		return banco;
	}

	public void setBanco(Banco aBanco) {
		this.banco = aBanco;
	}

	public java.util.Date getFec_desde() throws BaseException {
		supportRefresh();
		return fec_desde;
	}

	public void setFec_desde(java.util.Date aFec_desde) {
		this.fec_desde = aFec_desde;
	}

	public java.util.Date getFec_hasta() throws BaseException {
		supportRefresh();
		return fec_hasta;
	}

	public void setFec_hasta(java.util.Date aFec_hasta) {
		this.fec_hasta = aFec_hasta;
	}

	public java.util.Date getFec_vto() throws BaseException {
		supportRefresh();
		return fec_vto;
	}

	public void setFec_vto(java.util.Date aFec_vto) {
		this.fec_vto = aFec_vto;
	}

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

	public void setCotizacion(ValorCotizacion aCotizacion) {
		this.cotizacion = aCotizacion;
	}

	public Money getImporte() throws BaseException {
		supportRefresh();
		return importe;
	}

	public void setImporte(Money aImporte) {
		this.importe = aImporte;
	}

	public ConceptoLiqTarjeta getConcepto_liq_tar() throws BaseException {
		supportRefresh();
		return concepto_liq_tar;
	}

	public void setConcepto_liq_tar(ConceptoLiqTarjeta aConcepto_liq_tar) {
		this.concepto_liq_tar = aConcepto_liq_tar;
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static LiquidacionTarCab findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (LiquidacionTarCab) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static LiquidacionTarCab findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (LiquidacionTarCab) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public static LiquidacionTarCab findByCodigo(String codigo, ISesion aSesion) throws BaseException {
		return (LiquidacionTarCab) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}

		beforeSaveComprobante(this);

		Validar.noNulo(tipo_valor, "Debe ingresar el Tipo de Valor");
		Validar.noNulo(fec_desde, "Debe ingresar la Fecha Desde");
		Validar.noNulo(fec_hasta, "Debe ingresar la Fecha Hasta");
		Validar.noNulo(fec_vto, "Debe ingresar la Fecha de Vencimiento");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");
		Validar.noNulo(concepto_liq_tar, "Debe ingresar el Concepto de Liquidación");
		Validar.noNulo(importe, "Debe ingresar el Importe");
		
		if (this.getConcepto_liq_tar().getTipoValor()!=null)
			if (this.getConcepto_liq_tar().getTipoValor().getMoneda().getOID()!=this.getMoneda().getOID())
				throw new ExceptionValidation(null,"La moneda de la liquidación no puede ser diferente a la moneda del Valor del concepto de liquidación");
		
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return super.getCodigo();
	}

	public ComproCab getComprobante() throws BaseException {
		return comprobante;
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public void afterSave() throws BaseException {

		afterSaveComprobante(this);
		
	    Iterator iterDetallesLiquidacion = detallesLiquidacion.iterator();
	    while (iterDetallesLiquidacion.hasNext()) {
	      LiquidacionTarjetaDet liqTarDet = (LiquidacionTarjetaDet) iterDetallesLiquidacion.next();
	      liqTarDet.save();
	      liqTarDet = null;
	    }
	    
	    Iterator iterValoresLiquidacion = this.valoresLiquidacion.iterator();
	    while (iterValoresLiquidacion.hasNext()) {
	      LiquidacionTarjetaValor liqTarVal = (LiquidacionTarjetaValor) iterValoresLiquidacion.next();
	      liqTarVal.save();
	      liqTarVal = null;
	    }
	    
	    iterDetallesLiquidacion = null;
	    
	    grabarValorLiquidacion();
	    
	    grabarMediosPago();
	    

	}
	
	private void grabarValorLiquidacion() throws BaseException {
		
		if (this.getConcepto_liq_tar().getTipoValor()==null) return;
		
 	     MedioPago medioPago = this.addMedioPago();
         medioPago.setIngresoEgreso(MedioPago.INGRESO);
         medioPago.setSujeto(null);
         medioPago.setFechaContable(this.getImputac());
         TipoValor tipoValor = this.getConcepto_liq_tar().getTipoValor();           
         medioPago.setTipoValor(tipoValor);
         medioPago.setFecEmision(this.getEmision());
         medioPago.setFecVencimiento(this.getFec_vto());
         medioPago.setImporteMonedaPago(this.getImporte());
         medioPago.setImporteMonedaValor(this.getImporte());
         medioPago.setCotizMonedaValor(this.getCotizacion());
         medioPago.setTarjetaCredito(this.getTarjeta_credito());
         medioPago.setCaja(this.getCaja());
         medioPago.setImportesContables(
       		  this.getImportesContables(this.getImporte(),
       				  					this.getMoneda(),
       				  					this.getEmision()));    		
			
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		RenglonesAsiento renglones = new RenglonesAsiento();
		generarAsientos(renglones);
		return renglones;
	}
	
	private void generarAsientos(RenglonesAsiento renglones) throws BaseException {
		
		Iterator iterDetLiq = 
			detallesLiquidacion.iterator();
		
		while (iterDetLiq.hasNext()) {
			LiquidacionTarjetaDet liqTarDet = (LiquidacionTarjetaDet) iterDetLiq.next();
			ImportesContables importesTarjeta = this.getImportesContables(liqTarDet.getImporte_liquidado(), this.getMoneda(), this.getImputac());

			RenglonAsiento renglon = renglones.addRenglonAsiento();
			renglon.setCuentaImputable(liqTarDet.getValor().getCuentaImputable());
			renglon.setD_H(RenglonAsiento.HABER);
			renglon.setMonedaOri(getMoneda());
			renglon.setImporteOri(liqTarDet.getImporte_liquidado());
			renglon.setCotizOri(this.getCotizacion());
			renglon.setComentario("");
			renglon.setCotizMonExt1(importesTarjeta.getValorCotizMonExt1());
			renglon.setCotizMonExt2(importesTarjeta.getValorCotizMonExt2());
			renglon.setImpoLocHist(importesTarjeta.getImpoMonLoc());
			renglon.setImpoLocAju(importesTarjeta.getImpoMonLocAju());
			renglon.setImpoMonExt1(importesTarjeta.getImpoMonExt1());
			renglon.setImpoMonExt2(importesTarjeta.getImpoMonExt2());
			
		}
		
		// Cuenta Liquidacion de Tarjeta
		ImportesContables importesLiquidacion = this.getImportesContables(this.getImporte(), this.getMoneda(), this.getImputac());
		CuentaImputable ctaImpuLiq = this.getConcepto_liq_tar().getCuentaImputable(this.getTarjeta_credito(),this.getBanco());
		if (ctaImpuLiq == null)
			throw new ExceptionValidation(null,"No se pudo obtener la cuenta contable para el concepto de Liquidación de Tarjetas");
		RenglonAsiento renglon = renglones.addRenglonAsiento();
		renglon.setCuentaImputable(ctaImpuLiq);
		renglon.setD_H(RenglonAsiento.DEBE);
		renglon.setMonedaOri(getMoneda());
		renglon.setImporteOri(this.getImporte());
		renglon.setCotizOri(this.getCotizacion());
		renglon.setComentario(this.getComentario());
		renglon.setCotizMonExt1(importesLiquidacion.getValorCotizMonExt1());
		renglon.setCotizMonExt2(importesLiquidacion.getValorCotizMonExt2());
		renglon.setImpoLocHist(importesLiquidacion.getImpoMonLoc());
		renglon.setImpoLocAju(importesLiquidacion.getImpoMonLocAju());
		renglon.setImpoMonExt1(importesLiquidacion.getImpoMonExt1());
		renglon.setImpoMonExt2(importesLiquidacion.getImpoMonExt2());
		
		
	}

	public Date getImputacion() throws BaseException {
		return this.getImputac();
	}

	public boolean getContabiliza() throws BaseException {
		ValorParametro vpContabilizaFactura = ValorParametro.findByCodigoParametro("CONTABILIZA_LIQ_TAR", getSesion());
		return vpContabilizaFactura.getBoolean();
	}

	public static List getHelpLiquidacionTarjetasCab(Integer nroExtDesde, Integer nroExtHasta, ConceptoLiqTarjeta conceptoLiquidacion,
			Date fechaDesde, Date fechaHasta, ISesion aSesion) throws BaseException {

		return DBLiquidacionTarCab.getHelpLiquidacionTarjetasCab(nroExtDesde, nroExtHasta, conceptoLiquidacion, fechaDesde, fechaHasta,
				aSesion);
	}

	public List getDetallesLiquidacion() throws BaseException {

		if (this.readDetallesLiquidacion) {
			List listaDetallesLiquidacion = LiquidacionTarjetaDet.getLiquidacionTarjetasDet(this, getSesion());
			detallesLiquidacion.addAll(listaDetallesLiquidacion);
			this.readDetallesLiquidacion = false;
		}
		return detallesLiquidacion;
	}
	
	public List getValoresLiquidacion() throws BaseException {

		if (this.readValoresLiquidacion) {
			List listaValoresLiquidacion = LiquidacionTarjetaValor.getLiquidacionesTarjetasValor(this, getSesion());
			this.valoresLiquidacion.addAll(listaValoresLiquidacion);
			this.readValoresLiquidacion = false;
		}
		return this.valoresLiquidacion;
	}
	

	public void addDetalleLiquidacion(LiquidacionTarjetaDet aLiquidacionTarjetaDet) throws BaseException {
		aLiquidacionTarjetaDet.setLiquidacion_tar(this);
		this.detallesLiquidacion.add(aLiquidacionTarjetaDet);
	}
	
	public void addLiquidacionTarjetaValor(LiquidacionTarjetaValor aLiquidacionTarjetaValor) throws BaseException {
		aLiquidacionTarjetaValor.setLiquidacion_tarjeta(this);
		this.valoresLiquidacion.add(aLiquidacionTarjetaValor);
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


}
