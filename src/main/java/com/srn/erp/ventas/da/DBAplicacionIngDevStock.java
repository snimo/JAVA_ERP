package com.srn.erp.ventas.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.ventas.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBAplicacionIngDevStock extends DBObjetoPersistente {

  public static final String OID_APL_DEV_STK = "oid_apl_dev_stk";
  public static final String OID_DEV_DET = "oid_dev_det";
  public static final String OID_ING_STK_DET = "oid_ing_stk_det";
  public static final String CANTIDAD = "cantidad";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_DEV_VTAS_DET_ACTIVAS = 100;
  public static final int SELECT_BY_ING_STK_DET_ACTIVAS = 101; 

  public DBAplicacionIngDevStock() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_APL_DEV_STK = 1;
    final int OID_DEV_DET = 2;
    final int OID_ING_STK_DET = 3;
    final int CANTIDAD = 4;
    final int ACTIVO = 5;

    AplicacionIngDevStock pers = (AplicacionIngDevStock) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veAplDevStk "+
                     " ( "+
                      "OID_APL_DEV_STK,"+
                      "OID_DEV_DET,"+
                      "OID_ING_STK_DET,"+
                      "CANTIDAD,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_APL_DEV_STK,pers.getOID());
    qInsert.setInt(OID_DEV_DET,pers.getDevolucion_vtas_det().getOID());
    qInsert.setInt(OID_ING_STK_DET,pers.getDevolucion_stk_det().getOID());
    qInsert.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DEV_DET = 1;
    final int OID_ING_STK_DET = 2;
    final int CANTIDAD = 3;
    final int ACTIVO = 4;
    final int OID_APL_DEV_STK = 5;

    AplicacionIngDevStock pers = (AplicacionIngDevStock) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veAplDevStk set "+
              "oid_dev_det=?"+ 
              ",oid_ing_stk_det=?"+ 
              ",cantidad=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_apl_dev_stk=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APL_DEV_STK,pers.getOID());
    qUpdate.setInt(OID_DEV_DET,pers.getDevolucion_vtas_det().getOID());
    qUpdate.setInt(OID_ING_STK_DET,pers.getDevolucion_stk_det().getOID());
    qUpdate.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_APL_DEV_STK = 1; 
    AplicacionIngDevStock pers = (AplicacionIngDevStock) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAplDevStk "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_apl_dev_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APL_DEV_STK, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_APL_DEV_STK = 1; 
    AplicacionIngDevStock pers = (AplicacionIngDevStock) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAplDevStk "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_apl_dev_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APL_DEV_STK, pers.getOID()); 
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
      case SELECT_DEV_VTAS_DET_ACTIVAS: {
          ps = this.selectByDevVtasDetActivas(aCondiciones); 
          break; 
      }
      case SELECT_BY_ING_STK_DET_ACTIVAS: {
          ps = this.selectByIngStkDetActivas(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_APL_DEV_STK = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAplDevStk "); 
    textSQL.append(" WHERE oid_apl_dev_stk = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_APL_DEV_STK, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByIngStkDetActivas(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veAplDevStk "); 
	    textSQL.append(" WHERE oid_ing_stk_det = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    IngStockDevVtasDet ingDevVtasDet = (IngStockDevVtasDet) aCondiciones; 
	    querySelect.setInt(1, ingDevVtasDet.getOID()); 
	    return querySelect; 
	    
  }
  
  private PreparedStatement selectByDevVtasDetActivas(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veAplDevStk "); 
	    textSQL.append(" WHERE oid_dev_det = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    DevolucionVtasDet devVtasDet = (DevolucionVtasDet) aCondiciones; 
	    querySelect.setInt(1, devVtasDet.getOID()); 
	    return querySelect; 
	    
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAplDevStk "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_apl_dev_stk oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veAplDevStk");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getAplicacionByDevVtasDetActivas(
		  DevolucionVtasDet devolucionVtasDet,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(AplicacionIngDevStock.NICKNAME,
             DBAplicacionIngDevStock.SELECT_DEV_VTAS_DET_ACTIVAS,
             devolucionVtasDet,
             new ListObserver(),
             aSesion);
  }
  
  public static List getAplicacionesByIngStockDet(IngStockDevVtasDet ingStockDet,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(AplicacionIngDevStock.NICKNAME,
             DBAplicacionIngDevStock.SELECT_BY_ING_STK_DET_ACTIVAS,
             ingStockDet,
             new ListObserver(),
             aSesion);
  }
  
  
  
} 
