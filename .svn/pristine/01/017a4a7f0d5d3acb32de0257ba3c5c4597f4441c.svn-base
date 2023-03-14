package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBFaseCuentaOrigen;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class FaseCuentaOrigen extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public FaseCuentaOrigen() { 
  }

  public static String NICKNAME = "cg.FaseCuentaOrigen";

  private FaseSubReparto fase;
  private Cuenta cuenta;
  private Boolean activo;

  public FaseSubReparto getFase() throws BaseException { 
    supportRefresh();
    return fase;
  }

  public void setFase(FaseSubReparto aFase) { 
    this.fase =  aFase;
  }

  public Cuenta getCuenta() throws BaseException { 
    supportRefresh();
    return cuenta;
  }

  public void setCuenta(Cuenta aCuenta) { 
    this.cuenta =  aCuenta;
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

 public static FaseCuentaOrigen findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (FaseCuentaOrigen) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static FaseCuentaOrigen findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (FaseCuentaOrigen) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(fase, "Debe Ingresar la Fase");
    Validar.noNulo(cuenta, "Debe ingresar la Cuenta");
 }
 
 public static List getCuentasOrigen(FaseSubReparto fase,
         ISesion aSesion) throws BaseException {
	  return DBFaseCuentaOrigen.getCuentasOrigen(fase,aSesion);
 }
 
 public static FaseCuentaOrigen getFaseCuentaOrigen(
		  FaseSubReparto fase,
		  Cuenta cuenta,
         ISesion aSesion)
         throws BaseException {
	  return DBFaseCuentaOrigen.getFaseCuentaOrigen(fase,cuenta,aSesion);
 }
 
 

}
