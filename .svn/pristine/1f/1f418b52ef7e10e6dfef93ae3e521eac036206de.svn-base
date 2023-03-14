package com.srn.erp.cashflow.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cashflow.bm.CtaBcoSaldoIniCF;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCtaBcoSaldoIniCF extends DBObjetoPersistente {

  public static final String OID_SAL_INI_CTA = "oid_sal_ini_cta";
  public static final String OID_ESCENARIO = "oid_escenario";
  public static final String OID_CTA_BANCARIA = "oid_cta_bancaria";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ESCENARIO = 100;

  public DBCtaBcoSaldoIniCF() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SAL_INI_CTA = 1;
    final int OID_ESCENARIO = 2;
    final int OID_CTA_BANCARIA = 3;
    final int ACTIVO = 4;

    CtaBcoSaldoIniCF pers = (CtaBcoSaldoIniCF) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cfSaldoIniCtasBco "+
                     " ( "+
                      "OID_SAL_INI_CTA,"+
                      "OID_ESCENARIO,"+
                      "OID_CTA_BANCARIA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_SAL_INI_CTA,pers.getOID());
    qInsert.setInt(OID_ESCENARIO,pers.getEscenariocf().getOID());
    qInsert.setInt(OID_CTA_BANCARIA,pers.getCuenta_bancaria().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESCENARIO = 1;
    final int OID_CTA_BANCARIA = 2;
    final int ACTIVO = 3;
    final int OID_SAL_INI_CTA = 4;

    CtaBcoSaldoIniCF pers = (CtaBcoSaldoIniCF) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cfSaldoIniCtasBco set "+
              "oid_escenario=?"+ 
              ",oid_cta_bancaria=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_sal_ini_cta=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SAL_INI_CTA,pers.getOID());
    qUpdate.setInt(OID_ESCENARIO,pers.getEscenariocf().getOID());
    qUpdate.setInt(OID_CTA_BANCARIA,pers.getCuenta_bancaria().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SAL_INI_CTA = 1; 
    CtaBcoSaldoIniCF pers = (CtaBcoSaldoIniCF) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfSaldoIniCtasBco "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_sal_ini_cta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SAL_INI_CTA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SAL_INI_CTA = 1; 
    CtaBcoSaldoIniCF pers = (CtaBcoSaldoIniCF) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfSaldoIniCtasBco "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_sal_ini_cta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SAL_INI_CTA, pers.getOID()); 
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

    final int OID_SAL_INI_CTA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfSaldoIniCtasBco "); 
    textSQL.append(" WHERE oid_sal_ini_cta = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SAL_INI_CTA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfSaldoIniCtasBco "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEscenario(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cfSaldoIniCtasBco "); 
	    textSQL.append(" WHERE oid_escenario = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EscenarioCashFlow escenario = (EscenarioCashFlow) aCondiciones; 
	    querySelect.setInt(1, escenario.getOID()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_sal_ini_cta oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cfSaldoIniCtasBco");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCtasBcoSaldoIni(EscenarioCashFlow escenario,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CtaBcoSaldoIniCF.NICKNAME,
             DBCtaBcoSaldoIniCF.SELECT_BY_ESCENARIO,
             escenario,
             new ListObserver(),
             aSesion);
  }
  
  
} 
