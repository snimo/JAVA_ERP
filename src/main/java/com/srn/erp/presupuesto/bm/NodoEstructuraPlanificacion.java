package com.srn.erp.presupuesto.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.presupuesto.da.DBNodoEstructuraPlanificacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class NodoEstructuraPlanificacion extends ObjetoLogico { 

  public NodoEstructuraPlanificacion() { 
  }

  public static String NICKNAME = "pl.NodoEstructuraPlanificacion";

  private EstructuraPlanificacion estructura_planificacion;
  private Integer nro_relacion;
  private Integer nro_relacion_padre;
  private String nombre;
  private Integer ancho;
  private Integer alto;
  private Integer color;
  private Integer orden;
  private String alineacion;
  private Boolean activo;
  
  private List UPCHabilitadas = new ArrayList();
  private boolean readUPCHabilitadas = true;
  

  public EstructuraPlanificacion getEstructura_planificacion() throws BaseException { 
    supportRefresh();
    return estructura_planificacion;
  }

  public void setEstructura_planificacion(EstructuraPlanificacion aEstructura_planificacion) { 
    this.estructura_planificacion =  aEstructura_planificacion;
  }

  public Integer getNro_relacion() throws BaseException { 
    supportRefresh();
    return nro_relacion;
  }

  public void setNro_relacion(Integer aNro_relacion) { 
    this.nro_relacion =  aNro_relacion;
  }

  public Integer getNro_relacion_padre() throws BaseException { 
    supportRefresh();
    return nro_relacion_padre;
  }

  public void setNro_relacion_padre(Integer aNro_relacion_padre) { 
    this.nro_relacion_padre =  aNro_relacion_padre;
  }

  public String getNombre() throws BaseException { 
    supportRefresh();
    return nombre;
  }

  public void setNombre(String aNombre) { 
    this.nombre =  aNombre;
  }

  public Integer getAncho() throws BaseException { 
    supportRefresh();
    return ancho;
  }

  public void setAncho(Integer aAncho) { 
    this.ancho =  aAncho;
  }

  public Integer getAlto() throws BaseException { 
    supportRefresh();
    return alto;
  }

  public void setAlto(Integer aAlto) { 
    this.alto =  aAlto;
  }

  public Integer getColor() throws BaseException { 
    supportRefresh();
    return color;
  }

  public void setColor(Integer aColor) { 
    this.color =  aColor;
  }

  public Integer getOrden() throws BaseException { 
    supportRefresh();
    return orden;
  }

  public void setOrden(Integer aOrden) { 
    this.orden =  aOrden;
  }

  public String getAlineacion() throws BaseException { 
    supportRefresh();
    return alineacion;
  }

  public void setAlineacion(String aAlineacion) { 
    this.alineacion =  aAlineacion;
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

 public static NodoEstructuraPlanificacion findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (NodoEstructuraPlanificacion) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static NodoEstructuraPlanificacion findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (NodoEstructuraPlanificacion) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static NodoEstructuraPlanificacion findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (NodoEstructuraPlanificacion) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(estructura_planificacion, "Debe ingresar la Estructura de Planificacion");
    Validar.noNulo(nombre, "Debe ingresar el Nombre del Nodo");
 }

 public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }

 public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }
 
 public static List getNodosEstructura(EstructuraPlanificacion estructura,
    ISesion aSesion) throws BaseException {
	return DBNodoEstructuraPlanificacion.getNodosEstructura(estructura,aSesion);
 }
 
 public List getUPCHabilitadas() throws BaseException {
   if (this.readUPCHabilitadas) {
     List listaUPCHabilitadas = UPCNodoEstructura.getUPCsByNodo(this,getSesion());
     this.UPCHabilitadas.addAll(listaUPCHabilitadas);
     this.readUPCHabilitadas = false;
   }
   return this.UPCHabilitadas;
 }

 public void addUPCHabilitada(UPCNodoEstructura upcNodo) throws BaseException {
	 upcNodo.setNodo_estructura(this);
   this.UPCHabilitadas.add(upcNodo);
 }

 public void afterSave() throws BaseException {
   Iterator iterUPCHabilitadas = this.UPCHabilitadas.iterator();
   while (iterUPCHabilitadas.hasNext()) {
     UPCNodoEstructura upcNodoEstructura = (UPCNodoEstructura) iterUPCHabilitadas.next();
     upcNodoEstructura.save();
     upcNodoEstructura = null;
   }
   iterUPCHabilitadas = null;
 }
 



}
