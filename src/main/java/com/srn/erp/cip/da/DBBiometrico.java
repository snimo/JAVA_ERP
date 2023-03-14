package com.srn.erp.cip.da;

import java.sql.*;
import com.srn.erp.cip.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBBiometrico extends DBObjetoPersistente {

  public static final String ID_BIOMETRICO = "id_biometrico";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String IP = "ip";
  public static final String PUERTO = "puerto";
  public static final String TIPO_BIOMETRICO = "tipo_biometrico";
  public static final String NRO_BIOMETRICO = "nro_biometrico";
  public static final String ACTIVO = "activo";

  public DBBiometrico() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int ID_BIOMETRICO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int IP = 4;
    final int PUERTO = 5;
    final int TIPO_BIOMETRICO = 6;
    final int NRO_BIOMETRICO = 7;
    final int ACTIVO = 8;

    Biometrico pers = (Biometrico) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipBiometrico "+
                     " ( "+
                      "ID_BIOMETRICO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "IP,"+
                      "PUERTO,"+
                      "TIPO_BIOMETRICO,"+
                      "NRO_BIOMETRICO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(ID_BIOMETRICO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(IP,pers.getIp());
    qInsert.setInt(PUERTO,pers.getPuerto().intValue());
    qInsert.setString(TIPO_BIOMETRICO,pers.getTipo_biometrico());
    qInsert.setInt(NRO_BIOMETRICO,pers.getNro_biometrico().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int IP = 3;
    final int PUERTO = 4;
    final int TIPO_BIOMETRICO = 5;
    final int NRO_BIOMETRICO = 6;
    final int ACTIVO = 7;
    final int ID_BIOMETRICO = 8;

    Biometrico pers = (Biometrico) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipBiometrico set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",ip=?"+ 
              ",puerto=?"+ 
              ",tipo_biometrico=?"+ 
              ",nro_biometrico=?"+ 
              ",activo=?"+ 
                 " where " +
                 " id_biometrico=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(ID_BIOMETRICO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(IP,pers.getIp());
    qUpdate.setInt(PUERTO,pers.getPuerto().intValue());
    qUpdate.setString(TIPO_BIOMETRICO,pers.getTipo_biometrico());
    qUpdate.setInt(NRO_BIOMETRICO,pers.getNro_biometrico().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int ID_BIOMETRICO = 1; 
    Biometrico pers = (Biometrico) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipBiometrico "+
                     " set activo=0 " + 
                     " where " + 
                     " id_biometrico=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(ID_BIOMETRICO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int ID_BIOMETRICO = 1; 
    Biometrico pers = (Biometrico) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipBiometrico "+
                     " set activo=1 " + 
                     " where " + 
                     " id_biometrico=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(ID_BIOMETRICO, pers.getOID()); 
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

    final int ID_BIOMETRICO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipBiometrico "); 
    textSQL.append(" WHERE id_biometrico = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(ID_BIOMETRICO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipBiometrico "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT id_biometrico oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cipBiometrico");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
