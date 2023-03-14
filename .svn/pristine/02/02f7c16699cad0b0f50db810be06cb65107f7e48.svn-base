package com.srn.erp.pagos.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.pagos.da.DBFormaPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class FormaPago extends ObjetoLogico {

  private List tiposValor = new ArrayList();
  private boolean readTiposValores = true;

  public FormaPago() {
  }

  public static String NICKNAME = "pag.FormaPago";

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

 public static FormaPago findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (FormaPago) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static FormaPago findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (FormaPago) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }


 public static FormaPago findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (FormaPago) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
   Validar.noNulo(codigo, "Debe ingresar el Código");
   Validar.noNulo(descripcion, "Debe ingresar la descripción");
 }

 private List getTiposValor() throws BaseException {
   return TipoValorFormaPago.getTiposValorFormaPago(this,getSesion());
 }

 public List getTiposValores() throws BaseException {
   if (readTiposValores) {
     List listaTiposDeValores = this.getTiposValor();
     tiposValor.addAll(listaTiposDeValores);
     readTiposValores = false;
   }
   return tiposValor;
 }

 public void addTipoValor(TipoValorFormaPago aTipoValorFormaPago) throws BaseException {
   aTipoValorFormaPago.setFormapago(this);
   tiposValor.add(aTipoValorFormaPago);
 }

 public void afterSave() throws BaseException {
   Iterator iterTiposValores = tiposValor.iterator();
   while (iterTiposValores.hasNext()) {
     TipoValorFormaPago tipoValorFormaPago =
         (TipoValorFormaPago) iterTiposValores.next();
     tipoValorFormaPago.save();
     tipoValorFormaPago = null;
   }
   iterTiposValores = null;
 }
 
 public static List getAllFormasDePago(ISesion aSesion)
	throws BaseException {
	 return DBFormaPago.getAllFormasDePago(aSesion);
}
 
 
 



}
