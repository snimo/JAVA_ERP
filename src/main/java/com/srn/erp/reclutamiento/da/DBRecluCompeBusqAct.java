package com.srn.erp.reclutamiento.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.reclutamiento.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBRecluCompeBusqAct extends DBObjetoPersistente {

  public static final String OID_COMP_BUSQ_ACT = "oid_comp_busq_act";
  public static final String OID_COMPETENCIA = "oid_competencia";
  public static final String OID_BUSQUEDA_ACT = "oid_busqueda_act";
  public static final String ACTIVO = "activo";
  
  private static final int SELECT_BY_BUSQUEDA = 100;

  public DBRecluCompeBusqAct() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMP_BUSQ_ACT = 1;
    final int OID_COMPETENCIA = 2;
    final int OID_BUSQUEDA_ACT = 3;
    final int ACTIVO = 4;

    RecluCompeBusqAct pers = (RecluCompeBusqAct) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into RSCOMPEBUSQACT "+
                     " ( "+
                      "OID_COMP_BUSQ_ACT,"+
                      "OID_COMPETENCIA,"+
                      "OID_BUSQUEDA_ACT,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COMP_BUSQ_ACT,pers.getOID());
    qInsert.setInt(OID_COMPETENCIA,pers.getCompetencia().getOID());
    qInsert.setInt(OID_BUSQUEDA_ACT,pers.getBusqueda().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMPETENCIA = 1;
    final int OID_BUSQUEDA_ACT = 2;
    final int ACTIVO = 3;
    final int OID_COMP_BUSQ_ACT = 4;

    RecluCompeBusqAct pers = (RecluCompeBusqAct) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update RSCOMPEBUSQACT set "+
              "oid_competencia=?"+ 
              ",oid_busqueda_act=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_comp_busq_act=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMP_BUSQ_ACT,pers.getOID());
    qUpdate.setInt(OID_COMPETENCIA,pers.getCompetencia().getOID());
    qUpdate.setInt(OID_BUSQUEDA_ACT,pers.getBusqueda().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMP_BUSQ_ACT = 1; 
    RecluCompeBusqAct pers = (RecluCompeBusqAct) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update RSCOMPEBUSQACT "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_comp_busq_act=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMP_BUSQ_ACT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMP_BUSQ_ACT = 1; 
    RecluCompeBusqAct pers = (RecluCompeBusqAct) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update RSCOMPEBUSQACT "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_comp_busq_act=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMP_BUSQ_ACT, pers.getOID()); 
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
      case SELECT_BY_BUSQUEDA: {
          ps = this.selectByBusqueda(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_COMP_BUSQ_ACT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  RSCOMPEBUSQACT "); 
    textSQL.append(" WHERE oid_comp_busq_act = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COMP_BUSQ_ACT, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByBusqueda(Object aCondiciones) throws BaseException, SQLException {
	  
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  RSCOMPEBUSQACT "); 
	    textSQL.append(" WHERE oid_busqueda_act = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RecluBusqueda busqueda = (RecluBusqueda) aCondiciones; 
	    querySelect.setInt(1, busqueda.getOID()); 
	    return querySelect;
	    
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  RSCOMPEBUSQACT "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_comp_busq_act oid, codigo,  descripcion ,activo ");
    textSQL.append(" from RSCOMPEBUSQACT");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCompetenciasBusqueda(RecluBusqueda busqueda,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluCompeBusqAct.NICKNAME,
             DBRecluCompeBusqAct.SELECT_BY_BUSQUEDA,
             busqueda,
             new ListObserver(),
             aSesion);
  }  
  
} 
