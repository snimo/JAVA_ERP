package com.srn.erp.pagos.bm;

import java.util.List;

import com.srn.erp.pagos.da.DBRendicionFondoFijoMedioPago;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class RendicionFondoFijoMedioPago extends ObjetoLogico { 

  public RendicionFondoFijoMedioPago() { 
  }

  public static String NICKNAME = "pag.RendicionFondoFijoMedioPago";

  private RendicionFondoFijo rendicion_fondo;
  private Valor valor;
  private TipoValor tipo_valor;
  private Double cotizacion;
  private Double importe;
  private Double impo_mon_rend_ff;
  private Double impo_mon_loc;
  private String ingresoEgreso;
  private Caja caja;

  public RendicionFondoFijo getRendicion_fondo() throws BaseException { 
    supportRefresh();
    return rendicion_fondo;
  }
  
  public void setIngresoEgreso(String aIngresoEgreso) throws BaseException {
	  this.ingresoEgreso = aIngresoEgreso;
  }
  
  public Caja getCaja() throws BaseException { 
    supportRefresh();
    return caja;
  }
  
  public void setCaja(Caja aCaja) throws BaseException {
	  this.caja = aCaja;
  }
  
  
  public String getIngresoEgreso() throws BaseException {
	  return this.ingresoEgreso;
  }

  public void setRendicion_fondo(RendicionFondoFijo aRendicion_fondo) { 
    this.rendicion_fondo =  aRendicion_fondo;
  }

  public Valor getValor() throws BaseException { 
    supportRefresh();
    return valor;
  }

  public void setValor(Valor aValor) { 
    this.valor =  aValor;
  }

  public TipoValor getTipo_valor() throws BaseException { 
    supportRefresh();
    return tipo_valor;
  }

  public void setTipo_valor(TipoValor aTipo_valor) { 
    this.tipo_valor =  aTipo_valor;
  }

  public Double getCotizacion() throws BaseException { 
    supportRefresh();
    return cotizacion;
  }

  public void setCotizacion(Double aCotizacion) { 
    this.cotizacion =  aCotizacion;
  }

  public Double getImporte() throws BaseException { 
    supportRefresh();
    return importe;
  }

  public void setImporte(Double aImporte) { 
    this.importe =  aImporte;
  }

  public Double getImpo_mon_rend_ff() throws BaseException { 
    supportRefresh();
    return impo_mon_rend_ff;
  }

  public void setImpo_mon_rend_ff(Double aImpo_mon_rend_ff) { 
    this.impo_mon_rend_ff =  aImpo_mon_rend_ff;
  }

  public Double getImpo_mon_loc() throws BaseException { 
    supportRefresh();
    return impo_mon_loc;
  }

  public void setImpo_mon_loc(Double aImpo_mon_loc) { 
    this.impo_mon_loc =  aImpo_mon_loc;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static RendicionFondoFijoMedioPago findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (RendicionFondoFijoMedioPago) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static RendicionFondoFijoMedioPago findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (RendicionFondoFijoMedioPago) getObjectByOidProxy(NICKNAME,oid,aSesion);
  } 
 

 public static RendicionFondoFijoMedioPago findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (RendicionFondoFijoMedioPago) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(rendicion_fondo, "Debe ingresar un comprobante de Rendición");
    Validar.noNulo(tipo_valor, "Debe ingresar el tipo de Valor");    
    Validar.noNulo(ingresoEgreso,"Debe ingresar si se trata de un ingreso o egreso");
 }

public Boolean isActivo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
}

public static List getValores(RendicionFondoFijo rendFondoFijo,
        ISesion aSesion) throws BaseException {
  return DBRendicionFondoFijoMedioPago.getValores(rendFondoFijo,aSesion);
}

}
