package com.srn.erp.ctasACobrar.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.ctasACobrar.da.DBSaldoCtaCteClie;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class SaldoCtaCteClie extends ObjetoLogico {

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public SaldoCtaCteClie() {
	}

	public static String NICKNAME = "cac.SaldoCtaCteClie";

	private Sujeto sujeto;
    private Moneda moneda; 
	private Money saldo;

	public Sujeto getSujeto() throws BaseException {
		supportRefresh();
		return sujeto;
	}

	public void setSujeto(Sujeto aSujeto) {
		this.sujeto = aSujeto;
	}

	public Money getSaldo() throws BaseException {
		supportRefresh();
		return saldo;
	}

	public void setSaldo(Money aSaldo) {
		this.saldo = aSaldo;
	}
	
	public Moneda getMoneda() throws BaseException {
		supportRefresh();
		return moneda;
	}

	public void setMoneda(Moneda aMoneda) {
		this.moneda = aMoneda;
	}
	

	public String getNickName() {
		return NICKNAME;
	}

	public static SaldoCtaCteClie findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (SaldoCtaCteClie) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SaldoCtaCteClie findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (SaldoCtaCteClie) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public static List getSaldosIniciales(Sujeto sujeto,
								   		  java.util.Date fecha,
										  ISesion sesion) throws BaseException {
		
		HashTableDatos saldos = new HashTableDatos();
		
		// Obtener los sados iniciales de TranClie
		List listaTransClie = DBSaldoCtaCteClie.getSaldosInicialesTranClie(sujeto,fecha,sesion);
		Iterator iterSalIniTranClie = listaTransClie.iterator();
		while (iterSalIniTranClie.hasNext()) {
			SaldoCtaCteClie saldoCtaCteClie = (SaldoCtaCteClie) iterSalIniTranClie.next();
			// Verificar si ya se encuentra en la lista de saldos por moneda  
			SaldoCtaCteClie saldoMoneda = (SaldoCtaCteClie) saldos.get(saldoCtaCteClie.getMoneda().getOIDInteger());
			if (saldoMoneda == null)
				saldos.put(saldoCtaCteClie.getMoneda().getOIDInteger(),saldoCtaCteClie);
			else {
				// Acumular por Moneda
				CalculadorMoney totSaldoMoneda = new CalculadorMoney(saldoMoneda.getSaldo());
				totSaldoMoneda.sumar(saldoCtaCteClie.getSaldo());
				saldoMoneda.setSaldo(totSaldoMoneda.getResultMoney());
			}
		}
		
		// Obtener las aplicaciones y aplicarlas a las Transacciones anteriores
		List listaTransClieAplic = DBSaldoCtaCteClie.getSaldosInicialesAplicClie(sujeto,fecha,sesion);
		Iterator iterSalIniTranClieAplic = listaTransClieAplic.iterator();
		while (iterSalIniTranClieAplic.hasNext()) {
			SaldoCtaCteClie saldoCtaCteClie = (SaldoCtaCteClie) iterSalIniTranClieAplic.next();
			// Verificar si ya se encuentra en la lista de saldos por moneda  
			SaldoCtaCteClie saldoMoneda = (SaldoCtaCteClie) saldos.get(saldoCtaCteClie.getMoneda().getOIDInteger());
			if (saldoMoneda == null)
				saldos.put(saldoCtaCteClie.getMoneda().getOIDInteger(),saldoCtaCteClie);
			else {
				// Acumular por Moneda
				CalculadorMoney totSaldoMoneda = new CalculadorMoney(saldoMoneda.getSaldo());
				totSaldoMoneda.sumar(saldoCtaCteClie.getSaldo());
				saldoMoneda.setSaldo(totSaldoMoneda.getResultMoney());
			}
		}
		
		List lista = new ArrayList();
		lista.addAll(saldos.values());
		return lista;
	}

}
