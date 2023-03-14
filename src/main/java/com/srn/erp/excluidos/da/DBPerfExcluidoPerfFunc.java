package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.PerfExcluidoPerfFunc;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;

public class DBPerfExcluidoPerfFunc extends DBObjetoPersistente {

  public static final String OID_EXC_PERF_FUNC = "oid_exc_perf_func";
  public static final String OID_PERF_FUNC = "oid_perf_func";
  public static final String OID_SEGU_PERFIL = "oid_segu_perfil";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PERFIL_FUNCIONAL = 100;

  public DBPerfExcluidoPerfFunc() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EXC_PERF_FUNC = 1;
    final int OID_PERF_FUNC = 2;
    final int OID_SEGU_PERFIL = 3;
    final int ACTIVO = 4;

    PerfExcluidoPerfFunc pers = (PerfExcluidoPerfFunc) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excPerfFunc "+
                     " ( "+
                      "OID_EXC_PERF_FUNC,"+
                      "OID_PERF_FUNC,"+
                      "OID_SEGU_PERFIL,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EXC_PERF_FUNC,pers.getOID());
    qInsert.setInt(OID_PERF_FUNC,pers.getPerfilfuncional().getOID());
    qInsert.setInt(OID_SEGU_PERFIL,pers.getSeguridadperfil().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PERF_FUNC = 1;
    final int OID_SEGU_PERFIL = 2;
    final int ACTIVO = 3;
    final int OID_EXC_PERF_FUNC = 4;

    PerfExcluidoPerfFunc pers = (PerfExcluidoPerfFunc) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excPerfFunc set "+
              "oid_perf_func=?"+ 
              ",oid_segu_perfil=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_exc_perf_func=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EXC_PERF_FUNC,pers.getOID());
    qUpdate.setInt(OID_PERF_FUNC,pers.getPerfilfuncional().getOID());
    qUpdate.setInt(OID_SEGU_PERFIL,pers.getSeguridadperfil().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EXC_PERF_FUNC = 1; 
    PerfExcluidoPerfFunc pers = (PerfExcluidoPerfFunc) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excPerfFunc "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_exc_perf_func=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EXC_PERF_FUNC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EXC_PERF_FUNC = 1; 
    PerfExcluidoPerfFunc pers = (PerfExcluidoPerfFunc) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excPerfFunc "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_exc_perf_func=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EXC_PERF_FUNC, pers.getOID()); 
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
      case SELECT_BY_PERFIL_FUNCIONAL: {
          ps = this.selectByPerfilFuncional(aCondiciones); 
          break;    	  
      }
      case IDBObjetoPersistente.SELECT_ALL_HELP: { 
        ps = this.selectAllHelp(aCondiciones); 
        break; 
      } 
      case IDBObjetoPersistente.SELECT_ALL_ACTIVOS: { 
          ps = this.selectAllActivos(aCondiciones); 
          break; 
        }      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_EXC_PERF_FUNC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excPerfFunc "); 
    textSQL.append(" WHERE oid_exc_perf_func = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EXC_PERF_FUNC, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excPerfFunc "); 
	    textSQL.append(" WHERE activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
	    
  }  
  
  
  private PreparedStatement selectByPerfilFuncional(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excPerfFunc "); 
	    textSQL.append(" WHERE oid_perf_func = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    PerfilFuncional perfilFuncional = (PerfilFuncional) aCondiciones; 
	    querySelect.setInt(1, perfilFuncional.getOID()); 
	    return querySelect; 
	    
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excPerfFunc "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_exc_perf_func oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excPerfFunc");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getPerfExcluidosPerfFuncional(PerfilFuncional perfil,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(PerfExcluidoPerfFunc.NICKNAME,
             DBPerfExcluidoPerfFunc.SELECT_BY_PERFIL_FUNCIONAL,
             perfil,
             new ListObserver(),
             aSesion);
  }  
  
  
  public static List getAllActivos(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(PerfExcluidoPerfFunc.NICKNAME,
             DBPerfExcluidoPerfFunc.SELECT_ALL_ACTIVOS,
             null,
             new ListObserver(),
             aSesion);
  }  
  
  
  
} 
