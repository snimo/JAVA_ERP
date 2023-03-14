package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBDriverComponente;
import com.srn.erp.general.bm.PeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class DriverComponente extends ObjetoLogico { 

  private List cuentas = new ArrayList();
  private boolean readCuentas = true;
	
  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public DriverComponente() { 
  }

  public static String NICKNAME = "cg.DriverComponente";

  private DriverSubreparto driver;
  private IObjetoLogico valor_compo;
  private Boolean activo;

  public DriverSubreparto getDriver() throws BaseException { 
    supportRefresh();
    return driver;
  }

  public void setDriver(DriverSubreparto aDriver) { 
    this.driver =  aDriver;
  }

  public IObjetoLogico getValor_compo() throws BaseException { 
    supportRefresh();
    return valor_compo;
  }

  public void setValor_compo(IObjetoLogico aValor_compo) { 
    this.valor_compo =  aValor_compo;
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

 public static DriverComponente findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (DriverComponente) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static DriverComponente findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	return (DriverComponente) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 public static DriverComponente findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (DriverComponente) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(driver, "Debe ingresar el Driver");
    Validar.noNulo(valor_compo, "Debe ingresar el Valor de Componente");
    
 }
 
 public static List getComponentesDriver(
		 DriverSubreparto driver,
         ISesion aSesion) throws BaseException {
	  return DBDriverComponente.getComponentesDriver(driver,aSesion);
 }
 
 public List getCuentasCompo() throws BaseException {
   if (readCuentas) {
	   List listaCuentas = DriverComponenteCta.getCuentasCompoDriver(this,getSesion());
	   cuentas.addAll(listaCuentas);
	   readCuentas = false;
   }
   return cuentas;
 }

 public void addCuentaCompro(DriverComponenteCta driverCompoCta) throws BaseException {
	 driverCompoCta.setComponente_driver(this);
	 cuentas.add(driverCompoCta);
 }

 public void afterSave() throws BaseException {
	Iterator iterCtas = cuentas.iterator();
	while (iterCtas.hasNext()) {
	   DriverComponenteCta compoCta = (DriverComponenteCta) iterCtas.next();
	   compoCta.save();
	   compoCta = null;
	}
	iterCtas = null;
 }


}
