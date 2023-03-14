package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBAsientoManualDet;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class AsientoManualDet extends ObjetoLogico {

  public AsientoManualDet() {
  }

  public static String NICKNAME = "cg.AsientoManualDet";

  private ComproCab comprobante;
  private CuentaImputable cuentaImputable;
  private Integer secu;
  private Integer signo;
  private Money importe;
  private String comentario;

  public ComproCab getComprobante() throws BaseException {
    supportRefresh();
    return comprobante;
  }

  public void setImporteDebe(Money aImporteDebe) throws BaseException {
    if (aImporteDebe==null) return;
    if (aImporteDebe.doubleValue()!=0) {
      signo = new Integer(1);
      importe = aImporteDebe;
    }
  }

  public void setImporteHaber(Money aImporteHaber) throws BaseException {
    if (aImporteHaber==null) return;
    if (aImporteHaber.doubleValue()!=0) {
      signo = new Integer(-11);
      importe = aImporteHaber;
    }
  }


  public void setComprobante(ComproCab aComprobante) {
    this.comprobante =  aComprobante;
  }

  public CuentaImputable getCuentaImputable() throws BaseException {
    supportRefresh();
    return cuentaImputable;
  }

  public void setCuentaImputable(CuentaImputable aCuentaImputable) {
    this.cuentaImputable =  aCuentaImputable;
  }

  public Integer getSecu() throws BaseException {
    supportRefresh();
    return secu;
  }

  public void setSecu(Integer aSecu) {
    this.secu =  aSecu;
  }

  public Integer getSigno() throws BaseException {
    supportRefresh();
    return signo;
  }

  public void setSigno(Integer aSigno) {
    this.signo =  aSigno;
  }

  public Money getImporte() throws BaseException {
    supportRefresh();
    return importe;
  }

  public void setImporte(Money aImporte) {
    this.importe =  aImporte;
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

 public static AsientoManualDet findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (AsientoManualDet) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static AsientoManualDet findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
   return (AsientoManualDet) getObjectByOidProxy(NICKNAME,oid,aSesion);
  }
 

 public static AsientoManualDet findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (AsientoManualDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
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
  
  public static List getDetalles(AsientoManual asiento,
      ISesion aSesion) throws BaseException {
  	return DBAsientoManualDet.getDetalles(asiento,aSesion);
  }
  

}
