package com.srn.erp.contabilidad.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.ComproAperturaEjercicio;
import com.srn.erp.contabilidad.bm.ComproCierreEjercicio;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.ImporteDebeHaber;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAperturaEjercicio extends Operation {
	
  HashTableDatos acumPorCuenta = new HashTableDatos();
  private int oid = 0;

  public TraerAperturaEjercicio() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet dsComproApertura = this.getDataSetAperturaEjercicio();
	  IDataSet dsAsiento = this.getDataSetAsiento();
	  
	  ComproAperturaEjercicio comproAperturaEjercicio = 
		  ComproAperturaEjercicio.findByOid(mapaDatos.getInteger("oid"), this.getSesion());
	  cargarRegistroAperturaEjercicio(dsComproApertura, comproAperturaEjercicio);
	  
	  List listaDetalles = ComproContaDet.getDetallesByComproConta(comproAperturaEjercicio.getComproConta(),
		getSesion());
	  
	  Iterator iterDetalles = listaDetalles.iterator();
	  while (iterDetalles.hasNext()) {
		  ComproContaDet comproContaDet = (ComproContaDet) iterDetalles.next();
		  acumularComproContaDetPorCuenta(comproContaDet);
	  }
	  
	  enviarAsientoResumen(dsAsiento,comproAperturaEjercicio);
	  
	  writeCliente(dsComproApertura);
	  writeCliente(dsAsiento);

    
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
  

  private IDataSet getDataSetAperturaEjercicio() {
    IDataSet dataset = new TDataSet();
    dataset.create("TAperturaContable");
    dataset.fieldDef(new Field("oid_apertura_contable", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ejercicio", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ejercicio", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ejercicio", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_imputacion", Field.DATE, 0));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  
  private IDataSet getDataSetAsiento() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TResumenContableDet");
	    dataset.fieldDef(new Field("oid_resumen_contable", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_apertura_contable", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_ana_con",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_ana_con",Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_ana_con",Field.STRING, 255));
	    dataset.fieldDef(new Field("debe",Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("haber",Field.CURRENCY, 0));
	    return dataset;
  }
  
  private void cargarAsiento(IDataSet dataset,
          Integer oidResumenContable,
          Integer oidAperturaContable,
          Cuenta cuenta,
          Money debe,
          Money haber) throws BaseException {
	  
	  dataset.append();
	  dataset.fieldValue("oid_resumen_contable", oidResumenContable);
	  dataset.fieldValue("oid_apertura_contable", oidAperturaContable);
	  dataset.fieldValue("oid_ana_con", cuenta.getOIDInteger());
	  dataset.fieldValue("cod_ana_con", cuenta.getCodigo());
	  dataset.fieldValue("desc_ana_con", cuenta.getDescripcion());
	  if (debe.doubleValue()!=0)
		  dataset.fieldValue("debe", debe);
	  else
		  dataset.fieldValue("debe", "");
	  if (haber.doubleValue()!=0)
		  dataset.fieldValue("haber", haber);
	  else
		  dataset.fieldValue("haber", "");

  }
  
	private void enviarAsientoResumen(IDataSet ds , ComproAperturaEjercicio comproAperturaEjercicio) throws BaseException {
		
		Iterator iterCuentas = 
			acumPorCuenta.keySet().iterator();
		while (iterCuentas.hasNext()) {
			
			Integer oidCuenta = (Integer) iterCuentas.next();
			ImporteDebeHaber importeDebeHaber = (ImporteDebeHaber) acumPorCuenta.get(oidCuenta);
			ImportesContables saldosContables = 
				importeDebeHaber.getSaldoImportesContables();
			
			Money debe = new Money(0);
			Money haber = new Money(0);
			
			if (importeDebeHaber.getSignoSaldo() == RenglonAsiento.DEBE) 
				debe = saldosContables.getImpoMonLoc();
			else 
				haber = saldosContables.getImpoMonLoc();
			
			cargarAsiento(ds,
					new Integer(++oid),
					comproAperturaEjercicio.getOIDInteger(),
					Cuenta.findByOid(oidCuenta, this.getSesion()),
					debe,haber);
					
		}
		
	}
	
  
  private void cargarRegistroAperturaEjercicio(IDataSet dataset,
                                               ComproAperturaEjercicio comproAperturaEjercicio) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_apertura_contable", comproAperturaEjercicio.getOIDInteger());
    dataset.fieldValue("oid_ejercicio", comproAperturaEjercicio.getEjercicio().getOIDInteger());
    dataset.fieldValue("cod_ejercicio", comproAperturaEjercicio.getEjercicio().getNroejer());
    dataset.fieldValue("desc_ejercicio", comproAperturaEjercicio.getEjercicio().getDescripcion());
    dataset.fieldValue("fec_emision", comproAperturaEjercicio.getEmision());
    dataset.fieldValue("fec_imputacion", comproAperturaEjercicio.getImputac());
    dataset.fieldValue("nro_ext", comproAperturaEjercicio.getNroExt());
    dataset.fieldValue("activo", comproAperturaEjercicio.isActivo());
    
  }


}
