package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.ventas.da.DBListaPreciosPorUniOrg;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ListaPreciosPorUniOrg extends ObjetoLogico {

  public ListaPreciosPorUniOrg() {
  }

  public static String NICKNAME = "ve.ListaPreciosPorUniOrg";

  private UnidadOrganizativa unidad_organizativa;
  private ListaPrecios lista_precios;

  public UnidadOrganizativa getUnidad_organizativa() throws BaseException {
    supportRefresh();
    return unidad_organizativa;
  }

  public void setUnidad_organizativa(UnidadOrganizativa aUnidad_organizativa) {
    this.unidad_organizativa =  aUnidad_organizativa;
  }

  public ListaPrecios getLista_precios() throws BaseException {
    supportRefresh();
    return lista_precios;
  }

  public void setLista_precios(ListaPrecios aLista_precios) {
    this.lista_precios =  aLista_precios;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static ListaPreciosPorUniOrg findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ListaPreciosPorUniOrg) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ListaPreciosPorUniOrg findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ListaPreciosPorUniOrg) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(unidad_organizativa, "Debe ingresar la unidad organizativa");
    Validar.noNulo(lista_precios, "Debe ingresar la Lista de Precios");
 }

  /**
   * isActivo
   *
   * @return Boolean
   */
  public Boolean isActivo() {
    return null;
  }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  public static List getUniOrgPorLP(ListaPrecios listaPrecios,
                                    ISesion aSesion) throws BaseException {
    return DBListaPreciosPorUniOrg.getUniOrgPorLP(listaPrecios,aSesion);
  }

  public static List getUniOrgPorLP(UnidadOrganizativa uniOrg,
                                    ISesion aSesion) throws BaseException {
    return DBListaPreciosPorUniOrg.getUniOrgPorLP(uniOrg,aSesion);
  }



}
