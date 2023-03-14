package com.srn.erp.produccion.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class UMTiempoProduccion extends ObjetoLogico { 

  public UMTiempoProduccion() { 
  }
  
  public static final String UM_TIEMPO_SEG = "SEGU";
  public static final String UM_TIEMPO_MIN = "MINU";
  public static final String UM_TIEMPO_HOR = "HORA";
  public static final String UM_TIEMPO_DIA = "DIAS";
  public static final String UM_TIEMPO_NES = "MES";
  public static final String UM_TIEMPO_ANIO = "ANIO";

  public static String NICKNAME = "pr.UMTiempoProduccion";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private String comportamiento;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Boolean isActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public String getComportamiento() throws BaseException { 
    supportRefresh();
    return comportamiento;
  }

  public void setComportamiento(String aComportamiento) { 
    this.comportamiento =  aComportamiento;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static UMTiempoProduccion findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (UMTiempoProduccion) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static UMTiempoProduccion findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (UMTiempoProduccion) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 
 

 public static UMTiempoProduccion findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (UMTiempoProduccion) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(comportamiento, "Debe ingresar el Comportamiento");
 }
 
 public static HashTableDatos getUMTiemposProduccion() throws BaseException {
	 HashTableDatos umTiempo = new HashTableDatos();
	 umTiempo.put(UMTiempoProduccion.UM_TIEMPO_SEG, "Segundos");
	 umTiempo.put(UMTiempoProduccion.UM_TIEMPO_MIN, "Minutos");
	 umTiempo.put(UMTiempoProduccion.UM_TIEMPO_HOR, "Horas");
	 umTiempo.put(UMTiempoProduccion.UM_TIEMPO_DIA, "Día");
	 umTiempo.put(UMTiempoProduccion.UM_TIEMPO_NES, "Mes");
	 umTiempo.put(UMTiempoProduccion.UM_TIEMPO_ANIO, "Año");
	 return umTiempo; 
 }

}
