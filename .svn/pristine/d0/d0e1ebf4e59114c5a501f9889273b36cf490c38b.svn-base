package com.srn.erp.bienUso.bm;

import com.srn.erp.bienUso.da.DBValorOrigenSubBien;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;

public class ValorOrigenSubBien extends ObjetoLogico { 

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

  public ValorOrigenSubBien() { 
  }

  public static String NICKNAME = "bu.ValorOrigenSubBien";

  private SistemaValuacion sistema_valuacion;
  private Money valor_origen;

  public SistemaValuacion getSistema_valuacion() throws BaseException { 
    supportRefresh();
    return sistema_valuacion;
  }

  public void setSistema_valuacion(SistemaValuacion aSistema_valuacion) { 
    this.sistema_valuacion =  aSistema_valuacion;
  }

  public Money getValor_origen() throws BaseException { 
    supportRefresh();
    return valor_origen;
  }

  public void setValor_origen(Money aValor_origen) { 
    this.valor_origen =  aValor_origen;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ValorOrigenSubBien findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ValorOrigenSubBien) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ValorOrigenSubBien findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ValorOrigenSubBien) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
 }
 
 public static ValorOrigenSubBien getValorOrigenSubBien(SubBien subBien,
			SistemaValuacion sistemaValuacion,
			ISesion aSesion) throws BaseException {
    return DBValorOrigenSubBien.getValorOrigenSubBien(subBien,sistemaValuacion,aSesion);
 } 

}
