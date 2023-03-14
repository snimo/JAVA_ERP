package com.srn.erp.stock.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TipoProducto extends ObjetoLogico {

  public static String COD_MP = "MP";
  public static String COD_PT = "PT";
  public static String COD_SE = "SE";
  public static String COD_SV = "SV";

  public static String DESC_MP = "Materia Prima";
  public static String DESC_PT = "Producto Terminado";
  public static String DESC_SE = "Semi-Elaborado";
  public static String DESC_SV = "Servicio";


  public TipoProducto() {
  }

  public static String NICKNAME = "st.TipoProducto";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private String comportamiento;

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
  }

  public void setComportamiento(String aComportamiento) throws BaseException {
    this.comportamiento = aComportamiento;
  }

  public String getComportamiento() throws BaseException {
    supportRefresh();
    return comportamiento;
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

 public static TipoProducto findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (TipoProducto) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static TipoProducto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (TipoProducto) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static TipoProducto findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (TipoProducto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
   Validar.noNulo(codigo, "Debe ingresar un código");
   Validar.noNulo(descripcion, "Debe ingresar la Descripción");
   Validar.noNulo(comportamiento, "Debe ingresar un Comportamiento");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El tipo de producto debe estar activo");

 }
 
 public static TipoProducto getTipoProductoDefault(ISesion aSesion) throws BaseException {
   Integer oidTipoProducto =
       ValorParametro.findByCodigoParametro("TIPO_PROD_DEF_ABM_PROD",aSesion).getOidObjNeg();
   TipoProducto tipoProducto = TipoProducto.findByOid(oidTipoProducto,aSesion);
   return tipoProducto;
 } 

}
