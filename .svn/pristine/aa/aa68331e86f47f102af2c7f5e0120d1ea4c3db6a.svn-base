package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class LogMensajeCIP extends ObjetoLogico { 

  public LogMensajeCIP() { 
  }

  public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public static String NICKNAME = "cip.LogMensajeCIP";

  private java.util.Date fec_hor;
  private Integer id_equipo;
  private String mensaje;
  private Boolean activo;

  public java.util.Date getFec_hor() throws BaseException { 
    supportRefresh();
    return fec_hor;
  }

  public void setFec_hor(java.util.Date aFec_hor) { 
    this.fec_hor =  aFec_hor;
  }

  public Integer getId_equipo() throws BaseException { 
    supportRefresh();
    return id_equipo;
  }

  public void setId_equipo(Integer aId_equipo) { 
    this.id_equipo =  aId_equipo;
  }

  public String getMensaje() throws BaseException { 
    supportRefresh();
    return mensaje;
  }

  public void setMensaje(String aMensaje) { 
    this.mensaje =  aMensaje;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static LogMensajeCIP findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (LogMensajeCIP) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static LogMensajeCIP findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (LogMensajeCIP) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }

}
