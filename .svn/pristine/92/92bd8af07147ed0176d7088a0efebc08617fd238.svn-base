package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBUniOrgHabUsu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UniOrgHabUsu extends ObjetoLogico {

  public UniOrgHabUsu() {
  }

  public static String NICKNAME = "ge.UniOrgHabUsu";

  private UnidadOrganizativa unidad_organizacion;
  private Empresa empresa;
  private Sucursal sucursal;
  private Usuario usuario;

  public void setUsuario(Usuario usuario) throws BaseException {
    this.usuario = usuario;
  }

  public Usuario getUsuario() throws BaseException {
    supportRefresh();
    return usuario;
  }

  public UnidadOrganizativa getUnidad_organizacion() throws BaseException {
    supportRefresh();
    return unidad_organizacion;
  }

  public void setUnidad_organizacion(UnidadOrganizativa aUnidad_organizacion) {
    this.unidad_organizacion =  aUnidad_organizacion;
  }

  public Empresa getEmpresa() throws BaseException {
    supportRefresh();
    return empresa;
  }

  public void setEmpresa(Empresa aEmpresa) {
    this.empresa =  aEmpresa;
  }

  public Sucursal getSucursal() throws BaseException {
    supportRefresh();
    return sucursal;
  }

  public void setSucursal(Sucursal aSucursal) {
    this.sucursal =  aSucursal;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static UniOrgHabUsu findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (UniOrgHabUsu) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static UniOrgHabUsu findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (UniOrgHabUsu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(unidad_organizacion, "Debe ingresar la Unidad Organizativa");
    Validar.noNulo(empresa, "Debe ingresar la Empresa");
    Validar.noNulo(sucursal, "Debe ingresar la Sucursal");
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


  public static UniOrgHabUsu getUniOrgHabUsu(UnidadOrganizativa uniOrg,
                                     Empresa empresa,
                                     Sucursal sucursal,
                                     Usuario usuario,
                                     ISesion aSesion)
                                     throws BaseException {
    return DBUniOrgHabUsu.getUniOrgHabUsu(uniOrg,
                                          empresa,
                                          sucursal,
                                          usuario,
                                          aSesion);
  }


  public static List getUniOrgHabUsu(Empresa empresa,
                                     Sucursal sucursal,
                                     Usuario usuario,
                                     ISesion aSesion)
                                     throws BaseException {
    return DBUniOrgHabUsu.getUniOrgHabUsu(empresa,
                                          sucursal,
                                          usuario,
                                          aSesion);
  }



}
