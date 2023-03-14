package com.srn.erp.excluidos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.excluidos.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBGrupoImportacionExcEst extends DBObjetoPersistente {

  public static final String OID_GRUPO_IMPO_EST = "oid_grupo_impo_est";
  public static final String OID_GRUPO_IMP_EXC = "oid_grupo_imp_exc";
  public static final String OID_PREDIO = "oid_predio";
  public static final String OID_ESTADO = "oid_estado";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_GRUPO_IMP_EXC = 100;

  public DBGrupoImportacionExcEst() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_IMPO_EST = 1;
    final int OID_GRUPO_IMP_EXC = 2;
    final int OID_PREDIO = 3;
    final int OID_ESTADO = 4;
    final int ACTIVO = 5;

    GrupoImportacionExcEst pers = (GrupoImportacionExcEst) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excGrupoImpEst "+
                     " ( "+
                      "OID_GRUPO_IMPO_EST,"+
                      "OID_GRUPO_IMP_EXC,"+
                      "OID_PREDIO,"+
                      "OID_ESTADO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_IMPO_EST,pers.getOID());
    if (pers.getGrupo_imp_esc()!=null) 
      qInsert.setInt(OID_GRUPO_IMP_EXC,pers.getGrupo_imp_esc().getOID());
    else
      qInsert.setNull(OID_GRUPO_IMP_EXC,java.sql.Types.INTEGER);
    qInsert.setInt(OID_PREDIO,pers.getPredio().getOID());
    qInsert.setInt(OID_ESTADO,pers.getEstado().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_IMP_EXC = 1;
    final int OID_PREDIO = 2;
    final int OID_ESTADO = 3;
    final int ACTIVO = 4;
    final int OID_GRUPO_IMPO_EST = 5;

    GrupoImportacionExcEst pers = (GrupoImportacionExcEst) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excGrupoImpEst set "+
              "oid_grupo_imp_exc=?"+ 
              ",oid_predio=?"+ 
              ",oid_estado=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupo_impo_est=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_IMPO_EST,pers.getOID());
    if (pers.getGrupo_imp_esc()!=null) 
      qUpdate.setInt(OID_GRUPO_IMP_EXC,pers.getGrupo_imp_esc().getOID());
    else
      qUpdate.setNull(OID_GRUPO_IMP_EXC,java.sql.Types.INTEGER);
    qUpdate.setInt(OID_PREDIO,pers.getPredio().getOID());
    qUpdate.setInt(OID_ESTADO,pers.getEstado().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_IMPO_EST = 1; 
    GrupoImportacionExcEst pers = (GrupoImportacionExcEst) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excGrupoImpEst "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo_impo_est=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_IMPO_EST, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_IMPO_EST = 1; 
    GrupoImportacionExcEst pers = (GrupoImportacionExcEst) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excGrupoImpEst "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_impo_est=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_IMPO_EST, pers.getOID()); 
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
      case SELECT_BY_GRUPO_IMP_EXC: {
          ps = this.selectByGrupoImpExc(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_GRUPO_IMPO_EST = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excGrupoImpEst "); 
    textSQL.append(" WHERE oid_grupo_impo_est = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_IMPO_EST, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByGrupoImpExc(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excGrupoImpEst "); 
	    textSQL.append(" WHERE oid_grupo_imp_exc = ? and activo = 1");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    GrupoImportacionExcluido grupoImpExc = (GrupoImportacionExcluido) aCondiciones; 
	    querySelect.setInt(1, grupoImpExc.getOID()); 
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excGrupoImpEst "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_impo_est oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excGrupoImpEst");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getGruposImpExcEstados(
		  GrupoImportacionExcluido grupoImportacion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(GrupoImportacionExcEst.NICKNAME,
             DBGrupoImportacionExcEst.SELECT_BY_GRUPO_IMP_EXC,
             grupoImportacion,
             new ListObserver(),
             aSesion);
  }  
  
} 
