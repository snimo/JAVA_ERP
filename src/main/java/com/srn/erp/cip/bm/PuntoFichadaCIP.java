package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBPuntoFichadaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class PuntoFichadaCIP extends ObjetoLogico { 

  public PuntoFichadaCIP() { 
  }

  public static String NICKNAME = "cip.PuntoFichadaCIP";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private Boolean antipassback_ent;
  private Boolean antipassback_sal;
  

  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }
  
  public Boolean isAntipassbackEnt() throws BaseException { 
	    supportRefresh();
	    return this.antipassback_ent;
  }  
  
  public Boolean isAntipassbackSal() throws BaseException { 
	    supportRefresh();
	    return this.antipassback_sal;
  }  

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }
  
  public void setAntiPassbackEnt(Boolean aAntipassbackEnt) { 
	    this.antipassback_ent =  aAntipassbackEnt;
  }  
  
  public void setAntiPassbackSal(Boolean aAntipassbackSal) { 
	    this.antipassback_sal =  aAntipassbackSal;
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

 public static PuntoFichadaCIP findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (PuntoFichadaCIP) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 
 public static PuntoFichadaCIP findByOid(Integer oid , ISesion aSesion) throws BaseException { 
	   return (PuntoFichadaCIP) getObjectByOid(NICKNAME,oid,aSesion);
	  } 

 public static PuntoFichadaCIP findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (PuntoFichadaCIP) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public static List getAllPuntosFichada(ISesion aSesion) throws BaseException {
	  
	  return DBPuntoFichadaCIP.getAllPuntosFichada(aSesion);
 }
 

}
