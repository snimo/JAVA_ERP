package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.compras.bm.ObsGeneralesOC;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBObsGeneralesOC extends DBObjetoPersistente {

  public static final String OID_OBS_GEN_OC = "oid_obs_gen_oc";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String INC_EN_OC = "inc_en_oc";
  public static final String ORDEN = "orden";
  public static final String ACTIVO = "activo";

  public DBObsGeneralesOC() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_OBS_GEN_OC = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int INC_EN_OC = 4;
    final int ORDEN = 5;
    final int ACTIVO = 6;

    ObsGeneralesOC pers = (ObsGeneralesOC) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpObsGenOC "+
                     " ( "+
                      "OID_OBS_GEN_OC,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "INC_EN_OC,"+
                      "ORDEN,"+
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
    qInsert.setInt(OID_OBS_GEN_OC,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(INC_EN_OC,pers.isIncluir_en_oc().booleanValue());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int INC_EN_OC = 3;
    final int ORDEN = 4;
    final int ACTIVO = 5;
    final int OID_OBS_GEN_OC = 6;

    ObsGeneralesOC pers = (ObsGeneralesOC) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpObsGenOC set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",inc_en_oc=?"+ 
              ",orden=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_obs_gen_oc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OBS_GEN_OC,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(INC_EN_OC,pers.isIncluir_en_oc().booleanValue());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OBS_GEN_OC = 1; 
    ObsGeneralesOC pers = (ObsGeneralesOC) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpObsGenOC "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_obs_gen_oc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OBS_GEN_OC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_OBS_GEN_OC = 1; 
    ObsGeneralesOC pers = (ObsGeneralesOC) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpObsGenOC "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_obs_gen_oc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_OBS_GEN_OC, pers.getOID()); 
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

    final int OID_OBS_GEN_OC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpObsGenOC "); 
    textSQL.append(" WHERE oid_obs_gen_oc = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_OBS_GEN_OC, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpObsGenOC "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_obs_gen_oc oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cpObsGenOC");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
