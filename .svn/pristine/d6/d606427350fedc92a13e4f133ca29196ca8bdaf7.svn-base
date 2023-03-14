package com.srn.erp.stock.bm;

import java.util.List;

import com.srn.erp.stock.da.DBAjuStkMovCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AjuStkMovCab extends ObjetoLogico {

  public AjuStkMovCab() {
  }

  public static String NICKNAME = "st.AjuStkMovCab";

  private ComproAjusteStk comproAjuStkCab;
  private Deposito deposito;
  private String tipo_movi;
  private EstadoStock estado_stock;
  private UbicacionDeposito ubicacion_deposito;
  private Boolean afecta_stk_fisico;
  private Boolean activo;

  public ComproAjusteStk getComproajustkcab() throws BaseException {
    supportRefresh();
    return comproAjuStkCab;
  }

  public int getSigno() throws BaseException {
    if (getTipo_movi().toUpperCase().equals("ENTRADA"))
      return 1;
    else
      return -1;
  }

  public void setComproajustkcab(ComproAjusteStk aComproajustkcab) {
    this.comproAjuStkCab =  aComproajustkcab;
  }

  public Deposito getDeposito() throws BaseException {
    supportRefresh();
    return deposito;
  }

  public void setDeposito(Deposito aDeposito) {
    this.deposito =  aDeposito;
  }

  public String getTipo_movi() throws BaseException {
    supportRefresh();
    return tipo_movi;
  }

  public void setTipo_movi(String aTipo_movi) {
    this.tipo_movi =  aTipo_movi;
  }

  public EstadoStock getEstado_stock() throws BaseException {
    supportRefresh();
    return estado_stock;
  }

  public void setEstado_stock(EstadoStock aEstado_stock) {
    this.estado_stock =  aEstado_stock;
  }

  public UbicacionDeposito getUbicacion_deposito() throws BaseException {
    supportRefresh();
    return ubicacion_deposito;
  }

  public void setUbicacion_deposito(UbicacionDeposito aUbicacion_deposito) {
    this.ubicacion_deposito =  aUbicacion_deposito;
  }

  public Boolean isAfecta_stk_fisico() throws BaseException {
    supportRefresh();
    return afecta_stk_fisico;
  }

  public void setAfecta_stk_fisico(Boolean aAfecta_stk_fisico) {
    this.afecta_stk_fisico =  aAfecta_stk_fisico;
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

 public static AjuStkMovCab findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (AjuStkMovCab) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static AjuStkMovCab findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (AjuStkMovCab) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(comproAjuStkCab, "Debe ingresar el Comprobante Cabecera");
    Validar.noNulo(deposito, "Debe ingresar el Depósito");
    Validar.noNulo(tipo_movi, "Debe ingresar el Tipo de Movimiento");
    Validar.noNulo(estado_stock, "Debe ingresar el Estado de Stock");
    //Validar.noNulo(ubicacion_deposito, "Debe ingresar la Ubicación del Deposito");
    Validar.noNulo(afecta_stk_fisico, "Debe ingresar si afecta o no el Stock físico");
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

  public static List getAjustesStkMovCab(ComproAjusteStk comproAjusteStk,
                                         ISesion aSesion) throws BaseException {
    return DBAjuStkMovCab.getAjustesStkMovCab(comproAjusteStk,aSesion);
  }


}
