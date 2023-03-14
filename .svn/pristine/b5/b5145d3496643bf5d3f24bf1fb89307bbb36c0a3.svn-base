package com.srn.erp.ventas.bm;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.TasaIVA;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.applicarionServer.bm.Varios.Redondear;
import framework.request.bl.Utils.BaseException;

public class CalculadorItemFactura {
	
	ISesion aSesion;
	
	private Integer oidDet;
	private Producto producto;
	private Money precioLista;
	private Money precio;
	private Porcentaje porcBonif1;
	private Porcentaje porcBonif2;
	private Porcentaje porcBonif3;
	private Money precioNetoBonif;
	private Money cantidad;
	private boolean bonifEnCascada = false;
	
	public Money getNetoGravadoSaldoPendFactSenia() {
		return netoGravadoSaldoPendFactSenia;
	}

	public void setNetoGravadoSaldoPendFactSenia(Money netoGravadoSaldoPendFactSenia) {
		this.netoGravadoSaldoPendFactSenia = netoGravadoSaldoPendFactSenia;
	}

	public Money getNetoNoGravadoSaldoPendFactSenia() {
		return netoNoGravadoSaldoPendFactSenia;
	}

	public void setNetoNoGravadoSaldoPendFactSenia(
			Money netoNoGravadoSaldoPendFactSenia) {
		this.netoNoGravadoSaldoPendFactSenia = netoNoGravadoSaldoPendFactSenia;
	}
	
	public Money getNetoNoGravadoSeniaFact() {
		return this.netoNoGravadoSeniaFact;
	}

	public void setNetoNoGravadoSeniaFact(
			Money aNetoNoGravadoSeniaFact) {
		this.netoNoGravadoSeniaFact = aNetoNoGravadoSeniaFact;
	}
	
	public Money getNetoGravadoSeniaFact() {
		return this.netoGravadoSeniaFact;
	}

	public void setNetoGravadoSeniaFact(
			Money aNetoGravadoSeniaFact) {
		this.netoGravadoSeniaFact = aNetoGravadoSeniaFact;
	}
	
	private Money netoGravadoSaldoPendFactSenia;
	private Money netoNoGravadoSaldoPendFactSenia;
	
	private Money netoGravadoSeniaFact;
	private Money netoNoGravadoSeniaFact;
	
		
	
	// Por el IVA
	private Porcentaje tasaIVA;
	private Money iva;
	private ConceptoImpuesto concImpuIVA        = null;
	
	
	private RemitoDet remitoDet;
	
	private ConceptoImpuesto concImpuPercIVA    = null;
	private ConceptoImpuesto concImpuPercIB     = null;
	private ConceptoImpuesto concImpuImpInt     = null;
	private CalculadorFactura calculadorFactura = null;

	public Money getPrecioLista() {
		return this.precioLista;
	}

	public void setPrecioLista(Money aPrecioLista) {
		this.precioLista = aPrecioLista;
	}
	
	public Integer getOidDet() {
		return this.oidDet;
	}

	public void setOidDet(Integer aOidDet) {
		this.oidDet = aOidDet;
	}
	
	
	public boolean isBonifEnCascada() {
		return bonifEnCascada;
	}

	public void setBonifEnCascada(boolean aBonifEnCascada) {
		this.bonifEnCascada = aBonifEnCascada;
	}
	
	
	public Money getPrecio() {
		return this.precio;
	}

	public void setPrecio(Money aPrecio) {
		this.precio = aPrecio;
	}
	
	public Porcentaje getTasaIVA() {
		return this.tasaIVA;
	}

	public void setTasaIVA(Porcentaje aTasaIVA) {
		this.tasaIVA = aTasaIVA;
	}
	
	public Money getIVA() {
		return this.iva;
	}

	public void setIVA(Money aImporteIVA) {
		this.iva = aImporteIVA;
	}
	
	
	
	
	public RemitoDet getRemitoDet() {
		return this.remitoDet;
	}

	public void setRemitoDet(RemitoDet aRemitoDet) {
		this.remitoDet = aRemitoDet;
	}
	
	
	public Porcentaje getPorcBonif1() {
		if (this.porcBonif1 == null)
			return new Porcentaje(0);
		else
			return this.porcBonif1;
	}

	public void setPorcBonif1(Porcentaje aPorcBonif1) {
		this.porcBonif1 = aPorcBonif1;
	}
	
	public Porcentaje getPorcBonif2() {
		if (this.porcBonif2 == null)
			return new Porcentaje(0);
		else
		  return this.porcBonif2;
	}

	public void setPorcBonif2(Porcentaje aPorcBonif2) {
		this.porcBonif2 = aPorcBonif2;
	}
	
	public Porcentaje getPorcBonif3() {
		if (this.porcBonif3 == null)
			return new Porcentaje(0);
		else
			return this.porcBonif3;
	}

	public void setPorcBonif3(Porcentaje aPorcBonif3) {
		this.porcBonif3 = aPorcBonif3;
	}		
	
	public ConceptoImpuesto getConcImpuImpInt() {
		return concImpuImpInt;
	}

	public void setConcImpuImpInt(ConceptoImpuesto concImpuImpInt) {
		this.concImpuImpInt = concImpuImpInt;
	}

	public ConceptoImpuesto getConcImpuIVA() {
		return concImpuIVA;
	}

	public void setConcImpuIVA(ConceptoImpuesto concImpuIVA) {
		this.concImpuIVA = concImpuIVA;
	}

	public ConceptoImpuesto getConcImpuPercIB() {
		return concImpuPercIB;
	}

	public void setConcImpuPercIB(ConceptoImpuesto concImpuPercIB) {
		this.concImpuPercIB = concImpuPercIB;
	}

	public ConceptoImpuesto getConcImpuPercIVA() {
		return concImpuPercIVA;
	}

	public void setConcImpuPercIVA(ConceptoImpuesto concImpuPercIVA) {
		this.concImpuPercIVA = concImpuPercIVA;
	}

	public CalculadorItemFactura(CalculadorFactura aCalculadorFactura) throws BaseException {
		this.calculadorFactura = aCalculadorFactura;
	}

	public Money getCantidad() {
		return cantidad;
	}

	public void setCantidad(Money cantidad) {
		this.cantidad = cantidad;
	}

	public Money getPrecioNetoBonif() throws BaseException {
		
		// Obtener la bonificacion del Precio
		Porcentaje porc = 
			CalculadorItemVenta.getPorcBonificacion(this.isBonifEnCascada(),
																							this.getPorcBonif1(),
																							this.getPorcBonif2(),
																							this.getPorcBonif3()
				                                      );
		Money bonificacion = CalculadorItemVenta.getPrecioBonif(this.getPrecio(),porc);
		if (bonificacion!=null)
			bonificacion = new Money(Redondear.round(bonificacion.doubleValue(), 2));
		return  bonificacion;
		
	}

	public void setPrecioNetoBonif(Money aPrecioNetoBonif) {
		this.precioNetoBonif = aPrecioNetoBonif;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public Money getImporte() throws BaseException  {
		// Calcular el Importe
		CalculadorMoney calcImporte = new CalculadorMoney(this.getPrecioNetoBonif());
		calcImporte.multiplicarPor(this.getCantidad());
		return calcImporte.getResultMoney();
	}

	public Money getCantPorPrecio() throws BaseException {
		CalculadorMoney calcCantPorPrecio = new CalculadorMoney(this.getPrecioNetoBonif());
		calcCantPorPrecio.multiplicarPor(getCantidad());
		return calcCantPorPrecio.getResultMoney();
	}
	
	public Money getNetoGravado() throws BaseException {
		if (this.getConcImpuIVA()==null)
			return new Money(0);
		else
		if (this.getCalculadorFactura().getSujeto().getSujeto_impositivo().getCategiva().isDiscriminaIVA().booleanValue()) 
			return this.getImporte();
		else if (this.getProducto().isSeUsaParaSaldoPendFactSenia().booleanValue())
			return this.getNetoGravadoSaldoPendFactSenia();
		else if (this.getProducto().isSeniaFactura().booleanValue())
			return this.getNetoGravadoSeniaFact();
		else
			return getNetoGravadoImporteIVANoDisc();
	}
	
	public Money getNetoNoGravado() throws BaseException {
		if (this.getConcImpuIVA()==null)
			return this.getImporte();
		else if (this.getProducto().isSeUsaParaSaldoPendFactSenia().booleanValue())
					return this.getNetoNoGravadoSaldoPendFactSenia();
		else if (this.getProducto().isSeniaFactura().booleanValue())
			return this.getNetoNoGravadoSeniaFact();
		else
			return new Money(0);
	}
	
	
	
	public Money getNetoGravadoImporteIVANoDisc() throws BaseException {
		
		return this.getProducto().getPrecioSinIVA(this.getCalculadorFactura().getFecha(),this.getImporte());
		
		/*TasaIVA tasaIVA = null;
		if (this.getConcImpuIVA()!=null)
			tasaIVA = this.getConcImpuIVA().getTasaVigenteIVA(this.getCalculadorFactura().getFecha(),
					this.getCalculadorFactura().getSesion());
		Money indiceTasaIVA = new Money(1);
		
		if (tasaIVA!=null) {
			CalculadorMoney calcIndice = new CalculadorMoney(new Money(
				tasaIVA.getPorcentaje().doubleValue()));
			calcIndice.dividirPor(new Money(100));
			calcIndice.sumar(new Money(1));
			indiceTasaIVA = calcIndice.getResultMoney();
		}
		
		//	Calcular el Neto Gravado
		CalculadorMoney calcNeto = new CalculadorMoney(this.getImporte());
		calcNeto.dividirPor(indiceTasaIVA);
	    return calcNeto.getResultMoney();*/		
	}
	
	
	public Money getIVAImporteIVANoDisc() throws BaseException {
		CalculadorMoney calcIVA = new CalculadorMoney(this.getImporte());
		calcIVA.restar(getNetoGravadoImporteIVANoDisc());
		return calcIVA.getResultMoney();		
	}

	public CalculadorFactura getCalculadorFactura() {
		return calculadorFactura;
	}

	public void setCalculadorFactura(CalculadorFactura calculadorFactura) {
		this.calculadorFactura = calculadorFactura;
	}
	
	public Money getImpuestoInterno(Money importe) throws BaseException {
		// Calcular los Impuestos Internos
		Money impuInterno = new Money(0);		
		concImpuImpInt = this.getProducto().getConcImpuInterno(this.getCalculadorFactura().getFecha());		
		if (concImpuImpInt!=null)
			impuInterno = concImpuImpInt.getCalcImpuesto(this.getCalculadorFactura().getFecha(), importe);
		return impuInterno;
	}
	
	public Money getImpuestoPercIB(Money importe) throws BaseException {
		Money percIB = new Money(0);
		
		concImpuPercIB = this.getProducto().getConcImpuPercIB(this.getCalculadorFactura().getFecha());
		
		if ((concImpuPercIB!=null) && (this.getCalculadorFactura().getSujeto().getSujeto_impositivo()!=null) && (this.getCalculadorFactura().getSujeto().getSujeto_impositivo().getCategib()!=null)) 
			percIB = this.concImpuPercIB.getImpuestoPercIB(this.getCalculadorFactura().getFecha(),
					                                           this.getCalculadorFactura().getProvincia(), 
					                                           this.getCalculadorFactura().getSujeto().getSujeto_impositivo().getCategib(),
					                                           importe);
		return percIB;
		
	}
	
	public Money getImpuestoPercIVA(Money importe) throws BaseException {
		Money percIVA = new Money(0);
		
		concImpuPercIVA = this.getProducto().getConcImpuPercIVA(this.getCalculadorFactura().getFecha());
		
		if ((this.concImpuPercIVA!=null) && (this.getCalculadorFactura().getSujeto().getSujeto_impositivo()!=null) && (this.getCalculadorFactura().getSujeto().getSujeto_impositivo().getCategib()!=null)) 
			percIVA = concImpuPercIVA.getCalcImpuesto(this.getCalculadorFactura().getFecha(), importe);
		return percIVA;		
	}
	

}
