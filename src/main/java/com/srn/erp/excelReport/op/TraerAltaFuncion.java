package com.srn.erp.excelReport.op;

import java.util.Iterator;

import com.srn.erp.excelReport.bm.DefFunExcel;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class TraerAltaFuncion extends Operation { 

  public TraerAltaFuncion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  
	String tokenFuncion = mapaDatos.getString("token_funcion");
	String funcion = mapaDatos.getString("funcion");
	
	DefFunExcel defFuncExcel = DefFunExcel.create(tokenFuncion);
	Iterator iterListaDataSets = 
		defFuncExcel.enviarDatosAltaFuncion(funcion,this.getSesion()).iterator();
	while (iterListaDataSets.hasNext()) {
		IDataSet ds = (IDataSet) iterListaDataSets.next();
		writeCliente(ds);
	}
	
  }

}
