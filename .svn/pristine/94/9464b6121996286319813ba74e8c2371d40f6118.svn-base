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
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ConsultaMayorTipoCompro extends Operation  {

  private Cuenta cuenta;
  private java.util.Date fecImpuDesde;
  private java.util.Date fecImpuHasta;
  private Hashtable valoresDeComponentes = new Hashtable();
  private Integer cantComponentes = null;
  private final String SALDO_INICIAL = "Saldo Inicial";
  private final String MOVIMIENTOS   = "Movimientos";
  private final String SALDO_FINAL   = "Saldo Final";
  private IDataSet  datasetConsMayor;
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

  public ConsultaMayorTipoCompro() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    init();
    tratarParametros(mapaDatos);
    traerSaldoInicial();
    traerMovimientosCuenta();
    traerSaldoFinal();
    enviarDataSets();
  }

  public void init() throws BaseException {
    monedaCursoLegal = Moneda.getMonedaCursoLegal(getSesion()).getDescripcion();
    monedaAjustada = Moneda.getMonedaCursoLegal(getSesion()).getDescripcion()+" (Aju)";
    monedaExt1 = Moneda.getMonedaExt1(getSesion()).getDescripcion();
    monedaExt2 = Moneda.getMonedaExt2(getSesion()).getDescripcion();
  }

  private void tratarParametros(MapDatos mapaDatos) throws BaseException {
    cuenta          = Cuenta.findByOid(mapaDatos.getInteger("oid_ana"),getSesion());
    listaComponentes = cuenta.getComponentesConAux();
    fecImpuDesde    = mapaDatos.getDate("fecDesde");
    fecImpuHasta    = mapaDatos.getDate("fecHasta");
    cantComponentes = mapaDatos.getInteger("cant_compo");

    filtro = new StringBuffer();
    filtro.append(cuenta.getCodigo()+" - "+cuenta.getDescripcion()+"  ");
    filtro.append(" Movimientos del "+Fecha.getddmmyyyy(fecImpuDesde)+" al "+Fecha.getddmmyyyy(fecImpuHasta)+"  ");

    for (int i=1;i<=cantComponentes.intValue();++i) {
      Integer oidComponente = mapaDatos.getInteger("oid_compo_"+new Integer(i).toString());
      Integer oidValCompo   = mapaDatos.getInteger("oid_val_compo_"+new Integer(i).toString());
      Componente componente = Componente.findByOid(oidComponente,getSesion());
      IObjetoLogico valorCompo = componente.getValorCompo(oidValCompo);
      valoresDeComponentes.put(componente,valorCompo);
      filtro.append(componente.getDescripcion()+": "+valorCompo.getCodigo()+"-"+valorCompo.getDescripcion()+"  ");
    }
    cargarRegistroFiltro(dataSetFiltro,filtro.toString());
    datasetConsMayor = getDataSetConsultaMayor();
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
  }

  private void traerSaldoFinal() throws BaseException {

    ImportesContables importesContables =
        cuenta.getSaldoFinal(fecImpuHasta,valoresDeComponentes);

    double debe     = 0;
    double haber    = 0;

    if (importesContables.getImpoMonLoc().doubleValue()>0) {
      debe  = Math.abs(importesContables.getImpoMonLoc().doubleValue());
      haber = 0;
    }
    else {
      debe  = 0;
      haber = Math.abs(importesContables.getImpoMonLoc().doubleValue());
    }

    cargarRegistroConsultaMayor(datasetConsMayor,0,-1,
                                SALDO_FINAL,
                                SALDO_FINAL,
                                monedaCursoLegal,
                                debe,haber,0,getValoresCompoEnSaldoFinal());


    if (importesContables.getImpoMonLocAju().doubleValue()>0) {
      debe  = Math.abs(importesContables.getImpoMonLocAju().doubleValue());
      haber = 0;
    }
    else {
      debe  = 0;
      haber = Math.abs(importesContables.getImpoMonLocAju().doubleValue());
    }

    cargarRegistroConsultaMayor(datasetConsMayor,0,-1,
                                SALDO_FINAL,
                                SALDO_FINAL,
                                monedaAjustada,
                                debe,haber,0,getValoresCompoEnSaldoFinal());

    if (importesContables.getImpoMonExt1().doubleValue()>0) {
      debe  = Math.abs(importesContables.getImpoMonExt1().doubleValue());
      haber = 0;
    }
    else {
      debe  = 0;
      haber = Math.abs(importesContables.getImpoMonExt1().doubleValue());
    }

    cargarRegistroConsultaMayor(datasetConsMayor,0,-1,
                                SALDO_FINAL,
                                SALDO_FINAL,
                                monedaExt1,
                                debe,haber,0,getValoresCompoEnSaldoFinal());

    if (importesContables.getImpoMonExt2().doubleValue()>0) {
      debe  = Math.abs(importesContables.getImpoMonExt2().doubleValue());
      haber = 0;
    }
    else {
      debe  = 0;
      haber = Math.abs(importesContables.getImpoMonExt2().doubleValue());
    }

    cargarRegistroConsultaMayor(datasetConsMayor,0,-1,
                                SALDO_FINAL,
                                SALDO_FINAL,
                                monedaExt2,
                                debe,haber,0,getValoresCompoEnSaldoFinal());

  }


  private void cargarSaldosInicialesMovimientos() throws BaseException {
    cargarRegistroConsultaMayor(datasetConsMayor,0,-2,
                                   MOVIMIENTOS,
                                   SALDO_INICIAL,
                                   monedaCursoLegal,
                                   (saldoInicialMonedaLocal.doubleValue()>0?saldoInicialMonedaLocal.doubleValue():0.0),
                                   (saldoInicialMonedaLocal.doubleValue()<0?Math.abs(saldoInicialMonedaLocal.doubleValue()):0.0),
                                   saldoInicialMonedaLocal.doubleValue(),getValoresCompoEnSaldoInicial());
    cargarRegistroConsultaMayor(datasetConsMayor,0,-2,
                                   MOVIMIENTOS,
                                   SALDO_INICIAL,
                                   monedaAjustada,
                                   (saldoInicialMonedaAju.doubleValue()>0?saldoInicialMonedaAju.doubleValue():0.0),
                                   (saldoInicialMonedaAju.doubleValue()<0?Math.abs(saldoInicialMonedaAju.doubleValue()):0.0),
                                   saldoInicialMonedaAju.doubleValue(),getValoresCompoEnSaldoInicial());
     cargarRegistroConsultaMayor(datasetConsMayor,0,-2,
                                 MOVIMIENTOS,
                                 SALDO_INICIAL,
                                 monedaExt1,
                                 (saldoInicialMonedaExt1.doubleValue()>0?saldoInicialMonedaExt1.doubleValue():0.0),
                                 (saldoInicialMonedaExt1.doubleValue()<0?Math.abs(saldoInicialMonedaExt1.doubleValue()):0.0),
                                 saldoInicialMonedaExt1.doubleValue(),getValoresCompoEnSaldoInicial());
     cargarRegistroConsultaMayor(datasetConsMayor,0,-2,
                                 MOVIMIENTOS,
                                 SALDO_INICIAL,
                                 monedaExt2,
                                 (saldoInicialMonedaExt2.doubleValue()>0?saldoInicialMonedaExt2.doubleValue():0.0),
                                 (saldoInicialMonedaExt2.doubleValue()<0?Math.abs(saldoInicialMonedaExt2.doubleValue()):0.0),
                                 saldoInicialMonedaExt2.doubleValue(),getValoresCompoEnSaldoInicial());
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
          PreparedStatement psConsMayor = consultasContables.prepararSelect(
              DBConsultasContables.SELECT_BY_MOVIMIENTOS_CUENTA_POR_TC, getCondicionesQuery());
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

           if (firstRecordProcess) {
             firstRecordProcess = false;
             cargarSaldosInicialesMovimientos();
           }

           // Moneda Curso Legal
           cargarRegistroConsultaMayor(datasetConsMayor,rs.getInt("oid_diario"),rs.getInt("oid_tc"),
                                       MOVIMIENTOS,
                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
                                       monedaCursoLegal,d_impo_loc_his,h_impo_loc_his,
                                       rs.getDouble("impo_loc_his")*rs.getDouble("signo"),
                                       getValoresCompo(rs));

           // Moneda Ajustada
           cargarRegistroConsultaMayor(datasetConsMayor,rs.getInt("oid_diario"),rs.getInt("oid_tc"),
                                       MOVIMIENTOS,
                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
                                       monedaAjustada,d_impo_loc_aju,h_impo_loc_aju,
                                       rs.getDouble("impo_loc_aju")*rs.getDouble("signo"),
                                       getValoresCompo(rs));

           // Moneda Extranjera 1
           cargarRegistroConsultaMayor(datasetConsMayor,rs.getInt("oid_diario"),rs.getInt("oid_tc"),
                                       MOVIMIENTOS,
                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
                                       monedaExt1,d_impo_mon_ext_1,h_impo_mon_ext_1,
                                       rs.getDouble("impo_mon_ext_1")*rs.getDouble("signo"),
                                       getValoresCompo(rs));

           // Moneda Extranjera 2
           cargarRegistroConsultaMayor(datasetConsMayor,rs.getInt("oid_diario"),rs.getInt("oid_tc"),
                                       MOVIMIENTOS,
                                       Fecha.getddmmyyyy(rs.getDate("imputac")),
                                       monedaExt2,d_impo_mon_ext_2,h_impo_mon_ext_2,
                                       rs.getDouble("impo_mon_ext_2")*rs.getDouble("signo"),
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
    dataset.fieldDef(new Field("oid_diario", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("tipo_mov", Field.STRING, 30));
    dataset.fieldDef(new Field("imputac",Field.STRING, 20));
    dataset.fieldDef(new Field("moneda",Field.STRING, 30));
    dataset.fieldDef(new Field("debe",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("haber",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("saldo",Field.CURRENCY, 0));

    // Agregar los Componentes Correspondientes a la cuenta
    Iterator iterCompoConAux = listaComponentes.iterator();
    while (iterCompoConAux.hasNext()) {
      Componente componente = (Componente) iterCompoConAux.next();
      dataset.fieldDef(new Field("oid_co_"+componente.getOIDInteger().toString(),Field.CURRENCY, 0));
    }
    return dataset;
  }

  private IDataSet getDataSetFiltro() {
    IDataSet dataset = new TDataSet();
    dataset.create("TFiltro");
    dataset.fieldDef(new Field("filtro", Field.STRING, 255));
    return dataset;
  }

  private void cargarRegistroFiltro(IDataSet dataset,
                                    String filtro) throws BaseException {
    dataset.append();
    dataset.fieldValue("filtro", filtro);
  }

  private Hashtable getValoresCompo(java.sql.ResultSet rs) throws BaseException,SQLException {
    Hashtable valoresCompoEnCero = new Hashtable();
    Iterator iterCompoConAux = listaComponentes.iterator();
    while (iterCompoConAux.hasNext()) {
      Componente componente = (Componente) iterCompoConAux.next();
      valoresCompoEnCero.put(componente.getOIDInteger(),new Integer(rs.getInt(componente.getCampoFisicoAnaImp())));
    }
    return valoresCompoEnCero;
  }

  private Hashtable getValoresCompoEnCero() throws BaseException {
    Hashtable valoresCompoEnCero = new Hashtable();
    Iterator iterCompoConAux = listaComponentes.iterator();
    while (iterCompoConAux.hasNext()) {
      Componente componente = (Componente) iterCompoConAux.next();
      valoresCompoEnCero.put(componente.getOIDInteger(),new Integer(0));
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
                                           int oidDiario,
                                           int oidTC,
                                           String tipoMov,
                                           String imputac,
                                           String moneda,
                                           double debe,
                                           double haber,
                                           double saldo,
                                           Hashtable valoresCompo) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_diario", oidDiario);
    dataset.fieldValue("oid_tc", oidTC);
    dataset.fieldValue("tipo_mov", tipoMov);
    dataset.fieldValue("imputac",imputac);
    dataset.fieldValue("moneda",moneda);
    dataset.fieldValue("debe",debe);
    dataset.fieldValue("haber",haber);
    dataset.fieldValue("saldo",saldo);

    Iterator iterCompoConAux = listaComponentes.iterator();
    while (iterCompoConAux.hasNext()) {
      Componente componente = (Componente) iterCompoConAux.next();
      dataset.fieldValue("oid_co_"+componente.getOIDInteger().toString(),(Integer)valoresCompo.get(componente.getOIDInteger()));
    }

  }

  private void enviarDataSets() throws BaseException {
    writeCliente(datasetConsMayor);
    writeCliente(dataSetFiltro);
  }

}
