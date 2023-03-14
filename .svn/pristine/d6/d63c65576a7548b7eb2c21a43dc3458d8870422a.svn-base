package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluPermisosOper;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRecluPermisosOper extends DBObjetoPersistente {

  public static final String OID_OPER_HAB = "oid_oper_hab";
  public static final String OID_OPERACION = "oid_operacion";
  public static final String OID_PEF_FUNC = "oid_perf_func";
  public static final String TIPO_OPER = "tipo_oper";
  public static final String ACTIVO = "activo";
  
  private static final int SELECT_BY_OPERACION  = 100;

  public DBRecluPermisosOper() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_OPER_HAB = 1;
    final int OID_OPERACION = 2;
    final int OID_PEF_FUNC = 3;
    final int TIPO_OPER = 4;
    final int ACTIVO = 5;

    RecluPermisosOper pers = (RecluPermisosOper) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into RSOPERHABPERMI "+
                     " ( "+
                      "OID_OPER_HAB,"+
                      "OID_OPERACION,"+
                      "OID_PERF_FUNC,"+
                      "TIPO_OPER,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_OPER_HAB,pers.getOID());
    qInsert.setInt(OID_OPERACION,pers.getOperacion().getOID());
    qInsert.setInt(OID_PEF_FUNC,pers.getPerfil_funcional().getOID());
    qInsert.setString(TIPO_OPER,pers.getTipo_oper());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_OPERACION = 1;
    final int OID_PEF_FUNC = 2;
    final int TIPO_OPER = 3;
    final int ACTIVO = 4;
    final int OID_OPER_HAB = 5;

    RecluPermisosOper pers = (RecluPermisosOper) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update RSOPERHABPERMI set "+
              "oid_operacion=?"+ 
              ",oid_perf_func=?"+ 
              ",tipo_oper=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_oper_hab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OPER_HAB,pers.getOID());
    qUpdate.setInt(OID_OPERACION,pers.getOperacion().getOID());
    qUpdate.setInt(OID_PEF_FUNC,pers.getPerfil_funcional().getOID());
    qUpdate.setString(TIPO_OPER,pers.getTipo_oper());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OPER_HAB = 1; 
    RecluPermisosOper pers = (RecluPermisosOper) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update RSOPERHABPERMI "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_oper_hab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OPER_HAB, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OPER_HAB = 1; 
    RecluPermisosOper pers = (RecluPermisosOper) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update RSOPERHABPERMI "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_oper_hab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OPER_HAB, pers.getOID()); 
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
      case SELECT_BY_OPERACION: {
    	  ps = this.selectByOperacion(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_OPER_HAB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  RSOPERHABPERMI "); 
    textSQL.append(" WHERE oid_oper_hab = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_OPER_HAB, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByOperacion(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  RSOPERHABPERMI "); 
	    textSQL.append(" WHERE oid_operacion = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RecluOperacion oper = (RecluOperacion) aCondiciones; 
	    querySelect.setInt(1, oper.getOID()); 
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  RSOPERHABPERMI "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_oper_hab oid, codigo,  descripcion ,activo ");
    textSQL.append(" from RSOPERHABPERMI");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getPermisosOperacion(RecluOperacion operacion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluPermisosOper.NICKNAME,
             DBRecluPermisosOper.SELECT_BY_OPERACION,
             operacion,
             new ListObserver(),
             aSesion);
  }  
  
} 
