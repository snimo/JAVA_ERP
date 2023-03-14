package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBMotEntIntVis;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotEntIntVis extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public MotEntIntVis() { 
  }

  public static String NICKNAME = "cip.MotEntIntVis";

  private Visita visita;
  private MotivoEntIntermedias motivo;
  private Boolean activo;
  private GrupoVisita grupoVisita;

  public Visita getVisita() throws BaseException { 
    supportRefresh();
    return visita;
  }
  
  public GrupoVisita getGrupoVisita() throws BaseException { 
	    supportRefresh();
	    return this.grupoVisita;
  }
  
  public void setVisita(Visita aVisita) { 
    this.visita =  aVisita;
  }
  
  public void setGrupoVisita(GrupoVisita aGrupoVisita) { 
	    this.grupoVisita =  aGrupoVisita;
  }
  

  public MotivoEntIntermedias getMotivo() throws BaseException { 
    supportRefresh();
    return motivo;
  }

  public void setMotivo(MotivoEntIntermedias aMotivo) { 
    this.motivo =  aMotivo;
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

 public static MotEntIntVis findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (MotEntIntVis) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static MotEntIntVis findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (MotEntIntVis) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(motivo, "Debe ingresar el Motivo");
 }
 
 public static List getMotEntIntermedias(
		  Visita visita,
         ISesion aSesion) throws BaseException {
	  return DBMotEntIntVis.getMotEntIntermedias(visita,aSesion);
 }
 
 public static MotEntIntVis getMotEntIntVis(
		  Visita visita,
		  MotivoEntIntermedias motivo,
         ISesion aSesion)
         throws BaseException {
	  return DBMotEntIntVis.getMotEntIntVis(visita,motivo,aSesion);
 }
 
 public static MotEntIntVis getMotEntIntVis(
		  GrupoVisita grupo,
		  MotivoEntIntermedias motivo,
        ISesion aSesion)
        throws BaseException {
	  return DBMotEntIntVis.getMotEntIntVis(grupo,motivo,aSesion);
}

}
