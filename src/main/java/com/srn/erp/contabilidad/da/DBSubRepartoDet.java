package com.srn.erp.contabilidad.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.contabilidad.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBSubRepartoDet extends DBObjetoPersistente {

  public static final String OID_SUB_DET = "oid_sub_det";
  public static final String SECU = "secu";
  public static final String OID_SUBREPARTO = "oid_subreparto";
  public static final String OID_FASE = "oid_fase";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_SUBREPARTO = 100;

  public DBSubRepartoDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_SUB_DET = 1;
    final int SECU = 2;
    final int OID_SUBREPARTO = 3;
    final int OID_FASE = 4;
    final int ACTIVO = 5;

    SubRepartoDet pers = (SubRepartoDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgSubRepartoDet "+
                     " ( "+
                      "OID_SUB_DET,"+
                      "SECU,"+
                      "OID_SUBREPARTO,"+
                      "OID_FASE,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_SUB_DET,pers.getOID());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.setInt(OID_SUBREPARTO,pers.getSubreparto().getOID());
    qInsert.setInt(OID_FASE,pers.getFase().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int SECU = 1;
    final int OID_SUBREPARTO = 2;
    final int OID_FASE = 3;
    final int ACTIVO = 4;
    final int OID_SUB_DET = 5;

    SubRepartoDet pers = (SubRepartoDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgSubRepartoDet set "+
              "secu=?"+ 
              ",oid_subreparto=?"+ 
              ",oid_fase=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_sub_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SUB_DET,pers.getOID());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    qUpdate.setInt(OID_SUBREPARTO,pers.getSubreparto().getOID());
    qUpdate.setInt(OID_FASE,pers.getFase().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SUB_DET = 1; 
    SubRepartoDet pers = (SubRepartoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from cgSubRepartoDet "+
                     " where " + 
                     " oid_sub_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SUB_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_SUB_DET = 1; 
    SubRepartoDet pers = (SubRepartoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgSubRepartoDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_sub_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_SUB_DET, pers.getOID()); 
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
      case SELECT_BY_SUBREPARTO: {
          ps = this.selectBySubReparto(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 
  
  private PreparedStatement selectBySubReparto(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgSubRepartoDet "); 
	    textSQL.append(" WHERE oid_subreparto = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    SubReparto subreparto = (SubReparto) aCondiciones; 
	    querySelect.setInt(1, subreparto.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_SUB_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgSubRepartoDet "); 
    textSQL.append(" WHERE oid_sub_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_SUB_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgSubRepartoDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_sub_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgSubRepartoDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getSubRepartosDet(SubReparto subreparto,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(SubRepartoDet.NICKNAME,
             DBSubRepartoDet.SELECT_BY_SUBREPARTO,
             subreparto,
             new ListObserver(),
             aSesion);
  }
  
  
} 
