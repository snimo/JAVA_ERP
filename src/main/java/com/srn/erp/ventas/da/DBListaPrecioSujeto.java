package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.ListaPrecioSujeto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBListaPrecioSujeto extends DBObjetoPersistente {

  public static final String OID_LP_SUJ = "oid_lp_suj";
  public static final String FEC_DESDE = "fec_desde";
  public static final String FEC_HASTA = "fec_hasta";
  public static final String OID_SUJETO = "oid_sujeto";
  public static final String ACTIVO = "activo";
  public static final String OID_PRECIO_CAB = "oid_precio_cab";

  public static final int SELECT_BY_SUJETO = 100;
  public static final int SELECT_BY_SUJETO_FECHA = 101;

  public DBListaPrecioSujeto() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_LP_SUJ = 1;
    final int FEC_DESDE = 2;
    final int FEC_HASTA = 3;
    final int OID_SUJETO = 4;
    final int ACTIVO = 5;
    final int OID_PRECIO_CAB = 6;

    ListaPrecioSujeto pers = (ListaPrecioSujeto) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veListaPrecioSuj "+
                     " ( "+
                      "OID_LP_SUJ,"+
                      "FEC_DESDE,"+
                      "FEC_HASTA,"+
                      "OID_SUJETO,"+
                      "ACTIVO,"+
                      "OID_PRECIO_CAB)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_LP_SUJ,pers.getOID());
    qInsert.setDate(FEC_DESDE,new java.sql.Date(pers.getFecha_desde().getTime()));
    qInsert.setDate(FEC_HASTA,new java.sql.Date(pers.getFecha_hasta().getTime()));
    qInsert.setInt(OID_SUJETO,pers.getSujeto().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_PRECIO_CAB,pers.getLista_precio().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int FEC_DESDE = 1;
    final int FEC_HASTA = 2;
    final int OID_SUJETO = 3;
    final int ACTIVO = 4;
    final int OID_PRECIO_CAB = 5;
    final int OID_LP_SUJ = 6;

    ListaPrecioSujeto pers = (ListaPrecioSujeto) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veListaPrecioSuj set "+
              "fec_desde=?"+
              ",fec_hasta=?"+
              ",oid_sujeto=?"+
              ",activo=?"+
              ",oid_precio_cab=?"+
                 " where " +
                 " oid_lp_suj=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_LP_SUJ,pers.getOID());
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFecha_desde().getTime()));
    qUpdate.setDate(FEC_HASTA,new java.sql.Date(pers.getFecha_hasta().getTime()));
    qUpdate.setInt(OID_SUJETO,pers.getSujeto().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_PRECIO_CAB,pers.getLista_precio().getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_LP_SUJ = 1;
    ListaPrecioSujeto pers = (ListaPrecioSujeto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veListaPrecioSuj "+
                     " set activo=0 " +
                     " where " +
                     " oid_lp_suj=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_LP_SUJ, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_LP_SUJ = 1;
    ListaPrecioSujeto pers = (ListaPrecioSujeto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veListaPrecioSuj "+
                     " set activo=1 " +
                     " where " +
                     " oid_lp_suj=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_LP_SUJ, pers.getOID());
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
      case SELECT_BY_SUJETO: {
        ps = this.selectBySujeto(aCondiciones);
        break;
      }
      case SELECT_BY_SUJETO_FECHA: {
        ps = this.selectBySujetoFecha(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_LP_SUJ = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veListaPrecioSuj ");
    textSQL.append(" WHERE oid_lp_suj = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_LP_SUJ, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veListaPrecioSuj ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_lp_suj oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veListaPrecioSuj");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectBySujeto(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    Sujeto sujeto = (Sujeto) aCondiciones;
    textSQL.append("SELECT * ");
    textSQL.append(" from veListaPrecioSuj where oid_sujeto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,sujeto.getOID());
    return querySelect;
  }

  private PreparedStatement selectBySujetoFecha(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
    java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
    textSQL.append("SELECT * ");
    textSQL.append(" from veListaPrecioSuj where oid_sujeto = ? and fec_desde<=? and fec_hasta>=? and activo=1 ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,sujeto.getOID());
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
    querySelect.setDate(3,new java.sql.Date(fecha.getTime()));
    return querySelect;
  }


  public static List getListaPreciosBySujeto(Sujeto sujeto,
                                       ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ListaPrecioSujeto.NICKNAME,
                                          DBListaPrecioSujeto.SELECT_BY_SUJETO,
                                          sujeto,
                                          new ListObserver(),
                                          aSesion);
  }

  public static List getListaPreciosBySujetoFecha(Sujeto sujeto,
                                                          java.util.Date fecha,
                                                          ISesion aSesion) throws BaseException {
    ListaPrecioSujeto lp = null;
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(Sujeto.NICKNAME,sujeto);
    condiciones.put("fecha",fecha);
    List lista = (List) ObjetoLogico.getObjects(ListaPrecioSujeto.NICKNAME,
                                                 DBListaPrecioSujeto.SELECT_BY_SUJETO_FECHA,
                                                 condiciones,
                                                 new ListObserver(),
                                                 aSesion);
    return lista;
  }




}
