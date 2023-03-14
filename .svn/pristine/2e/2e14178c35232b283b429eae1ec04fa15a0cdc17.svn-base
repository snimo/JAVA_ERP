package com.srn.erp.crm.bm;

import java.util.Hashtable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstadoCampania extends ObjetoLogico { 

  public static final String ABIERTO = "ABIERTA";
  public static final String CERRADA = "CERRADA";
	
  public EstadoCampania() { 
  }

  public static String NICKNAME = "crm.EstadoCampania";

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

 public static EstadoCampania findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EstadoCampania) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EstadoCampania findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (EstadoCampania) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 public static EstadoCampania findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EstadoCampania) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(comportamiento, "Debe ingresar el Estado");
 }
 
 public static Hashtable getTiposEstados() throws BaseException {
	 Hashtable comportamientos = new Hashtable();
	 comportamientos.put(ABIERTO,"Abierta");
	 comportamientos.put(CERRADA,"Cerrada");
	 return comportamientos;
 }

}
