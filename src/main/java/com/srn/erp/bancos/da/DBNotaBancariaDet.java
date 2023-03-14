package com.srn.erp.bancos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bancos.bm.NotaBancaria;
import com.srn.erp.bancos.bm.NotaBancariaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBNotaBancariaDet extends DBObjetoPersistente {

  public static final String OID_ND_NC_DET = "oid_nd_nc_det";
  public static final String OID_NC_ND = "oid_nc_nd";
  public static final String OID_AI = "oid_ai";
  public static final String DEBE = "debe";
  public static final String HABER = "haber";
  public static final String COMENTARIO = "comentario";
  
  public static final int SELECT_BY_NOTA_BANCARIA = 100;

  public DBNotaBancariaDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ND_NC_DET = 1;
    final int OID_NC_ND = 2;
    final int OID_AI = 3;
    final int DEBE = 4;
    final int HABER = 5;
    final int COMENTARIO = 6;

    NotaBancariaDet pers = (NotaBancariaDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaNDNCDet "+
                     " ( "+
                      "OID_ND_NC_DET,"+
                      "OID_NC_ND,"+
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
    qInsert.setInt(OID_ND_NC_DET,pers.getOID());
    qInsert.setInt(OID_NC_ND,pers.getNota_bancaria().getOID());
    qInsert.setInt(OID_AI,pers.getCuenta_imputable().getOID());
    if (pers.getDebe()!=null) 
      qInsert.setDouble(DEBE,pers.getDebe().doubleValue());
    else
      qInsert.setNull(DEBE,java.sql.Types.DOUBLE);
    if (pers.getHaber()!=null) 
      qInsert.setDouble(HABER,pers.getHaber().doubleValue());
    else
      qInsert.setNull(HABER,java.sql.Types.INTEGER);
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_NC_ND = 1;
    final int OID_AI = 2;
    final int DEBE = 3;
    final int HABER = 4;
    final int COMENTARIO = 5;
    final int OID_ND_NC_DET = 6;

    NotaBancariaDet pers = (NotaBancariaDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaNDNCDet set "+
              "oid_nc_nd=?"+ 
              ",oid_ai=?"+ 
              ",debe=?"+ 
              ",haber=?"+ 
              ",comentario=?"+ 
                 " where " +
                 " oid_nd_nc_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ND_NC_DET,pers.getOID());
    qUpdate.setInt(OID_NC_ND,pers.getNota_bancaria().getOID());
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
    final int OID_ND_NC_DET = 1; 
    NotaBancariaDet pers = (NotaBancariaDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaNDNCDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_nd_nc_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ND_NC_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ND_NC_DET = 1; 
    NotaBancariaDet pers = (NotaBancariaDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaNDNCDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_nd_nc_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ND_NC_DET, pers.getOID()); 
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
      case SELECT_BY_NOTA_BANCARIA: {
        ps = this.selectByNotaBancaria(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 
  
  
  private PreparedStatement selectByNotaBancaria(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaNDNCDet "); 
    textSQL.append(" WHERE oid_nc_nd = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    NotaBancaria notaBancaria = (NotaBancaria) aCondiciones;
    querySelect.setInt(1, notaBancaria.getOID()); 
    return querySelect; 
  }
  

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_ND_NC_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaNDNCDet "); 
    textSQL.append(" WHERE oid_nd_nc_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ND_NC_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaNDNCDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_nd_nc_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vaNDNCDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getDetallesByNotaBancaria(NotaBancaria notaBancaria,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(NotaBancariaDet.NICKNAME,
         DBNotaBancariaDet.SELECT_BY_NOTA_BANCARIA,
         notaBancaria,
         new ListObserver(),
         aSesion);
  }
  
  
} 
