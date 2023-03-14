package com.srn.erp.ctasACobrar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.ctasACobrar.bm.AplicacionComproClieDet;
import com.srn.erp.ctasAPagar.bm.AplicacionComproProvDet;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBAplicacionComproClieDet extends DBObjetoPersistente {

  public static final String OID_COMPRO_APL_DET = "oid_compro_apl_det";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_TRAN_VTO = "oid_tran_vto";
  public static final String APLIC_MON_ORI = "aplic_mon_ori";
  public static final String COTIZ_MON_ORI_C = "cotiz_mon_ori_c";
  public static final String COTIZ_MON_EXT1_C = "cotiz_mon_ext1_c";
  public static final String COTIZ_MON_EXT2_C = "cotiz_mon_ext2_c";
  public static final String COTIZ_MON_ORI_H = "cotiz_mon_ori_h";
  public static final String COTIZ_MON_EXT1_H = "cotiz_mon_ext1_h";
  public static final String COTIZ_MON_EXT2_H = "cotiz_mon_ext2_h";
  public static final String NRO_RELACION     = "nro_relacion";
  public static final String OID_COMPRO_APLIC = "oid_compro_aplic";
  public static final String OID_TRAN_VTO_APLIC = "oid_tran_vto_aplic";

  public DBAplicacionComproClieDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COMPRO_APL_DET = 1;
    final int OID_CCO = 2;
    final int OID_TRAN_VTO = 3;
    final int APLIC_MON_ORI = 4;
    final int COTIZ_MON_ORI_C = 5;
    final int COTIZ_MON_EXT1_C = 6;
    final int COTIZ_MON_EXT2_C = 7;
    final int COTIZ_MON_ORI_H = 8;
    final int COTIZ_MON_EXT1_H = 9;
    final int COTIZ_MON_EXT2_H = 10;
    final int NRO_RELACION = 11;
    final int OID_COMPRO_APLIC = 12;
    final int OID_TRAN_VTO_APLIC = 13;

    AplicacionComproClieDet pers = (AplicacionComproClieDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veComproClieAplDet "+
                     " ( "+
                      "OID_COMPRO_APL_DET,"+
                      "OID_CCO,"+
                      "OID_TRAN_VTO,"+
                      "APLIC_MON_ORI,"+
                      "COTIZ_MON_ORI_C,"+
                      "COTIZ_MON_EXT1_C,"+
                      "COTIZ_MON_EXT2_C,"+
                      "COTIZ_MON_ORI_H,"+
                      "COTIZ_MON_EXT1_H,"+
                      "COTIZ_MON_EXT2_H,"+
                      "NRO_RELACION,"+
                      "OID_COMPRO_APLIC,"+
                      "OID_TRAN_VTO_APLIC"+
                      ")"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COMPRO_APL_DET,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprocab().getOID());
    qInsert.setInt(OID_TRAN_VTO,pers.getTranClieVto().getOID());
    qInsert.setDouble(APLIC_MON_ORI,pers.getAplicmonedaori().doubleValue());
    qInsert.setDouble(COTIZ_MON_ORI_C,pers.getCotizmonoricont().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT1_C,pers.getCotizmonext1cont().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT2_C,pers.getCotizmonext2cont().doubleValue());
    qInsert.setDouble(COTIZ_MON_ORI_H,pers.getCotizmonorihoy().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT1_H,pers.getCotizmonext1hoy().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT2_H,pers.getCotizmonext2hoy().doubleValue());
    qInsert.setInt(NRO_RELACION,pers.getNroRelacion().intValue());
    qInsert.setInt(OID_COMPRO_APLIC,pers.getComproAplicOri().getOID());
    if (pers.getTranClieVtoAplic()!=null)
      qInsert.setInt(OID_TRAN_VTO_APLIC,pers.getTranClieVtoAplic().getOID());
    else
      qInsert.setNull(OID_TRAN_VTO_APLIC,java.sql.Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int OID_TRAN_VTO = 2;
    final int APLIC_MON_ORI = 3;
    final int COTIZ_MON_ORI_C = 4;
    final int COTIZ_MON_EXT1_C = 5;
    final int COTIZ_MON_EXT2_C = 6;
    final int COTIZ_MON_ORI_H = 7;
    final int COTIZ_MON_EXT1_H = 8;
    final int COTIZ_MON_EXT2_H = 9;
    final int NRO_RELACION = 10;
    final int OID_COMPRO_APLIC = 11;
    final int OID_TRAN_VTO_APLIC = 12;
    final int OID_COMPRO_APL_DET = 13;

    AplicacionComproClieDet pers = (AplicacionComproClieDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veComproClieAplDet set "+
              "oid_cco=?"+
              ",oid_tran_vto=?"+
              ",aplic_mon_ori=?"+
              ",cotiz_mon_ori_c=?"+
              ",cotiz_mon_ext1_c=?"+
              ",cotiz_mon_ext2_c=?"+
              ",cotiz_mon_ori_h=?"+
              ",cotiz_mon_ext1_h=?"+
              ",cotiz_mon_ext2_h=?"+
              ",nro_relacion=?"+
              ",oid_compro_aplic=?"+
              ",oid_tran_vto_aplic=?"+
                 " where " +
                 " oid_compro_apl_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPRO_APL_DET,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprocab().getOID());
    qUpdate.setInt(OID_TRAN_VTO,pers.getTranClieVto().getOID());
    qUpdate.setDouble(APLIC_MON_ORI,pers.getAplicmonedaori().doubleValue());
    qUpdate.setDouble(COTIZ_MON_ORI_C,pers.getCotizmonoricont().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT1_C,pers.getCotizmonext1cont().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT2_C,pers.getCotizmonext2cont().doubleValue());
    qUpdate.setDouble(COTIZ_MON_ORI_H,pers.getCotizmonorihoy().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT1_H,pers.getCotizmonext1hoy().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT2_H,pers.getCotizmonext2hoy().doubleValue());
    qUpdate.setInt(NRO_RELACION,pers.getNroRelacion().intValue());
    qUpdate.setInt(OID_COMPRO_APLIC,pers.getComproAplicOri().getOID());
    if (pers.getTranClieVtoAplic()!=null)
      qUpdate.setInt(OID_TRAN_VTO_APLIC,pers.getTranClieVtoAplic().getOID());
    else
      qUpdate.setNull(OID_TRAN_VTO_APLIC,java.sql.Types.INTEGER);
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPRO_APL_DET = 1;
    AplicacionComproProvDet pers = (AplicacionComproProvDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veComproClieAplDet "+
                     " set activo=0 " +
                     " where " +
                     " oid_compro_apl_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPRO_APL_DET, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPRO_APL_DET = 1;
    AplicacionComproProvDet pers = (AplicacionComproProvDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veComproClieAplDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_compro_apl_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPRO_APL_DET, pers.getOID());
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

    final int OID_COMPRO_APL_DET = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veComproClieAplDet ");
    textSQL.append(" WHERE oid_compro_apl_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COMPRO_APL_DET, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veComproClieAplDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compro_apl_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veComproClieAplDet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
