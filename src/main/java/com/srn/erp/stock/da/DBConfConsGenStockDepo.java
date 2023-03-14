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

public class DBConfConsGenStockDepo extends DBObjetoPersistente {

  public static final String OID_DEP_CONF_CONS_STK = "oid_dep_conf_cons_stk";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String OID_CONF_CONS_STK = "oid_conf_cons_stk";
  public static final String ACTIVO = "activo";
  public static final String ORDEN = "orden";
  
  public static final int SELECT_BY_CONF_CONS_STK = 100;

  public DBConfConsGenStockDepo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DEP_CONF_CONS_STK = 1;
    final int OID_DEPOSITO = 2;
    final int OID_CONF_CONS_STK = 3;
    final int ACTIVO = 4;
    final int ORDEN = 5;

    ConfConsGenStockDepo pers = (ConfConsGenStockDepo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skDepoConfConsStk "+
                     " ( "+
                      "OID_DEP_CONF_CONS_STK,"+
                      "OID_DEPOSITO,"+
                      "OID_CONF_CONS_STK,"+
                      "ACTIVO,"+
                      "ORDEN)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_DEP_CONF_CONS_STK,pers.getOID());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setInt(OID_CONF_CONS_STK,pers.getConf_cons_stk().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DEPOSITO = 1;
    final int OID_CONF_CONS_STK = 2;
    final int ACTIVO = 3;
    final int ORDEN = 4;
    final int OID_DEP_CONF_CONS_STK = 5;

    ConfConsGenStockDepo pers = (ConfConsGenStockDepo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skDepoConfConsStk set "+
              "oid_deposito=?"+ 
              ",oid_conf_cons_stk=?"+ 
              ",activo=?"+ 
              ",orden=?"+ 
                 " where " +
                 " oid_dep_conf_cons_stk=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEP_CONF_CONS_STK,pers.getOID());
    qUpdate.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qUpdate.setInt(OID_CONF_CONS_STK,pers.getConf_cons_stk().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DEP_CONF_CONS_STK = 1; 
    ConfConsGenStockDepo pers = (ConfConsGenStockDepo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skDepoConfConsStk "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_dep_conf_cons_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEP_CONF_CONS_STK, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DEP_CONF_CONS_STK = 1; 
    ConfConsGenStockDepo pers = (ConfConsGenStockDepo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skDepoConfConsStk "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_dep_conf_cons_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DEP_CONF_CONS_STK, pers.getOID()); 
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
      case SELECT_BY_CONF_CONS_STK: {
          ps = this.selectByConfConsStk(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_DEP_CONF_CONS_STK = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skDepoConfConsStk "); 
    textSQL.append(" WHERE oid_dep_conf_cons_stk = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DEP_CONF_CONS_STK, oid); 
    return querySelect; 
  }
  
  

  private PreparedStatement selectByConfConsStk(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  skDepoConfConsStk "); 
	    textSQL.append(" WHERE oid_conf_cons_stk = ? order by orden ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ConfConsGenStock confConsGenStock = (ConfConsGenStock) aCondiciones; 
	    querySelect.setInt(1, confConsGenStock.getOID()); 
	    return querySelect;
	    
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skDepoConfConsStk "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_dep_conf_cons_stk oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skDepoConfConsStk");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getConfConsGenStockDepo(ConfConsGenStock confConsGenStock,ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ConfConsGenStockDepo.NICKNAME,
             DBConfConsGenStockDepo.SELECT_BY_CONF_CONS_STK,
             confConsGenStock,
             new ListObserver(),
             aSesion);
  }
  
  
} 
