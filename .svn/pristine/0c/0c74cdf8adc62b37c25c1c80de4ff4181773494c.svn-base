package com.srn.erp.cashflow.da;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.cashflow.bm.ConceptoCashFlow;
import com.srn.erp.cashflow.bm.EsceConceptoCFHab;
import com.srn.erp.cashflow.bm.EscenarioCashFlow;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEsceConceptoCFHab extends DBObjetoPersistente {

  public static final String OID_ESCE_CONC = "oid_esce_conc";
  public static final String OID_CONCEPTO = "oid_concepto";
  public static final String OID_ESCENARIO = "oid_escenario";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_CONCEPTO_ESCENARIO = 100;

  public DBEsceConceptoCFHab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESCE_CONC = 1;
    final int OID_CONCEPTO = 2;
    final int OID_ESCENARIO = 3;
    final int ACTIVO = 4;

    EsceConceptoCFHab pers = (EsceConceptoCFHab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgEsceConc "+
                     " ( "+
                      "OID_ESCE_CONC,"+
                      "OID_CONCEPTO,"+
                      "OID_ESCENARIO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESCE_CONC,pers.getOID());
    qInsert.setInt(OID_CONCEPTO,pers.getConcepto_cf().getOID());
    qInsert.setInt(OID_ESCENARIO,pers.getEscenario_cf().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONCEPTO = 1;
    final int OID_ESCENARIO = 2;
    final int ACTIVO = 3;
    final int OID_ESCE_CONC = 4;

    EsceConceptoCFHab pers = (EsceConceptoCFHab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgEsceConc set "+
              "oid_concepto=?"+ 
              ",oid_escenario=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_esce_conc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESCE_CONC,pers.getOID());
    qUpdate.setInt(OID_CONCEPTO,pers.getConcepto_cf().getOID());
    qUpdate.setInt(OID_ESCENARIO,pers.getEscenario_cf().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESCE_CONC = 1; 
    EsceConceptoCFHab pers = (EsceConceptoCFHab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgEsceConc "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_esce_conc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESCE_CONC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESCE_CONC = 1; 
    EsceConceptoCFHab pers = (EsceConceptoCFHab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgEsceConc "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_esce_conc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESCE_CONC, pers.getOID()); 
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
      case SELECT_BY_CONCEPTO_ESCENARIO: {
          ps = this.selectByConceptoEscenario(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ESCE_CONC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgEsceConc "); 
    textSQL.append(" WHERE oid_esce_conc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESCE_CONC, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByConceptoEscenario(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgEsceConc "); 
	    textSQL.append(" WHERE oid_concepto = ? and oid_escenario = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    ConceptoCashFlow concepto = (ConceptoCashFlow) condiciones.get(ConceptoCashFlow.NICKNAME);
	    EscenarioCashFlow escenario = (EscenarioCashFlow) condiciones.get(EscenarioCashFlow.NICKNAME);
	    querySelect.setInt(1, concepto.getOID());
	    querySelect.setInt(2, escenario.getOID());
	    return querySelect;
	    
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgEsceConc "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_esce_conc oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgEsceConc");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static EsceConceptoCFHab getEscenariosConcHab(
		  ConceptoCashFlow concepto,
		  EscenarioCashFlow escenario,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ConceptoCashFlow.NICKNAME, concepto);
	  condiciones.put(EscenarioCashFlow.NICKNAME, escenario);
	  return (EsceConceptoCFHab) ObjetoLogico.getObjects(EsceConceptoCFHab.NICKNAME,
             DBEsceConceptoCFHab.SELECT_BY_CONCEPTO_ESCENARIO,
             condiciones,
             new ObjetoObservado(),
             aSesion);
  }
  
  
} 
