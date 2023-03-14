package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstructuraPlan extends ObjetoLogico { 

  public EstructuraPlan() { 
  }

  public static String NICKNAME = "pl.EstructuraPlan";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  
  private List componentesEstruc = new ArrayList();
  private boolean readComponentesEstruc = true;
  

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

 public static EstructuraPlan findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EstructuraPlan) getObjectByOid(NICKNAME,oid,aSesion);
 }
 
 public static EstructuraPlan findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (EstructuraPlan) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 

 public static EstructuraPlan findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EstructuraPlan) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public List getComponentesEstrucPlan() throws BaseException {
   if (this.readComponentesEstruc) {
     List listaCompoEstrucPlan = CompoEstructuraPlan.getCompoEstrucPlan(this,getSesion());
     componentesEstruc.addAll(listaCompoEstrucPlan);
     readComponentesEstruc = false;
   }
   return this.componentesEstruc;
 }

 public void addCompoEstrucPlan(CompoEstructuraPlan aCompoEstrucPlan) throws BaseException {
	 aCompoEstrucPlan.setEstructura_plan(this);
   componentesEstruc.add(aCompoEstrucPlan);
 }

 public void afterSave() throws BaseException {
   Iterator iterCompoEstrucPlan = this.componentesEstruc.iterator();
   while (iterCompoEstrucPlan.hasNext()) {
     CompoEstructuraPlan compoEstrucPlan = (CompoEstructuraPlan) iterCompoEstrucPlan.next();
     compoEstrucPlan.save();
     compoEstrucPlan = null;
   }
   iterCompoEstrucPlan = null;
 } 

}
