package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBCompoEstructuraPlan;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CompoEstructuraPlan extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CompoEstructuraPlan() { 
  }

  public static String NICKNAME = "pl.CompoEstructuraPlan";

  private EstructuraPlan estructura_plan;
  private CompoPresupuestario compo_presu;
  private Boolean activo;

  public EstructuraPlan getEstructura_plan() throws BaseException { 
    supportRefresh();
    return estructura_plan;
  }

  public void setEstructura_plan(EstructuraPlan aEstructura_plan) { 
    this.estructura_plan =  aEstructura_plan;
  }

  public CompoPresupuestario getCompo_presu() throws BaseException { 
    supportRefresh();
    return compo_presu;
  }

  public void setCompo_presu(CompoPresupuestario aCompo_presu) { 
    this.compo_presu =  aCompo_presu;
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

 public static CompoEstructuraPlan findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CompoEstructuraPlan) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static CompoEstructuraPlan findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (CompoEstructuraPlan) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(estructura_plan, "Debe ingresar la Estructura del Plan");
    Validar.noNulo(compo_presu, "Debe ingresar el Componente Presupuestario");
 }
 
 public static List getCompoEstrucPlan(EstructuraPlan estructuraPlan,
     ISesion aSesion) throws BaseException {
 	return DBCompoEstructuraPlan.getCompoEstrucPlan(estructuraPlan,aSesion);
 } 

}
