package com.srn.erp.general.bm;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class LugarEmision extends ObjetoLogico {

  public LugarEmision() {
  }

  public static String NICKNAME = "ge.LugarEmision";

  private Integer lugEmi;
  private String descripcion;
  private UnidadOrganizativa unidadOrganizativa;
  private Boolean activo;

  public Integer getLugemi() throws BaseException {
    supportRefresh();
    return lugEmi;
  }

  public void setLugemi(Integer aLugemi) {
    this.lugEmi =  aLugemi;
  }

  public String getDescripcion() throws BaseException {
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) {
    this.descripcion =  aDescripcion;
  }

  public UnidadOrganizativa getUnidadorganizativa() throws BaseException {
    supportRefresh();
    return unidadOrganizativa;
  }

  public void setUnidadorganizativa(UnidadOrganizativa aUnidadorganizativa) {
    this.unidadOrganizativa =  aUnidadorganizativa;
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

 public static LugarEmision findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (LugarEmision) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static LugarEmision findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (LugarEmision) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }

 public static LugarEmision findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (LugarEmision) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(lugEmi, "Debe ingresar el Lugar de Emisión");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El Lugar de Emisión debe estar en modo activo");

 }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() throws BaseException {
    return getLugemi().toString();
  }
  
  public String getLugEmiFormato4Digitos() throws BaseException {
		NumberFormat formatLugEmi = new DecimalFormat("0000");
		return formatLugEmi.format(this.getLugemi());
  }
  
  public String getLugEmiFormato5Digitos() throws BaseException {
		NumberFormat formatLugEmi = new DecimalFormat("00000");
		return formatLugEmi.format(this.getLugemi());
  }

  
  public static LugarEmision getLugarEmisionDefaultFactura(ISesion aSesion)
	throws BaseException {
		Integer oidLugEmi = ValorParametro.findByCodigoParametro(
				"LUG_EMI_COMPRO_DEF_FACT", aSesion).getOidObjNeg();
		LugarEmision lugEmi = LugarEmision.findByOid(oidLugEmi, aSesion);
		return lugEmi;
  }
  
  public static LugarEmision getLugarEmisionDefaultRemito(ISesion aSesion)
	throws BaseException {
		Integer oidLugEmi = ValorParametro.findByCodigoParametro(
				"LUG_EMI_COMPRO_DEF_RTO", aSesion).getOidObjNeg();
		LugarEmision lugEmi = LugarEmision.findByOid(oidLugEmi, aSesion);
		return lugEmi;
  }
  
  public static LugarEmision getLugarEmisionDefaultPedido(ISesion aSesion)
	throws BaseException {
		Integer oidLugEmi = ValorParametro.findByCodigoParametro(
				"LUG_EMI_COMPRO_DEF_PED", aSesion).getOidObjNeg();
		LugarEmision lugEmi = LugarEmision.findByOid(oidLugEmi, aSesion);
		return lugEmi;
  }
  
  
  
}
