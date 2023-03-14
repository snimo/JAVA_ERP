package com.srn.erp.general.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.da.DBEmpresaHabUsu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EmpresaHabUsu extends ObjetoLogico {

  public EmpresaHabUsu() {
  }

  public static String NICKNAME = "ge.EmpresaHabUsu";


  private Usuario usuario;
  private Empresa empresa;
  private Sucursal sucursal;
  private Boolean usarPorDefecto;

  private List unidadesOrgHab = new ArrayList();
  private boolean readUniOrgHab = true;


  public void setUsarPorDefecto(Boolean usarPorDefecto) throws BaseException {
    this.usarPorDefecto = usarPorDefecto;
  }

  public Boolean isUsarPorDefecto() throws BaseException {
    supportRefresh();
    return usarPorDefecto;
  }

  public Usuario getUsuario() throws BaseException {
    supportRefresh();
    return usuario;
  }

  public void setUsuario(Usuario aUsuario) {
    this.usuario =  aUsuario;
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

 public static EmpresaHabUsu findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (EmpresaHabUsu) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static EmpresaHabUsu findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (EmpresaHabUsu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(usuario, "Debe ingresar el Usuario");
    Validar.noNulo(empresa, "Debe ingresar la Empresa");
    Validar.noNulo(sucursal, "Debe ingrear la Sucursal");
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

  public static List getEmpHabUsu(Usuario usuario,
                                       ISesion aSesion) throws BaseException {
    return DBEmpresaHabUsu.getEmpHabUsu(usuario,aSesion);
  }

  public static EmpresaHabUsu getEmpresaHabUsu(Usuario usuario,
                                               Empresa empresa,
                                               Sucursal sucursal,
                                               ISesion aSesion)
                                                      throws BaseException {
    return DBEmpresaHabUsu.getEmpresaHabUsu(usuario,empresa,sucursal,aSesion);
  }

  public List getUnidadesOrganizativasHabilitadas() throws BaseException {
    if (readUniOrgHab) {
      List listaUniOrgHab = UniOrgHabUsu.getUniOrgHabUsu(getEmpresa(),getSucursal(),getUsuario(),getSesion());
      unidadesOrgHab.addAll(listaUniOrgHab);
      readUniOrgHab = false;
    }
    return unidadesOrgHab;
  }

  public void addUniOrgHab(UniOrgHabUsu aUniOrgHabUsu) throws BaseException {
    aUniOrgHabUsu.setEmpresa(getEmpresa());
    aUniOrgHabUsu.setSucursal(getSucursal());
    aUniOrgHabUsu.setUsuario(getUsuario());
    unidadesOrgHab.add(aUniOrgHabUsu);
  }

  public void afterSave() throws BaseException {
    Iterator iterUniOrgHab = unidadesOrgHab.iterator();
    while (iterUniOrgHab.hasNext()) {
      UniOrgHabUsu uniOrgHabUsu = (UniOrgHabUsu) iterUniOrgHab.next();
      uniOrgHabUsu.save();
      uniOrgHabUsu = null;
    }
    iterUniOrgHab = null;
  }




}
