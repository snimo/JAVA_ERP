package com.srn.erp.bancos.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.bancos.da.DBNotaBancaria;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.MovimientoCtaBancaria;
import com.srn.erp.tesoreria.bm.OperacionCuentaBancaria;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class NotaBancaria extends ComproCab implements IContabilizable {

	public void afterSaveNew() throws BaseException {
		// TODO Auto-generated method stub
		super.afterSaveNew();
		
		grabarMovimientoCtaBanco();
	}

	public NotaBancaria() {
	}

	private ComproCab				comprobante;	
	
	public static String		NICKNAME			= "ba.NotaBancaria";

	private CuentaBancaria	cuenta_bancaria;

	private Moneda					moneda_cta;

	private Money						tot_mon_cta;

	private ValorCotizacion	cotizacion;

	private List						detalles			= new ArrayList();

	private boolean					readDetalles	= true;

	public CuentaBancaria getCuenta_bancaria() throws BaseException {
		supportRefresh();
		return cuenta_bancaria;
	}

	public void setCuenta_bancaria(CuentaBancaria aCuenta_bancaria) {
		this.cuenta_bancaria = aCuenta_bancaria;
	}

	public Moneda getMoneda_cta() throws BaseException {
		supportRefresh();
		return moneda_cta;
	}

	public void setMoneda_cta(Moneda aMoneda_cta) {
		this.moneda_cta = aMoneda_cta;
	}

	public Money getTot_mon_cta() throws BaseException {
		supportRefresh();
		return tot_mon_cta;
	}

	public void setTot_mon_cta(Money aTot_mon_cta) {
		this.tot_mon_cta = aTot_mon_cta;
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

	public static NotaBancaria findByOid(Integer oid, ISesion aSesion) throws BaseException {
		return (NotaBancaria) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static NotaBancaria findByOidProxy(Integer oid, ISesion aSesion) throws BaseException {
		return (NotaBancaria) getObjectByOidProxy(NICKNAME, oid, aSesion);
	}
	
	public void setComprobante(ComproCab aComprobante) {
		this.comprobante = aComprobante;
	}
	
	public void beforeSave() throws BaseException {
		
		if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
			
		}

		beforeSaveComprobante(this);
		
		
		Validar.noNulo(cuenta_bancaria, "Debe ingresar la Cuenta Bancaria");
		Validar.noNulo(moneda_cta, "Debe ingresar la Moneda");
		Validar.noNulo(tot_mon_cta, "Debe ingresar el Total");
		Validar.noNulo(cotizacion, "Debe ingresar el Tipo de Cambio");
		
		
		if (this.getTotDebitosMenosCreditos().doubleValue()>0) {
			if ((this.getTotDebitosMenosCreditos().doubleValue()!=this.getTot_mon_cta().doubleValue()))
				throw new ExceptionValidation(null,"El total no coincide con los debitos y creditos");
		}
		else {
			if ((this.getTotDebitosMenosCreditos().doubleValue()!=(this.getTot_mon_cta().doubleValue()*-1)))
				throw new ExceptionValidation(null,"El total no coincide con los debitos y creditos");
		}
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getCodigo();
	}

	public List getDetalles() throws BaseException {
		if (readDetalles) {
			List listaDetalles = NotaBancariaDet.getDetallesByNotaBancaria(this, getSesion());
			detalles.addAll(listaDetalles);
			readDetalles = false;
		}
		return detalles;
	}

	public void addDetalle(NotaBancariaDet notaBancariaDet) throws BaseException {
		notaBancariaDet.setNota_bancaria(this);
		detalles.add(notaBancariaDet);
	}

	public void afterSave() throws BaseException {
		
		Iterator iterDetalles = detalles.iterator();
		while (iterDetalles.hasNext()) {
			NotaBancariaDet notaBancariaDet = (NotaBancariaDet) iterDetalles.next();
			notaBancariaDet.save();
			notaBancariaDet = null;
		}
		iterDetalles = null;
		
		afterSaveComprobante(this);
	}

	public ComproCab getComprobante() throws BaseException {
		// TODO Auto-generated method stub
		return this.comprobante;
	}

	public Date getImputacion() throws BaseException {
		// TODO Auto-generated method stub
		return this.getImputac();
	}

	public RenglonesAsiento getRenglonesAsiento() throws BaseException {
		RenglonesAsiento renglones = new RenglonesAsiento();
  	// Imputar los Valores
  	Iterator iterDetalles = this.detalles.iterator();
  	while (iterDetalles.hasNext()) {
  		NotaBancariaDet notaBancariaDet = (NotaBancariaDet) iterDetalles.next();
  		imputarDetalle(notaBancariaDet,renglones);
  	}
  	imputarCtaBanco(renglones);
  	return renglones;	
  }
	
	private void imputarCtaBanco(RenglonesAsiento renglones) throws BaseException {
			
	  RenglonAsiento renglonGasto = renglones.addRenglonAsiento();
    renglonGasto.setCuentaImputable(this.getCuenta_bancaria().getCuentaimputableAConciliar());
    
    if (this.getTotDebitosMenosCreditos().doubleValue()>0)
    	renglonGasto.setD_H(RenglonAsiento.HABER);
    else
    	renglonGasto.setD_H(RenglonAsiento.DEBE);
    
    renglonGasto.setMonedaOri(this.getMoneda_cta());
    renglonGasto.setImporteOri(this.getTot_mon_cta());
    renglonGasto.setCotizOri(this.getCotizacion());
    renglonGasto.setCotizMonExt1(this.getCotizMonExt1());
    renglonGasto.setCotizMonExt2(this.getCotizMonExt2());
          
    ImportesContables importesContables = this.getImportesContables(this.getTot_mon_cta(),
    												  this.getMoneda_cta(),
    												  this.getEmision());
    		
    
    renglonGasto.setComentario("");
    renglonGasto.setImpoLocHist(importesContables.getImpoMonLoc());
    renglonGasto.setImpoLocAju(importesContables.getImpoMonLocAju());
    renglonGasto.setImpoMonExt1(importesContables.getImpoMonExt1());
    renglonGasto.setImpoMonExt2(importesContables.getImpoMonExt2());
			
	}
	
	private void imputarDetalle(NotaBancariaDet notaBancariaDet,RenglonesAsiento renglones) throws BaseException {
    RenglonAsiento renglonGasto = renglones.addRenglonAsiento();
    renglonGasto.setCuentaImputable(notaBancariaDet.getCuenta_imputable());
    
    Money importe = new Money(0);
    if ((notaBancariaDet.getDebe()!=null) && (notaBancariaDet.getDebe().doubleValue()>0)) {
    	renglonGasto.setD_H(RenglonAsiento.DEBE);
    	importe = notaBancariaDet.getDebe();
    }
    
    if ((notaBancariaDet.getHaber()!=null) && (notaBancariaDet.getHaber().doubleValue()>0)) {
    	renglonGasto.setD_H(RenglonAsiento.HABER);
    	importe = notaBancariaDet.getHaber();
    }
    
    renglonGasto.setMonedaOri(this.getMoneda_cta());
    renglonGasto.setImporteOri(importe);
    renglonGasto.setCotizOri(this.getCotizacion());
    renglonGasto.setCotizMonExt1(this.getCotizMonExt1());
    renglonGasto.setCotizMonExt2(this.getCotizMonExt2());
          
    ImportesContables importesContables = this.getImportesContables(importe,
    												  this.getMoneda_cta(),
    												  this.getEmision());
    		
    
    renglonGasto.setComentario("");
    renglonGasto.setImpoLocHist(importesContables.getImpoMonLoc());
    renglonGasto.setImpoLocAju(importesContables.getImpoMonLocAju());
    renglonGasto.setImpoMonExt1(importesContables.getImpoMonExt1());
    renglonGasto.setImpoMonExt2(importesContables.getImpoMonExt2());

	}
	
	private Money getTotDebitosMenosCreditos() throws BaseException {
		CalculadorMoney calcTot = new CalculadorMoney(new Money(0));
		Iterator iterDetalles = this.detalles.iterator();
		while (iterDetalles.hasNext()) {
			NotaBancariaDet notaBancariaDet = (NotaBancariaDet) iterDetalles.next();
			if (notaBancariaDet.getDebe()!=null)
				calcTot.sumar(notaBancariaDet.getDebe());
			if (notaBancariaDet.getHaber()!=null)
				calcTot.restar(notaBancariaDet.getHaber());
		}
		return calcTot.getResultMoney();
	}
	
	private void grabarMovimientoCtaBanco() throws BaseException {
		
		
		Iterator iterDetalles = this.detalles.iterator();
		while (iterDetalles.hasNext()) {
			NotaBancariaDet notaDet = (NotaBancariaDet) iterDetalles.next();
			grabarMovimientoDetalle(notaDet);
		}
		
	}
	
	private void grabarMovimientoDetalle(NotaBancariaDet notaDet) throws BaseException {
		
		OperacionCuentaBancaria operacionCuentaBancaria = new OperacionCuentaBancaria();
		operacionCuentaBancaria.setSesion(getSesion());
		operacionCuentaBancaria.setCtaBancaria(this.getCuenta_bancaria());
		operacionCuentaBancaria.setNroValor(null);
		int signo = 0;
		Money impoMovCtaBanco = new Money(0);
				
		if (!notaDet.isCredito()) {
			impoMovCtaBanco = notaDet.getDebe();
			signo = -1;
			operacionCuentaBancaria.setTipoMov(MovimientoCtaBancaria.NOTA_DEBITO);
		} else {
			impoMovCtaBanco = notaDet.getHaber();
			signo = 1;
			operacionCuentaBancaria.setTipoMov(MovimientoCtaBancaria.NOTA_CREDITO);
		}

		operacionCuentaBancaria.setFechaContable(this.getEmision());
		operacionCuentaBancaria.setFechaEmision(this.getEmision());
		operacionCuentaBancaria.setFechaVto(null);
		operacionCuentaBancaria.setCuenta(notaDet.getCuenta_imputable());
		operacionCuentaBancaria.setSigno(new Integer(signo));
		operacionCuentaBancaria.setImporte(impoMovCtaBanco);
		operacionCuentaBancaria.setComprobante(this);
		addCotizacionMoneda(this.getCuenta_bancaria().getMoneda(), this.getCotizacion());
		ImportesContables importesContables = this.getImportesContables(impoMovCtaBanco, this.getCuenta_bancaria().getMoneda(), this
				.getEmision());
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
		operacionCuentaBancaria.save();
		
	}
	
  public static List getHelpNotasBancarias(
  		Integer nroDesde,
  		Integer nroHasta,
  		java.util.Date fecDesde,
  		java.util.Date fecHasta,
  		CuentaBancaria cuentaBancaria,
  		ISesion aSesion) throws BaseException {
  	
  	return DBNotaBancaria.getHelpNotasBancarias(nroDesde,nroHasta,fecDesde,fecHasta,cuentaBancaria,aSesion);

  }
	

}
