package com.srn.erp.contabilidad.bm;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class ImporteDebeHaber {
	
	private ImportesContables debe;
	private ImportesContables haber;
	
	public ImportesContables getDebe() {
		return debe;
	}
	public void setDebe(ImportesContables debe) {
		this.debe = debe;
	}
	public ImportesContables getHaber() {
		return haber;
	}
	public void setHaber(ImportesContables haber) {
		this.haber = haber;
	}
	
	public void acumularDebe(ImportesContables importesConatbles) throws BaseException {
		
		// Importe Moneda historico
		CalculadorMoney calcImpoMonHist = new CalculadorMoney(importesConatbles.getImpoMonLoc());
		calcImpoMonHist.sumar(debe.getImpoMonLoc());
		debe.setImpoMonLoc(calcImpoMonHist.getResultMoney());
		calcImpoMonHist = null;
		
		// Importe Moneda Ajustado
		CalculadorMoney calcImpoMonAju = new CalculadorMoney(importesConatbles.getImpoMonLocAju());
		calcImpoMonAju.sumar(debe.getImpoMonLocAju());
		debe.setImpoMonLocAju(calcImpoMonAju.getResultMoney());
		calcImpoMonAju = null;
		
		// Moneda Extrajera 1
		CalculadorMoney calcImpoMonExt1 = new CalculadorMoney(importesConatbles.getImpoMonExt1());
		calcImpoMonExt1.sumar(debe.getImpoMonExt1());
		debe.setImpoMonExt1(calcImpoMonExt1.getResultMoney());
		calcImpoMonExt1 = null;
		
		// Moneda Extrajera 2
		CalculadorMoney calcImpoMonExt2 = new CalculadorMoney(importesConatbles.getImpoMonExt2());
		calcImpoMonExt2.sumar(debe.getImpoMonExt2());
		debe.setImpoMonExt2(calcImpoMonExt2.getResultMoney());
		calcImpoMonExt2 = null;
		
	}
	
	public void acumularHaber(ImportesContables importesConatbles) throws BaseException {
		
		// Importe Moneda historico
		CalculadorMoney calcImpoMonHist = new CalculadorMoney(importesConatbles.getImpoMonLoc());
		calcImpoMonHist.sumar(haber.getImpoMonLoc());
		haber.setImpoMonLoc(calcImpoMonHist.getResultMoney());
		calcImpoMonHist = null;
		
		// Importe Moneda Ajustado
		CalculadorMoney calcImpoMonAju = new CalculadorMoney(importesConatbles.getImpoMonLocAju());
		calcImpoMonAju.sumar(haber.getImpoMonLocAju());
		haber.setImpoMonLocAju(calcImpoMonAju.getResultMoney());
		calcImpoMonAju = null;
		
		// Moneda Extrajera 1
		CalculadorMoney calcImpoMonExt1 = new CalculadorMoney(importesConatbles.getImpoMonExt1());
		calcImpoMonExt1.sumar(haber.getImpoMonExt1());
		haber.setImpoMonExt1(calcImpoMonExt1.getResultMoney());
		calcImpoMonExt1 = null;
		
		// Moneda Extrajera 2
		CalculadorMoney calcImpoMonExt2 = new CalculadorMoney(importesConatbles.getImpoMonExt2());
		calcImpoMonExt2.sumar(haber.getImpoMonExt2());
		haber.setImpoMonExt2(calcImpoMonExt2.getResultMoney());
		calcImpoMonExt2 = null;
		
	}
	
	public int getSignoSaldo() throws BaseException {
		if (this.getDebe().getImpoMonLoc().doubleValue()>this.getHaber().getImpoMonLoc().doubleValue())
			return RenglonAsiento.DEBE;
		else
			return RenglonAsiento.HABER;
	}
	
	public ImportesContables getSaldoImportesContables() throws BaseException {
		ImportesContables impoConta = new ImportesContables(new Money(0), new Money(0), new Money(0), new Money(0));
		
		int signo = getSignoSaldo(); 
			
		// Importe Moneda historico
		CalculadorMoney calcImpoMonHist = new CalculadorMoney(debe.getImpoMonLoc());
		calcImpoMonHist.restar(haber.getImpoMonLoc());
		if (signo == RenglonAsiento.HABER)
			calcImpoMonHist.multiplicarPor(new Money(-1));
		impoConta.setImpoMonLoc(calcImpoMonHist.getResultMoney());
		calcImpoMonHist = null;
			
		// Importe Moneda Ajustado
		CalculadorMoney calcImpoMonAju = new CalculadorMoney(debe.getImpoMonLocAju());
		calcImpoMonAju.restar(haber.getImpoMonLocAju());
		if (signo == RenglonAsiento.HABER)
			calcImpoMonAju.multiplicarPor(new Money(-1));		
		impoConta.setImpoMonLocAju(calcImpoMonAju.getResultMoney());
		calcImpoMonAju = null;
			
		// Importe Moneda Extranjera 1
		CalculadorMoney calcImpoMonExt1 = new CalculadorMoney(debe.getImpoMonExt1());
		calcImpoMonExt1.restar(haber.getImpoMonExt1());
		if (signo == RenglonAsiento.HABER)
			calcImpoMonExt1.multiplicarPor(new Money(-1));		
		impoConta.setImpoMonExt1(calcImpoMonExt1.getResultMoney());
		calcImpoMonExt1 = null;
			
		// Importe Moneda Extranjera 2
		CalculadorMoney calcImpoMonExt2 = new CalculadorMoney(debe.getImpoMonExt2());
		calcImpoMonExt2.restar(haber.getImpoMonExt2());
		if (signo == RenglonAsiento.HABER)
			calcImpoMonExt2.multiplicarPor(new Money(-1));		
		impoConta.setImpoMonExt2(calcImpoMonExt2.getResultMoney());
		calcImpoMonExt2 = null;
		
		return impoConta;
		
	}
	
	

}
