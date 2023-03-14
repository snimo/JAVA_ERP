package com.srn.erp.compras.bm;

import java.util.Hashtable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoAcuerdo extends ObjetoLogico { 

  public static final String LISTA_PRECIOS = "LP";
  public static final String ACUERDO ="ACUERDO";
	
  public TipoAcuerdo() { 
  }

  public static String NICKNAME = "cp.TipoAcuerdo";

  private String codigo;
  private String descripcion;
  private String tipo_acuerdo;
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

  public String getTipo_acuerdo() throws BaseException { 
    supportRefresh();
    return tipo_acuerdo;
  }

  public void setTipo_acuerdo(String aTipo_acuerdo) { 
    this.tipo_acuerdo =  aTipo_acuerdo;
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

 public static TipoAcuerdo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (TipoAcuerdo) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static TipoAcuerdo findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (TipoAcuerdo) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 public static TipoAcuerdo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (TipoAcuerdo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(tipo_acuerdo,"Debe ingresar el tipo de acuerdo");
 }
 
 public static Hashtable getTiposAcuerdos() throws BaseException {
	 Hashtable tiposAcuerdos = new Hashtable();
	 tiposAcuerdos.put(LISTA_PRECIOS,"Lista de Precios");
	 tiposAcuerdos.put(ACUERDO,"Acuerdo");
	 return tiposAcuerdos; 
 }

}
