package com.srn.erp.stock.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.stock.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBComproAjusteStkDetAnu extends DBObjetoPersistente {

  public static final String OID_AJU_DET_ANU = "oid_aju_det_anu";
  public static final String OID_AJU_ANU = "oid_aju_anu";
  public static final String OID_AJU_STK_DET = "oid_aju_stk_det";
  
  public static final int SELECT_BY_AJU_CAB_ANU = 100;

  public DBComproAjusteStkDetAnu() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_AJU_DET_ANU = 1;
    final int OID_AJU_ANU = 2;
    final int OID_AJU_STK_DET = 3;

    ComproAjusteStkDetAnu pers = (ComproAjusteStkDetAnu) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skAjuStkDetAnu "+
                     " ( "+
                      "OID_AJU_DET_ANU,"+
                      "OID_AJU_ANU,"+
                      "OID_AJU_STK_DET)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_AJU_DET_ANU,pers.getOID());
    qInsert.setInt(OID_AJU_ANU,pers.getCompro_aju_stk_anu().getOID());
    qInsert.setInt(OID_AJU_STK_DET,pers.getCompro_aju_stk_det().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_AJU_ANU = 1;
    final int OID_AJU_STK_DET = 2;
    final int OID_AJU_DET_ANU = 3;

    ComproAjusteStkDetAnu pers = (ComproAjusteStkDetAnu) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skAjuStkDetAnu set "+
              "oid_aju_anu=?"+ 
              ",oid_aju_stk_det=?"+ 
                 " where " +
                 " oid_aju_det_anu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_AJU_DET_ANU,pers.getOID());
    qUpdate.setInt(OID_AJU_ANU,pers.getCompro_aju_stk_anu().getOID());
    qUpdate.setInt(OID_AJU_STK_DET,pers.getCompro_aju_stk_det().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_AJU_DET_ANU = 1; 
    ComproAjusteStkDetAnu pers = (ComproAjusteStkDetAnu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skAjuStkDetAnu "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_aju_det_anu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_AJU_DET_ANU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_AJU_DET_ANU = 1; 
    ComproAjusteStkDetAnu pers = (ComproAjusteStkDetAnu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skAjuStkDetAnu "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_aju_det_anu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_AJU_DET_ANU, pers.getOID()); 
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
      case SELECT_BY_AJU_CAB_ANU: {
        ps = this.selectByAjuCabAnu(aCondiciones); 
        break; 
      }
    } 
    
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_AJU_DET_ANU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skAjuStkDetAnu "); 
    textSQL.append(" WHERE oid_aju_det_anu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_AJU_DET_ANU, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByAjuCabAnu(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skAjuStkDetAnu "); 
    textSQL.append(" WHERE oid_aju_anu = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    ComproAjusteStkAnu compro = (ComproAjusteStkAnu) aCondiciones; 
    querySelect.setInt(1, compro.getOID()); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skAjuStkDetAnu "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_aju_det_anu oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skAjuStkDetAnu");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getDetalles(ComproAjusteStkAnu compro,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(ComproAjusteStkDetAnu.NICKNAME,
         DBComproAjusteStkDetAnu.SELECT_BY_AJU_CAB_ANU,
         compro,
         new ListObserver(),
         aSesion);
  }
  
  
} 
