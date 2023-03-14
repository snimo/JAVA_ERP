package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Iterator;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.contabilidad.bm.Subdiario;
import com.srn.erp.contabilidad.bm.SubdiarioDet;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class DBConsultasContables extends DBObjetoPersistente {

  public static final int SELECT_BY_MOVIMIENTOS_CUENTA = 100;
  public static final int SELECT_BY_SALDO_INI_DESDE_INI_EJER_A_FIN_PERI = 101;
  public static final int SELECT_BY_SALDO_INI_DESDE_INICIO_PERI_A_FECHA_DIA_ANT = 102;
  public static final int SELECT_BY_SALDO_INI_DESDE_INI_CONTA_A_FIN_PERI = 103;
  public static final int SELECT_BY_SALDO_FIN_DESDE_INI_EJER_A_FIN_PERI = 104;
  public static final int SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING = 105;
  public static final int SELECT_BY_SALDO_FIN_DESDE_INI_CONTA_A_FIN_PERI = 106;
  public static final int SELECT_BY_MOVIMIENTOS_CUENTA_POR_TC = 107;
  public static final int SELECT_BY_SALDO_INI_DESDE_INI_EJER_A_FIN_PERI_ALL_RESULT = 108;
  public static final int SELECT_BY_SALDO_INI_DESDE_INICIO_PERI_A_FECHA_DIA_ANT_ALL = 109;
  public static final int SELECT_BY_SALDO_INI_DESDE_INI_CONTA_A_FIN_PERI_ALL_PATRI = 110;
  public static final int SELECT_BY_SALDO_FIN_DESDE_INI_EJER_A_FIN_PERI_ALL_RESULT = 111;
  public static final int SELECT_BY_SALDO_FIN_DESDE_INI_CONTA_A_FIN_PERI_ALL_PATRI = 112;
  public static final int SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL = 113;
  public static final int SELECT_BY_MOV_FEC_DESDE_HASTA_ALL_DEBITOS = 114;
  public static final int SELECT_BY_MOV_FEC_DESDE_HASTA_ALL_CREDITOS = 115;
  public static final int SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL_RESULT = 116;
  public static final int SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL_PATRI = 117;
  public static final int SELECT_BY_MOVIMIENTOS_CUENTA_AGRUP_COMPRO = 118;
  public static final int SELECT_BY_MOVIMIENTOS_CUENTA_AGRUP_TC = 119;
  public static final int SELECT_BY_TOT_CTA_PERI = 120;
  public static final int SELECT_BY_SALDO_ANA_IMP = 121;
  public static final int SELECT_BY_MOVIMIENTOS_CUENTA_AGRUP_COMPRO_SIN_SIGNO = 122;
  public static final int SELECT_BY_MOVIMIENTOS_CUENTA_AGRUP_TC_SIN_SIGNO = 123;
  public static final int SELECT_BY_SALDO_INI_PATRI_SIN_ASI_CIERRE_APER  = 124;
  public static final int SELECT_BY_SALDO_FIN_DESDE_INI_EJER_A_FIN_PERI_ALL_RESULT_SIN_ASI_CIE = 125;
  public static final int SELECT_BY_SALDO_FIN_DESDE_INI_CONTA_A_FIN_PERI_ALL_PATRI_SIN_ASI_CIE = 126;
  public static final int SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL_RESULT_SIN_CIE = 127;
  public static final int SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL_PATRI_SIN_CIE = 128;
  public static final int SELECT_BY_MOV_FEC_DESDE_HASTA_ALL_DEBITOS_SIN_ASI_CIE = 129;
  public static final int SELECT_BY_MOV_FEC_DESDE_HASTA_ALL_CREDITOS_SIN_ASI_CIE = 130;

  public DBConsultasContables() {
  }

  public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException,SQLException {
    PreparedStatement ps = null;
    switch (aSelect) {
      case SELECT_BY_MOVIMIENTOS_CUENTA: {
          ps = this.selectByMovimientosCuenta(aCondiciones);
          break;
      }
      case SELECT_BY_MOVIMIENTOS_CUENTA_AGRUP_COMPRO: {
          ps = this.selectByMovimientosCuentaAgrupCompro(aCondiciones);
          break;
      }
      case SELECT_BY_MOVIMIENTOS_CUENTA_AGRUP_COMPRO_SIN_SIGNO: {
          ps = this.selectByMovimientosCuentaAgrupComproSinSigno(aCondiciones);
          break;
      }
      case SELECT_BY_MOVIMIENTOS_CUENTA_AGRUP_TC: {
          ps = this.selectByMovimientosCuentaAgrupTC(aCondiciones);
          break;
      }
      case SELECT_BY_MOVIMIENTOS_CUENTA_AGRUP_TC_SIN_SIGNO: {
          ps = this.selectByMovimientosCuentaAgrupTCSinSigno(aCondiciones);
          break;
      }      
      
      case SELECT_BY_SALDO_INI_DESDE_INI_EJER_A_FIN_PERI: {
        ps = this.selectBySaldoInicioDesdeIniEjerAFinPeri(aCondiciones);
          break;
      }
      case SELECT_BY_SALDO_INI_DESDE_INICIO_PERI_A_FECHA_DIA_ANT: {
        ps = this.selectBySaldoIniDesdeInicioPeriAFechaDiaAnt(aCondiciones);
          break;
      }
      case SELECT_BY_SALDO_INI_DESDE_INI_CONTA_A_FIN_PERI: {
        ps = this.selectBySaldoInicioDesdeIniContaAFinPeriAntAFecIng(aCondiciones);
          break;
      }
      case SELECT_BY_SALDO_FIN_DESDE_INI_EJER_A_FIN_PERI: {
        ps = this.selectBySaldoFinalDesdeIniEjerAFinPeri(aCondiciones);
        break;
      }
      case SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING: {
        ps = this.selectBySaldoFinalDesdeInicioPeriAFechaIng(aCondiciones);
        break;
      }
      case SELECT_BY_SALDO_FIN_DESDE_INI_CONTA_A_FIN_PERI: {
        ps = this.selectBySaldoFinalDesdeIniContaAFinPeriAntAFecIng(aCondiciones);
          break;
      }
      case SELECT_BY_MOVIMIENTOS_CUENTA_POR_TC: {
        ps = this.selectByMovimientosCuentaPorTC(aCondiciones);
          break;
      }
      case SELECT_BY_SALDO_INI_DESDE_INI_EJER_A_FIN_PERI_ALL_RESULT: {
        ps = this.selectBySaldoInicioDesdeIniEjerAFinPeriAntaFecIngCtasResul(aCondiciones);
        break;
      }
      case SELECT_BY_SALDO_INI_DESDE_INICIO_PERI_A_FECHA_DIA_ANT_ALL: {
        ps = this.selectBySaldoIniDesdeInicioPeriAFechaDiaAntAll(aCondiciones);
        break;
      }
      case SELECT_BY_SALDO_INI_DESDE_INI_CONTA_A_FIN_PERI_ALL_PATRI: {
        ps = this.selectBySaldoInicioDesdeIniContaAFinPeriAntAFecIngAllPatri(aCondiciones);
        break;
      }
      case SELECT_BY_SALDO_FIN_DESDE_INI_EJER_A_FIN_PERI_ALL_RESULT: {
        ps = this.selectBySaldoFinalDesdeIniEjerAFinPeriAllResult(aCondiciones);
        break;
      }
      case SELECT_BY_SALDO_FIN_DESDE_INI_CONTA_A_FIN_PERI_ALL_PATRI: {
        ps = this.selectBySaldoFinalDesdeIniContaAFinPeriAntAFecIngAllPatri(aCondiciones);
        break;
      }
      case SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL: {
        ps = this.selectBySaldoFinalDesdeInicioPeriAFechaIngAll(aCondiciones);
        break;
      }
      case SELECT_BY_MOV_FEC_DESDE_HASTA_ALL_DEBITOS: {
        ps = this.selectByMovFecDesdeHastaAllDebitos(aCondiciones);
        break;
      }
      case SELECT_BY_MOV_FEC_DESDE_HASTA_ALL_CREDITOS: {
        ps = this.selectByMovFecDesdeHastaAllCreditos(aCondiciones);
        break;
      }
      case SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL_RESULT: {
        ps = this.selectBySaldoFinalDesdeInicioPeriAFechaIngAllResult(aCondiciones);
        break;
      }
      case SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL_PATRI: {
        ps = this.selectBySaldoFinalDesdeInicioPeriAFechaIngAllPatri(aCondiciones);
        break;
      }
      case SELECT_BY_TOT_CTA_PERI: {
          ps = this.selectByTotCtaPeriodo(aCondiciones);
          break;
      }
      case SELECT_BY_SALDO_ANA_IMP: {
          ps = this.selectBySaldoAnaImp(aCondiciones);
          break;    	  
      }
      case SELECT_BY_SALDO_INI_PATRI_SIN_ASI_CIERRE_APER: {
          ps = this.selectBySaldoIniPatriSinAsiCierreAper(aCondiciones);
          break;    	  
      }
      case SELECT_BY_SALDO_FIN_DESDE_INI_EJER_A_FIN_PERI_ALL_RESULT_SIN_ASI_CIE: {
    	  ps = selectBySaldoFinalDesdeIniEjerAFinPeriAllResultSinAsiCieAper(aCondiciones);
    	  break;
      }
      case SELECT_BY_SALDO_FIN_DESDE_INI_CONTA_A_FIN_PERI_ALL_PATRI_SIN_ASI_CIE: {
    	  ps = selectBySaldoFinalDesdeIniContaAFinPeriAntAFecIngAllPatriSinAsiCierre(aCondiciones);
    	  break;
      }
      case SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL_RESULT_SIN_CIE: {
    	  ps = selectBySaldoFinalDesdeInicioPeriAFechaIngAllResultSinAsiCierre(aCondiciones);
    	  break;
      }
      case SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING_ALL_PATRI_SIN_CIE: {
    	  ps = selectBySaldoFinalDesdeInicioPeriAFechaIngAllPatriSinAsiCierre(aCondiciones);
    	  break;
      }
      case SELECT_BY_MOV_FEC_DESDE_HASTA_ALL_DEBITOS_SIN_ASI_CIE: {
    	  ps = selectByMovFecDesdeHastaAllDebitosSinAsiCierre(aCondiciones);
    	  break;
      }
      case SELECT_BY_MOV_FEC_DESDE_HASTA_ALL_CREDITOS_SIN_ASI_CIE: {
    	  ps = selectByMovFecDesdeHastaAllCreditosSinAsiCierre(aCondiciones);
    	  break;
      }

    }
    return ps;
  }

  private PreparedStatement selectBySaldoIniDesdeInicioPeriAFechaDiaAnt(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    Cuenta cuenta            = (Cuenta) condiciones.get("oid_ana_con");
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");
    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

    Periodo periodo = Periodo.getPeriodoByFechaDelEjercicio(fecha,getSesion());
    if (periodo == null)
      throw new ExceptionValidation(null,"No se encuentra un período habilitado para la fecha "+Fecha.getddmmyyyy(fecha));
    java.util.Date fechaInicioPeri  = periodo.getFechadesde();

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorDia a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.imputac>=? ");
    textSQLSaldoPeriodos.append("   and a.imputac<? ");
    textSQLSaldoPeriodos.append("   and b.oid_ana_con=? ");
    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
    while (iterComponentes.hasNext()) {
      Componente componente = (Componente) iterComponentes.next();
      textSQLSaldoPeriodos.append(" and "+
      "b."+componente.getCampoFisicoAnaImp()+
          "="+
          ((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
    }

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fechaInicioPeri.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
    querySelect.setInt(3,cuenta.getOID());

    return querySelect;
  }
  
  
  
  private PreparedStatement selectBySaldoIniPatriSinAsiCierreAper(Object aCondiciones)
  	throws BaseException, SQLException {

	  MapDatos condiciones          = (MapDatos) aCondiciones;
	  java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");

	  StringBuffer textSQLSaldoPeriodos = new StringBuffer();
	  
	  textSQLSaldoPeriodos.append(" select ");
	  textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
	  textSQLSaldoPeriodos.append(" 	c.oid_ana_con, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_his*b.signo) impo_loc_his, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_aju*b.signo) impo_loc_aju, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_1*b.signo) impo_mon_ext_1, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_2*b.signo) impo_mon_ext_2 "); 
	  textSQLSaldoPeriodos.append(" from ");
	  textSQLSaldoPeriodos.append(" 	cgComproConta a, ");
	  textSQLSaldoPeriodos.append(" 	cgComproContaDet b, ");
	  textSQLSaldoPeriodos.append(" 	cgAnaImpCon c , ");
	  textSQLSaldoPeriodos.append(" 	cgAnaCon d ");
	  textSQLSaldoPeriodos.append(" where ");
	  textSQLSaldoPeriodos.append(" 	a.imputac < ? ");
	  textSQLSaldoPeriodos.append(" 	and a.oid_cco = b.oid_cco and ");
	  textSQLSaldoPeriodos.append(" 	b.oid_ai = c.oid_ai and ");
	  textSQLSaldoPeriodos.append(" 	c.oid_ana_con = d.oid_ana_con and ");
	  textSQLSaldoPeriodos.append(" 	d.es_patrimonial = 1 and ");
	  textSQLSaldoPeriodos.append(" 	a.oid_cco not in (select oid_cierre_ejercicio from cgCierreEjercicio) ");
	  textSQLSaldoPeriodos.append(" group by ");
	  textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
	  textSQLSaldoPeriodos.append(" 	c.oid_ana_con ");	  
	  

	  PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
	  querySelect.setDate(1,new java.sql.Date(fecha.getTime()));

	  return querySelect;

  }  

  private PreparedStatement selectByMovFecDesdeHastaAllDebitos(Object aCondiciones)
      throws BaseException, SQLException {

    MapDatos condiciones          = (MapDatos) aCondiciones;
    java.util.Date fechaDesde     = (java.util.Date) condiciones.get("fechaDesde");
    java.util.Date fechaHasta     = (java.util.Date) condiciones.get("fechaHasta");

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   b.oid_ai,");
    textSQLSaldoPeriodos.append("   b.oid_ana_con,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorDia a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.imputac>=? ");
    textSQLSaldoPeriodos.append("   and a.imputac<=? and a.signo = 1");
    textSQLSaldoPeriodos.append(" group by ");
    textSQLSaldoPeriodos.append("   b.oid_ai,");
    textSQLSaldoPeriodos.append("   b.oid_ana_con ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fechaDesde.getTime()));
    querySelect.setDate(2,new java.sql.Date(fechaHasta.getTime()));

    return querySelect;

  }

  private PreparedStatement selectByMovFecDesdeHastaAllCreditos(Object aCondiciones)
      throws BaseException, SQLException {

    MapDatos condiciones          = (MapDatos) aCondiciones;
    java.util.Date fechaDesde     = (java.util.Date) condiciones.get("fechaDesde");
    java.util.Date fechaHasta     = (java.util.Date) condiciones.get("fechaHasta");

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   b.oid_ai,");
    textSQLSaldoPeriodos.append("   b.oid_ana_con,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorDia a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.imputac>=? ");
    textSQLSaldoPeriodos.append("   and a.imputac<=? and a.signo = -1");
    textSQLSaldoPeriodos.append(" group by ");
    textSQLSaldoPeriodos.append("   b.oid_ai,");
    textSQLSaldoPeriodos.append("   b.oid_ana_con ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fechaDesde.getTime()));
    querySelect.setDate(2,new java.sql.Date(fechaHasta.getTime()));

    return querySelect;

  }


  private PreparedStatement selectBySaldoIniDesdeInicioPeriAFechaDiaAntAll(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");

    Periodo periodo = Periodo.getPeriodoByFechaDelEjercicio(fecha,getSesion());
    if (periodo == null)
      throw new ExceptionValidation(null,"No se encuentra un período habilitado para la fecha "+Fecha.getddmmyyyy(fecha));
    java.util.Date fechaInicioPeri  = periodo.getFechadesde();

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   b.oid_ai,");
    textSQLSaldoPeriodos.append("   b.oid_ana_con,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorDia a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.imputac>=? ");
    textSQLSaldoPeriodos.append("   and a.imputac<? ");
    textSQLSaldoPeriodos.append(" group by ");
    textSQLSaldoPeriodos.append("   b.oid_ai,");
    textSQLSaldoPeriodos.append("   b.oid_ana_con ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fechaInicioPeri.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));

    return querySelect;
  }

  private PreparedStatement selectBySaldoAnaImp(Object aCondiciones) throws BaseException, SQLException {

	    MapDatos condiciones     = (MapDatos) aCondiciones;
	    CuentaImputable cuentaImputable            = (CuentaImputable) condiciones.get("oid_ana_imp_con");
	    
	    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
	    textSQLSaldoPeriodos.append(" select ");
	    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
	    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
	    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
	    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
	    textSQLSaldoPeriodos.append(" from ");
	    textSQLSaldoPeriodos.append("   cgMayorDia a ");
	    textSQLSaldoPeriodos.append(" where ");
	    textSQLSaldoPeriodos.append("   a.oid_ai = ? ");
	    	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
	    querySelect.setInt(1,cuentaImputable.getOID());
	    return querySelect;
	  }
  
  
  private PreparedStatement selectBySaldoFinalDesdeInicioPeriAFechaIng(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    Cuenta cuenta            = (Cuenta) condiciones.get("oid_ana_con");
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");
    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

    Periodo periodo = Periodo.getPeriodoByFechaDelEjercicio(fecha,getSesion());
    if (periodo == null)
      throw new ExceptionValidation(null,"No se encuentra un período habilitado para la fecha "+Fecha.getddmmyyyy(fecha));
    java.util.Date fechaInicioPeri  = periodo.getFechadesde();

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorDia a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.imputac>=? ");
    textSQLSaldoPeriodos.append("   and a.imputac<=? ");
    textSQLSaldoPeriodos.append("   and b.oid_ana_con=? ");
    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
    while (iterComponentes.hasNext()) {
      Componente componente = (Componente) iterComponentes.next();
      textSQLSaldoPeriodos.append(" and "+
      "b."+componente.getCampoFisicoAnaImp()+
          "="+
          ((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
    }

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fechaInicioPeri.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
    querySelect.setInt(3,cuenta.getOID());

    return querySelect;
  }

  private PreparedStatement selectBySaldoFinalDesdeInicioPeriAFechaIngAll(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");

    Periodo periodo = Periodo.getPeriodoByFechaDelEjercicio(fecha,getSesion());
    if (periodo == null)
      throw new ExceptionValidation(null,"No se encuentra un período habilitado para la fecha "+Fecha.getddmmyyyy(fecha));
    java.util.Date fechaInicioPeri  = periodo.getFechadesde();

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   a.oid_ai, ");
    textSQLSaldoPeriodos.append("   b.oid_ana_con,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorDia a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.imputac>=? ");
    textSQLSaldoPeriodos.append("   and a.imputac<=? ");
    textSQLSaldoPeriodos.append(" group by ");
    textSQLSaldoPeriodos.append("   a.oid_ai, ");
    textSQLSaldoPeriodos.append("   b.oid_ana_con ");


    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fechaInicioPeri.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));

    return querySelect;
  }

  private PreparedStatement selectBySaldoFinalDesdeInicioPeriAFechaIngAllResult(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");

    Periodo periodo = Periodo.getPeriodoByFechaDelEjercicio(fecha,getSesion());
    if (periodo == null)
      throw new ExceptionValidation(null,"No se encuentra un período habilitado para la fecha "+Fecha.getddmmyyyy(fecha));
    java.util.Date fechaInicioPeri  = periodo.getFechadesde();

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   a.oid_ai, ");
    textSQLSaldoPeriodos.append("   b.oid_ana_con,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorDia a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b, ");
    textSQLSaldoPeriodos.append("   cgAnaCon c ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.imputac>=? ");
    textSQLSaldoPeriodos.append("   and a.imputac<=? ");
    textSQLSaldoPeriodos.append("   and b.oid_ana_con = c.oid_ana_con and c.es_patrimonial = 0 ");
    textSQLSaldoPeriodos.append(" group by ");
    textSQLSaldoPeriodos.append("   a.oid_ai, ");
    textSQLSaldoPeriodos.append("   b.oid_ana_con ");


    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fechaInicioPeri.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));

    return querySelect;
  }

  private PreparedStatement selectBySaldoFinalDesdeInicioPeriAFechaIngAllPatri(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");

    Periodo periodo = Periodo.getPeriodoByFechaDelEjercicio(fecha,getSesion());
    if (periodo == null)
      throw new ExceptionValidation(null,"No se encuentra un período habilitado para la fecha "+Fecha.getddmmyyyy(fecha));
    java.util.Date fechaInicioPeri  = periodo.getFechadesde();

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   a.oid_ai, ");
    textSQLSaldoPeriodos.append("   b.oid_ana_con,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorDia a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b, ");
    textSQLSaldoPeriodos.append("   cgAnaCon c ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.imputac>=? ");
    textSQLSaldoPeriodos.append("   and a.imputac<=? ");
    textSQLSaldoPeriodos.append("   and b.oid_ana_con = c.oid_ana_con and c.es_patrimonial = 1 ");
    textSQLSaldoPeriodos.append(" group by ");
    textSQLSaldoPeriodos.append("   a.oid_ai, ");
    textSQLSaldoPeriodos.append("   b.oid_ana_con ");


    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fechaInicioPeri.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));

    return querySelect;
  }


  private PreparedStatement selectBySaldoInicioDesdeIniEjerAFinPeriAntaFecIngCtasResul(Object aCondiciones)
      throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");

    Ejercicio ejercicio      = Ejercicio.getEjercicioByFecha(fecha,getSesion());
    if (ejercicio == null)
      throw new ExceptionValidation(null,"No se encuentra habilitado un ejercicio para la fecha "+Fecha.getddmmyyyy(fecha));
    java.util.Date fechaInicioEjer  = ejercicio.getFechadesde();

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   a.oid_ai,");
    textSQLSaldoPeriodos.append("   d.oid_ana_con,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorPeri a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b, ");
    textSQLSaldoPeriodos.append("   gePeriodos c, ");
    textSQLSaldoPeriodos.append("   cgAnaCon d ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.oid_peri = c.oid_peri ");
    textSQLSaldoPeriodos.append("   and c.fecha_desde>=? ");
    textSQLSaldoPeriodos.append("   and c.fecha_hasta<=? ");
    textSQLSaldoPeriodos.append("   and d.oid_ana_con = b.oid_ana_con and d.es_patrimonial = 0");
    textSQLSaldoPeriodos.append(" group by ");
    textSQLSaldoPeriodos.append("   a.oid_ai,");
    textSQLSaldoPeriodos.append("   d.oid_ana_con ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fechaInicioEjer.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));

    return querySelect;

  }

  private PreparedStatement selectBySaldoInicioDesdeIniEjerAFinPeri(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    Cuenta cuenta            = (Cuenta) condiciones.get("oid_ana_con");
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");
    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

    Ejercicio ejercicio             = Ejercicio.getEjercicioByFecha(fecha,getSesion());
    if (ejercicio == null)
      throw new ExceptionValidation(null,"No se encuentra habilitado un ejercicio para la fecha "+Fecha.getddmmyyyy(fecha));
    java.util.Date fechaInicioEjer  = ejercicio.getFechadesde();

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorPeri a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b, ");
    textSQLSaldoPeriodos.append("   gePeriodos c ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.oid_peri = c.oid_peri ");
    textSQLSaldoPeriodos.append("   and c.fecha_desde>=? ");
    textSQLSaldoPeriodos.append("   and c.fecha_hasta<? ");
    textSQLSaldoPeriodos.append("   and b.oid_ana_con=? ");
    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
    while (iterComponentes.hasNext()) {
      Componente componente = (Componente) iterComponentes.next();
      textSQLSaldoPeriodos.append(" and "+
      "b."+componente.getCampoFisicoAnaImp()+
          "="+
          ((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
    }

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fechaInicioEjer.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
    querySelect.setInt(3,cuenta.getOID());

    return querySelect;
  }

  private PreparedStatement selectBySaldoFinalDesdeIniEjerAFinPeri(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    Cuenta cuenta            = (Cuenta) condiciones.get("oid_ana_con");
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");
    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

    Ejercicio ejercicio             = Ejercicio.getEjercicioByFecha(fecha,getSesion());
    if (ejercicio == null)
      throw new ExceptionValidation(null,"No se encuentra habilitado un ejercicio para la fecha "+Fecha.getddmmyyyy(fecha));
    java.util.Date fechaInicioEjer  = ejercicio.getFechadesde();

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorPeri a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b, ");
    textSQLSaldoPeriodos.append("   gePeriodos c ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.oid_peri = c.oid_peri ");
    textSQLSaldoPeriodos.append("   and c.fecha_desde>=? ");
    textSQLSaldoPeriodos.append("   and c.fecha_hasta<? ");
    textSQLSaldoPeriodos.append("   and b.oid_ana_con=? ");
    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
    while (iterComponentes.hasNext()) {
      Componente componente = (Componente) iterComponentes.next();
      textSQLSaldoPeriodos.append(" and "+
      "b."+componente.getCampoFisicoAnaImp()+
          "="+
          ((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
    }

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fechaInicioEjer.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
    querySelect.setInt(3,cuenta.getOID());

    return querySelect;
  }

  private PreparedStatement selectBySaldoFinalDesdeIniEjerAFinPeriAllResult(Object aCondiciones)
      throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");

    Ejercicio ejercicio             = Ejercicio.getEjercicioByFecha(fecha,getSesion());
    if (ejercicio == null)
      throw new ExceptionValidation(null,"No se encuentra habilitado un ejercicio para la fecha "+Fecha.getddmmyyyy(fecha));
    java.util.Date fechaInicioEjer  = ejercicio.getFechadesde();

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   a.oid_ai,");
    textSQLSaldoPeriodos.append("   b.oid_ana_con,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorPeri a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b, ");
    textSQLSaldoPeriodos.append("   gePeriodos c, ");
    textSQLSaldoPeriodos.append("   cgAnaCon d ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.oid_peri = c.oid_peri ");
    textSQLSaldoPeriodos.append("   and c.fecha_desde>=? ");
    textSQLSaldoPeriodos.append("   and c.fecha_hasta<=? ");
    textSQLSaldoPeriodos.append("   and d.oid_ana_con = b.oid_ana_con ");
    textSQLSaldoPeriodos.append("   and d.es_patrimonial = 0 ");
    textSQLSaldoPeriodos.append(" group by ");
    textSQLSaldoPeriodos.append("   a.oid_ai,");
    textSQLSaldoPeriodos.append("   b.oid_ana_con ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fechaInicioEjer.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));

    return querySelect;
  }



  private PreparedStatement selectBySaldoInicioDesdeIniContaAFinPeriAntAFecIng(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    Cuenta cuenta            = (Cuenta) condiciones.get("oid_ana_con");
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");
    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorPeri a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b, ");
    textSQLSaldoPeriodos.append("   gePeriodos c ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.oid_peri = c.oid_peri ");
    textSQLSaldoPeriodos.append("   and c.fecha_hasta<? ");
    textSQLSaldoPeriodos.append("   and b.oid_ana_con=? ");
    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
    while (iterComponentes.hasNext()) {
      Componente componente = (Componente) iterComponentes.next();
      textSQLSaldoPeriodos.append(" and "+
      "b."+componente.getCampoFisicoAnaImp()+
          "="+
          ((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
    }

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fecha.getTime()));
    querySelect.setInt(2,cuenta.getOID());

    return querySelect;
  }

  private PreparedStatement selectBySaldoInicioDesdeIniContaAFinPeriAntAFecIngAllPatri(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   a.oid_ai,");
    textSQLSaldoPeriodos.append("   d.oid_ana_con,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorPeri a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b, ");
    textSQLSaldoPeriodos.append("   gePeriodos c, ");
    textSQLSaldoPeriodos.append("   cgAnaCon d ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.oid_peri = c.oid_peri ");
    textSQLSaldoPeriodos.append("   and c.fecha_hasta<=? ");
    textSQLSaldoPeriodos.append("   and b.oid_ana_con = d.oid_ana_con and d.es_patrimonial=1 ");
    textSQLSaldoPeriodos.append(" group by ");
    textSQLSaldoPeriodos.append("   a.oid_ai,");
    textSQLSaldoPeriodos.append("   d.oid_ana_con ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fecha.getTime()));

    return querySelect;
  }


  private PreparedStatement selectBySaldoFinalDesdeIniContaAFinPeriAntAFecIng(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    Cuenta cuenta            = (Cuenta) condiciones.get("oid_ana_con");
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");
    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorPeri a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b, ");
    textSQLSaldoPeriodos.append("   gePeriodos c ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.oid_peri = c.oid_peri ");
    textSQLSaldoPeriodos.append("   and c.fecha_hasta<? ");
    textSQLSaldoPeriodos.append("   and b.oid_ana_con=? ");
    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
    while (iterComponentes.hasNext()) {
      Componente componente = (Componente) iterComponentes.next();
      textSQLSaldoPeriodos.append(" and "+
      "b."+componente.getCampoFisicoAnaImp()+
          "="+
          ((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
    }

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fecha.getTime()));
    querySelect.setInt(2,cuenta.getOID());

    return querySelect;
  }


  private PreparedStatement selectBySaldoFinalDesdeIniContaAFinPeriAntAFecIngAllPatri(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones     = (MapDatos) aCondiciones;
    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");

    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
    textSQLSaldoPeriodos.append(" select ");
    textSQLSaldoPeriodos.append("   a.oid_ai,");
    textSQLSaldoPeriodos.append("   d.oid_ana_con,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
    textSQLSaldoPeriodos.append(" from ");
    textSQLSaldoPeriodos.append("   cgMayorPeri a,");
    textSQLSaldoPeriodos.append("   cgAnaImpCon b, ");
    textSQLSaldoPeriodos.append("   gePeriodos c,");
    textSQLSaldoPeriodos.append("   cgAnaCon d ");
    textSQLSaldoPeriodos.append(" where ");
    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
    textSQLSaldoPeriodos.append("   and a.oid_peri = c.oid_peri ");
    textSQLSaldoPeriodos.append("   and c.fecha_hasta<=? ");
    textSQLSaldoPeriodos.append("   and b.oid_ana_con = d.oid_ana_con ");
    textSQLSaldoPeriodos.append("   and d.es_patrimonial = 1 ");
    textSQLSaldoPeriodos.append(" group by ");
    textSQLSaldoPeriodos.append("   a.oid_ai,");
    textSQLSaldoPeriodos.append("   d.oid_ana_con ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
    querySelect.setDate(1,new java.sql.Date(fecha.getTime()));

    return querySelect;
  }
  
  private PreparedStatement selectByTotCtaPeriodo(Object aCondiciones) throws BaseException, SQLException {
	    MapDatos condiciones = (MapDatos) aCondiciones;
	    Cuenta cuenta = (Cuenta) condiciones.get(Cuenta.NICKNAME);
	    Periodo periodo = (Periodo) condiciones.get(Periodo.NICKNAME);
	    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

	    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
	    textSQLSaldoPeriodos.append(" select ");
	    textSQLSaldoPeriodos.append("   sum(a.impo_loc_his*signo) impo_loc_his,");
	    textSQLSaldoPeriodos.append("   sum(a.impo_loc_aju*signo) impo_loc_aju,");
	    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_1*signo) impo_mon_ext_1,");
	    textSQLSaldoPeriodos.append("   sum(a.impo_mon_ext_2*signo) impo_mon_ext_2 ");
	    textSQLSaldoPeriodos.append(" from ");
	    textSQLSaldoPeriodos.append("   cgMayorPeri a,");
	    textSQLSaldoPeriodos.append("   cgAnaImpCon b, ");
	    textSQLSaldoPeriodos.append("   gePeriodos c ");
	    textSQLSaldoPeriodos.append(" where ");
	    textSQLSaldoPeriodos.append("   a.oid_ai = b.oid_ai ");
	    textSQLSaldoPeriodos.append("   and a.oid_peri = c.oid_peri ");
	    textSQLSaldoPeriodos.append("   and a.oid_peri = ? ");
	    textSQLSaldoPeriodos.append("   and b.oid_ana_con=? ");
	    if (valoresDeCompo!=null) {
	    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
	    	while (iterComponentes.hasNext()) {
	    		Componente componente = (Componente) iterComponentes.next();
	    		textSQLSaldoPeriodos.append(" and "+
	    				"b."+componente.getCampoFisicoAnaImp()+
	    				"="+
	    				((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
	    	}
	    }

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
	    querySelect.setInt(1,periodo.getOID());
	    querySelect.setInt(2,cuenta.getOID());

	    return querySelect;
	  }

  


  private PreparedStatement selectByMovimientosCuentaAgrupCompro(Object aCondiciones) throws BaseException, SQLException {

	    MapDatos condiciones = (MapDatos) aCondiciones;
	    
	    Cuenta cuenta = null;
	    if (condiciones.containsKey("oid_ana_con"))
	    	cuenta = (Cuenta) condiciones.get("oid_ana_con");
	    
	    Subdiario subdiario = null;
	    if (condiciones.containsKey("oid_subdiario"))
	    	subdiario = (Subdiario) condiciones.get("oid_subdiario");
	    
	    java.util.Date fecImputacDesde = (java.util.Date) condiciones.get("fecImputacDesde");
	    java.util.Date fecImputacHasta = (java.util.Date) condiciones.get("fecImputacHasta");
	    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append(" select ");
	    textSQL.append("   a.oid_cco,a.tc_ext,a.letra,a.lug_emi,a.nro_ext,c.comentario,b.imputac,c.signo,");
	    textSQL.append("   sum(c.signo*c.impo_loc_his) impo_loc_his,sum(c.signo*c.impo_loc_aju) impo_loc_aju,sum(c.signo*c.impo_mon_ext_1) impo_mon_ext_1,sum(c.signo*c.impo_mon_ext_2) impo_mon_ext_2, sum(0) oid_dco  ");
	    textSQL.append(" from  ");
	    textSQL.append("   geComproCab a,cgComproConta b , cgComproContaDet c , cgAnaImpCon d ");
	    textSQL.append(" where ");
	    textSQL.append("   a.oid_cco = b.oid_cco ");
	    textSQL.append("   and b.oid_cco = c.oid_cco ");
	    textSQL.append("   and c.oid_ai = d.oid_ai ");

	    if (cuenta!=null)
	    	textSQL.append("   and d.oid_ana_con = "+cuenta.getOIDInteger());
	    
	    if (subdiario!=null) {
	    	StringBuffer condINCuentas = new StringBuffer("");
	    	Iterator iterSubdiariosDet = 
	    		subdiario.getSubdiariosDet().iterator();
	    	while (iterSubdiariosDet.hasNext()) {
	    		SubdiarioDet subdiarioDet = (SubdiarioDet) iterSubdiariosDet.next();
	    		if (!subdiarioDet.isActivo()) continue;
	    		if (condINCuentas.toString().trim().length()==0) {
	    			condINCuentas.append(" in ("+subdiarioDet.getCuenta().getOIDInteger());
	    		} else {
	    			condINCuentas.append(","+subdiarioDet.getCuenta().getOIDInteger());
	    		}
	    	}
	    	condINCuentas.append(") ");
	    	
	    	textSQL.append("   and d.oid_ana_con  "+condINCuentas.toString());
	    }
	    
	    textSQL.append("   and b.imputac>=? and b.imputac<=? ");

	    // Agregar al Filtro los Valores de Componentes
	    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
	    while (iterComponentes.hasNext()) {
	      Componente componente = (Componente) iterComponentes.next();
	      textSQL.append("   and "+
	      "d."+componente.getCampoFisicoAnaImp()+
	          "="+
	          ((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
	    }

	    textSQL.append("   group by ");
	    textSQL.append("   a.oid_cco,a.tc_ext,a.letra,a.lug_emi,a.nro_ext,c.comentario,b.imputac,c.signo ");
	    
	    textSQL.append("   order by b.imputac,a.oid_cco ");

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setDate(1,new java.sql.Date(fecImputacDesde.getTime()));
	    querySelect.setDate(2,new java.sql.Date(fecImputacHasta.getTime()));
	    return querySelect;
	  }
  
  
  private PreparedStatement selectByMovimientosCuentaAgrupComproSinSigno(Object aCondiciones) throws BaseException, SQLException {

	    MapDatos condiciones = (MapDatos) aCondiciones;
	    
	    Cuenta cuenta = null;
	    if (condiciones.containsKey("oid_ana_con"))
	    	cuenta = (Cuenta) condiciones.get("oid_ana_con");
	    
	    Subdiario subdiario = null;
	    if (condiciones.containsKey("oid_subdiario"))
	    	subdiario = (Subdiario) condiciones.get("oid_subdiario");
	    
	    java.util.Date fecImputacDesde = (java.util.Date) condiciones.get("fecImputacDesde");
	    java.util.Date fecImputacHasta = (java.util.Date) condiciones.get("fecImputacHasta");
	    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append(" select ");
	    textSQL.append("   a.oid_cco,a.tc_ext,a.letra,a.lug_emi,a.nro_ext,c.comentario,b.imputac, 0 signo,");
	    textSQL.append("   sum(c.signo*c.impo_loc_his) impo_loc_his,sum(c.signo*c.impo_loc_aju) impo_loc_aju,sum(c.signo*c.impo_mon_ext_1) impo_mon_ext_1,sum(c.signo*c.impo_mon_ext_2) impo_mon_ext_2, sum(0) oid_dco  ");
	    textSQL.append(" from  ");
	    textSQL.append("   geComproCab a,cgComproConta b , cgComproContaDet c , cgAnaImpCon d ");
	    textSQL.append(" where ");
	    textSQL.append("   a.oid_cco = b.oid_cco ");
	    textSQL.append("   and b.oid_cco = c.oid_cco ");
	    textSQL.append("   and c.oid_ai = d.oid_ai ");

	    if (cuenta!=null)
	    	textSQL.append("   and d.oid_ana_con = "+cuenta.getOIDInteger());
	    
	    if (subdiario!=null) {
	    	StringBuffer condINCuentas = new StringBuffer("");
	    	Iterator iterSubdiariosDet = 
	    		subdiario.getSubdiariosDet().iterator();
	    	while (iterSubdiariosDet.hasNext()) {
	    		SubdiarioDet subdiarioDet = (SubdiarioDet) iterSubdiariosDet.next();
	    		if (!subdiarioDet.isActivo()) continue;
	    		if (condINCuentas.toString().trim().length()==0) {
	    			condINCuentas.append(" in ("+subdiarioDet.getCuenta().getOIDInteger());
	    		} else {
	    			condINCuentas.append(","+subdiarioDet.getCuenta().getOIDInteger());
	    		}
	    	}
	    	condINCuentas.append(") ");
	    	
	    	textSQL.append("   and d.oid_ana_con  "+condINCuentas.toString());
	    }
	    
	    textSQL.append("   and b.imputac>=? and b.imputac<=? ");

	    // Agregar al Filtro los Valores de Componentes
	    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
	    while (iterComponentes.hasNext()) {
	      Componente componente = (Componente) iterComponentes.next();
	      textSQL.append("   and "+
	      "d."+componente.getCampoFisicoAnaImp()+
	          "="+
	          ((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
	    }

	    textSQL.append("   group by ");
	    textSQL.append("   a.oid_cco,a.tc_ext,a.letra,a.lug_emi,a.nro_ext,c.comentario,b.imputac ");
	    
	    textSQL.append("   order by b.imputac,a.tc_ext,a.letra,a.lug_emi,a.nro_ext ");

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setDate(1,new java.sql.Date(fecImputacDesde.getTime()));
	    querySelect.setDate(2,new java.sql.Date(fecImputacHasta.getTime()));
	    return querySelect;
	  }
  
  
  private PreparedStatement selectByMovimientosCuentaAgrupTC(Object aCondiciones) throws BaseException, SQLException {

	    MapDatos condiciones = (MapDatos) aCondiciones;
	    Cuenta cuenta = null;
	    if (condiciones.containsKey("oid_ana_con"))
	    	cuenta = (Cuenta) condiciones.get("oid_ana_con");
	    
	    Subdiario subdiario = null;
	    if (condiciones.containsKey("oid_subdiario"))
	    	subdiario = (Subdiario) condiciones.get("oid_subdiario");
	    
	    java.util.Date fecImputacDesde = (java.util.Date) condiciones.get("fecImputacDesde");
	    java.util.Date fecImputacHasta = (java.util.Date) condiciones.get("fecImputacHasta");
	    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append(" select ");
	    textSQL.append("   b.imputac,");
	    textSQL.append("   e.descripcion,");
	    textSQL.append("   c.signo,");
	    textSQL.append("   sum(c.signo*c.impo_loc_his) impo_loc_his,sum(c.signo*c.impo_loc_aju) impo_loc_aju,sum(c.signo*c.impo_mon_ext_1) impo_mon_ext_1,sum(c.signo*c.impo_mon_ext_2) impo_mon_ext_2, sum(0) oid_dco  ");
	    textSQL.append(" from  ");
	    textSQL.append("   geComproCab a,cgComproConta b , cgComproContaDet c , cgAnaImpCon d , geTipoCompro e");
	    textSQL.append(" where ");
	    textSQL.append("   a.oid_cco = b.oid_cco ");
	    textSQL.append("   and b.oid_cco = c.oid_cco ");
	    textSQL.append("   and c.oid_ai = d.oid_ai ");
	    textSQL.append("   and e.oid_tc = a.oid_tc ");
	    
	    if (cuenta!=null)
	    	textSQL.append("   and d.oid_ana_con = "+cuenta.getOIDInteger());

	    if (subdiario!=null) {
	    	StringBuffer condINCuentas = new StringBuffer("");
	    	Iterator iterSubdiariosDet = 
	    		subdiario.getSubdiariosDet().iterator();
	    	while (iterSubdiariosDet.hasNext()) {
	    		SubdiarioDet subdiarioDet = (SubdiarioDet) iterSubdiariosDet.next();
	    		if (!subdiarioDet.isActivo()) continue;
	    		if (condINCuentas.toString().trim().length()==0) {
	    			condINCuentas.append(" in ("+subdiarioDet.getCuenta().getOIDInteger());
	    		} else {
	    			condINCuentas.append(","+subdiarioDet.getCuenta().getOIDInteger());
	    		}
	    	}
	    	condINCuentas.append(") ");
	    	
	    	textSQL.append("   and d.oid_ana_con  "+condINCuentas.toString());
	    }
	    
	    textSQL.append("   and b.imputac>=? and b.imputac<=? ");

	    // Agregar al Filtro los Valores de Componentes
	    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
	    while (iterComponentes.hasNext()) {
	      Componente componente = (Componente) iterComponentes.next();
	      textSQL.append("   and "+
	      "d."+componente.getCampoFisicoAnaImp()+
	          "="+
	          ((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
	    }

	    textSQL.append("   group by ");
	    textSQL.append("   b.imputac,e.descripcion,c.signo ");
	    
	    textSQL.append("   order by b.imputac,e.descripcion ");

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setDate(1,new java.sql.Date(fecImputacDesde.getTime()));
	    querySelect.setDate(2,new java.sql.Date(fecImputacHasta.getTime()));
	    return querySelect;
	    
  }
  
  private PreparedStatement selectByMovimientosCuentaAgrupTCSinSigno(Object aCondiciones) throws BaseException, SQLException {

	    MapDatos condiciones = (MapDatos) aCondiciones;
	    Cuenta cuenta = null;
	    if (condiciones.containsKey("oid_ana_con"))
	    	cuenta = (Cuenta) condiciones.get("oid_ana_con");
	    
	    Subdiario subdiario = null;
	    if (condiciones.containsKey("oid_subdiario"))
	    	subdiario = (Subdiario) condiciones.get("oid_subdiario");
	    
	    java.util.Date fecImputacDesde = (java.util.Date) condiciones.get("fecImputacDesde");
	    java.util.Date fecImputacHasta = (java.util.Date) condiciones.get("fecImputacHasta");
	    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append(" select ");
	    textSQL.append("   b.imputac,");
	    textSQL.append("   e.descripcion,");
	    textSQL.append("   0 signo,");
	    textSQL.append("   sum(c.signo*c.impo_loc_his) impo_loc_his,sum(c.signo*c.impo_loc_aju) impo_loc_aju,sum(c.signo*c.impo_mon_ext_1) impo_mon_ext_1,sum(c.signo*c.impo_mon_ext_2) impo_mon_ext_2, sum(0) oid_dco  ");
	    textSQL.append(" from  ");
	    textSQL.append("   geComproCab a,cgComproConta b , cgComproContaDet c , cgAnaImpCon d , geTipoCompro e");
	    textSQL.append(" where ");
	    textSQL.append("   a.oid_cco = b.oid_cco ");
	    textSQL.append("   and b.oid_cco = c.oid_cco ");
	    textSQL.append("   and c.oid_ai = d.oid_ai ");
	    textSQL.append("   and e.oid_tc = a.oid_tc ");
	    
	    if (cuenta!=null)
	    	textSQL.append("   and d.oid_ana_con = "+cuenta.getOIDInteger());

	    if (subdiario!=null) {
	    	StringBuffer condINCuentas = new StringBuffer("");
	    	Iterator iterSubdiariosDet = 
	    		subdiario.getSubdiariosDet().iterator();
	    	while (iterSubdiariosDet.hasNext()) {
	    		SubdiarioDet subdiarioDet = (SubdiarioDet) iterSubdiariosDet.next();
	    		if (!subdiarioDet.isActivo()) continue;
	    		if (condINCuentas.toString().trim().length()==0) {
	    			condINCuentas.append(" in ("+subdiarioDet.getCuenta().getOIDInteger());
	    		} else {
	    			condINCuentas.append(","+subdiarioDet.getCuenta().getOIDInteger());
	    		}
	    	}
	    	condINCuentas.append(") ");
	    	
	    	textSQL.append("   and d.oid_ana_con  "+condINCuentas.toString());
	    }
	    
	    textSQL.append("   and b.imputac>=? and b.imputac<=? ");

	    // Agregar al Filtro los Valores de Componentes
	    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
	    while (iterComponentes.hasNext()) {
	      Componente componente = (Componente) iterComponentes.next();
	      textSQL.append("   and "+
	      "d."+componente.getCampoFisicoAnaImp()+
	          "="+
	          ((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
	    }

	    textSQL.append("   group by ");
	    textSQL.append("   b.imputac,e.descripcion ");
	    
	    textSQL.append("   order by b.imputac,e.descripcion ");

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setDate(1,new java.sql.Date(fecImputacDesde.getTime()));
	    querySelect.setDate(2,new java.sql.Date(fecImputacHasta.getTime()));
	    return querySelect;
	    
}
  

  

  private PreparedStatement selectByMovimientosCuenta(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones = (MapDatos) aCondiciones;
    Cuenta cuenta = (Cuenta) condiciones.get("oid_ana_con");
    java.util.Date fecImputacDesde = (java.util.Date) condiciones.get("fecImputacDesde");
    java.util.Date fecImputacHasta = (java.util.Date) condiciones.get("fecImputacHasta");
    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

    StringBuffer textSQL = new StringBuffer();
    textSQL.append(" select ");
    textSQL.append("   c.oid_dco,a.oid_cco,a.tc_ext,a.letra,a.lug_emi,a.nro_ext,c.comentario,b.imputac,");
    textSQL.append("   c.signo,c.impo_loc_his,c.impo_loc_aju,c.impo_mon_ext_1,c.impo_mon_ext_2 , e.descripcion desc_tc ");

    // Agregar los Campos del Componente
    Iterator iterCompo = cuenta.getComponentesConAux().iterator();
    while (iterCompo.hasNext()) {
      Componente componente = (Componente) iterCompo.next();
      textSQL.append(",d."+componente.getCampoFisicoAnaImp());
    }

    textSQL.append(" from  ");
    textSQL.append("   geComproCab a,cgComproConta b , cgComproContaDet c , cgAnaImpCon d , geTipoCompro e ");
    textSQL.append(" where ");
    textSQL.append("   a.oid_cco = b.oid_cco ");
    textSQL.append("   and b.oid_cco = c.oid_cco ");
    textSQL.append("   and c.oid_ai = d.oid_ai ");
    textSQL.append("   and a.oid_tc = e.oid_tc ");
    textSQL.append("   and d.oid_ana_con = ? ");
    textSQL.append("   and b.imputac>=? and b.imputac<=? ");

    // Agregar al Filtro los Valores de Componentes
    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
    while (iterComponentes.hasNext()) {
      Componente componente = (Componente) iterComponentes.next();
      textSQL.append("   and "+
      "d."+componente.getCampoFisicoAnaImp()+
          "="+
          ((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
    }

    textSQL.append("   order by b.imputac,a.oid_cco ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,cuenta.getOID());
    querySelect.setDate(2,new java.sql.Date(fecImputacDesde.getTime()));
    querySelect.setDate(3,new java.sql.Date(fecImputacHasta.getTime()));
    return querySelect;
  }

  private PreparedStatement selectByMovimientosCuentaPorTC(Object aCondiciones) throws BaseException, SQLException {

    MapDatos condiciones = (MapDatos) aCondiciones;
    Cuenta cuenta = (Cuenta) condiciones.get("oid_ana_con");
    java.util.Date fecImputacDesde = (java.util.Date) condiciones.get("fecImputacDesde");
    java.util.Date fecImputacHasta = (java.util.Date) condiciones.get("fecImputacHasta");
    Hashtable valoresDeCompo = (Hashtable) condiciones.get("valoresComponentes");

    StringBuffer textSQL = new StringBuffer();
    textSQL.append(" select ");
    textSQL.append("   a.oid_diario,a.imputac,a.comentario,a.oid_tc,");
    textSQL.append("   b.signo,b.impo_loc_his,b.impo_loc_aju,b.impo_mon_ext_1,b.impo_mon_ext_2 ");

    // Agregar los Campos del Componente
    Iterator iterCompo = cuenta.getComponentesConAux().iterator();
    while (iterCompo.hasNext()) {
      Componente componente = (Componente) iterCompo.next();
      textSQL.append(",c."+componente.getCampoFisicoAnaImp());
    }

    textSQL.append(" from  ");
    textSQL.append("   cgDiario a,cgMayorDia b , cgAnaImpCon c");
    textSQL.append(" where ");
    textSQL.append("  a.oid_diario = b.oid_diario and b.oid_ai = c.oid_ai ");
    textSQL.append("   and c.oid_ana_con = ? ");
    textSQL.append("   and a.imputac>=? and a.imputac<=? ");

    // Agregar al Filtro los Valores de Componentes
    Iterator iterComponentes = valoresDeCompo.keySet().iterator();
    while (iterComponentes.hasNext()) {
      Componente componente = (Componente) iterComponentes.next();
      textSQL.append("   and "+
      "c."+componente.getCampoFisicoAnaImp()+
          "="+
          ((IObjetoLogico)valoresDeCompo.get(componente)).getOIDInteger().toString());
    }

    textSQL.append("   order by b.imputac ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,cuenta.getOID());
    querySelect.setDate(2,new java.sql.Date(fecImputacDesde.getTime()));
    querySelect.setDate(3,new java.sql.Date(fecImputacHasta.getTime()));
    return querySelect;
  }
  
  private PreparedStatement selectBySaldoFinalDesdeIniEjerAFinPeriAllResultSinAsiCieAper(Object aCondiciones)
  throws BaseException, SQLException {

	  MapDatos condiciones     = (MapDatos) aCondiciones;
	  java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");

	  Ejercicio ejercicio             = Ejercicio.getEjercicioByFecha(fecha,getSesion());
	  if (ejercicio == null)
		  throw new ExceptionValidation(null,"No se encuentra habilitado un ejercicio para la fecha "+Fecha.getddmmyyyy(fecha));
	  java.util.Date fechaInicioEjer  = ejercicio.getFechadesde();

	  StringBuffer textSQLSaldoPeriodos = new StringBuffer();
	  
	  
	  textSQLSaldoPeriodos.append(" select ");
	  textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
	  textSQLSaldoPeriodos.append(" 	c.oid_ana_con, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_his*b.signo) impo_loc_his, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_aju*b.signo) impo_loc_aju, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_1*b.signo) impo_mon_ext_1, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_2*b.signo) impo_mon_ext_2 "); 
	  textSQLSaldoPeriodos.append(" from ");
	  textSQLSaldoPeriodos.append(" 	cgComproConta a, ");
	  textSQLSaldoPeriodos.append(" 	cgComproContaDet b, ");
	  textSQLSaldoPeriodos.append(" 	cgAnaImpCon c , ");
	  textSQLSaldoPeriodos.append(" 	cgAnaCon d ");
	  textSQLSaldoPeriodos.append(" where ");
	  textSQLSaldoPeriodos.append(" 	a.imputac >= ? and a.imputac <= ? ");
	  textSQLSaldoPeriodos.append(" 	and a.oid_cco = b.oid_cco and ");
	  textSQLSaldoPeriodos.append(" 	b.oid_ai = c.oid_ai and ");
	  textSQLSaldoPeriodos.append(" 	c.oid_ana_con = d.oid_ana_con and ");
	  textSQLSaldoPeriodos.append(" 	d.es_patrimonial = 0 and ");
	  textSQLSaldoPeriodos.append(" 	a.oid_cco not in (select oid_cierre_ejercicio from cgCierreEjercicio) ");
	  textSQLSaldoPeriodos.append(" group by ");
	  textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
	  textSQLSaldoPeriodos.append(" 	c.oid_ana_con ");	  
	  

	  PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
	  querySelect.setDate(1,new java.sql.Date(fechaInicioEjer.getTime()));
	  querySelect.setDate(2,new java.sql.Date(fecha.getTime()));

	  return querySelect;
  }
  
  private PreparedStatement selectBySaldoFinalDesdeIniContaAFinPeriAntAFecIngAllPatriSinAsiCierre(Object aCondiciones) throws BaseException, SQLException {

	    MapDatos condiciones     = (MapDatos) aCondiciones;
	    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");
	    
	    Periodo periodo = Periodo.getPeriodoByFechaDelEjercicio(fecha,getSesion());
	    
	    if (periodo == null)
	    	throw new ExceptionValidation(null,"No se pudo obtener el período para la fecha "+Fecha.getddmmyyyy(fecha));
	    
	    if (fecha.before(periodo.getFechahasta()))
	    	fecha = Fecha.getFechaDiaAnterior(periodo.getFechadesde());

	      StringBuffer textSQLSaldoPeriodos = new StringBuffer();
		  textSQLSaldoPeriodos.append(" select ");
		  textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
		  textSQLSaldoPeriodos.append(" 	c.oid_ana_con, ");
		  textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_his*b.signo) impo_loc_his, ");
		  textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_aju*b.signo) impo_loc_aju, ");
		  textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_1*b.signo) impo_mon_ext_1, ");
		  textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_2*b.signo) impo_mon_ext_2 "); 
		  textSQLSaldoPeriodos.append(" from ");
		  textSQLSaldoPeriodos.append(" 	cgComproConta a, ");
		  textSQLSaldoPeriodos.append(" 	cgComproContaDet b, ");
		  textSQLSaldoPeriodos.append(" 	cgAnaImpCon c , ");
		  textSQLSaldoPeriodos.append(" 	cgAnaCon d ");
		  textSQLSaldoPeriodos.append(" where ");
		  textSQLSaldoPeriodos.append(" 	a.imputac <= ?  ");
		  textSQLSaldoPeriodos.append(" 	and a.oid_cco = b.oid_cco and ");
		  textSQLSaldoPeriodos.append(" 	b.oid_ai = c.oid_ai and ");
		  textSQLSaldoPeriodos.append(" 	c.oid_ana_con = d.oid_ana_con and ");
		  textSQLSaldoPeriodos.append(" 	d.es_patrimonial = 1 and ");
		  textSQLSaldoPeriodos.append(" 	a.oid_cco not in (select oid_cierre_ejercicio from cgCierreEjercicio) ");
		  textSQLSaldoPeriodos.append(" group by ");
		  textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
		  textSQLSaldoPeriodos.append(" 	c.oid_ana_con ");

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
	    querySelect.setDate(1,new java.sql.Date(fecha.getTime()));

	    return querySelect;
  }  
  
  
  private PreparedStatement selectBySaldoFinalDesdeInicioPeriAFechaIngAllResultSinAsiCierre(Object aCondiciones) throws BaseException, SQLException {

	    MapDatos condiciones     = (MapDatos) aCondiciones;
	    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");

	    Periodo periodo = Periodo.getPeriodoByFechaDelEjercicio(fecha,getSesion());
	    if (periodo == null)
	      throw new ExceptionValidation(null,"No se encuentra un período habilitado para la fecha "+Fecha.getddmmyyyy(fecha));
	    java.util.Date fechaInicioPeri  = periodo.getFechadesde();

	    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
	    
		textSQLSaldoPeriodos.append(" select ");
		textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
		textSQLSaldoPeriodos.append(" 	c.oid_ana_con, ");
		textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_his*b.signo) impo_loc_his, ");
		textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_aju*b.signo) impo_loc_aju, ");
		textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_1*b.signo) impo_mon_ext_1, ");
		textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_2*b.signo) impo_mon_ext_2 "); 
		textSQLSaldoPeriodos.append(" from ");
		textSQLSaldoPeriodos.append(" 	cgComproConta a, ");
		textSQLSaldoPeriodos.append(" 	cgComproContaDet b, ");
		textSQLSaldoPeriodos.append(" 	cgAnaImpCon c , ");
		textSQLSaldoPeriodos.append(" 	cgAnaCon d ");
		textSQLSaldoPeriodos.append(" where ");
		textSQLSaldoPeriodos.append(" 	a.imputac >= ? and a.imputac <= ? ");
		textSQLSaldoPeriodos.append(" 	and a.oid_cco = b.oid_cco and ");
		textSQLSaldoPeriodos.append(" 	b.oid_ai = c.oid_ai and ");
		textSQLSaldoPeriodos.append(" 	c.oid_ana_con = d.oid_ana_con and ");
		textSQLSaldoPeriodos.append(" 	d.es_patrimonial = 0 and ");
		textSQLSaldoPeriodos.append(" 	a.oid_cco not in (select oid_cierre_ejercicio from cgCierreEjercicio) ");
		textSQLSaldoPeriodos.append(" group by ");
		textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
		textSQLSaldoPeriodos.append(" 	c.oid_ana_con ");
	    

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
	    querySelect.setDate(1,new java.sql.Date(fechaInicioPeri.getTime()));
	    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));

	    return querySelect;
   }
  
  private PreparedStatement selectBySaldoFinalDesdeInicioPeriAFechaIngAllPatriSinAsiCierre(Object aCondiciones) throws BaseException, SQLException {

	    MapDatos condiciones     = (MapDatos) aCondiciones;
	    java.util.Date fecha     = (java.util.Date) condiciones.get("fecha");

	    Periodo periodo = Periodo.getPeriodoByFechaDelEjercicio(fecha,getSesion());
	    if (periodo == null)
	      throw new ExceptionValidation(null,"No se encuentra un período habilitado para la fecha "+Fecha.getddmmyyyy(fecha));
	    java.util.Date fechaInicioPeri  = periodo.getFechadesde();

	    StringBuffer textSQLSaldoPeriodos = new StringBuffer();
		textSQLSaldoPeriodos.append(" select ");
		textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
		textSQLSaldoPeriodos.append(" 	c.oid_ana_con, ");
		textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_his*b.signo) impo_loc_his, ");
		textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_aju*b.signo) impo_loc_aju, ");
		textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_1*b.signo) impo_mon_ext_1, ");
		textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_2*b.signo) impo_mon_ext_2 "); 
		textSQLSaldoPeriodos.append(" from ");
		textSQLSaldoPeriodos.append(" 	cgComproConta a, ");
		textSQLSaldoPeriodos.append(" 	cgComproContaDet b, ");
		textSQLSaldoPeriodos.append(" 	cgAnaImpCon c , ");
		textSQLSaldoPeriodos.append(" 	cgAnaCon d ");
		textSQLSaldoPeriodos.append(" where ");
		textSQLSaldoPeriodos.append(" 	a.imputac >= ? and a.imputac <= ? ");
		textSQLSaldoPeriodos.append(" 	and a.oid_cco = b.oid_cco and ");
		textSQLSaldoPeriodos.append(" 	b.oid_ai = c.oid_ai and ");
		textSQLSaldoPeriodos.append(" 	c.oid_ana_con = d.oid_ana_con and ");
		textSQLSaldoPeriodos.append(" 	d.es_patrimonial = 1 and ");
		textSQLSaldoPeriodos.append(" 	a.oid_cco not in (select oid_cierre_ejercicio from cgCierreEjercicio) ");
		textSQLSaldoPeriodos.append(" group by ");
		textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
		textSQLSaldoPeriodos.append(" 	c.oid_ana_con ");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
	    querySelect.setDate(1,new java.sql.Date(fechaInicioPeri.getTime()));
	    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));

	    return querySelect;
	  }
  
  private PreparedStatement selectByMovFecDesdeHastaAllDebitosSinAsiCierre(Object aCondiciones)
  throws BaseException, SQLException {

	  MapDatos condiciones          = (MapDatos) aCondiciones;
	  java.util.Date fechaDesde     = (java.util.Date) condiciones.get("fechaDesde");
	  java.util.Date fechaHasta     = (java.util.Date) condiciones.get("fechaHasta");

	  StringBuffer textSQLSaldoPeriodos = new StringBuffer();
	  textSQLSaldoPeriodos.append(" select ");
	  textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
	  textSQLSaldoPeriodos.append(" 	c.oid_ana_con, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_his*b.signo) impo_loc_his, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_aju*b.signo) impo_loc_aju, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_1*b.signo) impo_mon_ext_1, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_2*b.signo) impo_mon_ext_2 "); 
	  textSQLSaldoPeriodos.append(" from ");
	  textSQLSaldoPeriodos.append(" 	cgComproConta a, ");
	  textSQLSaldoPeriodos.append(" 	cgComproContaDet b, ");
	  textSQLSaldoPeriodos.append(" 	cgAnaImpCon c , ");
	  textSQLSaldoPeriodos.append(" 	cgAnaCon d ");
	  textSQLSaldoPeriodos.append(" where ");
	  textSQLSaldoPeriodos.append(" 	a.imputac >= ? and a.imputac <= ? and b.signo=1");
	  textSQLSaldoPeriodos.append(" 	and a.oid_cco = b.oid_cco and ");
	  textSQLSaldoPeriodos.append(" 	b.oid_ai = c.oid_ai and ");
	  textSQLSaldoPeriodos.append(" 	c.oid_ana_con = d.oid_ana_con and ");
	  textSQLSaldoPeriodos.append(" 	a.oid_cco not in (select oid_cierre_ejercicio from cgCierreEjercicio) ");
	  textSQLSaldoPeriodos.append(" group by ");
	  textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
	  textSQLSaldoPeriodos.append(" 	c.oid_ana_con ");	  
	  

	  PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
	  querySelect.setDate(1,new java.sql.Date(fechaDesde.getTime()));
	  querySelect.setDate(2,new java.sql.Date(fechaHasta.getTime()));

	  return querySelect;

  }
  
  private PreparedStatement selectByMovFecDesdeHastaAllCreditosSinAsiCierre(Object aCondiciones)
  throws BaseException, SQLException {

	  MapDatos condiciones          = (MapDatos) aCondiciones;
	  java.util.Date fechaDesde     = (java.util.Date) condiciones.get("fechaDesde");
	  java.util.Date fechaHasta     = (java.util.Date) condiciones.get("fechaHasta");

	  StringBuffer textSQLSaldoPeriodos = new StringBuffer();
	  textSQLSaldoPeriodos.append(" select ");
	  textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
	  textSQLSaldoPeriodos.append(" 	c.oid_ana_con, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_his*b.signo) impo_loc_his, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_loc_aju*b.signo) impo_loc_aju, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_1*b.signo) impo_mon_ext_1, ");
	  textSQLSaldoPeriodos.append(" 	sum(b.impo_mon_ext_2*b.signo) impo_mon_ext_2 "); 
	  textSQLSaldoPeriodos.append(" from ");
	  textSQLSaldoPeriodos.append(" 	cgComproConta a, ");
	  textSQLSaldoPeriodos.append(" 	cgComproContaDet b, ");
	  textSQLSaldoPeriodos.append(" 	cgAnaImpCon c , ");
	  textSQLSaldoPeriodos.append(" 	cgAnaCon d ");
	  textSQLSaldoPeriodos.append(" where ");
	  textSQLSaldoPeriodos.append(" 	a.imputac >= ? and a.imputac <= ? and b.signo=-1 ");
	  textSQLSaldoPeriodos.append(" 	and a.oid_cco = b.oid_cco and ");
	  textSQLSaldoPeriodos.append(" 	b.oid_ai = c.oid_ai and ");
	  textSQLSaldoPeriodos.append(" 	c.oid_ana_con = d.oid_ana_con and ");
	  textSQLSaldoPeriodos.append(" 	a.oid_cco not in (select oid_cierre_ejercicio from cgCierreEjercicio) ");
	  textSQLSaldoPeriodos.append(" group by ");
	  textSQLSaldoPeriodos.append(" 	b.oid_ai, ");
	  textSQLSaldoPeriodos.append(" 	c.oid_ana_con ");	  
	  

	  PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQLSaldoPeriodos.toString());
	  querySelect.setDate(1,new java.sql.Date(fechaDesde.getTime()));
	  querySelect.setDate(2,new java.sql.Date(fechaHasta.getTime()));

	  return querySelect;

  }  


  /**
   * insert
   *
   * @param objetoPersistente IObjetoPersistente
   */
  protected void insert(IObjetoPersistente objetoPersistente) {
  }

  /**
   * delete
   *
   * @param objetoPersistente IObjetoPersistente
   */
  protected void delete(IObjetoPersistente objetoPersistente) {
  }

  /**
   * update
   *
   * @param objetoPersistente IObjetoPersistente
   */
  protected void update(IObjetoPersistente objetoPersistente) {
  }

  /**
   * rehabilitar
   *
   * @param objetoPersistente IObjetoPersistente
   */
  protected void rehabilitar(IObjetoPersistente objetoPersistente) {
  }

}
