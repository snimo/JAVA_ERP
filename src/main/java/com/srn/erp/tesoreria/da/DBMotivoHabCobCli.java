package com.srn.erp.tesoreria.da;

import java.sql.*;

import com.srn.erp.general.bm.MotivoTC;
import com.srn.erp.tesoreria.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.*;

public class DBMotivoHabCobCli extends DBObjetoPersistente {

  public static final String OID_MOT_HAB_COBCLI = "oid_mot_hab_cobcli";
  public static final String OID_MOTIVO_TC = "oid_motivo_tc";
  public static final String HABILITADO = "habilitado";
  
  public static final int SELECT_BY_MOTIVO_TC = 100;

  public DBMotivoHabCobCli() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOT_HAB_COBCLI = 1;
    final int OID_MOTIVO_TC = 2;
    final int HABILITADO = 3;

    MotivoHabCobCli pers = (MotivoHabCobCli) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into teMotHabCobCli "+
                     " ( "+
                      "OID_MOT_HAB_COBCLI,"+
                      "OID_MOTIVO_TC,"+
                      "HABILITADO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOT_HAB_COBCLI,pers.getOID());
    qInsert.setInt(OID_MOTIVO_TC,pers.getMotivo_tc().getOID());
    qInsert.setBoolean(HABILITADO,pers.isHabilitado().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOTIVO_TC = 1;
    final int HABILITADO = 2;
    final int OID_MOT_HAB_COBCLI = 3;

    MotivoHabCobCli pers = (MotivoHabCobCli) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update teMotHabCobCli set "+
              "oid_motivo_tc=?"+ 
              ",habilitado=?"+ 
                 " where " +
                 " oid_mot_hab_cobcli=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_HAB_COBCLI,pers.getOID());
    qUpdate.setInt(OID_MOTIVO_TC,pers.getMotivo_tc().getOID());
    qUpdate.setBoolean(HABILITADO,pers.isHabilitado().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_HAB_COBCLI = 1; 
    MotivoHabCobCli pers = (MotivoHabCobCli) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teMotHabCobCli "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_mot_hab_cobcli=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_HAB_COBCLI, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOT_HAB_COBCLI = 1; 
    MotivoHabCobCli pers = (MotivoHabCobCli) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teMotHabCobCli "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_mot_hab_cobcli=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOT_HAB_COBCLI, pers.getOID()); 
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

    final int OID_MOT_HAB_COBCLI = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teMotHabCobCli "); 
    textSQL.append(" WHERE oid_mot_hab_cobcli = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOT_HAB_COBCLI, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teMotHabCobCli "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mot_hab_cobcli oid, codigo,  descripcion ,activo ");
    textSQL.append(" from teMotHabCobCli ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  private PreparedStatement selectByMotivoTC(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teMotHabCobCli "); 
    textSQL.append(" WHERE oid_motivo_tc  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    MotivoTC motivoTC = (MotivoTC) aCondiciones; 
    querySelect.setInt(1, motivoTC.getOID()); 
    return querySelect; 
  }

  public static MotivoHabCobCli getMotivoHabCobCli(MotivoTC motivoTC,
      ISesion aSesion)
      throws BaseException {
  	return (MotivoHabCobCli) ObjetoLogico.getObjects(MotivoHabCobCli.NICKNAME,
	  				DBMotivoHabCobCli.SELECT_BY_MOTIVO_TC,
	  				motivoTC,
	  				new ObjetoObservado(),
	  				aSesion);
  }

  
} 
