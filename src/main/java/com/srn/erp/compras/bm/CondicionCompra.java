package com.srn.erp.compras.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.compras.da.DBCondicionCompra;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CondicionCompra extends ObjetoLogico {

  private List condicionesCompraDet = new ArrayList();
  private boolean readCondicionesDet = true;

  public static final String CODIGO_UNI_DIAS  = "DIAS";
  public static final String CODIGO_UNI_MESES = "MESES";

  public static final String DESC_UNI_DIAS = "Dias";
  public static final String DESC_UNI_MESES = "Meses";

  public CondicionCompra() {
  }

  public static String NICKNAME = "cp.CondicionCompra";

  private String codigo;
  private String descripcion;
  private Boolean vtoFijo;
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

 public static CondicionCompra findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (CondicionCompra) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static CondicionCompra findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (CondicionCompra) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static CondicionCompra findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (CondicionCompra) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La Zona debe ingresarse en modo activo");

 }

 public List getCondicionesCompraDet() throws BaseException {
   if (readCondicionesDet) {
     List listaCondicionesCompraDet = CondicionCompraDet.getCondicionesCompraDet(this,getSesion());
     condicionesCompraDet.addAll(listaCondicionesCompraDet);
     readCondicionesDet = false;
   }
   return condicionesCompraDet;
 }

 public void addCondicionCompraDet(CondicionCompraDet condicionCompraDet) throws BaseException {
   condicionCompraDet.setCondicioncompra(this);
   condicionesCompraDet.add(condicionCompraDet);
 }

 public void afterSave() throws BaseException {
   Iterator iterCondicionesCompraDet = condicionesCompraDet.iterator();
   while (iterCondicionesCompraDet.hasNext()) {
     CondicionCompraDet condicionCompraDet = (CondicionCompraDet) iterCondicionesCompraDet.next();
     condicionCompraDet.save();
     condicionCompraDet = null;
   }
   iterCondicionesCompraDet = null;
 }
 
 public static List getAllCondCompra(ISesion aSesion) throws BaseException {
		return DBCondicionCompra.getAllCondCompra(aSesion);
 }
 


}
