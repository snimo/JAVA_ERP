package com.srn.erp.cip.bm;

import com.srn.erp.cip.da.DBNovedadGLMPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class NovedadGLMPayroll extends ObjetoLogico { 

  public NovedadGLMPayroll() { 
  }

  public static String NICKNAME = "cip.NovedadGLMPayroll";

  private String codigo;
  private java.util.Date fechaini;
  public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

private java.util.Date fechafin;
  private java.util.Date PROCONPE;
  private Boolean activo;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public java.util.Date getFechaini() throws BaseException { 
    supportRefresh();
    return fechaini;
  }

  public void setFechaini(java.util.Date aFechaini) { 
    this.fechaini =  aFechaini;
  }

  public java.util.Date getFechafin() throws BaseException { 
    supportRefresh();
    return fechafin;
  }

  public void setFechafin(java.util.Date aFechafin) { 
    this.fechafin =  aFechafin;
  }

  public java.util.Date getProconpe() throws BaseException { 
    supportRefresh();
    return PROCONPE;
  }

  public void setProconpe(java.util.Date aProconpe) { 
    this.PROCONPE =  aProconpe;
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

 public static NovedadGLMPayroll findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (NovedadGLMPayroll) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static NovedadGLMPayroll findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (NovedadGLMPayroll) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static void truncarTablaNovedades(ISesion aSesion)
 throws BaseException {
 		DBNovedadGLMPayroll.truncarTablaNovedades(aSesion);
 }
 

}
