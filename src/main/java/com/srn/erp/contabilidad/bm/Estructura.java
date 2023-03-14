package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBEstructuraCompo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Estructura extends ObjetoLogico {

  public Estructura() {
  }

  public static String NICKNAME = "cg.Estructura";

  private String codigo;
  private String descripcion;
  private Boolean activo;

  private List listaComponentes = new ArrayList();
  private boolean leerComponentes = true;


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

 public static Estructura findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Estructura) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static Estructura findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Estructura) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }

 public static Estructura findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Estructura) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La estructura debe estar em modo activo");

 }

 public List getEstrucComponenentes() throws BaseException {

   if (leerComponentes) {
     List listaDeComponentes = DBEstructuraCompo.getEstrucCompoByEstruc(this,getSesion());
     listaComponentes.addAll(listaDeComponentes);
     leerComponentes = false;
   }

   return listaComponentes;
 }

 public List getComponenentesConAux() throws BaseException {
     List listaCompoActualConAux = new ArrayList();
     List listaDeComponentes = DBEstructuraCompo.getEstrucCompoByEstruc(this,getSesion());
     Iterator iterEstrucCompo = listaDeComponentes.iterator();
     while (iterEstrucCompo.hasNext()) {
       EstructuraCompo estrucCompo = (EstructuraCompo) iterEstrucCompo.next();
       listaCompoActualConAux.addAll(
           estrucCompo.getComponente().getListaCompoActualyAuxiliares());
     }
   return listaCompoActualConAux;
 }


 public void addEstructuraCompo(EstructuraCompo estructuraCompo) throws BaseException {
   estructuraCompo.setEstructura(this);
   listaComponentes.add(estructuraCompo);
 }

 public void afterSave() throws BaseException {
   Iterator iterEstructuraCompo = listaComponentes.iterator();
   while (iterEstructuraCompo.hasNext()) {
     EstructuraCompo estructuraCompo = (EstructuraCompo) iterEstructuraCompo.next();
     estructuraCompo.save();
     estructuraCompo = null;
   }
   iterEstructuraCompo = null;
 }
 
 public boolean isPerteneceAEstructura(Componente compo) throws BaseException {
	 Iterator iterExtruCompo = 
		 getEstrucComponenentes().iterator();
	 while (iterExtruCompo.hasNext()) {
		 EstructuraCompo estCompo = (EstructuraCompo) iterExtruCompo.next();
		 if (estCompo.getComponente().getOID() == compo.getOID())
			 return true;
	 }
	 return false;
 }
 




}
