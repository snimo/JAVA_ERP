package com.srn.erp.ctasAPagar.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ConsultaMovCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ConsultaMovCtaCteProv.ConsMovCtaCte;
import com.srn.erp.ctasAPagar.bm.ConsultaMovCtaCteProv.SaldosPorMoneda;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMovCtaCteProv extends Operation {

  HashTableDatos monedas = null;	
	
  public TraerMovCtaCteProv() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	Proveedor proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"),getSesion());
	Date fechaDesde = mapaDatos.getDate("fecha_desde");
	Date fechaHasta = mapaDatos.getDate("fecha_hasta");
	
	ConsultaMovCtaCteProv consMov = new ConsultaMovCtaCteProv(getSesion());
	consMov.setProveedor(proveedor);
	consMov.setFechaDesde(fechaDesde);
	consMov.setFechaHasta(fechaHasta);
	consMov.ejecutarConsulta();
		
	IDataSet datasetResumen = getDataSetResumen();
    IDataSet datasetMovimientos = getDataSetMovimientos();
    
    Iterator iterResumen = consMov.getSaldosResumenes().iterator();
    while (iterResumen.hasNext()) {
    	SaldosPorMoneda saldoPorMoneda = (SaldosPorMoneda) iterResumen.next();
    	cargarRegistroResumen(datasetResumen,
    			              saldoPorMoneda.getMoneda().getOIDInteger(),
    			              saldoPorMoneda.getMoneda().getDescripcion(),
    			              saldoPorMoneda.getSaldoInicial(),
    			              saldoPorMoneda.getMovimientos(),
    			              saldoPorMoneda.getSaldoFinal());
    }
    
    Iterator iterMovimientos = consMov.getMovimientos().iterator();
    while (iterMovimientos.hasNext()) {
    	ConsMovCtaCte consMovCtaCte = (ConsMovCtaCte) iterMovimientos.next();
    	cargarRegistroMovimiento(datasetMovimientos,
    							 consMovCtaCte.secu,
    							 consMovCtaCte.orden,
    							 consMovCtaCte.oid_cco_tran_vto,
    							 consMovCtaCte.codigo_cco_tran_vto,
    							 consMovCtaCte.oid_cco_aplic,
    							 consMovCtaCte.codigo_cco_aplic,
    							 consMovCtaCte.oid_cco_aplic_aux,
    							 consMovCtaCte.codigo_cco_aplic_aux,
    							 consMovCtaCte.imputacion,
    							 consMovCtaCte.emision,
    							 consMovCtaCte.importe,
    							 consMovCtaCte.saldo,
    							 consMovCtaCte.oidMoneda,
    							 consMovCtaCte.oidTipoCtaCte,
    							 consMovCtaCte.vto,
    							 getMoneda(consMovCtaCte.oidMoneda).getDescripcion(),
    							 consMovCtaCte.allowDesaplicar,
    							 consMovCtaCte.oidCCO
    							 );
    }

    writeCliente(datasetResumen);
    writeCliente(datasetMovimientos);

  }

  private IDataSet getDataSetResumen() {
    IDataSet dataset = new TDataSet();
    dataset.create("TResumenConsMovCtaCteProv");
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_moneda",Field.STRING, 50));
    dataset.fieldDef(new Field("saldo_inicial",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("movimientos",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("saldo_final",Field.CURRENCY, 0));
    return dataset;
  }

  private IDataSet getDataSetMovimientos() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConsMovCtaCteProv");
    dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
    dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco_tran_vto",Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_cco_tran_vto",Field.STRING, 50));
    dataset.fieldDef(new Field("oid_cco_aplic",Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_cco_aplic",Field.STRING, 50));
    dataset.fieldDef(new Field("oid_cco_aplic_aux",Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo_cco_aplic_aux",Field.STRING, 50));
    dataset.fieldDef(new Field("imputacion",Field.DATE, 0));
    dataset.fieldDef(new Field("emision",Field.DATE, 0));
    dataset.fieldDef(new Field("importe",Field.CURRENCY,0));
    dataset.fieldDef(new Field("saldo",Field.CURRENCY,0));
    dataset.fieldDef(new Field("oid_moneda",Field.INTEGER,0));
    dataset.fieldDef(new Field("oid_tipo_cta",Field.INTEGER,0));
    dataset.fieldDef(new Field("vto",Field.DATE,0));
    dataset.fieldDef(new Field("cod_moneda",Field.STRING,50));
    dataset.fieldDef(new Field("allow_desaplicar",Field.BOOLEAN,0));
    dataset.fieldDef(new Field("oid_cco",Field.INTEGER,0));
    return dataset;
  }

  private void cargarRegistroResumen(IDataSet dataset,
		  		Integer oidMoneda,
		  		String descMoneda,
		  		Money saldoInicial,
		  		Money movimientos,
		  		Money saldoFinal) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_moneda", oidMoneda);
    dataset.fieldValue("desc_moneda", descMoneda);
    
    dataset.fieldValue("saldo_inicial", invertirSigno(saldoInicial));
    dataset.fieldValue("movimientos", invertirSigno(movimientos));
    dataset.fieldValue("saldo_final", invertirSigno(saldoFinal));
  }

  private void cargarRegistroMovimiento(IDataSet dataset,
                         Integer secu,
                         Integer orden,
                         Integer oid_cco_tran_vto,
                         String codigo_cco_tran_vto,
                         Integer oid_cco_aplic,
                         String codigo_cco_aplic,
                         Integer oid_cco_aplic_aux,
                         String codigo_cco_aplic_aux,
                         Date imputacion,
                         Date emision,
                         Money importe,
                         Money saldo,
                         Integer oidMoneda,
                         Integer oidTipoCta,
                         Date vto,
                         String codMoneda,
                         Boolean allowDesaplicar,
                         Integer oidCCO) throws BaseException {
    dataset.append();
    dataset.fieldValue("secu", secu);
    dataset.fieldValue("orden",orden);
    dataset.fieldValue("oid_cco_tran_vto",oid_cco_tran_vto);
    dataset.fieldValue("codigo_cco_tran_vto", codigo_cco_tran_vto);
    dataset.fieldValue("oid_cco_aplic", oid_cco_aplic);
    dataset.fieldValue("codigo_cco_aplic", codigo_cco_aplic);
    dataset.fieldValue("oid_cco_aplic_aux", oid_cco_aplic_aux);
    dataset.fieldValue("codigo_cco_aplic_aux", codigo_cco_aplic_aux);
    dataset.fieldValue("imputacion", imputacion);
    dataset.fieldValue("emision", emision);
    dataset.fieldValue("importe",invertirSigno(importe));
    dataset.fieldValue("saldo",invertirSigno(saldo));
    dataset.fieldValue("oid_moneda",oidMoneda);
    dataset.fieldValue("oid_tipo_cta",oidTipoCta);
    dataset.fieldValue("vto",vto);
    dataset.fieldValue("cod_moneda",codMoneda);
    dataset.fieldValue("allow_desaplicar",allowDesaplicar);
    dataset.fieldValue("oid_cco",oidCCO);
  }
  
  private Money invertirSigno(Money importe) throws BaseException {
	    CalculadorMoney calcInvSigno = new CalculadorMoney(importe);
	    calcInvSigno.multiplicarPor(new Money(-1));
	    return calcInvSigno.getResultMoney();
  }
  
  private Moneda getMoneda(Integer oidMoneda) throws BaseException {

	  if (monedas == null) {
		  monedas = new HashTableDatos();
		  Iterator iterMonedas = Moneda.getAll(this.getSesion()).iterator();
		  while (iterMonedas.hasNext()) {
			  Moneda moneda = (Moneda) iterMonedas.next();
			  monedas.put(moneda.getOIDInteger(), moneda);
		  }
	  }
	  return (Moneda)monedas.get(oidMoneda);
  }




}
