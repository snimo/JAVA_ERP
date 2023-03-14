package com.srn.erp.presupuesto.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.presupuesto.bm.VarEscenarioCab;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBVarEscenarioCab extends DBObjetoPersistente {

  public static final String OID_VAR_ESC_CAB = "oid_var_esc_cab";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_TIPO_PERI = "oid_tipo_peri";
  public static final String ACTIVO = "activo";

  public DBVarEscenarioCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_VAR_ESC_CAB = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int OID_TIPO_PERI = 4;
    final int ACTIVO = 5;

    VarEscenarioCab pers = (VarEscenarioCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plVarEsceCab "+
                     " ( "+
                      "OID_VAR_ESC_CAB,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "OID_TIPO_PERI,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_VAR_ESC_CAB,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    if (pers.getTipo_periodo()!=null)
    	qInsert.setInt(OID_TIPO_PERI,pers.getTipo_periodo().getOID());
    else
    	qInsert.setNull(OID_TIPO_PERI,Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int OID_TIPO_PERI = 3;
    final int ACTIVO = 4;
    final int OID_VAR_ESC_CAB = 5;

    VarEscenarioCab pers = (VarEscenarioCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plVarEsceCab set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",oid_tipo_peri=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_var_esc_cab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAR_ESC_CAB,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    if (pers.getTipo_periodo()!=null)
    	qUpdate.setInt(OID_TIPO_PERI,pers.getTipo_periodo().getOID());
    else
    	qUpdate.setNull(OID_TIPO_PERI,Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAR_ESC_CAB = 1; 
    VarEscenarioCab pers = (VarEscenarioCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plVarEsceCab "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_var_esc_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAR_ESC_CAB, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_VAR_ESC_CAB = 1; 
    VarEscenarioCab pers = (VarEscenarioCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plVarEsceCab "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_var_esc_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_VAR_ESC_CAB, pers.getOID()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_VAR_ESC_CAB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plVarEsceCab "); 
    textSQL.append(" WHERE oid_var_esc_cab = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_VAR_ESC_CAB, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plVarEsceCab "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_var_esc_cab oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from plVarEsceCab");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
