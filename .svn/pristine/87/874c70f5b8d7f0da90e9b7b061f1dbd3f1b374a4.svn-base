package com.srn.erp.bienUso.bm;

import com.srn.erp.bienUso.da.DBRevaluoValorOrigenSubBien;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class RevaluoValorOrigenSubBien extends ObjetoLogico { 

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

  public RevaluoValorOrigenSubBien() { 
  }

  public static String NICKNAME = "bu.RevaluoValorOrigenSubBien";

  private SistemaValuacion sistema_valuacion;
  private Money revaluo_valor_origen;

  public SistemaValuacion getSistema_valuacion() throws BaseException { 
    supportRefresh();
    return sistema_valuacion;
  }

  public void setSistema_valuacion(SistemaValuacion aSistema_valuacion) { 
    this.sistema_valuacion =  aSistema_valuacion;
  }

  public Money getRevaluo_Valor_origen() throws BaseException { 
    supportRefresh();
    return revaluo_valor_origen;
  }

  public void setRevaluo_Valor_origen(Money aRevaluoValor_origen) { 
    this.revaluo_valor_origen =  aRevaluoValor_origen;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static RevaluoValorOrigenSubBien findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RevaluoValorOrigenSubBien) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RevaluoValorOrigenSubBien findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RevaluoValorOrigenSubBien) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static RevaluoValorOrigenSubBien getRevaluoValorOrigenSubBien(SubBien subBien,
			SistemaValuacion sistemaValuacion,
			Periodo periodoAExcluir,
			ISesion aSesion) throws BaseException {
    return DBRevaluoValorOrigenSubBien.getRevaluoValorOrigenSubBien(subBien,sistemaValuacion,periodoAExcluir,aSesion);
 } 

}
