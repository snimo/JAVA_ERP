package com.srn.erp.excelReport.bm;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class DefFuncExcelCuentaTotalPeriodo extends DefFunExcel {

	public DefFuncExcelCuentaTotalPeriodo() {
		
		token = DefFunExcel.TOKEN_0001;
		nombreFuncion = "@Cuenta.TotalPeriodo";
		parametrosFuncion = "(Cuenta,Período,Moneda)";
		categFunc = CategFuncExcel.CTAS;
		nombreFormulario = "TFDefFuncExcel001";
		detalles = getDetalleFuncion();
		
	}
	
	private String getDetalleFuncion() {
		StringBuffer obs = new StringBuffer("");
		obs.append("Devuele el total de una cuenta contable para un período y moneda. ");
		obs.append(Util.ENTER());
		obs.append(Util.ENTER());
		obs.append("Cuenta: Es el código de la cuenta contable. Ejemplo: 101200 ");
		obs.append(Util.ENTER());
		obs.append("Período: Es el período mensual contable. Ejemplo: 2009.01 ");
		obs.append(Util.ENTER());
		obs.append("Moneda: Es el código de la moneda contable. Ejemplo: PES ");
		obs.append(Util.ENTER());
		return obs.toString();
	}
	
	public ResultFuncExcel execFunc(String params,ISesion aSesion) throws BaseException {
		
		String codCuenta = "";
		String codPeriodo = "";
		String codMoneda = "";
		
		ResultFuncExcel resultFuncExcel = new ResultFuncExcel();
		resultFuncExcel.setTipo(Field.CURRENCY);
		
		
		StringTokenizer st = new StringTokenizer(params, ";");
		int i=1;
		while (st.hasMoreTokens()) {
			String param = st.nextToken();
			if (i==1)
				codCuenta = param;
			else if (i==2)
				codPeriodo = param;
			else if (i==3)
				codMoneda = param;
			++i;
		}
		
		Cuenta cuenta = Cuenta.findByCodigo(codCuenta, aSesion);
		if (cuenta == null) return getResultError("Código de cuenta "+codCuenta+" inexistente.");
		
		Periodo periodo = Periodo.findByCodigo(codPeriodo, aSesion);
		if (periodo == null) return getResultError("Código de período "+codPeriodo+" inexistente.");
		
		Moneda moneda = Moneda.findByCodigo(codMoneda, aSesion);
		if (moneda == null) return getResultError("Código de moneda "+codMoneda+" inexistente.");
		
		ImportesContables importesContables =
			cuenta.getTotalPeriodo(periodo, null);
		
		if (Moneda.getMonedaCursoLegal(aSesion).getOID() == moneda.getOID())
			resultFuncExcel.setMoney(importesContables.getImpoMonLoc());
		else
			if (Moneda.getMonedaExt1(aSesion).getOID() == moneda.getOID())
				resultFuncExcel.setMoney(importesContables.getImpoMonExt1());			
			else
				if (Moneda.getMonedaExt2(aSesion).getOID() == moneda.getOID())
					resultFuncExcel.setMoney(importesContables.getImpoMonExt2());		
		
		return resultFuncExcel;
	}
	
 
	
	
	
	public List enviarDatosAltaFuncion(String funcion,ISesion aSesion) throws BaseException {
		
		Cuenta cuenta = null;
		String celdaCuenta = "";
		Periodo periodo = null;
		String celdaPeriodo = "";
		Moneda moneda = null;
		String celdaMoneda = "";
		
		List listaDataSets = new ArrayList();
		IDataSet dsFuncion = this.getDataSetDefFuncExcel();
		IDataSet dsCuentas = this.getDataSetCuenta();
		IDataSet dsPeriodo = this.getDataSetPeriodo();
		IDataSet dsMoneda  = this.getDataSetMoneda();

		String params = getParamsFuncion(funcion);
		StringTokenizer st = new StringTokenizer(params, ";");
		int i=1;
		while (st.hasMoreTokens()) {
			String param = st.nextToken();
			if (i==1) {
				cuenta = Cuenta.findByCodigo(param,aSesion);
				if (cuenta == null)
					celdaCuenta = param;
			}
			else if (i==2) {
				periodo = Periodo.findByCodigo(param,aSesion);
				if (periodo == null)
					celdaPeriodo = param;				
			}
			else if (i==3) {
				moneda = Moneda.findByCodigo(param,aSesion);
				if (moneda == null)
					celdaMoneda = param;				
			}
			++i;
		}		
		
		enviarDatosFuncion(dsFuncion);
		enviarDatosCuenta(dsCuentas,1,cuenta,celdaCuenta);
		enviarDatosPeriodo(dsPeriodo,1,periodo,celdaPeriodo);
		enviarDatosMoneda(dsMoneda,1,moneda,celdaMoneda);
		
		listaDataSets.add(dsFuncion);
		listaDataSets.add(dsCuentas);
		listaDataSets.add(dsPeriodo);
		listaDataSets.add(dsMoneda);
		
		return listaDataSets;
		
		
	}	
	
	private IDataSet getDataSetCuenta() {
		
		IDataSet dataset = new TDataSet(); 
		dataset.create("TCuenta");
		
		dataset.fieldDef(new Field("orden", Field.STRING, 50));
		dataset.fieldDef(new Field("celda", Field.STRING, 50));
		
		dataset.fieldDef(new Field("oid_cuenta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_cuenta", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_cuenta", Field.STRING, 100));
		
		return dataset;
	}
	
	private IDataSet getDataSetPeriodo() { 
		IDataSet dataset = new TDataSet(); 
		dataset.create("TPeriodo");
		dataset.fieldDef(new Field("orden", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_periodo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_periodo", Field.STRING, 50));
		dataset.fieldDef(new Field("celda", Field.STRING, 50));
		return dataset;
	}
	
	private IDataSet getDataSetMoneda() { 
		IDataSet dataset = new TDataSet(); 
		dataset.create("TMoneda");
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_moneda", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_moneda", Field.STRING, 100));
		dataset.fieldDef(new Field("celda", Field.STRING, 50));
		return dataset;
	}
	
	private void enviarDatosFuncion(IDataSet dsFuncion) throws BaseException {
		cargarRegistroFunc(dsFuncion,this);
	}
	
	private void enviarDatosMoneda(IDataSet dsMoneda,
			                       int orden,
			                       Moneda moneda,
			                       String celda) throws BaseException {
		dsMoneda.append();
		dsMoneda.fieldValue("orden", orden);
		if (moneda!=null) {
			dsMoneda.fieldValue("oid_moneda", moneda.getOIDInteger());
			dsMoneda.fieldValue("cod_moneda", moneda.getCodigo());
			dsMoneda.fieldValue("desc_moneda", moneda.getDescripcion());
		} else {
			dsMoneda.fieldValue("oid_moneda", "");
			dsMoneda.fieldValue("cod_moneda", "");
			dsMoneda.fieldValue("desc_moneda", "");
		}
		dsMoneda.fieldValue("celda", celda);
	}
	
	private void enviarDatosCuenta(IDataSet dsCuentas,
			                       int orden,
			                       Cuenta cuenta,
			                       String celda) throws BaseException {

		dsCuentas.append();
		dsCuentas.fieldValue("orden", orden);
		dsCuentas.fieldValue("celda", celda);
		
		if (cuenta!=null) {
			dsCuentas.fieldValue("oid_cuenta", cuenta.getOIDInteger());
			dsCuentas.fieldValue("cod_cuenta", cuenta.getCodigo());
			dsCuentas.fieldValue("desc_cuenta", cuenta.getDescripcion());
		} else {
			dsCuentas.fieldValue("oid_cuenta", "");
			dsCuentas.fieldValue("cod_cuenta", "");
			dsCuentas.fieldValue("desc_cuenta", "");
		}
		
		
	}
	
	private void enviarDatosPeriodo(IDataSet dsPeriodo,
			                        int orden,
			                        Periodo periodo,
			                        String celda) throws BaseException {

		dsPeriodo.append();
		dsPeriodo.fieldValue("orden", orden);
		if (periodo!=null) {
			dsPeriodo.fieldValue("oid_periodo", periodo.getOIDInteger());
			dsPeriodo.fieldValue("desc_periodo", periodo.getCodigo());
		} else {
			dsPeriodo.fieldValue("oid_periodo", "");
			dsPeriodo.fieldValue("desc_periodo", "");			
		}
		dsPeriodo.fieldValue("celda", celda);
		
	}
	
	
	
}
