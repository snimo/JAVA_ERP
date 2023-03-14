package com.srn.erp.conciTarjeta.bm;

import java.util.Iterator;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class AsientoCobTarj {
	
	private HashTableDatos renglones = new HashTableDatos();
	private HashTableDatos renglonesResuPorSaldo = new HashTableDatos(); 
	
	public void AddDetalle(
			String cuenta,
			String compo1,
			String compo2,
			String D_O_H,
			Money importe
			) throws BaseException {
		
		
		String claveResu = getClave(cuenta, compo1, compo2, "");
		String clave = getClave(cuenta, compo1, compo2, D_O_H);
		
		RenglonAsiCobTarj renglon = (RenglonAsiCobTarj) renglones.get(clave);
		if (renglon == null) {
			renglon = new RenglonAsiCobTarj();
			renglones.put(clave, renglon);
			renglon.setCuenta(cuenta);
			renglon.setCompo1(compo1);
			renglon.setCompo2(compo2);
			renglon.setD_H(D_O_H);
			renglon.setImporte(new Money(0));
		}
		
		// Acumular el Importe
		CalculadorMoney acumImp = new CalculadorMoney(renglon.getImporte());
		acumImp.sumar(importe);
		renglon.setImporte(acumImp.getResultMoney());
		
		RenglonAsiCobTarj renglon1 = (RenglonAsiCobTarj) renglonesResuPorSaldo.get(claveResu);
		if (renglon1 == null) {
			renglon1 = new RenglonAsiCobTarj();
			renglonesResuPorSaldo.put(claveResu, renglon1);
			renglon1.setCuenta(cuenta);
			renglon1.setCompo1(compo1);
			renglon1.setCompo2(compo2);
			renglon1.setD_H("R");
			renglon1.setImporte(new Money(0));
		}
		
		// Obtener el Importe con saldo
		CalculadorMoney impConSigo = new CalculadorMoney(new Money(0));
		if ((D_O_H.equals("D")) && (importe.doubleValue()>=0)) {
			impConSigo.sumar(new Money(importe.doubleValue()));
		} else if ((D_O_H.equals("D")) && (importe.doubleValue()<0)) {
			impConSigo.sumar(new Money(importe.doubleValue()));
		} else if ((D_O_H.equals("H")) && (importe.doubleValue()>=0)) {
			impConSigo.sumar(new Money(importe.doubleValue()*-1));
		} else if ((D_O_H.equals("H")) && (importe.doubleValue()<0)) {
			impConSigo.sumar(new Money(importe.doubleValue()*-1));
		}
		
		
		CalculadorMoney acumImp1 = new CalculadorMoney(renglon1.getImporte());
		acumImp1.sumar(impConSigo.getResultMoney());
		renglon1.setImporte(acumImp1.getResultMoney());		
		
		
	}
	
	private String getClave(String cuenta,
							String compo1,
							String compo2,
							String DOH) throws BaseException {
		StringBuffer clave = new StringBuffer("");
		if (cuenta!=null)
			clave.append(cuenta);
		clave.append("*");
		if (compo1!=null)
			clave.append(compo1);
		clave.append("*");
		if (compo2!=null)
			clave.append(compo2);
		clave.append("*");
		if (DOH!=null)
			clave.append(DOH);		
		return clave.toString();
	}
							
	
	public boolean existeClave(String clave) {
		RenglonAsiCobTarj renglon = (RenglonAsiCobTarj) renglones.get(clave);
		if (renglon!=null)
			return true;
		else
			return false;
	}
	
	public int getCantRenglones() {
		return renglones.size();
	}
	
	public int getCantRenglonesResu() {
		return renglonesResuPorSaldo.size();
	}	
	
	public Iterator getRenglones() throws BaseException {
		return this.renglones.values().iterator();
	}

	public Iterator getRenglonesResu() throws BaseException {
		return this.renglonesResuPorSaldo.values().iterator();
	}
	

}
