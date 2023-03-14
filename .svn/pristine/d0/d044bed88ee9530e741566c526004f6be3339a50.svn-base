package com.srn.erp.excluidos.bm;

import java.util.List;

import com.srn.erp.excluidos.da.DBGrupoImportacionExcMaq;
import com.srn.erp.mensajero.bm.Maquina;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class GrupoImportacionExcMaq extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public GrupoImportacionExcMaq() { 
  }

  public static String NICKNAME = "exc.GrupoImportacionExcMaq";

  private GrupoImportacionExcluido grupo_imp_exc;
  private Maquina maquina;
  private Boolean activo;

  public GrupoImportacionExcluido getGrupo_imp_exc() throws BaseException { 
    supportRefresh();
    return grupo_imp_exc;
  }

  public void setGrupo_imp_exc(GrupoImportacionExcluido aGrupo_imp_exc) { 
    this.grupo_imp_exc =  aGrupo_imp_exc;
  }

  public Maquina getMaquina() throws BaseException { 
    supportRefresh();
    return maquina;
  }

  public void setMaquina(Maquina aMaquina) { 
    this.maquina =  aMaquina;
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

 public static GrupoImportacionExcMaq findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (GrupoImportacionExcMaq) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static GrupoImportacionExcMaq findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (GrupoImportacionExcMaq) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(grupo_imp_exc, "Debe ingresar el Grupo");
    Validar.noNulo(maquina, "Debe ingresar la Máquina");
 }
 
 public static List getGrupoImpExcMaq(GrupoImportacionExcluido grupo,
         ISesion aSesion) throws BaseException {
	  return DBGrupoImportacionExcMaq.getGrupoImpExcMaq(grupo,aSesion);
 } 

}
