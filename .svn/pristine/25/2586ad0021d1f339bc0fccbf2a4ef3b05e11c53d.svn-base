package com.srn.erp.general.bm;

import com.srn.erp.general.da.DBFactorConversion;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorDecimal;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class FactorConversion extends ObjetoLogico {

  public FactorConversion() {
  }

  public static String NICKNAME = "ge.FactorConversion";

  private UnidadMedida uni_med_ori;
  private UnidadMedida uni_med_dest;
  private Double factor;
  private Boolean activo;

  public UnidadMedida getUni_med_ori() throws BaseException {
    supportRefresh();
    return uni_med_ori;
  }

  public void setUni_med_ori(UnidadMedida aUni_med_ori) {
    this.uni_med_ori =  aUni_med_ori;
  }

  public UnidadMedida getUni_med_dest() throws BaseException {
    supportRefresh();
    return uni_med_dest;
  }

  public void setUni_med_dest(UnidadMedida aUni_med_dest) {
    this.uni_med_dest =  aUni_med_dest;
  }

  public Double getFactor() throws BaseException {
    supportRefresh();
    return factor;
  }

  public void setFactor(Double aFactor) {
    this.factor =  aFactor;
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

 public static FactorConversion findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (FactorConversion) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static FactorConversion findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (FactorConversion) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(uni_med_ori, "Debe Ingresar la Unidad de Medida Origen");
    Validar.noNulo(uni_med_dest, "Debe Ingresar la Unidad de Medida Destino");
    Validar.noNulo(factor, "Debe ingresar el Factor de Conversión");
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

  public static FactorConversion getFactConv(UnidadMedida umOri,
                                    UnidadMedida umDest,
                                    ISesion aSesion)  throws BaseException {
    return DBFactorConversion.getFactConv(umOri,umDest,aSesion);
  }
  
  public static Double getFactorConvGral(UnidadMedida uniMedOri,UnidadMedida uniMedDest , ISesion aSesion) throws BaseException {
	  FactorConversion factor = FactorConversion.getFactConv(uniMedOri,uniMedDest,aSesion);
	  if (factor!=null) return factor.getFactor();
	  
	  factor = FactorConversion.getFactConv(uniMedDest,uniMedOri,aSesion);
	  if (factor!=null) {
	  	  CalculadorDecimal calc = new CalculadorDecimal(new NumeroBase(1));
		  calc.dividirPor(new NumeroBase(factor.getFactor()));
		  return new Double(calc.getResult()); 		  
	  }
	  return null;
  }  


}
