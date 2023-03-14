package com.srn.erp.ventas.bm;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class FacturaCabImpu extends ObjetoLogico { 

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

public FacturaCabImpu() { 
  }

  public static String NICKNAME = "ve.FacturaCabImpu";

  private FacturaCab facturaCab;
  private ConceptoImpuesto concepto_impuesto;
  private Money importe_mon_ori;
  private Money importe_mon_local;

  public FacturaCab getFacturacab() throws BaseException { 
    supportRefresh();
    return facturaCab;
  }

  public void setFacturacab(FacturaCab aFacturacab) { 
    this.facturaCab =  aFacturacab;
  }

  public ConceptoImpuesto getConcepto_impuesto() throws BaseException { 
    supportRefresh();
    return concepto_impuesto;
  }

  public void setConcepto_impuesto(ConceptoImpuesto aConcepto_impuesto) { 
    this.concepto_impuesto =  aConcepto_impuesto;
  }

  public Money getImporte_mon_ori() throws BaseException { 
    supportRefresh();
    return importe_mon_ori;
  }

  public void setImporte_mon_ori(Money aImporte_mon_ori) { 
    this.importe_mon_ori =  aImporte_mon_ori;
  }

  public Money getImporte_mon_local() throws BaseException { 
    supportRefresh();
    return importe_mon_local;
  }

  public void setImporte_mon_local(Money aImporte_mon_local) { 
    this.importe_mon_local =  aImporte_mon_local;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static FacturaCabImpu findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (FacturaCabImpu) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static FacturaCabImpu findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (FacturaCabImpu) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(facturaCab, "Debe ingresar la Factura");
    Validar.noNulo(concepto_impuesto, "Debe ingresar el Concepto Impuesto");
    Validar.noNulo(importe_mon_ori, "Debe ingresar el Importe del Impuesto");
    Validar.noNulo(importe_mon_local, "Debe ingresar el Importe del Impuesto");
 }

}
