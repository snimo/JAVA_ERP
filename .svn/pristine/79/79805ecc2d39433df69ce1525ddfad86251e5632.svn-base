package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBEsquemaBonifProdDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorCotizacion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class EsquemaBonifProdDet extends ObjetoLogico { 

  public EsquemaBonifProdDet() { 
  }

  public static String NICKNAME = "ve.EsquemaBonifProdDet";

  private EsquemaBonificacionProducto esquema_bonif_producto;
  private java.util.Date fec_desde;
  private java.util.Date fec_hasta;
  private Double porc_bonif_1;
  private Double porc_bonif_2;
  private Double porc_bonif_3;
  private Double porc_bonif_4;
  private Double porc_bonif_5;
  private Boolean en_cascada;
  private Boolean activo;

  public EsquemaBonificacionProducto getEsquema_bonif_producto() throws BaseException { 
    supportRefresh();
    return esquema_bonif_producto;
  }

  public void setEsquema_bonif_producto(EsquemaBonificacionProducto aEsquema_bonif_producto) { 
    this.esquema_bonif_producto =  aEsquema_bonif_producto;
  }

  public java.util.Date getFec_desde() throws BaseException { 
    supportRefresh();
    return fec_desde;
  }

  public void setFec_desde(java.util.Date aFec_desde) { 
    this.fec_desde =  aFec_desde;
  }

  public java.util.Date getFec_hasta() throws BaseException { 
    supportRefresh();
    return fec_hasta;
  }

  public void setFec_hasta(java.util.Date aFec_hasta) { 
    this.fec_hasta =  aFec_hasta;
  }

  public Double getPorc_bonif_1() throws BaseException { 
    supportRefresh();
    return porc_bonif_1;
  }

  public void setPorc_bonif_1(Double aPorc_bonif_1) { 
    this.porc_bonif_1 =  aPorc_bonif_1;
  }

  public Double getPorc_bonif_2() throws BaseException { 
    supportRefresh();
    return porc_bonif_2;
  }

  public void setPorc_bonif_2(Double aPorc_bonif_2) { 
    this.porc_bonif_2 =  aPorc_bonif_2;
  }

  public Double getPorc_bonif_3() throws BaseException { 
    supportRefresh();
    return porc_bonif_3;
  }

  public void setPorc_bonif_3(Double aPorc_bonif_3) { 
    this.porc_bonif_3 =  aPorc_bonif_3;
  }

  public Double getPorc_bonif_4() throws BaseException { 
    supportRefresh();
    return porc_bonif_4;
  }

  public void setPorc_bonif_4(Double aPorc_bonif_4) { 
    this.porc_bonif_4 =  aPorc_bonif_4;
  }

  public Double getPorc_bonif_5() throws BaseException { 
    supportRefresh();
    return porc_bonif_5;
  }

  public void setPorc_bonif_5(Double aPorc_bonif_5) { 
    this.porc_bonif_5 =  aPorc_bonif_5;
  }

  public Boolean isEn_cascada() throws BaseException { 
    supportRefresh();
    return en_cascada;
  }

  public void setEn_cascada(Boolean aEn_cascada) { 
    this.en_cascada =  aEn_cascada;
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

 public static EsquemaBonifProdDet findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (EsquemaBonifProdDet) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static EsquemaBonifProdDet findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (EsquemaBonifProdDet) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(esquema_bonif_producto, "Debe ingresar el esquema de Bonificación");
    Validar.noNulo(fec_desde, "Debe ingresar la Fecha Desde");
    Validar.noNulo(fec_hasta, "Debe ingresar la Fecha Hasta");
 }

 public String getCodigo() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }

 public String getDescripcion() throws BaseException {
	// TODO Auto-generated method stub
	return null;
 }

 public static List getEsquemasBonifProdDet(EsquemaBonificacionProducto esquemaBonificacionProducto,
        ISesion aSesion) throws BaseException {
	  return DBEsquemaBonifProdDet.getEsquemasBonifProdDet(esquemaBonificacionProducto,aSesion);
 }
 
 public static EsquemaBonifProdDet getEsquemasBonifProdDetVigAFecha(EsquemaBonificacionProducto esquemaBonificacionProducto,
			java.util.Date fecha,
			ISesion aSesion) throws BaseException {
  return DBEsquemaBonifProdDet.getEsquemasBonifProdDet(esquemaBonificacionProducto,fecha,aSesion);
 }
 
  public Porcentaje getPorcDto() throws BaseException {
	if (isEn_cascada().booleanValue())
	   return getPorcBonifCascada();
	else
	   return getPorcBonifDirecta();
  }
  
  private Porcentaje getPorcBonifCascada() throws BaseException {
	CalculadorCotizacion calcPorcBonif1 =
	  new CalculadorCotizacion(new NumeroBase(1-(getPorc_bonif_1().doubleValue()/100)));
	CalculadorCotizacion calcPorcBonif2 =
	  new CalculadorCotizacion(new NumeroBase(1-(getPorc_bonif_2().doubleValue()/100)));
	CalculadorCotizacion calcPorcBonif3 =
	  new CalculadorCotizacion(new NumeroBase(1-(getPorc_bonif_3().doubleValue()/100)));
	CalculadorCotizacion calcPorcBonif4 =
	  new CalculadorCotizacion(new NumeroBase(1-(getPorc_bonif_4().doubleValue()/100)));
	CalculadorCotizacion calcPorcBonif5 =
	  new CalculadorCotizacion(new NumeroBase(1-(getPorc_bonif_5().doubleValue()/100)));
	CalculadorCotizacion calc = new CalculadorCotizacion(new NumeroBase(1.0));
	  calc.multiplicarPor(calcPorcBonif1.getResultNroBase());
	calc.multiplicarPor(calcPorcBonif2.getResultNroBase());
	  calc.multiplicarPor(calcPorcBonif3.getResultNroBase());
	calc.multiplicarPor(calcPorcBonif4.getResultNroBase());
	  calc.multiplicarPor(calcPorcBonif5.getResultNroBase());
	CalculadorMoney porcentajeBonif = new CalculadorMoney(new NumeroBase(1.0));
	  porcentajeBonif.restar(calc.getResultNroBase());
	porcentajeBonif.multiplicarPor(new NumeroBase(100));
	return new Porcentaje(porcentajeBonif.getResult());
  }

  private Porcentaje getPorcBonifDirecta() throws BaseException {
	 CalculadorMoney calc =
	        new CalculadorMoney(new NumeroBase(getPorc_bonif_1().doubleValue()));
	 calc.sumar(new NumeroBase(getPorc_bonif_2().doubleValue()));
	 calc.sumar(new NumeroBase(getPorc_bonif_3().doubleValue()));
	 calc.sumar(new NumeroBase(getPorc_bonif_4().doubleValue()));
	 calc.sumar(new NumeroBase(getPorc_bonif_5().doubleValue()));
	 return new Porcentaje(calc.getResult());
  }
  
 
 

}
