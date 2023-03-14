package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.pagos.da.DBRendicionFondoFijoImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RendicionFondoFijoImpu extends ObjetoLogico { 

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

public RendicionFondoFijoImpu() { 
  }

  public static String NICKNAME = "pag.RendicionFondoFijoImpu";

  private RendicionFondoFijo rendicion_fondo;
  private CuentaImputable cuenta_imputable;
  private Double importe_debe;
  private Double importe_haber;
  private String comentario;

  public RendicionFondoFijo getRendicion_fondo() throws BaseException { 
    supportRefresh();
    return rendicion_fondo;
  }

  public void setRendicion_fondo(RendicionFondoFijo aRendicion_fondo) { 
    this.rendicion_fondo =  aRendicion_fondo;
  }

  public CuentaImputable getCuenta_imputable() throws BaseException { 
    supportRefresh();
    return cuenta_imputable;
  }

  public void setCuenta_imputable(CuentaImputable aCuenta_imputable) { 
    this.cuenta_imputable =  aCuenta_imputable;
  }

  public Double getImporte_debe() throws BaseException { 
    supportRefresh();
    return importe_debe;
  }

  public void setImporte_debe(Double aImporte_debe) { 
    this.importe_debe =  aImporte_debe;
  }

  public Double getImporte_haber() throws BaseException { 
    supportRefresh();
    return importe_haber;
  }

  public void setImporte_haber(Double aImporte_haber) { 
    this.importe_haber =  aImporte_haber;
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

 public static RendicionFondoFijoImpu findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RendicionFondoFijoImpu) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static RendicionFondoFijoImpu findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RendicionFondoFijoImpu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(rendicion_fondo, "Debe ingresar un comprobante de Rendición");
    Validar.noNulo(cuenta_imputable, "Debe ingresar la cueta imputable");
 }
 
 public static List getImputacionesRendFF(RendicionFondoFijo rendFondoFijo,
         ISesion aSesion) throws BaseException {
   return DBRendicionFondoFijoImpu.getImputacionesRendFF(rendFondoFijo,aSesion);
 }
 

}
