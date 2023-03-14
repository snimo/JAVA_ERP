package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBRotaVisita;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class RotaVisita extends ObjetoLogico { 

  public RotaVisita() { 
  }

  public static String NICKNAME = "cip.RotaVisita";

  private java.util.Date fecha;
  private Visita visita;
  private Rota rota;
  private Boolean activo;
  private GrupoVisita grupoVisita;

  public java.util.Date getFecha() throws BaseException { 
    supportRefresh();
    return fecha;
  }
  
  public GrupoVisita getGrupoVisita() throws BaseException { 
	    supportRefresh();
	    return grupoVisita;
  }

  public void setFecha(java.util.Date aFecha) { 
    this.fecha =  aFecha;
  }
  
  public void setGrupoVisita(GrupoVisita aGrupoVisita) { 
	this.grupoVisita =  aGrupoVisita;
  }

  public Visita getVisita() throws BaseException { 
    supportRefresh();
    return visita;
  }

  public void setVisita(Visita aVisita) { 
    this.visita =  aVisita;
  }

  public Rota getRota() throws BaseException { 
    supportRefresh();
    return rota;
  }

  public void setRota(Rota aRota) { 
    this.rota =  aRota;
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

 public static RotaVisita findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RotaVisita) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RotaVisita findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RotaVisita) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(fecha, "Debe ingresar la Fecha");
    Validar.noNulo(rota, "Debe ingresar la Rota");
 }

public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}


public static RotaVisita getRotaVisita(
		  Visita visita,
		  Rota rota,
		  java.util.Date fecha,
        ISesion aSesion)
        throws BaseException {
	  return DBRotaVisita.getRotaVisita(visita,rota,fecha,aSesion);
}

public static RotaVisita getRotaVisita(
		  GrupoVisita grupo,
		  Rota rota,
		  java.util.Date fecha,
        ISesion aSesion)
        throws BaseException {
	  return DBRotaVisita.getRotaVisita(grupo,rota,fecha,aSesion);
}

public static RotaVisita getBuscarRotaVisita(
		  GrupoVisita grupoVisita,
		  java.util.Date fecha,
        ISesion aSesion)
        throws BaseException {
	  return DBRotaVisita.geBuscartRotaVisita(grupoVisita,fecha,aSesion);
}


public static List getRotasVisita(Visita visita,
        ISesion aSesion) throws BaseException {
	  return DBRotaVisita.getRotasVisita(visita,aSesion);
}

 public static List getRotasVisita(Visita visita,
		  java.util.Date fecha,
        ISesion aSesion) throws BaseException {
	  return DBRotaVisita.getRotasVisita(visita,fecha,aSesion);
 }
 

 public static List getRotasVisita(GrupoVisita grupo,
		  java.util.Date fecha,
        ISesion aSesion) throws BaseException {
	  return DBRotaVisita.getRotasVisita(grupo,fecha,aSesion);
}
 
 public static RotaVisita getBuscarRotaVisita(
		  Visita visita,
		  java.util.Date fecha,
         ISesion aSesion)
         throws BaseException {
	  return DBRotaVisita.getBuscarRotaVisita(visita,fecha,aSesion);
 }
 



}
