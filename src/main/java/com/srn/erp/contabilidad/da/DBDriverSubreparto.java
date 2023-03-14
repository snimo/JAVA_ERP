package com.srn.erp.contabilidad.da;

import java.sql.*;
import com.srn.erp.contabilidad.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBDriverSubreparto extends DBObjetoPersistente {

  public static final String OID_DRIVER = "oid_driver";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String TIPO_VALOR = "tipo_valor";
  public static final String VALOR = "valor";
  public static final String OID_COMPO = "oid_compo";
  public static final String ACTIVO = "activo";
  public static final String TIPO_SALDO = "tipo_saldo";
  
  
  

  public DBDriverSubreparto() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DRIVER = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int TIPO_VALOR = 4;
    final int VALOR = 5;
    final int OID_COMPO = 6;
    final int ACTIVO = 7;
    final int TIPO_SALDO = 8;
    

    DriverSubreparto pers = (DriverSubreparto) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgDriver "+
                     " ( "+
                      "OID_DRIVER,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "TIPO_VALOR,"+
                      "VALOR,"+
                      "OID_COMPO,"+
                      "ACTIVO,TIPO_SALDO)"+ 
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
    qInsert.setInt(OID_DRIVER,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(TIPO_VALOR,pers.getTipo_valor());
    if (pers.getValor()!=null)
    	qInsert.setDouble(VALOR,pers.getValor().doubleValue());
    else
    	qInsert.setNull(VALOR,java.sql.Types.DOUBLE);
    if (pers.getComponente()!=null) 
      qInsert.setInt(OID_COMPO,pers.getComponente().getOID());
    else
      qInsert.setNull(OID_COMPO,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(TIPO_SALDO,pers.getTipoSaldo());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int TIPO_VALOR = 3;
    final int VALOR = 4;
    final int OID_COMPO = 5;
    final int ACTIVO = 6;
    final int TIPO_SALDO = 7;
    final int OID_DRIVER = 8;

    DriverSubreparto pers = (DriverSubreparto) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgDriver set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",tipo_valor=?"+ 
              ",valor=?"+ 
              ",oid_compo=?"+ 
              ",activo=?"+ 
              ",tipo_saldo=?"+
                 " where " +
                 " oid_driver=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DRIVER,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(TIPO_VALOR,pers.getTipo_valor());
    if (pers.getValor()!=null)
    	qUpdate.setDouble(VALOR,pers.getValor().doubleValue());
    else
    	qUpdate.setNull(VALOR,java.sql.Types.DOUBLE);
    if (pers.getComponente()!=null) 
      qUpdate.setInt(OID_COMPO,pers.getComponente().getOID());
    else
      qUpdate.setNull(OID_COMPO,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(TIPO_SALDO,pers.getTipoSaldo());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DRIVER = 1; 
    DriverSubreparto pers = (DriverSubreparto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgDriver "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_driver=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DRIVER, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_DRIVER = 1; 
    DriverSubreparto pers = (DriverSubreparto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgDriver "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_driver=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_DRIVER, pers.getOID()); 
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

    final int OID_DRIVER = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgDriver "); 
    textSQL.append(" WHERE oid_driver = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_DRIVER, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgDriver "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_driver oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cgDriver");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
