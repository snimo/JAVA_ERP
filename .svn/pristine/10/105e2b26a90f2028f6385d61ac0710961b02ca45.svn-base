package com.srn.erp.contabilidad.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.ComproCierreEjercicio;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.contabilidad.bm.ImporteDebeHaber;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPropuAsiAperEjer extends Operation {

	private int newOid = 0;
	Integer oidCierreEjercicio = null;
	private CalculadorMoney difDebeMenosHaber = new CalculadorMoney(new Money(0)); 
	private CalculadorMoney difDebeMenosHaberImputMonLocHist = new CalculadorMoney(new Money(0));
	private CalculadorMoney difDebeMenosHaberImputMonLocAju = new CalculadorMoney(new Money(0));
	private CalculadorMoney difDebeMenosHaberImputMonExt1 = new CalculadorMoney(new Money(0));
	private CalculadorMoney difDebeMenosHaberImputMonExt2 = new CalculadorMoney(new Money(0));
	
	HashTableDatos acumPorCuenta = new HashTableDatos();
	HashTableDatos acumPorCuentaImputable = new HashTableDatos();

	public TraerPropuAsiAperEjer() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		oidCierreEjercicio = mapaDatos.getInteger("oid_cierre_ejercicio");
		Ejercicio ejercicioActual = Ejercicio.findByOidProxy(mapaDatos.getInteger("oid_ejercicio"), this.getSesion());
		Ejercicio ejercicio = ejercicioActual.getEjercicioAnterior();
		
		if (ejercicio == null)
			throw new ExceptionValidation(null,"No pudo encontrar el ejercicio anterior al "+ejercicioActual.getDescripcion());
		
		// Buscar el asiento de cierre de Patrimoniales
		ComproCierreEjercicio comproCierrePatrimoniales = 
			ejercicio.getComproCierrePatrimonial();
		
		if (comproCierrePatrimoniales == null)
			throw new ExceptionValidation(null,"No se pudo encontrar el asiento de cierre de patrimoniales para el ejercicio "+ejercicio.getDescripcion());
		
		Iterator iterComproContaDet =
			comproCierrePatrimoniales.getComproConta().getDetallesAsiento().iterator();
		while (iterComproContaDet.hasNext()) {
			ComproContaDet comproContaDet = (ComproContaDet) iterComproContaDet.next();
			acumularComproContaDetPorCuenta(comproContaDet);
			acumularComproContaDetPorImputable(comproContaDet);
			
		}

		IDataSet dsResumenAsiento = this.getDataSetResumenAsi();
		IDataSet dsDetalleAsiento = this.getDataSetDetAsiento();
		
		enviarAsientoResumen(dsResumenAsiento);
		enviarAsientoDetPorImputable(dsDetalleAsiento);
		

		writeCliente(dsResumenAsiento);
		writeCliente(dsDetalleAsiento);

	}
	
	private void enviarAsientoDetPorImputable(IDataSet ds) throws BaseException {
		
		Iterator iterCuentas = 
			acumPorCuentaImputable.keySet().iterator();
		while (iterCuentas.hasNext()) {
			
			Integer oidCuenta = (Integer) iterCuentas.next();
			ImporteDebeHaber importeDebeHaber = (ImporteDebeHaber) acumPorCuentaImputable.get(oidCuenta);
			ImportesContables saldosContables = 
				importeDebeHaber.getSaldoImportesContables();
			
			Money debeMonLocHist = new Money(0);
			Money debeMonLocAju = new Money(0);
			Money debeMonExt1 = new Money(0);
			Money debeMonExt2 = new Money(0);
			
			Money haberMonLocHist = new Money(0);
			Money haberMonLocAju = new Money(0);
			Money haberMonExt1 = new Money(0);
			Money haberMonExt2 = new Money(0);
			
			if (importeDebeHaber.getSignoSaldo() == RenglonAsiento.DEBE) {
				
				haberMonLocHist = saldosContables.getImpoMonLoc();
				haberMonLocAju = saldosContables.getImpoMonLocAju();
				haberMonExt1 = saldosContables.getImpoMonExt1();
				haberMonExt2 = saldosContables.getImpoMonExt2();
				
				difDebeMenosHaberImputMonLocHist.restar(haberMonLocHist);
				difDebeMenosHaberImputMonLocAju.restar(haberMonLocAju);
				difDebeMenosHaberImputMonExt1.restar(haberMonExt1);
				difDebeMenosHaberImputMonExt2.restar(haberMonExt2);
				
			}
			else {
				
				debeMonLocHist = saldosContables.getImpoMonLoc();
				debeMonLocAju = saldosContables.getImpoMonLocAju();
				debeMonExt1 = saldosContables.getImpoMonExt1();
				debeMonExt2 = saldosContables.getImpoMonExt2();
				
				difDebeMenosHaberImputMonLocHist.sumar(debeMonLocHist);
				difDebeMenosHaberImputMonLocAju.sumar(debeMonLocAju);
				difDebeMenosHaberImputMonExt1.sumar(debeMonExt1);
				difDebeMenosHaberImputMonExt2.sumar(debeMonExt2);
				
			}
			
			cargarDetalleAsiento(ds,
					oidCierreEjercicio,
					CuentaImputable.findByOid(oidCuenta, this.getSesion()),
					debeMonLocHist,
					haberMonLocHist,
					debeMonLocAju,
					haberMonLocAju,
					debeMonExt1,
					haberMonExt1,
					debeMonExt2,
					haberMonExt2);					
					
					
		}
		
		
	}
	
	
	
	private void enviarAsientoResumen(IDataSet ds) throws BaseException {
		
		Iterator iterCuentas = 
			acumPorCuenta.keySet().iterator();
		while (iterCuentas.hasNext()) {
			
			Integer oidCuenta = (Integer) iterCuentas.next();
			ImporteDebeHaber importeDebeHaber = (ImporteDebeHaber) acumPorCuenta.get(oidCuenta);
			ImportesContables saldosContables = 
				importeDebeHaber.getSaldoImportesContables();
			
			Money debe = new Money(0);
			Money haber = new Money(0);
			
			if (importeDebeHaber.getSignoSaldo() == RenglonAsiento.DEBE) {
				haber = saldosContables.getImpoMonLoc();
				difDebeMenosHaber.restar(haber);
			}
			else {
				debe = saldosContables.getImpoMonLoc();
				difDebeMenosHaber.sumar(debe);
			}
			
			if ((debe.doubleValue()==0) && (haber.doubleValue()==0)) continue;
			
			cargarResumenAsiento(ds,
					oidCierreEjercicio,
					Cuenta.findByOid(oidCuenta, this.getSesion()),
					debe,haber);
					
		}
		
	}
	
	
	private void acumularComproContaDetPorImputable(ComproContaDet comproContaDet) throws BaseException {
		
		ImporteDebeHaber importeDebeHaber =
			(ImporteDebeHaber) acumPorCuentaImputable.get(comproContaDet.getCuentaImputable().getOIDInteger());
		
		if (importeDebeHaber == null) {
			importeDebeHaber = new ImporteDebeHaber();
			ImportesContables impoContaDebe = new ImportesContables(new Money(0), new Money(0), new Money(0), new Money(0)); 
			ImportesContables impoContaHaber = new ImportesContables(new Money(0), new Money(0), new Money(0), new Money(0));
			importeDebeHaber.setDebe(impoContaDebe);
			importeDebeHaber.setHaber(impoContaHaber);
			acumPorCuentaImputable.put(comproContaDet.getCuentaImputable().getOIDInteger(), importeDebeHaber);
		}
		
		ImportesContables importesContables = new ImportesContables(
				comproContaDet.getImpoLocHist(),
				comproContaDet.getImpoLocAju(),
				comproContaDet.getImpoMonExt1(),
				comproContaDet.getImpoMonExt2()); 
		
		if (comproContaDet.getSigno().intValue() == RenglonAsiento.DEBE) 
			importeDebeHaber.acumularDebe(importesContables);
		else
			importeDebeHaber.acumularHaber(importesContables);
			
		
	}
	
	private void acumularComproContaDetPorCuenta(ComproContaDet comproContaDet) throws BaseException {
		
		ImporteDebeHaber importeDebeHaber =
			(ImporteDebeHaber) acumPorCuenta.get(comproContaDet.getCuentaImputable().getCuenta().getOIDInteger());
		
		if (importeDebeHaber == null) {
			importeDebeHaber = new ImporteDebeHaber();
			ImportesContables impoContaDebe = new ImportesContables(new Money(0), new Money(0), new Money(0), new Money(0)); 
			ImportesContables impoContaHaber = new ImportesContables(new Money(0), new Money(0), new Money(0), new Money(0));
			importeDebeHaber.setDebe(impoContaDebe);
			importeDebeHaber.setHaber(impoContaHaber);
			acumPorCuenta.put(comproContaDet.getCuentaImputable().getCuenta().getOIDInteger(), importeDebeHaber);
		}
		
		ImportesContables importesContables = new ImportesContables(
				comproContaDet.getImpoLocHist(),
				comproContaDet.getImpoLocAju(),
				comproContaDet.getImpoMonExt1(),
				comproContaDet.getImpoMonExt2()); 
		
		if (comproContaDet.getSigno().intValue() == RenglonAsiento.DEBE) 
			importeDebeHaber.acumularDebe(importesContables);
		else
			importeDebeHaber.acumularHaber(importesContables);
			
		
	}

	private IDataSet getDataSetResumenAsi() {
		IDataSet dataset = new TDataSet();
		dataset.create("TResumenContableDet");
		dataset.fieldDef(new Field("oid_resumen_contable", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_apertura_contable", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ana_con", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_ana_con", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_ana_con", Field.STRING, 255));
		dataset.fieldDef(new Field("debe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("haber", Field.CURRENCY, 0));
		return dataset;
	}

	private void cargarResumenAsiento(IDataSet ds, Integer oidComproCierre,
			Cuenta cuenta, Money debe, Money haber) throws BaseException {
		
		if ((debe.doubleValue()==0) && (haber.doubleValue()==0)) return;

		ds.append();
		ds.fieldValue("oid_resumen_contable", new Integer(--newOid));
		ds.fieldValue("oid_apertura_contable", oidComproCierre);
		ds.fieldValue("oid_ana_con", cuenta.getOIDInteger());
		ds.fieldValue("cod_ana_con", cuenta.getCodigo());
		ds.fieldValue("desc_ana_con", cuenta.getDescripcion());
		
		if (debe.doubleValue()!=0)
			ds.fieldValue("debe", debe);
		else
			ds.fieldValue("debe", "");
		if (haber.doubleValue()!=0)
			ds.fieldValue("haber", haber);
		else
			ds.fieldValue("haber", "");

	}
	
	private void cargarDetalleAsiento(
			IDataSet ds, Integer oidComproCierre,
			CuentaImputable cuenta, 
			Money debeMonLoc, 
			Money haberMonLoc,
			Money debeMonAju,
			Money haberMonAju,
			Money debeMonExt1,
			Money haberMonExt1,
			Money debeMonExt2,
			Money haberMonExt2) throws BaseException {

		ds.append();
		ds.fieldValue("oid_apertura_det", new Integer(--newOid));
		ds.fieldValue("oid_apertura_contable", oidComproCierre);
		ds.fieldValue("oid_ai", cuenta.getOIDInteger());
		ds.fieldValue("debe_mon_loc", debeMonLoc);
		ds.fieldValue("haber_mon_loc", haberMonLoc);
		ds.fieldValue("debe_mon_aju", debeMonAju);
		ds.fieldValue("haber_mon_aju", haberMonAju);
		ds.fieldValue("debe_mon_ext_1", debeMonExt1);
		ds.fieldValue("haber_mon_ext_1", haberMonExt1);
		ds.fieldValue("debe_mon_ext_2", debeMonExt2);
		ds.fieldValue("haber_mon_ext_2", haberMonExt2);
		if ((debeMonLoc.doubleValue()>0) || (debeMonAju.doubleValue()>0) || (debeMonExt1.doubleValue()>0) || (debeMonExt2.doubleValue()>0))			
			ds.fieldValue("signo", RenglonAsiento.DEBE);
		else
			ds.fieldValue("signo", RenglonAsiento.HABER);

	}
	

	private IDataSet getDataSetDetAsiento() {
		IDataSet dataset = new TDataSet();
		dataset.create("TAperturaContableDet");
		dataset.fieldDef(new Field("oid_apertura_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_apertura_contable", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
		dataset.fieldDef(new Field("debe_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("haber_mon_loc", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("debe_mon_aju", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("haber_mon_aju", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("debe_mon_ext_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("haber_mon_ext_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("debe_mon_ext_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("haber_mon_ext_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("signo", Field.INTEGER, 0));
		return dataset;
	}

}
