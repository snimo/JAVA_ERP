package com.srn.erp.costos.da;

import java.sql.*;
import com.srn.erp.costos.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBProcesoCostoProductos extends DBObjetoPersistente {

  public static final String OID_PROCESO_COSTO = "oid_proceso_costo";
  public static final String CODIGO = "codigo";
  public static final String FEC_EJECUCION = "fec_ejecucion";
  public static final String DESCRIPCION = "descripcion";
  public static final String HORA_EJECUCION = "hora_ejecucion";
  public static final String OID_USUARIO = "oid_usuario";
  public static final String FEC_COSTO = "fec_costo";
  public static final String FEC_DESDE = "fec_desde";
  public static final String ACTIVO = "activo";
  public static final String FEC_HASTA = "fec_hasta";

  public DBProcesoCostoProductos() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROCESO_COSTO = 1;
    final int CODIGO = 2;
    final int FEC_EJECUCION = 3;
    final int DESCRIPCION = 4;
    final int HORA_EJECUCION = 5;
    final int OID_USUARIO = 6;
    final int FEC_COSTO = 7;
    final int FEC_DESDE = 8;
    final int ACTIVO = 9;
    final int FEC_HASTA = 10;

    ProcesoCostoProductos pers = (ProcesoCostoProductos) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into coProcesoCostos "+
                     " ( "+
                      "OID_PROCESO_COSTO,"+
                      "CODIGO,"+
                      "FEC_EJECUCION,"+
                      "DESCRIPCION,"+
                      "HORA_EJECUCION,"+
                      "OID_USUARIO,"+
                      "FEC_COSTO,"+
                      "FEC_DESDE,"+
                      "ACTIVO,"+
                      "FEC_HASTA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PROCESO_COSTO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setDate(FEC_EJECUCION,new java.sql.Date(pers.getFec_ejecucion().getTime()));
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(HORA_EJECUCION,pers.getHora_ejecucion());
    qInsert.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qInsert.setDate(FEC_COSTO,new java.sql.Date(pers.getFecha_costo().getTime()));
    qInsert.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int FEC_EJECUCION = 2;
    final int DESCRIPCION = 3;
    final int HORA_EJECUCION = 4;
    final int OID_USUARIO = 5;
    final int FEC_COSTO = 6;
    final int FEC_DESDE = 7;
    final int ACTIVO = 8;
    final int FEC_HASTA = 9;
    final int OID_PROCESO_COSTO = 10;

    ProcesoCostoProductos pers = (ProcesoCostoProductos) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update coProcesoCostos set "+
              "codigo=?"+ 
              ",fec_ejecucion=?"+ 
              ",descripcion=?"+ 
              ",hora_ejecucion=?"+ 
              ",oid_usuario=?"+ 
              ",fec_costo=?"+ 
              ",fec_desde=?"+ 
              ",activo=?"+ 
              ",fec_hasta=?"+ 
                 " where " +
                 " oid_proceso_costo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROCESO_COSTO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setDate(FEC_EJECUCION,new java.sql.Date(pers.getFec_ejecucion().getTime()));
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(HORA_EJECUCION,pers.getHora_ejecucion());
    qUpdate.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qUpdate.setDate(FEC_COSTO,new java.sql.Date(pers.getFecha_costo().getTime()));
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROCESO_COSTO = 1; 
    ProcesoCostoProductos pers = (ProcesoCostoProductos) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update coProcesoCostos "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_proceso_costo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROCESO_COSTO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROCESO_COSTO = 1; 
    ProcesoCostoProductos pers = (ProcesoCostoProductos) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update coProcesoCostos "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_proceso_costo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROCESO_COSTO, pers.getOID()); 
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

    final int OID_PROCESO_COSTO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  coProcesoCostos "); 
    textSQL.append(" WHERE oid_proceso_costo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PROCESO_COSTO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  coProcesoCostos "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_proceso_costo oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from coProcesoCostos");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
