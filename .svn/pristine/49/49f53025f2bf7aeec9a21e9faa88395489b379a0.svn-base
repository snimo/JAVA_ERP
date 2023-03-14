package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.pagos.da.DBRendicionFondoFijoComproImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RendicionFondoFijoComproImpu extends ObjetoLogico { 

  public RendicionFondoFijoComproImpu() { 
  }

  public static String NICKNAME = "pag.RendicionFondoFijoComproImpu";

  private RendicionFondoFijoCompro rendicion_det;
  private CuentaImputable cuenta_imputable;
  private Double importe;
  private String comentario;

  public RendicionFondoFijoCompro getRendicion_det() throws BaseException { 
    supportRefresh();
    return rendicion_det;
  }

  public void setRendicion_det(RendicionFondoFijoCompro aRendicion_det) { 
    this.rendicion_det =  aRendicion_det;
  }

  public CuentaImputable getCuenta_imputable() throws BaseException { 
    supportRefresh();
    return cuenta_imputable;
  }

  public void setCuenta_imputable(CuentaImputable aCuenta_imputable) { 
    this.cuenta_imputable =  aCuenta_imputable;
  }

  public Double getImporte() throws BaseException { 
    supportRefresh();
    return importe;
  }

  public void setImporte(Double aImporte) { 
    this.importe =  aImporte;
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

 public static RendicionFondoFijoComproImpu findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RendicionFondoFijoComproImpu) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RendicionFondoFijoComproImpu findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RendicionFondoFijoComproImpu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(rendicion_det, "Debe ingresar el detalle");
    Validar.noNulo(cuenta_imputable, "Debe ingresar la cuenta imputable");
    Validar.noNulo(importe, "Debe ingresar el importe");
 }

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

public static List getImputacionesComproProv(RendicionFondoFijoCompro rendFondoFijoCompro,
        ISesion aSesion) throws BaseException {
  return DBRendicionFondoFijoComproImpu.getImputacionesComproProv(rendFondoFijoCompro,aSesion);
}


}
