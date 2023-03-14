package com.srn.erp.rrhh.bm;

import java.util.List;

import com.srn.erp.rrhh.da.DBEvalCargaResul;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EvalCargaResul extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public EvalCargaResul() { 
  }

  public static String NICKNAME = "rh.EvalCargaResul";

  private EvaluacionLegajoCab evaluacion;
  private Competencia competencia;
  private Integer nro_grado;
  private Money porc_cumpli;
  private Boolean activo;
  private Money puntaje;

  public EvaluacionLegajoCab getEvaluacion() throws BaseException { 
    supportRefresh();
    return evaluacion;
  }
  
  public Money getPuntaje() throws BaseException { 
	    supportRefresh();
	    return puntaje;
  }
  
  public void setEvaluacion(EvaluacionLegajoCab aEvaluacion) { 
    this.evaluacion =  aEvaluacion;
  }
  
  public void setPuntaje(Money aPuntaje) { 
	    this.puntaje =  aPuntaje;
  }
  

  public Competencia getCompetencia() throws BaseException { 
    supportRefresh();
    return competencia;
  }

  public void setCompetencia(Competencia aCompetencia) { 
    this.competencia =  aCompetencia;
  }

  public Integer getNro_grado() throws BaseException { 
    supportRefresh();
    return nro_grado;
  }

  public void setNro_grado(Integer aNro_grado) { 
    this.nro_grado =  aNro_grado;
  }

  public Money getPorc_cumpli() throws BaseException { 
    supportRefresh();
    return porc_cumpli;
  }

  public void setPorc_cumpli(Money aPorc_cumpli) { 
    this.porc_cumpli =  aPorc_cumpli;
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

 public static EvalCargaResul findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EvalCargaResul) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EvalCargaResul findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EvalCargaResul) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(evaluacion, "Debe ingresar la Evaluación");
    Validar.noNulo(competencia, "Debe ingresar la Competencia");
 }
 
 public static List getEvalCargaResul(EvaluacionLegajoCab aEvaluacionLegajoCab,ISesion aSesion) throws BaseException {
	  return DBEvalCargaResul.getEvalCargaResul(aEvaluacionLegajoCab,aSesion);
 }
 
 public static EvalCargaResul getEvalCargaResul(
		  EvaluacionLegajoCab evaluacion,
		  Competencia competencia,
         ISesion aSesion)
         throws BaseException {
	  return DBEvalCargaResul.getEvalCargaResul(evaluacion,competencia,aSesion);
 }
 
 

}
