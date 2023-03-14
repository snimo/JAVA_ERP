package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Escenario extends ObjetoLogico { 

  public Escenario() { 
  }

  public static String NICKNAME = "pl.Escenario";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  
  private List detallesCompoEscenario = new ArrayList();
  private boolean readDetallesCompoEscenario = true;  
  
  private List detallesValoresEscenario = new ArrayList();
  private boolean readDetallesValoresEscenario = true;  
  
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

 public static Escenario findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (Escenario) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static Escenario findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (Escenario) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 

 public static Escenario findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (Escenario) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
 }
 
 public List getDetallesCompoEsce() throws BaseException {
   if (this.readDetallesCompoEscenario) {
     List listaDetalles = CompoEscenario.getDetallesEscenario(this,getSesion());
     detallesCompoEscenario.addAll(listaDetalles);
     this.readDetallesCompoEscenario = false;
   }
   return detallesCompoEscenario;
 }
 
 public List getValores() throws BaseException {
   if (this.readDetallesValoresEscenario) {
     List listaValores = ValorEscenario.getValoresByEscenario(this,getSesion());
     this.detallesValoresEscenario.addAll(listaValores);
     this.readDetallesValoresEscenario = false;
   }
   return this.detallesValoresEscenario;
 }
 

 public void addDetalleCompoEscenario(CompoEscenario aCompoEsce) throws BaseException {
	 aCompoEsce.setEscenario(this);
	 detallesCompoEscenario.add(aCompoEsce);
 }


 public void addValorEscenario(ValorEscenario aValorEscenario) throws BaseException {
	 aValorEscenario.setEscenario(this);
	 detallesValoresEscenario.add(aValorEscenario);
 }
 
 
 public void afterSave() throws BaseException {
	 
   Iterator iterCompoEsce = this.detallesCompoEscenario.iterator();
   while (iterCompoEsce.hasNext()) {
     CompoEscenario compoEscenario = 
    	 (CompoEscenario) iterCompoEsce.next();
     compoEscenario.save();
     compoEscenario = null;
   }
   iterCompoEsce = null;
   
   Iterator iterValorEsce = this.detallesValoresEscenario.iterator();
   while (iterValorEsce.hasNext()) {
     	ValorEscenario valorEscenario = 
    	 (ValorEscenario) iterValorEsce.next();
     	valorEscenario.save();
     	valorEscenario = null;
   }
   iterValorEsce = null;
   
   
   
 }
 

}
