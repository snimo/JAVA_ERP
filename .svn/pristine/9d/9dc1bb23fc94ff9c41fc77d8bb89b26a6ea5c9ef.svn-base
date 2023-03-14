package com.srn.erp.bancos.bm;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.CuentaSistemaBanco;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class UniOrgCtaSistBanco extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public UniOrgCtaSistBanco() { 
  }

  public static String NICKNAME = "ba.UniOrgCtaSistBanco";

  private UnidadOrganizativa unidad_organizativa;
  private CuentaSistemaBanco cuenta_hab_banco;
  private Boolean activo;

  public UnidadOrganizativa getUnidad_organizativa() throws BaseException { 
    supportRefresh();
    return unidad_organizativa;
  }

  public void setUnidad_organizativa(UnidadOrganizativa aUnidad_organizativa) { 
    this.unidad_organizativa =  aUnidad_organizativa;
  }

  public CuentaSistemaBanco getCuenta_hab_banco() throws BaseException { 
    supportRefresh();
    return cuenta_hab_banco;
  }

  public void setCuenta_hab_banco(CuentaSistemaBanco aCuenta_hab_banco) { 
    this.cuenta_hab_banco =  aCuenta_hab_banco;
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

 public static UniOrgCtaSistBanco findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (UniOrgCtaSistBanco) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static UniOrgCtaSistBanco findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (UniOrgCtaSistBanco) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(unidad_organizativa, "Debe ingresar la Unidad Organizativa");
    Validar.noNulo(cuenta_hab_banco, "Debe ingresar la Cuenta");
 }

}
