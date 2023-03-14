package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.bl.CrearTablaCompo;
import com.srn.erp.contabilidad.da.DBCompoAtributo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;

public class CompoAtributo extends ObjetoLogico {

  public CompoAtributo() {
  }

  public static String NICKNAME = "cg.CompoAtributo";

  private Componente compo;
  private Integer secu;
  private Atributo atributo;
  private Boolean activo;

  public Componente getCompo() throws BaseException {
    supportRefresh();
    return compo;
  }

  public void setCompo(Componente aCompo) {
    this.compo =  aCompo;
  }

  public Integer getSecu() throws BaseException {
    supportRefresh();
    return secu;
  }

  public void setSecu(Integer aSecu) {
    this.secu =  aSecu;
  }

  public Atributo getAtributo() throws BaseException {
    supportRefresh();
    return atributo;
  }

  public void setAtributo(Atributo aAtributo) {
    this.atributo =  aAtributo;
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

 public static CompoAtributo findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CompoAtributo) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CompoAtributo findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CompoAtributo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
 }

 public List getAtributosByCompo(Componente componente) throws BaseException {
   return DBCompoAtributo.getAtributosByCompo(componente,getSesion());
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

  public String getSQLScriptAddCampo() throws BaseException {
    CrearTablaCompo crearTablaCompo = new CrearTablaCompo();
    crearTablaCompo.setComponente(getCompo());
    return crearTablaCompo.getScriptAddCampoAtributo(this);
  }

}
