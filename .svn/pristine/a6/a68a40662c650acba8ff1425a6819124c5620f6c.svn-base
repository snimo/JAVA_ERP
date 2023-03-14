package com.srn.erp.contabilidad.bm;

import java.util.Date;

import com.srn.erp.contabilidad.da.DBDiario;
import com.srn.erp.general.bm.TipoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class Diario extends ObjetoLogico {

  public Diario() {
  }

  public static String NICKNAME = "cg.Diario";

  private TipoComprobante tipoComprobante;
  private Date imputac;
  private Boolean cierre;
  private String comentario;

  public static Diario getNewDiario(ISesion aSesion) throws BaseException {
    Diario diario = (Diario)Diario.getNew(Diario.NICKNAME,aSesion);
    return diario;
  }

  public TipoComprobante getTipocomprobante() throws BaseException {
    supportRefresh();
    return tipoComprobante;
  }

  public void setTipocomprobante(TipoComprobante aTipocomprobante) {
    this.tipoComprobante =  aTipocomprobante;
  }

  public Date getImputac() throws BaseException {
    supportRefresh();
    return imputac;
  }

  public void setImputac(Date aImputac) {
    this.imputac =  aImputac;
  }

  public Boolean isCierre() throws BaseException {
    supportRefresh();
    return cierre;
  }

  public void setCierre(Boolean aCierre) {
    this.cierre =  aCierre;
  }

  public String getComentario() throws BaseException {
    supportRefresh();
    return comentario;
  }

  public void setComentario(String aComentario) {
    this.comentario =  aComentario;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static Diario findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Diario) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static Diario findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Diario) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static Diario findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Diario) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

  public void beforeSave() throws BaseException {
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

  public static Diario getDiarioByFechayTC(java.util.Date fecha,
                                           TipoComprobante tc,
                                           ISesion aSesion)
                                           throws BaseException {
    return DBDiario.getDiarioByFechayTC(fecha,tc,aSesion);
  }




}
