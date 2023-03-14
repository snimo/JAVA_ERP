package com.srn.erp.ctasACobrar.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.ctasACobrar.bm.TranClie;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBTranClie extends DBObjetoPersistente {

  public static final String OID_TRAN_CLIE = "oid_tran_clie";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_SUJETO = "oid_sujeto";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String IMPORTE = "importe";
  public static final String SALDO = "saldo";
  public static final String PENDIENTE = "pendiente";
  public static final String IMPUTAC = "imputac";
  public static final String EMISION = "emision";
  public static final String BASE = "base";
  public static final String COTIZ_MON_ORI = "cotiz_mon_ori";
  public static final String COTIZ_MON_EXT1 = "cotiz_mon_ext1";
  public static final String COTIZ_MON_EXT2 = "cotiz_mon_ext2";
  public static final String COTIZ_MON_ORI_CO = "cotiz_mon_ori_co";
  public static final String COTIZ_MON_EXT1_CO = "cotiz_mon_ext1_co";
  public static final String COTIZ_MON_EXT2_CO = "cotiz_mon_ext2_co";
  public static final String OID_TIPO_CTA_CLIE = "oid_tipo_cta_clie";

  public DBTranClie() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TRAN_CLIE = 1;
    final int OID_CCO = 2;
    final int OID_SUJETO = 3;
    final int OID_MONEDA = 4;
    final int IMPORTE = 5;
    final int SALDO = 6;
    final int PENDIENTE = 7;
    final int IMPUTAC = 8;
    final int EMISION = 9;
    final int BASE = 10;
    final int COTIZ_MON_ORI = 11;
    final int COTIZ_MON_EXT1 = 12;
    final int COTIZ_MON_EXT2 = 13;
    final int COTIZ_MON_ORI_CO = 14;
    final int COTIZ_MON_EXT1_CO = 15;
    final int COTIZ_MON_EXT2_CO = 16;
    final int OID_TIPO_CTA_CLIE = 17;

    TranClie pers = (TranClie) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veTranClie "+
                     " ( "+
                      "OID_TRAN_CLIE,"+
                      "OID_CCO,"+
                      "OID_SUJETO,"+
                      "OID_MONEDA,"+
                      "IMPORTE,"+
                      "SALDO,"+
                      "PENDIENTE,"+
                      "IMPUTAC,"+
                      "EMISION,"+
                      "BASE,"+
                      "COTIZ_MON_ORI,"+
                      "COTIZ_MON_EXT1,"+
                      "COTIZ_MON_EXT2,"+
                      "COTIZ_MON_ORI_CO,"+
                      "COTIZ_MON_EXT1_CO,"+
                      "COTIZ_MON_EXT2_CO,"+
                      "OID_TIPO_CTA_CLIE)"+ 
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
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TRAN_CLIE,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobante().getOID());
    qInsert.setInt(OID_SUJETO,pers.getSujeto().getOID());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.setDouble(SALDO,pers.getSaldo().doubleValue());
    qInsert.setBoolean(PENDIENTE,pers.isPendiente().booleanValue());
    qInsert.setDate(IMPUTAC,new Date(pers.getImputac().getTime()));
    qInsert.setDate(EMISION,new Date(pers.getEmision().getTime()));
    qInsert.setDate(BASE,new Date(pers.getBase().getTime()));
    qInsert.setDouble(COTIZ_MON_ORI,pers.getCotiz_mon_ori().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT1,pers.getCotiz_mon_ext1().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT2,pers.getCotiz_mon_ext2().doubleValue());
    qInsert.setDouble(COTIZ_MON_ORI_CO,pers.getCotiz_mon_ori_co().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT1_CO,pers.getCotiz_mon_ext1_co().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT2_CO,pers.getCotiz_mon_ext2_co().doubleValue());
    qInsert.setInt(OID_TIPO_CTA_CLIE,pers.getTipo_cta_cte().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO = 1;
    final int OID_SUJETO = 2;
    final int OID_MONEDA = 3;
    final int IMPORTE = 4;
    final int SALDO = 5;
    final int PENDIENTE = 6;
    final int IMPUTAC = 7;
    final int EMISION = 8;
    final int BASE = 9;
    final int COTIZ_MON_ORI = 10;
    final int COTIZ_MON_EXT1 = 11;
    final int COTIZ_MON_EXT2 = 12;
    final int COTIZ_MON_ORI_CO = 13;
    final int COTIZ_MON_EXT1_CO = 14;
    final int COTIZ_MON_EXT2_CO = 15;
    final int OID_TIPO_CTA_CLIE = 16;
    final int OID_TRAN_CLIE = 17;

    TranClie pers = (TranClie) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veTranClie set "+
              "oid_cco=?"+ 
              ",oid_sujeto=?"+ 
              ",oid_moneda=?"+ 
              ",importe=?"+ 
              ",saldo=?"+ 
              ",pendiente=?"+ 
              ",imputac=?"+ 
              ",emision=?"+ 
              ",base=?"+ 
              ",cotiz_mon_ori=?"+ 
              ",cotiz_mon_ext1=?"+ 
              ",cotiz_mon_ext2=?"+ 
              ",cotiz_mon_ori_co=?"+ 
              ",cotiz_mon_ext1_co=?"+ 
              ",cotiz_mon_ext2_co=?"+ 
              ",oid_tipo_cta_clie=?"+ 
                 " where " +
                 " oid_tran_clie=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TRAN_CLIE,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobante().getOID());
    qUpdate.setInt(OID_SUJETO,pers.getSujeto().getOID());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.setDouble(SALDO,pers.getSaldo().doubleValue());
    qUpdate.setBoolean(PENDIENTE,pers.isPendiente().booleanValue());
    qUpdate.setDate(IMPUTAC,new Date(pers.getImputac().getTime()));
    qUpdate.setDate(EMISION,new Date(pers.getEmision().getTime()));
    qUpdate.setDate(BASE,new Date(pers.getBase().getTime()));
    qUpdate.setDouble(COTIZ_MON_ORI,pers.getCotiz_mon_ori().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT1,pers.getCotiz_mon_ext1().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT2,pers.getCotiz_mon_ext2().doubleValue());
    qUpdate.setDouble(COTIZ_MON_ORI_CO,pers.getCotiz_mon_ori_co().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT1_CO,pers.getCotiz_mon_ext1_co().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT2_CO,pers.getCotiz_mon_ext2_co().doubleValue());
    qUpdate.setInt(OID_TIPO_CTA_CLIE,pers.getTipo_cta_cte().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TRAN_CLIE = 1; 
    TranClie pers = (TranClie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veTranClie "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_tran_clie=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TRAN_CLIE, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TRAN_CLIE = 1; 
    TranClie pers = (TranClie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veTranClie "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_tran_clie=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TRAN_CLIE, pers.getOID()); 
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

    final int OID_TRAN_CLIE = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veTranClie "); 
    textSQL.append(" WHERE oid_tran_clie = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TRAN_CLIE, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veTranClie "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tran_clie oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veTranClie");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
