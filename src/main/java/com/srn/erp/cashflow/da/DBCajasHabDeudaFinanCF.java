package com.srn.erp.cashflow.da;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cashflow.bm.CajasHabDeudaFinanCF;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCajasHabDeudaFinanCF extends DBObjetoPersistente {

  public static final String OID_CAJA_DEUDA = "oid_caja_deuda";
  public static final String OID_ESCENARIO = "oid_escenario";
  public static final String OID_CAJA = "oid_caja";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ESCENARIO = 100;
  public static final int SELECT_BY_CAJAS_HAB_ESCE = 101;	

  public DBCajasHabDeudaFinanCF() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CAJA_DEUDA = 1;
    final int OID_ESCENARIO = 2;
    final int OID_CAJA = 3;
    final int ACTIVO = 4;

    CajasHabDeudaFinanCF pers = (CajasHabDeudaFinanCF) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cfCajasDeuFinan "+
                     " ( "+
                      "OID_CAJA_DEUDA,"+
                      "OID_ESCENARIO,"+
                      "OID_CAJA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CAJA_DEUDA,pers.getOID());
    qInsert.setInt(OID_ESCENARIO,pers.getEscenario_cf().getOID());
    qInsert.setInt(OID_CAJA,pers.getCaja().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESCENARIO = 1;
    final int OID_CAJA = 2;
    final int ACTIVO = 3;
    final int OID_CAJA_DEUDA = 4;

    CajasHabDeudaFinanCF pers = (CajasHabDeudaFinanCF) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cfCajasDeuFinan set "+
              "oid_escenario=?"+ 
              ",oid_caja=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_caja_deuda=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAJA_DEUDA,pers.getOID());
    qUpdate.setInt(OID_ESCENARIO,pers.getEscenario_cf().getOID());
    qUpdate.setInt(OID_CAJA,pers.getCaja().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CAJA_DEUDA = 1; 
    CajasHabDeudaFinanCF pers = (CajasHabDeudaFinanCF) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfCajasDeuFinan "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_caja_deuda=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAJA_DEUDA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CAJA_DEUDA = 1; 
    CajasHabDeudaFinanCF pers = (CajasHabDeudaFinanCF) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfCajasDeuFinan "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_caja_deuda=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAJA_DEUDA, pers.getOID()); 
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
      case SELECT_BY_ESCENARIO: {
          ps = this.selectByEscenario(aCondiciones); 
          break; 
      }
      case SELECT_BY_CAJAS_HAB_ESCE: {
          ps = this.selectByCajasHabEscenario(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CAJA_DEUDA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfCajasDeuFinan "); 
    textSQL.append(" WHERE oid_caja_deuda = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CAJA_DEUDA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfCajasDeuFinan "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEscenario(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cfCajasDeuFinan "); 
	    textSQL.append(" WHERE oid_escenario = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EscenarioCashFlow escenario = (EscenarioCashFlow) aCondiciones; 
	    querySelect.setInt(1, escenario.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCajasHabEscenario(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cfCajasDeuFinan "); 
	    textSQL.append(" WHERE oid_escenario = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EscenarioCashFlow escenario = (EscenarioCashFlow) aCondiciones; 
	    querySelect.setInt(1, escenario.getOID()); 
	    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_caja_deuda oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cfCajasDeuFinan");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCajasHabDeudaFinan(EscenarioCashFlow escenario,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CajasHabDeudaFinanCF.NICKNAME,
             DBCajasHabDeudaFinanCF.SELECT_BY_ESCENARIO,
             escenario,
             new ListObserver(),
             aSesion);
  }
  
  public static List getCajasHabDeudaFinanActivas(EscenarioCashFlow escenario,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CajasHabDeudaFinanCF.NICKNAME,
             DBCajasHabDeudaFinanCF.SELECT_BY_CAJAS_HAB_ESCE,
             escenario,
             new ListObserver(),
             aSesion);
  }
  
  
  
} 
