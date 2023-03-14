package com.srn.erp.bienUso.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bienUso.bm.ConfColAnexoA;
import com.srn.erp.bienUso.bm.ConfColAnexoAMov;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBConfColAnexoAMov extends DBObjetoPersistente {

  public static final String OID_CONF_ANEXO_MOV = "oid_conf_anexo_mov";
  public static final String OID_CONF_ANEXO_A = "oid_conf_anexo_a";
  public static final String TIPO_MOV = "tipo_mov";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_CONF_ANEXO_A = 100;

  public DBConfColAnexoAMov() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONF_ANEXO_MOV = 1;
    final int OID_CONF_ANEXO_A = 2;
    final int TIPO_MOV = 3;
    final int ACTIVO = 4;

    ConfColAnexoAMov pers = (ConfColAnexoAMov) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into buConfAnexoAMov "+
                     " ( "+
                      "OID_CONF_ANEXO_MOV,"+
                      "OID_CONF_ANEXO_A,"+
                      "TIPO_MOV,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CONF_ANEXO_MOV,pers.getOID());
    qInsert.setInt(OID_CONF_ANEXO_A,pers.getConf_col_aneoxo().getOID());
    qInsert.setString(TIPO_MOV,pers.getTipo_mov());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONF_ANEXO_A = 1;
    final int TIPO_MOV = 2;
    final int ACTIVO = 3;
    final int OID_CONF_ANEXO_MOV = 4;

    ConfColAnexoAMov pers = (ConfColAnexoAMov) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update buConfAnexoAMov set "+
              "oid_conf_anexo_a=?"+ 
              ",tipo_mov=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_conf_anexo_mov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONF_ANEXO_MOV,pers.getOID());
    qUpdate.setInt(OID_CONF_ANEXO_A,pers.getConf_col_aneoxo().getOID());
    qUpdate.setString(TIPO_MOV,pers.getTipo_mov());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONF_ANEXO_MOV = 1; 
    ConfColAnexoAMov pers = (ConfColAnexoAMov) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from  buConfAnexoAMov "+
                     " where " + 
                     " oid_conf_anexo_mov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONF_ANEXO_MOV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONF_ANEXO_MOV = 1; 
    ConfColAnexoAMov pers = (ConfColAnexoAMov) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buConfAnexoAMov "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_conf_anexo_mov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONF_ANEXO_MOV, pers.getOID()); 
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
      case SELECT_BY_CONF_ANEXO_A: {
        ps = this.selectByConfAnexoA(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CONF_ANEXO_MOV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buConfAnexoAMov "); 
    textSQL.append(" WHERE oid_conf_anexo_mov = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CONF_ANEXO_MOV, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByConfAnexoA(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  buConfAnexoAMov "); 
	    textSQL.append(" WHERE oid_conf_anexo_a = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ConfColAnexoA confColAnexoA =  (ConfColAnexoA) aCondiciones;
	    querySelect.setInt(1, confColAnexoA.getOID()); 
	    return querySelect; 
  }  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buConfAnexoAMov "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conf_anexo_mov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from buConfAnexoAMov");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  

  public static List getConfColAnexoAMov(ConfColAnexoA condColAnexoA,
                                         ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ConfColAnexoAMov.NICKNAME,
                                          DBConfColAnexoAMov.SELECT_BY_CONF_ANEXO_A,
                                          condColAnexoA,
                                          new ListObserver(),
                                          aSesion);
  }
  
  
} 
