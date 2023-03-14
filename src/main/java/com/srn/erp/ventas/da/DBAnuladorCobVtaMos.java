package com.srn.erp.ventas.da;

import java.sql.*;
import com.srn.erp.ventas.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBAnuladorCobVtaMos extends DBObjetoPersistente {

  public static final String OID_ANU_COB_VTA = "oid_anu_cob_vta";
  public static final String OID_COB_VTA_MOS = "oid_cob_vta_mos";
  public static final String OID_ANU_FACT_CAB = "oid_anu_fac_cab";

  public DBAnuladorCobVtaMos() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_COB_VTA = 1;
    final int OID_COB_VTA_MOS = 2;
    final int OID_ANU_FACT_CAB = 3;

    AnuladorCobVtaMos pers = (AnuladorCobVtaMos) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veAnuCobVtaMos "+
                     " ( "+
                      "OID_ANU_COB_VTA,"+
                      "OID_COB_VTA_MOS,"+
                      "OID_ANU_FAC_CAB)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ANU_COB_VTA,pers.getOID());
    qInsert.setInt(OID_COB_VTA_MOS,pers.getCobranza_vta_mos().getOID());
    qInsert.setInt(OID_ANU_FACT_CAB,pers.getAnuladorFactura_cab().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COB_VTA_MOS = 1;
    final int OID_ANU_FAC_CAB = 2;
    final int OID_ANU_COB_VTA = 3;

    AnuladorCobVtaMos pers = (AnuladorCobVtaMos) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veAnuCobVtaMos set "+
              "oid_cob_vta_mos=?"+ 
              ",oid_anu_fac_cab=?"+ 
                 " where " +
                 " oid_anu_cob_vta=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_COB_VTA,pers.getOID());
    qUpdate.setInt(OID_COB_VTA_MOS,pers.getCobranza_vta_mos().getOID());
    qUpdate.setInt(OID_ANU_FAC_CAB,pers.getAnuladorFactura_cab().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_COB_VTA = 1; 
    AnuladorCobVtaMos pers = (AnuladorCobVtaMos) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAnuCobVtaMos "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_anu_cob_vta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_COB_VTA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_COB_VTA = 1; 
    AnuladorCobVtaMos pers = (AnuladorCobVtaMos) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAnuCobVtaMos "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_anu_cob_vta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_COB_VTA, pers.getOID()); 
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

    final int OID_ANU_COB_VTA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAnuCobVtaMos "); 
    textSQL.append(" WHERE oid_anu_cob_vta = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ANU_COB_VTA, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAnuCobVtaMos "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_anu_cob_vta oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veAnuCobVtaMos");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
