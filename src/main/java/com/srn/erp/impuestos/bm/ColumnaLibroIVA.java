package com.srn.erp.impuestos.bm;

import java.util.List;

import com.srn.erp.impuestos.da.DBColumnaLibroIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ColumnaLibroIVA extends ObjetoLogico {

  public ColumnaLibroIVA() {
  }

  public static String NICKNAME = "im.ColumnaLibroIVA";

  private String codigo;
  private String descripcion;
  private Integer columna;
  private Boolean activo;
  private Boolean usarIVAVentas;
  private Boolean usarIVACompras;

  public Boolean isUsarIVAVentas() throws BaseException {
	    supportRefresh();
	    return usarIVAVentas;
  }

  public void setUsarIVAVentas(Boolean aUsarIVAVentas) {
	    this.usarIVAVentas =  aUsarIVAVentas;
  }
  
  public Boolean isUsarIVACompras() throws BaseException {
	    supportRefresh();
	    return usarIVACompras;
}

  public void setUsarIVACompras(Boolean aUsarIVACompras) {
	    this.usarIVACompras =  aUsarIVACompras;
  }
 
  
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

  public Integer getColumna() throws BaseException {
    supportRefresh();
    return columna;
  }

  public void setColumna(Integer aColumna) {
    this.columna =  aColumna;
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

 public static ColumnaLibroIVA findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ColumnaLibroIVA) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static ColumnaLibroIVA findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (ColumnaLibroIVA) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static ColumnaLibroIVA findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ColumnaLibroIVA) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {

   Validar.noNulo(codigo, "Debe ingresar un Código");
   Validar.noNulo(descripcion, "Debe ingresar la Descripción");
   Validar.noNulo(columna, "Debe ingresar el Nro. de Columna");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La Columna de IVA debe ingresarse en Modo Activo");

 }
 
 public static List getColLibroIVACompras(ISesion aSesion) throws BaseException {
	  return DBColumnaLibroIVA.getColLibroIVACompras(aSesion);
 } 

 public static List getColLibroIVA(ISesion aSesion) throws BaseException {
	  return DBColumnaLibroIVA.getColLibroIVA(aSesion);
} 
 
}
