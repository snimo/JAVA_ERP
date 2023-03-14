package com.srn.erp.bienUso.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.bienUso.da.DBSubBienVidaUtil;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.NumeroBase;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SubBienVidaUtil extends ObjetoLogico { 
	
  private List valoresOrigen = new ArrayList();
  private boolean readValorOrigen = true;	

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

  public SubBienVidaUtil() { 
  }

  public static String NICKNAME = "bu.SubBienVidaUtil";

  private SubBien subBien;
  private SistemaValuacion sistema_valuacion;
  private Integer vidal_util;
  private Integer meses_amort;
  private Periodo ult_peri_amort;
  private java.util.Date fec_ult_amort;
  private Double tasa_acu;
  private Double tasa_acu_ejer_ant;
  private Double tasa_acu_ejer_act;
  private Integer ant_meses_amort;
  private Periodo ant_ult_peri;
  private Double ant_tasa_acu;
  private Double ant_tasa_acu_eje_a;
  private Double ult_tasa_aplic;

  public SubBien getSubbien() throws BaseException { 
    supportRefresh();
    return subBien;
  }
  
  public Double getUltTasaAplic() throws BaseException {
	supportRefresh();
	return ult_tasa_aplic;
  }
  
  public void setUltTasaAplic(Double aUltTasaAplic) throws BaseException {
	  this.ult_tasa_aplic = aUltTasaAplic;
  }

  public void setSubbien(SubBien aSubbien) { 
    this.subBien =  aSubbien;
  }

  public SistemaValuacion getSistema_valuacion() throws BaseException { 
    supportRefresh();
    return sistema_valuacion;
  }

  public void setSistema_valuacion(SistemaValuacion aSistema_valuacion) { 
    this.sistema_valuacion =  aSistema_valuacion;
  }
  
  public void setTasaAcuEjerActual(Double aTasaAcumEjerActual) throws BaseException {
	  this.tasa_acu_ejer_act = aTasaAcumEjerActual;
  }
  
  public Double getTasaAcuEjerActual() throws BaseException {
	  supportRefresh();
	  if (tasa_acu_ejer_act == null)
		  return new Double(0);
	  else
		  return tasa_acu_ejer_act;
  }
  

  public Integer getVidal_util() throws BaseException { 
    supportRefresh();
    return vidal_util;
  }

  public void setVidal_util(Integer aVidal_util) { 
    this.vidal_util =  aVidal_util;
  }

  public Integer getMeses_amort() throws BaseException { 
    supportRefresh();
    return meses_amort;
  }

  public void setMeses_amort(Integer aMeses_amort) { 
    this.meses_amort =  aMeses_amort;
  }

  public Periodo getUlt_peri_amort() throws BaseException { 
    supportRefresh();
    return ult_peri_amort;
  }

  public void setUlt_peri_amort(Periodo aUlt_peri_amort) { 
    this.ult_peri_amort =  aUlt_peri_amort;
  }

  public java.util.Date getFec_ult_amort() throws BaseException { 
    supportRefresh();
    return fec_ult_amort;
  }

  public void setFec_ult_amort(java.util.Date aFec_ult_amort) { 
    this.fec_ult_amort =  aFec_ult_amort;
  }

  public Double getTasa_acu() throws BaseException { 
    supportRefresh();
    return tasa_acu;
  }

  public void setTasa_acu(Double aTasa_acu) { 
    this.tasa_acu =  aTasa_acu;
  }

  public Double getTasa_acu_ejer_ant() throws BaseException { 
    supportRefresh();
    return tasa_acu_ejer_ant;
  }

  public void setTasa_acu_ejer_ant(Double aTasa_acu_ejer_ant) { 
    this.tasa_acu_ejer_ant =  aTasa_acu_ejer_ant;
  }

  public Integer getAnt_meses_amort() throws BaseException { 
    supportRefresh();
    return ant_meses_amort;
  }

  public void setAnt_meses_amort(Integer aAnt_meses_amort) { 
    this.ant_meses_amort =  aAnt_meses_amort;
  }

  public Periodo getAnt_ult_peri() throws BaseException { 
    supportRefresh();
    return ant_ult_peri;
  }

  public void setAnt_ult_peri(Periodo aAnt_ult_peri) { 
    this.ant_ult_peri =  aAnt_ult_peri;
  }

  public Double getAnt_tasa_acu() throws BaseException { 
    supportRefresh();
    return ant_tasa_acu;
  }

  public void setAnt_tasa_acu(Double aAnt_tasa_acu) { 
    this.ant_tasa_acu =  aAnt_tasa_acu;
  }

  public Double getAnt_tasa_acu_eje_a() throws BaseException { 
    supportRefresh();
    return ant_tasa_acu_eje_a;
  }

  public void setAnt_tasa_acu_eje_a(Double aAnt_tasa_acu_eje_a) { 
    this.ant_tasa_acu_eje_a =  aAnt_tasa_acu_eje_a;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static SubBienVidaUtil findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SubBienVidaUtil) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static SubBienVidaUtil findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (SubBienVidaUtil) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 
 public static SubBienVidaUtil findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SubBienVidaUtil) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(subBien, "Debe ingresar el Sub-Bien");
    Validar.noNulo(sistema_valuacion, "Debe ingresar el Sistema de Valuación");
    Validar.noNulo(vidal_util, "Debe ingresar la Vidal Util");
    Validar.noNulo(meses_amort, "Debe ingresar cant. Meses Amort.");
    Validar.noNulo(tasa_acu, "Debe ingresar la Tasa Acumulada");
    Validar.noNulo(tasa_acu_ejer_ant, "Dene ingresar la Tasa Ejer. Ant.");
 }
 
 public static List getSubBienesVidalUtil(SubBien aSubBien,
         ISesion aSesion) throws BaseException {
   return DBSubBienVidaUtil.getSubBienesVidalUtil(aSubBien,aSesion);
 } 
 
 public static SubBienVidaUtil getSubBienVidaUtil(SubBien subBien,SistemaValuacion sistVal,ISesion aSesion)
 	throws BaseException {
   return DBSubBienVidaUtil.getSubBienVidaUtil(subBien,sistVal,aSesion);
 }

 protected void onNew() throws BaseException {
	// TODO Auto-generated method stub
	super.onNew();
	vidal_util = new Integer(0);
	meses_amort = new Integer(0);
	tasa_acu = new Double(0);
	tasa_acu_ejer_ant = new Double(0);
	ant_meses_amort = new Integer(0);
	ant_tasa_acu = new Double(0);
	ant_tasa_acu_eje_a = new Double(0);
	ult_tasa_aplic = new Double(0);
 }
 
  public List getValoresOrigen() throws BaseException {
    if (readValorOrigen) {
	   List listaValoresOrigenes = ComposicionValorOrigen.getValoresOrigen(this,getSesion());
	   valoresOrigen.addAll(listaValoresOrigenes);
	   readValorOrigen = false;
    }
    return valoresOrigen;
  }

  public void addValorOrigen(ComposicionValorOrigen composicionValorOrigen) throws BaseException {
	composicionValorOrigen.setSubbienVidaUtil(this);
	valoresOrigen.add(composicionValorOrigen);
  }

  public void afterSave() throws BaseException {
	Iterator iterValoresOrigen = valoresOrigen.iterator();
	while (iterValoresOrigen.hasNext()) {
	  ComposicionValorOrigen composicionValorOrigen = (ComposicionValorOrigen) iterValoresOrigen.next();
	  composicionValorOrigen.save();
	  composicionValorOrigen = null;
	}
	iterValoresOrigen = null;
  }
  
  public Double getValorOrigen() throws BaseException {
	CalculadorMoney calc = new CalculadorMoney(new NumeroBase(0));   
	Iterator iterValoresOrigen = getValoresOrigen().iterator();
	while (iterValoresOrigen.hasNext()) {
		ComposicionValorOrigen compoValorOrigen = (ComposicionValorOrigen) iterValoresOrigen.next();
		calc.sumar(new NumeroBase(compoValorOrigen.getImpo_valor()));
	}
	return new Double(calc.getResult()); 
  }
  
}
