package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.pagos.bm.TipoValorFormaPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBTipoValorFormaPago extends DBObjetoPersistente {

  public static final String OID_FORMA_PAGO_TV = "oid_forma_pago_tv";
  public static final String OID_FORMA_PAGO = "oid_forma_pago";
  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_FORMA_PAGO = 100;

  public DBTipoValorFormaPago() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_FORMA_PAGO_TV = 1;
    final int OID_FORMA_PAGO = 2;
    final int OID_TIPO_VALOR = 3;
    final int ACTIVO = 4;

    TipoValorFormaPago pers = (TipoValorFormaPago) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpFormaPagoTV "+
                     " ( "+
                      "OID_FORMA_PAGO_TV,"+
                      "OID_FORMA_PAGO,"+
                      "OID_TIPO_VALOR,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_FORMA_PAGO_TV,pers.getOID());
    qInsert.setInt(OID_FORMA_PAGO,pers.getFormapago().getOID());
    qInsert.setInt(OID_TIPO_VALOR,pers.getTipovalor().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_FORMA_PAGO = 1;
    final int OID_TIPO_VALOR = 2;
    final int ACTIVO = 3;
    final int OID_FORMA_PAGO_TV = 4;

    TipoValorFormaPago pers = (TipoValorFormaPago) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpFormaPagoTV set "+
              "oid_forma_pago=?"+
              ",oid_tipo_valor=?"+
              ",activo=?"+
                 " where " +
                 " oid_forma_pago_tv=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_FORMA_PAGO_TV,pers.getOID());
    qUpdate.setInt(OID_FORMA_PAGO,pers.getFormapago().getOID());
    qUpdate.setInt(OID_TIPO_VALOR,pers.getTipovalor().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_FORMA_PAGO_TV = 1;
    TipoValorFormaPago pers = (TipoValorFormaPago) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from cpFormaPagoTV "+
                     " where " +
                     " oid_forma_pago_tv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_FORMA_PAGO_TV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_FORMA_PAGO_TV = 1;
    TipoValorFormaPago pers = (TipoValorFormaPago) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpFormaPagoTV "+
                     " set activo=1 " +
                     " where " +
                     " oid_forma_pago_tv=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_FORMA_PAGO_TV, pers.getOID());
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
      case SELECT_BY_FORMA_PAGO: {
        ps = this.selectByFormaPago(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_FORMA_PAGO_TV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpFormaPagoTV ");
    textSQL.append(" WHERE oid_forma_pago_tv = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_FORMA_PAGO_TV, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpFormaPagoTV ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_forma_pago_tv oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpFormaPagoTV");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByFormaPago(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    FormaPago formaPago = (FormaPago) aCondiciones;
    textSQL.append("SELECT * FROM  cpFormaPagoTV ");
    textSQL.append(" WHERE oid_forma_pago = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,formaPago.getOID());
    return querySelect;
  }

  public static List getTipoValorFormaPago(FormaPago formaPago,ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(TipoValorFormaPago.NICKNAME,
                                          SELECT_BY_FORMA_PAGO,
                                          formaPago,
                                          new ListObserver(),
                                          aSesion);
  }




}
