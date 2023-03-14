package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.LiberacionImpuestoSujeto;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;

public class CalculadorPercIBBsAs {
	
	List items = new ArrayList();
	
	private ISesion sesion;
	private Porcentaje tasa;
	private Sujeto sujeto;
	private Provincia provincia;
	private Empresa empresa;
	private Sucursal sucursal;
	private Money percIB;
	private Money totNetoGravado = new Money(0);
	private java.util.Date fecha;
	private ValorCotizacion cotizacion;
	
	
	public ValorCotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(ValorCotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Money getPercIB() throws BaseException {
		return this.percIB;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(Date aFecha) {
		this.fecha = aFecha;
	}
	
	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public void setSesion(ISesion aSesion) throws BaseException {
		this.sesion = aSesion;
	}
	
	public ISesion getSesion() throws BaseException {
		return this.sesion;
	}
	
	public void setTasa(Porcentaje aTasa) throws BaseException {
		this.tasa = aTasa;
	}
	
	public void setProvincia(Provincia aProvincia) throws BaseException {
		this.provincia = aProvincia;
	}
	
	public Provincia getProvincia() throws BaseException {
		return this.provincia;
	}
	
	public Porcentaje getTasa() throws BaseException {
		return this.tasa;
	}
	
	public void setSujeto(Sujeto aSujeto) throws BaseException {
		this.sujeto = aSujeto;
	}
	
	public Sujeto getSujeto() throws BaseException {
		return this.sujeto;
	}
	
	public void addNetoGravado(Producto producto,Money netoGravado) throws BaseException {
		ItemPercIB itemPercIB = new ItemPercIB();
		itemPercIB.setProducto(producto);
		itemPercIB.setNetoGravado(netoGravado);
		items.add(itemPercIB);
	}
	
	public void calcular() throws BaseException {
		
		this.percIB = new Money(0);
		this.totNetoGravado = new Money(0);
		
		if (isCorrespondeCalcPercIBBsAs()==false)
			return;
		
		procesarItems();
		calcPercIB();
	}
	
	private void procesarItems() throws BaseException {
		
		CalculadorMoney calcTotNetoGravado = new CalculadorMoney(new Money(0));
		
		Iterator iterItems = this.items.iterator();
		while (iterItems.hasNext()) {
			ItemPercIB itemPercIB = (ItemPercIB) iterItems.next();
			
			if (itemPercIB.getProducto().isCalcPercIBBsAs()==true)
				calcTotNetoGravado.sumar(itemPercIB.getNetoGravado());
		}
		
		if (calcTotNetoGravado.getResult()>0)
			this.totNetoGravado = calcTotNetoGravado.getResultMoney();
		
		
		
	}
	
	private Money getTotalNetoGravado() throws BaseException {
		return this.totNetoGravado;
	}
	
	private void calcPercIB() throws BaseException {
		
		
		this.tasa = this.getTasaPercIB(); 
		
		if (tasa==null) return;
		
		if (this.getTotalNetoGravado().doubleValue()<=0) return;
		
		// Llevar el Neto a la Moneda curso legal para validar la base imponible
		CalculadorMoney baseImpoMonLoc = new CalculadorMoney(this.getTotalNetoGravado());
		baseImpoMonLoc.multiplicarPor(this.getCotizacion());
		ConceptoImpuesto concImpu = ConceptoImpuesto.getPercIBBsAs(this.getSesion());
		
		if (baseImpoMonLoc.getResult()<concImpu.getBaseImponible().doubleValue())
			return ;
		
		
		CalculadorMoney calcPercIB = new CalculadorMoney(tasa);
		calcPercIB.dividirPor(new Money(100));
		calcPercIB.multiplicarPor(this.getTotalNetoGravado());
		
		Money impuPerc = new Money(calcPercIB.getResult(2));
		if (impuPerc.doubleValue()<concImpu.getImpuestoMinimo().doubleValue())
			return;
		
		this.percIB = impuPerc; 
		
	}
	
	private boolean isCorrespondeCalcPercIBBsAs() throws BaseException {
		
		if (this.getEmpresa()!=null)
			if (this.getEmpresa().isAgentePercIBBsAs()==false)
				return false;
		
		if (this.getSucursal()!=null)
			if (this.getSucursal().isAgentePercIBBsAs()==false)
				return false;
		
		if (this.getSujeto()!=null)
			if (this.getSujeto().isSusceptiblePercIBBsAs()==false)
				return false;
		
		if (this.getSujeto()!=null)
			if (this.getSujeto().getSujeto_impositivo()!=null)
				if (this.getSujeto().getSujeto_impositivo().getCategib()!=null)
					if (this.getSujeto().getSujeto_impositivo().getCategib().isCalcPercIBBsAs()==false)
						return false;
		
		if (this.getSujeto()!=null)
			if (this.getSujeto().getSujeto_impositivo()!=null)
				if (this.getSujeto().getSujeto_impositivo().getCategiva()!=null)
					if (this.getSujeto().getSujeto_impositivo().getCategiva().isAgentePercIBBsAs()==false)
						return false;			
		
		return true;
	}
	
	private LiberacionImpuestoSujeto getLiberacionImpuestoSujeto() throws BaseException {
	
		if (this.getSujeto() == null)
			return null;
		
		LiberacionImpuestoSujeto libImpuSuj = 
			LiberacionImpuestoSujeto.getLiberacionImpuestoSujeto(this.getSujeto(),this.getFecha(),this.getSesion());
		
		if (libImpuSuj == null)
			return null;
		else
			return libImpuSuj;
		
	}
	
	
	private Porcentaje getPorcIBMenosLiberacion(Porcentaje tasaIB,
			                                        Porcentaje tasaLiberacion) throws BaseException {
		
		if (tasaLiberacion == null)
			return tasaIB;
		
		CalculadorMoney calcTasa = new CalculadorMoney(tasaIB);
		calcTasa.restar(tasaLiberacion);
		if (calcTasa.getResult()<=0)
			return new Porcentaje(0);
		else
			return new Porcentaje(calcTasa.getResult());
	}
	
	private Porcentaje getTasaPercIB() throws BaseException {
		
		
		LiberacionImpuestoSujeto libImpSuj = getLiberacionImpuestoSujeto();
		
		Porcentaje porcLib = new Porcentaje(0);
		
		if (libImpSuj!=null) {
			
			// Si tiene cargado la liberacion predomina por sobre el padron
			if (libImpSuj.getNuevo_porc().doubleValue()>0)
					return libImpSuj.getNuevo_porc();
			
			if ((libImpSuj.getNuevo_porc().doubleValue()==0) &&
			   (libImpSuj.getPorc_lib().doubleValue()==0))
				return new Porcentaje(0);
			
			if ((libImpSuj.getNuevo_porc().doubleValue()==0) &&
				   (libImpSuj.getPorc_lib().doubleValue()==100))
					return new Porcentaje(0);
			
			if ((libImpSuj.getPorc_lib().doubleValue()>0))
				porcLib = libImpSuj.getPorc_lib(); 
			
			
		}
		
		if (this.getSujeto()==null)
			return new Porcentaje(0);
		
		if (sujeto.getSujeto_impositivo()==null)
			return new Porcentaje(0);
		
		if (sujeto.getSujeto_impositivo().getCuit()==null)
			return new Porcentaje(0);
		
		// Verificar si encuentra en el Padro
		TablaPercIBBsAs tablaPercIB =
			TablaPercIBBsAs.getTablaPercIBBsAs(
				this.getSujeto().getSujeto_impositivo().getCuit(),
				this.getFecha(),
				this.getSesion());
		
		// Si se encuentra en el Padro devuelvo la tasa
		if (tablaPercIB!=null) 
			return getPorcIBMenosLiberacion(tablaPercIB.getAli_percepcion(),porcLib);
		
		// Si es provincia de Buenos Aires
		if (this.getProvincia()==null)
			return new Porcentaje(0);
		
		if (this.getProvincia().isCalcPercIBBA())
			return getPorcIBMenosLiberacion(getMaxPorcPercIBBsAs(this.getSesion()),porcLib);
		
		return new Porcentaje(0);
	}
	
	 public static Porcentaje getMaxPorcPercIBBsAs(ISesion aSesion) throws BaseException {
	       return new Porcentaje(ValorParametro.findByCodigoParametro("MAX_PORC_PERC_IB_BSAS",aSesion).getValorDecimal().doubleValue());
	 }
	
	
	

}
