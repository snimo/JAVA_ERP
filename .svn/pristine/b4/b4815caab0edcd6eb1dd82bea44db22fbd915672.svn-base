package com.srn.erp.bienUso.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.bienUso.bm.Bien;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBBien extends DBObjetoPersistente {

  public static final String OID_BIEN_USO = "oid_bien_uso";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String AMORTIZABLE = "amortizable";
  public static final String ESTADO = "estado";
  public static final String FEC_ALTA = "fec_alta";
  public static final String OID_GRUPO_BIEN_USO = "oid_grupo_bien_uso";
  public static final String OID_AI_VO = "oid_ai_vo";
  public static final String OID_AI_AA = "oid_ai_aa";
  public static final String OID_AI_RVO = "oid_ai_rvo";
  public static final String OID_AI_RAA = "oid_ai_raa";
  public static final String ACTIVO = "activo";

  public DBBien() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BIEN_USO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int AMORTIZABLE = 4;
    final int ESTADO = 5;
    final int FEC_ALTA = 6;
    final int OID_GRUPO_BIEN_USO = 7;
    final int OID_AI_VO = 8;
    final int OID_AI_AA = 9;
    final int OID_AI_RVO = 10;
    final int OID_AI_RAA = 11;
    final int ACTIVO = 12;

    Bien pers = (Bien) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into buBien "+
                     " ( "+
                      "OID_BIEN_USO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "AMORTIZABLE,"+
                      "ESTADO,"+
                      "FEC_ALTA,"+
                      "OID_GRUPO_BIEN_USO,"+
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
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_BIEN_USO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(AMORTIZABLE,pers.isAmortizable().booleanValue());
    qInsert.setString(ESTADO,pers.getEstado());
    qInsert.setDate(FEC_ALTA,new Date(pers.getFec_alta().getTime()));
    qInsert.setInt(OID_GRUPO_BIEN_USO,pers.getGrupo_bien_uso().getOID());
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
    final int AMORTIZABLE = 3;
    final int ESTADO = 4;
    final int FEC_ALTA = 5;
    final int OID_GRUPO_BIEN_USO = 6;
    final int OID_AI_VO = 7;
    final int OID_AI_AA = 8;
    final int OID_AI_RVO = 9;
    final int OID_AI_RAA = 10;
    final int ACTIVO = 11;
    final int OID_BIEN_USO = 12;

    Bien pers = (Bien) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update buBien set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",amortizable=?"+ 
              ",estado=?"+ 
              ",fec_alta=?"+ 
              ",oid_grupo_bien_uso=?"+ 
              ",oid_ai_vo=?"+ 
              ",oid_ai_aa=?"+ 
              ",oid_ai_rvo=?"+ 
              ",oid_ai_raa=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_bien_uso=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BIEN_USO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(AMORTIZABLE,pers.isAmortizable().booleanValue());
    qUpdate.setString(ESTADO,pers.getEstado());
    qUpdate.setDate(FEC_ALTA,new Date(pers.getFec_alta().getTime()));
    qUpdate.setInt(OID_GRUPO_BIEN_USO,pers.getGrupo_bien_uso().getOID());
    qUpdate.setInt(OID_AI_VO,pers.getAi_vo().getOID());
    qUpdate.setInt(OID_AI_AA,pers.getAi_aa().getOID());
    qUpdate.setInt(OID_AI_RVO,pers.getAi_rvo().getOID());
    qUpdate.setInt(OID_AI_RAA,pers.getAi_raa().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BIEN_USO = 1; 
    Bien pers = (Bien) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buBien "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_bien_uso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BIEN_USO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BIEN_USO = 1; 
    Bien pers = (Bien) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buBien "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_bien_uso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BIEN_USO, pers.getOID()); 
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

    final int OID_BIEN_USO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buBien "); 
    textSQL.append(" WHERE oid_bien_uso = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_BIEN_USO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buBien "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_bien_uso oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from buBien");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
