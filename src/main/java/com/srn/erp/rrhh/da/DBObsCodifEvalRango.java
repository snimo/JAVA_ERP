package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.rrhh.bm.ObsCodifEvalRango;
import com.srn.erp.rrhh.bm.RangoPtajeObsCodif;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBObsCodifEvalRango extends DBObjetoPersistente {

  public static final String OID_MOD_OBS_DET = "oid_mod_obs_det";
  public static final String ORDEN = "orden";
  public static final String OID_OBS_CODIF = "oid_obs_codif";
  public static final String OID_MOD_OBS_CODIF = "oid_mod_obs_codif";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_RANGO_PUNTAJE = 100;

  public DBObsCodifEvalRango() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOD_OBS_DET = 1;
    final int ORDEN = 2;
    final int OID_OBS_CODIF = 3;
    final int OID_MOD_OBS_CODIF = 4;
    final int DESCRIPCION = 5;
    final int ACTIVO = 6;

    ObsCodifEvalRango pers = (ObsCodifEvalRango) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhModObsCodifDet "+
                     " ( "+
                      "OID_MOD_OBS_DET,"+
                      "ORDEN,"+
                      "OID_OBS_CODIF,"+
                      "OID_MOD_OBS_CODIF,"+
                      "DESCRIPCION,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_MOD_OBS_DET,pers.getOID());
    if (pers.getOrden()!=null)
    	qInsert.setInt(ORDEN,pers.getOrden().intValue());
    else
    	qInsert.setInt(ORDEN,1);
    qInsert.setInt(OID_OBS_CODIF,pers.getOid_obs_codif().getOID());
    qInsert.setInt(OID_MOD_OBS_CODIF,pers.getMod_obs_codif().getOID());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int ORDEN = 1;
    final int OID_OBS_CODIF = 2;
    final int OID_MOD_OBS_CODIF = 3;
    final int DESCRIPCION = 4;
    final int ACTIVO = 5;
    final int OID_MOD_OBS_DET = 6;

    ObsCodifEvalRango pers = (ObsCodifEvalRango) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhModObsCodifDet set "+
              "orden=?"+ 
              ",oid_obs_codif=?"+ 
              ",oid_mod_obs_codif=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_mod_obs_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOD_OBS_DET,pers.getOID());
    if (pers.getOrden()!=null)
    	qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    else
    	qUpdate.setInt(ORDEN,1);
    qUpdate.setInt(OID_OBS_CODIF,pers.getOid_obs_codif().getOID());
    qUpdate.setInt(OID_MOD_OBS_CODIF,pers.getMod_obs_codif().getOID());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOD_OBS_DET = 1; 
    ObsCodifEvalRango pers = (ObsCodifEvalRango) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhModObsCodifDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_mod_obs_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOD_OBS_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_MOD_OBS_DET = 1; 
    ObsCodifEvalRango pers = (ObsCodifEvalRango) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhModObsCodifDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_mod_obs_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_MOD_OBS_DET, pers.getOID()); 
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
      case SELECT_BY_RANGO_PUNTAJE: {
          ps = this.selectByRangoPuntaje(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_MOD_OBS_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhModObsCodifDet "); 
    textSQL.append(" WHERE oid_mod_obs_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_MOD_OBS_DET, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByRangoPuntaje(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhModObsCodifDet "); 
	    textSQL.append(" WHERE oid_mod_obs_codif = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RangoPtajeObsCodif rango = (RangoPtajeObsCodif) aCondiciones; 
	    querySelect.setInt(1, rango.getOID()); 
	    return querySelect; 
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhModObsCodifDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mod_obs_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhModObsCodifDet");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getObsCodif(RangoPtajeObsCodif aRangoPtajeObsCodif,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ObsCodifEvalRango.NICKNAME,
             DBObsCodifEvalRango.SELECT_BY_RANGO_PUNTAJE,
             aRangoPtajeObsCodif,
             new ListObserver(),
             aSesion);
  }
  
  
} 
