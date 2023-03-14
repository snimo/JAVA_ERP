package com.srn.erp.impuestos.bm;

import java.util.List;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.impuestos.da.DBTalonarioCategoriaIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TalonarioCategoriaIVA extends ObjetoLogico {

  public TalonarioCategoriaIVA() {
  }

  public static String NICKNAME = "im.TalonarioCategoriaIVA";

  private CategoriaIVA categoria_iva;
  private Talonario talonario;

  public CategoriaIVA getCategoria_iva() throws BaseException {
    supportRefresh();
    return categoria_iva;
  }

  public void setCategoria_iva(CategoriaIVA aCategoria_iva) {
    this.categoria_iva =  aCategoria_iva;
  }

  public Talonario getTalonario() throws BaseException {
    supportRefresh();
    return talonario;
  }

  public void setTalonario(Talonario aTalonario) {
    this.talonario =  aTalonario;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static TalonarioCategoriaIVA findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (TalonarioCategoriaIVA) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static TalonarioCategoriaIVA findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (TalonarioCategoriaIVA) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }


 public static TalonarioCategoriaIVA findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (TalonarioCategoriaIVA) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(categoria_iva, "Debe ingresar la Categoría de IVA");
    Validar.noNulo(talonario, "Debe ingresar el Talonario");
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

  public static List getTalonariosCatIVA(CategoriaIVA categoriaIVA,
                                         ISesion aSesion) throws BaseException {
    return DBTalonarioCategoriaIVA.getTalonariosCatIVA(categoriaIVA,aSesion);
  }


}
