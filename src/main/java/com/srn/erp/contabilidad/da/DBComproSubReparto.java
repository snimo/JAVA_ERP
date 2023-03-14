package com.srn.erp.contabilidad.da;

import java.sql.*;

import com.srn.erp.contabilidad.bm.*;
import com.srn.erp.ventas.bm.PedidoCab;

import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBComproSubReparto extends DBObjetoPersistente {

  public static final String OID_COMPRO_SUB = "oid_compro_sub";
  public static final String COD_EJECUCION = "cod_ejecucion";
  public static final String DESC_EJECUCION = "desc_ejecucion";
  public static final String FEC_DESDE = "fec_desde";
  public static final String FEC_HASTA = "fec_hasta";
  public static final String OID_SUB_REPARTO = "oid_sub_reparto";

  public DBComproSubReparto() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMPRO_SUB = 1;
    final int COD_EJECUCION = 2;
    final int DESC_EJECUCION = 3;
    final int FEC_DESDE = 4;
    final int FEC_HASTA = 5;
    final int OID_SUB_REPARTO = 6;

    ComproSubReparto pers = (ComproSubReparto) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgComproSubRep "+
                     " ( "+
                      "OID_COMPRO_SUB,"+
                      "COD_EJECUCION,"+
                      "DESC_EJECUCION,"+
                      "FEC_DESDE,"+
                      "FEC_HASTA,"+
                      "OID_SUB_REPARTO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COMPRO_SUB,pers.getOID());
    qInsert.setString(COD_EJECUCION,pers.getCod_ejecucion());
    qInsert.setString(DESC_EJECUCION,pers.getDesc_ejecucion());
    qInsert.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qInsert.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qInsert.setInt(OID_SUB_REPARTO,pers.getSubReparto().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int COD_EJECUCION = 1;
    final int DESC_EJECUCION = 2;
    final int FEC_DESDE = 3;
    final int FEC_HASTA = 4;
    final int OID_SUB_REPARTO = 5;
    final int OID_COMPRO_SUB = 6;

    ComproSubReparto pers = (ComproSubReparto) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgComproSubRep set "+
              "cod_ejecucion=?"+ 
              ",desc_ejecucion=?"+ 
              ",fec_desde=?"+ 
              ",fec_hasta=?"+ 
              ",oid_sub_reparto=?"+ 
                 " where " +
                 " oid_compro_sub=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPRO_SUB,pers.getOID());
    qUpdate.setString(COD_EJECUCION,pers.getCod_ejecucion());
    qUpdate.setString(DESC_EJECUCION,pers.getDesc_ejecucion());
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qUpdate.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qUpdate.setInt(OID_SUB_REPARTO,pers.getSubReparto().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPRO_SUB = 1; 
	ComproSubReparto pers = (ComproSubReparto) objetoPersistente;
	StringBuffer sqlUpdate = new StringBuffer();
	sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
	PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
	qUpdate.setInt(OID_COMPRO_SUB, pers.getOID());
	qUpdate.executeUpdate();
	qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPRO_SUB = 1; 
    ComproSubReparto pers = (ComproSubReparto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgComproSubRep "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_compro_sub=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPRO_SUB, pers.getOID()); 
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

    final int OID_COMPRO_SUB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgComproSubRep a, geComproCab b "); 
    textSQL.append(" WHERE a.oid_compro_sub = b.oid_cco and a.oid_compro_sub = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COMPRO_SUB, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgComproSubRep a, geComproCab b"); 
    textSQL.append(" WHERE a.oid_compro_sub = b.oid_cco and cod_ejecucion = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT a.oid_compro_sub oid,a.cod_ejecucion codigo, a.desc_ejecucion descripcion ,b.activo ");
    textSQL.append(" from cgComproSubRep a , geComproCab b WHERE a.oid_compro_sub = b.oid_cco ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
