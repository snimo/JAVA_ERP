package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.excluidos.bm.AdmEstadoExcluido;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBAdmEstadoExcluido extends DBObjetoPersistente {

  public static final String OID_INDIVIDUO = "oid_individuo";
  public static final String OID_ESTADO = "oid_estado";
  public static final String OID_ESTADO_ANT = "oid_estado_ant";
  public static final String FEC_ESTADO = "fec_estado";
  public static final String FEC_ESTADO_ANT = "fec_estado_ant";
  public static final String OID_NOVEDAD = "oid_novedad";

  public DBAdmEstadoExcluido() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_INDIVIDUO = 1;
    final int OID_ESTADO = 2;
    final int OID_ESTADO_ANT = 3;
    final int FEC_ESTADO = 4;
    final int FEC_ESTADO_ANT = 5;
    final int OID_NOVEDAD = 6;

    AdmEstadoExcluido pers = (AdmEstadoExcluido) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excIndividuo "+
                     " ( "+
                      "OID_INDIVIDUO,"+
                      "OID_ESTADO,"+
                      "OID_ESTADO_ANT,"+
                      "FEC_ESTADO,"+
                      "FEC_ESTADO_ANT,"+
                      "OID_NOVEDAD)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_INDIVIDUO,pers.getOID());
    if (pers.getEstado()!=null) 
      qInsert.setInt(OID_ESTADO,pers.getEstado().getOID());
    else
      qInsert.setNull(OID_ESTADO,java.sql.Types.INTEGER);
    if (pers.getEstado_anterior()!=null) 
      qInsert.setInt(OID_ESTADO_ANT,pers.getEstado_anterior().getOID());
    else
      qInsert.setNull(OID_ESTADO_ANT,java.sql.Types.INTEGER);
    if (pers.getFec_estado()!=null) 
      qInsert.setDate(FEC_ESTADO,new java.sql.Date(pers.getFec_estado().getTime()));
    else
      qInsert.setNull(FEC_ESTADO,java.sql.Types.DATE);
    if (pers.getFec_estado_ant()!=null) 
      qInsert.setDate(FEC_ESTADO_ANT,new java.sql.Date(pers.getFec_estado_ant().getTime()));
    else
      qInsert.setNull(FEC_ESTADO_ANT,java.sql.Types.INTEGER);
    if (pers.getNovedad()!=null) 
      qInsert.setInt(OID_NOVEDAD,pers.getNovedad().getOID());
    else
      qInsert.setNull(OID_NOVEDAD,java.sql.Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTADO = 1;
    final int OID_ESTADO_ANT = 2;
    final int FEC_ESTADO = 3;
    final int FEC_ESTADO_ANT = 4;
    final int OID_NOVEDAD = 5;
    final int OID_INDIVIDUO = 6;

    AdmEstadoExcluido pers = (AdmEstadoExcluido) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excIndividuo set "+
              "oid_estado=?"+ 
              ",oid_estado_ant=?"+ 
              ",fec_estado=?"+ 
              ",fec_estado_ant=?"+ 
              ",oid_novedad=?"+ 
                 " where " +
                 " oid_individuo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_INDIVIDUO,pers.getOID());
    if (pers.getEstado()!=null) 
      qUpdate.setInt(OID_ESTADO,pers.getEstado().getOID());
    else
      qUpdate.setNull(OID_ESTADO,java.sql.Types.INTEGER);
    if (pers.getEstado_anterior()!=null) 
      qUpdate.setInt(OID_ESTADO_ANT,pers.getEstado_anterior().getOID());
    else
      qUpdate.setNull(OID_ESTADO_ANT,java.sql.Types.INTEGER);
    if (pers.getFec_estado()!=null) 
      qUpdate.setDate(FEC_ESTADO, new java.sql.Date(pers.getFec_estado().getTime()));
    else
      qUpdate.setNull(FEC_ESTADO,java.sql.Types.DATE);
    if (pers.getFec_estado_ant()!=null) 
      qUpdate.setDate(FEC_ESTADO_ANT,new java.sql.Date(pers.getFec_estado_ant().getTime()));
    else
      qUpdate.setNull(FEC_ESTADO_ANT,java.sql.Types.DATE);
    if (pers.getNovedad()!=null) 
      qUpdate.setInt(OID_NOVEDAD,pers.getNovedad().getOID());
    else
      qUpdate.setNull(OID_NOVEDAD,java.sql.Types.INTEGER);
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_INDIVIDUO = 1; 
    AdmEstadoExcluido pers = (AdmEstadoExcluido) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excIndividuo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_individuo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_INDIVIDUO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_INDIVIDUO = 1; 
    AdmEstadoExcluido pers = (AdmEstadoExcluido) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excIndividuo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_individuo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_INDIVIDUO, pers.getOID()); 
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

    final int OID_INDIVIDUO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excIndividuo "); 
    textSQL.append(" WHERE oid_individuo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_INDIVIDUO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excIndividuo "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_individuo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excIndividuo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
