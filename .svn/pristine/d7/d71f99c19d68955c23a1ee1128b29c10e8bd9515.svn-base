package com.srn.erp.Ausentismo.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.Ausentismo.bm.GrupoRRHHGeneral;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBGrupoRRHHGeneral extends DBObjetoPersistente {

  public static final String OID_GRUPO_GRAL = "oid_grupo_gral";
  public static final String TIPO = "tipo";
  public static final String NOMBRE = "nombre";
  public static final String ACTIVO = "activo";

  public DBGrupoRRHHGeneral() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_GRAL = 1;
    final int TIPO = 2;
    final int NOMBRE = 3;
    final int ACTIVO = 4;

    GrupoRRHHGeneral pers = (GrupoRRHHGeneral) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhoGrupoGral "+
                     " ( "+
                      "OID_GRUPO_GRAL,"+
                      "TIPO,"+
                      "NOMBRE,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_GRAL,pers.getOID());
    qInsert.setString(TIPO,pers.getTipo());
    qInsert.setString(NOMBRE,pers.getNombre());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int TIPO = 1;
    final int NOMBRE = 2;
    final int ACTIVO = 3;
    final int OID_GRUPO_GRAL = 4;

    GrupoRRHHGeneral pers = (GrupoRRHHGeneral) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhoGrupoGral set "+
              "tipo=?"+ 
              ",nombre=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupo_gral=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_GRAL,pers.getOID());
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setString(NOMBRE,pers.getNombre());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_GRAL = 1; 
    GrupoRRHHGeneral pers = (GrupoRRHHGeneral) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhoGrupoGral "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo_gral=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_GRAL, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_GRAL = 1; 
    GrupoRRHHGeneral pers = (GrupoRRHHGeneral) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhoGrupoGral "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_gral=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_GRAL, pers.getOID()); 
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

    final int OID_GRUPO_GRAL = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhoGrupoGral "); 
    textSQL.append(" WHERE oid_grupo_gral = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_GRAL, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhoGrupoGral "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_gral oid, nombre codigo, nombre descripcion , activo ");
    textSQL.append(" from rhoGrupoGral");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 