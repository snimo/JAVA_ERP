package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.srn.erp.general.bm.Cotizacion;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.bm.TipoCambio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCotizacion extends DBObjetoPersistente {

  public static final String OID_COTIZACION = "oid_cotizacion";
  public static final String FECHA_VIG = "fecha_vig";
  public static final String OID_TIPO_CAMBIO = "oid_tipo_cambio";
  public static final String COTIZACION = "cotizacion";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String ACTIVO = "activo";
  public static final String CARATULA = "CARATULA_COTIZ_CAB";
  public static final String FOOTER = "FOOTER_COTIZ_CAB";

  public static final int SELECT_BY_FECHA_TIPO_MON = 100;
  public static final int SELECT_BY_FECHA_TIPO = 101;
  

  public DBCotizacion() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COTIZACION = 1;
    final int FECHA_VIG = 2;
    final int OID_TIPO_CAMBIO = 3;
    final int COTIZACION = 4;
    final int OID_MONEDA = 5;
    final int ACTIVO = 6;

    Cotizacion pers = (Cotizacion) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geCotizacion "+
                     " ( "+
                      "OID_COTIZACION,"+
                      "FECHA_VIG,"+
                      "OID_TIPO_CAMBIO,"+
                      "COTIZACION,"+
                      "OID_MONEDA,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COTIZACION,pers.getOID());
    qInsert.setDate(FECHA_VIG,new java.sql.Date(pers.getFechavig().getTime()));
    qInsert.setInt(OID_TIPO_CAMBIO,pers.getTipocambio().getOID());
    qInsert.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int FECHA_VIG = 1;
    final int OID_TIPO_CAMBIO = 2;
    final int COTIZACION = 3;
    final int OID_MONEDA = 4;
    final int ACTIVO = 5;
    final int OID_COTIZACION = 6;

    Cotizacion pers = (Cotizacion) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geCotizacion set "+
              "fecha_vig=?"+
              ",oid_tipo_cambio=?"+
              ",cotizacion=?"+
              ",oid_moneda=?"+
              ",activo=?"+
                 " where " +
                 " oid_cotizacion=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COTIZACION,pers.getOID());
    qUpdate.setDate(FECHA_VIG,new java.sql.Date(pers.getFechavig().getTime()));
    qUpdate.setInt(OID_TIPO_CAMBIO,pers.getTipocambio().getOID());
    qUpdate.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COTIZACION = 1;
    Cotizacion pers = (Cotizacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geCotizacion "+
                     " set activo=0 " +
                     " where " +
                     " oid_cotizacion=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COTIZACION, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COTIZACION = 1;
    Cotizacion pers = (Cotizacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geCotizacion "+
                     " set activo=1 " +
                     " where " +
                     " oid_cotizacion=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COTIZACION, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
    PreparedStatement ps = null;
    switch (aSelect) {
      case IDBObjetoPersistente.SELECT_BY_OID: {
        ps = this.selectByOID(aCondiciones);
        break;
      }
      case IDBObjetoPersistente.SELECT_BY_CODIGO: {
        ps = this.selectByCodigo(aCondiciones);
        break;
      }
      case IDBObjetoPersistente.SELECT_ALL_HELP: {
        ps = this.selectAllHelp(aCondiciones);
        break;
      }
      case SELECT_BY_FECHA_TIPO_MON: {
        ps = this.selectByFechaTipoMon(aCondiciones);
        break;
      }
      case SELECT_BY_FECHA_TIPO: {
        ps = this.selectByFechaTipo(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COTIZACION = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geCotizacion ");
    textSQL.append(" WHERE oid_cotizacion = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COTIZACION, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geCotizacion ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByFechaTipoMon(Object aCondiciones) throws BaseException, SQLException {

    Map mapaDatos = (HashTableDatos) aCondiciones;
    Date fecha = (Date)mapaDatos.get(DBCotizacion.FECHA_VIG);
    TipoCambio tipoCambio = (TipoCambio)mapaDatos.get(TipoCambio.NICKNAME);
    Moneda moneda = (Moneda)mapaDatos.get(Moneda.NICKNAME);

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geCotizacion ");
    textSQL.append(" WHERE  fecha_vig=? and oid_tipo_cambio=? and oid_moneda= ?");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setDate(1,new java.sql.Date(fecha.getTime()));
    querySelect.setInt(2,tipoCambio.getOID());
    querySelect.setInt(3,moneda.getOID());

    return querySelect;

  }
  
  private PreparedStatement selectByFechaTipo(Object aCondiciones) throws BaseException, SQLException {

    Map mapaDatos = (HashTableDatos) aCondiciones;
    Date fecha = (Date)mapaDatos.get(DBCotizacion.FECHA_VIG);
    TipoCambio tipoCambio = (TipoCambio)mapaDatos.get(TipoCambio.NICKNAME);

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geCotizacion ");
    textSQL.append(" WHERE  fecha_vig=? and oid_tipo_cambio=?");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setDate(1,new java.sql.Date(fecha.getTime()));
    querySelect.setInt(2,tipoCambio.getOID());
    return querySelect;

  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cotizacion oid, codigo,  descripcion ,activo ");
    textSQL.append(" from geCotizacion");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static Cotizacion getCotizacionByFechaTipoMoneda(Date fechaVig,
                                                          TipoCambio tipoCambio,
                                                          Moneda moneda,
                                                          ISesion aSesion)
                                                          throws BaseException {
    Map mapaDatos = new HashTableDatos();
    mapaDatos.put(DBCotizacion.FECHA_VIG, fechaVig);
    mapaDatos.put(TipoCambio.NICKNAME,tipoCambio);
    mapaDatos.put(Moneda.NICKNAME,moneda);

    return (Cotizacion) ObjetoLogico.getObjects(Cotizacion.NICKNAME,
                                                DBCotizacion.SELECT_BY_FECHA_TIPO_MON,
                                                mapaDatos,
                                                new ObjetoObservado(),
                                                aSesion);

  }
  
  public static List getCotizacionesByFechayTipoCambio(Date fechaVig,
  																										 TipoCambio tipoCambio,	
      ISesion aSesion) throws BaseException {
    Map mapaDatos = new HashTableDatos();
    mapaDatos.put(DBCotizacion.FECHA_VIG, fechaVig);
    mapaDatos.put(TipoCambio.NICKNAME,tipoCambio);
  	
  	return (List) ObjetoLogico.getObjects(Cotizacion.NICKNAME,
         DBCotizacion.SELECT_BY_FECHA_TIPO,
         mapaDatos,
         new ListObserver(),
         aSesion);
  	
  }
  


}
