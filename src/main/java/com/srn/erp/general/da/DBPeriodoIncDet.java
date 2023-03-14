package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBPeriodoIncDet extends DBObjetoPersistente {

  public static final String OID_PERI_INC_DET = "oid_peri_inc_det";
  public static final String OID_PERI_INC_CAB = "oid_peri_inc_cab";
  public static final String SECU = "secu";
  public static final String OID_PERI = "oid_peri";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_PERIODO_INC = 100;

  public DBPeriodoIncDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PERI_INC_DET = 1;
    final int OID_PERI_INC_CAB = 2;
    final int SECU = 3;
    final int OID_PERI = 4;
    final int ACTIVO = 5;

    PeriodoIncDet pers = (PeriodoIncDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into gePeriIncDet "+
                     " ( "+
                      "OID_PERI_INC_DET,"+
                      "OID_PERI_INC_CAB,"+
                      "SECU,"+
                      "OID_PERI,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_PERI_INC_DET,pers.getOID());
    qInsert.setInt(OID_PERI_INC_CAB,pers.getPeriinc().getOID());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.setInt(OID_PERI,pers.getPeriodo().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PERI_INC_CAB = 1;
    final int SECU = 2;
    final int OID_PERI = 3;
    final int ACTIVO = 4;
    final int OID_PERI_INC_DET = 5;

    PeriodoIncDet pers = (PeriodoIncDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update gePeriIncDet set "+
              "oid_peri_inc_cab=?"+
              ",secu=?"+
              ",oid_peri=?"+
              ",activo=?"+
                 " where " +
                 " oid_peri_inc_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI_INC_DET,pers.getOID());
    qUpdate.setInt(OID_PERI_INC_CAB,pers.getPeriinc().getOID());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    qUpdate.setInt(OID_PERI,pers.getPeriodo().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PERI_INC_DET = 1;
    PeriodoIncDet pers = (PeriodoIncDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update gePeriIncDet "+
                     " set activo=0 " +
                     " where " +
                     " oid_peri_inc_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI_INC_DET, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PERI_INC_DET = 1;
    PeriodoIncDet pers = (PeriodoIncDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update gePeriIncDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_peri_inc_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI_INC_DET, pers.getOID());
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
      case SELECT_BY_PERIODO_INC: {
        ps = this.selectByPeriodoInc(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_PERI_INC_DET = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  gePeriIncDet ");
    textSQL.append(" WHERE oid_peri_inc_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PERI_INC_DET, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  gePeriIncDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByPeriodoInc(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    PeriodoInc periodoInc = (PeriodoInc) aCondiciones;
    textSQL.append("SELECT * ");
    textSQL.append(" from gePeriIncDet where oid_peri_inc_cab = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,periodoInc.getOID());
    return querySelect;

  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_peri_inc_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from gePeriIncDet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getPeriodosIncDet(PeriodoInc periodoInc,
                                       ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(PeriodoIncDet.NICKNAME,
                                          DBPeriodoIncDet.SELECT_BY_PERIODO_INC,
                                          periodoInc,
                                          new ListObserver(),
                                          aSesion);
  }

  

}
