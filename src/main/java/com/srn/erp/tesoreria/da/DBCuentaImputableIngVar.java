package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.tesoreria.bm.CuentaImputableIngVar;
import com.srn.erp.tesoreria.bm.MotivoHabIngVar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCuentaImputableIngVar extends DBObjetoPersistente {

  public static final String OID_CTA_INT_IV = "oid_cta_int_iv";
  public static final String OID_MOT_HAB_IV = "oid_mot_hab_iv";
  public static final String OID_AI = "oid_ai";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_MOT_HAB_IV = 100;

  public DBCuentaImputableIngVar() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CTA_INT_IV = 1;
    final int OID_MOT_HAB_IV = 2;
    final int OID_AI = 3;
    final int ACTIVO = 4;

    CuentaImputableIngVar pers = (CuentaImputableIngVar) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into teCtasIngVar "+
                     " ( "+
                      "OID_CTA_INT_IV,"+
                      "OID_MOT_HAB_IV,"+
                      "OID_AI,ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CTA_INT_IV,pers.getOID());
    qInsert.setInt(OID_MOT_HAB_IV,pers.getMotivo_hab_ing_var().getOID());
    qInsert.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOT_HAB_IV = 1;
    final int OID_AI = 2;
    final int ACTIVO = 3;
    final int OID_CTA_INT_IV = 4;

    CuentaImputableIngVar pers = (CuentaImputableIngVar) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update teCtasIngVar set "+
              "oid_mot_hab_iv=?"+ 
              ",oid_ai=?"+
              ",activo=?"+
                 " where " +
                 " oid_cta_int_iv=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_INT_IV,pers.getOID());
    qUpdate.setInt(OID_MOT_HAB_IV,pers.getMotivo_hab_ing_var().getOID());
    qUpdate.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CTA_INT_IV = 1; 
    CuentaImputableIngVar pers = (CuentaImputableIngVar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teCtasIngVar "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cta_int_iv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_INT_IV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CTA_INT_IV = 1; 
    CuentaImputableIngVar pers = (CuentaImputableIngVar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teCtasIngVar "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cta_int_iv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_INT_IV, pers.getOID()); 
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
      case SELECT_MOT_HAB_IV: {
        ps = this.selectByMotHabIngVar(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CTA_INT_IV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teCtasIngVar "); 
    textSQL.append(" WHERE oid_cta_int_iv = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CTA_INT_IV, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teCtasIngVar "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByMotHabIngVar(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teCtasIngVar "); 
    textSQL.append(" WHERE oid_mot_hab_iv = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    MotivoHabIngVar motHabIngVar = (MotivoHabIngVar) aCondiciones; 
    querySelect.setInt(1, motHabIngVar.getOID()); 
    return querySelect; 
  }
  
  public static List getCuentasHabIngVar(MotivoHabIngVar motHabIngVar,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(CuentaImputableIngVar.NICKNAME,
         DBCuentaImputableIngVar.SELECT_MOT_HAB_IV,
         motHabIngVar,
         new ListObserver(),
         aSesion);
  }
  
  
  
    
  
  
} 
