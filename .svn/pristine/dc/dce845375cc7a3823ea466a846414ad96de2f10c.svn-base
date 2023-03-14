package com.srn.erp.ventas.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.TasaIVA;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Decimal;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class CalculadorFactura {
	
	List listaConceptoTotales = new ArrayList();
	CalculadorPercIBBsAs calcPercIBBsAs = null;
	private Moneda moneda;
	private ValorCotizacion cotizacion;
	private Money totIVA1PrimeraParte = new Money(0);
	private Money totIVA2PrimeraParte = new Money(0);
	private Money totOriPrimeraEtapa = new Money(0);
	
	
	public List getConceptosTotales() throws BaseException {
		return this.listaConceptoTotales;
	}
	
	private String getClaveBusqConc(String comportamiento,ConceptoImpuesto concImpuesto) {
		String claveBusqueda = comportamiento;
		if (concImpuesto!=null)
			 claveBusqueda = claveBusqueda + '_' + concImpuesto.getOIDInteger().toString();
		return claveBusqueda;
	}
	
	private ConceptoTotales buscarConceptoTotalByClave(String clave) {
		Iterator iterConcTotales = listaConceptoTotales.iterator();
		while (iterConcTotales.hasNext()) {
			ConceptoTotales concTotales = (ConceptoTotales) iterConcTotales.next();
			if (concTotales.getClave().equals(clave))
				return concTotales; 
		}
		return null;
	}
	
	private String getDescConcepto(String comportamiento,ConceptoImpuesto concImpuesto) throws BaseException {
				
		if (comportamiento.equals(CONC_NG)) {
			if (concImpuesto == null)
				return "Neto ";
			else
			if (concImpuesto.getImpuesto().isIVA()) 
				return "Neto "+ concImpuesto.getImpuesto().getDescripcion();
			else
				return "Neto No Gravado";
		}
		else
		if (comportamiento.equals(CONC_NNG)) {
			return "Neto No Gravado";
		}
		else
		if (comportamiento.equals(CONC_IVA)) {
			return concImpuesto.getImpuesto().getDescripcion();
		}
		else
		if (comportamiento.equals(CONC_PIVA)) {
				return "Percepción de IVA";
		}
		if (comportamiento.equals(CONC_PIB)) {
			return "Percepción Ingresos Brutos";
	  }
		if (comportamiento.equals(CONC_IMP_INT)) {
			return "Impuestos Internos";
	  }
		if (comportamiento.equals(CONC_TOT_FACT)) {
			return "TOTAL";
	  }		
		return "";
	}
	
	private int getSecuConcepto(String comportamiento) throws BaseException {
		
		if (comportamiento.equals(CONC_NG)) {
			return 1;
		}
		else
		if (comportamiento.equals(CONC_NNG)) {
			return 2;
		}
		else
		if (comportamiento.equals(CONC_IVA)) {
			return 3;
		}
		else
		if (comportamiento.equals(CONC_PIVA)) {
				return 4;
		}
		if (comportamiento.equals(CONC_PIB)) {
			return 6;
	  }
		if (comportamiento.equals(CONC_IMP_INT)) {
			return 5;
	  }
		if (comportamiento.equals(CONC_TOT_FACT)) {
			return 100;
	  }		
		return 0;
	}
	
	
	private void addConceptoTotal(String comportamiento,
			                          ConceptoImpuesto concImpuesto,
			                          Money importe) throws BaseException  {
		
		String clave                = getClaveBusqConc(comportamiento,concImpuesto);
		ConceptoTotales concTotales = buscarConceptoTotalByClave(clave);
		if (concTotales == null) {
			concTotales = new ConceptoTotales();
			concTotales.setSecu(this.getSecuConcepto(comportamiento));
			concTotales.setComportamiento(comportamiento);
			concTotales.setConceptoImpuesto(concImpuesto);
			concTotales.setDescConcepto(getDescConcepto(comportamiento,concImpuesto));
			concTotales.setImporte(new Money(0));
			listaConceptoTotales.add(concTotales);
		}
		
		// Agregar al concepto existe el importe correspondiente
		CalculadorMoney calcAgregarImporte = new CalculadorMoney(concTotales.getImporte());
		calcAgregarImporte.sumar(importe);
		concTotales.setImporte(calcAgregarImporte.getResultMoney());
		
	}
	
	
	ISesion sesion;
	private Provincia provincia;
	private Sujeto sujeto ;
	private Date fecha;
	private Money senia = new Money(0);
	private boolean calcSaldoPendPagoPorSenia = false;
	
	public static final String CONC_NG = "CONC_NG";
	public static final String CONC_NNG = "CONC_NNG";
	public static final String CONC_IVA = "CONC_IVA";
	public static final String CONC_PIVA = "CONC_PIVA";
	public static final String CONC_PIB = "CONC_PIB";
	public static final String CONC_IMP_INT = "CONC_IMP_INT";
	public static final String CONC_TOT_FACT = "CONC_TOT_FAC";
	public static final String CONC_PIB_BS_AS = "CONC_PI_BA";
	
	
	ConceptoImpuesto concImpuIVA     = null;
	ConceptoImpuesto concImpuIVA2    = null;
	ConceptoImpuesto concImpuPercIVA = null;
	ConceptoImpuesto concImpuPercIB  = null;
	ConceptoImpuesto concImpuImpInt  = null;	
	
	CalculadorMoney totBruto 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totNeto 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totNetoGravadoCalc 		= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totNetoNoGravadoCalc 	= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totDto 					= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totRecar 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totIVA 					= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totIVA1 					= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totIVA2 					= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totPercIVA 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totImpInt 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totPercIBBsAs 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totTotal 				= new CalculadorMoney(new Decimal(0));
	
	CalculadorMoney totBrutoOri 			= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totNetoOri				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totNetoGravadoOri 		= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totNetoNoGravadoOri 	= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totPorcDtoOri 			= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totDtoOri 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totRecarOri 			= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totPorcRecarOri 		= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totIVAOri 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totIVA1Ori 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totIVA2Ori 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totPercIVAOri 			= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totImpIntOri		    = new CalculadorMoney(new Decimal(0));
	CalculadorMoney totPercIBBsAsOri 			= new CalculadorMoney(new Decimal(0));
	CalculadorMoney totTotalOri 			= new CalculadorMoney(new Decimal(0));
	
	CalculadorMoney impreTotBruto 			= new CalculadorMoney(new Decimal(0));
	CalculadorMoney impreNeto 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney impreDto 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney imprePorcDto 			= new CalculadorMoney(new Decimal(0));
	CalculadorMoney impreRecar 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney imprePorcRecar 			= new CalculadorMoney(new Decimal(0));
	CalculadorMoney impreIVA 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney impreIVA2 				= new CalculadorMoney(new Decimal(0));
	CalculadorMoney imprePercIVA 			= new CalculadorMoney(new Decimal(0));
	CalculadorMoney impreImpInt 			= new CalculadorMoney(new Decimal(0));
	CalculadorMoney imprePercIBBsAs 			= new CalculadorMoney(new Decimal(0));
	CalculadorMoney impreTotFact 			= new CalculadorMoney(new Decimal(0));
	
	CalculadorMoney totNetoGravado 			= new CalculadorMoney(new Money(0));
	
	Money descuento = new Money(0);
	Money recargo = new Money(0);
	Money porcDto = new Money(0);
	Money porcReca = new Money(0);
	
	
	private List items = new ArrayList();
	
	
	
	public boolean isCalcSaldoPendPagoPorSenia() {
		return this.calcSaldoPendPagoPorSenia;
	}
	
	public void setCalcSaldoPendPagoPorSenia(boolean aCalcSaldoPendPago) throws BaseException {
		this.calcSaldoPendPagoPorSenia = aCalcSaldoPendPago;
	}
	
	public void setSenia(Money aSenia) throws BaseException {
		this.senia = aSenia;
	}
	
	public Money getSenia() throws BaseException {
		return this.senia;
	}
	
	public Provincia getProvincia() throws BaseException {
		return this.provincia;
	}
	
	public void setProvincia(Provincia aProvincia) throws BaseException {
		this.provincia = aProvincia;
	}
	
	public void setSujeto(Sujeto aSujeto) throws BaseException {
		this.sujeto = aSujeto;
	}
	
	public Sujeto getSujeto() throws BaseException {
		return this.sujeto;
	}
	
	public Date getFecha() {
		return this.fecha;
	}
	
	public void setFecha(Date aFecha) throws BaseException {
		this.fecha = aFecha;
	}
	
	public CalculadorFactura(ISesion aSesion) throws BaseException {
		this.sesion = aSesion;
	}
	
	public ISesion getSesion() throws BaseException {
		return this.sesion;
	}
	
	public CalculadorItemFactura addItemFact() throws BaseException {
		CalculadorItemFactura itemFactura = new CalculadorItemFactura(this);
		items.add(itemFactura);
		return itemFactura;
	}
	
	public void calcular() throws BaseException {
		validarCargaDatos();
		setCalculadorPercIBBsAs();
		procesarItems();
		calcularTotal();
		calcDtosRecargos();
	}
	
	public void validarCargaDatos() throws BaseException {
		if (this.getFecha() == null)
			throw new ExceptionValidation(null,"Debe ingresar la Fecha");		
		if (this.getSujeto() == null)
			throw new ExceptionValidation(null,"Debe ingresar un cliente");
		if (this.getSujeto().getSujeto_impositivo() == null)
			throw new ExceptionValidation(null,"El cliente no tiene configurado un Sujeto Impositivo");
		if (this.getSujeto().getSujeto_impositivo().getCategiva()==null)
			throw new ExceptionValidation(null,"El cliente "+ this.getSujeto().getCodigo()+" - "+this.getSujeto().getRazon_social()+" no tiene configurado una categoria de IVA");
		if (this.getProvincia()==null)
			throw new ExceptionValidation(null,"Debe ingresar la provincia");
	}
	
	
	public List getItems() throws BaseException {
		return this.items;
	}
	
	private void procesarItems() throws BaseException {
				
		// Procesar los items correspondiente
		Iterator items = this.items.iterator();
		while (items.hasNext()) {
			CalculadorItemFactura calcItemFactura = (CalculadorItemFactura) items.next();
			if (!(((calcItemFactura.getProducto().isSeUsaParaSaldoPendFactSenia()==true) ||
					(calcItemFactura.getProducto().isSeniaFactura()==true))))
				procesarItem(calcItemFactura);
		}
	
		
		// Guardar los Totales de IVA1 y IVA2
		// Porque se van a utilizar para calcular en base a un proporcional el IVA del saldo pendiente de facura por sea
		totIVA1PrimeraParte = totIVA1Ori.getResultMoney();
		totIVA2PrimeraParte = totIVA2Ori.getResultMoney();
		totOriPrimeraEtapa = totBrutoOri.getResultMoney();
		
		
		// Procesar ultimos los items de saldo pendiente
		items = this.items.iterator();
		while (items.hasNext()) {
			CalculadorItemFactura calcItemFactura = (CalculadorItemFactura) items.next();
			if ((calcItemFactura.getProducto().isSeUsaParaSaldoPendFactSenia()==true) ||
			(calcItemFactura.getProducto().isSeniaFactura()==true))
				procesarItem(calcItemFactura);
		}
		
		
	}
	
	private void setCalculadorPercIBBsAs() throws BaseException {
		
		calcPercIBBsAs = new CalculadorPercIBBsAs();
		calcPercIBBsAs.setSesion(this.getSesion());
		calcPercIBBsAs.setSujeto(this.getSujeto());
		calcPercIBBsAs.setProvincia(this.getProvincia());
		
		calcPercIBBsAs.setCotizacion(this.getCotizacion());
		
		Empresa empresa = Empresa.findByOidProxy(sesion.getLogin().getOidEmpresa(),this.getSesion());
		Sucursal sucursal = Sucursal.findByOidProxy(sesion.getLogin().getOidSucursal(),this.getSesion());
		
		calcPercIBBsAs.setEmpresa(empresa);
		calcPercIBBsAs.setSucursal(sucursal);
		
		calcPercIBBsAs.setFecha(this.getFecha());
		
	}
	
	private void procesarItem(CalculadorItemFactura itemFactura) throws BaseException {
		
		totBruto.sumar(itemFactura.getCantPorPrecio());
		impreTotBruto.sumar(itemFactura.getCantPorPrecio());
		
		// Calcular el Total
		Money importe = itemFactura.getImporte();
		totNeto.sumar(importe);
		totTotal.sumar(importe);
		impreTotFact.sumar(importe);		
		
		// Impresion Neto
		impreNeto.sumar(importe);
		
		// Calcular el Neto
		Money netoGravado   = new Money(0);
		Money netoNoGravado = new Money(0);
		
				
		// Determinar si se trata de Neto Gravado o no Gravado
		ConceptoImpuesto concImpu = itemFactura.getProducto().getConcImpuIVA(this.getFecha());
		
		if (concImpu == null)
			throw new ExceptionValidation(null,"No se encuentra configurado el impuesto I.V.A. para el producto "+itemFactura.getProducto().getCodigo()+" - "+itemFactura.getProducto().getDescripcion());
		
		Money impuIVAProd = null;
		
		if (this.getSujeto().getSujeto_impositivo().getCategiva().isDiscriminaIVA().booleanValue()) {
			
			if ((itemFactura.getProducto().isSeUsaParaSaldoPendFactSenia()==false) && (itemFactura.getProducto().isSeniaFactura()==false)) {
				impuIVAProd = calcImpuIVAProducto( concImpu , this.getFecha(), importe);
				
				if (concImpu == null)
					throw new ExceptionValidation(null,"Falta definir un concepto impuesto de IVA vigente para el producto "+
							itemFactura.getProducto().getCodigo()+"-"+itemFactura.getProducto().getDescripcion());
				
				if (concImpu.isUbiColIVA1()) {
					impreIVA.sumar(impuIVAProd);
					totIVA1Ori.sumar(impuIVAProd);
					totIVA1.sumar(impuIVAProd);
				}
				else if (concImpu.isUbiColIVA2()) {			
						impreIVA2.sumar(impuIVAProd);
						totIVA2Ori.sumar(impuIVAProd);
						totIVA2.sumar(impuIVAProd);
					}
				else {
					impreIVA.sumar(impuIVAProd);
					totIVA1Ori.sumar(impuIVAProd);
					totIVA1.sumar(impuIVAProd);
				}
				
				
			}
			else {
				
				//Calcular porcentaje de IVA A Calcular
				CalculadorMoney sumaIVAPrimeraParte = new CalculadorMoney(new Money(0));
				sumaIVAPrimeraParte.sumar(totIVA1PrimeraParte);
				sumaIVAPrimeraParte.sumar(totIVA2PrimeraParte);
				
				// Obtener el Porcentable de IVA proporcional
				CalculadorMoney calcPorcIVA = new CalculadorMoney(sumaIVAPrimeraParte.getResultMoney());
				calcPorcIVA.dividirPor(this.totOriPrimeraEtapa);
								
				// Calcular Inidice nuevo Porcentaje de IVA
				CalculadorMoney calcNuevoPorcIVA = new CalculadorMoney(sumaIVAPrimeraParte.getResultMoney());
				calcNuevoPorcIVA.dividirPor(totOriPrimeraEtapa);
				
				CalculadorMoney calcIVA = new CalculadorMoney(itemFactura.getImporte());
				calcIVA.multiplicarPor(calcNuevoPorcIVA.getResultMoney());
				
				impuIVAProd 	= new Money(calcIVA.getResultMoney().doubleValue(2));
				
				// Calcular los Proporcionales de IVA1 e IVA2
				if ((totIVA1PrimeraParte.doubleValue()>0) && (impuIVAProd!=null)) {
					
					  CalculadorMoney calcPorcIVA1 = new CalculadorMoney(totIVA1PrimeraParte);
					  calcPorcIVA1.dividirPor(sumaIVAPrimeraParte.getResultMoney());
					  
					  CalculadorMoney calcMontoIVA1 = new CalculadorMoney(impuIVAProd);
					  calcMontoIVA1.multiplicarPor(calcPorcIVA1.getResultMoney());
					  
					  totIVA1Ori.sumar(calcMontoIVA1.getResultMoney());
					  totIVA1.sumar(new Money(calcMontoIVA1.getResultMoney().doubleValue(2)));
					  impreIVA.sumar(new Money(calcMontoIVA1.getResultMoney().doubleValue(2)));
					  
				}
					
				// Calcular el Proporcianal del IVA2
				if ((totIVA2PrimeraParte.doubleValue()>0) && (impuIVAProd!=null)) {
						
					  CalculadorMoney calcPorcIVA2 = new CalculadorMoney(totIVA2PrimeraParte);
					  calcPorcIVA2.dividirPor(sumaIVAPrimeraParte.getResultMoney());
					  
					  CalculadorMoney calcMontoIVA2 = new CalculadorMoney(impuIVAProd);
					  calcMontoIVA2.multiplicarPor(calcPorcIVA2.getResultMoney());
					  
					  totIVA2Ori.sumar(calcMontoIVA2.getResultMoney());
					  totIVA2.sumar(new Money(calcMontoIVA2.getResultMoney().doubleValue(2)));
					  impreIVA2.sumar(new Money(calcMontoIVA2.getResultMoney().doubleValue(2)));
					  
				}				
				
			}
			
			
			if ((impuIVAProd != null) && (impuIVAProd.doubleValue() != 0))  
				netoGravado = importe;
			else  
				netoNoGravado = importe;
						
			
			totIVA.sumar(impuIVAProd);
			totIVAOri.sumar(impuIVAProd);
			
			
			
			totBrutoOri.sumar(itemFactura.getCantPorPrecio());
			addConceptoTotal(CONC_NG,null,importe);
			if (concImpu!=null)
				addConceptoTotal(CONC_IVA,concImpu,impuIVAProd);
			addConceptoTotal(CONC_TOT_FACT,null,importe);
			addConceptoTotal(CONC_TOT_FACT,null,impuIVAProd);
		} else { // No discrimina IVA EJEMPLO CONSUMIDOR FINAL
			
			
			if ((itemFactura.getProducto().isSeUsaParaSaldoPendFactSenia()==false) && (itemFactura.getProducto().isSeniaFactura()==false)) {
				
				impuIVAProd 	= itemFactura.getIVAImporteIVANoDisc();
				
				if (concImpu.isUbiColIVA1()) {
					totIVA1Ori.sumar(impuIVAProd);
					totIVA1.sumar(new Money(impuIVAProd.doubleValue(2)));
				}
				else if (concImpu.isUbiColIVA2()) {
					totIVA2Ori.sumar(impuIVAProd);
					totIVA2.sumar(new Money(impuIVAProd.doubleValue(2)));
				}
				else {
					totIVA1Ori.sumar(impuIVAProd);
					totIVA1.sumar(new Money(impuIVAProd.doubleValue(2)));
				
				}
				
				if ((impuIVAProd != null) && (impuIVAProd.doubleValue() != 0))  
					netoGravado = itemFactura.getNetoGravadoImporteIVANoDisc();
				 else  
					netoNoGravado = itemFactura.getNetoGravadoImporteIVANoDisc();
						
				
				
				
			}
			else {
				// Calcular el IVA del Producto en Forma Proporcional
				
				//Calcular porcentaje de IVA A Calcular
				CalculadorMoney sumaIVAPrimeraParte = new CalculadorMoney(new Money(0));
				sumaIVAPrimeraParte.sumar(totIVA1PrimeraParte);
				sumaIVAPrimeraParte.sumar(totIVA2PrimeraParte);
				
				// Obtener el Porcentable de IVA proporcional
				CalculadorMoney calcPorcIVA = new CalculadorMoney(sumaIVAPrimeraParte.getResultMoney());
				calcPorcIVA.dividirPor(totOriPrimeraEtapa);
								
				// Calcular Inidice nuevo Porcentaje de IVA
				CalculadorMoney calcNuevoIndiceIVA = new CalculadorMoney(sumaIVAPrimeraParte.getResultMoney());
				calcNuevoIndiceIVA.dividirPor(totOriPrimeraEtapa);
				calcNuevoIndiceIVA.sumar(new Money(1));
				
				
				// De esta porcentaje de IVA, determinar cuanto corresponde al IVA1 y cuanto al IVA2
				CalculadorMoney calcNetoGravado = new CalculadorMoney(itemFactura.getImporte());
				calcNetoGravado.dividirPor(calcNuevoIndiceIVA.getResultMoney());
				
				CalculadorMoney calcIVA = new CalculadorMoney(itemFactura.getImporte());
				calcIVA.restar(calcNetoGravado.getResultMoney());
				
				impuIVAProd 	= calcIVA.getResultMoney();
				
				// Calcular el Proporcianal del IVA1
				if ((totIVA1PrimeraParte.doubleValue()>0) && (impuIVAProd!=null)) {
					
				  CalculadorMoney calcPorcIVA1 = new CalculadorMoney(totIVA1PrimeraParte);
				  calcPorcIVA1.dividirPor(sumaIVAPrimeraParte.getResultMoney());
				  
				  CalculadorMoney calcMontoIVA1 = new CalculadorMoney(impuIVAProd);
				  calcMontoIVA1.multiplicarPor(calcPorcIVA1.getResultMoney());
				  
				  totIVA1Ori.sumar(calcMontoIVA1.getResultMoney());
				  totIVA1.sumar(new Money(calcMontoIVA1.getResultMoney().doubleValue(2)));
				  
				}
				
				// Calcular el Proporcianal del IVA2
				if ((totIVA2PrimeraParte.doubleValue()>0) && (impuIVAProd!=null)) {
					
				  CalculadorMoney calcPorcIVA2 = new CalculadorMoney(totIVA2PrimeraParte);
				  calcPorcIVA2.dividirPor(sumaIVAPrimeraParte.getResultMoney());
				  
				  CalculadorMoney calcMontoIVA2 = new CalculadorMoney(impuIVAProd);
				  calcMontoIVA2.multiplicarPor(calcPorcIVA2.getResultMoney());
				  
				  totIVA2Ori.sumar(calcMontoIVA2.getResultMoney());
				  totIVA2.sumar(new Money(calcMontoIVA2.getResultMoney().doubleValue(2)));
				  
				}
				
				if ((impuIVAProd != null) && (impuIVAProd.doubleValue() != 0)) {  
					netoGravado = new Money(calcNetoGravado.getResultMoney().doubleValue(2));
					if (itemFactura.getProducto().isSeUsaParaSaldoPendFactSenia())
							itemFactura.setNetoGravadoSaldoPendFactSenia(netoGravado);
						else 
							if (itemFactura.getProducto().isSeniaFactura())
								itemFactura.setNetoGravadoSeniaFact(netoGravado);
				}
				 else {  
					netoNoGravado = new Money(calcNetoGravado.getResultMoney().doubleValue(2));
					if (itemFactura.getProducto().isSeUsaParaSaldoPendFactSenia())
						itemFactura.setNetoNoGravadoSaldoPendFactSenia(netoNoGravado);
					else if (itemFactura.getProducto().isSeniaFactura())
						itemFactura.setNetoNoGravadoSeniaFact(netoNoGravado);
				 }
				
				
				
			}
				
			
			if ((impuIVAProd != null) && (impuIVAProd.doubleValue() != 0)) { 
				addConceptoTotal(CONC_NG,null,importe);
				addConceptoTotal(CONC_TOT_FACT,null,importe);
			}
			 else { 
				addConceptoTotal(CONC_NG,null,importe);
				addConceptoTotal(CONC_TOT_FACT,null,importe);
			}
			// Total Bruto en Moneda Origen
			totBrutoOri.sumar(netoGravado);
			totBrutoOri.sumar(netoNoGravado);
			impreIVA.sumar(new Money(0));
			
			totIVA.sumar(new Money(impuIVAProd.doubleValue(2)));
			
			totIVAOri.sumar(new Money(impuIVAProd.doubleValue(2)));
			
			
		}
		
		// Guardar a Nivel Item la tasa y el IVA CALCULADO
		if (concImpu!=null) {
		   TasaIVA tasaIVA = 
			   concImpu.getTasaVigenteIVA(this.getFecha(),this.getSesion());
		   if (tasaIVA!=null)
			   itemFactura.setTasaIVA(new Porcentaje(tasaIVA.getPorcentaje().doubleValue()));
		   else
			   itemFactura.setTasaIVA(new Porcentaje(0));
		}
		
		itemFactura.setIVA(impuIVAProd);
		
		
		calcPercIBBsAs.addNetoGravado(itemFactura.getProducto(),netoGravado);
		
		
		totNetoGravadoOri.sumar(netoGravado);
		totNetoNoGravadoOri.sumar(netoNoGravado);
		totNetoGravado.sumar(netoGravado);
		totNetoGravado.sumar(netoNoGravado);
		totNetoOri.sumar(netoGravado);
		totNetoOri.sumar(netoNoGravado);
		
		CalculadorMoney baseCalcImpu = new CalculadorMoney(netoGravado);
		baseCalcImpu.sumar(netoNoGravado);
		
		Money impuInterno = itemFactura.getImpuestoInterno(baseCalcImpu.getResultMoney());
		if (impuInterno!=null) {
		  totImpInt.sumar(impuInterno);
		  impreImpInt.sumar(impuInterno);
		  totImpIntOri.sumar(impuInterno);
		  addConceptoTotal(CONC_IMP_INT,null,impuInterno);
		  addConceptoTotal(CONC_TOT_FACT,null,impuInterno);
		}
		
		/*
		Money impuPercIB = itemFactura.getImpuestoPercIB(baseCalcImpu.getResultMoney());
		if (impuPercIB!=null) {
		  totPercIB.sumar(impuPercIB);
		  imprePercIB.sumar(impuPercIB);
		  totPercIBOri.sumar(impuPercIB);
		  addConceptoTotal(CONC_PIB,null,impuPercIB);
		  addConceptoTotal(CONC_TOT_FACT,null,impuPercIB); 
		}*/
		
		Money impuPercIVA = itemFactura.getImpuestoPercIVA(netoGravado);		
		if (impuPercIVA!=null) {
			totPercIVA.sumar(impuPercIVA);
			imprePercIVA.sumar(impuPercIVA);
			totPercIVAOri.sumar(impuPercIVA);
			addConceptoTotal(CONC_PIVA,null,impuPercIVA);
			addConceptoTotal(CONC_TOT_FACT,null,impuPercIVA);
		}

		// Tomar el primer concepto de cada item
		if (concImpuIVA == null)
			if (itemFactura.getConcImpuIVA()!=null)
				if (itemFactura.getConcImpuIVA().isUbiColIVA1())
					concImpuIVA = itemFactura.getConcImpuIVA();
		
		if (concImpuIVA2 == null)
			if (itemFactura.getConcImpuIVA()!=null)
				if (itemFactura.getConcImpuIVA().isUbiColIVA2())
					concImpuIVA2 = itemFactura.getConcImpuIVA();		
		
		if (concImpuPercIVA == null) 
			concImpuPercIVA = itemFactura.getConcImpuPercIVA();
		if (concImpuImpInt == null) 
			concImpuImpInt = itemFactura.getConcImpuImpInt();
		if (concImpuPercIB == null) 
			concImpuPercIB = itemFactura.getConcImpuPercIB();
		
		
	}
	
	private void calcularTotal() throws BaseException {
		
		
		calcPercIBBsAs.calcular();
		
		if ((calcPercIBBsAs.getPercIB()!=null) && 
				(calcPercIBBsAs.getPercIB().doubleValue()>0)) {

		  totPercIBBsAs.sumar(calcPercIBBsAs.getPercIB());
		  imprePercIBBsAs.sumar(calcPercIBBsAs.getPercIB());
		  totPercIBBsAsOri.sumar(calcPercIBBsAs.getPercIB());
		  addConceptoTotal(CONC_PIB_BS_AS,null,calcPercIBBsAs.getPercIB());
		  addConceptoTotal(CONC_TOT_FACT,null,calcPercIBBsAs.getPercIB()); 
			
		}
		
		
		
		// Calcular el Total total
		totTotal.sumar(new Money(totImpInt.getResult(2)));
		totTotal.sumar(new Money(totPercIBBsAs.getResult(2)));

		// Calcular el Total
		totTotalOri.sumar(new Money(totNetoOri.getResult(2)));
		totTotalOri.sumar(new Money(totIVAOri.getResult(2)));
		totTotalOri.sumar(new Money(totPercIVAOri.getResult(2)));
		totTotalOri.sumar(new Money(totPercIBBsAsOri.getResult(2)));
		totTotalOri.sumar(new Money(totImpIntOri.getResult(2)));

		// Calcular el total de la Factura
		impreTotFact.sumar(new Money(totImpInt.getResult(2)));
		impreTotFact.sumar(new Money(totPercIBBsAs.getResult(2)));
		
		if (this.getSujeto().getSujeto_impositivo().getCategiva().isDiscriminaIVA().booleanValue()) {
			totTotal.sumar(new Money(totIVA.getResult(2)));
			totTotal.sumar(new Money(totPercIVA.getResult(2)));

			// Calcular el total de la Factura
			impreTotFact.sumar(new Money(totIVA.getResult(2)));
			impreTotFact.sumar(new Money(totPercIVA.getResult(2)));

		}
		

	}
	
	private void calcDtosRecargos() throws BaseException {
		
		// CALCULAR EN CASO DE DESCUENTOS
		if (totBruto.getResultMoney().doubleValue() > totNeto.getResultMoney()
				.doubleValue()) {

			// Calcular el importe del descuento
			CalculadorMoney calcDescuento = new CalculadorMoney(totBruto
					.getResultMoney());
			calcDescuento.restar(totNeto.getResultMoney());
			descuento = calcDescuento.getResultMoney();

			// Calcular el Porcentaje del Descuento
			if (totBruto.getResultMoney().doubleValue() > 0) {
				CalculadorMoney calcPorcDto = new CalculadorMoney(descuento);
				calcPorcDto.dividirPor(totBruto.getResultMoney());
				calcPorcDto.multiplicarPor(new Money(100));
				porcDto = calcPorcDto.getResultMoney();
			}

			impreDto.sumar(descuento);
			imprePorcDto.sumar(porcDto);

		}

		// CALCULAR EN CASO DE RECARGOS
		if (totBruto.getResultMoney().doubleValue() < totNeto.getResultMoney()
				.doubleValue()) {

			// Calcular el importe del descuento
			CalculadorMoney calcRecargo = new CalculadorMoney(totNeto
					.getResultMoney());
			calcRecargo.restar(totBruto.getResultMoney());
			recargo = calcRecargo.getResultMoney();

			// Calcular el Porcentaje del Recargo
			if (totBruto.getResultMoney().doubleValue() > 0) {
				CalculadorMoney calcPorcRecar = new CalculadorMoney(recargo);
				calcPorcRecar.dividirPor(totBruto.getResultMoney());
				calcPorcRecar.multiplicarPor(new Money(100));
				porcReca = calcPorcRecar.getResultMoney();
			}

			impreRecar.sumar(recargo);
			imprePorcRecar.sumar(porcReca);
		}

		// Calcular el Descuento y el Recargo
		if (totBrutoOri.getResultMoney().doubleValue() > totNetoOri
				.getResultMoney().doubleValue()) {

			// Calcular el importe del descuento
			CalculadorMoney calcDescuento = new CalculadorMoney(totBrutoOri
					.getResultMoney());
			calcDescuento.restar(totNetoOri.getResultMoney());
			totDtoOri.sumar(calcDescuento.getResultMoney());

			// Calcular el Porcentaje del Descuento
			if (totBrutoOri.getResultMoney().doubleValue() > 0) {
				CalculadorMoney calcPorcDto = new CalculadorMoney(totDtoOri
						.getResultMoney());
				calcPorcDto.dividirPor(totBrutoOri.getResultMoney());
				calcPorcDto.multiplicarPor(new Money(100));
				totPorcDtoOri.sumar(calcPorcDto.getResultMoney());
			}
		} else if (totBrutoOri.getResultMoney().doubleValue() < totNetoOri
				.getResultMoney().doubleValue()) {

			// Calcular el importe del Recargo
			CalculadorMoney calcRecargo = new CalculadorMoney(totNetoOri
					.getResultMoney());
			calcRecargo.restar(totBrutoOri.getResultMoney());
			totRecarOri.sumar(calcRecargo.getResultMoney());

			// Calcular el Porcentaje del Descuento
			if (totBrutoOri.getResultMoney().doubleValue() > 0) {
				CalculadorMoney calcPorcRecar = new CalculadorMoney(totRecarOri
						.getResultMoney());
				calcPorcRecar.dividirPor(totBrutoOri.getResultMoney());
				calcPorcRecar.multiplicarPor(new Money(100));
				totPorcRecarOri.sumar(calcPorcRecar.getResultMoney());
			}

		}
		
	}
	
	private Money calcImpuIVAProducto(ConceptoImpuesto concImpIVA,
			java.util.Date fecha, Money precio) throws BaseException {
		Money impuestoIVA = null;
		if (concImpIVA != null)
			impuestoIVA = concImpIVA.getCalcImpuesto(fecha, precio);
		else
			impuestoIVA = new Money(0);
		return impuestoIVA;
	}	
	
	
	
	public IDataSet getDataSetDetFact() throws BaseException {

		IDataSet dataset = new TDataSet();
		dataset.create("TCalcDetFactura");
		dataset.fieldDef(new Field("oid_fact_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("importe_neto_gravado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe_neto_no_gravado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_impu_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("tasa_iva", Field.CURRENCY, 0));
		return dataset;
		
	}
	
	public IDataSet enviarDatosDet() throws BaseException {
		
		IDataSet dsDet = getDataSetDetFact();		
		Iterator iterDetFact = 
			this.getItems().iterator();
		while (iterDetFact.hasNext()) {
			CalculadorItemFactura calcItemFact = (CalculadorItemFactura) iterDetFact.next();
			dsDet.append();
			dsDet.fieldValue("oid_fact_det", calcItemFact.getOidDet());
			dsDet.fieldValue("importe_neto_gravado" , calcItemFact.getNetoGravado());
			dsDet.fieldValue("importe_neto_no_gravado" , calcItemFact.getNetoNoGravado());
			if (calcItemFact.getConcImpuIVA()!=null)
				dsDet.fieldValue("oid_conc_impu_iva", calcItemFact.getConcImpuIVA().getOIDInteger());
			else
				dsDet.fieldValue("oid_conc_impu_iva", new Integer(0));
			dsDet.fieldValue("iva", calcItemFact.getIVA());
			dsDet.fieldValue("tasa_iva", calcItemFact.getTasaIVA());
		}
		
		return dsDet;
		
		
	}
	
	public IDataSet enviarDatos() throws BaseException {
		
		IDataSet dataset = new TDataSet();
		dataset.create("TTotalesFactura");

		// Para calculo internos
		dataset.fieldDef(new Field("bruto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_dto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("descuento", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_recar", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("recargo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("neto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("neto_gravado", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("neto_no_gravado", Field.CURRENCY, 0));

		dataset.fieldDef(new Field("iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("iva_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_impu_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("perc_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_impu_perc_iva", Field.INTEGER, 0));
		dataset.fieldDef(new Field("imp_internos", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_impu_int", Field.INTEGER, 0));
		dataset.fieldDef(new Field("perc_ib_ba", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_impu_perc_ib_ba", Field.INTEGER, 0));
		dataset.fieldDef(new Field("perc_ib_cf", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_impu_perc_ib_cf", Field.INTEGER, 0));
		dataset.fieldDef(new Field("total", Field.CURRENCY, 0));

		// En Moneda local para el libro de IVA Ventas
		dataset.fieldDef(new Field("bruto_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_dto_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("descuento_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_recar_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("recargo_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("neto_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("neto_gravado_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("neto_no_gravado_mon_loc", Field.CURRENCY,0));

		dataset.fieldDef(new Field("iva_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("iva_2_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_impu_iva_mon_loc", Field.INTEGER,0));
		dataset.fieldDef(new Field("oid_conc_impu_iva_2_mon_loc", Field.INTEGER,0));
		dataset.fieldDef(new Field("perc_iva_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_impu_perc_iva_mon_loc",Field.INTEGER, 0));
		dataset.fieldDef(new Field("imp_internos_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_impu_int_mon_loc", Field.INTEGER,0));
		dataset.fieldDef(new Field("perc_ib_ba_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_impu_pi_ba_mon_loc",Field.INTEGER, 0));
		
		dataset.fieldDef(new Field("perc_ib_cf_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_conc_impu_pi_cf_mon_loc",Field.INTEGER, 0));
		
		
		dataset.fieldDef(new Field("total_mon_loc", Field.CURRENCY, 0));

		// Para calculo de Impresiones
		dataset.fieldDef(new Field("impre_bruto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_porc_dto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_descuento", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_porc_recar", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_recargo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_neto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_iva_2", Field.CURRENCY, 0));
		
		dataset.fieldDef(new Field("impre_perc_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_imp_internos", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_perc_ib_ba", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_perc_ib_cf", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impre_total", Field.CURRENCY, 0));
		
		dataset.fieldDef(new Field("saldo_pend_pago", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_prod_saldo_pend_fact_senia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prod_saldo_pend_fact_senia", Field.STRING, 100));

		
		
		dataset.append();
		dataset.fieldValue("bruto", totBrutoOri.getResultMoney());
		dataset.fieldValue("porc_dto", totPorcDtoOri.getResultMoney());
		dataset.fieldValue("descuento", totDtoOri.getResultMoney());
		dataset.fieldValue("porc_recar", totPorcRecarOri.getResultMoney());
		dataset.fieldValue("recargo", totRecarOri.getResultMoney());
		dataset.fieldValue("neto", totNetoOri.getResultMoney());
		dataset.fieldValue("neto_gravado", totNetoGravadoOri.getResultMoney());
		dataset.fieldValue("neto_no_gravado", totNetoNoGravadoOri.getResultMoney());

		//procesado
		
		dataset.fieldValue("iva", totIVA1Ori.getResultMoney());
		if (concImpuIVA != null)
			dataset.fieldValue("oid_conc_impu_iva", concImpuIVA.getOIDInteger());
		else 
			dataset.fieldValue("oid_conc_impu_iva", new Integer(0));
		
		dataset.fieldValue("iva_2", totIVA2Ori.getResultMoney());
		
		dataset.fieldValue("perc_iva", totPercIVA.getResultMoney());
		if (this.concImpuPercIVA!=null)
		  dataset.fieldValue("oid_conc_impu_perc_iva", concImpuPercIVA.getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_perc_iva", new Integer(0));
		
		
		dataset.fieldValue("imp_internos", totImpIntOri.getResultMoney());		
		if (this.concImpuImpInt!=null)
			dataset.fieldValue("oid_conc_impu_int", this.concImpuImpInt.getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_int", new Integer(0));
		
		
		dataset.fieldValue("perc_ib_ba", totPercIBBsAsOri.getResultMoney());
		dataset.fieldValue("oid_conc_impu_perc_ib_ba", ConceptoImpuesto.getPercIBBsAs(this.getSesion()).getOIDInteger());
		
		dataset.fieldValue("perc_ib_cf", new Money(0));
		dataset.fieldValue("oid_conc_impu_perc_ib_cf", ConceptoImpuesto.getPercIBCapFed(this.getSesion()).getOIDInteger());
		
		
		
		dataset.fieldValue("total", totTotalOri.getResultMoney());

		dataset.fieldValue("bruto_mon_loc", totBruto.getResultMoney());
		dataset.fieldValue("porc_dto_mon_loc", porcDto);
		dataset.fieldValue("descuento_mon_loc", descuento);
		dataset.fieldValue("porc_recar_mon_loc", porcReca);
		dataset.fieldValue("recargo_mon_loc", recargo);
		dataset.fieldValue("neto_mon_loc", totNeto.getResultMoney());
		dataset.fieldValue("neto_gravado_mon_loc", new Money(0));
		dataset.fieldValue("neto_no_gravado_mon_loc", new Money(0));

		dataset.fieldValue("iva_mon_loc", totIVA1.getResultMoney());
		
		dataset.fieldValue("iva_2_mon_loc", totIVA2.getResultMoney());
		
		if (concImpuIVA != null)
			dataset.fieldValue("oid_conc_impu_iva_mon_loc", concImpuIVA.getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_iva_mon_loc", new Integer(0));
		
		if (concImpuIVA2 != null)
			dataset.fieldValue("oid_conc_impu_iva_2_mon_loc", concImpuIVA2.getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_iva_2_mon_loc", new Integer(0));
		
		
		dataset.fieldValue("perc_iva_mon_loc", totPercIVA.getResultMoney());		
		if (concImpuPercIVA != null)
			dataset.fieldValue("oid_conc_impu_perc_iva_mon_loc",concImpuPercIVA.getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_perc_iva_mon_loc",new Integer(0));
		
		dataset.fieldValue("imp_internos_mon_loc", totImpInt.getResultMoney());
		if (concImpuImpInt != null)
			dataset.fieldValue("oid_conc_impu_int_mon_loc", concImpuImpInt.getOIDInteger());
		else
			dataset.fieldValue("oid_conc_impu_int_mon_loc", new Integer(0));
		
		dataset.fieldValue("perc_ib_ba_mon_loc", totPercIBBsAs.getResultMoney());
		dataset.fieldValue("oid_conc_impu_pi_ba_mon_loc", ConceptoImpuesto.getPercIBBsAs(this.getSesion()).getOIDInteger());

		dataset.fieldValue("perc_ib_cf_mon_loc", new Money(0));
		dataset.fieldValue("oid_conc_impu_pi_cf_mon_loc", ConceptoImpuesto.getPercIBCapFed(this.getSesion()).getOIDInteger());
		
		dataset.fieldValue("total_mon_loc", totTotal.getResultMoney());

		dataset.fieldValue("impre_bruto", impreTotBruto.getResultMoney());
		dataset.fieldValue("impre_porc_dto", imprePorcDto.getResultMoney());
		dataset.fieldValue("impre_descuento", impreDto.getResultMoney());
		dataset.fieldValue("impre_porc_recar", imprePorcRecar.getResultMoney());
		dataset.fieldValue("impre_recargo", impreRecar.getResultMoney());
		dataset.fieldValue("impre_neto", impreNeto.getResultMoney());
		dataset.fieldValue("impre_iva", impreIVA.getResultMoney());
		dataset.fieldValue("impre_iva_2", impreIVA2.getResultMoney());
		
		dataset.fieldValue("impre_perc_iva", imprePercIVA.getResultMoney());
		dataset.fieldValue("impre_imp_internos", impreImpInt.getResultMoney());
		dataset.fieldValue("impre_perc_ib_ba", imprePercIBBsAs.getResultMoney());
		dataset.fieldValue("impre_perc_ib_cf", new Money(0));
		dataset.fieldValue("impre_total", impreTotFact.getResultMoney());
		
		dataset.fieldValue("saldo_pend_pago", getSaldoPendPagoPorSenia());
		if (this.isCalcSaldoPendPagoPorSenia()) {
				Producto productoSaldo = null; 
				if (this.getSujeto().getSujeto_impositivo().getCategiva().isDiscriminaIVA().booleanValue()==false) 
					productoSaldo = Producto.getProductoSaldoPendPagoPorSenia(this.getSesion());
				else
					productoSaldo = Producto.getProductoSaldoPendPagoPorSeniaDiscIVA(this.getSesion());
				
				
				
				dataset.fieldValue("oid_prod_saldo_pend_fact_senia", productoSaldo.getOIDInteger());
				dataset.fieldValue("cod_prod_saldo_pend_fact_senia", productoSaldo.getCodigo());
				
				
		} else {
			  dataset.fieldValue("oid_prod_saldo_pend_fact_senia", new Integer(0));
			  dataset.fieldValue("cod_prod_saldo_pend_fact_senia", "");
		}

		return dataset;
		
		
	}

	public ValorCotizacion getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(ValorCotizacion cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	
	public Money getSaldoPendPagoPorSenia() throws BaseException {
		
		if (this.isCalcSaldoPendPagoPorSenia()==false)
			return new Money(0);
		
		if (this.getSujeto().getSujeto_impositivo().getCategiva().isDiscriminaIVA().booleanValue()==false) {
			CalculadorMoney calcSaldoPend = new CalculadorMoney(new Money(0));
			calcSaldoPend.sumar(totTotalOri.getResultMoney());
			calcSaldoPend.restar(this.getSenia());
			return calcSaldoPend.getResultMoney();
		} else {
			
			CalculadorMoney calcSaldo = new CalculadorMoney(totTotalOri.getResultMoney()); 
			calcSaldo.restar(this.getSenia());
			
			// Hasta aca incluye el precio final con IVA
			CalculadorMoney calcIVA = new CalculadorMoney(calcSaldo.getResultMoney());
			calcIVA.multiplicarPor(this.totIVAOri.getResultMoney());
			calcIVA.dividirPor(totTotalOri.getResultMoney());
			
			CalculadorMoney netoGravado = new CalculadorMoney(calcSaldo.getResultMoney());
			netoGravado.restar(calcIVA.getResultMoney());
						
			return netoGravado.getResultMoney();
			
		}
		
		// Calcular el Saldo pendiente de pago por sea
		
	}

}
