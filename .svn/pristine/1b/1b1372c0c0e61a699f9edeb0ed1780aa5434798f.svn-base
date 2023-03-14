package com.srn.erp.cashflow.bm;

import com.srn.erp.cashflow.da.DBEsceConceptoCFHab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EsceConceptoCFHab extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public EsceConceptoCFHab() { 
  }

  public static String NICKNAME = "cf.EsceConceptoCFHab";

  private ConceptoCashFlow concepto_cf;
  private EscenarioCashFlow escenario_cf;
  private Boolean activo;

  public ConceptoCashFlow getConcepto_cf() throws BaseException { 
    supportRefresh();
    return concepto_cf;
  }

  public void setConcepto_cf(ConceptoCashFlow aConcepto_cf) { 
    this.concepto_cf =  aConcepto_cf;
  }

  public EscenarioCashFlow getEscenario_cf() throws BaseException { 
    supportRefresh();
    return escenario_cf;
  }

  public void setEscenario_cf(EscenarioCashFlow aEscenario_cf) { 
    this.escenario_cf =  aEscenario_cf;
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

 public static EsceConceptoCFHab findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EsceConceptoCFHab) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EsceConceptoCFHab findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EsceConceptoCFHab) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(concepto_cf, "Debe ingresar el Concepto");
    Validar.noNulo(escenario_cf, "Debe ingresar el Escenario");
 }
 
 public static EsceConceptoCFHab getEscenariosConcHab(
		  ConceptoCashFlow concepto,
		  EscenarioCashFlow escenario,
         ISesion aSesion) throws BaseException {
	  return (EsceConceptoCFHab) DBEsceConceptoCFHab.getEscenariosConcHab(concepto,escenario,aSesion);
 }
 

}
