package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UPC extends ObjetoLogico { 

  public UPC() { 
  }

  public static String NICKNAME = "pl.UPC";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  
  private List tiposUPCHabilitados = new ArrayList();
  private boolean readTiposUPCHabilitados = true;
  

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

 public static UPC findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (UPC) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static UPC findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (UPC) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static UPC findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (UPC) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public List getTiposUPCHabilitados() throws BaseException {
   if (this.readTiposUPCHabilitados) {
     List listaUPCHabilitados = TipoHabilitadoUPC.getTiposHabilitadosUPC(this,getSesion());
     this.tiposUPCHabilitados.addAll(listaUPCHabilitados);
     this.readTiposUPCHabilitados = false;
   }
   return this.tiposUPCHabilitados;
 }

 public void addTipoUPCHabilitado(TipoHabilitadoUPC tipoHabilitadoUPC) throws BaseException {
	 tipoHabilitadoUPC.setUpc(this);
   this.tiposUPCHabilitados.add(tipoHabilitadoUPC);
 }

 public void afterSave() throws BaseException {
   Iterator iterTiposHabilitadosUPC = this.tiposUPCHabilitados.iterator();
   while (iterTiposHabilitadosUPC.hasNext()) {
     TipoHabilitadoUPC tipoHabilitadoUPC = (TipoHabilitadoUPC) iterTiposHabilitadosUPC.next();
     tipoHabilitadoUPC.save();
     tipoHabilitadoUPC = null;
   }
   iterTiposHabilitadosUPC = null;
 }
 

}
