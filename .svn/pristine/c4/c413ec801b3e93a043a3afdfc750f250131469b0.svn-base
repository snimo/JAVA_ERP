package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.pagos.da.DBTipoValorFormaPago;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoValorFormaPago extends ObjetoLogico {

  public TipoValorFormaPago() {
  }

  public static String NICKNAME = "pag.TipoValorFormaPago";

  private FormaPago formaPago;
  private TipoValor tipoValor;
  private Boolean activo;

  public FormaPago getFormapago() throws BaseException {
    supportRefresh();
    return formaPago;
  }

  public void setFormapago(FormaPago aFormapago) {
    this.formaPago =  aFormapago;
  }

  public TipoValor getTipovalor() throws BaseException {
    supportRefresh();
    return tipoValor;
  }

  public void setTipovalor(TipoValor aTipovalor) {
    this.tipoValor =  aTipovalor;
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

 public static TipoValorFormaPago findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (TipoValorFormaPago) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static TipoValorFormaPago findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (TipoValorFormaPago) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(formaPago, "Debe ingresar la Forma de Pago");
    Validar.noNulo(tipoValor, "Debe ingresar el Tipo de Valor");
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

  public static List getTiposValorFormaPago(FormaPago formaPago,
                                            ISesion aSesion)
      throws BaseException {
    return DBTipoValorFormaPago.getTipoValorFormaPago(formaPago,aSesion);
  }

}
