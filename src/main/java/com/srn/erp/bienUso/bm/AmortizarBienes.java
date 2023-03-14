package com.srn.erp.bienUso.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.Talonario;

import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class AmortizarBienes implements IAmortizarBienes  { 

  private Periodo periodo;
  private java.util.Date fecImputac;
  private ISesion sesion;
  private List listaComprobantes = new ArrayList();
  private HashTableDatos listaCotizaciones = null;
	
  public void amortizar() throws BaseException {
		// TODO Auto-generated method stub
	  Iterator iterSubBienes = SubBien.getSubBienes(getSesion()).iterator();
	  while (iterSubBienes.hasNext()) {
		  SubBien subBien = (SubBien) iterSubBienes.next();
		  if (!subBien.isActivo().booleanValue()) continue;
		  if (!subBien.getBien_uso().isActivo().booleanValue()) continue;
		  if (subBien.getBien_uso().isAmortizable().booleanValue())
			  amortizarBien(subBien,getListaCotizaciones());
	  }
	  Iterator iterComprobantes = getComprobantes().iterator();
	  while (iterComprobantes.hasNext()) {
			ComproBienUsoCab comproBienUsoCab = (ComproBienUsoCab) iterComprobantes.next();
			comproBienUsoCab.save();
	  }
  }
  
  public HashTableDatos getListaCotizaciones() throws BaseException {
	  return this.listaCotizaciones;
  }
  
  public void setListaCotizaciones(HashTableDatos aListaCotiz) throws BaseException {
	  this.listaCotizaciones = aListaCotiz;
  }
  
  public List getComprobantes() throws BaseException {
	return listaComprobantes;
  }

  public void setFecImputac(Date aFecImputac) {
		this.fecImputac = aFecImputac;
  }

  public void setPeriodo(Periodo aPeriodo) {
		this.periodo = aPeriodo;
  }

  public void setSesion(ISesion aSesion) {
		sesion = aSesion;		
  }
  
  public java.util.Date getFecImputacion() {
	  return this.fecImputac;
  }
  
  public Periodo getPeriodo() {
	  return this.periodo;
  }
  
  public ISesion getSesion() {
	  return this.sesion;
  }

  public AmortizarBienes() throws BaseException {
	 
  }
  
  private void amortizarBien(SubBien subBien , HashTableDatos listaCotizaciones) throws BaseException {
	  // Amortizar el Bien para todos los Sistemas de Valuacion
	  Iterator iterSistemasValuacion = SistemaValuacion.getSistemasDeValuacionActivos(getSesion()).iterator();
	  while (iterSistemasValuacion.hasNext()) {
		  SistemaValuacion sistemaValuacion = (SistemaValuacion) iterSistemasValuacion.next();
		  if (!sistemaValuacion.isAmortizaPeriodo(getPeriodo())) continue;
		  if (!subBien.isAmortizable(sistemaValuacion,getPeriodo())) continue;	
		  CalculoMovimientoAmortizacion calcMovAmort = new CalculoMovimientoAmortizacion();
		  calcMovAmort.setASesion(getSesion());
		  calcMovAmort.setSistemaValuacion(sistemaValuacion);
		  calcMovAmort.setSubBien(subBien);
		  calcMovAmort.setPeriodo(getPeriodo());
		  Map movimientos = calcMovAmort.getMovimientos();
		  generarComprobantesBienUso(subBien,sistemaValuacion,movimientos,listaCotizaciones);
	  }
  }
  
 private void generarComprobantesBienUso(SubBien subBien,
		 								 SistemaValuacion sistemaValuacion,
		                                 Map movimientos,
		                                 HashTableDatos aListaCotizaciones) throws BaseException {  
   
   Iterator iterMov = movimientos.keySet().iterator();
   while (iterMov.hasNext()) {
	   String tipoMovimiento = (String) iterMov.next();
	   Money valor = (Money) movimientos.get(tipoMovimiento);
	   ComproBienUsoCab comproBienUsoCab = 
		   generarComprobanteBU(subBien,sistemaValuacion,tipoMovimiento,valor,aListaCotizaciones);
	   listaComprobantes.add(comproBienUsoCab);
   }
 }
 
 private Talonario getTalonario(String tipoMovimiento) throws BaseException {
   Talonario talonario = null;
	if (tipoMovimiento.equals(MovimientoBienUso.TM_RVO))
		talonario = ComproBienUsoCab.getTalonarioRevaluoValorOrigen(getSesion());
	else
	if (tipoMovimiento.equals(MovimientoBienUso.TM_AM_VO))
		talonario = ComproBienUsoCab.getTalonarioAmortizacionValorOrigen(getSesion());
	else
	if (tipoMovimiento.equals(MovimientoBienUso.TM_RAM_VO))
		talonario = ComproBienUsoCab.getTalonarioRevAmortValorOrigen(getSesion());	  
	else
	if (tipoMovimiento.equals(MovimientoBienUso.TM_AJ_AMO_MESES_ANT))
		talonario = ComproBienUsoCab.getTalonarioAjuAmortMesesAnt(getSesion());
	else
	if (tipoMovimiento.equals(MovimientoBienUso.TM_AJ_AMO_EJER_ANT))
		talonario = ComproBienUsoCab.getTalonarioAjuAmortEjerAnt(getSesion());
	return talonario; 
 }
 
 private ComproBienUsoCab generarComprobanteBU(SubBien subBien,
		 						   SistemaValuacion sistemaValuacion,
		 						   String tipoMovimiento,
		 						   Money valor,
		 						   HashTableDatos aListaCotizaciones
		 						   ) throws BaseException {
   
  ComproBienUsoCab comproBienUsoCab = (ComproBienUsoCab)ComproBienUsoCab.getNew(ComproBienUsoCab.NICKNAME,getSesion());
  
	  
  Talonario talonario = getTalonario(tipoMovimiento);
  // Set datos del comrobante
  comproBienUsoCab.setContabiliza(true);
  comproBienUsoCab.setTalonario(talonario);
  comproBienUsoCab.setTipoCompro(talonario.getTipo_comprobante());
  comproBienUsoCab.setLetra(talonario.getLetra());
  comproBienUsoCab.setLugarEmision(talonario.getLugar_emision());
  comproBienUsoCab.setEmision(fecImputac);
  comproBienUsoCab.setComentario("");
  comproBienUsoCab.setSub_bien(subBien);
  comproBienUsoCab.setTipo_mov(tipoMovimiento);
  comproBienUsoCab.setPeriodo(periodo);
  comproBienUsoCab.setSistema_valuacion(sistemaValuacion);
  comproBienUsoCab.setImputac(fecImputac);
  comproBienUsoCab.addCotizacionesMonedas(aListaCotizaciones);
  
  ComproBienUsoDet compoBienUsoDet = (ComproBienUsoDet)ComproBienUsoDet.getNew(ComproBienUsoDet.NICKNAME,getSesion());
  compoBienUsoDet.setCompro_bien_uso_cab(comproBienUsoCab);
  compoBienUsoDet.setCompro_conta_det(null);
  compoBienUsoDet.setPorc(new Double(0));
  compoBienUsoDet.setMeses_amort(new Integer(0));
  compoBienUsoDet.setTasa_amort(new Double(0));
  compoBienUsoDet.setImporte(new Double(valor.doubleValue()));
  //if (MovimientoBienUso.TM_AM_VO.equals(tipoMovimiento)) {
  //	  compoBienUsoDet.setPorc();
  //}
  comproBienUsoCab.addDetComproBienUsoDet(compoBienUsoDet);
  
  
  
  
  return comproBienUsoCab;
  
 }
 
}
