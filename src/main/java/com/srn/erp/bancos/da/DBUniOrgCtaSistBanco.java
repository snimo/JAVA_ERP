package com.srn.erp.bancos.da;

import java.sql.*;
import com.srn.erp.bancos.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBUniOrgCtaSistBanco extends DBObjetoPersistente {

  public static final String OID_CTA_HAB_UO = "oid_cta_hab_uo";
  public static final String OID_UNI_ORG = "oid_uni_org";
  public static final String OID_CTA_HAB_BCO = "oid_cta_hab_bco";
  public static final String ACTIVO = "activo";

  public DBUniOrgCtaSistBanco() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CTA_HAB_UO = 1;
    final int OID_UNI_ORG = 2;
    final int OID_CTA_HAB_BCO = 3;
    final int ACTIVO = 4;

    UniOrgCtaSistBanco pers = (UniOrgCtaSistBanco) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaCtasHabBancosUO "+
                     " ( "+
                      "OID_CTA_HAB_UO,"+
                      "OID_UNI_ORG,"+
                      "OID_CTA_HAB_BCO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CTA_HAB_UO,pers.getOID());
    qInsert.setInt(OID_UNI_ORG,pers.getUnidad_organizativa().getOID());
    qInsert.setInt(OID_CTA_HAB_BCO,pers.getCuenta_hab_banco().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_UNI_ORG = 1;
    final int OID_CTA_HAB_BCO = 2;
    final int ACTIVO = 3;
    final int OID_CTA_HAB_UO = 4;

    UniOrgCtaSistBanco pers = (UniOrgCtaSistBanco) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaCtasHabBancosUO set "+
              "oid_uni_org=?"+ 
              ",oid_cta_hab_bco=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_cta_hab_uo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_HAB_UO,pers.getOID());
    qUpdate.setInt(OID_UNI_ORG,pers.getUnidad_organizativa().getOID());
    qUpdate.setInt(OID_CTA_HAB_BCO,pers.getCuenta_hab_banco().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CTA_HAB_UO = 1; 
    UniOrgCtaSistBanco pers = (UniOrgCtaSistBanco) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaCtasHabBancosUO "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cta_hab_uo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_HAB_UO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CTA_HAB_UO = 1; 
    UniOrgCtaSistBanco pers = (UniOrgCtaSistBanco) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaCtasHabBancosUO "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cta_hab_uo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_HAB_UO, pers.getOID()); 
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

    final int OID_CTA_HAB_UO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaCtasHabBancosUO "); 
    textSQL.append(" WHERE oid_cta_hab_uo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CTA_HAB_UO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaCtasHabBancosUO "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cta_hab_uo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vaCtasHabBancosUO");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
