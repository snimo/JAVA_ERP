package com.srn.erp.ventas.bm;

import java.util.Date;
import java.util.List;

import com.srn.erp.ventas.da.DBListaPrecioSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ListaPrecioSujeto extends ObjetoLogico {

  public ListaPrecioSujeto() {
  }

  public static String NICKNAME = "ve.ListaPrecioSujeto";

  private Date fecha_desde;
  private Date fecha_hasta;
  private Sujeto sujeto;
  private Boolean activo;
  private ListaPrecios lista_precio;

  public Date getFecha_desde() throws BaseException {
    supportRefresh();
    return fecha_desde;
  }

  public void setFecha_desde(Date aFecha_desde) {
    this.fecha_desde =  aFecha_desde;
  }

  public Date getFecha_hasta() throws BaseException {
    supportRefresh();
    return fecha_hasta;
  }

  public void setFecha_hasta(Date aFecha_hasta) {
    this.fecha_hasta =  aFecha_hasta;
  }

  public Sujeto getSujeto() throws BaseException {
    supportRefresh();
    return sujeto;
  }

  public void setSujeto(Sujeto aSujeto) {
    this.sujeto =  aSujeto;
  }

  public Boolean isActivo() throws BaseException {
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) {
    this.activo =  aActivo;
  }

  public ListaPrecios getLista_precio() throws BaseException {
    supportRefresh();
    return lista_precio;
  }

  public void setLista_precio(ListaPrecios aLista_precio) {
    this.lista_precio =  aLista_precio;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static ListaPrecioSujeto findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (ListaPrecioSujeto) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static ListaPrecioSujeto findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (ListaPrecioSujeto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(fecha_desde, "Debe ingresar la Fecha Desde");
    Validar.noNulo(fecha_hasta, "Debe ingresar la Fecha Hasta");
    Validar.noNulo(sujeto, "Debe ingresar el Cliente");
    Validar.noNulo(lista_precio, "Debe ingresar la Lista de Precios");
 }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

  public static List getListaPreciosBySujeto(Sujeto sujeto,
                                             ISesion aSesion) throws BaseException {
    return DBListaPrecioSujeto.getListaPreciosBySujeto(sujeto,aSesion);
  }

  public static List getListaPreciosBySujetoFecha(Sujeto sujeto,
      java.util.Date fecha,
      ISesion aSesion) throws BaseException {
    return DBListaPrecioSujeto.getListaPreciosBySujetoFecha(sujeto,fecha,aSesion);
  }


}
