package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBDriverComponenteCta;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DriverComponenteCta extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public DriverComponenteCta() { 
  }

  public static String NICKNAME = "cg.DriverComponenteCta";

  private DriverComponente componente_driver;
  private Cuenta cuenta;
  private Boolean activo;

  public DriverComponente getComponente_driver() throws BaseException { 
    supportRefresh();
    return componente_driver;
  }

  public void setComponente_driver(DriverComponente aComponente_driver) { 
    this.componente_driver =  aComponente_driver;
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

 public static DriverComponenteCta findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (DriverComponenteCta) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static DriverComponenteCta findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (DriverComponenteCta) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(componente_driver, "Debe ingresar el Driver");
    Validar.noNulo(cuenta, "Debe ingresar la Cuenta");
 }
 
 public static List getCuentasCompoDriver(DriverComponente driverCompo,
		 								  ISesion aSesion) throws BaseException {
	  return DBDriverComponenteCta.getCuentasCompoDriver(driverCompo,aSesion);
 }
 
 

}
