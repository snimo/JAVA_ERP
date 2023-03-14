package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.reclutamiento.bm.RecluEstAprobBusq;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBRecluEstAprobBusq extends DBObjetoPersistente {

  public static final String OID_EST_APROB_BUSQ = "oid_est_aprob_busq";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String APROBADO = "aprobado";
  public static final String ACTIVO = "activo";

  public DBRecluEstAprobBusq() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EST_APROB_BUSQ = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int APROBADO = 4;
    final int ACTIVO = 5;

    RecluEstAprobBusq pers = (RecluEstAprobBusq) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsEstadoAprobBusq "+
                     " ( "+
                      "OID_EST_APROB_BUSQ,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "APROBADO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EST_APROB_BUSQ,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(APROBADO,pers.isAprobado().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int APROBADO = 3;
    final int ACTIVO = 4;
    final int OID_EST_APROB_BUSQ = 5;

    RecluEstAprobBusq pers = (RecluEstAprobBusq) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsEstadoAprobBusq set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",aprobado=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_est_aprob_busq=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EST_APROB_BUSQ,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(APROBADO,pers.isAprobado().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EST_APROB_BUSQ = 1; 
    RecluEstAprobBusq pers = (RecluEstAprobBusq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsEstadoAprobBusq "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_est_aprob_busq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EST_APROB_BUSQ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EST_APROB_BUSQ = 1; 
    RecluEstAprobBusq pers = (RecluEstAprobBusq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsEstadoAprobBusq "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_est_aprob_busq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EST_APROB_BUSQ, pers.getOID()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_EST_APROB_BUSQ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsEstadoAprobBusq "); 
    textSQL.append(" WHERE oid_est_aprob_busq = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EST_APROB_BUSQ, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsEstadoAprobBusq "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_est_aprob_busq oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from rsEstadoAprobBusq");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
