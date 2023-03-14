package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CondicionVenta extends ObjetoLogico {

  private List condicionesVentaDet = new ArrayList();
  private boolean readCondicionesDet = true;

  public static final String CODIGO_UNI_DIAS  = "DIAS";
  public static final String CODIGO_UNI_MESES = "MESES";

  public static final String DESC_UNI_DIAS = "Dias";
  public static final String DESC_UNI_MESES = "Meses";

  public CondicionVenta() {
  }

  public static String NICKNAME = "ve.CondicionVenta";

  private String codigo;
  private String descripcion;
  private Boolean vtoFijo;
  private Porcentaje porcRecar;
  private Porcentaje porcDto;
  private Boolean activo;

  public Porcentaje getPorcDto() throws BaseException {
    supportRefresh();
    return porcDto;
  }

  public Porcentaje getPorcRecar() throws BaseException {
    supportRefresh();
    return porcRecar;
  }

  public void setPorcDto(Porcentaje aPorcDto) throws BaseException {
    this.porcDto = aPorcDto;
  }

  public void setPorcRecar(Porcentaje aPorcRecar) throws BaseException {
    this.porcRecar = aPorcRecar;
  }


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

  public Boolean isVtofijo() throws BaseException {
    supportRefresh();
    return vtoFijo;
  }

  public void setVtofijo(Boolean aVtofijo) {
    this.vtoFijo =  aVtofijo;
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

 public static CondicionVenta findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CondicionVenta) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CondicionVenta findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (CondicionVenta) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static CondicionVenta findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CondicionVenta) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La Zona debe ingresarse en modo activo");

 }

 public List getCondicionesVentaDet() throws BaseException {
   if (readCondicionesDet) {
     List listaCondicionesVentaDet = CondicionVentaDet.getCondicionesVentaDet(this,getSesion());
     condicionesVentaDet.addAll(listaCondicionesVentaDet);
     readCondicionesDet = false;
   }
   return condicionesVentaDet;
 }

 public void addCondicionVentaDet(CondicionVentaDet condicionVentaDet) throws BaseException {
   condicionVentaDet.setCondicionVenta(this);
   condicionesVentaDet.add(condicionVentaDet);
 }

 public void afterSave() throws BaseException {
   Iterator iterCondicionesVentaDet = condicionesVentaDet.iterator();
   while (iterCondicionesVentaDet.hasNext()) {
     CondicionVentaDet condicionVentaDet = (CondicionVentaDet) iterCondicionesVentaDet.next();
     condicionVentaDet.save();
     condicionVentaDet = null;
   }
   iterCondicionesVentaDet = null;
 }


}
