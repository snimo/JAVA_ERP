package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBReporteContable extends DBObjetoPersistente {

  public static final String OID_REP_CONTA = "oid_rep_conta";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String SHOW_ABM_CTAS = "show_abm_ctas";
  
  public static final int SELECT_BY_REP_ACT_ABM_CTAS = 100;
  public static final int SELECT_ALL_HELP_ACTIVOS = 101;
  
  

  public DBReporteContable() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_REP_CONTA = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int SHOW_ABM_CTAS = 5;

    ReporteContable pers = (ReporteContable) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgRepConta "+
                     " ( "+
                      "OID_REP_CONTA,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,SHOW_ABM_CTAS)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_REP_CONTA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(SHOW_ABM_CTAS,pers.isShowEnABMCtas().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int SHOW_ABM_CTAS = 4;
    final int OID_REP_CONTA = 5;
    

    ReporteContable pers = (ReporteContable) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgRepConta set "+
              "codigo=?"+
              ",descripcion=?"+
              ",activo=?"+
              ",show_abm_ctas=? "+
                 " where " +
                 " oid_rep_conta=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_REP_CONTA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(SHOW_ABM_CTAS,pers.isShowEnABMCtas().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_REP_CONTA = 1;
    ReporteContable pers = (ReporteContable) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgRepConta "+
                     " set activo=0 " +
                     " where " +
                     " oid_rep_conta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_REP_CONTA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_REP_CONTA = 1;
    ReporteContable pers = (ReporteContable) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgRepConta "+
                     " set activo=1 " +
                     " where " +
                     " oid_rep_conta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_REP_CONTA, pers.getOID());
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
      case SELECT_ALL_HELP_ACTIVOS: {
          ps = this.selectAllHelpActivos(aCondiciones);
          break;
      }
      case SELECT_BY_REP_ACT_ABM_CTAS: {
          ps = this.selectByReportesActABMCtas(aCondiciones);
          break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_REP_CONTA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgRepConta ");
    textSQL.append(" WHERE oid_rep_conta = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_REP_CONTA, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByReportesActABMCtas(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  cgRepConta ");
	    textSQL.append(" WHERE activo=1 and show_abm_ctas=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
	    
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgRepConta ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rep_conta oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cgRepConta");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  private PreparedStatement selectAllHelpActivos(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT oid_rep_conta oid,codigo codigo, descripcion descripcion ,activo ");
	    textSQL.append(" from cgRepConta where activo=1");

	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
	  }
  
  
  
  
  public static List getReportesActivosABMCtas(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ReporteContable.NICKNAME,
             DBReporteContable.SELECT_BY_REP_ACT_ABM_CTAS,
             null,
             new ListObserver(),
             aSesion);
  }

  

}
