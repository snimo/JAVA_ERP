package com.srn.erp.ctasAPagar.bm;

import java.util.Iterator;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class DesAplicarCtaCteProv {

	private ISesion sesion;

	public DesAplicarCtaCteProv(ISesion aSesion) throws BaseException {
		this.sesion = aSesion;
	}

	public void desaplicar(AplicacionComproProv aplicacionComproProv)
			throws BaseException {

		Iterator iterAplicProvVto = 
			aplicacionComproProv.getAplicacionesProveedor().iterator();
		while (iterAplicProvVto.hasNext()) {
			AplProv aplProv = (AplProv) iterAplicProvVto.next();

			// Restablecer el Saldo del Vencimiento

			CalculadorMoney calcNuevoSaldo = new CalculadorMoney(aplProv
					.getImporte());
			calcNuevoSaldo.multiplicarPor(new Money(-1));
			calcNuevoSaldo.sumar(aplProv.getTranprovvto().getSaldo());
			aplProv.getTranprovvto().setSaldo(calcNuevoSaldo.getResultMoney());
			if (aplProv.getTranprovvto().getSaldo().doubleValue() == 0)
				aplProv.getTranprovvto().setPendiente(new Boolean(false));
			else
				aplProv.getTranprovvto().setPendiente(new Boolean(true));
			aplProv.getTranprovvto().save();

			// Restablecer el saldo de la transaccion
			calcNuevoSaldo = new CalculadorMoney(aplProv
					.getImporte());
			calcNuevoSaldo.multiplicarPor(new Money(-1));
			calcNuevoSaldo.sumar(aplProv.getTranprovvto().getTranprov()
					.getSaldo());
			aplProv.getTranprovvto().getTranprov().setSaldo(
					calcNuevoSaldo.getResultMoney());
			if (aplProv.getTranprovvto().getTranprov().getSaldo().doubleValue() == 0)
				aplProv.getTranprovvto().getTranprov().setPendiente(
						new Boolean(false));
			else
				aplProv.getTranprovvto().getTranprov().setPendiente(
						new Boolean(true));
			aplProv.getTranprovvto().getTranprov().save();

			aplProv.delete();
			aplProv.save();

		}

	}

}
