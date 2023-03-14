package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.CompoEscenario;
import com.srn.erp.presupuesto.bm.Escenario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCompoEscenario extends DBObjetoPersistente {

  public static final String OID_COMPO_ESCENARIO = "oid_compo_esce";
  public static final String OID_ESCENARIO = "oid_escenario";
  public static final String NIVEL = "nivel";
  public static final String OID_COMPO_PRESU = "oid_compo_presu";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ESCENARIO = 100;

  public DBCompoEscenario() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMPO_ESCE = 1;
    final int OID_ESCENARIO = 2;
    final int NIVEL = 3;
    final int OID_COMPO_PRESU = 4;
    final int ACTIVO = 5;

    CompoEscenario pers = (CompoEscenario) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plCompoEscenario"+
                     " ( "+
                      "OID_COMPO_ESCE,"+
                      "OID_ESCENARIO,"+
                      "NIVEL,"+
                      "OID_COMPO_PRESU,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COMPO_ESCE,pers.getOID());
    qInsert.setInt(OID_ESCENARIO,pers.getEscenario().getOID());
    qInsert.setInt(NIVEL,pers.getNivel().intValue());
    qInsert.setInt(OID_COMPO_PRESU,pers.getCompoPresupuestario().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESCENARIO = 1;
    final int NIVEL = 2;
    final int OID_COMPO_PRESU = 3;
    final int ACTIVO = 4;
    final int OID_COMPO_ESCE = 5;

    CompoEscenario pers = (CompoEscenario) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plCompoEscenario set "+
              "oid_escenario=?"+ 
              ",nivel=?"+ 
              ",oid_compo_presu=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_compo_esce=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPO_ESCE,pers.getOID());
    qUpdate.setInt(OID_ESCENARIO,pers.getEscenario().getOID());
    qUpdate.setInt(NIVEL,pers.getNivel().intValue());
    qUpdate.setInt(OID_COMPO_PRESU,pers.getCompoPresupuestario().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    CompoEscenario pers = (CompoEscenario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plCompoEscenario "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_compo_esce=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    CompoEscenario pers = (CompoEscenario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plCompoEscenario "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_compo_esce=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1, pers.getOID()); 
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
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plCompoEscenario "); 
    textSQL.append(" WHERE oid_compo_esce = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(1, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plCompoEscenario "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compo_esce oid, codigo,  descripcion ,activo ");
    textSQL.append(" from plCompoEscenario");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEscenario(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plCompoEscenario "); 
    textSQL.append(" WHERE oid_escenario = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    Escenario escenario = (Escenario) aCondiciones; 
    querySelect.setInt(1, escenario.getOID()); 
    return querySelect; 
  }
  
  public static List getDetallesByEscenario(Escenario escenario,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(CompoEscenario.NICKNAME,
         DBCompoEscenario.SELECT_BY_ESCENARIO,
         escenario,
         new ListObserver(),
         aSesion);
  }
  
  
} 
