package com.srn.erp.presupuesto.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.presupuesto.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBCompoEstructuraPlan extends DBObjetoPersistente {

  public static final String OID_ESTRUC_COMPO = "oid_estruc_compo";
  public static final String OID_ESTRUC_PLAN = "oid_estruc_plan";
  public static final String OID_COMPO_PRESU = "oid_compo_presu";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_ESTRUCTURA_PLAN = 100;

  public DBCompoEstructuraPlan() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTRUC_COMPO = 1;
    final int OID_ESTRUC_PLAN = 2;
    final int OID_COMPO_PRESU = 3;
    final int ACTIVO = 4;

    CompoEstructuraPlan pers = (CompoEstructuraPlan) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into pEstrucPlanCompo "+
                     " ( "+
                      "OID_ESTRUC_COMPO,"+
                      "OID_ESTRUC_PLAN,"+
                      "OID_COMPO_PRESU,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESTRUC_COMPO,pers.getOID());
    qInsert.setInt(OID_ESTRUC_PLAN,pers.getEstructura_plan().getOID());
    qInsert.setInt(OID_COMPO_PRESU,pers.getCompo_presu().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTRUC_PLAN = 1;
    final int OID_COMPO_PRESU = 2;
    final int ACTIVO = 3;
    final int OID_ESTRUC_COMPO = 4;

    CompoEstructuraPlan pers = (CompoEstructuraPlan) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update pEstrucPlanCompo set "+
              "oid_estruc_plan=?"+ 
              ",oid_compo_presu=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_estruc_compo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTRUC_COMPO,pers.getOID());
    qUpdate.setInt(OID_ESTRUC_PLAN,pers.getEstructura_plan().getOID());
    qUpdate.setInt(OID_COMPO_PRESU,pers.getCompo_presu().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTRUC_COMPO = 1; 
    CompoEstructuraPlan pers = (CompoEstructuraPlan) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update pEstrucPlanCompo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_estruc_compo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTRUC_COMPO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTRUC_COMPO = 1; 
    CompoEstructuraPlan pers = (CompoEstructuraPlan) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update pEstrucPlanCompo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_estruc_compo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTRUC_COMPO, pers.getOID()); 
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
      case SELECT_BY_ESTRUCTURA_PLAN: {
        ps = this.selectByEstructuraPlan(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ESTRUC_COMPO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  pEstrucPlanCompo "); 
    textSQL.append(" WHERE oid_estruc_compo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESTRUC_COMPO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  pEstrucPlanCompo "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEstructuraPlan(Object aCondiciones) throws BaseException, SQLException {
  	
  	EstructuraPlan estructuraPlan = (EstructuraPlan) aCondiciones;
  	
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  pEstrucPlanCompo "); 
    textSQL.append(" WHERE oid_estruc_plan = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    querySelect.setInt(1, estructuraPlan.getOID()); 
    return querySelect; 
  }
  
  
    private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_estruc_compo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from pEstrucPlanCompo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
    
    public static List getCompoEstrucPlan(EstructuraPlan estructuraPlan,
        ISesion aSesion) throws BaseException {
    	return (List) ObjetoLogico.getObjects(CompoEstructuraPlan.NICKNAME,
           DBCompoEstructuraPlan.SELECT_BY_ESTRUCTURA_PLAN,
           estructuraPlan,
           new ListObserver(),
           aSesion);
    }
    
  
} 
