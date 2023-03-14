package com.srn.erp.cip.bm;

import java.util.List;

import com.srn.erp.cip.da.DBMotivoVisitaDoc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class MotivoVisitaDoc extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public MotivoVisitaDoc() { 
  }

  public static String NICKNAME = "cip.MotivoVisitaDoc";

  private MotivoVisita motivo;
  private TipoDocumentacionCIP tipo_docu;
  private Integer dias_aviso_venc;
  private Boolean activo;

  public MotivoVisita getMotivo() throws BaseException { 
    supportRefresh();
    return motivo;
  }

  public void setMotivo(MotivoVisita aMotivo) { 
    this.motivo =  aMotivo;
  }

  public TipoDocumentacionCIP getTipo_docu() throws BaseException { 
    supportRefresh();
    return tipo_docu;
  }

  public void setTipo_docu(TipoDocumentacionCIP aTipo_docu) { 
    this.tipo_docu =  aTipo_docu;
  }

  public Integer getDias_aviso_venc() throws BaseException { 
    supportRefresh();
    return dias_aviso_venc;
  }

  public void setDias_aviso_venc(Integer aDias_aviso_venc) { 
    this.dias_aviso_venc =  aDias_aviso_venc;
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

 public static MotivoVisitaDoc findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (MotivoVisitaDoc) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static MotivoVisitaDoc findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (MotivoVisitaDoc) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(motivo, "Debe ingresar el Motivo");
    Validar.noNulo(tipo_docu, "Tipo de Documentación");
 }
 
 public static List getMotivosVisita(
		  MotivoVisita motivo,
         ISesion aSesion) throws BaseException {
	  return DBMotivoVisitaDoc.getMotivosVisita(motivo,aSesion);
 }
 
 public static MotivoVisitaDoc getMotivoVisitaDoc(
		  MotivoVisita motivo,
		  TipoDocumentacionCIP tipoDocumentacion,
         ISesion aSesion)
         throws BaseException {
	  return DBMotivoVisitaDoc.getMotivoVisitaDoc(motivo,tipoDocumentacion,aSesion);
 }
 
 

}
