package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.MotivoFichadaCIP;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBMotivoFichadaCIP extends DBObjetoPersistente {

  public static final String OID_MOTIVO_FICHADA = "oid_motivo_fichada";
  public static final String DESCRIPCION = "descripcion";
  public static final String ENTRADA = "entrada";
  public static final String REQUIERE_OBS_ENT = "requiere_obs_ent";
  public static final String SALIDA = "salida";
  public static final String REQUIERE_OBS_SAL = "requiere_obs_sal";
  public static final String ORDEN_ENTRADA = "orden_entrada";
  public static final String ORDEN_SALIDA = "orden_salida";
  public static final String ACTIVO = "activo";

  public DBMotivoFichadaCIP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOTIVO_FICHADA = 1;
    final int DESCRIPCION = 2;
    final int ENTRADA = 3;
    final int REQUIERE_OBS_ENT = 4;
    final int SALIDA = 5;
    final int REQUIERE_OBS_SAL = 6;
    final int ORDEN_ENTRADA = 7;
    final int ORDEN_SALIDA = 8;
    final int ACTIVO = 9;

    MotivoFichadaCIP pers = (MotivoFichadaCIP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipMotivosFichada "+
                     " ( "+
                      "OID_MOTIVO_FICHADA,"+
                      "DESCRIPCION,"+
                      "ENTRADA,"+
                      "REQUIERE_OBS_ENT,"+
                      "SALIDA,"+
                      "REQUIERE_OBS_SAL,"+
                      "ORDEN_ENTRADA,"+
                      "ORDEN_SALIDA,"+
                      "ACTIVO)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOTIVO_FICHADA,pers.getOID());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ENTRADA,pers.isEntrada().booleanValue());
    qInsert.setBoolean(REQUIERE_OBS_ENT,pers.isRequiere_obs_ent().booleanValue());
    qInsert.setBoolean(SALIDA,pers.isSalida().booleanValue());
    qInsert.setBoolean(REQUIERE_OBS_SAL,pers.isRequiere_obs_sal().booleanValue());
    if (pers.getOrden_entrada()!=null)
    	qInsert.setInt(ORDEN_ENTRADA,pers.getOrden_entrada().intValue());
    else
    	qInsert.setInt(ORDEN_ENTRADA,0);
    if (pers.getOrden_salida()!=null)
    	qInsert.setInt(ORDEN_SALIDA,pers.getOrden_salida().intValue());
    else
    	qInsert.setInt(ORDEN_SALIDA,0);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int DESCRIPCION = 1;
    final int ENTRADA = 2;
    final int REQUIERE_OBS_ENT = 3;
    final int SALIDA = 4;
    final int REQUIERE_OBS_SAL = 5;
    final int ORDEN_ENTRADA = 6;
    final int ORDEN_SALIDA = 7;
    final int ACTIVO = 8;
    final int OID_MOTIVO_FICHADA = 9;

    MotivoFichadaCIP pers = (MotivoFichadaCIP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipMotivosFichada set "+
              "descripcion=?"+ 
              ",entrada=?"+ 
              ",requiere_obs_ent=?"+ 
              ",salida=?"+ 
              ",requiere_obs_sal=?"+ 
              ",orden_entrada=?"+ 
              ",orden_salida=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_motivo_fichada=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOTIVO_FICHADA,pers.getOID());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ENTRADA,pers.isEntrada().booleanValue());
    qUpdate.setBoolean(REQUIERE_OBS_ENT,pers.isRequiere_obs_ent().booleanValue());
    qUpdate.setBoolean(SALIDA,pers.isSalida().booleanValue());
    qUpdate.setBoolean(REQUIERE_OBS_SAL,pers.isRequiere_obs_sal().booleanValue());
    if (pers.getOrden_entrada()!=null)
    	qUpdate.setInt(ORDEN_ENTRADA,pers.getOrden_entrada().intValue());
    else
    	qUpdate.setInt(ORDEN_ENTRADA,0);
    if (pers.getOrden_salida()!=null)
    	qUpdate.setInt(ORDEN_SALIDA,pers.getOrden_salida().intValue());
    else
    	qUpdate.setInt(ORDEN_SALIDA,0);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOTIVO_FICHADA = 1; 
    MotivoFichadaCIP pers = (MotivoFichadaCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotivosFichada "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_motivo_fichada=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOTIVO_FICHADA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOTIVO_FICHADA = 1; 
    MotivoFichadaCIP pers = (MotivoFichadaCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotivosFichada "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_motivo_fichada=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOTIVO_FICHADA, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL: { 
          ps = this.selectAll(aCondiciones); 
          break; 
      }      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOTIVO_FICHADA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotivosFichada "); 
    textSQL.append(" WHERE oid_motivo_fichada = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOTIVO_FICHADA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotivosFichada "); 
    textSQL.append(" WHERE descripcion  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotivosFichada "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_motivo_fichada oid, descripcion codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cipMotivosFichada");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getMotivosFichadas(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(MotivoFichadaCIP.NICKNAME,
             DBMotivoFichadaCIP.SELECT_ALL,
             null,
             new ListObserver(),
             aSesion);
  }  
  
} 
