package com.srn.erp.contabilidad.bm;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBComproCierreEjercicio;
import com.srn.erp.contabilidad.da.DBComproContaDet;
import com.srn.erp.contabilidad.da.DBEjercicio;
import com.srn.erp.contabilidad.da.DBEjercicioPeri;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.Validar;

public class Ejercicio extends ObjetoLogico {

  public Ejercicio() {
  }
  
  public static final String LD_DIA_COMPRO = "DIA_COMPRO";
  public static final String LD_DIA_TC = "DIA_TC";
  public static final String LD_MES_TC = "MES_TC";
  

  public static String NICKNAME = "cg.Ejercicio";

  private Integer nroEjer;
  private Date fechaDesde;
  private Date fechaHasta;
  private Boolean activo;
  private String libroDiarioPorComprobante;
  private java.util.Date fechaGenLibDiario;
  private String ultPresentacionLibroDiario;

  private List periodosEjercicio = new ArrayList();
  private boolean readPeriodosEjercicio = true;


  public Integer getNroejer() throws BaseException {
    supportRefresh();
    return nroEjer;
  }

  public void setNroejer(Integer aNroejer) {
    this.nroEjer =  aNroejer;
  }
  
  public String getUltimaPresentacionLibroDiario() throws BaseException {
	supportRefresh();
	return this.ultPresentacionLibroDiario;
  }

  public void setUltimaPresentacionLibroDiario(String aUltimaPresentacionLibroDiario) {
	this.ultPresentacionLibroDiario =  aUltimaPresentacionLibroDiario;
  }
  
  
  public java.util.Date getFechaGenLibDiario() throws BaseException {
	supportRefresh();
	return this.fechaGenLibDiario;
  }

  public void setFechaGenLibDiario(java.util.Date aFechaGenLibDia) {
	this.fechaGenLibDiario =  aFechaGenLibDia;
  }
  
    public String getLibroDiarioPorComprobante() throws BaseException {
	supportRefresh();
	return this.libroDiarioPorComprobante;
  }

  public void setLibroDiarioPorComprobante(String aLibroDiarioPorComprobante) {
	this.libroDiarioPorComprobante =  aLibroDiarioPorComprobante;
  }
  
  public Date getFechadesde() throws BaseException {
    supportRefresh();
    return fechaDesde;
  }

  public void setFechadesde(Date aFechadesde) {
    this.fechaDesde =  aFechadesde;
  }

  public Date getFechahasta() throws BaseException {
    supportRefresh();
    return fechaHasta;
  }

  public void setFechahasta(Date aFechahasta) {
    this.fechaHasta =  aFechahasta;
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

 public static Ejercicio findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Ejercicio) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static Ejercicio findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Ejercicio) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static Ejercicio findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Ejercicio) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(nroEjer, "Debe ingresar un Nro. de Ejercicio");
    Validar.noNulo(fechaDesde, "Debe ingresar la Fecha Desde");
    Validar.noNulo(fechaHasta, "Debe ingresar la Fecha Hasta");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("El Ejercicio debe estar em modo activo");

 }

  /**
   * getDescripcion
   *
   * @return String
   */
  public String getDescripcion() throws BaseException {
    return "Del "+Fecha.getddmmyyyy(this.getFechadesde())+" al "+Fecha.getddmmyyyy(this.getFechahasta());
  }

  /**
   * getCodigo
   *
   * @return String
   */
  public String getCodigo() {
    return "";
  }

  public List getPeriodosEjercicio() throws BaseException {
    if (readPeriodosEjercicio) {
      List periodosDelEjercicio = DBEjercicioPeri.getPeriodosEjercicios(this,
          getSesion());
      periodosEjercicio.addAll(periodosDelEjercicio);
      readPeriodosEjercicio = false;
    }
    return periodosEjercicio;
  }

  public void addEjercicioPeri(EjercicioPeri ejercicioPeri) throws BaseException {
    ejercicioPeri.setEjercicio(this);
    periodosEjercicio.add(ejercicioPeri);
  }

  public void afterSave() throws BaseException {
    Iterator iterPeriodosEjercicio = periodosEjercicio.iterator();
    while (iterPeriodosEjercicio.hasNext()) {
      EjercicioPeri ejercicioPeri = (EjercicioPeri) iterPeriodosEjercicio.next();
      ejercicioPeri.save();
      ejercicioPeri = null;
    }
    iterPeriodosEjercicio = null;
  }

  public static Ejercicio getEjercicioByFecha(java.util.Date fecha,
                                       ISesion aSesion) throws BaseException {
     return DBEjercicio.getEjercicioByFecha(fecha,aSesion);
  }
  
  public static Ejercicio getEjercicio(Periodo periodo,ISesion aSesion) throws BaseException {
	  Ejercicio ejercicio = Ejercicio.getEjercicioByFecha(periodo.getFechadesde(),aSesion);
	  return ejercicio;
  }
  
  public Periodo getUltimoPeriodo() throws BaseException {
	  Periodo ultimoPeriodo = null;
	  Iterator iterPeriEjer = getPeriodosEjercicio().iterator();
	  while (iterPeriEjer.hasNext()) {
		  EjercicioPeri ejercicioPeri = (EjercicioPeri) iterPeriEjer.next();
		  if (ultimoPeriodo == null) ultimoPeriodo = ejercicioPeri.getPeriodo(); 
		  if (ejercicioPeri.getPeriodo().getFechadesde().getTime()>ultimoPeriodo.getFechadesde().getTime()) {
			  ultimoPeriodo = ejercicioPeri.getPeriodo(); 
		  }
	  }	  
	  return ultimoPeriodo;
  }

  public Periodo getPrimerPeriodo() throws BaseException {
	  Periodo primerPeriodo = null;
	  Iterator iterPeriEjer = getPeriodosEjercicio().iterator();
	  while (iterPeriEjer.hasNext()) {
		  EjercicioPeri ejercicioPeri = (EjercicioPeri) iterPeriEjer.next();
		  if (primerPeriodo == null) primerPeriodo = ejercicioPeri.getPeriodo(); 
		  if (ejercicioPeri.getPeriodo().getFechadesde().before(primerPeriodo.getFechadesde())) {
			  primerPeriodo = ejercicioPeri.getPeriodo(); 
		  }
	  }	  
	  return primerPeriodo;
  }
  
  public List getDetallesComproConta(boolean patrimoniales, boolean resultado) throws BaseException {
	  return ComproContaDet.getDetallesByEjercicio(this,patrimoniales,resultado,this.getSesion());
  }
  
  public Ejercicio getEjercicioAnterior() throws BaseException {
	  Periodo periodo = this.getPrimerPeriodo();
	  Periodo periAnt = periodo.getPeriMensualAnterior();
	  if (periAnt == null) throw new ExceptionValidation(null,"No se pudo encontrar el período anterior del "+periodo.getCodigo());
	  Ejercicio ejerAnt = Ejercicio.getEjercicioByFecha(periAnt.getFechadesde(), this.getSesion());
	  return ejerAnt;
  }
  
  public ComproCierreEjercicio getComproCierrePatrimonial() throws BaseException {
		return ComproCierreEjercicio.getComproCierrePatrimonial(this,this.getSesion());
  }
  
  public static HashTableDatos getLibroDiarioTipoCompro() throws BaseException {
	  HashTableDatos datos = new HashTableDatos();
	  datos.put(LD_DIA_COMPRO,"Día por Comprobante");
	  datos.put(LD_DIA_TC,"Día por Tipo de Comprobante");
	  datos.put(LD_MES_TC,"Mes por Tipo de Comprobante");
	  return datos;
  }
  
  public List getImpuEjercicioOrderFecOIDCCO() throws BaseException {
	    return ComproContaDet.getImpuEjercicioOrderFecOIDCCO(this,this.getSesion());
  }   
  
  public boolean isTieneEjercicioComproAperturaActivo() throws BaseException {
	return ComproAperturaEjercicio.isTieneEjercicioComproAperturaActivo(this,this.getSesion());
  }
  
  
  
  



}
