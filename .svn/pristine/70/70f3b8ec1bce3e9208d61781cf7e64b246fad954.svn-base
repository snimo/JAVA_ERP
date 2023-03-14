package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.CondPagoTipoValor;
import com.srn.erp.ventas.bm.CondicionPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCondPagoTipoValor extends DBObjetoPersistente {

  public static final String OID_COND_PAGO_TV = "oid_cond_pago_tv";
  public static final String OID_COND_PAGO = "oid_cond_pago";
  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  public static final String SUGERIR = "sugerir";
  
  

  public static final int SELECT_BY_COND_PAGO = 100;

  public DBCondPagoTipoValor() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COND_PAGO_TV = 1;
    final int OID_COND_PAGO = 2;
    final int OID_TIPO_VALOR = 3;
    final int SUGERIR = 4;

    CondPagoTipoValor pers = (CondPagoTipoValor) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veCondPagoTipoVal "+
                     " ( "+
                      "OID_COND_PAGO_TV,"+
                      "OID_COND_PAGO,"+
                      "OID_TIPO_VALOR,SUGERIR)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COND_PAGO_TV,pers.getOID());
    qInsert.setInt(OID_COND_PAGO,pers.getCondicion_pago().getOID());
    qInsert.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    qInsert.setBoolean(SUGERIR , pers.isSugerir());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COND_PAGO = 1;
    final int OID_TIPO_VALOR = 2;
    final int SUGERIR = 3;
    final int OID_COND_PAGO_TV = 4;
    

    CondPagoTipoValor pers = (CondPagoTipoValor) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veCondPagoTipoVal set "+
              "oid_cond_pago=?"+
              ",oid_tipo_valor=?"+
              ",sugerir=?"+
                 " where " +
                 " oid_cond_pago_tv=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_PAGO_TV,pers.getOID());
    qUpdate.setInt(OID_COND_PAGO,pers.getCondicion_pago().getOID());
    qUpdate.setInt(OID_TIPO_VALOR,pers.getTipo_valor().getOID());
    qUpdate.setBoolean(SUGERIR , pers.isSugerir()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COND_PAGO_TV = 1;
    CondPagoTipoValor pers = (CondPagoTipoValor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from veCondPagoTipoVal "+
                     " where " +
                     " oid_cond_pago_tv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_PAGO_TV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COND_PAGO_TV = 1;
    CondPagoTipoValor pers = (CondPagoTipoValor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veCondPagoTipoVal "+
                     " set activo=1 " +
                     " where " +
                     " oid_cond_pago_tv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_PAGO_TV, pers.getOID());
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
      case SELECT_BY_COND_PAGO: {
        ps = this.selectByCondPago(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COND_PAGO_TV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPagoTipoVal ");
    textSQL.append(" WHERE oid_cond_pago_tv = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COND_PAGO_TV, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPagoTipoVal ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByCondPago(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPagoTipoVal ");
    textSQL.append(" WHERE oid_cond_pago = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    CondicionPago condicionPago = (CondicionPago) aCondiciones;
    querySelect.setInt(1, condicionPago.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cond_pago_tv oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veCondPagoTipoVal");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getTipoValCondPago(CondicionPago condPago,
                                        ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CondPagoTipoValor.NICKNAME,
                                          DBCondPagoTipoValor.SELECT_BY_COND_PAGO,
                                          condPago,
                                          new ListObserver(),
                                          aSesion);
  }


}
