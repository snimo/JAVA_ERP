package com.srn.erp.contabilidad.bm;

import java.util.List;

import com.srn.erp.contabilidad.da.DBSubdiarioDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SubdiarioDet extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public SubdiarioDet() { 
  }

  public static String NICKNAME = "cg.SubdiarioDet";

  private Subdiario subdiario;
  private Cuenta cuenta;
  private Boolean activo;

  public Subdiario getSubdiario() throws BaseException { 
    supportRefresh();
    return subdiario;
  }

  public void setSubdiario(Subdiario aSubdiario) { 
    this.subdiario =  aSubdiario;
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

 public static SubdiarioDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SubdiarioDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static SubdiarioDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SubdiarioDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(subdiario, "Debe ingresar el SubDiario");
    Validar.noNulo(cuenta, "Debe ingresar la Cuenta");
 }
 
 public static List getSubDiariosDet(Subdiario subDiario,
         ISesion aSesion) throws BaseException {
	  return DBSubdiarioDet.getSubDiariosDet(subDiario,aSesion);
 }
 

}
