package com.srn.erp.contabilidad.op;

import java.util.Iterator;
import java.util.List;

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

public class TraerCierreEjercicio extends Operation {
	
  HashTableDatos acumPorCuenta = new HashTableDatos();
  private int oid = 0;

  public TraerCierreEjercicio() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet dsComproCierre = this.getDataSetCierreEjercicio();
	  IDataSet dsAsiento = this.getDataSetAsiento();
	  
	  ComproCierreEjercicio comproCierreEjercicio = 
		  ComproCierreEjercicio.findByOid(mapaDatos.getInteger("oid"), this.getSesion());
	  cargarRegistroCierreEjercicio(dsComproCierre, comproCierreEjercicio);
	  
	  List listaDetalles = ComproContaDet.getDetallesByComproConta(comproCierreEjercicio.getComproConta(),
		getSesion());
	  
	  Iterator iterDetalles = listaDetalles.iterator();
	  while (iterDetalles.hasNext()) {
		  ComproContaDet comproContaDet = (ComproContaDet) iterDetalles.next();
		  acumularComproContaDetPorCuenta(comproContaDet);
	  }
	  
	  enviarAsientoResumen(dsAsiento,comproCierreEjercicio);
	  
	  writeCliente(dsComproCierre);
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
  

  private IDataSet getDataSetCierreEjercicio() {
    IDataSet dataset = new TDataSet();
    dataset.create("TCierreContable");
    dataset.fieldDef(new Field("oid_cierre_contable", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_ejercicio", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_ejercicio", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_ejercicio", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_imputacion", Field.DATE, 0));
    dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("cierre_de", Field.STRING, 10));
    return dataset;
  }
  
  private IDataSet getDataSetAsiento() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TResumenContableDet");
	    dataset.fieldDef(new Field("oid_resumen_contable", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_cierre_contable", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_ana_con",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_ana_con",Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_ana_con",Field.STRING, 255));
	    dataset.fieldDef(new Field("debe",Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("haber",Field.CURRENCY, 0));
	    return dataset;
  }
  
  private void cargarAsiento(IDataSet dataset,
          Integer oidResumenContable,
          Integer oidCierreContable,
          Cuenta cuenta,
          Money debe,
          Money haber) throws BaseException {
	  
	  dataset.append();
	  dataset.fieldValue("oid_resumen_contable", oidResumenContable);
	  dataset.fieldValue("oid_cierre_contable", oidCierreContable);
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
  
	private void enviarAsientoResumen(IDataSet ds , ComproCierreEjercicio comproCierreEjercicio) throws BaseException {
		
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
					comproCierreEjercicio.getOIDInteger(),
					Cuenta.findByOid(oidCuenta, this.getSesion()),
					debe,haber);
					
		}
		
	}
	
  
  private void cargarRegistroCierreEjercicio(IDataSet dataset,
                                             ComproCierreEjercicio comproCierreEjercicio) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_cierre_contable", comproCierreEjercicio.getOIDInteger());
    dataset.fieldValue("oid_ejercicio", comproCierreEjercicio.getEjercicio().getOIDInteger());
    dataset.fieldValue("cod_ejercicio", comproCierreEjercicio.getEjercicio().getNroejer());
    dataset.fieldValue("desc_ejercicio", comproCierreEjercicio.getEjercicio().getDescripcion());
    dataset.fieldValue("fec_emision", comproCierreEjercicio.getEmision());
    dataset.fieldValue("fec_imputacion", comproCierreEjercicio.getImputac());
    dataset.fieldValue("nro_ext", comproCierreEjercicio.getNroExt());
    dataset.fieldValue("activo", comproCierreEjercicio.isActivo());
    dataset.fieldValue("cierre_de", comproCierreEjercicio.getCierreDe());
    
  }


}
