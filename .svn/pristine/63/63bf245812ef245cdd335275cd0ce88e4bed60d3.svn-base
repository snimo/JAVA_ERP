package com.srn.erp.schedule.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.schedule.bm.TriggerSchedule;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBTriggerSchedule extends DBObjetoPersistente {

  public static final String OID_TRIGGER = "oid_trigger";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String TIPO = "tipo";
  public static final String ACTIVO = "activo";
  public static final String HORA = "hora";
  public static final String MINUTOS = "minutos";
  public static final String SEGUNDOS = "segundos";

  public DBTriggerSchedule() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TRIGGER = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int TIPO = 4;
    final int ACTIVO = 5;
    final int HORA = 6;
    final int MINUTOS = 7;
    final int SEGUNDOS = 8;

    TriggerSchedule pers = (TriggerSchedule) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into scTrigger "+
                     " ( "+
                      "OID_TRIGGER,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "TIPO,"+
                      "ACTIVO,"+
                      "HORA,"+
                      "MINUTOS,SEGUNDOS)"+ 
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
    qInsert.setInt(OID_TRIGGER,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(TIPO,pers.getTipo());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getHora()!=null)
    	qInsert.setInt(HORA,pers.getHora().intValue());
    else
    	qInsert.setInt(HORA,0);
    if (pers.getMinutos()!=null)
    	qInsert.setInt(MINUTOS,pers.getMinutos().intValue());
    else
    	qInsert.setInt(MINUTOS,0);
    if (pers.getSegundos()!=null)
    	qInsert.setInt(SEGUNDOS, pers.getSegundos().intValue());
    else
    	qInsert.setInt(SEGUNDOS, 0);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int TIPO = 3;
    final int ACTIVO = 4;
    final int HORA = 5;
    final int MINUTOS = 6;
    final int SEGUNDOS = 7;
    final int OID_TRIGGER = 8;

    TriggerSchedule pers = (TriggerSchedule) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update scTrigger set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",tipo=?"+ 
              ",activo=?"+ 
              ",hora=?"+ 
              ",minutos=?"+ 
              ",segundos=?"+
                 " where " +
                 " oid_trigger=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TRIGGER,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getHora()!=null)
    	qUpdate.setInt(HORA,pers.getHora().intValue());
    else
    	qUpdate.setInt(HORA,0);
    if (pers.getMinutos()!=null)
    	qUpdate.setInt(MINUTOS,pers.getMinutos().intValue());
    else
    	qUpdate.setInt(MINUTOS,0);
    if (pers.getSegundos()!=null)
    	qUpdate.setInt(SEGUNDOS, pers.getSegundos().intValue());
    else
    	qUpdate.setInt(SEGUNDOS, 0);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TRIGGER = 1; 
    TriggerSchedule pers = (TriggerSchedule) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update scTrigger "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_trigger=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TRIGGER, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TRIGGER = 1; 
    TriggerSchedule pers = (TriggerSchedule) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update scTrigger "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_trigger=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TRIGGER, pers.getOID()); 
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

    final int OID_TRIGGER = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  scTrigger "); 
    textSQL.append(" WHERE oid_trigger = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TRIGGER, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  scTrigger "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_trigger oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from scTrigger");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
