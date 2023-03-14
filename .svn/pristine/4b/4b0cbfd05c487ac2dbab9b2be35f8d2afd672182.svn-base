package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.da.DBEstructuraPlanificacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EstructuraPlanificacion extends ObjetoLogico { 

  public EstructuraPlanificacion() { 
  }

  public static String NICKNAME = "pl.EstructuraPlanificacion";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private GrupoEstructuraPlanif grupoEstructuraPlanif;
  
  private List nodosEstructura = new ArrayList();
  private boolean readNodosEstructura = true;
  

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setGrupoEstructuraPlanif(GrupoEstructuraPlanif aGrupoEstructuraPlanif) { 
    this.grupoEstructuraPlanif =  aGrupoEstructuraPlanif;
  }
  
  public GrupoEstructuraPlanif getGrupoEstructuraPlanif() throws BaseException { 
    supportRefresh();
    return this.grupoEstructuraPlanif;
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

 public static EstructuraPlanificacion findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EstructuraPlanificacion) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EstructuraPlanificacion findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (EstructuraPlanificacion) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 
 public static EstructuraPlanificacion findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EstructuraPlanificacion) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");
    Validar.noNulo(grupoEstructuraPlanif, "Debe ingresar el Grupo");
 }
 
 public List getNodosEstructura() throws BaseException {
   if (this.readNodosEstructura) {
     List listaNodos = NodoEstructuraPlanificacion.getNodosEstructura(this,getSesion());
     this.nodosEstructura.addAll(listaNodos);
     this.readNodosEstructura = false;
   }
   return this.nodosEstructura;
 }

 public void addNodoEstructura(NodoEstructuraPlanificacion aNodo) throws BaseException {
	 aNodo.setEstructura_planificacion(this);
	 this.nodosEstructura.add(aNodo);
 }

 public void afterSave() throws BaseException {
   Iterator iterNodos = this.nodosEstructura.iterator();
   while (iterNodos.hasNext()) {
     NodoEstructuraPlanificacion nodo = (NodoEstructuraPlanificacion) iterNodos.next();
     nodo.save();
     nodo = null;
   }
   iterNodos = null;
 }
 
 public static List getAllEstructuras(ISesion aSesion) throws BaseException {
 	return DBEstructuraPlanificacion.getAllEstructuras(aSesion);
 }
 
 

}
