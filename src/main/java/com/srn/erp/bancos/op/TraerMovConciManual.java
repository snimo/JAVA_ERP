package com.srn.erp.bancos.op;

import java.util.Iterator;

import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.MovimientoCtaBancaria;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMovConciManual extends Operation {

  private int oidConcDet = 0;	
  private Integer oidConciliacion = null;
	
  public TraerMovConciManual() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	Integer oidCuentaBancaria = mapaDatos.getInteger("oid_cta_bco");
  	oidConciliacion = mapaDatos.getInteger("oid_conciliacion");
  	IDataSet ds = this.getDataSetMovAConciliar();
  	
  	// Como Primer Movimiento enviar el saldo inicial
  	CuentaBancaria cuentaBancaria =
  		CuentaBancaria.findByOid(oidCuentaBancaria, this.getSesion());
  	
  	
  	cargarSaldoInicialReal(ds,cuentaBancaria);
  	cargarMovNoConciliados(ds,cuentaBancaria);
  	
  	writeCliente(ds);
  	
  	
  }
  
  private void cargarMovNoConciliados(IDataSet ds,CuentaBancaria cuentaBancaria) throws BaseException {
	  Iterator iterMovCtaBcoNoConc = 
		  cuentaBancaria.getMovCtaBancoNoConciliados().iterator();
	  while (iterMovCtaBcoNoConc.hasNext()) {
		  MovimientoCtaBancaria moviCtaBcoNoConc = (MovimientoCtaBancaria) iterMovCtaBcoNoConc.next();
		  
		  String codigo = "";
		  String descripcion = "";
		  
		  if (moviCtaBcoNoConc.getTipoValor()!=null) {
			  codigo = moviCtaBcoNoConc.getTipoValor().getCodigo();
			  descripcion = moviCtaBcoNoConc.getTipoValor().getDescripcion();
		  } else if (moviCtaBcoNoConc.getCuenta()!=null) {
			  codigo = moviCtaBcoNoConc.getCuenta().getCodigoCuentaMasCodigosValCompo();
			  descripcion = moviCtaBcoNoConc.getCuenta().getDescCuentaMasDescValCompo();			  
		  }
		  
		  cargarMovAConciliar(ds, 
				  new Integer(--oidConcDet), 
				  oidConciliacion, 
				  moviCtaBcoNoConc , 
				  codigo,
				  descripcion,
				  false);
  
	  }
  }
  
  private void cargarSaldoInicialReal(IDataSet ds,CuentaBancaria cuentaBancaria) throws BaseException {
	  
	  if (cuentaBancaria.getCuentaMovRealesBco() == null)
		  throw new ExceptionValidation(null,"Falta configurar la cuenta Banco para la cuenta bancaria "+
				  cuentaBancaria.getCodigo()+" "+cuentaBancaria.getDescripcion());
	  	  
	  // Obtener el Saldo de la contabilidad en la Misma Moneda la que la cuenta Bancaris
	  ImportesContables importesContables = 
		  cuentaBancaria.getCuentaMovRealesBco().getSaldo();

	  Money saldoInicial = null;
	  if (cuentaBancaria.getMoneda().getOID() == Moneda.getMonedaCursoLegal(this.getSesion()).getOID())
		  saldoInicial = importesContables.getImpoMonLoc();
	  else if (cuentaBancaria.getMoneda().getOID() == Moneda.getMonedaExt1(this.getSesion()).getOID())
		  saldoInicial = importesContables.getImpoMonExt1();
	  else if (cuentaBancaria.getMoneda().getOID() == Moneda.getMonedaExt2(this.getSesion()).getOID())
		  saldoInicial = importesContables.getImpoMonExt2();
	  else throw new ExceptionValidation(null,"No se encuentra soportada la moneda "+
			  cuentaBancaria.getMoneda().getDescripcion()+" para realizar conciliaciones.");
	  
	  // Simular un Movimiento Contable de Saldo Inicial
	  MovimientoCtaBancaria mov = (MovimientoCtaBancaria) MovimientoCtaBancaria.getNew(MovimientoCtaBancaria.NICKNAME, this.getSesion());
	  mov.setImporte(saldoInicial);
	  mov.setSigno(new Integer(1)); // Para que no cambio el signo dado que el saldo inicial viene con signo
	  mov.setFechaOperativa(Fecha.getFechaActual());
	  mov.setTipomov(MovimientoCtaBancaria.SALDO_INICIAL);
	  cargarMovAConciliar(ds, 
			  new Integer(--oidConcDet), 
			  oidConciliacion, 
			  mov , 
			  cuentaBancaria.getCuentaMovRealesBco().getCodigo(),
			  cuentaBancaria.getCuentaMovRealesBco().getDescripcion(),
			  true);
  }
  
  
  private void cargarMovAConciliar(
		  IDataSet ds,
		  Integer oidConciliacionDet,
		  Integer oidConciliacion,
		  MovimientoCtaBancaria mov,
		  String codConcepto,
		  String descConcepto,
		  Boolean esSaldoInicial) throws BaseException {
	  
  	ds.append();  	
  	ds.fieldValue("oid_conciliacion_det", new Integer(--oidConcDet));
  	ds.fieldValue("oid_conciliacion", oidConciliacion);
  	ds.fieldValue("conciliado", new Boolean(false));
  	ds.fieldValue("oid_mov_cta_bco", mov.getOIDInteger());
  	ds.fieldValue("fecha", mov.getFechaConciliacion());
  	ds.fieldValue("tipo_mov", mov.getTipomov());
  	ds.fieldValue("cod_concepto", codConcepto);
  	ds.fieldValue("desc_concepto", descConcepto);
  	if (mov.getNrovalor()!=null) {
  		if (mov.getNrovalor().intValue()==0)
  			ds.fieldValue("nro", "");
  		else
  			ds.fieldValue("nro", mov.getNrovalor());
  	}
  	else
  		ds.fieldValue("nro", "");
  	if (esSaldoInicial) {
  		ds.fieldValue("impo_contable", mov.getImportePorSigno());
  		ds.fieldValue("impo_extracto", mov.getImportePorSigno());
  	} else {
  	  	ds.fieldValue("impo_contable", mov.getImportePorSigno());
  	  	ds.fieldValue("impo_extracto", new Money(0));
  		
  	}
  	ds.fieldValue("es_saldo_inicial", esSaldoInicial);
  	
  }
  
  private IDataSet getDataSetMovAConciliar() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TConciliacionDet");
    dataset.fieldDef(new Field("oid_conciliacion_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conciliacion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("conciliado", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("oid_mov_cta_bco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("tipo_mov", Field.STRING, 50));
    dataset.fieldDef(new Field("cod_concepto", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_concepto", Field.STRING, 1000));
    dataset.fieldDef(new Field("nro", Field.STRING, 1000));
    dataset.fieldDef(new Field("impo_contable", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("impo_extracto", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("es_saldo_inicial", Field.BOOLEAN, 0));
    return dataset;
  }
  
  
}
