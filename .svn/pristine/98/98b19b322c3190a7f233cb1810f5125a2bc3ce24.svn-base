package com.srn.erp.bienUso.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.bienUso.bm.GrupoBien;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBGrupoBien extends DBObjetoPersistente {

  public static final String OID_GRUPO_BIEN_USO = "oid_grupo_bien_uso";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String AMORTIZA = "amortiza";
  public static final String OID_AI_VO = "oid_ai_vo";
  public static final String OID_AI_AA = "oid_ai_aa";
  public static final String OID_AI_RVO = "oid_ai_rvo";
  public static final String OID_AI_RAA = "oid_ai_raa";
  public static final String ACTIVO = "activo";

  public DBGrupoBien() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_BIEN_USO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int AMORTIZA = 4;
    final int OID_AI_VO = 5;
    final int OID_AI_AA = 6;
    final int OID_AI_RVO = 7;
    final int OID_AI_RAA = 8;
    final int ACTIVO = 9;

    GrupoBien pers = (GrupoBien) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into buGrupoBienUso "+
                     " ( "+
                      "OID_GRUPO_BIEN_USO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "AMORTIZA,"+
                      "OID_AI_VO,"+
                      "OID_AI_AA,"+
                      "OID_AI_RVO,"+
                      "OID_AI_RAA,"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_BIEN_USO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(AMORTIZA,pers.isAmortiza().booleanValue());
    qInsert.setInt(OID_AI_VO,pers.getAi_vo().getOID());
    qInsert.setInt(OID_AI_AA,pers.getAi_aa().getOID());
    qInsert.setInt(OID_AI_RVO,pers.getAi_rvo().getOID());
    qInsert.setInt(OID_AI_RAA,pers.getAi_raa().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int AMORTIZA = 3;
    final int OID_AI_VO = 4;
    final int OID_AI_AA = 5;
    final int OID_AI_RVO = 6;
    final int OID_AI_RAA = 7;
    final int ACTIVO = 8;
    final int OID_GRUPO_BIEN_USO = 9;

    GrupoBien pers = (GrupoBien) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update buGrupoBienUso set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",amortiza=?"+ 
              ",oid_ai_vo=?"+ 
              ",oid_ai_aa=?"+ 
              ",oid_ai_rvo=?"+ 
              ",oid_ai_raa=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupo_bien_uso=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_BIEN_USO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(AMORTIZA,pers.isAmortiza().booleanValue());
    qUpdate.setInt(OID_AI_VO,pers.getAi_vo().getOID());
    qUpdate.setInt(OID_AI_AA,pers.getAi_aa().getOID());
    qUpdate.setInt(OID_AI_RVO,pers.getAi_rvo().getOID());
    qUpdate.setInt(OID_AI_RAA,pers.getAi_raa().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_BIEN_USO = 1; 
    GrupoBien pers = (GrupoBien) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buGrupoBienUso "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo_bien_uso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_BIEN_USO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_BIEN_USO = 1; 
    GrupoBien pers = (GrupoBien) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buGrupoBienUso "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_bien_uso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_BIEN_USO, pers.getOID()); 
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

    final int OID_GRUPO_BIEN_USO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buGrupoBienUso "); 
    textSQL.append(" WHERE oid_grupo_bien_uso = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_BIEN_USO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buGrupoBienUso "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_bien_uso oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from buGrupoBienUso");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
