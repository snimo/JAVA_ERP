package com.srn.erp.cip.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Biometrico extends ObjetoLogico { 

  public Biometrico() { 
  }

  public static String NICKNAME = "cip.Biometrico";

  private String codigo;
  private String descripcion;
  private String ip;
  private Integer puerto;
  private String tipo_biometrico;
  private Integer nro_biometrico;
  private Boolean activo;

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

  public String getIp() throws BaseException { 
    supportRefresh();
    return ip;
  }

  public void setIp(String aIp) { 
    this.ip =  aIp;
  }

  public Integer getPuerto() throws BaseException { 
    supportRefresh();
    return puerto;
  }

  public void setPuerto(Integer aPuerto) { 
    this.puerto =  aPuerto;
  }

  public String getTipo_biometrico() throws BaseException { 
    supportRefresh();
    return tipo_biometrico;
  }

  public void setTipo_biometrico(String aTipo_biometrico) { 
    this.tipo_biometrico =  aTipo_biometrico;
  }

  public Integer getNro_biometrico() throws BaseException { 
    supportRefresh();
    return nro_biometrico;
  }

  public void setNro_biometrico(Integer aNro_biometrico) { 
    this.nro_biometrico =  aNro_biometrico;
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

 public static Biometrico findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (Biometrico) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static Biometrico findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (Biometrico) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
    Validar.noNulo(ip, "Debe ingresar la dirección I.P.");
    Validar.noNulo(puerto, "Debe ingresar el puerto");
    Validar.noNulo(tipo_biometrico, "Debe ingresar el Tipo de biométrico");
    Validar.noNulo(nro_biometrico, "Debe ingresar el Nro. de Biométrico");
 }

}
