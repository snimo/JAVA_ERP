package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBAjuStkMovDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AjuStkPartSerie extends ObjetoLogico {

  public AjuStkPartSerie() {
  }

  public static String NICKNAME = "st.AjuStkPartSerie";

  private ComproAjusteStkDet aju_stk_det;
  private Partida partida;
  private Serie serie;
  private Double cantidad;
  private Boolean activo;

  public ComproAjusteStkDet getAju_stk_det() throws BaseException {
    supportRefresh();
    return aju_stk_det;
  }

  public void setAju_stk_det(ComproAjusteStkDet aAju_stk_det) {
    this.aju_stk_det =  aAju_stk_det;
  }

  public Partida getPartida() throws BaseException {
    supportRefresh();
    return partida;
  }

  public void setPartida(Partida aPartida) {
    this.partida =  aPartida;
  }

  public Serie getSerie() throws BaseException {
    supportRefresh();
    return serie;
  }

  public void setSerie(Serie aSerie) {
    this.serie =  aSerie;
  }

  public Double getCantidad() throws BaseException {
    supportRefresh();
    return cantidad;
  }

  public void setCantidad(Double aCantidad) {
    this.cantidad =  aCantidad;
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

 public static AjuStkPartSerie findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (AjuStkPartSerie) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static AjuStkPartSerie findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (AjuStkPartSerie) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
     Validar.noNulo(getAju_stk_det(), "Debe ingresar el Detalle");
     Validar.noNulo(getAju_stk_det().getProducto(),"Debe ingresar el Producto");
     if (getAju_stk_det().getProducto().isLlevaPartida().booleanValue())
       Validar.noNulo(getPartida(),"Debe ingresar la Partida");
     if (getAju_stk_det().getProducto().isLlevaSerie().booleanValue())
       Validar.noNulo(getSerie(),"Debe ingresar la Serie");
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

  public static List getAjustesStkPartSerie(ComproAjusteStkDet comproAjuStkDet,
                                            ISesion aSesion) throws BaseException {
    return DBAjuStkMovDet.getAjustesStkMovDet(comproAjuStkDet,aSesion);
  }


}
