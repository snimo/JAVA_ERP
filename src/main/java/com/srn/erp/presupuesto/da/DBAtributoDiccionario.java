package com.srn.erp.presupuesto.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.presupuesto.bm.AtributoDiccionario;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBAtributoDiccionario extends DBObjetoPersistente {

  public static final String OID_ATRI_DICC = "oid_atri_dicc";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String DESC_ADIC = "desc_adic";
  public static final String TIPO_ATRIBUTO = "tipo_atributo";
  public static final String CAMPO_FECHA = "campo_fecha";
  public static final String CAMPO_INTEGER = "campo_integer";
  public static final String CAMPO_DECIMAL = "campo_decimal";
  public static final String CAMPO_STRING = "campo_string";
  public static final String CAMPO_BOOLEAN = "campo_boolean";
  public static final String OID_COMPO_PRESU = "oid_compo_presu";
  public static final String ACTIVO = "activo";
  public static final String OID_VALOR_COMPO_PRESU = "oid_val_compo_presu";
  
  public DBAtributoDiccionario() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ATRI_DICC = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int DESC_ADIC = 4;
    final int TIPO_ATRIBUTO = 5;
    final int CAMPO_FECHA = 6;
    final int CAMPO_INTEGER = 7;
    final int CAMPO_DECIMAL = 8;
    final int CAMPO_STRING = 9;
    final int CAMPO_BOOLEAN = 10;
    final int OID_COMPO_PRESU = 11;
    final int ACTIVO = 12;
    final int OID_VALOR_COMPO_PRESU = 13;

    AtributoDiccionario pers = (AtributoDiccionario) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into plAtriDicc "+
                     " ( "+
                      "OID_ATRI_DICC,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "DESC_ADIC,"+
                      "TIPO_ATRIBUTO,"+
                      "CAMPO_FECHA,"+
                      "CAMPO_INTEGER,"+
                      "CAMPO_DECIMAL,"+
                      "CAMPO_STRING,"+
                      "CAMPO_BOOLEAN,"+
                      "OID_COMPO_PRESU,"+
                      "ACTIVO,"+
                      "OID_VAL_COMPO_PRESU)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ATRI_DICC,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(DESC_ADIC,pers.getDesc_adic());
    qInsert.setString(TIPO_ATRIBUTO,pers.getTipo_atributo());
    if (pers.getCampo_fecha()!=null) 
      qInsert.setDate(CAMPO_FECHA,new Date(pers.getCampo_fecha().getTime()));
    else
      qInsert.setNull(CAMPO_FECHA,java.sql.Types.DATE);
    if (pers.getCampo_integer()!=null)
    	qInsert.setInt(CAMPO_INTEGER,pers.getCampo_integer().intValue());
    else
    	qInsert.setNull(CAMPO_INTEGER,Types.INTEGER);
    if (pers.getCampo_decimal()!=null)
    	qInsert.setDouble(CAMPO_DECIMAL,pers.getCampo_decimal().doubleValue());
    else
    	qInsert.setNull(CAMPO_DECIMAL,Types.DOUBLE);
    if (pers.getCampo_string()!=null)
    	qInsert.setString(CAMPO_STRING,pers.getCampo_string());
    else
    	qInsert.setNull(CAMPO_STRING,Types.VARCHAR);
    qInsert.setBoolean(CAMPO_BOOLEAN,pers.getCampo_boolean().booleanValue());
    if (pers.getCompo_presu()!=null) 
      qInsert.setInt(OID_COMPO_PRESU,pers.getCompo_presu().getOID());
    else
      qInsert.setNull(OID_COMPO_PRESU,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getValorCompoPresu()!=null)
    	qInsert.setInt(OID_VALOR_COMPO_PRESU,pers.getValorCompoPresu().getOID());
    else
    	qInsert.setInt(OID_VALOR_COMPO_PRESU,java.sql.Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int DESC_ADIC = 3;
    final int TIPO_ATRIBUTO = 4;
    final int CAMPO_FECHA = 5;
    final int CAMPO_INTEGER = 6;
    final int CAMPO_DECIMAL = 7;
    final int CAMPO_STRING = 8;
    final int CAMPO_BOOLEAN = 9;
    final int OID_COMPO_PRESU = 10;
    final int ACTIVO = 11;
    final int OID_VALOR_COMPO_PRESU = 12;
    final int OID_ATRI_DICC = 13;

    AtributoDiccionario pers = (AtributoDiccionario) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update plAtriDicc set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",desc_adic=?"+ 
              ",tipo_atributo=?"+ 
              ",campo_fecha=?"+ 
              ",campo_integer=?"+ 
              ",campo_decimal=?"+ 
              ",campo_string=?"+ 
              ",campo_boolean=?"+ 
              ",oid_compo_presu=?"+ 
              ",activo=?"+ 
              ",oid_val_compo_presu=?"+
                 " where " +
                 " oid_atri_dicc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ATRI_DICC,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(DESC_ADIC,pers.getDesc_adic());
    qUpdate.setString(TIPO_ATRIBUTO,pers.getTipo_atributo());
    if (pers.getCampo_fecha()!=null) 
      qUpdate.setDate(CAMPO_FECHA,new Date(pers.getCampo_fecha().getTime()));
    else
      qUpdate.setNull(CAMPO_FECHA,java.sql.Types.DATE);
    if (pers.getCampo_integer()!=null)
    	qUpdate.setInt(CAMPO_INTEGER,pers.getCampo_integer().intValue());
    else
    	qUpdate.setNull(CAMPO_INTEGER,Types.INTEGER);
    if (pers.getCampo_decimal()!=null)
    	qUpdate.setDouble(CAMPO_DECIMAL,pers.getCampo_decimal().doubleValue());
    else
    	qUpdate.setNull(CAMPO_DECIMAL,Types.DOUBLE);
    if (pers.getCampo_string()!=null)
    	qUpdate.setString(CAMPO_STRING,pers.getCampo_string());
    else
    	qUpdate.setNull(CAMPO_STRING,Types.VARCHAR);
    if (pers.getCampo_boolean()!=null)
    	qUpdate.setBoolean(CAMPO_BOOLEAN,pers.getCampo_boolean().booleanValue());
    else
    	qUpdate.setNull(CAMPO_BOOLEAN,Types.BOOLEAN);
    if (pers.getCompo_presu()!=null) 
      qUpdate.setInt(OID_COMPO_PRESU,pers.getCompo_presu().getOID());
    else
      qUpdate.setNull(OID_COMPO_PRESU,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getValorCompoPresu()!=null)
    	qUpdate.setInt(OID_VALOR_COMPO_PRESU,pers.getValorCompoPresu().getOID());
    else
    	qUpdate.setInt(OID_VALOR_COMPO_PRESU,java.sql.Types.INTEGER);

    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ATRI_DICC = 1; 
    AtributoDiccionario pers = (AtributoDiccionario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plAtriDicc "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_atri_dicc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ATRI_DICC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ATRI_DICC = 1; 
    AtributoDiccionario pers = (AtributoDiccionario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update plAtriDicc "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_atri_dicc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ATRI_DICC, pers.getOID()); 
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

    final int OID_ATRI_DICC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plAtriDicc "); 
    textSQL.append(" WHERE oid_atri_dicc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ATRI_DICC, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  plAtriDicc "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_atri_dicc oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from plAtriDicc");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
