package com.srn.erp.cip.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.cip.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBEstadoCIP extends DBObjetoPersistente {

  public static final String OID_ESTADO = "oid_estado";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String TIPO_INGRESO = "tipo_ingreso";
  public static final String TIPO_EGRESO = "tipo_egreso";
  public static final String ACTIVO = "activo";
  public static final String LEY_EGR_DENEGADO =  "ley_egr_denegado";
  public static final String LEY_ING_DENEGADO =  "ley_ing_denegado";
  public static final String ACTIVAR_ANTI_PASS_BACK =  "act_anti_pass_back";
  public static final String ES_SUSCEP_CACHEO =  "es_suscep_cacheo";
  public static final String MIN_ENT_ANT_ENTRADA = "min_ent_ant_ent";
  public static final String MIN_ENT_DES_ENTRADA = "min_ent_des_ent";

  public DBEstadoCIP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ESTADO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int TIPO_INGRESO = 4;
    final int TIPO_EGRESO = 5;
    final int ACTIVO = 6;
    final int LEY_EGR_DENEGADO = 7;
    final int LEY_ING_DENEGADO = 8;
    final int ACTIVAR_ANTI_PASS_BACK = 9;
    final int ES_SUSCEP_CACHEO = 10;
    final int MIN_ENT_ANT_ENTRADA = 11;
    final int MIN_ENT_DES_ENTRADA = 12;

    EstadoCIP pers = (EstadoCIP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipEstados "+
                     " ( "+
                      "OID_ESTADO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "TIPO_INGRESO,"+
                      "TIPO_EGRESO,"+
                      "ACTIVO,LEY_EGR_DENEGADO,LEY_ING_DENEGADO,act_anti_pass_back,es_suscep_cacheo,min_ent_ant_ent,min_ent_des_ent)"+ 
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
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ESTADO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(TIPO_INGRESO,pers.getTipo_ingreso());
    qInsert.setString(TIPO_EGRESO,pers.getTipo_egreso());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getLeyendaEgrDenegado()!=null)
    	qInsert.setString(LEY_EGR_DENEGADO, pers.getLeyendaEgrDenegado());
    else
    	qInsert.setString(LEY_EGR_DENEGADO, "");
    if (pers.getLeyendaIngDenegado()!=null)
    	qInsert.setString(LEY_ING_DENEGADO, pers.getLeyendaIngDenegado());
    else
    	qInsert.setString(LEY_ING_DENEGADO, "");
    if (pers.isActivarAntiPassBack()!=null)
    	qInsert.setBoolean(ACTIVAR_ANTI_PASS_BACK, pers.isActivarAntiPassBack().booleanValue());
    else
    	qInsert.setBoolean(ACTIVAR_ANTI_PASS_BACK, false);
    if (pers.isSusceptibleCacheo()!=null)
    	qInsert.setBoolean(ES_SUSCEP_CACHEO, pers.isSusceptibleCacheo().booleanValue());
    else
    	qInsert.setBoolean(ES_SUSCEP_CACHEO, false);
    
    qInsert.setInt(MIN_ENT_ANT_ENTRADA, pers.getMinEntAntEntrada().intValue());
    qInsert.setInt(MIN_ENT_DES_ENTRADA, pers.getMinEntDesEntrada().intValue());
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int TIPO_INGRESO = 3;
    final int TIPO_EGRESO = 4;
    final int ACTIVO = 5;
    final int LEY_EGR_DENEGADO = 6;
    final int LEY_ING_DENEGADO = 7;   
    final int ACTIVAR_ANTI_PASS_BACK = 8;
    final int ES_SUSCEP_CACHEO = 9;
    final int MIN_ENT_ANT_ENTRADA = 10;
    final int MIN_ENT_DES_ENTRADA = 11;
    final int OID_ESTADO = 12;

    EstadoCIP pers = (EstadoCIP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipEstados set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",tipo_ingreso=?"+ 
              ",tipo_egreso=?"+ 
              ",activo=?"+ 
              ",ley_egr_denegado=?"+
              ",ley_ing_denegado=?"+
              ",act_anti_pass_back=? "+
              ",es_suscep_cacheo=? , min_ent_ant_ent = ?,min_ent_des_ent = ? "+
                 " where " +
                 " oid_estado=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTADO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(TIPO_INGRESO,pers.getTipo_ingreso());
    qUpdate.setString(TIPO_EGRESO,pers.getTipo_egreso());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getLeyendaEgrDenegado()!=null)
    	qUpdate.setString(LEY_EGR_DENEGADO, pers.getLeyendaEgrDenegado());
    else
    	qUpdate.setString(LEY_EGR_DENEGADO, "");
    if (pers.getLeyendaIngDenegado()!=null)
    	qUpdate.setString(LEY_ING_DENEGADO, pers.getLeyendaIngDenegado());
    else
    	qUpdate.setString(LEY_ING_DENEGADO, "");
    if (pers.isActivarAntiPassBack()!=null)
    	qUpdate.setBoolean(ACTIVAR_ANTI_PASS_BACK, pers.isActivarAntiPassBack().booleanValue());
    else
    	qUpdate.setBoolean(ACTIVAR_ANTI_PASS_BACK, false);
    if (pers.isSusceptibleCacheo()!=null)
    	qUpdate.setBoolean(ES_SUSCEP_CACHEO, pers.isSusceptibleCacheo().booleanValue());
    else
    	qUpdate.setBoolean(ES_SUSCEP_CACHEO, false); 
    qUpdate.setInt(MIN_ENT_ANT_ENTRADA, pers.getMinEntAntEntrada().intValue());
    qUpdate.setInt(MIN_ENT_DES_ENTRADA, pers.getMinEntDesEntrada().intValue());
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTADO = 1; 
    EstadoCIP pers = (EstadoCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipEstados "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_estado=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTADO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ESTADO = 1; 
    EstadoCIP pers = (EstadoCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipEstados "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_estado=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ESTADO, pers.getOID()); 
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

    final int OID_ESTADO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipEstados "); 
    textSQL.append(" WHERE oid_estado = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ESTADO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipEstados "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipEstados "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_estado oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cipEstados");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getAllEstadosCIP(
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EstadoCIP.NICKNAME,
             DBEstadoCIP.SELECT_ALL,
             null,
             new ListObserver(),
             aSesion);
  }  
  
} 
