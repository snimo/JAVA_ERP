package com.srn.erp.bancos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bancos.bm.BoletaDeposito;
import com.srn.erp.bancos.bm.GastoBoletaDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBGastoBoletaDeposito extends DBObjetoPersistente {

  public static final String OID = "oid_gastos_bd";
  public static final String OID_BOLETA_DEP = "oid_boleta_dep";
  public static final String OID_AI = "oid_ai";
  public static final String DEBE = "debe";
  public static final String HABER = "haber";
  public static final String COMENTARIO = "comentario";
  
  public static final int SELECT_BY_BOLETA_DEPOSITO = 100;

  public DBGastoBoletaDeposito() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID = 1;
    final int OID_BOLETA_DEP = 2;
    final int OID_AI = 3;
    final int DEBE = 4;
    final int HABER = 5;
    final int COMENTARIO = 6;

    GastoBoletaDeposito pers = (GastoBoletaDeposito) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaGastosBolDep "+
                     " ( "+
                      "OID_GASTOS_BD,"+
                      "OID_BOLETA_DEP,"+
                      "OID_AI,"+
                      "DEBE,"+
                      "HABER,"+
                      "COMENTARIO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID,pers.getOID());
    qInsert.setInt(OID_BOLETA_DEP,pers.getBoleta_deposito().getOID());
    qInsert.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    if (pers.getDebe()!=null) 
      qInsert.setDouble(DEBE,pers.getDebe().doubleValue());
    else
      qInsert.setNull(DEBE,java.sql.Types.DOUBLE);
    if (pers.getHaber()!=null) 
      qInsert.setDouble(HABER,pers.getHaber().doubleValue());
    else
      qInsert.setNull(HABER,java.sql.Types.DOUBLE);
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BOLETA_DEP = 1;
    final int OID_AI = 2;
    final int DEBE = 3;
    final int HABER = 4;
    final int COMENTARIO = 5;
    final int OID = 6;

    GastoBoletaDeposito pers = (GastoBoletaDeposito) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaGastosBolDep set "+
              "oid_boleta_dep=?"+ 
              ",oid_ai=?"+ 
              ",debe=?"+ 
              ",haber=?"+ 
              ",comentario=?"+ 
                 " where " +
                 " oid_gastos_bd=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID,pers.getOID());
    qUpdate.setInt(OID_BOLETA_DEP,pers.getBoleta_deposito().getOID());
    qUpdate.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    if (pers.getDebe()!=null) 
      qUpdate.setDouble(DEBE,pers.getDebe().doubleValue());
    else
      qUpdate.setNull(DEBE,java.sql.Types.DOUBLE);
    if (pers.getHaber()!=null) 
      qUpdate.setDouble(HABER,pers.getHaber().doubleValue());
    else
      qUpdate.setNull(HABER,java.sql.Types.DOUBLE);
    qUpdate.setString(COMENTARIO,pers.getComentario());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID = 1; 
    GastoBoletaDeposito pers = (GastoBoletaDeposito) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaGastosBolDep "+
                     " set activo=0 " + 
                     " where " + 
                     " oid=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID = 1; 
    GastoBoletaDeposito pers = (GastoBoletaDeposito) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaGastosBolDep "+
                     " set activo=1 " + 
                     " where " + 
                     " oid=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID, pers.getOID()); 
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
      case SELECT_BY_BOLETA_DEPOSITO: {
        ps = this.selectByBoletaDeposito(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaGastosBolDep "); 
    textSQL.append(" WHERE oid = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByBoletaDeposito(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaGastosBolDep "); 
    textSQL.append(" WHERE oid_boleta_dep = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    BoletaDeposito boletaDeposito = (BoletaDeposito) aCondiciones;
    querySelect.setInt(1, boletaDeposito.getOID()); 
    return querySelect; 
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaGastosBolDep "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vaGastosBolDep");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getGastosByBoletaDeposito(BoletaDeposito boletaDeposito,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(GastoBoletaDeposito.NICKNAME,
         DBGastoBoletaDeposito.SELECT_BY_BOLETA_DEPOSITO,
         boletaDeposito,
         new ListObserver(),
         aSesion);
  }
  
  
} 
