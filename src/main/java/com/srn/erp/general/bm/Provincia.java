package com.srn.erp.general.bm;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Provincia extends ObjetoLogico {

  public Provincia() {
  }

  public static String NICKNAME = "ge.Provincia";

  private String codigo;
  private String descripcion;
  private Boolean activo;
  private boolean esBuenosAires;
  private boolean esCapitalFederal;
  private boolean calcPercIBBA;

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
  }
  
  public Boolean isCalcPercIBBA() throws BaseException {
	supportRefresh();
	return this.calcPercIBBA;
  }

  public void setCalcPercIBBA(Boolean aCalcPercIBBA) {
	this.calcPercIBBA =  aCalcPercIBBA;
  }
  
  
  public boolean esBuenosAires() throws BaseException {
    supportRefresh();
    return this.esBuenosAires;
  }

  public void setEsBuenosAires(boolean aEsBuenosAires) {
    this.esBuenosAires =  aEsBuenosAires;
  }
  
  public boolean esCapitalFederal() throws BaseException {
    supportRefresh();
    return this.esCapitalFederal;
  }

  public void setEsCapitalFederal(boolean aEsCapitalFederal) {
    this.esCapitalFederal =  aEsCapitalFederal;
  }

  public String getDescripcion() throws BaseException {
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) {
    this.descripcion =  aDescripcion;
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

 public static Provincia findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Provincia) getObjectByOid(NICKNAME,oid,aSesion);
  }

 public static Provincia findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Provincia) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }

 public static Provincia findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Provincia) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {

	 Validar.noNulo(codigo, "Debe ingresar un código de Provincia");
	 Validar.noNulo(descripcion, "Debe ingresar la descripción de la Provincia");
	 
   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La provincia debe ingresarse en modo activo");

 }
 
 public static Provincia getProvinciaDefaultVtaMos(ISesion aSesion) throws BaseException {
   Integer oidProvincia =
       ValorParametro.findByCodigoParametro("PROV_DEF_VTA_MOS",aSesion).getOidObjNeg();
   return Provincia.findByOid(oidProvincia,aSesion);
 }
 
 public static Provincia getProvinciaDefaultFactRtoParaPercIB(ISesion aSesion) throws BaseException {
   Integer oidProvincia =
       ValorParametro.findByCodigoParametro("PROV_DEF_FACT_RTO_PARA_IB",aSesion).getOidObjNeg();
   return Provincia.findByOid(oidProvincia,aSesion);
 }
 
 
 
 

}
