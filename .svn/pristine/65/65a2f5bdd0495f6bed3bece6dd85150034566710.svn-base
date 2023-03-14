package com.srn.erp.turnos.bm;

import java.sql.Date;
import java.util.List;

import com.srn.erp.turnos.da.DBLogImpSujTurno;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class LogImpSujTurno extends ObjetoLogico { 

  @Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public LogImpSujTurno() { 
  }

  public static String NICKNAME = "tu.LogImpSujTurno";

  private String descripcion;
  private java.util.Date fecha;

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public java.util.Date getFecha() throws BaseException { 
    supportRefresh();
    return fecha;
  }

  public void setFecha(java.util.Date aFecha) { 
    this.fecha =  aFecha;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static LogImpSujTurno findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (LogImpSujTurno) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static LogImpSujTurno findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (LogImpSujTurno) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(fecha, "Debe ingresar la Fecha");
 }
 
 public static List getLogs(java.util.Date aFecha,
         ISesion aSesion) throws BaseException {
	  return DBLogImpSujTurno.getLogs(aFecha,aSesion);
 }
 
 public static void borrarLogs(java.util.Date aFecha,
         ISesion aSesion) throws BaseException {
            DBLogImpSujTurno.borrarLogs(aFecha,aSesion);
 }
 
 public static List getLogsUltimaCorrida(ISesion aSesion) throws BaseException {
	  return DBLogImpSujTurno.getLogsUltimaCorrida(aSesion);
 }
 
 
 
 

}
