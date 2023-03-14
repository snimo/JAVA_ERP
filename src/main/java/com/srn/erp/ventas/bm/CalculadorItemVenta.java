package com.srn.erp.ventas.bm;

import java.util.Date;

import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;

public class CalculadorItemVenta {

	ISesion	sesion;

	public CalculadorItemVenta() {

	}

	public void setSesion(ISesion aSesion) throws BaseException {
		this.sesion = aSesion;
	}
	
	public static Money getPrecioLista(
			ListaPrecios listaPrecios, 
			Producto producto, 
			Moneda moneda,
			HashTableDatos cotizaciones) throws BaseException {
		
		PrecioEnLP precioEnLP = 
			listaPrecios.getPrecioLista(producto);
		
		// Obtener la Cotizacion de la Moneda Origen
		ValorCotizacion cotizMonOri = null;
		if (precioEnLP.getMoneda().isMonedaCursoLegal())
			cotizMonOri = new ValorCotizacion(1);
		if (cotizMonOri == null)
			cotizMonOri = (ValorCotizacion) cotizaciones.get(precioEnLP.getMoneda().getOIDInteger());
		
		// Obtener la cotizacion de la Moneda Destino
		ValorCotizacion cotizMonDest = null;
		if (moneda.isMonedaCursoLegal())
			cotizMonDest = new ValorCotizacion(1);
		if (cotizMonDest == null)
			cotizMonDest = (ValorCotizacion) cotizaciones.get(moneda.getOIDInteger());
		
		Money precio = Cotizacion.convertir(precioEnLP.getPrecio(),cotizMonOri, cotizMonDest);
		
		return precio;
	}

	public static PrecioEnLP getPrecioAMostrar(
			ListaPrecios listaPrecios, 
			Producto producto, 
			Sujeto sujeto,
			java.util.Date fecha) throws BaseException {

		if (listaPrecios == null)
			throw new ExceptionValidation(null, "Debe ingresar la Lista de Precios");
		if (producto == null)
			throw new ExceptionValidation(null, "Debe ingresar el Producto");
		if (sujeto == null)
			throw new ExceptionValidation(null, "Debe ingresar el Sujeto");
		if (fecha == null)
			throw new ExceptionValidation(null, "Debe ingresar la Fecha");

		if (sujeto.getSujeto_impositivo() == null)
			throw new ExceptionValidation(null, "Debe ingresar un sujeto impositivo para  " + sujeto.getRazon_social()
					+ " - " + sujeto.getCodigo());

		// producto.getPrecioConsumidorFinal(ftecha,)
		if (sujeto.getSujeto_impositivo().getCategiva() == null)
			throw new ExceptionValidation(null, "Debe ingresar una Categoría de IVA para " + sujeto.getRazon_social() + " - "
					+ sujeto.getCodigo());

		// Si discrimina IVA devolver el precio sin IVA
		if (sujeto.getSujeto_impositivo().getCategiva().isDiscriminaIVA().booleanValue()) 
			return listaPrecios.getPrecioListaSinIVA(producto,fecha);
		else
			return listaPrecios.getPrecioListaConIVA(producto,fecha);

	}

	public static Porcentaje getPorcBonif(int nro,Sujeto sujeto, Producto producto, CondicionPago condicionPago, int cuotas,
			int dias, Date fecha, ISesion aSesion) throws BaseException {

		ValorParametro valorParamNroBonif = ValorParametro.findByCodigoParametro("FUENTE_BONIF_"+nro+"_VTA", aSesion);

		Porcentaje porc = new Porcentaje(0);

		// 0 = Sin Bonificacion
		if (valorParamNroBonif.getValorEntero().intValue() == 0)
			return new Porcentaje(0);
		else // 1- Bonificacion por producto
		if (valorParamNroBonif.getValorEntero().intValue() == 1)
			porc = producto.getPorcDtoProducto(sujeto, null, fecha);
		else if (valorParamNroBonif.getValorEntero().intValue() == 2)
			porc = sujeto.getPorcBonificacion(fecha);
		else if (valorParamNroBonif.getValorEntero().intValue() == 3)
			porc = condicionPago.getPorcBonif(cuotas, dias);
		if (porc == null)
			return new Porcentaje(0);
		else
			return porc;
	}
	
	public static Porcentaje getPorcBonificacion(boolean enCascada,
	                                             Porcentaje porcBonif1,
	                                             Porcentaje porcBonif2,
	                                             Porcentaje porcBonif3) throws BaseException {
		if (enCascada) {
			
			CalculadorMoney calcBonif1 = new CalculadorMoney(porcBonif1);
			calcBonif1.dividirPor(new Money(100));
			
			CalculadorMoney calcBonif2 = new CalculadorMoney(porcBonif2);
			calcBonif2.dividirPor(new Money(100));
			
			CalculadorMoney calcBonif3 = new CalculadorMoney(porcBonif3);
			calcBonif3.dividirPor(new Money(100));
			
			throw new ExceptionValidation(null,"Bonificación en cascada no implementada");
			
		} else {
			CalculadorMoney bonificacion = new CalculadorMoney(porcBonif1);
			bonificacion.sumar(porcBonif2);
			bonificacion.sumar(porcBonif3);
			return new Porcentaje(bonificacion.getResultMoney().doubleValue()); 
		}
	}
	
	public static Money getPrecioBonif(Money precio, Porcentaje porcBonif) throws BaseException {
		
		CalculadorMoney calcPorcBonif = new CalculadorMoney(porcBonif);
		calcPorcBonif.dividirPor(new Money(100));
		
		CalculadorMoney calcBonif = new CalculadorMoney(precio);
		calcBonif.multiplicarPor(calcPorcBonif.getResultMoney());
		
		CalculadorMoney precioListaBonif = new CalculadorMoney(precio);
		precioListaBonif.restar(calcBonif.getResultMoney());
		
		return precioListaBonif.getResultMoney();
		
	}
	
	public static Money getPrecioPorCantidad(Money precio , Money cantidad) throws BaseException {
		CalculadorMoney calcImporte = new CalculadorMoney(precio);
		calcImporte.multiplicarPor(cantidad);
		return calcImporte.getResultMoney();
	}

	
}
