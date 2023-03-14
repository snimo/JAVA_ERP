package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.AsientoManual;
import com.srn.erp.contabilidad.bm.AsientoManualDet;
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

public class DBAsientoManualDet extends DBObjetoPersistente {

  public static final String OID_DCO = "oid_dco";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_AI = "oid_ai";
  public static final String SECU = "secu";
  public static final String SIGNO = "signo";
  public static final String IMPORTE = "importe";
  public static final String COMENTARIO = "comentario";
  
  public static final int SELECT_BY_ASIENTO = 100;

  public DBAsientoManualDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_DCO = 1;
    final int OID_CCO = 2;
    final int OID_AI = 3;
    final int SECU = 4;
    final int SIGNO = 5;
    final int IMPORTE = 6;
    final int COMENTARIO = 7;

    AsientoManualDet pers = (AsientoManualDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgComproDetAsiMan "+
                     " ( "+
                      "OID_DCO,"+
                      "OID_CCO,"+
                      "OID_AI,"+
                      "SECU,"+
                      "SIGNO,"+
                      "IMPORTE,"+
                      "COMENTARIO)"+
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
    qInsert.setInt(OID_DCO,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobante().getOID());
    qInsert.setInt(OID_AI,pers.getCuentaImputable().getOID());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.setInt(SIGNO,pers.getSigno().intValue());
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int OID_AI = 2;
    final int SECU = 3;
    final int SIGNO = 4;
    final int IMPORTE = 5;
    final int COMENTARIO = 6;
    final int OID_DCO = 7;

    AsientoManualDet pers = (AsientoManualDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgComproDetAsiMan set "+
              "oid_cco=?"+
              ",oid_ai=?"+
              ",secu=?"+
              ",signo=?"+
              ",importe=?"+
              ",comentario=?"+
                 " where " +
                 " oid_dco=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DCO,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobante().getOID());
    qUpdate.setInt(OID_AI,pers.getCuentaImputable().getOID());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    qUpdate.setInt(SIGNO,pers.getSigno().intValue());
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.setString(COMENTARIO,pers.getComentario());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_DCO = 1;
    AsientoManualDet pers = (AsientoManualDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgComproDetAsiMan "+
                     " set activo=0 " +
                     " where " +
                     " oid_dco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DCO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_DCO = 1;
    AsientoManualDet pers = (AsientoManualDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgComproDetAsiMan "+
                     " set activo=1 " +
                     " where " +
                     " oid_dco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DCO, pers.getOID());
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
      case SELECT_BY_ASIENTO : {
        ps = this.selectByAsiento(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_DCO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgComproDetAsiMan ");
    textSQL.append(" WHERE oid_dco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_DCO, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByAsiento(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgComproDetAsiMan ");
    textSQL.append(" WHERE oid_cco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    
    AsientoManual asiento = (AsientoManual) aCondiciones;
    querySelect.setInt(1, asiento.getOID());
    
    return querySelect;
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgComproDetAsiMan ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_dco oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgComproDetAsiMan");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static List getDetalles(AsientoManual asiento,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(AsientoManualDet.NICKNAME,
         DBAsientoManualDet.SELECT_BY_ASIENTO,
         asiento,
         new ListObserver(),
         aSesion);
  }
  

}
