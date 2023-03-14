package com.srn.erp.pagos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.pagos.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBRendicionFFUniOrg extends DBObjetoPersistente {

  public static final String OID_UNI_ORG_FF = "oid_uni_org_ff";
  public static final String OID_UNI_ORG = "oid_uni_org";
  public static final String ACTIVO = "activo";

  public DBRendicionFFUniOrg() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_UNI_ORG_FF = 1;
    final int OID_UNI_ORG = 2;
    final int ACTIVO = 3;

    RendicionFFUniOrg pers = (RendicionFFUniOrg) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opUniOrgFF "+
                     " ( "+
                      "OID_UNI_ORG_FF,"+
                      "OID_UNI_ORG,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_UNI_ORG_FF,pers.getOID());
    qInsert.setInt(OID_UNI_ORG,pers.getUnidad_organizativa().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_UNI_ORG = 1;
    final int ACTIVO = 2;
    final int OID_UNI_ORG_FF = 3;

    RendicionFFUniOrg pers = (RendicionFFUniOrg) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opUniOrgFF set "+
              "oid_uni_org=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_uni_org_ff=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_UNI_ORG_FF,pers.getOID());
    qUpdate.setInt(OID_UNI_ORG,pers.getUnidad_organizativa().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_UNI_ORG_FF = 1; 
    RendicionFFUniOrg pers = (RendicionFFUniOrg) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opUniOrgFF "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_uni_org_ff=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_UNI_ORG_FF, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_UNI_ORG_FF = 1; 
    RendicionFFUniOrg pers = (RendicionFFUniOrg) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opUniOrgFF "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_uni_org_ff=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_UNI_ORG_FF, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL: { 
        ps = this.selectAll(aCondiciones); 
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

    final int OID_UNI_ORG_FF = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opUniOrgFF "); 
    textSQL.append(" WHERE oid_uni_org_ff = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_UNI_ORG_FF, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opUniOrgFF "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opUniOrgFF "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_uni_org_ff oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opUniOrgFF");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getAllUniOrgRendFF(ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(RendicionFFUniOrg.NICKNAME,
         DBRendicionFFUniOrg.SELECT_ALL,
         null,
         new ListObserver(),
         aSesion);
  }
  
  
} 
