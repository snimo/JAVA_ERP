package com.srn.erp.impuestos.bm;

import java.util.Hashtable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CategoriaIB extends ObjetoLogico {

  public static final String COMPO_CODIGO_CONV = "CONV";
  public static final String COMPO_DESC_CONV = "Convenio";

  public static final String COMPO_CODIGO_INS = "INS";
  public static final String COMPO_DESC_INS = "Inscripto";

  public static final String COMPO_CODIGO_NINS = "NINS";
  public static final String COMPO_DESC_NINS = "No Inscripto";

  public static final String COMPO_CODIGO_EXEN = "EXEN";
  public static final String COMPO_DESC_EXEN = "Exento";

  public CategoriaIB() {
  }

  public static String NICKNAME = "im.CategoriaIB";

  private String codigo;
  private String descripcion;
  private String comportamiento;
  private Boolean activo;
  private boolean calcPercIBBsAs;
  private boolean calcPercIBCapFed;

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
  }

  
  public boolean isCalcPercIBBsAs() throws BaseException {
  	supportRefresh();
  	return this.calcPercIBBsAs;
  }

  public void setCalcPercIBBsAs(boolean aCalcPercIBBsAs) {
    this.calcPercIBBsAs =  aCalcPercIBBsAs;
  }
  
  public boolean isCalcPercIBCapFed() throws BaseException {
  	supportRefresh();
  	return this.calcPercIBCapFed;
  }

  public void setCalcPercIBCapFed(boolean aCalcPercIBCapFed) {
    this.calcPercIBCapFed =  aCalcPercIBCapFed;
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

 public static CategoriaIB findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CategoriaIB) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static CategoriaIB findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (CategoriaIB) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static CategoriaIB findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CategoriaIB) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresarse el Código");
    Validar.noNulo(descripcion, "Debe ingresarse la Descripción");
    Validar.noNulo(comportamiento, "Debe ingresarse la Categoría de IB");
    
   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La categoría de IB debe ingresarse en modo activo");

 }

 public static Hashtable getListaComportamientos() throws BaseException {
   Hashtable lista = new Hashtable();
   lista.put(COMPO_CODIGO_CONV,COMPO_DESC_CONV);
   lista.put(COMPO_CODIGO_INS,COMPO_DESC_INS);
   lista.put(COMPO_CODIGO_NINS,COMPO_DESC_NINS);
   lista.put(COMPO_CODIGO_EXEN,COMPO_DESC_EXEN);
   return lista;
 }


}
