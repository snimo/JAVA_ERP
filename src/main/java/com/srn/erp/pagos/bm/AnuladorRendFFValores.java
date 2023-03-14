package com.srn.erp.pagos.bm;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.MedioPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.ValorCotizacion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class AnuladorRendFFValores extends ObjetoLogico { 

  public AnuladorRendFFValores() { 
  }

  public static String NICKNAME = "pag.AnuladorRendFFValores";

  private AnuladorRendFF anulador_rend_ff;
  private RendicionFondoFijoMedioPago rend_medio_pago;

  public AnuladorRendFF getAnulador_rend_ff() throws BaseException { 
    supportRefresh();
    return anulador_rend_ff;
  }

  public void setAnulador_rend_ff(AnuladorRendFF aAnulador_rend_ff) { 
    this.anulador_rend_ff =  aAnulador_rend_ff;
  }

  public RendicionFondoFijoMedioPago getRend_medio_pago() throws BaseException { 
    supportRefresh();
    return rend_medio_pago;
  }

  public void setRend_medio_pago(RendicionFondoFijoMedioPago aRend_medio_pago) { 
    this.rend_medio_pago =  aRend_medio_pago;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static AnuladorRendFFValores findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (AnuladorRendFFValores) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static AnuladorRendFFValores findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (AnuladorRendFFValores) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(anulador_rend_ff, "Debe ingresar el Anulador Rend. F.F.");
    Validar.noNulo(rend_medio_pago, "Debe Ingresar el Medio de Pago");
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

public void afterSaveNew() throws BaseException {
	// TODO Auto-generated method stub
	super.afterSaveNew();
	
	// Por la anulacion del Valor el mismo debe salir de la caja
	Caja caja = this.getRend_medio_pago().getCaja();
	MedioPago medioPago = new MedioPago();
	medioPago.setSesion(getSesion());
	medioPago.setComprobante(this.getAnulador_rend_ff());
	medioPago.setIngresoEgreso(MedioPago.INGRESO);	
  medioPago.setTipoValor(this.getRend_medio_pago().getTipo_valor());
  medioPago.setCaja(caja);
  medioPago.setAnulado(true);
  medioPago.setImporteMonedaValor(new Money(this.getRend_medio_pago().getImporte().doubleValue()));
  medioPago.setCotizMonedaValor(new ValorCotizacion(this.getRend_medio_pago().getCotizacion().doubleValue()));
  medioPago.save();

}

}
