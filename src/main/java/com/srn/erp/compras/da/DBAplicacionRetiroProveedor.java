package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.compras.bm.AplicacionRetiroProveedor;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBAplicacionRetiroProveedor extends DBObjetoPersistente {

  public static final String OID_APLIC_RET_PROV = "oid_aplic_ret_prov";
  public static final String OID_CC_DET = "oid_cc_det";
  public static final String OID_REMITO_DET = "oid_remito_det";
  public static final String CANT_UM_STK = "cant_um_stk";
  public static final String OID_UM_STK = "oid_um_stk";
  public static final String CANT_UM_CPRA = "cant_um_cpra";
  public static final String OID_UM_CPRA = "oid_um_cpra";

  public DBAplicacionRetiroProveedor() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_APLIC_RET_PROV = 1;
    final int OID_CC_DET = 2;
    final int OID_REMITO_DET = 3;
    final int CANT_UM_STK = 4;
    final int OID_UM_STK = 5;
    final int CANT_UM_CPRA = 6;
    final int OID_UM_CPRA = 7;

    AplicacionRetiroProveedor pers = (AplicacionRetiroProveedor) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpAplicRetProv "+
                     " ( "+
                      "OID_APLIC_RET_PROV,"+
                      "OID_CC_DET,"+
                      "OID_REMITO_DET,"+
                      "CANT_UM_STK,"+
                      "OID_UM_STK,"+
                      "CANT_UM_CPRA,"+
                      "OID_UM_CPRA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_APLIC_RET_PROV,pers.getOID());
    qInsert.setInt(OID_CC_DET,pers.getControl_calidad_det().getOID());
    qInsert.setInt(OID_REMITO_DET,pers.getRemito_det().getOID());
    qInsert.setDouble(CANT_UM_STK,pers.getCant_um_stk().doubleValue());
    qInsert.setInt(OID_UM_STK,pers.getOid_um_stk().getOID());
    qInsert.setDouble(CANT_UM_CPRA,pers.getCant_um_cpra().doubleValue());
    qInsert.setInt(OID_UM_CPRA,pers.getOid_um_cpra().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CC_DET = 1;
    final int OID_REMITO_DET = 2;
    final int CANT_UM_STK = 3;
    final int OID_UM_STK = 4;
    final int CANT_UM_CPRA = 5;
    final int OID_UM_CPRA = 6;
    final int OID_APLIC_RET_PROV = 7;

    AplicacionRetiroProveedor pers = (AplicacionRetiroProveedor) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpAplicRetProv set "+
              "oid_cc_det=?"+ 
              ",oid_remito_det=?"+ 
              ",cant_um_stk=?"+ 
              ",oid_um_stk=?"+ 
              ",cant_um_cpra=?"+ 
              ",oid_um_cpra=?"+ 
                 " where " +
                 " oid_aplic_ret_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APLIC_RET_PROV,pers.getOID());
    qUpdate.setInt(OID_CC_DET,pers.getControl_calidad_det().getOID());
    qUpdate.setInt(OID_REMITO_DET,pers.getRemito_det().getOID());
    qUpdate.setDouble(CANT_UM_STK,pers.getCant_um_stk().doubleValue());
    qUpdate.setInt(OID_UM_STK,pers.getOid_um_stk().getOID());
    qUpdate.setDouble(CANT_UM_CPRA,pers.getCant_um_cpra().doubleValue());
    qUpdate.setInt(OID_UM_CPRA,pers.getOid_um_cpra().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_APLIC_RET_PROV = 1; 
    AplicacionRetiroProveedor pers = (AplicacionRetiroProveedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAplicRetProv "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_aplic_ret_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APLIC_RET_PROV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_APLIC_RET_PROV = 1; 
    AplicacionRetiroProveedor pers = (AplicacionRetiroProveedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAplicRetProv "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_aplic_ret_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APLIC_RET_PROV, pers.getOID()); 
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

    final int OID_APLIC_RET_PROV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAplicRetProv "); 
    textSQL.append(" WHERE oid_aplic_ret_prov = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_APLIC_RET_PROV, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAplicRetProv "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_aplic_ret_prov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpAplicRetProv");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
