package com.srn.erp.bienUso.bm;

import java.util.Map;

import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class CalculoMovimientoAmortizacion {
	
	private ISesion aSesion;
	private SubBien subBien;
	private Periodo periodo;
	private SistemaValuacion sistemaValuacion;
	private HashTableDatos listaCotizaciones;
	//private Money importeValorOrigenRevaluo
	
	public void setListaCotizaciones(HashTableDatos aListaCotizaciones) throws BaseException {
		this.listaCotizaciones = aListaCotizaciones;
	}
	
	public HashTableDatos getListaCotizaciones() throws BaseException {
		return this.listaCotizaciones;
	}
	
	public ISesion getASesion() {
		return aSesion;
	}
	public void setASesion(ISesion sesion) {
		aSesion = sesion;
	}
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	public SistemaValuacion getSistemaValuacion() {
		return sistemaValuacion;
	}
	public void setSistemaValuacion(SistemaValuacion sistemaValuacion) {
		this.sistemaValuacion = sistemaValuacion;
	}
	public SubBien getSubBien() {
		return subBien;
	}
	public void setSubBien(SubBien subBien) {
		this.subBien = subBien;
	}
	
	public Map getMovimientos() throws BaseException {
		HashTableDatos movimientos = new HashTableDatos();
		
		// Determinar si hay revaluo por efecto inflacionario
		if (sistemaValuacion.isAju_inf().booleanValue()) {
			Money revaluoVODelPeriodo = getRevaluoValorOrigenDelPeriodo();
			movimientos.put(MovimientoBienUso.TM_RVO,revaluoVODelPeriodo);
		}
		
		// Determinar la Amortizacion del Valor Origen del Periodo
		Money amortDelMes = getAmortizacionDelMesVO();
		movimientos.put(MovimientoBienUso.TM_AM_VO,amortDelMes);
		
		if (sistemaValuacion.isAju_inf().booleanValue()) {
			
			// Revaluo Amortizacin Valor Origen
			Money revaluoAmortizacionVO = getRevaluoAmortVO();
			movimientos.put(MovimientoBienUso.TM_RAM_VO,revaluoAmortizacionVO);
			
			// Ajuste Amortizacion meses anteriores del ejercicio
			Money ajusteAmortMesesant = getAjusteAmortMesesAnt();
			movimientos.put(MovimientoBienUso.TM_AJ_AMO_MESES_ANT,ajusteAmortMesesant);
			
			// Ajuste Amortizaciones por los meses anteriores
			Money ajusteAmortEjerAnt = getAjusteAmortEjerAnt();
			movimientos.put(MovimientoBienUso.TM_AJ_AMO_EJER_ANT,ajusteAmortEjerAnt);
			
		}
		
		
		return movimientos;
	}
	
	private Money getValorOrigenRevaluado(Money valorOrigen) throws BaseException {
		Periodo periodoIndexacionDesde = subBien.getPeri_ini_amort();
		AjusteInflacionAmortizacion ajuInf = new AjusteInflacionAmortizacion();
		ajuInf.setSistemaValuacion(sistemaValuacion);
		Money valorOrigenRevaluado = ajuInf.aplicaAjusteInflacion(periodoIndexacionDesde,this.periodo,valorOrigen);		
		return valorOrigenRevaluado;
	}
	
	//private Money getRevaluoValorOrigenBD() throws BaseException {
	//	return subBien.getRevaluoValorOrigen(sistemaValuacion,periodo);
	//}
	
	private Money getRevaluoValorOrigenDelPeriodo() throws BaseException {
		
        // Tomar el Valor Origen del Bien
		ValorOrigenSubBien valorOrigen = ValorOrigenSubBien.getValorOrigenSubBien(subBien,sistemaValuacion,aSesion);
		Money importeValorOrigen = valorOrigen.getValor_origen();
		
		// Revaluar el Valor Origen del Bien al Periodo que esta amortizando
		Money valorOrigenRevaluado =
			   this.getValorOrigenRevaluado(importeValorOrigen);
		
		// Obtener el total de revaluos en la base de datos
		Money revaluacionesValorOrigen = subBien.getRevaluoValorOrigen(sistemaValuacion,periodo);
		
		CalculadorMoney calcRevDelPeri = new CalculadorMoney(new Money(0));
		calcRevDelPeri.sumar(valorOrigenRevaluado);
		calcRevDelPeri.restar(importeValorOrigen);
		calcRevDelPeri.restar(revaluacionesValorOrigen);
		
		return calcRevDelPeri.getResultMoney();
		
	}
	
	private Money getAmortizacionDelMesVO() throws BaseException {
      // Tomar el Valor Origen del Bien
	  ValorOrigenSubBien valorOrigen = ValorOrigenSubBien.getValorOrigenSubBien(subBien,sistemaValuacion,aSesion);
	  Money importeValorOrigen = valorOrigen.getValor_origen();
	  Money tasaAmortizacion = subBien.getTasaAmortizacion(sistemaValuacion);
	  CalculadorMoney calcAmortPeri = new CalculadorMoney(new Money(0));
	  calcAmortPeri.sumar(importeValorOrigen);
	  calcAmortPeri.multiplicarPor(tasaAmortizacion);
	  return calcAmortPeri.getResultMoney();
	}
	
	
	private Money getValorOrigenRevaluado() throws BaseException {
		
		// Tomar el Valor Origen del Bien
		ValorOrigenSubBien valorOrigen = ValorOrigenSubBien.getValorOrigenSubBien(subBien,sistemaValuacion,aSesion);
		Money importeValorOrigen = valorOrigen.getValor_origen();
		
		// Revaluar el Valor Origen del Bien al Periodo que esta amortizando
		Money valorOrigenRevaluado =
			   this.getValorOrigenRevaluado(importeValorOrigen);
		
		return valorOrigenRevaluado;
	}
	
	private Money getRevaluoAmortVO() throws BaseException {
		
		// Revaluar el Valor Origen del Bien al Periodo que esta amortizando
		Money valorOrigenRevaluado = getValorOrigenRevaluado();
		
		// Obtener la Tasa de Amortización 
		Money tasaAmortizacion = subBien.getTasaAmortizacion(sistemaValuacion);
		
		// Obtener la amortizacion de Valor Origen del Mes
		Money amortMesVO = getAmortizacionDelMesVO();
		
		CalculadorMoney calcRevAmortVO = new CalculadorMoney(new Money(0));
		calcRevAmortVO.sumar(valorOrigenRevaluado);
		calcRevAmortVO.multiplicarPor(tasaAmortizacion);
		calcRevAmortVO.restar(amortMesVO);
		return calcRevAmortVO.getResultMoney();
	}
	
	private Money getAjusteAmortMesesAnt() throws BaseException {
		
		// Obtener la Tasa acumulada
		Money tasaAcum = subBien.getTasaAcum(sistemaValuacion,periodo);
		Money tasaAmortizacion = subBien.getTasaAmortizacion(sistemaValuacion);
		CalculadorMoney calcTasaAcum = new CalculadorMoney(tasaAcum);
		calcTasaAcum.sumar(tasaAmortizacion);
		
		// 1- Calcular la amortización teórica acumulada
		Money valorOrigenRevaluado = getValorOrigenRevaluado();
		CalculadorMoney calcAmortTeorica = new CalculadorMoney(valorOrigenRevaluado);
		calcAmortTeorica.multiplicarPor(calcTasaAcum.getResultMoney());
		
		// 2- Obtener la amortizacion acumulada sin incluir el periodo que se esta amortizando
		Money amortAcumulada = getAmortizacionAcumuladaRevaluadaAntAPeri();
		
		// 3- Obtener la amortizacion del Mes Valor Origen
		Money amortMesValorOrigen = getAmortizacionDelMesVO();
		
		// 4- Obtener el revaluo de la amortizacion del mes valor origen
		Money revaluoAmortizacionVO = getRevaluoAmortVO();
		
		// 5- Amortizacion Teorica acumulada al inicio del ejercicio
		Money amortTeoricaAcumAlIniEjer = getAmortTeoricaAcumAlIniEjer();
		
		// 6- Amortizacion acumulada al inicio del ejercicio
		Money amortAcumAlIniEjer = getAmortAcumAlIniEjer();
		
		// 7- Acumulado de Ajuste amortizacion ejercicios anteriores
		Money amortAcumAjuEjerAnt = getAmortAcumAjuEjerAnt();
		
		CalculadorMoney calcAjusteAmortMesesAnt = new CalculadorMoney(new Money(0));
		calcAjusteAmortMesesAnt.sumar(calcAmortTeorica.getResultMoney());
		calcAjusteAmortMesesAnt.restar(amortAcumulada);
		calcAjusteAmortMesesAnt.restar(amortMesValorOrigen);
		calcAjusteAmortMesesAnt.restar(revaluoAmortizacionVO);
		calcAjusteAmortMesesAnt.restar(amortTeoricaAcumAlIniEjer);
		calcAjusteAmortMesesAnt.sumar(amortAcumAlIniEjer);
		calcAjusteAmortMesesAnt.sumar(amortAcumAjuEjerAnt);
		
		return calcAjusteAmortMesesAnt.getResultMoney();
		
	}
	
	
	
	private Money getAmortizacionAcumuladaRevaluadaAntAPeri() throws BaseException  {
		AmortizacionAcumulada amortizacionAcumuladaAnAPeri = AmortizacionAcumulada.getAmortizacionAcumuladaHastaPeriAnt(subBien,sistemaValuacion,periodo,aSesion);
		return amortizacionAcumuladaAnAPeri.getAmortizacionAcumulada();
	}
	
	private Money getAmortTeoricaAcumAlIniEjer() throws BaseException {
		Money valorOrigenRevaluado = getValorOrigenRevaluado();
		Money tasaAcumEjerAnt = subBien.getTasaAcumEjerAnteriores(sistemaValuacion);
		CalculadorMoney calcAmortTeoricaAlIniEjer = new CalculadorMoney(valorOrigenRevaluado);
		calcAmortTeoricaAlIniEjer.multiplicarPor(tasaAcumEjerAnt);
		return calcAmortTeoricaAlIniEjer.getResultMoney();
	}
	
	private Money getAmortAcumAlIniEjer() throws BaseException {
		Periodo periodoInicioEjercicio = periodo.getPrimerPeriodoEjercicio();
		AmortizacionAcumulada amortizacionAcumuladaAnAPeri = AmortizacionAcumulada.getAmortizacionAcumuladaHastaPeriAnt(subBien,
																														sistemaValuacion,
																														periodoInicioEjercicio,
																														aSesion);
		return amortizacionAcumuladaAnAPeri.getAmortizacionAcumulada();
	}
	
	private Money getAmortAcumAjuEjerAnt() throws BaseException {
		return subBien.getAmortAcumAjustesEjerAnt(sistemaValuacion,periodo);
	}
	
	private Money getAjusteAmortEjerAnt() throws BaseException {
		
		Money amortTeoricaAlIniEjer = getAmortTeoricaAcumAlIniEjer();
		Money amortAcumAlIniEjer    = getAmortAcumAlIniEjer();
		Money amortAcumAjuEjerAnt   = getAmortAcumAjuEjerAnt();
		
		CalculadorMoney calcAjuAmortEjeAnt = new CalculadorMoney(new Money(0));
		calcAjuAmortEjeAnt.sumar(amortTeoricaAlIniEjer);
		calcAjuAmortEjeAnt.restar(amortAcumAlIniEjer);
		calcAjuAmortEjeAnt.restar(amortAcumAjuEjerAnt);
		
		return calcAjuAmortEjeAnt.getResultMoney();
	}

}
