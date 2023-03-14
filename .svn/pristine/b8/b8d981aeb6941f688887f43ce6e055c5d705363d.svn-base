package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.ReporteContaCompo;
import com.srn.erp.contabilidad.bm.ReporteContable;
import com.srn.erp.contabilidad.bm.ReporteContableDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBReporteContaCompo extends DBObjetoPersistente {

  public static final String OID_REP_CON_COMPO = "oid_rep_con_compo";
  public static final String OID_REP_CONTA_DET = "oid_rep_conta_det";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_VALOR_COMPO = "oid_valor_compo";

  public static final int SELECT_BY_REPORTE_CONTABLE = 100;
  public static final int SELECT_BY_REPORTE_CONTA_DET = 101;
  public static final int SELECT_BY_REP_CON_DET_COMPO = 102;

  public DBReporteContaCompo() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_REP_CON_COMPO = 1;
    final int OID_REP_CONTA_DET = 2;
    final int OID_CCO = 3;
    final int OID_VALOR_COMPO = 4;

    ReporteContaCompo pers = (ReporteContaCompo) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgRepContaCompo "+
                     " ( "+
                      "OID_REP_CON_COMPO,"+
                      "OID_REP_CONTA_DET,"+
                      "OID_CCO,"+
                      "OID_VALOR_COMPO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_REP_CON_COMPO,pers.getOID());
    qInsert.setInt(OID_REP_CONTA_DET,pers.getReportecontadet().getOID());
    qInsert.setInt(OID_CCO,pers.getComponente().getOID());
    qInsert.setInt(OID_VALOR_COMPO,pers.getValorcomponente().getOIDInteger().intValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_REP_CONTA_DET = 1;
    final int OID_CCO = 2;
    final int OID_VALOR_COMPO = 3;
    final int OID_REP_CON_COMPO = 4;

    ReporteContaCompo pers = (ReporteContaCompo) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgRepContaCompo set "+
              "oid_rep_conta_det=?"+
              ",oid_cco=?"+
              ",oid_valor_compo=?"+
                 " where " +
                 " oid_rep_con_compo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_REP_CON_COMPO,pers.getOID());
    qUpdate.setInt(OID_REP_CONTA_DET,pers.getReportecontadet().getOID());
    qUpdate.setInt(OID_CCO,pers.getComponente().getOID());
    qUpdate.setInt(OID_VALOR_COMPO,pers.getValorcomponente().getOIDInteger().intValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_REP_CON_COMPO = 1;
    ReporteContaCompo pers = (ReporteContaCompo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from cgRepContaCompo "+
                     " where " +
                     " oid_rep_con_compo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    if (pers.getOIDInteger()!=null)
    	qUpdate.setInt(OID_REP_CON_COMPO, pers.getOID());
    else
    	qUpdate.setInt(OID_REP_CON_COMPO, -1);
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_REP_CON_COMPO = 1;
    ReporteContaCompo pers = (ReporteContaCompo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgRepContaCompo "+
                     " set activo=1 " +
                     " where " +
                     " oid_rep_con_compo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_REP_CON_COMPO, pers.getOID());
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
      case SELECT_BY_REPORTE_CONTABLE: {
        ps = this.selectByReporteContable(aCondiciones);
        break;
      }
      case SELECT_BY_REPORTE_CONTA_DET: {
        ps = this.selectByReporteContableDet(aCondiciones);
        break;
      }
      case SELECT_BY_REP_CON_DET_COMPO: {
          ps = this.selectByRepConDetCompo(aCondiciones);
          break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_REP_CON_COMPO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgRepContaCompo ");
    textSQL.append(" WHERE oid_rep_con_compo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_REP_CON_COMPO, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgRepContaCompo ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rep_con_compo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgRepContaCompo");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByReporteContable(Object aCondiciones) throws BaseException, SQLException {

    ReporteContable reporteContable = (ReporteContable) aCondiciones;
    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT a.* ");
    textSQL.append(" from cgRepContaCompo a, cgRepContaDet b ");
    textSQL.append(" where a.oid_rep_conta_det=b.oid_rep_conta_det ");
    textSQL.append(" and b.oid_rep_conta=?");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,reporteContable.getOID());
    return querySelect;
  }
  
  private PreparedStatement selectByRepConDetCompo(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

	    textSQL.append("SELECT * ");
	    textSQL.append(" from cgRepContaCompo  ");
	    textSQL.append(" where oid_rep_conta_det=? and oid_cco=? ");

	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    ReporteContableDet reporteContableDet = (ReporteContableDet) condiciones.get(ReporteContableDet.NICKNAME);
	    Componente componente = (Componente) condiciones.get(Componente.NICKNAME);
	    
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setInt(1,reporteContableDet.getOID());
	    querySelect.setInt(2,componente.getOID());
	    return querySelect;
	    
	  }

  private PreparedStatement selectByReporteContableDet(Object aCondiciones) throws BaseException, SQLException {

    ReporteContableDet reporteContableDet = (ReporteContableDet) aCondiciones;
    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT * ");
    textSQL.append(" from cgRepContaCompo  ");
    textSQL.append(" where oid_rep_conta_det=? ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,reporteContableDet.getOID());
    return querySelect;
  }



  public static List getReportesContaCompoByReporte(ReporteContable reporteContable,
                                                    ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ReporteContaCompo.NICKNAME,
                                          SELECT_BY_REPORTE_CONTABLE,
                                          reporteContable,
                                          new ListObserver(),
                                          aSesion);

  }

  public static List getReportesContaCompoByReporteDet(ReporteContableDet reporteContableDet,
                                                      ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ReporteContaCompo.NICKNAME,
                                          SELECT_BY_REPORTE_CONTA_DET,
                                          reporteContableDet,
                                          new ListObserver(),
                                          aSesion);

  }
  
  public static ReporteContaCompo getReporteContaCompo(
		  ReporteContableDet reporteContableDet,
		  Componente compo,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ReporteContableDet.NICKNAME, reporteContableDet);
	  condiciones.put(Componente.NICKNAME, compo);
	  return (ReporteContaCompo) ObjetoLogico.getObjects(ReporteContaCompo.NICKNAME,
			  SELECT_BY_REP_CON_DET_COMPO,
			  condiciones,
			  new ObjetoObservado(),
			  aSesion);

  }
  





}
