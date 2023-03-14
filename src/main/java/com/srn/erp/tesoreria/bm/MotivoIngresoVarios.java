package com.srn.erp.tesoreria.bm;

import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.tesoreria.da.DBMotivoIngresoVarios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class MotivoIngresoVarios extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public MotivoIngresoVarios() { 
  }

  public static String NICKNAME = "te.MotivoIngresoVarios";

  private Recibo recibo;
  private CuentaImputable cuenta_imputable;
  private Money debe;
  private Money haber;
  private String comentario;

  public Recibo getRecibo() throws BaseException { 
    supportRefresh();
    return recibo;
  }

  public void setRecibo(Recibo aRecibo) { 
    this.recibo =  aRecibo;
  }

  public CuentaImputable getCuenta_imputable() throws BaseException { 
    supportRefresh();
    return cuenta_imputable;
  }

  public void setCuenta_imputable(CuentaImputable aCuenta_imputable) { 
    this.cuenta_imputable =  aCuenta_imputable;
  }

  public Money getDebe() throws BaseException { 
    supportRefresh();
    return debe;
  }

  public void setDebe(Money aDebe) { 
    this.debe =  aDebe;
  }

  public Money getHaber() throws BaseException { 
    supportRefresh();
    return haber;
  }

  public void setHaber(Money aHaber) { 
    this.haber =  aHaber;
  }

  public String getComentario() throws BaseException { 
    supportRefresh();
    return comentario;
  }

  public void setComentario(String aComentario) { 
    this.comentario =  aComentario;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

  public static MotivoIngresoVarios findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (MotivoIngresoVarios) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
  public static MotivoIngresoVarios findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
    return (MotivoIngresoVarios) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static MotivoIngresoVarios findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (MotivoIngresoVarios) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(recibo, "Debe ingresar el Recibo");
    Validar.noNulo(cuenta_imputable, "Debe ingresar la Cuenta");
 }
 
 public static List getMotIngVarByRecibo(Recibo recibo,
         ISesion aSesion) throws BaseException {
	  return DBMotivoIngresoVarios.getMotIngVarByRecibo(recibo,aSesion);
 }
 

}
