package com.srn.erp.tesoreria.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.CuentasParametrizadas;
import com.srn.erp.contabilidad.bm.EstructuraCompo;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctasACobrar.bm.AplicacionComproClie;
import com.srn.erp.ctasACobrar.bm.AplicacionComproClieDet;
import com.srn.erp.ctasACobrar.bm.GrabarCtaCteClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.impuestos.bm.ILibroIVA;
import com.srn.erp.impuestos.bm.ListadoIVACab;
import com.srn.erp.tesoreria.da.DBRecibo;
import com.srn.erp.ventas.bm.Cobrador;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Recibo extends ComproCab implements IContabilizable, ILibroIVA {

	private AnuladorRecibo anuladorRecibo = null;
	
	private List facturasRecibo = new ArrayList();
	private boolean readFacturasRecibo = true;

	private List valoresRecibo = new ArrayList();
	private boolean readValoresRecibo = true;
	
	private List ingVarRecibos = new ArrayList();
	private boolean readIngVarRecibos = true;
	
	public static final String ING_VAR  = "INGVAR";
	public static final String COB_CLIE = "COBCLIE";  
	
	private String enConcepto;
	
	private ComproCab comprobante;
	private List mediosPago = new ArrayList();

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public java.util.Date getImputacion() throws BaseException {
		return this.getImputac();
	}

	public ComproCab getComprobante() throws BaseException {
		return comprobante;
	}

	public Recibo() {
	}

	public static String NICKNAME = "te.Recibo";

	private Cobrador cobrador;

	private Caja caja;

	private Sujeto sujeto;

	private ValorCotizacion cotizacion;

	private Money tot_mon_ori;

	private Money tot_mon_loc;

	private Boolean reemplaza_recibo;

	private Moneda moneda;

	private String nro_rec_ori;
	
	private String tipoOper;
	
	private Money pagoACuenta;
	
	private Boolean isPagoACuenta = new Boolean(false);
	
	public void setIsPagoACuenta(Boolean isPagoACuenta) throws BaseException {
		this.isPagoACuenta = isPagoACuenta;
	}
	
	public boolean isPagoACuenta() throws BaseException {
		return this.isPagoACuenta.booleanValue();
	}
	
	public void setPagoACuenta(Money aPagoACuenta) throws BaseException {
		this.pagoACuenta = aPagoACuenta;
	}
	
	public Money getPagoACuenta() throws BaseException {
		return this.pagoACuenta;
	}

	public Cobrador getCobrador() throws BaseException {
		supportRefresh();
		return cobrador;
	}

	public void setCobrador(Cobrador aCobrador) {
		this.cobrador = aCobrador;
	}
	
	public String getTipoOper() throws BaseException {
		supportRefresh();
		return tipoOper;
	}
	
	public void setTipoOper(String aTipoOper) {
		this.tipoOper = aTipoOper;
	}
	
	public String getEnConcepto() throws BaseException {
		supportRefresh();
		return this.enConcepto;
	}
	
	public void setEnConcepto(String aEnConcepto) {
		this.enConcepto = aEnConcepto;
	}
	
	

	public Caja getCaja() throws BaseException {
		supportRefresh();
		return caja;
	}

	public void setCaja(Caja aCaja) {
		this.caja = aCaja;
	}

	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) {
		this.sujeto = aSujeto;
	}

	public ValorCotizacion getCotizacion() throws BaseException {
		supportRefresh();
		return cotizacion;
	}

	public void setCotizacion(ValorCotizacion aCotizacion) {
		this.cotizacion = aCotizacion;
	}

	public Money getTot_mon_ori() throws BaseException {
		supportRefresh();
		return tot_mon_ori;
	}

	public void setTot_mon_ori(Money aTot_mon_ori) {
		this.tot_mon_ori = aTot_mon_ori;
	}

	public Money getTot_mon_loc() throws BaseException {
		supportRefresh();
		return tot_mon_loc;
	}

	public void setTot_mon_loc(Money aTot_mon_loc) {
		this.tot_mon_loc = aTot_mon_loc;
	}

	public Boolean isReemplaza_recibo() throws BaseException {
		supportRefresh();
		return reemplaza_recibo;
	}

	public void setReemplaza_recibo(Boolean aReemplaza_recibo) {
		this.reemplaza_recibo = aReemplaza_recibo;
	}

	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}

	public String getNro_rec_ori() throws BaseException {
		supportRefresh();
		return nro_rec_ori;
	}

	public void setNro_rec_ori(String aNro_rec_ori) {
		this.nro_rec_ori = aNro_rec_ori;
		if ((aNro_rec_ori!=null) && (!aNro_rec_ori.equals("")))
			this.setReemplaza_recibo(new Boolean(true));
		else
			this.setReemplaza_recibo(new Boolean(false));
	}

	public String getNickName() {
		return NICKNAME;
	}

	public static Recibo findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (Recibo) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static Recibo findByOidProxy(Integer oid, ISesion aSesion)
			throws BaseException {
		return (Recibo) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}

		beforeSaveComprobante(this);

		Validar.noNulo(cobrador, "Debe Ingresar el Cobrador");
		Validar.noNulo(caja, "Debe ingresar la Caja");
		Validar.noNulo(tot_mon_ori, "Debe ingresar el Total del Recibo");
		Validar.noNulo(moneda, "Debe ingresar la Moneda");

	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		RenglonesAsiento renglones = new RenglonesAsiento();
		if (this.isPagoACuenta.booleanValue())
			getRenglonPagoACuenta(renglones);
		if (this.getTipoOper().equals(COB_CLIE))
			  getRenglonDeudoresPorVentas(renglones);
		else
			  getRenglonMotIngresosVarios(renglones);
		getRenglonDescuentoRecibo(renglones);
		getRenglonValores(renglones);
		return renglones;
	}
	
	private void getRenglonPagoACuenta(RenglonesAsiento renglones) throws BaseException {
		
		if (!this.isPagoACuenta()) return;
					
		ImportesContables importesPagoACuenta = this.getImportesContables(this.getPagoACuenta(), 	
					this.getMoneda(),
					this.getImputac());
						
		RenglonAsiento renglon = renglones.addRenglonAsiento();
		renglon.setCuentaImputable(CuentasParametrizadas.getPagoACuentaRecibo(this.getSesion()));
		renglon.setD_H(RenglonAsiento.HABER);
		renglon.setMonedaOri(this.getMoneda());
		renglon.setImporteOri(this.getPagoACuenta());
		renglon.setCotizOri(this.getCotizacion());
		renglon.setComentario("");
		renglon.setCotizMonExt1(importesPagoACuenta.getValorCotizMonExt1());
		renglon.setCotizMonExt2(importesPagoACuenta.getValorCotizMonExt2());

		renglon.setImpoLocHist(importesPagoACuenta.getImpoMonLoc());
		renglon.setImpoLocAju(importesPagoACuenta.getImpoMonLocAju());
		renglon.setImpoMonExt1(importesPagoACuenta.getImpoMonExt1());
		renglon.setImpoMonExt2(importesPagoACuenta.getImpoMonExt2());
			
	
  }
	
	
	  

	private void getRenglonMotIngresosVarios(RenglonesAsiento renglones) throws BaseException {
		
		boolean esDebe = false;
		Iterator iterMotivosIngVarios = this.ingVarRecibos.iterator();
		while (iterMotivosIngVarios.hasNext()) {
			MotivoIngresoVarios motivoIngresoVarios = (MotivoIngresoVarios) iterMotivosIngVarios.next();
	
			Money importe = new Money(0);
			if ((motivoIngresoVarios.getDebe()!=null) && (motivoIngresoVarios.getDebe().doubleValue()>0)) { 
				importe = motivoIngresoVarios.getDebe();
				esDebe = true;
			}

			if ((motivoIngresoVarios.getHaber()!=null) && (motivoIngresoVarios.getHaber().doubleValue()>0)) 
				importe = motivoIngresoVarios.getHaber(); 
			
			
			ImportesContables importesValores = this.getImportesContables(importe, 	
					this.getMoneda(),
					this.getImputac());
						
			RenglonAsiento renglon = renglones.addRenglonAsiento();
			renglon.setCuentaImputable(motivoIngresoVarios.getCuenta_imputable());
			if (esDebe)
				renglon.setD_H(RenglonAsiento.DEBE);
			else
				renglon.setD_H(RenglonAsiento.HABER);
			renglon.setMonedaOri(this.getMoneda());
			renglon.setImporteOri(importe);
			renglon.setCotizOri(this.getCotizacion());
			renglon.setComentario("");
			renglon.setCotizMonExt1(importesValores.getValorCotizMonExt1());
			renglon.setCotizMonExt2(importesValores.getValorCotizMonExt2());

			renglon.setImpoLocHist(importesValores.getImpoMonLoc());
			renglon.setImpoLocAju(importesValores.getImpoMonLocAju());
			renglon.setImpoMonExt1(importesValores.getImpoMonExt1());
			renglon.setImpoMonExt2(importesValores.getImpoMonExt2());
			
		}
	}
	
	
	private void getRenglonValores(RenglonesAsiento renglones) throws BaseException {
		
		
		
		
		Iterator iterMediosPago = this.mediosPago.iterator();
		while (iterMediosPago.hasNext()) {
			MedioPago medioPago = (MedioPago) iterMediosPago.next();

			
		
			
			addCotizacionMoneda(medioPago.getTipoValor().getMoneda(),medioPago.getCotizMonedaValor());
			ImportesContables importesValores = this.getImportesContables(medioPago.getImporteMonedaValor(), 	
					medioPago.getTipoValor().getMoneda(),
					this.getImputac());
			
			
			RenglonAsiento renglon = renglones.addRenglonAsiento();
			if (medioPago.getTipoValor().getCuentaImputable()!=null)
				renglon.setCuentaImputable(medioPago.getTipoValor().getCuentaImputable());
			else if (medioPago.getValorGrabado()!=null)
				renglon.setCuentaImputable(medioPago.getValorGrabado().getCuentaImputable());
				
			renglon.setD_H(RenglonAsiento.DEBE);
			renglon.setMonedaOri(medioPago.getTipoValor().getMoneda());
			renglon.setImporteOri(medioPago.getImporteMonedaValor());
			renglon.setCotizOri(medioPago.getCotizMonedaValor());
			renglon.setComentario("");
			renglon.setCotizMonExt1(importesValores.getValorCotizMonExt1());
			renglon.setCotizMonExt2(importesValores.getValorCotizMonExt2());

			renglon.setImpoLocHist(importesValores.getImpoMonLoc());
			renglon.setImpoLocAju(importesValores.getImpoMonLocAju());
			renglon.setImpoMonExt1(importesValores.getImpoMonExt1());
			renglon.setImpoMonExt2(importesValores.getImpoMonExt2());
			
			
			
		}
		
		/* EL SIGUIENTE CODIGO FUE COMENTADO Y REEMPLAZADO POR EL CODIGO DE ARRIBA
		Iterator iterValoresRecibo = this.getValoresRecibo().iterator();
		while (iterValoresRecibo.hasNext()) {
			ValoresRecibo valorRecibo = (ValoresRecibo) iterValoresRecibo.next();
	
			addCotizacionMoneda(valorRecibo.getTipo_valor().getMoneda(),valorRecibo.getCotizacion());
			ImportesContables importesValores = this.getImportesContables(valorRecibo.getImpo_mon_ori(), 	
					valorRecibo.getTipo_valor().getMoneda(),
					this.getImputac());
						
			RenglonAsiento renglon = renglones.addRenglonAsiento();
			renglon.setCuentaImputable(valorRecibo.getTipo_valor().getCuentaImputable());
			renglon.setD_H(RenglonAsiento.DEBE);
			renglon.setMonedaOri(valorRecibo.getTipo_valor().getMoneda());
			renglon.setImporteOri(valorRecibo.getImpo_mon_ori());
			renglon.setCotizOri(valorRecibo.getCotizacion());
			renglon.setComentario("");
			renglon.setCotizMonExt1(importesValores.getValorCotizMonExt1());
			renglon.setCotizMonExt2(importesValores.getValorCotizMonExt2());

			renglon.setImpoLocHist(importesValores.getImpoMonLoc());
			renglon.setImpoLocAju(importesValores.getImpoMonLocAju());
			renglon.setImpoMonExt1(importesValores.getImpoMonExt1());
			renglon.setImpoMonExt2(importesValores.getImpoMonExt2());
			
		}*/
	}
	
	private void getRenglonDescuentoRecibo(RenglonesAsiento renglones) throws BaseException {
		
		Iterator iterFacturasRecibo = this.facturasRecibo.iterator();
		while (iterFacturasRecibo.hasNext()) {
			FacturasRecibo facturasRecibo = (FacturasRecibo) iterFacturasRecibo.next();
			
			CalculadorMoney totDtoRecibo = new CalculadorMoney(new Money(0));
			if (facturasRecibo.getImpo_dto_mon_ori()!=null)
				totDtoRecibo.sumar(facturasRecibo.getImpo_dto_mon_ori());
			
			ImportesContables importesDtoRecibo = this.getImportesContables(totDtoRecibo.getResultMoney(),
					this.getMoneda(),
					this.getImputac());
			
			if (totDtoRecibo.getResultMoney().doubleValue() == 0) continue;
			
			RenglonAsiento renglon = renglones.addRenglonAsiento();
			renglon.setCuentaImputable(CuentasParametrizadas.getDtoOtorgadoRecibo(getSesion()));
			renglon.setD_H(RenglonAsiento.DEBE);
			renglon.setMonedaOri(facturasRecibo.getTranClieVto().getMoneda());
			renglon.setImporteOri(totDtoRecibo.getResultMoney());
			renglon.setCotizOri(facturasRecibo.getCotizacion());
			renglon.setComentario("");
			renglon.setCotizMonExt1(importesDtoRecibo.getValorCotizMonExt1());
			renglon.setCotizMonExt2(importesDtoRecibo.getValorCotizMonExt2());

			renglon.setImpoLocHist(importesDtoRecibo.getImpoMonLoc());
			renglon.setImpoLocAju(importesDtoRecibo.getImpoMonLocAju());
			renglon.setImpoMonExt1(importesDtoRecibo.getImpoMonExt1());
			renglon.setImpoMonExt2(importesDtoRecibo.getImpoMonExt2());
		}
				
	}
	
	private void getRenglonDeudoresPorVentas(RenglonesAsiento renglones) throws BaseException {
		
		
		Iterator iterFacturasRecibo = this.facturasRecibo.iterator();
		while (iterFacturasRecibo.hasNext()) {
			FacturasRecibo facturasRecibo = (FacturasRecibo) iterFacturasRecibo.next();
			
			CalculadorMoney totDeudoresPorVtas = new CalculadorMoney(facturasRecibo.getImpo_cob_mon_ori());
			if (facturasRecibo.getImpo_dto_mon_ori()!=null)
				totDeudoresPorVtas.sumar(facturasRecibo.getImpo_dto_mon_ori());
			
			ImportesContables importesDeudoresPorVentas = this.getImportesContables(totDeudoresPorVtas.getResultMoney(),
					this.getMoneda(),
					this.getImputac());
			
			RenglonAsiento renglon = renglones.addRenglonAsiento();
			renglon.setCuentaImputable(CuentasParametrizadas.getDeudoresPorVentas(getSesion()));
			renglon.setD_H(RenglonAsiento.HABER);
			renglon.setMonedaOri(facturasRecibo.getTranClieVto().getMoneda());
			renglon.setImporteOri(totDeudoresPorVtas.getResultMoney());
			renglon.setCotizOri(facturasRecibo.getCotizacion());
			renglon.setComentario("");
			renglon.setCotizMonExt1(importesDeudoresPorVentas.getValorCotizMonExt1());
			renglon.setCotizMonExt2(importesDeudoresPorVentas.getValorCotizMonExt2());

			renglon.setImpoLocHist(importesDeudoresPorVentas.getImpoMonLoc());
			renglon.setImpoLocAju(importesDeudoresPorVentas.getImpoMonLocAju());
			renglon.setImpoMonExt1(importesDeudoresPorVentas.getImpoMonExt1());
			renglon.setImpoMonExt2(importesDeudoresPorVentas.getImpoMonExt2());
		}
		
	}
	

	public ListadoIVACab getLibroIVACab() throws BaseException {
		// Grabar los Impuestos correspondientes al comprobantes Proveedor
		return null;
	}

	public int getSignoLibroIVA() throws BaseException {
		return 1;
	}
	
	public List getValoresRecibo() throws BaseException {
		if (readValoresRecibo) {
			List listaValoresRecibo = ValoresRecibo.getValoresEnRecibo(this,
					getSesion());
			valoresRecibo.addAll(listaValoresRecibo);
			readValoresRecibo = false;
		}
		return valoresRecibo;
	}
	
	public List getMotivosIngVarios() throws BaseException {
		if (readIngVarRecibos) {
			List listaIngVarRecibos = MotivoIngresoVarios.getMotIngVarByRecibo(this,
					getSesion());
			ingVarRecibos.addAll(listaIngVarRecibos);
			readIngVarRecibos = false;
		}
		return ingVarRecibos;
	}
	
	

	public List getFacturasRecibo() throws BaseException {
		if (readFacturasRecibo) {
			List listaFacturasRecibo = FacturasRecibo.getFacturasEnRecibo(this,
					getSesion());
			facturasRecibo.addAll(listaFacturasRecibo);
			readFacturasRecibo = false;
		}
		return facturasRecibo;
	}

	public void addFacturaRecibo(FacturasRecibo aFacturasRecibo)
			throws BaseException {
		aFacturasRecibo.setRecibo(this);
		facturasRecibo.add(aFacturasRecibo);
	}
	
	public void addValorRecibo(ValoresRecibo aValoresRecibo)
	throws BaseException {
		aValoresRecibo.setRecibo(this);
		valoresRecibo.add(aValoresRecibo);
	}
	
	public void addMotivoIngVarios(MotivoIngresoVarios aMotivoIngresoVarios)
	throws BaseException {
		aMotivoIngresoVarios.setRecibo(this);
		ingVarRecibos.add(aMotivoIngresoVarios);
	}
	
	private void grabarFacturasRecibo() throws BaseException {
		Iterator iterFacturasRecibo = facturasRecibo.iterator();
		while (iterFacturasRecibo.hasNext()) {
			FacturasRecibo facturaRecibo = (FacturasRecibo) iterFacturasRecibo
					.next();
			facturaRecibo.save();
			facturaRecibo = null;
		}
		iterFacturasRecibo = null;		
	}
	
	private void grabarValoresRecibo() throws BaseException {
		Iterator iterValoresRecibo = valoresRecibo.iterator();
		while (iterValoresRecibo.hasNext()) {
			ValoresRecibo valorRecibo = (ValoresRecibo) iterValoresRecibo.next();
			valorRecibo.save();
			valorRecibo = null;
		}
		iterValoresRecibo = null;
	}
	
	private void grabarMotivosIngVar() throws BaseException {
		Iterator iterIngVarRecibos = ingVarRecibos.iterator();
		while (iterIngVarRecibos.hasNext()) {
			MotivoIngresoVarios motivoIngresoVarios = (MotivoIngresoVarios) iterIngVarRecibos.next();
			motivoIngresoVarios.save();
			motivoIngresoVarios = null;
		}
		iterIngVarRecibos = null;
	}

	public void afterSave() throws BaseException {
		grabarFacturasRecibo();
		grabarValoresRecibo();
		grabarMotivosIngVar();
		grabarMediosPago();
		aplicarCtaCte();
		if (this.isPagoACuenta.booleanValue())
			grabarPagoACuenta(this.getPagoACuenta());
		afterSaveComprobante(this);
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
  
  public void aplicarCtaCte() throws BaseException {

  	if (facturasRecibo.isEmpty()) return;
  	
	  // Realizar las Aplicaciones
	  Talonario talAplicClie = AplicacionComproClie.getTalonatioAplicComproClie(getSesion()); 
  	  
    AplicacionComproClie aplicacionComproClie = (AplicacionComproClie)AplicacionComproClie.getNew(AplicacionComproClie.NICKNAME,getSesion());
    aplicacionComproClie.setContabiliza(false);
    aplicacionComproClie.setTalonario(talAplicClie);
    aplicacionComproClie.setTipoCompro(talAplicClie.getTipo_comprobante());
    aplicacionComproClie.setLetra(talAplicClie.getLetra());
    aplicacionComproClie.setLugarEmision(talAplicClie.getLugar_emision());
    aplicacionComproClie.setEmision(this.getEmision());
    aplicacionComproClie.setImputacion(this.getImputacion()); 
    aplicacionComproClie.setComentario("");
    aplicacionComproClie.setSujeto(this.getSujeto());
    aplicacionComproClie.setNoContaOtrasMonedas(new Boolean(false));
    aplicacionComproClie.setActivo(new Boolean(true));
    aplicacionComproClie.setAllowDesaplicar(false);
    
    Iterator iterFacturasCobradas = facturasRecibo.iterator();
    while (iterFacturasCobradas.hasNext()) {
    	FacturasRecibo facturaCobrada = (FacturasRecibo) iterFacturasCobradas.next();
    	AplicacionComproClieDet aplicComproClieDet =
    		aplicacionComproClie.addDetalle();
    	aplicComproClieDet.setTranClieVto(facturaCobrada.getTranClieVto());
    	
    	//Calcular Total a Aplicar = Cobrado + el descuento realizadp
    	CalculadorMoney calcTotAplic = new CalculadorMoney(facturaCobrada.getImpo_cob_mon_ori());
    	if (facturaCobrada.getImpo_dto_mon_ori()!=null)
    		calcTotAplic.sumar(facturaCobrada.getImpo_dto_mon_ori());
    	calcTotAplic.multiplicarPor(new Money(-1));
    	// Aplicar Descuento
    	aplicComproClieDet.setAplicmonedaori(calcTotAplic.getResultMoney());
    	
    	// Obtener las cotizaciones correspondientes
    	aplicComproClieDet.setCotizmonoricont(facturaCobrada.getTranClieVto().getTran_clie().getCotiz_mon_ori_co());
    	aplicComproClieDet.setCotizmonext1cont(facturaCobrada.getTranClieVto().getTran_clie().getCotiz_mon_ext1_co());
    	aplicComproClieDet.setCotizmonext2cont(facturaCobrada.getTranClieVto().getTran_clie().getCotiz_mon_ext2_co());
    	
    	aplicComproClieDet.setCotizmonorihoy(this.getCotizacionMoneda(facturaCobrada.getTranClieVto().getMoneda()));
    	aplicComproClieDet.setCotizmonext1hoy(this.getCotizMonExt1());
    	aplicComproClieDet.setCotizmonext2hoy(this.getCotizMonExt2());
    	
    	aplicComproClieDet.setNroRelacion(new Integer(0));
    	aplicComproClieDet.setComproAplicOri(this);
    	aplicComproClieDet.setTranClieVtoAplic(null);
          	
     }
    
    if (!facturasRecibo.isEmpty())
    	aplicacionComproClie.save();

  }
  
  public void grabarPagoACuenta(Money pagoACuenta) throws BaseException {

    // Grabar pago a Cuenta
  	
  	if (pagoACuenta == null) return;
  	
  	if (pagoACuenta.doubleValue() == 0) return;

    GrabarCtaCteClie ctaCteClie = new GrabarCtaCteClie(getSesion());
    ctaCteClie.setSigno(new Integer(-1));
    ctaCteClie.setComprobante(this);
    ctaCteClie.setTipoCtaCteClie(TipoCtaCteClie.getTipoCtaCteClieAnticipoCliente(getSesion()));
    ctaCteClie.setSujeto(this.getSujeto());
    ctaCteClie.setMoneda(this.getMoneda());
    ctaCteClie.setImporte(this.getPagoACuenta());
    ctaCteClie.setImputac(this.getImputac());
    ctaCteClie.setEmision(this.getImputac());
    ctaCteClie.setBase(this.getImputac());
    ctaCteClie.setCotizMonOri(this.getCotizacion());
    ctaCteClie.setCotizMonExt1(this.getCotizMonExt1());
    ctaCteClie.setCotizMonExt2(this.getCotizMonExt2());
    ctaCteClie.setCotizMonOriCon(this.getCotizacion());
    ctaCteClie.setCotizMonExt1Con(this.getCotizMonExt1());
    ctaCteClie.setCotizMonExt2Con(this.getCotizMonExt2());
    ctaCteClie.setCondVenta(null);
    ctaCteClie.addVtoFechaFija(this.getImputac(),
                               pagoACuenta);
    ctaCteClie.save();

  }
  
  public static List getHelpRecibos(Integer nroExtDesde,
      Integer nroExtHasta,
      Sujeto sujeto,
      Date fechaDesde,
      Date fechaHasta,
      ISesion aSesion) throws BaseException {

  	return DBRecibo.getHelpRecibos(nroExtDesde,nroExtHasta,sujeto,fechaDesde,fechaHasta,aSesion);
  }  
  
	public void anular() throws BaseException {

		anuladorRecibo = (AnuladorRecibo) AnuladorRecibo.getNew(AnuladorRecibo.NICKNAME, getSesion());
		anuladorRecibo.setRecibo(this);
		anuladorRecibo.generarComproAnulacion();
		anuladorRecibo.save();		
		
	}
	
	public static boolean isContabilizaRecibo(ISesion aSesion)
	throws BaseException {
		try {
		return ValorParametro.findByCodigoParametro(
		"CONTA_RECIBO", aSesion).getBoolean();
		} catch(Exception e) {
			return true;
		}
	}	
  
  
    
}
