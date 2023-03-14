package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.PeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SubReparto extends ObjetoLogico {
	
  private List subrepartosDet = new ArrayList();
  private boolean readSubRepartposDet = true;
	
  public SubReparto() { 
  }

  public static String NICKNAME = "cg.SubReparto";

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

 public static SubReparto findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SubReparto) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static SubReparto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (SubReparto) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 

 public static SubReparto findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SubReparto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public List getSubRepartosDet() throws BaseException {
	if (readSubRepartposDet) {
	      List listaSubRepartosDet = SubRepartoDet.getSubRepartosDet(this,getSesion());
	      subrepartosDet.addAll(listaSubRepartosDet);
	      readSubRepartposDet = false;
	}
	return subrepartosDet;
 }

 public void addSubRepartoDet(SubRepartoDet aSubRepartoDet) throws BaseException {
	 aSubRepartoDet.setSubreparto(this);
	 subrepartosDet.add(aSubRepartoDet);
 }

 public void afterSave() throws BaseException {
	Iterator iterSubRepartosDet = subrepartosDet.iterator();
	while (iterSubRepartosDet.hasNext()) {
	      SubRepartoDet subRepartoDet = (SubRepartoDet) iterSubRepartosDet.next();
	      subRepartoDet.save();
	      subRepartoDet = null;
	}
	iterSubRepartosDet = null;
 }
 

}
