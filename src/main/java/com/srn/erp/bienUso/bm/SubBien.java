package com.srn.erp.bienUso.bm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.bienUso.da.DBSubBien;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class SubBien extends ObjetoLogico { 

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

  public SubBien() { 
  }

  public static String NICKNAME = "bu.SubBien";

  private Bien bien_uso;
  private Integer nro_alta;
  private String descripcion;
  private Boolean sigue_bien_ppal;
  private Periodo peri_ini_amort;
  private Boolean activo;

  private List subBienesVidaUtil = new ArrayList();
  private boolean readsubBienesVidaUtil = true;
  
  
  public Bien getBien_uso() throws BaseException { 
    supportRefresh();
    return bien_uso;
  }

  public void setBien_uso(Bien aBien_uso) { 
    this.bien_uso =  aBien_uso;
  }

  public Integer getNro_alta() throws BaseException { 
    supportRefresh();
    return nro_alta;
  }

  public void setNro_alta(Integer aNro_alta) { 
    this.nro_alta =  aNro_alta;
  }

  public String getDescripcion() throws BaseException { 
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) { 
    this.descripcion =  aDescripcion;
  }

  public Boolean isSigue_bien_ppal() throws BaseException { 
    supportRefresh();
    return sigue_bien_ppal;
  }

  public void setSigue_bien_ppal(Boolean aSigue_bien_ppal) { 
    this.sigue_bien_ppal =  aSigue_bien_ppal;
  }

  public Periodo getPeri_ini_amort() throws BaseException { 
    supportRefresh();
    return peri_ini_amort;
  }

  public void setPeri_ini_amort(Periodo aPeri_ini_amort) { 
    this.peri_ini_amort =  aPeri_ini_amort;
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

 public static SubBien findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (SubBien) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static SubBien findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (SubBien) getObjectByOidProxy(NICKNAME,oid,aSesion);
 }
 
 public static SubBien findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (SubBien) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(bien_uso, "Debe ingresar el Bien");
    Validar.noNulo(nro_alta, "Debe ingresar el Nro. de alta");
    Validar.noNulo(descripcion, "Debe ingresar la Descripción del Sub-Bien");
    Validar.noNulo(sigue_bien_ppal, "Debe indicar si sigue el bien principal");
    Validar.noNulo(peri_ini_amort, "Debe ingresar el Período");
 }
 
 public static List getSubBienes(Bien aBien,
         ISesion aSesion) throws BaseException {
   return DBSubBien.getSubBienes(aBien,aSesion);
 }  
 
 public List getSubBienesVidaUtil() throws BaseException {
   if (readsubBienesVidaUtil) {
	  List listaSubBienesVidaUtil = SubBienVidaUtil.getSubBienesVidalUtil(this,getSesion());
	  subBienesVidaUtil.addAll(listaSubBienesVidaUtil);
	  readsubBienesVidaUtil = false;
   }	
   return subBienesVidaUtil;
 }  
	  
  public void addSubBienVidaUtil(SubBienVidaUtil subBienVidaUtil) throws BaseException {
    subBienVidaUtil.setSubbien(this);
	subBienesVidaUtil.add(subBienVidaUtil);
  }
  
  public Integer getVidaUtil(SistemaValuacion sistemaValuacion) throws BaseException {
	  Integer vidaUtil = null;
	  Iterator iterSubBienesVidaUtil = getSubBienesVidaUtil().iterator();
	  while (iterSubBienesVidaUtil.hasNext()) {
	    SubBienVidaUtil subBienVidaUtil = (SubBienVidaUtil) iterSubBienesVidaUtil.next();
	    if (subBienVidaUtil.getSistema_valuacion().getOID() == sistemaValuacion.getOID()) {
	    	vidaUtil = subBienVidaUtil.getVidal_util();
	    	return vidaUtil;
	    }	
	  }
	  return vidaUtil;
  }
	  
  public void afterSave() throws BaseException {
	Iterator iterSubBienesVU = subBienesVidaUtil.iterator();
	while (iterSubBienesVU.hasNext()) {
		 SubBienVidaUtil subBienVidaUtil = (SubBienVidaUtil) iterSubBienesVU.next();
		 subBienVidaUtil.save();
		 subBienVidaUtil = null;
		}
	iterSubBienesVU = null;	
		
  }
  
  
  public SubBienVidaUtil getSubBienVidaUtil(SistemaValuacion sistVal)
	throws BaseException {
	  return SubBienVidaUtil.getSubBienVidaUtil(this,sistVal,getSesion());
  }   

  public static List getSubBienes(ISesion aSesion) throws BaseException {
	return DBSubBien.getSubBienes(aSesion);
  } 
  
  public boolean isAmortizable(SistemaValuacion sistemaValuacion,Periodo periodo) throws BaseException {
	Integer vidaUtil = null;  
	SubBienVidaUtil subBienVidaUtil = null;
	if (!getBien_uso().isAmortizable().booleanValue())
		return false;
	if (getPeri_ini_amort()==null)
		return false;
	vidaUtil = getVidaUtil(sistemaValuacion); 
	if (vidaUtil==null)
		return false;
	if ((vidaUtil!=null) && (vidaUtil.intValue()<=0))
	    return false;
	if (getPeri_ini_amort().isPosterior(periodo))
		return false;
	subBienVidaUtil = getSubBienVidaUtil(sistemaValuacion);
	if (subBienVidaUtil==null) return false;
	if ((subBienVidaUtil!=null) && (subBienVidaUtil.getMeses_amort()==null))
		return false;
	if (subBienVidaUtil.getMeses_amort().intValue()>=vidaUtil.intValue())
		return false;
	if ((subBienVidaUtil.getUlt_peri_amort()!=null) && (subBienVidaUtil.getUlt_peri_amort().getMesesEntre(periodo)>1))
		return false;
	return true;
  }
  
  
  public Money getValorOrigen(SistemaValuacion sistemaValuacion) throws BaseException {
	  ValorOrigenSubBien valorOrigenSubBien = ValorOrigenSubBien.getValorOrigenSubBien(this,sistemaValuacion,getSesion());
	  if (valorOrigenSubBien!=null)
		  return valorOrigenSubBien.getValor_origen();
	  else
		  return new Money(0);
  }
  
  public Money getRevaluoValorOrigen(SistemaValuacion sistemaValuacion,
		                             Periodo periodoAExcluir) throws BaseException {
	  RevaluoValorOrigenSubBien revValOri = 
		  RevaluoValorOrigenSubBien.getRevaluoValorOrigenSubBien(this,
				  					sistemaValuacion,
				  					periodoAExcluir,
				  					getSesion());
	  return revValOri.getRevaluo_Valor_origen();
  }
  
  public Money getTasaAmortizacion(SistemaValuacion sistemaValuacion) throws BaseException {
	  SubBienVidaUtil subBienVidaUtil = this.getSubBienVidaUtil(sistemaValuacion);
	  if (subBienVidaUtil!=null) {
		  Integer vidaUtil = subBienVidaUtil.getVidal_util();
		  if (vidaUtil==null) return null;
		  if (vidaUtil.intValue()==0) return null;
		  CalculadorMoney calcTasa = new CalculadorMoney(new Money(0));
		  calcTasa.sumar(new Money(1));
		  calcTasa.dividirPor(new Money(vidaUtil.toString()));
		  return calcTasa.getResultMoney(); 
	  }	  
	  else
	      return null;
  }
  
  public Money getTasaAcum(SistemaValuacion sistemaValuacion,
		  				   Periodo periodo) throws BaseException {
	  SubBienVidaUtil subBienVidaUtil = getSubBienVidaUtil(sistemaValuacion);
	  Money tasaAmortAcum = new Money(subBienVidaUtil.getTasa_acu().doubleValue());
	  CalculadorMoney tasaAcum = new CalculadorMoney(tasaAmortAcum);
	  if (isPeriodoYaAmortizado(sistemaValuacion,periodo))
		  tasaAcum.restar(new Money(subBienVidaUtil.getUltTasaAplic().doubleValue()));	  
	  return tasaAcum.getResultMoney();
  }
  
  public boolean isPeriodoYaAmortizado(SistemaValuacion sistemaValuacion,Periodo periodo) throws BaseException {
	  Periodo ultimoPeriodo = getUltimoPeriodoAmortizado(sistemaValuacion); 
	  if (ultimoPeriodo == null)
		  return false;
	  if (periodo.isPosterior(ultimoPeriodo))
		  return false;
	  else
		  return true;
  }
  
  public Periodo getUltimoPeriodoAmortizado(SistemaValuacion sistemaValuacion) throws BaseException {
	  SubBienVidaUtil subBienVidaUtil = getSubBienVidaUtil(sistemaValuacion);
	  return subBienVidaUtil.getUlt_peri_amort();
  }
  
  public Money getAmortizacionAcumuladaHastaPeriAnt(SistemaValuacion sistemaValuacion,Periodo periodo) throws BaseException {
	  AmortizacionAcumulada amortAcum = AmortizacionAcumulada.getAmortizacionAcumuladaHastaPeriAnt(this,sistemaValuacion,periodo,getSesion());
	  return amortAcum.getAmortizacionAcumulada();
  }
  
  public Money getTasaAcumEjerAnteriores(SistemaValuacion sistemaValuacion) throws BaseException {
	  SubBienVidaUtil subBienVidaUtil = this.getSubBienVidaUtil(sistemaValuacion);
	  Money tasaAcumEjerAnt = new Money(subBienVidaUtil.getTasa_acu_ejer_ant().doubleValue());	  
	  return tasaAcumEjerAnt;
  }
  
  public Money getAmortAcumAjustesEjerAnt(SistemaValuacion sistemaValuacion,Periodo periodo) throws BaseException {
	  Periodo primerPeriodoEjercicio = periodo.getPrimerPeriodoEjercicio();
	  AmortizacionAcumulada amortizacionAcumulada = AmortizacionAcumulada.getAmortAcumAjAmortEjerAnt(this,
			  																						 sistemaValuacion,
			  																						 primerPeriodoEjercicio,
			  																						 getSesion());
	  return amortizacionAcumulada.getAmortizacionAcumulada();
  }
  
  
  
  
}
