package com.srn.erp.general.op;

import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarAutorizPorClave extends Operation { 

  public ValidarAutorizPorClave() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	String parametro = mapaDatos.getString("parametro");
  	String claveIngresada = mapaDatos.getString("clave");
  	
    String clave =
    	ValorParametro.findByCodigoParametro(parametro,this.getSesion()).getValorCadena();
    
    IDataSet ds = getDS();
    if (claveIngresada.equals(clave))
    	cargarRegistro(ds,true);
    else
    	cargarRegistro(ds,false);
    writeCliente(ds);
  }

  private IDataSet getDS() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TValidarClave");
    dataset.fieldDef(new Field("validacion_ok", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         boolean validacionOK) {
    dataset.append(); 
    dataset.fieldValue("validacion_ok", new Boolean(validacionOK));
  }
}
