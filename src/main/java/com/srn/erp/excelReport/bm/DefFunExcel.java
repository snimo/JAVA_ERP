package com.srn.erp.excelReport.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class DefFunExcel {
	
	public static final String TOKEN_0001 = "@Cuenta.TotalPeriodo";
	private ISesion sesion;
	
	public  DefFunExcel() {
	}
	
	public ISesion getSesion() {
		return sesion;
	}
	
	public void setSesion(ISesion aSesion) {
		sesion = aSesion;
	}
	
	
	public static List getListaTokens() {
		List listaTokes = new ArrayList();
		listaTokes.add(TOKEN_0001);
		return listaTokes;
		
	}
	
	public static DefFunExcel create(String token) {
		if (token.equals(TOKEN_0001))
			return new DefFuncExcelCuentaTotalPeriodo();
		return null;
	}
	
	public static HashTableDatos getFuncionesByCategoria(String categoria) throws BaseException {
		HashTableDatos funciones = new HashTableDatos();
		Iterator iterTokens = 
			getListaTokens().iterator();
		while (iterTokens.hasNext()) {
			String token = (String) iterTokens.next();
			DefFunExcel defFunc = DefFunExcel.create(token);
			if (defFunc.getCategFunc().equals(categoria))
				funciones.put(token, defFunc);
		}
		return funciones;
	}
	
	public static HashTableDatos getAllFunciones() throws BaseException {
		HashTableDatos funciones = new HashTableDatos();
		Iterator iterTokens = 
			getListaTokens().iterator();
		while (iterTokens.hasNext()) {
			String token = (String) iterTokens.next();
			DefFunExcel defFunc = DefFunExcel.create(token);
			funciones.put(token, defFunc);
		}
		return funciones;
	}
	
	
	String token = "";
	String nombreFuncion = "";
	String parametrosFuncion = "";
	String detalles = "";
	String categFunc = "";
	String nombreFormulario = "";
	
	public String getCategFunc() {
		return categFunc;
	}

	public void setCategFunc(String categFunc) {
		this.categFunc = categFunc;
	}
	
	public String getNombreFormulario() {
		return nombreFormulario;
	}

	public void setNombreFormulario(String aNombreFormulario) {
		this.nombreFormulario = aNombreFormulario;
	}
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNombreFuncion() {
		return nombreFuncion;
	}

	public void setNombreFuncion(String nombreFuncion) {
		this.nombreFuncion = nombreFuncion;
	}

	public String getParametrosFuncion() {
		return parametrosFuncion;
	}

	public void setParametrosFuncion(String parametrosFuncion) {
		this.parametrosFuncion = parametrosFuncion;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
	public String getNombreFuncionyArgumentos() {
		return this.getNombreFuncion()+" "+this.getParametrosFuncion();
	}
	
	public List enviarDatosAltaFuncion(String funcion,ISesion aSesion) throws BaseException {
		return null;
	}
	
	protected IDataSet getDataSetDefFuncExcel() { 
		IDataSet dataset = new TDataSet(); 
		dataset.create("TFuncRepo");
		dataset.fieldDef(new Field("token_funcion", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_funcion", Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_y_argumentos", Field.STRING, 1000));
		dataset.fieldDef(new Field("detalle", Field.MEMO, 0));
		dataset.fieldDef(new Field("nombre_formulario", Field.STRING, 100));
		return dataset;
	}
	
	protected void cargarDataSets() throws BaseException {
		
	}
	
	protected void cargarRegistroFunc(IDataSet dataset, 
				  DefFunExcel defFuncion) throws BaseException {
		  dataset.append(); 
		  dataset.fieldValue("token_funcion", defFuncion.getToken());
		  dataset.fieldValue("nombre_funcion", defFuncion.getNombreFuncion());
		  dataset.fieldValue("nombre_y_argumentos", defFuncion.getNombreFuncionyArgumentos());
		  dataset.fieldValue("detalle", defFuncion.getDetalles());   
		  dataset.fieldValue("nombre_formulario", defFuncion.getNombreFormulario());
	}
	
	public static String getTokenFuncion(String funcion) throws BaseException {
		StringBuffer tokenFuncion = new StringBuffer("");
		for (int i = 0;i<funcion.length();++i) {
			if (funcion.charAt(i)=='(') break;
			tokenFuncion.append(funcion.charAt(i));
		}
		return tokenFuncion.toString();
	}
	
	public static String getParamsFuncion(String funcion) throws BaseException {
		
		String token = getTokenFuncion(funcion);
		funcion = funcion.replaceAll(token, "");
		funcion = funcion.replaceAll("\\(", "");
		funcion = funcion.replaceAll("\\)", "");
		return funcion;
	}
	
	public ResultFuncExcel execFunc(String params,ISesion aSesion) throws BaseException {
		return null;
	}
	
	protected ResultFuncExcel getResultError(String mensaje) {
		ResultFuncExcel result = new ResultFuncExcel();
		result.setTipo(Field.STRING);
		result.setResult(mensaje);
		return result;
	}
	
	
	
	
	
}
