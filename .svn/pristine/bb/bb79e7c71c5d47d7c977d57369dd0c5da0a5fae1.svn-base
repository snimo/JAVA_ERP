package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.GrupoImportacionExcPeli;
import com.srn.erp.excluidos.bm.GrupoImportacionExcluido;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBGrupoImportacionExcPeli extends DBObjetoPersistente {

  public static final String OID_GRUPO_IMPO_PELI = "oid_grupo_impo_peli";
  public static final String OID_GRUPO_IMP_EXC = "oid_grupo_imp_exc";
  public static final String OID_PREDIO = "oid_predio";
  public static final String OID_PELIGROSIDAD = "oid_peligrosidad";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_GRUPO_IMP_EXC = 100;

  public DBGrupoImportacionExcPeli() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_IMPO_PELI = 1;
    final int OID_GRUPO_IMP_EXC = 2;
    final int OID_PREDIO = 3;
    final int OID_PELIGROSIDAD = 4;
    final int ACTIVO = 5;

    GrupoImportacionExcPeli pers = (GrupoImportacionExcPeli) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excGrupoImpoPeli "+
                     " ( "+
                      "OID_GRUPO_IMPO_PELI,"+
                      "OID_GRUPO_IMP_EXC,"+
                      "OID_PREDIO,"+
                      "OID_PELIGROSIDAD,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_IMPO_PELI,pers.getOID());
    if (pers.getGrupo_imp_esc()!=null) 
      qInsert.setInt(OID_GRUPO_IMP_EXC,pers.getGrupo_imp_esc().getOID());
    else
      qInsert.setNull(OID_GRUPO_IMP_EXC,java.sql.Types.INTEGER);
    qInsert.setInt(OID_PREDIO,pers.getPredio().getOID());
    qInsert.setInt(OID_PELIGROSIDAD,pers.getPeligrosidad().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_IMP_EXC = 1;
    final int OID_PREDIO = 2;
    final int OID_PELIGROSIDAD = 3;
    final int ACTIVO = 4;
    final int OID_GRUPO_IMPO_PELI = 5;

    GrupoImportacionExcPeli pers = (GrupoImportacionExcPeli) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excGrupoImpoPeli set "+
              "oid_grupo_imp_exc=?"+ 
              ",oid_predio=?"+ 
              ",oid_peligrosidad=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupo_impo_peli=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_IMPO_PELI,pers.getOID());
    if (pers.getGrupo_imp_esc()!=null) 
      qUpdate.setInt(OID_GRUPO_IMP_EXC,pers.getGrupo_imp_esc().getOID());
    else
      qUpdate.setNull(OID_GRUPO_IMP_EXC,java.sql.Types.INTEGER);
    qUpdate.setInt(OID_PREDIO,pers.getPredio().getOID());
    qUpdate.setInt(OID_PELIGROSIDAD,pers.getPeligrosidad().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_IMPO_PELI = 1; 
    GrupoImportacionExcPeli pers = (GrupoImportacionExcPeli) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excGrupoImpoPeli "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo_impo_peli=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_IMPO_PELI, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_IMPO_PELI = 1; 
    GrupoImportacionExcPeli pers = (GrupoImportacionExcPeli) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excGrupoImpoPeli "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_impo_peli=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_IMPO_PELI, pers.getOID()); 
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

    final int OID_GRUPO_IMPO_PELI = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excGrupoImpoPeli "); 
    textSQL.append(" WHERE oid_grupo_impo_peli = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_IMPO_PELI, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByGrupoImpExc(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excGrupoImpoPeli "); 
	    textSQL.append(" WHERE oid_grupo_imp_exc = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    GrupoImportacionExcluido grupo = (GrupoImportacionExcluido) aCondiciones; 
	    querySelect.setInt(1, grupo.getOID()); 
	    return querySelect; 
	    
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excGrupoImpoPeli "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_impo_peli oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excGrupoImpoPeli");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getGrupoImportacionExcPeli(
		  GrupoImportacionExcluido grupoImportacion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(GrupoImportacionExcPeli.NICKNAME,
             DBGrupoImportacionExcPeli.SELECT_BY_GRUPO_IMP_EXC,
             grupoImportacion,
             new ListObserver(),
             aSesion);
  }  
  
} 
