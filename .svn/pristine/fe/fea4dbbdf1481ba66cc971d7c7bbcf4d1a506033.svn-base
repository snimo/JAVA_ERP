package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.pagos.da.DBImputacionPagosVarios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ImputacionPagosVarios extends ObjetoLogico { 

  @Override
	public Boolean isActivo() throws BaseException {
		// TODO Auto-generated method stub
		return this.activo;
	}

	public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescripcion() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

public ImputacionPagosVarios() { 
  }

  public static String NICKNAME = "pag.ImputacionPagosVarios";

  private CuentaImputable cuenta_imputable;
  private ComproOrdenPagoCab comprobante;
  private Money debe_mon_pago;
  private Money haber_mon_pago;
  private Money debe_mon_loc;
  private Money haber_mon_loc;
  private String comentario;
  private  Boolean activo;

  public CuentaImputable getCuenta_imputable() throws BaseException { 
    supportRefresh();
    return cuenta_imputable;
  }

  public void setCuenta_imputable(CuentaImputable aCuenta_imputable) { 
    this.cuenta_imputable =  aCuenta_imputable;
  }

  public ComproOrdenPagoCab getComprobante() throws BaseException { 
    supportRefresh();
    return comprobante;
  }

  public void setComprobante(ComproOrdenPagoCab aComprobante) { 
    this.comprobante =  aComprobante;
  }

  public Money getDebe_mon_pago() throws BaseException { 
    supportRefresh();
    return debe_mon_pago;
  }

  public void setDebe_mon_pago(Money aDebe_mon_pago) { 
    this.debe_mon_pago =  aDebe_mon_pago;
  }

  public Money getHaber_mon_pago() throws BaseException { 
    supportRefresh();
    return haber_mon_pago;
  }

  public void setHaber_mon_pago(Money aHaber_mon_pago) { 
    this.haber_mon_pago =  aHaber_mon_pago;
  }

  public Money getDebe_mon_loc() throws BaseException { 
    supportRefresh();
    return debe_mon_loc;
  }

  public void setDebe_mon_loc(Money aDebe_mon_loc) { 
    this.debe_mon_loc =  aDebe_mon_loc;
  }

  public Money getHaber_mon_loc() throws BaseException { 
    supportRefresh();
    return haber_mon_loc;
  }

  public void setHaber_mon_loc(Money aHaber_mon_loc) { 
    this.haber_mon_loc =  aHaber_mon_loc;
  }

  public String getComentario() throws BaseException { 
    supportRefresh();
    return comentario;
  }

  public void setComentario(String aComentario) { 
    this.comentario =  aComentario;
  }

  public  boolean getActivo() throws BaseException { 
    supportRefresh();
    return activo;
  }

  public void setActivo(Boolean aActivo) { 
    this.activo =  aActivo;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ImputacionPagosVarios findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ImputacionPagosVarios) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ImputacionPagosVarios findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (ImputacionPagosVarios) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(cuenta_imputable, "Debe ingresar la Cuenta Imputable");
    Validar.noNulo(comprobante, "Debe ingresar la Orden de Pago");
 }
 
 public static List getImputacionesOPVarias(ComproOrdenPagoCab comproOP,
         ISesion aSesion) throws BaseException {
	  return DBImputacionPagosVarios.getImputacionesOPVarias(comproOP,aSesion);
 }
 
 public boolean isDebe() throws BaseException {
	 if ((this.getDebe_mon_pago()!=null) && (this.getDebe_mon_pago().doubleValue()>0))
		 return true;
	 else
		 return false;
 }
 

}
