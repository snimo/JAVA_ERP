package com.srn.erp.general.bm;

import java.util.List;

import com.srn.erp.general.da.DBMotivoTC;
import com.srn.erp.tesoreria.bm.MotivoHabCobCli;
import com.srn.erp.tesoreria.bm.MotivoHabIngVar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivoTC extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public MotivoTC() { 
  }

  public static String NICKNAME = "ge.MotivoTC";

  private MotivoComprobante motivo_comprobante;
  private TipoComprobante tipo_comprobate;
  private Boolean activo;

  public MotivoComprobante getMotivo_comprobante() throws BaseException { 
    supportRefresh();
    return motivo_comprobante;
  }

  public void setMotivo_comprobante(MotivoComprobante aMotivo_comprobante) { 
    this.motivo_comprobante =  aMotivo_comprobante;
  }

  public TipoComprobante getTipo_comprobate() throws BaseException { 
    supportRefresh();
    return tipo_comprobate;
  }

  public void setTipo_comprobate(TipoComprobante aTipo_comprobate) { 
    this.tipo_comprobate =  aTipo_comprobate;
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

 public static MotivoTC findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (MotivoTC) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static MotivoTC findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (MotivoTC) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static MotivoTC findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (MotivoTC) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(motivo_comprobante, "Debe ingresar el Motivo Comprobante");
    Validar.noNulo(tipo_comprobate, "Debe ingresar el Tipo de Comprobante");
 }
 
 public static List getMotivosPorTC(TipoComprobante tipoComprobante,
         ISesion aSesion) throws BaseException {
   return DBMotivoTC.getMotivosPorTC(tipoComprobante,aSesion);   
 }
 
 public static List getMotivosRecibos(
     ISesion aSesion) throws BaseException {
 	return DBMotivoTC.getMotivosRecibos(aSesion);
 }
 
 public boolean isHabilitadoIngVar() throws BaseException {
	 
	 MotivoHabIngVar motHabIngVar = 
		 MotivoHabIngVar.getMotivoHabIngVar(this,this.getSesion());
	 
	 if ((motHabIngVar!=null) && (motHabIngVar.isHabilitado().booleanValue()))
		 return true;
	 else
		 return false;
	 
 }
 
 public boolean isHabilitadoCobCli() throws BaseException {
	 
	 MotivoHabCobCli motHabCobCli = 
		 MotivoHabCobCli.getMotivoHabCobCli(this,this.getSesion());
	 
	 if ((motHabCobCli!=null) && (motHabCobCli.isHabilitado().booleanValue()))
		 return true;
	 else
		 return false;
	 
 }
 
 
 

}
