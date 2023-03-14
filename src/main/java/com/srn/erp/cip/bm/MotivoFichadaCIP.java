package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBMotivoFichadaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivoFichadaCIP extends ObjetoLogico { 

  @Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return this.getDescripcion();
	}

public MotivoFichadaCIP() { 
  }

  public static String NICKNAME = "cip.MotivoFichadaCIP";

  private String descripcion;
  private Boolean entrada;
  private Boolean requiere_obs_ent;
  private Boolean salida;
  private Boolean requiere_obs_sal;
  private Integer orden_entrada;
  private Integer orden_salida;
  private Boolean activo;

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Boolean isEntrada() throws BaseException { 
    supportRefresh();
    return entrada;
  }

  public void setEntrada(Boolean aEntrada) { 
    this.entrada =  aEntrada;
  }

  public Boolean isRequiere_obs_ent() throws BaseException { 
    supportRefresh();
    return requiere_obs_ent;
  }

  public void setRequiere_obs_ent(Boolean aRequiere_obs_ent) { 
    this.requiere_obs_ent =  aRequiere_obs_ent;
  }

  public Boolean isSalida() throws BaseException { 
    supportRefresh();
    return salida;
  }

  public void setSalida(Boolean aSalida) { 
    this.salida =  aSalida;
  }

  public Boolean isRequiere_obs_sal() throws BaseException { 
    supportRefresh();
    return requiere_obs_sal;
  }

  public void setRequiere_obs_sal(Boolean aRequiere_obs_sal) { 
    this.requiere_obs_sal =  aRequiere_obs_sal;
  }

  public Integer getOrden_entrada() throws BaseException { 
    supportRefresh();
    return orden_entrada;
  }

  public void setOrden_entrada(Integer aOrden_entrada) { 
    this.orden_entrada =  aOrden_entrada;
  }

  public Integer getOrden_salida() throws BaseException { 
    supportRefresh();
    return orden_salida;
  }

  public void setOrden_salida(Integer aOrden_salida) { 
    this.orden_salida =  aOrden_salida;
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

 public static MotivoFichadaCIP findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (MotivoFichadaCIP) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static MotivoFichadaCIP findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (MotivoFichadaCIP) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static MotivoFichadaCIP findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (MotivoFichadaCIP) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
 }
 
 public static List getMotivosFichadas(ISesion aSesion) throws BaseException {
	  return DBMotivoFichadaCIP.getMotivosFichadas(aSesion);
 } 

}
