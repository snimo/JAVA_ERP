package com.srn.erp.impuestos.bm;

import java.util.Hashtable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CategoriaGanancia extends ObjetoLogico {

  public CategoriaGanancia() {
  }

  public static final String CODIGO_PRIMERA_CATEG = "1";
  public static final String DESC_PRIMERA_CATEG = "Primera Categoría";

  public static final String CODIGO_SEGUNDA_CATEG = "2";
  public static final String DESC_SEGUNDA_CATEG = "Segunda Categoría";

  public static final String CODIGO_TERCERA_CATEG = "3";
  public static final String DESC_TERCERA_CATEG = "Tercera Categoría";

  public static final String CODIGO_CUARTA_CATEG = "4";
  public static final String DESC_CUARTA_CATEG = "Cuarta Categoría";



  public static String NICKNAME = "im.CategoriaGanancia";

  private String codigo;
  private String descripcion;
  private String compo;
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

  public String getCompo() throws BaseException {
    supportRefresh();
    return compo;
  }

  public void setCompo(String aCompo) {
    this.compo =  aCompo;
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

 public static CategoriaGanancia findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CategoriaGanancia) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static CategoriaGanancia findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (CategoriaGanancia) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static CategoriaGanancia findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CategoriaGanancia) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(compo, "Debe ingresra el Comportamiento");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La Categoría de Ganancias debe ingresarse en Modo Activo");

 }

 public static Hashtable getListaComportamientos() throws BaseException {
   Hashtable lista = new Hashtable();
   lista.put(CODIGO_PRIMERA_CATEG,DESC_PRIMERA_CATEG);
   lista.put(CODIGO_SEGUNDA_CATEG,DESC_SEGUNDA_CATEG);
   lista.put(CODIGO_TERCERA_CATEG,DESC_TERCERA_CATEG);
   lista.put(CODIGO_CUARTA_CATEG,DESC_CUARTA_CATEG);
   return lista;
 }


}
