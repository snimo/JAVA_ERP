package com.srn.erp.ventas.bm;

import java.util.List;

import com.srn.erp.ventas.da.DBBonifRecarSujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorCotizacion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Decimal;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class BonifRecarSujeto extends ObjetoLogico {

  public BonifRecarSujeto() {
  }

  public static String NICKNAME = "ve.BonifRecarSujeto";

  private java.util.Date fec_vig_desde;
  private java.util.Date fec_vig_hasta;
  private Decimal bonif1;
  private Decimal bonif2;
  private Decimal bonif3;
  private Decimal bonif4;
  private Decimal bonif5;
  private Boolean en_cascada_bonif;
  private Decimal reca1;
  private Decimal reca2;
  private Decimal reca3;
  private Decimal reca4;
  private Decimal reca5;
  private Boolean en_cascada_reca;
  private Sujeto sujeto;

  public java.util.Date getFec_vig_desde() throws BaseException {
    supportRefresh();
    return fec_vig_desde;
  }

  public void setFec_vig_desde(java.util.Date aFec_vig_desde) {
    this.fec_vig_desde =  aFec_vig_desde;
  }
  
  public java.util.Date getFec_vig_hasta() throws BaseException {
    supportRefresh();
    return fec_vig_hasta;
  }

  public void setFec_vig_hasta(java.util.Date aFec_vig_hasta) {
    this.fec_vig_hasta =  aFec_vig_hasta;
  }  

  public Decimal getBonif1() throws BaseException {
    supportRefresh();
    return bonif1;
  }

  public void setBonif1(Decimal aBonif1) {
    this.bonif1 =  aBonif1;
  }

  public Decimal getBonif2() throws BaseException {
    supportRefresh();
    return bonif2;
  }

  public void setBonif2(Decimal aBonif2) {
    this.bonif2 =  aBonif2;
  }

  public Decimal getBonif3() throws BaseException {
    supportRefresh();
    return bonif3;
  }

  public void setBonif3(Decimal aBonif3) {
    this.bonif3 =  aBonif3;
  }

  public Decimal getBonif4() throws BaseException {
    supportRefresh();
    return bonif4;
  }

  public void setBonif4(Decimal aBonif4) {
    this.bonif4 =  aBonif4;
  }

  public Decimal getBonif5() throws BaseException {
    supportRefresh();
    return bonif5;
  }

  public void setBonif5(Decimal aBonif5) {
    this.bonif5 =  aBonif5;
  }

  public Boolean isEn_cascada_bonif() throws BaseException {
    supportRefresh();
    return en_cascada_bonif;
  }

  public void setEn_cascada_bonif(Boolean aEn_cascada_bonif) {
    this.en_cascada_bonif =  aEn_cascada_bonif;
  }

  public Decimal getReca1() throws BaseException {
    supportRefresh();
    return reca1;
  }

  public void setReca1(Decimal aReca1) {
    this.reca1 =  aReca1;
  }

  public Decimal getReca2() throws BaseException {
    supportRefresh();
    return reca2;
  }

  public void setReca2(Decimal aReca2) {
    this.reca2 =  aReca2;
  }

  public Decimal getReca3() throws BaseException {
    supportRefresh();
    return reca3;
  }

  public void setReca3(Decimal aReca3) {
    this.reca3 =  aReca3;
  }

  public Decimal getReca4() throws BaseException {
    supportRefresh();
    return reca4;
  }

  public void setReca4(Decimal aReca4) {
    this.reca4 =  aReca4;
  }

  public Decimal getReca5() throws BaseException {
    supportRefresh();
    return reca5;
  }

  public void setReca5(Decimal aReca5) {
    this.reca5 =  aReca5;
  }

  public Boolean isEn_cascada_reca() throws BaseException {
    supportRefresh();
    return en_cascada_reca;
  }

  public void setEn_cascada_reca(Boolean aEn_cascada_reca) {
    this.en_cascada_reca =  aEn_cascada_reca;
  }

  public Sujeto getSujeto() throws BaseException {
    supportRefresh();
    return sujeto;
  }

  public void setSujeto(Sujeto aSujeto) {
    this.sujeto =  aSujeto;
  }

  public String getNickName() {
    return NICKNAME;
  }

 public static BonifRecarSujeto findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (BonifRecarSujeto) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static BonifRecarSujeto findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (BonifRecarSujeto) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(fec_vig_desde, "Debe ingresar la Fecha de Vigencia Desde");
    Validar.noNulo(fec_vig_hasta, "Debe ingresar la Fecha de Vigencia Hasta");
    Validar.noNulo(en_cascada_bonif, "Debe ingresar si la bonificación es en cascada");
    Validar.noNulo(en_cascada_reca, "Debe ingresar si el recargo es en cascada");
    Validar.noNulo(sujeto, "Debe ingresar el sujeto");
 }

  /**
   * isActivo
   *
   * @return Boolean
   */
  public Boolean isActivo() {
    return null;
  }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() {
    return "";
  }

  public static List getBonifRecar(Sujeto sujeto,
                                   ISesion aSesion) throws BaseException {
    return DBBonifRecarSujeto.getBonifRecar(sujeto,aSesion);
  }

  public Porcentaje getPorcDto() throws BaseException {
    if (isEn_cascada_bonif().booleanValue())
      return getPorcBonifCascada();
    else
      return getPorcBonifDirecta();
  }

  public static BonifRecarSujeto getBonificacion(Sujeto aSujeto,
                                                 java.util.Date aFecha,
                                                 ISesion aSesion) throws BaseException {
    return DBBonifRecarSujeto.getBonifRecarVigente(aSujeto,aFecha,aSesion);
  }

  private Porcentaje getPorcBonifCascada() throws BaseException {
    CalculadorCotizacion calcPorcBonif1 =
        new CalculadorCotizacion(new NumeroBase(1-(getBonif1().doubleValue()/100)));
    CalculadorCotizacion calcPorcBonif2 =
        new CalculadorCotizacion(new NumeroBase(1-(getBonif2().doubleValue()/100)));
    CalculadorCotizacion calcPorcBonif3 =
        new CalculadorCotizacion(new NumeroBase(1-(getBonif3().doubleValue()/100)));
    CalculadorCotizacion calcPorcBonif4 =
        new CalculadorCotizacion(new NumeroBase(1-(getBonif4().doubleValue()/100)));
    CalculadorCotizacion calcPorcBonif5 =
        new CalculadorCotizacion(new NumeroBase(1-(getBonif5().doubleValue()/100)));
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
        new CalculadorMoney(new NumeroBase(getBonif1().doubleValue()));
    calc.sumar(new NumeroBase(getBonif2().doubleValue()));
    calc.sumar(new NumeroBase(getBonif3().doubleValue()));
    calc.sumar(new NumeroBase(getBonif4().doubleValue()));
    calc.sumar(new NumeroBase(getBonif5().doubleValue()));
    return new Porcentaje(calc.getResult());
  }

  public Porcentaje getPorcRecar() throws BaseException {
    if (isEn_cascada_reca().booleanValue())
      return getPorcRecarCascada();
    else
      return getPorcRecarDirecta();
  }

  private Porcentaje getPorcRecarCascada() throws BaseException {
    CalculadorCotizacion calcPorcRecar1 =
        new CalculadorCotizacion(new NumeroBase(1-(getReca1().doubleValue()/100)));
    CalculadorCotizacion calcPorcRecar2 =
        new CalculadorCotizacion(new NumeroBase(1-(getReca2().doubleValue()/100)));
    CalculadorCotizacion calcPorcRecar3 =
        new CalculadorCotizacion(new NumeroBase(1-(getReca3().doubleValue()/100)));
    CalculadorCotizacion calcPorcRecar4 =
        new CalculadorCotizacion(new NumeroBase(1-(getReca4().doubleValue()/100)));
    CalculadorCotizacion calcPorcRecar5 =
        new CalculadorCotizacion(new NumeroBase(1-(getReca5().doubleValue()/100)));
    CalculadorCotizacion calc = new CalculadorCotizacion(new NumeroBase(1.0));
    calc.multiplicarPor(calcPorcRecar1.getResultNroBase());
    calc.multiplicarPor(calcPorcRecar2.getResultNroBase());
    calc.multiplicarPor(calcPorcRecar3.getResultNroBase());
    calc.multiplicarPor(calcPorcRecar4.getResultNroBase());
    calc.multiplicarPor(calcPorcRecar5.getResultNroBase());
    CalculadorMoney porcentajeRecar = new CalculadorMoney(new NumeroBase(1.0));
    porcentajeRecar.restar(calc.getResultNroBase());
    porcentajeRecar.multiplicarPor(new NumeroBase(100));
    return new Porcentaje(porcentajeRecar.getResult());
  }

  private Porcentaje getPorcRecarDirecta() throws BaseException {
    CalculadorMoney calc =
        new CalculadorMoney(new NumeroBase(getReca1().doubleValue()));
    calc.sumar(new NumeroBase(getReca2().doubleValue()));
    calc.sumar(new NumeroBase(getReca3().doubleValue()));
    calc.sumar(new NumeroBase(getReca4().doubleValue()));
    calc.sumar(new NumeroBase(getReca5().doubleValue()));
    return new Porcentaje(calc.getResult());
  }

}
