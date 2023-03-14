package com.srn.erp.bancos.da;


import java.sql.*;
import java.util.List;

import com.srn.erp.bancos.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBConciliacionBancoDia extends DBObjetoPersistente {

  public static final String OID_CONCI_BCO_DIA = "oid_conci_bco_dia";
  public static final String OID_CONCI_BCO = "oid_conci_bco";
  public static final String OID_CCO_CONC_DIA = "oid_cco_conc_dia";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_CONCILIACION_CAB = 100;

  public DBConciliacionBancoDia() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONCI_BCO_DIA = 1;
    final int OID_CONCI_BCO = 2;
    final int OID_CCO_CONC_DIA = 3;
    final int ACTIVO = 4;

    ConciliacionBancoDia pers = (ConciliacionBancoDia) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaConciBcoDia "+
                     " ( "+
                      "OID_CONCI_BCO_DIA,"+
                      "OID_CONCI_BCO,"+
                      "OID_CCO_CONC_DIA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CONCI_BCO_DIA,pers.getOID());
    qInsert.setInt(OID_CONCI_BCO,pers.getConciliacion().getOID());
    qInsert.setInt(OID_CCO_CONC_DIA,pers.getCompro_conciliacion_dia().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONCI_BCO = 1;
    final int OID_CCO_CONC_DIA = 2;
    final int ACTIVO = 3;
    final int OID_CONCI_BCO_DIA = 4;

    ConciliacionBancoDia pers = (ConciliacionBancoDia) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaConciBcoDia set "+
              "oid_conci_bco=?"+ 
              ",oid_cco_conc_dia=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_conci_bco_dia=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONCI_BCO_DIA,pers.getOID());
    qUpdate.setInt(OID_CONCI_BCO,pers.getConciliacion().getOID());
    qUpdate.setInt(OID_CCO_CONC_DIA,pers.getCompro_conciliacion_dia().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONCI_BCO_DIA = 1; 
    ConciliacionBancoDia pers = (ConciliacionBancoDia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaConciBcoDia "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_conci_bco_dia=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONCI_BCO_DIA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONCI_BCO_DIA = 1; 
    ConciliacionBancoDia pers = (ConciliacionBancoDia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaConciBcoDia "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_conci_bco_dia=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONCI_BCO_DIA, pers.getOID()); 
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
      case SELECT_BY_CONCILIACION_CAB: {
          ps = this.selectByConciliacionCab(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CONCI_BCO_DIA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaConciBcoDia "); 
    textSQL.append(" WHERE oid_conci_bco_dia = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CONCI_BCO_DIA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByConciliacionCab(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  vaConciBcoDia "); 
	    textSQL.append(" WHERE oid_conci_bco = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ConciliacionCab conciliacion = (ConciliacionCab) aCondiciones; 
	    querySelect.setInt(conciliacion.getOID(), conciliacion.getOID()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaConciBcoDia "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conci_bco_dia oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vaConciBcoDia");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getConciliacionesBcoDia(ConciliacionCab conciliacion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ConciliacionBancoDia.NICKNAME,
             DBConciliacionBancoDia.SELECT_BY_CONCILIACION_CAB,
             conciliacion,
             new ListObserver(),
             aSesion);
  }
  
  
} 
