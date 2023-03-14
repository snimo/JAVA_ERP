package com.srn.erp.bienUso.bm;

import com.srn.erp.general.bm.IndiceValor;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class AjusteInflacionAmortizacion {
	
	private SistemaValuacion sistemaValuacion;
	
	public void setSistemaValuacion(SistemaValuacion sistemaValuacion) throws BaseException {
		this.sistemaValuacion = sistemaValuacion;
	}
	
	public Money aplicaAjusteInflacion(Periodo periodoDesde,Periodo periodoHasta, Money valorOrigen) throws BaseException {
		if (!sistemaValuacion.isAju_inf().booleanValue())
			return valorOrigen;
		else {
			// Aplicar la valuacipn del valor origen
			IndiceValor valorIndiceOrigen = sistemaValuacion.getIndice().getValorIndice(periodoDesde);
			IndiceValor valorIndiceDestino = sistemaValuacion.getIndice().getValorIndice(periodoHasta);
			
			// Calcular el coeficiente de inflacion
			CalculadorMoney calcAjuInf = new CalculadorMoney(new Money(0));
			calcAjuInf.sumar(new Money(valorIndiceDestino.getValor().doubleValue()));
			calcAjuInf.dividirPor(new Money(valorIndiceOrigen.getValor().doubleValue()));
			
			// Calcular el valor ajustado
			calcAjuInf.multiplicarPor(valorOrigen);
			return calcAjuInf.getResultMoney();
		}
	}
	
	

}
