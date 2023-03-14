package com.srn.erp.cubo.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.cubo.bm.DimensionCubo;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBDimensionCubo extends DBObjetoPersistente {

  public static final String OID_DIMENSION = "oid_dimension";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String TIPO_DIMENSION = "tipo_dimension";
  public static final String OID_SELECT = "oid_select";
  public static final String NOMBRE_OPER = "nombre_oper";
  public static final String OID_CLASIF_ENT = "oid_clasif_ent";
  public static final String ACTIVO = "activo";

  public DBDimensionCubo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DIMENSION = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int TIPO_DIMENSION = 4;
    final int OID_SELECT = 5;
    final int NOMBRE_OPER = 6;
    final int OID_CLASIF_ENT = 7;
    final int ACTIVO = 8;

    DimensionCubo pers = (DimensionCubo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cuDimensiones "+
                     " ( "+
                      "OID_DIMENSION,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "TIPO_DIMENSION,"+
                      "OID_SELECT,"+
                      "NOMBRE_OPER,"+
                      "OID_CLASIF_ENT,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_DIMENSION,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(TIPO_DIMENSION,pers.getTipo_dimension());
    if (pers.getSelect()!=null) 
      qInsert.setInt(OID_SELECT,pers.getSelect().getOID());
    else
      qInsert.setNull(OID_SELECT,java.sql.Types.INTEGER);
    qInsert.setString(NOMBRE_OPER,pers.getNombre_oper());
    if (pers.getClasificador_entidad()!=null) 
      qInsert.setInt(OID_CLASIF_ENT,pers.getClasificador_entidad().getOID());
    else
      qInsert.setNull(OID_CLASIF_ENT,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int TIPO_DIMENSION = 3;
    final int OID_SELECT = 4;
    final int NOMBRE_OPER = 5;
    final int OID_CLASIF_ENT = 6;
    final int ACTIVO = 7;
    final int OID_DIMENSION = 8;

    DimensionCubo pers = (DimensionCubo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cuDimensiones set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",tipo_dimension=?"+ 
              ",oid_select=?"+ 
              ",nombre_oper=?"+ 
              ",oid_clasif_ent=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_dimension=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DIMENSION,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(TIPO_DIMENSION,pers.getTipo_dimension());
    if (pers.getSelect()!=null) 
      qUpdate.setInt(OID_SELECT,pers.getSelect().getOID());
    else
      qUpdate.setNull(OID_SELECT,java.sql.Types.INTEGER);
    qUpdate.setString(NOMBRE_OPER,pers.getNombre_oper());
    if (pers.getClasificador_entidad()!=null) 
      qUpdate.setInt(OID_CLASIF_ENT,pers.getClasificador_entidad().getOID());
    else
      qUpdate.setNull(OID_CLASIF_ENT,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DIMENSION = 1; 
    DimensionCubo pers = (DimensionCubo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cuDimensiones "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_dimension=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DIMENSION, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DIMENSION = 1; 
    DimensionCubo pers = (DimensionCubo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cuDimensiones "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_dimension=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DIMENSION, pers.getOID()); 
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

    final int OID_DIMENSION = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cuDimensiones "); 
    textSQL.append(" WHERE oid_dimension = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DIMENSION, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cuDimensiones "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_dimension oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cuDimensiones");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
