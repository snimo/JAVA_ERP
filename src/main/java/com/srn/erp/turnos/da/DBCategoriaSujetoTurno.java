package com.srn.erp.turnos.da;

import java.sql.*;
import com.srn.erp.turnos.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBCategoriaSujetoTurno extends DBObjetoPersistente {

  public static final String OID_CATEGORIA = "oid_categoria";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String COMPORTAMIENTO = "comportamiento";
  public static final String ACTIVO = "activo";
  public static final String NO_PERMITIR_TURNO = "no_permitir_turno";
  public static final String MONTO_MAX_DEUDA = "monto_max_deuda";	

  public DBCategoriaSujetoTurno() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CATEGORIA = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int COMPORTAMIENTO = 4;
    final int ACTIVO = 5;
    final int NO_PERMITIR_TURNO = 6;
    final int MONTO_MAX_DEUDA = 7;

    CategoriaSujetoTurno pers = (CategoriaSujetoTurno) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into tuCategorias "+
                     " ( "+
                      "OID_CATEGORIA,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "COMPORTAMIENTO,"+
                      "ACTIVO,NO_PERMITIR_TURNO,MONTO_MAX_DEUDA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CATEGORIA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(COMPORTAMIENTO,pers.getComportamiento());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(NO_PERMITIR_TURNO,pers.isNoPermitirTurno().booleanValue());
    if (pers.getMontoMaxDeuda()!=null)
    	qInsert.setDouble(MONTO_MAX_DEUDA,pers.getMontoMaxDeuda().doubleValue());
    else
    	qInsert.setDouble(MONTO_MAX_DEUDA,0);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int COMPORTAMIENTO = 3;
    final int ACTIVO = 4;
    final int NO_PERMITIR_TURNO = 5;
    final int MONTO_MAX_DEUDA = 6;
    final int OID_CATEGORIA = 7;

    CategoriaSujetoTurno pers = (CategoriaSujetoTurno) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update tuCategorias set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",comportamiento=?"+ 
              ",activo=?"+ 
              ",no_permitir_turno=?"+
              ",monto_max_deuda=?"+
                 " where " +
                 " oid_categoria=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CATEGORIA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(COMPORTAMIENTO,pers.getComportamiento());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(NO_PERMITIR_TURNO,pers.isNoPermitirTurno().booleanValue());
    if (pers.getMontoMaxDeuda()!=null)
    	qUpdate.setDouble(MONTO_MAX_DEUDA,pers.getMontoMaxDeuda().doubleValue());
    else
    	qUpdate.setDouble(MONTO_MAX_DEUDA,0);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CATEGORIA = 1; 
    CategoriaSujetoTurno pers = (CategoriaSujetoTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuCategorias "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_categoria=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CATEGORIA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CATEGORIA = 1; 
    CategoriaSujetoTurno pers = (CategoriaSujetoTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update tuCategorias "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_categoria=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CATEGORIA, pers.getOID()); 
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

    final int OID_CATEGORIA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuCategorias "); 
    textSQL.append(" WHERE oid_categoria = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CATEGORIA, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  tuCategorias "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_categoria oid, codigo,  descripcion ,activo ");
    textSQL.append(" from tuCategorias");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
