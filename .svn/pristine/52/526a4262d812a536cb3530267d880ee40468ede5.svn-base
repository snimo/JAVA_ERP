package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.tesoreria.bm.MotivoHabIngVar;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBMotivoHabIngVar extends DBObjetoPersistente {

  public static final String OID_MOT_HAB_IV = "oid_mot_hab_iv";
  public static final String OID_MOTIVO_TC = "oid_motivo_tc";
  public static final String HABILITADO = "habilitado";
  
  public static final int SELECT_BY_MOTIVO_TC = 100;

  public DBMotivoHabIngVar() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOT_HAB_IV = 1;
    final int OID_MOTIVO_TC = 2;
    final int HABILITADO = 3;

    MotivoHabIngVar pers = (MotivoHabIngVar) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into teMotHabIngVar "+
                     " ( "+
                      "OID_MOT_HAB_IV,"+
                      "OID_MOTIVO_TC,"+
                      "HABILITADO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOT_HAB_IV,pers.getOID());
    qInsert.setInt(OID_MOTIVO_TC,pers.getMotivo_tc().getOID());
    qInsert.setBoolean(HABILITADO,pers.isHabilitado().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOTIVO_TC = 1;
    final int HABILITADO = 2;
    final int OID_MOT_HAB_IV = 3;

    MotivoHabIngVar pers = (MotivoHabIngVar) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update teMotHabIngVar set "+
              "oid_motivo_tc=?"+ 
              ",habilitado=?"+ 
                 " where " +
                 " oid_mot_hab_iv=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_HAB_IV,pers.getOID());
    qUpdate.setInt(OID_MOTIVO_TC,pers.getMotivo_tc().getOID());
    qUpdate.setBoolean(HABILITADO,pers.isHabilitado().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_HAB_IV = 1; 
    MotivoHabIngVar pers = (MotivoHabIngVar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teMotHabIngVar "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_mot_hab_iv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_HAB_IV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_HAB_IV = 1; 
    MotivoHabIngVar pers = (MotivoHabIngVar) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teMotHabIngVar "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_mot_hab_iv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_HAB_IV, pers.getOID()); 
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
      case SELECT_BY_MOTIVO_TC: {
        ps = this.selectByMotivoTC(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOT_HAB_IV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teMotHabIngVar "); 
    textSQL.append(" WHERE oid_mot_hab_iv = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOT_HAB_IV, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByMotivoTC(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teMotHabIngVar "); 
    textSQL.append(" WHERE oid_motivo_tc  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    MotivoTC motivoTC = (MotivoTC) aCondiciones; 
    querySelect.setInt(1, motivoTC.getOID()); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teMotHabIngVar "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mot_hab_iv oid, codigo,  descripcion ,activo ");
    textSQL.append(" from teMotHabIngVar");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static MotivoHabIngVar getMotivoHabIngVar(MotivoTC motivoTC,
      ISesion aSesion)
      throws BaseException {
  	return (MotivoHabIngVar) ObjetoLogico.getObjects(MotivoHabIngVar.NICKNAME,
	  				DBMotivoHabIngVar.SELECT_BY_MOTIVO_TC,
	  				motivoTC,
	  				new ObjetoObservado(),
	  				aSesion);
  }
  
  
} 
