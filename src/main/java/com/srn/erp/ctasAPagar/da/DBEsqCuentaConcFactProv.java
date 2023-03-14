package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.ctasAPagar.bm.EsqCuentaConcFactProv;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEsqCuentaConcFactProv extends DBObjetoPersistente {

  public static final String OID_CTA_CONC_FP = "oid_cta_conc_fp";
  public static final String OID_CONC_FACT_PROV = "oid_conc_fact_prov";
  public static final String OID_ANA_CON = "oid_ana_con";
  
  public static final int SELECT_BY_CONC_FACT = 100;

  public DBEsqCuentaConcFactProv() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CTA_CONC_FP = 1;
    final int OID_CONC_FACT_PROV = 2;
    final int OID_ANA_CON = 3;

    EsqCuentaConcFactProv pers = (EsqCuentaConcFactProv) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpCtasConcFactProv "+
                     " ( "+
                      "OID_CTA_CONC_FP,"+
                      "OID_CONC_FACT_PROV,"+
                      "OID_ANA_CON)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CTA_CONC_FP,pers.getOID());
    qInsert.setInt(OID_CONC_FACT_PROV,pers.getConc_fact_prov().getOID());
    qInsert.setInt(OID_ANA_CON,pers.getCuenta_contable().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONC_FACT_PROV = 1;
    final int OID_ANA_CON = 2;
    final int OID_CTA_CONC_FP = 3;

    EsqCuentaConcFactProv pers = (EsqCuentaConcFactProv) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpCtasConcFactProv set "+
              "oid_conc_fact_prov=?"+ 
              ",oid_ana_con=?"+ 
                 " where " +
                 " oid_cta_conc_fp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_CONC_FP,pers.getOID());
    qUpdate.setInt(OID_CONC_FACT_PROV,pers.getConc_fact_prov().getOID());
    qUpdate.setInt(OID_ANA_CON,pers.getCuenta_contable().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CTA_CONC_FP = 1; 
    EsqCuentaConcFactProv pers = (EsqCuentaConcFactProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from cpCtasConcFactProv "+
                     " where " + 
                     " oid_cta_conc_fp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_CONC_FP, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CTA_CONC_FP = 1; 
    EsqCuentaConcFactProv pers = (EsqCuentaConcFactProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpCtasConcFactProv "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cta_conc_fp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CTA_CONC_FP, pers.getOID()); 
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
      case SELECT_BY_CONC_FACT: {
        ps = this.selectByConcFact(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CTA_CONC_FP = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpCtasConcFactProv "); 
    textSQL.append(" WHERE oid_cta_conc_fp = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CTA_CONC_FP, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByConcFact(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpCtasConcFactProv "); 
    textSQL.append(" WHERE oid_conc_fact_prov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    ConcFactProv concFactProv = (ConcFactProv) aCondiciones; 
    querySelect.setInt(1, concFactProv.getOID()); 
    return querySelect; 
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpCtasConcFactProv "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cta_conc_fp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpCtasConcFactProv");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getEsqCuentasConcFactProv(ConcFactProv concFactProv,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(EsqCuentaConcFactProv.NICKNAME,
         DBEsqCuentaConcFactProv.SELECT_BY_CONC_FACT,
         concFactProv,
         new ListObserver(),
         aSesion);
  }
  
  
} 
