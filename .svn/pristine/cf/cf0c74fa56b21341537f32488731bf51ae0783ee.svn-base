package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.ventas.da.DBCondPagoTipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CondPagoTipoValor extends ObjetoLogico {

  public CondPagoTipoValor() {
  }

  public static String NICKNAME = "ve.CondPagoTipoValor";

  private CondicionPago condicion_pago;
  private TipoValor tipo_valor;
  private boolean sugerir;

  public CondicionPago getCondicion_pago() throws BaseException {
    supportRefresh();
    return condicion_pago;
  }

  public void setCondicion_pago(CondicionPago aCondicion_pago) {
    this.condicion_pago =  aCondicion_pago;
  }
  
  public boolean isSugerir() throws BaseException {
    supportRefresh();
    return this.sugerir;
  }

  public void setSugerir(boolean aSugerir) {
    this.sugerir =  aSugerir;
  }
  

  public TipoValor getTipo_valor() throws BaseException {
    supportRefresh();
    return tipo_valor;
  }

  public void setTipo_valor(TipoValor aTipo_valor) {
    this.tipo_valor =  aTipo_valor;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static CondPagoTipoValor findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CondPagoTipoValor) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CondPagoTipoValor findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CondPagoTipoValor) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(condicion_pago, "Debe ingresar la condición de Pago");
    Validar.noNulo(tipo_valor, "Debe ingresar el Tipo de Valor");
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

  public static List getTipoValCondPago(CondicionPago condPago,
                                        ISesion aSesion) throws BaseException {
    return DBCondPagoTipoValor.getTipoValCondPago(condPago,aSesion);
  }


}
