package com.srn.erp.produccion.da;

import java.sql.*;
import com.srn.erp.produccion.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBTipoEstacionTrabajo extends DBObjetoPersistente {

  public static final String OID_TIPO_ESTACION = "oid_tipo_estacion";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";

  public DBTipoEstacionTrabajo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TIPO_ESTACION = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;

    TipoEstacionTrabajo pers = (TipoEstacionTrabajo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into prTipoEstacion "+
                     " ( "+
                      "OID_TIPO_ESTACION,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TIPO_ESTACION,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int OID_TIPO_ESTACION = 4;

    TipoEstacionTrabajo pers = (TipoEstacionTrabajo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update prTipoEstacion set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_tipo_estacion=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_ESTACION,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TIPO_ESTACION = 1; 
    TipoEstacionTrabajo pers = (TipoEstacionTrabajo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update prTipoEstacion "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tipo_estacion=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_ESTACION, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TIPO_ESTACION = 1; 
    TipoEstacionTrabajo pers = (TipoEstacionTrabajo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update prTipoEstacion "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tipo_estacion=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TIPO_ESTACION, pers.getOID()); 
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

    final int OID_TIPO_ESTACION = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  prTipoEstacion "); 
    textSQL.append(" WHERE oid_tipo_estacion = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TIPO_ESTACION, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  prTipoEstacion "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tipo_estacion oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from prTipoEstacion");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
