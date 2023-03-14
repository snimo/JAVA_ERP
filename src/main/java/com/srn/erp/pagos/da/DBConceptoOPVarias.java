package com.srn.erp.pagos.da;

import java.sql.*;
import java.util.Hashtable;

import com.srn.erp.pagos.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBConceptoOPVarias extends DBObjetoPersistente {

  public static final String OID_CONC_PV = "oid_conc_pv";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_AI = "oid_ai";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_HELP_CONCEPTOS_UNI_ORG = 100;
  public static final int SELECT_BY_CODIGO_UNI_ORG = 101;

  public DBConceptoOPVarias() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CONC_PV = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int OID_AI = 4;
    final int ACTIVO = 5;

    ConceptoOPVarias pers = (ConceptoOPVarias) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opConcPagosVar "+
                     " ( "+
                      "OID_CONC_PV,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "OID_AI,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CONC_PV,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int OID_AI = 3;
    final int ACTIVO = 4;
    final int OID_CONC_PV = 5;

    ConceptoOPVarias pers = (ConceptoOPVarias) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opConcPagosVar set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",oid_ai=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_conc_pv=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_PV,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONC_PV = 1; 
    ConceptoOPVarias pers = (ConceptoOPVarias) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opConcPagosVar "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_conc_pv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_PV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CONC_PV = 1; 
    ConceptoOPVarias pers = (ConceptoOPVarias) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opConcPagosVar "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_conc_pv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CONC_PV, pers.getOID()); 
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
      case SELECT_BY_HELP_CONCEPTOS_UNI_ORG: {
        ps = this.selectByHelpConceptosUniOrg(aCondiciones); 
        break; 
      }
      case SELECT_BY_CODIGO_UNI_ORG: {
        ps = this.selectByCodigoUniOrg(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CONC_PV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opConcPagosVar "); 
    textSQL.append(" WHERE oid_conc_pv = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CONC_PV, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opConcPagosVar "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  
  private PreparedStatement selectByHelpConceptosUniOrg(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    Integer oidEmpresa = this.getSesion().getLogin().getOidEmpresa();
    Integer oidSucursal = this.getSesion().getLogin().getOidSucursal();
    Integer oidUsuario = this.getSesion().getLogin().getUsuario().getOIDInteger();
    
    textSQL.append(" select ");
    textSQL.append("    oid_conc_pv oid, ");
    textSQL.append("    codigo codigo, ");
    textSQL.append("    descripcion descripcion ,");
    textSQL.append("    activo ");
    textSQL.append(" from opConcPagosVar where activo=1 and oid_conc_pv in ");
    textSQL.append(" (select ");
    textSQL.append("    oid_conc_pv ");
    textSQL.append("  from opConcPVHab ");
    textSQL.append("  where activo=1 and oid_uni_org in ");
    textSQL.append("  (select oid_uni_org from seUniOrgHabUsu where oid_empresa="+oidEmpresa+" and oid_sucursal="+oidSucursal+" and oid_usuario="+oidUsuario+")) ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigoUniOrg(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    Integer oidEmpresa = this.getSesion().getLogin().getOidEmpresa();
    Integer oidSucursal = this.getSesion().getLogin().getOidSucursal();
    Integer oidUsuario = this.getSesion().getLogin().getUsuario().getOIDInteger();
    
    textSQL.append(" select ");
    textSQL.append("    * ");
    textSQL.append(" from opConcPagosVar where codigo = ? and activo=1 and oid_conc_pv in ");
    textSQL.append(" (select ");
    textSQL.append("    oid_conc_pv ");
    textSQL.append("  from opConcPVHab ");
    textSQL.append("  where activo=1 and oid_uni_org in ");
    textSQL.append("  (select oid_uni_org from seUniOrgHabUsu where oid_empresa="+oidEmpresa+" and oid_sucursal="+oidSucursal+" and oid_usuario="+oidUsuario+")) ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    
    Hashtable condiciones = (Hashtable) aCondiciones;
    String codigo = (String) condiciones.get("codigo");
    querySelect.setString(1, codigo);
    
    return querySelect; 
  	
  }
  

  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conc_pv oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from opConcPagosVar");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
