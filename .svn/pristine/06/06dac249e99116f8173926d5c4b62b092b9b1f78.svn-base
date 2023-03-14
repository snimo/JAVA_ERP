package com.srn.erp.bienUso.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.bienUso.da.DBConfColAnexoA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ConfColAnexoA extends ObjetoLogico { 

  public ConfColAnexoA() { 
  }

  public static String NICKNAME = "bu.ConfColAnexoA";
  
  public static final String TE_AL_INICIO = "INICIO";
  public static final String TE_EJER_ACTUAL = "ACTUAL";
  
  private List confMovimientos = new ArrayList();
  private boolean readConfMovimientos = true;
  

  private String codigo;
  private String descripcion;
  private Integer nro_col;
  private String tipo_ejercicio;
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

  public Integer getNro_col() throws BaseException { 
    supportRefresh();
    return nro_col;
  }

  public void setNro_col(Integer aNro_col) { 
    this.nro_col =  aNro_col;
  }

  public String getTipo_ejercicio() throws BaseException { 
    supportRefresh();
    return tipo_ejercicio;
  }

  public void setTipo_ejercicio(String aTipo_ejercicio) { 
    this.tipo_ejercicio =  aTipo_ejercicio;
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

 public static ConfColAnexoA findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ConfColAnexoA) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ConfColAnexoA findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	return (ConfColAnexoA) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 
 public static ConfColAnexoA findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ConfColAnexoA) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(nro_col, "Debe ingresar el Nro. de Columna");
    Validar.noNulo(tipo_ejercicio, "Debe ingresar el Tipo de Ejercicio");
    Validar.noNulo(activo, "Debe indicar si esta activo");
 }
 
 public List getConfColAnexoMovimientos() throws BaseException {
   if (readConfMovimientos) {
	   List listaConfColAnexoAMov = ConfColAnexoAMov.getConfColAnexoAMov(this,getSesion());
	   confMovimientos.addAll(listaConfColAnexoAMov);
	   readConfMovimientos = false;
   }
   return confMovimientos; 
 }
 
 public boolean tieneEsteMovimiento(String tipoMov) throws BaseException {
   Iterator iterConfMov = getConfColAnexoMovimientos().iterator();
	 while (iterConfMov.hasNext()) {
	   ConfColAnexoAMov confColMov = (ConfColAnexoAMov)iterConfMov.next();
	   if (confColMov.getTipo_mov().equals(tipoMov))
			 return true;
   }
   return false;
 }

  public void addConfColAnexoAMov(ConfColAnexoAMov  aConfColAnexoAMov) throws BaseException {
	  aConfColAnexoAMov.setConf_col_aneoxo(this);
	  confMovimientos.add(aConfColAnexoAMov);
  }

  public void afterSave() throws BaseException {
	Iterator iterConfColAnexoAMov = confMovimientos.iterator();
	while (iterConfColAnexoAMov.hasNext()) {
	  ConfColAnexoAMov confColAnexoAMov = (ConfColAnexoAMov) iterConfColAnexoAMov.next();
	  confColAnexoAMov.save();
	  confColAnexoAMov = null;
	}
	iterConfColAnexoAMov = null;
  }
  
  public static List getConfColAnexoA(ISesion aSesion) throws BaseException {
	  return DBConfColAnexoA.getConfColAnexoA(aSesion);
  }  
  
  public static List getConfColAnexoAAlIniEjer(ISesion aSesion) throws BaseException {
	  List listaNueva = new ArrayList();
	  List listaConfCol = getConfColAnexoA(aSesion);
	  Iterator iterConfCol = listaConfCol.iterator();
	  while (iterConfCol.hasNext()) {
		  ConfColAnexoA confColAnexoA = (ConfColAnexoA) iterConfCol.next();
		  if (!confColAnexoA.getTipo_ejercicio().equals(ConfColAnexoA.TE_AL_INICIO)) continue;
		  listaNueva.add(confColAnexoA);
	  }
	  return listaNueva;
  }

  public static List getConfColAnexoAEnEjerActual(ISesion aSesion) throws BaseException {
	  List listaNueva = new ArrayList();
	  List listaConfCol = getConfColAnexoA(aSesion);
	  Iterator iterConfCol = listaConfCol.iterator();
	  while (iterConfCol.hasNext()) {
		  ConfColAnexoA confColAnexoA = (ConfColAnexoA) iterConfCol.next();
		  if (!confColAnexoA.getTipo_ejercicio().equals(ConfColAnexoA.TE_EJER_ACTUAL)) continue;
		  listaNueva.add(confColAnexoA);
	  }
	  return listaNueva;
  }  
}
