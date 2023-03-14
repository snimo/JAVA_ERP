package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBCIPFichadaOficina;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class CIPFichadaOficina extends ObjetoLogico { 

  @Override
	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public CIPFichadaOficina() { 
  }

  public static String NICKNAME = "cip.CIPFichadaOficina";
  public static final String ENTRADA = "E";
  public static final String SALIDA = "S";
 
  private Legajo legajo;
  private java.util.Date fec_hor;
  private String sentido;
  private PuntoFichadaCIP oid_pto_fichada;
  private MotivoFichadaCIP motivo_fichada;
  private String observacion;
  private Boolean activo;

  public Legajo getLegajo() throws BaseException { 
    supportRefresh();
    return legajo;
  }

  public void setLegajo(Legajo aLegajo) { 
    this.legajo =  aLegajo;
  }

  public java.util.Date getFec_hor() throws BaseException { 
    supportRefresh();
    return fec_hor;
  }

  public void setFec_hor(java.util.Date aFec_hor) { 
    this.fec_hor =  aFec_hor;
  }

  public String getSentido() throws BaseException { 
    supportRefresh();
    return sentido;
  }

  public void setSentido(String aSentido) { 
    this.sentido =  aSentido;
  }

  public PuntoFichadaCIP getOid_pto_fichada() throws BaseException { 
    supportRefresh();
    return oid_pto_fichada;
  }

  public void setOid_pto_fichada(PuntoFichadaCIP aOid_pto_fichada) { 
    this.oid_pto_fichada =  aOid_pto_fichada;
  }

  public MotivoFichadaCIP getMotivo_fichada() throws BaseException { 
    supportRefresh();
    return motivo_fichada;
  }

  public void setMotivo_fichada(MotivoFichadaCIP aMotivo_fichada) { 
    this.motivo_fichada =  aMotivo_fichada;
  }

  public String getObservacion() throws BaseException { 
    supportRefresh();
    return observacion;
  }

  public void setObservacion(String aObservacion) { 
    this.observacion =  aObservacion;
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

 public static CIPFichadaOficina findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CIPFichadaOficina) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static CIPFichadaOficina findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (CIPFichadaOficina) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(legajo, "Debe ingresar el Legajo");
    Validar.noNulo(fec_hor, "Debe ingresar le Fecha/Hora");
    Validar.noNulo(sentido, "Debe ingresar el Sentido");
    Validar.noNulo(oid_pto_fichada, "Debe ingresar el Punto Fichada");
    Validar.noNulo(motivo_fichada, "Debe ingresar el Motivo Fichada");
 }
 
 public static List getFichadasOficinaAsc(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
		  Legajo legajo,
         ISesion aSesion) throws BaseException {
	  
	  return DBCIPFichadaOficina.getFichadasOficinaAsc(fecDesde,fecHasta,legajo,aSesion);
	  
 }
 
 public static List getFichadasOficinaDesc(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
		  Legajo legajo,
        ISesion aSesion) throws BaseException {
	  
	  return DBCIPFichadaOficina.getFichadasOficinaDesc(fecDesde,fecHasta,legajo,aSesion);
	  
} 
 
 
 public static List getFichadasOficinaOrderByLegFec(
		  java.util.Date fecDesde,
		  java.util.Date fecHasta,
	      ISesion aSesion) throws BaseException {
	  	  
	  return DBCIPFichadaOficina.getFichadasOficinaOrderByLegFec(fecDesde,fecHasta,aSesion);
            
 }  
 

}
