package com.srn.erp.cashflow.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cashflow.bm.CtaSaldoIniCf;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCtaSaldoIniCf extends DBObjetoPersistente {

  public static final String OID_SALDO_INI_CTA = "oid_saldo_ini_cta";
  public static final String OID_ESCENARIO = "oid_escenario";
  public static final String OID_ANA_CON = "oid_ana_con";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ESCENARIO = 100;

  public DBCtaSaldoIniCf() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SALDO_INI_CTA = 1;
    final int OID_ESCENARIO = 2;
    final int OID_ANA_CON = 3;
    final int ACTIVO = 4;

    CtaSaldoIniCf pers = (CtaSaldoIniCf) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cfSaldoIniCta "+
                     " ( "+
                      "OID_SALDO_INI_CTA,"+
                      "OID_ESCENARIO,"+
                      "OID_ANA_CON,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_SALDO_INI_CTA,pers.getOID());
    qInsert.setInt(OID_ESCENARIO,pers.getEscenario().getOID());
    qInsert.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESCENARIO = 1;
    final int OID_ANA_CON = 2;
    final int ACTIVO = 3;
    final int OID_SALDO_INI_CTA = 4;

    CtaSaldoIniCf pers = (CtaSaldoIniCf) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cfSaldoIniCta set "+
              "oid_escenario=?"+ 
              ",oid_ana_con=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_saldo_ini_cta=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SALDO_INI_CTA,pers.getOID());
    qUpdate.setInt(OID_ESCENARIO,pers.getEscenario().getOID());
    qUpdate.setInt(OID_ANA_CON,pers.getCuenta().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SALDO_INI_CTA = 1; 
    CtaSaldoIniCf pers = (CtaSaldoIniCf) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfSaldoIniCta "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_saldo_ini_cta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SALDO_INI_CTA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SALDO_INI_CTA = 1; 
    CtaSaldoIniCf pers = (CtaSaldoIniCf) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfSaldoIniCta "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_saldo_ini_cta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SALDO_INI_CTA, pers.getOID()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SALDO_INI_CTA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfSaldoIniCta "); 
    textSQL.append(" WHERE oid_saldo_ini_cta = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SALDO_INI_CTA, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByEscenario(Object aCondiciones) throws BaseException, SQLException { 

		    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cfSaldoIniCta "); 
	    textSQL.append(" WHERE oid_escenario  = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EscenarioCashFlow escenario = (EscenarioCashFlow) aCondiciones; 
	    querySelect.setInt(1, escenario.getOID()); 
	    return querySelect; 
  }
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfSaldoIniCta "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_saldo_ini_cta oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cfSaldoIniCta");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCtasContablesSICaja(EscenarioCashFlow escenario,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CtaSaldoIniCf.NICKNAME,
             DBCtaSaldoIniCf.SELECT_BY_ESCENARIO,
             escenario,
             new ListObserver(),
             aSesion);
  }
  
  
} 
