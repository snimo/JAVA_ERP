package com.srn.erp.ventas.da;

import java.sql.*;
import com.srn.erp.ventas.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBAplicPedDepoRto extends DBObjetoPersistente {

  public static final String OID_APLIC_PED_RTO = "oid_aplic_ped_rto";
  public static final String OID_PED_MERC_DET = "oid_ped_merc_det";
  public static final String OID_REMITO_DET = "oid_remito_det";
  public static final String CANT_ENVIADA = "cant_enviada";
  public static final String OID_UM = "oid_um";
  public static final String ACTIVO = "activo";

  public DBAplicPedDepoRto() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_APLIC_PED_RTO = 1;
    final int OID_PED_MERC_DET = 2;
    final int OID_REMITO_DET = 3;
    final int CANT_ENVIADA = 4;
    final int OID_UM = 5;
    final int ACTIVO = 6;

    AplicPedDepoRto pers = (AplicPedDepoRto) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veAplicPedDepoRto "+
                     " ( "+
                      "OID_APLIC_PED_RTO,"+
                      "OID_PED_MERC_DET,"+
                      "OID_REMITO_DET,"+
                      "CANT_ENVIADA,"+
                      "OID_UM,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_APLIC_PED_RTO,pers.getOID());
    qInsert.setInt(OID_PED_MERC_DET,pers.getPedido_merc_det().getOID());
    qInsert.setInt(OID_REMITO_DET,pers.getRemito_det().getOID());
    qInsert.setDouble(CANT_ENVIADA,pers.getCant_enviada().doubleValue());
    qInsert.setInt(OID_UM,pers.getUm().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PED_MERC_DET = 1;
    final int OID_REMITO_DET = 2;
    final int CANT_ENVIADA = 3;
    final int OID_UM = 4;
    final int ACTIVO = 5;
    final int OID_APLIC_PED_RTO = 6;

    AplicPedDepoRto pers = (AplicPedDepoRto) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veAplicPedDepoRto set "+
              "oid_ped_merc_det=?"+ 
              ",oid_remito_det=?"+ 
              ",cant_enviada=?"+ 
              ",oid_um=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_aplic_ped_rto=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APLIC_PED_RTO,pers.getOID());
    qUpdate.setInt(OID_PED_MERC_DET,pers.getPedido_merc_det().getOID());
    qUpdate.setInt(OID_REMITO_DET,pers.getRemito_det().getOID());
    qUpdate.setDouble(CANT_ENVIADA,pers.getCant_enviada().doubleValue());
    qUpdate.setInt(OID_UM,pers.getUm().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_APLIC_PED_RTO = 1; 
    AplicPedDepoRto pers = (AplicPedDepoRto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAplicPedDepoRto "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_aplic_ped_rto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APLIC_PED_RTO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_APLIC_PED_RTO = 1; 
    AplicPedDepoRto pers = (AplicPedDepoRto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAplicPedDepoRto "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_aplic_ped_rto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APLIC_PED_RTO, pers.getOID()); 
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

    final int OID_APLIC_PED_RTO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAplicPedDepoRto "); 
    textSQL.append(" WHERE oid_aplic_ped_rto = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_APLIC_PED_RTO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAplicPedDepoRto "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_aplic_ped_rto oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veAplicPedDepoRto");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
