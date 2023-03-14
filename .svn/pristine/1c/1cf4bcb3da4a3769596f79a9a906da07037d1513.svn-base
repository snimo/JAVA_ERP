package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.AjuStkMovCab;
import com.srn.erp.stock.bm.ComproAjusteStk;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAjuStkMovCab extends DBObjetoPersistente {

  public static final String OID_AJU_MOV_CAB = "oid_aju_mov_cab";
  public static final String OID_AJU_STK_CAB = "oid_aju_stk_cab";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String TIPO_MOVI = "tipo_movi";
  public static final String OID_ESTADO_STOCK = "oid_estado_stock";
  public static final String OID_UBI_DEPO = "oid_ubi_depo";
  public static final String AFECTA_STK_FISICO = "afecta_stk_fisico";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_AJU_STK_CAB = 100;

  public DBAjuStkMovCab() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_AJU_MOV_CAB = 1;
    final int OID_AJU_STK_CAB = 2;
    final int OID_DEPOSITO = 3;
    final int TIPO_MOVI = 4;
    final int OID_ESTADO_STOCK = 5;
    final int OID_UBI_DEPO = 6;
    final int AFECTA_STK_FISICO = 7;
    final int ACTIVO = 8;

    AjuStkMovCab pers = (AjuStkMovCab) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skAjuStkMovCab "+
                     " ( "+
                      "OID_AJU_MOV_CAB,"+
                      "OID_AJU_STK_CAB,"+
                      "OID_DEPOSITO,"+
                      "TIPO_MOVI,"+
                      "OID_ESTADO_STOCK,"+
                      "OID_UBI_DEPO,"+
                      "AFECTA_STK_FISICO,"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_AJU_MOV_CAB,pers.getOID());
    qInsert.setInt(OID_AJU_STK_CAB,pers.getComproajustkcab().getOID());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setString(TIPO_MOVI,pers.getTipo_movi());
    qInsert.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    if (pers.getUbicacion_deposito()!=null)
      qInsert.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
    else
      qInsert.setNull(OID_UBI_DEPO,java.sql.Types.INTEGER); 	
    qInsert.setBoolean(AFECTA_STK_FISICO,pers.isAfecta_stk_fisico().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_AJU_STK_CAB = 1;
    final int OID_DEPOSITO = 2;
    final int TIPO_MOVI = 3;
    final int OID_ESTADO_STOCK = 4;
    final int OID_UBI_DEPO = 5;
    final int AFECTA_STK_FISICO = 6;
    final int ACTIVO = 7;
    final int OID_AJU_MOV_CAB = 8;

    AjuStkMovCab pers = (AjuStkMovCab) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skAjuStkMovCab set "+
              "oid_aju_stk_cab=?"+
              ",oid_deposito=?"+
              ",tipo_movi=?"+
              ",oid_estado_stock=?"+
              ",oid_ubi_depo=?"+
              ",afecta_stk_fisico=?"+
              ",activo=?"+
                 " where " +
                 " oid_aju_mov_cab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_MOV_CAB,pers.getOID());
    qUpdate.setInt(OID_AJU_STK_CAB,pers.getComproajustkcab().getOID());
    qUpdate.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qUpdate.setString(TIPO_MOVI,pers.getTipo_movi());
    qUpdate.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    if (pers.getUbicacion_deposito()!=null)
    	qUpdate.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
      else
    	  qUpdate.setNull(OID_UBI_DEPO,java.sql.Types.INTEGER);    
    qUpdate.setBoolean(AFECTA_STK_FISICO,pers.isAfecta_stk_fisico().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_AJU_MOV_CAB = 1;
    AjuStkMovCab pers = (AjuStkMovCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skAjuStkMovCab "+
                     " set activo=0 " +
                     " where " +
                     " oid_aju_mov_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_MOV_CAB, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_AJU_MOV_CAB = 1;
    AjuStkMovCab pers = (AjuStkMovCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skAjuStkMovCab "+
                     " set activo=1 " +
                     " where " +
                     " oid_aju_mov_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_MOV_CAB, pers.getOID());
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
      case SELECT_BY_AJU_STK_CAB: {
        ps = this.selectByAjuStkCab(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_AJU_MOV_CAB = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skAjuStkMovCab ");
    textSQL.append(" WHERE oid_aju_mov_cab = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_AJU_MOV_CAB, oid);
    return querySelect;
  }

  private PreparedStatement selectByAjuStkCab(Object aCondiciones) throws BaseException, SQLException {
        StringBuffer textSQL = new StringBuffer();
        textSQL.append("SELECT * FROM  skAjuStkMovCab ");
        textSQL.append(" WHERE oid_aju_stk_cab = ? ");
        PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
        ComproAjusteStk comproAjusteStk = (ComproAjusteStk) aCondiciones;
        querySelect.setInt(1, comproAjusteStk.getOID());
        return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skAjuStkMovCab ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_aju_mov_cab oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skAjuStkMovCab");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getAjustesStkMovCab(ComproAjusteStk comproAjusteStk,
                                         ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(AjuStkMovCab.NICKNAME,
                                          DBAjuStkMovCab.SELECT_BY_AJU_STK_CAB,
                                          comproAjusteStk,
                                          new ListObserver(),
                                          aSesion);
  }


}
