package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBDriverCuentaSubreparto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DriverCuentaSubreparto extends ObjetoLogico { 

  private List driverComponentesCuenta = new ArrayList();
  private boolean readDriverComponentesCuenta = true;
	
  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

  public DriverCuentaSubreparto() { 
  }

  public static String NICKNAME = "cg.DriverCuentaSubreparto";

  private DriverSubreparto driver;
  private Cuenta cuenta;
  private Boolean activo;

  public DriverSubreparto getDriver() throws BaseException { 
    supportRefresh();
    return driver;
  }

  public void setDriver(DriverSubreparto aDriver) { 
    this.driver =  aDriver;
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

 public static DriverCuentaSubreparto findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (DriverCuentaSubreparto) getObjectByOid(NICKNAME,oid,aSesion);
  } 
 
 public static DriverCuentaSubreparto findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	return (DriverCuentaSubreparto) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 

 public static DriverCuentaSubreparto findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (DriverCuentaSubreparto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(driver, "Debe ingresar el Driver");
    Validar.noNulo(cuenta, "Debe ingresar la cuenta");
 }
 
 public static List getDriverCuentasSubreparto(DriverSubreparto driver,
         ISesion aSesion) throws BaseException {
	  return DBDriverCuentaSubreparto.getDriverCuentasSubreparto(driver,aSesion);
 }
 
 public List getComponentesCuentaDriver() throws BaseException {
	 if (readDriverComponentesCuenta) {
	      List listaDriversCompoCta = DriverCuentaComponente.getDriverComponentesCta(this,getSesion());
	      driverComponentesCuenta.addAll(listaDriversCompoCta);
	      readDriverComponentesCuenta = false;
	    }
	    return driverComponentesCuenta;
 }

 public void addComponenteCuentaDriver(DriverCuentaComponente aDriverCuentaComponente) throws BaseException {
	 aDriverCuentaComponente.setDriver_cta(this);
	 driverComponentesCuenta.add(aDriverCuentaComponente);
 }

 public void afterSave() throws BaseException {
	Iterator iterDriverCtasCompo = driverComponentesCuenta.iterator();
	while (iterDriverCtasCompo.hasNext()) {
	      DriverCuentaComponente driverCtaCompo = (DriverCuentaComponente) iterDriverCtasCompo.next();
	      driverCtaCompo.save();
	      driverCtaCompo = null;
	}
	iterDriverCtasCompo = null;
 }

}
