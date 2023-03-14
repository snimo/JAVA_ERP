package com.srn.erp.produccion.bm;

import java.util.List;

import com.srn.erp.produccion.da.DBNecMatOperAltFab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class NecMatOperAltFab extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public NecMatOperAltFab() { 
  }

  public static String NICKNAME = "pr.NecMatOperAltFab";

  private OperAlterFab oper_alt_fab;
  private RecetaDet receta_det;
  private Boolean activo;

  public OperAlterFab getOper_alt_fab() throws BaseException { 
    supportRefresh();
    return oper_alt_fab;
  }

  public void setOper_alt_fab(OperAlterFab aOper_alt_fab) { 
    this.oper_alt_fab =  aOper_alt_fab;
  }

  public RecetaDet getReceta_det() throws BaseException { 
    supportRefresh();
    return receta_det;
  }

  public void setReceta_det(RecetaDet aReceta_det) { 
    this.receta_det =  aReceta_det;
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

 public static NecMatOperAltFab findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (NecMatOperAltFab) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static NecMatOperAltFab findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (NecMatOperAltFab) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(oper_alt_fab, "Operación Alternativa de Fabricación");
    Validar.noNulo(receta_det, "Debe ingresar el Detalle de la Receta");
 }
 
 public static List getNecMatOperAlt(OperAlterFab operAltFab,
         ISesion aSesion) throws BaseException {
	  return DBNecMatOperAltFab.getNecMatOperAlt(operAltFab,aSesion);
 } 

}
