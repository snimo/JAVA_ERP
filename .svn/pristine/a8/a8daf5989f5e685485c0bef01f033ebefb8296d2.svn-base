package com.srn.erp.cashflow.bm;

import java.util.List;

import com.srn.erp.cashflow.da.DBCtaBcoSaldoIniCF;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CtaBcoSaldoIniCF extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public CtaBcoSaldoIniCF() { 
  }

  public static String NICKNAME = "cf.CtaBcoSaldoIniCF";

  private EscenarioCashFlow escenarioCF;
  private CuentaBancaria cuenta_bancaria;
  private Boolean activo;

  public EscenarioCashFlow getEscenariocf() throws BaseException { 
    supportRefresh();
    return escenarioCF;
  }

  public void setEscenariocf(EscenarioCashFlow aEscenariocf) { 
    this.escenarioCF =  aEscenariocf;
  }

  public CuentaBancaria getCuenta_bancaria() throws BaseException { 
    supportRefresh();
    return cuenta_bancaria;
  }

  public void setCuenta_bancaria(CuentaBancaria aCuenta_bancaria) { 
    this.cuenta_bancaria =  aCuenta_bancaria;
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

 public static CtaBcoSaldoIniCF findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CtaBcoSaldoIniCF) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static CtaBcoSaldoIniCF findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (CtaBcoSaldoIniCF) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(escenarioCF, "Debe ingresar el Escenario");
    Validar.noNulo(cuenta_bancaria, "Debe ingresar la Cuenta Bancaria");
 }
 
 public static List getCtasBcoSaldoIni(EscenarioCashFlow escenario,
         ISesion aSesion) throws BaseException {
	  return DBCtaBcoSaldoIniCF.getCtasBcoSaldoIni(escenario,aSesion);
 }
 

}
