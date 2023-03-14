package com.srn.erp.ctasACobrar.op;

import java.util.Date;
import java.util.Iterator;

import com.srn.erp.ctasACobrar.bm.ConsultaMovCtaCteClie;
import com.srn.erp.ctasACobrar.bm.ConsultaMovCtaCteClie.ConsMovCtaCte;
import com.srn.erp.ctasACobrar.bm.ConsultaMovCtaCteClie.SaldosPorMoneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerMovCtaCteClie extends Operation {

  public TraerMovCtaCteClie() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

	Sujeto sujeto = Sujeto.findByOidProxy(mapaDatos.getInteger("oid_sujeto"),getSesion());
	Date fechaDesde = mapaDatos.getDate("fecha_desde");
	Date fechaHasta = mapaDatos.getDate("fecha_hasta");
	
	ConsultaMovCtaCteClie consMov = new ConsultaMovCtaCteClie(getSesion());
	consMov.setSujeto(sujeto);
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
    							 consMovCtaCte.vto
    							 );
    }

    writeCliente(datasetResumen);
    writeCliente(datasetMovimientos);

  }

  private IDataSet getDataSetResumen() {
    IDataSet dataset = new TDataSet();
    dataset.create("TResumenConsMovCtaCteClie");
    dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_moneda",Field.STRING, 50));
    dataset.fieldDef(new Field("saldo_inicial",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("movimientos",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("saldo_final",Field.CURRENCY, 0));
    return dataset;
  }

  private IDataSet getDataSetMovimientos() {
    IDataSet dataset = new TDataSet();
    dataset.create("TConsMovCtaCteClie");
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
    return dataset;
  }

  private void cargarRegistroResumen(IDataSet dataset,
		  		Integer oidMoneda,
		  		String descMoneda,
		  		Money saldoInicial,
		  		Money movimientos,
		  		Money saldoFinal) {
    dataset.append();
    dataset.fieldValue("oid_moneda", oidMoneda);
    dataset.fieldValue("desc_moneda", descMoneda);
    dataset.fieldValue("saldo_inicial", saldoInicial);
    dataset.fieldValue("movimientos", movimientos);
    dataset.fieldValue("saldo_final", saldoFinal);
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
                         Date vto) throws BaseException {
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
    dataset.fieldValue("importe",importe);
    dataset.fieldValue("saldo",saldo);
    dataset.fieldValue("oid_moneda",oidMoneda);
    dataset.fieldValue("oid_tipo_cta",oidTipoCta);
    dataset.fieldValue("vto",vto);
  }




}
