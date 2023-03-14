package com.srn.erp.tesoreria.bm;

import java.util.List;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.da.DBUniOrgCtasIngVar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UniOrgCtasIngVar extends ObjetoLogico { 

  public UniOrgCtasIngVar() { 
  }

  public static String NICKNAME = "te.UniOrgCtasIngVar";

  private CuentaImputableIngVar cuenta_iv;
  private UnidadOrganizativa unidad_organizativa;

  public CuentaImputableIngVar getCuenta_iv() throws BaseException { 
    supportRefresh();
    return cuenta_iv;
  }

  public void setCuenta_iv(CuentaImputableIngVar aCuenta_iv) { 
    this.cuenta_iv =  aCuenta_iv;
  }

  public UnidadOrganizativa getUnidad_organizativa() throws BaseException { 
    supportRefresh();
    return unidad_organizativa;
  }

  public void setUnidad_organizativa(UnidadOrganizativa aUnidad_organizativa) { 
    this.unidad_organizativa =  aUnidad_organizativa;
  }

  public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return new Boolean(true);
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNickName() { 
    return NICKNAME; 
  } 

 public static UniOrgCtasIngVar findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (UniOrgCtasIngVar) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static UniOrgCtasIngVar findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (UniOrgCtasIngVar) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(cuenta_iv, "Debe ingresar la cuenta");
    Validar.noNulo(unidad_organizativa, "Debe ingresar la Unidad Organizativa");
 }
 
	public static List getUniOrgCtaIngVar(
			CuentaImputableIngVar cuentaImputableIngVar, 
			ISesion aSesion)
		throws BaseException {
		return DBUniOrgCtasIngVar.getUniOrgCtaIngVar(cuentaImputableIngVar,aSesion);
	}
 

}
