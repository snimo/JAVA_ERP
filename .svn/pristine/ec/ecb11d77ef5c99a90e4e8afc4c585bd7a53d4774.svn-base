package com.srn.erp.legales.op;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCalcIntJuicio extends Operation {

	public TraerCalcIntJuicio() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		Money capital = mapaDatos.getMoney("capital");
		
		IDataSet dsCalcInteres = mapaDatos.getDataSet("TEnviarTCalcInteres");
		IDataSet dsRespuesta = this.getDataSetCalcInt();
		 
		dsCalcInteres.first();
		while (!dsCalcInteres.EOF()) {
			
			java.util.Date fecDesde = dsCalcInteres.getDate("fec_desde");  
			java.util.Date fecHasta = dsCalcInteres.getDate("fec_hasta");
			String tipoTasa = dsCalcInteres.getString("tipo_tasa");
			Money porc = dsCalcInteres.getMoney("porc");
			
			int diasInteres = 0;
			if (tipoTasa.equals("ANUAL"))
				diasInteres = ValorParametro.findByCodigoParametro("DIAS_INTERES_ANUAL_JUICIOS", this.getSesion()).getValorEntero().intValue();
			else
				diasInteres = ValorParametro.findByCodigoParametro("DIAS_INTERES_MENSUAL_JUICIOS", this.getSesion()).getValorEntero().intValue();
			
			
			Money interes = getCalcularInteresAnual(fecDesde,fecHasta,capital,porc,diasInteres);
			
			cargarRegistroAbogado(dsRespuesta, dsCalcInteres.getInteger("oid_calc_int") , interes);
			
			
			dsCalcInteres.next();
		}
		writeCliente(dsRespuesta);
		
	}
	
	private Money getCalcularInteresAnual(java.util.Date fecDesde , java.util.Date fecHasta , Money capital , Money porc , int diasInteres) {
		int dias = Fecha.fechasDiferenciaEnDias(fecDesde, fecHasta)+1;
		
		CalculadorMoney calcNumerador = new CalculadorMoney(capital);
		calcNumerador.multiplicarPor(porc);
		calcNumerador.multiplicarPor(new Money(dias));
		
		CalculadorMoney calcDenominador = new CalculadorMoney(new Money(diasInteres));
		calcDenominador.multiplicarPor(new Money(100));
		
		CalculadorMoney calcInteres = new CalculadorMoney(calcNumerador.getResultMoney());
		calcInteres.dividirPor(calcDenominador.getResultMoney());
		
		return calcInteres.getResultMoney();
	}

	private IDataSet getDataSetCalcInt() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRespCalcInt");
		dataset.fieldDef(new Field("oid_calc_int", Field.INTEGER, 0));
		dataset.fieldDef(new Field("interes", Field.CURRENCY, 50));
		return dataset;
	}

	private void cargarRegistroAbogado(IDataSet dataset, Integer oid, Money interes) {
		dataset.append();
		dataset.fieldValue("oid_calc_int", oid);
		dataset.fieldValue("interes", interes);
	}
}
