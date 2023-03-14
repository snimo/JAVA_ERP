package com.srn.erp.contabilidad.op;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.ImportesContables;
import com.srn.erp.contabilidad.da.DBConsultasContables;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ConsultaMayor extends Operation  {
	
  private static String TIPO_CONS_COMPRO = "COMPRO";	
  private static String TIPO_CONS_TC = "TIPO_COMPRO";
  private static String DET_COMPO = "DET_COMPO";

  private Cuenta cuenta;
  private java.util.Date fecImpuDesde;
  private java.util.Date fecImpuHasta;
  private Hashtable valoresDeComponentes = new Hashtable();
  private Integer cantComponentes = null;
  private final String SALDO_INICIAL = "Saldo Inicial";
  private final String MOVIMIENTOS   = "Movimientos";
  private final String SALDO_FINAL   = "Saldo Final";
  private IDataSet  datasetConsMayor;
  private IDataSet  datasetSaldos;
  private IDataSet  dataSetFiltro = getDataSetFiltro();
  private String monedaCursoLegal = null;
  private String monedaAjustada = null;
  private String monedaExt1 = null;
  private String monedaExt2 = null;
  private Money saldoInicialMonedaLocal;
  private Money saldoInicialMonedaAju;
  private Money saldoInicialMonedaExt1;
  private Money saldoInicialMonedaExt2;
  private List listaComponentes;
  StringBuffer filtro;
  private CalculadorMoney calAcumSaldoMonLoc = new CalculadorMoney(new Money(0));
  private CalculadorMoney calAcumSaldoMonLocAju = new CalculadorMoney(new Money(0));
  private CalculadorMoney calAcumSaldoMonExt1 = new CalculadorMoney(new Money(0));
  private CalculadorMoney calAcumSaldoMonExt2 = new CalculadorMoney(new Money(0));
  
  private CalculadorMoney calAcumDebeMonLoc = new CalculadorMoney(new Money(0));
  private CalculadorMoney calAcumDebeMonLocAju = new CalculadorMoney(new Money(0));
  private CalculadorMoney calAcumDebeMonExt1 = new CalculadorMoney(new Money(0));
  private CalculadorMoney calAcumDebeMonExt2 = new CalculadorMoney(new Money(0));
  
  private CalculadorMoney calAcumHaberMonLoc = new CalculadorMoney(new Money(0));
  private CalculadorMoney calAcumHaberMonLocAju = new CalculadorMoney(new Money(0));
  private CalculadorMoney calAcumHaberMonExt1 = new CalculadorMoney(new Money(0));
  private CalculadorMoney calAcumHaberMonExt2 = new CalculadorMoney(new Money(0));
  
  private boolean esMonedaLocal = false;
  private boolean esMonedaLocalAju = false;
  private boolean esMonedaExt1 = false;
  private boolean esMonedaExt2 = false;
  
  private String tipoConsulta = null;

  public ConsultaMayor() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	tipoConsulta = mapaDatos.getString("tipo_consulta");
    init(Moneda.findByOidProxy(mapaDatos.getInteger("oid_moneda"),this.getSesion()),
    	 mapaDatos.getBoolean("ajustado"));
    tratarParametros(mapaDatos);
    traerSaldoInicial();
    if (tipoConsulta.equals(TIPO_CONS_COMPRO))
    	traerMovimientosCuenta();
    else if (tipoConsulta.equals(TIPO_CONS_TC))
    	traerMovimientosCuentaPorTC();
    else if (tipoConsulta.equals(DET_COMPO))
    	traerMovimientosDetalleCompo();    
    
    if (((tipoConsulta.equals(TIPO_CONS_COMPRO))) ||
    	       ((tipoConsulta.equals(TIPO_CONS_TC))))
    	traerSaldoFinal();
    traerSaldos();
    enviarDataSets();
  }
  
  private void traerSaldos() throws BaseException {
	  datasetSaldos.append();
	  datasetSaldos.fieldValue("oid_cuenta", cuenta.getOIDInteger());
	  datasetSaldos.fieldValue("cod_cuenta", cuenta.getCodigo());
	  datasetSaldos.fieldValue("cuenta", cuenta.getDescripcion());

	  CalculadorMoney calcSaldoFinal = new CalculadorMoney(new Money(0));
	  
	  if (this.esMonedaLocal) {
		  datasetSaldos.fieldValue("saldo_inicial", saldoInicialMonedaLocal);
		  datasetSaldos.fieldValue("debe", calAcumDebeMonLoc.getResult());
		  datasetSaldos.fieldValue("haber", calAcumHaberMonLoc.getResult());
		  calcSaldoFinal.sumar(saldoInicialMonedaLocal);
		  calcSaldoFinal.sumar(calAcumDebeMonLoc.getResultMoney());
		  calcSaldoFinal.restar(calAcumHaberMonLoc.getResultMoney());
		  datasetSaldos.fieldValue("saldo_final", calcSaldoFinal.getResultMoney());
	  } else
		  if (this.esMonedaLocalAju) {
			  datasetSaldos.fieldValue("saldo_inicial", saldoInicialMonedaAju);
			  datasetSaldos.fieldValue("debe", calAcumDebeMonLocAju.getResult());
			  datasetSaldos.fieldValue("haber", calAcumHaberMonLocAju.getResult());
			  calcSaldoFinal.sumar(saldoInicialMonedaAju);
			  calcSaldoFinal.sumar(calAcumDebeMonLocAju.getResultMoney());
			  calcSaldoFinal.restar(calAcumHaberMonLocAju.getResultMoney());
			  datasetSaldos.fieldValue("saldo_final", calcSaldoFinal.getResultMoney());
		  }
		  else if (this.esMonedaExt1) {
			  datasetSaldos.fieldValue("saldo_inicial", saldoInicialMonedaExt1);
			  datasetSaldos.fieldValue("debe", calAcumDebeMonExt1.getResult());
			  datasetSaldos.fieldValue("haber", calAcumHaberMonExt1.getResult());
			  calcSaldoFinal.sumar(saldoInicialMonedaExt1);
			  calcSaldoFinal.sumar(calAcumDebeMonExt1.getResultMoney());
			  calcSaldoFinal.restar(calAcumHaberMonExt1.getResultMoney());
			  datasetSaldos.fieldValue("saldo_final", calcSaldoFinal.getResultMoney());
		  } else if (this.esMonedaExt2) {
			  datasetSaldos.fieldValue("saldo_inicial", saldoInicialMonedaExt2);
			  datasetSaldos.fieldValue("debe", calAcumDebeMonExt2.getResult());
			  datasetSaldos.fieldValue("haber", calAcumHaberMonExt2.getResult());
			  calcSaldoFinal.sumar(saldoInicialMonedaExt2);
			  calcSaldoFinal.sumar(calAcumDebeMonExt2.getResultMoney());
			  calcSaldoFinal.restar(calAcumHaberMonExt2.getResultMoney());
			  datasetSaldos.fieldValue("saldo_final", calcSaldoFinal.getResultMoney());
		  	} 
	  
	  
  }

  public void init(Moneda moneda, Boolean ajustada) throws BaseException {
    monedaCursoLegal = Moneda.getMonedaCursoLegal(getSesion()).getDescripcion();
    monedaAjustada = Moneda.getMonedaCursoLegal(getSesion()).getDescripcion()+" (Aju)";
    monedaExt1 = Moneda.getMonedaExt1(getSesion()).getDescripcion();
    monedaExt2 = Moneda.getMonedaExt2(getSesion()).getDescripcion();
    
    if (moneda.getOID() == Moneda.getMonedaCursoLegal(getSesion()).getOID()) {
    	if (ajustada == true)
    		this.esMonedaLocalAju = true;
    	else
    		this.esMonedaLocal = true;
    } else
    	if (moneda.getOID() == Moneda.getMonedaExt1(getSesion()).getOID()) 
    		this.esMonedaExt1 = true;
    	else if (moneda.getOID() == Moneda.getMonedaExt2(getSesion()).getOID()) 
    		this.esMonedaExt2 = true;
    
  }

  private void tratarParametros(MapDatos mapaDatos) throws BaseException {
    cuenta          = Cuenta.findByOid(mapaDatos.getInteger("oid_ana"),getSesion());
    listaComponentes = cuenta.getComponentesConAux();
    fecImpuDesde    = mapaDatos.getDate("fecDesde");
    fecImpuHasta    = mapaDatos.getDate("fecHasta");
    cantComponentes = mapaDatos.getInteger("cant_compo");

    filtro = new StringBuffer();
    filtro.append(cuenta.getCodigo()+" - "+cuenta.getDescripcion()+"  ");
    filtro.append(" del "+Fecha.getddmmyyyy(fecImpuDesde)+" al "+Fecha.getddmmyyyy(fecImpuHasta)+" ");
    filtro.append(" en "+Moneda.findByOidProxy(mapaDatos.getInteger("oid_moneda"),this.getSesion()).getDescripcion()+". ");

    for (int i=1;i<=cantComponentes.intValue();++i) {
      Integer oidComponente = mapaDatos.getInteger("oid_compo_"+new Integer(i).toString());
      Integer oidValCompo   = mapaDatos.getInteger("oid_val_compo_"+new Integer(i).toString());
      Componente componente    = Componente.findByOid(oidComponente,getSesion());
      IObjetoLogico valorCompo = componente.getValorCompo(oidValCompo);
      valoresDeComponentes.put(componente,valorCompo);
      filtro.append(componente.getDescripcion()+": "+valorCompo.getCodigo()+"-"+valorCompo.getDescripcion()+"  ");
    }
    cargarRegistroFiltro(dataSetFiltro,filtro.toString());
    datasetConsMayor = getDataSetConsultaMayor();
    datasetSaldos = getDataSetSaldos();
  }

  private MapDatos getCondicionesQuery() throws BaseException {
    MapDatos condiciones = new HashTableDatos();
    condiciones.put("oid_ana_con",cuenta);
    condiciones.put("fecImputacDesde",fecImpuDesde);
    condiciones.put("fecImputacHasta",fecImpuHasta);
    condiciones.put("valoresComponentes",valoresDeComponentes);
    return condiciones;
  }

  private void traerSaldoInicial() throws BaseException {
    ImportesContables importesContables =
        cuenta.getSaldoInicial(fecImpuDesde,valoresDeComponentes);

    saldoInicialMonedaLocal = new Money(importesContables.getImpoMonLoc().doubleValue());
    saldoInicialMonedaAju   = new Money(importesContables.getImpoMonLocAju().doubleValue());
    saldoInicialMonedaExt1  = new Money(importesContables.getImpoMonExt1().doubleValue());
    saldoInicialMonedaExt2  = new Money(importesContables.getImpoMonExt2().doubleValue());
    
    calAcumSaldoMonLoc.sumar(saldoInicialMonedaLocal);
    calAcumSaldoMonLocAju.sumar(saldoInicialMonedaAju);
    calAcumSaldoMonExt1.sumar(saldoInicialMonedaExt1);
    calAcumSaldoMonExt2.sumar(saldoInicialMonedaExt2);
    
  }

  private void traerSaldoFinal() throws BaseException {

	  
	ImportesContables importesContables =
			cuenta.getSaldoFinal(fecImpuHasta,valoresDeComponentes);
	double debe     = 0;
	double haber    = 0;
	
	
	if (this.esMonedaLocal) {
					
		if (importesContables.getImpoMonLoc().doubleValue()>0) {
			debe  = Math.abs(importesContables.getImpoMonLoc().doubleValue());
			haber = 0;
		}
		else {
			debe  = 0;
			haber = Math.abs(importesContables.getImpoMonLoc().doubleValue());
		}

    
		cargarRegistroConsultaMayor(datasetConsMayor,0,0,
                                SALDO_FINAL,
                                SALDO_FINAL,
                                "",
                                "",
                                Fecha.getddmmyyyy(fecImpuHasta),
                                monedaCursoLegal,
                                null,0,0,0,calAcumSaldoMonLoc.getResult(),getValoresCompoEnSaldoFinal());
	}


	else 
	if (this.esMonedaLocalAju) {
		if (importesContables.getImpoMonLocAju().doubleValue()>0) {
			debe  = Math.abs(importesContables.getImpoMonLocAju().doubleValue());
			haber = 0;
		}
		else {
			debe  = 0;
			haber = Math.abs(importesContables.getImpoMonLocAju().doubleValue());
		}

		cargarRegistroConsultaMayor(datasetConsMayor,0,0,
                                SALDO_FINAL,
                                SALDO_FINAL,
                                "",
                                "",
                                Fecha.getddmmyyyy(fecImpuHasta),
                                monedaAjustada,
                                null,0,0,0,calAcumSaldoMonLocAju.getResult(),getValoresCompoEnSaldoFinal());
	}
	else 
	if (this.esMonedaExt1) {
		if (importesContables.getImpoMonExt1().doubleValue()>0) {
			debe  = Math.abs(importesContables.getImpoMonExt1().doubleValue());
			haber = 0;
		}
		else {
			debe  = 0;
			haber = Math.abs(importesContables.getImpoMonExt1().doubleValue());
		}

		cargarRegistroConsultaMayor(datasetConsMayor,0,0,
                                SALDO_FINAL,
                                SALDO_FINAL,
                                "",
                                "",
                                Fecha.getddmmyyyy(fecImpuHasta),
                                monedaExt1,
                                null,0,0,0,calAcumSaldoMonExt1.getResult(),getValoresCompoEnSaldoFinal());
	}
	else if (this.esMonedaExt2) {

		if (importesContables.getImpoMonExt2().doubleValue()>0) {
			debe  = Math.abs(importesContables.getImpoMonExt2().doubleValue());
			haber = 0;
		}
		else {
			debe  = 0;
			haber = Math.abs(importesContables.getImpoMonExt2().doubleValue());
		}

		cargarRegistroConsultaMayor(datasetConsMayor,0,0,
                                SALDO_FINAL,
                                SALDO_FINAL,
                                "",
                                "",
                                Fecha.getddmmyyyy(fecImpuHasta),
                                monedaExt2,
                                null,0,0,0,calAcumSaldoMonExt2.getResult(),getValoresCompoEnSaldoFinal());
	}

  }


  private void cargarSaldosInicialesMovimientos() throws BaseException {
	if (this.esMonedaLocal) 
		cargarRegistroConsultaMayor(datasetConsMayor,0,0,
				MOVIMIENTOS,
				SALDO_INICIAL,
				"",
				"",
				Fecha.getddmmyyyy(fecImpuDesde),
				monedaCursoLegal,
				saldoInicialMonedaLocal.doubleValue(),
				0,
				0,
				0,
				calAcumSaldoMonLoc.getResult(),
				getValoresCompoEnSaldoInicial());
	else
	if (this.esMonedaLocalAju)
    cargarRegistroConsultaMayor(datasetConsMayor,0,0,
                                   MOVIMIENTOS,
                                   SALDO_INICIAL,
                                   "",
                                   "",
                                   Fecha.getddmmyyyy(fecImpuDesde),
                                   monedaAjustada,
                                   saldoInicialMonedaAju.doubleValue(),
                                   0,
                                   0,
                                   0,
                                   calAcumSaldoMonLocAju.getResult(),
                                   getValoresCompoEnSaldoInicial());
	else
	if (this.esMonedaExt1)
     cargarRegistroConsultaMayor(datasetConsMayor,0,0,
                                 MOVIMIENTOS,
                                 SALDO_INICIAL,
                                 "",
                                 "",
                                 Fecha.getddmmyyyy(fecImpuDesde),
                                 monedaExt1,
                                 saldoInicialMonedaExt1.doubleValue(),
                                 0,
                                 0,
                                 0,
                                 calAcumSaldoMonExt1.getResult(),
                                 getValoresCompoEnSaldoInicial());
	else if (this.esMonedaExt2)
     cargarRegistroConsultaMayor(datasetConsMayor,0,0,
                                 MOVIMIENTOS,
                                 SALDO_INICIAL,
                                 "",
                                 "",
                                 Fecha.getddmmyyyy(fecImpuDesde),
                                 monedaExt2,
                                 saldoInicialMonedaExt2.doubleValue(),
                                 0,
                                 0,
                                 0,
                                 calAcumSaldoMonExt2.getResult(),
                                 getValoresCompoEnSaldoInicial());
  }
  
    private void traerMovimientosDetalleCompo() throws BaseException {

	    double d_impo_loc_his = 0;
	    double h_impo_loc_his = 0;
	    double d_impo_loc_aju = 0;
	    double h_impo_loc_aju = 0;
	    double d_impo_mon_ext_1 = 0;
	    double h_impo_mon_ext_1 = 0;
	    double d_impo_mon_ext_2 = 0;
	    double h_impo_mon_ext_2 = 0;

	    try {

	        java.sql.ResultSet rs = null;
	        DBConsultasContables consultasContables = new DBConsultasContables();
	        consultasContables.setSesion(getSesion());
	          PreparedStatement psConsMayor = consultasContables.prepararSelect(
	              DBConsultasContables.SELECT_BY_MOVIMIENTOS_CUENTA, getCondicionesQuery());
	         rs = psConsMayor.executeQuery();

	         while (rs.next()) {

	           if (rs.getInt("signo")==1) {
	              d_impo_loc_his = rs.getDouble("impo_loc_his");
	              d_impo_loc_aju = rs.getDouble("impo_loc_aju");
	              d_impo_mon_ext_1 = rs.getDouble("impo_mon_ext_1");
	              d_impo_mon_ext_2 = rs.getDouble("impo_mon_ext_2");
	              h_impo_loc_aju = 0;
	              h_impo_loc_his = 0;
	              h_impo_mon_ext_1 = 0;
	              h_impo_mon_ext_2 = 0;
	           }
	           else {
	             h_impo_loc_his = rs.getDouble("impo_loc_his");
	             h_impo_loc_aju = rs.getDouble("impo_loc_aju");
	             h_impo_mon_ext_1 = rs.getDouble("impo_mon_ext_1");
	             h_impo_mon_ext_2 = rs.getDouble("impo_mon_ext_2");
	             d_impo_loc_aju = 0;
	             d_impo_loc_his = 0;
	             d_impo_mon_ext_1 = 0;
	             d_impo_mon_ext_2 = 0;
	           }

	           // Moneda Curso Legal
	           if (this.esMonedaLocal)
	           cargarRegistroConsultaMayor(datasetConsMayor,rs.getInt("oid_dco"),rs.getInt("oid_cco"),
	                                       MOVIMIENTOS,
	                                       ComproCab.getFormatoCompro(rs.getString("tc_ext"),
	                                                                  rs.getString("letra"),
	                                                                  new Integer(rs.getInt("lug_emi")),
	                                                                  new Integer(rs.getInt("nro_ext"))),
	                                       rs.getString("desc_tc"),
	                                       rs.getString("comentario"),
	                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
	                                       monedaCursoLegal,null,d_impo_loc_his,h_impo_loc_his,
	                                       rs.getDouble("impo_loc_his")*rs.getDouble("signo"),0,
	                                       getValoresCompo(rs));

	           else
	           if (this.esMonedaLocalAju)
	           cargarRegistroConsultaMayor(datasetConsMayor,rs.getInt("oid_dco"),rs.getInt("oid_cco"),
	                                       MOVIMIENTOS,
	                                       ComproCab.getFormatoCompro(rs.getString("tc_ext"),
	                                                                  rs.getString("letra"),
	                                                                  new Integer(rs.getInt("lug_emi")),
	                                                                  new Integer(rs.getInt("nro_ext"))),
	                                       rs.getString("desc_tc"),
	                                       rs.getString("comentario"),
	                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
	                                       monedaAjustada,null,
	                                       d_impo_loc_aju,h_impo_loc_aju,
	                                       rs.getDouble("impo_loc_aju")*rs.getDouble("signo"),0,
	                                       getValoresCompo(rs));
	           else
		       if (this.esMonedaExt1)
	           cargarRegistroConsultaMayor(datasetConsMayor,rs.getInt("oid_dco"),rs.getInt("oid_cco"),
	                                       MOVIMIENTOS,
	                                       ComproCab.getFormatoCompro(rs.getString("tc_ext"),
	                                                                  rs.getString("letra"),
	                                                                  new Integer(rs.getInt("lug_emi")),
	                                                                  new Integer(rs.getInt("nro_ext"))),
	                                       rs.getString("desc_tc"),
	                                       rs.getString("comentario"),
	                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
	                                       monedaExt1,null,
	                                       d_impo_mon_ext_1,h_impo_mon_ext_1,
	                                       rs.getDouble("impo_mon_ext_1")*rs.getDouble("signo"),0,
	                                       getValoresCompo(rs));
	           else
			   if (this.esMonedaExt2)	           
	           cargarRegistroConsultaMayor(datasetConsMayor,rs.getInt("oid_dco"),rs.getInt("oid_cco"),
	                                       MOVIMIENTOS,
	                                       ComproCab.getFormatoCompro(rs.getString("tc_ext"),
	                                                                  rs.getString("letra"),
	                                                                  new Integer(rs.getInt("lug_emi")),
	                                                                  new Integer(rs.getInt("nro_ext"))),
	                                       rs.getString("desc_tc"),
	                                       rs.getString("comentario"),
	                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
	                                       monedaExt2,null,
	                                       d_impo_mon_ext_2,h_impo_mon_ext_2,
	                                       rs.getDouble("impo_mon_ext_2")*rs.getDouble("signo"),0,
	                                       getValoresCompo(rs));


	           //


	         }

	         psConsMayor.close();
	         rs.close();
	         rs = null;
	         psConsMayor = null;
	    }
	        catch (SQLException ex) {
	          throw new BaseException(null,ex.getMessage());
	    }
	  
	  
  }
  
  
  

  private void traerMovimientosCuenta() throws BaseException {

    double d_impo_loc_his = 0;
    double h_impo_loc_his = 0;
    double d_impo_loc_aju = 0;
    double h_impo_loc_aju = 0;
    double d_impo_mon_ext_1 = 0;
    double h_impo_mon_ext_1 = 0;
    double d_impo_mon_ext_2 = 0;
    double h_impo_mon_ext_2 = 0;
    boolean firstRecordProcess = true;

    try {

        java.sql.ResultSet rs = null;
        DBConsultasContables consultasContables = new DBConsultasContables();
        consultasContables.setSesion(getSesion());
        PreparedStatement psConsMayor = null;
        int nroConsulta = 0;
        nroConsulta = DBConsultasContables.SELECT_BY_MOVIMIENTOS_CUENTA_AGRUP_COMPRO;
          
        psConsMayor = consultasContables.prepararSelect(
        		nroConsulta, getCondicionesQuery());
        	  
         rs = psConsMayor.executeQuery();

         while (rs.next()) {

           if (rs.getDouble("impo_loc_his")>0) {
              d_impo_loc_his = rs.getDouble("impo_loc_his");
              d_impo_loc_aju = rs.getDouble("impo_loc_aju");
              d_impo_mon_ext_1 = rs.getDouble("impo_mon_ext_1");
              d_impo_mon_ext_2 = rs.getDouble("impo_mon_ext_2");
              h_impo_loc_aju = 0;
              h_impo_loc_his = 0;
              h_impo_mon_ext_1 = 0;
              h_impo_mon_ext_2 = 0;
           }
           else {
             h_impo_loc_his = rs.getDouble("impo_loc_his")*-1;
             h_impo_loc_aju = rs.getDouble("impo_loc_aju")*-1;
             h_impo_mon_ext_1 = rs.getDouble("impo_mon_ext_1")*-1;
             h_impo_mon_ext_2 = rs.getDouble("impo_mon_ext_2")*-1;
             d_impo_loc_aju = 0;
             d_impo_loc_his = 0;
             d_impo_mon_ext_1 = 0;
             d_impo_mon_ext_2 = 0;
           }

           if (firstRecordProcess) {
             firstRecordProcess = false;
             cargarSaldosInicialesMovimientos();
           }

           // Moneda Curso Legal
           calAcumSaldoMonLoc.sumar(new Money(rs.getDouble("impo_loc_his")));
           calAcumSaldoMonLocAju.sumar(new Money(rs.getDouble("impo_loc_aju")));
           calAcumSaldoMonExt1.sumar(new Money(rs.getDouble("impo_mon_ext_1")));
           calAcumSaldoMonExt2.sumar(new Money(rs.getDouble("impo_mon_ext_2")));
   
           
           if (this.esMonedaLocal) {
           String descTC = "";
           try {
           descTC = rs.getString("desc_tc");
           }  catch(Exception e) {}
        	   
           cargarRegistroConsultaMayor(datasetConsMayor,rs.getInt("oid_dco"),rs.getInt("oid_cco"),
                                       MOVIMIENTOS,
                                       ComproCab.getFormatoCompro(rs.getString("tc_ext"),
                                                                  rs.getString("letra"),
                                                                  new Integer(rs.getInt("lug_emi")),
                                                                  new Integer(rs.getInt("nro_ext"))),
                                       descTC,
                                       rs.getString("comentario"),
                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
                                       monedaCursoLegal,null,d_impo_loc_his,h_impo_loc_his,
                                       rs.getDouble("impo_loc_his"),
                                       calAcumSaldoMonLoc.getResult(),
                                       getValoresCompo(rs));
           }
           else
           if (this.esMonedaLocalAju) {
               String descTC = "";
               try {
               descTC = rs.getString("desc_tc");
               }  catch(Exception e) {}
        	   
           cargarRegistroConsultaMayor(datasetConsMayor,rs.getInt("oid_dco"),rs.getInt("oid_cco"),
                                       MOVIMIENTOS,
                                       ComproCab.getFormatoCompro(rs.getString("tc_ext"),
                                                                  rs.getString("letra"),
                                                                  new Integer(rs.getInt("lug_emi")),
                                                                  new Integer(rs.getInt("nro_ext"))),
                                       descTC,
                                       rs.getString("comentario"),
                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
                                       monedaAjustada,null,d_impo_loc_aju,h_impo_loc_aju,
                                       rs.getDouble("impo_loc_aju"),
                                       calAcumSaldoMonLocAju.getResult(),
                                       getValoresCompo(rs));
           }
           else
           if (this.esMonedaExt1) {
           // Moneda Extranjera 1
               String descTC = "";
               try {
               descTC = rs.getString("desc_tc");
               }  catch(Exception e) {}
        	   
           cargarRegistroConsultaMayor(datasetConsMayor,rs.getInt("oid_dco"),rs.getInt("oid_cco"),
                                       MOVIMIENTOS,
                                       ComproCab.getFormatoCompro(rs.getString("tc_ext"),
                                                                  rs.getString("letra"),
                                                                  new Integer(rs.getInt("lug_emi")),
                                                                  new Integer(rs.getInt("nro_ext"))),
                                       descTC,
                                       rs.getString("comentario"),
                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
                                       monedaExt1,null,d_impo_mon_ext_1,h_impo_mon_ext_1,
                                       rs.getDouble("impo_mon_ext_1"),
                                       calAcumSaldoMonExt1.getResult(),
                                       getValoresCompo(rs));
           }
           else
           if (this.esMonedaExt2) {
           // Moneda Extranjera 2
               String descTC = "";
               try {
               descTC = rs.getString("desc_tc");
               }  catch(Exception e) {}
        	   
           cargarRegistroConsultaMayor(datasetConsMayor,rs.getInt("oid_dco"),rs.getInt("oid_cco"),
                                       MOVIMIENTOS,
                                       ComproCab.getFormatoCompro(rs.getString("tc_ext"),
                                                                  rs.getString("letra"),
                                                                  new Integer(rs.getInt("lug_emi")),
                                                                  new Integer(rs.getInt("nro_ext"))),
                                       descTC,
                                       rs.getString("comentario"),
                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
                                       monedaExt2,null,d_impo_mon_ext_2,h_impo_mon_ext_2,
                                       rs.getDouble("impo_mon_ext_2"),
                                       calAcumSaldoMonExt2.getResult(),
                                       getValoresCompo(rs));
           }


           //


         }

         psConsMayor.close();
         rs.close();
         rs = null;
         psConsMayor = null;
    }
        catch (SQLException ex) {
          throw new BaseException(null,ex.getMessage());
    }
  }
  
  private void traerMovimientosCuentaPorTC() throws BaseException {

	    double d_impo_loc_his = 0;
	    double h_impo_loc_his = 0;
	    double d_impo_loc_aju = 0;
	    double h_impo_loc_aju = 0;
	    double d_impo_mon_ext_1 = 0;
	    double h_impo_mon_ext_1 = 0;
	    double d_impo_mon_ext_2 = 0;
	    double h_impo_mon_ext_2 = 0;
	    boolean firstRecordProcess = true;

	    try {

	        java.sql.ResultSet rs = null;
	        DBConsultasContables consultasContables = new DBConsultasContables();
	        consultasContables.setSesion(getSesion());
	        PreparedStatement psConsMayor = null;
	        int nroConsulta = DBConsultasContables.SELECT_BY_MOVIMIENTOS_CUENTA_AGRUP_TC;          
	          
	        psConsMayor = consultasContables.prepararSelect(nroConsulta, getCondicionesQuery());
	        	  
	         rs = psConsMayor.executeQuery();

	         while (rs.next()) {

	           if (rs.getDouble("impo_loc_his")>0) {
	              d_impo_loc_his = rs.getDouble("impo_loc_his");
	              d_impo_loc_aju = rs.getDouble("impo_loc_aju");
	              d_impo_mon_ext_1 = rs.getDouble("impo_mon_ext_1");
	              d_impo_mon_ext_2 = rs.getDouble("impo_mon_ext_2");
	              h_impo_loc_aju = 0;
	              h_impo_loc_his = 0;
	              h_impo_mon_ext_1 = 0;
	              h_impo_mon_ext_2 = 0;
	           }
	           else {
	             h_impo_loc_his = rs.getDouble("impo_loc_his")*-1;
	             h_impo_loc_aju = rs.getDouble("impo_loc_aju")*-1;
	             h_impo_mon_ext_1 = rs.getDouble("impo_mon_ext_1")*-1;
	             h_impo_mon_ext_2 = rs.getDouble("impo_mon_ext_2")*-1;
	             d_impo_loc_aju = 0;
	             d_impo_loc_his = 0;
	             d_impo_mon_ext_1 = 0;
	             d_impo_mon_ext_2 = 0;
	           }

	           if (firstRecordProcess) {
	             firstRecordProcess = false;
	             cargarSaldosInicialesMovimientos();
	           }

	           // Moneda Curso Legal
	           calAcumSaldoMonLoc.sumar(new Money(rs.getDouble("impo_loc_his")));
	           calAcumSaldoMonLocAju.sumar(new Money(rs.getDouble("impo_loc_aju")));
	           calAcumSaldoMonExt1.sumar(new Money(rs.getDouble("impo_mon_ext_1")));
	           calAcumSaldoMonExt2.sumar(new Money(rs.getDouble("impo_mon_ext_2")));
	   
	           if (this.esMonedaLocal)
	           cargarRegistroConsultaMayor(datasetConsMayor,0,0,
	                                       MOVIMIENTOS,
	                                       rs.getString("descripcion"),
	                                       "",
	                                       "",
	                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
	                                       monedaCursoLegal,null,d_impo_loc_his,h_impo_loc_his,
	                                       rs.getDouble("impo_loc_his"),
	                                       calAcumSaldoMonLoc.getResult(),
	                                       getValoresCompo(rs));
	           else
	           if (this.esMonedaLocalAju)
	           cargarRegistroConsultaMayor(datasetConsMayor,0,0,
	                                       MOVIMIENTOS,
	                                       rs.getString("descripcion"),
	                                       "",
	                                       "",
	                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
	                                       monedaAjustada,null,d_impo_loc_aju,h_impo_loc_aju,
	                                       rs.getDouble("impo_loc_aju"),
	                                       calAcumSaldoMonLocAju.getResult(),
	                                       getValoresCompo(rs));
	           else
	           if (this.esMonedaExt1)
	           // Moneda Extranjera 1
	           cargarRegistroConsultaMayor(datasetConsMayor,0,0,
	                                       MOVIMIENTOS,
	                                       rs.getString("descripcion"),
	                                       "",
	                                       "",
	                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
	                                       monedaExt1,null,d_impo_mon_ext_1,h_impo_mon_ext_1,
	                                       rs.getDouble("impo_mon_ext_1"),
	                                       calAcumSaldoMonExt1.getResult(),
	                                       getValoresCompo(rs));
	           else
	           if (this.esMonedaExt2)
	           // Moneda Extranjera 2
	           cargarRegistroConsultaMayor(datasetConsMayor,0,0,
	                                       MOVIMIENTOS,
	                                       rs.getString("descripcion"),
	                                       "",
	                                       "",
	                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
	                                       monedaExt2,null,d_impo_mon_ext_2,h_impo_mon_ext_2,
	                                       rs.getDouble("impo_mon_ext_2"),
	                                       calAcumSaldoMonExt2.getResult(),
	                                       getValoresCompo(rs));


	           //


	         }

	         psConsMayor.close();
	         rs.close();
	         rs = null;
	         psConsMayor = null;
	    }
	        catch (SQLException ex) {
	          throw new BaseException(null,ex.getMessage());
	    }
	  }
  

  private IDataSet getDataSetConsultaMayor() throws BaseException {
    IDataSet dataset = new TDataSet();
    dataset.create("TConsultaMayor");
    dataset.fieldDef(new Field("oid_dco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo_mov", Field.STRING, 30));
    dataset.fieldDef(new Field("comprobante",Field.STRING, 30));
    dataset.fieldDef(new Field("desc_tc",Field.STRING, 100));
    dataset.fieldDef(new Field("comentario",Field.STRING, 255));
    dataset.fieldDef(new Field("imputac",Field.DATE, 0));
    dataset.fieldDef(new Field("moneda",Field.STRING, 30));
    dataset.fieldDef(new Field("saldo_inicial",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("debe",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("haber",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("saldo",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("saldo_acum",Field.CURRENCY, 0));
    
    if ((!(tipoConsulta.equals(TIPO_CONS_COMPRO))) &&
       (!(tipoConsulta.equals(TIPO_CONS_TC))))
    	{

    	// Agregar los Componentes Correspondientes a la cuenta
    	Iterator iterCompoConAux = listaComponentes.iterator();
    	while (iterCompoConAux.hasNext()) {
    		Componente componente = (Componente) iterCompoConAux.next();
    		dataset.fieldDef(new Field("oid_co_"+componente.getOIDInteger().toString(),Field.CURRENCY, 0));
    		dataset.fieldDef(new Field("desc_co_"+componente.getOIDInteger().toString(),Field.STRING, 1000));
    	}
    	
    }
    return dataset;
  }

  private IDataSet getDataSetFiltro() {
    IDataSet dataset = new TDataSet();
    dataset.create("TFiltro");
    dataset.fieldDef(new Field("filtro", Field.STRING, 255));
    return dataset;
  }
  
  private IDataSet getDataSetSaldos() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TSaldoConsulta");
	    dataset.fieldDef(new Field("oid_cuenta", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_cuenta", Field.STRING, 50));
	    dataset.fieldDef(new Field("cuenta", Field.STRING, 255));
	    dataset.fieldDef(new Field("saldo_inicial", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("debe", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("haber", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("saldo_final", Field.CURRENCY, 0));
	    return dataset;
  }
  

  private void cargarRegistroFiltro(IDataSet dataset,
                                    String filtro) throws BaseException {
    dataset.append();
    dataset.fieldValue("filtro", filtro);
  }

  private Hashtable getValoresCompo(java.sql.ResultSet rs) throws BaseException,SQLException {
    Hashtable valoresCompoEnCero = new Hashtable();
    
    if ((!(tipoConsulta.equals(TIPO_CONS_COMPRO))) && (!(tipoConsulta.equals(TIPO_CONS_TC)))) {
    
    	Iterator iterCompoConAux = listaComponentes.iterator();
    	while (iterCompoConAux.hasNext()) {
    		Componente componente = (Componente) iterCompoConAux.next();
    		IObjetoLogico objLog = componente.getValorCompo(rs.getInt(componente.getCampoFisicoAnaImp()));
    		if (objLog!=null)
    			valoresCompoEnCero.put(componente.getOIDInteger(),objLog);
    		else
    			valoresCompoEnCero.put(componente.getOIDInteger(),"");
    	}
    	
    }
    return valoresCompoEnCero;
  }

  private Hashtable getValoresCompoEnSaldoInicial() throws BaseException {
    Hashtable valoresCompoEnCero = new Hashtable();
    Iterator iterCompoConAux = listaComponentes.iterator();
    while (iterCompoConAux.hasNext()) {
      Componente componente = (Componente) iterCompoConAux.next();
      valoresCompoEnCero.put(componente.getOIDInteger(),new Integer(-1));
    }
    return valoresCompoEnCero;
  }

  private Hashtable getValoresCompoEnSaldoFinal() throws BaseException {
    Hashtable valoresCompoEnCero = new Hashtable();
    Iterator iterCompoConAux = listaComponentes.iterator();
    while (iterCompoConAux.hasNext()) {
      Componente componente = (Componente) iterCompoConAux.next();
      valoresCompoEnCero.put(componente.getOIDInteger(),new Integer(-2));
    }
    return valoresCompoEnCero;
  }



  private void cargarRegistroConsultaMayor(IDataSet dataset,
                                           int oid_dco,
                                           int oid_cco,
                                           String tipoMov,
                                           String comprobante,
                                           String descTC,
                                           String comentario,
                                           String imputac,
                                           String moneda,
                                           Double saldoInicial,
                                           double debe,
                                           double haber,
                                           double saldo,
                                           double saldoAcum,
                                           Hashtable valoresCompo) throws BaseException {
	  
	 if (this.esMonedaLocal) {
		 if (debe!=0)
			 calAcumDebeMonLoc.sumar(new Money(debe));
		 else
			 calAcumHaberMonLoc.sumar(new Money(haber));
	 }
	 else
		 if (this.esMonedaLocalAju) {
			 if (debe!=0)
				 calAcumDebeMonLocAju.sumar(new Money(debe));
			 else
				 calAcumHaberMonLocAju.sumar(new Money(haber));
		 }
		 else
			 if (this.esMonedaExt1) {
				 if (debe!=0)
					 calAcumDebeMonExt1.sumar(new Money(debe));
				 else
					 calAcumDebeMonExt1.sumar(new Money(haber));
			 }
			 else
				 if (this.esMonedaExt2) {
					 if (debe!=0)
						 calAcumDebeMonExt2.sumar(new Money(debe));
					 else
						 calAcumDebeMonExt2.sumar(new Money(haber));
				 }
	 
	  
    dataset.append();
    dataset.fieldValue("oid_dco", oid_dco);
    dataset.fieldValue("oid_cco", oid_cco);
    dataset.fieldValue("tipo_mov", tipoMov);
    dataset.fieldValue("comprobante",comprobante);
    dataset.fieldValue("desc_tc",descTC);
    if (comentario == null)
       dataset.fieldValue("comentario","");
    else
       dataset.fieldValue("comentario",comentario);
    dataset.fieldValue("imputac",imputac);
    dataset.fieldValue("moneda",moneda);
    if (saldoInicial!=null)
    	dataset.fieldValue("saldo_inicial",saldoInicial);
    else
    	dataset.fieldValue("saldo_inicial","");
    if (debe != 0)
    	dataset.fieldValue("debe",debe);
    else
    	dataset.fieldValue("debe","");
    if (haber!=0)
    	dataset.fieldValue("haber",haber);
    else
    	dataset.fieldValue("haber","");
    if (saldo!=0)
    	dataset.fieldValue("saldo",saldo);
    else
    	dataset.fieldValue("saldo","");
    dataset.fieldValue("saldo_acum",saldoAcum);

    if ((!(tipoConsulta.equals(TIPO_CONS_COMPRO))) && (!(tipoConsulta.equals(TIPO_CONS_TC)))) {
    
    	Iterator iterCompoConAux = listaComponentes.iterator();
    	while (iterCompoConAux.hasNext()) {
    		Componente componente = (Componente) iterCompoConAux.next();
    		
    		
    		Object valorCompo = valoresCompo.get(componente.getOIDInteger());
    		if (valorCompo instanceof String) {
    			dataset.fieldValue("oid_co_"+componente.getOIDInteger().toString(),0);
    			dataset.fieldValue("desc_co_"+componente.getOIDInteger().toString(),(String)valorCompo);
    		}
    		else if (valorCompo instanceof Integer) {
    			dataset.fieldValue("oid_co_"+componente.getOIDInteger().toString(),(Integer)valorCompo);
    			dataset.fieldValue("desc_co_"+componente.getOIDInteger().toString(),(Integer)valorCompo);
    		}
    		else if (valorCompo instanceof IObjetoLogico) {	
    			dataset.fieldValue("oid_co_"+componente.getOIDInteger().toString(),((IObjetoLogico)valorCompo).getOIDInteger());
    			dataset.fieldValue("desc_co_"+componente.getOIDInteger().toString(),((IObjetoLogico)valorCompo).getDescripcion());
    		}
    		else {
    			dataset.fieldValue("oid_co_"+componente.getOIDInteger().toString(),0); 
    			dataset.fieldValue("desc_co_"+componente.getOIDInteger().toString(),"");
    		}
    	}
    }

  }

  private void enviarDataSets() throws BaseException {
    writeCliente(datasetConsMayor);
    writeCliente(dataSetFiltro);
    writeCliente(datasetSaldos);
  }

}
