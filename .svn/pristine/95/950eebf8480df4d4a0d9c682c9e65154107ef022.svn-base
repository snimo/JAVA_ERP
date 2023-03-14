package com.srn.erp.rrhh.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.rrhh.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBRangoPtajeObsCodif extends DBObjetoPersistente {

  public static final String OID_MOD_OBS_CODIF = "oid_mod_obs_codif";
  public static final String OID_COND_MOD = "oid_cond_mod";
  public static final String PUNTAJE_DESDE = "puntaje_desde";
  public static final String PUNTAJE_HASTA = "puntaje_hasta";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_CONDICION = 100;

  public DBRangoPtajeObsCodif() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOD_OBS_CODIF = 1;
    final int OID_COND_MOD = 2;
    final int PUNTAJE_DESDE = 3;
    final int PUNTAJE_HASTA = 4;
    final int ACTIVO = 5;

    RangoPtajeObsCodif pers = (RangoPtajeObsCodif) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhModObsCodif "+
                     " ( "+
                      "OID_MOD_OBS_CODIF,"+
                      "OID_COND_MOD,"+
                      "PUNTAJE_DESDE,"+
                      "PUNTAJE_HASTA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOD_OBS_CODIF,pers.getOID());
    qInsert.setInt(OID_COND_MOD,pers.getCond_modelo().getOID());
    qInsert.setDouble(PUNTAJE_DESDE,pers.getPuntaje_desde().doubleValue());
    qInsert.setDouble(PUNTAJE_HASTA,pers.getPuntaje_hasta().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COND_MOD = 1;
    final int PUNTAJE_DESDE = 2;
    final int PUNTAJE_HASTA = 3;
    final int ACTIVO = 4;
    final int OID_MOD_OBS_CODIF = 5;

    RangoPtajeObsCodif pers = (RangoPtajeObsCodif) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhModObsCodif set "+
              "oid_cond_mod=?"+ 
              ",puntaje_desde=?"+ 
              ",puntaje_hasta=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_mod_obs_codif=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOD_OBS_CODIF,pers.getOID());
    qUpdate.setInt(OID_COND_MOD,pers.getCond_modelo().getOID());
    qUpdate.setDouble(PUNTAJE_DESDE,pers.getPuntaje_desde().doubleValue());
    qUpdate.setDouble(PUNTAJE_HASTA,pers.getPuntaje_hasta().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOD_OBS_CODIF = 1; 
    RangoPtajeObsCodif pers = (RangoPtajeObsCodif) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhModObsCodif "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_mod_obs_codif=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOD_OBS_CODIF, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOD_OBS_CODIF = 1; 
    RangoPtajeObsCodif pers = (RangoPtajeObsCodif) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhModObsCodif "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_mod_obs_codif=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOD_OBS_CODIF, pers.getOID()); 
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
      case SELECT_BY_CONDICION: {
          ps = this.selectByCondicion(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOD_OBS_CODIF = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhModObsCodif "); 
    textSQL.append(" WHERE oid_mod_obs_codif = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOD_OBS_CODIF, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByCondicion(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhModObsCodif "); 
	    textSQL.append(" WHERE oid_cond_mod = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    CondModEvalCab condicion = (CondModEvalCab) aCondiciones; 
	    querySelect.setInt(1, condicion.getOID()); 
	    return querySelect; 
  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhModObsCodif "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mod_obs_codif oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhModObsCodif");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getRangosPtajesObsCodig(
		  CondModEvalCab condModEvalCab,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RangoPtajeObsCodif.NICKNAME,
             DBRangoPtajeObsCodif.SELECT_BY_CONDICION,
             condModEvalCab,
             new ListObserver(),
             aSesion);
  }
  
  
} 
