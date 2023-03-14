package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.tesoreria.bm.MotivoIngresoVarios;
import com.srn.erp.tesoreria.bm.Recibo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBMotivoIngresoVarios extends DBObjetoPersistente {

  public static final String OID = "oid_mot_ing_rec";
  public static final String OID_RECIBO = "oid_recibo";
  public static final String OID_AI = "oid_ai";
  public static final String DEBE = "debe";
  public static final String HABER = "haber";
  public static final String COMENTARIO = "comentario";
  
  public static final int SELECT_BY_RECIBO = 100;
  
  

  public DBMotivoIngresoVarios() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID = 1;
    final int OID_RECIBO = 2;
    final int OID_AI = 3;
    final int DEBE = 4;
    final int HABER = 5;
    final int COMENTARIO = 6;

    MotivoIngresoVarios pers = (MotivoIngresoVarios) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into teMotVarIngRec "+
                     " ( "+
                      "OID_MOT_ING_REC,"+
                      "OID_RECIBO,"+
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
    qInsert.setInt(OID_RECIBO,pers.getRecibo().getOID());
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

    final int OID_RECIBO = 1;
    final int OID_AI = 2;
    final int DEBE = 3;
    final int HABER = 4;
    final int COMENTARIO = 5;
    final int OID = 6;

    MotivoIngresoVarios pers = (MotivoIngresoVarios) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update teMotVarIngRec set "+
              "oid_recibo=?"+ 
              ",oid_ai=?"+ 
              ",debe=?"+ 
              ",haber=?"+ 
              ",comentario=?"+ 
                 " where " +
                 " oid_mot_ing_rec=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID,pers.getOID());
    qUpdate.setInt(OID_RECIBO,pers.getRecibo().getOID());
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
    MotivoIngresoVarios pers = (MotivoIngresoVarios) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teMotVarIngRec "+
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
    MotivoIngresoVarios pers = (MotivoIngresoVarios) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teMotVarIngRec "+
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
      case SELECT_BY_RECIBO: {
        ps = this.selectByRecibo(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teMotVarIngRec "); 
    textSQL.append(" WHERE oid = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByRecibo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  teMotVarIngRec "); 
	    textSQL.append(" WHERE oid_recibo = ? "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    Recibo recibo = (Recibo) aCondiciones; 
	    querySelect.setInt(1, recibo.getOID()); 
	    return querySelect; 
  }
  
    
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teMotVarIngRec "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid oid, codigo,  descripcion ,activo ");
    textSQL.append(" from teMotVarIngRec");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getMotIngVarByRecibo(Recibo recibo,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(MotivoIngresoVarios.NICKNAME,
             DBMotivoIngresoVarios.SELECT_BY_RECIBO,
             recibo,
             new ListObserver(),
             aSesion);
  }
  
  
} 
