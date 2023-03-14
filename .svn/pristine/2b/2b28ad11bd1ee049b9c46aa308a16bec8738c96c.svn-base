package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBGrupoImportacionSoloEst;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoImportacionSoloEst extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public GrupoImportacionSoloEst() { 
  }

  public static String NICKNAME = "exc.GrupoImportacionSoloEst";

  private GrupoImportacionExcluido grupo_imp_exc;
  private EstadoExcluido estado;
  private Boolean activo;

  public GrupoImportacionExcluido getGrupo_imp_exc() throws BaseException { 
    supportRefresh();
    return grupo_imp_exc;
  }

  public void setGrupo_imp_exc(GrupoImportacionExcluido aGrupo_imp_exc) { 
    this.grupo_imp_exc =  aGrupo_imp_exc;
  }

  public EstadoExcluido getEstado() throws BaseException { 
    supportRefresh();
    return estado;
  }

  public void setEstado(EstadoExcluido aEstado) { 
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

 public static GrupoImportacionSoloEst findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoImportacionSoloEst) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static GrupoImportacionSoloEst findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoImportacionSoloEst) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(grupo_imp_exc, "Debe ingresar el Grupo");
    Validar.noNulo(estado, "Debe ingresar el Estado");
 }
 
 public static List getGrupoImpSoloEst(GrupoImportacionExcluido grupoImportacion,
         ISesion aSesion) throws BaseException {
	  return DBGrupoImportacionSoloEst.getGrupoImpSoloEst(grupoImportacion,aSesion);
 } 

}
