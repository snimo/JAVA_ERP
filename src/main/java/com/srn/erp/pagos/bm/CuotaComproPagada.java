package com.srn.erp.pagos.bm;

import com.srn.erp.ctasAPagar.bm.ComproAnticipoProveedor;
import com.srn.erp.ctasAPagar.bm.TranProvVto;

import framework.applicarionServer.bm.Varios.Money;

public class CuotaComproPagada {

	public ComproAnticipoProveedor anticipoProveedor;
  public TranProvVto tranProvVto;
  public Money saldoCuota;
  public Money descuento;
  public Money pagado;


  public Money getPagado() {
    return pagado;
  }

  public Money getDescuento() {
    return descuento;
  }

  public Money getSaldoCuota() {
    return saldoCuota;
  }
  
  public void setComproAnticipoProv(ComproAnticipoProveedor aComproAntProv) {
  	this.anticipoProveedor = aComproAntProv;
  }
  
  public ComproAnticipoProveedor getAnticipoProveedor()  {
  	return this.anticipoProveedor;
  }

  public void setTranProvVto(TranProvVto tranProvVto) {
    this.tranProvVto = tranProvVto;
  }

  public void setPagado(Money pagado) {
    this.pagado = pagado;
  }

  public void setDescuento(Money descuento) {
    this.descuento = descuento;
  }

  public void setSaldoCuota(Money saldoCuota) {
    this.saldoCuota = saldoCuota;
  }

  public TranProvVto getTranProvVto() {
    return tranProvVto;
  }

  public CuotaComproPagada() {
  }




}
