package com.srn.erp.contabilidad.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.contabilidad.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBAnuladorAsientoManualDet extends DBObjetoPersistente {

  public static final String OID_ASI_MAN_DET = "oid_asi_man_det";
  public static final String OID_CAB_ASI_MAN = "oid_cab_asi_man";
  public static final String OID_DCO = "oid_dco";
  
  public static final int SELECT_BY_ANULADOR_ASI_CAB = 100;

  public DBAnuladorAsientoManualDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ASI_MAN_DET = 1;
    final int OID_CAB_ASI_MAN = 2;
    final int OID_DCO = 3;

    AnuladorAsientoManualDet pers = (AnuladorAsientoManualDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgAnuAsiManDet "+
                     " ( "+
                      "OID_ASI_MAN_DET,"+
                      "OID_CAB_ASI_MAN,"+
                      "OID_DCO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ASI_MAN_DET,pers.getOID());
    qInsert.setInt(OID_CAB_ASI_MAN,pers.getAnulador_asiento_manual().getOID());
    qInsert.setInt(OID_DCO,pers.getDet_asiento_manual().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CAB_ASI_MAN = 1;
    final int OID_DCO = 2;
    final int OID_ASI_MAN_DET = 3;

    AnuladorAsientoManualDet pers = (AnuladorAsientoManualDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgAnuAsiManDet set "+
              "oid_cab_asi_man=?"+ 
              ",oid_dco=?"+ 
                 " where " +
                 " oid_asi_man_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ASI_MAN_DET,pers.getOID());
    qUpdate.setInt(OID_CAB_ASI_MAN,pers.getAnulador_asiento_manual().getOID());
    qUpdate.setInt(OID_DCO,pers.getDet_asiento_manual().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ASI_MAN_DET = 1; 
    AnuladorAsientoManualDet pers = (AnuladorAsientoManualDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgAnuAsiManDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_asi_man_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ASI_MAN_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ASI_MAN_DET = 1; 
    AnuladorAsientoManualDet pers = (AnuladorAsientoManualDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgAnuAsiManDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_asi_man_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ASI_MAN_DET, pers.getOID()); 
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
      case SELECT_BY_ANULADOR_ASI_CAB: {
        ps = this.selectByAnuladorAsiCab(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ASI_MAN_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgAnuAsiManDet "); 
    textSQL.append(" WHERE oid_asi_man_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ASI_MAN_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByAnuladorAsiCab(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgAnuAsiManDet "); 
    textSQL.append(" WHERE oid_cab_asi_man = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    AnuladorAsientoManual anuAsiMan = (AnuladorAsientoManual) aCondiciones; 
    querySelect.setInt(1, anuAsiMan.getOID()); 
    return querySelect; 
    
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgAnuAsiManDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_asi_man_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgAnuAsiManDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getDetallesAnuladosAsiento(AnuladorAsientoManual anuladorAsientoManual,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(AnuladorAsientoManualDet.NICKNAME,
         DBAnuladorAsientoManualDet.SELECT_BY_ANULADOR_ASI_CAB,
         anuladorAsientoManual,
         new ListObserver(),
         aSesion);
  }
  
  
  
  
  
} 
