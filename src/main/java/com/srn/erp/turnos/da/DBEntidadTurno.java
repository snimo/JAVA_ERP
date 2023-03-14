package com.srn.erp.turnos.da;

import java.sql.*;
import com.srn.erp.turnos.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBEntidadTurno extends DBObjetoPersistente {

  public static final String OID_ENTIDAD_TURNO = "oid_entidad_turno";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_GRUPO_ENTIDAD = "oid_grupo_entidad";
  public static final String ACTIVO = "activo";

  public DBEntidadTurno() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ENTIDAD_TURNO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int OID_GRUPO_ENTIDAD = 4;
    final int ACTIVO = 5;

    EntidadTurno pers = (EntidadTurno) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuEntidadesTurno "+
                     " ( "+
                      "OID_ENTIDAD_TURNO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "OID_GRUPO_ENTIDAD,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ENTIDAD_TURNO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_GRUPO_ENTIDAD,pers.getGrupo_entidad().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int OID_GRUPO_ENTIDAD = 3;
    final int ACTIVO = 4;
    final int OID_ENTIDAD_TURNO = 5;

    EntidadTurno pers = (EntidadTurno) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuEntidadesTurno set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",oid_grupo_entidad=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_entidad_turno=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ENTIDAD_TURNO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_GRUPO_ENTIDAD,pers.getGrupo_entidad().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ENTIDAD_TURNO = 1; 
    EntidadTurno pers = (EntidadTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuEntidadesTurno "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_entidad_turno=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ENTIDAD_TURNO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ENTIDAD_TURNO = 1; 
    EntidadTurno pers = (EntidadTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuEntidadesTurno "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_entidad_turno=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ENTIDAD_TURNO, pers.getOID()); 
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

    final int OID_ENTIDAD_TURNO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuEntidadesTurno "); 
    textSQL.append(" WHERE oid_entidad_turno = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ENTIDAD_TURNO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuEntidadesTurno "); 
    textSQL.append(" WHERE CODIGO = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_entidad_turno oid, codigo, codigo descripcion ,activo ");
    textSQL.append(" from tuEntidadesTurno");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
