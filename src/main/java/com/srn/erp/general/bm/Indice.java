package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBIndice;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Indice extends ObjetoLogico {

  public Indice() {
  }

  public static String NICKNAME = "ge.Indice";

  private String codigo;
  private String descripcion;
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

 public static Indice findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Indice) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static Indice findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Indice) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static Indice findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Indice) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar un código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El Indice debe estar em modo activo");

 }

 public static List getAllIndices(ISesion aSesion) throws BaseException {
   return DBIndice.getAllIndices(aSesion);
 }
 
 public IndiceValor getValorIndice(Periodo periodo) throws BaseException {
	 return IndiceValor.getIndiceValor(this,periodo,getSesion());
 }


}
