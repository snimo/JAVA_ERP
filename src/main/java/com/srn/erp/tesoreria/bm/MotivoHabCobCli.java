package com.srn.erp.tesoreria.bm;

import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.tesoreria.da.DBMotivoHabCobCli;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class MotivoHabCobCli extends ObjetoLogico { 

  public MotivoHabCobCli() { 
  }

  public static String NICKNAME = "te.MotivoHabCobCli";

  private MotivoTC motivo_tc;
  private Boolean habilitado;

  public MotivoTC getMotivo_tc() throws BaseException { 
    supportRefresh();
    return motivo_tc;
  }

  public void setMotivo_tc(MotivoTC aMotivo_tc) { 
    this.motivo_tc =  aMotivo_tc;
  }

  public Boolean isHabilitado() throws BaseException { 
    supportRefresh();
    return habilitado;
  }

  public void setHabilitado(Boolean aHabilitado) { 
    this.habilitado =  aHabilitado;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public static MotivoHabCobCli findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (MotivoHabCobCli) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static MotivoHabCobCli findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (MotivoHabCobCli) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(motivo_tc, "Debe ingresar el Motivo");
 }
 
 public static MotivoHabCobCli getMotivoHabCobCli(MotivoTC motivoTC,
     ISesion aSesion)
     throws BaseException {
 	return DBMotivoHabCobCli.getMotivoHabCobCli(motivoTC,aSesion);
 }

 

}
