package com.srn.erp.cip.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.da.DBMotivoVisita;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivoVisita extends ObjetoLogico { 

  public MotivoVisita() { 
  }

  public static String NICKNAME = "cip.MotivoVisita";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private boolean habEnIngPermiso;
  
  private List motivosVisitaDoc = new ArrayList();
  private boolean readMotivosVisitaDoc = true;

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }
  
  public boolean isHabEnIngPermiso() throws BaseException { 
	    supportRefresh();
	    return this.habEnIngPermiso;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public void setHabEnIngPermiso(boolean aHabEnIngPermiso) { 
	this.habEnIngPermiso =  aHabEnIngPermiso;
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

  public static MotivoVisita findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
    return (MotivoVisita) getObjectByOidProxy(NICKNAME,oid,aSesion);
  }
 
  public static MotivoVisita findByOid(Integer oid , ISesion aSesion) throws BaseException { 
	   return (MotivoVisita) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 

  public static MotivoVisita findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (MotivoVisita) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

  public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
  }
  
  public List getDocumentacion() throws BaseException {
	    if (this.readMotivosVisitaDoc) {
	      List listaMotivosVisitaDoc = MotivoVisitaDoc.getMotivosVisita(this,getSesion());
	      this.motivosVisitaDoc.addAll(listaMotivosVisitaDoc);
	      this.readMotivosVisitaDoc = false;
	    }
	    return motivosVisitaDoc;
  }

  public void addDocuMotivo(MotivoVisitaDoc aMotivoVisitaDoc) throws BaseException {
	  aMotivoVisitaDoc.setMotivo(this);
	  this.motivosVisitaDoc.add(aMotivoVisitaDoc);
  }

  public void afterSave() throws BaseException {
	    Iterator iterDocuMotivos = this.motivosVisitaDoc.iterator();
	    while (iterDocuMotivos.hasNext()) {
	      MotivoVisitaDoc motivoVisitaDoc = (MotivoVisitaDoc) iterDocuMotivos.next();
	      motivoVisitaDoc.save();
	      motivoVisitaDoc = null;
	    }
	    iterDocuMotivos = null;
  }

  public static List getMotivosIngesoManual(
          ISesion aSesion) throws BaseException {
	  return DBMotivoVisita.getMotivosIngesoManual(aSesion);
  }


}
