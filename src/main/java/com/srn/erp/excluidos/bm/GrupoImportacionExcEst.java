package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBGrupoImportacionExcEst;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoImportacionExcEst extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

  public GrupoImportacionExcEst() { 
  }

  public static String NICKNAME = "exc.GrupoImportacionExcEst";

  private GrupoImportacionExcluido grupo_imp_esc;
  private PredioExcluido predio;
  private EstadoPredioExc estado;
  private Boolean activo;

  public GrupoImportacionExcluido getGrupo_imp_esc() throws BaseException { 
    supportRefresh();
    return grupo_imp_esc;
  }

  public void setGrupo_imp_esc(GrupoImportacionExcluido aGrupo_imp_esc) { 
    this.grupo_imp_esc =  aGrupo_imp_esc;
  }

  public PredioExcluido getPredio() throws BaseException { 
    supportRefresh();
    return predio;
  }

  public void setPredio(PredioExcluido aPredio) { 
    this.predio =  aPredio;
  }

  public EstadoPredioExc getEstado() throws BaseException { 
    supportRefresh();
    return estado;
  }

  public void setEstado(EstadoPredioExc aEstado) { 
    this.estado =  aEstado;
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

 public static GrupoImportacionExcEst findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoImportacionExcEst) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static GrupoImportacionExcEst findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (GrupoImportacionExcEst) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 

 public static GrupoImportacionExcEst findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoImportacionExcEst) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(grupo_imp_esc, "Debe ingresar el Grupo de Importación");
    Validar.noNulo(predio, "Debe ingresar el Predio");
    Validar.noNulo(estado, "Debe ingresar el Estado");
 }
 
 public static List getGruposImpExcEstados(
		  GrupoImportacionExcluido grupoImportacion,
         ISesion aSesion) throws BaseException {
	  return DBGrupoImportacionExcEst.getGruposImpExcEstados(grupoImportacion,aSesion);
 }	
 

}
