package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.ctasAPagar.bm.ArticuloConceptoFactProv;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBArticuloConceptoFactProv extends DBObjetoPersistente {

  public static final String OID_ART_CONC_FACT = "oid_art_conc_fact";
  public static final String OID_DET_IR_OC = "oid_det_ir_oc";
  public static final String OID_CCO_PROV_DET = "oid_cco_prov_det";
  public static final String IMPO_MON_ORI = "impo_mon_ori";
  public static final String ACTIVO = "activo";

  public DBArticuloConceptoFactProv() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ART_CONC_FACT = 1;
    final int OID_DET_IR_OC = 2;
    final int OID_CCO_PROV_DET = 3;
    final int IMPO_MON_ORI = 4;
    final int ACTIVO = 5;

    ArticuloConceptoFactProv pers = (ArticuloConceptoFactProv) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpArtConcFactProv "+
                     " ( "+
                      "OID_ART_CONC_FACT,"+
                      "OID_DET_IR_OC,"+
                      "OID_CCO_PROV_DET,"+
                      "IMPO_MON_ORI,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ART_CONC_FACT,pers.getOID());
    qInsert.setInt(OID_DET_IR_OC,pers.getDetalle_infrecdet_ocdet().getOID());
    qInsert.setInt(OID_CCO_PROV_DET,pers.getProveedor_det().getOID());
    qInsert.setDouble(IMPO_MON_ORI,pers.getImpo_mon_ori().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DET_IR_OC = 1;
    final int OID_CCO_PROV_DET = 2;
    final int IMPO_MON_ORI = 3;
    final int ACTIVO = 4;
    final int OID_ART_CONC_FACT = 5;

    ArticuloConceptoFactProv pers = (ArticuloConceptoFactProv) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpArtConcFactProv set "+
              "oid_det_ir_oc=?"+ 
              ",oid_cco_prov_det=?"+ 
              ",impo_mon_ori=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_art_conc_fact=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ART_CONC_FACT,pers.getOID());
    qUpdate.setInt(OID_DET_IR_OC,pers.getDetalle_infrecdet_ocdet().getOID());
    qUpdate.setInt(OID_CCO_PROV_DET,pers.getProveedor_det().getOID());
    qUpdate.setDouble(IMPO_MON_ORI,pers.getImpo_mon_ori().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ART_CONC_FACT = 1; 
    ArticuloConceptoFactProv pers = (ArticuloConceptoFactProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpArtConcFactProv "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_art_conc_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ART_CONC_FACT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ART_CONC_FACT = 1; 
    ArticuloConceptoFactProv pers = (ArticuloConceptoFactProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpArtConcFactProv "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_art_conc_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ART_CONC_FACT, pers.getOID()); 
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

    final int OID_ART_CONC_FACT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpArtConcFactProv "); 
    textSQL.append(" WHERE oid_art_conc_fact = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ART_CONC_FACT, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpArtConcFactProv "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_art_conc_fact oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpArtConcFactProv");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
