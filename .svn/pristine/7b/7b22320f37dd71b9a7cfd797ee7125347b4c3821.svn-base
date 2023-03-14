package com.srn.erp.turnos.da;

import java.sql.*;
import com.srn.erp.turnos.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBTurnoGrupoEntidad extends DBObjetoPersistente {

  public static final String OID_GRUPO_ENTIDAD = "oid_grupo_entidad";
  public static final String COD_GRUPO = "cod_grupo";
  public static final String DESC_GRUPO = "desc_grupo";
  public static final String COMPORTAMIENTO = "comportamiento";
  public static final String ACTIVO = "activo";

  public DBTurnoGrupoEntidad() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_ENTIDAD = 1;
    final int COD_GRUPO = 2;
    final int DESC_GRUPO = 3;
    final int COMPORTAMIENTO = 4;
    final int ACTIVO = 5;

    TurnoGrupoEntidad pers = (TurnoGrupoEntidad) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuGrupoEntidades "+
                     " ( "+
                      "OID_GRUPO_ENTIDAD,"+
                      "COD_GRUPO,"+
                      "DESC_GRUPO,"+
                      "COMPORTAMIENTO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_ENTIDAD,pers.getOID());
    qInsert.setString(COD_GRUPO,pers.getCod_grupo());
    qInsert.setString(DESC_GRUPO,pers.getDesc_grupo());
    qInsert.setString(COMPORTAMIENTO,pers.getComportamiento());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int COD_GRUPO = 1;
    final int DESC_GRUPO = 2;
    final int COMPORTAMIENTO = 3;
    final int ACTIVO = 4;
    final int OID_GRUPO_ENTIDAD = 5;

    TurnoGrupoEntidad pers = (TurnoGrupoEntidad) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuGrupoEntidades set "+
              "cod_grupo=?"+ 
              ",desc_grupo=?"+ 
              ",comportamiento=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupo_entidad=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_ENTIDAD,pers.getOID());
    qUpdate.setString(COD_GRUPO,pers.getCod_grupo());
    qUpdate.setString(DESC_GRUPO,pers.getDesc_grupo());
    qUpdate.setString(COMPORTAMIENTO,pers.getComportamiento());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_ENTIDAD = 1; 
    TurnoGrupoEntidad pers = (TurnoGrupoEntidad) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuGrupoEntidades "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo_entidad=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_ENTIDAD, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_ENTIDAD = 1; 
    TurnoGrupoEntidad pers = (TurnoGrupoEntidad) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuGrupoEntidades "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_entidad=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_ENTIDAD, pers.getOID()); 
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

    final int OID_GRUPO_ENTIDAD = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuGrupoEntidades "); 
    textSQL.append(" WHERE oid_grupo_entidad = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_ENTIDAD, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuGrupoEntidades "); 
    textSQL.append(" WHERE cod_grupo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_entidad oid, cod_grupo codigo,  desc_grupo descripcion ,activo ");
    textSQL.append(" from tuGrupoEntidades");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
