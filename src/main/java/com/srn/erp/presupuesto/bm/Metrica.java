package com.srn.erp.presupuesto.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Metrica extends ObjetoLogico { 

  public Metrica() { 
  }
  
  public static final String ENTERO = "ENTERO";
  public static final String DECIMAL = "DECIMAL";

  public static String NICKNAME = "pl.Metrica";

  private String codigo;
  private String descripcion;
  private String tipo;
  private Integer cant_decimales;
  private String mascara_display;
  private Boolean activo;
  private Integer nroInterno;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setNroInterno(Integer aNroInterno) { 
    this.nroInterno =  aNroInterno;
  }
  
  public Integer getNroInterno() throws BaseException { 
    supportRefresh();
    return this.nroInterno;
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

  public String getTipo() throws BaseException { 
    supportRefresh();
    return tipo;
  }

  public void setTipo(String aTipo) { 
    this.tipo =  aTipo;
  }

  public Integer getCant_decimales() throws BaseException { 
    supportRefresh();
    return cant_decimales;
  }

  public void setCant_decimales(Integer aCant_decimales) { 
    this.cant_decimales =  aCant_decimales;
  }

  public String getMascara_display() throws BaseException { 
    supportRefresh();
    return mascara_display;
  }

  public void setMascara_display(String aMascara_display) { 
    this.mascara_display =  aMascara_display;
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

 public static Metrica findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (Metrica) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static Metrica findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (Metrica) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 

 public static Metrica findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (Metrica) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(tipo, "Debe ingresar el Tipo");
 }
 
 public static HashTableDatos getTiposMetricas() {
	 HashTableDatos tiposMetricas = new HashTableDatos();
	 tiposMetricas.put(ENTERO,"Entero");
	 tiposMetricas.put(DECIMAL,"Decimal");
	 return tiposMetricas;
 }

}
