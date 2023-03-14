package com.srn.erp.crm.bm;

import java.util.Hashtable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstadoOportunidad extends ObjetoLogico { 

  public EstadoOportunidad() { 
  }

  public static String NICKNAME = "crm.EstadoOportunidad";

  private String codigo;
  private String descripcion;
  private String comportamiento;
  private Boolean activo;
  
  public static final String ABIERTA = "ABIERTA";
  public static final String CERRADA = "CERRADA";

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

  public String getComportamiento() throws BaseException { 
    supportRefresh();
    return comportamiento;
  }

  public void setComportamiento(String aComportamiento) { 
    this.comportamiento =  aComportamiento;
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

 public static EstadoOportunidad findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EstadoOportunidad) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static EstadoOportunidad findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (EstadoOportunidad) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 

 public static EstadoOportunidad findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EstadoOportunidad) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(comportamiento, "Debe ingresar el Comportamiento");
 }
 
 public static Hashtable getEstadosOportunidades() throws BaseException {
	Hashtable condiciones = new Hashtable();
    condiciones.put(ABIERTA,"Abierta");
    condiciones.put(CERRADA,"Cerrada");
    return condiciones;
 }

}
