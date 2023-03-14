package com.srn.erp.ctasACobrar.bm;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class TranClie extends ObjetoLogico { 

  public TranClie() { 
  }

  public static String NICKNAME = "cac.TranClie";

  private ComproCab comprobante;
  private Sujeto sujeto;
  private Moneda moneda;
  private Money importe;
  private Money saldo;
  private Boolean pendiente;
  private java.util.Date imputac;
  private java.util.Date emision;
  private java.util.Date base;
  private ValorCotizacion cotiz_mon_ori;
  private ValorCotizacion cotiz_mon_ext1;
  private ValorCotizacion cotiz_mon_ext2;
  private ValorCotizacion cotiz_mon_ori_co;
  private ValorCotizacion cotiz_mon_ext1_co;
  private ValorCotizacion cotiz_mon_ext2_co;
  private TipoCtaCteClie tipo_cta_cte;

  public ComproCab getComprobante() throws BaseException { 
    supportRefresh();
    return comprobante;
  }

  public void setComprobante(ComproCab aComprobante) { 
    this.comprobante =  aComprobante;
  }

  public Sujeto getSujeto() throws BaseException { 
    supportRefresh();
    return sujeto;
  }

  public void setSujeto(Sujeto aSujeto) { 
    this.sujeto =  aSujeto;
  }

  public Moneda getMoneda() throws BaseException { 
    supportRefresh();
    return moneda;
  }

  public void setMoneda(Moneda aMoneda) { 
    this.moneda =  aMoneda;
  }

  public Money getImporte() throws BaseException { 
    supportRefresh();
    return importe;
  }

  public void setImporte(Money aImporte) { 
    this.importe =  aImporte;
  }

  public Money getSaldo() throws BaseException { 
    supportRefresh();
    return saldo;
  }

  public void setSaldo(Money aSaldo) { 
    this.saldo =  aSaldo;
  }

  public Boolean isPendiente() throws BaseException { 
    supportRefresh();
    return pendiente;
  }

  public void setPendiente(Boolean aPendiente) { 
    this.pendiente =  aPendiente;
  }

  public java.util.Date getImputac() throws BaseException { 
    supportRefresh();
    return imputac;
  }

  public void setImputac(java.util.Date aImputac) { 
    this.imputac =  aImputac;
  }

  public java.util.Date getEmision() throws BaseException { 
    supportRefresh();
    return emision;
  }

  public void setEmision(java.util.Date aEmision) { 
    this.emision =  aEmision;
  }

  public java.util.Date getBase() throws BaseException { 
    supportRefresh();
    return base;
  }

  public void setBase(java.util.Date aBase) { 
    this.base =  aBase;
  }

  public ValorCotizacion getCotiz_mon_ori() throws BaseException { 
    supportRefresh();
    return cotiz_mon_ori;
  }

  public void setCotiz_mon_ori(ValorCotizacion aCotiz_mon_ori) { 
    this.cotiz_mon_ori =  aCotiz_mon_ori;
  }

  public ValorCotizacion getCotiz_mon_ext1() throws BaseException { 
    supportRefresh();
    return cotiz_mon_ext1;
  }

  public void setCotiz_mon_ext1(ValorCotizacion aCotiz_mon_ext1) { 
    this.cotiz_mon_ext1 =  aCotiz_mon_ext1;
  }

  public ValorCotizacion getCotiz_mon_ext2() throws BaseException { 
    supportRefresh();
    return cotiz_mon_ext2;
  }

  public void setCotiz_mon_ext2(ValorCotizacion aCotiz_mon_ext2) { 
    this.cotiz_mon_ext2 =  aCotiz_mon_ext2;
  }

  public ValorCotizacion getCotiz_mon_ori_co() throws BaseException { 
    supportRefresh();
    return cotiz_mon_ori_co;
  }

  public void setCotiz_mon_ori_co(ValorCotizacion aCotiz_mon_ori_co) { 
    this.cotiz_mon_ori_co =  aCotiz_mon_ori_co;
  }

  public ValorCotizacion getCotiz_mon_ext1_co() throws BaseException { 
    supportRefresh();
    return cotiz_mon_ext1_co;
  }

  public void setCotiz_mon_ext1_co(ValorCotizacion aCotiz_mon_ext1_co) { 
    this.cotiz_mon_ext1_co =  aCotiz_mon_ext1_co;
  }

  public ValorCotizacion getCotiz_mon_ext2_co() throws BaseException { 
    supportRefresh();
    return cotiz_mon_ext2_co;
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

public void setCotiz_mon_ext2_co(ValorCotizacion aCotiz_mon_ext2_co) { 
    this.cotiz_mon_ext2_co =  aCotiz_mon_ext2_co;
  }

  public TipoCtaCteClie getTipo_cta_cte() throws BaseException { 
    supportRefresh();
    return tipo_cta_cte;
  }

  public void setTipo_cta_cte(TipoCtaCteClie aTipo_cta_cte) { 
    this.tipo_cta_cte =  aTipo_cta_cte;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static TranClie findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (TranClie) getObjectByOid(NICKNAME,oid,aSesion);
 }
 
 public static TranClie findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	return (TranClie) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 

 public static TranClie findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (TranClie) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(comprobante, "Debe ingresar el Comprobante");
    Validar.noNulo(sujeto, "Debe ingresar el Sujeto");
    Validar.noNulo(moneda, "Debe ingresar la Moneda");
 }

}
