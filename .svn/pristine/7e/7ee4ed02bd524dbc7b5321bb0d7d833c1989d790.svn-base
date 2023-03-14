package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excluidos.bm.GrupoImportacionExcMaq;
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

public class DBGrupoImportacionExcMaq extends DBObjetoPersistente {

  public static final String OID_GRUPO_IMP_MAQ = "oid_grupo_imp_maq";
  public static final String OID_GRUPO_IMP_EXC = "oid_grupo_imp_exc";
  public static final String OID_MAQUINA = "oid_maquina";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_GRUPO_IMP_EXC = 100;

  public DBGrupoImportacionExcMaq() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_IMP_MAQ = 1;
    final int OID_GRUPO_IMP_EXC = 2;
    final int OID_MAQUINA = 3;
    final int ACTIVO = 4;

    GrupoImportacionExcMaq pers = (GrupoImportacionExcMaq) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excGrupoImpMaq "+
                     " ( "+
                      "OID_GRUPO_IMP_MAQ,"+
                      "OID_GRUPO_IMP_EXC,"+
                      "OID_MAQUINA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_GRUPO_IMP_MAQ,pers.getOID());
    qInsert.setInt(OID_GRUPO_IMP_EXC,pers.getGrupo_imp_exc().getOID());
    qInsert.setInt(OID_MAQUINA,pers.getMaquina().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_GRUPO_IMP_EXC = 1;
    final int OID_MAQUINA = 2;
    final int ACTIVO = 3;
    final int OID_GRUPO_IMP_MAQ = 4;

    GrupoImportacionExcMaq pers = (GrupoImportacionExcMaq) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excGrupoImpMaq set "+
              "oid_grupo_imp_exc=?"+ 
              ",oid_maquina=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_grupo_imp_maq=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_IMP_MAQ,pers.getOID());
    qUpdate.setInt(OID_GRUPO_IMP_EXC,pers.getGrupo_imp_exc().getOID());
    qUpdate.setInt(OID_MAQUINA,pers.getMaquina().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_IMP_MAQ = 1; 
    GrupoImportacionExcMaq pers = (GrupoImportacionExcMaq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excGrupoImpMaq "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_grupo_imp_maq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_IMP_MAQ, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_GRUPO_IMP_MAQ = 1; 
    GrupoImportacionExcMaq pers = (GrupoImportacionExcMaq) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excGrupoImpMaq "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_grupo_imp_maq=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_GRUPO_IMP_MAQ, pers.getOID()); 
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

    final int OID_GRUPO_IMP_MAQ = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excGrupoImpMaq "); 
    textSQL.append(" WHERE oid_grupo_imp_maq = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_GRUPO_IMP_MAQ, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByGrupoImpExc(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excGrupoImpMaq "); 
	    textSQL.append(" WHERE oid_grupo_imp_exc = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    GrupoImportacionExcluido grupo = (GrupoImportacionExcluido) aCondiciones; 
	    querySelect.setInt(1, grupo.getOID()); 
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excGrupoImpMaq "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_grupo_imp_maq oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excGrupoImpMaq");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getGrupoImpExcMaq(GrupoImportacionExcluido grupo,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(GrupoImportacionExcMaq.NICKNAME,
             DBGrupoImportacionExcMaq.SELECT_BY_GRUPO_IMP_EXC,
             grupo,
             new ListObserver(),
             aSesion);
  }  
  
} 
