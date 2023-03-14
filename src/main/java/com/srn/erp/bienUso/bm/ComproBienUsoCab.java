package com.srn.erp.bienUso.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.CalcImportesContables;
import com.srn.erp.contabilidad.bm.IContabilizable;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.bm.RenglonAsiento;
import com.srn.erp.contabilidad.bm.RenglonesAsiento;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.TipoCambio;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.Validar;

public class ComproBienUsoCab extends ComproCab implements IContabilizable {
	
  private List detalles = new ArrayList();
  private boolean readDetalles = true;
  private ComproCab comproCab = null;

  public String getCodigo() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

  public ComproBienUsoCab() { 
  }
  
  private TipoCambio getTipoCambio() throws BaseException {
	  return TipoCambio.getTipoCambioDefaultConta(getSesion());
  }

  public static String NICKNAME = "bu.ComproBienUsoCab";

  private SubBien sub_bien;
  private String tipo_mov;
  private Periodo periodo;
  private SistemaValuacion sistema_valuacion;

  public SubBien getSub_bien() throws BaseException { 
    supportRefresh();
    return sub_bien;
  }

  public void setSub_bien(SubBien aSub_bien) { 
    this.sub_bien =  aSub_bien;
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

  public SistemaValuacion getSistema_valuacion() throws BaseException { 
    supportRefresh();
    return sistema_valuacion;
  }

  public void setSistema_valuacion(SistemaValuacion aSistema_valuacion) { 
    this.sistema_valuacion =  aSistema_valuacion;
  }

  public String getNickName() { 
    return NICKNAME; 
  } 

 public static ComproBienUsoCab findByOid(Integer oid , ISesion aSesion) throws BaseException { 
   return (ComproBienUsoCab) getObjectByOid(NICKNAME,oid,aSesion);
  } 

 public static ComproBienUsoCab findByOidProxy(Integer oid , ISesion aSesion) throws BaseException { 
	   return (ComproBienUsoCab) getObjectByOidProxy(NICKNAME,oid,aSesion);
 } 
 
 public void setComprobante(ComproCab aComproCab) throws BaseException {
   this.comproCab = aComproCab;
 }

 public void beforeSave() throws BaseException { 
    Validar.noNulo(sub_bien, "Debe ingresar el SubBien");
    Validar.noNulo(tipo_mov, "Debe ingresar el Tipo de Movimiento");
    Validar.noNulo(periodo, "Debe ingresar el Período");
    Validar.noNulo(sistema_valuacion, "Debe ingresar el Sistema de Valuación");
	if (this.isNew()) {
			this.setComprobante(this);
			this.setEstado(ComproCab.ESTADO_ALTA);
			this.setActivo(new Boolean(true));
	}
	beforeSaveComprobante(this);
 }
 
 public List getDetalles() throws BaseException {
   if (readDetalles) {
	   cargarListaFromBD(detalles,ComproBienUsoDet.getDetalles(this,getSesion()));
	   readDetalles = false;
   }
   return detalles;
 }

 public void addDetComproBienUsoDet(ComproBienUsoDet comproBienUsoDet) throws BaseException {
   comproBienUsoDet.setCompro_bien_uso_cab(this);
   detalles.add(comproBienUsoDet);
 }

 public void afterSave() throws BaseException {
	Iterator iterDetalles = detalles.iterator();
	while (iterDetalles.hasNext()) {
	  ComproBienUsoDet comproBienUsoDet = (ComproBienUsoDet) iterDetalles.next();
	  comproBienUsoDet.save();
	  comproBienUsoDet = null;
	}
	iterDetalles = null;
	afterSaveComprobante(this);
 }
 
 public ComproCab getComprobante() throws BaseException {
   return comproCab; 
 }
 
  public RenglonesAsiento getRenglonesAsiento() throws BaseException {
	  
	  if (!getSistema_valuacion().isContable().booleanValue()) {
		  setContabiliza(false);
		  return null;
	  }
	  
	  if (getTipo_mov().equals(MovimientoBienUso.TM_VO))
		  return contabilizarAltaValorOrigen();
	  else
	  if (getTipo_mov().equals(MovimientoBienUso.TM_AM_VO))
		  return contabilizarAmortizacionValorOrigen();
	  else
		  return null;
  }
  
  private RenglonesAsiento contabilizarAmortizacionValorOrigen() throws BaseException {
	  
	  
	  RenglonesAsiento renglones = new RenglonesAsiento();
	  
	  Iterator iterDetalles = getDetalles().iterator();
	  while (iterDetalles.hasNext()) {
		ComproBienUsoDet comproBienUsoDet = (ComproBienUsoDet) iterDetalles.next();
		
		// Distribuir la amortizacion entre los sectores correspondientes
		List listValoresDist = 
			  getSub_bien().getBien_uso().getValoresDistAImputacion(getImputac(),new Money(comproBienUsoDet.getImporte().doubleValue()));
		
		Iterator iterValoresDist = listValoresDist.iterator();
		while (iterValoresDist.hasNext()) {
			  CuentaDistribucionAmortizacion ctaDistAmort = 
				  (CuentaDistribucionAmortizacion) iterValoresDist.next();
			  
			  // Calcular el Importe contable
			  CalcImportesContables impoContable = new CalcImportesContables(getSesion(),getImputacion());
			  
			  impoContable.setTipoCambio(getTipoCambio());
			  impoContable.addCotizaciones(getCotizaciones());
			  ImportesContables importeContable = impoContable.getImportesContables(ctaDistAmort.getImporte(),getSistema_valuacion().getMoneda());
			  
			  // Debitar las amortizaciones
			  RenglonAsiento renglonAmortVO = renglones.addRenglonAsiento();
			  renglonAmortVO.setCuentaImputable(ctaDistAmort.getCuentaImputable());
			  renglonAmortVO.setD_H(RenglonAsiento.DEBE);
			  renglonAmortVO.setMonedaOri(getSistema_valuacion().getMoneda());
			  renglonAmortVO.setImporteOri(ctaDistAmort.getImporte());
			  renglonAmortVO.setComentario("Amort. VO ");
			  renglonAmortVO.setImpoLocHist(importeContable.getImpoMonLoc());
			  renglonAmortVO.setImpoLocAju(importeContable.getImpoMonLocAju());
			  renglonAmortVO.setImpoMonExt1(importeContable.getImpoMonExt1());
			  renglonAmortVO.setImpoMonExt2(importeContable.getImpoMonExt2());
			  renglonAmortVO.setCotizOri(impoContable.getValorCotizMonedaOri());
			  renglonAmortVO.setCotizMonExt1(importeContable.getValorCotizMonExt1());
			  renglonAmortVO.setCotizMonExt2(importeContable.getValorCotizMonExt2());
			  
			  // Acreditar las amortizaciones acumuladas
			  RenglonAsiento renglonAmortAcumVO = renglones.addRenglonAsiento();
			  
			  renglonAmortAcumVO.setCuentaImputable(getSub_bien().getBien_uso().getAi_aa());
			  renglonAmortAcumVO.setD_H(RenglonAsiento.HABER);
			  renglonAmortAcumVO.setMonedaOri(getSistema_valuacion().getMoneda());
			  renglonAmortAcumVO.setImporteOri(ctaDistAmort.getImporte());
			  renglonAmortAcumVO.setComentario("Amort. Acum. VO ");
			  renglonAmortAcumVO.setImpoLocHist(importeContable.getImpoMonLoc());
			  renglonAmortAcumVO.setImpoLocAju(importeContable.getImpoMonLocAju());
			  renglonAmortAcumVO.setImpoMonExt1(importeContable.getImpoMonExt1());
			  renglonAmortAcumVO.setImpoMonExt2(importeContable.getImpoMonExt2());
			  renglonAmortAcumVO.setCotizOri(impoContable.getValorCotizMonedaOri());
			  renglonAmortAcumVO.setCotizMonExt1(importeContable.getValorCotizMonExt1());
			  renglonAmortAcumVO.setCotizMonExt2(importeContable.getValorCotizMonExt2());			  
			  
		}
		
		
	  }
	  
	  
	  return renglones;
  }  
  
  
  private RenglonesAsiento contabilizarAltaValorOrigen() throws BaseException {
	  RenglonesAsiento renglones = new RenglonesAsiento();
	  
	  Iterator iterDetalles = getDetalles().iterator();
	  while (iterDetalles.hasNext()) {
		  ComproBienUsoDet comproBienUsoDet = (ComproBienUsoDet) iterDetalles.next();
		  
		  //Debita el Alta del Valor Origen
		  RenglonAsiento renglonVO = renglones.addRenglonAsiento();
		  renglonVO.setCuentaImputable(getSub_bien().getBien_uso().getAi_vo());
		  renglonVO.setD_H(RenglonAsiento.DEBE);
		  		  
		  renglonVO.setMonedaOri(comproBienUsoDet.getCompro_conta_det().getMoneda());
		  renglonVO.setImporteOri(comproBienUsoDet.getCompro_conta_det().getImporteOriginal());
		  renglonVO.setComentario("Alta Sub-Bien:"+getSub_bien().getDescripcion());
		  renglonVO.setImpoLocHist(comproBienUsoDet.getCompro_conta_det().getImpoLocHist());
		  renglonVO.setImpoLocAju(comproBienUsoDet.getCompro_conta_det().getImpoLocAju());
		  renglonVO.setImpoMonExt1(comproBienUsoDet.getCompro_conta_det().getImpoMonExt1());
		  renglonVO.setImpoMonExt2(comproBienUsoDet.getCompro_conta_det().getImpoMonExt2());
		  renglonVO.setCotizOri(comproBienUsoDet.getCompro_conta_det().getCotizMonOri());
		  renglonVO.setCotizMonExt1(comproBienUsoDet.getCompro_conta_det().getCotizMonExt1());
		  renglonVO.setCotizMonExt2(comproBienUsoDet.getCompro_conta_det().getCotizMonExt2());	      

		  //Acreditar la cuenta Original 
		  RenglonAsiento renglonCtaOri = renglones.addRenglonAsiento();
		  renglonCtaOri.setCuentaImputable(comproBienUsoDet.getCompro_conta_det().getCuentaImputable());
		  renglonCtaOri.setD_H(RenglonAsiento.HABER);
		  		  
		  renglonCtaOri.setMonedaOri(comproBienUsoDet.getCompro_conta_det().getMoneda());
		  renglonCtaOri.setImporteOri(comproBienUsoDet.getCompro_conta_det().getImporteOriginal());
		  renglonCtaOri.setComentario("");
		  renglonCtaOri.setImpoLocHist(comproBienUsoDet.getCompro_conta_det().getImpoLocHist());
		  renglonCtaOri.setImpoLocAju(comproBienUsoDet.getCompro_conta_det().getImpoLocAju());
		  renglonCtaOri.setImpoMonExt1(comproBienUsoDet.getCompro_conta_det().getImpoMonExt1());
		  renglonCtaOri.setImpoMonExt2(comproBienUsoDet.getCompro_conta_det().getImpoMonExt2());
		  renglonCtaOri.setCotizOri(comproBienUsoDet.getCompro_conta_det().getCotizMonOri());
		  renglonCtaOri.setCotizMonExt1(comproBienUsoDet.getCompro_conta_det().getCotizMonExt1());
		  renglonCtaOri.setCotizMonExt2(comproBienUsoDet.getCompro_conta_det().getCotizMonExt2());	      
	      
	  }
	  
	  
	  return renglones;
  }
  
  public Date getImputacion() throws BaseException {
	return super.getImputac();  
  }
 
  public static Talonario getTalonarioRevaluoValorOrigen(ISesion aSesion) throws BaseException {
      ValorParametro valorParametro = ValorParametro.findByCodigoParametro("TALONARIO_REVALUO_VO_BIEN_USO",aSesion);
      Talonario talonario = Talonario.findByOid(valorParametro.getOidObjNeg(),aSesion);
      return talonario;
  }
  
  public static Talonario getTalonarioAmortizacionValorOrigen(ISesion aSesion) throws BaseException {
      ValorParametro valorParametro = ValorParametro.findByCodigoParametro("TALONARIO_AMORT_VO_BIEN_USO",aSesion);
      Talonario talonario = Talonario.findByOid(valorParametro.getOidObjNeg(),aSesion);
      return talonario;
  }  

  public static Talonario getTalonarioRevAmortValorOrigen(ISesion aSesion) throws BaseException {
      ValorParametro valorParametro = ValorParametro.findByCodigoParametro("TALONARIO_REV_AMORT_VO_BU",aSesion);
      Talonario talonario = Talonario.findByOid(valorParametro.getOidObjNeg(),aSesion);
      return talonario;
  }  
  public static Talonario getTalonarioAjuAmortMesesAnt(ISesion aSesion) throws BaseException {
      ValorParametro valorParametro = ValorParametro.findByCodigoParametro("TALONARIO_AJU_AMORT_MESES_ANT",aSesion);
      Talonario talonario = Talonario.findByOid(valorParametro.getOidObjNeg(),aSesion);
      return talonario;
  }
  
  public static Talonario getTalonarioAjuAmortEjerAnt(ISesion aSesion) throws BaseException {
      ValorParametro valorParametro = ValorParametro.findByCodigoParametro("TALONARIO_AJU_AMORT_EJER_ANT",aSesion);
      Talonario talonario = Talonario.findByOid(valorParametro.getOidObjNeg(),aSesion);
      return talonario;
  }  
  
  public Money getTotalImportes() throws BaseException {
	  CalculadorMoney calcTotAmort = new CalculadorMoney(new Money(0));
	  Iterator iterDetalles = getDetalles().iterator();
	  while (iterDetalles.hasNext()) {
		  ComproBienUsoDet comproBienUsoDet = (ComproBienUsoDet) iterDetalles.next();
		  calcTotAmort.sumar(new Money(comproBienUsoDet.getImporte().doubleValue()));
	  }
	  return calcTotAmort.getResultMoney();
  }
  
}
