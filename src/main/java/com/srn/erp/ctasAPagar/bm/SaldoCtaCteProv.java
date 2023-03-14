package com.srn.erp.ctasAPagar.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.da.DBSaldoCtaCteProv;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class SaldoCtaCteProv extends ObjetoLogico {

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

	public SaldoCtaCteProv() {
	}

	public static String NICKNAME = "cap.SaldoCtaCteProv";

	private Proveedor proveedor;
    private Moneda moneda; 
	private Money saldo;

	public Proveedor getProveedor() throws BaseException {
		supportRefresh();
		return proveedor;
	}

	public void setProveedor(Proveedor aProveedor) {
		this.proveedor = aProveedor;
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

	public static SaldoCtaCteProv findByOid(Integer oid, ISesion aSesion)
			throws BaseException {
		return (SaldoCtaCteProv) getObjectByOid(NICKNAME, oid, aSesion);
	}

	public static SaldoCtaCteProv findByCodigo(String codigo, ISesion aSesion)
			throws BaseException {
		return (SaldoCtaCteProv) getObjectByCodigo(NICKNAME, codigo, aSesion);
	}

	public void beforeSave() throws BaseException {
	}
	
	public static List getSaldosIniciales(Proveedor proveedor,
								   		  java.util.Date fecha,
										  ISesion sesion) throws BaseException {
		
		HashTableDatos saldos = new HashTableDatos();
		
		// Obtener los sados iniciales de TranProv
		List listaTransProv = DBSaldoCtaCteProv.getSaldosInicialesTranProv(proveedor,fecha,sesion);
		Iterator iterSalIniTranProv = listaTransProv.iterator();
		while (iterSalIniTranProv.hasNext()) {
			SaldoCtaCteProv saldoCtaCteProv = (SaldoCtaCteProv) iterSalIniTranProv.next();
			// Verificar si ya se encuentra en la lista de saldos por moneda  
			SaldoCtaCteProv saldoMoneda = (SaldoCtaCteProv) saldos.get(saldoCtaCteProv.getMoneda().getOIDInteger());
			if (saldoMoneda == null)
				saldos.put(saldoCtaCteProv.getMoneda().getOIDInteger(),saldoCtaCteProv);
			else {
				// Acumular por Moneda
				CalculadorMoney totSaldoMoneda = new CalculadorMoney(saldoMoneda.getSaldo());
				totSaldoMoneda.sumar(saldoCtaCteProv.getSaldo());
				saldoMoneda.setSaldo(totSaldoMoneda.getResultMoney());
			}
		}
		
		// Obtener las aplicaciones y aplicarlas a las Transacciones anteriores
		List listaTransProvAplic = DBSaldoCtaCteProv.getSaldosInicialesAplicProv(proveedor,fecha,sesion);
		Iterator iterSalIniTranProvAplic = listaTransProvAplic.iterator();
		while (iterSalIniTranProvAplic.hasNext()) {
			SaldoCtaCteProv saldoCtaCteProv = (SaldoCtaCteProv) iterSalIniTranProvAplic.next();
			// Verificar si ya se encuentra en la lista de saldos por moneda  
			SaldoCtaCteProv saldoMoneda = (SaldoCtaCteProv) saldos.get(saldoCtaCteProv.getMoneda().getOIDInteger());
			if (saldoMoneda == null)
				saldos.put(saldoCtaCteProv.getMoneda().getOIDInteger(),saldoCtaCteProv);
			else {
				// Acumular por Moneda
				CalculadorMoney totSaldoMoneda = new CalculadorMoney(saldoMoneda.getSaldo());
				totSaldoMoneda.sumar(saldoCtaCteProv.getSaldo());
				saldoMoneda.setSaldo(totSaldoMoneda.getResultMoney());
			}
		}
		
		List lista = new ArrayList();
		lista.addAll(saldos.values());
		return lista;
	}

}
