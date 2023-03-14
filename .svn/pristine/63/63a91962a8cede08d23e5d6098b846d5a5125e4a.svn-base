package com.srn.erp.tesoreria.bm;

import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.da.DBCuentaSistemaBanco;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CuentaSistemaBanco extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public CuentaSistemaBanco() { 
  }

  public static String NICKNAME = "te.CuentaSistemaBanco";

  private CuentaImputable cuenta;
  private Boolean activo;
  private UnidadOrganizativa uniOrg;

  public CuentaImputable getCuenta() throws BaseException { 
    supportRefresh();
    return cuenta;
  }

  public void setCuenta(CuentaImputable aCuenta) { 
    this.cuenta =  aCuenta;
  }
  
  public UnidadOrganizativa getUniOrg() throws BaseException { 
    supportRefresh();
    return this.uniOrg;
  }

  public void setUnidadOrganizativa(UnidadOrganizativa aUniOrg) { 
    this.uniOrg =  aUniOrg;
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

 public static CuentaSistemaBanco findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CuentaSistemaBanco) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static CuentaSistemaBanco findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (CuentaSistemaBanco) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static CuentaSistemaBanco findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (CuentaSistemaBanco) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(cuenta, "Debe ingresar la Cuenta imputable");
    Validar.noNulo(this.uniOrg, "Debe ingresar la Unidad Organizativa");
 }
 
 public static List getAll(ISesion aSesion) throws BaseException {
 	return DBCuentaSistemaBanco.getAll(aSesion);
 }
 
 public static List getCuentasByUniOrg(UnidadOrganizativa uniOrg,
     ISesion aSesion) throws BaseException {
 	return DBCuentaSistemaBanco.getCuentasByUniOrg(uniOrg,aSesion);
 }
 
  

}
