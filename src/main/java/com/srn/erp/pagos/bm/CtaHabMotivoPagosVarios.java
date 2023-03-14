package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.pagos.da.DBCtaHabMotivoPagosVarios;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;
import framework.request.bl.Utils.Validar;

public class CtaHabMotivoPagosVarios extends ObjetoLogico { 

  public CtaHabMotivoPagosVarios() { 
  }

  public static String NICKNAME = "pag.CtaHabMotivoPagosVarios";

  public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

private MotivoPago motivo_pago;
  private Cuenta cuenta;
  private Boolean activo;

  public MotivoPago getMotivo_pago() throws BaseException { 
    supportRefresh();
    return motivo_pago;
  }

  public void setMotivo_pago(MotivoPago aMotivo_pago) { 
    this.motivo_pago =  aMotivo_pago;
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

 public static CtaHabMotivoPagosVarios findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CtaHabMotivoPagosVarios) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static CtaHabMotivoPagosVarios findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (CtaHabMotivoPagosVarios) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(motivo_pago, "Debe ingresar el Motivo de Pago");
    Validar.noNulo(cuenta, "Debe ingresar la cuenta");
 }
 
 public static List getCtasHabilitadasMotivosPagos(
		  MotivoPago motivoPago,
		  ISesion aSesion) throws BaseException {
	  return DBCtaHabMotivoPagosVarios.getCtasHabilitadasMotivosPagos(motivoPago,aSesion);
 }
 
 public static CtaHabMotivoPagosVarios getCtaHabMotPago(
		  MotivoPago motivo,
		  Cuenta cuenta,
          ISesion aSesion)
         throws BaseException {
	  
	  return DBCtaHabMotivoPagosVarios.getCtaHabMotPago(motivo,cuenta,aSesion);
 }
 
 

}
