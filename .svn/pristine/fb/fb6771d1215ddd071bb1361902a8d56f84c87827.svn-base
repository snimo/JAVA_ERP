package com.srn.erp.ctasACobrar.bm;

import java.util.Iterator;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class DesAplicarCtaCteClie {

	private ISesion sesion;

	public DesAplicarCtaCteClie(ISesion aSesion) throws BaseException {
		this.sesion = aSesion;
	}

	public void desaplicar(AplicacionComproClie aplicacionComproClie)
			throws BaseException {

		Iterator iterAplicClieVto = aplicacionComproClie
				.getAplicacionesClienteVto().iterator();
		while (iterAplicClieVto.hasNext()) {
			AplicClieVto aplicClie = (AplicClieVto) iterAplicClieVto.next();

			// Restablecer el Saldo del Vencimiento

			CalculadorMoney calcNuevoSaldo = new CalculadorMoney(aplicClie
					.getImporte());
			calcNuevoSaldo.multiplicarPor(new Money(-1));
			calcNuevoSaldo.sumar(aplicClie.getTran_vto().getSaldo());
			aplicClie.getTran_vto().setSaldo(calcNuevoSaldo.getResultMoney());
			if (aplicClie.getTran_vto().getSaldo().doubleValue() == 0)
				aplicClie.getTran_vto().setPendiente(new Boolean(false));
			else
				aplicClie.getTran_vto().setPendiente(new Boolean(true));
			aplicClie.getTran_vto().save();

			// Restablecer el saldo de la transaccion
			calcNuevoSaldo = new CalculadorMoney(aplicClie.getImporte());
			calcNuevoSaldo.multiplicarPor(new Money(-1));
			calcNuevoSaldo.sumar(aplicClie.getTran_vto().getTran_clie()
					.getSaldo());
			aplicClie.getTran_vto().getTran_clie().setSaldo(
					calcNuevoSaldo.getResultMoney());
			if (aplicClie.getTran_vto().getTran_clie().getSaldo().doubleValue() == 0)
				aplicClie.getTran_vto().getTran_clie().setPendiente(
						new Boolean(false));
			else
				aplicClie.getTran_vto().getTran_clie().setPendiente(
						new Boolean(true));
			aplicClie.getTran_vto().getTran_clie().save();

			aplicClie.delete();
			aplicClie.save();

		}

	}

}
