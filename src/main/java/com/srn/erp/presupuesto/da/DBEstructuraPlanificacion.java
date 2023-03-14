package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.presupuesto.bm.EstructuraPlanificacion;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEstructuraPlanificacion extends DBObjetoPersistente {

  public static final String OID_ESTRUC_PLANIF = "oid_estruc_planif";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String OID_GRUPO_ESTRUCTURA_PLANIF = "oid_grupo_est";

  public DBEstructuraPlanificacion() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTRUC_PLANIF = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int OID_GRUPO_EST = 5;

    EstructuraPlanificacion pers = (EstructuraPlanificacion) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plEstrucPlanif "+
                     " ( "+
                      "OID_ESTRUC_PLANIF,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,OID_GRUPO_EST)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESTRUC_PLANIF,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_GRUPO_EST,pers.getGrupoEstructuraPlanif().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int OID_GRUPO_EST = 4;
    final int OID_ESTRUC_PLANIF = 5;

    EstructuraPlanificacion pers = (EstructuraPlanificacion) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plEstrucPlanif set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+
              ",oid_grupo_est=?"+ 
                 " where " +
                 " oid_estruc_planif=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTRUC_PLANIF,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_GRUPO_EST,pers.getGrupoEstructuraPlanif().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTRUC_PLANIF = 1; 
    EstructuraPlanificacion pers = (EstructuraPlanificacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plEstrucPlanif "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_estruc_planif=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTRUC_PLANIF, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTRUC_PLANIF = 1; 
    EstructuraPlanificacion pers = (EstructuraPlanificacion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plEstrucPlanif "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_estruc_planif=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTRUC_PLANIF, pers.getOID()); 
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
      case SELECT_ALL: {
        ps = this.selectAll(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ESTRUC_PLANIF = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plEstrucPlanif "); 
    textSQL.append(" WHERE oid_estruc_planif = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESTRUC_PLANIF, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plEstrucPlanif "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plEstrucPlanif "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_estruc_planif oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from plEstrucPlanif");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAllEstructuras(ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(EstructuraPlanificacion.NICKNAME,
         DBEstructuraPlanificacion.SELECT_ALL,
         null,
         new ListObserver(),
         aSesion);
  }
  
  
} 
