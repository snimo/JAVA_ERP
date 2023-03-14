package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.ventas.da.DBCobranzaVtaMostrador;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class CobranzaVtaMostrador extends ObjetoLogico { 

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

public CobranzaVtaMostrador() { 
  }

  public static String NICKNAME = "ve.CobranzaVtaMostrador";

  private TipoValor tipo_valor;
  private Valor valor;
  private ValorCotizacion cotizacion;
  private Money impo_mon_tv;
  private Money impo_mon_fact;
  private FacturaCab facturaCab;

  public TipoValor getTipo_valor() throws BaseException { 
    supportRefresh();
    return tipo_valor;
  }

  public void setTipo_valor(TipoValor aTipo_valor) { 
    this.tipo_valor =  aTipo_valor;
  }
  
  public FacturaCab getFacturaCab() throws BaseException { 
	supportRefresh();
	return this.facturaCab;
  }

  public void setFacturaCab(FacturaCab aFacturacab) { 
	this.facturaCab =  aFacturacab;
  }  

  public Valor getValor() throws BaseException { 
    supportRefresh();
    return valor;
  }

  public void setValor(Valor aValor) { 
    this.valor =  aValor;
  }

  public ValorCotizacion getCotizacion() throws BaseException { 
    supportRefresh();
    return cotizacion;
  }

  public void setCotizacion(ValorCotizacion aCotizacion) { 
    this.cotizacion =  aCotizacion;
  }

  public Money getImpo_mon_tv() throws BaseException { 
    supportRefresh();
    return impo_mon_tv;
  }

  public void setImpo_mon_tv(Money aImpo_mon_tv) { 
    this.impo_mon_tv =  aImpo_mon_tv;
  }

  public Money getImpo_mon_fact() throws BaseException { 
    supportRefresh();
    return impo_mon_fact;
  }

  public void setImpo_mon_fact(Money aImpo_mon_fact) { 
    this.impo_mon_fact =  aImpo_mon_fact;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static CobranzaVtaMostrador findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (CobranzaVtaMostrador) getObjectByOid(NICKNAME,oid,aSesion);
  }
 
 public static CobranzaVtaMostrador findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (CobranzaVtaMostrador) getObjectByOidProxy(NICKNAME,oid,aSesion);
	  } 
 

 public static CobranzaVtaMostrador findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (CobranzaVtaMostrador) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(tipo_valor, "Debe ingresar el Tipo de Valor");
    Validar.noNulo(impo_mon_tv, "Debe ingresar el Importe");
    Validar.noNulo(impo_mon_fact, "Debe ingresar el Importe");
 }
 
 public static List getCobranzasVtaMos(FacturaCab facturaCab,
			ISesion aSesion) throws BaseException {
	 return DBCobranzaVtaMostrador.getCobranzasVtaMos(facturaCab,aSesion);
 } 

}
