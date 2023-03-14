package com.srn.erp.produccion.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.produccion.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBNecMatOperAltFab extends DBObjetoPersistente {

  public static final String OID_NECE_MAT_OPER = "oid_nece_mat_oper";
  public static final String OID_OPER_FABRI = "oid_oper_fabri";
  public static final String OID_REC_DET = "oid_rec_det";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_OPER_ALT_FAB = 100;

  public DBNecMatOperAltFab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_NECE_MAT_OPER = 1;
    final int OID_OPER_FABRI = 2;
    final int OID_REC_DET = 3;
    final int ACTIVO = 4;

    NecMatOperAltFab pers = (NecMatOperAltFab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into prNeceMatOper "+
                     " ( "+
                      "OID_NECE_MAT_OPER,"+
                      "OID_OPER_FABRI,"+
                      "OID_REC_DET,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_NECE_MAT_OPER,pers.getOID());
    qInsert.setInt(OID_OPER_FABRI,pers.getOper_alt_fab().getOID());
    qInsert.setInt(OID_REC_DET,pers.getReceta_det().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_OPER_FABRI = 1;
    final int OID_REC_DET = 2;
    final int ACTIVO = 3;
    final int OID_NECE_MAT_OPER = 4;

    NecMatOperAltFab pers = (NecMatOperAltFab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update prNeceMatOper set "+
              "oid_oper_fabri=?"+ 
              ",oid_rec_det=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_nece_mat_oper=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NECE_MAT_OPER,pers.getOID());
    qUpdate.setInt(OID_OPER_FABRI,pers.getOper_alt_fab().getOID());
    qUpdate.setInt(OID_REC_DET,pers.getReceta_det().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_NECE_MAT_OPER = 1; 
    NecMatOperAltFab pers = (NecMatOperAltFab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update prNeceMatOper "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_nece_mat_oper=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NECE_MAT_OPER, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_NECE_MAT_OPER = 1; 
    NecMatOperAltFab pers = (NecMatOperAltFab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update prNeceMatOper "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_nece_mat_oper=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NECE_MAT_OPER, pers.getOID()); 
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
      case SELECT_BY_OPER_ALT_FAB: {
          ps = this.selectByOperAltFab(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_NECE_MAT_OPER = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  prNeceMatOper "); 
    textSQL.append(" WHERE oid_nece_mat_oper = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_NECE_MAT_OPER, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByOperAltFab(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  prNeceMatOper "); 
	    textSQL.append(" WHERE oid_oper_fabri = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    OperAlterFab operAlterFab = (OperAlterFab) aCondiciones; 
	    querySelect.setInt(1, operAlterFab.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  prNeceMatOper "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_nece_mat_oper oid, codigo,  descripcion ,activo ");
    textSQL.append(" from prNeceMatOper");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getNecMatOperAlt(OperAlterFab operAltFab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(NecMatOperAltFab.NICKNAME,
             DBNecMatOperAltFab.SELECT_BY_OPER_ALT_FAB,
             operAltFab,
             new ListObserver(),
             aSesion);
  }
  
  
} 
