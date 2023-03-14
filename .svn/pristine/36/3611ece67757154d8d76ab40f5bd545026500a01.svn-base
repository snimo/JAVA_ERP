package com.srn.erp.bancos.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// agregar comentario

import com.srn.erp.bancos.da.DBBoletaDeposito;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.MedioPago;
import com.srn.erp.tesoreria.bm.MovimientoCtaBancaria;
import com.srn.erp.tesoreria.bm.OperacionCuentaBancaria;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class BoletaDeposito extends ComproCab implements IContabilizable {

	private HashTableDatos movAcumPoTipoValor = new HashTableDatos();
	
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getCodigo();
	}

	public BoletaDeposito() {
	}

	private List						detallesBolDep	= new ArrayList();

	private boolean					readDetBolDep		= true;

	private List						detallesGastos	= new ArrayList();

	private boolean					readDetGastos		= true;

	public static String		NICKNAME				= "ba.BoletaDeposito";

	private java.util.Date	fec_deposito;

	private Integer					clearing;

	private CuentaBancaria	cuenta_bancaria;

	private Moneda					moneda;

	private ValorCotizacion	cotizacion;

	private ComproCab				comprobante;

	private Money						montoDeposito;

	private Money						gastos;

	private Money						netoDeposito;
	
	private Caja caja;
	
	public Caja getCaja() throws BaseException {
		supportRefresh();
		return caja;
	}

	public void setCaja(Caja aCaja) {
		this.caja = aCaja;
	}
	

	public Money getMontoDeposito() throws BaseException {
		supportRefresh();
		return montoDeposito;
	}

	public void setMontoDeposito(Money aMontoDeposito) {
		this.montoDeposito = aMontoDeposito;
	}

	public Money getGastos() throws BaseException {
		supportRefresh();
		return gastos;
	}

	public void setGastos(Money aGastos) {
		this.gastos = aGastos;
	}

	public Money getNetoDeposito() throws BaseException {
		supportRefresh();
		return this.netoDeposito;
	}

	public void setNetoDeposito(Money aNetoDeposito) {
		this.netoDeposito = aNetoDeposito;
	}

	public java.util.Date getFec_deposito() throws BaseException {
		supportRefresh();
		return fec_deposito;
	}

	public void setFec_deposito(java.util.Date aFec_deposito) {
		this.fec_deposito = aFec_deposito;
	}

	public Integer getClearing() throws BaseException {
		supportRefresh();
		return clearing;
	}

	public void setClearing(Integer aClearing) {
		this.clearing = aClearing;
	}

	public CuentaBancaria getCuenta_bancaria() throws BaseException {
		supportRefresh();
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(CuentaBancaria aCuenta_bancaria) {
		this.cuenta_bancaria = aCuenta_bancaria;
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

	public String getNickName() {
		return NICKNAME;
	}

	public static BoletaDeposito findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (BoletaDeposito) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static BoletaDeposito findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (BoletaDeposito) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}

	public void beforeSave() throws BaseException {

		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
		}

		beforeSaveComprobante(this);

		Validar.noNulo(moneda, "Debe Ingresar la Moneda");
		Validar.noNulo(this.fec_deposito, "Debe ingresar la Fecha de Depósito");
		Validar.noNulo(this.cuenta_bancaria, "Debe ingresar la Cuenta Bancaria");
		Validar.noNulo(this.cotizacion, "Debe ingresar la Cotización");
		Validar.noNulo(this.montoDeposito, "Debe ingresar el Monto Depósito");
		Validar.noNulo(this.gastos, "Debe ingresar el Gasto");
		Validar.noNulo(this.netoDeposito, "Debe ingresar el Neto Depositado");
		Validar.noNulo(this.caja, "Debe ingresar la Caja");

	}
	
	private void grabarMovPorTipoValor() throws BaseException {
		Iterator iterAcumPorTipoValor = 
			movAcumPoTipoValor.values().iterator();
		while (iterAcumPorTipoValor.hasNext()) {
			OperacionCuentaBancaria operacionCuentaBancaria = (OperacionCuentaBancaria) iterAcumPorTipoValor.next();
			operacionCuentaBancaria.save();
		}
	}
	
	private void acumPorTipoValor(BoletaDepositoDet boletaDepositoDet) throws BaseException {

		// Si no existe el movimiento volver a crearlo
		OperacionCuentaBancaria operacionCuentaBancaria = (OperacionCuentaBancaria)
					movAcumPoTipoValor.get(boletaDepositoDet.getTipo_valor().getOIDInteger());
		
		if (operacionCuentaBancaria == null) {
		    operacionCuentaBancaria = new OperacionCuentaBancaria();
		    operacionCuentaBancaria.setSesion(getSesion());
		    operacionCuentaBancaria.setCtaBancaria(this.getCuenta_bancaria());
		    operacionCuentaBancaria.setNroValor(null);
		    operacionCuentaBancaria.setTipoMov(MovimientoCtaBancaria.BOLETA_DEPOSITO);
		    operacionCuentaBancaria.setFechaContable(this.getEmision());
		    operacionCuentaBancaria.setFechaEmision(this.getEmision());
		    operacionCuentaBancaria.setFechaVto(this.getFechaDisponible());
		    operacionCuentaBancaria.setSigno(new Integer(MovimientoCtaBancaria.ENTRADA));
		    operacionCuentaBancaria.setComprobante(this);
		    operacionCuentaBancaria.setValor(null);
		    operacionCuentaBancaria.setTipoValor(boletaDepositoDet.getTipo_valor());
		    operacionCuentaBancaria.setActivo(new Boolean(true));
		    movAcumPoTipoValor.put(
		    		boletaDepositoDet.getTipo_valor().getOIDInteger(),
		    		operacionCuentaBancaria);
		}		
		
		operacionCuentaBancaria.AcumImporte(boletaDepositoDet.getImporte());
		
		addCotizacionMoneda(this.getMoneda(), this.getCotizacion());
		addCotizacionMoneda(boletaDepositoDet.getTipo_valor().getMoneda(), boletaDepositoDet.getCotizacion());
		ImportesContables importesContables = this.getImportesContables(
				boletaDepositoDet.getImporte(), 
				this.getMoneda(), 
				this.getEmision());
		
		operacionCuentaBancaria.AcumImporteHist(importesContables.getImpoMonLoc());
		operacionCuentaBancaria.AcumImporteAju(importesContables.getImpoMonLocAju());
		operacionCuentaBancaria.AcumImporteExt1(importesContables.getImpoMonExt1());
		operacionCuentaBancaria.AcumImporteExt2(importesContables.getImpoMonExt2());
		
		operacionCuentaBancaria.setCotizMonOri(this.getCotizacion());
		operacionCuentaBancaria.setCotizMonExt1(this.getCotizMonExt1());
		operacionCuentaBancaria.setCotizMonExt2(this.getCotizMonExt2());
		operacionCuentaBancaria.setCotizMonOriCon(this.getCotizacion());
		operacionCuentaBancaria.setCotizMonExt1Con(this.getCotizMonExt1());
		operacionCuentaBancaria.setCotizMonExt2Con(this.getCotizMonExt2());
		
	}

	public void afterSave() throws BaseException {

		Iterator iterDetBolDep = detallesBolDep.iterator();
		while (iterDetBolDep.hasNext()) {
			BoletaDepositoDet boletaDepositoDet = (BoletaDepositoDet) iterDetBolDep.next();
			boletaDepositoDet.save();
			if (boletaDepositoDet.getTipo_valor().isDiscValBolDep().booleanValue())
				grabarDepositoCuenta(boletaDepositoDet);
			else
				acumPorTipoValor(boletaDepositoDet);
			boletaDepositoDet = null;
		}
		iterDetBolDep = null;
		
		// Para los tipos de Valores configurados como que se graba un movimiento resumen por tipo de Valor
		grabarMovPorTipoValor();

		Iterator iterGastosBolDep = detallesGastos.iterator();
		while (iterGastosBolDep.hasNext()) {
			GastoBoletaDeposito gastoBoletaDeposito = (GastoBoletaDeposito) iterGastosBolDep.next();
			grabarDepositoCuenta(gastoBoletaDeposito);
			gastoBoletaDeposito.save();
			gastoBoletaDeposito = null;
		}
		iterGastosBolDep = null;

		grabarEgresoValores();
		

		afterSaveComprobante(this);
	}
	
	private void grabarDepositoCuenta(GastoBoletaDeposito gastoBoletaDeposito) throws BaseException {

		OperacionCuentaBancaria operacionCuentaBancaria = new OperacionCuentaBancaria();
		operacionCuentaBancaria.setSesion(getSesion());
		operacionCuentaBancaria.setCtaBancaria(this.getCuenta_bancaria());
		operacionCuentaBancaria.setNroValor(null);
		operacionCuentaBancaria.setTipoMov(MovimientoCtaBancaria.BOLETA_DEPOSITO);
		operacionCuentaBancaria.setFechaContable(this.getEmision());
		operacionCuentaBancaria.setFechaEmision(this.getEmision());
		operacionCuentaBancaria.setFechaVto(this.getFechaDisponible());
		
		ImportesContables importesContables = null;
		addCotizacionMoneda(this.getMoneda(), this.getCotizacion());
		
		if ((gastoBoletaDeposito.getDebe()!=null) && (gastoBoletaDeposito.getDebe().doubleValue()>0)) {
			
			operacionCuentaBancaria.setSigno(new Integer(MovimientoCtaBancaria.ENTRADA));
			operacionCuentaBancaria.setImporte(gastoBoletaDeposito.getDebe());
			importesContables = this.getImportesContables(
					gastoBoletaDeposito.getDebe(), 
					this.getMoneda(), 
					this.getEmision());
			
		}
		else {			
			
			operacionCuentaBancaria.setSigno(new Integer(MovimientoCtaBancaria.SALIDA));
			operacionCuentaBancaria.setImporte(gastoBoletaDeposito.getHaber());
			importesContables = this.getImportesContables(
					gastoBoletaDeposito.getHaber(), 
					this.getMoneda(), 
					this.getEmision());
			
		}
		
		operacionCuentaBancaria.setComprobante(this);
				
		operacionCuentaBancaria.setImporteHist(importesContables.getImpoMonLoc());
		operacionCuentaBancaria.setImporteAju(importesContables.getImpoMonLocAju());
		operacionCuentaBancaria.setImporteExt1(importesContables.getImpoMonExt1());
		operacionCuentaBancaria.setImporteExt2(importesContables.getImpoMonExt2());
		operacionCuentaBancaria.setActivo(new Boolean(true));
		operacionCuentaBancaria.setCotizMonOri(this.getCotizacion());
		operacionCuentaBancaria.setCotizMonExt1(this.getCotizMonExt1());
		operacionCuentaBancaria.setCotizMonExt2(this.getCotizMonExt2());
		operacionCuentaBancaria.setCotizMonOriCon(this.getCotizacion());
		operacionCuentaBancaria.setCotizMonExt1Con(this.getCotizMonExt1());
		operacionCuentaBancaria.setCotizMonExt2Con(this.getCotizMonExt2());
		operacionCuentaBancaria.setValor(null);
		operacionCuentaBancaria.setTipoValor(null);
		operacionCuentaBancaria.setCuenta(gastoBoletaDeposito.getCuenta_imputable());
		
		operacionCuentaBancaria.save();
		
	}
	

	private void grabarDepositoCuenta(BoletaDepositoDet boletaDepositoDet) throws BaseException {

		OperacionCuentaBancaria operacionCuentaBancaria = new OperacionCuentaBancaria();
		operacionCuentaBancaria.setSesion(getSesion());
		operacionCuentaBancaria.setCtaBancaria(this.getCuenta_bancaria());
		operacionCuentaBancaria.setFechaContable(this.getEmision());
		operacionCuentaBancaria.setFechaEmision(this.getEmision());
		operacionCuentaBancaria.setFechaVto(this.getFechaDisponible());
		operacionCuentaBancaria.setSigno(new Integer(MovimientoCtaBancaria.ENTRADA));
		operacionCuentaBancaria.setImporte(boletaDepositoDet.getImporte());
		operacionCuentaBancaria.setComprobante(this);
		addCotizacionMoneda(this.getMoneda(), this.getCotizacion());
		addCotizacionMoneda(boletaDepositoDet.getTipo_valor().getMoneda(), boletaDepositoDet.getCotizacion());
		ImportesContables importesContables = this.getImportesContables(
				boletaDepositoDet.getImporte(), 
				this.getMoneda(), 
				this.getEmision());
		
		
		if (boletaDepositoDet.getTipo_valor().isEfectivo())
			operacionCuentaBancaria.setTipoMov(MovimientoCtaBancaria.BOL_DEP_EFECTIVO);
		else if (boletaDepositoDet.getTipo_valor().isChequeCliente() || boletaDepositoDet.getTipo_valor().isChequeTercero())
			operacionCuentaBancaria.setTipoMov(MovimientoCtaBancaria.BOL_DEP_CHEQUE);
		else 
			operacionCuentaBancaria.setTipoMov(MovimientoCtaBancaria.BOLETA_DEPOSITO);
		
		operacionCuentaBancaria.setImporteHist(importesContables.getImpoMonLoc());
		operacionCuentaBancaria.setImporteAju(importesContables.getImpoMonLocAju());
		operacionCuentaBancaria.setImporteExt1(importesContables.getImpoMonExt1());
		operacionCuentaBancaria.setImporteExt2(importesContables.getImpoMonExt2());
		operacionCuentaBancaria.setActivo(new Boolean(true));
		operacionCuentaBancaria.setCotizMonOri(this.getCotizacion());
		operacionCuentaBancaria.setCotizMonExt1(this.getCotizMonExt1());
		operacionCuentaBancaria.setCotizMonExt2(this.getCotizMonExt2());
		operacionCuentaBancaria.setCotizMonOriCon(this.getCotizacion());
		operacionCuentaBancaria.setCotizMonExt1Con(this.getCotizMonExt1());
		operacionCuentaBancaria.setCotizMonExt2Con(this.getCotizMonExt2());
		operacionCuentaBancaria.setValor(boletaDepositoDet.getValor());
		
		if ((boletaDepositoDet.getValor()!=null) && (boletaDepositoDet.getTipo_valor().isChequeCliente()))
				operacionCuentaBancaria.setNroValor(boletaDepositoDet.getValor().getNrocheque());
		
		operacionCuentaBancaria.setTipoValor(boletaDepositoDet.getTipo_valor());
		
		operacionCuentaBancaria.save();
		
	}

	public void grabarEgresoValores() throws BaseException {
		Iterator iterBoletaDepDet = detallesBolDep.iterator();
		while (iterBoletaDepDet.hasNext()) {
			BoletaDepositoDet boletaDepositoDet = (BoletaDepositoDet) iterBoletaDepDet.next();

			MedioPago medioPago = new MedioPago();
			medioPago.setCaja(boletaDepositoDet.getCaja());
			medioPago.setSesion(getSesion());
			medioPago.setTipoValor(boletaDepositoDet.getTipo_valor());
			medioPago.setComprobante(this);
			medioPago.setIngresoEgreso(MedioPago.EGRESO);
			medioPago.setFechaContable(this.getImputac());
			medioPago.setValor(boletaDepositoDet.getValor());
			medioPago.setImporteMonedaValor(boletaDepositoDet.getImporte());
			//medioPago.setCotizMonedaValor(this.getCotizacionMoneda(boletaDepositoDet.getTipo_valor().getMoneda()));
			medioPago.setCotizMonedaValor(this.getCotizacion());
			medioPago.setDepositar(true);
			// medioPago.setImportesContables(
			// this.getImportesContables(boletaDepositoDet.getImpoMonValor(),
			// boletaDepositoDet.getTipo_valor().getMoneda(),
			// this.getEmision()));
			medioPago.save();
		}
	}

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this.comprobante;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getImputac();
	}

	public void addDetalleBoletaDeposito(BoletaDepositoDet boletaDepositoDet) throws BaseException {
		this.detallesBolDep.add(boletaDepositoDet);
		boletaDepositoDet.setBoleta_deposito(this);
	}

	public void addGastoBoletaDeposito(GastoBoletaDeposito gastoBoletaDeposito) throws BaseException {
		this.detallesGastos.add(gastoBoletaDeposito);
		gastoBoletaDeposito.setBoleta_deposito(this);
	}

	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}

	public List getDetallesBolDep() throws BaseException {
		if (readDetBolDep == true) {
			detallesBolDep.addAll(BoletaDepositoDet.getDetallesBolDep(this, getSesion()));
			readDetBolDep = false;
			return detallesBolDep;
		}
		else
			return detallesBolDep;
	}

	public List getGastosBoletaDepoito() throws BaseException {
		if (readDetGastos == true) {
			detallesGastos.addAll(GastoBoletaDeposito.getGastosByBoletaDeposito(this, getSesion()));
			readDetGastos = false;
			return detallesGastos;
		}
		else
			return detallesGastos;
	}
	
	
	public void imputarBanco(RenglonesAsiento renglones) throws BaseException {
		
    RenglonAsiento renglonBanco = renglones.addRenglonAsiento();
    renglonBanco.setCuentaImputable(this.getCuenta_bancaria().getCuentaimputableAConciliar());
    renglonBanco.setD_H(RenglonAsiento.DEBE);
    renglonBanco.setMonedaOri(this.getMoneda());
    renglonBanco.setImporteOri(this.getNetoDeposito());
    renglonBanco.setCotizOri(this.getCotizacion());
    renglonBanco.setCotizMonExt1(this.getCotizMonExt1());
    renglonBanco.setCotizMonExt2(this.getCotizMonExt2());
          
    ImportesContables importesContables = this.getImportesContables(this.getNetoDeposito(),
    												  this.getMoneda(),
    												  this.getEmision());
    		
    
    renglonBanco.setComentario("");
    renglonBanco.setImpoLocHist(importesContables.getImpoMonLoc());
    renglonBanco.setImpoLocAju(importesContables.getImpoMonLocAju());
    renglonBanco.setImpoMonExt1(importesContables.getImpoMonExt1());
    renglonBanco.setImpoMonExt2(importesContables.getImpoMonExt2());
    
	}
	
	public void imputarValor(BoletaDepositoDet boletaDepositoDet,RenglonesAsiento renglones) throws BaseException {
    RenglonAsiento renglonValor = renglones.addRenglonAsiento();
    if (boletaDepositoDet.getTipo_valor().getCuentaImputable()!=null)
    	renglonValor.setCuentaImputable(boletaDepositoDet.getTipo_valor().getCuentaImputable());
    else if (boletaDepositoDet.getValor()!=null)
    			renglonValor.setCuentaImputable(boletaDepositoDet.getValor().getCuentaImputable());
    renglonValor.setD_H(RenglonAsiento.HABER);
    renglonValor.setMonedaOri(boletaDepositoDet.getTipo_valor().getMoneda());
    renglonValor.setImporteOri(boletaDepositoDet.getImporte());
    renglonValor.setCotizOri(boletaDepositoDet.getCotizacion());
    renglonValor.setCotizMonExt1(this.getCotizMonExt1());
    renglonValor.setCotizMonExt2(this.getCotizMonExt2());
          
    ImportesContables importesContables = this.getImportesContables(boletaDepositoDet.getImporte(),
    												  boletaDepositoDet.getTipo_valor().getMoneda(),
    												  this.getEmision());
    		
    
    renglonValor.setComentario("");
    renglonValor.setImpoLocHist(importesContables.getImpoMonLoc());
    renglonValor.setImpoLocAju(importesContables.getImpoMonLocAju());
    renglonValor.setImpoMonExt1(importesContables.getImpoMonExt1());
    renglonValor.setImpoMonExt2(importesContables.getImpoMonExt2());
		
	}
	
	public void imputarGasto(GastoBoletaDeposito gastoBoletaDeposito,RenglonesAsiento renglones) throws BaseException {
    RenglonAsiento renglonGasto = renglones.addRenglonAsiento();
    renglonGasto.setCuentaImputable(gastoBoletaDeposito.getCuenta_imputable());
    renglonGasto.setD_H(RenglonAsiento.DEBE);
    renglonGasto.setMonedaOri(this.getMoneda());
    renglonGasto.setImporteOri(this.getGastos());
    renglonGasto.setCotizOri(this.getCotizacion());
    renglonGasto.setCotizMonExt1(this.getCotizMonExt1());
    renglonGasto.setCotizMonExt2(this.getCotizMonExt2());
          
    ImportesContables importesContables = this.getImportesContables(this.getGastos(),
    												  this.getMoneda(),
    												  this.getEmision());
    		
    
    renglonGasto.setComentario("");
    renglonGasto.setImpoLocHist(importesContables.getImpoMonLoc());
    renglonGasto.setImpoLocAju(importesContables.getImpoMonLocAju());
    renglonGasto.setImpoMonExt1(importesContables.getImpoMonExt1());
    renglonGasto.setImpoMonExt2(importesContables.getImpoMonExt2());
		
	}
	
  public RenglonesAsiento getRenglonesAsiento() throws BaseException {
  	
  	RenglonesAsiento renglones = new RenglonesAsiento();
  	// Imputar los Valores
  	Iterator iterDetallesBolDepDet = this.detallesBolDep.iterator();
  	while (iterDetallesBolDepDet.hasNext()) {
  		BoletaDepositoDet bolDepDet = (BoletaDepositoDet) iterDetallesBolDepDet.next();
  		imputarValor(bolDepDet,renglones);
  	}
  	// Imputar la cuenta Bancaria
  	imputarBanco(renglones);
  	
  	// Imputarcomisiones o Gastos
  	Iterator iterGastosBoletaDeposito = this.detallesGastos.iterator();
  	while (iterGastosBoletaDeposito.hasNext()) {
  		GastoBoletaDeposito gastoBoletaDeposito = (GastoBoletaDeposito) iterGastosBoletaDeposito.next();
  		imputarGasto(gastoBoletaDeposito,renglones);
  	}
  	
  	return renglones;
  }
  
  public static List getHelpBoletasDeposito(
  		Integer nroDesde,
  		Integer nroHasta,
  		java.util.Date fecDesde,
  		java.util.Date fecHasta,
  		CuentaBancaria cuentaBancaria,
  		ISesion aSesion) throws BaseException {
  	
  	return DBBoletaDeposito.getHelpBoletasDeposito(nroDesde,nroHasta,fecDesde,fecHasta,cuentaBancaria,aSesion);

  }
  
  public java.util.Date getFechaDisponible() throws BaseException {
	  if (this.getFec_deposito() == null)
		  throw new ExceptionValidation(null,"Debe ingresar la fecha de Depósito");
	  Integer dias = new Integer(0);
	  if (this.getCuenta_bancaria().getClearingEnDias()!=null)
		  dias = this.getCuenta_bancaria().getClearingEnDias();
	  return Fecha.getFechaMasDias(this.getFec_deposito(), dias);
  }
  
	

}
