package com.srn.erp.presupuesto.bm;

import java.util.List;

import com.srn.erp.presupuesto.da.DBEstructuraTipoCiclo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class EstructuraTipoCiclo extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public EstructuraTipoCiclo() { 
  }

  public static String NICKNAME = "pl.EstructuraTipoCiclo";

  private TipoCiclo tipo_ciclo;
  private EstructuraPlanificacion estructura_planificacion;
  private Boolean activo;

  public TipoCiclo getTipo_ciclo() throws BaseException { 
    supportRefresh();
    return tipo_ciclo;
  }

  public void setTipo_ciclo(TipoCiclo aTipo_ciclo) { 
    this.tipo_ciclo =  aTipo_ciclo;
  }

  public EstructuraPlanificacion getEstructura_planificacion() throws BaseException { 
    supportRefresh();
    return estructura_planificacion;
  }

  public void setEstructura_planificacion(EstructuraPlanificacion aEstructura_planificacion) { 
    this.estructura_planificacion =  aEstructura_planificacion;
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

 public static EstructuraTipoCiclo findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EstructuraTipoCiclo) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EstructuraTipoCiclo findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EstructuraTipoCiclo) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(tipo_ciclo, "Debe ingresar el tipo de Ciclo");
    Validar.noNulo(estructura_planificacion, "Debe ingresar la Estructura");
 }
 
 public static List getEstructurasTipoCiclo(TipoCiclo tipoCiclo,
     ISesion aSesion) throws BaseException {
 	return DBEstructuraTipoCiclo.getEstructurasTipoCiclo(tipoCiclo,aSesion);
 }
 
 public static EstructuraTipoCiclo getEstructuraTipoCiclo(TipoCiclo tipoCiclo,
		 																				  EstructuraPlanificacion estrucPlanif,
		 																				  ISesion aSesion)
     																					throws BaseException {
	 HashTableDatos condiciones = new HashTableDatos();
	 condiciones.put(TipoCiclo.NICKNAME,tipoCiclo);
	 condiciones.put(EstructuraPlanificacion.NICKNAME,estrucPlanif);
  return (EstructuraTipoCiclo) ObjetoLogico.getObjects(EstructuraTipoCiclo.NICKNAME,
	  				DBEstructuraTipoCiclo.SELECT_BY_TIPO_CICLO_ESTRUCTURA,
	  				condiciones,
	  				new ObjetoObservado(),
	  				aSesion);
 }
 

}
