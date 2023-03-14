package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBLogSincroExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class LogSincroExcluido extends ObjetoLogico { 

  public LogSincroExcluido() { 
  }

  public static String NICKNAME = "exc.LogSincroExcluido";

  public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

private DispMovilExc disp_movil;
  private java.util.Date fecha;
  private String hora;
  private GrupoImportacionExcluido grupo_imp_exc;
  private Integer nro_lote;
  private Boolean activo;

  public DispMovilExc getDisp_movil() throws BaseException { 
    supportRefresh();
    return disp_movil;
  }

  public void setDisp_movil(DispMovilExc aDisp_movil) { 
    this.disp_movil =  aDisp_movil;
  }

  public java.util.Date getFecha() throws BaseException { 
    supportRefresh();
    return fecha;
  }

  public void setFecha(java.util.Date aFecha) { 
    this.fecha =  aFecha;
  }

  public String getHora() throws BaseException { 
    supportRefresh();
    return hora;
  }

  public void setHora(String aHora) { 
    this.hora =  aHora;
  }

  public GrupoImportacionExcluido getGrupo_imp_exc() throws BaseException { 
    supportRefresh();
    return grupo_imp_exc;
  }

  public void setGrupo_imp_exc(GrupoImportacionExcluido aGrupo_imp_exc) { 
    this.grupo_imp_exc =  aGrupo_imp_exc;
  }

  public Integer getNro_lote() throws BaseException { 
    supportRefresh();
    return nro_lote;
  }

  public void setNro_lote(Integer aNro_lote) { 
    this.nro_lote =  aNro_lote;
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

 public static LogSincroExcluido findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (LogSincroExcluido) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static LogSincroExcluido findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (LogSincroExcluido) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(disp_movil, "Debe ingresar el Dispositivo Móvil");
    Validar.noNulo(fecha, "Debe ingresar la Fecha");
    Validar.noNulo(hora, "Debe ingresar la Hora");
    Validar.noNulo(grupo_imp_exc, "Debe ingresar el Grupo de Importación");
    Validar.noNulo(nro_lote, "Debe ingresar el Nro. de Lote");
 }
 
 
 public static List getLogsSincUlt30Dias(
		  DispMovilExc dispositivo,
         ISesion aSesion) throws BaseException {
	  return DBLogSincroExcluido.getLogsSincUlt30Dias(dispositivo,aSesion);
 }
 
 

}
