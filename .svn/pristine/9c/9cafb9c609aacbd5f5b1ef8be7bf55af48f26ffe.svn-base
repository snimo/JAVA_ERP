package com.srn.erp.bienUso.bm;

import java.util.Hashtable;
import java.util.List;

import com.srn.erp.bienUso.da.DBMovimientoBienUso;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.Validar;

public class MovimientoBienUso extends ObjetoLogico { 

  public static final String TM_VO = "VO";
  public static final String TM_RVO = "RVO";
  public static final String TM_AM_VO = "AM_VO";
  public static final String TM_RAM_VO = "RAM_VO";
  public static final String TM_AJ_AMO_MESES_ANT = "AJ_MA";
  public static final String TM_AJ_AMO_EJER_ANT = "AJ_EA";
  public static final String TM_BAJA_VO = "BAJA_VO";
  public static final String TM_BAJA_REV_VO = "BAJA_RVO";
  public static final String TM_BAJA_AM_VO = "BAJA_AMVO";
  public static final String TM_BAJA_REV_AM_VO = "BAJA_RAMVO";
  public static final String TM_BAJA_REV_AM_EA = "BAJA_RAEA";
  
	
  public static String getTipoMovValorOrigen() {
	  return TM_VO;
  }
  
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

public MovimientoBienUso() { 
  }

  public static String NICKNAME = "bu.MovimientoBienUso";

  private SubBien sub_bien;
  private java.util.Date fec_imputac;
  private String tipo_mov;
  private Periodo periodo;
  private ComproContaDet compro_conta_det;
  private SistemaValuacion sistemaValuacion;
  Integer mesesAmort;
  Money tasaAmort;
  Money importe;
  private ComproBienUsoDet comproBienUsoDet;
  private Integer signo;
  
  
  public Integer getSigno() throws BaseException {
	  supportRefresh();
	  return signo;
  }
  
  public void setSigno(Integer aSigno) throws BaseException {
	  this.signo = aSigno;
  }
  
  public SistemaValuacion getSistemaValuacion() throws BaseException {
	 supportRefresh();
	 return sistemaValuacion;
  }
  
  public void setSistemaValuacion(SistemaValuacion sistemaValuacion) throws BaseException {
	  this.sistemaValuacion = sistemaValuacion;
  }
  
  public ComproBienUsoDet getComproBienUsoDet() throws BaseException {
   supportRefresh();
	return comproBienUsoDet;
  }
	  
  public void setComproBienUsoDet(ComproBienUsoDet comproBienUsoDet) throws BaseException {
   this.comproBienUsoDet = comproBienUsoDet;
  }  
  
  public Integer getMesesAmortizados() throws BaseException {
	supportRefresh();
	return mesesAmort;
  }
  
  public void setMesesAmortizados(Integer aMesesAmortizados) throws BaseException {
	this.mesesAmort = aMesesAmortizados;
  }
  
  public Money getTasaAmortizacion() throws BaseException {
    supportRefresh();
	return tasaAmort;
  }
	  
  public void setTasaAmortizacion(Money aTasaAmortizacion) throws BaseException {
    this.tasaAmort = aTasaAmortizacion;
  }  
  
  public Money getImporte() throws BaseException {
	supportRefresh();
	return importe;
  }
		  
  public void setImporte(Money aImporte) throws BaseException {
	this.importe = aImporte;
  }   

  public SubBien getSub_bien() throws BaseException { 
    supportRefresh();
    return sub_bien;
  }

  public void setSub_bien(SubBien aSub_bien) { 
    this.sub_bien =  aSub_bien;
  }

  public java.util.Date getFec_imputac() throws BaseException { 
    supportRefresh();
    return fec_imputac;
  }

  public void setFec_imputac(java.util.Date aFec_imputac) { 
    this.fec_imputac =  aFec_imputac;
  }

  public String getTipo_mov() throws BaseException { 
    supportRefresh();
    return tipo_mov;
  }

  public void setTipo_mov(String aTipo_mov) { 
    this.tipo_mov =  aTipo_mov;
  }

  public Periodo getPeriodo() throws BaseException { 
    supportRefresh();
    return periodo;
  }

  public void setPeriodo(Periodo aPeriodo) { 
    this.periodo =  aPeriodo;
  }

  public ComproContaDet getCompro_conta_det() throws BaseException { 
    supportRefresh();
    return compro_conta_det;
  }

  public void setCompro_conta_det(ComproContaDet aCompro_conta_det) { 
    this.compro_conta_det =  aCompro_conta_det;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static MovimientoBienUso findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (MovimientoBienUso) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static MovimientoBienUso findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
   return (MovimientoBienUso) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 public static MovimientoBienUso findByCodigo(String codigo , ISesion aSesion) throws BaseException { 
   return (MovimientoBienUso) getObjectByCodigo(NICKNAME,codigo,aSesion);
  } 

 public void beforeSave() throws BaseException { 
    Validar.noNulo(sub_bien, "Debe ingresar el SubBien");
    Validar.noNulo(fec_imputac, "Debe ingresar la Fecha de Imputación");
    Validar.noNulo(tipo_mov, "Debe ingresar el Tipo de Movimiento");
    Validar.noNulo(periodo, "Debe ingresar el Período");
    Validar.noNulo(sistemaValuacion,"Debe ingresar el sistema de valuación");
    Validar.noNulo(mesesAmort,"Debe ingresar la cant. de meses amort.");
    Validar.noNulo(tasaAmort,"Debe ingresar la tasa de Amortización");
    Validar.noNulo(importe,"Debe ingresar el Importe");
    
 }
 
 public static Integer getSigno(String aTipoMov) throws BaseException {
	 if (aTipoMov.equals(TM_VO))
		 return new Integer(1);
	 else
		 if (aTipoMov.equals(TM_RVO))
			 return new Integer(1);
		 else
			 if (aTipoMov.equals(TM_AM_VO))
				 return new Integer(-1);
			 else
				 if (aTipoMov.equals(TM_RAM_VO))
					 return new Integer(-1);
				 else
					 if (aTipoMov.equals(TM_AJ_AMO_MESES_ANT))
						 return new Integer(-1);
					 else
						 if (aTipoMov.equals(TM_AJ_AMO_EJER_ANT))
							 return new Integer(-1);
						 else
							 throw new ExceptionValidation(null,"Tipo de Movimiento Inexistente");
 }
 
 public static Hashtable getTiposMovimientos() throws BaseException {
	 Hashtable lista = new Hashtable();
	 lista.put(TM_VO,"Valor Origen");
	 lista.put(TM_RVO,"Revalúo Valor Origen");
	 lista.put(TM_AM_VO,"Amortización Valor Origen");
	 lista.put(TM_RAM_VO , "Revalúo Amortización Valor Origen");
	 lista.put(TM_AJ_AMO_MESES_ANT, "Ajuste Amortización Meses Ant.");
	 lista.put(TM_AJ_AMO_EJER_ANT, "Ajuste Amortización Ejercicios Ant.");
	 lista.put(TM_BAJA_VO,"Baja Valor Origen");
	 lista.put(TM_BAJA_REV_VO , "Baja Revalúo Valor Origen");
	 lista.put(TM_BAJA_AM_VO , "Baja Amortización Valor Origen");
	 lista.put(TM_BAJA_REV_AM_VO , "Baja Revalúo Amortización");
	 lista.put(TM_BAJA_REV_AM_EA,"Baja Revalúo Amort. Ejer. Ant.");
	 return lista;
 }
 
 public static List getMovimientosSistValAnterioresAlPeriodo(SistemaValuacion sistemaValuacion,
		  Periodo periodo,
		  ISesion aSesion) throws BaseException {
	  return DBMovimientoBienUso.getMovimientosSistValAntAlPeriodo(sistemaValuacion,periodo,aSesion);
 }
 
 public static List getMovimientosSistValEntrePeriodos(SistemaValuacion sistemaValuacion,
		  Periodo periodoDesde,
		  Periodo periodoHasta,
		  ISesion aSesion) throws BaseException {
	  return DBMovimientoBienUso.getMovimientosSistValEntrePeriodos(sistemaValuacion,periodoDesde,periodoHasta,aSesion);
 }  
 
 
 

}
