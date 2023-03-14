package com.srn.erp.compras.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CertificacionProveedor extends ObjetoLogico {

  public CertificacionProveedor() {
  }

  public static String NICKNAME = "cp.CertificacionProveedor";

  private String codigo;
  private String descripcion;
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

 public static CertificacionProveedor findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CertificacionProveedor) getObjectByOid(NICKNAME,oid,aSesion);
 }

 public static CertificacionProveedor findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
   return (CertificacionProveedor) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }


 public static CertificacionProveedor findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CertificacionProveedor) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La certificación de Proveedor debe ingresarse en modo activo");

 }

}
