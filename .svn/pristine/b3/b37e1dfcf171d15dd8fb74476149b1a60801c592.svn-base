package com.srn.erp.general.op;

import com.srn.erp.implementacion.bm.TablaGeneral;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class EjecutarSQL extends Operation {

  public EjecutarSQL() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  	String str = mapaDatos.getString("sentencias");  
	  	String[] sentencia;  
	  	String delimeter = ";";  
	  	sentencia = str.split(delimeter); 
	  	for(int i =0; i < sentencia.length ; i++) {
	  		TablaGeneral.ejecutarSQL(sentencia[i], this.getSesion()); 	  
	  	}

  }


}
