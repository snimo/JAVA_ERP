package com.srn.erp.bancos.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.MovimientoCtaBancaria;
import com.srn.erp.tesoreria.bm.SaldoCuentaBanco;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMoviCtaBco extends Operation {

	Money saldoFinal   = new Money(0);
	Money saldoInicial = new Money(0);
	Money debitos      = new Money(0);
	Money creditos     = new Money(0);
	
	CalculadorMoney calcDebitos  = new CalculadorMoney(new Money(0));
	CalculadorMoney calcCreditos = new CalculadorMoney(new Money(0));
	
  public TraerMoviCtaBco() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	CuentaBancaria cuentaBancaria = CuentaBancaria.findByOidProxy(mapaDatos.getInteger("oid_cta_bco"),getSesion());
  	Date fechaDesde               = mapaDatos.getDate("fecDesde");
  	Date fechaHasta               = mapaDatos.getDate("fecHasta");
  	String tipoSaldo              = mapaDatos.getString("tipoSaldo");
  	Iterator iterMoviCta          = null;
  	
  	IDataSet dsMovCtaBco          = getDataSetMovCtaBanco();
  	IDataSet dsResumen            = getDataSetResumen();
  	
  	SaldoCuentaBanco saldoCuentaBanco = null; 
  		  	
  	if (tipoSaldo.equals("CONT")) {
  		iterMoviCta = MovimientoCtaBancaria.getMovCtaBancoContable(cuentaBancaria,fechaDesde,fechaHasta,getSesion()).iterator();
  		saldoCuentaBanco = SaldoCuentaBanco.getSaldoInicialContableAFecha(fechaDesde,cuentaBancaria,getSesion());
  	}
  	else {
  		iterMoviCta = MovimientoCtaBancaria.getMovCtaBancoOperativos(cuentaBancaria,fechaDesde,fechaHasta,getSesion()).iterator();
  		saldoCuentaBanco = SaldoCuentaBanco.getSaldoInicialOperativoAFecha(fechaDesde,cuentaBancaria,getSesion());
  	}
  	
  	if (saldoCuentaBanco!=null)
 		 saldoInicial = saldoCuentaBanco.getSaldo();
  	
  	
  	// Recorrer los movimientos del Banco 
  	while (iterMoviCta.hasNext()) {
  		MovimientoCtaBancaria moviCta = (MovimientoCtaBancaria) iterMoviCta.next();
  		if (moviCta.getSigno().intValue()==1)
  			calcDebitos.sumar(moviCta.getImporte());
  		else
  			calcCreditos.sumar(moviCta.getImporte());
  		cargarRegistroMovCtaBancaria(dsMovCtaBco,moviCta,tipoSaldo);
  	}
  	
  	// Calcular el Saldo Final
  	debitos  = calcDebitos.getResultMoney();
  	creditos = calcCreditos.getResultMoney();
  	
   	CalculadorMoney calcSaldoFinal = new CalculadorMoney(this.saldoInicial);
  	calcSaldoFinal.sumar(this.debitos);
  	calcSaldoFinal.restar(this.creditos);
  	saldoFinal = calcSaldoFinal.getResultMoney(); 
  	
  	cargarRegistroResumen(dsResumen,new Integer(1),cuentaBancaria.getMoneda().getDescripcion(),saldoInicial,saldoFinal,debitos,creditos);
  	
  	writeCliente(dsMovCtaBco);
  	writeCliente(dsResumen);
  	
  }

  private IDataSet getDataSetMovCtaBanco() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConsMovCtaCteBanco");
    dataset.fieldDef(new Field("oid_mov_cta_banco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
    dataset.fieldDef(new Field("fecha", Field.DATE, 0));
    dataset.fieldDef(new Field("tipo_mov",Field.STRING,20));
    dataset.fieldDef(new Field("nro_cheque",Field.INTEGER,0));
    dataset.fieldDef(new Field("debito",Field.CURRENCY,0));
    dataset.fieldDef(new Field("credito",Field.CURRENCY,0));
    dataset.fieldDef(new Field("tipo_valor",Field.STRING,100));
    dataset.fieldDef(new Field("oid_ai",Field.INTEGER,0));
    dataset.fieldDef(new Field("cod_ai",Field.STRING,100));
    dataset.fieldDef(new Field("desc_ai",Field.STRING,255));
    return dataset;
  }
  
  private IDataSet getDataSetResumen() {
    IDataSet dataset = new TDataSet();
    dataset.create("TResumenCtaBanco");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
    dataset.fieldDef(new Field("moneda", Field.STRING, 20));
    dataset.fieldDef(new Field("saldo_inicial", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("saldo_final", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("debitos",Field.CURRENCY,0));
    dataset.fieldDef(new Field("creditos",Field.CURRENCY,0));
    return dataset;
  }
  

  private void cargarRegistroMovCtaBancaria(IDataSet dataset,
                         MovimientoCtaBancaria movCtaBancaria,
                         String tipoSaldo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_mov_cta_banco", movCtaBancaria.getOIDInteger());
    dataset.fieldValue("oid_cco", movCtaBancaria.getComprobante().getOIDInteger());
    dataset.fieldValue("comprobante", movCtaBancaria.getComprobante().getCodigo());
    if (tipoSaldo.equals("CONT")) 
    	dataset.fieldValue("fecha", movCtaBancaria.getFechacontable());
    else
    	dataset.fieldValue("fecha", movCtaBancaria.getFechaOperativa());
    dataset.fieldValue("tipo_mov",MovimientoCtaBancaria.getDescTipoMov(movCtaBancaria.getTipomov()));
    dataset.fieldValue("nro_cheque",movCtaBancaria.getNrovalor());
    if (movCtaBancaria.getSigno().intValue() == 1) {
    	dataset.fieldValue("debito",movCtaBancaria.getImporte());
      dataset.fieldValue("credito",new Money(0));
    }
    else {
    	dataset.fieldValue("credito",movCtaBancaria.getImporte());
      dataset.fieldValue("debito",new Money(0));
    }
    if (movCtaBancaria.getTipoValor()!=null)
    	dataset.fieldValue("tipo_valor", movCtaBancaria.getTipoValor().getDescripcion());
    else {
    	dataset.fieldValue("tipo_valor", "");
    }
    
    if (movCtaBancaria.getCuenta()!=null) {
      dataset.fieldValue("oid_ai", movCtaBancaria.getCuenta().getOIDInteger());
      dataset.fieldValue("cod_ai", movCtaBancaria.getCuenta().getCodigoCuentaMasCodigosValCompo());
      dataset.fieldValue("desc_ai",movCtaBancaria.getCuenta().getDescCuentaMasDescValCompo());
    } else {
      dataset.fieldValue("oid_ai", new Integer(0));
      dataset.fieldValue("cod_ai", "");
      dataset.fieldValue("desc_ai","");
    }
    
    
  }
  
  public void cargarRegistroResumen(IDataSet dataset,
  															    Integer oid,
  															    String moneda,
  															    Money saldoInicial,
  															    Money saldoFinal,
  															    Money debitos,
  															    Money creditos) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("moneda", moneda);
    dataset.fieldValue("saldo_inicial", saldoInicial);
    dataset.fieldValue("saldo_final", saldoFinal);
    dataset.fieldValue("debitos",debitos);
    dataset.fieldValue("creditos",creditos);    
  }
  
}
