package com.srn.erp.general.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBUniOrgTalonario extends DBObjetoPersistente {

  public static final String OID_UNI_ORG_TAL = "oid_uni_org_tal";
  public static final String OID_TALONARIO = "oid_talonario";
  public static final String OID_UNI_ORG = "oid_uni_org";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_TALONARIO = 100;

  public DBUniOrgTalonario() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_UNI_ORG_TAL = 1;
    final int OID_TALONARIO = 2;
    final int OID_UNI_ORG = 3;
    final int ACTIVO = 4;

    UniOrgTalonario pers = (UniOrgTalonario) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geUniOrgTalonario "+
                     " ( "+
                      "OID_UNI_ORG_TAL,"+
                      "OID_TALONARIO,"+
                      "OID_UNI_ORG,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_UNI_ORG_TAL,pers.getOID());
    qInsert.setInt(OID_TALONARIO,pers.getTalonario().getOID());
    qInsert.setInt(OID_UNI_ORG,pers.getUnidad_organizativa().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TALONARIO = 1;
    final int OID_UNI_ORG = 2;
    final int ACTIVO = 3;
    final int OID_UNI_ORG_TAL = 4;

    UniOrgTalonario pers = (UniOrgTalonario) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geUniOrgTalonario set "+
              "oid_talonario=?"+ 
              ",oid_uni_org=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_uni_org_tal=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_UNI_ORG_TAL,pers.getOID());
    qUpdate.setInt(OID_TALONARIO,pers.getTalonario().getOID());
    qUpdate.setInt(OID_UNI_ORG,pers.getUnidad_organizativa().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_UNI_ORG_TAL = 1; 
    UniOrgTalonario pers = (UniOrgTalonario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from geUniOrgTalonario "+
                     " where " + 
                     " oid_uni_org_tal=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_UNI_ORG_TAL, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_UNI_ORG_TAL = 1; 
    UniOrgTalonario pers = (UniOrgTalonario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geUniOrgTalonario "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_uni_org_tal=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_UNI_ORG_TAL, pers.getOID()); 
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
      case SELECT_BY_TALONARIO: {
        ps = this.selectByTalonario(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_UNI_ORG_TAL = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geUniOrgTalonario "); 
    textSQL.append(" WHERE oid_uni_org_tal = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_UNI_ORG_TAL, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geUniOrgTalonario "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_uni_org_tal oid, codigo,  descripcion ,activo ");
    textSQL.append(" from geUniOrgTalonario");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByTalonario(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT * ");
    textSQL.append(" from geUniOrgTalonario where oid_talonario = ?");
    
    Talonario talonario = (Talonario) aCondiciones;
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,talonario.getOID());
    return querySelect; 
  } 
  
  public static List getUnidadesOrgTalonario(Talonario talonario,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(UniOrgTalonario.NICKNAME,
  			 DBUniOrgTalonario.SELECT_BY_TALONARIO,
         talonario,
         new ListObserver(),
         aSesion);
  }
  
  
  
  
} 
