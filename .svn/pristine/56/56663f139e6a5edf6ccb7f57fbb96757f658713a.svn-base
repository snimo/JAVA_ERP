package com.srn.erp.contabilidad.bm;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.da.DBConsultasContables;
import com.srn.erp.contabilidad.da.DBCuenta;
import com.srn.erp.general.bm.Indice;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.bm.TipoCambio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.Utils.Validar;

public class Cuenta extends ObjetoLogico {

  public Cuenta() {
  }

  public static String NICKNAME = "cg.Cuenta";

  private String codigo;
  private String descripcion;
  private Boolean esPatrimonial;
  private Boolean esCtaInterna;
  private Estructura estructura;
  private TipoCambio tipoCambio;
  private Indice indice;
  private Boolean activo;
  private String subsistema;
  private Boolean esImpuesto;
  
  private List reportesDet = new ArrayList();
  private boolean readReportesDet = true;

  public String getCodigo() throws BaseException {
    supportRefresh();
    return codigo;
  }

  public void setCodigo(String aCodigo) {
    this.codigo =  aCodigo;
  }
  
  public Boolean esImpuesto() throws BaseException {
    supportRefresh();
    return this.esImpuesto;
  }

  public void setEsImpuesto(Boolean aEsImpuesto) {
    this.esImpuesto =  aEsImpuesto;
  }
  

  public String getSubsistema() throws BaseException {
    supportRefresh();
    return subsistema;
  }

  public void setSubsistema(String aSubsistema) {
    this.subsistema =  aSubsistema;
  }


  public String getDescripcion() throws BaseException {
    supportRefresh();
    return descripcion;
  }

  public void setDescripcion(String aDescripcion) {
    this.descripcion =  aDescripcion;
  }

  public Boolean isEspatrimonial() throws BaseException {
    supportRefresh();
    if (esPatrimonial == null)
    	return new Boolean(false);
    else
    	return esPatrimonial;
  }

  public void setEspatrimonial(Boolean aEspatrimonial) {
    this.esPatrimonial =  aEspatrimonial;
  }

  public Boolean isEsctainterna() throws BaseException {
    supportRefresh();
    return esCtaInterna;
  }

  public void setEsctainterna(Boolean aEsctainterna) {
    this.esCtaInterna =  aEsctainterna;
  }

  public Estructura getEstructura() throws BaseException {
    supportRefresh();
    return estructura;
  }
  

  public void setEstructura(Estructura aEstructura) {
    this.estructura =  aEstructura;
  }

  public TipoCambio getTipocambio() throws BaseException {
    supportRefresh();
    return tipoCambio;
  }

  public void setTipocambio(TipoCambio aTipocambio) {
    this.tipoCambio =  aTipocambio;
  }

  public Indice getIndice() throws BaseException {
    supportRefresh();
    return indice;
  }

  public void setIndice(Indice aIndice) {
    this.indice =  aIndice;
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

 public static Cuenta findByOid(Integer oid , ISesion aSesion) throws BaseException {
   return (Cuenta) getObjectByOid(NICKNAME,oid,aSesion);
  }

  public static Cuenta findByOidProxy(Integer oid , ISesion aSesion) throws BaseException {
    return (Cuenta) getObjectByOidProxy(NICKNAME,oid,aSesion);
   }


 public static Cuenta findByCodigo(String codigo , ISesion aSesion) throws BaseException {
   return (Cuenta) getObjectByCodigo(NICKNAME,codigo,aSesion);
  }

 public void beforeSave() throws BaseException {
    Validar.noNulo(codigo, "Debe ingresar un código");
    Validar.noNulo(descripcion, "Debe ingresar la descripción");

    if (isEsctainterna().booleanValue())
      Validar.noNulo(subsistema, "Debe ingresar un subsistema");

   if (isNew() && (isActivo().booleanValue() == false))
     Validar.mensajeValidacion("La cuenta debe ingresarse en modo activo");
 }

 private CuentaImputable imputableConEstructura(String valoresCompoConcat)
     throws BaseException {
   return null;
 }

 private CuentaImputable getGenerarNuevaImputableSinEstructura() throws BaseException {
   // Generar nueva imputable sin estructura

   return null;
 }

 public CuentaImputable getImputable(String valoresCompoConcat) throws BaseException {
   return CuentaImputable.getImputable(this,valoresCompoConcat,getSesion());
 }

 public static List getHelpCuentas(MapDatos mapaDatos,
                                   ISesion aSesion) throws BaseException {
   return DBCuenta.getHelpCuentas(mapaDatos,aSesion);
 }

 public static List getCuentas(String codigoDesde,
                               String codigoHasta,
                               ISesion aSesion) throws BaseException {
   return DBCuenta.getCuentas(codigoDesde,codigoHasta,aSesion);
 }


 public String getListaCamposComponentes() throws BaseException {
   StringBuffer listaCampos = new StringBuffer("");
   if (getEstructura()!= null) {
     Iterator iterEstrcCompo =
         getEstructura().getEstrucComponenentes().iterator();
     while (iterEstrcCompo.hasNext()) {
       EstructuraCompo estCompo = (EstructuraCompo) iterEstrcCompo.next();
       listaCampos.append(estCompo.getComponente().getListaCampos());
     }
   }
   return listaCampos.toString();
 }

 public ImportesContables getSaldoInicial(java.util.Date fecha,
                                          Hashtable valoresComponentes) throws BaseException {
   try {
     if (this.isEspatrimonial() == false)
       return getSaldoInicialCtaResultado(fecha, valoresComponentes);
     else
       return getSaldoInicialCtaPatrimonial(fecha, valoresComponentes);
   }
   catch (SQLException ex) {
     throw new BaseException(null,ex.getMessage());
   }
   catch (ExceptionValidation ex) {
     throw new ExceptionValidation(ex,ex.getMessage());
   }
   catch (BaseException ex) {
     throw new BaseException(null,ex.getMessage());
   }
 }

 public ImportesContables getSaldoFinal(java.util.Date fecha,
                                        Hashtable valoresComponentes) throws BaseException {
   try {
     if (isEspatrimonial().booleanValue() == false)
       return getSaldoFinalCtaResultado(fecha, valoresComponentes);
     else
       return getSaldoFinalCtaPatrimonial(fecha, valoresComponentes);
   }
   catch (SQLException ex) {
     throw new BaseException(null,ex.getMessage());
   }
   catch (ExceptionValidation ex) {
     throw new ExceptionValidation(null,ex.getMessage());
   }
   catch (BaseException ex) {
     throw new BaseException(null,ex.getMessage());
   }
 }


  private ImportesContables getSaldoInicioDesdeIniEjerAFinPeriAntAFecIng(java.util.Date fecha,
                                                                         Hashtable valoresComponentes)
                                                                         throws BaseException,SQLException {

    MapDatos condiciones = new HashTableDatos();
    condiciones.put("oid_ana_con",this);
    condiciones.put("fecha",fecha);
    condiciones.put("valoresComponentes",valoresComponentes);

    DBConsultasContables consultasContables = new DBConsultasContables();
    consultasContables.setSesion(getSesion());
    PreparedStatement psConsSaldoIniPeri = consultasContables.prepararSelect(
      DBConsultasContables.SELECT_BY_SALDO_INI_DESDE_INI_EJER_A_FIN_PERI, condiciones);

    java.sql.ResultSet rsSaldoInicioPeriodos = null;
    rsSaldoInicioPeriodos = psConsSaldoIniPeri.executeQuery();

    double saldoPeriodosImpoMonLoc  = 0;
    double saldoPeriodosImpoMonAju  = 0;
    double saldoPeriodosImpoMonExt1 = 0;
    double saldoPeriodosImpoMonExt2 = 0;

    if (rsSaldoInicioPeriodos.next()) {
      saldoPeriodosImpoMonLoc  = rsSaldoInicioPeriodos.getDouble("impo_loc_his");
      saldoPeriodosImpoMonAju  = rsSaldoInicioPeriodos.getDouble("impo_loc_aju");
      saldoPeriodosImpoMonExt1 = rsSaldoInicioPeriodos.getDouble("impo_mon_ext_1");
      saldoPeriodosImpoMonExt2 = rsSaldoInicioPeriodos.getDouble("impo_mon_ext_2");
    }

    rsSaldoInicioPeriodos.close();
    psConsSaldoIniPeri.close();

    ImportesContables importesContables =
       new ImportesContables(new Money(saldoPeriodosImpoMonLoc),
                             new Money(saldoPeriodosImpoMonAju),
                             new Money(saldoPeriodosImpoMonExt1),
                             new Money(saldoPeriodosImpoMonExt2)
                             );
    return importesContables;
  }

  private ImportesContables getSaldoFinalDesdeIniEjerAFinPeriAntAFecIng(java.util.Date fecha,
                                                                        Hashtable valoresComponentes)
                                                                        throws BaseException,SQLException {

    MapDatos condiciones = new HashTableDatos();
    condiciones.put("oid_ana_con",this);
    condiciones.put("fecha",fecha);
    condiciones.put("valoresComponentes",valoresComponentes);

    DBConsultasContables consultasContables = new DBConsultasContables();
    consultasContables.setSesion(getSesion());
    PreparedStatement psConsSaldoIniPeri = consultasContables.prepararSelect(
      DBConsultasContables.SELECT_BY_SALDO_FIN_DESDE_INI_EJER_A_FIN_PERI, condiciones);

    java.sql.ResultSet rsSaldoInicioPeriodos = null;
    rsSaldoInicioPeriodos = psConsSaldoIniPeri.executeQuery();

    double saldoPeriodosImpoMonLoc  = 0;
    double saldoPeriodosImpoMonAju  = 0;
    double saldoPeriodosImpoMonExt1 = 0;
    double saldoPeriodosImpoMonExt2 = 0;

    if (rsSaldoInicioPeriodos.next()) {
      saldoPeriodosImpoMonLoc  = rsSaldoInicioPeriodos.getDouble("impo_loc_his");
      saldoPeriodosImpoMonAju  = rsSaldoInicioPeriodos.getDouble("impo_loc_aju");
      saldoPeriodosImpoMonExt1 = rsSaldoInicioPeriodos.getDouble("impo_mon_ext_1");
      saldoPeriodosImpoMonExt2 = rsSaldoInicioPeriodos.getDouble("impo_mon_ext_2");
    }

    rsSaldoInicioPeriodos.close();
    psConsSaldoIniPeri.close();

    ImportesContables importesContables =
       new ImportesContables(new Money(saldoPeriodosImpoMonLoc),
                             new Money(saldoPeriodosImpoMonAju),
                             new Money(saldoPeriodosImpoMonExt1),
                             new Money(saldoPeriodosImpoMonExt2)
                             );
    return importesContables;
  }


  private ImportesContables getSaldoInicioHastaFinPeriAntAFecIng(java.util.Date fecha,
                                                                 Hashtable valoresComponentes)
                                                                 throws BaseException,SQLException {

    MapDatos condiciones = new HashTableDatos();
    condiciones.put("oid_ana_con",this);
    condiciones.put("fecha",fecha);
    condiciones.put("valoresComponentes",valoresComponentes);

    DBConsultasContables consultasContables = new DBConsultasContables();
    consultasContables.setSesion(getSesion());
    PreparedStatement psConsSaldoIniPeri = consultasContables.prepararSelect(
      DBConsultasContables.SELECT_BY_SALDO_INI_DESDE_INI_CONTA_A_FIN_PERI, condiciones);

    java.sql.ResultSet rsSaldoInicioPeriodos = null;
    rsSaldoInicioPeriodos = psConsSaldoIniPeri.executeQuery();

    double saldoPeriodosImpoMonLoc  = 0;
    double saldoPeriodosImpoMonAju  = 0;
    double saldoPeriodosImpoMonExt1 = 0;
    double saldoPeriodosImpoMonExt2 = 0;

    if (rsSaldoInicioPeriodos.next()) {
      saldoPeriodosImpoMonLoc  = rsSaldoInicioPeriodos.getDouble("impo_loc_his");
      saldoPeriodosImpoMonAju  = rsSaldoInicioPeriodos.getDouble("impo_loc_aju");
      saldoPeriodosImpoMonExt1 = rsSaldoInicioPeriodos.getDouble("impo_mon_ext_1");
      saldoPeriodosImpoMonExt2 = rsSaldoInicioPeriodos.getDouble("impo_mon_ext_2");
    }

    rsSaldoInicioPeriodos.close();
    psConsSaldoIniPeri.close();

    ImportesContables importesContables =
       new ImportesContables(new Money(saldoPeriodosImpoMonLoc),
                             new Money(saldoPeriodosImpoMonAju),
                             new Money(saldoPeriodosImpoMonExt1),
                             new Money(saldoPeriodosImpoMonExt2)
                             );
    return importesContables;
  }

  private ImportesContables getSaldoFinalHastaFinPeriAntAFecIng(java.util.Date fecha,
                                                                 Hashtable valoresComponentes)
                                                                 throws BaseException,SQLException {

    MapDatos condiciones = new HashTableDatos();
    condiciones.put("oid_ana_con",this);
    condiciones.put("fecha",fecha);
    if (valoresComponentes == null)
    	valoresComponentes = new Hashtable();
    condiciones.put("valoresComponentes",valoresComponentes);

    DBConsultasContables consultasContables = new DBConsultasContables();
    consultasContables.setSesion(getSesion());
    PreparedStatement psConsSaldoFinPeri = consultasContables.prepararSelect(
      DBConsultasContables.SELECT_BY_SALDO_FIN_DESDE_INI_CONTA_A_FIN_PERI, condiciones);

    java.sql.ResultSet rsSaldoFinalPeriodos = null;
    rsSaldoFinalPeriodos = psConsSaldoFinPeri.executeQuery();

    double saldoPeriodosImpoMonLoc  = 0;
    double saldoPeriodosImpoMonAju  = 0;
    double saldoPeriodosImpoMonExt1 = 0;
    double saldoPeriodosImpoMonExt2 = 0;

    if (rsSaldoFinalPeriodos.next()) {
      saldoPeriodosImpoMonLoc  = rsSaldoFinalPeriodos.getDouble("impo_loc_his");
      saldoPeriodosImpoMonAju  = rsSaldoFinalPeriodos.getDouble("impo_loc_aju");
      saldoPeriodosImpoMonExt1 = rsSaldoFinalPeriodos.getDouble("impo_mon_ext_1");
      saldoPeriodosImpoMonExt2 = rsSaldoFinalPeriodos.getDouble("impo_mon_ext_2");
    }

    rsSaldoFinalPeriodos.close();
    psConsSaldoFinPeri.close();

    ImportesContables importesContables =
       new ImportesContables(new Money(saldoPeriodosImpoMonLoc),
                             new Money(saldoPeriodosImpoMonAju),
                             new Money(saldoPeriodosImpoMonExt1),
                             new Money(saldoPeriodosImpoMonExt2)
                             );
    return importesContables;
  }
  
  public ImportesContables getTotalPeriodo(Periodo periodo,
          					Hashtable valoresComponentes)
          throws BaseException {
	  try {
	  MapDatos condiciones = new HashTableDatos();
	  condiciones.put(Cuenta.NICKNAME,this);
	  condiciones.put(Periodo.NICKNAME,periodo);
	  if (valoresComponentes!=null)
		  condiciones.put("valoresComponentes",valoresComponentes);

	  DBConsultasContables consultasContables = new DBConsultasContables();
	  consultasContables.setSesion(getSesion());
	  PreparedStatement psTotal = consultasContables.prepararSelect(
			DBConsultasContables.SELECT_BY_TOT_CTA_PERI, 
			condiciones);

	  java.sql.ResultSet rsTotal = null;
	  rsTotal = psTotal.executeQuery();

	  double totMonLoc  = 0;
	  double totMonAju  = 0;
	  double totMonExt1 = 0;
	  double totMonExt2 = 0;

	  if (rsTotal.next()) {
		  totMonLoc  = rsTotal.getDouble("impo_loc_his");
		  totMonAju  = rsTotal.getDouble("impo_loc_aju");
		  totMonExt1 = rsTotal.getDouble("impo_mon_ext_1");
		  totMonExt2 = rsTotal.getDouble("impo_mon_ext_2");
	  }

	  rsTotal.close();
	  psTotal.close();

	  ImportesContables importesContables =
		  new ImportesContables(
				  new Money(totMonLoc),
				  new Money(totMonAju),
				  new Money(totMonExt1),
				  new Money(totMonExt2)
		  );
	  return importesContables;
	  }
	  catch (SQLException ex) {
		     throw new BaseException(null,ex.getMessage());
	  }	  
  }
  



  private ImportesContables getSaldoInicioDesdeIniPeriADiaAntAFecIng(java.util.Date fecha,
                                                                     Hashtable valoresComponentes)
                                                                     throws BaseException,SQLException {

    MapDatos condiciones = new HashTableDatos();
    condiciones.put("oid_ana_con",this);
    condiciones.put("fecha",fecha);
    condiciones.put("valoresComponentes",valoresComponentes);

    DBConsultasContables consultasContables = new DBConsultasContables();
    consultasContables.setSesion(getSesion());
    PreparedStatement psConsSaldoIniFechas = consultasContables.prepararSelect(
        DBConsultasContables.SELECT_BY_SALDO_INI_DESDE_INICIO_PERI_A_FECHA_DIA_ANT, condiciones);

    java.sql.ResultSet rsSaldoInicioFecha = null;
    rsSaldoInicioFecha = psConsSaldoIniFechas.executeQuery();

    double saldoFechaImpoMonLoc   = 0;
    double saldoFechaImpoMonAju   = 0;
    double saldoFechasImpoMonExt1 = 0;
    double saldoFechasImpoMonExt2 = 0;

    if (rsSaldoInicioFecha.next()) {
      saldoFechaImpoMonLoc   = rsSaldoInicioFecha.getDouble("impo_loc_his");
      saldoFechaImpoMonAju   = rsSaldoInicioFecha.getDouble("impo_loc_aju");
      saldoFechasImpoMonExt1 = rsSaldoInicioFecha.getDouble("impo_mon_ext_1");
      saldoFechasImpoMonExt2 = rsSaldoInicioFecha.getDouble("impo_mon_ext_2");
    }

    rsSaldoInicioFecha.close();
    psConsSaldoIniFechas.close();

    ImportesContables importesContables =
       new ImportesContables(new Money(saldoFechaImpoMonLoc),
                             new Money(saldoFechaImpoMonAju),
                             new Money(saldoFechasImpoMonExt1),
                             new Money(saldoFechasImpoMonExt2)
                             );
    return importesContables;

  }

  private ImportesContables getSaldoFinalDesdeIniPeriADiaIngresado(java.util.Date fecha,
                                                                   Hashtable valoresComponentes)
                                                                   throws BaseException,SQLException {

    MapDatos condiciones = new HashTableDatos();
    condiciones.put("oid_ana_con",this);
    condiciones.put("fecha",fecha);
    if (valoresComponentes == null)
    	valoresComponentes = new Hashtable();
    condiciones.put("valoresComponentes",valoresComponentes);

    DBConsultasContables consultasContables = new DBConsultasContables();
    consultasContables.setSesion(getSesion());
    PreparedStatement psConsSaldoFinFechas = consultasContables.prepararSelect(
        DBConsultasContables.SELECT_BY_SALDO_FIN_DESDE_INICIO_PERI_A_FECHA_ING, condiciones);

    java.sql.ResultSet rsSaldoFinalFecha = null;
    rsSaldoFinalFecha = psConsSaldoFinFechas.executeQuery();

    double saldoFechaImpoMonLoc   = 0;
    double saldoFechaImpoMonAju   = 0;
    double saldoFechasImpoMonExt1 = 0;
    double saldoFechasImpoMonExt2 = 0;

    if (rsSaldoFinalFecha.next()) {
      saldoFechaImpoMonLoc   = rsSaldoFinalFecha.getDouble("impo_loc_his");
      saldoFechaImpoMonAju   = rsSaldoFinalFecha.getDouble("impo_loc_aju");
      saldoFechasImpoMonExt1 = rsSaldoFinalFecha.getDouble("impo_mon_ext_1");
      saldoFechasImpoMonExt2 = rsSaldoFinalFecha.getDouble("impo_mon_ext_2");
    }

    rsSaldoFinalFecha.close();
    psConsSaldoFinFechas.close();

    ImportesContables importesContables =
       new ImportesContables(new Money(saldoFechaImpoMonLoc),
                             new Money(saldoFechaImpoMonAju),
                             new Money(saldoFechasImpoMonExt1),
                             new Money(saldoFechasImpoMonExt2)
                             );
    return importesContables;

  }


  private ImportesContables getSaldoInicialCtaResultado(java.util.Date fecha,
                                                        Hashtable valoresComponentes)
                                                        throws BaseException,SQLException {

   ImportesContables impoContablesSaldoPeriAntAFecIng =
       getSaldoInicioDesdeIniEjerAFinPeriAntAFecIng(fecha,valoresComponentes);

   ImportesContables impoContablesSaldoDesdeIniPeriADiaAntAFecIng =
       getSaldoInicioDesdeIniPeriADiaAntAFecIng(fecha,valoresComponentes);

    CalculadorMoney calcMoneyImpoLoc = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonLoc());
    calcMoneyImpoLoc.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonLoc());

    CalculadorMoney calcMoneyImpoAju = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonLocAju());
    calcMoneyImpoAju.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonLocAju());

    CalculadorMoney calcMoneyImpoExt1 = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonExt1());
    calcMoneyImpoExt1.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonExt1());

    CalculadorMoney calcMoneyImpoExt2 = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonExt2());
    calcMoneyImpoExt2.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonExt2());

    ImportesContables importesContables =
        new ImportesContables(calcMoneyImpoLoc.getResultMoney(),
                              calcMoneyImpoAju.getResultMoney(),
                              calcMoneyImpoExt1.getResultMoney(),
                              calcMoneyImpoExt2.getResultMoney()
                              );
    return importesContables;
 }

 private ImportesContables getSaldoFinalCtaResultado(java.util.Date fecha,
                                                     Hashtable valoresComponentes)
                                                     throws BaseException,SQLException {

  ImportesContables impoContablesSaldoPeriAntAFecIng =
      getSaldoFinalDesdeIniEjerAFinPeriAntAFecIng(fecha,valoresComponentes);

  ImportesContables impoContablesSaldoDesdeIniPeriADiaAntAFecIng =
      getSaldoFinalDesdeIniPeriADiaIngresado(fecha,valoresComponentes);

   CalculadorMoney calcMoneyImpoLoc = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonLoc());
   calcMoneyImpoLoc.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonLoc());

   CalculadorMoney calcMoneyImpoAju = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonLocAju());
   calcMoneyImpoAju.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonLocAju());

   CalculadorMoney calcMoneyImpoExt1 = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonExt1());
   calcMoneyImpoExt1.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonExt1());

   CalculadorMoney calcMoneyImpoExt2 = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonExt2());
   calcMoneyImpoExt2.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonExt2());

   ImportesContables importesContables =
       new ImportesContables(calcMoneyImpoLoc.getResultMoney(),
                             calcMoneyImpoAju.getResultMoney(),
                             calcMoneyImpoExt1.getResultMoney(),
                             calcMoneyImpoExt2.getResultMoney()
                             );
   return importesContables;
}


  private ImportesContables getSaldoInicialCtaPatrimonial(java.util.Date fecha,
                                                          Hashtable valoresComponentes)
                                                          throws BaseException,SQLException {

    ImportesContables impoContablesSaldoPeriAntAFecIng =
        getSaldoInicioHastaFinPeriAntAFecIng(fecha,valoresComponentes);

    ImportesContables impoContablesSaldoDesdeIniPeriADiaAntAFecIng =
       getSaldoInicioDesdeIniPeriADiaAntAFecIng(fecha,valoresComponentes);

     CalculadorMoney calcMoneyImpoLoc = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonLoc());
     calcMoneyImpoLoc.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonLoc());

     CalculadorMoney calcMoneyImpoAju = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonLocAju());
     calcMoneyImpoAju.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonLocAju());

     CalculadorMoney calcMoneyImpoExt1 = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonExt1());
     calcMoneyImpoExt1.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonExt1());

     CalculadorMoney calcMoneyImpoExt2 = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonExt2());
     calcMoneyImpoExt2.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonExt2());

     ImportesContables importesContables =
        new ImportesContables(calcMoneyImpoLoc.getResultMoney(),
                             calcMoneyImpoAju.getResultMoney(),
                             calcMoneyImpoExt1.getResultMoney(),
                             calcMoneyImpoExt2.getResultMoney()
                             );
     return importesContables;
}

  private ImportesContables getSaldoFinalCtaPatrimonial(java.util.Date fecha,
                                                         Hashtable valoresComponentes)
                                                         throws BaseException,SQLException {

     ImportesContables impoContablesSaldoPeriAntAFecIng =
         getSaldoFinalHastaFinPeriAntAFecIng(fecha,valoresComponentes);

     ImportesContables impoContablesSaldoDesdeIniPeriADiaAntAFecIng =
        getSaldoFinalDesdeIniPeriADiaIngresado(fecha,valoresComponentes);

      CalculadorMoney calcMoneyImpoLoc = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonLoc());
      calcMoneyImpoLoc.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonLoc());

      CalculadorMoney calcMoneyImpoAju = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonLocAju());
      calcMoneyImpoAju.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonLocAju());

      CalculadorMoney calcMoneyImpoExt1 = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonExt1());
      calcMoneyImpoExt1.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonExt1());

      CalculadorMoney calcMoneyImpoExt2 = new CalculadorMoney(impoContablesSaldoPeriAntAFecIng.getImpoMonExt2());
      calcMoneyImpoExt2.sumar(impoContablesSaldoDesdeIniPeriADiaAntAFecIng.getImpoMonExt2());

      ImportesContables importesContables =
         new ImportesContables(calcMoneyImpoLoc.getResultMoney(),
                              calcMoneyImpoAju.getResultMoney(),
                              calcMoneyImpoExt1.getResultMoney(),
                              calcMoneyImpoExt2.getResultMoney()
                              );
      return importesContables;
 }

 public List getComponentesConAux() throws BaseException {
   if (getEstructura()!= null)
     return getEstructura().getComponenentesConAux();
   else
     return new ArrayList();
 }

 public List getImputables() throws BaseException {
   return CuentaImputable.getImputablesByCuenta(this,getSesion());
 }

 public List getImputablesByValoresCompo(HashTableDatos listaValCompo) throws BaseException {
   return CuentaImputable.getImputablesByCuentayValoresCompo(this,listaValCompo,getSesion());
 }

 public List getImputablesByNotInValoresCompo(HashTableDatos listaValCompo) throws BaseException {
   return CuentaImputable.getImputablesByCuentayNotInValoresCompo(this,listaValCompo,getSesion());
 }
 
 public static Cuenta getCuentaProvisionCompras(ISesion aSesion) throws BaseException {
     ValorParametro valorParametro = ValorParametro.findByCodigoParametro("CUENTA_PROVISION_COMPRAS",aSesion);
     Cuenta cuenta = Cuenta.findByOid(valorParametro.getOidObjNeg(),aSesion);
     return cuenta;
 }
 
 public Componente getUltCompoSegunValConcat(String aValConcat) throws BaseException {
	 
	 if (aValConcat == null)
		 return null;
	 if (this.getEstructura() == null)
		 return null;
	 
	 int cantCompo = CuentaImputable.getCantValoresSegunValConcat(aValConcat); 
	 
	 int i = 0;
	 Componente compoEncontrado = null;
	 
	 Iterator iterEstrucCompo = this.getEstructura().getEstrucComponenentes().iterator();
	 while (iterEstrucCompo.hasNext()) {
		    ++i;
			EstructuraCompo estrucCompo = (EstructuraCompo) iterEstrucCompo.next();
			
			if (i==cantCompo) {
				compoEncontrado = estrucCompo.getComponente();
				break;
			}
			
	 }
	 
	 return compoEncontrado;
	 
 }
 
 public Componente getUltimoComponente() throws BaseException {
	 if (this.getEstructura()==null) return  null;
	 
	 Iterator iterEstrucCompo = this.getEstructura().getEstrucComponenentes().iterator();
	 while (iterEstrucCompo.hasNext()) {
		EstructuraCompo estrucCompo = (EstructuraCompo) iterEstrucCompo.next();
		
		if (iterEstrucCompo.hasNext()==false)
			return estrucCompo.getComponente();
			
	}
	 
	return null;
 }
 
 public String getDescEstrucCta() throws BaseException {
	 StringBuffer descEstruc = new StringBuffer("");
	 if (this.getEstructura()==null)
		 return "";
	 Iterator iterEstrucCompo = this.getEstructura().getEstrucComponenentes().iterator();
	 while (iterEstrucCompo.hasNext()) {
		EstructuraCompo estrucCompo = (EstructuraCompo) iterEstrucCompo.next();
		if (descEstruc.length()>0)
			descEstruc.append(".");
		descEstruc.append(estrucCompo.getComponente().getDescripcion());
	}
	 return descEstruc.toString();
 }

 public static List getAllActivos(ISesion aSesion) throws BaseException {
	  return DBCuenta.getAllActivos(aSesion);

 }
 
 public void addReporteContableDet(ReporteContableDet reporteContableDet) throws BaseException {
	 this.reportesDet.add(reporteContableDet);
 }

 public void afterSave() throws BaseException {
	Iterator iterReportesContablesDet = this.reportesDet.iterator();
	while (iterReportesContablesDet.hasNext()) {
	      ReporteContableDet reporteContableDet = (ReporteContableDet) iterReportesContablesDet.next();
	      reporteContableDet.save();
	      reporteContableDet = null;
	}
	iterReportesContablesDet = null;
 }
 
 public boolean isTieneEstructura() throws BaseException {
	 if (this.getEstructura()!=null)
		 return true;
	 else
		 return false;
 }
 


}
