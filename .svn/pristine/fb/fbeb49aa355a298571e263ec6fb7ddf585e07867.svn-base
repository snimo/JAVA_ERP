package com.srn.erp.bienUso.bm;

import com.srn.erp.bienUso.da.DBAmortizacionAcumulada;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class AmortizacionAcumulada extends ObjetoLogico { 

  public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

  public AmortizacionAcumulada() { 
  }

  public static String NICKNAME = "bu.AmortizacionAcumulada";

  private SistemaValuacion sistema_valuacion;
  private Money amortizacionAcumulada;

  public SistemaValuacion getSistema_valuacion() throws BaseException { 
    supportRefresh();
    return sistema_valuacion;
  }

  public void setSistema_valuacion(SistemaValuacion aSistema_valuacion) { 
    this.sistema_valuacion =  aSistema_valuacion;
  }

  public Money getAmortizacionAcumulada() throws BaseException { 
    supportRefresh();
    return amortizacionAcumulada;
  }

  public void setAmortizacionAcumuada(Money aAmortizacionAcumulada) { 
    this.amortizacionAcumulada =  aAmortizacionAcumulada;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static AmortizacionAcumulada findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AmortizacionAcumulada) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AmortizacionAcumulada findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AmortizacionAcumulada) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static AmortizacionAcumulada getAmortizacionAcumuladaHastaPeriAnt(SubBien subBien,
			SistemaValuacion sistemaValuacion,
			Periodo periodo,
			ISesion aSesion) throws BaseException {
    return DBAmortizacionAcumulada.getAmortizacionAcumuladaHastaPeriAnt(subBien,sistemaValuacion,periodo,aSesion);
 }
 
 public static AmortizacionAcumulada getAmortAcumAjAmortEjerAnt(SubBien subBien,SistemaValuacion sistemaValuacion,Periodo periodo,ISesion aSesion) throws BaseException {
	return DBAmortizacionAcumulada.getAmortizacionAcumuladaHastaPeriAntAjAmortEjerAnt(subBien,sistemaValuacion,periodo,aSesion);
 } 

}
