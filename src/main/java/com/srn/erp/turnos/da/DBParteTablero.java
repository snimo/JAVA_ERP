package com.srn.erp.turnos.da;

import java.sql.*;
import com.srn.erp.turnos.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBParteTablero extends DBObjetoPersistente {

  public static final String OID_PARTE_TABLERO = "oid_parte_tablero";
  public static final String DESCRIPCION = "descripcion";
  public static final String LUNES = "lunes";
  public static final String MARTES = "martes";
  public static final String MIERCOLES = "miercoles";
  public static final String JUEVES = "jueves";
  public static final String VIERNES = "viernes";
  public static final String SABADO = "sabado";
  public static final String DOMINGO = "domingo";
  public static final String ACTIVO = "activo";

  public DBParteTablero() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PARTE_TABLERO = 1;
    final int DESCRIPCION = 2;
    final int LUNES = 3;
    final int MARTES = 4;
    final int MIERCOLES = 5;
    final int JUEVES = 6;
    final int VIERNES = 7;
    final int SABADO = 8;
    final int DOMINGO = 9;
    final int ACTIVO = 10;

    ParteTablero pers = (ParteTablero) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuParteTablero "+
                     " ( "+
                      "OID_PARTE_TABLERO,"+
                      "DESCRIPCION,"+
                      "LUNES,"+
                      "MARTES,"+
                      "MIERCOLES,"+
                      "JUEVES,"+
                      "VIERNES,"+
                      "SABADO,"+
                      "DOMINGO,"+
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
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PARTE_TABLERO,pers.getOID());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(LUNES,pers.isLunes().booleanValue());
    qInsert.setBoolean(MARTES,pers.isMartes().booleanValue());
    qInsert.setBoolean(MIERCOLES,pers.isMiercoles().booleanValue());
    qInsert.setBoolean(JUEVES,pers.isJueves().booleanValue());
    qInsert.setBoolean(VIERNES,pers.isViernes().booleanValue());
    qInsert.setBoolean(SABADO,pers.isSabado().booleanValue());
    qInsert.setBoolean(DOMINGO,pers.isDomingo().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int DESCRIPCION = 1;
    final int LUNES = 2;
    final int MARTES = 3;
    final int MIERCOLES = 4;
    final int JUEVES = 5;
    final int VIERNES = 6;
    final int SABADO = 7;
    final int DOMINGO = 8;
    final int ACTIVO = 9;
    final int OID_PARTE_TABLERO = 10;

    ParteTablero pers = (ParteTablero) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuParteTablero set "+
              "descripcion=?"+ 
              ",lunes=?"+ 
              ",martes=?"+ 
              ",miercoles=?"+ 
              ",jueves=?"+ 
              ",viernes=?"+ 
              ",sabado=?"+ 
              ",domingo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_parte_tablero=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PARTE_TABLERO,pers.getOID());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(LUNES,pers.isLunes().booleanValue());
    qUpdate.setBoolean(MARTES,pers.isMartes().booleanValue());
    qUpdate.setBoolean(MIERCOLES,pers.isMiercoles().booleanValue());
    qUpdate.setBoolean(JUEVES,pers.isJueves().booleanValue());
    qUpdate.setBoolean(VIERNES,pers.isViernes().booleanValue());
    qUpdate.setBoolean(SABADO,pers.isSabado().booleanValue());
    qUpdate.setBoolean(DOMINGO,pers.isDomingo().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PARTE_TABLERO = 1; 
    ParteTablero pers = (ParteTablero) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuParteTablero "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_parte_tablero=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PARTE_TABLERO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PARTE_TABLERO = 1; 
    ParteTablero pers = (ParteTablero) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuParteTablero "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_parte_tablero=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PARTE_TABLERO, pers.getOID()); 
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

    final int OID_PARTE_TABLERO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuParteTablero "); 
    textSQL.append(" WHERE oid_parte_tablero = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PARTE_TABLERO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuParteTablero "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_parte_tablero oid, descripcion codigo,  descripcion ,activo ");
    textSQL.append(" from tuParteTablero");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
