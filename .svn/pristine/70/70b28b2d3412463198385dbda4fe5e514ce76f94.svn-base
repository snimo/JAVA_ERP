package com.srn.erp.ventas.op;

import com.srn.erp.ventas.bm.LogImpresoraFiscal;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveLogImpresoraFiscal extends Operation {

  public SaveLogImpresoraFiscal() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	Integer nroImpresion = mapaDatos.getInteger("nro_impresion");
  	String  linea = mapaDatos.getString("linea");
  	Integer error = mapaDatos.getInteger("error");

  	LogImpresoraFiscal logImpresoraFiscal = 
  		(LogImpresoraFiscal)LogImpresoraFiscal.getNew(LogImpresoraFiscal.NICKNAME,this.getSesion());
  	logImpresoraFiscal.setOID(new Integer(0));
  	logImpresoraFiscal.setNro_impresion(nroImpresion);
  	logImpresoraFiscal.setFecha(Fecha.getFechaActual());
  	logImpresoraFiscal.setHora(Fecha.getHoraActualConSeg());
  	logImpresoraFiscal.setOid_usuario(this.getSesion().getLogin().getUsuario().getOIDInteger());
  	logImpresoraFiscal.setLinea(linea);
  	logImpresoraFiscal.setNro_error(error);
  	logImpresoraFiscal.setOid_sucursal(this.getSesion().getLogin().getOidSucursal());
  	
  	this.addTransaccion(logImpresoraFiscal);
  	
  }

}
