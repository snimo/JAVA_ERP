package com.srn.erp.bienUso.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.applicarionServer.bm.Varios.Porcentaje;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class Bien extends ObjetoLogico { 

  public Bien() { 
  }

  public static String NICKNAME = "bu.Bien";

  private String codigo;
  private String descripcion;
  private Boolean amortizable;
  private String estado;
  private java.util.Date fec_alta;
  private GrupoBien grupo_bien_uso;
  private CuentaImputable ai_vo;
  private CuentaImputable ai_aa;
  private CuentaImputable ai_rvo;
  private CuentaImputable ai_raa;
  private Boolean activo;
  
  private List imputaciones = new ArrayList();
  private boolean readImputaciones = true;

  private List subBienes = new ArrayList();
  private boolean readSubBienes = true;  
  
  public String getCodigo() throws BaseException { 
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) { 
    this.codigo =  aCodigo;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Boolean isAmortizable() throws BaseException { 
    supportRefresh();
    return amortizable;
  }

  public void setAmortizable(Boolean aAmortizable) { 
    this.amortizable =  aAmortizable;
  }

  public String getEstado() throws BaseException { 
    supportRefresh();
    return estado;
  }

  public void setEstado(String aEstado) { 
    this.estado =  aEstado;
  }

  public java.util.Date getFec_alta() throws BaseException { 
    supportRefresh();
    return fec_alta;
  }

  public void setFec_alta(java.util.Date aFec_alta) { 
    this.fec_alta =  aFec_alta;
  }

  public GrupoBien getGrupo_bien_uso() throws BaseException { 
    supportRefresh();
    return grupo_bien_uso;
  }

  public void setGrupo_bien_uso(GrupoBien aGrupo_bien_uso) { 
    this.grupo_bien_uso =  aGrupo_bien_uso;
  }

  public CuentaImputable getAi_vo() throws BaseException { 
    supportRefresh();
    return ai_vo;
  }

  public void setAi_vo(CuentaImputable aAi_vo) { 
    this.ai_vo =  aAi_vo;
  }

  public CuentaImputable getAi_aa() throws BaseException { 
    supportRefresh();
    return ai_aa;
  }

  public void setAi_aa(CuentaImputable aAi_aa) { 
    this.ai_aa =  aAi_aa;
  }

  public CuentaImputable getAi_rvo() throws BaseException { 
    supportRefresh();
    return ai_rvo;
  }

  public void setAi_rvo(CuentaImputable aAi_rvo) { 
    this.ai_rvo =  aAi_rvo;
  }

  public CuentaImputable getAi_raa() throws BaseException { 
    supportRefresh();
    return ai_raa;
  }

  public void setAi_raa(CuentaImputable aAi_raa) { 
    this.ai_raa =  aAi_raa;
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

 public static Bien findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (Bien) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static Bien findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (Bien) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 

 
 public static Bien findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (Bien) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(codigo, "Debe ingresar el Código");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción");
    Validar.noNulo(amortizable, "Debe ingresar si es Amortizable");
    Validar.noNulo(fec_alta, "Debe ingresar la Fecha de Alta");
    Validar.noNulo(grupo_bien_uso, "Debe indicar el Grupo Bien");
    Validar.noNulo(ai_vo, "Debe ingresar la cuenta Valor Origen");
    Validar.noNulo(ai_aa, "Debe ingresar la cuenta Amort. Acum.");
    Validar.noNulo(ai_rvo, "Debe ingresar la cuenta RVO");
    Validar.noNulo(ai_raa, "Debe ingresar la cuenta RAA");
 }

 protected void onNew() throws BaseException {
  super.onNew();
  setEstado("ALTA");
 }
 
  public List getBienesImputaciones() throws BaseException {
   if (readImputaciones) {
	   List listaImputaciones = BienImputacion.getImputaciones(this,getSesion());
	   imputaciones.addAll(listaImputaciones);
	   readImputaciones = false;
	  }
    return imputaciones;
  }

  public List getSubBienes() throws BaseException {
	if (readSubBienes) {
	  List listaSubBienes = SubBien.getSubBienes(this,getSesion());
	  subBienes.addAll(listaSubBienes);
	  readSubBienes = false;
	}
	return subBienes;
  }  
  
  public void addBienImputacion(BienImputacion bienImputacion) throws BaseException {
	bienImputacion.setBien_uso(this);
	imputaciones.add(bienImputacion);
  }
  
  public void addSubBien(SubBien aSubBien) throws BaseException {
	aSubBien.setBien_uso(this);
	subBienes.add(aSubBien);
  }  

  public void afterSave() throws BaseException {
	Iterator iterBienesImputaciones = imputaciones.iterator();
	while (iterBienesImputaciones.hasNext()) {
	      BienImputacion bienImputacion = (BienImputacion) iterBienesImputaciones.next();
	      bienImputacion.save();
	      bienImputacion = null;
	}
	iterBienesImputaciones = null;
	Iterator iterSubBienes = subBienes.iterator();
	while (iterSubBienes.hasNext()) {
	      SubBien subBien = (SubBien) iterSubBienes.next();
	      subBien.save();
	      subBien = null;
	}
	iterSubBienes = null;	
  }
  
  public List getValoresDistAImputacion(Date aFecha,Money importeADist) throws BaseException {
	  List valoresDistribuidos = new ArrayList();
	  List porcImputacionesAFecha = getImputacionesVigentesAFecha(aFecha);
	  Iterator iterPorcimputacionesAFecha = porcImputacionesAFecha.iterator();
	  while (iterPorcimputacionesAFecha.hasNext()) {
		  BienImputacion bienImputacion = (BienImputacion) iterPorcimputacionesAFecha.next();
		  CuentaImputable cuentaAmortizacion = bienImputacion.getCuenta_imputable();
		  Porcentaje porc = new Porcentaje(bienImputacion.getPorc().doubleValue());
		  CuentaDistribucionAmortizacion ctaAmortDist = new CuentaDistribucionAmortizacion();
		  CalculadorMoney calcAmort = new CalculadorMoney(importeADist);
		  calcAmort.multiplicarPor(porc);
		  calcAmort.dividirPor(new Money(new Double(100).doubleValue()));
		  ctaAmortDist.setCuentaImputable(cuentaAmortizacion);
		  ctaAmortDist.setImporte(calcAmort.getResultMoney());
		  valoresDistribuidos.add(ctaAmortDist);
	  }
	  return valoresDistribuidos;
  }

  public List getPorcImputaciones(Date aFecha) throws BaseException {
	  return null;
  }
  
  public List getImputacionesVigentesAFecha(java.util.Date fecha) throws BaseException {
	return BienImputacion.getImputacionesVigentesAFecha(this,fecha,getSesion());
  }

  
}
